package com.tencent.component.network.module.base;

import com.tencent.component.network.module.base.inter.Log;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QDLog {
    public static final String TAG_DOWNLOAD = "downloader";
    public static final String TAG_DOWNLOAD_OKHTTP = "downloader_OKHTTP";
    public static final String TAG_DOWNLOAD_RANGE = "downloader_RANGE";
    public static final String TAG_DOWNLOAD_RESULT = "downloader_result";
    private static Log sLog;

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static Log getLog() {
        return sLog;
    }

    private static int getLogLevel() {
        Log log = sLog;
        if (log != null) {
            return log.getLogLevel();
        }
        return 1;
    }

    public static void i(String str, String str2) {
        Log log = sLog;
        if (log != null) {
            log.i(str, str2);
        } else {
            android.util.Log.i(str, str2);
        }
    }

    public static boolean isDebugEnable() {
        if (2 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isErrorEnable() {
        if (5 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isInfoEnable() {
        if (3 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isWarningEnable() {
        if (4 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static void setLog(Log log) {
        sLog = log;
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

    public static void w(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.w(str, str2, th5);
        } else {
            android.util.Log.w(str, str2, th5);
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
}
