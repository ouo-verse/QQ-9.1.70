package com.tencent.ams.fusion.widget.slideinteractive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.DrawableLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGuideAnimationHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideGuideAnimatorView extends AnimatorView {
    static IPatchRedirector $redirector_ = null;
    private static final float ARROW_ICON_HEIGHT_DP = 77.0f;
    private static final float ARROW_ICON_WIDTH_DP = 34.0f;
    private static final float ARROW_TITLE_TOP_PADDING_DP = 47.0f;
    protected static final int DEFAULT_SUB_TITLE_SIZE_DP = 14;
    private static final int DEFAULT_TITLE_SIZE_DP = 18;
    private static final int SHADOW_END_COLOR = 0;
    private static final int SHADOW_START_COLOR = 2130706432;
    private static final float SLIDE_ICON_BELOW_BOTTOM_DP = 25.0f;
    private static final float SLIDE_ICON_HEIGHT_DP = 130.0f;
    private static final float SLIDE_ICON_WIDTH_DP = 130.0f;
    private static final String TAG = "SlideInteractiveView";
    private static final float TITLE_SUB_TITLE_PADDING_DP = 4.0f;
    private Bitmap mArrowBitmap;
    protected AnimatorLayer mArrowLayer;
    private float mBottomPaddingDp;
    protected boolean mIsStop;
    private Bitmap mSlideIconBitmap;
    protected AnimatorLayer mSlideIconLayer;
    private String mSubTitleText;
    protected AnimatorLayer mSubTitleTextLayer;
    private int mSubTitleTextSizeDp;
    private float mTextBottomMarginDp;
    private String mTitleText;
    protected AnimatorLayer mTitleTextLayer;
    private int mTitleTextSizeDp;

    public SlideGuideAnimatorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mBottomPaddingDp = 0.0f;
        this.mTextBottomMarginDp = 126.3f;
        this.mTitleTextSizeDp = 18;
        this.mSubTitleTextSizeDp = 14;
    }

    private Bitmap createArrowBitmap() {
        if (this.mArrowBitmap == null) {
            this.mArrowBitmap = Utils.bitmapFromBase64StringSafe(SlideGuideAnimationHelper.ARROW_ICON_BASE64, (int) Utils.dp2px(ARROW_ICON_WIDTH_DP), (int) Utils.dp2px(ARROW_ICON_HEIGHT_DP));
        }
        return this.mArrowBitmap;
    }

    private Bitmap createSlideIconBitmap() {
        Bitmap bitmap = this.mSlideIconBitmap;
        if (bitmap != null) {
            return Utils.scaleBitmapSafe(bitmap, (int) getSlideIconWidth(), (int) getSlideIconHeight());
        }
        return null;
    }

    private AnimatorLayer createSlideIconLayer() {
        Bitmap createSlideIconBitmap = createSlideIconBitmap();
        SlideGuideAnimationHelper.IconParams iconParams = new SlideGuideAnimationHelper.IconParams((getWidth() / 2.0f) - (getSlideIconWidth() / 2.0f), getSlideIconY(), getSlideIconWidth(), getSlideIconHeight());
        Logger.d(TAG, "createSlideIconLayer: " + iconParams);
        return SlideGuideAnimationHelper.getSlideIconAnimatorLayer(createSlideIconBitmap, iconParams, null);
    }

    private float getArrowIconHeight() {
        return Utils.dp2px(ARROW_ICON_HEIGHT_DP);
    }

    private float getArrowIconWidth() {
        return Utils.dp2px(ARROW_ICON_WIDTH_DP);
    }

    private float getArrowIconY() {
        return (getTitleLayerY() - Utils.getTextPaintBaselineToTop(Utils.dp2px(this.mTitleTextSizeDp))) - Utils.dp2px(47.0f);
    }

    private float getSlideIconHeight() {
        return Utils.dp2px(130.0f);
    }

    private float getSlideIconWidth() {
        return Utils.dp2px(130.0f);
    }

    private float getSlideIconY() {
        int height = getHeight();
        if (height <= 0) {
            height = Utils.getScreenHeight(getContext());
        }
        return (height - getSlideIconHeight()) + Utils.dp2px(SLIDE_ICON_BELOW_BOTTOM_DP);
    }

    private float getSubTitleLayerY() {
        int height = getHeight();
        if (height <= 0) {
            height = Utils.getScreenHeight(getContext());
        }
        return ((height - Utils.dp2px(this.mTextBottomMarginDp)) - Utils.dp2px(this.mBottomPaddingDp)) - Utils.getTextPaintBaselineToBottom(Utils.dp2px(this.mSubTitleTextSizeDp));
    }

    private float getTitleLayerY() {
        return ((getSubTitleLayerY() - Utils.getTextPaintBaselineToTop(Utils.dp2px(this.mSubTitleTextSizeDp))) - Utils.dp2px(4.0f)) - Utils.getTextPaintBaselineToBottom(Utils.dp2px(this.mTitleTextSizeDp));
    }

    private void reset() {
        this.mIsStop = false;
        clearLayers();
    }

    protected AnimatorLayer createArrowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return SlideGuideAnimationHelper.getArrowIconAnimatorLayer(createArrowBitmap(), new SlideGuideAnimationHelper.IconParams((getWidth() / 2.0f) - (getArrowIconWidth() / 2.0f), getArrowIconY(), getArrowIconWidth(), getArrowIconHeight()), null);
    }

    protected AnimatorLayer createBgShadowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        DrawableLayer drawableLayer = new DrawableLayer(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{2130706432, 0}));
        int dp2px = (int) Utils.dp2px(240.0f);
        drawableLayer.setX(0.0f);
        drawableLayer.setY((getHeight() - dp2px) - Utils.dp2px(this.mBottomPaddingDp));
        drawableLayer.setWidth(getWidth());
        drawableLayer.setHeight(dp2px);
        drawableLayer.setAnimator(new KeepAnimator(drawableLayer));
        return drawableLayer;
    }

    protected AnimatorLayer createSubTitleLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        TextLayer textLayer = new TextLayer(this.mSubTitleText, -855638017, Utils.dp2px(this.mSubTitleTextSizeDp));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(getWidth() / 2.0f);
        textLayer.setY(getSubTitleLayerY());
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    protected AnimatorLayer createTitleLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        TextLayer textLayer = new TextLayer(this.mTitleText, -1, Utils.dp2px(this.mTitleTextSizeDp));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(getWidth() / 2.0f);
        textLayer.setY(getTitleLayerY());
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextBold(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    public PointF getArrowIconCenterPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (PointF) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return new PointF(Utils.getScreenWidth(getContext()) / 2.0f, getArrowIconY() + (getArrowIconWidth() / 2.0f));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        if (isUserStarted()) {
            start();
        }
    }

    public void reStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Logger.i(TAG, "reStart isStop: " + this.mIsStop + " isUserStarted :" + isUserStarted());
        if (isUserStarted() && !this.mIsStop) {
            start();
        }
    }

    public void setBottomPaddingDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else if (f16 >= 0.0f) {
            this.mBottomPaddingDp = f16;
        }
    }

    public void setSlideIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.mSlideIconBitmap = bitmap;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mSubTitleText = str;
        }
    }

    public void setSubTitleTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.mSubTitleTextSizeDp = i3;
            return;
        }
        Logger.w(TAG, "Set sub title text size with an invalid value: " + i3);
    }

    public void setTextBottomMarginDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else if (f16 >= 0.0f) {
            this.mTextBottomMarginDp = f16;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mTitleText = str;
        }
    }

    public void setTitleTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.mTitleTextSizeDp = i3;
            return;
        }
        Logger.w(TAG, "Set title text size with an invalid value: " + i3);
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        reset();
        startShakeAnimation();
    }

    public void startEndAnimation(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) animatorListener);
            return;
        }
        AnimatorLayer animatorLayer = this.mSlideIconLayer;
        if (animatorLayer != null) {
            animatorLayer.setAnimator(SlideGuideAnimationHelper.getSlideIconEndAnimator(animatorLayer, animatorListener, Utils.dp2px(-208.0f), true));
        }
        AnimatorLayer animatorLayer2 = this.mArrowLayer;
        if (animatorLayer2 != null) {
            if (this.mSlideIconLayer != null) {
                animatorListener = null;
            }
            animatorLayer2.setAnimator(SlideGuideAnimationHelper.getArrowIconEndAnimator(animatorLayer2, animatorListener));
        }
        AnimatorLayer animatorLayer3 = this.mTitleTextLayer;
        if (animatorLayer3 != null) {
            animatorLayer3.setAnimator(SlideGuideAnimationHelper.getTitleEndAnimator(animatorLayer3));
        }
        AnimatorLayer animatorLayer4 = this.mSubTitleTextLayer;
        if (animatorLayer4 != null) {
            animatorLayer4.setAnimator(SlideGuideAnimationHelper.getSubTitleEndAnimator(animatorLayer4));
        }
        startAnimation();
    }

    protected void startShakeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.mIsStop) {
            return;
        }
        this.mSlideIconLayer = createSlideIconLayer();
        this.mTitleTextLayer = createTitleLayer();
        this.mSubTitleTextLayer = createSubTitleLayer();
        this.mArrowLayer = createArrowLayer();
        addLayer(new GroupLayer(createBgShadowLayer(), this.mSlideIconLayer, this.mTitleTextLayer, this.mSubTitleTextLayer, this.mArrowLayer));
        startAnimation();
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            stop(true);
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    private void stop(boolean z16) {
        Logger.i(TAG, "stop clearCanvas:" + z16);
        this.mIsStop = true;
        stopAnimation(z16, true);
    }
}
