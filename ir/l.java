package ir;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public TextPaint f408366a;

    /* renamed from: b, reason: collision with root package name */
    public int f408367b;

    /* renamed from: c, reason: collision with root package name */
    public int f408368c;

    /* renamed from: d, reason: collision with root package name */
    public int f408369d;

    /* renamed from: e, reason: collision with root package name */
    public int f408370e;

    /* renamed from: f, reason: collision with root package name */
    public int f408371f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<h> f408372g;

    /* renamed from: h, reason: collision with root package name */
    public int f408373h = 0;

    public l(int i3, int i16, Typeface typeface, int i17, int i18, int i19, int i26) {
        TextPaint textPaint = new TextPaint();
        this.f408366a = textPaint;
        textPaint.setAntiAlias(true);
        this.f408366a.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
        this.f408366a.setDither(true);
        this.f408366a.setTextSize(i3);
        this.f408366a.setColor(i16);
        this.f408366a.setTypeface(typeface);
        this.f408367b = i17;
        this.f408368c = i18;
        this.f408369d = i19;
        this.f408370e = i26;
    }

    public static l b(CharSequence charSequence, int i3, int i16, int i17, int i18, int i19, int i26, Typeface typeface, a aVar) {
        l lVar = new l(i3, i16, typeface, i17, i18, i19, i26);
        lVar.f408373h = 1;
        lVar.c(charSequence, aVar);
        return lVar;
    }

    public static int e() {
        Random random = new Random();
        return (random.nextInt(5) * 100) + (random.nextInt(9) * 10) + random.nextInt(9);
    }

    public void c(CharSequence charSequence, a aVar) {
        d(charSequence, aVar, 0);
    }

    public void d(CharSequence charSequence, a aVar, int i3) {
        int width;
        int measureText = (int) this.f408366a.measureText(charSequence, 0, charSequence.length());
        this.f408371f = measureText;
        int length = (i3 == 0 || i3 <= measureText) ? 0 : (i3 - measureText) / (charSequence.length() - 1);
        this.f408372g = new ArrayList<>();
        int i16 = 0;
        for (int i17 = 0; i17 < charSequence.length(); i17++) {
            char charAt = charSequence.charAt(i17);
            if (charAt == ' ') {
                i16 += (int) this.f408366a.measureText("0", 0, 1);
            } else {
                h hVar = new h();
                String str = new String(new char[]{charAt});
                int measureText2 = (int) this.f408366a.measureText(str, 0, str.length());
                Paint.FontMetrics fontMetrics = this.f408366a.getFontMetrics();
                float f16 = fontMetrics.bottom - fontMetrics.top;
                float abs = Math.abs(fontMetrics.ascent);
                Bitmap createBitmap = Bitmap.createBitmap(measureText2, (int) f16, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawText(str, 0.0f, abs, this.f408366a);
                if (this.f408373h == 0) {
                    hVar.f408321c = aVar.a("", this.f408369d + e(), this.f408370e, 0, 255, new LinearInterpolator());
                } else {
                    hVar.f408321c = aVar.a("", this.f408369d + ((this.f408370e * i17) / charSequence.length()), this.f408370e, 0, 255, new LinearInterpolator());
                }
                hVar.f408319a = createBitmap;
                if (i17 == 0) {
                    hVar.f408320b = i16;
                    width = createBitmap.getWidth();
                } else {
                    hVar.f408320b = i16 + length;
                    width = createBitmap.getWidth() + length;
                }
                i16 += width;
                this.f408372g.add(hVar);
            }
        }
    }

    public static void a(int i3, Paint paint) {
        if (i3 == 255) {
            paint.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
        } else {
            paint.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
        }
    }
}
