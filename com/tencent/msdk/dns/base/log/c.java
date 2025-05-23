package com.tencent.msdk.dns.base.log;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f336214a;

    static {
        int i3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18871);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int i16 = 7;
        int i17 = 6;
        while (true) {
            int i18 = i17;
            i3 = i16;
            i16 = i18;
            if (i16 < 2 || !Log.isLoggable("HTTPDNS", i16)) {
                break;
            } else {
                i17 = i16 - 1;
            }
        }
        f336214a = i3;
    }

    private static void a(int i3, Throwable th5, String str, Object... objArr) {
        try {
            if (i3 >= f336214a) {
                d.a(i3, "HTTPDNS", String.format(Locale.US, str, objArr), th5);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void b(a aVar) {
        d.b(aVar);
    }

    public static void c(String str, Object... objArr) {
        d(null, str, objArr);
    }

    public static void d(Throwable th5, String str, Object... objArr) {
        a(3, th5, str, objArr);
    }

    public static boolean e(int i3) {
        if (i3 >= f336214a) {
            return true;
        }
        return false;
    }

    public static void f(int i3) {
        f336214a = Math.min(i3, f336214a);
    }

    public static void g(String str, Object... objArr) {
        h(null, str, objArr);
    }

    public static void h(Throwable th5, String str, Object... objArr) {
        a(2, th5, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        j(null, str, objArr);
    }

    public static void j(Throwable th5, String str, Object... objArr) {
        a(5, th5, str, objArr);
    }
}
