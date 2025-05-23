package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.luggage.wxa.xd.v {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("route", vVar.A0());
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
    }
}
