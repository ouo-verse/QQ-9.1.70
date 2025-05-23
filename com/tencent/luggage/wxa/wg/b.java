package com.tencent.luggage.wxa.wg;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.mg.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 482;
    public static final String NAME = "loadVideoResource";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data nil"));
            w.f("MicroMsg.JsApiLoadVideoResource", "data is null");
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(DKConfiguration.Directory.RESOURCES);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int i16 = 0;
            for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                String optString = optJSONArray.optString(i17, "");
                w.a("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", optString);
                if (w0.c(optString)) {
                    w.f("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
                    i16++;
                } else {
                    com.tencent.luggage.wxa.k0.d.a(g.a(j.class));
                }
            }
            if (i16 != 0 && i16 == optJSONArray.length()) {
                dVar.a(i3, makeReturnJson("fail"));
                return;
            }
            return;
        }
        w.f("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
        dVar.a(i3, makeReturnJson("fail:dataArr nil"));
    }
}
