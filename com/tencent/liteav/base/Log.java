package com.tencent.liteav.base;

import java.util.Locale;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";
    private static final boolean useChromiumLog = true;

    Log() {
    }

    public static void d(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(3, str, formatLogWithStack(str2, getThrowableToLog(objArr), objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(6, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    private static String formatLog(String str, Throwable th5, Object... objArr) {
        if (objArr != null) {
            if ((th5 == null && objArr.length > 0) || objArr.length > 1) {
                return String.format(Locale.US, str, objArr);
            }
            return str;
        }
        return str;
    }

    private static String formatLogWithStack(String str, Throwable th5, Object... objArr) {
        return "[" + getCallOrigin() + "] " + formatLog(str, th5, objArr);
    }

    private static String getCallOrigin() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i3 = 0;
        while (true) {
            if (i3 >= stackTrace.length) {
                break;
            }
            if (stackTrace[i3].getClassName().equals(name)) {
                i3 += 3;
                break;
            }
            i3++;
        }
        return stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber();
    }

    public static String getStackTraceString(Throwable th5) {
        return android.util.Log.getStackTraceString(th5);
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    public static void i(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(4, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    private static boolean isDebug() {
        return true;
    }

    public static boolean isLoggable(String str, int i3) {
        if (!isDebug() && i3 <= 4) {
            return false;
        }
        return android.util.Log.isLoggable(str, i3);
    }

    private static native void nativeWriteLogToNative(int i3, String str, String str2);

    public static String normalizeTag(String str) {
        int i3;
        if (str.startsWith(sTagPrefix)) {
            return str;
        }
        if (str.startsWith(sDeprecatedTagPrefix)) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        return sTagPrefix + str.substring(i3, str.length());
    }

    public static void v(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(2, str, formatLogWithStack(str2, getThrowableToLog(objArr), objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(5, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }

    public static void wtf(String str, String str2, Object... objArr) {
        nativeWriteLogToNative(7, str, formatLog(str2, getThrowableToLog(objArr), objArr));
    }
}
