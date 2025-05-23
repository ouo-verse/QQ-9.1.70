package com.tencent.msdk.dns.base.executor;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class DnsExecutors {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f336206a;

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.msdk.dns.base.executor.a f336207b;

    /* renamed from: c, reason: collision with root package name */
    public static final Executor f336208c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f336209d;

        a(Runnable runnable) {
            this.f336209d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String k3 = DnsExecutors.k("dns-work-" + DnsExecutors.f336206a.getAndIncrement());
            int e16 = DnsExecutors.e();
            try {
                Runnable runnable = this.f336209d;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Exception e17) {
                com.tencent.msdk.dns.base.log.c.j(e17, "Run task in executor failed", new Object[0]);
            }
            DnsExecutors.g(e16);
            DnsExecutors.j(k3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class c implements com.tencent.msdk.dns.base.executor.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final HandlerThread f336210d;

        /* renamed from: e, reason: collision with root package name */
        private final Handler f336211e;

        /* renamed from: f, reason: collision with root package name */
        private final Map<Runnable, Runnable> f336212f;

        /* synthetic */ c(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }

        @Override // com.tencent.msdk.dns.base.executor.a
        public void a(Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3));
                return;
            }
            if (runnable != null) {
                Runnable f16 = DnsExecutors.f(runnable);
                if (0 < j3) {
                    this.f336212f.put(runnable, f16);
                    this.f336211e.postDelayed(f16, j3);
                } else {
                    execute(f16);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            } else if (runnable != null) {
                this.f336211e.post(DnsExecutors.f(runnable));
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f336212f = new ConcurrentHashMap();
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("dns-main");
            this.f336210d = baseHandlerThread;
            baseHandlerThread.start();
            this.f336211e = new Handler(baseHandlerThread.getLooper());
        }

        @Override // com.tencent.msdk.dns.base.executor.a
        public void a(Runnable runnable) {
            Runnable runnable2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
            } else {
                if (runnable == null || (runnable2 = this.f336212f.get(runnable)) == null) {
                    return;
                }
                this.f336211e.removeCallbacks(runnable2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class d implements Executor {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final Executor f336213d;

        /* synthetic */ d(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            } else if (runnable != null) {
                this.f336213d.execute(DnsExecutors.f(runnable));
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                com.tencent.msdk.dns.base.executor.a aVar = DnsExecutors.f336207b;
                this.f336213d = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f336206a = new AtomicInteger(0);
        a aVar = null;
        f336207b = new c(aVar);
        f336208c = new d(aVar);
    }

    static /* synthetic */ int e() {
        return i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Runnable f(Runnable runnable) {
        return new a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(int i3) {
        if (Integer.MIN_VALUE == i3) {
            return;
        }
        try {
            if (i3 != Process.getThreadPriority(Process.myTid())) {
                Process.setThreadPriority(i3);
            }
        } catch (Exception unused) {
        }
    }

    private static int i() {
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            if (10 != threadPriority) {
                try {
                    Process.setThreadPriority(10);
                    return threadPriority;
                } catch (Exception unused) {
                    return threadPriority;
                }
            }
            return threadPriority;
        } catch (Exception unused2) {
            return Integer.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str) {
        Thread.currentThread().setName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(String str) {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(str);
        return name;
    }
}
