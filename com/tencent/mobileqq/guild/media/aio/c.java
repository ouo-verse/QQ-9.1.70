package com.tencent.mobileqq.guild.media.aio;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends ReplacementSpan {
    private final int C;
    private final int D;
    private final int E;

    /* renamed from: d, reason: collision with root package name */
    private int f227891d;

    /* renamed from: e, reason: collision with root package name */
    private final int f227892e;

    /* renamed from: f, reason: collision with root package name */
    private final int f227893f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f227894h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f227895i;

    /* renamed from: m, reason: collision with root package name */
    private final int f227896m;

    public c(int i3, int i16, int i17, TextView textView, int i18, int i19) {
        this(i3, i16, i17, textView, i18, i19, 0, 0);
    }

    private Path a(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, boolean z17, boolean z18, boolean z19) {
        Path path = new Path();
        if (f26 < 0.0f) {
            f26 = 0.0f;
        }
        if (f27 < 0.0f) {
            f27 = 0.0f;
        }
        float f28 = f18 - f16;
        float f29 = f19 - f17;
        float f36 = f28 / 2.0f;
        if (f26 > f36) {
            f26 = f36;
        }
        float f37 = f29 / 2.0f;
        if (f27 > f37) {
            f27 = f37;
        }
        float f38 = f28 - (f26 * 2.0f);
        float f39 = f29 - (2.0f * f27);
        path.moveTo(f18, f17 + f27);
        if (z17) {
            float f46 = -f27;
            path.rQuadTo(0.0f, f46, -f26, f46);
        } else {
            path.rLineTo(0.0f, -f27);
            path.rLineTo(-f26, 0.0f);
        }
        path.rLineTo(-f38, 0.0f);
        if (z16) {
            float f47 = -f26;
            path.rQuadTo(f47, 0.0f, f47, f27);
        } else {
            path.rLineTo(-f26, 0.0f);
            path.rLineTo(0.0f, f27);
        }
        path.rLineTo(0.0f, f39);
        if (z19) {
            path.rQuadTo(0.0f, f27, f26, f27);
        } else {
            path.rLineTo(0.0f, f27);
            path.rLineTo(f26, 0.0f);
        }
        path.rLineTo(f38, 0.0f);
        if (z18) {
            path.rQuadTo(f26, 0.0f, f26, -f27);
        } else {
            path.rLineTo(f26, 0.0f);
            path.rLineTo(0.0f, -f27);
        }
        path.rLineTo(0.0f, -f39);
        path.close();
        return path;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        String str;
        int i26;
        String str2;
        int i27;
        int i28;
        int i29;
        int measureText = (int) paint.measureText(charSequence, i3, i16);
        String substring = charSequence.toString().substring(i3, i16);
        int width = (int) (this.f227895i.getWidth() - f16);
        if (measureText > width) {
            str = TextUtils.ellipsize(substring, new TextPaint(paint), width, TextUtils.TruncateAt.END).toString();
            measureText = width;
        } else {
            str = substring;
        }
        int color = paint.getColor();
        paint.setColor(this.f227891d);
        paint.setAntiAlias(true);
        if (this.f227894h == null) {
            this.f227894h = new RectF();
        }
        this.f227894h.set(f16, i17 + this.D, measureText + f16, i19 - this.E);
        if (i3 == this.f227896m) {
            RectF rectF = this.f227894h;
            float f17 = rectF.left;
            float f18 = rectF.top;
            int i36 = this.f227893f;
            i26 = color;
            str2 = str;
            canvas.drawPath(a(f17, f18, i36 + f17, rectF.bottom, i36, i36, true, false, false, true), paint);
            i27 = this.f227893f;
        } else {
            i26 = color;
            str2 = str;
            i27 = 0;
        }
        if (i16 == this.C) {
            RectF rectF2 = this.f227894h;
            float f19 = rectF2.right;
            int i37 = this.f227893f;
            i28 = i27;
            canvas.drawPath(a(f19 - i37, rectF2.top, f19, rectF2.bottom, i37, i37, false, true, true, false), paint);
            i29 = this.f227893f;
        } else {
            i28 = i27;
            i29 = 0;
        }
        if (this.f227894h.width() >= i28 + i29) {
            RectF rectF3 = this.f227894h;
            canvas.drawRect(rectF3.left + i28, rectF3.top, rectF3.right - i29, rectF3.bottom, paint);
        }
        paint.setColor(this.f227892e);
        canvas.drawText(str2, f16, i18, paint);
        paint.setColor(i26);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence, i3, i16);
    }

    public c(int i3, int i16, int i17, TextView textView, int i18, int i19, int i26, int i27) {
        this.f227891d = i3;
        this.f227892e = i16;
        this.f227893f = i17;
        this.f227895i = textView;
        this.f227894h = new RectF();
        this.f227896m = i18;
        this.C = i19;
        this.D = i26;
        this.E = i27;
    }
}
