package com.tencent.luggage.wxa.ue;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.sd.c {
    @Override // com.tencent.luggage.wxa.sd.c
    public String e() {
        return "webgl";
    }

    @Override // com.tencent.luggage.wxa.sd.c
    public int getViewId(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("canvasId", -1);
    }
}
