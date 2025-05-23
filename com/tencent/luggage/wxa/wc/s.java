package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, com.tencent.luggage.wxa.tk.g.c(jSONArray, 0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_FONT_SIZE;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, int i3) {
        float f16 = i3;
        dVar.d().setTextSize(f16);
        dVar.f().setTextSize(f16);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.q qVar = (com.tencent.luggage.wxa.xc.q) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (qVar == null) {
            return false;
        }
        return a(dVar, qVar.f144718b);
    }
}
