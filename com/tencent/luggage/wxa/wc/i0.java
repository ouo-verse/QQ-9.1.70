package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        try {
            return a(canvas, (float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1), (float) jSONArray.getDouble(2), (float) jSONArray.getDouble(3), com.tencent.luggage.wxa.tk.g.b(jSONArray, 4), com.tencent.luggage.wxa.tk.g.b(jSONArray, 5));
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_TRANSFORM;
    }

    public final boolean a(Canvas canvas, float f16, float f17, float f18, float f19, float f26, float f27) {
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setValues(new float[]{f16, f18, f26, f17, f19, f27, 0.0f, 0.0f, 1.0f});
        canvas.setMatrix(matrix);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.e0 e0Var = (com.tencent.luggage.wxa.xc.e0) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (e0Var == null) {
            return false;
        }
        return a(canvas, e0Var.f144682b, e0Var.f144683c, e0Var.f144684d, e0Var.f144685e, e0Var.f144686f, e0Var.f144687g);
    }
}
