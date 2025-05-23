package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xk.a;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends k {

    /* renamed from: b, reason: collision with root package name */
    public final m f124703b = new m();

    @Override // com.tencent.luggage.wxa.ef.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(com.tencent.luggage.wxa.ic.l lVar) {
        this.f124703b.a(lVar.getRuntime());
    }

    @Override // com.tencent.luggage.wxa.ef.k
    public void a(com.tencent.luggage.wxa.ic.l lVar, int i3, String str, a.C6919a c6919a) {
        this.f124703b.b(lVar.getRuntime());
    }

    @Override // com.tencent.luggage.wxa.ef.k
    public a.b a(com.tencent.luggage.wxa.ic.l lVar, a.b bVar) {
        return n.a(lVar, bVar);
    }

    @Override // com.tencent.luggage.wxa.ef.k
    public Bundle a(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject) {
        Bundle a16 = super.a((com.tencent.luggage.wxa.xd.d) lVar, jSONObject);
        String optString = jSONObject.optString("subKey", "");
        String appId = lVar.getAppId();
        if (!w0.c(optString)) {
            a16.putString("smallAppKey", optString + "#" + appId + ";");
        }
        a16.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        if (lVar.getRuntime() != null && lVar.getRuntime().j0() != null) {
            a16.putString("openId", ((com.tencent.luggage.wxa.j4.g) lVar.getRuntime().j0()).f130834j0);
        }
        w.g("MicroMsg.JsApiGetLocation", "getLocation %s", jSONObject);
        return a16;
    }
}
