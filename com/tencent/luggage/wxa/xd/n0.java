package com.tencent.luggage.wxa.xd;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n0 extends v {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getPermissionBytes";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        int i3 = 0;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "invoke jsapi: %s", NAME);
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "fail:service is nil");
            return makeReturnJson("fail:service is nil");
        }
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "fail:data is nil");
            return makeReturnJson("fail:data is nil");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("indexes");
        if (optJSONArray == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "fail:indexes is nil");
            return makeReturnJson("fail:indexes is nil");
        }
        com.tencent.luggage.wxa.c5.e eVar = dVar.getRuntime() instanceof com.tencent.luggage.wxa.c5.e ? (com.tencent.luggage.wxa.c5.e) dVar.getRuntime() : null;
        if (eVar == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is nil");
            return makeReturnJson("fail:runtime is nil");
        }
        com.tencent.luggage.wxa.rj.c B1 = eVar.B1();
        if (B1 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetPermissionBytes", "invoke failed, NULL permissionController with appId:%s", eVar.getAppId());
            return makeReturnJson("fail:internal error");
        }
        byte[] a16 = B1.a((d) dVar);
        if (a16 != null && a16.length > 0) {
            JSONArray jSONArray = new JSONArray();
            if (optJSONArray.length() == 0) {
                while (i3 < a16.length) {
                    jSONArray.put(B1.a(a16, i3));
                    i3++;
                }
            } else {
                while (i3 < optJSONArray.length()) {
                    jSONArray.put(B1.a(a16, optJSONArray.optInt(i3, -1)));
                    i3++;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("permissionBytes", jSONArray);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "invoke getPermissionBytes ok");
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetPermissionBytes", "fail:ctrlBytes is empty");
        return makeReturnJson("fail:ctrlBytes is empty");
    }
}
