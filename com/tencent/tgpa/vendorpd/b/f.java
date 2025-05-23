package com.tencent.tgpa.vendorpd.b;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f376027a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f376027a = false;
        }
    }

    public static void a(String str) {
        Log.v("TGPA", str);
    }

    public static void b(String str) {
        if (f376027a) {
            Log.d("TGPA", str);
        }
    }

    public static void c(String str) {
        Log.w("TGPA", str);
    }

    public static void d(String str) {
        Log.e("TGPA", str);
    }

    public static void a(String str, Object... objArr) {
        if (f376027a) {
            Log.d("TGPA", String.format(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        d(String.format(str, objArr));
    }

    public static void a(boolean z16) {
        f376027a = z16;
    }
}
