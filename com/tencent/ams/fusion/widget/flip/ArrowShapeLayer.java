package com.tencent.ams.fusion.widget.flip;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArrowShapeLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ArrowShapeLayer";
    private float mAlphaFactor;
    private int mDirection;
    private float mLineCornerRadius;
    private float mLineHeightRatio;
    private final Paint mLinePaint;
    private final Path mLinePath;
    private float mLineWidthRatio;
    private float mProgress;
    private float mTriangleCornerRadius;
    private final Paint mTrianglePaint;
    private final Path mTrianglePath;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ArrowDirection {
        public static final int LEFT_TO_RIGHT = 1;
        public static final int RIGHT_TO_LEFT = 2;
    }

    public ArrowShapeLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mProgress = 0.0f;
        this.mLineHeightRatio = 0.75f;
        this.mLineWidthRatio = 0.33333334f;
        this.mAlphaFactor = 1.0f;
        this.mLinePath = new Path();
        Paint paint = new Paint();
        this.mLinePaint = paint;
        this.mTrianglePath = new Path();
        Paint paint2 = new Paint();
        this.mTrianglePaint = paint2;
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.FILL);
    }

    private float[] getXSymmetry(float f16, float[] fArr) {
        return new float[]{(f16 * 2.0f) - fArr[0], fArr[1]};
    }

    private float[] getYSymmetry(float f16, float[] fArr) {
        return new float[]{fArr[0], (f16 * 2.0f) - fArr[1]};
    }

    private void updatePath(float f16) {
        float f17;
        float f18;
        RectF rectF;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        if (f16 < 0.0f) {
            f17 = 0.0f;
        } else if (f16 > 1.0f) {
            f17 = 1.0f;
        } else {
            f17 = f16;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float height2 = getHeight() * this.mLineHeightRatio;
        float width2 = getWidth() * this.mLineWidthRatio;
        float width3 = getWidth() - width2;
        float f19 = height2 / 2.0f;
        float min = Math.min(f17 / this.mLineWidthRatio, 1.0f);
        float f26 = this.mLineWidthRatio;
        if (f17 > f26) {
            f18 = (f17 - f26) / (1.0f - f26);
        } else {
            f18 = 0.0f;
        }
        this.mLinePath.reset();
        this.mTrianglePath.reset();
        if (this.mDirection == 1) {
            rectF = new RectF(getCenterX() - width, getCenterY() + f19, (getCenterX() - width) + (min * width2), getCenterY() - f19);
            float f27 = this.mLineCornerRadius;
            fArr = new float[]{f27, f27, 0.0f, 0.0f, 0.0f, 0.0f, f27, f27};
        } else {
            rectF = new RectF((getCenterX() + width) - (min * width2), getCenterY() + f19, getCenterX() + width, getCenterY() - f19);
            float f28 = this.mLineCornerRadius;
            fArr = new float[]{0.0f, 0.0f, f28, f28, f28, f28, 0.0f, 0.0f};
        }
        this.mLinePath.addRoundRect(rectF, fArr, Path.Direction.CW);
        if (f18 <= 0.0f) {
            return;
        }
        if (this.mDirection == 1) {
            fArr2 = new float[]{(getCenterX() - width) + width2, getCenterY() + height};
            fArr3 = new float[]{(getCenterX() - width) + width2 + (width3 * f18), getCenterY() + (height * (1.0f - f18))};
        } else {
            fArr2 = new float[]{(getCenterX() + width) - width2, getCenterY() + height};
            fArr3 = new float[]{((getCenterX() + width) - width2) - (width3 * f18), getCenterY() + (height * (1.0f - f18))};
        }
        float[] ySymmetry = getYSymmetry(getCenterY(), fArr3);
        float[] ySymmetry2 = getYSymmetry(getCenterY(), fArr2);
        this.mTrianglePath.moveTo(fArr2[0], fArr2[1]);
        this.mTrianglePath.lineTo(fArr3[0], fArr3[1]);
        this.mTrianglePath.lineTo(ySymmetry[0], ySymmetry[1]);
        this.mTrianglePath.lineTo(ySymmetry2[0], ySymmetry2[1]);
        this.mTrianglePath.close();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            canvas.drawPath(this.mLinePath, this.mLinePaint);
            canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
            canvas.setMatrix(null);
            return;
        }
        canvas.drawPath(this.mLinePath, this.mLinePaint);
        canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
    }

    public void init(int i3, int i16, int i17, int i18, int i19, int i26, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mDirection = i19;
        this.mLineHeightRatio = f16;
        this.mLineWidthRatio = f17;
        this.mTriangleCornerRadius = f19;
        this.mLineCornerRadius = f18;
        this.mLinePaint.setColor(i26);
        this.mTrianglePaint.setColor(i26);
        this.mTrianglePaint.setPathEffect(new CornerPathEffect(this.mTriangleCornerRadius));
        this.mProgress = 0.0f;
        setCenterX(i3);
        setCenterY(i16);
        setWidth(i17);
        setHeight(i18);
        updatePath(this.mProgress);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.mAlpha = i3;
        float f16 = i3;
        this.mPaint.setAlpha((int) (this.mAlphaFactor * f16));
        this.mLinePaint.setAlpha((int) (this.mAlphaFactor * f16));
        this.mTrianglePaint.setAlpha((int) (f16 * this.mAlphaFactor));
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mProgress = f16;
            updatePath(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mTrianglePath.offset(f16 - getDistanceX(), f17 - getDistanceY());
        this.mLinePath.offset(f16 - getDistanceX(), f17 - getDistanceY());
        super.postTranslate(f16, f17);
    }

    public void setAlphaFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mAlphaFactor = f16;
            postAlpha(this.mAlpha);
        }
    }
}
