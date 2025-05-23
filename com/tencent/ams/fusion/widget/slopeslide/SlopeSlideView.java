package com.tencent.ams.fusion.widget.slopeslide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BrokenLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.CircleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer;
import com.tencent.ams.fusion.widget.utils.FreeModeSplashLayerHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.RewardSplashHelper;
import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlopeSlideView extends FrameLayout implements IAnimatorView, RotationSensor.OnRotationChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final int ARROW1_BOTTOM_TO_PHONE_ICON_TOP = 98;
    private static final int ARROW2_BOTTOM_TO_PHONE_ICON_TOP = 66;
    private static final int ARROW_HEIGHT = 54;
    private static final int ARROW_WIDTH = 78;
    private static final int BOTTOM = 167;
    private static final int DEFAULT_BG_SHADER_COLOR_END;
    private static final int DEFAULT_BG_SHADER_COLOR_START;
    private static final int DEFAULT_BG_SHADER_HEIGHT = 480;
    private static final int DEFAULT_BG_SHADER_HEIGHT_FREE_MODE = 628;
    private static final int DEFAULT_ICON_ANIMATOR_OFFSET = 20;
    private static final int DEFAULT_ICON_SIZE = 260;
    private static final int DEFAULT_ICON_TOP_OFFSET = 124;
    private static final float DEFAULT_ROTATION_THRESHOLD = 40.0f;
    private static final int PHONE_MARGIN_BOTTOM = 7;
    protected static final float ROTATION_START_THRESHOLD = 5.0f;
    protected static final int SUBTITLE_TEXT_COLOR;
    protected static final int SUBTITLE_TEXT_SIZE = 14;
    private static final String TAG = "SlopeSlideView";
    private static final int TEXT_MARGIN = 5;
    protected static final int TITLE_TEXT_COLOR = -1;
    protected static final int TITLE_TEXT_SIZE = 18;
    private boolean isActionDownInFreeModeButton;
    protected boolean mAnimatorFinished;
    protected BitmapLayer mArrowLayer1;
    protected BitmapLayer mArrowLayer2;
    protected PathShapeLayer mBgShaderLayer;
    private int mBottomPadding;
    private int mBottomPaddingDp;
    private boolean mCheckGestureMatchWhenTouchDown;
    private final ViewConfiguration mConfiguration;
    private float mDownX;
    private float mDownY;
    private boolean mEnableClick;
    private boolean mEnableShowBgShadow;
    private boolean mEnableShowStroke;
    private FreeModeSplashLayerHelper.OnFreeModeButtonClickListener mFreeModeButtonClickListener;
    private final AnimatorView mGestureAnimatorView;
    private GesturePathLayer mGesturePathLayer;
    private float mHotAreaBottomMargin;
    private float mHotAreaHeight;
    private float mHotAreaLeftMargin;
    private Rect mHotAreaRect;
    private float mHotAreaRightMargin;
    protected Bitmap mIconBitmap;
    protected BitmapLayer mIconLayer;
    private Animator mIconShakeAnimator;
    protected boolean mIsInteractSuccess;
    private volatile boolean mIsRotationStarted;
    private boolean mIsUserStarted;
    protected float mMaxAngle;
    protected OnSlopSlideInteractListener mOnSlopeSlideInteractListener;
    protected RotatePhoneLayer mPhoneLayer;
    private final AnimatorView mPosterAnimatorView;
    private Bitmap mRewardImage;
    private float mRotationThreshold;
    private final RotationSensor mSensor;
    private int mShowMode;

    @Reason
    private int mSlideErrorType;
    private float mSlideThreshold;
    private int mStorkColor;
    private float mStrokeWidthDp;
    private int mStyle;
    protected String mSubTitle;
    protected TextLayer mSubTitleLayer;
    private int mTextBottomMargin;
    private int mTextBottomMarginDp;
    private String mTextFour;
    private String mTextOne;
    private String mTextThree;
    private String mTextTwo;
    protected String mTitle;
    protected TextLayer mTitleLayer;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface InteractType {
        public static final int BLOW = 3;
        public static final int CLICK = 4;
        public static final int ROTATION = 1;
        public static final int SLIDE = 2;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnSlopSlideInteractListener {
        void onAnimatorFinish();

        void onAnimatorStart();

        void onInteractFinish(@InteractType int i3, boolean z16, Point point);

        void onInteractProgress(float f16);

        void onInteractResult(@InteractType int i3, boolean z16, @Reason int i16, Point point, float f16);

        void onInteractStart(@InteractType int i3, Point point);

        void onSensorError();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface Reason {
        public static final int BLOW_NOT_INTERACTIVE = 5;
        public static final int BLOW_SLOPE_NOT_INTERACTIVE = 6;
        public static final int NONE = 0;
        public static final int NOT_INTERACTIVE = 1;
        public static final int SLIDE_DO_NOT_IN_HOTAREA = 3;
        public static final int SLIDE_DO_NOT_REACH_THRESHOLD = 2;
        public static final int SLOPE_DO_NOT_REACH_THRESHOLD = 4;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface STYLE {
        public static final int DEFAULT = 0;
        public static final int PAD = 1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 69)) {
            redirector.redirect((short) 69);
            return;
        }
        SUBTITLE_TEXT_COLOR = Color.parseColor("#CCFFFFFF");
        DEFAULT_BG_SHADER_COLOR_START = Color.parseColor("#00000000");
        DEFAULT_BG_SHADER_COLOR_END = Color.parseColor("#7F000000");
    }

    public SlopeSlideView(Context context) {
        this(context, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void addRewardImageLayer(List<AnimatorLayer> list) {
        Bitmap bitmap = this.mRewardImage;
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
    }

    private void createArrowLayer() {
        float width = (getWidth() - getRelativeSizeByStyle(getContext(), 78)) / 2.0f;
        BitmapLayer createSplitArrowLayer = createSplitArrowLayer(width, getRelativeSizeByStyle(getContext(), 98));
        this.mArrowLayer1 = createSplitArrowLayer;
        AlphaAnimator alphaAnimator = new AlphaAnimator(createSplitArrowLayer, 0.2f, 1.0f);
        alphaAnimator.setDuration(720L);
        alphaAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        AlphaAnimator alphaAnimator2 = new AlphaAnimator(this.mArrowLayer1, 1.0f, 0.2f);
        alphaAnimator2.setDuration(400L);
        alphaAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        AlphaAnimator alphaAnimator3 = new AlphaAnimator(this.mArrowLayer1, 0.2f, 0.2f);
        alphaAnimator3.setDuration(560L);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.mArrowLayer1, alphaAnimator, alphaAnimator2, alphaAnimator3);
        sequentialAnimator.setRepeatMode(1);
        sequentialAnimator.setRepeatCount(0);
        this.mArrowLayer1.setAnimator(sequentialAnimator);
        BitmapLayer createSplitArrowLayer2 = createSplitArrowLayer(width, getRelativeSizeByStyle(getContext(), 66));
        this.mArrowLayer2 = createSplitArrowLayer2;
        AlphaAnimator alphaAnimator4 = new AlphaAnimator(createSplitArrowLayer2, 0.2f, 0.2f);
        alphaAnimator4.setDuration(360L);
        AlphaAnimator alphaAnimator5 = new AlphaAnimator(this.mArrowLayer2, 0.2f, 1.0f);
        alphaAnimator5.setDuration(360L);
        alphaAnimator5.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        AlphaAnimator alphaAnimator6 = new AlphaAnimator(this.mArrowLayer2, 1.0f, 0.2f);
        alphaAnimator6.setDuration(400L);
        alphaAnimator6.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        AlphaAnimator alphaAnimator7 = new AlphaAnimator(this.mArrowLayer2, 0.2f, 0.2f);
        alphaAnimator7.setDuration(560L);
        SequentialAnimator sequentialAnimator2 = new SequentialAnimator(this.mArrowLayer2, alphaAnimator4, alphaAnimator5, alphaAnimator6, alphaAnimator7);
        sequentialAnimator2.setRepeatMode(1);
        sequentialAnimator2.setRepeatCount(0);
        this.mArrowLayer2.setAnimator(sequentialAnimator2);
    }

    private void createGesturePathLayer() {
        this.mHotAreaRect = generateSlideRect();
        GesturePathLayer gesturePathLayer = new GesturePathLayer(getContext(), this.mHotAreaRect, this.mSlideThreshold);
        this.mGesturePathLayer = gesturePathLayer;
        gesturePathLayer.setStrokeColor(this.mStorkColor);
        this.mGesturePathLayer.setEnableShowStroke(this.mEnableShowStroke);
        this.mGesturePathLayer.setStrokeWidth(Utils.dp2px(this.mStrokeWidthDp));
        this.mGesturePathLayer.setCheckGestureMatchWhenTouchDown(this.mCheckGestureMatchWhenTouchDown);
        this.mGesturePathLayer.setGestureResultListener(new GesturePathLayer.GestureResultListener() { // from class: com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchFinish(boolean z16, int i3, float f16, float f17, float f18, float f19, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i16));
                    return;
                }
                Logger.d(SlopeSlideView.TAG, "onGestureMatchFinish:" + z16);
                SlopeSlideView.this.mSlideErrorType = i3;
                SlopeSlideView slopeSlideView = SlopeSlideView.this;
                OnSlopSlideInteractListener onSlopSlideInteractListener = slopeSlideView.mOnSlopeSlideInteractListener;
                if (!z16 && slopeSlideView.mEnableClick) {
                    SlopeSlideView slopeSlideView2 = SlopeSlideView.this;
                    if (slopeSlideView2.isClickInCircle(slopeSlideView2.mDownX, SlopeSlideView.this.mDownY)) {
                        SlopeSlideView slopeSlideView3 = SlopeSlideView.this;
                        if (!slopeSlideView3.isClickInBottomPaddingArea(slopeSlideView3.mDownX, SlopeSlideView.this.mDownY) && Utils.isClickEvent(SlopeSlideView.this.mConfiguration, SlopeSlideView.this.mDownX, SlopeSlideView.this.mDownY, f16, f17)) {
                            if (onSlopSlideInteractListener != null) {
                                onSlopSlideInteractListener.onInteractFinish(4, true, new Point((int) f16, (int) f17));
                            }
                            SlopeSlideView.this.onInteractSuccess(4, new Point((int) f16, (int) f17));
                            return;
                        }
                    }
                }
                if (onSlopSlideInteractListener != null) {
                    onSlopSlideInteractListener.onInteractFinish(2, z16, new Point((int) f16, (int) f17));
                }
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchProgress(float f16, float f17, float f18, float f19, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchStart(float f16, float f17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SlopeSlideView.this.mDownX = f16;
                    SlopeSlideView.this.mDownY = f17;
                    OnSlopSlideInteractListener onSlopSlideInteractListener = SlopeSlideView.this.mOnSlopeSlideInteractListener;
                    if (onSlopSlideInteractListener != null) {
                        onSlopSlideInteractListener.onInteractStart(2, new Point((int) f16, (int) f17));
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchSuccess(float f16, float f17, float f18) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
                    return;
                }
                RotatePhoneLayer rotatePhoneLayer = SlopeSlideView.this.mPhoneLayer;
                if (rotatePhoneLayer != null) {
                    rotatePhoneLayer.setAnimator(new KeepAnimator(rotatePhoneLayer));
                }
                SlopeSlideView.this.onInteractSuccess(2, new Point((int) f16, (int) f17));
            }
        });
    }

    private void createIconFlyAnimator(Animator.AnimatorListener animatorListener) {
        BitmapLayer bitmapLayer = this.mIconLayer;
        if (bitmapLayer == null) {
            return;
        }
        float y16 = bitmapLayer.getY() + (this.mIconLayer.getHeight() * 1.3f);
        float relativeSizeByStyle = getRelativeSizeByStyle(getContext(), 246);
        Logger.i(TAG, "createIconFlyAnimator, offset: " + y16);
        float f16 = -relativeSizeByStyle;
        GroupAnimator groupAnimator = new GroupAnimator(this.mIconLayer, new TranslateAnimator(this.mIconLayer, 0.0f, 0.0f, 0.0f, f16), new ScaleAnimator((AnimatorLayer) this.mIconLayer, 1.0f, 1.3f, 1.0f, 1.3f));
        groupAnimator.setDuration(120L);
        groupAnimator.setPathInterpolator(0.37f, 0.0f, 0.63f, 1.0f);
        GroupAnimator groupAnimator2 = new GroupAnimator(this.mIconLayer, new TranslateAnimator(this.mIconLayer, 0.0f, 0.0f, f16, -y16), new ScaleAnimator((AnimatorLayer) this.mIconLayer, 1.3f, 1.3f, 1.3f, 1.3f));
        groupAnimator2.setDuration(300L);
        groupAnimator2.setPathInterpolator(0.33f, 1.0f, 0.68f, 1.0f);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.mIconLayer, groupAnimator, groupAnimator2);
        sequentialAnimator.setAnimatorListener(animatorListener);
        this.mIconLayer.setAnimator(sequentialAnimator);
    }

    private BitmapLayer createSplitArrowLayer(float f16, int i3) {
        int relativeSizeByStyle = getRelativeSizeByStyle(getContext(), 78);
        int relativeSizeByStyle2 = getRelativeSizeByStyle(getContext(), 54);
        BitmapLayer bitmapLayer = new BitmapLayer(relativeSizeByStyle, relativeSizeByStyle2) { // from class: com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.3
            static IPatchRedirector $redirector_;
            private Bitmap bitmap;
            final /* synthetic */ int val$height;
            final /* synthetic */ int val$width;

            {
                this.val$width = relativeSizeByStyle;
                this.val$height = relativeSizeByStyle2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SlopeSlideView.this, Integer.valueOf(relativeSizeByStyle), Integer.valueOf(relativeSizeByStyle2));
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer
            public Bitmap getBitmap() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                if (this.bitmap == null) {
                    this.bitmap = SlopeSlideHelper.getArrowIcon(this.val$width, this.val$height);
                }
                return this.bitmap;
            }
        };
        bitmapLayer.setWidth(relativeSizeByStyle);
        bitmapLayer.setHeight(relativeSizeByStyle2);
        bitmapLayer.setX(f16);
        RotatePhoneLayer rotatePhoneLayer = this.mPhoneLayer;
        if (rotatePhoneLayer != null) {
            bitmapLayer.setY(rotatePhoneLayer.getY() - i3);
        }
        return bitmapLayer;
    }

    private float getBgClickCenterY() {
        if (isPadStyle()) {
            if (getWidth() > getHeight()) {
                return getHeight() + Utils.getRelativeSize1334(getContext(), 885);
            }
            return getHeight() + Utils.getRelativeSize1334(getContext(), 182);
        }
        return getSubtitleTextY() + Utils.getRelativeSize375(getContext(), 42);
    }

    private float getBgClickCircleRadius() {
        int relativeSize375;
        if (isPadStyle()) {
            if (getWidth() > getHeight()) {
                relativeSize375 = Utils.getRelativeSize1334(getContext(), 1585);
            } else {
                relativeSize375 = Utils.getRelativeSize1334(getContext(), 882);
            }
        } else {
            relativeSize375 = Utils.getRelativeSize375(getContext(), 230);
        }
        return relativeSize375;
    }

    private int getBottomPaddingPx() {
        if (isPadStyle()) {
            return (int) Utils.dp2px(this.mBottomPadding);
        }
        int i3 = this.mBottomPaddingDp;
        if (i3 > 0) {
            return (int) Utils.dp2px(i3);
        }
        return Utils.getRelativeSize(getContext(), this.mBottomPadding);
    }

    private int getPhoneMarginBottom() {
        if (isPadStyle()) {
            return Utils.getRelativeSize1334(getContext(), 24);
        }
        return Utils.getRelativeSize(getContext(), 7);
    }

    private int getRelativeSizeByStyle(Context context, int i3) {
        if (isPadStyle()) {
            return Utils.getRelativeSize1334(context, i3);
        }
        return Utils.getRelativeSize(context, i3);
    }

    private float getRelativeSizePad(int i3) {
        return Utils.getRelativeSize1334(getContext(), i3);
    }

    private int getTextBottomMarginPx() {
        int i3 = this.mTextBottomMarginDp;
        if (i3 > 0) {
            return (int) Utils.dp2px(i3);
        }
        return getRelativeSizeByStyle(getContext(), this.mTextBottomMargin);
    }

    private float getTitleTextSize() {
        if (isPadStyle()) {
            return getRelativeSizePad(42);
        }
        return Utils.dp2px(18.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isClickInBottomPaddingArea(float f16, float f17) {
        if (getBottomPaddingPx() == 0 || f17 <= getHeight() - r3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isClickInCircle(float f16, float f17) {
        if (((float) Math.sqrt(Math.pow(Math.abs((getWidth() / 2.0f) - f16), 2.0d) + Math.pow(Math.abs(getBgClickCenterY() - f17), 2.0d))) <= getBgClickCircleRadius()) {
            return true;
        }
        return false;
    }

    private boolean isPadStyle() {
        if (this.mStyle == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            this.mPosterAnimatorView.addLayer(animatorLayer);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) animatorLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.mPosterAnimatorView.clearCanvas();
            this.mGestureAnimatorView.clearCanvas();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            this.mPosterAnimatorView.clearLayers();
            this.mGestureAnimatorView.clearLayers();
        }
    }

    protected AnimatorLayer createBgClickLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        CircleShapeLayer circleShapeLayer = new CircleShapeLayer(getWidth() / 2.0f, getBgClickCenterY(), getBgClickCircleRadius());
        circleShapeLayer.setShader(new LinearGradient(circleShapeLayer.getX(), circleShapeLayer.getY(), circleShapeLayer.getX(), getHeight(), new int[]{1291845632, 0}, (float[]) null, Shader.TileMode.MIRROR));
        circleShapeLayer.setAnimator(new KeepAnimator(circleShapeLayer));
        return circleShapeLayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createBgShaderLayer() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        if (this.mEnableShowBgShadow) {
            if (this.mShowMode == 1) {
                i3 = 628;
            } else {
                i3 = 480;
            }
            int relativeSizeByStyle = getRelativeSizeByStyle(getContext(), i3);
            int[] iArr = {DEFAULT_BG_SHADER_COLOR_START, DEFAULT_BG_SHADER_COLOR_END};
            int width = getWidth();
            int height = getHeight() - getBottomPaddingPx();
            float f16 = height - relativeSizeByStyle;
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
            this.mBgShaderLayer = pathShapeLayer;
            this.mBgShaderLayer.setAnimator(new KeepAnimator(pathShapeLayer));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GroupLayer createGroupLayer(@NonNull List<AnimatorLayer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (GroupLayer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
        }
        return new GroupLayer((AnimatorLayer[]) list.toArray(new AnimatorLayer[0]));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createIconLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        int relativeSizeByStyle = getRelativeSizeByStyle(getContext(), 260);
        float height = getHeight() - getRelativeSizeByStyle(getContext(), 124);
        BitmapLayer bitmapLayer = new BitmapLayer(this.mIconBitmap);
        this.mIconLayer = bitmapLayer;
        bitmapLayer.setWidth(relativeSizeByStyle);
        this.mIconLayer.setHeight(relativeSizeByStyle);
        this.mIconLayer.setX((getWidth() - relativeSizeByStyle) / 2.0f);
        this.mIconLayer.setY(height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createIconShakeAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        float f16 = -getRelativeSizeByStyle(getContext(), 20);
        TranslateAnimator translateAnimator = new TranslateAnimator(this.mIconLayer, 0.0f, 0.0f, 0.0f, f16);
        translateAnimator.setDuration(720L);
        translateAnimator.setPathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        TranslateAnimator translateAnimator2 = new TranslateAnimator(this.mIconLayer, 0.0f, 0.0f, f16, 0.0f);
        translateAnimator2.setDuration(400L);
        translateAnimator2.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        KeepAnimator keepAnimator = new KeepAnimator(this.mIconLayer);
        keepAnimator.setDuration(560L);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.mIconLayer, translateAnimator, translateAnimator2, keepAnimator);
        this.mIconShakeAnimator = sequentialAnimator;
        sequentialAnimator.setRepeatCount(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createPhoneLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        RotatePhoneLayer rotatePhoneLayer = new RotatePhoneLayer(getContext(), this.mStyle);
        this.mPhoneLayer = rotatePhoneLayer;
        rotatePhoneLayer.setX((getWidth() - this.mPhoneLayer.getWidth()) / 2.0f);
        RotatePhoneLayer rotatePhoneLayer2 = this.mPhoneLayer;
        rotatePhoneLayer2.setY(getPhoneBottom(rotatePhoneLayer2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextLayer createTextLayer(String str, int i3, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (TextLayer) iPatchRedirector.redirect((short) 35, this, str, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
        }
        TextLayer textLayer = new TextLayer(str, i3, f16);
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(getWidth() / 2.0f);
        textLayer.setY(f17);
        textLayer.setTextBold(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.isActionDownInFreeModeButton) {
                        return false;
                    }
                }
            }
            FreeModeSplashLayerHelper.OnFreeModeButtonClickListener onFreeModeButtonClickListener = this.mFreeModeButtonClickListener;
            if (this.isActionDownInFreeModeButton) {
                if (FreeModeSplashLayerHelper.isClickInFreeModeButton(motionEvent.getX(), motionEvent.getY()) && onFreeModeButtonClickListener != null) {
                    onFreeModeButtonClickListener.onFreeModeButtonClick(motionEvent.getX(), motionEvent.getY());
                }
                this.isActionDownInFreeModeButton = false;
                return false;
            }
        } else if (FreeModeSplashLayerHelper.isClickInFreeModeButton(motionEvent.getX(), motionEvent.getY())) {
            this.isActionDownInFreeModeButton = true;
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Rect generateSlideRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Rect) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        Rect rect = this.mHotAreaRect;
        if (rect != null) {
            return rect;
        }
        Rect rect2 = new Rect();
        getLocalVisibleRect(rect2);
        if (rect2.width() != 0 && rect2.height() != 0) {
            rect2.left = (int) this.mHotAreaLeftMargin;
            rect2.right = (int) (rect2.right - this.mHotAreaRightMargin);
            int i3 = (int) (rect2.bottom - this.mHotAreaBottomMargin);
            rect2.bottom = i3;
            rect2.top = (int) (i3 - this.mHotAreaHeight);
            this.mHotAreaRect = rect2;
            Logger.i(TAG, "generateSlideRect: " + this.mHotAreaRect);
            return this.mHotAreaRect;
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public List<AnimatorLayer> getLayerList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.mPosterAnimatorView.getLayerList();
    }

    public float getPhoneBottom(AnimatorLayer animatorLayer) {
        int height;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Float) iPatchRedirector.redirect((short) 59, (Object) this, (Object) animatorLayer)).floatValue();
        }
        float titleTextY = getTitleTextY();
        if (animatorLayer == null) {
            height = 0;
        } else {
            height = animatorLayer.getHeight();
        }
        return ((titleTextY - Utils.getTextPaintHeight(getTitleTextSize())) - getPhoneMarginBottom()) - height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getSubTitleTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Float) iPatchRedirector.redirect((short) 37, (Object) this)).floatValue();
        }
        if (isPadStyle()) {
            return getRelativeSizePad(32);
        }
        return Utils.dp2px(14.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getSubtitleTextY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Float) iPatchRedirector.redirect((short) 43, (Object) this)).floatValue();
        }
        getContext();
        return ((getHeight() - getBottomPaddingPx()) - getTextBottomMarginPx()) - Utils.getTextPaintBaselineToBottom(getSubTitleTextSize());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getTitleTextY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Float) iPatchRedirector.redirect((short) 44, (Object) this)).floatValue();
        }
        return ((getSubtitleTextY() - Utils.getTextPaintHeight(getSubTitleTextSize())) - getRelativeSizeByStyle(getContext(), 5)) - Utils.getTextPaintBaselineToBottom(getTitleTextSize());
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (getWidth() > 0 && getHeight() > 0) {
            if (this.mShowMode == 0) {
                createTextLayer();
            }
            createPhoneLayer();
            createArrowLayer();
            createGesturePathLayer();
            createIconLayer();
            createIconShakeAnimator();
            ArrayList arrayList = new ArrayList();
            if (this.mEnableClick) {
                int bottomPaddingPx = getBottomPaddingPx();
                if (bottomPaddingPx > 0) {
                    BrokenLayer brokenLayer = new BrokenLayer(new Rect(0, getHeight() - bottomPaddingPx, getWidth(), getHeight()));
                    brokenLayer.setAnimator(new KeepAnimator(brokenLayer));
                    arrayList.add(brokenLayer);
                }
                arrayList.add(createBgClickLayer());
            } else {
                createBgShaderLayer();
                arrayList.add(this.mBgShaderLayer);
            }
            arrayList.add(this.mPhoneLayer);
            arrayList.add(this.mSubTitleLayer);
            arrayList.add(this.mTitleLayer);
            arrayList.add(this.mArrowLayer1);
            arrayList.add(this.mArrowLayer2);
            arrayList.add(this.mIconLayer);
            addRewardImageLayer(arrayList);
            if (this.mShowMode == 1 && this.mPhoneLayer != null) {
                FreeModeSplashLayerHelper.buildFreeModeCardLayers(getContext(), arrayList, getWidth(), Utils.dp2px(20.0f) + this.mPhoneLayer.getY() + this.mPhoneLayer.getHeight(), this.mTextOne, this.mTextTwo, this.mTextThree, this.mTextFour);
            }
            addLayer(createGroupLayer(arrayList));
            this.mGestureAnimatorView.addLayer(this.mGesturePathLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public boolean isUserStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.mPosterAnimatorView.isUserStarted();
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        float f19 = -f16;
        if (f19 < 0.0f) {
            this.mSensor.resetRotation();
        }
        if (f19 > this.mMaxAngle) {
            this.mMaxAngle = f19;
        }
        OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
        if (onSlopSlideInteractListener != null) {
            onSlopSlideInteractListener.onInteractProgress(f19);
        }
        if (f19 > 5.0f || this.mIsRotationStarted) {
            if (!this.mIsRotationStarted) {
                RotatePhoneLayer rotatePhoneLayer = this.mPhoneLayer;
                if (rotatePhoneLayer != null) {
                    rotatePhoneLayer.start();
                }
                if (onSlopSlideInteractListener != null) {
                    onSlopSlideInteractListener.onInteractStart(1, null);
                }
                this.mIsRotationStarted = true;
            }
            RotatePhoneLayer rotatePhoneLayer2 = this.mPhoneLayer;
            if (rotatePhoneLayer2 != null) {
                rotatePhoneLayer2.postRotateX(f19);
                this.mPhoneLayer.postProgress(f19 / this.mRotationThreshold);
            }
        }
        if (f19 > this.mRotationThreshold) {
            RotationSensor rotationSensor = this.mSensor;
            if (rotationSensor != null) {
                rotationSensor.stop();
            }
            if (onSlopSlideInteractListener != null) {
                onSlopSlideInteractListener.onInteractFinish(1, true, null);
            }
            onInteractSuccess(1, null);
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor.OnRotationChangeListener
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
            return;
        }
        OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
        if (onSlopSlideInteractListener != null) {
            onSlopSlideInteractListener.onSensorError();
        }
    }

    protected void onInteractCallBack() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        synchronized (this) {
            OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
            if (onSlopSlideInteractListener != null) {
                int i18 = 1;
                if (!this.mIsInteractSuccess) {
                    if (this.mMaxAngle >= 5.0f) {
                        onSlopSlideInteractListener.onInteractFinish(1, false, null);
                        i3 = 4;
                    } else {
                        i3 = this.mSlideErrorType;
                        if (i3 != 0) {
                            i18 = 2;
                        } else {
                            i16 = 1;
                            i17 = 0;
                            onSlopSlideInteractListener.onInteractResult(i17, false, i16, null, this.mMaxAngle);
                        }
                    }
                    i16 = i3;
                    i17 = i18;
                    onSlopSlideInteractListener.onInteractResult(i17, false, i16, null, this.mMaxAngle);
                } else if (!this.mAnimatorFinished) {
                    this.mAnimatorFinished = true;
                    onSlopSlideInteractListener.onAnimatorFinish();
                }
            }
        }
    }

    protected synchronized void onInteractSuccess(@InteractType int i3, Point point) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) point);
            return;
        }
        if (!this.mIsInteractSuccess) {
            this.mIsInteractSuccess = true;
            OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
            if (onSlopSlideInteractListener != null) {
                onSlopSlideInteractListener.onInteractResult(i3, true, 0, point, this.mMaxAngle);
            }
            startEndAnimation(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SlopeSlideView.this);
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SlopeSlideView slopeSlideView = SlopeSlideView.this;
                    slopeSlideView.mAnimatorFinished = true;
                    OnSlopSlideInteractListener onSlopSlideInteractListener2 = slopeSlideView.mOnSlopeSlideInteractListener;
                    if (onSlopSlideInteractListener2 != null) {
                        onSlopSlideInteractListener2.onAnimatorFinish();
                    }
                }
            });
            if (onSlopSlideInteractListener != null) {
                onSlopSlideInteractListener.onAnimatorStart();
            }
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
            start();
        }
        if (this.mAnimatorFinished) {
            updateEndUI();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mIsInteractSuccess) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mGesturePathLayer != null) {
            if (this.mHotAreaRect == null) {
                Rect generateSlideRect = generateSlideRect();
                this.mHotAreaRect = generateSlideRect;
                if (generateSlideRect != null) {
                    this.mGesturePathLayer.setHotAreaRect(generateSlideRect);
                }
            }
            return this.mGesturePathLayer.processEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.mPosterAnimatorView.pauseAnimation();
        this.mGestureAnimatorView.pauseAnimation();
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) animatorLayer);
        } else {
            this.mPosterAnimatorView.removeLayer(animatorLayer);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            this.mIsRotationStarted = false;
            clearLayers();
            init();
            resetIconLayers();
            startAnimation();
        } catch (Throwable th5) {
            Logger.e(TAG, "reset error.", th5);
        }
    }

    protected void resetIconLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        BitmapLayer bitmapLayer = this.mIconLayer;
        if (bitmapLayer != null) {
            bitmapLayer.setAnimator(this.mIconShakeAnimator);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void resumeAnimation() {
        RotationSensor rotationSensor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.mPosterAnimatorView.resumeAnimation();
        this.mGestureAnimatorView.resumeAnimation();
        if (!this.mIsInteractSuccess && (rotationSensor = this.mSensor) != null) {
            rotationSensor.resume();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) animatorListener);
        } else {
            this.mPosterAnimatorView.setAnimationListener(animatorListener);
        }
    }

    public void setBottomPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
        } else if (i3 > 0) {
            this.mBottomPadding = i3;
        }
    }

    public void setBottomPaddingDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else if (i3 > 0) {
            this.mBottomPaddingDp = i3;
        }
    }

    public void setCheckGestureMatchWhenTouchDown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
        } else {
            this.mCheckGestureMatchWhenTouchDown = z16;
        }
    }

    public void setEnableClick(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, z16);
        } else {
            this.mEnableClick = z16;
        }
    }

    public void setEnableShowBgShadow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, z16);
        } else {
            this.mEnableShowBgShadow = z16;
        }
    }

    public void setEnableShowStroke(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, z16);
            return;
        }
        this.mEnableShowStroke = z16;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setEnableShowStroke(z16);
        }
    }

    public void setFreeModeClickListener(FreeModeSplashLayerHelper.OnFreeModeButtonClickListener onFreeModeButtonClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onFreeModeButtonClickListener);
        } else {
            this.mFreeModeButtonClickListener = onFreeModeButtonClickListener;
        }
    }

    public void setFreeModeText(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, str4);
            return;
        }
        this.mTextOne = str;
        this.mTextTwo = str2;
        this.mTextThree = str3;
        this.mTextFour = str4;
    }

    public void setHotArea(int i3, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        if (getContext() != null && getContext().getResources() != null) {
            Resources resources = getContext().getResources();
            this.mHotAreaLeftMargin = TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics());
            this.mHotAreaRightMargin = TypedValue.applyDimension(i3, f17, resources.getDisplayMetrics());
            this.mHotAreaBottomMargin = TypedValue.applyDimension(i3, f18, resources.getDisplayMetrics());
            this.mHotAreaHeight = TypedValue.applyDimension(i3, f19, resources.getDisplayMetrics());
        }
    }

    public void setHotAreaWithDp(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            setHotArea(1, f16, f17, f18, f19);
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) bitmap);
        } else {
            int relativeSizeByStyle = getRelativeSizeByStyle(getContext(), 260);
            this.mIconBitmap = Utils.createBitmap(bitmap, relativeSizeByStyle, relativeSizeByStyle, true);
        }
    }

    public void setOnSlopeSlideInteractListener(OnSlopSlideInteractListener onSlopSlideInteractListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) onSlopSlideInteractListener);
        } else {
            this.mOnSlopeSlideInteractListener = onSlopSlideInteractListener;
        }
    }

    public void setRewardImage(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap);
        } else {
            this.mRewardImage = bitmap;
        }
    }

    public void setRotationThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Float.valueOf(f16));
        } else if (f16 > 0.0f) {
            this.mRotationThreshold = f16;
        }
    }

    public void setShowMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mShowMode = i3;
        }
    }

    public void setSlideThreshold(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        if (getContext() != null && getContext().getResources() != null) {
            float applyDimension = TypedValue.applyDimension(i3, f16, getContext().getResources().getDisplayMetrics());
            this.mSlideThreshold = applyDimension;
            GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
            if (gesturePathLayer != null) {
                gesturePathLayer.setSlideThreshold(applyDimension);
            }
        }
    }

    public void setSlideThresholdWithDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, Float.valueOf(f16));
        } else {
            setSlideThreshold(1, f16);
        }
    }

    public void setStrokeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, i3);
            return;
        }
        this.mStorkColor = i3;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setStrokeColor(i3);
        }
    }

    public void setStrokeWidthDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Float.valueOf(f16));
            return;
        }
        this.mStrokeWidthDp = f16;
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            gesturePathLayer.setStrokeWidth(Utils.dp2px(f16));
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        } else {
            this.mSubTitle = str;
        }
    }

    public void setTextBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, i3);
        } else if (i3 > 0) {
            this.mTextBottomMargin = i3;
        }
    }

    public void setTextBottomMarginDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, i3);
        } else if (i3 > 0) {
            this.mTextBottomMarginDp = i3;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
        } else {
            this.mTitle = str;
        }
    }

    public void setViewsShowOnTop(AnimatorView.ViewShowOnTop[] viewShowOnTopArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) viewShowOnTopArr);
        } else {
            this.mPosterAnimatorView.setViewsShowOnTop(viewShowOnTopArr);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.mIsUserStarted = true;
        if (getWidth() > 0 && getHeight() > 0) {
            reset();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            startAnimation(true);
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    protected void startEndAnimation(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) animatorListener);
        } else {
            createIconFlyAnimator(animatorListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.mIsUserStarted = false;
        this.mPosterAnimatorView.stopAnimation();
        this.mGestureAnimatorView.stopAnimation();
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.stop();
        }
        onInteractCallBack();
    }

    public void updateEnableOrientationCheck(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.updateEnableOrientationCheck(z16);
        }
    }

    protected void updateEndUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void updateStyle(@STYLE int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mStyle = i3;
        }
    }

    public SlopeSlideView(Context context, @STYLE int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.mMaxAngle = 0.0f;
        this.mSlideErrorType = 0;
        this.mRotationThreshold = 40.0f;
        this.mStorkColor = -1;
        this.mEnableShowStroke = true;
        this.mEnableShowBgShadow = true;
        this.mEnableClick = false;
        this.mStrokeWidthDp = 8.0f;
        this.mBottomPadding = 0;
        this.mBottomPaddingDp = 0;
        this.mTextBottomMargin = 167;
        this.mStyle = 0;
        this.mShowMode = 0;
        this.isActionDownInFreeModeButton = false;
        this.mCheckGestureMatchWhenTouchDown = true;
        AnimatorView animatorView = new AnimatorView(context);
        this.mPosterAnimatorView = animatorView;
        addView(animatorView);
        AnimatorView animatorView2 = new AnimatorView(context);
        this.mGestureAnimatorView = animatorView2;
        addView(animatorView2);
        this.mStyle = i3;
        RotationSensor rotationSensor = new RotationSensor(getContext(), isPadStyle());
        this.mSensor = rotationSensor;
        rotationSensor.setOnRotationChangeListener(this);
        this.mConfiguration = ViewConfiguration.get(context);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            this.mPosterAnimatorView.addLayer(i3, animatorLayer);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) animatorLayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAnimation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        this.mPosterAnimatorView.startAnimation();
        this.mGestureAnimatorView.startAnimation();
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor == null || !z16) {
            return;
        }
        rotationSensor.start();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.mPosterAnimatorView.stopAnimation(z16, z17);
            this.mGestureAnimatorView.stopAnimation(z16, z17);
        }
    }

    protected void createTextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            this.mSubTitleLayer = createTextLayer(this.mSubTitle, SUBTITLE_TEXT_COLOR, getSubTitleTextSize(), getSubtitleTextY());
            this.mTitleLayer = createTextLayer(this.mTitle, -1, getTitleTextSize(), getTitleTextY());
        }
    }
}
