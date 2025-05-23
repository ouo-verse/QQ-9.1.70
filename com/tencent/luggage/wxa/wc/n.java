package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(canvas, (float) jSONArray.optDouble(0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_ROTATE;
    }

    public final boolean a(Canvas canvas, float f16) {
        canvas.rotate((float) ((f16 / 3.141592653589793d) * 180.0d));
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.l lVar = (com.tencent.luggage.wxa.xc.l) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (lVar == null) {
            return false;
        }
        return a(canvas, lVar.f144712b);
    }
}
