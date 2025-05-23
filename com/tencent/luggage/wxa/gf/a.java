package com.tencent.luggage.wxa.gf;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.xd.a {
    public void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, boolean z16, boolean z17) {
        dVar.a(i3, str);
        com.tencent.luggage.wxa.hf.c.a(getName(), z16, z17);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.hf.c.a(getName());
    }

    public com.tencent.luggage.wxa.hf.a a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        if (dVar instanceof com.tencent.luggage.wxa.xd.f) {
            com.tencent.luggage.wxa.hf.e.b(dVar.getAppId(), com.tencent.luggage.wxa.hf.d.a(dVar, jSONObject));
            return null;
        }
        if (dVar.b(com.tencent.luggage.wxa.ee.g.class) == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", getName());
            return null;
        }
        com.tencent.luggage.wxa.xd.f a16 = ((com.tencent.luggage.wxa.ee.g) dVar.b(com.tencent.luggage.wxa.ee.g.class)).a(dVar, jSONObject);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.BaseMapJsApi", "name:%s is not componentView", getName());
            return null;
        }
        com.tencent.luggage.wxa.hf.e.b(a16.getAppId(), com.tencent.luggage.wxa.hf.d.a(a16, jSONObject));
        return null;
    }
}
