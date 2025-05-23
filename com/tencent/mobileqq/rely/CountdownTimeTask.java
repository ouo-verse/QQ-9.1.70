package com.tencent.mobileqq.rely;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class CountdownTimeTask implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected long f280834d;

    /* renamed from: e, reason: collision with root package name */
    protected Object f280835e;

    /* renamed from: f, reason: collision with root package name */
    protected Runnable f280836f;

    public CountdownTimeTask(Runnable runnable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, i3);
            return;
        }
        this.f280834d = 1000L;
        this.f280835e = new Object();
        this.f280836f = runnable;
        g(i3);
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f280834d;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            g(this.f280834d);
        }
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        synchronized (this.f280835e) {
            if (QLog.isColorLevel()) {
                QLog.d("CountDownTimeTask", 2, "resetTimer: " + j3);
            }
            this.f280834d = j3;
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            g(-1L);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        while (true) {
            long j3 = this.f280834d;
            if (j3 > 0) {
                try {
                    LockMethodProxy.sleep(100L);
                    synchronized (this.f280835e) {
                        this.f280834d -= 100;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CountDownTimeTask", 2, "run: " + this.f280834d);
                    }
                } catch (InterruptedException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CountDownTimeTask", 2, QLog.getStackTraceString(e16));
                    }
                }
            } else {
                if (j3 != -1 && (runnable = this.f280836f) != null) {
                    runnable.run();
                    return;
                }
                return;
            }
        }
    }
}
