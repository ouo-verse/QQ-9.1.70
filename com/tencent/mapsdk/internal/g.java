package com.tencent.mapsdk.internal;

import java.io.InputStream;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f148416a;

    /* renamed from: b, reason: collision with root package name */
    private static String f148417b;

    /* renamed from: c, reason: collision with root package name */
    private static String f148418c;

    static {
        try {
            InputStream resourceAsStream = g.class.getResourceAsStream("/com/qq/jce/wup/wup.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            resourceAsStream.close();
            f148416a = properties.getProperty("client.info");
            f148417b = properties.getProperty("client.built");
            f148418c = properties.getProperty("client.number");
        } catch (Throwable unused) {
        }
        if (f148416a == null) {
            f148416a = "Tencent Taf";
        }
        if (f148417b == null) {
            f148417b = "unknown";
        }
        if (f148418c == null) {
            f148418c = "unknown";
        }
    }

    private static String a() {
        return f148416a;
    }

    private static String b() {
        return f148417b;
    }

    private static String c() {
        return f148418c;
    }

    private static String d() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Client version: " + f148416a + "\n");
        sb5.append("Client built:   " + f148417b + "\n");
        sb5.append("Client number:  " + f148418c + "\n");
        sb5.append("OS Name:        " + System.getProperty("os.name") + "\n");
        sb5.append("OS Version:     " + System.getProperty("os.version") + "\n");
        sb5.append("Architecture:   " + System.getProperty("os.arch") + "\n");
        sb5.append("JVM Version:    " + System.getProperty("java.runtime.version") + "\n");
        sb5.append("JVM Vendor:     " + System.getProperty("java.vm.vendor") + "\n");
        return sb5.toString();
    }
}
