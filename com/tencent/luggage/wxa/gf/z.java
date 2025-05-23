package com.tencent.luggage.wxa.gf;

import android.view.View;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z extends com.tencent.luggage.wxa.ee.c {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiRemoveMap", "data is null");
            return false;
        }
        com.tencent.luggage.wxa.hf.c.a(6);
        if (com.tencent.luggage.wxa.hf.e.a(fVar.getAppId(), com.tencent.luggage.wxa.hf.d.a(fVar, jSONObject))) {
            com.tencent.luggage.wxa.hf.c.a(7);
            return true;
        }
        com.tencent.luggage.wxa.hf.c.a(8);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return com.tencent.luggage.wxa.hf.d.a(jSONObject);
    }
}
