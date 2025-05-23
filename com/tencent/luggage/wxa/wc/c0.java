package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, (float) jSONArray.optDouble(0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_MITERLIMIT;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, float f16) {
        dVar.d().setStrokeMiter(f16);
        dVar.f().setStrokeMiter(f16);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.n nVar = (com.tencent.luggage.wxa.xc.n) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (nVar == null) {
            return false;
        }
        return a(dVar, nVar.f144715b);
    }
}
