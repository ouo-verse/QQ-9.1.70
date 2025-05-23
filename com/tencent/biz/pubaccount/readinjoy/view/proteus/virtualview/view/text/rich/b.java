package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends ReplacementSpan {
    private final float C;
    private final float D;

    /* renamed from: d, reason: collision with root package name */
    private final int f79873d;

    /* renamed from: e, reason: collision with root package name */
    private final int f79874e;

    /* renamed from: f, reason: collision with root package name */
    private final float f79875f;

    /* renamed from: h, reason: collision with root package name */
    private final float f79876h;

    /* renamed from: i, reason: collision with root package name */
    private final float f79877i;

    /* renamed from: m, reason: collision with root package name */
    private final float f79878m;

    public b(int i3, int i16, float f16, float f17, float f18, float f19, float f26, float f27) {
        this.f79873d = i3;
        this.f79874e = i16;
        this.f79875f = f16;
        this.f79876h = f17;
        this.f79877i = f18;
        this.f79878m = f19;
        this.C = f26;
        this.D = f27;
    }

    private TextPaint a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(this.D);
        return textPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        TextPaint a16 = a(paint);
        Paint.FontMetricsInt fontMetricsInt = a16.getFontMetricsInt();
        float measureText = this.f79875f + f16 + paint.measureText(charSequence, i3, i16);
        RectF rectF = new RectF();
        rectF.set(f16, i17, measureText + this.f79876h, i19 + this.f79878m);
        paint.setColor(this.f79873d);
        float f17 = this.C;
        canvas.drawRoundRect(rectF, f17, f17, paint);
        int round = Math.round(f16 + this.f79875f);
        int round2 = Math.round((i18 - (((((i18 + fontMetricsInt.descent) + i18) + fontMetricsInt.ascent) / 2) - ((i17 + i19) / 2))) + this.f79877i);
        a16.setColor(this.f79874e);
        canvas.drawText(charSequence, i3, i16, round, round2, a16);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) (a(paint).measureText(charSequence.subSequence(i3, i16).toString()) + this.f79875f + this.f79876h);
    }
}
