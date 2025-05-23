package com.tencent.luggage.wxa.he;

import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(116);
        String appId = dVar.getAppId();
        w.d("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", appId);
        com.tencent.luggage.wxa.ne.k a16 = com.tencent.luggage.wxa.ge.a.a(appId);
        w.d("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", a16);
        if (a16.f135767a != 0) {
            dVar.a(i3, makeReturnJson(a16.f135768b, a16.f135769c));
            com.tencent.luggage.wxa.ge.f.a(118);
        } else {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
            com.tencent.luggage.wxa.ge.f.a(117);
        }
    }
}
