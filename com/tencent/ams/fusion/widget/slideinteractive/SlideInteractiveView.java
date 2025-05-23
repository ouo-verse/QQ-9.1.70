package com.tencent.ams.fusion.widget.slideinteractive;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class SlideInteractiveView extends FrameLayout implements IAnimatorViewHandler, SlideGestureViewHelper.ISlideGestureListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SlideInteractiveView";
    private boolean hasGestureSuccess;
    protected SlideGuideAnimatorView mGuideAnimationView;
    protected SlideGestureViewHelper mSlideGestureViewHelper;
    private SlideInteractiveListener mSlideInteractiveListener;

    public SlideInteractiveView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            initView(context);
        }
    }

    private static RectF calculateViewScreenLocation(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    private void initView(Context context) {
        if (context == null) {
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = new SlideGuideAnimatorView(context);
        this.mGuideAnimationView = slideGuideAnimatorView;
        addView(slideGuideAnimatorView, new FrameLayout.LayoutParams(-1, -1));
        SlideGestureViewHelper slideGestureViewHelper = new SlideGestureViewHelper(context, this);
        this.mSlideGestureViewHelper = slideGestureViewHelper;
        slideGestureViewHelper.setSlideGestureListener(this);
        setEnabled(false);
    }

    private void playEndAnimation() {
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.startEndAnimation(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlideInteractiveView.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (SlideInteractiveView.this.mSlideInteractiveListener != null) {
                        SlideInteractiveView.this.mSlideInteractiveListener.onEndAnimationFinish();
                    }
                }
            });
        }
    }

    public PointF getArrowIconCenterPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (PointF) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            return slideGuideAnimatorView.getArrowIconCenterPoint();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.mSlideGestureViewHelper.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        Logger.d(TAG, "onDetachedFromWindow, recycle listeners");
        this.mSlideGestureViewHelper.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureResult(int i3, View view, boolean z16, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), view, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        Logger.d("SlideInteractiveViewdispatchDrawGestureResultEvent " + z16);
        if (this.hasGestureSuccess) {
            return;
        }
        this.hasGestureSuccess = z16;
        SlideInteractiveListener slideInteractiveListener = this.mSlideInteractiveListener;
        if (slideInteractiveListener != null) {
            slideInteractiveListener.onGestureResult(z16, view, f16, f17);
        }
        if (z16) {
            playEndAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        SlideInteractiveListener slideInteractiveListener = this.mSlideInteractiveListener;
        if (slideInteractiveListener != null) {
            slideInteractiveListener.onGestureStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        SlideInteractiveListener slideInteractiveListener = this.mSlideInteractiveListener;
        if (slideInteractiveListener != null) {
            slideInteractiveListener.onTouch(view, motionEvent);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.pauseAnimation();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.resumeAnimation();
        }
    }

    public void setBottomPaddingDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.setBottomPaddingDp(f16);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            super.setEnabled(z16);
            this.mSlideGestureViewHelper.setEnabled(z16);
        }
    }

    public void setGestureClickView(View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewArr);
        } else {
            this.mSlideGestureViewHelper.setGestureClickView(viewArr);
        }
    }

    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mSlideGestureViewHelper.setGestureColor(str);
        }
    }

    public void setGestureHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mSlideGestureViewHelper.setGestureHotArea(i3, i16, i17, i18);
        }
    }

    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mSlideGestureViewHelper.setGestureSlideValidHeightDp(i3);
        }
    }

    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mSlideGestureViewHelper.setGestureStrokeWidthDp(i3);
        }
    }

    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mSlideGestureViewHelper.setGestureVisible(z16);
        }
    }

    public void setSlideIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            setSlideIconBitmap(bitmap, false);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bitmap);
        }
    }

    public void setSlideInteractiveListener(SlideInteractiveListener slideInteractiveListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) slideInteractiveListener);
        } else {
            this.mSlideInteractiveListener = slideInteractiveListener;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.setSubTitle(str);
        }
    }

    public void setTextBottomMarginDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.setTextBottomMarginDp(f16);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.setTitle(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler
    public void smoothHideView(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) animatorListener);
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.smoothHideView(animatorListener);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.start();
        }
        setEnabled(true);
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        SlideGestureViewHelper slideGestureViewHelper = this.mSlideGestureViewHelper;
        if (slideGestureViewHelper != null) {
            slideGestureViewHelper.stop();
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.stop();
        }
        setEnabled(false);
    }

    public void setSlideIconBitmap(Bitmap bitmap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, bitmap, Boolean.valueOf(z16));
            return;
        }
        SlideGuideAnimatorView slideGuideAnimatorView = this.mGuideAnimationView;
        if (slideGuideAnimatorView != null) {
            slideGuideAnimatorView.setSlideIconBitmap(bitmap);
            Logger.i(TAG, "setSlideIconBitmap, resetAnimation:" + z16 + " hasGestureSuccess:" + this.hasGestureSuccess);
            if (!z16 || this.hasGestureSuccess) {
                return;
            }
            this.mGuideAnimationView.reStart();
        }
    }
}
