package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.mj.g;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class u extends k {
    public static final int CTRL_INDEX = 454;
    public static final String NAME = "setBackgroundTextStyle";

    public u() {
        super(com.tencent.luggage.wxa.mj.g.class);
    }

    @Override // com.tencent.luggage.wxa.yf.k
    public void a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.mj.g gVar) {
        gVar.a(jSONObject.optString("textStyle", g.a.IGNORE.b()));
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
