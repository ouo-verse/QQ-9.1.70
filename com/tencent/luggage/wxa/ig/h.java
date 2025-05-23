package com.tencent.luggage.wxa.ig;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        int i3 = ((com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class)).f125967m;
        int optInt = jSONObject.optInt("storageId", 0);
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
        }
        if (com.tencent.luggage.wxa.fd.q.a(i3)) {
            return b(dVar, optInt);
        }
        if (i3 == 3) {
            a(dVar, optInt);
            return b(dVar, optInt);
        }
        return a(dVar, optInt);
    }

    public final String b(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), qVar.f125967m, qVar.D).b(i3, dVar.getAppId());
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }

    public final String a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        i iVar = new i();
        iVar.f130272c = dVar.getAppId();
        iVar.f130273d = i3;
        iVar.c();
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }
}
