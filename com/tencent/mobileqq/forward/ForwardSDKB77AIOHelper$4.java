package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
class ForwardSDKB77AIOHelper$4 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ s this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (!s.b(null)) {
                return;
            }
            s.a(null).dismiss();
        }
    }
}
