package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
class BaseLebaMainBiz$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.this$0.f240100a.notifyDataSetChanged();
        }
    }
}
