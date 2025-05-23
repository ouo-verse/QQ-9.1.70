package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
class TroopFileDataCenter$2 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            b.b(null);
        }
    }
}
