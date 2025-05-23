package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* loaded from: classes3.dex */
public class CircleProgressWithBg extends ImageView {
    int C;
    int D;
    int E;
    int F;
    Paint G;
    float H;
    RectF I;
    boolean J;
    boolean K;

    /* renamed from: d, reason: collision with root package name */
    int f75574d;

    /* renamed from: e, reason: collision with root package name */
    float f75575e;

    /* renamed from: f, reason: collision with root package name */
    int f75576f;

    /* renamed from: h, reason: collision with root package name */
    int f75577h;

    /* renamed from: i, reason: collision with root package name */
    int f75578i;

    /* renamed from: m, reason: collision with root package name */
    int f75579m;

    public CircleProgressWithBg(Context context) {
        super(context);
        this.f75578i = 9;
        this.I = new RectF();
        this.J = true;
        this.K = true;
        b();
    }

    private void b() {
        this.f75575e = getResources().getDisplayMetrics().density;
        this.f75576f = getResources().getColor(R.color.j_);
        this.C = getResources().getColor(R.color.f157037i4);
        this.f75579m = 51;
        this.D = 255;
        this.f75577h = getResources().getColor(R.color.f157067iz);
        Paint paint = new Paint();
        this.G = paint;
        paint.setAntiAlias(true);
        this.G.setStyle(Paint.Style.STROKE);
    }

    protected void a(Canvas canvas) {
        this.G.setColor(this.f75576f);
        this.G.setStyle(Paint.Style.FILL);
        if (this.J) {
            this.G.setAlpha((this.f75579m * 255) / 100);
        }
        this.G.setShadowLayer(this.f75578i, 0.0f, 0.0f, this.f75577h);
        canvas.drawCircle(this.E / 2.0f, this.F / 2.0f, Math.max(this.E, this.F) / 2, this.G);
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setColor(this.C);
        if (this.K) {
            this.G.setAlpha((this.D * 255) / 100);
        }
        this.G.setShadowLayer(this.f75578i, 0.0f, 0.0f, this.f75577h);
        RectF rectF = this.I;
        int i3 = this.f75574d;
        rectF.set(i3, i3, this.E - i3, this.F - i3);
        canvas.drawArc(this.I, -90.0f, (float) (this.H * 3.6d), false, this.G);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.E = getWidth();
        this.F = getHeight();
        RectF rectF = this.I;
        int i3 = this.f75574d;
        rectF.set(i3, i3, this.E - i3, r0 - i3);
        a(canvas);
    }

    public void setBgAndProgressColor(int i3, int i16, int i17, int i18) {
        this.f75576f = i16;
        this.f75579m = i3;
        this.C = i18;
        this.D = i17;
    }

    public void setProgress(float f16) {
        float f17 = 100.0f;
        if (f16 <= 100.0f) {
            f17 = f16;
        }
        this.H = f17;
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        this.H = f16;
        invalidate();
    }

    public void setShadowRadius(int i3) {
        this.f75578i = i3;
    }

    public void setStrokeWidth(float f16) {
        int i3 = (int) ((f16 * this.f75575e) + 0.5d);
        this.f75574d = i3;
        this.G.setStrokeWidth(i3);
    }

    public void setmShadowColor(int i3) {
        this.f75577h = i3;
    }

    public CircleProgressWithBg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75578i = 9;
        this.I = new RectF();
        this.J = true;
        this.K = true;
        b();
    }
}
