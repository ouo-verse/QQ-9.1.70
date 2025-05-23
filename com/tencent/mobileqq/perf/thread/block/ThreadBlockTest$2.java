package com.tencent.mobileqq.perf.thread.block;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
class ThreadBlockTest$2 implements Runnable {
    static IPatchRedirector $redirector_;

    ThreadBlockTest$2() {
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
            obj = e.f258115b;
            synchronized (obj) {
                QLog.d("[TM]ThreadBlockTest", 2, "QQ_SUB thread get lock2");
                obj2 = e.f258114a;
                synchronized (obj2) {
                    QLog.d("[TM]ThreadBlockTest", 2, "QQ_SUB thread get lock1");
                }
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
