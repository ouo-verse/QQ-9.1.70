package com.tencent.luggage.wxa.gf;

import android.view.View;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m0 extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 4;
    public static final String NAME = "updateMap";

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        com.tencent.luggage.wxa.hf.c.a(3);
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiUpdateMap", "data is null");
            return false;
        }
        String appId = fVar.getAppId();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", appId, Integer.valueOf(i3), jSONObject);
        com.tencent.luggage.wxa.hf.e.b(appId, com.tencent.luggage.wxa.hf.d.a(fVar, jSONObject));
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiUpdateMap", "mapView is null, return");
        return false;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", e16);
            return -1;
        }
    }
}
