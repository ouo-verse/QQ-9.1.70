package com.tencent.luggage.wxa.xp;

import com.tencent.luggage.wxa.vp.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k extends c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f145350c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.vp.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.vp.a
        public void a(int i3, String str) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", Integer.valueOf(i3), str);
            k.this.a(com.tencent.luggage.wxa.np.g.b().a(), 0);
            k.this.a(new com.tencent.luggage.wxa.sp.c(i3, str));
        }

        @Override // com.tencent.luggage.wxa.vp.a
        public void onSuccess() {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
            k.a(k.this);
            k.this.a(com.tencent.luggage.wxa.np.g.b().a(), 0);
            k.this.g();
        }
    }

    public k(com.tencent.luggage.wxa.wp.c cVar, boolean z16) {
        this.f145350c = z16;
    }

    public static /* synthetic */ com.tencent.luggage.wxa.wp.c a(k kVar) {
        kVar.getClass();
        return null;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean d() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void e() {
        com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        com.tencent.luggage.wxa.jp.a.i();
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean f() {
        if (!com.tencent.luggage.wxa.tp.b.c().e()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(1008));
            return true;
        }
        if (!com.tencent.luggage.wxa.tp.b.c().f()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(2));
            return true;
        }
        if (com.tencent.luggage.wxa.jp.a.g() && !this.f145350c) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(0, com.tencent.luggage.wxa.jp.a.c()));
            return true;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
        return false;
    }

    public final void g() {
        com.tencent.luggage.wxa.np.k c16 = com.tencent.luggage.wxa.jp.a.c();
        if (c16 == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
            com.tencent.luggage.wxa.jp.a.i();
            a(new com.tencent.luggage.wxa.sp.c(3, "ask model is null even after generation."));
        } else {
            com.tencent.luggage.wxa.np.e.a("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(0, "treat as normal because you do not provide the net wrapper", c16));
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void b() {
        a(com.tencent.luggage.wxa.np.g.b().a(), 1);
        new b.C6856b().a(this.f145350c).a(new a()).a().b();
    }
}
