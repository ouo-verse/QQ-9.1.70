package com.qq.jce.wup;

import java.io.InputStream;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WupInfo {
    private static String clientBuilt;
    private static String clientInfo;
    private static String clientNumber;

    static {
        try {
            InputStream resourceAsStream = WupInfo.class.getResourceAsStream("/com/qq/jce/wup/wup.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            resourceAsStream.close();
            clientInfo = properties.getProperty("client.info");
            clientBuilt = properties.getProperty("client.built");
            clientNumber = properties.getProperty("client.number");
        } catch (Throwable unused) {
        }
        if (clientInfo == null) {
            clientInfo = "Tencent Taf";
        }
        if (clientBuilt == null) {
            clientBuilt = "unknown";
        }
        if (clientNumber == null) {
            clientNumber = "unknown";
        }
    }

    public static String getClientBuilt() {
        return clientBuilt;
    }

    public static String getClientInfo() {
        return clientInfo;
    }

    public static String getClientNumber() {
        return clientNumber;
    }

    public static void main(String[] strArr) {
        System.out.println(showString());
        System.out.println("Client version: " + getClientInfo());
        System.out.println("Client built:   " + getClientBuilt());
        System.out.println("Client number:  " + getClientNumber());
        System.out.println("OS Name:        " + System.getProperty("os.name"));
        System.out.println("OS Version:     " + System.getProperty("os.version"));
        System.out.println("Architecture:   " + System.getProperty("os.arch"));
        System.out.println("JVM Version:    " + System.getProperty("java.runtime.version"));
        System.out.println("JVM Vendor:     " + System.getProperty("java.vm.vendor"));
    }

    public static String showString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Client version: " + getClientInfo() + "\n");
        stringBuffer.append("Client built:   " + getClientBuilt() + "\n");
        stringBuffer.append("Client number:  " + getClientNumber() + "\n");
        stringBuffer.append("OS Name:        " + System.getProperty("os.name") + "\n");
        stringBuffer.append("OS Version:     " + System.getProperty("os.version") + "\n");
        stringBuffer.append("Architecture:   " + System.getProperty("os.arch") + "\n");
        stringBuffer.append("JVM Version:    " + System.getProperty("java.runtime.version") + "\n");
        stringBuffer.append("JVM Vendor:     " + System.getProperty("java.vm.vendor") + "\n");
        return stringBuffer.toString();
    }
}
