package com.tencent.luggage.wxa.v3;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public int f143115a;

    /* renamed from: b, reason: collision with root package name */
    public String f143116b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143117c;

    /* renamed from: d, reason: collision with root package name */
    public String f143118d;

    public static j a(WXLaunchMiniProgram.Resp resp) {
        JSONException e16;
        j jVar;
        JSONObject jSONObject;
        boolean z16;
        try {
            jSONObject = new JSONObject(resp.extMsg);
            jVar = new j();
        } catch (JSONException e17) {
            e16 = e17;
            jVar = null;
        }
        try {
            jVar.f143116b = jSONObject.optString("data", "");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("transitiveData", ""));
            jVar.f143115a = jSONObject2.optInt("callbackId", -1);
            jVar.f143118d = jSONObject2.optString("callbackActivity", "");
            if (jSONObject2.optInt("isBridgedJsApi", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            jVar.f143117c = z16;
        } catch (JSONException e18) {
            e16 = e18;
            w.b("Luggage.OpenSDKBridgedJsApiParams", "onResp: parse extraData error: %s", e16.toString());
            w.g("Luggage.OpenSDKBridgedJsApiParams", "resp:%s", jVar.toString());
            return jVar;
        }
        w.g("Luggage.OpenSDKBridgedJsApiParams", "resp:%s", jVar.toString());
        return jVar;
    }

    public String toString() {
        return "Resp{callbackId=" + this.f143115a + ", detail='" + this.f143116b + "', isBridgedJsApi=" + this.f143117c + ", callbackActivity='" + this.f143118d + "'}";
    }
}
