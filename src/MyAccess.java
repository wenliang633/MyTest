import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyAccess {

	public static void main(String args[]){
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		System.out.println( System.getProperty("java.class.path"));
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/new_schema","root", "root123");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		Statement statement = null;
 
		String selectTableSQL = "SELECT * FROM mytable";
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			
			while (rs.next()) {
				 
				int userid = rs.getInt("id");
				String username = rs.getString("USERNAME");
				
				System.out.println("userID : " + userid);
				System.out.println("userName : " + username);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
