package com.tencent.mobileqq.microapp.appbrand.b;

import com.tencent.mobileqq.microapp.appbrand.b.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c.h();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
