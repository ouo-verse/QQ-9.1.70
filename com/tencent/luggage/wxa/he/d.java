package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(151);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            Map<String, ? extends Object> hashMap = new HashMap<>();
            hashMap.put("errCode", 10013);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            com.tencent.luggage.wxa.ge.f.a(153, 154);
            return;
        }
        w.d("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", dVar.getAppId(), jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
            Map<String, ? extends Object> hashMap2 = new HashMap<>();
            hashMap2.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(153, 156);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
            Map<String, ? extends Object> hashMap3 = new HashMap<>();
            hashMap3.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(153, 158);
            return;
        }
        List a16 = b16.a(jSONObject.optString(Constants.SP_DEVICE_ID), jSONObject.optString("serviceId"));
        Map<String, ? extends Object> hashMap4 = new HashMap<>();
        if (a16 != null && a16.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = a16.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.mo162put(((com.tencent.luggage.wxa.ne.c) it.next()).a());
                } catch (JSONException e16) {
                    w.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", e16.getMessage());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("characteristics", jSONArray);
                jSONObject2.put("errCode", 0);
            } catch (JSONException e17) {
                w.a("MicroMsg.JsApiGetBLEDeviceCharacteristics", e17, "", new Object[0]);
            }
            w.d("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", jSONObject2.toString());
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, jSONObject2));
            com.tencent.luggage.wxa.ge.f.a(152);
            return;
        }
        w.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
        hashMap4.put("errCode", 10005);
        dVar.a(i3, makeReturnJson("fail:no characteristic", com.tencent.luggage.wxa.af.b.X, hashMap4));
        com.tencent.luggage.wxa.ge.f.a(153, 159);
    }
}
