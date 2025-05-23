package com.tencent.ams.fusion.service.splash.b.b;

import com.tencent.ams.fusion.service.splash.b.b.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import nt.g;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements kt.b<nt.f, g> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nt.f f70360a;

    /* renamed from: b, reason: collision with root package name */
    private g f70361b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.data.a f70362c;

    /* renamed from: d, reason: collision with root package name */
    private final CountDownLatch f70363d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f70364e;

    /* renamed from: f, reason: collision with root package name */
    private int f70365f;

    /* renamed from: g, reason: collision with root package name */
    protected long f70366g;

    /* renamed from: h, reason: collision with root package name */
    protected long f70367h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements mt.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // mt.b
        public void a(mt.a aVar, mt.c cVar) {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) cVar);
                return;
            }
            com.tencent.ams.fusion.a.f.g("PreloadRequestTask onRequestFailed:" + (System.currentTimeMillis() - b.this.f70366g));
            boolean z16 = cVar instanceof com.tencent.ams.fusion.service.splash.data.b.c;
            if (z16) {
                i3 = ((com.tencent.ams.fusion.service.splash.data.b.c) cVar).f70523a;
            } else {
                i3 = -1;
            }
            if (z16) {
                i16 = ((com.tencent.ams.fusion.service.splash.data.b.c) cVar).b();
            } else {
                i16 = 0;
            }
            b bVar = b.this;
            bVar.h(402, i3, bVar.f70366g, i16);
            if (i16 != 0 || b.this.f70364e.get() >= b.this.f70365f) {
                b.this.o(null, 64);
            } else {
                b.this.f70364e.incrementAndGet();
                b.this.s();
            }
        }

        @Override // mt.b
        public void b(mt.a aVar, mt.c cVar) {
            int i3;
            com.tencent.ams.fusion.service.splash.data.g gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) cVar);
                return;
            }
            com.tencent.ams.fusion.a.f.i("PreloadRequestTask onRequestFinish:" + (System.currentTimeMillis() - b.this.f70366g));
            b bVar = b.this;
            if (cVar instanceof com.tencent.ams.fusion.service.splash.data.b.c) {
                i3 = ((com.tencent.ams.fusion.service.splash.data.b.c) cVar).b();
            } else {
                i3 = 0;
            }
            bVar.g(401, i3, b.this.f70366g);
            b bVar2 = b.this;
            if (cVar instanceof com.tencent.ams.fusion.service.splash.data.g) {
                gVar = (com.tencent.ams.fusion.service.splash.data.g) cVar;
            } else {
                gVar = null;
            }
            bVar2.n(gVar);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70363d = new CountDownLatch(1);
        this.f70364e = new AtomicInteger(0);
        this.f70365f = 0;
    }

    private int e() {
        if (this.f70360a == null) {
            return 2;
        }
        if (!com.tencent.ams.fusion.service.splash.a.a.d().s()) {
            return 4;
        }
        if (System.currentTimeMillis() - this.f70366g < com.tencent.ams.fusion.service.splash.a.a.d().v()) {
            return 8;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3, int i16, long j3) {
        nt.d.c(this.f70360a, null, i3, 0L, j3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3, long j3, long j16, int i16) {
        nt.d.c(this.f70360a, null, i3, j3, System.currentTimeMillis() - j16, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.tencent.ams.fusion.service.splash.data.g gVar) {
        nt.f fVar;
        StringBuilder sb5;
        String str;
        if (gVar == null) {
            o(null, 16);
            return;
        }
        rt.b a16 = gVar.a();
        if (a16 == null) {
            o(null, 32);
            return;
        }
        if (this.f70362c != null && (fVar = this.f70360a) != null) {
            String b16 = fVar.b();
            com.tencent.ams.fusion.service.splash.data.a aVar = this.f70362c;
            if (this.f70360a.a()) {
                sb5 = new StringBuilder();
                sb5.append(b16);
                str = "key_preload_request_hot";
            } else {
                sb5 = new StringBuilder();
                sb5.append(b16);
                str = "key_preload_request_cold";
            }
            sb5.append(str);
            aVar.b(sb5.toString(), a16.a());
        }
        o(a16.a(), Integer.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, int i3) {
        com.tencent.ams.fusion.a.f.j("PreloadRequestTask", " requestFinished :" + i3);
        r(str, i3);
        this.f70363d.countDown();
    }

    private b.f r(String str, int i3) {
        b.f fVar = new b.f();
        if (str == null || str.length() == 0) {
            fVar.d(false);
        }
        fVar.c(str);
        fVar.a(i3);
        fVar.b(System.currentTimeMillis() - this.f70366g);
        this.f70361b = fVar;
        return fVar;
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "PreloadRequestTask";
    }

    @Override // kt.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public g c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f70367h = System.currentTimeMillis();
        int e16 = e();
        if (e16 != 1) {
            return r(null, e16);
        }
        com.tencent.ams.fusion.service.b.b().g().a(new Runnable() { // from class: com.tencent.ams.fusion.service.splash.b.b.b.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    b.this.s();
                }
            }
        }, com.tencent.ams.fusion.service.splash.a.a.d().w());
        try {
            z16 = this.f70363d.await(this.f70360a.d(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e17) {
            com.tencent.ams.fusion.a.f.d("PreloadRequestTask exec error ", e17);
            z16 = false;
        }
        if (!z16) {
            r(null, 128);
        }
        return this.f70361b;
    }

    public void m(com.tencent.ams.fusion.service.splash.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f70362c = aVar;
        }
    }

    public void p(nt.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            this.f70360a = fVar;
        }
    }

    protected void s() {
        int i3;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        nt.f fVar = this.f70360a;
        if ((fVar instanceof com.tencent.ams.fusion.service.splash.b.b.a.a.a) && ((com.tencent.ams.fusion.service.splash.b.b.a.a.a) fVar).h()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        g(400, i3, 0L);
        this.f70366g = System.currentTimeMillis();
        this.f70365f = com.tencent.ams.fusion.service.splash.a.a.d().o();
        com.tencent.ams.fusion.service.splash.data.b.a aVar = new com.tencent.ams.fusion.service.splash.data.b.a();
        aVar.h(this.f70360a.b());
        aVar.e(this.f70360a.c());
        aVar.g(this.f70360a.a());
        aVar.i(true);
        nt.f fVar2 = this.f70360a;
        if (fVar2 instanceof com.tencent.ams.fusion.service.splash.b.b.a.a.a) {
            obj = ((com.tencent.ams.fusion.service.splash.b.b.a.a.a) fVar2).g();
        } else {
            obj = null;
        }
        aVar.d(obj);
        com.tencent.ams.fusion.a.f.j("PreloadRequestTask", " setUpPreloadNetRequest requestAsync :" + this.f70364e.get());
        com.tencent.ams.fusion.service.b.b().h().a(aVar, new a());
    }
}
