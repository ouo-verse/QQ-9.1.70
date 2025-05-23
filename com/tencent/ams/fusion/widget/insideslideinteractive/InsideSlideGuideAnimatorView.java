package com.tencent.ams.fusion.widget.insideslideinteractive;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InsideSlideGuideAnimatorView extends TextureAnimatorView implements Animator.AnimatorListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "InsideSlideGuideAnimatorView";
    private boolean mDataChanged;
    private GuideAnimatorLayer mGuideAnimatorLayer;
    private int mGuideRepeatCount;
    private String mGuideText;
    private int mGuideTextColor;
    private float mGuideTextSizeDp;
    private int mHolderGuideBackgroundColor;
    private HolderGuideLayer mHolderGuideLayer;
    private int mHolderGuideTextColor;
    private float mHolderGuideTextSizeDp;

    @SlideGestureViewHelper.SlideDirection
    private int mSlideDirection;
    private InsideSlideGuideAnimatorCallback mSlideGuideAnimatorListener;
    private boolean mStarted;

    public InsideSlideGuideAnimatorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mStarted = false;
        this.mSlideDirection = 1;
        this.mHolderGuideTextSizeDp = 12.0f;
        this.mHolderGuideTextColor = Color.parseColor("#FFFFFF");
        this.mHolderGuideBackgroundColor = Color.parseColor("#99000000");
        this.mGuideTextSizeDp = 14.0f;
        this.mGuideTextColor = Color.parseColor("#FFFFFF");
    }

    private void initLayer() {
        if (getWidth() > 0 && getHeight() > 0) {
            if (this.mGuideAnimatorLayer == null || this.mDataChanged) {
                GuideAnimatorLayer guideAnimatorLayer = new GuideAnimatorLayer(getContext());
                this.mGuideAnimatorLayer = guideAnimatorLayer;
                guideAnimatorLayer.setWidth(getWidth());
                this.mGuideAnimatorLayer.setHeight(getHeight());
                GuideAnimatorLayer guideAnimatorLayer2 = this.mGuideAnimatorLayer;
                int i3 = this.mGuideRepeatCount;
                if (i3 < 0) {
                    i3 = 0;
                }
                guideAnimatorLayer2.setGuideRepeatCount(i3);
                this.mGuideAnimatorLayer.setGuideDirection(this.mSlideDirection);
                this.mGuideAnimatorLayer.setOnAnimatorListener(this);
                this.mGuideAnimatorLayer.setGuideText(this.mGuideText);
                this.mGuideAnimatorLayer.setTextSizeDp(this.mGuideTextSizeDp);
                this.mGuideAnimatorLayer.setTextColor(this.mGuideTextColor);
                this.mGuideAnimatorLayer.init();
            }
            if (this.mHolderGuideLayer == null || this.mDataChanged) {
                HolderGuideLayer holderGuideLayer = new HolderGuideLayer(getContext());
                this.mHolderGuideLayer = holderGuideLayer;
                holderGuideLayer.setWidth(getWidth());
                this.mHolderGuideLayer.setHeight(getHeight());
                this.mHolderGuideLayer.setGuideText(this.mGuideText);
                this.mHolderGuideLayer.setSlideDirection(this.mSlideDirection);
                this.mHolderGuideLayer.setTextSizeDp(this.mHolderGuideTextSizeDp);
                this.mHolderGuideLayer.setTextColor(this.mHolderGuideTextColor);
                this.mHolderGuideLayer.setBackgroundColor(this.mHolderGuideBackgroundColor);
                this.mHolderGuideLayer.init();
            }
            this.mDataChanged = false;
            addLayer(this.mGuideAnimatorLayer);
            if (this.mGuideRepeatCount == 0) {
                onAnimationFinish();
            } else {
                this.mGuideAnimatorLayer.start();
            }
        }
    }

    private void notifyGuideAnimatorVisibilityChanged(AnimatorLayer animatorLayer, boolean z16) {
        InsideSlideGuideAnimatorCallback insideSlideGuideAnimatorCallback = this.mSlideGuideAnimatorListener;
        if (insideSlideGuideAnimatorCallback == null) {
            return;
        }
        if (animatorLayer == this.mGuideAnimatorLayer) {
            insideSlideGuideAnimatorCallback.onGuideVisibilityChanged(z16);
        }
        if (animatorLayer == this.mHolderGuideLayer) {
            insideSlideGuideAnimatorCallback.onHolderGuideVisibilityChanged(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) animatorLayer);
        } else {
            super.addLayer(animatorLayer);
            notifyGuideAnimatorVisibilityChanged(animatorLayer, true);
        }
    }

    public RectF getGuideRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RectF) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        GuideAnimatorLayer guideAnimatorLayer = this.mGuideAnimatorLayer;
        if (guideAnimatorLayer != null) {
            return guideAnimatorLayer.getRect();
        }
        Logger.w(TAG, "getGuideRect: mGuideAnimatorLayer is null");
        return new RectF();
    }

    public RectF getHolderGuideRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RectF) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        HolderGuideLayer holderGuideLayer = this.mHolderGuideLayer;
        if (holderGuideLayer != null) {
            return holderGuideLayer.getBackgroundRect();
        }
        Logger.w(TAG, "getHolderGuideRect: mHolderGuideLayout is null");
        return new RectF();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (this.mHolderGuideLayer != null) {
            removeLayer(this.mGuideAnimatorLayer);
            addLayer(this.mHolderGuideLayer);
            this.mHolderGuideLayer.start();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mStarted) {
            initLayer();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) animatorLayer);
        } else {
            super.removeLayer(animatorLayer);
            notifyGuideAnimatorVisibilityChanged(animatorLayer, false);
        }
    }

    public void setGuideDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        this.mSlideDirection = i3;
        GuideAnimatorLayer guideAnimatorLayer = this.mGuideAnimatorLayer;
        if (guideAnimatorLayer != null) {
            guideAnimatorLayer.setGuideDirection(i3);
        }
        HolderGuideLayer holderGuideLayer = this.mHolderGuideLayer;
        if (holderGuideLayer != null) {
            holderGuideLayer.setSlideDirection(i3);
        }
    }

    public void setGuideRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.mGuideRepeatCount = i3;
        GuideAnimatorLayer guideAnimatorLayer = this.mGuideAnimatorLayer;
        if (guideAnimatorLayer != null) {
            guideAnimatorLayer.setGuideRepeatCount(i3);
        }
    }

    public void setGuideText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (!Objects.equals(str, this.mGuideText)) {
            this.mDataChanged = true;
        }
        this.mGuideText = str;
        GuideAnimatorLayer guideAnimatorLayer = this.mGuideAnimatorLayer;
        if (guideAnimatorLayer != null) {
            guideAnimatorLayer.setGuideText(str);
        }
        HolderGuideLayer holderGuideLayer = this.mHolderGuideLayer;
        if (holderGuideLayer != null) {
            holderGuideLayer.setGuideText(str);
        }
    }

    public void setGuideTextSizeAndColor(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        this.mGuideTextColor = i3;
        this.mGuideTextSizeDp = f16;
        GuideAnimatorLayer guideAnimatorLayer = this.mGuideAnimatorLayer;
        if (guideAnimatorLayer != null) {
            guideAnimatorLayer.setTextSizeDp(f16);
            this.mGuideAnimatorLayer.setTextColor(i3);
        }
    }

    public void setHolderGuideBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.mHolderGuideBackgroundColor = i3;
        HolderGuideLayer holderGuideLayer = this.mHolderGuideLayer;
        if (holderGuideLayer != null) {
            holderGuideLayer.setBackgroundColor(i3);
        }
    }

    public void setHolderGuideTextSizeAndColor(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        this.mHolderGuideTextSizeDp = f16;
        this.mHolderGuideTextColor = i3;
        HolderGuideLayer holderGuideLayer = this.mHolderGuideLayer;
        if (holderGuideLayer != null) {
            holderGuideLayer.setTextSizeDp(f16);
            this.mHolderGuideLayer.setTextColor(this.mHolderGuideTextColor);
        }
    }

    public void setSlideGuideAnimatorCallback(InsideSlideGuideAnimatorCallback insideSlideGuideAnimatorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) insideSlideGuideAnimatorCallback);
        } else {
            this.mSlideGuideAnimatorListener = insideSlideGuideAnimatorCallback;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.startAnimation();
        this.mStarted = true;
        initLayer();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.stopAnimation();
        this.mStarted = false;
        GuideAnimatorLayer guideAnimatorLayer = this.mGuideAnimatorLayer;
        if (guideAnimatorLayer != null) {
            guideAnimatorLayer.stop();
            removeLayer(this.mGuideAnimatorLayer);
        }
        HolderGuideLayer holderGuideLayer = this.mHolderGuideLayer;
        if (holderGuideLayer != null) {
            holderGuideLayer.stop();
            removeLayer(this.mHolderGuideLayer);
        }
    }
}
