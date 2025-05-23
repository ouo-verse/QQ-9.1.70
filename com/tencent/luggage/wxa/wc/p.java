package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        return a(canvas, (float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return "scale";
    }

    public final boolean a(Canvas canvas, float f16, float f17) {
        canvas.scale(f16, f17);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.m mVar = (com.tencent.luggage.wxa.xc.m) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (mVar == null) {
            return false;
        }
        return a(canvas, mVar.f144713b, mVar.f144714c);
    }
}
