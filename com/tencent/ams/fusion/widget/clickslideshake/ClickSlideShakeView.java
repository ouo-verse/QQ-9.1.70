package com.tencent.ams.fusion.widget.clickslideshake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.base.ShakeView;
import com.tencent.ams.fusion.widget.base.SlideGestureView;
import com.tencent.ams.fusion.widget.base.SlideInspector;
import com.tencent.ams.fusion.widget.clickslideshake.ShakeBannerAnimatorLayer;
import com.tencent.ams.fusion.widget.olympicshake.OnShakeListener;
import com.tencent.ams.fusion.widget.olympicshake.ShakeSensor;
import com.tencent.ams.fusion.widget.slideinteractive.FeatureGestureView;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.tma.slidecalculate.SlideConfig;
import com.tencent.ams.fusion.widget.tma.slidecalculate.TMASlideCalculateUtil;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.qid.QidPagView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickSlideShakeView extends FrameLayout implements ShakeView<ClickSlideShakeListener>, SlideGestureView, OnShakeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ClickSlideShakeView";
    private final ClickSlideShakeAnimationHelper mAnimationHelper;
    private String mBannerBackgroundColor;
    private int mBannerBottomPadding;
    private Bitmap mBannerIcon;
    private ShakeBannerAnimatorLayer.ShakeBannerLayerParams mBannerLayerParams;
    private final AnimatorView mBannerView;
    private boolean mBannerVisible;
    private View.OnClickListener mClickListener;
    private final ViewConfiguration mConfiguration;
    private View mCustomSlideArrowView;
    private int mCustomSlideArrowViewMarginBanner;
    private float mDownX;
    private float mDownY;
    private final FeatureGestureView mGestureView;
    private boolean mIsClickDownInBanner;
    private boolean mSensorEventsDeliveredOnMainThread;
    private int[] mShakeDirectcombine;
    private int mShakeDuration;
    private float mShakeFactorX;
    private float mShakeFactorY;
    private float mShakeFactorZ;
    private OnShakeListener mShakeListener;
    private int mShakeSampleRate;
    private ShakeSensor mShakeSensor;
    private float mShakeThreshold;
    private int mShakeValidCount;
    private SlideArrowAnimatorView mSlideArrowView;
    private boolean mSlideGuideVisible;
    private String mSubTitle;
    private String mTitle;
    private View.OnTouchListener mTouchListener;

    public ClickSlideShakeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSensorEventsDeliveredOnMainThread = true;
        this.mShakeThreshold = 3.0f;
        this.mShakeValidCount = 60;
        this.mShakeFactorX = 1.0f;
        this.mShakeFactorY = 1.0f;
        this.mShakeFactorZ = 0.5f;
        this.mShakeDuration = 0;
        this.mShakeSampleRate = 60;
        this.mShakeDirectcombine = null;
        this.mSlideGuideVisible = true;
        this.mBannerVisible = true;
        this.mBannerBottomPadding = -1;
        this.mAnimationHelper = new ClickSlideShakeAnimationHelper(Utils.getScreenWidth(context));
        AnimatorView animatorView = new AnimatorView(context);
        this.mBannerView = animatorView;
        addView(animatorView, new FrameLayout.LayoutParams(-1, -1));
        FeatureGestureView featureGestureView = new FeatureGestureView(context);
        this.mGestureView = featureGestureView;
        addView(featureGestureView, new FrameLayout.LayoutParams(-1, -1));
        ShakeSensor shakeSensor = new ShakeSensor(getContext());
        this.mShakeSensor = shakeSensor;
        shakeSensor.setShakeListener(this);
        this.mConfiguration = ViewConfiguration.get(context);
    }

    private void addSlideArrowView(Context context) {
        if (this.mSlideArrowView == null) {
            SlideArrowAnimatorView slideArrowAnimatorView = new SlideArrowAnimatorView(context, this.mAnimationHelper);
            this.mSlideArrowView = slideArrowAnimatorView;
            slideArrowAnimatorView.setSlideIconShape(2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            addView(this.mSlideArrowView, layoutParams);
        }
    }

    private GroupLayer createBannerLayer() {
        ShakeBannerAnimatorLayer.ShakeBannerLayerParams shakeBannerLayerParams = new ShakeBannerAnimatorLayer.ShakeBannerLayerParams();
        this.mBannerLayerParams = shakeBannerLayerParams;
        shakeBannerLayerParams.width = getRelativeSize(327);
        ShakeBannerAnimatorLayer.ShakeBannerLayerParams shakeBannerLayerParams2 = this.mBannerLayerParams;
        shakeBannerLayerParams2.height = (shakeBannerLayerParams2.width * 67) / 327;
        shakeBannerLayerParams2.title = this.mTitle;
        shakeBannerLayerParams2.subTitle = this.mSubTitle;
        shakeBannerLayerParams2.backgroundColor = this.mBannerBackgroundColor;
        shakeBannerLayerParams2.shakeIcon = this.mBannerIcon;
        shakeBannerLayerParams2.f70536x = getRelativeSize(24);
        ShakeBannerAnimatorLayer.ShakeBannerLayerParams shakeBannerLayerParams3 = this.mBannerLayerParams;
        int height = getHeight() - getBannerBottomPadding();
        ShakeBannerAnimatorLayer.ShakeBannerLayerParams shakeBannerLayerParams4 = this.mBannerLayerParams;
        shakeBannerLayerParams3.f70537y = height - shakeBannerLayerParams4.height;
        return new ShakeBannerAnimatorLayer(shakeBannerLayerParams4);
    }

    private int getBannerBottomPadding() {
        int i3 = this.mBannerBottomPadding;
        if (i3 < 0) {
            return getRelativeSize(126);
        }
        return i3;
    }

    private int getRelativeSize(int i3) {
        return (getWidth() * i3) / QidPagView.DESIGN_PAG_WIDTH;
    }

    private int getSlideArrowViewPaddingBottom() {
        return ((getRelativeSize(327) * 67) / 327) + getBannerBottomPadding();
    }

    private boolean isClickEvent(float f16, float f17) {
        if (this.mConfiguration == null) {
            return false;
        }
        float f18 = f16 - this.mDownX;
        float f19 = f17 - this.mDownY;
        if ((f18 * f18) + (f19 * f19) > r0.getScaledTouchSlop() * this.mConfiguration.getScaledTouchSlop()) {
            return false;
        }
        return true;
    }

    private boolean isClickInBanner(float f16, float f17) {
        if (this.mBannerLayerParams == null) {
            return false;
        }
        ShakeBannerAnimatorLayer.ShakeBannerLayerParams shakeBannerLayerParams = this.mBannerLayerParams;
        if (!new RectF(shakeBannerLayerParams.f70536x, shakeBannerLayerParams.f70537y, r3 + shakeBannerLayerParams.width, r5 + shakeBannerLayerParams.height).contains(f16, f17) || !isClickEvent(f16, f17)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View.OnClickListener onClickListener;
        View.OnTouchListener onTouchListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
        }
        if (this.mBannerView.isUserStarted()) {
            z16 = isClickInBanner(motionEvent.getX(), motionEvent.getY());
            FeatureGestureView featureGestureView = this.mGestureView;
            if (featureGestureView != null) {
                featureGestureView.setDisallowGestureEventNotify(z16);
            }
            if (z16 && (onTouchListener = this.mTouchListener) != null) {
                onTouchListener.onTouch(this, motionEvent);
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.mIsClickDownInBanner && z16 && (onClickListener = this.mClickListener) != null) {
                        onClickListener.onClick(this);
                    }
                    this.mIsClickDownInBanner = false;
                }
            } else if (z16) {
                this.mIsClickDownInBanner = true;
            }
        } else {
            z16 = false;
        }
        if (super.dispatchTouchEvent(motionEvent) || z16) {
            return true;
        }
        return false;
    }

    protected boolean needStartWhenAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (needStartWhenAttachedToWindow()) {
            start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            stop();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Double.valueOf(d16));
            return;
        }
        stop();
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null) {
            onShakeListener.onShakeComplete(d16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null) {
            onShakeListener.onShaking(d16, i3);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        this.mAnimationHelper.updateRootWidth(getWidth());
        if (this.mBannerView.isUserStarted()) {
            start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        this.mBannerView.pauseAnimation();
        SlideArrowAnimatorView slideArrowAnimatorView = this.mSlideArrowView;
        if (slideArrowAnimatorView != null) {
            slideArrowAnimatorView.pauseAnimation();
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        this.mBannerView.resumeAnimation();
        SlideArrowAnimatorView slideArrowAnimatorView = this.mSlideArrowView;
        if (slideArrowAnimatorView != null) {
            slideArrowAnimatorView.resumeAnimation();
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.resume();
        }
    }

    public void setBannerBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mBannerBackgroundColor = str;
        }
    }

    public void setBannerBottomPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mBannerBottomPadding = i3;
        }
    }

    public void setBannerIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
        } else {
            this.mBannerIcon = bitmap;
        }
    }

    public void setBannerVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mBannerVisible = z16;
        }
    }

    public void setCustomSlideArrowView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, i3);
        } else {
            this.mCustomSlideArrowView = view;
            this.mCustomSlideArrowViewMarginBanner = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mGestureView.setGestureClickHotArea(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureClickView(View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) viewArr);
        } else {
            this.mGestureView.setGestureClickView(viewArr);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.mGestureView.setGestureColor(str);
        }
    }

    public void setGestureSlideConfig(SlideConfig slideConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) slideConfig);
        } else if (slideConfig != null) {
            this.mGestureView.setSlideInspector(new SlideInspector(slideConfig) { // from class: com.tencent.ams.fusion.widget.clickslideshake.ClickSlideShakeView.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SlideConfig val$slideConfig;

                {
                    this.val$slideConfig = slideConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClickSlideShakeView.this, (Object) slideConfig);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.base.SlideInspector
                public boolean inspect(PointF pointF, PointF pointF2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pointF, (Object) pointF2)).booleanValue();
                    }
                    return TMASlideCalculateUtil.checkSlideValid(new Point((int) pointF.x, (int) pointF.y), new Point((int) pointF2.x, (int) pointF2.y), this.val$slideConfig);
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.mGestureView.setGestureSlideDirection(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mGestureView.setGestureSlideHotArea(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideValidAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Float.valueOf(f16));
        } else {
            this.mGestureView.setGestureSlideValidAngle(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.mGestureView.setGestureSlideValidHeightDp(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            this.mGestureView.setGestureStrokeWidthDp(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, z16);
        } else {
            this.mGestureView.setGestureVisible(z16);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onClickListener);
        } else {
            this.mClickListener = onClickListener;
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onTouchListener);
        } else {
            this.mTouchListener = onTouchListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setSensorEventsDeliveredOnMainThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mSensorEventsDeliveredOnMainThread = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) iArr);
        } else {
            this.mShakeDirectcombine = iArr;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mShakeFactorX = f16;
        this.mShakeFactorY = f17;
        this.mShakeFactorZ = f18;
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mShakeSampleRate = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mShakeDuration = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.mShakeThreshold = f16;
            this.mShakeValidCount = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setSlideGestureListener(SlideGestureViewHelper.ISlideGestureListener iSlideGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) iSlideGestureListener);
        } else {
            this.mGestureView.setSlideGestureListener(iSlideGestureListener);
        }
    }

    public void setSlideGuideVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mSlideGuideVisible = z16;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mSubTitle = str;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mTitle = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mBannerView.clearLayers();
        GroupLayer createBannerLayer = createBannerLayer();
        if (this.mBannerVisible) {
            this.mBannerView.addLayer(createBannerLayer);
        }
        this.mBannerView.startAnimation();
        if (this.mSlideGuideVisible) {
            addSlideArrowView(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSlideArrowView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = (int) ((getHeight() - createBannerLayer.getY()) + getRelativeSize(18));
            }
            this.mSlideArrowView.startAnimation();
        }
        View view = this.mCustomSlideArrowView;
        if (view != null) {
            Utils.safeRemoveChildView(view);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCustomSlideArrowView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams2.bottomMargin = (int) ((getHeight() - createBannerLayer.getY()) + getRelativeSize(this.mCustomSlideArrowViewMarginBanner));
            layoutParams2.gravity = 81;
            addView(this.mCustomSlideArrowView, layoutParams2);
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.reset();
            shakeSensor.setSensorEventsDeliveredOnMainThread(this.mSensorEventsDeliveredOnMainThread);
            shakeSensor.setShakeValue(this.mShakeThreshold, this.mShakeValidCount);
            shakeSensor.setShakeFactor(this.mShakeFactorX, this.mShakeFactorY, this.mShakeFactorZ);
            shakeSensor.setShakeDirectCombine(this.mShakeDirectcombine);
            shakeSensor.setShakeTimeDuration(this.mShakeDuration);
            shakeSensor.setShakeSampleRate(this.mShakeSampleRate);
            shakeSensor.register();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        this.mBannerView.stopAnimation(true, true);
        SlideArrowAnimatorView slideArrowAnimatorView = this.mSlideArrowView;
        if (slideArrowAnimatorView != null) {
            slideArrowAnimatorView.stopAnimation(true, true);
        }
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.unregister();
        }
        this.mShakeSensor = null;
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setOnShakeListener(ClickSlideShakeListener clickSlideShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            this.mShakeListener = clickSlideShakeListener;
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) clickSlideShakeListener);
        }
    }
}
