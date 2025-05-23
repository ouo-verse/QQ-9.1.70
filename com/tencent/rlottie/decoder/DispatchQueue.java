package com.tencent.rlottie.decoder;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class DispatchQueue extends BaseThread {
    static IPatchRedirector $redirector_;
    public static volatile Handler F;
    private volatile Handler C;
    private CountDownLatch D;
    private long E;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            F = null;
        }
    }

    public DispatchQueue(String str) {
        this(str, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    public static void s(Runnable runnable) {
        t(runnable, 0L);
    }

    public static synchronized void t(Runnable runnable, long j3) {
        synchronized (DispatchQueue.class) {
            if (F == null) {
                F = new Handler(Looper.getMainLooper());
            }
            if (j3 == 0) {
                F.post(runnable);
            } else {
                F.postDelayed(runnable, j3);
            }
        }
    }

    public long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.E;
    }

    public boolean p(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable)).booleanValue();
        }
        this.E = SystemClock.elapsedRealtime();
        return q(runnable, 0L);
    }

    public boolean q(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, runnable, Long.valueOf(j3))).booleanValue();
        }
        try {
            this.D.await();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (j3 <= 0) {
            return this.C.post(runnable);
        }
        return this.C.postDelayed(runnable, j3);
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.C.getLooper().quit();
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Looper.prepare();
        this.C = new Handler();
        this.D.countDown();
        Looper.loop();
    }

    public DispatchQueue(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            return;
        }
        this.C = null;
        this.D = new CountDownLatch(1);
        setName(str);
        if (z16) {
            start();
        }
    }
}
