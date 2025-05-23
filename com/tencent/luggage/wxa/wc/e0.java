package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float a16 = com.tencent.luggage.wxa.tk.g.a(jSONArray, 0);
        float a17 = com.tencent.luggage.wxa.tk.g.a(jSONArray, 1);
        float a18 = com.tencent.luggage.wxa.tk.g.a(jSONArray, 2);
        JSONArray optJSONArray = jSONArray.optJSONArray(3);
        if (optJSONArray == null || optJSONArray.length() < 4) {
            return false;
        }
        return a(dVar, a16, a17, a18, com.tencent.luggage.wxa.tk.g.a(optJSONArray));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_SHADOW;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, float f16, float f17, float f18, int i3) {
        dVar.d().setShadowLayer(f18, f16, f17, i3);
        dVar.f().setShadowLayer(f18, f16, f17, i3);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.a0 a0Var = (com.tencent.luggage.wxa.xc.a0) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (a0Var == null) {
            return false;
        }
        return a(dVar, a0Var.f144663b, a0Var.f144664c, a0Var.f144665d, a0Var.f144666e);
    }
}
