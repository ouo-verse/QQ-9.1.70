package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class RingShapeLayer extends AnimatorLayer {
    private static final String TAG = "RingShapeLayer";
    private float mProgress;
    private float mRadius;
    private float mScale;
    private float mStrokeWidth;

    public RingShapeLayer(float f16, float f17, float f18, int i3, float f19) {
        this.mCenterX = f16;
        this.mCenterY = f17;
        this.mRadius = f18;
        int i16 = (int) (f18 * 2.0f);
        this.mWidth = i16;
        this.mHeight = i16;
        this.mPaint.setColor(i3);
        this.mStrokeWidth = f19;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF();
        rectF.left = getCenterX() - getRadius();
        rectF.top = getCenterY() - getRadius();
        rectF.right = getCenterX() + getRadius();
        rectF.bottom = getCenterY() + getRadius();
        canvas.drawArc(rectF, -90.0f, this.mProgress * 360.0f, false, this.mPaint);
    }

    public float getRadius() {
        float f16 = this.mScale;
        if (f16 > 0.0f) {
            return this.mRadius * f16;
        }
        return this.mRadius;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        if (f16 < 0.0f) {
            this.mProgress = 0.0f;
        } else if (f16 > 1.0f) {
            this.mProgress = 1.0f;
        } else {
            this.mProgress = f16;
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17, float f18, float f19, float f26) {
        if (f16 != f17) {
            QLog.w(TAG, 1, "Not support ellipse scale.");
        }
        this.mScale = f16;
        float f27 = this.mCenterX;
        this.mCenterX = f27 + ((f18 - f27) * f26);
        float f28 = this.mCenterY;
        this.mCenterY = f28 + ((f19 - f28) * f26);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void reset() {
        super.reset();
        this.mProgress = 0.0f;
        this.mPaint.setAlpha(255);
    }

    public RingShapeLayer setStrokeCap(Paint.Cap cap) {
        this.mPaint.setStrokeCap(cap);
        return this;
    }
}
