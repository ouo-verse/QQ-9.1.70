package com.tencent.ams.fusion.widget.actionbanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwoLineActionBannerView extends FrameLayout implements ActionBanner {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TwoLineActionBanner";
    private final ActionBannerInfo mActionBannerInfo;
    private final ActionBannerAnimationHelper mAnimationHelper;
    private final AnimatorView mAnimatorView;
    private RectF mBannerRect;
    private boolean mIsStop;
    private boolean mIsTouchDownInBanner;

    public TwoLineActionBannerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        ActionBannerInfo actionBannerInfo = new ActionBannerInfo();
        this.mActionBannerInfo = actionBannerInfo;
        AnimatorView animatorView = new AnimatorView(context);
        this.mAnimatorView = animatorView;
        addView(animatorView, new FrameLayout.LayoutParams(-1, -1));
        this.mAnimationHelper = new ActionBannerAnimationHelper(this, actionBannerInfo);
    }

    private boolean isTouchInBanner(float f16, float f17) {
        if (this.mBannerRect != null) {
            float touchAreaWidthFactor = this.mActionBannerInfo.getTouchAreaWidthFactor();
            float touchAreaHeightFactor = this.mActionBannerInfo.getTouchAreaHeightFactor();
            if (touchAreaWidthFactor == 1.0f && touchAreaHeightFactor == 1.0f) {
                return this.mBannerRect.contains(f16, f17);
            }
            float width = this.mBannerRect.width() * (touchAreaWidthFactor - 1.0f);
            float height = this.mBannerRect.height() * (touchAreaHeightFactor - 1.0f);
            RectF rectF = this.mBannerRect;
            float f18 = width / 2.0f;
            float f19 = height / 2.0f;
            return new RectF(rectF.left - f18, rectF.top - f19, rectF.right + f18, rectF.bottom + f19).contains(f16, f17);
        }
        return false;
    }

    private void reset() {
        this.mIsStop = false;
        this.mAnimatorView.clearLayers();
    }

    private void startBannerAnimation() {
        AnimatorLayer animatorLayer;
        if (this.mIsStop) {
            return;
        }
        AnimatorLayer createBreathLayer = this.mAnimationHelper.createBreathLayer();
        AnimatorLayer createBannerBgLayer = this.mAnimationHelper.createBannerBgLayer();
        AnimatorLayer createTitleLayer = this.mAnimationHelper.createTitleLayer();
        AnimatorLayer createSubTitleLayer = this.mAnimationHelper.createSubTitleLayer();
        if (this.mActionBannerInfo.isIconVisible()) {
            animatorLayer = this.mAnimationHelper.createIconLayer();
        } else {
            animatorLayer = null;
        }
        GroupLayer groupLayer = new GroupLayer(createBreathLayer, createBannerBgLayer, createTitleLayer, createSubTitleLayer, animatorLayer);
        if (this.mActionBannerInfo.getActionType() == 2) {
            if (this.mActionBannerInfo.getSlideIconShape() == 2) {
                groupLayer.addLayers(this.mAnimationHelper.createSlideArrowBgLayer(), this.mAnimationHelper.createSlideArrowLayer(), this.mAnimationHelper.createSlideHandLayer());
            } else {
                groupLayer.addLayers(this.mAnimationHelper.createSlideNormalArrowLayer());
            }
        }
        this.mAnimatorView.addLayer(groupLayer);
        this.mAnimatorView.startAnimation();
        RectF rectF = new RectF();
        this.mBannerRect = rectF;
        rectF.left = createBannerBgLayer.getX();
        this.mBannerRect.top = createBannerBgLayer.getY();
        this.mBannerRect.right = createBannerBgLayer.getX() + createBannerBgLayer.getWidth();
        this.mBannerRect.bottom = createBannerBgLayer.getY() + createBannerBgLayer.getHeight();
        Logger.i(TAG, " mBannerRect : " + this.mBannerRect.toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mAnimatorView.isUserStarted()) {
            boolean isTouchInBanner = isTouchInBanner(motionEvent.getX(), motionEvent.getY());
            if (isTouchInBanner && this.mActionBannerInfo.getOnTouchListener() != null) {
                this.mActionBannerInfo.getOnTouchListener().onTouch(this, motionEvent);
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.mIsTouchDownInBanner && isTouchInBanner && this.mActionBannerInfo.getOnClickListener() != null) {
                        this.mActionBannerInfo.getOnClickListener().onClick(this);
                    }
                    this.mIsTouchDownInBanner = false;
                }
            } else if (isTouchInBanner) {
                this.mIsTouchDownInBanner = true;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public RectF getBannerRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (RectF) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mBannerRect;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            super.onAttachedToWindow();
            start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            stop();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        if (this.mAnimatorView.isUserStarted()) {
            start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            Logger.i(TAG, "pause");
            this.mAnimatorView.pauseAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            Logger.i(TAG, "resume");
            this.mAnimatorView.resumeAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setActionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mActionBannerInfo.setActionType(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setBackgroundAnimationType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mActionBannerInfo.setBackgroundAnimationType(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mActionBannerInfo.setBackgroundColor(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setBackgroundHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else {
            this.mActionBannerInfo.setBackgroundHeight(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setBannerRelativeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mAnimationHelper.setBannerRelativeWidth(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setHighlightBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mActionBannerInfo.setHighlightBackgroundColor(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setHighlightDelayTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.mActionBannerInfo.setHighlightDelayTime(j3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setIconBitmapArray(Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bitmapArr);
        } else {
            this.mActionBannerInfo.setIconBitmapArray(bitmapArr);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setIconVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mActionBannerInfo.setIconVisible(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setMarginBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mActionBannerInfo.setMarginBottom(i3);
        }
    }

    @Override // android.view.View, com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onClickListener);
        } else {
            this.mActionBannerInfo.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onTouchListener);
        } else {
            this.mActionBannerInfo.setOnTouchListener(onTouchListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setSlideIconShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mActionBannerInfo.setSlideIconShape(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mActionBannerInfo.setSubTitle(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setSubTitleColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mActionBannerInfo.setSubTitleColor(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setSubTitleFontSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mActionBannerInfo.setSubTitleFontSize(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mActionBannerInfo.setTitle(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setTitleColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mActionBannerInfo.setTitleColor(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setTitleFontSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mActionBannerInfo.setTitleFontSizeDp(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setTouchAreaHeightFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16));
        } else {
            this.mActionBannerInfo.setTouchAreaHeightFactor(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.ActionBanner
    public void setTouchAreaWidthFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.mActionBannerInfo.setTouchAreaWidthFactor(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        reset();
        startBannerAnimation();
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        this.mActionBannerInfo.setOnClickListener(null);
        this.mIsStop = true;
        this.mAnimatorView.stopAnimation(true, true);
    }
}
