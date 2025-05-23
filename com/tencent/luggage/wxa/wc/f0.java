package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONArray.length() < 2) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if (CanvasView.ACTION_LINER.equalsIgnoreCase(optString)) {
            if (jSONArray.length() >= 3 && (optJSONArray2 = jSONArray.optJSONArray(1)) != null && optJSONArray2.length() >= 4) {
                float a16 = com.tencent.luggage.wxa.tk.g.a(optJSONArray2, 0);
                float a17 = com.tencent.luggage.wxa.tk.g.a(optJSONArray2, 1);
                float a18 = com.tencent.luggage.wxa.tk.g.a(optJSONArray2, 2);
                float a19 = com.tencent.luggage.wxa.tk.g.a(optJSONArray2, 3);
                JSONArray optJSONArray3 = jSONArray.optJSONArray(2);
                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                    int[] iArr = new int[optJSONArray3.length()];
                    float[] fArr = new float[optJSONArray3.length()];
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONArray optJSONArray4 = optJSONArray3.optJSONArray(i3);
                        if (optJSONArray4.length() >= 2) {
                            fArr[i3] = (float) optJSONArray4.optDouble(0);
                            iArr[i3] = com.tencent.luggage.wxa.tk.g.a(optJSONArray4.optJSONArray(1));
                        }
                    }
                    dVar.f().setShader(new LinearGradient(a16, a17, a18, a19, iArr, fArr, Shader.TileMode.CLAMP));
                }
            }
            return false;
        }
        if (CanvasView.ACTION_RADIAL.equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3 || (optJSONArray = jSONArray.optJSONArray(1)) == null || optJSONArray.length() < 3) {
                return false;
            }
            float a26 = com.tencent.luggage.wxa.tk.g.a(optJSONArray, 1);
            float a27 = com.tencent.luggage.wxa.tk.g.a(optJSONArray, 2);
            float a28 = com.tencent.luggage.wxa.tk.g.a(optJSONArray, 3);
            JSONArray optJSONArray5 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray5.length()];
            float[] fArr2 = new float[optJSONArray5.length()];
            for (int i16 = 0; i16 < optJSONArray5.length(); i16++) {
                JSONArray optJSONArray6 = optJSONArray5.optJSONArray(i16);
                if (optJSONArray6.length() >= 2) {
                    fArr2[i16] = (float) optJSONArray6.optDouble(0);
                    iArr2[i16] = com.tencent.luggage.wxa.tk.g.a(optJSONArray6.optJSONArray(1));
                }
            }
            dVar.f().setShader(new RadialGradient(a26, a27, a28, iArr2, fArr2, Shader.TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            JSONArray optJSONArray7 = jSONArray.optJSONArray(1);
            if (optJSONArray7 == null || optJSONArray7.length() < 4) {
                return false;
            }
            dVar.f().setColor(com.tencent.luggage.wxa.tk.g.a(optJSONArray7));
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_STROKESTYLE;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.b0 b0Var = (com.tencent.luggage.wxa.xc.b0) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (b0Var == null) {
            return false;
        }
        return b0Var.a(dVar, canvas);
    }
}
