package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.TMSManager;

/* compiled from: P */
/* loaded from: classes20.dex */
class KCWraper$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TMSManager.a f312739d;
    final /* synthetic */ l this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f312739d.a(false, false, 0);
        }
    }
}
