package com.etrump.mixlayout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.OffsetableImageSpan;

/* compiled from: P */
/* loaded from: classes2.dex */
public class p extends OffsetableImageSpan {
    public float C;
    public float D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    private String f32777d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f32778e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f32779f;

    /* renamed from: h, reason: collision with root package name */
    private int f32780h;

    /* renamed from: i, reason: collision with root package name */
    private int f32781i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f32782m;

    public int a() {
        Rect bounds = getDrawable().getBounds();
        Paint.FontMetricsInt fontMetricsInt = this.f32782m.getFontMetricsInt();
        int max = Math.max(bounds.bottom, (-fontMetricsInt.top) + fontMetricsInt.bottom);
        this.f32781i = max;
        return max;
    }

    public int b() {
        Paint paint = this.f32782m;
        String str = this.f32777d;
        getSize(paint, str, 0, str.length(), this.f32782m.getFontMetricsInt());
        return this.f32780h;
    }

    @Override // com.tencent.mobileqq.text.OffsetableImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        int i26;
        int i27;
        if (this.E) {
            i26 = this.f32782m.getFontMetricsInt().top + i18;
        } else {
            i26 = i18;
        }
        int i28 = this.f32780h;
        if (i28 > 0 && (i27 = this.f32781i) > 0) {
            this.f32779f.setBounds(0, i26, i28, i27 + i26);
            this.f32779f.draw(canvas);
        }
        super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
        float f17 = f16 + getDrawable().getBounds().right;
        int i29 = i18 - this.f32782m.getFontMetricsInt().ascent;
        if (!this.E) {
            i18 = i29;
        }
        canvas.drawText(this.f32777d, f17, i18, this.f32782m);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        this.f32782m.getTextWidths(this.f32777d, this.f32778e);
        int i17 = bounds.right;
        for (float f16 : this.f32778e) {
            i17 = (int) (i17 + f16);
        }
        this.f32780h = i17;
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.f32781i = Math.max(bounds.bottom, (-fontMetricsInt2.top) + fontMetricsInt2.bottom);
        return i17;
    }
}
