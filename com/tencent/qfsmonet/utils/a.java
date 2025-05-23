package com.tencent.qfsmonet.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.IMonetLogListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f342624a;

    /* renamed from: b, reason: collision with root package name */
    private static IMonetLogListener f342625b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26431);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342624a = true;
            f342625b = null;
        }
    }

    public static void a(String str, String str2) {
        e(3, str, str2);
    }

    public static void b(String str, String str2) {
        e(6, str, str2);
    }

    public static void c(String str, String str2) {
        e(4, str, str2);
    }

    private static void d(int i3, String str, String str2) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            f342625b.e(str, str2);
                            return;
                        }
                        return;
                    }
                    f342625b.w(str, str2);
                    return;
                }
                f342625b.i(str, str2);
                return;
            }
            f342625b.d(str, str2);
            return;
        }
        f342625b.v(str, str2);
    }

    public static void e(int i3, String str, String str2) {
        if ((i3 == 2 || i3 == 3) && !f342624a) {
            return;
        }
        if (i3 == 5) {
            i3 = 6;
        }
        try {
            if (f342625b != null) {
                d(i3, str, str2);
            } else {
                Log.println(i3, str, str2);
            }
        } catch (Throwable th5) {
            Log.println(6, str, th5.toString());
        }
    }

    public static void f(boolean z16) {
        f342624a = z16;
    }

    public static void g(IMonetLogListener iMonetLogListener) {
        f342625b = iMonetLogListener;
    }

    public static void h(String str, String str2) {
        e(5, str, str2);
    }
}
