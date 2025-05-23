package com.tencent.luggage.wxa.wc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d0 implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        try {
            return a(dVar, canvas, (Bitmap) jSONArray.get(4), com.tencent.luggage.wxa.tk.g.c(jSONArray, 0), com.tencent.luggage.wxa.tk.g.c(jSONArray, 1), com.tencent.luggage.wxa.tk.g.c(jSONArray, 2), com.tencent.luggage.wxa.tk.g.c(jSONArray, 3));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.SetPixelsAction", "get bitmap data error, %s", Log.getStackTraceString(e16));
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return "__setPixels";
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, Bitmap bitmap, int i3, int i16, int i17, int i18) {
        ?? r122;
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof com.tencent.luggage.wxa.vc.f) {
                ((com.tencent.luggage.wxa.vc.f) canvas).a(i3, i16, i3 + i17, i16 + i18);
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                r122 = 0;
            } else if (dVar.c() != null) {
                r122 = 0;
                canvas.drawRect(i3, i16, i3 + i17, i16 + i18, dVar.c());
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            } else {
                r122 = 0;
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            }
        } else {
            boolean z16 = false;
            if (dVar.c() != null) {
                canvas.drawRect(i3, i16, i3 + i17, i16 + i18, dVar.c());
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                r122 = z16;
            } else {
                canvas.drawRect(i3, i16, i3 + i17, i16 + i18, dVar.a());
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                r122 = z16;
            }
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return r122;
        }
        canvas.drawBitmap(bitmap, new Rect(r122, r122, bitmap.getWidth(), bitmap.getHeight()), new RectF(i3, i16, i3 + i17, i16 + i18), dVar.f());
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.z zVar = (com.tencent.luggage.wxa.xc.z) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (zVar == null) {
            return false;
        }
        return a(dVar, canvas, zVar.f144732f, zVar.f144728b, zVar.f144729c, zVar.f144730d, zVar.f144731e);
    }
}
