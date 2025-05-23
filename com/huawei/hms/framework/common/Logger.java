package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Logger {
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NetworkKit_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean kitPrint = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        /* JADX INFO: Access modifiers changed from: private */
        public void setCause(Throwable th5) {
            this.thisCause = th5;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th5 = this.thisCause;
            if (th5 == this) {
                return null;
            }
            return th5;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th5 = this.ownerThrowable;
            if (th5 == null) {
                return "";
            }
            String name = th5.getClass().getName();
            if (this.message != null) {
                String str = name + MsgSummary.STR_COLON;
                if (this.message.startsWith(str)) {
                    return this.message;
                }
                return str + this.message;
            }
            return name;
        }

        ThrowableWrapper(Throwable th5) {
            this.ownerThrowable = th5;
            StackTraceElement[] stackTrace = th5.getStackTrace();
            int i3 = ((th5 instanceof IOException) || (th5 instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i3) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i3));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th5.getMessage()));
        }
    }

    private static String complexAppTag(String str) {
        return TAG_NETWORK_SDK_PRE + str;
    }

    private static String complexMsg(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i3) + "|" + str;
        }
        return getCallMethodInfo(i3);
    }

    private static String complexTag(String str) {
        return TAG_NETWORKKIT_PRE + str;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    private static void extLogPrintln(int i3, String str, String str2) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            extLogger.e(str, str2);
                            return;
                        }
                        return;
                    }
                    extLogger.w(str, str2);
                    return;
                }
                extLogger.i(str, str2);
                return;
            }
            extLogger.d(str, str2);
            return;
        }
        extLogger.v(str, str2);
    }

    private static String getCallMethodInfo(int i3) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > i3) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
        }
        return "";
    }

    private static Throwable getNewThrowable(Throwable th5) {
        if (isLoggable(3)) {
            return th5;
        }
        if (th5 == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th5);
        Throwable cause = th5.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    private static boolean isAPPLoggable(int i3) {
        if (extLogger != null && i3 >= 3) {
            return true;
        }
        return false;
    }

    private static boolean isKitLoggable(int i3) {
        if (kitPrint && isLoggable(i3)) {
            return true;
        }
        return false;
    }

    public static boolean isLoggable(int i3) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, i3);
    }

    private static int logPrintln(int i3, String str, String str2) {
        if (isAPPLoggable(i3)) {
            extLogPrintln(i3, complexAppTag(str), complexMsg(str2, 7));
        }
        if (isKitLoggable(i3)) {
            return Log.println(i3, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i3, String str, Object obj) {
        if (i3 < 3) {
            return;
        }
        logPrintln(i3, str, obj == null ? "null" : obj.toString());
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z16) {
        extLogger = extLogger2;
        kitPrint = z16;
        i(TAG, "logger = " + extLogger2 + z16);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static void println(int i3, String str, String str2, Object... objArr) {
        if (i3 < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(TAG, "format is null, not log");
            return;
        }
        try {
            logPrintln(i3, str, StringUtils.format(str2, objArr));
        } catch (IllegalFormatException e16) {
            w(TAG, "log format error" + str2, e16);
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }

    public static void e(String str, String str2, Throwable th5) {
        if (isAPPLoggable(6)) {
            extLogger.e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th5));
        }
        if (kitPrint) {
            Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th5));
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (isAPPLoggable(5)) {
            extLogger.w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th5));
        }
        if (kitPrint) {
            Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th5));
        }
    }
}
