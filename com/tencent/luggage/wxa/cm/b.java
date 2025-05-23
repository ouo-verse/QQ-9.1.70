package com.tencent.luggage.wxa.cm;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends ReplacementSpan {

    /* renamed from: a, reason: collision with root package name */
    public final String f123711a;

    /* renamed from: b, reason: collision with root package name */
    public final float f123712b;

    /* renamed from: c, reason: collision with root package name */
    public final int f123713c;

    /* renamed from: d, reason: collision with root package name */
    public final int f123714d;

    /* renamed from: e, reason: collision with root package name */
    public final int f123715e;

    /* renamed from: f, reason: collision with root package name */
    public final int f123716f;

    /* renamed from: g, reason: collision with root package name */
    public final int f123717g;

    public b(String str, int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f123712b = i17;
        this.f123711a = str;
        this.f123713c = i18;
        this.f123714d = i19;
        this.f123715e = i26;
        this.f123716f = i3;
        this.f123717g = i16;
    }

    public int a(Paint paint) {
        if (paint == null) {
            paint = new Paint();
        }
        paint.setTextSize(this.f123712b);
        return ((int) paint.measureText(this.f123711a)) + this.f123716f + this.f123717g + (this.f123715e * 2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        paint.setTextSize(this.f123712b);
        paint.setAntiAlias(true);
        RectF rectF = new RectF();
        rectF.left = ((int) f16) + this.f123716f;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int max = Math.max(0, ((((i19 - i17) - fontMetricsInt.descent) + fontMetricsInt.top) / 2) - this.f123715e);
        rectF.top = i17 + max;
        rectF.bottom = i19 - max;
        rectF.right = rectF.left + ((int) paint.measureText(this.f123711a)) + (this.f123715e * 2);
        paint.setColor(this.f123714d);
        float f17 = this.f123715e;
        canvas.drawRoundRect(rectF, f17, f17, paint);
        paint.setColor(this.f123713c);
        String str = this.f123711a;
        float f18 = rectF.left;
        float f19 = this.f123715e;
        canvas.drawText(str, f18 + f19, (rectF.top + f19) - fontMetricsInt.top, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        return a(paint);
    }
}
