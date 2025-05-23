package com.tencent.ams.fusion.widget.olympicshake;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.base.ShakeView;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeAnimationHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicShakeIconView extends TextureAnimatorView implements ShakeView<OnShakeListener>, OnShakeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "OlympicShakeIconView";
    private Bitmap mIconBitmap;
    private float mIconHeight;
    private float mIconWidth;
    private float mIconX;
    private float mIconY;
    private boolean mIsAutoStopWhenComplete;
    private boolean mIsStop;
    private boolean mNeedAlphaAnimate;
    private float mOffsetCenterX;
    private float mOffsetCenterY;
    private float mShakeFactorX;
    private float mShakeFactorY;
    private float mShakeFactorZ;
    private OnShakeListener mShakeListener;
    private ShakeSensor mShakeSensor;
    private float mShakeThreshold;
    private int mShakeValidCount;

    public OlympicShakeIconView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mShakeThreshold = 3.0f;
        this.mShakeValidCount = 60;
        this.mShakeFactorX = 1.0f;
        this.mShakeFactorY = 1.0f;
        this.mShakeFactorZ = 0.5f;
        this.mOffsetCenterX = Float.MIN_VALUE;
        this.mOffsetCenterY = Float.MIN_VALUE;
        this.mIsAutoStopWhenComplete = true;
        this.mNeedAlphaAnimate = true;
        ShakeSensor shakeSensor = new ShakeSensor(getContext());
        this.mShakeSensor = shakeSensor;
        shakeSensor.setShakeListener(this);
    }

    private void addAlphaAnimator(AnimatorLayer animatorLayer) {
        if (animatorLayer != null && animatorLayer.getAnimator() != null && this.mNeedAlphaAnimate) {
            AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 0.0f, 1.0f);
            alphaAnimator.setDuration(300L);
            animatorLayer.setAnimator(new GroupAnimator(animatorLayer, alphaAnimator, animatorLayer.getAnimator()));
        }
    }

    private Bitmap createShakeIconBitmap() {
        Bitmap bitmap = this.mIconBitmap;
        if (bitmap != null) {
            return Utils.createBitmap(bitmap, (int) this.mIconWidth, (int) this.mIconHeight, false);
        }
        return Utils.bitmapFromBase64String("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", (int) this.mIconWidth, (int) this.mIconHeight);
    }

    private void reset() {
        this.mIsStop = false;
    }

    private void startShakeAnimation() {
        if (this.mIsStop) {
            return;
        }
        clearLayers();
        AnimatorLayer shakeIconAnimatorLayer = OlympicShakeAnimationHelper.getShakeIconAnimatorLayer(createShakeIconBitmap(), new OlympicShakeAnimationHelper.IconParams(this.mIconX, this.mIconY, this.mIconWidth, this.mIconHeight, this.mOffsetCenterX, this.mOffsetCenterY), null);
        addAlphaAnimator(shakeIconAnimatorLayer);
        addLayer(shakeIconAnimatorLayer);
        startAnimation();
    }

    public void addActivityLifecycleListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.addActivityLifecycleListener(getContext());
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Double.valueOf(d16));
            return;
        }
        if (this.mIsAutoStopWhenComplete) {
            stop();
        }
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null) {
            onShakeListener.onShakeComplete(d16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null) {
            onShakeListener.onShaking(d16, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            Logger.i(TAG, "pause");
            pauseAnimation();
        }
    }

    public void removeActivityLifecycleListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.removeActivityLifecycleListener();
        }
    }

    public void resetWhenReuse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.mIsStop = false;
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.reset();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            Logger.i(TAG, "resume");
            resumeAnimation();
        }
    }

    public void setAutoStopWhenComplete(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mIsAutoStopWhenComplete = z16;
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bitmap);
        } else {
            this.mIconBitmap = bitmap;
        }
    }

    public void setIconPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mIconX = f16;
            this.mIconY = f17;
        }
    }

    public void setIconSize(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mIconWidth = f16;
            this.mIconHeight = f17;
        }
    }

    public void setNeedAlphaAnimate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mNeedAlphaAnimate = z16;
        }
    }

    public void setOffsetCenter(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mOffsetCenterX = f16;
            this.mOffsetCenterY = f17;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setOnShakeListener(OnShakeListener onShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onShakeListener);
        } else {
            this.mShakeListener = onShakeListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setSensorEventsDeliveredOnMainThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mShakeFactorX = f16;
        this.mShakeFactorY = f17;
        this.mShakeFactorZ = f18;
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.mShakeThreshold = f16;
            this.mShakeValidCount = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        reset();
        startShakeAnimation();
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor == null) {
            shakeSensor = new ShakeSensor(getContext());
            shakeSensor.setShakeListener(this);
            this.mShakeSensor = shakeSensor;
        }
        shakeSensor.reset();
        shakeSensor.setShakeValue(this.mShakeThreshold, this.mShakeValidCount);
        shakeSensor.setShakeFactor(this.mShakeFactorX, this.mShakeFactorY, this.mShakeFactorZ);
        shakeSensor.register();
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            stop(true);
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    private void stop(boolean z16) {
        Logger.i(TAG, "stop clearCanvas:" + z16);
        this.mIsStop = true;
        stopAnimation(z16, true);
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.unregister();
        }
        this.mShakeSensor = null;
    }
}
