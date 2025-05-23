package com.tencent.luggage.wxa.xd;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class y0 extends a {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.r4.d dVar, JSONObject jSONObject, int i3) {
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (dVar.getRuntime().j0().F == optBoolean) {
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            com.tencent.luggage.wxa.wi.a.a(dVar, dVar.getAppId(), optBoolean);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
