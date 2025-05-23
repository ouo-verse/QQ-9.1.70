package com.tencent.ams.fusion.widget.flip;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GradientLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_ROTATION = 30;
    private int mBottom;

    @GradientDirection
    private int mDirection;
    private int mLeft;
    LinearGradient mLinearGradient;
    private int mRight;
    private int mTop;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface GradientDirection {
        public static final int LEFT_TO_RIGHT = 1;
        public static final int RIGHT_TO_LEFT = 2;
    }

    public GradientLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
        } else {
            if (this.mMatrixChanged) {
                canvas.setMatrix(getMatrix());
                canvas.drawRect(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mPaint);
                canvas.setMatrix(null);
                return;
            }
            canvas.drawRect(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mPaint);
        }
    }

    public void init(@GradientDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        this.mLeft = ((int) getCenterX()) - width;
        this.mTop = ((int) getCenterY()) - height;
        this.mRight = ((int) getCenterX()) + width;
        this.mBottom = ((int) getCenterY()) + height;
        this.mDirection = i3;
        if (i3 == 1) {
            float f16 = this.mLeft;
            int i16 = this.mTop;
            this.mLinearGradient = new LinearGradient(f16, i16, this.mRight, i16, Integer.MAX_VALUE, 16777215, Shader.TileMode.MIRROR);
        } else {
            float f17 = this.mRight;
            int i17 = this.mTop;
            this.mLinearGradient = new LinearGradient(f17, i17, this.mLeft, i17, Integer.MAX_VALUE, 16777215, Shader.TileMode.MIRROR);
        }
        this.mPaint.setShader(this.mLinearGradient);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        super.postRotationY(f16);
        int i3 = this.mDirection;
        if ((i3 != 1 || f16 >= 0.0f) && (i3 != 2 || f16 <= 0.0f)) {
            z16 = false;
        }
        if (z16) {
            postAlpha((int) (Math.min(Math.abs(f16) / 30.0f, 1.0f) * 255.0f));
        } else {
            postAlpha(0);
        }
    }
}
