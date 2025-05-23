package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 587;
    private static final String NAME = "disableLocationUpdate";

    /* renamed from: a, reason: collision with root package name */
    public o f124677a;

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "disableLocationUpdate invoke");
        o oVar = (o) dVar.c(o.class);
        this.f124677a = oVar;
        if (oVar == null) {
            w.d("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "fail:location update not enabled");
            dVar.a(i3, makeReturnJson("fail:location update not enabled"));
        } else {
            oVar.n();
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
