package com.tencent.mobileqq.msf.core;

import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements com.tencent.mobileqq.msf.core.e0.d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: h, reason: collision with root package name */
    public static final String f248589h = "MSFKernelProtector";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248590i = "trpc.group_pro.configdistribution.ConfigDistributionSvr.SsoGetConfig";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248591j = "MSFKernel";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248592k = "sp_msf_kernel_protector";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248593l = "key_default_switch";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248594m = "key_start_time";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248595n = "key_crash_count";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248596o = "key_start_up_network_error";

    /* renamed from: p, reason: collision with root package name */
    public static final int f248597p = 60000;

    /* renamed from: q, reason: collision with root package name */
    public static final int f248598q = 5;

    /* renamed from: r, reason: collision with root package name */
    public static final int f248599r = 60000;

    /* renamed from: s, reason: collision with root package name */
    public static final int f248600s = 15;

    /* renamed from: t, reason: collision with root package name */
    public static final int f248601t = 3;

    /* renamed from: u, reason: collision with root package name */
    public static final int f248602u = 10000;

    /* renamed from: v, reason: collision with root package name */
    private static volatile c f248603v;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f248604a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f248605b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f248606c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f248607d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f248608e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f248609f;

    /* renamed from: g, reason: collision with root package name */
    private final Set<String> f248610g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements INetEventHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                k.this.f248606c.set(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            k.this.f248607d.set(false);
            if (k.this.f248606c.get() && !k.this.f248608e.get()) {
                QLog.d(k.f248589h, 1, "setStartUpNetworkError for no conn");
                k.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: g, reason: collision with root package name */
        private static final String f248613g = "param_uin";

        /* renamed from: h, reason: collision with root package name */
        private static final String f248614h = "event_time";

        /* renamed from: i, reason: collision with root package name */
        private static final String f248615i = "killReason";

        /* renamed from: j, reason: collision with root package name */
        private static final String f248616j = "responseInterval";

        /* renamed from: k, reason: collision with root package name */
        private static final String f248617k = "lastSendMsgTime";

        /* renamed from: l, reason: collision with root package name */
        private static final String f248618l = "lastRespTime";

        /* renamed from: m, reason: collision with root package name */
        private static final String f248619m = "EvtMSFCoreMonitor";

        /* renamed from: n, reason: collision with root package name */
        private static final int f248620n = 1;

        /* renamed from: o, reason: collision with root package name */
        private static final int f248621o = 2;

        /* renamed from: a, reason: collision with root package name */
        private final com.tencent.mobileqq.msf.core.f0.c.b f248622a;

        /* renamed from: b, reason: collision with root package name */
        private long f248623b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f248624c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f248625d;

        /* renamed from: e, reason: collision with root package name */
        private long f248626e;

        /* renamed from: f, reason: collision with root package name */
        private long f248627f;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements com.tencent.mobileqq.msf.core.y.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.mobileqq.msf.core.y.c
            public void f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    c.this.f248625d = true;
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.msf.core.y.c
            public void h() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    c.this.f248625d = false;
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }
        }

        /* synthetic */ c(com.tencent.mobileqq.msf.core.f0.c.b bVar, a aVar) {
            this(bVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) aVar);
        }

        private boolean b() {
            this.f248626e = this.f248622a.q();
            this.f248627f = this.f248622a.r();
            long uptimeMillis = SystemClock.uptimeMillis() - this.f248626e;
            if (uptimeMillis > com.tencent.mobileqq.msf.core.x.d.X() && this.f248627f - this.f248626e > com.tencent.mobileqq.msf.core.x.d.W()) {
                QLog.d(k.f248589h, 1, "checkServiceResponse timeout, responseInterval: " + uptimeMillis);
                return true;
            }
            return false;
        }

        private void c() {
            try {
                LockMethodProxy.sleep(10000L);
                SystemMethodProxy.killProcess(Process.myPid());
            } catch (InterruptedException e16) {
                QLog.e(k.f248589h, 1, "killMSFProcess InterruptedException", e16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                QLog.d(k.f248589h, 1, "MSFKernelProtector run");
                if (a() && !this.f248624c) {
                    this.f248624c = true;
                    QLog.d(k.f248589h, 1, "need to Kill MSF by MSFCore no connect with network support");
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (this.f248625d && b() && !this.f248624c) {
                    this.f248624c = true;
                    QLog.d(k.f248589h, 1, "need to Kill MSF by MSFCore no response");
                    i3 = 2;
                }
                if (this.f248624c) {
                    this.f248624c = false;
                    HashMap hashMap = new HashMap();
                    String e16 = MsfService.getCore().getAccountCenter().e();
                    if (TextUtils.isEmpty(e16)) {
                        e16 = "0000";
                    }
                    hashMap.put("param_uin", e16);
                    hashMap.put("event_time", String.valueOf(System.currentTimeMillis()));
                    hashMap.put(f248615i, String.valueOf(i3));
                    hashMap.put(f248616j, String.valueOf(SystemClock.uptimeMillis() - this.f248626e));
                    hashMap.put(f248617k, String.valueOf(this.f248627f));
                    hashMap.put(f248618l, String.valueOf(this.f248626e));
                    com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
                    if (statReporter != null) {
                        statReporter.a(f248619m, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                    if (com.tencent.mobileqq.msf.core.x.d.t()) {
                        c();
                    }
                }
            } catch (Exception e17) {
                QLog.e(k.f248589h, 1, "MSFKernelMonitor exception: ", e17);
            } finally {
                k.a(this.f248622a);
            }
        }

        c(@NonNull com.tencent.mobileqq.msf.core.f0.c.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
                return;
            }
            this.f248623b = 0L;
            this.f248624c = false;
            this.f248625d = false;
            this.f248626e = 0L;
            this.f248627f = 0L;
            this.f248622a = bVar;
            this.f248625d = com.tencent.mobileqq.msf.core.y.a.h().i();
            com.tencent.mobileqq.msf.core.y.a.h().a(new a());
        }

        private boolean a() {
            if (!this.f248622a.b() && AppNetConnInfo.isNetSupport()) {
                this.f248623b++;
            } else if (this.f248622a.b()) {
                this.f248623b = 0L;
            }
            if (this.f248623b <= com.tencent.mobileqq.msf.core.x.d.V()) {
                return false;
            }
            this.f248623b = 0L;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final k f248629a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15523);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f248629a = new k(null);
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        }
    }

    /* synthetic */ k(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.tencent.mobileqq.msf.core.b0.a.b().a(f248592k, true).edit().putBoolean(f248596o, true).apply();
        this.f248607d.set(false);
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248604a = new AtomicBoolean(false);
        this.f248605b = new AtomicBoolean(false);
        this.f248606c = new AtomicBoolean(false);
        this.f248607d = new AtomicBoolean(true);
        this.f248608e = new AtomicBoolean(false);
        this.f248609f = new AtomicInteger(0);
        this.f248610g = new HashSet();
    }

    public static k c() {
        return d.f248629a;
    }

    private void d() {
        this.f248605b.set(true);
        this.f248607d.set(false);
        com.tencent.mobileqq.msf.core.b0.a.b().a(f248592k, true).edit().clear().apply();
    }

    public boolean a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, z16)).booleanValue();
        }
        SharedPreferences a16 = com.tencent.mobileqq.msf.core.b0.a.b().a(f248592k, true);
        if (!z16) {
            return a16.getBoolean(f248596o, false) || a16.getInt("key_crash_count", 0) > 5;
        }
        a16.edit().clear().apply();
        return false;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f248604a.compareAndSet(false, true)) {
            this.f248606c.set(NetConnInfoCenter.getActiveNetworkType() != 0);
            AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), new a());
            q.s().postDelayed(new b(), 60000L);
        }
    }

    public static boolean a() {
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
            return !BaseApplication.getContext().getMSFInterfaceAdapter().isVIPAccount(MsfService.getCore().getMainAccount());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.e0.d
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (this.f248604a.get() && this.f248607d.get() && toServiceMsg != null && fromServiceMsg != null) {
            if (MsfService.getCore().isConnected() && !this.f248608e.get()) {
                QLog.d(f248589h, 1, "[onMessageReceive] set connect success");
                this.f248608e.set(true);
            }
            if (toServiceMsg.getServiceCmd().equals(f248590i) && fromServiceMsg.getServiceCmd().equals(f248590i)) {
                QLog.d(f248589h, 1, "[onMessageReceive] freesia fetch config");
                d();
            }
            if (this.f248606c.get() && fromServiceMsg.getBusinessFailCode() == 1002) {
                this.f248610g.add(fromServiceMsg.getServiceCmd());
                int incrementAndGet = this.f248609f.incrementAndGet();
                QLog.d(f248589h, 1, "[onMessageReceive] timeout but netSupport, cmd: " + fromServiceMsg.getServiceCmd() + ", timeoutCount: " + incrementAndGet + ", timeoutCmdSize:" + this.f248610g.size());
                if (this.f248610g.size() <= 3 || incrementAndGet <= 15) {
                    return;
                }
                this.f248609f.set(0);
                this.f248610g.clear();
                e();
                QLog.d(f248589h, 1, "setStartUpNetworkError for package timeout");
                return;
            }
            if (this.f248606c.get()) {
                this.f248609f.set(0);
                this.f248610g.clear();
            }
        }
    }

    public void a(boolean z16, String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
            return;
        }
        QLog.d(f248589h, 1, "checkExceptionWhenCauseByMSFCore isNativeCrash: " + z16 + ", crashStack: " + str);
        if (!this.f248605b.get() && this.f248604a.get() && z16 && str.contains("MSFKernel")) {
            SharedPreferences a16 = com.tencent.mobileqq.msf.core.b0.a.b().a(f248592k, true);
            long j3 = a16.getLong("key_start_time", 0L);
            int i16 = a16.getInt("key_crash_count", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (j3 == 0 || currentTimeMillis <= j3 || i16 <= 0 || currentTimeMillis - j3 > 60000) {
                i3 = 1;
                j3 = currentTimeMillis;
            } else {
                i3 = i16 + 1;
            }
            QLog.d(f248589h, 1, "checkExceptionWhenCauseByMSFCore startTime: " + j3 + ", count: " + i3);
            a16.edit().putLong("key_start_time", j3).putInt("key_crash_count", i3).apply();
        }
    }

    public static void a(@NonNull com.tencent.mobileqq.msf.core.f0.c.b bVar) {
        if (f248603v == null) {
            synchronized (k.class) {
                if (f248603v == null) {
                    f248603v = new c(bVar, null);
                }
            }
        }
        QLog.d(f248589h, 1, "startMSFKernelMonitor");
        q.s().removeCallbacks(f248603v);
        q.s().postDelayed(f248603v, 10000L);
    }
}
