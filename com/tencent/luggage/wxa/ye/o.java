package com.tencent.luggage.wxa.ye;

import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class o extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateTextView";

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        w.a("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i3), jSONObject);
        if (!(view instanceof b)) {
            w.h("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        com.tencent.luggage.wxa.il.h hVar = (com.tencent.luggage.wxa.il.h) ((b) view).a(com.tencent.luggage.wxa.il.h.class);
        if (hVar == null) {
            w.h("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", Integer.valueOf(i3));
        }
        com.tencent.luggage.wxa.gh.c.a(hVar, jSONObject.optJSONObject("label"));
        com.tencent.luggage.wxa.gh.f.a(view, jSONObject.optJSONObject("style"));
        return super.a(fVar, i3, view, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }
}
