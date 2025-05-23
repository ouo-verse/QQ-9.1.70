package com.tencent.luggage.wxa.hh;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends a {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    @Override // com.tencent.luggage.wxa.hh.a
    public void a(c cVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        g stop = cVar.stop();
        w.d("MicroMsg.JsApiStopPlayVoice", "stop:%s", stop);
        if (stop.a()) {
            dVar.a(i3, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            return;
        }
        w.b("MicroMsg.JsApiStopPlayVoice", "stop fail %s", stop);
        dVar.a(i3, "fail:" + stop.f144873b);
    }
}
