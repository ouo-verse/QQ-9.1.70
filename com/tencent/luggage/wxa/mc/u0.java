package com.tencent.luggage.wxa.mc;

import com.tencent.luggage.wxa.mc.t0;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements t0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f134396a;

        public a(com.tencent.luggage.wxa.ic.g gVar) {
            this.f134396a = gVar;
        }

        @Override // com.tencent.luggage.wxa.mc.t0.b
        public boolean a() {
            return this.f134396a.u0();
        }

        @Override // com.tencent.luggage.wxa.mc.t0.b
        public com.tencent.mm.plugin.appbrand.appcache.a b() {
            return ((com.tencent.luggage.wxa.fd.q) this.f134396a.a(com.tencent.luggage.wxa.fd.q.class)).f125966l;
        }

        @Override // com.tencent.luggage.wxa.mc.t0.b
        public String getAppId() {
            return this.f134396a.getAppId();
        }

        @Override // com.tencent.luggage.wxa.mc.t0.b
        public void a(com.tencent.luggage.wxa.fd.p pVar) {
            this.f134396a.J().add(pVar);
        }
    }

    public static m a(com.tencent.luggage.wxa.ic.g gVar, k0 k0Var) {
        k0Var.a("__plugin__/");
        k0Var.a(WxaPluginPkgInfo.PREFIX_EXTENDED);
        return new t0(new a(gVar), k0Var);
    }
}
