package com.tencent.luggage.wxa.he;

import com.tencent.luggage.wxa.he.m;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(101);
        String appId = dVar.getAppId();
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        Object obj = jSONObject;
        if (jSONObject == null) {
            obj = "";
        }
        objArr[1] = obj;
        w.d("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "appId:%s stopBluetoothDevicesDiscovery data:%s", objArr);
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(appId);
        if (b16 == null) {
            w.b("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(103, 106);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(103, 108);
            return;
        }
        com.tencent.luggage.wxa.ne.k f16 = b16.f();
        w.d("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", f16);
        HashMap hashMap3 = new HashMap();
        if (f16.f135767a != 0) {
            hashMap3.put("isDiscovering", Boolean.FALSE);
            dVar.a(i3, makeReturnJson("fail", com.tencent.luggage.wxa.af.b.f121238g0, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(103);
        } else {
            hashMap3.put("isDiscovering", Boolean.FALSE);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(102);
            m.i.a(dVar, true, false);
        }
    }
}
