package com.tencent.tmsqmsp.oaid2;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class t0 {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f380887a = "oaid_tag";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f380888b = false;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static void a(String str) {
        if (f380888b) {
            Log.e(f380887a, String.format(str, new Object[0]));
        }
    }

    public static void b(String str) {
        if (f380888b) {
            Log.i(f380887a, String.format(str, new Object[0]));
        }
    }

    public static void c(String str) {
        if (f380888b) {
            Log.d(f380887a, String.format(str, new Object[0]));
        }
    }
}
