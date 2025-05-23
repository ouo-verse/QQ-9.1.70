package com.tencent.luggage.wxa.rh;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.sd.c {
    @Override // com.tencent.luggage.wxa.sd.c
    public String e() {
        return "camera";
    }

    @Override // com.tencent.luggage.wxa.sd.c
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }
}
