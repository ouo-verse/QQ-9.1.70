package com.tencent.luggage.wxa.we;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ee.c {
    public static final int CTRL_INDEX = 512;
    public static final String NAME = "removePositioningContainer";

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }
}
