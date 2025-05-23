package com.tencent.centaur.host.loader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
class CentaurLoader$3 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a.a(this.this$0);
            System.exit(0);
        }
    }
}
