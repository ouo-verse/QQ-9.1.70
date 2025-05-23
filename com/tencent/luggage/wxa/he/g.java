package com.tencent.luggage.wxa.he;

import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(126);
        w.d("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", dVar.getAppId());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(128, 130);
            return;
        }
        boolean e16 = b16.e();
        boolean d16 = b16.d();
        w.d("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + e16 + ",discoveringState : " + d16);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("available", Boolean.valueOf(e16));
        hashMap2.put("discovering", Boolean.valueOf(d16));
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
        com.tencent.luggage.wxa.ge.f.a(127);
    }
}
