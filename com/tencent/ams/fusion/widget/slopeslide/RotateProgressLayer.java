package com.tencent.ams.fusion.widget.slopeslide;

import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.Shader;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class RotateProgressLayer extends PathShapeLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RotateProgressLayer";
    private float mOffsetX;
    private float mOffsetY;

    public RotateProgressLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Path createProgressPath(float f16) {
        Path path = new Path();
        float x16 = getX();
        float width = getWidth() + x16;
        float y16 = getY() + getHeight();
        float height = y16 - (getHeight() * f16);
        path.moveTo(x16, y16);
        path.lineTo(width, y16);
        path.lineTo(width, height);
        path.lineTo(x16, height);
        return path;
    }

    private Shader createShader() {
        return new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{-1275068417, 1308622847, 16777215}, (float[]) null, Shader.TileMode.MIRROR);
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            setShader(createShader());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r5 > 1.0f) goto L10;
     */
    @Override // com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        float f17 = 0.0f;
        if (f16 >= 0.0f) {
            f17 = 1.0f;
        }
        f16 = f17;
        super.postProgress(f16);
        setPath(createProgressPath(f16));
    }

    public void setOffset(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mOffsetX = f16;
            this.mOffsetY = f17;
        }
    }
}
