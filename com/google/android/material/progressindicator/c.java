package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
final class c extends g<CircularProgressIndicatorSpec> {

    /* renamed from: c, reason: collision with root package name */
    private int f33956c;

    /* renamed from: d, reason: collision with root package name */
    private float f33957d;

    /* renamed from: e, reason: collision with root package name */
    private float f33958e;

    /* renamed from: f, reason: collision with root package name */
    private float f33959f;

    public c(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f33956c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f16, float f17, float f18) {
        canvas.save();
        canvas.rotate(f18);
        float f19 = this.f33959f;
        float f26 = f16 / 2.0f;
        canvas.drawRoundRect(new RectF(f19 - f26, f17, f19 + f26, -f17), f17, f17, paint);
        canvas.restore();
    }

    private int i() {
        S s16 = this.f33983a;
        return ((CircularProgressIndicatorSpec) s16).f33944g + (((CircularProgressIndicatorSpec) s16).f33945h * 2);
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        int i3;
        S s16 = this.f33983a;
        float f17 = (((CircularProgressIndicatorSpec) s16).f33944g / 2.0f) + ((CircularProgressIndicatorSpec) s16).f33945h;
        canvas.translate(f17, f17);
        canvas.rotate(-90.0f);
        float f18 = -f17;
        canvas.clipRect(f18, f18, f17, f17);
        if (((CircularProgressIndicatorSpec) this.f33983a).f33946i == 0) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        this.f33956c = i3;
        this.f33957d = ((CircularProgressIndicatorSpec) r5).f33950a * f16;
        this.f33958e = ((CircularProgressIndicatorSpec) r5).f33951b * f16;
        this.f33959f = (((CircularProgressIndicatorSpec) r5).f33944g - ((CircularProgressIndicatorSpec) r5).f33950a) / 2.0f;
        if ((this.f33984b.m() && ((CircularProgressIndicatorSpec) this.f33983a).f33954e == 2) || (this.f33984b.k() && ((CircularProgressIndicatorSpec) this.f33983a).f33955f == 1)) {
            this.f33959f += ((1.0f - f16) * ((CircularProgressIndicatorSpec) this.f33983a).f33950a) / 2.0f;
        } else if ((this.f33984b.m() && ((CircularProgressIndicatorSpec) this.f33983a).f33954e == 1) || (this.f33984b.k() && ((CircularProgressIndicatorSpec) this.f33983a).f33955f == 2)) {
            this.f33959f -= ((1.0f - f16) * ((CircularProgressIndicatorSpec) this.f33983a).f33950a) / 2.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17, @ColorInt int i3) {
        float f18;
        if (f16 == f17) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setStrokeWidth(this.f33957d);
        int i16 = this.f33956c;
        float f19 = f16 * 360.0f * i16;
        if (f17 >= f16) {
            f18 = f17 - f16;
        } else {
            f18 = (1.0f + f17) - f16;
        }
        float f26 = f18 * 360.0f * i16;
        float f27 = this.f33959f;
        canvas.drawArc(new RectF(-f27, -f27, f27, f27), f19, f26, false, paint);
        if (this.f33958e > 0.0f && Math.abs(f26) < 360.0f) {
            paint.setStyle(Paint.Style.FILL);
            h(canvas, paint, this.f33957d, this.f33958e, f19);
            h(canvas, paint, this.f33957d, this.f33958e, f19 + f26);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a16 = z0.a.a(((CircularProgressIndicatorSpec) this.f33983a).f33953d, this.f33984b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a16);
        paint.setStrokeWidth(this.f33957d);
        float f16 = this.f33959f;
        canvas.drawArc(new RectF(-f16, -f16, f16, f16), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.g
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.g
    public int e() {
        return i();
    }
}
