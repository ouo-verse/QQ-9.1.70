package com.tencent.mobileqq.perf.thread;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
class ThreadTraceHelper$1 implements Runnable {
    static IPatchRedirector $redirector_;

    ThreadTraceHelper$1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            l3 = b.l();
            QLog.e("AutoMonitor", 1, l3);
            QLog.e("AutoMonitor", 1, "printBlockOrWaitThread" + b.g());
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
