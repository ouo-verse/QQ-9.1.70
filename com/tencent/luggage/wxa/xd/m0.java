package com.tencent.luggage.wxa.xd;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m0 extends v {
    public static final int CTRL_INDEX = 466;
    public static final String NAME = "getMenuButtonBoundingClientRect";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f144864a = com.tencent.luggage.wxa.tn.e.f141559a;

    public boolean b(com.tencent.luggage.wxa.ic.d dVar) {
        return dVar.D().shouldInLargeScreenCompatMode();
    }

    public boolean a(com.tencent.luggage.wxa.ic.d dVar) {
        dVar.D();
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.kj.v a16 = o1.a(dVar);
        if (a16 != null) {
            try {
                r0 = b(dVar) ? com.tencent.luggage.wxa.lj.k.a(o1.b(dVar)) : null;
                if (r0 == null) {
                    r0 = com.tencent.luggage.wxa.lj.k.a();
                }
                if (r0 == null) {
                    r0 = com.tencent.luggage.wxa.lj.k.b(a16);
                }
                if (r0 != null && f144864a) {
                    com.tencent.luggage.wxa.lj.k.a(o1.b(dVar));
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", e16);
            }
        }
        if (r0 == null || a(dVar)) {
            r0 = com.tencent.luggage.wxa.lj.k.a(o1.b(dVar));
        }
        if (r0 != null) {
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, r0);
        }
        return makeReturnJson("fail:internal error");
    }
}
