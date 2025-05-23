package com.tencent.luggage.wxa.wg;

import android.view.View;
import com.tencent.luggage.wxa.mg.k;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.ee.c {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.mg.a f144246a;

        public a(com.tencent.luggage.wxa.mg.a aVar) {
            this.f144246a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f144246a.c();
        }
    }

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        k kVar = new k(i3);
        w.d("MicroMsg.JsApiRemoveVideoPlayer", "%s onRemoveView, data: %s", kVar, jSONObject);
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h("MicroMsg.JsApiRemoveVideoPlayer", "%s view is not a instance of CoverViewContainer", kVar);
            return false;
        }
        com.tencent.luggage.wxa.mg.a aVar = (com.tencent.luggage.wxa.mg.a) ((com.tencent.luggage.wxa.ye.b) view).a(com.tencent.luggage.wxa.mg.a.class);
        if (aVar == null) {
            w.h("MicroMsg.JsApiRemoveVideoPlayer", "%s view not AppBrandVideoView", kVar);
            return false;
        }
        c0.a(new a(aVar));
        super.a(fVar, i3, view, jSONObject);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId", 0);
    }
}
