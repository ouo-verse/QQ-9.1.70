package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
class FileCleanManager$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ l this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        l.d(null);
        l.f(null);
        l.b(null, true);
        QLog.d("FileCleanManager", 1, "load pics and videos finish");
        l.c(null);
    }
}
