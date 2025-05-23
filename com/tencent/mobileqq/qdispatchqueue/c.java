package com.tencent.mobileqq.qdispatchqueue;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes16.dex */
class c implements Executor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    ExecutorService f261874d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static c f261875a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14388);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f261875a = new c();
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f261874d = new BaseThreadPoolExecutor(8, (Runtime.getRuntime().availableProcessors() * 2) + 2, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        }
    }

    public static c a() {
        return a.f261875a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            this.f261874d.execute(runnable);
        }
    }
}
