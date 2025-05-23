package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 5) {
            return false;
        }
        return a(dVar, canvas, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_ARC;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, float f16, float f17, float f18, float f19, float f26) {
        canvas.drawArc(new RectF(f16 - f18, f17 - f18, f16 + f18, f17 + f18), (float) ((f19 / 3.141592653589793d) * 180.0d), (float) ((f26 / 3.141592653589793d) * 180.0d), true, dVar.f());
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.e eVar = (com.tencent.luggage.wxa.xc.e) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (eVar == null) {
            return false;
        }
        return a(dVar, canvas, eVar.f144677b, eVar.f144678c, eVar.f144679d, eVar.f144680e, eVar.f144681f);
    }
}
