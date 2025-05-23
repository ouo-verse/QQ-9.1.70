package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.luggage.wxa.ad.a;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 3) {
            return false;
        }
        return a(dVar, canvas, jSONArray.optString(0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_STROKETEXT;
    }

    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, String str, float f16, float f17, float f18) {
        float abs;
        com.tencent.luggage.wxa.ad.a f19;
        Paint.FontMetrics fontMetrics = dVar.f().getFontMetrics();
        if (dVar.f().c() == a.EnumC5993a.TOP) {
            abs = Math.abs(fontMetrics.ascent);
        } else if (dVar.f().c() == a.EnumC5993a.MIDDLE) {
            float f26 = -fontMetrics.ascent;
            float f27 = fontMetrics.descent;
            abs = Math.abs(((f26 + f27) / 2.0f) - f27);
        } else {
            if (dVar.f().c() == a.EnumC5993a.BOTTOM) {
                f17 -= Math.abs(fontMetrics.descent);
            }
            f19 = dVar.f();
            float measureText = f19.measureText(str);
            if (f18 <= 0.0f && f18 < measureText) {
                canvas.save();
                canvas.translate(f16, f17);
                canvas.scale(f18 / measureText, 1.0f);
                canvas.drawText(str, 0.0f, 0.0f, f19);
                canvas.restore();
                return true;
            }
            canvas.drawText(str, f16, f17, f19);
            return true;
        }
        f17 += abs;
        f19 = dVar.f();
        float measureText2 = f19.measureText(str);
        if (f18 <= 0.0f) {
        }
        canvas.drawText(str, f16, f17, f19);
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.h hVar = (com.tencent.luggage.wxa.xc.h) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (hVar == null) {
            return false;
        }
        return a(dVar, canvas, hVar.f144704b, hVar.f144705c, hVar.f144706d, hVar.f144707e);
    }
}
