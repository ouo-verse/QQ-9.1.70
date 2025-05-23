package com.tencent.mobileqq.perf.thread.block;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
class ThreadBlockTest$1 implements Runnable {
    static IPatchRedirector $redirector_;

    ThreadBlockTest$1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            obj = e.f258114a;
            synchronized (obj) {
                QLog.d("[TM]ThreadBlockTest", 2, "testLockThread get lock1");
                try {
                    LockMethodProxy.sleep(2000L);
                } catch (InterruptedException e16) {
                    QLog.e("[TM]ThreadBlockTest", 1, e16, new Object[0]);
                }
                obj2 = e.f258115b;
                synchronized (obj2) {
                    QLog.d("[TM]ThreadBlockTest", 2, "testLockThread  get lock2");
                }
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
