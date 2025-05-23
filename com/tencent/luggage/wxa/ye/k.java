package com.tencent.luggage.wxa.ye;

import android.view.View;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k extends com.tencent.luggage.wxa.ee.c {
    private static final int CTRL_INDEX = 448;
    public static final String NAME = "removeScrollView";

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        fVar.a(getIndependent(jSONObject)).h(i3);
        return super.a(fVar, i3, view, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }
}
