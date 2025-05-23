package com.tencent.ams.fusion.service.splash.c.a.a;

import android.os.Looper;
import com.tencent.ams.fusion.a.f;
import com.tencent.ams.fusion.a.i;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.dynamic.SplashAdDynamicEngineManager;
import com.tencent.ams.fusion.service.splash.c.a.a.b.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import ot.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements e {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends com.tencent.ams.fusion.service.splash.c.a.a.b.c {
        static IPatchRedirector $redirector_;

        public c(c.b bVar) {
            super(bVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c
        protected void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            List<com.tencent.ams.fusion.service.splash.b.a.a> g16 = i.g(this.f70414a);
            if (j.b(g16)) {
                f.h("AllResourceCompensationDownloadTask", " getAffectDisplayResourceList isEmpty");
                this.f70415b.a(2, true);
                return;
            }
            f.j("AllResourceCompensationDownloadTask", " getAffectDisplayResourceList: " + g16.size());
            b(g16, true);
            f.h("AllResourceCompensationDownloadTask", " onNecessarySrcCompleted time out ? " + this.f70419f.get());
            if (!this.f70419f.get()) {
                this.f70415b.a_();
            }
            if (this.f70418e && com.tencent.ams.fusion.service.splash.a.a.d().b()) {
                List<com.tencent.ams.fusion.service.splash.b.a.a> i3 = i.i(this.f70414a);
                if (j.b(i3)) {
                    f.h("AllResourceCompensationDownloadTask", " getNoAffectDisplayResourceList isEmpty");
                    this.f70415b.a(3, false);
                    return;
                }
                f.j("AllResourceCompensationDownloadTask", " getNoAffectDisplayResourceList: " + i3.size());
                this.f70415b.g();
                b(i3, false);
                f.h("AllResourceCompensationDownloadTask", " onAllSrcCompleted time out ? " + this.f70419f);
                if (!this.f70419f.get()) {
                    this.f70415b.f();
                    return;
                }
                return;
            }
            f.h("AllResourceCompensationDownloadTask", " not allow DownloadNonessentialSrc");
        }

        @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c
        protected int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements com.tencent.ams.fusion.service.resdownload.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f70429a;

        /* renamed from: b, reason: collision with root package name */
        private final com.tencent.ams.fusion.service.splash.b.a.a f70430b;

        /* renamed from: c, reason: collision with root package name */
        private final c.a f70431c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f70432d;

        public d(com.tencent.ams.fusion.service.splash.b.a.a aVar, CountDownLatch countDownLatch, c.a aVar2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, countDownLatch, aVar2, Boolean.valueOf(z16));
                return;
            }
            this.f70429a = countDownLatch;
            this.f70430b = aVar;
            this.f70431c = aVar2;
            this.f70432d = z16;
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a(long j3, long j16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void d() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            CountDownLatch countDownLatch = this.f70429a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (this.f70431c != null) {
                com.tencent.ams.fusion.service.splash.b.a.a aVar = this.f70430b;
                if (aVar != null) {
                    i3 = aVar.c();
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                this.f70431c.h(null, this.f70432d, i3);
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void e() {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("CompensationResDownloadCallback onSingleSrcCompleted: ");
            com.tencent.ams.fusion.service.splash.b.a.a aVar = this.f70430b;
            if (aVar != null) {
                str = aVar.a();
            } else {
                str = "";
            }
            sb5.append(str);
            f.i(sb5.toString());
            CountDownLatch countDownLatch = this.f70429a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (this.f70431c != null) {
                com.tencent.ams.fusion.service.splash.b.a.a aVar2 = this.f70430b;
                if (aVar2 != null) {
                    i3 = aVar2.c();
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                this.f70431c.i(this.f70432d, i3);
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a(long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f70431c != null) {
                com.tencent.ams.fusion.service.splash.b.a.a aVar = this.f70430b;
                this.f70431c.a(this.f70432d, aVar != null ? aVar.c() : Integer.MIN_VALUE);
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a(com.tencent.ams.fusion.service.resdownload.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
                return;
            }
            f.g("CompensationResDownloadCallback onSingleSrcFailed: " + bVar.b());
            CountDownLatch countDownLatch = this.f70429a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (this.f70431c != null) {
                com.tencent.ams.fusion.service.splash.b.a.a aVar = this.f70430b;
                this.f70431c.h(bVar, this.f70432d, aVar != null ? aVar.c() : Integer.MIN_VALUE);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // ot.e
    public void c(ot.c cVar, ot.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) aVar);
        } else {
            new a(null).j(cVar, aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final LinkedList<pt.a> f70397a;

        /* renamed from: b, reason: collision with root package name */
        private ot.a f70398b;

        /* renamed from: c, reason: collision with root package name */
        private long f70399c;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f70400d;

        /* renamed from: e, reason: collision with root package name */
        private volatile pt.a f70401e;

        /* renamed from: f, reason: collision with root package name */
        private int f70402f;

        /* renamed from: g, reason: collision with root package name */
        private int f70403g;

        /* renamed from: h, reason: collision with root package name */
        private ot.d f70404h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f70405i;

        /* renamed from: j, reason: collision with root package name */
        private ot.c f70406j;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f70397a = new LinkedList<>();
            this.f70403g = 0;
            this.f70405i = true;
        }

        private com.tencent.ams.fusion.service.splash.c.a.a.a b(ot.c cVar, rt.a aVar) {
            com.tencent.ams.fusion.service.splash.c.a.a.a aVar2 = new com.tencent.ams.fusion.service.splash.c.a.a.a();
            aVar2.c(cVar);
            aVar2.d(aVar);
            return aVar2;
        }

        private void g(int i3, int i16, ot.c cVar, ot.d dVar) {
            int i17;
            long j3;
            if (dVar != null) {
                i17 = dVar.e();
                j3 = dVar.c();
            } else {
                i17 = 0;
                j3 = -1;
            }
            ot.b.c(cVar, dVar, i3, i17, j3, i16);
        }

        private void h(int i3, ot.c cVar, ot.d dVar) {
            g(i3, Integer.MIN_VALUE, cVar, dVar);
        }

        private void k(ot.d dVar) {
            if (this.f70398b == null) {
                return;
            }
            if (dVar != null) {
                if (dVar.a() == null) {
                    if (dVar.g()) {
                        o(dVar);
                    } else {
                        com.tencent.ams.fusion.service.splash.c.a.a.a.a aVar = new com.tencent.ams.fusion.service.splash.c.a.a.a.a(this.f70406j);
                        com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
                        bVar.b(5);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(aVar);
                        bVar.d(arrayList);
                        h(1001, this.f70406j, bVar);
                        this.f70398b.a(bVar);
                        return;
                    }
                } else {
                    if (dVar.d() == 4) {
                        boolean z16 = true;
                        if (com.tencent.ams.fusion.service.splash.a.a.d().l() != 1) {
                            z16 = false;
                        }
                        if (!z16) {
                            g(306, 512, this.f70406j, dVar);
                            this.f70398b.a((ot.d) null);
                            return;
                        }
                    }
                    o(dVar);
                    h(1000, this.f70406j, dVar);
                }
            }
            this.f70398b.a(dVar);
        }

        private void l(pt.a aVar) {
            pt.c b16;
            ot.d a16;
            if (aVar == null) {
                return;
            }
            aVar.a();
            if (!this.f70405i || (b16 = aVar.b()) == null || (a16 = b16.a()) == null) {
                return;
            }
            if (a16.a() != null) {
                this.f70404h = a16;
            }
            this.f70405i = b16.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(18:6|(1:8)|9|(1:11)(2:65|(1:67)(14:68|(1:14)|(1:16)|(1:18)|19|(1:64)|(1:24)|25|26|27|(1:29)|30|13d|54))|12|(0)|(0)|(0)|19|(1:21)|64|(0)|25|26|27|(0)|30|13d) */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0138, code lost:
        
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0139, code lost:
        
            r8.printStackTrace();
            r8 = false;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void n(ot.c cVar, ot.a aVar) {
            rt.a a16;
            com.tencent.ams.fusion.service.splash.c.a.a.d.d dVar;
            long h16;
            long e16;
            this.f70406j = cVar;
            this.f70398b = aVar;
            if (cVar == null) {
                k(d(1));
                return;
            }
            if (com.tencent.ams.fusion.service.splash.a.a.d().z()) {
                com.tencent.ams.fusion.service.b.b().g().b(new Runnable() { // from class: com.tencent.ams.fusion.service.splash.c.a.a.b.a.2
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.ams.fusion.service.splash.c.a.a.b$a$2$a, reason: collision with other inner class name */
                    /* loaded from: classes3.dex */
                    class C0678a implements SplashAdDynamicEngineManager.InitCallback {
                        static IPatchRedirector $redirector_;

                        C0678a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            SplashAdDynamicEngineManager.getInstance().preWarmMosaicEngine(com.tencent.ams.fusion.service.b.b().f(), new C0678a(), -1);
                        }
                    }
                });
            }
            com.tencent.ams.fusion.service.splash.a.a d16 = com.tencent.ams.fusion.service.splash.a.a.d();
            com.tencent.ams.fusion.service.splash.data.a.a.a aVar2 = new com.tencent.ams.fusion.service.splash.data.a.a.a();
            aVar2.b(cVar.k());
            aVar2.d(cVar.j());
            aVar2.e(cVar.a());
            aVar2.f(cVar.i());
            aVar2.c(cVar.t());
            qt.c n3 = com.tencent.ams.fusion.service.b.b().n();
            if (n3 == null) {
                this.f70403g |= 1;
                h(900, this.f70406j, null);
            } else {
                qt.b a17 = n3.a(aVar2);
                if (a17 == null) {
                    this.f70403g |= 2;
                    h(901, this.f70406j, null);
                } else {
                    a16 = a17.a();
                    if (a16 == null) {
                        this.f70403g |= 4;
                        h(902, this.f70406j, null);
                    }
                    if (a16 != null) {
                        com.tencent.ams.fusion.service.splash.c.a.a.d.e eVar = new com.tencent.ams.fusion.service.splash.c.a.a.d.e();
                        eVar.o(b(cVar, a16));
                        this.f70397a.add(eVar);
                    }
                    if (a16 != null) {
                        com.tencent.ams.fusion.service.splash.c.a.a.d.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.d.b();
                        com.tencent.ams.fusion.service.splash.c.a.a.a b16 = b(cVar, a16);
                        b16.b(d16.g());
                        bVar.o(b16);
                        this.f70397a.add(bVar);
                    }
                    dVar = new com.tencent.ams.fusion.service.splash.c.a.a.d.d();
                    dVar.o(b(cVar, a16));
                    if (!cVar.s() || com.tencent.ams.fusion.service.splash.a.a.d().A()) {
                        com.tencent.ams.fusion.service.splash.c.a.a.d.f fVar = new com.tencent.ams.fusion.service.splash.c.a.a.d.f();
                        com.tencent.ams.fusion.service.splash.c.a.a.a b17 = b(cVar, a16);
                        b17.b(d16.f());
                        fVar.o(b17);
                        dVar.w(fVar);
                    }
                    if (a16 != null) {
                        com.tencent.ams.fusion.service.splash.c.a.a.d.c cVar2 = new com.tencent.ams.fusion.service.splash.c.a.a.d.c();
                        cVar2.o(b(cVar, a16));
                        dVar.w(cVar2);
                    }
                    this.f70397a.add(dVar);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    com.tencent.ams.fusion.service.b.b().g().b(new Runnable(countDownLatch) { // from class: com.tencent.ams.fusion.service.splash.c.a.a.b.a.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ CountDownLatch f70412d;

                        {
                            this.f70412d = countDownLatch;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) countDownLatch);
                            }
                        }

                        /* JADX WARN: Removed duplicated region for block: B:48:0x0137 A[EDGE_INSN: B:48:0x0137->B:49:0x0137 BREAK  A[LOOP:0: B:9:0x000f->B:47:0x000f], SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            while (true) {
                                if (a.this.f70397a.size() <= 0) {
                                    break;
                                }
                                if (a.this.f70400d) {
                                    return;
                                }
                                synchronized (a.this) {
                                    a aVar3 = a.this;
                                    aVar3.f70401e = (pt.a) aVar3.f70397a.poll();
                                    if (a.this.f70401e != null) {
                                        if (a.this.f70398b != null) {
                                            a.this.f70398b.a(a.this.f70401e);
                                        }
                                        pt.c c16 = a.this.f70401e.c();
                                        if (a.this.f70398b != null) {
                                            a.this.f70398b.b(a.this.f70401e);
                                        }
                                        if (c16 == null) {
                                            if (a.this.f70398b != null) {
                                                a.this.f70398b.d(a.this.f70401e);
                                            }
                                        } else {
                                            ot.d a18 = c16.a();
                                            if (a18 == null) {
                                                if (a.this.f70398b != null) {
                                                    a.this.f70398b.d(a.this.f70401e);
                                                }
                                            } else {
                                                synchronized (a.this) {
                                                    if (a18.a() == null && !a18.g()) {
                                                        a.this.f70402f = a18.e();
                                                        if (a.this.f70398b != null) {
                                                            a.this.f70398b.d(a.this.f70401e);
                                                        }
                                                        if (c16.b()) {
                                                            break;
                                                        }
                                                    }
                                                    a.this.f70404h = a18;
                                                    a.this.f70401e = null;
                                                    a.this.f70405i = c16.b();
                                                    if (a.this.f70400d) {
                                                        if (a.this.f70398b != null) {
                                                            a.this.f70398b.d(a.this.f70401e);
                                                        }
                                                    } else if (a.this.f70398b != null) {
                                                        a.this.f70398b.c(a.this.f70401e);
                                                    }
                                                    if (c16.b()) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            this.f70412d.countDown();
                        }
                    });
                    h16 = cVar.h();
                    e16 = d16.e();
                    if (h16 > e16) {
                        h16 = e16;
                    }
                    boolean z16 = countDownLatch.await(h16, TimeUnit.MILLISECONDS);
                    synchronized (this) {
                        if (!z16) {
                            f.g("\u9009\u5355service \u5168\u5c40\u8d85\u65f6");
                            this.f70400d = true;
                            this.f70403g |= 8;
                            h(903, this.f70406j, this.f70404h);
                            if (this.f70401e != null) {
                                this.f70403g |= this.f70401e.e();
                            }
                            l(this.f70401e);
                            while (this.f70397a.size() > 0) {
                                pt.a poll = this.f70397a.poll();
                                if (poll != null) {
                                    l(poll);
                                }
                            }
                        } else {
                            this.f70403g |= this.f70402f;
                        }
                        if (this.f70404h == null) {
                            f.g("\u9009\u5355\u5931\u8d25\uff0c\u6ca1\u6709\u9009\u4e2d");
                            k(d(this.f70403g));
                        } else {
                            f.a("SplashSelectOrderServiceImpl onSelectFinish :" + this.f70404h.d());
                            k(this.f70404h);
                        }
                    }
                    return;
                }
            }
            a16 = null;
            if (a16 == null) {
            }
            if (a16 != null) {
            }
            if (a16 != null) {
            }
            dVar = new com.tencent.ams.fusion.service.splash.c.a.a.d.d();
            dVar.o(b(cVar, a16));
            if (!cVar.s()) {
            }
            com.tencent.ams.fusion.service.splash.c.a.a.d.f fVar2 = new com.tencent.ams.fusion.service.splash.c.a.a.d.f();
            com.tencent.ams.fusion.service.splash.c.a.a.a b172 = b(cVar, a16);
            b172.b(d16.f());
            fVar2.o(b172);
            dVar.w(fVar2);
            if (a16 != null) {
            }
            this.f70397a.add(dVar);
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            com.tencent.ams.fusion.service.b.b().g().b(new Runnable(countDownLatch2) { // from class: com.tencent.ams.fusion.service.splash.c.a.a.b.a.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CountDownLatch f70412d;

                {
                    this.f70412d = countDownLatch2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) countDownLatch2);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:48:0x0137 A[EDGE_INSN: B:48:0x0137->B:49:0x0137 BREAK  A[LOOP:0: B:9:0x000f->B:47:0x000f], SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    while (true) {
                        if (a.this.f70397a.size() <= 0) {
                            break;
                        }
                        if (a.this.f70400d) {
                            return;
                        }
                        synchronized (a.this) {
                            a aVar3 = a.this;
                            aVar3.f70401e = (pt.a) aVar3.f70397a.poll();
                            if (a.this.f70401e != null) {
                                if (a.this.f70398b != null) {
                                    a.this.f70398b.a(a.this.f70401e);
                                }
                                pt.c c16 = a.this.f70401e.c();
                                if (a.this.f70398b != null) {
                                    a.this.f70398b.b(a.this.f70401e);
                                }
                                if (c16 == null) {
                                    if (a.this.f70398b != null) {
                                        a.this.f70398b.d(a.this.f70401e);
                                    }
                                } else {
                                    ot.d a18 = c16.a();
                                    if (a18 == null) {
                                        if (a.this.f70398b != null) {
                                            a.this.f70398b.d(a.this.f70401e);
                                        }
                                    } else {
                                        synchronized (a.this) {
                                            if (a18.a() == null && !a18.g()) {
                                                a.this.f70402f = a18.e();
                                                if (a.this.f70398b != null) {
                                                    a.this.f70398b.d(a.this.f70401e);
                                                }
                                                if (c16.b()) {
                                                    break;
                                                }
                                            }
                                            a.this.f70404h = a18;
                                            a.this.f70401e = null;
                                            a.this.f70405i = c16.b();
                                            if (a.this.f70400d) {
                                                if (a.this.f70398b != null) {
                                                    a.this.f70398b.d(a.this.f70401e);
                                                }
                                            } else if (a.this.f70398b != null) {
                                                a.this.f70398b.c(a.this.f70401e);
                                            }
                                            if (c16.b()) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.f70412d.countDown();
                }
            });
            h16 = cVar.h();
            e16 = d16.e();
            if (h16 > e16) {
            }
            boolean z162 = countDownLatch2.await(h16, TimeUnit.MILLISECONDS);
            synchronized (this) {
            }
        }

        private void o(ot.d dVar) {
            if (dVar != null && !j.b(dVar.f())) {
                for (com.tencent.ams.fusion.service.splash.c.a.a.c.a.a aVar : dVar.f()) {
                    if (aVar != null && aVar.a() != Integer.MIN_VALUE) {
                        ot.b.c(this.f70406j, dVar, aVar.a(), dVar.e(), dVar.c(), aVar.c());
                    }
                }
            }
        }

        protected ot.d d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ot.d) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
            bVar.i(i3);
            return bVar;
        }

        public void j(ot.c cVar, ot.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) aVar);
                return;
            }
            this.f70399c = System.currentTimeMillis();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.tencent.ams.fusion.service.b.b().g().b(new Runnable(cVar, aVar) { // from class: com.tencent.ams.fusion.service.splash.c.a.a.b.a.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ot.c f70407d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ot.a f70408e;

                    {
                        this.f70407d = cVar;
                        this.f70408e = aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, a.this, cVar, aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            a.this.n(this.f70407d, this.f70408e);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else {
                n(cVar, aVar);
            }
        }

        /* synthetic */ a(C0679b c0679b) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) c0679b);
        }
    }
}
