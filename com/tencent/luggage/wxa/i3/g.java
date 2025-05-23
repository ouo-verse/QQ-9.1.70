package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.fd.c0;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.eh;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.j7;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.hn.z7;
import com.tencent.luggage.wxa.ic.t0;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.n3.g0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129233a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129234b;

        public a(String str, com.tencent.luggage.wxa.p5.f fVar) {
            this.f129233a = str;
            this.f129234b = fVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "async update FAILED, appId[%s] exception[%s]", this.f129233a, obj);
            g.b(this.f129234b, com.tencent.luggage.wxa.lg.b.NO_UPDATE, 0, null, null, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129235a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129236b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j4.d f129237c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n0 f129238a;

            public a(n0 n0Var) {
                this.f129238a = n0Var;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public void a(Object obj) {
                com.tencent.luggage.wxa.p5.f fVar = b.this.f129236b;
                com.tencent.luggage.wxa.lg.b bVar = com.tencent.luggage.wxa.lg.b.UPDATE_FAILED;
                int i3 = this.f129238a.h().f125920a;
                n0 n0Var = this.f129238a;
                g.b(fVar, bVar, i3, null, n0Var.D, n0Var.F);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.g$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6276b implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n0 f129240a;

            public C6276b(n0 n0Var) {
                this.f129240a = n0Var;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public void a(com.tencent.mm.plugin.appbrand.appcache.a aVar) {
                com.tencent.luggage.wxa.p5.f fVar = b.this.f129236b;
                com.tencent.luggage.wxa.lg.b bVar = com.tencent.luggage.wxa.lg.b.UPDATE_READY;
                int i3 = this.f129240a.h().f125920a;
                n0 n0Var = this.f129240a;
                g.b(fVar, bVar, i3, null, n0Var.D, n0Var.F);
            }
        }

        public b(String str, com.tencent.luggage.wxa.p5.f fVar, com.tencent.luggage.wxa.j4.d dVar) {
            this.f129235a = str;
            this.f129236b = fVar;
            this.f129237c = dVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(se seVar) {
            if (seVar != null) {
                o0.a().b(this.f129235a, seVar);
                n0 a16 = o0.a().a(this.f129235a, "versionInfo", "passThroughInfo");
                if (a16 == null || a16.h() == null) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "after async update, get invalid info, appId=%s", this.f129235a);
                    g.b(this.f129236b, com.tencent.luggage.wxa.lg.b.NO_UPDATE, 0, null, null, null);
                } else if (a16.h().f125920a <= this.f129237c.V) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "after async update, version(%d) no change, appId=%s", Integer.valueOf(a16.h().f125920a), this.f129235a);
                    g.b(this.f129236b, com.tencent.luggage.wxa.lg.b.NO_UPDATE, a16.h().f125920a, a16.h().f125921b, a16.D, a16.F);
                } else {
                    g.b(this.f129236b, com.tencent.luggage.wxa.lg.b.UPDATING, a16.h().f125920a, a16.h().f125921b, a16.D, a16.F);
                    com.tencent.luggage.wxa.xo.h.a(this.f129236b, a16).c(new j()).a(new C6276b(a16)).a(new a(a16));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129242a;

        public c(String str) {
            this.f129242a = str;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(se seVar) {
            if (seVar != null) {
                o0.a().b(this.f129242a, seVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.lg.b f129243a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129244b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f129245c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f129246d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f129247e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f129248f;

        public d(com.tencent.luggage.wxa.lg.b bVar, com.tencent.luggage.wxa.p5.f fVar, int i3, String str, String str2, String str3) {
            this.f129243a = bVar;
            this.f129244b = fVar;
            this.f129245c = i3;
            this.f129246d = str;
            this.f129247e = str2;
            this.f129248f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f129243a.a(this.f129244b.h0(), this.f129245c, this.f129246d, this.f129247e, this.f129248f);
        }
    }

    public static void a(com.tencent.luggage.wxa.j4.g gVar) {
    }

    public static void b(com.tencent.luggage.wxa.p5.f fVar, com.tencent.luggage.wxa.lg.b bVar, int i3, String str, String str2, String str3) {
        fVar.c(new d(bVar, fVar, i3, str, str2, str3));
    }

    public static com.tencent.luggage.wxa.j4.g a(String str, n0 n0Var, com.tencent.mm.plugin.appbrand.appcache.a aVar, i6 i6Var) {
        char c16;
        com.tencent.luggage.wxa.fn.c cVar;
        long c17 = w0.c();
        com.tencent.luggage.wxa.j4.g gVar = new com.tencent.luggage.wxa.j4.g();
        gVar.f125966l = aVar;
        com.tencent.luggage.wxa.rj.b bVar = new com.tencent.luggage.wxa.rj.b(i6Var.f127859f);
        o a16 = o.a(str, i6Var.f127858e, i6Var.f127867n);
        String str2 = i6Var.f127866m;
        z7 z7Var = i6Var.f127861h;
        boolean z16 = z7Var != null && z7Var.f129141j;
        boolean z17 = i6Var.f127858e.f127477d == 5;
        boolean z18 = i6Var.f127870q;
        eh ehVar = i6Var.f127867n;
        gVar.J = new com.tencent.luggage.wxa.j4.i(bVar, a16, str2, z16, z17, null, z18, ehVar != null ? ehVar.f127580f : null);
        j7 j7Var = i6Var.f127863j;
        if (j7Var == null || w0.c(j7Var.f127945d)) {
            c16 = 0;
        } else {
            gVar.M = i6Var.f127863j.f127945d;
            try {
                JSONObject jSONObject = new JSONObject(i6Var.f127863j.f127945d).getJSONObject("privacy");
                gVar.f125962h = jSONObject.getInt("banLocationIfEmptyDesc") == 1;
                gVar.f125963i = jSONObject.getInt("banGetWifiListIfEmptyDesc") == 1;
                c16 = 0;
            } catch (JSONException unused) {
                c16 = 0;
                gVar.f125962h = false;
                gVar.f125963i = false;
            }
            c0.a(gVar, gVar.M);
        }
        gVar.f130831g0 = com.tencent.luggage.wxa.fd.h.b();
        t0.a(gVar, n0Var);
        a(gVar);
        gVar.f125967m = 2;
        com.tencent.luggage.wxa.hn.a aVar2 = i6Var.f127862i;
        if (aVar2 != null && (cVar = aVar2.f127251h) != null) {
            gVar.f130835k0 = cVar.a();
        }
        Object[] objArr = new Object[2];
        objArr[c16] = Long.valueOf(w0.c() - c17);
        objArr[1] = str;
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "[perf] prepare assemble sysConfig cost %dms, appId[%s]", objArr);
        return gVar;
    }

    public static void a(com.tencent.luggage.wxa.p5.f fVar, com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.j4.g gVar) {
        long c16 = w0.c();
        if (gVar != null) {
            String str = dVar.f125808a;
            int i3 = dVar.f125811d;
            if (e.a.b(i3)) {
                if (!dVar.m() && g0.a(str)) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "async update attr, appId=%s", str);
                    g0.b(str).a(com.tencent.luggage.wxa.yo.d.f146046c, new b(str, fVar, dVar)).a(new a(str, fVar));
                } else {
                    b(fVar, com.tencent.luggage.wxa.lg.b.NO_UPDATE, 0, null, null, null);
                }
            } else if (i3 == 2) {
                if (!dVar.m() && g0.a(str)) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "async update attr, appId=%s", str);
                    g0.b(str).a(com.tencent.luggage.wxa.yo.d.f146046c, new c(str));
                }
                b(fVar, com.tencent.luggage.wxa.lg.b.NO_UPDATE, 0, null, null, null);
            } else {
                b(fVar, com.tencent.luggage.wxa.lg.b.NO_UPDATE, 0, null, null, null);
            }
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "[perf] prepare bonus cost %dms, appId[%s]", Long.valueOf(w0.c() - c16), fVar.getAppId());
    }
}
