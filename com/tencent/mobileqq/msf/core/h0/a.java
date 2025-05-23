package com.tencent.mobileqq.msf.core.h0;

import android.os.Handler;
import android.os.PowerManager;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f248390d = "MSF:WakeLock";

    /* renamed from: e, reason: collision with root package name */
    private static final int f248391e = 300000;

    /* renamed from: a, reason: collision with root package name */
    private final PowerManager.WakeLock f248392a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f248393b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f248394c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.h0.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class RunnableC8080a implements Runnable {
        static IPatchRedirector $redirector_;

        RunnableC8080a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a.this.c();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248394c = new RunnableC8080a();
        BaseApplication context = BaseApplication.getContext();
        this.f248393b = new Handler(q.k().getLooper());
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, f248390d);
        this.f248392a = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private void b() {
        this.f248393b.removeCallbacks(this.f248394c);
        this.f248392a.acquire(MiniBoxNoticeInfo.MIN_5);
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            b();
            this.f248393b.postDelayed(this.f248394c, j3);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f248393b.removeCallbacks(this.f248394c);
        if (this.f248392a.isHeld()) {
            this.f248392a.release();
            QLog.d(f248390d, 1, "wakeLock release");
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            c();
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f248392a.isHeld() : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }
}
