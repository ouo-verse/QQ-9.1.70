package com.tencent.luggage.wxa.f3;

import android.view.View;
import com.tencent.luggage.wxa.xd.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.ee.c {
    public static final int CTRL_INDEX = 299;
    public static final String NAME = "removeHTMLWebView";

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(f fVar, int i3, View view, JSONObject jSONObject) {
        if (view instanceof a) {
            ((a) view).a();
        }
        return super.a(fVar, i3, view, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}
