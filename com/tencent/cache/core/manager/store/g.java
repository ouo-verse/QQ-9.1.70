package com.tencent.cache.core.manager.store;

import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class g implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final g f98783d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98783d = new g();
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.cache.core.util.b.f98833f.j("GlobalImageCache", 1, "evictAll");
        com.tencent.cache.core.manager.report.c cVar = new com.tencent.cache.core.manager.report.c(ClearMode.UserEvictAction);
        i.f98786c.a();
        i.f98785b.f();
        cVar.c("evict_all", null);
    }
}
