package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* loaded from: classes14.dex */
public class GuildCircleProgressView extends ImageView {
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
    int f235827d;

    /* renamed from: e, reason: collision with root package name */
    float f235828e;

    /* renamed from: f, reason: collision with root package name */
    int f235829f;

    /* renamed from: h, reason: collision with root package name */
    int f235830h;

    /* renamed from: i, reason: collision with root package name */
    int f235831i;

    /* renamed from: m, reason: collision with root package name */
    int f235832m;

    public GuildCircleProgressView(Context context) {
        super(context);
        this.f235831i = 9;
        this.I = new RectF();
        this.J = true;
        this.K = true;
        b();
    }

    private void b() {
        this.f235828e = getResources().getDisplayMetrics().density;
        this.f235829f = getResources().getColor(17170445);
        this.C = getResources().getColor(R.color.bn7);
        this.f235832m = 51;
        this.D = 255;
        this.f235830h = getResources().getColor(R.color.bob);
        Paint paint = new Paint();
        this.G = paint;
        paint.setAntiAlias(true);
        this.G.setStyle(Paint.Style.STROKE);
    }

    protected void a(Canvas canvas) {
        this.G.setColor(this.f235829f);
        if (this.J) {
            this.G.setAlpha((this.f235832m * 255) / 100);
        }
        this.G.setShadowLayer(this.f235831i, 0.0f, 0.0f, this.f235830h);
        canvas.drawArc(this.I, -90.0f, 360.0f, false, this.G);
        this.G.setColor(this.C);
        if (this.K) {
            this.G.setAlpha((this.D * 255) / 100);
        }
        this.G.setShadowLayer(this.f235831i, 0.0f, 0.0f, this.f235830h);
        RectF rectF = this.I;
        int i3 = this.f235827d;
        rectF.set(i3, i3, this.E - i3, this.F - i3);
        canvas.drawArc(this.I, -90.0f, (float) (this.H * 3.6d), false, this.G);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.E = getWidth();
        this.F = getHeight();
        RectF rectF = this.I;
        int i3 = this.f235827d;
        rectF.set(i3, i3, this.E - i3, r0 - i3);
        a(canvas);
    }

    public void setBgAndProgressColor(int i3, int i16, int i17, int i18) {
        this.f235829f = i16;
        this.f235832m = i3;
        this.C = i18;
        this.D = i17;
    }

    public void setBgAndProgressUseAlpha(boolean z16, boolean z17) {
        this.J = z16;
        this.K = z17;
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
        this.f235831i = i3;
    }

    public void setStrokeWidth(float f16) {
        int i3 = (int) ((f16 * this.f235828e) + 0.5d);
        this.f235827d = i3;
        this.G.setStrokeWidth(i3);
    }

    public void setmShadowColor(int i3) {
        this.f235830h = i3;
    }

    public GuildCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f235831i = 9;
        this.I = new RectF();
        this.J = true;
        this.K = true;
        b();
    }
}
