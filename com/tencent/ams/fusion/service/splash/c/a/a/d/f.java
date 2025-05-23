package com.tencent.ams.fusion.service.splash.c.a.a.d;

import android.text.TextUtils;
import com.tencent.ams.fusion.a.h;
import com.tencent.ams.fusion.service.splash.c.a.a.b;
import com.tencent.ams.fusion.service.splash.c.a.a.b.c;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends com.tencent.ams.fusion.service.splash.c.a.a.d.a {
    static IPatchRedirector $redirector_;
    private long A;
    private long B;

    /* renamed from: d, reason: collision with root package name */
    private ot.c f70472d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.c.a.a.c.b.b f70473e;

    /* renamed from: f, reason: collision with root package name */
    private final CountDownLatch f70474f;

    /* renamed from: g, reason: collision with root package name */
    private SplashOrder f70475g;

    /* renamed from: h, reason: collision with root package name */
    private SplashOrder f70476h;

    /* renamed from: i, reason: collision with root package name */
    private SplashOrder f70477i;

    /* renamed from: j, reason: collision with root package name */
    private SplashOrder f70478j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f70479k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f70480l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f70481m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f70482n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f70483o;

    /* renamed from: p, reason: collision with root package name */
    private volatile boolean f70484p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f70485q;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f70486r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f70487s;

    /* renamed from: t, reason: collision with root package name */
    private volatile boolean f70488t;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.c.a.a.b.c f70489u;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f70490v;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f70491w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f70492x;

    /* renamed from: y, reason: collision with root package name */
    private volatile boolean f70493y;

    /* renamed from: z, reason: collision with root package name */
    private volatile boolean f70494z;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements mt.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // mt.b
        public void a(mt.a aVar, mt.c cVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                f.this.f70481m = true;
                if (f.this.f70479k) {
                    com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask onRequestFailed but is timeout now.");
                    return;
                }
                if (cVar instanceof com.tencent.ams.fusion.service.splash.data.b.b) {
                    i3 = ((com.tencent.ams.fusion.service.splash.data.b.b) cVar).f70522b;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask onRequestFailed " + i3);
                f fVar = f.this;
                fVar.t(105, (long) i3, fVar.f70472d.b() ? 1 : 0, f.this.f70446c);
                f.this.K(i3);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) cVar);
        }

        @Override // mt.b
        public void b(mt.a aVar, mt.c cVar) {
            long j3;
            com.tencent.ams.fusion.service.splash.data.e eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) cVar);
                return;
            }
            com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask onRequestFinish cost: " + (System.currentTimeMillis() - f.this.f70446c));
            f.this.f70481m = true;
            if (f.this.f70479k) {
                com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask onRequestFinish but is timeout now.");
                return;
            }
            f fVar = f.this;
            if (fVar.f70472d.b()) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            fVar.u(104, j3, f.this.f70446c);
            f fVar2 = f.this;
            if (cVar instanceof com.tencent.ams.fusion.service.splash.data.b.b) {
                eVar = (com.tencent.ams.fusion.service.splash.data.e) cVar;
            } else {
                eVar = null;
            }
            fVar2.B(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f70500a;

        b(boolean z16) {
            this.f70500a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void a(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (z16) {
                f.this.f70491w = true;
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void a_() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            f.this.f70490v = !r0.f70491w;
            if (f.this.f70490v) {
                f fVar = f.this;
                fVar.u(151, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, fVar.A);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            if (!f.this.f70492x) {
                f fVar = f.this;
                fVar.u(154, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, fVar.A);
            }
            if (!f.this.f70479k && f.this.f70490v) {
                f fVar2 = f.this;
                fVar2.u(142, 2L, fVar2.f70446c);
                f fVar3 = f.this;
                fVar3.H(fVar3.f70475g);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                f.this.l(153, Integer.MIN_VALUE);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void h(com.tencent.ams.fusion.service.resdownload.b bVar, boolean z16, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, bVar, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (this.f70500a && z16) {
                f.this.f70491w = true;
                f fVar = f.this;
                SplashOrder splashOrder = fVar.f70475g;
                if (bVar != null) {
                    i16 = bVar.a();
                } else {
                    i16 = Integer.MIN_VALUE;
                }
                fVar.m(splashOrder, i3, 140, i16);
            }
            if (!z16) {
                f.this.f70492x = true;
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void i(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (this.f70500a && z16) {
                f fVar = f.this;
                fVar.m(fVar.f70475g, i3, 139, Integer.MIN_VALUE);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (this.f70500a && z16) {
                f fVar = f.this;
                fVar.m(fVar.f70475g, i3, 138, Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f70502a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SplashOrder f70503b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f70504c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f70505d;

        c(int i3, SplashOrder splashOrder, long j3, boolean z16) {
            this.f70502a = i3;
            this.f70503b = splashOrder;
            this.f70504c = j3;
            this.f70505d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, Integer.valueOf(i3), splashOrder, Long.valueOf(j3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void a(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (z16) {
                f.this.f70494z = true;
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void a_() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            f.this.f70493y = !r0.f70494z;
            f.this.n(this.f70503b, 0, 160, Integer.MIN_VALUE, System.currentTimeMillis() - this.f70504c);
            if (!this.f70505d) {
                com.tencent.ams.fusion.a.f.h("RealTimeSelectOrderTask", "onAllSrcDownloadEnd but no need callback!");
                return;
            }
            if (!f.this.f70479k && f.this.f70493y && f.this.f70473e != null && f.this.f70473e.k()) {
                com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", "onNecessarySrcDownloadEnd selectSuccess");
                f.this.H(this.f70503b);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            f.this.n(this.f70503b, 0, 161, Integer.MIN_VALUE, System.currentTimeMillis() - this.f70504c);
            if (!this.f70505d) {
                com.tencent.ams.fusion.a.f.h("RealTimeSelectOrderTask", "onAllSrcDownloadEnd but no need callback!");
                return;
            }
            if (!f.this.f70479k && f.this.f70493y && f.this.f70473e != null && f.this.f70473e.k()) {
                com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", "onAllSrcDownloadEnd selectSuccess");
                f.this.H(this.f70503b);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void h(com.tencent.ams.fusion.service.resdownload.b bVar, boolean z16, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, bVar, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (z16) {
                f.this.f70494z = true;
            }
            int i18 = this.f70502a;
            if (i18 == 1) {
                i17 = 123;
            } else if (i18 == 2) {
                i17 = 134;
            }
            f fVar = f.this;
            SplashOrder splashOrder = this.f70503b;
            if (bVar != null) {
                i16 = bVar.a();
            } else {
                i16 = Integer.MIN_VALUE;
            }
            fVar.m(splashOrder, i3, i17, i16);
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void i(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            int i17 = this.f70502a;
            if (i17 == 1) {
                i16 = 122;
            } else if (i17 == 2) {
                i16 = 133;
            }
            f.this.m(this.f70503b, i3, i16, Integer.MIN_VALUE);
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
        public void a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            int i17 = this.f70502a;
            if (i17 == 1) {
                i16 = 121;
            } else if (i17 == 2) {
                i16 = 132;
            }
            f.this.m(this.f70503b, i3, i16, Integer.MIN_VALUE);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70473e = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
        this.f70474f = new CountDownLatch(1);
        this.f70482n = false;
        this.f70489u = null;
        this.f70490v = false;
        this.f70491w = false;
        this.f70492x = false;
        this.f70493y = false;
        this.f70494z = false;
        this.A = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.B = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(com.tencent.ams.fusion.service.splash.data.e eVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (eVar == null) {
            K(8);
            return;
        }
        List<SplashOrder> a16 = eVar.a();
        if (a16 != null && a16.size() != 0) {
            for (SplashOrder splashOrder : a16) {
                if (splashOrder != null) {
                    if (splashOrder.bm()) {
                        if (this.f70475g == null) {
                            this.f70475g = splashOrder;
                        }
                    } else if (splashOrder.bl()) {
                        if (this.f70476h == null) {
                            this.f70476h = splashOrder;
                        }
                    } else if (splashOrder.bk()) {
                        if (this.f70478j == null) {
                            this.f70478j = splashOrder;
                        }
                    } else if (this.f70477i == null) {
                        this.f70477i = splashOrder;
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("RealTimeSelectOrderTask RealTimeFirstPlay exist:");
            boolean z19 = true;
            if (this.f70475g != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            com.tencent.ams.fusion.a.f.i(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("RealTimeSelectOrderTask BEST exist:");
            if (this.f70476h != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb6.append(z17);
            com.tencent.ams.fusion.a.f.i(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("RealTimeSelectOrderTask LOCAL exist:");
            if (this.f70477i != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            sb7.append(z18);
            com.tencent.ams.fusion.a.f.i(sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("RealTimeSelectOrderTask EMPTY exist:");
            if (this.f70478j == null) {
                z19 = false;
            }
            sb8.append(z19);
            com.tencent.ams.fusion.a.f.i(sb8.toString());
            if (this.f70475g != null) {
                f();
                return;
            } else if (this.f70476h != null) {
                Y();
                return;
            } else {
                u(107, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
                Z();
                return;
            }
        }
        K(16);
        u(106, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
    }

    private void C(SplashOrder splashOrder, int i3, boolean z16, boolean z17) {
        boolean z18;
        String aB;
        long j3;
        if (splashOrder == null) {
            K(256);
            return;
        }
        if (com.tencent.ams.fusion.service.splash.a.a.d().i() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && z18) {
            aB = splashOrder.aC();
        } else {
            aB = splashOrder.aB();
        }
        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask download src url = " + aB);
        if (TextUtils.isEmpty(aB)) {
            if (z16) {
                j3 = 101;
            } else {
                j3 = 100;
            }
            u(110, j3, this.f70446c);
            if (i3 == 1) {
                Z();
                return;
            } else {
                if (i3 == 2) {
                    K(32);
                    return;
                }
                return;
            }
        }
        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask downloadSrc src type :" + i3);
        com.tencent.ams.fusion.service.b.b().g().b(new Runnable(z17, splashOrder, i3) { // from class: com.tencent.ams.fusion.service.splash.c.a.a.d.f.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f70495d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ SplashOrder f70496e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f70497f;

            {
                this.f70495d = z17;
                this.f70496e = splashOrder;
                this.f70497f = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, f.this, Boolean.valueOf(z17), splashOrder, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    f.this.D(this.f70495d, this.f70496e, this.f70497f);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z16, SplashOrder splashOrder, int i3) {
        if (splashOrder != null && this.f70472d != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = System.currentTimeMillis();
            c.b bVar = new c.b();
            bVar.f70427c = this.f70472d.i();
            bVar.f70425a = splashOrder;
            bVar.f70428d = this.f70472d.h();
            bVar.f70426b = new c(i3, splashOrder, currentTimeMillis, z16);
            if (this.f70489u == null) {
                this.f70489u = new b.c(bVar);
            }
            m(splashOrder, 0, 159, Integer.MIN_VALUE);
            this.f70489u.f();
            com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " mCompensationDownloadTask execute finish.");
            return;
        }
        com.tencent.ams.fusion.a.f.h("RealTimeSelectOrderTask", "downloadAllSrc error invalid params!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(SplashOrder splashOrder) {
        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask selectSuccess :" + splashOrder);
        ot.b.b(this.f70472d, this.f70473e, 198, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, System.currentTimeMillis() - this.f70446c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(splashOrder);
        this.f70473e.g(arrayList);
        this.f70473e.e(false);
        this.f70474f.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i3) {
        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask selectFailed :" + i3);
        ot.b.b(this.f70472d, this.f70473e, 199, (long) i3, System.currentTimeMillis() - this.f70446c);
        this.f70473e.f(i3);
        this.f70474f.countDown();
    }

    private void W() {
        SplashOrder splashOrder;
        SplashOrder splashOrder2;
        SplashOrder splashOrder3;
        SplashOrder splashOrder4;
        com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = this.f70473e;
        if (bVar != null && bVar.a() == null) {
            if (this.A != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && (splashOrder4 = this.f70475g) != null && splashOrder4.aA()) {
                com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " mRealtimeFirstPlayOrder ready to show.");
                u(142, 3L, this.f70446c);
                splashOrder = this.f70475g;
            } else {
                splashOrder = null;
            }
            X();
            if (this.B != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && splashOrder == null && (splashOrder3 = this.f70476h) != null && splashOrder3.aA()) {
                com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " mBestOrder ready to show.");
                splashOrder = this.f70476h;
            }
            if (this.B != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && splashOrder == null && (splashOrder2 = this.f70477i) != null && splashOrder2.aA()) {
                com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " mLocalPreloadedOrder ready to show.");
                splashOrder = this.f70477i;
            }
            if (splashOrder != null) {
                H(splashOrder);
            }
            com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " useTimeoutOrder:" + splashOrder);
            return;
        }
        com.tencent.ams.fusion.a.f.h("RealTimeSelectOrderTask", "checkRealtimeFirstPlayerOrder fail invalid data.");
    }

    private void X() {
        if (this.f70491w) {
            u(152, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.A);
        }
        if (this.f70492x) {
            u(155, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.A);
        }
        if (!this.f70490v) {
            u(141, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        }
    }

    private void Y() {
        boolean z16;
        long j3;
        com.tencent.ams.fusion.a.f.i("selectRealTimeBestOrder begin");
        if (this.f70476h == null) {
            K(256);
            return;
        }
        if (com.tencent.ams.fusion.service.splash.a.a.d().h() != 1) {
            this.f70486r = true;
            u(111, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
            K(8192);
            return;
        }
        if (!TextUtils.isEmpty(this.f70476h.aC())) {
            this.f70482n = true;
            u(109, 101L, this.f70446c);
        } else {
            u(109, 100L, this.f70446c);
        }
        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask selectRealTimeBestOrder src exist :" + this.f70476h.aA());
        if (this.f70476h.aA()) {
            if (this.f70482n) {
                j3 = 4;
            } else {
                j3 = 2;
            }
            u(129, j3, this.f70446c);
            SplashOrder splashOrder = this.f70476h;
            SplashOrder a16 = splashOrder.a(splashOrder);
            if (a16 == null) {
                H(this.f70476h);
                return;
            } else {
                H(a16);
                return;
            }
        }
        if (s() != null && s().a() != null && !s().a().t()) {
            com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask not allow download RealTimeBestOrder src in realtime.");
            K(32768);
            return;
        }
        long h16 = this.f70472d.h() - (System.currentTimeMillis() - this.f70446c);
        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask download leftTime :" + h16 + " TimeThreshold " + this.f70476h.ba());
        if (h16 > this.f70476h.ba()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f70483o = z16;
        if (!this.f70483o) {
            u(120, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        }
        C(this.f70476h, 1, this.f70482n, this.f70483o);
    }

    private void Z() {
        com.tencent.ams.fusion.a.f.i("selectLocalPreloadedOrder begin");
        if (this.f70477i != null) {
            com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask selectLocalPreloadedOrder src exist :" + this.f70477i.aA());
            u(118, 1L, this.f70446c);
            if (com.tencent.ams.fusion.service.splash.a.a.d().y()) {
                if (this.f70477i.aA()) {
                    a0();
                    return;
                }
                u(131, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
                long h16 = this.f70472d.h() - (System.currentTimeMillis() - this.f70446c);
                com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask download leftTime :" + h16 + " TimeThreshold " + this.f70477i.ba());
                boolean z16 = true;
                boolean isEmpty = TextUtils.isEmpty(this.f70477i.aC()) ^ true;
                if (this.f70477i.bh() != 1) {
                    if (s() != null && s().a() != null && !s().a().t()) {
                        com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask not allow download LocalPreloadedOrder src in realtime.");
                        K(32768);
                        return;
                    } else {
                        if (h16 <= this.f70477i.ba()) {
                            z16 = false;
                        }
                        C(this.f70477i, 2, isEmpty, z16);
                        return;
                    }
                }
                u(117, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
                K(2048);
                return;
            }
            a0();
            return;
        }
        if (this.f70478j != null) {
            com.tencent.ams.fusion.a.f.i("RealTimeSelectOrderTask: realtime order is empty order");
            u(108, 8L, this.f70446c);
            H(this.f70478j);
        } else if (this.f70481m) {
            u(119, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        }
    }

    private void a0() {
        if (this.f70477i == null) {
            K(256);
            return;
        }
        u(130, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        t(116, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, b0(), this.f70446c);
        SplashOrder splashOrder = this.f70477i;
        SplashOrder a16 = splashOrder.a(splashOrder);
        this.f70477i = a16;
        if (a16 == null) {
            K(4096);
        } else {
            H(a16);
        }
    }

    private int b0() {
        if (this.f70476h == null) {
            return 128;
        }
        if (this.f70484p) {
            return 64;
        }
        if (this.f70485q) {
            return 32;
        }
        if (!this.f70483o) {
            return 256;
        }
        if (this.f70486r) {
            return 512;
        }
        return 16;
    }

    private void f() {
        com.tencent.ams.fusion.a.f.i("selectRealTimeFirstPlayOrder begin");
        if (this.f70475g != null && this.f70472d != null) {
            l(137, Integer.MIN_VALUE);
            if (this.f70475g.aA()) {
                u(142, 1L, this.f70446c);
                SplashOrder splashOrder = this.f70475g;
                SplashOrder a16 = splashOrder.a(splashOrder);
                if (a16 == null) {
                    H(this.f70475g);
                    return;
                } else {
                    H(a16);
                    return;
                }
            }
            this.A = System.currentTimeMillis();
            boolean b16 = this.f70472d.b();
            c.b bVar = new c.b();
            bVar.f70427c = this.f70472d.i();
            bVar.f70425a = this.f70475g;
            bVar.f70428d = this.f70472d.h();
            bVar.f70426b = new b(b16);
            if (this.f70489u == null) {
                this.f70489u = new b.c(bVar);
            }
            l(150, Integer.MIN_VALUE);
            this.f70489u.f();
            com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " first play mCompensationDownloadTask execute finish.");
            return;
        }
        K(256);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3, long j3, int i16, long j16) {
        if (!this.f70479k) {
            ot.b.c(this.f70472d, this.f70473e, i3, j3, System.currentTimeMillis() - j16, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3, long j3, long j16) {
        t(i3, j3, Integer.MIN_VALUE, j16);
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a, pt.a
    public void a() {
        long j3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.ams.fusion.a.f.j("RealTimeSelectOrderTask", " timeout !");
        com.tencent.ams.fusion.service.splash.c.a.a.b.c cVar = this.f70489u;
        if (cVar != null) {
            cVar.e();
        }
        W();
        ot.c cVar2 = this.f70472d;
        if (cVar2 != null && cVar2.o() != 0) {
            u(136, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70472d.o());
        }
        if (this.f70480l && !this.f70481m) {
            u(102, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
            K(16384);
        }
        if (this.f70487s) {
            u(126, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
            if (this.f70477i != null && this.f70478j != null) {
                i3 = 127;
            } else {
                i3 = 128;
            }
            u(i3, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        }
        if (this.f70488t) {
            u(135, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        }
        if (this.f70473e.a() == null && this.f70481m) {
            if (this.f70482n) {
                j3 = 101;
            } else {
                j3 = 100;
            }
            u(112, j3, this.f70446c);
            Z();
        }
        this.f70479k = true;
        if (this.f70474f.getCount() != 0 && this.f70473e.a() == null) {
            K(64);
        }
    }

    @Override // pt.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // pt.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 32;
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a
    protected ot.d r() {
        long j3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ot.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        pt.b s16 = s();
        if (!h.a(com.tencent.ams.fusion.service.b.b().f())) {
            com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask exec error, network invalid");
            this.f70473e.f(4);
            u(100, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
            return this.f70473e;
        }
        u(101, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, this.f70446c);
        if (s16 == null) {
            com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask exec error, invalid params");
            this.f70473e.f(1);
            return this.f70473e;
        }
        if (s16.a() == null) {
            com.tencent.ams.fusion.a.f.g("RealTimeSelectOrderTask exec error, invalid params");
            this.f70473e.f(1);
            return this.f70473e;
        }
        ot.c a16 = s16.a();
        this.f70472d = a16;
        if (a16.b()) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        u(103, j3, this.f70446c);
        com.tencent.ams.fusion.service.splash.data.b.a aVar = new com.tencent.ams.fusion.service.splash.data.b.a();
        aVar.h(this.f70472d.i());
        aVar.e(this.f70472d.j());
        aVar.f(this.f70472d.l());
        aVar.g(this.f70472d.a());
        aVar.d(this.f70472d.r());
        aVar.b(this.f70472d.q());
        aVar.c(this.f70472d.o());
        this.f70480l = true;
        com.tencent.ams.fusion.service.b.b().h().a(aVar, new a());
        try {
            z16 = this.f70474f.await(com.tencent.ams.fusion.service.splash.a.a.d().c(this.f70472d.h()), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            com.tencent.ams.fusion.a.f.d("RealTimeSelectOrderTask exec error ", e16);
            z16 = false;
        }
        if (!z16) {
            this.f70473e.f(64);
        }
        this.f70473e.b(d());
        return this.f70473e;
    }
}
