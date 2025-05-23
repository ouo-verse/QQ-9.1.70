package com.tencent.luggage.wxa.xd;

import android.content.Context;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class u0 extends a {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("url");
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            lVar.a(i3, makeReturnJson("fail"));
            return;
        }
        String optString2 = jSONObject.optString("pageOrientation");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiOpenUrl", "pageOrientation:%s", optString2);
        Context context = lVar.getContext();
        if (context != null) {
            d0.a aVar = new d0.a();
            aVar.f144747c = lVar;
            ((d0) lVar.b(d0.class)).a(context, optString, optString2, aVar);
            lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return;
        }
        lVar.a(i3, makeReturnJson("fail"));
    }
}
