package com.tencent.mobileqq.guild.media.aio;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ac extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f227852d;

    /* renamed from: e, reason: collision with root package name */
    private int f227853e;

    /* renamed from: f, reason: collision with root package name */
    private Path f227854f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f227855h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f227856i;

    public ac(Drawable drawable, int i3) {
        super(drawable, i3);
        this.f227852d = 0;
        this.f227853e = 0;
        this.f227855h = false;
    }

    public void a(Drawable drawable) {
        this.f227856i = drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        int i26;
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (((ImageSpan) this).mVerticalAlignment == 1) {
            i26 = ((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
        } else {
            i26 = (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17;
        }
        canvas.translate((f16 + this.f227852d) - this.f227853e, i26);
        if (this.f227855h) {
            canvas.clipPath(this.f227854f);
        }
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = this.f227856i;
        if (drawable != null) {
            return drawable;
        }
        return super.getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i18 = (bounds.bottom - bounds.top) / 2;
            int i19 = i17 / 4;
            int i26 = i18 - i19;
            int i27 = -(i18 + i19);
            fontMetricsInt.ascent = i27;
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
        }
        return bounds.right + this.f227852d + this.f227853e;
    }
}
