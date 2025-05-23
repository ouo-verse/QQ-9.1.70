package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        return a(canvas, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_TRANSLATE;
    }

    public final boolean a(Canvas canvas, float f16, float f17) {
        canvas.translate(f16, f17);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.f0 f0Var = (com.tencent.luggage.wxa.xc.f0) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (f0Var == null) {
            return false;
        }
        return a(canvas, f0Var.f144698b, f0Var.f144699c);
    }
}
