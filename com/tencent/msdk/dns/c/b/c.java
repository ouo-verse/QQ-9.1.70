package com.tencent.msdk.dns.c.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes21.dex */
final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Application f336226a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static Application a(Context context) {
        if (f336226a == null) {
            Application b16 = b(context);
            f336226a = b16;
            if (b16 == null) {
                f336226a = b(com.tencent.msdk.dns.c.d.a.b().c());
            }
        }
        return f336226a;
    }

    private static Application b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Application) {
                return (Application) context;
            }
            if (context instanceof Activity) {
                return ((Activity) context).getApplication();
            }
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof Application)) {
                return null;
            }
            return (Application) applicationContext;
        } catch (Exception e16) {
            com.tencent.msdk.dns.base.log.c.d(e16, "Get Application failed", new Object[0]);
            return null;
        }
    }
}
