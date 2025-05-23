package com.tencent.mobileqq.perf.thread.block;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
class ThreadBlockTest$3 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f258091d;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d("[TM]ThreadBlockTest", 2, "testSubThreadBlocked start");
        try {
            LockMethodProxy.sleep(this.f258091d);
        } catch (InterruptedException e16) {
            QLog.e("[TM]ThreadBlockTest", 1, e16, new Object[0]);
        }
        QLog.d("[TM]ThreadBlockTest", 2, "testSubThreadBlocked end");
    }
}
