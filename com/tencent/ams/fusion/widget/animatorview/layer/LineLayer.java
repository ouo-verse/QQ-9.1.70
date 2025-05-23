package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LineLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LineLayer";
    private int mColor;
    protected float mProgress;
    private float mStartX;
    private float mStartY;
    private float mStopX;
    private float mStopY;
    protected float mStrokeWidth;
    private Paint.Style mStyle;

    public LineLayer(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mStyle = Paint.Style.STROKE;
        this.mColor = Color.parseColor("#FFFFFF");
        this.mStartX = f16;
        this.mStopX = f17;
        this.mStartY = f18;
        this.mStopY = f19;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setStyle(this.mStyle);
        this.mPaint.setAlpha(this.mAlpha);
        this.mPaint.setColor(this.mColor);
        canvas.drawLine(this.mStartX, this.mStartY, this.mStopX, this.mStopY, this.mPaint);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
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

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.reset();
        this.mProgress = 0.0f;
        this.mPaint.setAlpha(255);
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mColor = i3;
        }
    }

    public LineLayer setStrokeCap(Paint.Cap cap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LineLayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cap);
        }
        this.mPaint.setStrokeCap(cap);
        return this;
    }

    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        Logger.d(TAG, "setStrokeWidth: " + f16);
        this.mStrokeWidth = f16;
    }
}
