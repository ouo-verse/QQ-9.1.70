package com.tencent.upgrade.util;

import android.util.Log;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static pw4.c f383916a;

    public static void a(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th5) {
        String f16 = f(str);
        String e16 = e(str, str2);
        pw4.c cVar = f383916a;
        if (cVar != null) {
            cVar.d(f16, e16, th5);
        } else {
            Log.d(f16, e16, th5);
        }
    }

    public static void c(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        String f16 = f(str);
        String e16 = e(str, str2);
        pw4.c cVar = f383916a;
        if (cVar != null) {
            cVar.e(f16, e16, th5);
        } else {
            Log.e(f16, e16, th5);
        }
    }

    private static String e(String str, String str2) {
        return str + ProgressTracer.SEPARATOR + str2;
    }

    private static String f(String str) {
        return "UpgradeCommonTag";
    }

    public static void g(String str, String str2) {
        h(str, str2, null);
    }

    public static void h(String str, String str2, Throwable th5) {
        String f16 = f(str);
        String e16 = e(str, str2);
        pw4.c cVar = f383916a;
        if (cVar != null) {
            cVar.i(f16, e16, th5);
        } else {
            Log.i(f16, e16, th5);
        }
    }

    public static void i(pw4.c cVar) {
        f383916a = cVar;
    }

    public static void j(String str, String str2) {
        k(str, str2, null);
    }

    public static void k(String str, String str2, Throwable th5) {
        String f16 = f(str);
        String e16 = e(str, str2);
        pw4.c cVar = f383916a;
        if (cVar != null) {
            cVar.v(f16, e16, th5);
        } else {
            Log.v(f16, e16, th5);
        }
    }

    public static void l(String str, String str2) {
        m(str, str2, null);
    }

    public static void m(String str, String str2, Throwable th5) {
        String f16 = f(str);
        String e16 = e(str, str2);
        pw4.c cVar = f383916a;
        if (cVar != null) {
            cVar.w(f16, e16, th5);
        } else {
            Log.w(f16, e16, th5);
        }
    }
}
