package com.tencent.luggage.wxa.zh;

import android.text.TextUtils;
import android.view.Surface;
import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.tk.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends a implements com.tencent.luggage.wxa.ph.d {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "insertXWebMap";

    public com.tencent.luggage.wxa.hf.a a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, Surface surface) {
        w.d("MicroMsg.JsApiInsertXWebMap", "insertXwebMap:%s", jSONObject);
        double a16 = w0.a(jSONObject.optString("centerLatitude"), 0.0d);
        double a17 = w0.a(jSONObject.optString("centerLongitude"), 0.0d);
        jSONObject.optDouble("scale", 16.0d);
        jSONObject.optInt(CanvasView.ACTION_ROTATE, 0);
        jSONObject.optInt("skew", 0);
        w0.a(jSONObject.optString("maxScale"), 20.0f);
        w0.a(jSONObject.optString("minScale"), 3.0f);
        if (Math.abs(a16) <= 90.0d && Math.abs(a17) <= 180.0d) {
            dVar.getAppId();
            String optString = jSONObject.optString("theme", "");
            String optString2 = jSONObject.optString("subKey", "");
            String appId = dVar.getAppId();
            String optString3 = jSONObject.optString("pluginId", "");
            if (!TextUtils.isEmpty(optString3)) {
                appId = optString3;
            }
            int optInt = jSONObject.optInt("styleId", 0);
            boolean optBoolean = jSONObject.optBoolean("enableDarkMode", false);
            boolean optBoolean2 = jSONObject.optBoolean("enableMSAA", false);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject == null) {
                w.b("MicroMsg.JsApiInsertXWebMap", "positionObj is null, err, return");
                return null;
            }
            int a18 = g.a(optJSONObject, "width", 0);
            int a19 = g.a(optJSONObject, "height", 0);
            com.tencent.luggage.wxa.hf.d.a(dVar, jSONObject);
            HashMap hashMap = new HashMap(5);
            hashMap.put("theme", optString);
            hashMap.put("subKey", optString2);
            hashMap.put("subId", appId);
            hashMap.put("styleId", Integer.valueOf(optInt));
            hashMap.put("surface", surface);
            hashMap.put("width", Integer.valueOf(a18));
            hashMap.put("height", Integer.valueOf(a19));
            hashMap.put("mapType", 2);
            hashMap.put("enableDarkMode", Integer.valueOf(optBoolean ? 1 : 0));
            hashMap.put("enableMSAA", Boolean.valueOf(optBoolean2));
            com.tencent.luggage.wxa.k0.d.a(e.a(com.tencent.luggage.wxa.hf.b.class));
            dVar.getContext();
            throw null;
        }
        w.a("MicroMsg.JsApiInsertXWebMap", "centerLatitude or centerLongitude value is error!");
        return null;
    }
}
