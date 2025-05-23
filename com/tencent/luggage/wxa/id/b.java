package com.tencent.luggage.wxa.id;

import com.tencent.luggage.wxa.xd.o1;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends v {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "remoteDebugInfo";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.ic.l b16 = o1.b(dVar);
        c cVar = b16 instanceof com.tencent.luggage.wxa.r4.d ? (c) ((com.tencent.luggage.wxa.r4.d) b16).h(c.class) : null;
        if (cVar == null) {
            return makeReturnJson("fail:not debug");
        }
        cVar.a(jSONObject.toString());
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }
}
