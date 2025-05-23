package com.tencent.luggage.wxa.rh;

import com.tencent.luggage.wxa.re.f;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends a {
    private static final int CTRL_INDEX = 808;
    public static final String NAME = "removeXWebCamera";

    public boolean a(com.tencent.luggage.wxa.xd.d dVar, f fVar, JSONObject jSONObject) {
        w.d("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
        if (fVar == null) {
            w.f("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
            return false;
        }
        if (dVar instanceof com.tencent.luggage.wxa.xd.f) {
            com.tencent.luggage.wxa.xd.f fVar2 = (com.tencent.luggage.wxa.xd.f) dVar;
            fVar2.a((g.d) fVar);
            fVar2.b((g.b) fVar);
            fVar2.b((g.c) fVar);
        }
        fVar.release();
        return true;
    }
}
