package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class v extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 388;
    public static final String NAME = "setMenuStyle";

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
        if (jSONObject == null) {
            lVar.a(i3, makeReturnJson("fail:data is null"));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetMenuStyle", "data is null");
            return;
        }
        String optString = jSONObject.optString("style");
        com.tencent.luggage.wxa.kj.v pageView = lVar.getRuntime().Y().getPageView();
        if (pageView == null) {
            lVar.a(i3, makeReturnJson("fail view is null"));
            return;
        }
        if (optString.equalsIgnoreCase(MiniAppConst.MENU_STYLE_DARK)) {
            pageView.h(MiniAppConst.MENU_STYLE_DARK);
        } else if (optString.equalsIgnoreCase(MiniAppConst.MENU_STYLE_LIGHT)) {
            pageView.h(MiniAppConst.MENU_STYLE_LIGHT);
        } else {
            lVar.a(i3, makeReturnJson("fail invalid style " + optString));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", optString);
            return;
        }
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
