package com.tencent.component.utils;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LogUtil {
    public static final LogProxy DEFAULT_PROXY;
    private static volatile LogProxy sProxy;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface LogProxy {
        void d(String str, String str2);

        void e(String str, String str2);

        void flush();

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    static {
        LogProxy logProxy = new LogProxy() { // from class: com.tencent.component.utils.LogUtil.1
            @Override // com.tencent.component.utils.LogUtil.LogProxy
            public void d(String str, String str2) {
                Log.d(str, str2);
            }

            @Override // com.tencent.component.utils.LogUtil.LogProxy
            public void e(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // com.tencent.component.utils.LogUtil.LogProxy
            public void i(String str, String str2) {
                Log.i(str, str2);
            }

            @Override // com.tencent.component.utils.LogUtil.LogProxy
            public void v(String str, String str2) {
                Log.v(str, str2);
            }

            @Override // com.tencent.component.utils.LogUtil.LogProxy
            public void w(String str, String str2) {
                Log.w(str, str2);
            }

            @Override // com.tencent.component.utils.LogUtil.LogProxy
            public void flush() {
            }
        };
        DEFAULT_PROXY = logProxy;
        sProxy = logProxy;
    }

    public static void d(String str, String str2) {
        getProxy().d(str, str2);
    }

    public static void e(String str, String str2) {
        getProxy().e(str, str2);
    }

    public static void flush() {
        getProxy().flush();
    }

    public static LogProxy getProxy() {
        LogProxy logProxy = sProxy;
        if (logProxy == null) {
            return DEFAULT_PROXY;
        }
        return logProxy;
    }

    private static String getStackTraceString(Throwable th5) {
        return Log.getStackTraceString(th5);
    }

    public static void i(String str, String str2) {
        getProxy().i(str, str2);
    }

    public static void setProxy(LogProxy logProxy) {
        synchronized (LogUtil.class) {
            sProxy = logProxy;
        }
    }

    public static void v(String str, String str2) {
        getProxy().v(str, str2);
    }

    public static void w(String str, String str2) {
        getProxy().w(str, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        getProxy().d(str, str2 + '\n' + getStackTraceString(th5));
    }

    public static void e(String str, String str2, Throwable th5) {
        getProxy().e(str, str2 + '\n' + getStackTraceString(th5));
    }

    public static void i(String str, String str2, Throwable th5) {
        getProxy().i(str, str2 + '\n' + getStackTraceString(th5));
    }

    public static void v(String str, String str2, Throwable th5) {
        getProxy().v(str, str2 + '\n' + getStackTraceString(th5));
    }

    public static void w(String str, String str2, Throwable th5) {
        getProxy().w(str, str2 + '\n' + getStackTraceString(th5));
    }

    public static void w(String str, Throwable th5) {
        getProxy().w(str, getStackTraceString(th5));
    }
}
