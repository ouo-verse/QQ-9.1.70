package com.tencent.luggage.wxa.xd;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a1 extends a {
    public static final int CTRL_INDEX = 283;
    public static final String NAME = "traceEvent";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        JSONArray optJSONArray = jSONObject.optJSONArray(LinkReportConstant$GlobalKey.EVENTS);
        if (com.tencent.luggage.wxa.qj.b.d((com.tencent.luggage.wxa.c5.e) dVar.getRuntime()) && optJSONArray != null) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("category");
                    String optString2 = optJSONObject.optString("name");
                    long optLong = optJSONObject.optLong("start");
                    long optLong2 = optJSONObject.optLong("end");
                    String optString3 = optJSONObject.optString("phase");
                    String optString4 = optJSONObject.optString("args");
                    if (!com.tencent.luggage.wxa.tn.w0.c(optString2)) {
                        com.tencent.luggage.wxa.qj.c.a(dVar.getAppId(), optString, optString2, optString3, optLong, optLong2, optString4);
                    }
                }
            }
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return;
        }
        dVar.a(i3, makeReturnJson("fail"));
    }
}
