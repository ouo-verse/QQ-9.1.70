package com.tencent.luggage.wxa.gg;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 464;
    public static final String NAME = "updateShareMenuUpdatable";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        v J = lVar.J();
        if (J != null) {
            com.tencent.luggage.wxa.ui.a b16 = J.b(com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal());
            if (b16 == null) {
                lVar.a(i3, makeReturnJson("fail:menu item do not exist"));
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("updatable", false);
            String optString = jSONObject.optString("templateId", "");
            boolean optBoolean2 = jSONObject.optBoolean("isPrivateMessage", false);
            b16.c().b("enable_share_with_updateable_msg", Boolean.valueOf(optBoolean));
            b16.c().b("enable_share_with_updateable_msg_template_id", (Object) optString);
            b16.c().b("enable_share_with_private_msg", Boolean.valueOf(optBoolean2));
            boolean optBoolean3 = jSONObject.optBoolean("useForChatTool", false);
            String optString2 = jSONObject.optString("participant", "");
            int optInt = jSONObject.optInt("chooseType", 1);
            b16.c().b("share_useForChatTool", Boolean.valueOf(optBoolean3));
            b16.c().b("share_participant", (Object) optString2);
            b16.c().b("share_choose_type", Integer.valueOf(optInt));
            lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            if (x0.b()) {
                w.d("MicroMsg.JsApiUpdateShareMenuUpdatable", "updateShareMenuUpdatable %s", jSONObject);
            }
            w.d("MicroMsg.JsApiUpdateShareMenuUpdatable", "update share menu updatable(%s) isPrivateMessage(%s)", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2));
            return;
        }
        lVar.a(i3, makeReturnJson("fail"));
    }
}
