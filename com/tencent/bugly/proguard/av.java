package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class av {

    /* renamed from: a, reason: collision with root package name */
    public static String f98115a = "CrashReportInfo";

    /* renamed from: b, reason: collision with root package name */
    public static String f98116b = "CrashReport";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f98117c = false;

    private static boolean a(int i3, String str, Object... objArr) {
        if (!f98117c) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i3 == 0) {
            Log.i(f98116b, str);
            return true;
        }
        if (i3 == 1) {
            Log.d(f98116b, str);
            return true;
        }
        if (i3 == 2) {
            Log.w(f98116b, str);
            return true;
        }
        if (i3 == 3) {
            Log.e(f98116b, str);
            return true;
        }
        if (i3 != 5) {
            return false;
        }
        Log.i(f98115a, str);
        return true;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th5) {
        return a(3, th5);
    }

    private static boolean a(int i3, Throwable th5) {
        if (f98117c) {
            return a(i3, ba.a(th5), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th5) {
        return a(2, th5);
    }
}
