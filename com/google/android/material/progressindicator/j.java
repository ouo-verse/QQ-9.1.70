package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
final class j extends g<LinearProgressIndicatorSpec> {

    /* renamed from: c, reason: collision with root package name */
    private float f33988c;

    /* renamed from: d, reason: collision with root package name */
    private float f33989d;

    /* renamed from: e, reason: collision with root package name */
    private float f33990e;

    public j(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f33988c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        Rect clipBounds = canvas.getClipBounds();
        this.f33988c = clipBounds.width();
        float f17 = ((LinearProgressIndicatorSpec) this.f33983a).f33950a;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f33983a).f33950a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f33983a).f33949i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f33984b.m() && ((LinearProgressIndicatorSpec) this.f33983a).f33954e == 1) || (this.f33984b.k() && ((LinearProgressIndicatorSpec) this.f33983a).f33955f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f33984b.m() || this.f33984b.k()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f33983a).f33950a * (f16 - 1.0f)) / 2.0f);
        }
        float f18 = this.f33988c;
        canvas.clipRect((-f18) / 2.0f, (-f17) / 2.0f, f18 / 2.0f, f17 / 2.0f);
        S s16 = this.f33983a;
        this.f33989d = ((LinearProgressIndicatorSpec) s16).f33950a * f16;
        this.f33990e = ((LinearProgressIndicatorSpec) s16).f33951b * f16;
    }

    @Override // com.google.android.material.progressindicator.g
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17, @ColorInt int i3) {
        if (f16 == f17) {
            return;
        }
        float f18 = this.f33988c;
        float f19 = this.f33990e;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        float f26 = this.f33989d;
        RectF rectF = new RectF(((-f18) / 2.0f) + (f16 * (f18 - (f19 * 2.0f))), (-f26) / 2.0f, ((-f18) / 2.0f) + (f17 * (f18 - (f19 * 2.0f))) + (f19 * 2.0f), f26 / 2.0f);
        float f27 = this.f33990e;
        canvas.drawRoundRect(rectF, f27, f27, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a16 = z0.a.a(((LinearProgressIndicatorSpec) this.f33983a).f33953d, this.f33984b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(a16);
        float f16 = this.f33988c;
        float f17 = this.f33989d;
        RectF rectF = new RectF((-f16) / 2.0f, (-f17) / 2.0f, f16 / 2.0f, f17 / 2.0f);
        float f18 = this.f33990e;
        canvas.drawRoundRect(rectF, f18, f18, paint);
    }

    @Override // com.google.android.material.progressindicator.g
    public int d() {
        return ((LinearProgressIndicatorSpec) this.f33983a).f33950a;
    }

    @Override // com.google.android.material.progressindicator.g
    public int e() {
        return -1;
    }
}
