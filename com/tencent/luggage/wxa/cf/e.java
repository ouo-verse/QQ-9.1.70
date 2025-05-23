package com.tencent.luggage.wxa.cf;

import com.tencent.luggage.wxa.cf.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends k0 {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        public b() {
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        a.b a16 = com.tencent.luggage.wxa.cf.a.a(dVar.getAppId());
        Integer valueOf = Integer.valueOf(DigestErrCode.UN_SUPPORT_TYPE);
        if (a16 == null) {
            w.b("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", valueOf);
            dVar.a(i3, makeReturnJson("fail:not start", hashMap));
            return;
        }
        if (a16.e()) {
            com.tencent.luggage.wxa.cf.a.b(dVar.getAppId());
            new HashMap().put("errCode", 0);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", valueOf);
            dVar.a(i3, makeReturnJson("fail:not start", hashMap2));
        }
        b bVar = new b();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", com.tencent.luggage.wxa.cf.a.f123477d);
            jSONObject2.put("discovering", false);
        } catch (JSONException e16) {
            w.b("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", e16);
        }
        w.d("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject2.toString());
        bVar.setContext(dVar, dVar.getComponentId()).setData(jSONObject2.toString()).dispatch();
    }
}
