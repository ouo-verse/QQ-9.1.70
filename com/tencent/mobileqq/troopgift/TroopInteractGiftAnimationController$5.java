package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
class TroopInteractGiftAnimationController$5 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ j this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        throw null;
    }
}
