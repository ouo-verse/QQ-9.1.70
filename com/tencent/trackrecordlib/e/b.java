package com.tencent.trackrecordlib.e;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381106a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f381107b;

    /* renamed from: c, reason: collision with root package name */
    private PowerManager f381108c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f381109d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f381106a = b.class.getSimpleName();
        }
    }

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f381108c = (PowerManager) context.getSystemService("power");
        this.f381107b = false;
        this.f381109d = true;
    }

    @Override // com.tencent.trackrecordlib.e.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f381107b = true;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.trackrecordlib.e.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            new BaseThread(new Runnable() { // from class: com.tencent.trackrecordlib.e.b.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    while (!b.this.f381107b) {
                        try {
                            if (!b.this.f381108c.isScreenOn() && b.this.f381109d) {
                                com.tencent.trackrecordlib.core.c.a().c();
                                b.this.f381109d = false;
                            }
                            if (b.this.f381108c.isScreenOn() && !b.this.f381109d) {
                                com.tencent.trackrecordlib.core.c.a().c();
                                b.this.f381109d = true;
                            }
                            LockMethodProxy.sleep(1000L);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }, "PowerKeyMonitorThread").start();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
