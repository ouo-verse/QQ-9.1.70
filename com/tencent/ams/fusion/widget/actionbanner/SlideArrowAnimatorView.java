package com.tencent.ams.fusion.widget.actionbanner;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGuideAnimationHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideArrowAnimatorView extends AnimatorView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SlideArrowAnimatorView";
    private final SlideArrowAnimationHelper mAnimationHelper;
    private int mLayerPaddingBottom;
    private int mSlideIconShape;

    public SlideArrowAnimatorView(Context context) {
        this(context, new SlideArrowAnimationHelper());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private float getSlideArrowBgY() {
        return (getHeight() - Utils.dp2px(this.mLayerPaddingBottom)) - this.mAnimationHelper.getSlideArrowBgHeight();
    }

    public AnimatorLayer createSlideArrowBgLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int slideArrowBgWidth = this.mAnimationHelper.getSlideArrowBgWidth();
        int slideArrowBgHeight = this.mAnimationHelper.getSlideArrowBgHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(this.mAnimationHelper.getIconArrowBgBase64(), slideArrowBgWidth, slideArrowBgHeight));
        bitmapLayer.setCenterX(getWidth() / 2.0f);
        bitmapLayer.setWidth(slideArrowBgWidth);
        bitmapLayer.setHeight(slideArrowBgHeight);
        bitmapLayer.setY(getSlideArrowBgY());
        bitmapLayer.setAnimator(this.mAnimationHelper.createSlideArrowBgAnimation(bitmapLayer));
        return bitmapLayer;
    }

    public AnimatorLayer createSlideArrowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int slideArrowHeight = this.mAnimationHelper.getSlideArrowHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(this.mAnimationHelper.getIconArrowBase64(), slideArrowHeight, slideArrowHeight));
        bitmapLayer.setCenterX(getWidth() / 2.0f);
        bitmapLayer.setWidth(slideArrowHeight);
        bitmapLayer.setHeight(slideArrowHeight);
        bitmapLayer.setY(getSlideArrowBgY() - Utils.dp2px(4.0f));
        bitmapLayer.setAnimator(this.mAnimationHelper.createArrowAnimation(bitmapLayer));
        return bitmapLayer;
    }

    public AnimatorLayer createSlideHandLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        int slideHandHeight = this.mAnimationHelper.getSlideHandHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(this.mAnimationHelper.getIconHandBase64(), slideHandHeight, slideHandHeight));
        bitmapLayer.setWidth(slideHandHeight);
        bitmapLayer.setHeight(slideHandHeight);
        bitmapLayer.setX((getWidth() / 2.0f) + this.mAnimationHelper.getHandLeftMargin());
        bitmapLayer.setY(getSlideArrowBgY() + Utils.dp2px(2.0f));
        bitmapLayer.setAnimator(this.mAnimationHelper.createSlideHandAnimation(bitmapLayer));
        return bitmapLayer;
    }

    public AnimatorLayer createSlideNormalArrowLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Bitmap createSlideArrowBitmap = this.mAnimationHelper.createSlideArrowBitmap();
        float slideNormalArrowWidth = this.mAnimationHelper.getSlideNormalArrowWidth();
        return SlideGuideAnimationHelper.getArrowIconAnimatorLayer(createSlideArrowBitmap, new SlideGuideAnimationHelper.IconParams((getWidth() / 2.0f) - (slideNormalArrowWidth / 2.0f), (getHeight() - Utils.dp2px(285.0f)) - Utils.dp2px(58.0f), slideNormalArrowWidth, this.mAnimationHelper.getSlideNormalArrowHeight()), null);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onAttachedToWindow();
            startAnimation();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            stopAnimation();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        if (isUserStarted()) {
            startAnimation();
        }
    }

    public void setLayerPaddingBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mLayerPaddingBottom = i3;
        }
    }

    public void setSlideIconShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mSlideIconShape = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Logger.i(TAG, QZoneJsConstants.ACTION_START_ANIMATION);
        clearLayers();
        GroupLayer groupLayer = new GroupLayer(new AnimatorLayer[0]);
        if (this.mSlideIconShape == 2) {
            groupLayer.addLayers(createSlideArrowBgLayer(), createSlideArrowLayer(), createSlideHandLayer());
        } else {
            groupLayer.addLayers(createSlideNormalArrowLayer());
        }
        addLayer(groupLayer);
        super.startAnimation();
    }

    public SlideArrowAnimatorView(Context context, SlideArrowAnimationHelper slideArrowAnimationHelper) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) slideArrowAnimationHelper);
            return;
        }
        this.mLayerPaddingBottom = 0;
        if (slideArrowAnimationHelper == null) {
            this.mAnimationHelper = new SlideArrowAnimationHelper();
        } else {
            this.mAnimationHelper = slideArrowAnimationHelper;
        }
    }
}
