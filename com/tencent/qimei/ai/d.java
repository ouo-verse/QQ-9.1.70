package com.tencent.qimei.ai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.al.a;
import com.tencent.qimei.as.a;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.report.beat.BeatType;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.uin.U;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d implements Runnable, com.tencent.qimei.s.b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final Map<String, d> f343006i;

    /* renamed from: j, reason: collision with root package name */
    public static Queue<Integer> f343007j;

    /* renamed from: a, reason: collision with root package name */
    public c f343008a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.s.c f343009b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f343010c;

    /* renamed from: d, reason: collision with root package name */
    public long f343011d;

    /* renamed from: e, reason: collision with root package name */
    public long f343012e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343013f;

    /* renamed from: g, reason: collision with root package name */
    public String f343014g;

    /* renamed from: h, reason: collision with root package name */
    public final b f343015h;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements b.a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f343017a;

        /* renamed from: b, reason: collision with root package name */
        public final a f343018b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f343019c;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        public interface a {
        }

        public b(int i3, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
                return;
            }
            this.f343019c = new AtomicInteger();
            this.f343017a = i3;
            this.f343018b = aVar;
        }

        public boolean a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            this.f343019c.getAndIncrement();
            if (this.f343019c.get() > this.f343017a) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f343019c.set(0);
                a aVar = this.f343018b;
                if (aVar != null) {
                    a aVar2 = (a) aVar;
                    if (!a.c.K.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(d.this.f343014g).f343094b.f343146r)).isEmpty()) {
                        d.this.f343013f = true;
                        com.tencent.qimei.t.a.a().a(10000L, d.this);
                    }
                }
            }
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16415);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343006i = new ConcurrentHashMap();
        }
    }

    public d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        new AtomicInteger();
        this.f343010c = new AtomicBoolean(false);
        this.f343013f = false;
        this.f343014g = "";
        this.f343015h = new b(3, new a());
        this.f343014g = str;
        f343007j = com.tencent.qimei.ab.d.a(3, 8);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f343010c.set(false);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.qimei.ai.b.a(this.f343014g).a(com.tencent.qimei.an.a.e(this.f343014g));
        Qimei qimei = com.tencent.qimei.ai.b.a(this.f343014g).f342995b;
        if (qimei != null && !qimei.isEmpty()) {
            Process.myPid();
            c();
        }
    }

    public final void c() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.qimei.ap.a aVar = new com.tencent.qimei.ap.a(this.f343014g);
        if (aVar.c() != null) {
            aVar.c().g();
        }
        com.tencent.qimei.s.c cVar = this.f343009b;
        if (cVar != null && (context = cVar.f343364b) != null) {
            try {
                context.unregisterReceiver(cVar);
                Process.myPid();
            } catch (IllegalArgumentException e16) {
                com.tencent.qimei.ad.c.a(e16);
            }
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"MissingPermission"})
    public void run() {
        boolean z16;
        long j3;
        String str;
        BeatType beatType;
        String str2;
        com.tencent.qimei.u.c cVar;
        byte a16;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        boolean z17 = false;
        if (this.f343010c.get()) {
            com.tencent.qimei.ad.c.b("QM", "QM is requesting,cancel this request(appKey: %s)", this.f343014g);
            return;
        }
        this.f343010c.set(true);
        if (!com.tencent.qimei.f.a.b()) {
            com.tencent.qimei.ad.c.b("QM", "no network,cancel QM request(appKey: %s)", this.f343014g);
            a();
            return;
        }
        if (!com.tencent.qimei.u.a.f()) {
            com.tencent.qimei.s.c cVar2 = new com.tencent.qimei.s.c(this);
            this.f343009b = cVar2;
            IntentFilter intentFilter = new IntentFilter(com.tencent.qimei.s.a.f343361a);
            Context context = cVar2.f343364b;
            if (context != null) {
                context.registerReceiver(cVar2, intentFilter);
                Process.myPid();
            }
            b();
            a();
            return;
        }
        this.f343011d = SystemClock.uptimeMillis();
        String a17 = com.tencent.qimei.ai.c.f343001a.a(this.f343014g);
        if (TextUtils.isEmpty(a17)) {
            com.tencent.qimei.ad.c.b("QM", "The parameter to get the QM request is empty, cancel the QM request(appKey: %s)", this.f343014g);
            String str4 = this.f343014g;
            com.tencent.qimei.ag.h a18 = com.tencent.qimei.ag.h.a();
            a18.getClass();
            com.tencent.qimei.ag.e eVar = new com.tencent.qimei.ag.e();
            eVar.f342975a.put("6", PluginJumpManager.CONFIG_BID);
            a18.a(eVar, "v2", str4);
            a();
            return;
        }
        this.f343012e = SystemClock.uptimeMillis();
        String str5 = this.f343014g;
        CMD cmd = CMD.REGISTER;
        com.tencent.qimei.x.c cVar3 = new com.tencent.qimei.x.c(U.a(str5, cmd.b(), a17, cmd.a()));
        if (cVar3.c()) {
            String a19 = cVar3.a();
            com.tencent.qimei.ad.c.b("QM", "(appKey: %s)QM response, %s", this.f343014g, a19);
            com.tencent.qimei.ai.b a26 = com.tencent.qimei.ai.b.a(this.f343014g);
            Qimei qimei = a26.f342995b;
            a26.a(com.tencent.qimei.an.a.a(this.f343014g, a19));
            Qimei qimei2 = a26.f342995b;
            boolean z18 = a26.f342999f;
            if (qimei != null && !qimei.isEmpty()) {
                String str6 = qimei.f343372b;
                String str7 = qimei.f343373c;
                if (str6 != null && str7 != null && (str6.isEmpty() || !str7.isEmpty())) {
                    String str8 = qimei2.f343372b;
                    String str9 = qimei2.f343373c;
                    if ((str8.isEmpty() || !str9.isEmpty()) && (!str6.equals(str8) || !str7.equals(str9))) {
                        String str10 = this.f343014g;
                        com.tencent.qimei.ag.h a27 = com.tencent.qimei.ag.h.a();
                        a27.getClass();
                        com.tencent.qimei.ag.e eVar2 = new com.tencent.qimei.ag.e();
                        eVar2.f342975a.put("6", str6);
                        eVar2.f342975a.put("7", str7);
                        eVar2.f342975a.put("8", str8);
                        eVar2.f342975a.put("9", str9);
                        if (z18) {
                            str3 = "1";
                        } else {
                            str3 = "0";
                        }
                        eVar2.f342975a.put("10", str3);
                        a27.a(eVar2, "v3", str10);
                    }
                }
            }
            Qimei qimei3 = com.tencent.qimei.ai.b.a(this.f343014g).f342995b;
            if (qimei3 == null || qimei3.isEmpty()) {
                String str11 = this.f343014g;
                com.tencent.qimei.ag.h a28 = com.tencent.qimei.ag.h.a();
                a28.getClass();
                com.tencent.qimei.ag.e eVar3 = new com.tencent.qimei.ag.e();
                eVar3.f342975a.put("6", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED);
                eVar3.f342975a.put("7", "200");
                a28.a(eVar3, "v2", str11);
            }
            com.tencent.qimei.ad.c.b("QM", "(appKey: %s)QM response, data decryption result: %s", this.f343014g, qimei2);
            Qimei qimei4 = a26.f342995b;
            if (qimei4 != null && !qimei4.isEmpty()) {
                c();
                String str12 = this.f343014g;
                if (com.tencent.qimei.u.a.f()) {
                    if (!a.C9307a.f343059a.f343058a) {
                        a16 = -1;
                    } else {
                        a16 = U.a(str12, a19);
                        if (a16 != 0) {
                            com.tencent.qimei.f.a.a(str12, a16);
                        }
                    }
                    if (a16 == 0) {
                        com.tencent.qimei.f.a.a(com.tencent.qimei.s.a.f343361a, com.tencent.qimei.u.a.d(), (Bundle) null);
                        com.tencent.qimei.aa.f.b(str12).a("q_s_t", System.currentTimeMillis());
                        com.tencent.qimei.ad.c.b("QM", "QM was successfully updated to local: %s (appKey: %s)", a19, str12);
                        if (TextUtils.isEmpty(com.tencent.qimei.aa.f.b(str12).d("is_first"))) {
                            com.tencent.qimei.aa.f.b(str12).a("is_first", "false");
                        }
                    }
                }
                j3 = 0;
                a26.f342997d = 0L;
                a26.f342996c = a26.b();
                com.tencent.qimei.aa.f.b(a26.f342994a).a(TtmlNode.TAG_TT, a26.f342996c);
                str = this.f343014g;
                beatType = BeatType.REGISTER;
                str2 = "0";
            } else {
                j3 = 0;
                str = this.f343014g;
                beatType = BeatType.REGISTER;
                str2 = "402";
            }
            com.tencent.qimei.ah.a.a(str, beatType, str2);
            a();
            if (com.tencent.qimei.an.b.f343085a.nextInt(101) <= a.b.A.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(this.f343014g).f343094b.f343146r)).intValue()) {
                z17 = true;
            }
            if (z17) {
                long uptimeMillis = SystemClock.uptimeMillis();
                long j16 = uptimeMillis - this.f343012e;
                long j17 = uptimeMillis - this.f343011d;
                synchronized (com.tencent.qimei.u.c.class) {
                    cVar = com.tencent.qimei.u.c.f343390p;
                }
                long j18 = cVar.f343393c;
                c cVar4 = this.f343008a;
                if (cVar4 != null) {
                    j3 = ((e) cVar4).f343030i;
                }
                String str13 = this.f343014g;
                com.tencent.qimei.ag.h a29 = com.tencent.qimei.ag.h.a();
                a29.getClass();
                com.tencent.qimei.ag.e eVar4 = new com.tencent.qimei.ag.e();
                eVar4.f342975a.put("6", String.valueOf(j16));
                eVar4.f342975a.put("7", String.valueOf(j17));
                eVar4.f342975a.put("8", String.valueOf(j18));
                eVar4.f342975a.put("9", String.valueOf(j3));
                a29.a(eVar4, "v1", str13);
                return;
            }
            return;
        }
        long j19 = 0;
        if (cVar3.f343427h) {
            String str14 = cVar3.f343424e;
            int i3 = cVar3.f343425f;
            String str15 = cVar3.f343426g;
            com.tencent.qimei.ad.c.a("QM", "onFailure msg: %s,%d,%s. Waiting next query.", str14, Integer.valueOf(i3), str15);
            b bVar = this.f343015h;
            if (bVar.f343019c.get() > bVar.f343017a - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String str16 = this.f343014g;
                String str17 = "1000";
                if (str14.equals("451")) {
                    str17 = "1001";
                }
                com.tencent.qimei.ag.h a36 = com.tencent.qimei.ag.h.a();
                a36.getClass();
                com.tencent.qimei.ag.e eVar5 = new com.tencent.qimei.ag.e();
                eVar5.f342975a.put("6", str17);
                eVar5.f342975a.put("7", "error code: " + i3 + ", msg:" + str15);
                a36.a(eVar5, "v2", str16);
            }
            a();
            if (this.f343013f) {
                this.f343013f = false;
            } else if (!this.f343015h.a()) {
                if (f343007j.peek() != null) {
                    j19 = f343007j.poll().longValue() * 1000;
                }
                com.tencent.qimei.t.a.a().a(j19, this);
            }
        }
        String b16 = cVar3.b();
        com.tencent.qimei.ah.a.a(this.f343014g, BeatType.REGISTER, b16);
        com.tencent.qimei.ad.c.a("QM", "register qm failed,response err code is %s", b16);
    }
}
