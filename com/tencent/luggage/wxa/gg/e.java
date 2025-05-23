package com.tencent.luggage.wxa.gg;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 779;
    public static final String NAME = "showShareTimelineMenu";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiShowShareTimelineMenu", "invoke showShareTimelineMenu");
        if (dVar == null) {
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        if (dVar.J() == null) {
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        com.tencent.luggage.wxa.m4.b J = dVar.J();
        com.tencent.luggage.wxa.ui.b bVar = com.tencent.luggage.wxa.ui.b.ShareToTimeLine;
        if (J.b(bVar.ordinal()) == null) {
            dVar.a(i3, makeReturnJson("fail"));
        } else {
            dVar.J().b(bVar.ordinal()).a(false);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
