package com.tencent.ditto.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoLog {
    public static final String defaultTag = "DITTO_UI";
    private static Log sLog;

    public static void d(String str) {
        d(defaultTag, str);
    }

    public static void e(String str) {
        e(defaultTag, str);
    }

    public static Log getLog() {
        return sLog;
    }

    public static String getTraceString(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void i(String str) {
        i(defaultTag, str);
    }

    public static boolean isColoredLevel() {
        Log log = sLog;
        if (log != null && log.isColoredLevel()) {
            return true;
        }
        return false;
    }

    public static void setLog(Log log) {
        sLog = log;
    }

    public static void v(String str) {
        v(defaultTag, str);
    }

    public static void w(String str) {
        w(defaultTag, str);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.d(str, str2, th5);
        } else {
            android.util.Log.d(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.e(str, str2, th5);
        } else {
            android.util.Log.e(str, str2, th5);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.i(str, str2, th5);
        } else {
            android.util.Log.i(str, str2, th5);
        }
    }

    public static void v(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.v(str, str2, th5);
        } else {
            android.util.Log.v(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.w(str, str2, th5);
        } else {
            android.util.Log.w(str, str2, th5);
        }
    }
}
