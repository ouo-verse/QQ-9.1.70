package com.tencent.luggage.wxa.ff;

import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.ee.c {
    private static final int CTRL_INDEX = 366;
    public static final String NAME = "removeLivePlayer";

    /* renamed from: b, reason: collision with root package name */
    private static final String f126096b = "MicroMsg.JsApiRemoveLivePlayer";

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        super.a(fVar, i3, view, jSONObject);
        w.d(f126096b, "onRemoveView livePlayerId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h(f126096b, "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        View view2 = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (!(view2 instanceof com.tencent.mm.plugin.appbrand.jsapi.live.a)) {
            w.b(f126096b, "targetView not AppBrandLivePlayerView");
            return false;
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.live.a) view2).a();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("livePlayerId");
    }
}
