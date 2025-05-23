package com.tencent.luggage.wxa.mh;

import android.content.Context;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 315;
    public static final String NAME = "stopWifi";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
        Context context = dVar.getContext();
        if (context == null) {
            w.b("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 12010);
            dVar.a(i3, makeReturnJson("fail:context is null", com.tencent.luggage.wxa.af.e.f121309e, hashMap));
            return;
        }
        if (!d.f134588a) {
            w.b("MicroMsg.JsApiStopWifi", "not invoke startWifi");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 12000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.B, hashMap2));
            return;
        }
        com.tencent.luggage.wxa.nh.a.a(context);
        d.f134588a = false;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("errCode", 0);
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap3));
    }
}
