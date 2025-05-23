package com.tencent.luggage.wxa.yi;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final k f145919a = x41.b.a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f145920a = new f();
    }

    public static f b() {
        return a.f145920a;
    }

    public int a() {
        return this.f145919a.a();
    }

    public d a(com.tencent.luggage.wxa.xd.d dVar) {
        com.tencent.luggage.wxa.er.a.b(dVar instanceof g);
        try {
            return (d) this.f145919a.a((g) dVar);
        } catch (NullPointerException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequestManager", "get client failed", e16);
            b(dVar);
            return null;
        }
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar instanceof g) {
            g gVar = (g) dVar;
            if (gVar instanceof h) {
                g a16 = ((h) gVar).a();
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandNetworkRequestManager", String.format("Proxy caller detected. TargetCaller: %s", a16 != null ? a16.toString() : "null"));
            }
        }
    }

    public d a(com.tencent.luggage.wxa.xd.d dVar, j jVar) {
        com.tencent.luggage.wxa.er.a.b(dVar instanceof g);
        try {
            return (d) this.f145919a.a((g) dVar, jVar);
        } catch (NullPointerException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequestManager", "getOrCreate client failed", e16);
            b(dVar);
            return null;
        }
    }

    public boolean a(g gVar) {
        return this.f145919a.b(gVar);
    }
}
