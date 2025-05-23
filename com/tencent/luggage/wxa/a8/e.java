package com.tencent.luggage.wxa.a8;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f120929a = false;

    public static com.tencent.luggage.wxa.ph.a a(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.a("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
        if (!f120929a) {
            com.tencent.luggage.wxa.tn.w.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, not support");
            return null;
        }
        com.tencent.luggage.wxa.ic.g a16 = a(cVar.e());
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
            return null;
        }
        if (!a16.t0() && !a16.w0()) {
            com.tencent.luggage.wxa.ph.a aVar = (com.tencent.luggage.wxa.ph.a) a16.c(com.tencent.luggage.wxa.ph.a.class);
            if (aVar != null) {
                return aVar;
            }
            com.tencent.luggage.wxa.tn.w.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
            com.tencent.luggage.wxa.ph.a aVar2 = new com.tencent.luggage.wxa.ph.a(a16);
            a16.a((com.tencent.luggage.wxa.xd.m) aVar2);
            return aVar2;
        }
        com.tencent.luggage.wxa.tn.w.f("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is destroyed or finishing");
        return null;
    }

    public static com.tencent.luggage.wxa.ic.g a(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
            return ((com.tencent.luggage.wxa.kj.v) dVar).getRuntime();
        }
        if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
            return ((com.tencent.luggage.wxa.ic.l) dVar).getRuntime();
        }
        return null;
    }
}
