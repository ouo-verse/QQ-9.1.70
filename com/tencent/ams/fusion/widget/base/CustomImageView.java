package com.tencent.ams.fusion.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class CustomImageView extends ImageView {
    static IPatchRedirector $redirector_;
    private int mBorderColor;
    private float mBorderWidth;
    private float mLeftBottomRadius;
    private float mLeftTopRadius;
    private int mMaskColor;
    private final Paint mPaint;
    private float mRightBottomRadius;
    private float mRightTopRadius;

    public CustomImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mBorderWidth = 2.0f;
        this.mBorderColor = 0;
        setLayerType(2, null);
        this.mPaint = new Paint();
    }

    private Path createPath() {
        Path path = new Path();
        float f16 = this.mBorderWidth / 2.0f;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        rectF.inset(f16, f16);
        float f17 = this.mLeftTopRadius;
        float f18 = this.mRightTopRadius;
        float f19 = this.mRightBottomRadius;
        float f26 = this.mLeftBottomRadius;
        path.addRoundRect(rectF, new float[]{f17, f17, f18, f18, f19, f19, f26, f26}, Path.Direction.CW);
        return path;
    }

    private void doDraw(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path createPath = createPath();
        createPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(createPath, this.mPaint);
        this.mPaint.setXfermode(null);
        if (this.mBorderWidth > 0.0f && this.mBorderColor != 0) {
            drawBorders(canvas);
        }
        int i3 = this.mMaskColor;
        if (i3 != 0) {
            canvas.drawColor(i3);
        }
    }

    private void drawBorders(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        this.mPaint.setShader(null);
        this.mPaint.setColor(this.mBorderColor);
        canvas.drawPath(createPath(), this.mPaint);
    }

    private void resetSize(float f16) {
        this.mLeftTopRadius = Math.min(this.mLeftTopRadius, f16);
        this.mRightTopRadius = Math.min(this.mRightTopRadius, f16);
        this.mLeftBottomRadius = Math.min(this.mLeftBottomRadius, f16);
        this.mRightBottomRadius = Math.min(this.mRightBottomRadius, f16);
        this.mBorderWidth = Math.min(this.mBorderWidth, f16 / 2.0f);
    }

    public int getBorderColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.mBorderWidth;
    }

    public float getLeftBottomRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.mLeftBottomRadius;
    }

    public float getLeftTopRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.mLeftTopRadius;
    }

    public float getRightBottomRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this)).floatValue();
        }
        return this.mRightBottomRadius;
    }

    public float getRightTopRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.mRightTopRadius;
    }

    @Override // android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        if (getDrawable() != null) {
            resetSize(Math.min(getWidth(), getHeight()) / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            super.onDraw(canvas2);
            this.mPaint.reset();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setDither(true);
            doDraw(canvas2);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.mPaint);
            createBitmap.recycle();
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void postInvalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            super.postInvalidate();
        } else {
            super.invalidate();
        }
    }

    public void setBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (this.mBorderColor != i3) {
            this.mBorderColor = i3;
            postInvalidate();
        }
    }

    public void setBorderWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else if (this.mBorderWidth != f16) {
            this.mBorderWidth = f16;
            postInvalidate();
        }
    }

    public void setLeftBottomRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        } else if (this.mLeftBottomRadius != f16) {
            this.mLeftBottomRadius = f16;
            postInvalidate();
        }
    }

    public void setLeftTopRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else if (this.mLeftTopRadius != f16) {
            this.mLeftTopRadius = f16;
            postInvalidate();
        }
    }

    public void setMaskColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.mMaskColor = i3;
            invalidate();
        }
    }

    public void setRadius(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        if (this.mLeftTopRadius == f16 && this.mRightTopRadius == f17 && this.mLeftBottomRadius == f19 && this.mRightBottomRadius == f18) {
            return;
        }
        this.mLeftTopRadius = f16;
        this.mRightTopRadius = f17;
        this.mLeftBottomRadius = f19;
        this.mRightBottomRadius = f18;
        postInvalidate();
    }

    public void setRightBottomRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else if (this.mRightBottomRadius != f16) {
            this.mRightBottomRadius = f16;
            postInvalidate();
        }
    }

    public void setRightTopRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else if (this.mRightTopRadius != f16) {
            this.mRightTopRadius = f16;
            postInvalidate();
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            setRadius(f16, f16, f16, f16);
        } else {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        }
    }
}
