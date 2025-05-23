package com.tencent.luggage.wxa.a6;

import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.bk.a;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.t;
import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.r6.h;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.xweb.internal.ConstValue;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.w1.a {
    public com.tencent.luggage.wxa.fj.a M;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f120887a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.bk.a f120888b;

        public a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.bk.a aVar) {
            this.f120887a = gVar;
            this.f120888b = aVar;
        }

        @Override // com.tencent.luggage.wxa.bk.a.b
        public void a(boolean z16, com.tencent.luggage.wxa.bj.a aVar) {
            if (!this.f120887a.t0() && !this.f120887a.w0()) {
                if (z16) {
                    com.tencent.luggage.wxa.r6.b.a(this.f120887a.getAppId(), this.f120888b, this.f120887a.j0());
                    return;
                } else {
                    w.f("Luggage.MGameServiceLogic", "get sampling failed!");
                    return;
                }
            }
            w.f("Luggage.MGameServiceLogic", "runtime finished. abort");
        }
    }

    static {
        com.tencent.luggage.wxa.s1.d.b();
    }

    public c(com.tencent.luggage.wxa.r4.d dVar) {
        super(dVar);
        this.M = null;
    }

    @Override // com.tencent.luggage.wxa.w1.a, com.tencent.luggage.wxa.r4.f
    public void T() {
        super.T();
        com.tencent.luggage.wxa.fj.a aVar = this.M;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.tencent.luggage.wxa.w1.a
    public void a(int i3) {
        super.a(i3);
        com.tencent.luggage.wxa.c5.e B = B();
        if ((B instanceof com.tencent.luggage.wxa.p5.f) && B.Q1()) {
            w.a("Luggage.MGameServiceLogic", "updateMainCanvasType");
            com.tencent.luggage.wxa.r6.g gVar = (com.tencent.luggage.wxa.r6.g) com.tencent.luggage.wxa.r6.b.a(x());
            if (gVar == null) {
                return;
            }
            gVar.e().f139356a = h.a.values()[i3];
        }
    }

    @Override // com.tencent.luggage.wxa.w1.a, com.tencent.luggage.wxa.r4.f
    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        super.b(gVar);
        if ((gVar instanceof com.tencent.luggage.wxa.p5.f) && ((com.tencent.luggage.wxa.p5.f) gVar).Q1()) {
            w.a("Luggage.MGameServiceLogic", "triggerGameExtraConfigMgr");
            com.tencent.luggage.wxa.bk.a aVar = new com.tencent.luggage.wxa.bk.a();
            aVar.a(gVar, new a(gVar, aVar));
        }
    }

    @Override // com.tencent.luggage.wxa.w1.a
    public String e0() {
        return com.tencent.luggage.wxa.q5.c.f137855a.a();
    }

    @Override // com.tencent.luggage.wxa.w1.a
    public String f0() {
        String f06 = super.f0();
        if (this.M != null) {
            return f06 + this.M.a();
        }
        return f06;
    }

    @Override // com.tencent.luggage.wxa.w1.a
    public void n0() {
        super.n0();
        try {
            com.tencent.luggage.wxa.p8.b.b("gamelog_delegate");
        } catch (LinkageError e16) {
            w.b("Luggage.MGameServiceLogic", "load libgamelog_delegate.so failed %s", e16);
        }
        CronetLogic.initializeNativeLib();
    }

    @Override // com.tencent.luggage.wxa.w1.a
    public j a(String str, byte[] bArr) {
        com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) t();
        Objects.requireNonNull(dVar);
        q i3 = dVar.i();
        Objects.requireNonNull(i3);
        d.a aVar = new d.a();
        aVar.f122185a = str;
        aVar.f122188d = null;
        aVar.f122190f = "1";
        aVar.f122191g = true;
        aVar.f122193i = true;
        aVar.f122194j = false;
        aVar.f122198n = Boolean.parseBoolean(i3.h("delayedServiceCodeCache"));
        com.tencent.luggage.wxa.ei.w wVar = new com.tencent.luggage.wxa.ei.w(aVar);
        d dVar2 = new d();
        this.M = dVar2;
        dVar2.a((l) t(), wVar, e.a.Service);
        return wVar;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, com.tencent.luggage.wxa.gn.a.f126802f);
            jSONObject.put("JSEngineName", com.tencent.luggage.wxa.u4.b.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime()));
        } catch (JSONException e16) {
            w.a("Luggage.MGameServiceLogic", e16, "attachCommonConfig error", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.w1.a
    public com.tencent.luggage.wxa.w1.e a(com.tencent.luggage.wxa.r4.d dVar, t tVar) {
        return new h(dVar, tVar);
    }
}
