package com.tencent.ams.fusion.widget.cny2025.twist;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArcClipBitmapLayer extends BitmapLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ArcClipBitmapLayer";
    private final float mCenterX;
    private final float mCenterY;
    private final Path mPath;
    private volatile float mProgress;
    private final float mRadius;
    private final float mStartAngle;
    private final float mSweepAngle;

    public ArcClipBitmapLayer(Bitmap bitmap, float f16, float f17, float f18, float f19, float f26) {
        super(bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitmap, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26));
            return;
        }
        this.mRadius = f16;
        this.mCenterX = f17;
        this.mCenterY = f18;
        this.mStartAngle = f19;
        this.mSweepAngle = f26;
        this.mPath = new Path();
    }

    private void updateClipPath(float f16) {
        float f17 = this.mStartAngle;
        float f18 = this.mSweepAngle * f16;
        float f19 = this.mCenterX;
        float f26 = this.mRadius;
        float f27 = this.mCenterY;
        RectF rectF = new RectF(f19 - f26, f27 - f26, f19 + f26, f27 + f26);
        this.mPath.reset();
        this.mPath.moveTo(this.mCenterX, this.mCenterY);
        double d16 = f17;
        float cos = (float) (this.mCenterX + (this.mRadius * Math.cos(Math.toRadians(d16))));
        float sin = (float) (this.mCenterY + (this.mRadius * Math.sin(Math.toRadians(d16))));
        double d17 = f17 + f18;
        float cos2 = this.mCenterX + (this.mRadius * ((float) Math.cos(Math.toRadians(d17))));
        float sin2 = this.mCenterY + (this.mRadius * ((float) Math.sin(Math.toRadians(d17))));
        this.mPath.lineTo(cos, sin);
        this.mPath.arcTo(rectF, f17, f18);
        this.mPath.lineTo(cos2, sin2);
        this.mPath.lineTo(this.mCenterX, this.mCenterY);
        this.mPath.close();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        if (canvas == null) {
            Logger.i(TAG, "draw, canvas is null");
            return;
        }
        canvas.save();
        updateClipPath(this.mProgress);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            super.postProgress(f16);
            this.mProgress = f16;
        }
    }
}
