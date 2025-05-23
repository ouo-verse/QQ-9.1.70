package com.tencent.ams.fusion.widget.olympic2024;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.apng.APNGDrawable;
import com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.FileLoader;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class OlympicCarouselView extends FrameLayout implements GalleryItemListener {
    static IPatchRedirector $redirector_ = null;
    protected static final int ANIMATION_INTERVAL = 300;
    protected static final int DEFAULT_BG_SHADER_COLOR_END;
    protected static final int DEFAULT_BG_SHADER_COLOR_START;
    protected static final int DEFAULT_BG_SHADER_HEIGHT = 240;
    protected static final int DEFAULT_BOTTOM_MARGIN = 60;
    protected static final int FIRST_CARD_KEEP_TIME = 660;
    protected static final int HAND_ENTRANCE_INTERVAL = 1000;
    protected static final int HAND_KEEP_INTERVAL = 500;
    protected static final int HAND_MOVE_INTERVAL = 250;
    protected static final int SUBTITLE_TEXT_COLOR;
    protected static final int SUBTITLE_TEXT_SIZE = 16;
    private static final String TAG = "OlympicCarouselView";
    protected static final int TEXT_MAX_WIDTH = 230;
    protected static final int TITLE_TEXT_COLOR = -1;
    protected static final int TITLE_TEXT_SIZE = 20;
    protected AnimatorView mAnimatableView;
    protected PathShapeLayer mBgShaderLayer;
    protected int mBottomMarginDp;
    private String[] mFireWorksImagePath;
    private int mGalleryType;
    protected OlympicGalleryView mGalleryView;
    protected volatile boolean mInteractiveSucceed;
    protected int mLargerTextWidth;
    private ImageView mLeftSideFloatView;
    private volatile OlympicGalleryListener mListener;
    private ImageView mMovableImg;
    private final Runnable mMovableViewAnimationTask;
    private ImageView mRightSideFloatView;
    protected TextLayer mSubTitleLayer;
    protected String mSubTitleText;
    protected float mSubTitleTextSize;
    protected TextLayer mTitleLayer;
    protected String mTitleText;
    protected float mTitleTextSize;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        SUBTITLE_TEXT_COLOR = Color.parseColor("#CCFFFFFF");
        DEFAULT_BG_SHADER_COLOR_START = Color.parseColor("#00000000");
        DEFAULT_BG_SHADER_COLOR_END = Color.parseColor(GameCenterVideoViewController.GRAY_MASK);
    }

    public OlympicCarouselView(@NonNull Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.mGalleryType = 0;
        this.mTitleTextSize = Utils.dp2px(20.0f);
        this.mSubTitleTextSize = Utils.dp2px(16.0f);
        this.mBottomMarginDp = 60;
        this.mLargerTextWidth = 0;
        this.mFireWorksImagePath = new String[2];
        this.mInteractiveSucceed = false;
        this.mMovableViewAnimationTask = new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicCarouselView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ImageView imageView = OlympicCarouselView.this.mMovableImg;
                    if (imageView == null) {
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, -(imageView.getLeft() + imageView.getWidth()));
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, c.f123400v, 1.0f, 0.0f);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.9f);
                    ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.9f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(300L);
                    animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
                    animatorSet.start();
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.mGalleryType = i3;
        AnimatorView animatorView = new AnimatorView(context);
        this.mAnimatableView = animatorView;
        addView(animatorView);
        OlympicGalleryView olympicGalleryView = new OlympicGalleryView(context, i3);
        this.mGalleryView = olympicGalleryView;
        olympicGalleryView.setEndAnimationListener(this);
        addView(this.mGalleryView);
        initViews(context, i3);
    }

    private TextLayer createTextLayer(String str, int i3, float f16, float f17, boolean z16) {
        Logger.i(TAG, "createTextLayer, text:" + str + ", y:" + f17);
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        setTextMaxWidth(textLayer, str);
        textLayer.setX((float) getTextX());
        textLayer.setY(f17);
        textLayer.setTextBold(z16);
        textLayer.setEllipsizeAtEnd(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private APNGDrawable getApngDrawable(String str) {
        APNGDrawable aPNGDrawable;
        APNGDrawable aPNGDrawable2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            aPNGDrawable = new APNGDrawable(new FileLoader(str), getHandler());
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            aPNGDrawable.setLoopLimit(1);
            return aPNGDrawable;
        } catch (Throwable th6) {
            th = th6;
            aPNGDrawable2 = aPNGDrawable;
            Logger.e(TAG, "apng create fail:", th);
            return aPNGDrawable2;
        }
    }

    private void setTextMaxWidth(TextLayer textLayer, String str) {
        if (textLayer != null && textLayer.getPaint() != null) {
            float measureText = textLayer.getPaint().measureText(str);
            if (measureText < 0.0f) {
                measureText = 0.0f;
            }
            int min = (int) Math.min(measureText, Utils.getRelativeSize375(getContext(), 230));
            textLayer.setWidth(min);
            if (min > this.mLargerTextWidth) {
                this.mLargerTextWidth = min;
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void afterItemSwitch(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        Logger.i(TAG, "[afterItemSwitch] current" + i3 + " isImmediately :" + z16);
        if (i3 == this.mGalleryView.getItemCount() - 1 || z16) {
            this.mGalleryView.playTransitionPageAnimation();
            hideBottomIconAndTextLayer();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void beforeItemSwitch(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        Logger.i(TAG, "[beforeItemSwitch] current" + i3);
        this.mGalleryView.changeItemAlphaAndRotationWhenShow(i3, z16);
        if (i3 == 0 && z16) {
            Utils.removeCallbacks(this.mMovableViewAnimationTask);
            Utils.runOnUiThread(this.mMovableViewAnimationTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeText(TextLayer textLayer, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) textLayer, (Object) str);
        } else if (textLayer != null && !TextUtils.isEmpty(str)) {
            setTextMaxWidth(textLayer, str);
            textLayer.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PathShapeLayer createBgShaderLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (PathShapeLayer) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        int dp2px = (int) Utils.dp2px(240.0f);
        int[] iArr = {DEFAULT_BG_SHADER_COLOR_START, DEFAULT_BG_SHADER_COLOR_END};
        int width = getWidth();
        int height = getHeight();
        float f16 = height - dp2px;
        float f17 = height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f16, 0.0f, f17, iArr, (float[]) null, Shader.TileMode.MIRROR);
        Path path = new Path();
        path.moveTo(0.0f, f16);
        path.lineTo(0.0f, f17);
        float f18 = width;
        path.lineTo(f18, f17);
        path.lineTo(f18, f16);
        path.lineTo(0.0f, f16);
        PathShapeLayer pathShapeLayer = new PathShapeLayer(path, linearGradient, Paint.Style.FILL);
        pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        return pathShapeLayer;
    }

    protected void createLeftSideFloatView() {
        APNGDrawable apngDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        String str = this.mFireWorksImagePath[0];
        if (TextUtils.isEmpty(str)) {
            Logger.e(TAG, "invalid left float view path");
            return;
        }
        if (this.mLeftSideFloatView != null || (apngDrawable = getApngDrawable(str)) == null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.mLeftSideFloatView = imageView;
        imageView.setImageDrawable(apngDrawable);
        apngDrawable.registerAnimationCallback(new Animatable2.AnimationCallback(apngDrawable) { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ APNGDrawable val$apngDrawable;

            {
                this.val$apngDrawable = apngDrawable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicCarouselView.this, (Object) apngDrawable);
                }
            }

            @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) drawable);
                } else {
                    super.onAnimationEnd(drawable);
                    Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            APNGDrawable aPNGDrawable = AnonymousClass3.this.val$apngDrawable;
                            if (aPNGDrawable != null) {
                                aPNGDrawable.stop();
                                AnonymousClass3.this.val$apngDrawable.clearAnimationCallbacks();
                            }
                            if (OlympicCarouselView.this.mLeftSideFloatView != null) {
                                OlympicCarouselView.this.mLeftSideFloatView.setVisibility(8);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) drawable);
                } else {
                    super.onAnimationStart(drawable);
                }
            }
        });
        int relativeSize375 = Utils.getRelativeSize375(getContext(), 180);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relativeSize375, relativeSize375);
        layoutParams.topMargin = (int) ((Utils.getScreenHeight(getContext()) * 546.0d) / 812.0d);
        layoutParams.leftMargin = (int) (-Utils.dp2px(28.0f));
        addView(this.mLeftSideFloatView, layoutParams);
    }

    protected void createMovableViewAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (this.mMovableImg == null) {
                return;
            }
            Utils.runOnUiThread(this.mMovableViewAnimationTask, 960L);
        }
    }

    protected void createRightSideFloatView() {
        APNGDrawable apngDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        String str = this.mFireWorksImagePath[1];
        if (TextUtils.isEmpty(str)) {
            Logger.e(TAG, "invalid right float view path");
            return;
        }
        if (this.mRightSideFloatView != null || (apngDrawable = getApngDrawable(str)) == null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.mRightSideFloatView = imageView;
        imageView.setImageDrawable(apngDrawable);
        apngDrawable.registerAnimationCallback(new Animatable2.AnimationCallback(apngDrawable) { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ APNGDrawable val$apngDrawable;

            {
                this.val$apngDrawable = apngDrawable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicCarouselView.this, (Object) apngDrawable);
                }
            }

            @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) drawable);
                } else {
                    super.onAnimationEnd(drawable);
                    Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            APNGDrawable aPNGDrawable = AnonymousClass2.this.val$apngDrawable;
                            if (aPNGDrawable != null) {
                                aPNGDrawable.stop();
                                AnonymousClass2.this.val$apngDrawable.clearAnimationCallbacks();
                            }
                            if (OlympicCarouselView.this.mRightSideFloatView != null) {
                                OlympicCarouselView.this.mRightSideFloatView.setVisibility(8);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) drawable);
                } else {
                    super.onAnimationStart(drawable);
                }
            }
        });
        int relativeSize375 = Utils.getRelativeSize375(getContext(), 140);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relativeSize375, relativeSize375);
        layoutParams.leftMargin = Utils.getRelativeSize375(getContext(), 252);
        int screenHeight = (int) ((Utils.getScreenHeight(getContext()) * 171.0f) / 812.0f);
        if (this.mGalleryType == 1) {
            screenHeight = (int) ((Utils.getScreenHeight(getContext()) * 100.0f) / 812.0f);
        }
        layoutParams.topMargin = screenHeight;
        addView(this.mRightSideFloatView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextLayer createSubTitleTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TextLayer) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return createTextLayer(this.mSubTitleText, SUBTITLE_TEXT_COLOR, this.mSubTitleTextSize, getSubTextY(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextLayer createTitleTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TextLayer) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return createTextLayer(this.mTitleText, -1, this.mTitleTextSize, getTileTextY(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSubTextY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return (int) (getHeight() - Utils.dp2px(this.mBottomMarginDp));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTextX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return (int) (((getWidth() - this.mLargerTextWidth) + Utils.dp2px(62.0f)) / 2.0f);
    }

    protected int getTileTextY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return (int) ((getSubTextY() - this.mTitleTextSize) - Utils.dp2px(5.0f));
    }

    protected abstract void hideBottomIconAndTextLayer();

    protected abstract void initViews(@NonNull Context context, int i3);

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onEndAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onEndCardAnimFinish();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onEndAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onEndCardAnimStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onItemSwitch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            createRightSideFloatView();
            createMovableViewAnimation();
            Utils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.olympic2024.OlympicCarouselView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OlympicCarouselView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        OlympicCarouselView.this.createLeftSideFloatView();
                    }
                }
            }, 300L);
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onItemSwitch(i3);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mAnimatableView.isUserStarted() && !this.mInteractiveSucceed) {
            start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onVideoItemComplete(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onVideoItemComplete(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onVideoItemError(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onVideoItemError(i3, i16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onVideoItemPause(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onVideoItemPause(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onVideoItemPlayUpdate(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onVideoItemPlayUpdate(i3, j3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onVideoItemResume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onVideoItemResume(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympic2024.GalleryItemListener
    public void onVideoItemStart(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        OlympicGalleryListener olympicGalleryListener = this.mListener;
        if (olympicGalleryListener != null) {
            olympicGalleryListener.onVideoItemStart(i3, j3);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        AnimatorView animatorView = this.mAnimatableView;
        if (animatorView != null) {
            animatorView.pauseAnimation();
        }
        OlympicGalleryView olympicGalleryView = this.mGalleryView;
        if (olympicGalleryView != null) {
            olympicGalleryView.pause();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        AnimatorView animatorView = this.mAnimatableView;
        if (animatorView != null) {
            animatorView.resumeAnimation();
        }
        OlympicGalleryView olympicGalleryView = this.mGalleryView;
        if (olympicGalleryView != null) {
            olympicGalleryView.resume();
        }
    }

    public void setItems(List<GalleryItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.mGalleryView.setItems(list);
        }
    }

    public void setMovableImagePath(String str) {
        APNGDrawable apngDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (this.mGalleryType == 1 || (apngDrawable = getApngDrawable(str)) == null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.mMovableImg = imageView;
        imageView.setImageDrawable(apngDrawable);
        int relativeSize375 = Utils.getRelativeSize375(getContext(), 100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relativeSize375, relativeSize375);
        layoutParams.leftMargin = (int) Utils.dp2px(25.0f);
        layoutParams.topMargin = (int) ((Utils.getScreenHeight(getContext()) * 453.0f) / 812.0f);
        addView(this.mMovableImg, layoutParams);
        this.mMovableImg.bringToFront();
    }

    public void setOlympicGalleryListener(OlympicGalleryListener olympicGalleryListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) olympicGalleryListener);
        } else {
            this.mListener = olympicGalleryListener;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.mSubTitleText = str;
        TextLayer textLayer = this.mSubTitleLayer;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void setSubTitleBottomMarginDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mBottomMarginDp = i3;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.mTitleText = str;
        TextLayer textLayer = this.mTitleLayer;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void setUnMovableImagePaths(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) strArr);
            return;
        }
        if (strArr != null && strArr.length != 0) {
            for (int i3 = 0; i3 < strArr.length && i3 <= 1; i3++) {
                this.mFireWorksImagePath[i3] = strArr[i3];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) animatorLayer);
        } else {
            if (animatorLayer == null) {
                return;
            }
            AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 0.0f, 1.0f);
            alphaAnimator.setDuration(1000L);
            alphaAnimator.setStartDelay(300L);
            animatorLayer.setAnimator(alphaAnimator);
        }
    }

    public abstract void start();

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        stopInteractive();
        AnimatorView animatorView = this.mAnimatableView;
        if (animatorView != null) {
            animatorView.stopAnimation();
        }
        OlympicGalleryView olympicGalleryView = this.mGalleryView;
        if (olympicGalleryView != null) {
            olympicGalleryView.stop();
        }
        if (this.mListener != null) {
            this.mListener = null;
        }
        this.mInteractiveSucceed = false;
    }

    public abstract void stopInteractive();

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLayer(AnimatorLayer animatorLayer, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, animatorLayer, Float.valueOf(f16));
        } else {
            if (animatorLayer == null) {
                return;
            }
            AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 0.0f, f16);
            alphaAnimator.setDuration(1000L);
            alphaAnimator.setStartDelay(300L);
            animatorLayer.setAnimator(alphaAnimator);
        }
    }
}
