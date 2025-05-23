package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContentWrapView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private Matrix mMatrix;
    private TransformationInfo mTransInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class TransformationInfo {
        static IPatchRedirector $redirector_;
        private final Matrix mMatrix;
        boolean mMatrixDirty;
        float mTranslationX;
        float mTranslationY;

        TransformationInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mMatrix = new Matrix();
            this.mMatrixDirty = false;
            this.mTranslationX = 0.0f;
            this.mTranslationY = 0.0f;
        }
    }

    public ContentWrapView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mMatrix = new Matrix();
            init(context);
        }
    }

    private void init(Context context) {
        setWillNotDraw(false);
    }

    private void updateMatrix() {
        TransformationInfo transformationInfo = this.mTransInfo;
        if (transformationInfo != null && transformationInfo.mMatrixDirty) {
            transformationInfo.mMatrix.setTranslate(transformationInfo.mTranslationX, transformationInfo.mTranslationY);
            transformationInfo.mMatrixDirty = false;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        TransformationInfo transformationInfo = this.mTransInfo;
        if (transformationInfo != null) {
            updateMatrix();
            canvas.concat(transformationInfo.mMatrix);
        }
        super.draw(canvas);
    }

    public void ensureTransformationInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.mTransInfo == null) {
            this.mTransInfo = new TransformationInfo();
        }
    }

    public float getTransX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        TransformationInfo transformationInfo = this.mTransInfo;
        if (transformationInfo != null) {
            return transformationInfo.mTranslationX;
        }
        return 0.0f;
    }

    public float getTransY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        TransformationInfo transformationInfo = this.mTransInfo;
        if (transformationInfo != null) {
            return transformationInfo.mTranslationY;
        }
        return 0.0f;
    }

    public void transX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        ensureTransformationInfo();
        TransformationInfo transformationInfo = this.mTransInfo;
        if (transformationInfo.mTranslationX != f16) {
            transformationInfo.mTranslationX = f16;
            transformationInfo.mMatrixDirty = true;
            invalidate();
        }
    }

    public void transXBy(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else if (f16 != 0.0f) {
            transX(f16 + getTransX());
        }
    }

    public void transY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        ensureTransformationInfo();
        TransformationInfo transformationInfo = this.mTransInfo;
        if (transformationInfo.mTranslationY != f16) {
            transformationInfo.mTranslationY = f16;
            transformationInfo.mMatrixDirty = true;
            invalidate();
        }
    }

    public void transYBy(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else if (f16 != 0.0f) {
            transX(f16 + getTransX());
        }
    }

    public ContentWrapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ContentWrapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mMatrix = new Matrix();
            init(context);
        }
    }
}
