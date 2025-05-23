package com.tencent.luggage.wxa.se;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.ee.c {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }
}
