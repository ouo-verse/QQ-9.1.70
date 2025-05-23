package com.tencent.luggage.wxa.ci;

import com.tencent.luggage.wxa.a8.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 819;
    public static final String NAME = "operateXWebVideoBackground";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        AppBrandInvokeContext appBrandInvokeContext = new AppBrandInvokeContext(i3, jSONObject, dVar, this);
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(appBrandInvokeContext);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
            dVar.a(i3, makeReturnJson("fail:audioOfVideoBackgroundPlayManager is null"));
            return;
        }
        j d16 = a16.d();
        if (d16 == null) {
            w.f("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
            dVar.a(i3, makeReturnJson("fail:videoPlayer is null"));
        } else if (!(d16 instanceof com.tencent.luggage.wxa.i8.e)) {
            w.f("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
            dVar.a(i3, makeReturnJson("fail:videoPlayer is not for XwebVideo"));
        } else {
            ((com.tencent.luggage.wxa.i8.e) d16).handleJsApi(appBrandInvokeContext);
        }
    }
}
