package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l0 extends k {
    public static final int CTRL_INDEX = 284;
    public static final String NAME = "startPullDownRefresh";

    public l0() {
        super(com.tencent.luggage.wxa.mj.g.class);
    }

    @Override // com.tencent.luggage.wxa.yf.k
    public void a(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.mj.g gVar) {
        gVar.a();
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
