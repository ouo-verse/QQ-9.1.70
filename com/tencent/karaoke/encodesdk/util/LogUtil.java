package com.tencent.karaoke.encodesdk.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LogUtil {
    private static final b DEFAULT_PROXY;
    private static volatile b sProxy;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void d(String str, String str2);

        void e(String str, String str2);

        void flush();

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    static {
        a aVar = new a();
        DEFAULT_PROXY = aVar;
        sProxy = aVar;
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

    private static b getProxy() {
        b bVar = sProxy;
        if (bVar == null) {
            return DEFAULT_PROXY;
        }
        return bVar;
    }

    private static String getStackTraceString(Throwable th5) {
        return Log.getStackTraceString(th5);
    }

    public static void i(String str, String str2) {
        getProxy().i(str, str2);
    }

    public static void setProxy(b bVar) {
        synchronized (LogUtil.class) {
            sProxy = bVar;
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

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class a implements b {
        a() {
        }

        @Override // com.tencent.karaoke.encodesdk.util.LogUtil.b
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.karaoke.encodesdk.util.LogUtil.b
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.tencent.karaoke.encodesdk.util.LogUtil.b
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.karaoke.encodesdk.util.LogUtil.b
        public void v(String str, String str2) {
            Log.v(str, str2);
        }

        @Override // com.tencent.karaoke.encodesdk.util.LogUtil.b
        public void w(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.tencent.karaoke.encodesdk.util.LogUtil.b
        public void flush() {
        }
    }
}
