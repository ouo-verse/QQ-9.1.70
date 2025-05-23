package com.tencent.luggage.wxa.i2;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.v;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends v {
    public static final int CTRL_INDEX = 527;
    public static final String NAME = "getABTestConfig";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(l lVar, JSONObject jSONObject) {
        w.d("MicroMsg.JsApiGetABTestConfig", "JSONObject = " + jSONObject);
        String optString = jSONObject.optString("experimentId");
        HashMap hashMap = new HashMap(1);
        String a16 = com.tencent.luggage.wxa.im.a.b().a(optString, "", true, true);
        if (!TextUtils.isEmpty(a16)) {
            hashMap.put("testConfig", a16);
        }
        return makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap);
    }
}
