package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_LINEWIDTH;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, float f16) {
        dVar.d().setStrokeWidth(f16);
        dVar.f().setStrokeWidth(f16);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.y yVar = (com.tencent.luggage.wxa.xc.y) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (yVar == null) {
            return false;
        }
        return a(dVar, yVar.f144727b);
    }
}
