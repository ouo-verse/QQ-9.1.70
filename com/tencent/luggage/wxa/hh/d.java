package com.tencent.luggage.wxa.hh;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends a {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";

    @Override // com.tencent.luggage.wxa.hh.a
    public void a(c cVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        g pause = cVar.pause();
        w.d("MicroMsg.JsApiPausePlayVoice", "pause:%s", pause);
        if (pause.a()) {
            dVar.a(i3, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            return;
        }
        w.b("MicroMsg.JsApiPausePlayVoice", "pause fail %s", pause);
        dVar.a(i3, "fail:" + pause.f144873b);
    }
}
