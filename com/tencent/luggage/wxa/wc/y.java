package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        try {
            JSONArray jSONArray2 = jSONArray.getJSONArray(0);
            if (jSONArray2 == null) {
                return false;
            }
            int length = jSONArray2.length();
            float[] fArr = new float[length];
            for (int i3 = 0; i3 < length; i3++) {
                fArr[i3] = com.tencent.luggage.wxa.tk.g.a(jSONArray2, i3);
            }
            return a(dVar, fArr, com.tencent.luggage.wxa.tk.g.a(jSONArray, 1));
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_LINEDASH;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, float[] fArr, float f16) {
        if (fArr == null || f16 == Float.MIN_VALUE) {
            return true;
        }
        dVar.f().setPathEffect(new DashPathEffect(fArr, f16));
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.w wVar = (com.tencent.luggage.wxa.xc.w) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (wVar == null) {
            return false;
        }
        return a(dVar, wVar.f144724b, wVar.f144725c);
    }
}
