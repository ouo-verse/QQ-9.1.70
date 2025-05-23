package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        return a(dVar, canvas, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return "strokeRect";
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, float f16, float f17, float f18, float f19) {
        canvas.drawRect(f16, f17, f16 + f18, f17 + f19, dVar.f());
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.g gVar = (com.tencent.luggage.wxa.xc.g) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (gVar == null) {
            return false;
        }
        return a(dVar, canvas, gVar.f144700b, gVar.f144701c, gVar.f144702d, gVar.f144703e);
    }
}
