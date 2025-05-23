package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        ArrayList arrayList;
        com.tencent.luggage.wxa.ge.f.a(191);
        w.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        w.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getConnectedBluetoothDevices data %s", dVar.getAppId(), jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
            Map<String, ? extends Object> hashMap = new HashMap<>();
            hashMap.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(193, 195);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
            Map<String, ? extends Object> hashMap2 = new HashMap<>();
            hashMap2.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(193, 197);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("services");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            arrayList = new ArrayList(length);
            for (int i16 = 0; i16 < length; i16++) {
                String optString = optJSONArray.optString(i16);
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
        } else {
            arrayList = null;
        }
        boolean optBoolean = jSONObject.optBoolean("useOldImpl", false);
        w.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "useOldImpl: " + optBoolean);
        List<com.tencent.luggage.wxa.ne.d> a16 = b16.a(arrayList, optBoolean);
        if (a16 == null) {
            w.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is null!");
            dVar.a(i3, makeReturnJson("fail:internal error", com.tencent.luggage.wxa.af.b.f121238g0));
            com.tencent.luggage.wxa.ge.f.a(193, 198);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.luggage.wxa.ne.d dVar2 : a16) {
            String str = dVar2.f135735b;
            String str2 = dVar2.f135734a;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Constants.SP_DEVICE_ID, str);
                jSONObject2.put("name", str2);
                jSONArray.mo162put(jSONObject2);
            } catch (JSONException e16) {
                w.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", e16);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("devices", jSONArray);
        } catch (JSONException e17) {
            w.a("MicroMsg.JsApiGetConnectedBluetoothDevices", e17, "", new Object[0]);
        }
        w.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", jSONObject3.toString());
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, jSONObject3));
        com.tencent.luggage.wxa.ge.f.a(192);
    }
}
