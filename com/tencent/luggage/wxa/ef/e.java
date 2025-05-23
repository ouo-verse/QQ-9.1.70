package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends a {
    private static final int CTRL_INDEX = 340;
    public static final String NAME = "enableLocationUpdate";

    /* renamed from: b, reason: collision with root package name */
    public o f124678b;

    public Bundle a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        return null;
    }

    public o c(com.tencent.luggage.wxa.xd.d dVar) {
        return new o(dVar);
    }

    @Override // com.tencent.luggage.wxa.ef.a, com.tencent.luggage.wxa.xd.a
    public /* bridge */ /* synthetic */ void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        super.invoke(dVar, jSONObject, i3);
    }

    @Override // com.tencent.luggage.wxa.ef.a
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", jSONObject);
        o oVar = (o) dVar.c(o.class);
        this.f124678b = oVar;
        if (oVar == null) {
            o c16 = c(dVar);
            this.f124678b = c16;
            c16.o();
            dVar.a(this.f124678b);
        }
        this.f124678b.a(a(dVar, jSONObject));
        this.f124678b.o(jSONObject.optString("type", MapJsPlugin.LOCATION_TYPE_02));
        this.f124678b.s();
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
