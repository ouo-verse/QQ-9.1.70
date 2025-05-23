package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xk.a;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 1342;
    private static final String NAME = "getLastLocationCache";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a.C6919a locationCache = ((com.tencent.luggage.wxa.xk.a) dVar.b(com.tencent.luggage.wxa.xk.a.class)).getLocationCache(MapJsPlugin.LOCATION_TYPE_84, 600000);
        HashMap hashMap = new HashMap(2);
        if (locationCache != null) {
            hashMap.put("latitude", Double.valueOf(locationCache.f145141a));
            hashMap.put("longitude", Double.valueOf(locationCache.f145142b));
            w.d("MicroMsg.AppBrand.JsApiGetLastLocationCache", "latitude:%f, longitude:%f", Double.valueOf(locationCache.f145141a), Double.valueOf(locationCache.f145142b));
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap));
            return;
        }
        w.d("MicroMsg.AppBrand.JsApiGetLastLocationCache", "getLocationCache fail");
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121321q));
    }
}
