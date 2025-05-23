package com.tencent.luggage.wxa.re;

import android.view.KeyEvent;
import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends com.tencent.luggage.wxa.ee.c {
    private static final int CTRL_INDEX = 330;
    public static final String NAME = "removeCamera";

    @Override // com.tencent.luggage.wxa.ee.c
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        super.a(fVar, i3, view, jSONObject);
        w.d("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", Integer.valueOf(i3));
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i3));
            return false;
        }
        KeyEvent.Callback callback = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (callback != null && (callback instanceof e)) {
            e eVar = (e) callback;
            fVar.a((g.d) eVar);
            fVar.b((g.b) eVar);
            fVar.b((g.c) eVar);
            a.b().b(eVar.getCameraId());
            eVar.release();
            return true;
        }
        w.h("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", Integer.valueOf(i3));
        return false;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId", 0);
    }
}
