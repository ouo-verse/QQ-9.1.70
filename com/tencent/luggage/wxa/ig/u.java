package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (w0.c(optString)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121388d);
        }
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
        }
        if (w0.c(dVar.getAppId())) {
            return makeReturnJson("fail:appID is empty");
        }
        int i3 = ((com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class)).f125967m;
        if (com.tencent.luggage.wxa.fd.q.a(i3)) {
            b(dVar, optString, optInt);
        } else if (i3 == 3) {
            b(dVar, optString, optInt);
            a(dVar, optString, optInt);
        } else {
            a(dVar, optString, optInt);
        }
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), qVar.f125967m, qVar.D).b(i3, dVar.getAppId(), str);
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
        v vVar = new v();
        vVar.f130325c = dVar.getAppId();
        vVar.f130326d = i3;
        vVar.f130327e = str;
        vVar.c();
    }
}
