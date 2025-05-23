package com.tencent.luggage.wxa.ff;

import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.ee.c {
    private static final int CTRL_INDEX = 362;
    public static final String NAME = "removeLivePusher";

    /* renamed from: b, reason: collision with root package name */
    private static final String f126097b = "MicroMsg.JsApiRemoveLivePusher";

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        super.a(fVar, i3, view, jSONObject);
        w.d(f126097b, "onRemoveView livePusherId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(f126097b, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        View view2 = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (!(view2 instanceof com.tencent.mm.plugin.appbrand.jsapi.live.b)) {
            w.b(f126097b, "targetView not AppBrandLivePusherView");
            return false;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.live.b) view2).d();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("livePusherId");
    }
}
