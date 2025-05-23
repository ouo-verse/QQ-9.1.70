package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class t0 extends a {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("url");
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            vVar.a(i3, makeReturnJson("fail"));
            return;
        }
        d0.a aVar = new d0.a();
        aVar.f144747c = vVar;
        ((d0) vVar.b(d0.class)).a(vVar.getContext(), optString, "", aVar);
        vVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
