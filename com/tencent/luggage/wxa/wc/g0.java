package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, jSONArray.optString(0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_TEXTALIGN;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        if ("left".equalsIgnoreCase(str)) {
            dVar.f().setTextAlign(Paint.Align.LEFT);
            dVar.d().setTextAlign(Paint.Align.LEFT);
            return true;
        }
        if ("right".equalsIgnoreCase(str)) {
            dVar.f().setTextAlign(Paint.Align.RIGHT);
            dVar.d().setTextAlign(Paint.Align.RIGHT);
            return true;
        }
        if (!"center".equalsIgnoreCase(str)) {
            return true;
        }
        dVar.f().setTextAlign(Paint.Align.CENTER);
        dVar.d().setTextAlign(Paint.Align.CENTER);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.c0 c0Var = (com.tencent.luggage.wxa.xc.c0) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (c0Var == null) {
            return false;
        }
        return a(dVar, c0Var.f144672b);
    }
}
