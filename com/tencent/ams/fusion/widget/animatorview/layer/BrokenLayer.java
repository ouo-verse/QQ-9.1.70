package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BrokenLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BrokenLayer";
    private Rect mBrokenRect;

    public BrokenLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mBrokenRect = new Rect();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void clipRect(Canvas canvas, Rect rect) {
        if (canvas != null && rect != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(rect);
            } else {
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
            }
        }
    }

    private void setBrokenRect(Rect rect) {
        if (rect != null) {
            this.mBrokenRect = rect;
            setX(rect.left);
            setY(rect.top);
            setWidth(rect.width());
            setHeight(rect.height());
            return;
        }
        Logger.e(TAG, "rect must be not null");
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (getAlign() == 2) {
            Rect rect = new Rect();
            int x16 = (int) getX();
            rect.left = x16;
            rect.right = x16 + getWidth();
            int y16 = (int) getY();
            rect.top = y16;
            rect.bottom = y16 + getHeight();
            clipRect(canvas, rect);
            return;
        }
        clipRect(canvas, this.mBrokenRect);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    public BrokenLayer(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rect);
        } else {
            this.mBrokenRect = new Rect();
            setBrokenRect(rect);
        }
    }

    public BrokenLayer(Rect rect, int i3) {
        this(rect);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rect, i3);
        } else {
            setAlign(2);
            setBottomMargin(i3);
        }
    }

    public BrokenLayer(View view) {
        this(AnimatorUtils.getRectFromView(view));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
    }
}
