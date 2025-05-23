package com.tencent.luggage.wxa.kj;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.xd.p {
    private static final int CTRL_INDEX = 50;
    public static final String NAME = "onAppEnterForeground";

    public void a(com.tencent.luggage.wxa.ic.g gVar, boolean z16, JSONObject jSONObject) {
    }

    public final void a(com.tencent.luggage.wxa.ic.g gVar, boolean z16) {
        String currentUrl;
        HashMap hashMap = new HashMap();
        JSONObject c16 = gVar.S().c();
        if (c16 != null) {
            hashMap.put("referrerInfo", c16);
        }
        hashMap.put("relaunch", Boolean.valueOf(z16));
        hashMap.put("reLaunch", Boolean.valueOf(z16));
        if (z16) {
            currentUrl = gVar.O();
        } else {
            currentUrl = gVar.Y().getCurrentUrl();
        }
        hashMap.put("rawPath", currentUrl);
        hashMap.put("path", com.tencent.luggage.wxa.h6.o.b(currentUrl));
        hashMap.put("query", com.tencent.luggage.wxa.h6.o.d(currentUrl));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", hashMap.get("path"), hashMap.get("query"), hashMap.get("relaunch"), currentUrl);
        com.tencent.luggage.wxa.h6.f.a((Map) hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        a(gVar, z16, jSONObject);
        setData(jSONObject.toString()).setContext(gVar.h0()).dispatch();
    }
}
