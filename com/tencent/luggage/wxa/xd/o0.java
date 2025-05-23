package com.tencent.luggage.wxa.xd;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class o0 extends v {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getPluginPermissionBytes";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        char c16 = 0;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "invoke jsapi: %s", NAME);
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:service is nil");
            return makeReturnJson("fail:service is nil");
        }
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:data is nil");
            return makeReturnJson("fail:data is nil");
        }
        com.tencent.luggage.wxa.c5.e eVar = dVar.getRuntime() instanceof com.tencent.luggage.wxa.c5.e ? (com.tencent.luggage.wxa.c5.e) dVar.getRuntime() : null;
        if (eVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:runtime is nil");
            return makeReturnJson("fail:runtime is nil");
        }
        com.tencent.luggage.wxa.rj.c B1 = eVar.B1();
        if (B1 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetPluginPermissionBytes", "invoke failed, NULL permissionController with appId:%s", eVar.getAppId());
            return makeReturnJson("fail:internal error");
        }
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("pluginList"));
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("pluginId");
                JSONArray optJSONArray = optJSONObject.optJSONArray("indexes");
                Object[] objArr = new Object[2];
                objArr[c16] = optString;
                objArr[1] = optJSONArray;
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s,indexes:%s", objArr);
                if (optJSONArray == null) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:indexes is nil");
                    return makeReturnJson("fail:indexes is nil");
                }
                byte[] a16 = B1.a(dVar, optString);
                if (a16 != null && a16.length > 0) {
                    Object[] objArr2 = new Object[2];
                    objArr2[c16] = optString;
                    objArr2[1] = Integer.valueOf(a16.length);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s ctrlBytes:%d", objArr2);
                    JSONArray jSONArray2 = new JSONArray();
                    if (optJSONArray.length() == 0) {
                        for (int i16 = 0; i16 < a16.length; i16++) {
                            jSONArray2.put(B1.a(a16, i16));
                        }
                    } else {
                        for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                            jSONArray2.put(B1.a(a16, optJSONArray.optInt(i17, -1)));
                        }
                    }
                    hashMap2.put(optString, jSONArray2);
                    i3++;
                    c16 = 0;
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:pluginId:%s ctrlBytes is empty", optString);
                i3++;
                c16 = 0;
            }
            hashMap.put("pluginPermissionMap", hashMap2);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPluginPermissionBytes", "invoke JsApiGetPluginPermissionBytes ok");
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetPluginPermissionBytes", "parse pluginList error:%s", e16);
            return makeReturnJson("fail:parse pluginList error");
        }
    }
}
