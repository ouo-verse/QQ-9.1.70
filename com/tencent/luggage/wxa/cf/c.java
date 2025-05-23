package com.tencent.luggage.wxa.cf;

import com.tencent.luggage.wxa.cf.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 223;
    private static final String NAME = "getBeacons";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.a("MicroMsg.JsApiGetBeacons", "getBeacons!");
        JSONArray jSONArray = new JSONArray();
        a.b a16 = a.a(dVar.getAppId());
        if (a16 != null) {
            Map a17 = a16.a();
            w.a("MicroMsg.JsApiGetBeacons", "getBeaconInfo, beaconInfos: " + a17);
            if (a17 != null && a17.size() > 0) {
                Iterator it = a17.values().iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put((JSONObject) it.next());
                }
            }
        } else {
            w.b("MicroMsg.JsApiGetBeacons", "not found device");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("beacons", jSONArray);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
