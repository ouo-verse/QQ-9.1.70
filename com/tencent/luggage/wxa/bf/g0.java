package com.tencent.luggage.wxa.bf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g0 extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String str;
        String optString = jSONObject.optString("filePath", "");
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            str = "fail:invalid data";
        } else if (!dVar.getFileSystem().isSavedFile(optString)) {
            str = "fail not a store filePath";
        } else if (dVar.getFileSystem().removeSavedFile(optString)) {
            str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        } else {
            str = "fail";
        }
        dVar.a(i3, makeReturnJson(str));
    }
}
