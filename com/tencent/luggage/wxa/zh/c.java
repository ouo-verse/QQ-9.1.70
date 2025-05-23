package com.tencent.luggage.wxa.zh;

import com.tencent.luggage.wxa.hf.e;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends a {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "removeXWebMap";

    public boolean a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiRemoveXWebMap", "data is null");
            return false;
        }
        w.d("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", jSONObject);
        e.a(dVar.getAppId(), com.tencent.luggage.wxa.hf.d.a(dVar, jSONObject));
        return true;
    }
}
