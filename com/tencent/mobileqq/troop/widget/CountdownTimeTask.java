package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CountdownTimeTask implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected long f302289d;

    /* renamed from: e, reason: collision with root package name */
    protected Object f302290e;

    /* renamed from: f, reason: collision with root package name */
    protected Runnable f302291f;

    public CountdownTimeTask(Runnable runnable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, i3);
            return;
        }
        this.f302289d = 1000L;
        this.f302290e = new Object();
        this.f302291f = runnable;
        g(i3);
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f302289d;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            g(this.f302289d);
        }
    }

    public void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        synchronized (this.f302290e) {
            if (QLog.isColorLevel()) {
                QLog.d("CountDownTimeTask", 2, "resetTimer: " + j3);
            }
            this.f302289d = j3;
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
            long j3 = this.f302289d;
            if (j3 > 0) {
                try {
                    LockMethodProxy.sleep(100L);
                    synchronized (this.f302290e) {
                        this.f302289d -= 100;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("CountDownTimeTask", 2, "run: " + this.f302289d);
                    }
                } catch (InterruptedException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CountDownTimeTask", 2, QLog.getStackTraceString(e16));
                    }
                }
            } else {
                if (j3 != -1 && (runnable = this.f302291f) != null) {
                    runnable.run();
                    return;
                }
                return;
            }
        }
    }
}
