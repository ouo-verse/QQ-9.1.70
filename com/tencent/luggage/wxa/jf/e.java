package com.tencent.luggage.wxa.jf;

import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends v {
    static final int CTRL_INDEX = 191;
    public static final String NAME = "exitMiniProgram";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject) {
        lVar.getRuntime().D();
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }
}
