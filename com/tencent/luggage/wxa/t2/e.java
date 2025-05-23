package com.tencent.luggage.wxa.t2;

import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "logout";

    public static boolean e() {
        l lVar = l.f136139a;
        if (lVar.c()) {
            lVar.b();
            com.tencent.luggage.wxa.tj.b.d();
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(i iVar, JSONObject jSONObject, int i3) {
        if (e()) {
            w.d("Luggage.JsApiLogout", "logout data:%s success", jSONObject);
            iVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            w.b("Luggage.JsApiLogout", "logout data:%s fail", jSONObject);
            iVar.a(i3, makeReturnJson("fail: not login"));
        }
    }
}
