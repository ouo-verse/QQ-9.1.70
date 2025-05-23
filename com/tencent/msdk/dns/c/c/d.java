package com.tencent.msdk.dns.c.c;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f336229a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Context context) {
        if (context == null) {
            com.tencent.msdk.dns.base.log.c.i("Install network change manager failed: context can not be null", new Object[0]);
            return;
        }
        synchronized (d.class) {
            if (f336229a == null) {
                f336229a = new e().a(context);
            }
        }
    }

    public static void b(c cVar) {
        synchronized (d.class) {
            b bVar = f336229a;
            if (bVar != null) {
                bVar.a(cVar);
            }
        }
    }
}
