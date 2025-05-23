package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FrameLayer";
    private Bitmap[] mFrameBitmaps;
    private float mLayerProgress;

    public FrameLayer() {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        Bitmap[] bitmapArr = this.mFrameBitmaps;
        if (bitmapArr != null && bitmapArr.length != 0) {
            canvas.drawBitmap(bitmapArr[getCurrentIndex()], getMatrix(), getPaint());
        }
    }

    protected int getCurrentIndex() {
        Animator animator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        Bitmap[] bitmapArr = this.mFrameBitmaps;
        if (bitmapArr == null || bitmapArr.length == 0 || (animator = getAnimator()) == null) {
            return 0;
        }
        float f16 = this.mLayerProgress;
        if (f16 < 0.0f) {
            f16 = animator.getProgress();
        }
        int round = Math.round(bitmapArr.length * f16);
        if (round < 0) {
            return 0;
        }
        return Math.min(round, bitmapArr.length - 1);
    }

    public Bitmap[] getFrameBitmaps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mFrameBitmaps;
    }

    public float getLayerProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.mLayerProgress;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.mLayerProgress = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    public void setFrameBitmaps(Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmapArr);
            return;
        }
        if (AnimatorConfig.isGrayModeOn() && bitmapArr != null && bitmapArr.length > 0) {
            this.mFrameBitmaps = new Bitmap[bitmapArr.length];
            for (int i3 = 0; i3 < bitmapArr.length; i3++) {
                this.mFrameBitmaps[i3] = AnimatorUtils.convertGrayBitmap(bitmapArr[i3]);
            }
            return;
        }
        this.mFrameBitmaps = bitmapArr;
    }

    public FrameLayer(Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmapArr);
        } else {
            this.mLayerProgress = -1.0f;
            setFrameBitmaps(bitmapArr);
        }
    }
}
