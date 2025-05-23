package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
abstract class WrapperRunnable implements Runnable {
    static IPatchRedirector $redirector_;
    final WeakReference<Runnable> innerRunnable;

    public WrapperRunnable(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
        } else {
            this.innerRunnable = new WeakReference<>(runnable);
        }
    }
}
