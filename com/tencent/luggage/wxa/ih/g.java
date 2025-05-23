package com.tencent.luggage.wxa.ih;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends b {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    @Override // com.tencent.luggage.wxa.ih.b
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        d dVar2 = (d) dVar.b(d.class);
        if (dVar2 == null) {
            w.b("MicroMsg.JsApiStopRecord", "luggageRecorder is null, return");
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        com.tencent.luggage.wxa.hh.g j3 = dVar2.j();
        w.d("MicroMsg.JsApiStopRecord", "startRecord result:%s", j3);
        if (j3 != null && j3.a()) {
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return;
        }
        dVar.a(i3, makeReturnJson("fail:" + j3.f144873b));
        w.b("MicroMsg.JsApiStopRecord", "startRecord fail");
    }
}
