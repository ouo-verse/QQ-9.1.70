package com.tencent.halley.downloader.task.section;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.downloader.a.a.d;
import com.tencent.halley.downloader.a.a.e;
import com.tencent.halley.downloader.b.c;
import com.tencent.halley.downloader.c.c;
import com.tencent.halley.downloader.c.g;
import com.tencent.halley.downloader.f.a;
import com.tencent.halley.downloader.task.c.b;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.halley.downloader.task.d.b;
import com.tencent.halley.downloader.task.section.DataSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements com.tencent.halley.downloader.a.a.c, com.tencent.halley.downloader.a.c, c.a, Runnable {
    static IPatchRedirector $redirector_;
    private long A;
    private boolean B;
    private List<com.tencent.halley.downloader.b.c> C;
    private Map<com.tencent.halley.downloader.task.d.a, com.tencent.halley.downloader.b.c> D;
    private Map<com.tencent.halley.downloader.task.d.a, List<String>> E;
    private com.tencent.halley.downloader.b.a F;
    private AtomicInteger G;
    private AtomicInteger H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;

    /* renamed from: a, reason: collision with root package name */
    public DataSection f113945a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.halley.downloader.task.d.a f113946b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f113947c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f113948d;

    /* renamed from: e, reason: collision with root package name */
    public String f113949e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.halley.downloader.a.c f113950f;

    /* renamed from: g, reason: collision with root package name */
    protected com.tencent.halley.downloader.task.section.a f113951g;

    /* renamed from: h, reason: collision with root package name */
    protected Map<String, String> f113952h;

    /* renamed from: i, reason: collision with root package name */
    protected int f113953i;

    /* renamed from: j, reason: collision with root package name */
    protected String f113954j;

    /* renamed from: k, reason: collision with root package name */
    boolean f113955k;

    /* renamed from: l, reason: collision with root package name */
    boolean f113956l;

    /* renamed from: m, reason: collision with root package name */
    public d f113957m;

    /* renamed from: n, reason: collision with root package name */
    public volatile int f113958n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f113959o;

    /* renamed from: p, reason: collision with root package name */
    boolean f113960p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.halley.downloader.task.d.b f113961q;

    /* renamed from: r, reason: collision with root package name */
    private e f113962r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f113963s;

    /* renamed from: t, reason: collision with root package name */
    private Object f113964t;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.halley.downloader.task.c.b f113965u;

    /* renamed from: v, reason: collision with root package name */
    private String f113966v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f113967w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f113968x;

    /* renamed from: y, reason: collision with root package name */
    private String f113969y;

    /* renamed from: z, reason: collision with root package name */
    private volatile int f113970z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f113971a;

        /* renamed from: b, reason: collision with root package name */
        public long f113972b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f113973c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f113974d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f113975e;

        /* renamed from: f, reason: collision with root package name */
        public int f113976f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
        }

        /* synthetic */ a(b bVar, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, bVar, Byte.valueOf(b16));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.section.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1251b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.halley.downloader.task.d.a f113978a;

        /* renamed from: b, reason: collision with root package name */
        public String f113979b;

        /* renamed from: c, reason: collision with root package name */
        public long f113980c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f113981d;

        /* renamed from: e, reason: collision with root package name */
        public String f113982e;

        /* renamed from: f, reason: collision with root package name */
        public String f113983f;

        /* renamed from: g, reason: collision with root package name */
        public String f113984g;

        /* renamed from: h, reason: collision with root package name */
        public String f113985h;

        /* renamed from: i, reason: collision with root package name */
        public String f113986i;

        /* renamed from: j, reason: collision with root package name */
        public Map<String, List<String>> f113987j;

        public C1251b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    public b(com.tencent.halley.downloader.task.d.b bVar, boolean z16, com.tencent.halley.downloader.a.c cVar, com.tencent.halley.downloader.task.section.a aVar, Map<String, String> map, boolean z17) {
        boolean z18;
        boolean z19;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, Boolean.valueOf(z16), cVar, aVar, map, Boolean.valueOf(z17));
            return;
        }
        this.f113947c = false;
        this.f113948d = false;
        this.f113949e = null;
        this.f113952h = null;
        this.f113953i = 0;
        this.f113954j = "";
        this.f113955k = true;
        this.f113962r = null;
        this.f113963s = false;
        this.f113956l = false;
        this.f113964t = new Object();
        this.f113965u = new com.tencent.halley.downloader.task.c.b();
        this.f113967w = true;
        this.f113968x = false;
        this.f113969y = "";
        this.f113959o = true;
        this.f113960p = false;
        this.B = false;
        if (h.a("down_hijack_feature_enable", 0, 1, 1) == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.I = z18;
        if (h.a("down_hijack_size_enable", 0, 1, 1) == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.J = z19;
        this.K = h.a("down_hijack_force_feature", 0, 1, 0) == 1;
        this.L = h.a("hijack_failed_cnt_switch_https", 0, 20, 3);
        this.f113961q = bVar;
        this.f113955k = z16;
        this.f113965u.f113856a = z16;
        if (z16) {
            str = "download-direct";
        } else {
            str = "download-sche";
        }
        this.f113969y = str;
        this.f113950f = cVar;
        this.f113951g = aVar;
        this.f113952h = map;
        this.f113967w = z17;
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.f113970z = i3;
        e eVar = this.f113962r;
        if (eVar != null) {
            eVar.a(i3);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            this.f113963s = true;
            d dVar = this.f113957m;
            if (dVar != null) {
                dVar.a();
            }
            synchronized (this.f113964t) {
                this.f113964t.notifyAll();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f113953i : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
    }

    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f113954j : (String) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        try {
            d dVar = this.f113957m;
            if (dVar != null) {
                return ((com.tencent.halley.downloader.a.a.a) dVar).h();
            }
            return "";
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.halley.downloader.task.c.b bVar = this.f113965u;
        if (bVar != null) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<b.a> it = bVar.f113861f.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(";");
            }
            return sb5.toString();
        }
        return "";
    }

    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        com.tencent.halley.downloader.task.c.b bVar = this.f113965u;
        if (bVar != null) {
            return bVar.toString();
        }
        return "";
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.B = true;
        com.tencent.halley.common.utils.d.c("DualNetworkManager", "setThisThreadOpenDual, isMultiTheadDownOpen=" + g.a().f113697a + "; isOptDownload=" + this.f113960p + "; isDirectDownload=" + this.f113955k);
    }

    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(!this.f113955k ? 1 : 0);
        sb5.append(sb6.toString());
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(this.f113966v);
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        StringBuilder sb7 = new StringBuilder();
        sb7.append(this.f113953i);
        sb5.append(sb7.toString());
        sb5.append(",");
        sb5.append(",");
        sb5.append(",");
        sb5.append(";");
        return sb5.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z16;
        com.tencent.halley.downloader.c.c cVar;
        boolean z17;
        String str;
        StringBuilder sb5;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f113965u.f113857b = System.currentTimeMillis();
            a aVar = new a(this, (byte) 0);
            aVar.f113973c = true;
            aVar.f113975e = true;
            aVar.f113974d = false;
            aVar.f113972b = 0L;
            aVar.f113971a = SystemClock.elapsedRealtime();
            aVar.f113976f = 0;
            boolean z18 = false;
            while (true) {
                if (this.f113961q.f113915f && !z18) {
                    aVar.f113973c = true;
                    z16 = true;
                } else {
                    z16 = z18;
                }
                if (a()) {
                    break;
                }
                if (!this.f113955k) {
                    try {
                        boolean z19 = com.tencent.halley.downloader.c.h.a().f113703a;
                        cVar = c.a.f113689a;
                        boolean z26 = cVar.f113688b;
                        if (z19) {
                            if (!z26) {
                                int a16 = h.a("down_res_sche_timeout", 1000, 60000, 15000);
                                com.tencent.halley.downloader.task.d.b bVar = this.f113961q;
                                if (bVar.f113920k == -1) {
                                    bVar.f113920k = SystemClock.elapsedRealtime();
                                }
                                if (bVar.a(true)) {
                                    CountDownLatch countDownLatch = new CountDownLatch(1);
                                    b.C1250b c1250b = new b.C1250b(countDownLatch);
                                    com.tencent.halley.common.utils.d.c("halley-downloader-DownloadUrlMgr", "start resSchedule url:" + bVar.f113911b.f113890c);
                                    com.tencent.halley.downloader.e.c.a(bVar.f113911b.f113890c, bVar.f113919j, c1250b, a16, !bVar.f113915f);
                                    try {
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        countDownLatch.await(20000L, TimeUnit.MILLISECONDS);
                                        com.tencent.halley.common.utils.d.b("halley-downloader-DownloadUrlMgr", "resSchedule time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                                    } catch (InterruptedException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            } else {
                                this.f113961q.f113915f = true;
                            }
                        }
                        if (this.f113967w && this.J && !this.f113968x) {
                            this.F.a(this.f113961q.f113918i);
                            this.f113968x = true;
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (a()) {
                    break;
                }
                if ((this.f113955k || this.f113967w) ? false : true) {
                    break;
                }
                if (aVar.f113976f > 0) {
                    synchronized (this.f113964t) {
                        try {
                            this.f113964t.wait(aVar.f113976f);
                        } catch (InterruptedException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
                if (a()) {
                    break;
                }
                if (aVar.f113972b == 0) {
                    aVar.f113972b = SystemClock.elapsedRealtime();
                }
                if (this.f113948d) {
                    aVar.f113973c = true;
                    this.f113948d = false;
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (aVar.f113973c) {
                    int i3 = this.f113953i;
                    this.f113946b = this.f113961q.a(com.tencent.halley.common.a.c.b(), this.f113946b, this.f113955k, false, z17, i3 == 404 || i3 == -10 || i3 == -11 || i3 == -55 || this.G.get() >= this.L, this.f113960p);
                    if (h.a("down_use_https", 0, 1, 1) != 1 && this.f113946b.f113891d == a.EnumC1249a.f113905j) {
                        this.f113946b = this.f113961q.a(com.tencent.halley.common.a.c.b(), this.f113946b, this.f113955k, true, z17, false, this.f113960p);
                    }
                    str = "halley-downloader-SectionTransport";
                    sb5 = new StringBuilder("Direct:");
                    sb5.append(this.f113955k);
                    str2 = " switch url... type:";
                } else {
                    a.EnumC1249a enumC1249a = this.f113946b.f113891d;
                    a.EnumC1249a enumC1249a2 = a.EnumC1249a.f113897b;
                    if (enumC1249a == enumC1249a2 || enumC1249a == a.EnumC1249a.f113896a || enumC1249a == a.EnumC1249a.f113902g) {
                        b.a a17 = this.f113961q.a(com.tencent.halley.common.a.c.b());
                        com.tencent.halley.downloader.task.d.a aVar2 = a17 == null ? null : (enumC1249a == enumC1249a2 || enumC1249a == a.EnumC1249a.f113896a) ? a17.f113928c : a17.f113929d;
                        if (aVar2 != null) {
                            this.f113946b = aVar2;
                        }
                        str = "halley-downloader-SectionTransport";
                        sb5 = new StringBuilder("Direct:");
                        sb5.append(this.f113955k);
                        str2 = " switch for domain to url... type:";
                    } else {
                        str = "halley-downloader-SectionTransport";
                        sb5 = new StringBuilder("Direct:");
                        sb5.append(this.f113955k);
                        str2 = " do not switch...type:";
                    }
                }
                sb5.append(str2);
                sb5.append(this.f113946b.f113891d);
                sb5.append(",url:");
                sb5.append(this.f113946b.f113890c);
                com.tencent.halley.common.utils.d.b(str, sb5.toString());
                com.tencent.halley.common.utils.d.c("currentUrl", "currentUrl after: " + this.f113946b.f113890c);
                this.f113946b.f113895h = true;
                com.tencent.halley.common.utils.d.c("halley-downloader-SectionTransport", " currentUrl = " + this.f113946b.f113890c + " transportModel.isNeedSwitchUrl = " + aVar.f113973c);
                com.tencent.halley.downloader.b.c cVar2 = this.D.get(this.f113946b);
                if (cVar2 != null && cVar2.f113629c && this.f113961q.b() > 0 && !cVar2.f113631e) {
                    this.f113948d = true;
                } else {
                    DataSection a18 = this.f113951g.a(this);
                    this.f113945a = a18;
                    if (a18 == null || a(aVar)) {
                        break;
                    }
                }
                z18 = z16;
            }
            com.tencent.halley.common.utils.d.d("halley-downloader-SectionTransport", "Transport finish on retCode:" + this.f113953i + ",msg:" + this.f113954j);
            this.f113956l = true;
            this.f113965u.f113858c = System.currentTimeMillis() - this.f113965u.f113857b;
            try {
                this.f113951g.c(this);
                return;
            } catch (Throwable th6) {
                th6.printStackTrace();
                return;
            }
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    private void a(com.tencent.halley.downloader.a.a.a aVar) {
        List<String> list;
        if (aVar == null || (list = aVar.f113610z) == null || list.size() <= 0) {
            return;
        }
        if (h.a("down_use_jump_schedule", 0, 1, 1) == 1) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f113961q.a(com.tencent.halley.common.a.c.b(), it.next(), a.EnumC1249a.f113900e);
            }
        }
        this.f113961q.b(false);
    }

    private static boolean b(int i3) {
        return i3 == -16 || i3 == -15 || i3 == -77;
    }

    private static boolean c(int i3) {
        return i3 == 404;
    }

    private static boolean d(int i3) {
        return i3 == 304;
    }

    @Override // com.tencent.halley.downloader.b.c.a
    public final void a(com.tencent.halley.downloader.task.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.halley.downloader.b.c cVar = this.D.get(aVar);
        if (cVar == null || cVar.f113631e) {
            return;
        }
        this.F.a(aVar, cVar);
    }

    public final void a(List<com.tencent.halley.downloader.b.c> list, Map<com.tencent.halley.downloader.task.d.a, com.tencent.halley.downloader.b.c> map, Map<com.tencent.halley.downloader.task.d.a, List<String>> map2, com.tencent.halley.downloader.b.a aVar, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, list, map, map2, aVar, atomicInteger, atomicInteger2, Long.valueOf(j3));
            return;
        }
        this.C = list;
        this.D = map;
        this.E = map2;
        this.F = aVar;
        this.G = atomicInteger;
        this.H = atomicInteger2;
        this.A = j3;
    }

    @Override // com.tencent.halley.downloader.a.c
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f113963s) {
            return true;
        }
        com.tencent.halley.downloader.a.c cVar = this.f113950f;
        if (cVar != null) {
            return cVar.a();
        }
        com.tencent.halley.common.utils.d.e("halley-downloader-SectionTransport", "cancelChecker is null");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x057a A[Catch: all -> 0x05ef, TryCatch #1 {all -> 0x05ef, blocks: (B:3:0x000f, B:5:0x0013, B:7:0x0019, B:8:0x001b, B:10:0x001f, B:11:0x0025, B:19:0x00a0, B:26:0x00fa, B:28:0x015c, B:30:0x0164, B:39:0x019e, B:42:0x01d6, B:44:0x024e, B:47:0x027f, B:49:0x0288, B:51:0x028c, B:52:0x02b4, B:54:0x02ba, B:57:0x02ca, B:58:0x04ef, B:60:0x04f3, B:74:0x0508, B:76:0x0510, B:79:0x051e, B:81:0x0526, B:83:0x053c, B:100:0x0562, B:111:0x057a, B:114:0x0589, B:116:0x058f, B:119:0x059d, B:121:0x05a1, B:123:0x05a9, B:127:0x052e, B:131:0x02cf, B:133:0x02d5, B:136:0x02de, B:138:0x02e6, B:139:0x02ec, B:140:0x02f0, B:141:0x02c1, B:142:0x02f6, B:144:0x0301, B:145:0x0306, B:154:0x0310, B:157:0x037a, B:159:0x0380, B:162:0x0391, B:164:0x0410, B:165:0x0420, B:167:0x0424, B:169:0x0430, B:170:0x0440, B:172:0x044c, B:173:0x0469, B:175:0x046d, B:177:0x0483, B:178:0x048d, B:180:0x0497, B:181:0x0499, B:183:0x049d, B:185:0x04a5, B:189:0x04ad, B:192:0x04b3, B:194:0x04b7, B:197:0x04bb, B:198:0x041c, B:200:0x04c1, B:201:0x04cc), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0230 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x05d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(a aVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        try {
            if (aVar.f113974d && !com.tencent.halley.common.a.c.k()) {
                aVar.f113974d = false;
            }
            DataSection.a byteRange = this.f113945a.toByteRange(aVar.f113974d ? com.tencent.halley.downloader.a.a.d() : -1, this.f113951g.a());
            com.tencent.halley.common.utils.d.c("halley-downloader-SectionTransport", "handleSectionTransport currentUrl = " + this.f113946b.f113890c);
            com.tencent.halley.downloader.task.d.a aVar2 = this.f113946b;
            e eVar = new e(aVar2, this.f113952h, byteRange, aVar.f113974d, this, aVar2.f113893f, this.f113961q, 1, this.B);
            this.f113962r = eVar;
            eVar.a(this.f113970z);
            e eVar2 = this.f113962r;
            eVar2.A = this.f113949e;
            this.f113957m = eVar2;
            if (a()) {
                this.f113947c = false;
                this.f113951g.b(this);
                this.f113957m = null;
                e eVar3 = this.f113962r;
                if (eVar3 == null) {
                    return true;
                }
                this.f113966v = eVar3.g();
                this.f113962r.d();
                this.f113962r = null;
                return true;
            }
            com.tencent.halley.downloader.task.c.b bVar = this.f113965u;
            int i3 = bVar.f113859d;
            bVar.f113859d = i3 + 1;
            this.f113958n = i3;
            b.a aVar3 = new b.a(this.f113958n, this.f113946b);
            aVar3.f113865d = SystemClock.elapsedRealtime() - aVar.f113971a;
            aVar3.f113863b = aVar.f113974d;
            aVar3.f113864c = this.f113945a.toString();
            aVar3.f113868g = byteRange.toString();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f113962r.b();
            if (a()) {
                this.f113947c = false;
                this.f113951g.b(this);
                this.f113957m = null;
                e eVar4 = this.f113962r;
                if (eVar4 == null) {
                    return true;
                }
                this.f113966v = eVar4.g();
                this.f113962r.d();
                this.f113962r = null;
                return true;
            }
            this.f113953i = this.f113962r.e();
            this.f113954j = this.f113962r.f();
            long j3 = aVar.f113971a;
            aVar3.f113867f = this.f113953i;
            aVar3.f113866e = SystemClock.elapsedRealtime() - j3;
            e eVar5 = this.f113962r;
            aVar3.f113869h = eVar5.f113598n;
            aVar3.f113882u = eVar5.f113599o;
            aVar3.f113883v = eVar5.f113608x;
            aVar3.f113871j = eVar5.f113601q;
            aVar3.f113872k = eVar5.f113602r;
            aVar3.f113870i = eVar5.f113609y;
            aVar3.f113873l = eVar5.f113600p;
            aVar3.f113874m = eVar5.f113604t;
            aVar3.f113875n = eVar5.f113607w;
            aVar3.f113880s = eVar5.j();
            aVar3.f113881t = this.f113962r.i();
            aVar3.f113885x = this.f113962r.f113605u;
            this.f113965u.a(aVar3);
            if (this.f113953i == -53 && !this.f113951g.a()) {
                long j16 = aVar.f113971a;
                boolean z27 = aVar.f113974d;
                com.tencent.halley.downloader.task.d.a aVar4 = this.f113946b;
                e eVar6 = new e(aVar4, this.f113952h, null, z27, this, aVar4.f113893f, this.f113961q, 1, this.B);
                this.f113962r = eVar6;
                this.f113957m = eVar6;
                if (!a()) {
                    com.tencent.halley.downloader.task.c.b bVar2 = this.f113965u;
                    int i16 = bVar2.f113859d;
                    bVar2.f113859d = i16 + 1;
                    this.f113958n = i16;
                    b.a aVar5 = new b.a(this.f113958n, this.f113946b);
                    aVar5.f113865d = SystemClock.elapsedRealtime() - j16;
                    aVar5.f113863b = z27;
                    aVar5.f113864c = this.f113945a.toString();
                    aVar5.f113868g = "";
                    this.f113962r.b();
                    if (!a()) {
                        this.f113953i = this.f113962r.e();
                        this.f113954j = this.f113962r.f();
                        aVar5.f113866e = SystemClock.elapsedRealtime() - j16;
                        e eVar7 = this.f113962r;
                        aVar5.f113869h = eVar7.f113598n;
                        aVar5.f113882u = eVar7.f113599o;
                        aVar5.f113883v = eVar7.f113608x;
                        aVar5.f113871j = eVar7.f113601q;
                        aVar5.f113872k = eVar7.f113602r;
                        aVar5.f113870i = eVar7.f113609y;
                        aVar5.f113873l = eVar7.f113600p;
                        aVar5.f113874m = eVar7.f113604t;
                        aVar5.f113875n = eVar7.f113607w;
                        aVar5.f113880s = eVar7.j();
                        aVar5.f113881t = this.f113962r.i();
                        aVar5.f113885x = this.f113962r.f113605u;
                        this.f113965u.a(aVar5);
                        z26 = false;
                        if (z26) {
                        }
                    }
                }
                z26 = true;
                if (z26) {
                }
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.halley.common.utils.d.a("halley-downloader-SectionTransport", "Direct:" + this.f113955k + " send req retCode:" + this.f113953i + ",msg:" + this.f113954j, this.f113953i != 0);
            if (this.f113953i != 0) {
                if (!aVar.f113975e) {
                    aVar.f113975e = true;
                    com.tencent.halley.common.utils.d.e("halley-downloader-SectionTransport", "!!handleSectionTransport Direct:" + this.f113955k + ", retCode: " + this.f113953i + ", reset checkCostTime!!");
                }
                int i17 = this.f113953i;
                if (i17 == -59) {
                    aVar.f113974d = true;
                    aVar.f113973c = false;
                } else {
                    aVar.f113973c = true;
                }
                if (elapsedRealtime2 > 10000) {
                    aVar.f113976f = 0;
                } else {
                    if (!c(i17) && !d(this.f113953i)) {
                        if (b(this.f113953i)) {
                            aVar.f113976f = 3000;
                        } else {
                            aVar.f113976f = 1000;
                        }
                    }
                    aVar.f113976f = 100;
                }
            } else {
                aVar.f113976f = 1000;
                if (this.f113961q.a(false)) {
                    a(this.f113962r);
                }
                if (!a()) {
                    com.tencent.halley.downloader.task.section.a aVar6 = this.f113951g;
                    C1251b c1251b = new C1251b();
                    c1251b.f113978a = this.f113946b;
                    c1251b.f113979b = this.f113962r.h();
                    e eVar8 = this.f113962r;
                    c1251b.f113980c = eVar8.f113609y;
                    c1251b.f113981d = eVar8.k();
                    e eVar9 = this.f113962r;
                    c1251b.f113982e = eVar9.f113604t;
                    c1251b.f113983f = eVar9.f113607w;
                    c1251b.f113984g = eVar9.f113600p;
                    c1251b.f113985h = eVar9.f113603s;
                    c1251b.f113986i = eVar9.f113605u;
                    c1251b.f113987j = eVar9.f113606v;
                    com.tencent.halley.common.utils.h a16 = aVar6.a(this, c1251b);
                    com.tencent.halley.common.utils.d.c("halley-downloader-SectionTransport", "Direct:" + this.f113955k + " onValidResponse:" + a16.f113557a + "," + a16.f113558b);
                    if (!a()) {
                        int i18 = a16.f113557a;
                        aVar3.f113876o = i18;
                        if (i18 == 0) {
                            aVar.f113972b = 0L;
                            aVar.f113976f = 0;
                            aVar.f113975e = false;
                            if (!a()) {
                                com.tencent.halley.common.utils.d.c("halley-downloader-SectionTransport", "Direct:" + this.f113955k + " start readData for section:" + this.f113945a);
                                this.f113947c = true;
                                this.f113962r.a(this);
                                com.tencent.halley.downloader.task.d.a aVar7 = this.f113946b;
                                this.f113947c = false;
                                aVar7.f113895h = false;
                                this.f113953i = this.f113962r.e();
                                this.f113954j = this.f113962r.f();
                                com.tencent.halley.common.utils.d.c("halley-downloader-SectionTransport", "Direct:" + this.f113955k + " readData retCode:" + this.f113953i + ",failInfo:" + this.f113954j);
                                aVar3.f113877p = this.f113953i;
                                aVar3.f113878q = this.f113945a.toString();
                                aVar3.f113879r = SystemClock.elapsedRealtime() - aVar.f113971a;
                                if (this.f113962r.C > 0) {
                                    aVar3.f113884w = SystemClock.elapsedRealtime() - this.f113962r.C;
                                } else {
                                    aVar3.f113884w = -1L;
                                }
                                if (!this.f113948d) {
                                    List<String> list = this.E.get(this.f113946b);
                                    if (list == null) {
                                        list = Collections.synchronizedList(new ArrayList());
                                        this.E.put(this.f113946b, list);
                                    }
                                    if (this.f113945a.read > this.f113945a.start) {
                                        list.add(this.f113945a.start + "," + this.f113945a.read);
                                    }
                                }
                                if (this.K) {
                                    int i19 = this.G.get();
                                    com.tencent.halley.downloader.task.d.b bVar3 = this.f113961q;
                                    b.a aVar8 = bVar3.f113914e.get(com.tencent.halley.common.a.c.b());
                                    int size = aVar8 != null ? aVar8.a().size() : 1;
                                    if (!TextUtils.isEmpty(bVar3.f113911b.f113894g)) {
                                        size--;
                                    }
                                    com.tencent.halley.downloader.task.d.a aVar9 = bVar3.f113912c;
                                    if (aVar9 != null && !TextUtils.isEmpty(aVar9.f113894g)) {
                                        size--;
                                    }
                                    if (size <= 0) {
                                        size = 1;
                                    }
                                    if (i19 >= size) {
                                        this.f113953i = -75;
                                    }
                                }
                                if (this.f113953i != 0) {
                                    aVar.f113973c = true;
                                } else {
                                    aVar.f113973c = false;
                                }
                            }
                        } else if (i18 < 0) {
                            this.f113953i = i18;
                            this.f113954j = a16.f113558b;
                            aVar.f113973c = true;
                        } else {
                            z16 = false;
                            aVar.f113973c = false;
                            z17 = z16;
                            if (z17) {
                                this.f113947c = z16;
                                this.f113951g.b(this);
                                this.f113957m = null;
                                e eVar10 = this.f113962r;
                                if (eVar10 == null) {
                                    return true;
                                }
                                this.f113966v = eVar10.g();
                                this.f113962r.d();
                                this.f113962r = null;
                                return true;
                            }
                        }
                        z16 = false;
                        z17 = z16;
                        if (z17) {
                        }
                    }
                }
                z16 = false;
                z17 = true;
                if (z17) {
                }
            }
            if (aVar.f113975e) {
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                long j17 = elapsedRealtime3 - aVar.f113972b;
                com.tencent.halley.downloader.a.a.g();
                if (j17 <= 60000) {
                    if (b(this.f113953i)) {
                        long j18 = elapsedRealtime3 - aVar.f113972b;
                        com.tencent.halley.downloader.a.a.h();
                        if (j18 > 20000) {
                        }
                    }
                    if (c(this.f113953i) || d(this.f113953i)) {
                        long j19 = elapsedRealtime3 - aVar.f113972b;
                        com.tencent.halley.downloader.a.a.j();
                        if (j19 > 300) {
                        }
                    }
                    int i26 = this.f113953i;
                    if (i26 != -76 && i26 != -73 && i26 != -71 && i26 != -68 && i26 != -51 && i26 != -44 && i26 != -43 && i26 != -11 && i26 != -10) {
                        switch (i26) {
                            default:
                                if (!((i26 <= 0 || i26 == 200 || i26 == 206) ? false : true)) {
                                    z19 = false;
                                    break;
                                }
                                break;
                            case -56:
                            case -55:
                            case -54:
                                z19 = true;
                                break;
                        }
                        if (z19) {
                            long j26 = elapsedRealtime3 - aVar.f113972b;
                            com.tencent.halley.downloader.a.a.i();
                            if (j26 > 3000) {
                            }
                        }
                        if (this.f113953i == -15 || elapsedRealtime3 - aVar.f113972b <= com.tencent.halley.downloader.a.a.k()) {
                            if (this.f113953i == -51 && this.f113946b.f113891d == a.EnumC1249a.f113897b) {
                                SystemClock.sleep(1000L);
                            }
                        }
                    }
                    z19 = true;
                    if (z19) {
                    }
                    if (this.f113953i == -15) {
                    }
                    if (this.f113953i == -51) {
                        SystemClock.sleep(1000L);
                    }
                }
                z18 = true;
                if (!z18) {
                    this.f113947c = false;
                    this.f113951g.b(this);
                    this.f113957m = null;
                    e eVar11 = this.f113962r;
                    if (eVar11 == null) {
                        return true;
                    }
                    this.f113966v = eVar11.g();
                    this.f113962r.d();
                    this.f113962r = null;
                    return true;
                }
                this.f113947c = false;
                this.f113951g.b(this);
                this.f113957m = null;
                e eVar12 = this.f113962r;
                if (eVar12 == null) {
                    return false;
                }
                this.f113966v = eVar12.g();
                this.f113962r.d();
                this.f113962r = null;
                return false;
            }
            z18 = false;
            if (!z18) {
            }
        } catch (Throwable th5) {
            try {
                com.tencent.halley.common.utils.d.c("halley-downloader-SectionTransport", "handleSectionTransport exception", th5);
                if (th5 instanceof OutOfMemoryError) {
                    this.f113953i = -2002;
                } else {
                    this.f113953i = -61;
                }
                this.f113954j = com.tencent.halley.downloader.a.b.a(th5);
                this.f113947c = false;
                this.f113951g.b(this);
                this.f113957m = null;
                e eVar13 = this.f113962r;
                if (eVar13 == null) {
                    return true;
                }
                this.f113966v = eVar13.g();
                this.f113962r.d();
                this.f113962r = null;
                return true;
            } finally {
                this.f113947c = false;
                this.f113951g.b(this);
                e eVar14 = null;
                this.f113957m = eVar14;
                e eVar15 = this.f113962r;
                if (eVar15 != null) {
                    this.f113966v = eVar15.g();
                    this.f113962r.d();
                    this.f113962r = eVar14;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.halley.downloader.a.a.c
    public final boolean a(byte[] bArr, int i3, boolean z16) {
        List<com.tencent.halley.downloader.e.a> a16;
        byte b16;
        int i16 = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (z16) {
            com.tencent.halley.common.utils.d.b("TAG", "is direct:" + this.f113955k + ",onReceiveData...len:" + i16 + ",section:" + this.f113945a);
        }
        com.tencent.halley.downloader.task.d.a aVar = this.f113946b;
        if ((this.f113961q.f113918i > 0 && (a16 = this.f113961q.a()) != null && a16.size() > 0 && !TextUtils.isEmpty(this.f113961q.f113922m) && aVar != null && this.D.get(aVar) == null && this.f113959o && this.f113967w && this.I) != false) {
            com.tencent.halley.downloader.b.c cVar = new com.tencent.halley.downloader.b.c((com.tencent.halley.downloader.task.c) this.f113950f, this.f113961q, this.f113946b, this.C, this.D, this, this.K, this.H, this.G);
            synchronized (this.C) {
                this.C.add(cVar);
            }
            this.D.put(this.f113946b, cVar);
            cVar.f113634h = this.A;
            com.tencent.halley.downloader.f.a a17 = com.tencent.halley.downloader.f.a.a();
            if (a17.f113744b == null) {
                a17.b();
            }
            cVar.f113632f = new a.C1244a(a17.f113744b.submit(cVar));
            int i17 = !this.f113955k ? 1 : 0;
            int i18 = this.f113958n;
            cVar.f113638l = i17;
            cVar.f113639m = i18;
            c.b bVar = cVar.f113633g;
            bVar.f113650b = i17;
            bVar.f113652d = i18;
        }
        com.tencent.halley.downloader.b.c cVar2 = this.D.get(this.f113946b);
        if (cVar2 == null || !cVar2.f113630d || cVar2.f113631e || !this.F.a(this.f113945a, cVar2)) {
            b16 = false;
        } else {
            this.f113948d = true;
            b16 = true;
        }
        if (b16 == true) {
            return false;
        }
        if (this.f113951g == null) {
            com.tencent.halley.common.utils.d.e("halley-downloader-SectionTransport", "listener in Ant is null.");
            return true;
        }
        if (this.f113945a.read + i16 >= this.f113945a.end) {
            i16 = (int) (this.f113945a.end - this.f113945a.read);
            z17 = false;
        }
        boolean a18 = this.f113951g.a(this, this.f113945a.read, bArr, i16, z16) & z17;
        if (!a18) {
            com.tencent.halley.common.utils.d.b("TAG", "is direct:" + this.f113955k + ",stop read data...len:" + i16 + ",section:" + this.f113945a);
        }
        return a18;
    }
}
