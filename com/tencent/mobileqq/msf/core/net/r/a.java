package com.tencent.mobileqq.msf.core.net.r;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f248949a = "AdaptorController";

    /* renamed from: b, reason: collision with root package name */
    private static int f248950b = -2;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f248951c = true;

    /* renamed from: d, reason: collision with root package name */
    private static int f248952d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static HandlerThreadC8087a f248953e = null;

    /* renamed from: f, reason: collision with root package name */
    private static Handler f248954f = null;

    /* renamed from: g, reason: collision with root package name */
    private static volatile AtomicBoolean f248955g = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f248956h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f248957i = false;

    /* renamed from: j, reason: collision with root package name */
    private static int f248958j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static final int f248959k = 18;

    /* renamed from: l, reason: collision with root package name */
    private static final int f248960l = 19;

    /* renamed from: m, reason: collision with root package name */
    private static final int f248961m = 20;

    /* renamed from: n, reason: collision with root package name */
    private static final int f248962n = 21;

    /* renamed from: o, reason: collision with root package name */
    public static final String f248963o = "foreground";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248964p = "screenon";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248965q = "kicked";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248966r = "disconnect";

    /* renamed from: s, reason: collision with root package name */
    public static final String f248967s = "exception";

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.r.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    static class HandlerThreadC8087a extends BaseHandlerThread implements Handler.Callback {
        static IPatchRedirector $redirector_;

        public HandlerThreadC8087a(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            QLog.d(a.f248949a, 1, "recv msg event " + i3);
            try {
                switch (i3) {
                    case 18:
                        if (a.f248950b == 2) {
                            QLog.d(a.f248949a, 1, "test heartbeat count:" + a.f248952d + ", fore:" + a.f248951c + ", mobile:" + NetConnInfoCenter.isMobileConn());
                            if (((a.f248952d != 0 || a.f248951c) && !a.f248956h) || !NetConnInfoCenter.isMobileConn()) {
                                int unused = a.f248952d = 0;
                                a.f248955g.set(false);
                                if (!a.f248951c) {
                                    a.f248954f.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.x.b.v1());
                                    break;
                                }
                            } else {
                                QLog.d(a.f248949a, 1, "testing heartbeat response");
                                if (!b.a()) {
                                    int unused2 = a.f248952d = 0;
                                    a.f248955g.set(false);
                                    QLog.d(a.f248949a, 1, "encap heartbeat failed");
                                    break;
                                } else {
                                    a.f248954f.sendEmptyMessageDelayed(19, 35000L);
                                    break;
                                }
                            }
                        }
                        break;
                    case 19:
                        if (a.f248950b == 2) {
                            if (b.d()) {
                                QLog.d(a.f248949a, 1, "test heartbeat response failed");
                                a.f248958j++;
                                if (a.f248958j <= com.tencent.mobileqq.msf.core.x.b.s1()) {
                                    QLog.d(a.f248949a, 1, "test heartbeat retry");
                                    a.f248954f.sendEmptyMessageDelayed(18, 30000L);
                                    break;
                                } else {
                                    QLog.d(a.f248949a, 1, "test heartbeat response limit " + a.f248958j);
                                    int unused3 = a.f248952d = 0;
                                    a.f248955g.set(false);
                                    break;
                                }
                            } else {
                                QLog.d(a.f248949a, 1, "test heartbeat response succ");
                                break;
                            }
                        }
                        break;
                    case 20:
                        if (a.f248950b == 2 || a.f248950b == 1) {
                            QLog.d(a.f248949a, 1, "start to report adaptor event");
                            try {
                                a.p();
                                a.o();
                                a.f248954f.sendEmptyMessageDelayed(20, 72000000L);
                                boolean unused4 = a.f248957i = true;
                                break;
                            } catch (Exception e16) {
                                QLog.d(a.f248949a, 1, "failed to report", e16);
                                break;
                            }
                        }
                        break;
                    case 21:
                        if (a.f248950b == 2 || a.f248950b == 1) {
                            QLog.d(a.f248949a, 1, "start to report adaptor event");
                            try {
                                a.p();
                                break;
                            } catch (Exception e17) {
                                QLog.d(a.f248949a, 1, "failed to report", e17);
                                break;
                            }
                        }
                        break;
                }
            } catch (Exception e18) {
                QLog.d(a.f248949a, 1, "process action " + i3 + " failed " + e18.toString());
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f248955g = new AtomicBoolean(false);
        f248956h = false;
        f248957i = false;
        f248958j = 0;
    }

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        HandlerThreadC8087a handlerThreadC8087a = new HandlerThreadC8087a("controllerthread");
        f248953e = handlerThreadC8087a;
        handlerThreadC8087a.start();
        f248954f = new Handler(f248953e.getLooper(), f248953e);
        f248951c = true;
        f248952d = 0;
        f248955g = new AtomicBoolean(false);
        f248957i = false;
        f248950b = i3;
    }

    public static void h() {
        try {
            QLog.d(f248949a, 1, "connection established");
            if (f248950b == 2 && NetConnInfoCenter.isMobileConn()) {
                if ((!f248951c || f248956h) && !b.f248972e && f248955g.compareAndSet(false, true)) {
                    f248958j = 0;
                    f248952d = 0;
                    if (!f248954f.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.x.b.v1())) {
                        QLog.d(f248949a, 1, "failed to add msg testHeartbeat");
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to process onConnect event " + e16.toString());
        }
    }

    public static void i() {
        f248954f.removeMessages(19);
        f248954f.removeMessages(18);
        f248955g.set(false);
        f248952d = 0;
        f248958j = 0;
    }

    public static void n() {
        try {
            int i3 = f248950b;
            if (i3 == 2 || i3 == 1) {
                f248954f.sendEmptyMessage(21);
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to report at once ", e16);
        }
    }

    public static void o() {
        String a16;
        try {
            com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
            if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
                return;
            }
            t j3 = ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j();
            int i3 = f248950b;
            if (i3 == 2) {
                String a17 = j3.f250097v.b().a(515);
                if (a17 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("heartbeat", a17);
                    if (MsfService.getCore().getStatReporter() != null) {
                        MsfService.getCore().getStatReporter().a(g.f247712l0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                }
            } else if (i3 == 1 && (a16 = j3.f250097v.b().a(515)) != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("heartbeat", a16);
                if (MsfService.getCore().getStatReporter() != null) {
                    MsfService.getCore().getStatReporter().a(g.f247724o0, false, 0L, 0L, (Map<String, String>) hashMap2, false, false);
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to report heartbeat " + e16.toString());
        }
    }

    public static void p() {
        try {
            com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
            if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
                return;
            }
            t j3 = ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j();
            int i3 = f248950b;
            if (i3 == 2) {
                String a16 = j3.f250097v.b().a(513);
                if (a16 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("report", a16);
                    if (MsfService.core.getStatReporter() != null) {
                        MsfService.core.getStatReporter().a(g.f247700i0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                }
                String a17 = j3.f250097v.b().a(516);
                if (a16 != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("reportExTimeout", a17);
                    if (MsfService.core.getStatReporter() != null) {
                        MsfService.core.getStatReporter().a(g.f247704j0, true, 0L, 0L, (Map<String, String>) hashMap2, false, false);
                    }
                }
                String a18 = j3.f250097v.b().a(514);
                if (a18 != null) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("except", a18);
                    if (MsfService.getCore().getStatReporter() != null) {
                        MsfService.getCore().getStatReporter().a(g.f247708k0, true, 0L, 0L, (Map<String, String>) hashMap3, false, false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 == 1) {
                String a19 = j3.f250097v.b().a(513);
                if (a19 != null) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("report", a19);
                    if (MsfService.core.getStatReporter() != null) {
                        MsfService.core.getStatReporter().a(g.f247716m0, false, 0L, 0L, (Map<String, String>) hashMap4, false, false);
                    }
                }
                String a26 = j3.f250097v.b().a(516);
                if (a19 != null) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("reportExTimeout", a26);
                    if (MsfService.core.getStatReporter() != null) {
                        MsfService.core.getStatReporter().a(g.f247720n0, false, 0L, 0L, (Map<String, String>) hashMap5, false, false);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to report sending " + e16.toString());
        }
    }

    public static void q() {
        QLog.d(f248949a, 1, "reset current mode: " + f248950b);
        try {
            a("exception");
            com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
            if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
                return;
            }
            ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j().f250097v.d();
            f248950b = f.f249013d;
            f248955g.set(false);
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to reset mode", e16);
        }
    }

    public static boolean r() {
        try {
            if (f248950b == 2) {
                QLog.d(f248949a, 1, "resume heartbeat");
                b.f248972e = true;
                com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
                if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
                    return false;
                }
                ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j().f250097v.b().a(152, true);
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to resume heartbeat " + e16.toString());
        }
        return true;
    }

    public static void s() {
        com.tencent.mobileqq.msf.core.f0.a msfNetService;
        QLog.d(f248949a, 1, "resume current mode: " + f248950b);
        try {
            msfNetService = MsfService.core.getMsfNetService();
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to resume mode", e16);
        }
        if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
            return;
        }
        ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j().f250097v.e();
        f248950b = f.f249013d;
    }

    public static boolean t() {
        try {
            if (f248950b == 2) {
                f248955g.set(false);
                QLog.d(f248949a, 1, "maincount: " + f248952d + ", fore: " + f248951c + ", mobile: " + NetConnInfoCenter.isMobileConn() + ", screenoff: " + f248956h);
                if (((f248952d <= 0 && !f248951c) || f248956h) && NetConnInfoCenter.isMobileConn()) {
                    com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
                    if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
                        return false;
                    }
                    t j3 = ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j();
                    if (j3.f250097v.b().a(156).equals("false")) {
                        QLog.d(f248949a, 1, "native switch closed");
                        return false;
                    }
                    if (b.f248972e) {
                        QLog.d(f248949a, 1, "already in proxy heartbeat, return");
                        return true;
                    }
                    if (j3.f250097v.b().a(151, true)) {
                        QLog.d(f248949a, 1, "set heartbeat proxy");
                        if (!r()) {
                            QLog.d(f248949a, 1, "resume heartbeat failed");
                            return false;
                        }
                        b.f248972e = true;
                        MsfService.getCore().pushManager.c(1500000L);
                    } else {
                        QLog.d(f248949a, 1, "failed to set heartbeat proxy");
                    }
                }
                QLog.d(f248949a, 1, "condition check failed");
                return false;
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to set heartbeat proxy " + e16.toString());
        }
        return true;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d(f248949a, 1, "main process enter background inMode:" + f248950b + ", mobile:" + NetConnInfoCenter.isMobileConn() + " ,inproxy:" + b.f248972e + ", enterprocess:" + f248955g);
        try {
            if (f248950b == 2 && NetConnInfoCenter.isMobileConn()) {
                f248951c = false;
                f248952d++;
                if (!b.f248972e && f248955g.compareAndSet(false, true)) {
                    f248952d = 0;
                    if (!f248954f.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.x.b.v1())) {
                        QLog.d(f248949a, 1, "failed to add msg testHeartbeat");
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to process background event " + e16.toString());
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d(f248949a, 1, "main process enter foreground inproxy:" + b.f248972e);
        try {
            if (f248950b == 2) {
                if (true == b.f248972e) {
                    a(f248963o);
                }
                f248951c = true;
                f248952d++;
                if (!f248957i) {
                    f248954f.sendEmptyMessageDelayed(20, 3600000L);
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to process foreground event " + e16.toString());
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d(f248949a, 1, "receive screen on msg inproxy:" + b.f248972e);
        try {
            if (f248950b == 2) {
                f248956h = false;
                if (true == b.f248972e && f248951c) {
                    a(f248964p);
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to process screenoff event " + e16.toString());
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(f248949a, 1, "receive screen off msg inMode:" + f248950b + ", mobile:" + NetConnInfoCenter.isMobileConn() + " ,inproxy:" + b.f248972e + ", enterprocess:" + f248955g);
        try {
            if (f248950b == 2 && NetConnInfoCenter.isMobileConn() && !b.f248972e && f248955g.compareAndSet(false, true)) {
                f248956h = true;
                if (!f248954f.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.x.b.v1())) {
                    QLog.d(f248949a, 1, "failed to add msg testHeartbeat");
                }
            }
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to process screenoff event " + e16.toString());
        }
    }

    public static boolean a(String str) {
        try {
        } catch (Exception e16) {
            QLog.d(f248949a, 1, "failed to pause heartbeat " + e16.toString());
        }
        if (f248950b != 2 || !b.f248972e) {
            return true;
        }
        com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
        if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
            return false;
        }
        if (!((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j().f250097v.b().a(153, true)) {
            QLog.d(f248949a, 1, "failed to pause heartbeat");
        }
        b.f248972e = false;
        QLog.d(f248949a, 1, "pause heartbeat proxy " + str);
        MsfService.getCore().pushManager.c(MiniBoxNoticeInfo.MIN_5);
        return true;
    }
}
