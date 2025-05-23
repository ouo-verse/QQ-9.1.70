package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 522;
    public static final String NAME = "getBackgroundFetchData";

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetBackgroundFetchData", "fail:component is null");
            return;
        }
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetBackgroundFetchData", "fail:data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        String optString = jSONObject.optString("fetchType");
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetBackgroundFetchData", "fail:fetchType is null");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        String appId = dVar.getAppId();
        if (w0.c(appId)) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetBackgroundFetchData", "fail:appid is null");
            dVar.a(i3, makeReturnJson("fail:appID is empty"));
            return;
        }
        boolean equals = optString.equals("periodic");
        com.tencent.luggage.wxa.tc.c c16 = com.tencent.luggage.wxa.tc.m.a().c(appId, equals ? 1 : 0);
        if (c16 == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:record is null");
            dVar.a(i3, makeReturnJson("fail:record is null"));
            return;
        }
        if (c16.f141218e == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsApiGetBackgroundFetchData", "worker fail:fetched data is null");
            dVar.a(i3, makeReturnJson("fail:fetched data is null"));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fetchedData", c16.f141218e);
        hashMap.put("path", c16.f141216c);
        hashMap.put("query", c16.f141217d);
        hashMap.put("scene", Integer.valueOf(c16.f141219f));
        hashMap.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, Long.valueOf(c16.f141220g));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetBackgroundFetchData", "JsApiGetBackgroundFetchData, app(%s_%d)", appId, Integer.valueOf(equals ? 1 : 0));
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
