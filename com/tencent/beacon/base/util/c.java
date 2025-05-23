package com.tencent.beacon.base.util;

import android.util.Log;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f77787a = true;

    /* renamed from: b, reason: collision with root package name */
    private static BeaconLogger f77788b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f77789c = false;

    c() {
    }

    public static BeaconLogger a() {
        return f77788b;
    }

    public static synchronized void b(boolean z16) {
        synchronized (c.class) {
            f77787a = z16;
        }
    }

    public static synchronized boolean c() {
        boolean z16;
        synchronized (c.class) {
            z16 = f77787a;
        }
        return z16;
    }

    private static boolean d() {
        return b();
    }

    public static void e(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = f77788b;
            if (beaconLogger == null) {
                Log.w("beacon", c(str, objArr));
            } else {
                beaconLogger.w("beacon", c(str, objArr));
            }
        }
    }

    private static String f() {
        StackTraceElement e16;
        String str = "";
        if (!c() || (e16 = e()) == null) {
            return "";
        }
        String fileName = e16.getFileName();
        if (fileName != null) {
            str = fileName;
        }
        String methodName = e16.getMethodName();
        if (methodName.contains("$")) {
            methodName = methodName.substring(methodName.indexOf("$") + 1, methodName.lastIndexOf("$") - 2);
        }
        return "(" + str + ":" + e16.getLineNumber() + ")" + methodName + " ";
    }

    public static void a(BeaconLogger beaconLogger) {
        f77788b = beaconLogger;
    }

    public static synchronized boolean b() {
        boolean z16;
        synchronized (c.class) {
            z16 = f77789c;
        }
        return z16;
    }

    public static String c(String str, Object... objArr) {
        String f16 = f();
        if (str == null) {
            return f16 + "msg is null";
        }
        if (objArr != null && objArr.length != 0) {
            return f16 + String.format(Locale.US, str, objArr);
        }
        return f16 + str;
    }

    public static void d(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = f77788b;
            if (beaconLogger == null) {
                Log.i("beacon", c(str, objArr));
            } else {
                beaconLogger.i("beacon", c(str, objArr));
            }
        }
    }

    public static synchronized void a(boolean z16) {
        synchronized (c.class) {
            Log.i("beacon", "beacon logAble: " + z16);
            f77789c = z16;
        }
    }

    public static void b(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = f77788b;
            if (beaconLogger == null) {
                Log.e("beacon", c(str, objArr));
            } else {
                beaconLogger.e("beacon", c(str, objArr));
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = f77788b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str, objArr));
            } else {
                beaconLogger.d("beacon", c(str, objArr));
            }
        }
    }

    private static StackTraceElement e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int a16 = a(stackTrace, c.class);
        if (a16 == -1 && (a16 = a(stackTrace, Log.class)) == -1) {
            return null;
        }
        return stackTrace[a16];
    }

    public static void a(String str, String str2, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = f77788b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str + " " + str2, objArr));
                return;
            }
            beaconLogger.d("beacon", c(str + " " + str2, objArr));
        }
    }

    public static void a(String str, int i3, String str2, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = f77788b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str + " step: " + i3 + ". " + str2, objArr));
                return;
            }
            beaconLogger.d("beacon", c(str + " step: " + i3 + ". " + str2, objArr));
        }
    }

    public static void a(Throwable th5) {
        if (th5 == null || !d()) {
            return;
        }
        BeaconLogger beaconLogger = f77788b;
        if (beaconLogger == null) {
            th5.printStackTrace();
        } else {
            beaconLogger.printStackTrace(th5);
        }
    }

    private static int a(StackTraceElement[] stackTraceElementArr, Class cls) {
        for (int i3 = 5; i3 < stackTraceElementArr.length; i3++) {
            String className = stackTraceElementArr[i3].getClassName();
            if (!(cls.equals(Log.class) && i3 < stackTraceElementArr.length - 1 && stackTraceElementArr[i3 + 1].getClassName().equals(Log.class.getName())) && className.equals(cls.getName())) {
                return i3 + 1;
            }
        }
        return -1;
    }
}
