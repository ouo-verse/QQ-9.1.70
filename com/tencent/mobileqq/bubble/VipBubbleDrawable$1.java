package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
class VipBubbleDrawable$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ h this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.this$0.invalidateSelf();
        }
    }
}
