package com.tencent.mobileqq.perf.block;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class LockMethodProxy {
    static IPatchRedirector $redirector_;

    public LockMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void sleep(long j3) throws InterruptedException {
        MainBlockMethodMonitor.onMethodStart();
        Thread.sleep(j3);
        MainBlockMethodMonitor.onMethodEnd();
    }

    public static void wait(Object obj) throws InterruptedException {
        MainBlockMethodMonitor.onMethodStart();
        obj.wait();
        MainBlockMethodMonitor.onMethodEnd();
    }

    public static void sleep(long j3, int i3) throws InterruptedException {
        MainBlockMethodMonitor.onMethodStart();
        Thread.sleep(j3, i3);
        MainBlockMethodMonitor.onMethodEnd();
    }
}
