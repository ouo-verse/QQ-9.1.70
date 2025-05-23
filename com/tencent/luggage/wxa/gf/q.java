package com.tencent.luggage.wxa.gf;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRotate";

    @Override // com.tencent.luggage.wxa.gf.a, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        super.invoke(dVar, jSONObject, i3);
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetMapRotate", "data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetMapRotate", "data:%s", jSONObject);
            a(dVar, jSONObject);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetMapRotate", "mapView is null, return");
            dVar.a(i3, makeReturnJson("fail:mapview is null"));
        }
    }
}
