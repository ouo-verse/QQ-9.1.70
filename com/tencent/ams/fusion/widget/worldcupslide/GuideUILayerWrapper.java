package com.tencent.ams.fusion.widget.worldcupslide;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.MotionEvent;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GuideUILayerWrapper implements WorldCupSlideView.InteractListener {
    static IPatchRedirector $redirector_;
    private Bitmap mArrowBitmap;
    private float mArrowBitmapHeight;
    private float mArrowBitmapPosX;
    private float mArrowBitmapPosY;
    private float mArrowBitmapWidth;
    private AnimatorLayer mArrowLayer;
    private Animator mArrowLayerAppearAnimator;
    private Animator mArrowLayerDisappearAnimator;
    private Animator mArrowLayerShakeAnimator;
    private Animator mArrowLayerTouchAnimator;
    private List<AnimatorLayer> mGuideUILayers;
    private boolean mIsDisappear;
    private float mShakeUpDistance;
    private float mSlideMaxDistance;
    private float mSubTitleAlpha;
    private int mSubTitleColor;
    private float mSubTitleFontSize;
    private float mSubTitlePosX;
    private float mSubTitlePosY;
    private String mSubTitleText;
    private AnimatorLayer mSubTitleTextLayer;
    private Animator mSubTitleTextLayerAppearAnimator;
    private Animator mSubTitleTextLayerDisappearAnimator;
    private Animator mSubTitleTextLayerShakeAnimator;
    private Animator mSubTitleTextLayerTouchAnimator;
    private int mTitleColor;
    private float mTitleFontSize;
    private float mTitlePosX;
    private float mTitlePosY;
    private String mTitleText;
    private AnimatorLayer mTitleTextLayer;
    private Animator mTitleTextLayerAppearAnimator;
    private Animator mTitleTextLayerDisappearAnimator;
    private Animator mTitleTextLayerShakeAnimator;
    private Animator mTitleTextLayerTouchAnimator;
    private float mTouchStartY;

    public GuideUILayerWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mGuideUILayers = new ArrayList();
        }
    }

    private Animator createAlphaAnimator(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, f16, f17);
        alphaAnimator.setDuration(j3);
        alphaAnimator.setPathInterpolator(0.33f, 1.0f, 0.68f, 1.0f);
        return alphaAnimator;
    }

    private Animator createShakeAnimator(AnimatorLayer animatorLayer) {
        TranslateAnimator createTranslateAnimator = createTranslateAnimator(animatorLayer, 0.0f, this.mShakeUpDistance, 600L);
        createTranslateAnimator.setRepeatCount(0);
        createTranslateAnimator.setRepeatMode(2);
        return createTranslateAnimator;
    }

    private AnimatorLayer createTextLayer(String str, int i3, float f16, float f17, float f18) {
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(f17);
        textLayer.setY(f18);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextBold(true);
        return textLayer;
    }

    private Animator createTouchAnimator(AnimatorLayer animatorLayer) {
        return new KeepAnimator(animatorLayer);
    }

    private TranslateAnimator createTranslateAnimator(AnimatorLayer animatorLayer, float f16, float f17, long j3) {
        TranslateAnimator translateAnimator = new TranslateAnimator(animatorLayer, 0.0f, 0.0f, f16, f17);
        translateAnimator.setDuration(j3);
        translateAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
        return translateAnimator;
    }

    private void setDisappear() {
        if (this.mArrowLayer != null) {
            this.mArrowLayerDisappearAnimator.reset();
            this.mArrowLayer.setAnimator(this.mArrowLayerDisappearAnimator);
        }
        if (this.mTitleTextLayer != null) {
            this.mTitleTextLayerDisappearAnimator.reset();
            this.mTitleTextLayer.setAnimator(this.mTitleTextLayerDisappearAnimator);
        }
        if (this.mSubTitleTextLayer != null) {
            this.mSubTitleTextLayerDisappearAnimator.reset();
            this.mSubTitleTextLayer.setAnimator(this.mSubTitleTextLayerDisappearAnimator);
        }
    }

    public AnimatorLayer[] getGuideUILayers() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AnimatorLayer[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mArrowLayer == null && (bitmap = this.mArrowBitmap) != null) {
            AnimatorLayer height = new BitmapLayer(bitmap).setX(this.mArrowBitmapPosX).setY(this.mArrowBitmapPosY).setWidth((int) this.mArrowBitmapWidth).setHeight((int) this.mArrowBitmapHeight);
            this.mArrowLayer = height;
            this.mArrowLayerShakeAnimator = createShakeAnimator(height);
            this.mArrowLayerTouchAnimator = createTouchAnimator(this.mArrowLayer);
            this.mArrowLayerAppearAnimator = createAlphaAnimator(this.mArrowLayer, 0.0f, 1.0f, 0L);
            this.mArrowLayerDisappearAnimator = createAlphaAnimator(this.mArrowLayer, 1.0f, 0.0f, 400L);
            this.mArrowLayer.setAnimator(this.mArrowLayerShakeAnimator);
            this.mGuideUILayers.add(this.mArrowLayer);
        }
        if (this.mTitleTextLayer == null) {
            AnimatorLayer createTextLayer = createTextLayer(this.mTitleText, this.mTitleColor, this.mTitleFontSize, this.mTitlePosX, this.mTitlePosY);
            this.mTitleTextLayer = createTextLayer;
            this.mTitleTextLayerShakeAnimator = createShakeAnimator(createTextLayer);
            this.mTitleTextLayerTouchAnimator = createTouchAnimator(this.mTitleTextLayer);
            this.mTitleTextLayerAppearAnimator = createAlphaAnimator(this.mTitleTextLayer, 0.0f, 1.0f, 0L);
            this.mTitleTextLayerDisappearAnimator = createAlphaAnimator(this.mTitleTextLayer, 1.0f, 0.0f, 400L);
            this.mTitleTextLayer.setAnimator(this.mTitleTextLayerShakeAnimator);
            this.mGuideUILayers.add(this.mTitleTextLayer);
        }
        if (this.mSubTitleTextLayer == null) {
            AnimatorLayer createTextLayer2 = createTextLayer(this.mSubTitleText, this.mSubTitleColor, this.mSubTitleFontSize, this.mSubTitlePosX, this.mSubTitlePosY);
            this.mSubTitleTextLayer = createTextLayer2;
            this.mSubTitleTextLayerShakeAnimator = createShakeAnimator(createTextLayer2);
            this.mSubTitleTextLayerTouchAnimator = createTouchAnimator(this.mSubTitleTextLayer);
            this.mSubTitleTextLayerAppearAnimator = createAlphaAnimator(this.mSubTitleTextLayer, 0.0f, this.mSubTitleAlpha, 0L);
            this.mSubTitleTextLayerDisappearAnimator = createAlphaAnimator(this.mSubTitleTextLayer, this.mSubTitleAlpha, 0.0f, 400L);
            this.mSubTitleTextLayer.setAnimator(this.mSubTitleTextLayerShakeAnimator);
            this.mGuideUILayers.add(this.mSubTitleTextLayer);
        }
        return (AnimatorLayer[]) this.mGuideUILayers.toArray(new AnimatorLayer[0]);
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onInteractFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!this.mIsDisappear) {
            AnimatorLayer animatorLayer = this.mArrowLayer;
            if (animatorLayer != null) {
                float y16 = animatorLayer.getY() - this.mArrowBitmapPosY;
                AnimatorLayer animatorLayer2 = this.mArrowLayer;
                animatorLayer2.setAnimator(createTranslateAnimator(animatorLayer2, y16, 0.0f, 300L));
            }
            AnimatorLayer animatorLayer3 = this.mTitleTextLayer;
            if (animatorLayer3 != null) {
                float y17 = animatorLayer3.getY() - this.mTitlePosY;
                AnimatorLayer animatorLayer4 = this.mTitleTextLayer;
                animatorLayer4.setAnimator(createTranslateAnimator(animatorLayer4, y17, 0.0f, 300L));
            }
            AnimatorLayer animatorLayer5 = this.mSubTitleTextLayer;
            if (animatorLayer5 != null) {
                float y18 = animatorLayer5.getY() - this.mSubTitlePosY;
                AnimatorLayer animatorLayer6 = this.mSubTitleTextLayer;
                animatorLayer6.setAnimator(createTranslateAnimator(animatorLayer6, y18, 0.0f, 300L));
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onInteractSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void onTouch(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent);
            return;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float y16 = this.mTouchStartY - motionEvent.getY();
                if (y16 >= 0.0f) {
                    float f16 = this.mSlideMaxDistance;
                    if (y16 >= f16) {
                        if (!this.mIsDisappear) {
                            this.mIsDisappear = true;
                            setDisappear();
                            return;
                        }
                        y16 = f16;
                    }
                } else {
                    y16 = 0.0f;
                }
                AnimatorLayer animatorLayer = this.mArrowLayer;
                if (animatorLayer != null) {
                    animatorLayer.postTranslate(0.0f, -y16);
                }
                AnimatorLayer animatorLayer2 = this.mTitleTextLayer;
                if (animatorLayer2 != null) {
                    animatorLayer2.postTranslate(0.0f, -y16);
                }
                AnimatorLayer animatorLayer3 = this.mSubTitleTextLayer;
                if (animatorLayer3 != null) {
                    animatorLayer3.postTranslate(0.0f, -y16);
                    return;
                }
                return;
            }
            return;
        }
        this.mIsDisappear = false;
        this.mTouchStartY = motionEvent.getY();
        AnimatorLayer animatorLayer4 = this.mArrowLayer;
        if (animatorLayer4 != null) {
            animatorLayer4.setAnimator(this.mArrowLayerTouchAnimator);
        }
        AnimatorLayer animatorLayer5 = this.mTitleTextLayer;
        if (animatorLayer5 != null) {
            animatorLayer5.setAnimator(this.mTitleTextLayerTouchAnimator);
        }
        AnimatorLayer animatorLayer6 = this.mSubTitleTextLayer;
        if (animatorLayer6 != null) {
            animatorLayer6.setAnimator(this.mSubTitleTextLayerTouchAnimator);
        }
    }

    @Override // com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.InteractListener
    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AnimatorLayer animatorLayer = this.mArrowLayer;
        if (animatorLayer != null) {
            animatorLayer.postTranslate(0.0f, 0.0f);
            if (this.mIsDisappear) {
                this.mArrowLayerShakeAnimator.reset();
                AnimatorLayer animatorLayer2 = this.mArrowLayer;
                animatorLayer2.setAnimator(new GroupAnimator(animatorLayer2, this.mArrowLayerAppearAnimator, this.mArrowLayerShakeAnimator));
            } else {
                AnimatorLayer animatorLayer3 = this.mArrowLayer;
                animatorLayer3.setAnimator(createShakeAnimator(animatorLayer3));
            }
        }
        if (this.mTitleTextLayer != null) {
            this.mTitleTextLayerShakeAnimator.reset();
            if (this.mIsDisappear) {
                this.mTitleTextLayerAppearAnimator.reset();
                AnimatorLayer animatorLayer4 = this.mTitleTextLayer;
                animatorLayer4.setAnimator(new GroupAnimator(animatorLayer4, this.mTitleTextLayerAppearAnimator, this.mTitleTextLayerShakeAnimator));
            } else {
                this.mTitleTextLayer.setAnimator(this.mTitleTextLayerShakeAnimator);
            }
        }
        if (this.mSubTitleTextLayer != null) {
            this.mSubTitleTextLayerShakeAnimator.reset();
            if (this.mIsDisappear) {
                this.mSubTitleTextLayerAppearAnimator.reset();
                AnimatorLayer animatorLayer5 = this.mSubTitleTextLayer;
                animatorLayer5.setAnimator(new GroupAnimator(animatorLayer5, this.mSubTitleTextLayerAppearAnimator, this.mSubTitleTextLayerShakeAnimator));
                return;
            }
            this.mSubTitleTextLayer.setAnimator(this.mSubTitleTextLayerShakeAnimator);
        }
    }

    public void setArrowBitmap(Bitmap bitmap, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bitmap, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mArrowBitmap = bitmap;
        this.mArrowBitmapPosX = f16;
        this.mArrowBitmapPosY = f17;
        this.mArrowBitmapWidth = f18;
        this.mArrowBitmapHeight = f19;
    }

    public void setShakeUpDistance(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mShakeUpDistance = f16;
        }
    }

    public void setSlideMaxDistance(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mSlideMaxDistance = f16;
        }
    }

    public void setSubTitle(String str, int i3, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.mSubTitleText = str;
        this.mSubTitleColor = AnimatorUtils.getColorWithAlpha((int) (255.0f * f16), i3);
        this.mSubTitleAlpha = f16;
        this.mSubTitleFontSize = f17;
        this.mSubTitlePosX = f18;
        this.mSubTitlePosY = f19;
    }

    public void setTitle(String str, int i3, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mTitleText = str;
        this.mTitleColor = i3;
        this.mTitleFontSize = f16;
        this.mTitlePosX = f17;
        this.mTitlePosY = f18;
    }
}
