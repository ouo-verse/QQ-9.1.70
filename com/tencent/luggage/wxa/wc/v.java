package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        try {
            return a(dVar, jSONArray.getInt(0));
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", e16);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_GLOBALALPHA;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, int i3) {
        float f16 = i3 / 255.0f;
        dVar.f().a(f16);
        dVar.d().a(f16);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.t tVar = (com.tencent.luggage.wxa.xc.t) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (tVar == null) {
            return false;
        }
        return a(dVar, tVar.f144721b);
    }
}
