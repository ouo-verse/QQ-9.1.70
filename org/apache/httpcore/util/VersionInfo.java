package org.apache.httpcore.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String str, String str2, String str3, String str4, String str5) {
        Args.notNull(str, "Package identifier");
        this.infoPackage = str;
        this.infoModule = str2 == null ? "UNAVAILABLE" : str2;
        this.infoRelease = str3 == null ? "UNAVAILABLE" : str3;
        this.infoTimestamp = str4 == null ? "UNAVAILABLE" : str4;
        this.infoClassloader = str5 == null ? "UNAVAILABLE" : str5;
    }

    protected static VersionInfo fromMap(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        Args.notNull(str, "Package identifier");
        String str5 = null;
        if (map != null) {
            String str6 = (String) map.get("info.module");
            if (str6 != null && str6.length() < 1) {
                str6 = null;
            }
            String str7 = (String) map.get("info.release");
            if (str7 != null && (str7.length() < 1 || str7.equals("${pom.version}"))) {
                str7 = null;
            }
            String str8 = (String) map.get("info.timestamp");
            if (str8 != null && (str8.length() < 1 || str8.equals("${mvn.timestamp}"))) {
                str4 = null;
            } else {
                str4 = str8;
            }
            str2 = str6;
            str3 = str7;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if (classLoader != null) {
            str5 = classLoader.toString();
        }
        return new VersionInfo(str, str2, str3, str4, str5);
    }

    public static String getUserAgent(String str, String str2, Class<?> cls) {
        String str3;
        VersionInfo loadVersionInfo = loadVersionInfo(str2, cls.getClassLoader());
        if (loadVersionInfo != null) {
            str3 = loadVersionInfo.getRelease();
        } else {
            str3 = "UNAVAILABLE";
        }
        return String.format("%s/%s (Java/%s)", str, str3, System.getProperty("java.version"));
    }

    public static VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        Args.notNull(strArr, "Package identifier array");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            VersionInfo loadVersionInfo = loadVersionInfo(str, classLoader);
            if (loadVersionInfo != null) {
                arrayList.add(loadVersionInfo);
            }
        }
        return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
        sb5.append("VersionInfo(");
        sb5.append(this.infoPackage);
        sb5.append(':');
        sb5.append(this.infoModule);
        if (!"UNAVAILABLE".equals(this.infoRelease)) {
            sb5.append(':');
            sb5.append(this.infoRelease);
        }
        if (!"UNAVAILABLE".equals(this.infoTimestamp)) {
            sb5.append(':');
            sb5.append(this.infoTimestamp);
        }
        sb5.append(')');
        if (!"UNAVAILABLE".equals(this.infoClassloader)) {
            sb5.append('@');
            sb5.append(this.infoClassloader);
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VersionInfo loadVersionInfo(String str, ClassLoader classLoader) {
        Properties properties;
        InputStream resourceAsStream;
        Args.notNull(str, "Package identifier");
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            resourceAsStream = classLoader.getResourceAsStream(str.replace('.', '/') + "/version.properties");
        } catch (IOException unused) {
        }
        if (resourceAsStream != null) {
            try {
                properties = new Properties();
                properties.load(resourceAsStream);
                if (properties == null) {
                    return fromMap(str, properties, classLoader);
                }
                return null;
            } finally {
                resourceAsStream.close();
            }
        }
        properties = null;
        if (properties == null) {
        }
    }
}
