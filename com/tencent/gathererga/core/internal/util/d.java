package com.tencent.gathererga.core.internal.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f108259a;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.gathererga.core.d f108260b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f108259a = "Gatherer";
            f108260b = null;
        }
    }

    public static void a(String str) {
        com.tencent.gathererga.core.d dVar = f108260b;
        if (dVar != null) {
            dVar.d(f108259a, str);
        } else {
            Log.d(f108259a, str);
        }
    }

    public static void b(String str) {
        com.tencent.gathererga.core.d dVar = f108260b;
        if (dVar != null) {
            dVar.e(f108259a, str);
        } else {
            Log.e(f108259a, str);
        }
    }

    public static void c(String str, Throwable th5) {
        com.tencent.gathererga.core.d dVar = f108260b;
        if (dVar != null) {
            dVar.e(f108259a, str, th5);
        } else {
            Log.e(f108259a, str, th5);
        }
    }

    public static void d(String str) {
        com.tencent.gathererga.core.d dVar = f108260b;
        if (dVar != null) {
            dVar.i(f108259a, str);
        } else {
            Log.i(f108259a, str);
        }
    }

    public static void e(com.tencent.gathererga.core.d dVar) {
        f108260b = dVar;
    }

    public static void f(String str) {
        com.tencent.gathererga.core.d dVar = f108260b;
        if (dVar != null) {
            dVar.w(f108259a, str);
        } else {
            Log.w(f108259a, str);
        }
    }

    public static void g(String str, Throwable th5) {
        com.tencent.gathererga.core.d dVar = f108260b;
        if (dVar != null) {
            dVar.w(f108259a, str, th5);
        } else {
            Log.w(f108259a, str, th5);
        }
    }

    public static void h(Throwable th5) {
        g("", th5);
    }
}
