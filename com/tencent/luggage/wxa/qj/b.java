package com.tencent.luggage.wxa.qj;

import android.os.Process;
import android.util.SparseArray;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.qj.f;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f138886a = new SparseArray();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.c5.e f138887a;

        /* renamed from: b, reason: collision with root package name */
        public final String f138888b;

        /* renamed from: h, reason: collision with root package name */
        public volatile boolean f138894h;

        /* renamed from: j, reason: collision with root package name */
        public f f138896j;

        /* renamed from: c, reason: collision with root package name */
        public volatile double f138889c = 0.0d;

        /* renamed from: d, reason: collision with root package name */
        public volatile int f138890d = 4;

        /* renamed from: e, reason: collision with root package name */
        public volatile boolean f138891e = true;

        /* renamed from: f, reason: collision with root package name */
        public volatile boolean f138892f = false;

        /* renamed from: g, reason: collision with root package name */
        public volatile boolean f138893g = false;

        /* renamed from: k, reason: collision with root package name */
        public e.c f138897k = new c();

        /* renamed from: i, reason: collision with root package name */
        public e f138895i = new e(Process.myPid());

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.qj.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6648a implements f.a {
            public C6648a() {
            }

            @Override // com.tencent.luggage.wxa.qj.f.a
            public void a(double d16) {
                if (Math.round(a.this.f138889c) != Math.round(d16)) {
                    a.this.f138889c = d16;
                    b.a(a.this.f138887a, 303, Math.round(a.this.f138889c) + " fps");
                    a aVar = a.this;
                    com.tencent.luggage.wxa.qj.c.a(aVar.f138888b, "Hardware", PreDownloadConstants.RPORT_KEY_FPS, aVar.f138889c);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.qj.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6649b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ig.b f138899a;

            public RunnableC6649b(com.tencent.luggage.wxa.ig.b bVar) {
                this.f138899a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.a(a.this.f138887a, 401, w0.b(this.f138899a.f130263d));
                this.f138899a.f();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c extends e.c {
            public c() {
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onDestroy() {
                super.onDestroy();
                a.this.m();
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onPause(e.d dVar) {
                super.onPause(dVar);
                a.this.j();
            }

            @Override // com.tencent.luggage.wxa.ic.e.c
            public void onResume() {
                super.onResume();
                a.this.k();
            }
        }

        public a(com.tencent.luggage.wxa.c5.e eVar) {
            this.f138894h = false;
            this.f138887a = eVar;
            this.f138888b = eVar.getAppId();
            this.f138894h = false;
        }

        public void g() {
            int b16 = w0.b(z.c());
            b.a(this.f138887a, 102, b16 + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
            com.tencent.luggage.wxa.qj.c.a(this.f138888b, "Hardware", "MEMORY", (double) b16);
        }

        public final void h() {
            com.tencent.luggage.wxa.j4.g j06 = this.f138887a.j0();
            if (j06 == null) {
                return;
            }
            if (j06.f125967m == 1) {
                com.tencent.luggage.wxa.ig.b bVar = new com.tencent.luggage.wxa.ig.b();
                bVar.f130262c = this.f138888b;
                bVar.f130264e = new RunnableC6649b(bVar);
                bVar.b();
                return;
            }
            b.a(this.f138887a, 401, w0.b(((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(this.f138888b, j06.f125967m, j06.D).b(this.f138888b)));
        }

        public final boolean i() {
            return true;
        }

        public void j() {
            f fVar;
            this.f138892f = true;
            if (i() && (fVar = this.f138896j) != null) {
                fVar.e();
            }
        }

        public void k() {
            f fVar;
            this.f138892f = false;
            if (i() && (fVar = this.f138896j) != null) {
                fVar.d();
            }
        }

        public void l() {
            f fVar;
            if (!this.f138894h && i()) {
                C6648a c6648a = new C6648a();
                f fVar2 = new f();
                this.f138896j = fVar2;
                fVar2.a(100L);
                this.f138896j.a(c6648a);
            }
            this.f138891e = true;
            l.a().d(this);
            com.tencent.luggage.wxa.ic.e.a(this.f138888b, this.f138897k);
            if (i() && (fVar = this.f138896j) != null) {
                fVar.d();
            }
        }

        public void m() {
            f fVar;
            this.f138891e = false;
            com.tencent.luggage.wxa.ic.e.b(this.f138888b, this.f138897k);
            if (i() && (fVar = this.f138896j) != null) {
                fVar.e();
            }
            e eVar = this.f138895i;
            if (eVar != null) {
                eVar.close();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f138887a.t0()) {
                return;
            }
            if (this.f138891e && !this.f138892f) {
                a();
                g();
                f();
                c();
                b();
                e();
                d();
                this.f138890d++;
                if (this.f138890d >= 4) {
                    this.f138890d = 0;
                    h();
                }
            }
            if (this.f138891e) {
                l.a().b(this, 1000L);
            }
        }

        public final void a() {
            double d16 = this.f138895i.d();
            b.a(this.f138887a, 101, ((int) d16) + "%");
            com.tencent.luggage.wxa.qj.c.a(this.f138888b, "Hardware", PreDownloadConstants.RPORT_KEY_CPU, d16);
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }
    }

    public static void a(String str) {
        w.a("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", str);
        int hashCode = str.hashCode();
        SparseArray sparseArray = f138886a;
        a aVar = (a) sparseArray.get(hashCode);
        if (aVar != null) {
            sparseArray.remove(hashCode);
            aVar.m();
        }
    }

    public static void b(com.tencent.luggage.wxa.c5.e eVar) {
        c(eVar);
        a(eVar);
    }

    public static void c(com.tencent.luggage.wxa.c5.e eVar) {
        String appId = eVar.getAppId();
        com.tencent.luggage.wxa.ok.e K1 = eVar.K1();
        a.c d16 = com.tencent.luggage.wxa.nb.a.a().d(appId.hashCode() + "performance_data");
        if (K1 == null) {
            w.b("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
            return;
        }
        if (d16 == null) {
            w.a("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
            return;
        }
        for (String str : d16.a()) {
            String str2 = (String) d16.b(str);
            if (str2 != null) {
                K1.a(w0.a(str, 0), str2);
            }
        }
    }

    public static boolean d(com.tencent.luggage.wxa.c5.e eVar) {
        return a((com.tencent.luggage.wxa.qj.a) eVar.a(com.tencent.luggage.wxa.qj.a.class));
    }

    public static void e(com.tencent.luggage.wxa.c5.e eVar) {
        String appId = eVar.getAppId();
        w.a("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", appId);
        SparseArray sparseArray = f138886a;
        a aVar = (a) sparseArray.get(appId.hashCode());
        if (aVar == null) {
            aVar = new a(eVar);
            sparseArray.put(appId.hashCode(), aVar);
        }
        aVar.l();
    }

    public static boolean a(com.tencent.luggage.wxa.qj.a aVar) {
        return aVar != null && aVar.f138883a;
    }

    public static void a(com.tencent.luggage.wxa.c5.e eVar, int i3, String str) {
        String appId = eVar.getAppId();
        com.tencent.luggage.wxa.ok.e K1 = eVar.K1();
        if (K1 == null) {
            com.tencent.luggage.wxa.nb.a.a().a(appId.hashCode() + "performance_data", true).b(String.valueOf(i3), (Object) str);
            return;
        }
        K1.a(i3, str);
    }

    public static void a(com.tencent.luggage.wxa.c5.e eVar, String str, String str2) {
        String appId = eVar.getAppId();
        com.tencent.luggage.wxa.ok.e K1 = eVar.K1();
        if (K1 == null) {
            com.tencent.luggage.wxa.nb.a.a().a(appId.hashCode() + "performance_custom_data", true).b(str, (Object) str2);
            return;
        }
        K1.a(str, str2);
    }

    public static void a(com.tencent.luggage.wxa.c5.e eVar) {
        String appId = eVar.getAppId();
        com.tencent.luggage.wxa.ok.e K1 = eVar.K1();
        a.c d16 = com.tencent.luggage.wxa.nb.a.a().d(appId.hashCode() + "performance_custom_data");
        if (K1 == null) {
            w.b("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
            return;
        }
        if (d16 == null) {
            w.a("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
            return;
        }
        for (String str : d16.a()) {
            String str2 = (String) d16.b(str);
            if (str2 != null) {
                K1.a(str, str2);
            }
        }
    }
}
