package com.tencent.autotemplate.filter;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.taveffect.core.CacheTextureFilter;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScaleTextureFilter extends CacheTextureFilter {
    static IPatchRedirector $redirector_;
    private float blue;
    private float colorAlpha;
    private float green;
    private float red;

    public ScaleTextureFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.red = 0.0f;
        this.green = 0.0f;
        this.blue = 0.0f;
        this.colorAlpha = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.taveffect.effects.BaseEffect
    public void onDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        GLES20.glClearColor(this.red, this.green, this.blue, this.colorAlpha);
        GLES20.glClear(16384);
        super.onDraw(tAVTextureInfo);
    }

    public void scale(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        if (this.xyMatrix == null) {
            this.xyMatrix = new Matrix();
        }
        this.xyMatrix.reset();
        this.xyMatrix.setScale(f16, f16);
        this.xyMatrix.postTranslate(f17, f18);
    }

    public void setBackgroundColor(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.red = f16;
        this.green = f17;
        this.blue = f18;
        this.colorAlpha = f19;
    }

    @Override // com.tencent.taveffect.effects.BaseEffect, com.tencent.taveffect.core.TAVBaseFilter
    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, matrix, matrix2, tAVRectangle, Float.valueOf(f16));
            return;
        }
        this.xyMatrix = matrix;
        this.stMatrix = matrix2;
        this.cropRect = tAVRectangle;
        this.alpha = f16;
    }
}
