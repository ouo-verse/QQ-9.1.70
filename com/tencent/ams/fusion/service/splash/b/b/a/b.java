package com.tencent.ams.fusion.service.splash.b.b.a;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import nt.g;
import nt.h;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements h {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements kt.a<g> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.fusion.service.c.a.a f70345a;

        a(com.tencent.ams.fusion.service.c.a.a aVar) {
            this.f70345a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
            }
        }

        @Override // kt.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // kt.a
        public void b(kt.c<?, ?> cVar, kt.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) eVar);
            } else if (cVar instanceof com.tencent.ams.fusion.service.splash.b.b.a) {
                this.f70345a.a();
            }
        }

        @Override // kt.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public g c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (g) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return null;
        }

        @Override // kt.a
        public void a(kt.c<?, ?> cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.service.splash.b.b.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0677b implements kt.a<g> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.fusion.service.c.a.a f70347a;

        C0677b(com.tencent.ams.fusion.service.c.a.a aVar) {
            this.f70347a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
            }
        }

        @Override // kt.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // kt.a
        public void b(kt.c<?, ?> cVar, kt.e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) eVar);
            } else if (cVar instanceof com.tencent.ams.fusion.service.splash.b.b.c) {
                this.f70347a.a();
            }
        }

        @Override // kt.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public g c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (g) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return null;
        }

        @Override // kt.a
        public void a(kt.c<?, ?> cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements nt.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f70349a;

        /* renamed from: b, reason: collision with root package name */
        private long f70350b;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f70349a = 0;
            }
        }

        @Override // nt.b
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f70349a;
        }

        @Override // kt.e
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }

        @Override // kt.e
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f70350b : ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }

        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f70349a = i3;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }

        public void c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.f70350b = j3;
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements nt.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private rt.c f70351a;

        /* renamed from: b, reason: collision with root package name */
        private long f70352b;

        /* renamed from: c, reason: collision with root package name */
        private int f70353c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f70354d;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f70354d = true;
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.f70353c = i3;
            }
        }

        @Override // kt.e
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f70354d : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }

        public void c(rt.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f70351a = cVar;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            }
        }

        public void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.f70352b = j3;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // kt.e
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f70352b : ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements kt.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f70355a;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.f70355a = j3;
            }
        }

        @Override // kt.e
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // kt.e
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.f70355a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class f implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f70356a;

        /* renamed from: b, reason: collision with root package name */
        private long f70357b;

        /* renamed from: c, reason: collision with root package name */
        private int f70358c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f70359d;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f70359d = true;
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.f70358c = i3;
            }
        }

        @Override // kt.e
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f70359d : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f70356a = str;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        public void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.f70359d = z16;
            }
        }

        public void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.f70357b = j3;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // kt.e
        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f70357b : ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private com.tencent.ams.fusion.service.c.a.a<nt.f, g> d(nt.e eVar, com.tencent.ams.fusion.service.splash.data.a aVar) {
        com.tencent.ams.fusion.service.splash.b.b.a aVar2 = new com.tencent.ams.fusion.service.splash.b.b.a();
        aVar2.h(aVar);
        aVar2.i(h(eVar));
        com.tencent.ams.fusion.service.splash.b.b.e eVar2 = new com.tencent.ams.fusion.service.splash.b.b.e();
        eVar2.h(aVar);
        eVar2.i(h(eVar));
        com.tencent.ams.fusion.service.c.a.a<nt.f, g> aVar3 = new com.tencent.ams.fusion.service.c.a.a<>("ParseAndSaveTask");
        aVar3.f(aVar2);
        aVar3.f(eVar2);
        aVar3.c(new a(aVar3));
        return aVar3;
    }

    private com.tencent.ams.fusion.service.c.a.a<nt.f, g> f(nt.e eVar, com.tencent.ams.fusion.service.splash.data.a aVar) {
        com.tencent.ams.fusion.service.splash.b.b.c cVar;
        com.tencent.ams.fusion.service.splash.b.b.f fVar = null;
        if (com.tencent.ams.fusion.service.splash.a.a.d().u()) {
            cVar = new com.tencent.ams.fusion.service.splash.b.b.c();
            cVar.e(aVar);
            cVar.g(h(eVar));
        } else {
            cVar = null;
        }
        if (com.tencent.ams.fusion.service.splash.a.a.d().t()) {
            fVar = new com.tencent.ams.fusion.service.splash.b.b.f();
            fVar.h(aVar);
            fVar.i(h(eVar));
        }
        com.tencent.ams.fusion.service.c.a.a<nt.f, g> aVar2 = new com.tencent.ams.fusion.service.c.a.a<>("CleanAndSerializeTask");
        if (cVar != null) {
            aVar2.f(cVar);
        }
        if (fVar != null) {
            aVar2.f(fVar);
        }
        aVar2.c(new C0677b(aVar2));
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(nt.e eVar) {
        if (eVar == null) {
            com.tencent.ams.fusion.a.f.i("preloadOrderRequest is null");
            return;
        }
        com.tencent.ams.fusion.service.splash.data.a aVar = new com.tencent.ams.fusion.service.splash.data.a();
        com.tencent.ams.fusion.service.splash.b.b.b bVar = new com.tencent.ams.fusion.service.splash.b.b.b();
        bVar.m(aVar);
        bVar.p(h(eVar));
        com.tencent.ams.fusion.service.c.a.b bVar2 = new com.tencent.ams.fusion.service.c.a.b("PreloadTasks");
        bVar2.a(bVar);
        bVar2.a(d(eVar, aVar));
        bVar2.a(f(eVar, aVar));
        if (com.tencent.ams.fusion.service.splash.a.a.d().u() && !eVar.f()) {
            com.tencent.ams.fusion.service.splash.b.b.d dVar = new com.tencent.ams.fusion.service.splash.b.b.d();
            dVar.o(h(eVar));
            dVar.j(aVar);
            bVar2.a(dVar);
        }
        com.tencent.ams.fusion.a.f.i("splash preloadInternal");
        bVar2.c();
    }

    @NonNull
    private com.tencent.ams.fusion.service.splash.b.b.a.a.a h(nt.e eVar) {
        com.tencent.ams.fusion.service.splash.b.b.a.a.a aVar = new com.tencent.ams.fusion.service.splash.b.b.a.a.a();
        aVar.a(eVar.d());
        aVar.e(eVar.c());
        aVar.c(eVar.b());
        aVar.d(eVar.a());
        aVar.b(eVar.e());
        aVar.f(eVar.f());
        return aVar;
    }

    @Override // nt.h
    public void b(nt.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            return;
        }
        lt.a g16 = com.tencent.ams.fusion.service.b.b().g();
        if (g16 != null) {
            g16.b(new Runnable(eVar) { // from class: com.tencent.ams.fusion.service.splash.b.b.a.b.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ nt.e f70343d;

                {
                    this.f70343d = eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this, (Object) eVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        b.this.g(this.f70343d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
