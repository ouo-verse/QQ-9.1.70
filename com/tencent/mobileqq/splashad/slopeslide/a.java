package com.tencent.mobileqq.splashad.slopeslide;

import android.graphics.Canvas;
import android.graphics.Shader;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends AnimatorLayer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private float f288907d;

    /* renamed from: e, reason: collision with root package name */
    private float f288908e;

    public a(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        setCenterX(f16);
        setCenterY(f17);
        setRadius(f18);
        int i3 = (int) (f18 * 2.0f);
        setWidth(i3);
        setHeight(i3);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
        } else {
            if (this.mMatrixChanged) {
                canvas.setMatrix(getMatrix());
                canvas.drawCircle(getCenterX(), getCenterY(), getRadius(), getPaint());
                canvas.setMatrix(null);
                return;
            }
            canvas.drawCircle(getCenterX(), getCenterY(), getRadius(), getPaint());
        }
    }

    public float getRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        float f16 = this.f288908e;
        if (f16 > 0.0f) {
            return this.f288907d * f16;
        }
        return this.f288907d;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17, float f18, float f19, float f26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26));
            return;
        }
        if (f16 != f17) {
            QLog.w("CircleShapeLayer", 1, "Not support ellipse scale.");
        }
        this.f288908e = f16;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.reset();
            this.f288908e = 0.0f;
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.f288907d = f16;
        }
    }

    public void setShader(Shader shader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) shader);
        } else if (shader != null) {
            this.mPaint.setShader(shader);
        }
    }
}
