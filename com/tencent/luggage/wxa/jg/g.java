package com.tencent.luggage.wxa.jg;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 851;
    private static final String NAME = "checkIsOpenAccessibility";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Boolean a16 = com.tencent.luggage.wxa.gh.b.a(dVar.getContext());
        if (a16 == null) {
            dVar.a(i3, makeReturnJson("fail"));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("open", a16);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
