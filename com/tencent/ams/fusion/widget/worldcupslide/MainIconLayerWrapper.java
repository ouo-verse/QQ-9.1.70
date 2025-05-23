package com.tencent.ams.fusion.widget.worldcupslide;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MainIconLayerWrapper implements WorldCupSlideView.InteractListener {
    static IPatchRedirector $redirector_;
    private float mBiggerHeight;
    private float mBiggerWidth;
    private float mCurrentHeight;
    private Animator.AnimatorListener mFlyAwayAnimatorListener;
    private Animator.AnimatorListener mGobackAnimatorListener;
    private float mInitialCenterX;
    private float mInitialCenterY;
    private float mInitialHeight;
    private float mInitialWidth;
    private boolean mIsBigger;
    private float mLastTouchY;
    private Bitmap mMainIconBitmap;
    private AnimatorLayer mMainIconLayer;
    private Animator mShakeAnimator;
    private float mShakeUpDistance;
    private float mSlideThreshold;
    private StateListener mStateListener;
    private Animator mToBiggerAnimator;
    private float mToBiggerDistance;
    private Animator mToSmallAnimator;
    private Animator mTouchAnimator;
    private float mTouchStartY;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    protected interface StateListener {
        void notifyIsIgnoreTouchEvent(boolean z16);
    }

    public MainIconLayerWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Animator createShakeAnimator(AnimatorLayer animatorLayer) {
        TranslateAnimator createTranslateAnimator = createTranslateAnimator(animatorLayer, 0.0f, this.mShakeUpDistance, 600L);
        createTranslateAnimator.setRepeatCount(0);
        createTranslateAnimator.setRepeatMode(2);
        return createTranslateAnimator;
    }

    private Animator createTouchAnimator(AnimatorLayer animatorLayer) {
        return new KeepAnimator(animatorLayer);
    }

    private static TranslateAnimator createTranslateAnimator(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        TranslateAnimator translateAnimator = new TranslateAnimator(animatorLayer, 0.0f, 0.0f, f16, f17);
        translateAnimator.setDuration(j3);
        translateAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
        return translateAnimator;
    }

    public AnimatorLayer getMainIconLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.mMainIconLayer == null) {
            AnimatorLayer height = new BitmapLayer(this.mMainIconBitmap).setCenterX(this.mInitialCenterX).setCenterY(this.mInitialCenterY).setWidth((int) this.mInitialWidth).setHeight((int) this.mInitialHeight);
            this.mMainIconLayer = height;
            this.mShakeAnimator = createShakeAnimator(height);
            this.mTouchAnimator = createTouchAnimator(this.mMainIconLayer);
            ScaleAnimator scaleAnimator = new ScaleAnimator(this.mMainIconLayer, (int) this.mInitialWidth, (int) this.mBiggerWidth, (int) this.mInitialHeight, (int) this.mBiggerHeight);
            this.mToBiggerAnimator = scaleAnimator;
            scaleAnimator.setDuration(200L);
            ScaleAnimator scaleAnimator2 = new ScaleAnimator(this.mMainIconLayer, (int) this.mBiggerWidth, (int) this.mInitialWidth, (int) this.mBiggerHeight, (int) this.mInitialHeight);
            this.mToSmallAnimator = scaleAnimator2;
            scaleAnimator2.setDuration(200L);
            this.mMainIconLayer.setAnimator(this.mShakeAnimator);
        }
        return this.mMainIconLayer;
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onInteractFail() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        StateListener stateListener = this.mStateListener;
        if (stateListener != null) {
            stateListener.notifyIsIgnoreTouchEvent(true);
        }
        AnimatorLayer animatorLayer = this.mMainIconLayer;
        if (animatorLayer != null) {
            GroupAnimator groupAnimator = new GroupAnimator(animatorLayer, new Animator[0]);
            float centerY = this.mMainIconLayer.getCenterY() - this.mInitialCenterY;
            if (this.mSlideThreshold > 0.0f && Math.abs(centerY) < this.mSlideThreshold) {
                j3 = (Math.abs(centerY) / this.mSlideThreshold) * 300.0f;
            } else {
                j3 = 300;
            }
            TranslateAnimator createTranslateAnimator = createTranslateAnimator(this.mMainIconLayer, centerY, 0.0f, j3);
            createTranslateAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.worldcupslide.MainIconLayerWrapper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainIconLayerWrapper.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (MainIconLayerWrapper.this.mStateListener != null) {
                        MainIconLayerWrapper.this.mStateListener.notifyIsIgnoreTouchEvent(false);
                    }
                    if (MainIconLayerWrapper.this.mGobackAnimatorListener != null) {
                        MainIconLayerWrapper.this.mGobackAnimatorListener.onAnimationFinish();
                    }
                }
            });
            groupAnimator.addAnimators(createTranslateAnimator);
            if (this.mIsBigger) {
                groupAnimator.addAnimators(new ScaleAnimator(this.mMainIconLayer, (int) this.mBiggerWidth, (int) this.mInitialWidth, (int) this.mBiggerHeight, (int) this.mInitialHeight));
            }
            groupAnimator.setDuration(j3);
            this.mMainIconLayer.setAnimator(groupAnimator);
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onInteractSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        StateListener stateListener = this.mStateListener;
        if (stateListener != null) {
            stateListener.notifyIsIgnoreTouchEvent(true);
        }
        AnimatorLayer animatorLayer = this.mMainIconLayer;
        if (animatorLayer != null) {
            float centerY = animatorLayer.getCenterY();
            float f16 = this.mInitialCenterY;
            float f17 = centerY - f16;
            float f18 = (-f16) - this.mCurrentHeight;
            GroupAnimator groupAnimator = new GroupAnimator(this.mMainIconLayer, new Animator[0]);
            groupAnimator.addAnimators(createTranslateAnimator(this.mMainIconLayer, f17, f18, 500L));
            AnimatorLayer animatorLayer2 = this.mMainIconLayer;
            float f19 = this.mBiggerWidth;
            int i3 = (int) f19;
            int i16 = (int) f19;
            float f26 = this.mBiggerHeight;
            groupAnimator.addAnimators(new ScaleAnimator(animatorLayer2, i3, i16, (int) f26, (int) f26));
            groupAnimator.setDuration(500L);
            groupAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.worldcupslide.MainIconLayerWrapper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainIconLayerWrapper.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (MainIconLayerWrapper.this.mFlyAwayAnimatorListener != null) {
                        MainIconLayerWrapper.this.mFlyAwayAnimatorListener.onAnimationFinish();
                    }
                }
            });
            this.mMainIconLayer.setAnimator(groupAnimator);
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onTouch(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent);
            return;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float y16 = this.mTouchStartY - motionEvent.getY();
                if (this.mMainIconLayer != null) {
                    if (motionEvent.getY() - this.mLastTouchY < 0.0f) {
                        if (y16 >= this.mToBiggerDistance && !this.mIsBigger) {
                            this.mIsBigger = true;
                            this.mCurrentHeight = this.mBiggerHeight;
                            this.mToBiggerAnimator.reset();
                            AnimatorLayer animatorLayer = this.mMainIconLayer;
                            animatorLayer.setAnimator(new GroupAnimator(animatorLayer, this.mToBiggerAnimator, this.mTouchAnimator));
                        }
                    } else if (y16 <= this.mToBiggerDistance && this.mIsBigger) {
                        this.mIsBigger = false;
                        this.mCurrentHeight = this.mInitialHeight;
                        this.mToSmallAnimator.reset();
                        AnimatorLayer animatorLayer2 = this.mMainIconLayer;
                        animatorLayer2.setAnimator(new GroupAnimator(animatorLayer2, this.mToSmallAnimator, this.mTouchAnimator));
                    }
                    if (y16 < 0.0f) {
                        y16 = 0.0f;
                    }
                    this.mMainIconLayer.postTranslate(0.0f, -y16);
                }
                this.mLastTouchY = motionEvent.getY();
                return;
            }
            return;
        }
        AnimatorLayer animatorLayer3 = this.mMainIconLayer;
        if (animatorLayer3 != null) {
            animatorLayer3.setAnimator(createTouchAnimator(animatorLayer3));
        }
        this.mTouchStartY = motionEvent.getY();
        this.mIsBigger = false;
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mCurrentHeight = this.mInitialHeight;
        if (this.mMainIconLayer != null) {
            this.mShakeAnimator.reset();
            this.mMainIconLayer.setAnimator(this.mShakeAnimator);
        }
    }

    public void setFlyAwayAnimatorListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animatorListener);
        } else {
            this.mFlyAwayAnimatorListener = animatorListener;
        }
    }

    public void setGobackAnimatorListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animatorListener);
        } else {
            this.mGobackAnimatorListener = animatorListener;
        }
    }

    public void setMainIcon(Bitmap bitmap, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bitmap, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mMainIconBitmap = bitmap;
        this.mInitialCenterX = f16;
        this.mInitialCenterY = f17;
        this.mInitialWidth = f18;
        this.mInitialHeight = f19;
        this.mCurrentHeight = f19;
        this.mBiggerWidth = (float) (f18 * 1.3d);
        this.mBiggerHeight = (float) (f19 * 1.3d);
    }

    public void setShakeUpDistance(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mShakeUpDistance = f16;
        }
    }

    public void setSlideThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mSlideThreshold = f16;
        }
    }

    public void setStateListener(StateListener stateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) stateListener);
        } else {
            this.mStateListener = stateListener;
        }
    }

    public void setToBiggerDistance(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mToBiggerDistance = f16;
        }
    }
}
