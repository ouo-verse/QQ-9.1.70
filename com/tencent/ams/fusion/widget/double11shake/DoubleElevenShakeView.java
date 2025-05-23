package com.tencent.ams.fusion.widget.double11shake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.CircleShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.DrawableLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.base.ShakeView;
import com.tencent.ams.fusion.widget.double11shake.DoubleElevenShakeAnimationHelper;
import com.tencent.ams.fusion.widget.olympicshake.OnShakeListener;
import com.tencent.ams.fusion.widget.olympicshake.ShakeSensor;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DoubleElevenShakeView extends AnimatorView implements ShakeView<DoubleElevenShakeListener>, OnShakeListener {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_SUB_TITLE_SIZE_DP = 14;
    private static final int DEFAULT_TITLE_SIZE_DP = 18;
    private static final int SHADOW_END_COLOR = 0;
    private static final int SHADOW_START_COLOR = 2130706432;
    private static final float SHAKE_BG_CIRCLE_RADIUS_DP = 65.0f;
    private static final float SHAKE_ICON_HEIGHT_DP = 90.0f;
    private static final float SHAKE_ICON_TITLE_PADDING_DP = 16.0f;
    private static final float SHAKE_ICON_WIDTH_DP = 90.0f;
    private static final float SUB_TITLE_BOTTOM_PADDING_DP = 42.0f;
    private static final String TAG = "DoubleElevenShakeView";
    private static final float TITLE_SUB_TITLE_PADDING_DP = 4.0f;
    protected int mAnimationType;
    private float mBottomPaddingDp;
    protected float mIconZoomFactor;
    private int mInteractiveMode;
    private boolean mIsStop;
    private boolean mIsTouchDownInShakeCircle;
    private boolean mSensorEventsDeliveredOnMainThread;
    private int[] mShakeDirectcombine;
    private int mShakeDuration;
    private float mShakeFactorX;
    private float mShakeFactorY;
    private float mShakeFactorZ;
    private String mShakeIconBgCircleColor;
    private Bitmap mShakeIconBitmap;
    private DoubleElevenShakeListener mShakeListener;
    private int mShakeSampleRate;
    private ShakeSensor mShakeSensor;
    private float mShakeThreshold;
    private int mShakeValidCount;
    private String mSubTitleText;
    private int mSubTitleTextSizeDp;
    private String mTitleText;
    private int mTitleTextSizeDp;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimationType {
        public static final int BREATHING = 2;
        public static final int NO_ANIMATION = 1;
        public static final int SHAKE = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface InteractiveMode {
        public static final int MODE_CLICK = 2;
        public static final int MODE_CLICK_SHAKE = 3;
        public static final int MODE_SHAKE = 1;
    }

    public DoubleElevenShakeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mShakeThreshold = 3.0f;
        this.mShakeValidCount = 60;
        this.mShakeFactorX = 1.0f;
        this.mShakeFactorY = 1.0f;
        this.mShakeFactorZ = 0.5f;
        this.mShakeDuration = 0;
        this.mShakeSampleRate = 60;
        this.mShakeDirectcombine = null;
        this.mTitleTextSizeDp = 18;
        this.mSubTitleTextSizeDp = 14;
        this.mSensorEventsDeliveredOnMainThread = true;
        this.mIconZoomFactor = 1.0f;
        ShakeSensor shakeSensor = new ShakeSensor(getContext());
        this.mShakeSensor = shakeSensor;
        shakeSensor.setShakeListener(this);
    }

    private AnimatorLayer createBgShadowLayer() {
        DrawableLayer drawableLayer = new DrawableLayer(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{2130706432, 0}));
        int height = (int) ((getHeight() - getShakeIconCenterY()) + getShakeCircleBgRadius() + Utils.dp2px(10.0f));
        drawableLayer.setX(0.0f);
        drawableLayer.setY(getHeight() - height);
        drawableLayer.setWidth(getWidth());
        drawableLayer.setHeight(height);
        drawableLayer.setAnimator(new KeepAnimator(drawableLayer));
        return drawableLayer;
    }

    private AnimatorLayer createCircleBgLayer() {
        CircleShapeLayer circleShapeLayer = new CircleShapeLayer(getWidth() / 2.0f, getShakeIconCenterY(), getShakeCircleBgRadius(), getShakeCircleBgColor());
        circleShapeLayer.setAnimator(new KeepAnimator(circleShapeLayer));
        return circleShapeLayer;
    }

    private Bitmap createShakeIconBitmap() {
        Bitmap bitmap = this.mShakeIconBitmap;
        if (bitmap != null) {
            return Utils.scaleBitmapSafe(bitmap, (int) getShakeIconWidth(), (int) getShakeIconHeight());
        }
        return Utils.bitmapFromBase64StringSafe(DoubleElevenShakeAnimationHelper.SHAKE_ICON_BASE64, (int) getShakeIconWidth(), (int) getShakeIconHeight());
    }

    private AnimatorLayer createSubTitleLayer() {
        TextLayer textLayer = new TextLayer(this.mSubTitleText, -1, Utils.dp2px(this.mSubTitleTextSizeDp));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(getWidth() / 2.0f);
        textLayer.setY(getSubTitleLayerY());
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private AnimatorLayer createTitleLayer() {
        TextLayer textLayer = new TextLayer(this.mTitleText, -1, Utils.dp2px(this.mTitleTextSizeDp));
        textLayer.setTextAlign(Paint.Align.CENTER);
        textLayer.setX(getWidth() / 2.0f);
        textLayer.setY(getTitleLayerY());
        textLayer.setShadowLayer(1.0f, 1.0f, 1.0f, Utils.buildColorFromARGB(0.2f, 0.0f, 0.0f, 0.0f));
        textLayer.setTextBold(true);
        textLayer.setAnimator(new KeepAnimator(textLayer));
        return textLayer;
    }

    private int getShakeCircleBgColor() {
        if (!TextUtils.isEmpty(this.mShakeIconBgCircleColor)) {
            try {
                return Color.parseColor(this.mShakeIconBgCircleColor);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    private float getShakeIconBgBottomPadding() {
        return Utils.dp2px(getBottomPaddingDp() + 16.0f + 4.0f) + getTitleTextPaintHeight() + getSubTitleTextPaintHeight();
    }

    private float getSubTitleLayerY() {
        return (getHeight() - Utils.dp2px(getBottomPaddingDp())) - Utils.getTextPaintBaselineToBottom(Utils.dp2px(this.mSubTitleTextSizeDp));
    }

    private float getSubTitleTextPaintHeight() {
        return Utils.getTextPaintHeight(Utils.dp2px(this.mSubTitleTextSizeDp));
    }

    private float getTitleLayerY() {
        return ((getSubTitleLayerY() - Utils.getTextPaintBaselineToTop(Utils.dp2px(this.mSubTitleTextSizeDp))) - Utils.dp2px(4.0f)) - Utils.getTextPaintBaselineToBottom(Utils.dp2px(this.mTitleTextSizeDp));
    }

    private float getTitleTextPaintHeight() {
        return Utils.getTextPaintHeight(Utils.dp2px(this.mTitleTextSizeDp));
    }

    private boolean isTouchDownInShakeCircle(float f16, float f17) {
        if (((float) Math.sqrt(Math.pow(Math.abs((getWidth() / 2.0f) - f16), 2.0d) + Math.pow(Math.abs(getShakeIconCenterY() - f17), 2.0d))) <= getShakeCircleBgRadius()) {
            return true;
        }
        return false;
    }

    private void reset() {
        this.mIsStop = false;
        clearLayers();
    }

    private void startShakeAnimation() {
        if (this.mIsStop) {
            return;
        }
        addLayer(new GroupLayer(createBgShadowLayer(), createCircleBgLayer(), createShakeIconLayer(), createTitleLayer(), createSubTitleLayer()));
        startAnimation();
    }

    protected AnimatorLayer createShakeIconLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return DoubleElevenShakeAnimationHelper.getShakeIconAnimatorLayer(createShakeIconBitmap(), this.mAnimationType, new DoubleElevenShakeAnimationHelper.IconParams((getWidth() / 2.0f) - (getShakeIconWidth() / 2.0f), getShakeIconCenterY() - (getShakeIconHeight() / 2.0f), getShakeIconWidth(), getShakeIconHeight(), this.mIconZoomFactor), (Animator.AnimatorListener) null);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i3;
        DoubleElevenShakeListener doubleElevenShakeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (isUserStarted() && ((i3 = this.mInteractiveMode) == 2 || i3 == 3)) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.mIsTouchDownInShakeCircle && (doubleElevenShakeListener = this.mShakeListener) != null) {
                        doubleElevenShakeListener.onShakeIconClick();
                    }
                    this.mIsTouchDownInShakeCircle = false;
                }
            } else if (isTouchDownInShakeCircle(motionEvent.getX(), motionEvent.getY())) {
                this.mIsTouchDownInShakeCircle = true;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getBottomPaddingDp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Float) iPatchRedirector.redirect((short) 30, (Object) this)).floatValue();
        }
        float f16 = this.mBottomPaddingDp;
        if (f16 > 0.0f) {
            return f16;
        }
        return SUB_TITLE_BOTTOM_PADDING_DP;
    }

    public PointF getShakeAnimViewCenterPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (PointF) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return new PointF(getWidth() / 2.0f, getShakeIconCenterY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getShakeCircleBgRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Float) iPatchRedirector.redirect((short) 32, (Object) this)).floatValue();
        }
        return Utils.dp2px(SHAKE_BG_CIRCLE_RADIUS_DP) * this.mIconZoomFactor;
    }

    public float getShakeIconCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Float) iPatchRedirector.redirect((short) 31, (Object) this)).floatValue();
        }
        return getHeight() - (getShakeIconBgBottomPadding() + getShakeCircleBgRadius());
    }

    protected float getShakeIconHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Float) iPatchRedirector.redirect((short) 34, (Object) this)).floatValue();
        }
        return Utils.dp2px(90.0f) * this.mIconZoomFactor;
    }

    protected float getShakeIconWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Float) iPatchRedirector.redirect((short) 33, (Object) this)).floatValue();
        }
        return Utils.dp2px(90.0f) * this.mIconZoomFactor;
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Double.valueOf(d16));
            return;
        }
        stop();
        DoubleElevenShakeListener doubleElevenShakeListener = this.mShakeListener;
        if (doubleElevenShakeListener != null) {
            doubleElevenShakeListener.onShakeComplete(d16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        DoubleElevenShakeListener doubleElevenShakeListener = this.mShakeListener;
        if (doubleElevenShakeListener != null) {
            doubleElevenShakeListener.onShaking(d16, i3);
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
        if (isUserStarted()) {
            start();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        pauseAnimation();
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        resumeAnimation();
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.resume();
        }
    }

    public void setBottomPaddingDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            this.mBottomPaddingDp = f16;
        }
    }

    public void setInteractiveMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mInteractiveMode = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setSensorEventsDeliveredOnMainThread(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mSensorEventsDeliveredOnMainThread = z16;
        }
    }

    public void setShakeCircleBgColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.mShakeIconBgCircleColor = str;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeDirectCombine(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr);
        } else {
            this.mShakeDirectcombine = iArr;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.mShakeFactorX = f16;
        this.mShakeFactorY = f17;
        this.mShakeFactorZ = f18;
    }

    @Deprecated
    public void setShakeIconAnimation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else if (!z16) {
            setShakeIconAnimationType(1);
        } else {
            setShakeIconAnimationType(3);
        }
    }

    public void setShakeIconAnimationType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mAnimationType = i3;
        }
    }

    public void setShakeIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bitmap);
        } else {
            this.mShakeIconBitmap = bitmap;
        }
    }

    public void setShakeIconZoomFactor(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
            return;
        }
        if (f16 > 0.0f) {
            float screenWidth = Utils.getScreenWidth(getContext());
            float dp2px = Utils.dp2px(SHAKE_BG_CIRCLE_RADIUS_DP) * 2.0f;
            if (screenWidth > 0.0f && dp2px * f16 > screenWidth) {
                this.mIconZoomFactor = screenWidth / dp2px;
                Logger.w(TAG, "setShakeIconZoomFactor : factor(" + f16 + ") is too large, correct it to (" + this.mIconZoomFactor + ")");
                return;
            }
            this.mIconZoomFactor = f16;
            return;
        }
        Logger.w(TAG, "setShakeIconZoomFactor failed: invalid factor(" + f16 + ")");
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mShakeSampleRate = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeTimeDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mShakeDuration = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Integer.valueOf(i3));
        } else {
            this.mShakeThreshold = f16;
            this.mShakeValidCount = i3;
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mSubTitleText = str;
        }
    }

    public void setSubTitleTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.mSubTitleTextSizeDp = i3;
            return;
        }
        Logger.w(TAG, "Set sub title text size with an invalid value: " + i3);
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mTitleText = str;
        }
    }

    public void setTitleTextSizeDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.mTitleTextSizeDp = i3;
            return;
        }
        Logger.w(TAG, "Set title text size with an invalid value: " + i3);
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        reset();
        startShakeAnimation();
        int i3 = this.mInteractiveMode;
        if (i3 == 1 || i3 == 3) {
            ShakeSensor shakeSensor = this.mShakeSensor;
            if (shakeSensor == null) {
                shakeSensor = new ShakeSensor(getContext());
                shakeSensor.setShakeListener(this);
                this.mShakeSensor = shakeSensor;
            }
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
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            stop(true);
        } else {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    private void stop(boolean z16) {
        Logger.i(TAG, "stop clearCanvas:" + z16);
        this.mIsStop = true;
        stopAnimation(z16, true);
        ShakeSensor shakeSensor = this.mShakeSensor;
        if (shakeSensor != null) {
            shakeSensor.unregister();
        }
        this.mShakeSensor = null;
    }

    @Override // com.tencent.ams.fusion.widget.base.ShakeView
    public void setOnShakeListener(DoubleElevenShakeListener doubleElevenShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mShakeListener = doubleElevenShakeListener;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) doubleElevenShakeListener);
        }
    }
}
