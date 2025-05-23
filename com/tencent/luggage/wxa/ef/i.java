package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xk.a;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends h {

    /* renamed from: f, reason: collision with root package name */
    public final m f124697f = new m();

    @Override // com.tencent.luggage.wxa.ef.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(com.tencent.luggage.wxa.ic.l lVar) {
        this.f124697f.a(lVar.getRuntime());
    }

    @Override // com.tencent.luggage.wxa.ef.h
    public void a(com.tencent.luggage.wxa.ic.l lVar, int i3, String str, a.C6919a c6919a) {
        this.f124697f.b(lVar.getRuntime());
    }

    @Override // com.tencent.luggage.wxa.ef.h
    public a.b a(com.tencent.luggage.wxa.ic.l lVar, a.b bVar) {
        return n.a(lVar, bVar);
    }

    @Override // com.tencent.luggage.wxa.ef.h
    public Bundle a(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject) {
        Bundle a16 = super.a((com.tencent.luggage.wxa.xd.d) lVar, jSONObject);
        String optString = jSONObject.optString("subKey", "");
        String appId = lVar.getAppId();
        if (!w0.c(optString)) {
            a16.putString("smallAppKey", optString + "#" + appId + ";");
        }
        if (lVar.getRuntime() != null && lVar.getRuntime().j0() != null) {
            a16.putString("openId", ((com.tencent.luggage.wxa.j4.g) lVar.getRuntime().j0()).f130834j0);
        }
        w.g("MicroMsg.JsApiGetLocation", "getFuzzyLocation %s", jSONObject);
        return a16;
    }
}
