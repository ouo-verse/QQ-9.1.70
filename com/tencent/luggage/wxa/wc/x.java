package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        return a(dVar, jSONArray.optString(0));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_LINECAP;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        if ("butt".equalsIgnoreCase(str)) {
            dVar.d().setStrokeCap(Paint.Cap.BUTT);
            dVar.f().setStrokeCap(Paint.Cap.BUTT);
            return true;
        }
        if ("round".equalsIgnoreCase(str)) {
            dVar.d().setStrokeCap(Paint.Cap.ROUND);
            dVar.f().setStrokeCap(Paint.Cap.ROUND);
            return true;
        }
        if (!"square".equalsIgnoreCase(str)) {
            return true;
        }
        dVar.d().setStrokeCap(Paint.Cap.SQUARE);
        dVar.f().setStrokeCap(Paint.Cap.SQUARE);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.v vVar = (com.tencent.luggage.wxa.xc.v) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (vVar == null) {
            return false;
        }
        return a(dVar, vVar.f144723b);
    }
}
