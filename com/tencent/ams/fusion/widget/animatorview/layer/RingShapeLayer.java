package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RingShapeLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RingShapeLayer";
    protected float mProgress;
    protected float mRadius;
    protected float mScale;
    private float mStartAngle;
    protected float mStrokeWidth;
    private Paint.Style mStyle;
    private float mSweepAngle;
    private boolean mUseCenter;

    public RingShapeLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStartAngle = -90.0f;
        this.mSweepAngle = 360.0f;
        this.mUseCenter = false;
        this.mStyle = Paint.Style.STROKE;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setStyle(this.mStyle);
        this.mPaint.setAlpha(this.mAlpha);
        RectF rectF = new RectF();
        rectF.left = getCenterX() - getRadius();
        rectF.top = getCenterY() - getRadius();
        rectF.right = getCenterX() + getRadius();
        rectF.bottom = getCenterY() + getRadius();
        canvas.drawArc(rectF, this.mStartAngle, this.mSweepAngle * this.mProgress, this.mUseCenter, this.mPaint);
    }

    public float getRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        float f16 = this.mScale;
        if (f16 > 0.0f) {
            return this.mRadius * f16;
        }
        return this.mRadius;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        if (f16 < 0.0f) {
            this.mProgress = 0.0f;
        } else if (f16 > 1.0f) {
            this.mProgress = 1.0f;
        } else {
            this.mProgress = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        super.postScale(f16, f17);
        if (f16 != f17) {
            Logger.w(TAG, "Not support ellipse scale.");
        }
        this.mScale = f16;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.reset();
        this.mProgress = 0.0f;
        this.mPaint.setAlpha(255);
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mRadius = f16;
        }
    }

    public void setStartAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mStartAngle = f16;
        }
    }

    public RingShapeLayer setStrokeCap(Paint.Cap cap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RingShapeLayer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cap);
        }
        this.mPaint.setStrokeCap(cap);
        return this;
    }

    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        Logger.d(TAG, "setStrokeWidth: " + f16);
        this.mStrokeWidth = f16;
    }

    public void setStyle(Paint.Style style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) style);
        } else {
            this.mStyle = style;
        }
    }

    public void setSweepAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mSweepAngle = f16;
        }
    }

    public void setUseCenter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mUseCenter = z16;
        }
    }

    public RingShapeLayer(float f16, float f17, float f18, int i3, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i3), Float.valueOf(f19));
            return;
        }
        this.mStartAngle = -90.0f;
        this.mSweepAngle = 360.0f;
        this.mUseCenter = false;
        this.mStyle = Paint.Style.STROKE;
        setCenterX(f16);
        setCenterY(f17);
        setRadius(f18);
        int i16 = (int) (f18 * 2.0f);
        setWidth(i16);
        setHeight(i16);
        setPaintColor(adapterGrayColor(i3));
        setStrokeWidth(f19);
    }
}
