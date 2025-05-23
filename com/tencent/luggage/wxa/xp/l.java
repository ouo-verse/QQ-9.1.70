package com.tencent.luggage.wxa.xp;

import com.tencent.luggage.wxa.vp.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l extends c {

    /* renamed from: c, reason: collision with root package name */
    public String f145352c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f145353d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f145354e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f145355f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.sp.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.sp.b
        public void a(com.tencent.luggage.wxa.sp.c cVar) {
            com.tencent.luggage.wxa.np.e.a("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", cVar.toString());
            if (cVar.f135896a == 0) {
                l.this.g();
            } else {
                l.this.a(cVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.luggage.wxa.vp.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.vp.a
        public void a(int i3, String str) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", l.this.f145352c, Integer.valueOf(i3), str);
            l lVar = l.this;
            lVar.a(lVar.f145352c, 0);
            l.this.a(new com.tencent.luggage.wxa.sp.c(i3, str));
        }

        @Override // com.tencent.luggage.wxa.vp.a
        public void onSuccess() {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
            l.c(l.this);
            l lVar = l.this;
            lVar.a(lVar.f145352c, 0);
            l.this.h();
        }
    }

    public l(int i3, com.tencent.luggage.wxa.wp.c cVar, com.tencent.luggage.wxa.wp.c cVar2, boolean z16, boolean z17) {
        this.f145353d = i3;
        this.f145354e = z16;
        this.f145355f = z17;
    }

    public static /* synthetic */ com.tencent.luggage.wxa.wp.c c(l lVar) {
        lVar.getClass();
        return null;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean d() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void e() {
        com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", this.f145352c);
        com.tencent.luggage.wxa.jp.a.b(this.f145352c, false);
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean f() {
        if (!com.tencent.luggage.wxa.tp.b.c().e()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(1008));
            return true;
        }
        if (!com.tencent.luggage.wxa.tp.b.c().f()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(2));
            return true;
        }
        String str = (String) com.tencent.luggage.wxa.tp.b.c().b().get(this.f145353d, "");
        this.f145352c = str;
        if (com.tencent.luggage.wxa.np.i.a(str)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.f145353d))));
            return true;
        }
        boolean g16 = com.tencent.luggage.wxa.jp.a.g();
        if (!g16 && com.tencent.luggage.wxa.jp.a.d(this.f145352c)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
            com.tencent.luggage.wxa.jp.a.b(this.f145352c, false);
        }
        if (!g16 && !this.f145355f) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(3));
            return true;
        }
        if (com.tencent.luggage.wxa.jp.a.d(this.f145352c) && !com.tencent.luggage.wxa.jp.a.a(this.f145352c, true)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
            return false;
        }
        if (com.tencent.luggage.wxa.jp.a.d(this.f145352c) && !this.f145354e) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(0, com.tencent.luggage.wxa.jp.a.c(this.f145352c)));
            return true;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
        return false;
    }

    public final void g() {
        a(this.f145352c, 1);
        new b.C6856b().a(this.f145352c, this.f145354e).a(new b()).a().b();
    }

    public final void h() {
        com.tencent.luggage.wxa.np.k c16 = com.tencent.luggage.wxa.jp.a.c(this.f145352c);
        if (c16 == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
            com.tencent.luggage.wxa.jp.a.b(this.f145352c, false);
            a(new com.tencent.luggage.wxa.sp.c(1006, "auth key model is null even after generation."));
        } else {
            com.tencent.luggage.wxa.np.e.a("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.c(0, "treat as normal because you do not provide the net wrapper", c16));
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void b() {
        if (!com.tencent.luggage.wxa.jp.a.g() && this.f145355f) {
            com.tencent.luggage.wxa.np.e.a("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
            com.tencent.luggage.wxa.qp.a.a((com.tencent.luggage.wxa.sp.b) new a(), false, (com.tencent.luggage.wxa.wp.c) null);
        } else {
            g();
        }
    }
}
