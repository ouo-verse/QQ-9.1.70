package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.fd.b;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends k {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    public b() {
        super(com.tencent.luggage.wxa.mj.g.class);
    }

    @Override // com.tencent.luggage.wxa.yf.k
    public void a(com.tencent.luggage.wxa.kj.v vVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.mj.g gVar) {
        if (!jSONObject.has("disable")) {
            vVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return;
        }
        if (jSONObject.optBoolean("disable", false)) {
            gVar.b(false);
        } else {
            b.e r06 = vVar.r0();
            if (r06 == null) {
                gVar.b(false);
            } else {
                gVar.b(r06.f125691k);
            }
        }
        vVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
