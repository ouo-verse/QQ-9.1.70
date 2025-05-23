package com.tencent.halley.common.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile j f113278a;

    /* renamed from: b, reason: collision with root package name */
    private Timer f113279b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Runnable, TimerTask> f113280c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9077);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f113278a = null;
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113280c = new ConcurrentHashMap();
            this.f113279b = new BaseTimer(i.b("ConnectionTimer"), true);
        }
    }

    public static j a() {
        if (f113278a == null) {
            synchronized (j.class) {
                if (f113278a == null) {
                    f113278a = new j();
                }
            }
        }
        return f113278a;
    }

    public final void a(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, runnable, Long.valueOf(j3));
            return;
        }
        synchronized (runnable) {
            a(runnable);
            TimerTask timerTask = new TimerTask(runnable) { // from class: com.tencent.halley.common.a.j.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Runnable f113281a;

                {
                    this.f113281a = runnable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) j.this, (Object) runnable);
                    }
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f113281a.run();
                    }
                }
            };
            this.f113279b.schedule(timerTask, j3);
            this.f113280c.put(runnable, timerTask);
        }
    }

    public final boolean a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable)).booleanValue();
        }
        synchronized (runnable) {
            TimerTask timerTask = this.f113280c.get(runnable);
            if (timerTask == null) {
                return true;
            }
            this.f113280c.remove(runnable);
            return timerTask.cancel();
        }
    }
}
