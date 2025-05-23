package com.tencent.luggage.wxa.se;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean enableGesture() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }
}
