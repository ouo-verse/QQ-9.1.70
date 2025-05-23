package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e implements com.tencent.gathererga.core.c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f108281c;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gathererga.core.c f108282a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.gathererga.core.c f108283b;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a implements com.tencent.gathererga.core.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private ExecutorService f108284a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f108284a = new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new b());
            }
        }

        @Override // com.tencent.gathererga.core.c
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            } else {
                this.f108284a.execute(runnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        private static final AtomicInteger f108285h;

        /* renamed from: d, reason: collision with root package name */
        private final ThreadGroup f108286d;

        /* renamed from: e, reason: collision with root package name */
        private final AtomicInteger f108287e;

        /* renamed from: f, reason: collision with root package name */
        private final String f108288f;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56030);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f108285h = new AtomicInteger(1);
            }
        }

        public b() {
            ThreadGroup threadGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f108287e = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f108286d = threadGroup;
            this.f108288f = "gatherer-" + f108285h.getAndIncrement() + "-thread";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            BaseThread baseThread = new BaseThread(this.f108286d, runnable, this.f108288f + this.f108287e.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            if (baseThread.getPriority() != 5) {
                baseThread.setPriority(5);
            }
            return baseThread;
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108282a = null;
            this.f108283b = null;
        }
    }

    private com.tencent.gathererga.core.c a() {
        com.tencent.gathererga.core.c cVar = this.f108282a;
        if (cVar != null) {
            return cVar;
        }
        com.tencent.gathererga.core.c cVar2 = this.f108283b;
        if (cVar2 == null) {
            a aVar = new a();
            this.f108283b = aVar;
            return aVar;
        }
        return cVar2;
    }

    public static e b() {
        if (f108281c == null) {
            synchronized (e.class) {
                if (f108281c == null) {
                    f108281c = new e();
                }
            }
        }
        return f108281c;
    }

    public void c(com.tencent.gathererga.core.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f108282a = cVar;
        }
    }

    @Override // com.tencent.gathererga.core.c
    public void execute(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            a().execute(runnable);
        }
    }
}
