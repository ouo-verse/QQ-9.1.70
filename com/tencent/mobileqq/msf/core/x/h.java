package com.tencent.mobileqq.msf.core.x;

import com.tencent.mobileqq.msf.core.x.b;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    public static final String f250261f = "MSFLoginMergeConfigManager";

    /* renamed from: g, reason: collision with root package name */
    public static final int f250262g = 500;

    /* renamed from: h, reason: collision with root package name */
    public static final int f250263h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final int f250264i = 300;

    /* renamed from: j, reason: collision with root package name */
    public static final int f250265j = 10;

    /* renamed from: k, reason: collision with root package name */
    public static final int f250266k = 3072;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f250267a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f250268b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f250269c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f250270d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f250271e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements b.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.x.b.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.a();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final h f250273a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12381);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250273a = new h(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ h(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static h g() {
        return b.f250273a;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f250270d.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f250267a.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f250271e.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f250268b.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f250269c.get();
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(500);
        this.f250267a = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        this.f250268b = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger(300);
        this.f250269c = atomicInteger3;
        AtomicInteger atomicInteger4 = new AtomicInteger(10);
        this.f250270d = atomicInteger4;
        AtomicInteger atomicInteger5 = new AtomicInteger(3072);
        this.f250271e = atomicInteger5;
        try {
            if (MsfService.getCore().configManager != null) {
                MsfService.getCore().configManager.a(new a());
            }
            String[] T = com.tencent.mobileqq.msf.core.x.b.T();
            if (T != null) {
                atomicInteger4.set(Integer.parseInt(T[0]));
                atomicInteger5.set(Integer.parseInt(T[1]));
                atomicInteger3.set(Integer.parseInt(T[2]));
                atomicInteger.set(Integer.parseInt(T[3]));
                atomicInteger2.set(Integer.parseInt(com.tencent.mobileqq.msf.core.x.b.U()));
                if (QLog.isColorLevel()) {
                    QLog.d(f250261f, 2, "maxDelaySize: " + atomicInteger5.get() + " noMergeSize: " + atomicInteger3.get() + " globalDelayTime: " + atomicInteger.get() + " delayWaitSendCount: " + atomicInteger4.get() + " mergeDuration: " + atomicInteger2.get());
                }
            }
        } catch (Exception e16) {
            QLog.d(f250261f, 1, "MSFLoginMergeConfigManager init error ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            String[] T = com.tencent.mobileqq.msf.core.x.b.T();
            if (T != null) {
                this.f250270d.set(Integer.parseInt(T[0]));
                this.f250271e.set(Integer.parseInt(T[1]));
                this.f250269c.set(Integer.parseInt(T[2]));
                this.f250267a.set(Integer.parseInt(T[3]));
                this.f250268b.set(Integer.parseInt(com.tencent.mobileqq.msf.core.x.b.U()));
            }
        } catch (Exception e16) {
            QLog.d(f250261f, 1, " " + e16, e16);
        }
        try {
            o.x().a(com.tencent.mobileqq.msf.core.x.b.V());
        } catch (Exception e17) {
            QLog.d(f250261f, 1, " " + e17, e17);
        }
    }
}
