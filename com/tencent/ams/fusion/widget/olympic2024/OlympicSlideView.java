package com.tencent.ams.fusion.widget.olympic2024;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.slideinteractive.SlideInteractiveListener;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OlympicSlideView extends OlympicCarouselView implements SlideGestureViewHelper.ISlideGestureListener {
    static IPatchRedirector $redirector_ = null;
    protected static final int IC_HAND_ANIMATE_X = 20;
    private static final String IC_HAND_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAAG4AAAByCAMAAACFkRQpAAABg1BMVEUAAAAMDAwKCgoGBgYGBgYDAwMEBAQWFhb///8AAAD///////8DAwP////////////////////////////////////////////////////////////////////////////////////////////////////////////5+fn///////////////////////////////////8CAgL////////////////////////////7+/v6+vr////////////19fXz8/P///////8BAQHx8fEBAQGHh4esrKwJCQl4eHj29vbn5+cCAgL5+fnc3NxbW1v7+/uhoaHw8PD09PTt7e3n5+fn5+e8vLyWlpb9/f3v7+/5+fn6+vrt7e3r6+vV1dWHh4f6+vr4+Pjv7+/w8PDv7+/h4eHDw8MDAwPt7e3k5OTo6Oj19fXHx8f5+fmurq6MjIz29vba2tr09PS3t7djY2OHh4fV1dX29vb6+vr19fXLy8v////9/f3g4OCmpqb////5Sf/GAAAAgHRSTlMACAYPDRIUC/0Ly9EXwtnV2+TT3s6/6ObiyOq99cTvzLG5tfftu/Pxzbf5rvuvrODd4RrYxqrX7Kelzc3Js6POzrSoHs8iOTAcPc51HMRVIJszqX57e3E6NuKamI6Aa0oopKGNg3RbQSWYcGVbUU5EKrNwQiwrHRDh02lkc2dkVqOJMGIAAAirSURBVGje7Zp3WxNBEMYh5eJBVBR7RbGgYsNKsKMUJYiIoICAIDaw985H952y2SN3yyWQ+BfvzhbkyfyemZu9vZzUrGpVq1rVf9LX+fGmurr28Tc1/0Mfd9axcrmm/wD8BZLh5X7UVFm/GUQNc0fHUE1V9cYE1pFD7+jIfaypppqAIgGE1tLRkv+asL+tRnDIIkiEYs0noJrqaBw4Dgs41TjjqgNszyGXNrTb6O8TidpElZBcJKAxCnYVqq0iLldnaFdJ1wgHAVkN3vGciUxo0CDTYFWomHHQOLTbjLqJNpPJZCTAysc3r4kEjHFQv+9nIOAqH+DXfAvnUVDf9rQutOYnUikQwatCQj9qbEjj7UML0JqFhUefUikOEKpwPhOzCI5Du9pMNCaChwBNQisIg35oJpmmvHwyxcDK1gtwqPj+93zd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";
    private static final String IC_HAND_TOP_RECT_BASE64 = "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";
    protected static final int IC_HAND_WIDTH = 52;
    private static final String TAG = "OlympicSlideView";
    private SlideGestureViewHelper mSlideGestureViewHelper;
    private BitmapLayer mSlideHandLayer;
    private BitmapLayer mSlideHandTopRectLayer;
    private SlideInteractiveListener mSlideInteractiveListener;

    public OlympicSlideView(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createHandAutoMoveAnimation() {
        if (this.mSlideHandLayer != null && this.mSlideHandTopRectLayer != null) {
            createHandSlideAnimation();
            createHandRectAnimation();
        }
    }

    private void createHandEntranceAnimation() {
        showLayer(this.mTitleLayer);
        showLayer(this.mSubTitleLayer);
        showLayer(this.mSlideHandTopRectLayer);
        BitmapLayer bitmapLayer = this.mSlideHandLayer;
        if (bitmapLayer == null) {
            return;
        }
        AlphaAnimator alphaAnimator = new AlphaAnimator(bitmapLayer, 0.0f, 1.0f);
        alphaAnimator.setDuration(1000L);
        TranslateAnimator translateAnimator = new TranslateAnimator(this.mSlideHandLayer, 0.0f, -Utils.dp2px(20.0f), 0.0f, 0.0f);
        translateAnimator.setPathInterpolator(0.17f, 0.17f, 0.4f, 1.0f);
        translateAnimator.setDuration(1000L);
        GroupAnimator groupAnimator = new GroupAnimator(this.mSlideHandLayer, alphaAnimator, translateAnimator);
        groupAnimator.setStartDelay(300L);
        this.mSlideHandLayer.setAnimator(groupAnimator);
        translateAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    OlympicSlideView.this.createHandAutoMoveAnimation();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        Logger.d(TAG, "createHandEntranceAnimation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createHandRectAnimation() {
        BitmapLayer bitmapLayer = this.mSlideHandTopRectLayer;
        if (bitmapLayer == null) {
            return;
        }
        KeepAnimator keepAnimator = new KeepAnimator(bitmapLayer);
        keepAnimator.setDuration(500L);
        AlphaAnimator alphaAnimator = new AlphaAnimator(this.mSlideHandTopRectLayer, 1.0f, 0.5f);
        alphaAnimator.setDuration(250L);
        alphaAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AlphaAnimator alphaAnimator2 = new AlphaAnimator(OlympicSlideView.this.mSlideHandTopRectLayer, 0.5f, 1.0f);
                alphaAnimator2.setDuration(1000L);
                alphaAnimator2.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                    public void onAnimationFinish() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            OlympicSlideView.this.createHandRectAnimation();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                OlympicSlideView.this.mSlideHandTopRectLayer.setAnimator(alphaAnimator2);
            }
        });
        this.mSlideHandTopRectLayer.setAnimator(new SequentialAnimator(this.mSlideHandTopRectLayer, keepAnimator, alphaAnimator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createHandSlideAnimation() {
        BitmapLayer bitmapLayer = this.mSlideHandLayer;
        if (bitmapLayer == null) {
            return;
        }
        KeepAnimator keepAnimator = new KeepAnimator(bitmapLayer);
        keepAnimator.setDuration(500L);
        AlphaAnimator alphaAnimator = new AlphaAnimator(this.mSlideHandLayer, 1.0f, 0.5f);
        alphaAnimator.setDuration(250L);
        TranslateAnimator translateAnimator = new TranslateAnimator(this.mSlideHandLayer, -Utils.dp2px(20.0f), 0.0f, 0.0f, 0.0f);
        translateAnimator.setPathInterpolator(0.17f, 0.17f, 0.83f, 0.83f);
        translateAnimator.setDuration(250L);
        translateAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AlphaAnimator alphaAnimator2 = new AlphaAnimator(OlympicSlideView.this.mSlideHandLayer, 0.5f, 1.0f);
                alphaAnimator2.setDuration(1000L);
                TranslateAnimator translateAnimator2 = new TranslateAnimator(OlympicSlideView.this.mSlideHandLayer, 0.0f, -Utils.dp2px(20.0f), 0.0f, 0.0f);
                translateAnimator2.setDuration(1000L);
                translateAnimator2.setPathInterpolator(0.17f, 0.17f, 0.4f, 1.0f);
                translateAnimator2.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView.3.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                    public void onAnimationFinish() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            OlympicSlideView.this.createHandSlideAnimation();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                OlympicSlideView.this.mSlideHandLayer.setAnimator(new GroupAnimator(OlympicSlideView.this.mSlideHandLayer, alphaAnimator2, translateAnimator2));
            }
        });
        this.mSlideHandLayer.setAnimator(new SequentialAnimator(this.mSlideHandLayer, keepAnimator, new GroupAnimator(this.mSlideHandLayer, alphaAnimator, translateAnimator)));
    }

    private BitmapLayer createSlideHandLayer() {
        int relativeSize375 = Utils.getRelativeSize375(getContext(), 52);
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(IC_HAND_BASE64, relativeSize375, relativeSize375));
        bitmapLayer.setWidth(relativeSize375);
        bitmapLayer.setHeight(relativeSize375);
        bitmapLayer.setX(getHandIconX());
        bitmapLayer.setY(getHandIconY());
        bitmapLayer.setAnimator(new KeepAnimator(bitmapLayer));
        return bitmapLayer;
    }

    private BitmapLayer createSlideHandTopRectLayer() {
        int relativeSize375 = Utils.getRelativeSize375(getContext(), 50);
        int relativeSize3752 = Utils.getRelativeSize375(getContext(), 16);
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64StringSafe(IC_HAND_TOP_RECT_BASE64, relativeSize375, relativeSize3752));
        bitmapLayer.setWidth(relativeSize375);
        bitmapLayer.setHeight(relativeSize3752);
        bitmapLayer.setX((getHandIconX() - Utils.dp2px(20.0f)) + Utils.dp2px(5.0f));
        bitmapLayer.setY(getHandIconY() + Utils.dp2px(1.0f));
        bitmapLayer.setAnimator(new KeepAnimator(bitmapLayer));
        return bitmapLayer;
    }

    private int getHandIconX() {
        return (int) (getTextX() - (Utils.dp2px(84.0f) / 2.0f));
    }

    private int getHandIconY() {
        return (int) (((getSubTextY() - this.mSubTitleTextSize) - Utils.dp2px(3.0f)) - (Utils.dp2px(52.0f) / 2.0f));
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    protected void hideBottomIconAndTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.mTitleLayer != null && this.mSubTitleLayer != null && this.mSlideHandLayer != null && this.mSlideHandTopRectLayer != null) {
            setEnabled(false);
            Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicSlideView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicSlideView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AlphaAnimator alphaAnimator = new AlphaAnimator(OlympicSlideView.this.mTitleLayer, 1.0f, 0.0f);
                    AlphaAnimator alphaAnimator2 = new AlphaAnimator(OlympicSlideView.this.mSubTitleLayer, 1.0f, 0.0f);
                    AlphaAnimator alphaAnimator3 = new AlphaAnimator(OlympicSlideView.this.mSlideHandLayer, 1.0f, 0.0f);
                    AlphaAnimator alphaAnimator4 = new AlphaAnimator(OlympicSlideView.this.mSlideHandTopRectLayer, 1.0f, 0.0f);
                    alphaAnimator.setDuration(300L);
                    alphaAnimator2.setDuration(300L);
                    alphaAnimator3.setDuration(300L);
                    alphaAnimator4.setDuration(300L);
                    OlympicSlideView.this.mTitleLayer.setAnimator(alphaAnimator);
                    OlympicSlideView.this.mSubTitleLayer.setAnimator(alphaAnimator2);
                    OlympicSlideView.this.mSlideHandLayer.setAnimator(alphaAnimator3);
                    OlympicSlideView.this.mSlideHandTopRectLayer.setAnimator(alphaAnimator4);
                }
            }, 500L);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    protected void initViews(@NonNull Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        SlideGestureViewHelper slideGestureViewHelper = new SlideGestureViewHelper(context, this);
        this.mSlideGestureViewHelper = slideGestureViewHelper;
        slideGestureViewHelper.setSlideGestureListener(this);
        this.mSlideGestureViewHelper.setGestureSlideDirection(1);
        setEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.mSlideGestureViewHelper.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Logger.d(TAG, "onDetachedFromWindow, recycle listeners");
        this.mSlideGestureViewHelper.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureResult(int i3, View view, boolean z16, float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), view, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        Logger.d("OlympicSlideViewdispatchDrawGestureResultEvent " + z16);
        if (this.mInteractiveSucceed) {
            Logger.w("OlympicSlideViewonGestureResult return ");
            return;
        }
        SlideInteractiveListener slideInteractiveListener = this.mSlideInteractiveListener;
        if (slideInteractiveListener != null) {
            slideInteractiveListener.onGestureResult(z16, view, f16, f17);
        } else {
            Logger.e(TAG, "onGestureResult fail listener null");
        }
        if (z16 && !this.mInteractiveSucceed) {
            this.mInteractiveSucceed = true;
            setEnabled(false);
            this.mGalleryView.onInteractiveSucceed();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onGestureStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        SlideInteractiveListener slideInteractiveListener = this.mSlideInteractiveListener;
        if (slideInteractiveListener != null) {
            slideInteractiveListener.onGestureStart();
        } else {
            Logger.e(TAG, "onGestureStart fail listener null");
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper.ISlideGestureListener
    public void onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, (Object) motionEvent);
            return;
        }
        SlideInteractiveListener slideInteractiveListener = this.mSlideInteractiveListener;
        if (slideInteractiveListener != null) {
            slideInteractiveListener.onTouch(view, motionEvent);
        } else {
            Logger.e(TAG, "onTouch fail listener null");
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            super.setEnabled(z16);
            this.mSlideGestureViewHelper.setEnabled(z16);
        }
    }

    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mSlideGestureViewHelper.setGestureColor(str);
        }
    }

    public void setGestureHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mSlideGestureViewHelper.setGestureHotArea(i3, i16, i17, i18);
        }
    }

    public void setGestureSlideDirection(@SlideGestureViewHelper.SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mSlideGestureViewHelper.setGestureSlideDirection(i3);
        }
    }

    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mSlideGestureViewHelper.setGestureSlideValidHeightDp(i3);
        }
    }

    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
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

    public void setSlideInteractiveListener(SlideInteractiveListener slideInteractiveListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) slideInteractiveListener);
        } else {
            this.mSlideInteractiveListener = slideInteractiveListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        PathShapeLayer createBgShaderLayer = createBgShaderLayer();
        this.mBgShaderLayer = createBgShaderLayer;
        arrayList.add(createBgShaderLayer);
        TextLayer createTitleTextLayer = createTitleTextLayer();
        this.mTitleLayer = createTitleTextLayer;
        arrayList.add(createTitleTextLayer);
        TextLayer createSubTitleTextLayer = createSubTitleTextLayer();
        this.mSubTitleLayer = createSubTitleTextLayer;
        arrayList.add(createSubTitleTextLayer);
        BitmapLayer createSlideHandLayer = createSlideHandLayer();
        this.mSlideHandLayer = createSlideHandLayer;
        arrayList.add(createSlideHandLayer);
        BitmapLayer createSlideHandTopRectLayer = createSlideHandTopRectLayer();
        this.mSlideHandTopRectLayer = createSlideHandTopRectLayer;
        arrayList.add(createSlideHandTopRectLayer);
        createHandEntranceAnimation();
        GroupLayer groupLayer = new GroupLayer((AnimatorLayer[]) arrayList.toArray(new AnimatorLayer[0]));
        this.mAnimatableView.clearLayers();
        this.mAnimatableView.addLayer(groupLayer);
        this.mAnimatableView.startAnimation();
        this.mGalleryView.start();
        setEnabled(true);
        Logger.i(TAG, "start() ...");
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView
    public void stopInteractive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        setEnabled(false);
        SlideGestureViewHelper slideGestureViewHelper = this.mSlideGestureViewHelper;
        if (slideGestureViewHelper != null) {
            slideGestureViewHelper.stop();
        }
    }
}
