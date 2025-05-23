package com.tencent.ams.fusion.widget.cny2025.twist;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CNYBitmapLayer extends BitmapLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CNYBitmapLayer";
    private float mFromDegrees;
    private float mFromScale;
    private float mFromX;
    private float mFromY;
    private float mProgress;
    private float mToDegrees;
    private float mToScale;
    private float mToX;
    private float mToY;

    public CNYBitmapLayer(Bitmap bitmap) {
        super(bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
        } else {
            this.mFromScale = 1.0f;
            this.mToScale = 1.0f;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        if (canvas == null) {
            Logger.e(TAG, "draw, canvas is null");
            return;
        }
        Matrix matrix = getMatrix();
        if (matrix == null) {
            Logger.e(TAG, "draw, matrix is null");
            return;
        }
        float f16 = this.mFromScale;
        float f17 = f16 + ((this.mToScale - f16) * this.mProgress);
        float f18 = this.mFromDegrees;
        matrix.postRotate(f18 + (this.mToDegrees - f18), getPx(), getPy());
        matrix.postScale(f17, f17, getPx(), getPy());
        super.draw(canvas);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        this.mProgress = f16;
        float f17 = this.mFromX;
        setX(f17 + ((this.mToX - f17) * f16));
        float f18 = this.mFromY;
        setY(f18 + ((this.mToY - f18) * f16));
    }

    public void setDegrees(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else {
            setFromDegrees(f16);
            setToDegrees(f16);
        }
    }

    public void setFromDegrees(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.mFromDegrees = f16;
        }
    }

    public void setFromScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.mFromScale = f16;
        }
    }

    public void setFromX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mFromX = f16;
            setX(f16 + ((this.mToX - f16) * this.mProgress));
        }
    }

    public void setFromY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mFromY = f16;
            setY(f16 + ((this.mToY - f16) * this.mProgress));
        }
    }

    public void setScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        } else {
            setFromScale(f16);
            setToScale(f16);
        }
    }

    public void setToDegrees(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.mToDegrees = f16;
        }
    }

    public void setToScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.mToScale = f16;
        }
    }

    public void setToX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        this.mToX = f16;
        float f17 = this.mFromX;
        setX(f17 + ((f16 - f17) * this.mProgress));
    }

    public void setToY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        this.mToY = f16;
        float f17 = this.mFromY;
        setY(f17 + ((f16 - f17) * this.mProgress));
    }
}
