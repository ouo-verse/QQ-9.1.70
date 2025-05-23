package com.tencent.mobileqq.vasgift.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;

/* loaded from: classes20.dex */
public class QQGiftCircleProgress extends RoundImageView {
    int D;
    float E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    Paint N;
    float P;
    RectF Q;
    boolean R;
    boolean S;

    public QQGiftCircleProgress(Context context) {
        super(context);
        this.H = 9;
        this.Q = new RectF();
        this.R = true;
        this.S = true;
        e();
    }

    private void e() {
        this.E = getResources().getDisplayMetrics().density;
        this.F = getResources().getColor(R.color.j_);
        this.J = getResources().getColor(R.color.f157037i4);
        this.I = 51;
        this.K = 255;
        this.G = getResources().getColor(R.color.f157067iz);
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
        this.N.setStyle(Paint.Style.STROKE);
    }

    protected void c(Canvas canvas) {
        this.N.setColor(this.F);
        if (this.R) {
            this.N.setAlpha((this.I * 255) / 100);
        }
        this.N.setShadowLayer(this.H, 0.0f, 0.0f, this.G);
        RectF rectF = this.Q;
        int i3 = this.D;
        rectF.set((i3 / 2.0f) + 0.0f, (i3 / 2.0f) + 0.0f, this.L - (i3 / 2.0f), this.M - (i3 / 2.0f));
        canvas.drawArc(this.Q, -90.0f, 360.0f, false, this.N);
        this.N.setColor(this.J);
        if (this.S) {
            this.N.setAlpha((this.K * 255) / 100);
        }
        this.N.setShadowLayer(this.H, 0.0f, 0.0f, this.G);
        canvas.drawArc(this.Q, -90.0f, (float) (this.P * 3.6d), false, this.N);
    }

    public float d() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.RoundImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.L = getWidth();
        int height = getHeight();
        this.M = height;
        RectF rectF = this.Q;
        int i3 = this.D;
        rectF.set((i3 / 2.0f) + 0.0f, (i3 / 2.0f) + 0.0f, this.L - (i3 / 2.0f), height - (i3 / 2.0f));
        c(canvas);
    }

    public void setBgAndProgressColor(int i3, int i16, int i17, int i18) {
        this.F = i16;
        this.I = i3;
        this.J = i18;
        this.K = i17;
    }

    public void setBgAndProgressUseAlpha(boolean z16, boolean z17) {
        this.R = z16;
        this.S = z17;
    }

    public void setProgress(float f16) {
        float f17 = 100.0f;
        if (f16 <= 100.0f) {
            f17 = f16;
        }
        this.P = f17;
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        this.P = f16;
        invalidate();
    }

    public void setShadowRadius(int i3) {
        this.H = i3;
    }

    public void setStrokeWidth(float f16) {
        int i3 = (int) ((f16 * this.E) + 0.5d);
        this.D = i3;
        this.N.setStrokeWidth(i3);
    }

    public void setmShadowColor(int i3) {
        this.G = i3;
    }

    public QQGiftCircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 9;
        this.Q = new RectF();
        this.R = true;
        this.S = true;
        e();
    }
}
