package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, jSONArray.optString(0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_LINEJOIN;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        if ("miter".equalsIgnoreCase(str)) {
            dVar.d().setStrokeJoin(Paint.Join.MITER);
            dVar.f().setStrokeJoin(Paint.Join.MITER);
            return true;
        }
        if ("round".equalsIgnoreCase(str)) {
            dVar.d().setStrokeJoin(Paint.Join.ROUND);
            dVar.f().setStrokeJoin(Paint.Join.ROUND);
            return true;
        }
        if (!"bevel".equalsIgnoreCase(str)) {
            return true;
        }
        dVar.d().setStrokeJoin(Paint.Join.BEVEL);
        dVar.f().setStrokeJoin(Paint.Join.BEVEL);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.x xVar = (com.tencent.luggage.wxa.xc.x) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (xVar == null) {
            return false;
        }
        return a(dVar, xVar.f144726b);
    }
}
