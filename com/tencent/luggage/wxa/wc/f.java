package com.tencent.luggage.wxa.wc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.luggage.wxa.vc.e;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.vc.e.a
        public void a(com.tencent.luggage.wxa.vc.d dVar, String str, Bitmap bitmap) {
            dVar.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.vc.e.a
        public void a(com.tencent.luggage.wxa.vc.d dVar, String str, Bitmap bitmap) {
            dVar.invalidate();
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length < 3) {
            return false;
        }
        return a(dVar, canvas, length, jSONArray.optString(0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), com.tencent.luggage.wxa.tk.g.a(jSONArray, 3), com.tencent.luggage.wxa.tk.g.a(jSONArray, 4), jSONArray.optInt(5), jSONArray.optInt(6), jSONArray.optInt(7), jSONArray.optInt(8));
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_DRAWIMAGE;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.f fVar = (com.tencent.luggage.wxa.xc.f) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (fVar == null) {
            return false;
        }
        return a(dVar, canvas, fVar.f144688b, fVar.f144689c, fVar.f144690d, fVar.f144691e, fVar.f144692f, fVar.f144693g, fVar.f144694h, fVar.f144695i, fVar.f144696j, fVar.f144697k);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, int i3, String str, float f16, float f17, float f18, float f19, int i16, int i17, int i18, int i19) {
        float f26;
        float f27;
        Bitmap a16;
        float f28;
        int i26;
        int i27;
        int i28;
        float f29 = f18;
        float f36 = f19;
        int i29 = i18;
        int i36 = i19;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i3 < 5) {
            f26 = f16;
        } else {
            if (f29 == 0.0f || f36 == 0.0f) {
                return true;
            }
            if (f29 < 0.0f) {
                f26 = f16 + f29;
                f29 = -f29;
            } else {
                f26 = f16;
            }
            if (f36 < 0.0f) {
                f27 = f17 + f36;
                f36 = -f36;
                float f37 = f26 + f29;
                float f38 = f27 + f36;
                if (i3 >= 9) {
                    a16 = dVar.e().a(dVar, str, new b());
                    if (a16 == null || a16.isRecycled()) {
                        return false;
                    }
                    if (f29 == 0.0f) {
                        f37 = f26 + com.tencent.luggage.wxa.tk.g.a(a16.getWidth());
                    }
                    if (f36 == 0.0f) {
                        f38 = f27 + com.tencent.luggage.wxa.tk.g.a(a16.getHeight());
                    }
                    f28 = f37;
                } else {
                    if (i29 == 0 || i36 == 0) {
                        return true;
                    }
                    if (i29 < 0) {
                        i26 = i16 + i29;
                        i29 = -i29;
                    } else {
                        i26 = i16;
                    }
                    if (i36 < 0) {
                        i27 = i17 + i36;
                        i36 = -i36;
                    } else {
                        i27 = i17;
                    }
                    int i37 = i26 + i29;
                    if (i37 <= 0 || (i28 = i27 + i36) <= 0) {
                        return true;
                    }
                    a16 = dVar.e().a(dVar, str, new Rect(i26 > 0 ? i26 : 0, i27 > 0 ? i27 : 0, i37, i28), new a());
                    if (a16 == null || a16.isRecycled()) {
                        return false;
                    }
                    int a17 = com.tencent.luggage.wxa.tk.g.a(i26);
                    int a18 = com.tencent.luggage.wxa.tk.g.a(i27);
                    int a19 = com.tencent.luggage.wxa.tk.g.a(i29);
                    float f39 = f29 / a19;
                    float a26 = f36 / com.tencent.luggage.wxa.tk.g.a(i36);
                    f26 += (com.tencent.luggage.wxa.tk.g.a(r11) - a17) * f39;
                    f27 += (com.tencent.luggage.wxa.tk.g.a(r10) - a18) * a26;
                    f28 = (com.tencent.luggage.wxa.tk.g.a(a16.getWidth()) * f39) + f26;
                    f38 = f27 + (com.tencent.luggage.wxa.tk.g.a(a16.getHeight()) * a26);
                }
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                canvas.drawBitmap(a16, new Rect(0, 0, a16.getWidth(), a16.getHeight()), new RectF(f26, f27, f28, f38), dVar.d());
                return true;
            }
        }
        f27 = f17;
        float f372 = f26 + f29;
        float f382 = f27 + f36;
        if (i3 >= 9) {
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(a16, new Rect(0, 0, a16.getWidth(), a16.getHeight()), new RectF(f26, f27, f28, f382), dVar.d());
        return true;
    }
}
