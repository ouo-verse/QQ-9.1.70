package com.tencent.ams.fusion.widget.twist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.CircleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RingShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.apng.APNGDrawable;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.FileLoader;
import com.tencent.ams.fusion.widget.twist.TwistAnimationHelper;
import com.tencent.ams.fusion.widget.twist.TwistRotationHandler;
import com.tencent.ams.fusion.widget.utils.FreeModeSplashLayerHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.RewardSplashHelper;
import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwistView extends FrameLayout implements IAnimatorViewHandler, TwistRotationHandler.TwistCallback {
    static IPatchRedirector $redirector_ = null;
    private static final int CIRCLE_BG_COLOR;
    private static final int CUSTOM_HEIGHT_DP = 120;
    private static final int CUSTOM_WIDTH_DP = 120;
    private static final int DEFAULT_BG_SHADER_COLOR_END;
    private static final int DEFAULT_BG_SHADER_COLOR_START;
    private static final int DEFAULT_BG_SHADER_HEIGHT_DP = 192;
    private static final String DEFAULT_REVERSE_TEXT = "\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c";
    private static final int PHONE_HEIGHT_DP = 70;
    private static final int PHONE_MARGIN_DP = 10;
    private static final int PHONE_WIDTH_DP = 70;
    private static final int RING_CENTER_Y_DP = 110;
    private static final int RING_RATIO_DP = 49;
    private static final int RING_STROKE_WIDTH_DP = 8;
    protected static final int SUBTITLE_TEXT_COLOR;
    protected static final int SUBTITLE_TEXT_SIZE = 14;
    private static final String TAG = "TwistView";
    private static final int TEXT_MARGIN_DP = 4;
    protected static final int TITLE_TEXT_COLOR = -1;
    protected static final int TITLE_TEXT_SIZE = 18;
    private final IAnimatorView mAnimatorView;
    private ImageView mApngImageView;
    private int mBottomPaddingDp;
    private CustomImage mCustomImage;
    private int mDirection;
    private boolean mEnableShowBgShadow;
    private boolean mEnableShowCircle;
    private boolean mEnableShowCircleBg;
    private FreeModeSplashLayerHelper.OnFreeModeButtonClickListener mFreeModeButtonClickListener;
    private List<AnimatorLayer> mFreeModeLayers;
    private volatile boolean mHasPause;
    private volatile boolean mHasStart;
    private boolean mIsActionDownInFreeModeButton;
    private boolean mIsFollowShot;
    private boolean mIsInteractSuccess;
    private boolean mIsUserStarted;
    private RotationAnimator mKeepRotationAnimator;
    protected float mPhoneHeight;
    private AnimatorLayer mPhoneLayer;
    protected float mPhoneWidth;
    protected float mPhoneX;
    protected float mPhoneY;
    private float mReverseAngle;
    private CustomImage mRewardImage;
    protected float mRingCenterX;
    protected float mRingCenterY;
    private ProgressAnimator mRingProgressAnimator;
    private RingShapeLayer mRingProgressLayer;
    protected float mRingRatio;
    protected float mRingStokeWidth;
    private final RotationSensor mSensor;
    private int mShowMode;
    private String mSubTitle;
    private float mSubTitleTextSize;
    protected float mSubTitleTextX;
    private float mSubTitleTextY;
    private float mTargetAngle;
    private int mTextBottomMarginDp;
    private String mTextFour;
    private String mTextOne;
    private String mTextThree;
    private String mTextTwo;
    protected String mTitle;
    private TextLayer mTitleLayer;
    protected float mTitleTextSize;
    protected float mTitleTextX;
    protected float mTitleTextY;
    private List<PathShapeLayer> mTriangleBgLayerList;
    protected float mTriangleWidth;
    private ITwistInteractListener mTwistInteractListener;
    private TwistRotationHandler mTwistRotationListener;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class CustomImage {
        static IPatchRedirector $redirector_;
        private String apngImagePath;
        private Bitmap imageBitmap;

        public CustomImage() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String getApngImagePath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.apngImagePath;
        }

        public Bitmap getImageBitmap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.imageBitmap;
        }

        public void setApngImagePath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.apngImagePath = str;
            }
        }

        public void setImageBitmap(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
            } else {
                this.imageBitmap = bitmap;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ITwistInteractListener {
        void onBackInteractProgress(float f16, int i3);

        void onInteractProgress(float f16, int i3);

        void onInteractResult(boolean z16);

        void onInteractStart();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
            return;
        }
        DEFAULT_BG_SHADER_COLOR_START = Color.parseColor("#00000000");
        DEFAULT_BG_SHADER_COLOR_END = Color.parseColor("#7F000000");
        SUBTITLE_TEXT_COLOR = Color.parseColor("#CCFFFFFF");
        CIRCLE_BG_COLOR = Color.parseColor("#7F191919");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TwistView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mDirection = 0;
        this.mTargetAngle = 90.0f;
        this.mReverseAngle = 0.0f;
        this.mBottomPaddingDp = 0;
        this.mTextBottomMarginDp = 48;
        this.mEnableShowBgShadow = true;
        this.mEnableShowCircle = true;
        this.mEnableShowCircleBg = false;
        this.mShowMode = 0;
        this.mIsActionDownInFreeModeButton = false;
        this.mFreeModeLayers = null;
        this.mIsFollowShot = true;
        IAnimatorView newInstance = newInstance(context);
        this.mAnimatorView = newInstance;
        addView((View) newInstance);
        this.mSensor = new RotationSensor(getContext(), false);
        createRotationChangeListener();
    }

    private boolean addCustomImageAnimator(List<AnimatorLayer> list) {
        if (this.mCustomImage == null) {
            Logger.i(TAG, "addImageAnimator\uff0c mCustomImage == null");
            return false;
        }
        float dp2px = Utils.dp2px(120.0f);
        float dp2px2 = Utils.dp2px(120.0f);
        TwistAnimationHelper.IconParams iconParams = new TwistAnimationHelper.IconParams((getWidth() - dp2px) / 2.0f, ((this.mTitleTextY - Utils.getTextPaintHeight(this.mTitleTextSize)) - Utils.dp2px(10.0f)) - dp2px2, dp2px, dp2px2);
        if (!playApngAnimator(this.mCustomImage.apngImagePath, iconParams)) {
            Bitmap bitmap = this.mCustomImage.imageBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                list.add(createCircleBgLayer(iconParams));
                list.add(createPhoneLayer(Utils.createBitmap(bitmap, (int) dp2px, (int) dp2px2, false), iconParams));
                return true;
            }
            Logger.i(TAG, "addImageAnimator\uff0c imageBitmap == null");
            return false;
        }
        Logger.i(TAG, "addImageAnimator\uff0c playApngAnimator");
        return true;
    }

    private void addDefaultImageAnimator(List<AnimatorLayer> list) {
        if (this.mEnableShowCircle) {
            list.add(createCircleLayer());
        }
        list.add(createPhoneLayer(null, new TwistAnimationHelper.IconParams(this.mPhoneX, this.mPhoneY, this.mPhoneWidth, this.mPhoneHeight)));
        list.add(createRingBgLayer(this.mRingRatio));
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mTriangleBgLayerList = copyOnWriteArrayList;
        int i3 = this.mDirection;
        if (i3 == 2) {
            copyOnWriteArrayList.add(createTriangleLayer(0, this.mRingRatio));
            this.mTriangleBgLayerList.add(createTriangleLayer(1, this.mRingRatio));
        } else {
            copyOnWriteArrayList.add(createTriangleLayer(i3, this.mRingRatio));
        }
        list.addAll(this.mTriangleBgLayerList);
        list.add(createRingProgressLayer(this.mRingRatio));
    }

    private void addImageAnimator(List<AnimatorLayer> list) {
        if (addCustomImageAnimator(list)) {
            Logger.i(TAG, "addImageAnimator\uff0c addCustomImage");
        } else {
            Logger.i(TAG, "addImageAnimator\uff0c addDefaultImage");
            addDefaultImageAnimator(list);
        }
    }

    private void addRewardImageLayer(List<AnimatorLayer> list) {
        CustomImage customImage = this.mRewardImage;
        if (customImage != null) {
            Bitmap bitmap = customImage.imageBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                float height = getHeight() - Utils.dp2px(105.0f);
                float dp2px = Utils.dp2px(130.0f);
                int height2 = bitmap.getHeight();
                if (height > 0.0f && height2 != 0) {
                    float width = (bitmap.getWidth() * dp2px) / height2;
                    RewardSplashHelper.addRewardImageLayer(getContext(), bitmap, list, (getWidth() - width) / 2.0f, height, width, dp2px);
                    return;
                }
                Logger.e(TAG, "addRewardImageLayer\uff0c imageY <= 0 || imageBitmap.getHeight() == 0");
                return;
            }
            Logger.e(TAG, "addRewardImageLayer\uff0c imageBitmap == null");
            return;
        }
        Logger.e(TAG, "addRewardImageLayer\uff0c mRewardImage == null");
    }

    private PathShapeLayer createBgShaderLayer() {
        int dp2px = (int) (Utils.dp2px(192.0f) + Utils.dp2px(this.mTextBottomMarginDp));
        int[] iArr = {DEFAULT_BG_SHADER_COLOR_START, DEFAULT_BG_SHADER_COLOR_END};
        int width = getWidth();
        int height = getHeight() - ((int) Utils.dp2px(this.mBottomPaddingDp));
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

    private void createRotationChangeListener() {
        Logger.i(TAG, "createRotationChangeListener: " + this.mTwistRotationListener);
        if (this.mTwistRotationListener == null) {
            this.mTwistRotationListener = new TwistRotationHandler(this);
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.setOnRotationChangeListener(this.mTwistRotationListener);
        }
    }

    private TextLayer createSubTextLayer() {
        return createTextLayer(this.mSubTitle, SUBTITLE_TEXT_COLOR, this.mSubTitleTextSize, this.mSubTitleTextX, this.mSubTitleTextY, false);
    }

    private TextLayer createTextLayer(String str, int i3, float f16, float f17, float f18, boolean z16) {
        Logger.i(TAG, "createTextLayer, text:" + str + ", y:" + f18);
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(f17);
        textLayer.setY(f18);
        textLayer.setTextBold(z16);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private TextLayer createTitleTextLayer() {
        return createTextLayer(this.mTitle, -1, this.mTitleTextSize, this.mTitleTextX, this.mTitleTextY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public APNGDrawable getApngDrawable(String str) {
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
            aPNGDrawable.setLoopLimit(-1);
            return aPNGDrawable;
        } catch (Throwable th6) {
            th = th6;
            aPNGDrawable2 = aPNGDrawable;
            Logger.e(TAG, "apng create fail:", th);
            return aPNGDrawable2;
        }
    }

    private void handleInteractSuccess() {
        ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onInteractResult(true);
        }
        this.mSensor.stop();
        this.mIsInteractSuccess = true;
    }

    private void handlePhoneRotation(float f16, float f17) {
        AnimatorLayer animatorLayer = this.mPhoneLayer;
        if (animatorLayer == null) {
            return;
        }
        if (f17 > 0.0f) {
            f16 = -f16;
        }
        float f18 = f16 * 45.0f;
        RotationAnimator rotationAnimator = this.mKeepRotationAnimator;
        if (rotationAnimator == null) {
            Animator animator = animatorLayer.getAnimator();
            if (animator != null) {
                animator.cancelAnimation();
            }
            float rotationDegrees = this.mPhoneLayer.getRotationDegrees();
            RotationAnimator rotationAnimator2 = new RotationAnimator(this.mPhoneLayer);
            rotationAnimator2.setRepeatCount(1);
            rotationAnimator2.setDuration(60L);
            rotationAnimator2.setRotationDegrees(rotationDegrees, f18);
            this.mPhoneLayer.setAnimator(rotationAnimator2);
            this.mKeepRotationAnimator = rotationAnimator2;
            return;
        }
        rotationAnimator.setDuration(0L);
        rotationAnimator.setRotationDegrees(f18, f18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRingProgress(float f16) {
        RingShapeLayer ringShapeLayer;
        ProgressAnimator progressAnimator = this.mRingProgressAnimator;
        if (progressAnimator != null) {
            progressAnimator.setFromProgress(f16);
            this.mRingProgressAnimator.setToProgress(f16);
        }
        if (this.mDirection == 2 && (ringShapeLayer = this.mRingProgressLayer) != null) {
            ringShapeLayer.setStartAngle((-90.0f) - (f16 * 45.0f));
        }
    }

    private boolean playApngAnimator(String str, TwistAnimationHelper.IconParams iconParams) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Utils.runOnUiThread(new Runnable(str, iconParams) { // from class: com.tencent.ams.fusion.widget.twist.TwistView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$apngImagePath;
            final /* synthetic */ TwistAnimationHelper.IconParams val$iconParams;

            {
                this.val$apngImagePath = str;
                this.val$iconParams = iconParams;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TwistView.this, str, iconParams);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    APNGDrawable apngDrawable = TwistView.this.getApngDrawable(this.val$apngImagePath);
                    if (apngDrawable == null) {
                        return;
                    }
                    if (TwistView.this.mApngImageView == null) {
                        TwistView.this.mApngImageView = new ImageView(TwistView.this.getContext());
                    } else {
                        TwistView twistView = TwistView.this;
                        twistView.removeView(twistView.mApngImageView);
                    }
                    TwistView.this.mApngImageView.setImageDrawable(apngDrawable);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.val$iconParams.getIconWidth(), (int) this.val$iconParams.getIconHeight());
                    layoutParams.gravity = 51;
                    layoutParams.topMargin = (int) this.val$iconParams.getIconY();
                    layoutParams.leftMargin = (int) this.val$iconParams.getIconX();
                    TwistView twistView2 = TwistView.this;
                    twistView2.addView(twistView2.mApngImageView, layoutParams);
                    Logger.i(TwistView.TAG, "playApngAnimator");
                    TwistView.this.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.twist.TwistView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                Logger.i(TwistView.TAG, "playApngAnimator, requestLayout");
                                TwistView.this.mApngImageView.requestLayout();
                            }
                        }
                    });
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
        return true;
    }

    private void setProgress(float f16, int i3) {
        float f17 = i3 / 100.0f;
        if (f17 < 0.0f) {
            f17 = 0.0f;
        } else if (f17 > 1.0f) {
            f17 = 1.0f;
        }
        handleRingProgress(f17);
        if (this.mIsFollowShot) {
            handlePhoneRotation(f17, f16);
        }
        if (!Utils.isEmpty(this.mTriangleBgLayerList)) {
            for (PathShapeLayer pathShapeLayer : this.mTriangleBgLayerList) {
                if (pathShapeLayer != null) {
                    if (f17 >= 1.0f) {
                        pathShapeLayer.postAlpha(255);
                    } else {
                        pathShapeLayer.postAlpha(153);
                    }
                    pathShapeLayer.setAnimator(new KeepAnimator(pathShapeLayer));
                }
            }
        }
    }

    protected void calculateUISize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (this.mShowMode == 2) {
            int width = getWidth();
            int height = getHeight();
            float f16 = width;
            this.mPhoneWidth = f16;
            float f17 = height;
            this.mPhoneHeight = 0.75f * f17;
            this.mPhoneX = 0.0f;
            this.mPhoneY = 0.25f * f17;
            this.mRingCenterX = f16 / 2.0f;
            this.mRingCenterY = f17 * 0.5f;
            this.mRingRatio = f16 * 0.5f;
            float f18 = f17 / 20.0f;
            this.mRingStokeWidth = f18;
            this.mTriangleWidth = f18 * 1.414f * 2.0f;
            return;
        }
        this.mSubTitleTextSize = Utils.dp2px(14.0f);
        this.mTitleTextSize = Utils.dp2px(18.0f);
        float width2 = getWidth() / 2.0f;
        this.mSubTitleTextX = width2;
        this.mTitleTextX = width2;
        float height2 = ((getHeight() - Utils.dp2px(this.mBottomPaddingDp)) - Utils.dp2px(this.mTextBottomMarginDp)) - Utils.getTextPaintBaselineToBottom(this.mSubTitleTextSize);
        this.mSubTitleTextY = height2;
        this.mTitleTextY = ((height2 - Utils.getTextPaintHeight(this.mSubTitleTextSize)) - Utils.dp2px(4.0f)) - Utils.getTextPaintBaselineToBottom(this.mTitleTextSize);
        this.mPhoneWidth = Utils.dp2px(70.0f);
        this.mPhoneHeight = Utils.dp2px(70.0f);
        this.mPhoneX = (getWidth() - this.mPhoneWidth) / 2.0f;
        this.mPhoneY = ((this.mTitleTextY - Utils.getTextPaintHeight(this.mTitleTextSize)) - Utils.dp2px(10.0f)) - this.mPhoneHeight;
        this.mRingCenterX = getWidth() / 2.0f;
        this.mRingCenterY = ((getHeight() - Utils.dp2px(110.0f)) - Utils.dp2px(this.mBottomPaddingDp)) - Utils.dp2px(this.mTextBottomMarginDp);
        this.mRingRatio = Utils.dp2px(49.0f);
        this.mRingStokeWidth = Utils.dp2px(8.0f);
        this.mTriangleWidth = Utils.dp2px(16.0f) * 1.414f;
    }

    protected AnimatorLayer createCircleBgLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            return null;
        }
        return (AnimatorLayer) iPatchRedirector.redirect((short) 32, (Object) this);
    }

    protected AnimatorLayer createCircleLayer() {
        float cos;
        float sin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        if (this.mDirection == 2) {
            cos = this.mRingCenterX;
            sin = this.mRingCenterY - this.mRingRatio;
        } else {
            float radians = (float) Math.toRadians(-45.0d);
            if (this.mDirection == 0) {
                radians = (float) Math.toRadians(-135.0d);
            }
            double d16 = radians;
            cos = (float) (this.mRingCenterX + (this.mRingRatio * Math.cos(d16)));
            sin = (float) (this.mRingCenterY + (this.mRingRatio * Math.sin(d16)));
        }
        RingShapeLayer strokeCap = new RingShapeLayer(cos, sin, this.mRingStokeWidth / 2.0f, -1, 1.0f).setStrokeCap(Paint.Cap.BUTT);
        strokeCap.setStartAngle(0.0f);
        strokeCap.setSweepAngle(360.0f);
        strokeCap.setUseCenter(true);
        strokeCap.setStyle(Paint.Style.FILL);
        strokeCap.postProgress(100.0f);
        strokeCap.setAnimator(new KeepAnimator(strokeCap));
        return strokeCap;
    }

    protected AnimatorLayer createPhoneLayer(Bitmap bitmap, TwistAnimationHelper.IconParams iconParams) {
        AnimatorLayer iconAnimatorLayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) bitmap, (Object) iconParams);
        }
        if (bitmap != null) {
            iconAnimatorLayer = TwistAnimationHelper.getIconAnimatorLayer(bitmap, iconParams);
        } else {
            iconAnimatorLayer = TwistAnimationHelper.getIconAnimatorLayer("", iconParams);
        }
        this.mPhoneLayer = iconAnimatorLayer;
        iconAnimatorLayer.setAnimator(TwistAnimationHelper.getGuidAnimator(iconAnimatorLayer, this.mDirection, new Animator.AnimatorProgressListener() { // from class: com.tencent.ams.fusion.widget.twist.TwistView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TwistView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
            public void onAnimationProgressUpdate(float f16) {
                float f17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Float.valueOf(f16));
                    return;
                }
                if (TwistView.this.mDirection == 2) {
                    f17 = 45.0f;
                } else {
                    f17 = 150.0f;
                }
                TwistView twistView = TwistView.this;
                twistView.handleRingProgress(Math.abs(twistView.mPhoneLayer.getRotationDegrees()) / f17);
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorProgressListener
            public int updateInterval() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this)).intValue();
                }
                return 0;
            }
        }));
        this.mKeepRotationAnimator = null;
        return this.mPhoneLayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnimatorLayer createRingBgLayer(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 31, this, Float.valueOf(f16));
        }
        return TwistAnimatorViewHelper.createRingBgLayer(f16, this.mRingCenterX, this.mRingCenterY, this.mRingStokeWidth);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnimatorLayer createRingProgressLayer(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 35, this, Float.valueOf(f16));
        }
        RingShapeLayer createRingProgressLayer = TwistAnimatorViewHelper.createRingProgressLayer(f16, this.mDirection, this.mRingCenterX, this.mRingCenterY, this.mRingStokeWidth);
        this.mRingProgressLayer = createRingProgressLayer;
        this.mRingProgressAnimator = (ProgressAnimator) createRingProgressLayer.getAnimator();
        return this.mRingProgressLayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PathShapeLayer createTriangleLayer(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (PathShapeLayer) iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Float.valueOf(f16));
        }
        return TwistAnimatorViewHelper.createTriangleLayer(i3, f16, this.mRingCenterX, this.mRingCenterY, this.mTriangleWidth);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                FreeModeSplashLayerHelper.OnFreeModeButtonClickListener onFreeModeButtonClickListener = this.mFreeModeButtonClickListener;
                if (this.mIsActionDownInFreeModeButton && FreeModeSplashLayerHelper.isClickInFreeModeButton(motionEvent.getX(), motionEvent.getY()) && onFreeModeButtonClickListener != null) {
                    onFreeModeButtonClickListener.onFreeModeButtonClick(motionEvent.getX(), motionEvent.getY());
                    this.mIsActionDownInFreeModeButton = false;
                    return false;
                }
            }
        } else if (FreeModeSplashLayerHelper.isClickInFreeModeButton(motionEvent.getX(), motionEvent.getY())) {
            this.mIsActionDownInFreeModeButton = true;
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected IAnimatorView newInstance(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IAnimatorView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return new AnimatorView(context);
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onBackInteractProgress(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        setProgress(f16, i3);
        TextLayer textLayer = this.mTitleLayer;
        if (textLayer != null) {
            textLayer.setText("\u6446\u6b63\u624b\u673a\u8fdb\u884c\u8df3\u8f6c");
        }
        FreeModeSplashLayerHelper.onBackInteractProgress(this.mFreeModeLayers);
        ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onBackInteractProgress(f16, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onInteractProgress(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        setProgress(f16, i3);
        ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onInteractProgress(f16, i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onInteractStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        ITwistInteractListener iTwistInteractListener = this.mTwistInteractListener;
        if (iTwistInteractListener != null) {
            iTwistInteractListener.onInteractStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.twist.TwistRotationHandler.TwistCallback
    public void onInteractSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            handleInteractSuccess();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mIsUserStarted && !this.mIsInteractSuccess) {
            Logger.i(TAG, "onSizeChanged() start() mHasPause: " + this.mHasPause);
            if (this.mHasPause) {
                return;
            }
            start();
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Logger.i(TAG, "pause()");
        this.mAnimatorView.pauseAnimation();
        if (!this.mIsInteractSuccess) {
            this.mSensor.pause();
            this.mHasPause = true;
            Logger.i(TAG, "pause() ...");
        }
    }

    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        this.mSensor.resetRotation();
        start();
        this.mIsInteractSuccess = false;
        createRotationChangeListener();
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.reset();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        Logger.i(TAG, "resume()");
        this.mAnimatorView.resumeAnimation();
        if (!this.mIsInteractSuccess) {
            if (!this.mHasStart) {
                start();
                return;
            }
            this.mSensor.resume();
            this.mHasPause = false;
            Logger.i(TAG, "resume() ...");
        }
    }

    public void setBottomPaddingDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (i3 >= 0) {
            this.mBottomPaddingDp = i3;
        }
    }

    public void setCustomImage(CustomImage customImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) customImage);
        } else {
            this.mCustomImage = customImage;
        }
    }

    public void setDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            Logger.w(TAG, "invalid direction: " + i3);
            return;
        }
        this.mDirection = i3;
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.setDirection(i3);
        }
    }

    public void setEnableShowBgShadow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.mEnableShowBgShadow = z16;
        }
    }

    public void setEnableShowCircle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.mEnableShowCircle = z16;
        }
    }

    public void setEnableShowCircleBg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mEnableShowCircleBg = z16;
        }
    }

    public void setFollowShot(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bool);
        } else {
            this.mIsFollowShot = bool.booleanValue();
        }
    }

    public void setFreeModeClickListener(FreeModeSplashLayerHelper.OnFreeModeButtonClickListener onFreeModeButtonClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onFreeModeButtonClickListener);
        } else {
            this.mFreeModeButtonClickListener = onFreeModeButtonClickListener;
        }
    }

    public void setFreeModeText(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, str3, str4);
            return;
        }
        this.mTextOne = str;
        this.mTextTwo = str2;
        this.mTextThree = str3;
        this.mTextFour = str4;
    }

    public void setReverseAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            Logger.i(TAG, "invalid reverseAngle");
            return;
        }
        this.mReverseAngle = f16;
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.setReverseAngle(f16);
        }
    }

    public void setRewardImage(CustomImage customImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) customImage);
        } else {
            this.mRewardImage = customImage;
        }
    }

    public void setShowMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mShowMode = i3;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mSubTitle = str;
        }
    }

    public void setTargetAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        if (f16 <= 0.0f) {
            Logger.i(TAG, "invalid targetAngle");
            return;
        }
        this.mTargetAngle = f16;
        TwistRotationHandler twistRotationHandler = this.mTwistRotationListener;
        if (twistRotationHandler != null) {
            twistRotationHandler.setTargetAngle(f16);
        }
    }

    public void setTextBottomMarginDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (i3 >= 0) {
            this.mTextBottomMarginDp = i3;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mTitle = str;
        }
    }

    public void setTwistInteractListener(ITwistInteractListener iTwistInteractListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) iTwistInteractListener);
        } else {
            this.mTwistInteractListener = iTwistInteractListener;
        }
    }

    public void setViewsShowOnTop(AnimatorView.ViewShowOnTop[] viewShowOnTopArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) viewShowOnTopArr);
            return;
        }
        IAnimatorView iAnimatorView = this.mAnimatorView;
        if (iAnimatorView instanceof AnimatorView) {
            ((AnimatorView) iAnimatorView).setViewsShowOnTop(viewShowOnTopArr);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorViewHandler
    public void smoothHideView(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) animatorListener);
            return;
        }
        IAnimatorView iAnimatorView = this.mAnimatorView;
        if (iAnimatorView instanceof IAnimatorViewHandler) {
            ((IAnimatorViewHandler) iAnimatorView).smoothHideView(animatorListener);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Logger.i(TAG, "start()");
        this.mIsUserStarted = true;
        if (getWidth() > 0 && getHeight() > 0) {
            calculateUISize();
            List<AnimatorLayer> arrayList = new ArrayList<>();
            if (this.mEnableShowBgShadow) {
                arrayList.add(createBgShaderLayer());
            }
            if (this.mEnableShowCircleBg) {
                arrayList.add(createCircleBgLayer());
            }
            int i3 = this.mShowMode;
            if (i3 == 0) {
                arrayList.add(createSubTextLayer());
                TextLayer createTitleTextLayer = createTitleTextLayer();
                this.mTitleLayer = createTitleTextLayer;
                arrayList.add(createTitleTextLayer);
                addImageAnimator(arrayList);
                addRewardImageLayer(arrayList);
            } else if (i3 == 1) {
                addImageAnimator(arrayList);
                this.mFreeModeLayers = FreeModeSplashLayerHelper.buildFreeModeCardLayers(getContext(), arrayList, getWidth(), Utils.dp2px(20.0f) + this.mPhoneY + this.mPhoneHeight, this.mTextOne, this.mTextTwo, this.mTextThree, this.mTextFour);
            } else if (i3 == 2) {
                addDefaultImageAnimator(arrayList);
            }
            GroupLayer groupLayer = new GroupLayer((AnimatorLayer[]) arrayList.toArray(new AnimatorLayer[0]));
            this.mAnimatorView.clearLayers();
            this.mAnimatorView.addLayer(groupLayer);
            this.mAnimatorView.startAnimation();
            this.mSensor.start();
            this.mHasStart = true;
            this.mHasPause = false;
            Logger.i(TAG, "start() ...");
            return;
        }
        Logger.i(TAG, "start() widthHeight=0, return");
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        Logger.i(TAG, "stop()");
        this.mIsUserStarted = false;
        this.mAnimatorView.stopAnimation();
        this.mSensor.stop();
    }

    private AnimatorLayer createCircleBgLayer(TwistAnimationHelper.IconParams iconParams) {
        CircleShapeLayer circleShapeLayer = new CircleShapeLayer(iconParams.getIconX() + (iconParams.getIconWidth() / 2.0f), iconParams.getIconY() + (iconParams.getIconHeight() / 2.0f), iconParams.getIconWidth() / 2.0f, CIRCLE_BG_COLOR);
        circleShapeLayer.setAnimator(new KeepAnimator(circleShapeLayer));
        return circleShapeLayer;
    }
}
