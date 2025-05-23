package com.tencent.rfix.loader.log;

import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixLog {
    private static final String LOG_INLINE_FENCE_NAME = "com.tencent.rfix.loader.log.RFixLogInlineFence";
    private static final String TAG = "RFix.RFixLog";
    private static final IRFixLog sDefaultLogImpl = null;
    private static IRFixLog sLogImpl;
    private static final Object sLogImplLock;
    private static Handler sLogInlineFence;

    static {
        Object obj = new Object();
        sLogImplLock = obj;
        synchronized (obj) {
            try {
                int i3 = RFixLogInlineFence.MSG_PRINT_PENDING_LOGS;
                Constructor declaredConstructor = RFixLogInlineFence.class.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                sLogInlineFence = (Handler) declaredConstructor.newInstance(new Object[0]);
            } finally {
            }
        }
    }

    public static void d(String str, String str2) {
        printLog(3, str, str2, null);
    }

    public static void e(String str, String str2) {
        printLog(6, str, str2, null);
    }

    public static IRFixLog getLogImpl() {
        IRFixLog iRFixLog;
        synchronized (sLogImplLock) {
            iRFixLog = sLogImpl;
        }
        return iRFixLog;
    }

    public static void i(String str, String str2) {
        printLog(4, str, str2, null);
    }

    public static boolean isDefaultLogImpl() {
        boolean z16;
        synchronized (sLogImplLock) {
            if (sLogImpl == sDefaultLogImpl) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private static void printLog(int i3, String str, String str2, Throwable th5) {
        Object[] objArr = {Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()), str, str2, th5};
        Handler handler = sLogInlineFence;
        if (handler != null) {
            Message obtain = Message.obtain(handler, i3, objArr);
            sLogInlineFence.handleMessage(obtain);
            obtain.recycle();
        }
    }

    private static void printPendingLogs() {
        Handler handler = sLogInlineFence;
        if (handler != null) {
            Message obtain = Message.obtain(handler, 240);
            sLogInlineFence.handleMessage(obtain);
            obtain.recycle();
        }
    }

    public static void setLogImpl(IRFixLog iRFixLog) {
        synchronized (sLogImplLock) {
            sLogImpl = iRFixLog;
            if (iRFixLog != sDefaultLogImpl) {
                printPendingLogs();
            }
        }
    }

    public static void v(String str, String str2) {
        printLog(2, str, str2, null);
    }

    public static void w(String str, String str2) {
        printLog(5, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        printLog(3, str, str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        printLog(6, str, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        printLog(5, str, str2, th5);
    }

    public static void v(String str, String str2, Throwable th5) {
        printLog(2, str, str2, th5);
    }

    public static void w(String str, String str2, Throwable th5) {
        printLog(5, str, str2, th5);
    }
}
