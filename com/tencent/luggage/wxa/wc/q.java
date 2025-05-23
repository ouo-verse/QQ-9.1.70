package com.tencent.luggage.wxa.wc;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONArray.length() < 2) {
            return false;
        }
        String optString = jSONArray.optString(0);
        com.tencent.luggage.wxa.ad.a d16 = dVar.d();
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
                    d16.setShader(new LinearGradient(a16, a17, a18, a19, iArr, fArr, Shader.TileMode.CLAMP));
                }
            }
            return false;
        }
        if (CanvasView.ACTION_RADIAL.equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3 || (optJSONArray = jSONArray.optJSONArray(1)) == null || optJSONArray.length() < 3) {
                return false;
            }
            float a26 = com.tencent.luggage.wxa.tk.g.a(optJSONArray, 0);
            float a27 = com.tencent.luggage.wxa.tk.g.a(optJSONArray, 1);
            float a28 = com.tencent.luggage.wxa.tk.g.a(optJSONArray, 2);
            if (a28 <= 0.0f) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", Float.valueOf(a28));
                return false;
            }
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
            d16.setShader(new RadialGradient(a26, a27, a28, iArr2, fArr2, Shader.TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            JSONArray optJSONArray7 = jSONArray.optJSONArray(1);
            if (optJSONArray7 == null || optJSONArray7.length() < 4) {
                return false;
            }
            d16.setShader(null);
            d16.setColor(com.tencent.luggage.wxa.tk.g.a(optJSONArray7));
        } else if ("pattern".equalsIgnoreCase(optString)) {
            String optString2 = jSONArray.optString(1);
            String optString3 = jSONArray.optString(2);
            if (w0.c(optString2)) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
                return false;
            }
            Bitmap a29 = dVar.e().a(dVar, optString2);
            if (a29 != null && !a29.isRecycled()) {
                d16.setShader(a(a29, optString3));
            }
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SET_FILLSTYLE;
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.o oVar = (com.tencent.luggage.wxa.xc.o) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (oVar == null) {
            return false;
        }
        return oVar.a(dVar, canvas);
    }

    public static Shader a(Bitmap bitmap, String str) {
        int a16 = com.tencent.luggage.wxa.tk.g.a(bitmap.getWidth());
        int a17 = com.tencent.luggage.wxa.tk.g.a(bitmap.getHeight());
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -934531685:
                if (str.equals("repeat")) {
                    c16 = 0;
                    break;
                }
                break;
            case -724648153:
                if (str.equals("no-repeat")) {
                    c16 = 1;
                    break;
                }
                break;
            case -436782906:
                if (str.equals("repeat-x")) {
                    c16 = 2;
                    break;
                }
                break;
            case -436782905:
                if (str.equals("repeat-y")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a16, a17, false);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                return new BitmapShader(createScaledBitmap, tileMode, tileMode);
            case 1:
                Bitmap createBitmap = Bitmap.createBitmap(a16 + 1, a17 + 1, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, a16, a17), (Paint) null);
                Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                return new BitmapShader(createBitmap, tileMode2, tileMode2);
            case 2:
                Bitmap createBitmap2 = Bitmap.createBitmap(a16, a17 + 1, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap2).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, a16, a17), (Paint) null);
                return new BitmapShader(createBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            case 3:
                Bitmap createBitmap3 = Bitmap.createBitmap(a16 + 1, a17, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap3).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, a16, a17), (Paint) null);
                return new BitmapShader(createBitmap3, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
            default:
                return null;
        }
    }
}
