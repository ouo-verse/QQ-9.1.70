package com.tencent.qimei.t;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ab.f;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f343376a;

    public b(c cVar, Runnable runnable) {
        this.f343376a = runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) runnable);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            this.f343376a.run();
        } catch (Throwable th5) {
            f.a(th5.getMessage());
            com.tencent.qimei.ad.c.a(th5);
        }
    }
}
