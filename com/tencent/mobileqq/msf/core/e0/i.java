package com.tencent.mobileqq.msf.core.e0;

import android.content.Context;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i implements com.tencent.mobileqq.msf.core.y.d, com.tencent.mobileqq.msf.core.y.c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f247999f = "SenderManager";

    /* renamed from: g, reason: collision with root package name */
    public static final String f248000g = "msf_sub_sender_switch";

    /* renamed from: h, reason: collision with root package name */
    public static final String f248001h = "key_is_open_sub_sender";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248002i = "key_conn_seq";

    /* renamed from: j, reason: collision with root package name */
    public static final int f248003j = 50;

    /* renamed from: k, reason: collision with root package name */
    public static final int f248004k = -1;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f248005l = false;

    /* renamed from: m, reason: collision with root package name */
    private static String f248006m = "";

    /* renamed from: n, reason: collision with root package name */
    private static int f248007n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static String f248008o = "0";

    /* renamed from: p, reason: collision with root package name */
    public static long f248009p;

    /* renamed from: a, reason: collision with root package name */
    private final MsfCore f248010a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f248011b;

    /* renamed from: c, reason: collision with root package name */
    private final t f248012c;

    /* renamed from: d, reason: collision with root package name */
    private final t f248013d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f248014e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public i(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) aVar);
            return;
        }
        this.f248010a = msfCore;
        this.f248011b = aVar;
        this.f248012c = new t(msfCore, aVar, true);
        this.f248013d = new t(msfCore, aVar, false);
    }

    public static void b(String str) {
        f248006m = str;
    }

    public static int g() {
        return f248007n;
    }

    public static String i() {
        return f248008o;
    }

    public static synchronized void n() {
        synchronized (i.class) {
            f248009p = com.tencent.mobileqq.msf.core.b0.a.b().a().decodeLong(f248002i, 0L);
        }
    }

    private void o() {
        this.f248014e = MsfService.getCore().getSharedPreferences(f248000g, 0).getBoolean(f248001h, false);
        QLog.d(f247999f, 1, "[initSubSenderSp] switch: ", Boolean.valueOf(this.f248014e));
    }

    public static synchronized void t() {
        synchronized (i.class) {
            long serverTime = NetConnInfoCenter.getServerTime();
            long j3 = f248009p;
            if (serverTime > j3) {
                f248009p = serverTime;
            } else {
                f248009p = j3 + 1;
            }
            a(f248009p);
            QLog.d(f247999f, 1, "updateConnSeq After conn success, connSeq: " + f248009p);
        }
    }

    public boolean a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.y.a.h().a((com.tencent.mobileqq.msf.core.y.d) this);
        com.tencent.mobileqq.msf.core.y.a.h().a((com.tencent.mobileqq.msf.core.y.c) this);
        boolean z16 = this.f248013d.a(context) && this.f248012c.a(context);
        o();
        n();
        if (!this.f248010a.getMainAccount().equals("0") && MsfSdkUtils.isUinLong(this.f248010a.getMainAccount())) {
            f248008o = this.f248010a.getMainAccount();
        }
        QLog.d(f247999f, 1, "[SenderManager] init: ", Boolean.valueOf(z16));
        return z16;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f248012c.f250076a.f();
    }

    public com.tencent.mobileqq.msf.core.d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.mobileqq.msf.core.d) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f248012c.f250076a.i().g();
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return f248006m;
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f248012c.t();
            this.f248013d.t();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.f248012c.s();
            this.f248013d.s();
        }
    }

    public t j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (t) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f248012c;
    }

    public com.tencent.mobileqq.msf.core.f0.d.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.msf.core.f0.d.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f248011b;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f248012c.m();
    }

    t m() {
        return this.f248013d;
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        try {
            if (com.tencent.mobileqq.msf.core.x.b.c()) {
                try {
                    j().f250097v.c().m();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f247999f, 2, "failed to call adaptorcontroller screenoff ", e16);
                    }
                }
            }
        } catch (Exception e17) {
            QLog.d(f247999f, 1, "onReceive ScreenOff to controller failed " + e17.toString(), e17);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        try {
            if (com.tencent.mobileqq.msf.core.x.b.c()) {
                try {
                    j().f250097v.c().l();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f247999f, 2, "failed to call adaptorcontroller screenon ", e16);
                    }
                }
            }
        } catch (Exception e17) {
            QLog.d(f247999f, 1, "onReceive ScreenOn to controller failed " + e17.toString(), e17);
        }
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f248012c.f250076a.l();
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f248014e;
    }

    public boolean r() {
        com.tencent.mobileqq.msf.core.d g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        n i3 = this.f248012c.f250076a.i();
        if (i3 != null && (g16 = i3.g()) != null) {
            return g16.l();
        }
        return false;
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f248012c.A();
            this.f248013d.A();
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.f248012c.f250076a.e() : ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
    }

    public synchronized long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return f248009p;
        }
        return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
    }

    public static void a(long j3) {
        com.tencent.mobileqq.msf.core.b0.a.b().a().encodeLong(f248002i, j3);
    }

    public int a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        return a(toServiceMsg.getServiceCmd()).b(toServiceMsg);
    }

    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.f248012c.a(aVar);
            this.f248013d.a(aVar);
        }
    }

    public static void a(int i3) {
        f248007n = i3;
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        this.f248014e = z16;
        QLog.d(f247999f, 1, "[enableSubSender] enable: ", Boolean.valueOf(this.f248014e));
        MsfService.getCore().getSharedPreferences(f248000g, 0).edit().putBoolean(f248001h, z16).apply();
        if (z16 || !this.f248013d.f250076a.l()) {
            return;
        }
        this.f248013d.a(com.tencent.qphone.base.a.closeByNewConnFailed);
    }

    public t a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (t) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        if (com.tencent.mobileqq.msf.core.x.d.c1() && com.tencent.mobileqq.msf.core.x.d.a(str) && this.f248014e) {
            return this.f248013d;
        }
        return this.f248012c;
    }

    public void a(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) eVar);
        } else {
            this.f248012c.a(eVar);
            this.f248013d.a(eVar);
        }
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) dVar);
        } else {
            this.f248012c.a(dVar);
            this.f248013d.a(dVar);
        }
    }
}
