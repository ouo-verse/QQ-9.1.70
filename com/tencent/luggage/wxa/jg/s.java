package com.tencent.luggage.wxa.jg;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 168;
    public static final String NAME = "setClipboardData";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("data");
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", optString);
        try {
            com.tencent.luggage.wxa.tn.g.a(dVar.getContext(), "text", optString);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            a(dVar, optString);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetClipboardData", "setPrimaryClip get exception:%s", e16);
            dVar.a(i3, makeReturnJson("fail:internal error"));
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str) {
    }
}
