package com.tencent.biz.richframework.delegate.impl;

import android.util.Log;
import com.tencent.biz.richframework.delegate.ILogDelegate;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWLog {
    private static final String TAG = "RFWLog";
    private static volatile ILogDelegate sLogImpl;
    private static final AtomicBoolean sOpenCLR = new AtomicBoolean(false);
    public static int DEV = 4;
    public static int CLR = 2;
    public static int USR = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class StringBuilderHolder {
        private static final ThreadLocal<StringBuilder> sBuilder = new ThreadLocal<>();

        StringBuilderHolder() {
        }

        public static String getString(Object... objArr) {
            StringBuilder obtain = obtain();
            for (Object obj : objArr) {
                obtain.append(obj);
            }
            return obtain.toString();
        }

        public static StringBuilder obtain() {
            ThreadLocal<StringBuilder> threadLocal = sBuilder;
            StringBuilder sb5 = threadLocal.get();
            if (sb5 == null) {
                StringBuilder sb6 = new StringBuilder();
                threadLocal.set(sb6);
                return sb6;
            }
            sb5.setLength(0);
            return sb5;
        }
    }

    public static void d(String str, int i3, Object... objArr) {
        ILogDelegate logDelegate = getLogDelegate();
        if (logDelegate != null) {
            logDelegate.d(str, redirectLevel(i3), objArr);
        } else {
            Log.d(str, StringBuilderHolder.getString(objArr));
        }
    }

    public static void e(String str, int i3, Object... objArr) {
        ILogDelegate logDelegate = getLogDelegate();
        if (logDelegate != null) {
            logDelegate.e(str, redirectLevel(i3), objArr);
        } else {
            Log.e(str, StringBuilderHolder.getString(objArr));
        }
    }

    public static void enableCLR(boolean z16) {
        sOpenCLR.set(z16);
    }

    public static void fatal(String str, int i3, Throwable th5) {
        fatal(str, i3, th5.getMessage(), th5);
    }

    private static ILogDelegate getLogDelegate() {
        if (sLogImpl == null) {
            synchronized (RFWLog.class) {
                if (sLogImpl == null) {
                    sLogImpl = (ILogDelegate) RFWDelegate.getDelegate(ILogDelegate.class);
                }
            }
        }
        return sLogImpl;
    }

    public static void i(String str, int i3, String str2) {
        ILogDelegate logDelegate = getLogDelegate();
        if (logDelegate != null) {
            logDelegate.i(str, redirectLevel(i3), str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static boolean isColorLevel() {
        ILogDelegate logDelegate = getLogDelegate();
        if (logDelegate != null) {
            return logDelegate.isColorLevel();
        }
        Log.e(TAG, "isColorLevel() get delegate is null!");
        return true;
    }

    public static boolean isDevelopLevel() {
        ILogDelegate logDelegate = getLogDelegate();
        if (logDelegate != null) {
            return logDelegate.isDevelopLevel();
        }
        Log.e(TAG, "isDevelopLevel() get delegate is null!");
        return true;
    }

    private static int redirectLevel(int i3) {
        if (i3 == CLR && sOpenCLR.get()) {
            return USR;
        }
        return i3;
    }

    public static void setILogDelegate(ILogDelegate iLogDelegate) {
        sLogImpl = iLogDelegate;
    }

    public static void w(String str, int i3, String str2) {
        ILogDelegate logDelegate = getLogDelegate();
        if (logDelegate != null) {
            logDelegate.w(str, redirectLevel(i3), str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void fatal(String str, int i3, String str2, Throwable th5) {
        if (!RFWApplication.isDebug()) {
            e(str, i3, str2, th5);
            return;
        }
        throw new RuntimeException(str2, th5);
    }
}
