package com.tencent.ams.fusion.widget.actionbanner;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.View;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.ColorAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.FrameLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RectangleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGuideAnimationHelper;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ActionBannerAnimationHelper {
    static IPatchRedirector $redirector_ = null;
    private static final int BACKGROUND_HIGHLIGHT_DURATION = 500;
    private static final int BACKGROUND_RADIUS_DP = 83;
    private static final int BACKGROUND_STROKE_WIDTH_DP = 2;
    private static final int BACKGROUND_WIDTH_RELATIVE = 654;
    private static final int BREATH_ANIMATION_DURATION = 1000;
    private static final int BREATH_COLOR = 1308622847;
    private static final int BREATH_STROKE_WIDTH_RELATIVE = 18;
    private static final int COLOR_BACKGROUND = -870309856;
    private static final int COLOR_HIGHLIGHT_BACKGROUND = -869105162;
    private static final int COLOR_STROKE = 1308622847;
    private static final int COLOR_SUB_TITLE = -855638017;
    private static final int COLOR_TITLE = 16777215;
    private static final int ICON_WIDTH_RELATIVE = 120;
    private static final int PADDING_ICON_LEFT_RELATIVE = 10;
    private static final int PADDING_ICON_RIGHT_RELATIVE = 40;
    private static final int PADDING_TITLE_LEFT_RELATIVE = 48;
    private static final int PADDING_TITLE_SUB_TITLE_RELATIVE = 16;
    private static final int SINGLE_LINE_BACKGROUND_WIDTH_RELATIVE = 614;
    private static final int SINGLE_LINE_ICON_WIDTH_RELATIVE = 108;
    private static final int SINGLE_LINE_PADDING_ICON_LEFT_RELATIVE = 8;
    private static final int SINGLE_LINE_PADDING_ICON_RIGHT_RELATIVE = 46;
    private static final int SINGLE_LINE_PADDING_TITLE_LEFT_RELATIVE = 46;
    private final ActionBannerInfo mActionBannerInfo;
    private final View mActionBannerView;
    private int mCustomWidthRelative;
    private final SlideArrowAnimationHelper mSlideArrowAnimationHelper;

    public ActionBannerAnimationHelper(View view, ActionBannerInfo actionBannerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) actionBannerInfo);
            return;
        }
        this.mCustomWidthRelative = 0;
        if (view != null && actionBannerInfo != null) {
            this.mActionBannerView = view;
            this.mActionBannerInfo = actionBannerInfo;
            this.mSlideArrowAnimationHelper = new SlideArrowAnimationHelper();
            return;
        }
        throw new IllegalArgumentException("Can't set a null action banner view or info, please check.");
    }

    private Animator createBreathAnimator(AnimatorLayer animatorLayer) {
        float breathLayerMaxWidth = getBreathLayerMaxWidth() / getBreathLayerWidth();
        float breathLayerMaxHeight = getBreathLayerMaxHeight() / getBreathLayerHeight();
        ScaleAnimator scaleAnimator = new ScaleAnimator(animatorLayer, 1.0f, breathLayerMaxWidth, 1.0f, breathLayerMaxHeight);
        scaleAnimator.setDuration(1000L);
        scaleAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        ScaleAnimator scaleAnimator2 = new ScaleAnimator(animatorLayer, breathLayerMaxWidth, 1.0f, breathLayerMaxHeight, 1.0f);
        scaleAnimator2.setDuration(1000L);
        scaleAnimator2.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer, scaleAnimator, scaleAnimator2);
        sequentialAnimator.setRepeatMode(1);
        sequentialAnimator.setRepeatCount(0);
        return sequentialAnimator;
    }

    private float getBannerBgLayerCenterX() {
        return this.mActionBannerView.getWidth() / 2.0f;
    }

    private float getBannerBgLayerCenterY() {
        return (this.mActionBannerView.getHeight() - this.mActionBannerInfo.getMarginBottom()) - (getBannerBgLayerHeight() / 2.0f);
    }

    private float getBannerBgLayerHeight() {
        return this.mActionBannerInfo.getBackgroundHeight();
    }

    private float getBannerBgLayerWidth() {
        int i3;
        if (this.mActionBannerInfo.isSingleLine()) {
            i3 = 614;
        } else {
            i3 = this.mCustomWidthRelative;
            if (i3 == 0) {
                i3 = BACKGROUND_WIDTH_RELATIVE;
            }
        }
        return Utils.getRelativeSize(this.mActionBannerView.getContext(), i3);
    }

    private float getBreathLayerHeight() {
        return getBannerBgLayerHeight();
    }

    private float getBreathLayerMaxHeight() {
        return getBannerBgLayerHeight() + (getRelativeSize(18) * 2.0f);
    }

    private float getBreathLayerMaxWidth() {
        return getBannerBgLayerWidth() + (getRelativeSize(18) * 2.0f);
    }

    private float getBreathLayerWidth() {
        return getBannerBgLayerWidth();
    }

    private float getIconLayerCenterX() {
        return ((getBannerBgLayerCenterX() + (getBannerBgLayerWidth() / 2.0f)) - (getIconLayerWidth() / 2.0f)) - getIconRightPadding();
    }

    private float getIconLayerWidth() {
        int i3;
        if (!this.mActionBannerInfo.isIconVisible()) {
            return 0.0f;
        }
        if (this.mActionBannerInfo.isSingleLine()) {
            i3 = 108;
        } else {
            i3 = 120;
        }
        return getRelativeSize(i3);
    }

    private float getIconLeftPadding() {
        int i3;
        if (!this.mActionBannerInfo.isIconVisible()) {
            return 0.0f;
        }
        if (this.mActionBannerInfo.isSingleLine()) {
            i3 = 8;
        } else {
            i3 = 10;
        }
        return getRelativeSize(i3);
    }

    private float getIconRightPadding() {
        int i3;
        if (this.mActionBannerInfo.isSingleLine()) {
            i3 = 46;
        } else {
            i3 = 40;
        }
        return getRelativeSize(i3);
    }

    private float getRelativeSize(int i3) {
        return Utils.getRelativeSize(this.mActionBannerView.getContext(), i3);
    }

    private float getSlideArrowBgY() {
        return ((getBannerBgLayerCenterY() - (getBannerBgLayerHeight() / 2.0f)) - Utils.dp2px(10.0f)) - ((int) Utils.dp2px(80.0f));
    }

    private float getSlideNormalArrowY() {
        return (getBannerBgLayerCenterY() - (getBannerBgLayerHeight() / 2.0f)) - Utils.dp2px(58.0f);
    }

    private float getSubTitleLayerX() {
        return getTitleLayerX();
    }

    private float getSubTitleLayerY() {
        return getBannerBgLayerCenterY() + Utils.getTextPaintBaselineToTop(this.mActionBannerInfo.getSubTitleFontSize()) + (getRelativeSize(16) / 2.0f);
    }

    private float getTitleLayerWidth() {
        return (((getBannerBgLayerWidth() - getTitleLeftPadding()) - getIconLayerWidth()) - getIconLeftPadding()) - getIconRightPadding();
    }

    private float getTitleLayerX() {
        if (!this.mActionBannerInfo.isIconVisible()) {
            return getBannerBgLayerCenterX();
        }
        return (getBannerBgLayerCenterX() - (getBannerBgLayerWidth() / 2.0f)) + getTitleLeftPadding();
    }

    private float getTitleLayerY() {
        if (this.mActionBannerInfo.isSingleLine()) {
            float titleFontSize = this.mActionBannerInfo.getTitleFontSize();
            return getBannerBgLayerCenterY() + (Utils.getTextPaintBaselineToTop(titleFontSize) - (Utils.getTextPaintHeight(titleFontSize) / 2.0f));
        }
        return getBannerBgLayerCenterY() - (getRelativeSize(16) / 2.0f);
    }

    private float getTitleLeftPadding() {
        int i3;
        if (this.mActionBannerInfo.isSingleLine()) {
            i3 = 46;
        } else {
            i3 = 48;
        }
        return getRelativeSize(i3);
    }

    public AnimatorLayer createBannerBgLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RectangleShapeLayer rectangleShapeLayer = new RectangleShapeLayer((int) getBannerBgLayerWidth(), (int) getBannerBgLayerHeight(), Utils.safeParseColor(this.mActionBannerInfo.getBackgroundColor(), COLOR_BACKGROUND));
        rectangleShapeLayer.setStroke(Utils.dp2px(2.0f), 1308622847);
        rectangleShapeLayer.setRadius(Utils.dp2px(83.0f));
        rectangleShapeLayer.setCenterX(getBannerBgLayerCenterX());
        rectangleShapeLayer.setCenterY(getBannerBgLayerCenterY());
        int safeParseColor = Utils.safeParseColor(this.mActionBannerInfo.getBackgroundColor(), COLOR_BACKGROUND);
        int safeParseColor2 = Utils.safeParseColor(this.mActionBannerInfo.getHighlightBackgroundColor(), COLOR_HIGHLIGHT_BACKGROUND);
        KeepAnimator keepAnimator = new KeepAnimator(rectangleShapeLayer);
        keepAnimator.setDuration(this.mActionBannerInfo.getHighlightDelayTime());
        ColorAnimator colorAnimator = new ColorAnimator(rectangleShapeLayer, safeParseColor, safeParseColor2);
        colorAnimator.setDuration(500L);
        rectangleShapeLayer.setAnimator(new SequentialAnimator(rectangleShapeLayer, keepAnimator, colorAnimator));
        return rectangleShapeLayer;
    }

    public AnimatorLayer createBreathLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.mActionBannerInfo.getBackgroundAnimationType() == 1) {
            return null;
        }
        RectangleShapeLayer rectangleShapeLayer = new RectangleShapeLayer((int) getBreathLayerWidth(), (int) getBreathLayerHeight(), 1308622847);
        rectangleShapeLayer.setRadius(Utils.dp2px(83.0f));
        rectangleShapeLayer.setCenterX(getBannerBgLayerCenterX());
        rectangleShapeLayer.setCenterY(getBannerBgLayerCenterY());
        rectangleShapeLayer.setAnimator(createBreathAnimator(rectangleShapeLayer));
        return rectangleShapeLayer;
    }

    public AnimatorLayer createIconLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        FrameLayer frameLayer = new FrameLayer(this.mActionBannerInfo.getIconBitmapArray());
        frameLayer.setWidth((int) getIconLayerWidth());
        frameLayer.setHeight((int) getIconLayerWidth());
        frameLayer.setCenterX(getIconLayerCenterX());
        frameLayer.setCenterY(getBannerBgLayerCenterY());
        frameLayer.setAnimator(new KeepAnimator(frameLayer).setDuration(1000L).setRepeatCount(0));
        return frameLayer;
    }

    public AnimatorLayer createSlideArrowBgLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int slideArrowBgWidth = this.mSlideArrowAnimationHelper.getSlideArrowBgWidth();
        int slideArrowBgHeight = this.mSlideArrowAnimationHelper.getSlideArrowBgHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(SlideArrowAnimationHelper.IC_ARROW_BG_BASE64, slideArrowBgWidth, slideArrowBgHeight));
        bitmapLayer.setCenterX(getBannerBgLayerCenterX());
        bitmapLayer.setWidth(slideArrowBgWidth);
        bitmapLayer.setHeight(slideArrowBgHeight);
        bitmapLayer.setY(getSlideArrowBgY());
        bitmapLayer.setAnimator(this.mSlideArrowAnimationHelper.createSlideArrowBgAnimation(bitmapLayer));
        return bitmapLayer;
    }

    public AnimatorLayer createSlideArrowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        int slideArrowHeight = this.mSlideArrowAnimationHelper.getSlideArrowHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(SlideArrowAnimationHelper.IC_ARROW_BASE64, slideArrowHeight, slideArrowHeight));
        bitmapLayer.setCenterX(getBannerBgLayerCenterX());
        bitmapLayer.setWidth(slideArrowHeight);
        bitmapLayer.setHeight(slideArrowHeight);
        bitmapLayer.setY(getSlideArrowBgY() - Utils.dp2px(4.0f));
        bitmapLayer.setAnimator(this.mSlideArrowAnimationHelper.createArrowAnimation(bitmapLayer));
        return bitmapLayer;
    }

    public AnimatorLayer createSlideHandLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        int dp2px = (int) Utils.dp2px(43.0f);
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(SlideArrowAnimationHelper.IC_HAND_BASE64, dp2px, dp2px));
        bitmapLayer.setWidth(dp2px);
        bitmapLayer.setHeight(dp2px);
        bitmapLayer.setX(getBannerBgLayerCenterX() + (this.mSlideArrowAnimationHelper.getSlideArrowBgWidth() / 2.0f));
        bitmapLayer.setY(getSlideArrowBgY() + Utils.dp2px(2.0f));
        bitmapLayer.setAnimator(this.mSlideArrowAnimationHelper.createSlideHandAnimation(bitmapLayer));
        return bitmapLayer;
    }

    public AnimatorLayer createSlideNormalArrowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Bitmap createSlideArrowBitmap = this.mSlideArrowAnimationHelper.createSlideArrowBitmap();
        float slideNormalArrowWidth = this.mSlideArrowAnimationHelper.getSlideNormalArrowWidth();
        return SlideGuideAnimationHelper.getArrowIconAnimatorLayer(createSlideArrowBitmap, new SlideGuideAnimationHelper.IconParams(getBannerBgLayerCenterX() - (slideNormalArrowWidth / 2.0f), getSlideNormalArrowY(), slideNormalArrowWidth, this.mSlideArrowAnimationHelper.getSlideNormalArrowHeight()), null);
    }

    public AnimatorLayer createSubTitleLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.mActionBannerInfo.isSingleLine()) {
            return null;
        }
        TextLayer textLayer = new TextLayer(this.mActionBannerInfo.getSubTitle(), Utils.safeParseColor(this.mActionBannerInfo.getSubTitleColor(), COLOR_SUB_TITLE), this.mActionBannerInfo.getSubTitleFontSize());
        if (!this.mActionBannerInfo.isIconVisible()) {
            textLayer.setTextAlign(Paint.Align.CENTER);
        } else {
            textLayer.setTextAlign(Paint.Align.LEFT);
        }
        textLayer.setX(getSubTitleLayerX());
        textLayer.setY(getSubTitleLayerY());
        textLayer.setWidth((int) getTitleLayerWidth());
        textLayer.setEllipsizeAtEnd(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    public AnimatorLayer createTitleLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        TextLayer textLayer = new TextLayer(this.mActionBannerInfo.getTitle(), Utils.safeParseColor(this.mActionBannerInfo.getTitleColor(), 16777215), this.mActionBannerInfo.getTitleFontSize());
        if (!this.mActionBannerInfo.isIconVisible()) {
            textLayer.setTextAlign(Paint.Align.CENTER);
        } else {
            textLayer.setTextAlign(Paint.Align.LEFT);
        }
        textLayer.setX(getTitleLayerX());
        textLayer.setY(getTitleLayerY());
        textLayer.setWidth((int) getTitleLayerWidth());
        textLayer.setEllipsizeAtEnd(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    public void setBannerRelativeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mCustomWidthRelative = i3;
        }
    }
}
