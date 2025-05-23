package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        return a(dVar, canvas, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_CLRAERECT;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, float f16, float f17, float f18, float f19) {
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof com.tencent.luggage.wxa.vc.f) {
                ((com.tencent.luggage.wxa.vc.f) canvas).a(f16, f17, f16 + f18, f17 + f19);
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return true;
            }
            if (dVar.c() == null) {
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return false;
            }
            canvas.drawRect(f16, f17, f16 + f18, f17 + f19, dVar.c());
            com.tencent.luggage.wxa.tn.w.g("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return true;
        }
        if (dVar.c() != null) {
            canvas.drawRect(f16, f17, f16 + f18, f17 + f19, dVar.c());
            com.tencent.luggage.wxa.tn.w.g("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return true;
        }
        canvas.drawRect(f16, f17, f16 + f18, f17 + f19, dVar.a());
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        return false;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        if (cVar == null || !(cVar instanceof com.tencent.luggage.wxa.xc.b)) {
            return false;
        }
        com.tencent.luggage.wxa.xc.b bVar = (com.tencent.luggage.wxa.xc.b) cVar;
        return a(dVar, canvas, bVar.f144667b, bVar.f144668c, bVar.f144669d, bVar.f144670e);
    }
}
