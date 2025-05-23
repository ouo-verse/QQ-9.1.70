package com.tencent.ams.fusion.widget.longpress;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.CircleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RingShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class LongPressAnimationHelper {
    static IPatchRedirector $redirector_ = null;
    private static final float ANIMATOR_VIEW_HEIGHT_DP = 240.0f;
    private static final int BIG_CIRCLE_COLOR = 872415231;
    private static final float BIG_CIRCLE_RADIUS_DP = 33.0f;
    private static final float BIG_CIRCLE_SCALE_RADIUS_DP = 28.0f;
    private static final int BREATHING_ANIMATION_DURANTION_STEP_1 = 320;
    private static final int BREATHING_ANIMATION_DURANTION_STEP_2 = 480;
    private static final float CIRCEL_CENTER_Y_DP = 96.0f;
    private static final int END_HIDE_ANIMATION_DURATION = 80;
    private static final int HEART_DEFAULT_COLOR = -1011541;
    private static final float HEART_HEIGHT_DP = 160.0f;
    private static final int HEART_HIDE_ANIMATION_DURATION = 40;
    private static final String HEART_PNG_BASE64 = "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";
    private static final int HEART_SHOW_ANIMATION_DURATION = 80;
    private static final String HEART_SVG_PATH_DATA = "M310,115.974C310,65.273 270.75,24 222.575,24C198.775,24 176.262,34.412 160,52.159C143.712,34.412 121.175,24 97.425,24C49.225,24 10,65.248 10,115.974C10,117.668 10.163,119.188 10.288,120.445C10.262,120.844 10.25,121.255 10.25,121.691C10.25,130.658 12.387,140.534 16.625,151.008C16.75,151.382 16.887,151.755 17.05,152.092C43.675,216.878 146.225,291.417 150.587,294.842C156.002,299.085 163.638,299.049 169.012,294.755C172.75,291.803 260.212,227.975 294.925,167.585C296.25,165.542 297.225,163.574 298.1,161.868C298.375,161.32 298.612,160.785 298.913,160.249L299.013,160C299.125,159.793 299.25,159.594 299.388,159.402C301.475,155.292 303.138,151.481 304.45,147.77C308.05,138.193 309.825,129.674 309.825,121.716C309.825,121.093 309.8,120.558 309.75,120.097C309.875,119.063 310,117.656 310,115.974Z";
    private static final float HEART_VIEW_PORT_SIZE = 320.0f;
    private static final float HEART_WIDTH_DP = 160.0f;
    private static final int PROGRESS_RING_STROKE_WIDTH_DP = 5;
    private static final int SMALL_CIRCLE_COLOR = -1;
    private static final float SMALL_CIRCLE_RADIUS_DP = 10.5f;
    private static final float SMALL_CIRCLE_SCALE_RADIUS_DP = 12.0f;
    private static final float SUB_TITLE_Y_FROM_CIRCLE_CENTER_DP = 93.0f;
    private static final String TAG = "QixiAnimationHelper";
    private static final float TITLE_Y_FROM_CIRCLE_CENTER_DP = 69.0f;
    private AnimatorView mAnimatorView;
    private Animator mBigCircleBreathingAnimator;
    private AnimatorLayer mBigCircleLayer;
    private Context mContext;
    private int mHearColor;
    private AnimatorLayer mHeartLayer;
    private Animator mProgressAnimator;
    private AnimatorLayer mProgressCircleLayer;
    private Animator mSmallCircleBreathingAnimator;
    private AnimatorLayer mSmallCircleLayer;
    private String mSubTitleText;
    private TextLayer mSubTitleTextLayer;
    private String mTitleText;
    private TextLayer mTitleTextLayer;

    public LongPressAnimationHelper(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mHearColor = HEART_DEFAULT_COLOR;
            this.mContext = context;
        }
    }

    private Animator createBigCircleBreathingAnimator(AnimatorLayer animatorLayer) {
        Animator animator = this.mBigCircleBreathingAnimator;
        if (animator == null) {
            SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
            ScaleAnimator scaleAnimator = new ScaleAnimator(animatorLayer, 0.8484849f, 1.0f, 0.8484849f, 1.0f);
            scaleAnimator.setDuration(320L);
            scaleAnimator.setPathInterpolator(0.17f, -0.12f, 0.67f, 1.0f);
            sequentialAnimator.addAnimator(scaleAnimator);
            ScaleAnimator scaleAnimator2 = new ScaleAnimator(animatorLayer, 1.0f, 0.8484849f, 1.0f, 0.8484849f);
            scaleAnimator2.setDuration(480L);
            sequentialAnimator.addAnimator(scaleAnimator2);
            sequentialAnimator.setRepeatMode(1);
            sequentialAnimator.setRepeatCount(0);
            this.mBigCircleBreathingAnimator = sequentialAnimator;
        } else {
            animator.reset();
        }
        return this.mBigCircleBreathingAnimator;
    }

    private AnimatorLayer createBigCircleLayer(boolean z16) {
        Animator createKeepAnimator;
        AnimatorLayer animatorLayer = this.mBigCircleLayer;
        if (animatorLayer == null) {
            this.mBigCircleLayer = new CircleShapeLayer(getScreenWidth() / 2.0f, dp2px(CIRCEL_CENTER_Y_DP), dp2px(BIG_CIRCLE_RADIUS_DP), BIG_CIRCLE_COLOR).setShadowLayer(dp2px(5.0f), 1.0f, 1.0f, Utils.buildColorFromARGB(0.1f, 0.0f, 0.0f, 0.0f));
        } else {
            animatorLayer.reset();
        }
        AnimatorLayer animatorLayer2 = this.mBigCircleLayer;
        if (z16) {
            createKeepAnimator = createBigCircleBreathingAnimator(animatorLayer2);
        } else {
            createKeepAnimator = createKeepAnimator(animatorLayer2);
        }
        animatorLayer2.setAnimator(createKeepAnimator);
        return this.mBigCircleLayer;
    }

    private Animator createHeartAlphaAnimator(AnimatorLayer animatorLayer, boolean z16, int i3) {
        if (z16) {
            return createHeartShowAnimator(animatorLayer, i3);
        }
        return createHideAnimator(animatorLayer, i3);
    }

    private Animator createHeartAnimator(AnimatorLayer animatorLayer) {
        SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
        sequentialAnimator.addAnimator(createHeartScaleAnimator(animatorLayer, 1.0f, 1.1875f, 1.0f, 1.1875f, 80, true));
        sequentialAnimator.addAnimator(createHeartScaleAnimator(animatorLayer, 1.1875f, 1.0f, 1.1875f, 1.0f, 200, false));
        sequentialAnimator.setRepeatMode(1);
        sequentialAnimator.setRepeatCount(0);
        return sequentialAnimator;
    }

    private AnimatorLayer createHeartLayer(boolean z16) {
        int i3;
        AnimatorLayer animatorLayer = this.mHeartLayer;
        if (animatorLayer == null) {
            int dp2px = (int) dp2px(160.0f);
            int dp2px2 = (int) dp2px(160.0f);
            BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromBase64String(HEART_PNG_BASE64, dp2px, dp2px2));
            bitmapLayer.setTintColor(this.mHearColor);
            bitmapLayer.setCenterX(getScreenWidth() / 2);
            bitmapLayer.setCenterY(dp2px(CIRCEL_CENTER_Y_DP));
            bitmapLayer.setWidth(dp2px);
            bitmapLayer.setHeight(dp2px2);
            this.mHeartLayer = bitmapLayer;
        } else {
            animatorLayer.reset();
        }
        AnimatorLayer animatorLayer2 = this.mHeartLayer;
        if (z16) {
            i3 = 80;
        } else {
            i3 = 40;
        }
        animatorLayer2.setAnimator(createHeartAlphaAnimator(animatorLayer2, z16, i3));
        return this.mHeartLayer;
    }

    private Animator createHeartScaleAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19, int i3, boolean z16) {
        ScaleAnimator scaleAnimator = new ScaleAnimator(animatorLayer, f16, f17, f18, f19);
        scaleAnimator.setDuration(i3);
        if (z16) {
            scaleAnimator.setPathInterpolator(0.17f, 0.12f, 0.67f, 1.0f);
        }
        return scaleAnimator;
    }

    private Animator createHeartShowAnimator(AnimatorLayer animatorLayer, int i3) {
        GroupAnimator groupAnimator = new GroupAnimator(animatorLayer, new AlphaAnimator(animatorLayer, 0.0f, 1.0f), new ScaleAnimator(animatorLayer, 0.0625f, 1.0f, 0.0625f, 1.0f));
        groupAnimator.setDuration(i3);
        groupAnimator.setAnimatorListener(new Animator.AnimatorListener(animatorLayer) { // from class: com.tencent.ams.fusion.widget.longpress.LongPressAnimationHelper.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ AnimatorLayer val$layer;

            {
                this.val$layer = animatorLayer;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LongPressAnimationHelper.this, (Object) animatorLayer);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    LongPressAnimationHelper.this.playHeartAnimationPart2(this.val$layer);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        return groupAnimator;
    }

    private Animator createHideAnimator(AnimatorLayer animatorLayer, int i3) {
        AlphaAnimator alphaAnimator = new AlphaAnimator(animatorLayer, 1.0f, 0.0f);
        alphaAnimator.setDuration(i3);
        return alphaAnimator;
    }

    private Animator createKeepAnimator(AnimatorLayer animatorLayer) {
        return new KeepAnimator(animatorLayer);
    }

    private AnimatorLayer createProgressLayer(int i3, boolean z16, Animator.AnimatorListener animatorListener, Animator.AnimatorProgressListener animatorProgressListener) {
        AnimatorLayer animatorLayer = this.mProgressCircleLayer;
        if (animatorLayer == null) {
            this.mProgressCircleLayer = new RingShapeLayer(getScreenWidth() / 2.0f, dp2px(CIRCEL_CENTER_Y_DP), dp2px(30.5f), -1, dp2px(5.0f)).setStrokeCap(Paint.Cap.ROUND);
        } else {
            animatorLayer.reset();
        }
        if (z16) {
            Animator animator = this.mProgressAnimator;
            if (animator == null) {
                ProgressAnimator progressAnimator = new ProgressAnimator(this.mProgressCircleLayer, 0.0f, 1.0f);
                this.mProgressAnimator = progressAnimator;
                progressAnimator.setDuration(i3);
                this.mProgressAnimator.setAnimatorListener(animatorListener);
                this.mProgressAnimator.setAnimatorProgressListener(animatorProgressListener);
            } else {
                animator.reset();
            }
            this.mProgressCircleLayer.setAnimator(this.mProgressAnimator);
        } else {
            AlphaAnimator alphaAnimator = new AlphaAnimator(this.mProgressCircleLayer, 1.0f, 0.0f);
            alphaAnimator.setDuration(i3);
            alphaAnimator.setAnimatorListener(animatorListener);
            this.mProgressCircleLayer.setAnimator(alphaAnimator);
        }
        return this.mProgressCircleLayer;
    }

    private Animator createSmallCircleBreathingAnimator(AnimatorLayer animatorLayer) {
        Animator animator = this.mSmallCircleBreathingAnimator;
        if (animator == null) {
            SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
            ScaleAnimator scaleAnimator = new ScaleAnimator(animatorLayer, 1.1428572f, 1.0f, 1.1428572f, 1.0f);
            scaleAnimator.setDuration(320L);
            scaleAnimator.setPathInterpolator(0.17f, -0.12f, 0.67f, 1.0f);
            sequentialAnimator.addAnimator(scaleAnimator);
            ScaleAnimator scaleAnimator2 = new ScaleAnimator(animatorLayer, 1.0f, 1.1428572f, 1.0f, 1.1428572f);
            scaleAnimator2.setDuration(480L);
            sequentialAnimator.addAnimator(scaleAnimator2);
            sequentialAnimator.setRepeatMode(1);
            sequentialAnimator.setRepeatCount(0);
            this.mSmallCircleBreathingAnimator = sequentialAnimator;
        } else {
            animator.reset();
        }
        return this.mSmallCircleBreathingAnimator;
    }

    private AnimatorLayer createSmallCircleLayer(boolean z16) {
        Animator createKeepAnimator;
        AnimatorLayer animatorLayer = this.mSmallCircleLayer;
        if (animatorLayer == null) {
            this.mSmallCircleLayer = new CircleShapeLayer(getScreenWidth() / 2, dp2px(CIRCEL_CENTER_Y_DP), dp2px(SMALL_CIRCLE_RADIUS_DP), -1);
        } else {
            animatorLayer.reset();
        }
        AnimatorLayer animatorLayer2 = this.mSmallCircleLayer;
        if (z16) {
            createKeepAnimator = createSmallCircleBreathingAnimator(animatorLayer2);
        } else {
            createKeepAnimator = createKeepAnimator(animatorLayer2);
        }
        animatorLayer2.setAnimator(createKeepAnimator);
        return this.mSmallCircleLayer;
    }

    private AnimatorLayer createSubTitleLayer() {
        TextLayer textLayer = this.mSubTitleTextLayer;
        if (textLayer == null) {
            TextLayer textLayer2 = new TextLayer(this.mSubTitleText, -1, dp2px(14.0f));
            this.mSubTitleTextLayer = textLayer2;
            textLayer2.setTextAlign(Paint.Align.CENTER);
            this.mSubTitleTextLayer.setX(getScreenWidth() / 2);
            this.mSubTitleTextLayer.setY(dp2px(189.0f));
            this.mSubTitleTextLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
            TextLayer textLayer3 = this.mSubTitleTextLayer;
            textLayer3.setAnimator(new KeepAnimator(textLayer3));
        } else {
            textLayer.reset();
        }
        return this.mSubTitleTextLayer;
    }

    private AnimatorLayer createTitleLayer() {
        TextLayer textLayer = this.mTitleTextLayer;
        if (textLayer == null) {
            TextLayer textLayer2 = new TextLayer(this.mTitleText, -1, dp2px(18.0f));
            this.mTitleTextLayer = textLayer2;
            textLayer2.setTextAlign(Paint.Align.CENTER);
            this.mTitleTextLayer.setX(getScreenWidth() / 2);
            this.mTitleTextLayer.setY(dp2px(165.0f));
            this.mTitleTextLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
            this.mTitleTextLayer.setTextBold(true);
            TextLayer textLayer3 = this.mTitleTextLayer;
            textLayer3.setAnimator(new KeepAnimator(textLayer3));
        } else {
            textLayer.reset();
        }
        return this.mTitleTextLayer;
    }

    private float dp2px(float f16) {
        return Utils.dp2px(f16);
    }

    private int getScreenWidth() {
        return Utils.getScreenWidth(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playHeartAnimationPart2(AnimatorLayer animatorLayer) {
        animatorLayer.setAnimator(createHeartAnimator(animatorLayer));
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.startAnimation();
        }
    }

    public AnimatorView createAnimView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AnimatorView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        AnimatorView animatorView = new AnimatorView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) dp2px(240.0f));
        layoutParams.gravity = 80;
        animatorView.setLayoutParams(layoutParams);
        this.mAnimatorView = animatorView;
        return animatorView;
    }

    public float getLongPressAreaSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return dp2px(BIG_CIRCLE_RADIUS_DP) * 2.0f;
    }

    public PointF getLongPressCenterPoint(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PointF) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        }
        if (view == null) {
            return null;
        }
        return new PointF(getScreenWidth() / 2.0f, view.getHeight() - dp2px(144.0f));
    }

    public int getProgressAnimatorPlayedDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        Animator animator = this.mProgressAnimator;
        if (animator != null) {
            return (int) (((float) animator.getDuration()) * this.mProgressAnimator.getProgress());
        }
        return 0;
    }

    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Logger.i(TAG, "pauseAnimation");
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.pauseAnimation();
        }
    }

    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Logger.i(TAG, "resumeAnimation");
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.resumeAnimation();
        }
    }

    public void setHeartColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        try {
            this.mHearColor = Color.parseColor(str);
        } catch (Throwable unused) {
            this.mHearColor = HEART_DEFAULT_COLOR;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.mSubTitleText = str;
        TextLayer textLayer = this.mSubTitleTextLayer;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.mTitleText = str;
        TextLayer textLayer = this.mTitleTextLayer;
        if (textLayer != null) {
            textLayer.setText(str);
        }
    }

    public void startBreathingAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        GroupLayer groupLayer = new GroupLayer(createBigCircleLayer(true), createSmallCircleLayer(true), createTitleLayer(), createSubTitleLayer());
        this.mAnimatorView.clearLayers();
        this.mAnimatorView.addLayer(groupLayer);
        this.mAnimatorView.startAnimation();
    }

    public void startEndAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        GroupLayer groupLayer = new GroupLayer(new AnimatorLayer[0]);
        AnimatorLayer animatorLayer = this.mSmallCircleLayer;
        if (animatorLayer != null) {
            animatorLayer.setAnimator(createHideAnimator(animatorLayer, 80));
            groupLayer.addLayers(this.mSmallCircleLayer);
        }
        AnimatorLayer animatorLayer2 = this.mBigCircleLayer;
        if (animatorLayer2 != null) {
            animatorLayer2.setAnimator(createHideAnimator(animatorLayer2, 80));
            groupLayer.addLayers(this.mBigCircleLayer);
        }
        TextLayer textLayer = this.mTitleTextLayer;
        if (textLayer != null) {
            textLayer.setAnimator(createHideAnimator(textLayer, 80));
            groupLayer.addLayers(this.mTitleTextLayer);
        }
        TextLayer textLayer2 = this.mSubTitleTextLayer;
        if (textLayer2 != null) {
            textLayer2.setAnimator(createHideAnimator(textLayer2, 80));
            groupLayer.addLayers(this.mSubTitleTextLayer);
        }
        AnimatorLayer animatorLayer3 = this.mHeartLayer;
        if (animatorLayer3 != null) {
            animatorLayer3.setAnimator(createHideAnimator(animatorLayer3, 80));
            groupLayer.addLayers(this.mHeartLayer);
        }
        AnimatorLayer animatorLayer4 = this.mProgressCircleLayer;
        if (animatorLayer4 != null) {
            Animator createHideAnimator = createHideAnimator(animatorLayer4, 80);
            createHideAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.longpress.LongPressAnimationHelper.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongPressAnimationHelper.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LongPressAnimationHelper.this.mAnimatorView != null) {
                        LongPressAnimationHelper.this.mAnimatorView.stopAnimation(true, true);
                    }
                }
            });
            this.mProgressCircleLayer.setAnimator(createHideAnimator);
            groupLayer.addLayers(this.mProgressCircleLayer);
        }
        this.mAnimatorView.clearLayers();
        this.mAnimatorView.stopAnimation(false, true);
        this.mAnimatorView.addLayer(groupLayer);
        this.mAnimatorView.startAnimation();
    }

    public void startProgressAnimation(int i3, Animator.AnimatorListener animatorListener, Animator.AnimatorProgressListener animatorProgressListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), animatorListener, animatorProgressListener);
            return;
        }
        AnimatorLayer createSmallCircleLayer = createSmallCircleLayer(false);
        GroupLayer groupLayer = new GroupLayer(createHeartLayer(true), createBigCircleLayer(false), createSmallCircleLayer, createTitleLayer(), createSubTitleLayer(), createProgressLayer(i3, true, new Animator.AnimatorListener(animatorListener) { // from class: com.tencent.ams.fusion.widget.longpress.LongPressAnimationHelper.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Animator.AnimatorListener val$animatorListener;

            {
                this.val$animatorListener = animatorListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongPressAnimationHelper.this, (Object) animatorListener);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LongPressAnimationHelper.this.startEndAnimation();
                Animator.AnimatorListener animatorListener2 = this.val$animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationFinish();
                }
            }
        }, animatorProgressListener));
        this.mAnimatorView.clearLayers();
        this.mAnimatorView.stopAnimation(true, true);
        this.mAnimatorView.addLayer(groupLayer);
        this.mAnimatorView.startAnimation();
    }

    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Logger.i(TAG, "stopAnimation");
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.stopAnimation(true, true);
        }
    }

    public void stopProgressAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AnimatorLayer createSmallCircleLayer = createSmallCircleLayer(false);
        GroupLayer groupLayer = new GroupLayer(createHeartLayer(false), createBigCircleLayer(false), createSmallCircleLayer, createTitleLayer(), createSubTitleLayer(), createProgressLayer(40, false, new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.longpress.LongPressAnimationHelper.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongPressAnimationHelper.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    LongPressAnimationHelper.this.startBreathingAnimation();
                }
            }
        }, null));
        this.mAnimatorView.clearLayers();
        this.mAnimatorView.stopAnimation(false, true);
        this.mAnimatorView.addLayer(groupLayer);
        this.mAnimatorView.startAnimation();
    }
}
