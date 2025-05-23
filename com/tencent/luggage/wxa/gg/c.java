package com.tencent.luggage.wxa.gg;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        v J = lVar.J();
        if (J != null) {
            J.a(com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal(), false);
        }
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
