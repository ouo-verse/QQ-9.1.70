package com.tencent.luggage.wxa.ic;

import android.text.TextUtils;
import com.tencent.luggage.wxa.rj.c;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.xd.d;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements d.c {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.rj.c f129704a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.qc.c f129705b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.d f129706c;

    public c(g gVar, com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.rj.c cVar) {
        Objects.requireNonNull(dVar);
        this.f129706c = dVar;
        Objects.requireNonNull(cVar);
        this.f129704a = cVar;
        com.tencent.luggage.wxa.qc.c c06 = gVar.c0();
        Objects.requireNonNull(c06);
        this.f129705b = c06;
    }

    @Override // com.tencent.luggage.wxa.xd.d.c
    public void a(int i3, String str) {
    }

    public final void b(com.tencent.luggage.wxa.xd.k0 k0Var, com.tencent.luggage.wxa.ei.p pVar, d.b bVar) {
        boolean z16;
        boolean z17;
        com.tencent.luggage.wxa.qc.c cVar = this.f129705b;
        if (cVar.c()) {
            bVar.a("fail:interrupted");
            return;
        }
        if (!this.f129706c.a(k0Var.getName(), pVar)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", k0Var.getName(), this.f129706c.getAppId());
            bVar.a("fail:interrupted");
            return;
        }
        com.tencent.luggage.wxa.qc.b b16 = cVar.b();
        boolean a16 = this.f129704a.a(this.f129706c, k0Var.getClass());
        if (com.tencent.luggage.wxa.qc.b.SUSPEND != b16 && !a16) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.tencent.luggage.wxa.rj.k a17 = com.tencent.luggage.wxa.rj.w.a();
        if (a17 != null && a17.a(k0Var)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", Boolean.valueOf(z16), k0Var.getName(), b16, Boolean.valueOf(a16));
            if (x0.a()) {
                if (k0Var.getName().equals("onInitialRenderingCacheReady")) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", k0Var.getName(), Integer.valueOf(k0Var.getData().length()));
                } else {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", k0Var.getName(), k0Var.getData());
                }
            }
        }
        if (!z16) {
            bVar.a("fail:access denied");
        } else {
            bVar.proceed();
        }
    }

    public void a(com.tencent.luggage.wxa.xd.o oVar, String str, String str2, int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.xd.d.c
    public void a(com.tencent.luggage.wxa.xd.o oVar, String str, String str2, int i3, String str3) {
    }

    @Override // com.tencent.luggage.wxa.xd.d.c
    public boolean a(com.tencent.luggage.wxa.xd.o oVar, String str, String str2, int i3, d.b bVar) {
        c.d a16 = this.f129704a.a(this.f129706c, oVar, str, str2, i3, new a(bVar, oVar, str, str2, i3));
        int i16 = a16.f139804a;
        if (-2 == i16) {
            return true;
        }
        if (i16 == 0) {
            return false;
        }
        bVar.a(oVar.makeReturnJson(a16.f139805b, a16.f139806c));
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.b f129707a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.o f129708b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f129709c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f129710d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f129711e;

        public a(d.b bVar, com.tencent.luggage.wxa.xd.o oVar, String str, String str2, int i3) {
            this.f129707a = bVar;
            this.f129708b = oVar;
            this.f129709c = str;
            this.f129710d = str2;
            this.f129711e = i3;
        }

        @Override // com.tencent.luggage.wxa.rj.c.e
        public void a(c.d dVar) {
            if (c.this.f129706c == null || !c.this.f129706c.isRunning()) {
                return;
            }
            if (dVar.f139804a == 0) {
                this.f129707a.proceed();
            } else {
                this.f129707a.a(this.f129708b.makeReturnJson(TextUtils.isEmpty(dVar.f139805b) ? "fail:internal error" : dVar.f139805b, dVar.f139806c));
            }
        }

        @Override // com.tencent.luggage.wxa.rj.c.e
        public void a(int i3) {
            c.this.a(this.f129708b, this.f129709c, this.f129710d, this.f129711e, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d.c
    public void a(com.tencent.luggage.wxa.xd.k0 k0Var, com.tencent.luggage.wxa.ei.p pVar, d.b bVar) {
        try {
            b(k0Var, pVar, bVar);
        } catch (NullPointerException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentInterceptor", e16, "onDispatchImpl %s", k0Var.getName());
        }
    }
}
