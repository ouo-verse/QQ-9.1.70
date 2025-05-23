package com.tencent.gamecenter.wadl.sdk.downloader.task.i;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.g;
import com.tencent.gamecenter.wadl.sdk.common.e.e;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr;
import com.tencent.gamecenter.wadl.sdk.downloader.a.e.f;
import com.tencent.gamecenter.wadl.sdk.downloader.c.b;
import com.tencent.gamecenter.wadl.sdk.downloader.task.k.a;
import com.tencent.mobileqq.haoliyou.JefsClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements Runnable, com.tencent.gamecenter.wadl.sdk.downloader.a.b, b.a {
    private volatile int A;
    private String B;
    c C;
    private long D;
    private volatile boolean E;
    private boolean F;

    /* renamed from: a, reason: collision with root package name */
    private boolean f107579a;

    /* renamed from: b, reason: collision with root package name */
    private int f107580b;

    /* renamed from: c, reason: collision with root package name */
    private DownloaderTaskAttr f107581c;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.gamecenter.wadl.sdk.downloader.task.k.b f107583e;

    /* renamed from: f, reason: collision with root package name */
    protected b f107584f;

    /* renamed from: h, reason: collision with root package name */
    public a f107586h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107587i;

    /* renamed from: j, reason: collision with root package name */
    protected Map<String, String> f107588j;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.a.d f107591m;

    /* renamed from: o, reason: collision with root package name */
    private List<com.tencent.gamecenter.wadl.sdk.downloader.c.b> f107593o;

    /* renamed from: p, reason: collision with root package name */
    private Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, com.tencent.gamecenter.wadl.sdk.downloader.c.b> f107594p;

    /* renamed from: q, reason: collision with root package name */
    private Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, List<String>> f107595q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.c.a f107596r;

    /* renamed from: u, reason: collision with root package name */
    private AtomicInteger f107599u;

    /* renamed from: v, reason: collision with root package name */
    private AtomicInteger f107600v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f107601w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f107602x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f107603y;

    /* renamed from: z, reason: collision with root package name */
    private int f107604z;

    /* renamed from: d, reason: collision with root package name */
    private boolean f107582d = false;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.downloader.a.d f107585g = null;

    /* renamed from: k, reason: collision with root package name */
    protected int f107589k = 0;

    /* renamed from: l, reason: collision with root package name */
    protected String f107590l = "";

    /* renamed from: n, reason: collision with root package name */
    private final byte[] f107592n = new byte[0];

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f107597s = false;

    /* renamed from: t, reason: collision with root package name */
    public volatile boolean f107598t = false;

    public d(int i3, com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar, boolean z16, b bVar2, Map<String, String> map, @NotNull DownloaderTaskAttr downloaderTaskAttr, String str) {
        boolean z17;
        boolean z18;
        boolean z19;
        this.f107579a = true;
        this.f107588j = null;
        if (g.a("down_hijack_feature_enable", 0, 1, 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f107601w = z17;
        if (g.a("down_hijack_size_enable", 0, 1, 1) == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.f107602x = z18;
        if (g.a("down_hijack_force_feature", 0, 1, 0) == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f107603y = z19;
        this.f107604z = g.a("hijack_failed_cnt_switch_https", 0, 20, 3);
        this.C = new c();
        this.E = true;
        this.F = false;
        this.f107580b = i3;
        this.f107583e = bVar;
        this.f107579a = z16;
        this.f107584f = bVar2;
        this.f107588j = map;
        this.f107581c = downloaderTaskAttr;
        this.B = str;
    }

    private boolean A() {
        if (this.C.f107578l) {
            return false;
        }
        b(true);
        if (this.C.f107578l) {
            return false;
        }
        if (this.f107589k == -53 && !this.f107584f.a()) {
            b(false);
        }
        return true;
    }

    private void B() {
        int a16 = g.a("down_res_sche_timeout", 1000, 60000, 15000);
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "socketSchedule timeout=" + a16);
        this.f107583e.a(a16);
    }

    private void C() {
        boolean z16;
        StringBuilder sb5;
        String str;
        if (this.f107598t) {
            this.C.f107568b = true;
            this.f107598t = false;
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-SectionTransport", "switchUrlIfNeed isDirectDownload=" + this.f107579a + ",switchUrlForHijackHappened");
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.C.f107568b) {
            this.f107587i = this.f107583e.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), this.f107587i, this.f107579a, false, z16, o(), this.f107582d);
            if (g.a("down_use_https", 0, 1, 1) != 1 && this.f107587i.f107609b == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https) {
                this.f107587i = this.f107583e.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), this.f107587i, this.f107579a, true, z16, false, this.f107582d);
            }
            sb5 = new StringBuilder();
            sb5.append("switchUrlIfNeed isDirectDownload=");
            sb5.append(this.f107579a);
            str = " switch url... type=";
        } else if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(this.f107587i.f107609b)) {
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a16 = this.f107583e.a(this.f107587i.f107609b);
            if (a16 != null) {
                this.f107587i = a16;
            }
            sb5 = new StringBuilder();
            sb5.append("switchUrlIfNeed isDirectDownload=");
            sb5.append(this.f107579a);
            str = " switch for domain to url... type=";
        } else {
            sb5 = new StringBuilder();
            sb5.append("switchUrlIfNeed isDirectDownload=");
            sb5.append(this.f107579a);
            str = " do not switch...type=";
        }
        sb5.append(str);
        sb5.append(this.f107587i.f107609b);
        sb5.append(JefsClass.INDEX_URL);
        sb5.append(this.f107587i.f107608a);
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", sb5.toString());
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "currentUrl after ip link: " + this.f107587i.f107608a);
    }

    private void D() {
        if (b(this.f107587i)) {
            com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar = new com.tencent.gamecenter.wadl.sdk.downloader.c.b(this.f107583e, this.f107587i, this.f107593o, this, this.f107603y, this.f107600v, this.f107599u);
            synchronized (this.f107593o) {
                this.f107593o.add(bVar);
            }
            this.f107594p.put(this.f107587i, bVar);
            bVar.f107352q = this.D;
            bVar.f107343h = com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().d(bVar);
            bVar.a(!this.f107579a ? 1 : 0, this.A);
        }
    }

    private void c(boolean z16) {
        if (z16) {
            return;
        }
        try {
            if (this.f107581c.scheduleSwitch) {
                B();
            }
            if (this.f107581c.multiSection && this.f107602x && !this.C.f107577k) {
                this.f107596r.a(this.f107583e.f());
                this.C.f107577k = true;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void e() {
        this.f107591m = null;
        com.tencent.gamecenter.wadl.sdk.downloader.a.d dVar = this.f107585g;
        if (dVar != null) {
            dVar.e();
            this.f107585g = null;
        }
    }

    private void f() {
        this.C.f107576j = true;
        try {
            this.f107584f.a(this);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private boolean k() {
        this.f107597s = true;
        this.C.a(this.f107585g.a(this));
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "handleRequestSucc isDirectDownload=" + this.f107579a + ",section=" + this.f107586h);
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107587i;
        this.f107597s = false;
        aVar.f107613f = false;
        a(this.f107585g.g(), this.f107585g.getFailInfo());
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "handleRequestSucc isDirectDownload:" + this.f107579a + " readData retCode:" + this.f107589k + ",failInfo:" + this.f107590l);
        if (!this.f107598t) {
            z();
        }
        if (this.f107603y && this.f107599u.get() >= this.f107583e.c()) {
            this.f107589k = -75;
            return false;
        }
        if (this.f107589k != 0) {
            this.C.b();
        } else {
            this.C.a();
        }
        return true;
    }

    private boolean o() {
        int i3 = this.f107589k;
        if (i3 != 404 && i3 != -10 && i3 != -11 && i3 != -55 && this.f107599u.get() < this.f107604z) {
            return false;
        }
        return true;
    }

    private boolean p() {
        if (this.f107580b == 1 && com.tencent.gamecenter.wadl.sdk.downloader.manager.b.c().d()) {
            return true;
        }
        return false;
    }

    private boolean r() {
        if (this.f107580b == 2) {
            return true;
        }
        return false;
    }

    private boolean t() {
        if (!this.C.f107572f) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.C.f107570d > com.tencent.gamecenter.wadl.sdk.downloader.a.a.j()) {
            return true;
        }
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.c(this.f107589k) && elapsedRealtime - this.C.f107570d > com.tencent.gamecenter.wadl.sdk.downloader.a.a.i()) {
            return true;
        }
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.b(this.f107589k) && elapsedRealtime - this.C.f107570d > com.tencent.gamecenter.wadl.sdk.downloader.a.a.c()) {
            return true;
        }
        if (this.f107589k == -15 && elapsedRealtime - this.C.f107570d > com.tencent.gamecenter.wadl.sdk.downloader.a.a.d()) {
            return true;
        }
        if (this.f107589k != -51 || this.f107587i.f107609b != a.EnumC1136a.Type_CDN_Domain) {
            return false;
        }
        SystemClock.sleep(1000L);
        return true;
    }

    private boolean u() {
        boolean z16;
        com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar = this.f107594p.get(this.f107587i);
        if (bVar != null && bVar.f107340e && this.f107583e.g() > 0 && !bVar.f107342g) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.f107598t = true;
        }
        return z16;
    }

    private boolean v() {
        com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar = this.f107594p.get(this.f107587i);
        if (bVar != null && bVar.f107341f && !bVar.f107342g && this.f107596r.a(this.f107586h, bVar)) {
            this.f107598t = true;
            return true;
        }
        return false;
    }

    private void x() {
        com.tencent.gamecenter.wadl.sdk.downloader.a.d dVar;
        List<String> f16;
        boolean a16 = this.f107583e.a(false);
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "optHeaderSchedule isNeedSchedule=" + a16 + ",req=" + this.f107585g);
        if (a16 && (dVar = this.f107585g) != null && (f16 = dVar.f()) != null && f16.size() > 0) {
            if (g.a("down_use_jump_schedule", 0, 1, 1) == 1) {
                Iterator<String> it = f16.iterator();
                while (it.hasNext()) {
                    this.f107583e.a(com.tencent.gamecenter.wadl.sdk.common.b.c.b(), it.next(), a.EnumC1136a.Type_CDN_Ip_Http_Header);
                }
            }
            this.f107583e.b(false);
        }
    }

    private void y() {
        if (this.C.f107571e > 0) {
            synchronized (this.f107592n) {
                try {
                    this.f107592n.wait(this.C.f107571e);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    private void z() {
        List<String> list = this.f107595q.get(this.f107587i);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList());
            this.f107595q.put(this.f107587i, list);
        }
        if (this.f107586h.f107562f > this.f107586h.f107560d) {
            list.add(this.f107586h.f107560d + "," + this.f107586h.f107562f);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.c.b.a
    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a() {
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f107593o) {
                Iterator<com.tencent.gamecenter.wadl.sdk.downloader.c.b> it = this.f107593o.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f107338c);
                }
            }
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a16 = this.f107583e.a(arrayList, this.f107599u.get() >= this.f107604z);
            if (b(a16)) {
                com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar = new com.tencent.gamecenter.wadl.sdk.downloader.c.b(this.f107583e, a16, this.f107593o, this, this.f107603y, this.f107600v, this.f107599u);
                synchronized (this.f107593o) {
                    this.f107593o.add(bVar);
                }
                this.f107594p.put(a16, bVar);
                bVar.f107352q = this.D;
                bVar.f107336a = true;
                bVar.f107343h = com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().d(bVar);
            }
            return a16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void b() {
        com.tencent.gamecenter.wadl.sdk.downloader.a.d dVar = this.f107591m;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void d() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "cancel");
        try {
            this.C.f107578l = true;
            com.tencent.gamecenter.wadl.sdk.downloader.a.d dVar = this.f107591m;
            if (dVar != null) {
                dVar.d();
            }
            synchronized (this.f107592n) {
                this.f107592n.notifyAll();
            }
        } catch (Throwable unused) {
        }
    }

    public String g() {
        return this.f107590l;
    }

    public String h() {
        return this.B;
    }

    public int i() {
        return this.f107589k;
    }

    public int j() {
        return this.f107580b;
    }

    public boolean l() {
        return this.f107579a;
    }

    public boolean m() {
        return this.F;
    }

    public boolean n() {
        return this.C.f107576j;
    }

    public boolean q() {
        return this.f107582d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            this.C.a(this.f107583e.f107637k);
            if (!this.C.f107578l) {
                c(this.f107579a);
                if (this.C.f107578l || !c()) {
                    break;
                }
                y();
                if (this.C.f107578l) {
                    break;
                }
                this.C.c();
                C();
                com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "run isDirectDownload=" + this.f107579a + ",sectionRunInfo=" + this.C + ",currentUrl=" + this.f107587i.f107608a);
                this.f107587i.f107613f = true;
                if (!u()) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "[" + Thread.currentThread().getName() + "],get Next Task**************** sectionType:" + this.f107580b);
                    a c16 = this.f107584f.c(this);
                    this.f107586h = c16;
                    if (c16 == null) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "run section is empty");
                        break;
                    }
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "run nextSection=" + this.f107586h);
                    this.C.d();
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!A()) {
                            break;
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "isDirectDownload=" + this.f107579a + ",retCode=" + this.f107589k + ",costTime:" + elapsedRealtime2 + ",msg=" + this.f107590l);
                        c cVar = this.C;
                        cVar.f107572f = true;
                        int i3 = this.f107589k;
                        if (i3 != 0) {
                            cVar.a(i3, elapsedRealtime2, 10000L);
                        } else {
                            cVar.f107571e = 1000;
                            x();
                            if (this.C.f107578l) {
                                break;
                            }
                            e a16 = this.f107584f.a(this, this.f107587i, this.f107585g.b(), this.f107585g.h());
                            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-SectionTransport", "isDirectDownload=" + this.f107579a + " retInfo=" + a16);
                            if (a(a16)) {
                                break;
                            } else {
                                b(a16);
                            }
                        }
                        if (t()) {
                            break;
                        }
                        this.f107597s = false;
                        this.f107584f.b(this);
                        e();
                        c cVar2 = this.C;
                        cVar2.f107574h += cVar2.f107575i;
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            } else {
                break;
            }
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "Transport finish on retCode:" + this.f107589k + ",msg:" + this.f107590l);
        f();
    }

    public boolean s() {
        return this.C.f107578l;
    }

    public void w() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("P2PReq", "onDownloadTaskCompleted,transport:" + hashCode());
        this.F = true;
    }

    private void a(int i3, String str) {
        this.f107589k = i3;
        this.f107590l = str;
    }

    private void b(e eVar) {
        int i3 = eVar.f107237a;
        if (i3 >= 0) {
            this.C.a();
        } else {
            a(i3, eVar.f107238b);
            this.C.b();
        }
    }

    private boolean c() {
        return this.f107579a || this.f107581c.multiSection;
    }

    public void d(boolean z16) {
        this.f107582d = z16;
    }

    private void b(boolean z16) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.e.b bVar;
        com.tencent.gamecenter.wadl.sdk.downloader.a.d dVar;
        if (z16) {
            bVar = this.f107586h.a(this.C.f107569c ? com.tencent.gamecenter.wadl.sdk.downloader.a.a.g() : -1, this.f107584f.a());
        } else {
            bVar = null;
        }
        com.tencent.gamecenter.wadl.sdk.downloader.a.e.b bVar2 = bVar;
        if (p()) {
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107587i;
            dVar = new f(aVar, this.f107588j, bVar2, this.C.f107569c, aVar.f107611d, this.f107583e, 1, this.B);
        } else if (r()) {
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar2 = this.f107587i;
            dVar = new com.tencent.gamecenter.wadl.sdk.downloader.a.e.g(aVar2, this.f107588j, bVar2, this.C.f107569c, aVar2.f107611d, this.f107583e, 1, this.B, this);
        } else {
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar3 = this.f107587i;
            dVar = new com.tencent.gamecenter.wadl.sdk.downloader.a.e.d(aVar3, this.f107588j, bVar2, this.C.f107569c, aVar3.f107611d, this.f107583e, 1, this.B);
        }
        this.f107585g = dVar;
        this.f107591m = this.f107585g;
        this.A++;
        this.f107585g.a();
        this.f107589k = this.f107585g.g();
        this.f107590l = this.f107585g.getFailInfo();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.c.b.a
    public void a(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
        com.tencent.gamecenter.wadl.sdk.downloader.c.b bVar = this.f107594p.get(aVar);
        if (bVar == null || bVar.f107342g) {
            return;
        }
        this.f107596r.a(aVar, bVar);
    }

    private boolean b(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
        List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> d16;
        return this.f107583e.f() > 0 && (d16 = this.f107583e.d()) != null && d16.size() > 0 && !TextUtils.isEmpty(this.f107583e.e()) && aVar != null && this.f107594p.get(aVar) == null && this.E && this.f107581c.multiSection && this.f107601w;
    }

    public void a(List<com.tencent.gamecenter.wadl.sdk.downloader.c.b> list, Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, com.tencent.gamecenter.wadl.sdk.downloader.c.b> map, Map<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a, List<String>> map2, com.tencent.gamecenter.wadl.sdk.downloader.c.a aVar, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, long j3) {
        this.f107593o = list;
        this.f107594p = map;
        this.f107595q = map2;
        this.f107596r = aVar;
        this.f107599u = atomicInteger;
        this.f107600v = atomicInteger2;
        this.D = j3;
    }

    public void a(boolean z16) {
        this.E = z16;
    }

    private boolean a(e eVar) {
        return this.C.f107578l || (eVar.f107237a == 0 && !k());
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.b
    public boolean a(byte[] bArr, int i3, boolean z16) {
        if (z16) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "is direct:" + this.f107579a + ",onReceiveData...len:" + i3 + ",section:" + this.f107586h);
        }
        D();
        boolean z17 = false;
        if (v()) {
            return false;
        }
        boolean z18 = true;
        if (this.f107584f != null) {
            if (this.f107586h.f107562f + i3 >= this.f107586h.f107563g) {
                i3 = (int) (this.f107586h.f107563g - this.f107586h.f107562f);
            } else {
                z17 = true;
            }
            z18 = z17 & this.f107584f.a(this, this.f107586h.f107562f, bArr, i3, z16);
            if (!z18) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-SectionTransport", "is direct:" + this.f107579a + ",stop read data...len:" + i3 + ",section:" + this.f107586h);
            }
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-SectionTransport", "listener in Ant is null.");
        }
        return z18;
    }
}
