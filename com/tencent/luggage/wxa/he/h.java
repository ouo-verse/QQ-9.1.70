package com.tencent.luggage.wxa.he;

import android.util.Log;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 178;
    private static final String NAME = "getBluetoothDevices";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Object obj;
        boolean z16;
        com.tencent.luggage.wxa.ge.f.a(166);
        String appId = dVar.getAppId();
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        if (jSONObject == null) {
            obj = "";
        } else {
            obj = jSONObject;
        }
        objArr[1] = obj;
        w.d("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", objArr);
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(appId);
        if (b16 == null) {
            w.b("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(168, 170);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(168, 172);
            return;
        }
        List a16 = b16.a();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (a16 != null) {
            if (jSONObject != null) {
                z16 = jSONObject.optBoolean("useOldImpl", false);
            } else {
                z16 = false;
            }
            w.d("MicroMsg.JsApiGetBluetoothDevices", "useOldImpl: " + z16);
            a16.addAll(b16.a(z16));
            Iterator it = a16.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.mo162put(((com.tencent.luggage.wxa.ne.d) it.next()).a());
                } catch (JSONException e16) {
                    w.a("MicroMsg.JsApiGetBluetoothDevices", e16, "", new Object[0]);
                }
            }
        }
        try {
            jSONObject2.put("errMsg", getName() + ":ok");
            jSONObject2.put("devices", jSONArray);
        } catch (JSONException e17) {
            w.b("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", Log.getStackTraceString(e17));
        }
        w.d("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", jSONObject2);
        dVar.a(i3, jSONObject2.toString());
        com.tencent.luggage.wxa.ge.f.a(167);
    }
}
