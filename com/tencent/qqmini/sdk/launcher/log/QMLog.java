package com.tencent.qqmini.sdk.launcher.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.utils.ProcessUtil;
import java.io.File;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class QMLog {
    private static int debugMode;
    private static String process;
    private static Log sLog;

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static int getDebug() {
        int i3;
        if (debugMode == 0) {
            if (new File("/sdcard/debug").exists()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            debugMode = i3;
        }
        return debugMode;
    }

    public static Log getLog() {
        return sLog;
    }

    public static int getLogLevel() {
        Log log = sLog;
        if (log != null) {
            return log.getLogLevel();
        }
        return 3;
    }

    private static String getLogTag(String str) {
        if (getDebug() == 1) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > 5) {
                StackTraceElement stackTraceElement = stackTrace[5];
                return String.format("[MiniSDK]|%s{%d}|%s[%s]%s", getProcessName(), Long.valueOf(Thread.currentThread().getId()), String.format("(%s:%s)", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())), stackTraceElement.getMethodName(), str);
            }
        }
        return "[MiniSDK]" + str;
    }

    private static String getProcessName() {
        if (process == null) {
            process = ProcessUtil.getSimpleProcessName();
        }
        return process;
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static boolean isColorLevel() {
        Log log = sLog;
        if (log != null && !log.isColorLevel()) {
            return false;
        }
        return true;
    }

    public static boolean isDebugEnabled() {
        if (2 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isErrorEnabled() {
        if (5 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isInfoEnabled() {
        if (3 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isWarningEnabled() {
        if (4 >= getLogLevel()) {
            return true;
        }
        return false;
    }

    public static void setLog(Log log) {
        if (log != null) {
            sLog = log;
        }
    }

    public static void traceInfo(String str) {
        if (getDebug() == 1) {
            new Exception(str).printStackTrace();
        }
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.d(getLogTag(str), str2, th5);
        } else {
            android.util.Log.d(getLogTag(str), str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.e(getLogTag(str), str2, th5);
        } else {
            android.util.Log.e(getLogTag(str), str2, th5);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.i(getLogTag(str), str2, th5);
        } else {
            android.util.Log.i(getLogTag(str), str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        Log log = sLog;
        if (log != null) {
            log.w(getLogTag(str), str2, th5);
        } else {
            android.util.Log.w(getLogTag(str), str2, th5);
        }
    }
}
