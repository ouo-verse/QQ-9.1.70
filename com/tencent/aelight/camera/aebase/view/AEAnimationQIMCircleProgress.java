package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.tencent.widget.QIMCircleProgress;

/* loaded from: classes32.dex */
public class AEAnimationQIMCircleProgress extends AnimationQIMCircleProgress {
    private static final int[] L;
    private RectF J;
    private Paint K;

    public AEAnimationQIMCircleProgress(Context context) {
        super(context);
    }

    private void f() {
        if (this.K != null) {
            return;
        }
        Paint paint = new Paint();
        this.K = paint;
        paint.setAntiAlias(true);
        this.K.setStyle(Paint.Style.STROKE);
        this.K.setStrokeWidth(this.mStrokeWidth);
        this.K.setShader(new SweepGradient(this.J.centerX(), this.J.centerY(), L, (float[]) null));
    }

    @Override // com.tencent.widget.QIMCircleProgress, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        f();
        float f16 = (((this.mProgress - (QIMCircleProgress.MAX_PROGRESS * (-0.0055555557f))) * 360.0f) / QIMCircleProgress.MAX_PROGRESS) - 4.0f;
        if (f16 > 0.0f) {
            canvas.drawArc(this.J, (((r0 * 360.0f) / r3) - 90.0f) + 2.0f, f16, false, this.K);
        }
        if (this.mMode != 2) {
            drawCenterCircle(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        int i19 = this.mStrokeWidth;
        float f16 = this.mProgressOffset;
        this.J = new RectF(i19 + f16, i19 + f16, (i3 - i19) - f16, (i16 - i19) - f16);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void setStrokeWidth(float f16) {
        super.setStrokeWidth(f16);
        Paint paint = this.K;
        if (paint != null) {
            paint.setStrokeWidth(this.mStrokeWidth);
        }
    }

    public AEAnimationQIMCircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static {
        L = r0;
        int[] iArr = {Color.parseColor("#B380CF"), Color.parseColor("#FD86A2"), Color.parseColor("#F78A92"), Color.parseColor("#FB785A"), Color.parseColor("#FF904B"), Color.parseColor("#F8BF72"), Color.parseColor("#8190E0"), Color.parseColor("#5F7EFB"), Color.parseColor("#B380CF")};
    }
}
