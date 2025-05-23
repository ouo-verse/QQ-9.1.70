package com.tencent.luggage.wxa.gf;

import android.view.View;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", e16);
            return -1;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        float a16 = w0.a(jSONObject.optString("centerLatitude"), 0.0f);
        float a17 = w0.a(jSONObject.optString("centerLongitude"), 0.0f);
        w0.a(jSONObject.optString("scale"), 16.0f);
        jSONObject.optInt(CanvasView.ACTION_ROTATE, 0);
        jSONObject.optInt("skew", 0);
        w0.a(jSONObject.optString("maxScale"), 20.0f);
        w0.a(jSONObject.optString("minScale"), 3.0f);
        if (Math.abs(a16) <= 90.0f && Math.abs(a17) <= 180.0f) {
            com.tencent.luggage.wxa.hf.c.a(0);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", fVar.getAppId(), Integer.valueOf(getViewId(jSONObject)), jSONObject);
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.hf.b.class));
            throw null;
        }
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
        return null;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertView(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        com.tencent.luggage.wxa.hf.e.b(fVar.getAppId(), com.tencent.luggage.wxa.hf.d.a(fVar, jSONObject));
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
    }
}
