package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes15.dex */
public class q {
    static IPatchRedirector $redirector_ = null;
    private static HandlerThread A = null;
    private static Handler B = null;
    private static Handler C = null;
    private static Handler D = null;
    private static Handler E = null;
    private static Handler F = null;
    public static final int G = 2;
    public static final int H = 2;
    private static Executor I = null;
    private static Executor J = null;
    private static HandlerThread K = null;
    private static Handler L = null;
    private static HandlerThread M = null;
    private static Handler N = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249786a = "MsfThreadManager";

    /* renamed from: b, reason: collision with root package name */
    private static HandlerThread f249787b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f249788c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final String f249789d = "MsfCoreMsgSender";

    /* renamed from: e, reason: collision with root package name */
    public static final String f249790e = "MsfCoreSocketReaderNew";

    /* renamed from: f, reason: collision with root package name */
    public static final String f249791f = "LightSender";

    /* renamed from: g, reason: collision with root package name */
    public static final String f249792g = "LightTcpSenderThread";

    /* renamed from: h, reason: collision with root package name */
    public static final String f249793h = "MSFSubHandlerThread";

    /* renamed from: i, reason: collision with root package name */
    public static final String f249794i = "MsgSyncControlHandlerThread";

    /* renamed from: j, reason: collision with root package name */
    public static final String f249795j = "MsfProbeThread";

    /* renamed from: k, reason: collision with root package name */
    public static final String f249796k = "MSFBaseEventDispatchThread";

    /* renamed from: l, reason: collision with root package name */
    public static final String f249797l = "MSFNewServiceReceiverThread";

    /* renamed from: m, reason: collision with root package name */
    public static final String f249798m = "MSFNewServiceSenderThread";

    /* renamed from: n, reason: collision with root package name */
    public static final String f249799n = "MSFNetworkAdapterWorkerThread";

    /* renamed from: o, reason: collision with root package name */
    public static final String f249800o = "MSFDeepSleepThread";

    /* renamed from: p, reason: collision with root package name */
    public static final String f249801p = "MSFWakeLockThread";

    /* renamed from: q, reason: collision with root package name */
    public static final String f249802q = "MSFStandByModeThread";

    /* renamed from: r, reason: collision with root package name */
    public static final String f249803r = "MSFPushManagerThread";

    /* renamed from: s, reason: collision with root package name */
    private static HandlerThread f249804s;

    /* renamed from: t, reason: collision with root package name */
    private static HandlerThread f249805t;

    /* renamed from: u, reason: collision with root package name */
    private static HandlerThread f249806u;

    /* renamed from: v, reason: collision with root package name */
    private static HandlerThread f249807v;

    /* renamed from: w, reason: collision with root package name */
    private static HandlerThread f249808w;

    /* renamed from: x, reason: collision with root package name */
    private static HandlerThread f249809x;

    /* renamed from: y, reason: collision with root package name */
    private static HandlerThread f249810y;

    /* renamed from: z, reason: collision with root package name */
    private static HandlerThread f249811z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f249812a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f249813b;

        a(c cVar, Runnable runnable) {
            this.f249812a = cVar;
            this.f249813b = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            c cVar = this.f249812a;
            if (cVar != null) {
                cVar.b();
            }
            this.f249813b.run();
            c cVar2 = this.f249812a;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f249814a;

        b(Runnable runnable) {
            this.f249814a = runnable;
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
            } else {
                this.f249814a.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a();

        void b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(@NonNull Runnable runnable, c cVar) {
        if (I == null) {
            I = ProxyExecutors.newFixedThreadPool(2);
        }
        I.execute(new a(cVar, runnable));
        QLog.d(f249786a, 1, "[postFileTask] task: ", runnable);
    }

    public static Handler b() {
        if (D == null) {
            synchronized (q.class) {
                if (D == null) {
                    D = new Handler(c().getLooper());
                }
            }
        }
        return D;
    }

    public static HandlerThread c() {
        if (f249809x == null) {
            synchronized (q.class) {
                if (f249809x == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249800o);
                    baseHandlerThread.start();
                    f249809x = baseHandlerThread;
                }
            }
        }
        return f249809x;
    }

    public static Handler d() {
        if (E == null) {
            synchronized (q.class) {
                if (E == null) {
                    E = new Handler(e().getLooper());
                }
            }
        }
        return E;
    }

    public static HandlerThread e() {
        if (f249808w == null) {
            synchronized (q.class) {
                if (f249808w == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249797l);
                    baseHandlerThread.start();
                    f249808w = baseHandlerThread;
                    BaseApplication.getContext().getMSFInterfaceAdapter().addHandlerThreadMonitor(2, baseHandlerThread);
                }
            }
        }
        return f249808w;
    }

    public static Handler f() {
        if (F == null) {
            synchronized (q.class) {
                if (F == null) {
                    F = new Handler(g().getLooper());
                }
            }
        }
        return F;
    }

    public static HandlerThread g() {
        if (f249810y == null) {
            synchronized (q.class) {
                if (f249810y == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249798m);
                    baseHandlerThread.start();
                    f249810y = baseHandlerThread;
                    BaseApplication.getContext().getMSFInterfaceAdapter().addHandlerThreadMonitor(1, baseHandlerThread);
                }
            }
        }
        return f249810y;
    }

    public static Handler h() {
        if (C == null) {
            synchronized (q.class) {
                if (C == null) {
                    C = new Handler(l().getLooper());
                }
            }
        }
        return C;
    }

    public static HandlerThread i() {
        if (A == null) {
            synchronized (q.class) {
                if (A == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249803r);
                    baseHandlerThread.start();
                    A = baseHandlerThread;
                }
            }
        }
        return A;
    }

    public static HandlerThread j() {
        if (f249811z == null) {
            synchronized (q.class) {
                if (f249811z == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249802q);
                    baseHandlerThread.start();
                    f249811z = baseHandlerThread;
                }
            }
        }
        return f249811z;
    }

    public static HandlerThread k() {
        if (f249806u == null) {
            synchronized (q.class) {
                if (f249806u == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249801p);
                    baseHandlerThread.start();
                    f249806u = baseHandlerThread;
                }
            }
        }
        return f249806u;
    }

    public static HandlerThread l() {
        if (f249805t == null) {
            synchronized (q.class) {
                if (f249805t == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249795j);
                    baseHandlerThread.start();
                    f249805t = baseHandlerThread;
                }
            }
        }
        return f249805t;
    }

    public static Handler m() {
        if (L == null) {
            synchronized (q.class) {
                if (L == null) {
                    L = new Handler(n().getLooper());
                }
            }
        }
        return L;
    }

    public static HandlerThread n() {
        if (K == null) {
            synchronized (q.class) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MSFNetHandlerThread");
                baseHandlerThread.start();
                K = baseHandlerThread;
                BaseApplication.getContext().getMSFInterfaceAdapter().addHandlerThreadMonitor(5, baseHandlerThread);
            }
        }
        return K;
    }

    public static Handler o() {
        if (N == null) {
            synchronized (q.class) {
                if (N == null) {
                    N = new Handler(p().getLooper());
                }
            }
        }
        return N;
    }

    public static HandlerThread p() {
        if (M == null) {
            synchronized (q.class) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MSFNetworkRefreshThread");
                baseHandlerThread.start();
                M = baseHandlerThread;
            }
        }
        return M;
    }

    public static Handler q() {
        if (f249788c == null) {
            synchronized (q.class) {
                if (f249788c == null) {
                    f249788c = new Handler(r().getLooper());
                }
            }
        }
        return f249788c;
    }

    public static HandlerThread r() {
        if (f249787b == null) {
            synchronized (q.class) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MSF_StatReportThread");
                baseHandlerThread.start();
                f249787b = baseHandlerThread;
            }
        }
        return f249787b;
    }

    public static Handler s() {
        if (B == null) {
            synchronized (q.class) {
                if (B == null) {
                    B = new Handler(t().getLooper());
                }
            }
        }
        return B;
    }

    public static HandlerThread t() {
        if (f249804s == null) {
            synchronized (q.class) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249793h);
                baseHandlerThread.start();
                f249804s = baseHandlerThread;
                BaseApplication.getContext().getMSFInterfaceAdapter().addHandlerThreadMonitor(4, baseHandlerThread);
            }
        }
        return f249804s;
    }

    public static void a(@NonNull Runnable runnable) {
        if (J == null) {
            J = ProxyExecutors.newFixedThreadPool(2);
        }
        J.execute(new b(runnable));
    }

    public static HandlerThread a() {
        if (f249807v == null) {
            synchronized (q.class) {
                if (f249807v == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(f249796k);
                    baseHandlerThread.start();
                    f249807v = baseHandlerThread;
                    BaseApplication.getContext().getMSFInterfaceAdapter().addHandlerThreadMonitor(3, baseHandlerThread);
                }
            }
        }
        return f249807v;
    }
}
