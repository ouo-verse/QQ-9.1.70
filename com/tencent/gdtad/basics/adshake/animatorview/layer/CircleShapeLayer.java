package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CircleShapeLayer extends AnimatorLayer {
    private static final String TAG = "CircleShapeLayer";
    private float mRadius;
    private float mScale;

    public CircleShapeLayer(float f16, float f17, float f18, int i3) {
        setCenterX(f16);
        setCenterY(f17);
        setRadius(f18);
        int i16 = (int) (f18 * 2.0f);
        setWidth(i16);
        setHeight(i16);
        setColor(i3);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            canvas.drawCircle(getCenterX(), getCenterY(), getRadius(), getPaint());
            canvas.setMatrix(null);
            return;
        }
        canvas.drawCircle(getCenterX(), getCenterY(), getRadius(), getPaint());
    }

    public float getRadius() {
        float f16 = this.mScale;
        if (f16 > 0.0f) {
            return this.mRadius * f16;
        }
        return this.mRadius;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        return false;
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
        this.mScale = 0.0f;
    }

    public void setColor(int i3) {
        this.mPaint.setColor(i3);
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
    }

    public CircleShapeLayer setShadowLayer(float f16, float f17, float f18, int i3) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setShadowLayer(f16, f17, f18, i3);
        }
        return this;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
    }
}
