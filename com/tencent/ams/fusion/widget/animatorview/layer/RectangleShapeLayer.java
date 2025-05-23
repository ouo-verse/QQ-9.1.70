package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RectangleShapeLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_;
    private Paint mStrokePaint;
    private float mXRadius;
    private float mYRadius;

    public RectangleShapeLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        canvas.drawRoundRect(new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight()), this.mXRadius, this.mYRadius, getPaint());
        if (this.mStrokePaint != null) {
            canvas.drawRoundRect(new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight()), this.mXRadius, this.mYRadius, this.mStrokePaint);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        float f16 = this.mScaleY;
        if (f16 != Float.MIN_VALUE) {
            return (int) (f16 * this.mHeight);
        }
        return super.getHeight();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        float f16 = this.mScaleX;
        if (f16 != Float.MIN_VALUE) {
            return (int) (f16 * this.mWidth);
        }
        return super.getWidth();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(adapterGrayColor(i3));
        }
    }

    public void setPaintStyle(Paint.Style style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) style);
            return;
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStyle(style);
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.mXRadius = f16;
            this.mYRadius = f16;
        }
    }

    public void setStroke(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        if (f16 > 0.0f) {
            Paint paint = new Paint();
            this.mStrokePaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setStrokeWidth(f16);
            this.mStrokePaint.setStrokeCap(Paint.Cap.ROUND);
            this.mStrokePaint.setColor(i3);
            this.mStrokePaint.setAntiAlias(true);
        }
    }

    public void setXRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mXRadius = f16;
        }
    }

    public void setYRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mYRadius = f16;
        }
    }

    public RectangleShapeLayer(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        setWidth(i3);
        setHeight(i16);
        setPaintStyle(Paint.Style.FILL);
        setColor(i17);
    }
}
