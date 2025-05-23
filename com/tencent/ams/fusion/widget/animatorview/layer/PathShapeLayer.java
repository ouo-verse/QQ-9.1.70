package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class PathShapeLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PathShapeLayer";
    protected Path mPath;

    public PathShapeLayer() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        if (this.mPath == null) {
            return;
        }
        this.mPaint.setAlpha(this.mAlpha);
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            drawPath(canvas);
            canvas.setMatrix(null);
            return;
        }
        drawPath(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawPath(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
        } else {
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        Path path = this.mPath;
        if (path != null) {
            path.offset(f16 - getDistanceX(), f17 - getDistanceY());
        }
        super.postTranslate(f16, f17);
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mPaint.setColor(adapterGrayColor(i3));
        }
    }

    public void setPath(Path path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) path);
        } else {
            this.mPath = path;
        }
    }

    public void setPathEffect(PathEffect pathEffect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pathEffect);
        } else {
            this.mPaint.setPathEffect(pathEffect);
        }
    }

    public void setShader(Shader shader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) shader);
        } else if (shader != null) {
            this.mPaint.setShader(shader);
        }
    }

    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.mPaint.setStrokeWidth(f16);
        }
    }

    public void setStyle(Paint.Style style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) style);
        } else if (style != null) {
            this.mPaint.setStyle(style);
        }
    }

    public PathShapeLayer(Path path) {
        this(path, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
    }

    public PathShapeLayer(Path path, Shader shader, Paint.Style style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, path, shader, style);
            return;
        }
        setPath(path);
        setShader(shader);
        setStyle(style);
    }
}
