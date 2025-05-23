package com.tencent.qmsp.oaid2;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class t0 {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f344295a = "oaid_tag";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f344296b = false;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static void a(String str) {
        if (f344296b) {
            Log.e(f344295a, String.format(str, new Object[0]));
        }
    }

    public static void b(String str) {
        if (f344296b) {
            Log.i(f344295a, String.format(str, new Object[0]));
        }
    }

    public static void c(String str) {
        if (f344296b) {
            Log.d(f344295a, String.format(str, new Object[0]));
        }
    }
}
