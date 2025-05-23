package com.tencent.luggage.wxa.x7;

import com.tencent.luggage.wxa.n3.l0;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f144642a = new i();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements e.a {
        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a(com.tencent.luggage.wxa.o3.j jVar) {
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a() {
            w.d("TdiAccountManagerInstaller", "onAccountLogout, killAll");
            com.tencent.luggage.wxa.z4.f.f146283b.a().a(com.tencent.luggage.wxa.z4.c.KILL_TYPE_SILENT);
        }
    }

    public final void a() {
        l lVar = l.f136139a;
        if (!(lVar.j() instanceof com.tencent.luggage.wxa.p3.f)) {
            w.b("TdiAccountManagerInstaller", "install wxaAccountManager");
            if (z.m()) {
                lVar.a(new k());
            } else {
                lVar.a(new j());
            }
            lVar.a(true);
            lVar.b(new a());
        }
        com.tencent.luggage.wxa.p3.k kVar = com.tencent.luggage.wxa.p3.k.f137201a;
        com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p3.d.class, kVar);
        l0.f135214b.a(kVar);
    }
}
