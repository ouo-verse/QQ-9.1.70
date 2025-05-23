package com.tencent.luggage.wxa.gg;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 202;
    public static final String NAME = "showShareMenuWithShareTicket";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiShowShareMenuWithShareTicket", "invoke");
        v J = lVar.J();
        if (J != null) {
            com.tencent.luggage.wxa.ui.b bVar = com.tencent.luggage.wxa.ui.b.ShareAppMsg;
            J.a(bVar.ordinal(), false);
            com.tencent.luggage.wxa.ui.a b16 = J.b(bVar.ordinal());
            if (b16 == null) {
                lVar.a(i3, makeReturnJson("fail:menu item do not exist"));
                return;
            } else {
                b16.c().b("enable_share_with_share_ticket", Boolean.TRUE);
                lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                return;
            }
        }
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
