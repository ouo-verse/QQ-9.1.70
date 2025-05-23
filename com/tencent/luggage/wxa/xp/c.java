package com.tencent.luggage.wxa.xp;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c extends d {
    public void a(String str, int i3) {
        com.tencent.luggage.wxa.np.e.a("Soter.BaseSoterPrepareKeyTask", "soter: marking preference. key: %s, status: %d", str, Integer.valueOf(i3));
        synchronized (com.tencent.luggage.wxa.tp.b.class) {
            if (com.tencent.luggage.wxa.tp.b.c().d() != null) {
                com.tencent.luggage.wxa.tp.b.c().d().edit().putInt(str, i3).commit();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void c(com.tencent.luggage.wxa.sp.e eVar) {
    }
}
