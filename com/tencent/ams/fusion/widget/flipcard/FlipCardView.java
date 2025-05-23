package com.tencent.ams.fusion.widget.flipcard;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.DrawableLayer;
import com.tencent.ams.fusion.widget.flipcard.FlipCardInteractiveListener;
import com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler;
import com.tencent.ams.fusion.widget.flipcard.IFlipCardView;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardBonusLayer;
import com.tencent.ams.fusion.widget.flipcard.layers.FlipCardBottomTextLayer;
import com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.RotationSensor;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlipCardView extends FrameLayout implements IFlipCardView {
    static IPatchRedirector $redirector_ = null;
    private static final float ROTATION_START_THRESHOLD = 5.0f;
    private static final String TAG = "FlipCardView";

    @NonNull
    private final AnimatorView mAnimatorView;
    private FlipCardBackLayer mBackLayer;
    private FlipCardBonusLayer mBonusLayer;
    private IFlipCardView.BonusPageClickListener mBonusPageClickListener;
    private FlipCardBottomTextLayer mBottomLayer;
    private FlipCardInfo mCardInfo;
    private final ViewConfiguration mConfiguration;
    private final Handler mCountdownHandler;
    private boolean mEndAnimatorFinished;
    private final FlipRotationHandler mFlipRotationHandler;
    private final FlipRotationHandler.IFlipRotationListener mFlipRotationListener;
    private FlipCardFrontLayer mFrontLayer;
    private GesturePathLayer mGesturePathLayer;
    private FlipCardInteractiveListener mInteractListener;
    private boolean mIsClickDownInBonusPageCard;
    private boolean mIsInteractStart;
    private boolean mIsInteractSuccess;
    private final RotationSensor mSensor;

    @FlipCardInteractiveListener.FailReason
    private int mSlideErrorType;

    public FlipCardView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSlideErrorType = 0;
        this.mCountdownHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.2
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlipCardView.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    FlipCardFrontLayer flipCardFrontLayer = FlipCardView.this.mFrontLayer;
                    if (flipCardFrontLayer != null) {
                        flipCardFrontLayer.updateTime();
                    }
                    FlipCardBonusLayer flipCardBonusLayer = FlipCardView.this.mBonusLayer;
                    if (flipCardBonusLayer != null) {
                        flipCardBonusLayer.updateTime();
                    }
                    sendEmptyMessageDelayed(0, 1000L);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
            }
        };
        FlipRotationHandler.IFlipRotationListener iFlipRotationListener = new FlipRotationHandler.IFlipRotationListener() { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlipCardView.this);
                }
            }

            private void updateFrontLayer(float f16, float f17) {
                FlipCardFrontLayer flipCardFrontLayer = FlipCardView.this.mFrontLayer;
                FlipCardInfo flipCardInfo = FlipCardView.this.mCardInfo;
                if (flipCardFrontLayer != null && flipCardInfo != null) {
                    FlipCardView.this.mAnimatorView.postOnAnimation(new Runnable(flipCardFrontLayer, f16, f17) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.8.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ FlipCardFrontLayer val$frontLayer;
                        final /* synthetic */ float val$progress;
                        final /* synthetic */ float val$rotationY;

                        {
                            this.val$frontLayer = flipCardFrontLayer;
                            this.val$rotationY = f16;
                            this.val$progress = f17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass8.this, flipCardFrontLayer, Float.valueOf(f16), Float.valueOf(f17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.val$frontLayer.postRotationY(this.val$rotationY);
                                this.val$frontLayer.postProgress(this.val$progress);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onError() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                    if (flipCardInteractiveListener != null) {
                        flipCardInteractiveListener.onSensorError();
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 8, (Object) this);
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipBackInteractProgress(float f16, float f17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17));
                } else {
                    updateFrontLayer(f16, f17);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipBackInteractStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) {
                    FlipCardInfo flipCardInfo = FlipCardView.this.mCardInfo;
                    FlipCardBottomTextLayer flipCardBottomTextLayer = FlipCardView.this.mBottomLayer;
                    if (flipCardInfo != null && flipCardBottomTextLayer != null) {
                        flipCardBottomTextLayer.setText(flipCardInfo.getReverseSubTitleText());
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 5, (Object) this);
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipInteractFinish(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    return;
                }
                if (FlipCardView.this.mSensor != null) {
                    FlipCardView.this.mSensor.stop();
                }
                FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                if (flipCardInteractiveListener != null) {
                    flipCardInteractiveListener.onInteractFinish(3, z16, null);
                }
                FlipCardView.this.onInteractSuccess(3, null, z17);
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipInteractProgress(float f16, float f17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
                } else {
                    updateFrontLayer(f16, f17);
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onFlipInteractStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                    return;
                }
                if (FlipCardView.this.mFrontLayer != null) {
                    FlipCardView.this.mFrontLayer.startRotationInteractive();
                }
                FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                if (flipCardInteractiveListener != null) {
                    flipCardInteractiveListener.onInteractStart(3, null);
                    FlipCardView.this.mIsInteractStart = true;
                }
            }

            @Override // com.tencent.ams.fusion.widget.flipcard.FlipRotationHandler.IFlipRotationListener
            public void onRotationChanged(float f16, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                    if (flipCardInteractiveListener != null) {
                        if (z16) {
                            flipCardInteractiveListener.onBackInteractProgress(f16);
                            return;
                        } else {
                            flipCardInteractiveListener.onInteractProgress(f16);
                            return;
                        }
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Float.valueOf(f16), Boolean.valueOf(z16));
            }
        };
        this.mFlipRotationListener = iFlipRotationListener;
        AnimatorView animatorView = new AnimatorView(context);
        this.mAnimatorView = animatorView;
        addView(animatorView, new ViewGroup.LayoutParams(-1, -1));
        this.mSensor = new RotationSensor(context);
        this.mConfiguration = ViewConfiguration.get(context);
        FlipRotationHandler flipRotationHandler = new FlipRotationHandler();
        this.mFlipRotationHandler = flipRotationHandler;
        flipRotationHandler.setRotationListener(iFlipRotationListener);
    }

    private AnimatorLayer createBottomShadowLayer(Context context) {
        DrawableLayer drawableLayer = new DrawableLayer(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Integer.MIN_VALUE, 0}));
        int dp2px = (int) (Utils.dp2px(118.0f) + Utils.dp2px(32.0f) + Utils.getRelativeSize375(context, 130));
        drawableLayer.setX(0.0f);
        drawableLayer.setY(getHeight() - dp2px);
        drawableLayer.setWidth(getWidth());
        drawableLayer.setHeight(dp2px);
        drawableLayer.setAnimator(new KeepAnimator(drawableLayer));
        return drawableLayer;
    }

    private FlipCardBottomTextLayer createBottomTextLayer(Context context) {
        FlipCardInfo flipCardInfo = this.mCardInfo;
        if (flipCardInfo == null) {
            return null;
        }
        return new FlipCardBottomTextLayer(context, getWidth() / 2.0f, getHeight() - Utils.dp2px(82.0f), flipCardInfo);
    }

    private GesturePathLayer createGesturePathLayer() {
        boolean z16;
        FlipCardInfo flipCardInfo = this.mCardInfo;
        if (flipCardInfo == null) {
            return null;
        }
        Rect generateSlideRect = generateSlideRect();
        float dp2px = Utils.dp2px(flipCardInfo.getSlideThresholdDp());
        GesturePathLayer gesturePathLayer = new GesturePathLayer(getContext(), generateSlideRect, dp2px);
        gesturePathLayer.setSlideDirections(new int[]{1, 3});
        gesturePathLayer.setStrokeColor(flipCardInfo.getStorkColor());
        boolean isSlideMode = FlipCardAnimationHelper.isSlideMode(flipCardInfo);
        if (flipCardInfo.isEnableShowStroke() && isSlideMode) {
            z16 = true;
        } else {
            z16 = false;
        }
        gesturePathLayer.setEnableShowStroke(z16);
        gesturePathLayer.setStrokeWidth(Utils.dp2px(flipCardInfo.getStrokeWidthDp()));
        gesturePathLayer.setGestureResultListener(new GesturePathLayer.GestureResultListener(isSlideMode, dp2px) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.1
            static IPatchRedirector $redirector_;
            private int mDirection;
            private float mDownX;
            private float mDownY;
            final /* synthetic */ boolean val$isSlideMode;
            final /* synthetic */ float val$slideThreshold;

            {
                this.val$isSlideMode = isSlideMode;
                this.val$slideThreshold = dp2px;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FlipCardView.this, Boolean.valueOf(isSlideMode), Float.valueOf(dp2px));
                }
            }

            private boolean handlerClickResult(float f16, float f17) {
                FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                if (FlipCardView.this.isClickInCard(this.mDownX, this.mDownY) && Utils.isClickEvent(FlipCardView.this.mConfiguration, this.mDownX, this.mDownY, f16, f17)) {
                    if (flipCardInteractiveListener != null) {
                        flipCardInteractiveListener.onInteractFinish(1, true, new Point((int) f16, (int) f17));
                    }
                    FlipCardView.this.onInteractSuccess(1, new Point((int) f16, (int) f17), true);
                    return true;
                }
                if (!this.val$isSlideMode && flipCardInteractiveListener != null) {
                    flipCardInteractiveListener.onInteractFinish(1, false, new Point((int) f16, (int) f17));
                    flipCardInteractiveListener.onInteractResult(1, false, 5, null, 0.0f);
                }
                return false;
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchFinish(boolean z17, int i3, float f16, float f17, float f18, float f19, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z17), Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i16));
                    return;
                }
                Logger.d(FlipCardView.TAG, "onGestureMatchFinish:" + z17);
                FlipCardView.this.mFlipRotationHandler.setIsEnabled(true);
                FlipCardView.this.mSlideErrorType = i3;
                this.mDirection = i16;
                FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                if (this.val$isSlideMode) {
                    if (!z17 && FlipCardAnimationHelper.isClickMode(FlipCardView.this.mCardInfo) && handlerClickResult(f16, f17)) {
                        return;
                    }
                    if (flipCardInteractiveListener != null) {
                        flipCardInteractiveListener.onInteractFinish(2, z17, new Point((int) f16, (int) f17));
                    }
                    FlipCardFrontLayer flipCardFrontLayer = FlipCardView.this.mFrontLayer;
                    if (!z17 && !FlipCardView.this.mIsInteractStart && flipCardFrontLayer != null) {
                        flipCardFrontLayer.setAnimator(new KeepAnimator(flipCardFrontLayer));
                        flipCardFrontLayer.postProgress(0.0f);
                        return;
                    }
                    return;
                }
                handlerClickResult(f16, f17);
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchProgress(float f16, float f17, float f18, float f19, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = true;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3));
                    return;
                }
                if (!this.val$isSlideMode) {
                    return;
                }
                float f26 = 0.0f;
                if (this.val$slideThreshold == 0.0f) {
                    return;
                }
                FlipCardView.this.mFlipRotationHandler.setIsEnabled(false);
                float f27 = f19 / this.val$slideThreshold;
                if (f27 >= 0.0f) {
                    f26 = 1.0f;
                    if (f27 <= 1.0f) {
                        f26 = f27;
                    }
                }
                if (i3 != 1) {
                    z17 = false;
                }
                if (z17) {
                    f26 = -f26;
                }
                FlipCardFrontLayer flipCardFrontLayer = FlipCardView.this.mFrontLayer;
                FlipCardInfo flipCardInfo2 = FlipCardView.this.mCardInfo;
                if (flipCardFrontLayer != null && flipCardInfo2 != null) {
                    FlipCardView.this.mAnimatorView.postOnAnimation(new Runnable(flipCardFrontLayer, f26, flipCardInfo2) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ FlipCardInfo val$cardInfo;
                        final /* synthetic */ float val$finalProgress;
                        final /* synthetic */ FlipCardFrontLayer val$frontLayer;

                        {
                            this.val$frontLayer = flipCardFrontLayer;
                            this.val$finalProgress = f26;
                            this.val$cardInfo = flipCardInfo2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, flipCardFrontLayer, Float.valueOf(f26), flipCardInfo2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.val$frontLayer.postRotationY(this.val$finalProgress * this.val$cardInfo.getRotationThreshold());
                                this.val$frontLayer.postProgress(this.val$finalProgress);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchStart(float f16, float f17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                int i3 = 2;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
                    return;
                }
                this.mDownX = f16;
                this.mDownY = f17;
                FlipCardInteractiveListener flipCardInteractiveListener = FlipCardView.this.mInteractListener;
                if (flipCardInteractiveListener != null) {
                    if (!this.val$isSlideMode) {
                        i3 = 1;
                    }
                    flipCardInteractiveListener.onInteractStart(i3, new Point((int) f16, (int) f17));
                    FlipCardView.this.mIsInteractStart = true;
                }
                FlipCardFrontLayer flipCardFrontLayer = FlipCardView.this.mFrontLayer;
                if (this.val$isSlideMode && flipCardFrontLayer != null) {
                    flipCardFrontLayer.startRotationInteractive();
                }
            }

            @Override // com.tencent.ams.fusion.widget.slopeslide.GesturePathLayer.GestureResultListener
            public void onGestureMatchSuccess(float f16, float f17, float f18) {
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = false;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
                    return;
                }
                if (this.val$isSlideMode) {
                    FlipCardView flipCardView = FlipCardView.this;
                    Point point = new Point((int) f16, (int) f17);
                    if (this.mDirection == 1) {
                        z17 = true;
                    }
                    flipCardView.onInteractSuccess(2, point, z17);
                }
            }
        });
        return gesturePathLayer;
    }

    private AnimatorLayer createTopShadowLayer(Context context) {
        DrawableLayer drawableLayer = new DrawableLayer(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1291845632, 0}));
        int dp2px = (int) Utils.dp2px(114.0f);
        drawableLayer.setX(0.0f);
        drawableLayer.setY(0.0f);
        drawableLayer.setWidth(getWidth());
        drawableLayer.setHeight(dp2px);
        drawableLayer.setAnimator(new KeepAnimator(drawableLayer));
        return drawableLayer;
    }

    private Rect generateSlideRect() {
        FlipCardInfo flipCardInfo = this.mCardInfo;
        if (flipCardInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        if (rect.width() == 0 || rect.height() == 0) {
            return null;
        }
        rect.left = (int) Utils.dp2px(flipCardInfo.getHotAreaLeftMarginDp());
        rect.right = (int) (rect.right - Utils.dp2px(flipCardInfo.getHotAreaRightMarginDp()));
        int dp2px = (int) (rect.bottom - Utils.dp2px(flipCardInfo.getHotAreaBottomMarginDp()));
        rect.bottom = dp2px;
        rect.top = (int) (dp2px - Utils.dp2px(flipCardInfo.getHotAreaHeightDp()));
        Logger.i(TAG, "generateSlideRect: " + rect);
        return rect;
    }

    private boolean hasBonusPage() {
        FlipCardInfo flipCardInfo = this.mCardInfo;
        if (flipCardInfo != null && flipCardInfo.isEnableBonusPage() && flipCardInfo.getBonusCardBitmap() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isClickInCard(float f16, float f17) {
        FlipCardFrontLayer flipCardFrontLayer = this.mFrontLayer;
        if (flipCardFrontLayer != null) {
            return flipCardFrontLayer.getCardRect().contains(f16, f17);
        }
        return false;
    }

    private boolean isClickInEndCard(float f16, float f17) {
        FlipCardBonusLayer flipCardBonusLayer = this.mBonusLayer;
        if (flipCardBonusLayer != null) {
            return flipCardBonusLayer.getRect().contains(f16, f17);
        }
        return false;
    }

    private void onInteractCallBack() {
        int i3;
        int i16;
        synchronized (this) {
            FlipCardInteractiveListener flipCardInteractiveListener = this.mInteractListener;
            if (flipCardInteractiveListener != null) {
                if (!this.mIsInteractSuccess) {
                    if (this.mFlipRotationHandler.getMaxAngle() >= 5.0f) {
                        flipCardInteractiveListener.onInteractFinish(3, false, null);
                        i16 = 4;
                        i3 = 3;
                    } else {
                        int i17 = this.mSlideErrorType;
                        if (i17 != 0) {
                            i16 = i17;
                            i3 = 2;
                        } else {
                            i3 = 3;
                            i16 = 1;
                        }
                    }
                    if (this.mIsInteractStart) {
                        flipCardInteractiveListener.onInteractResult(i3, false, i16, null, this.mFlipRotationHandler.getMaxAngle());
                    }
                } else if (!this.mEndAnimatorFinished) {
                    this.mEndAnimatorFinished = true;
                    flipCardInteractiveListener.onEndAnimationFinish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInteractSuccess(int i3, Point point, boolean z16) {
        RotationSensor rotationSensor = this.mSensor;
        if (rotationSensor != null) {
            rotationSensor.stop();
        }
        if (!this.mIsInteractSuccess) {
            this.mIsInteractSuccess = true;
            FlipCardInteractiveListener flipCardInteractiveListener = this.mInteractListener;
            if (flipCardInteractiveListener != null) {
                flipCardInteractiveListener.onInteractResult(i3, true, 0, point, this.mFlipRotationHandler.getMaxAngle());
            }
            if (hasBonusPage()) {
                startEndAnimationStep1(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlipCardView.this);
                        }
                    }

                    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                    public void onAnimationFinish() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        Logger.i(FlipCardView.TAG, "onAnimationFinish");
                        FlipCardView.this.mEndAnimatorFinished = true;
                        FlipCardInteractiveListener flipCardInteractiveListener2 = FlipCardView.this.mInteractListener;
                        if (flipCardInteractiveListener2 != null) {
                            flipCardInteractiveListener2.onEndAnimationFinish();
                        }
                    }
                }, z16);
                if (flipCardInteractiveListener != null) {
                    flipCardInteractiveListener.onEndAnimationStart();
                    return;
                }
                return;
            }
            FlipCardFrontLayer flipCardFrontLayer = this.mFrontLayer;
            if (flipCardFrontLayer != null) {
                flipCardFrontLayer.setAnimator(new KeepAnimator(flipCardFrontLayer));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDetailBitmapAnimation() {
        FlipCardInfo flipCardInfo = this.mCardInfo;
        if (flipCardInfo != null && flipCardInfo.getDetailBitmap() != null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(this.mCardInfo.getDetailBitmap());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setVisibility(4);
            addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(new Animator.AnimatorListener(imageView) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ ImageView val$imageView;

                {
                    this.val$imageView = imageView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlipCardView.this, (Object) imageView);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                    } else {
                        this.val$imageView.setVisibility(0);
                    }
                }
            });
            ofFloat.start();
        }
    }

    private void startCountdown() {
        this.mCountdownHandler.sendEmptyMessageDelayed(0, 1000L);
    }

    private void startEndAnimationStep1(Animator.AnimatorListener animatorListener, boolean z16) {
        Logger.i(TAG, "startEndAnimationStep1");
        FlipCardFrontLayer flipCardFrontLayer = this.mFrontLayer;
        if (flipCardFrontLayer != null) {
            flipCardFrontLayer.startEndAnimation(new Animator.AnimatorListener(animatorListener, z16) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$clockwise;
                final /* synthetic */ Animator.AnimatorListener val$listener;

                {
                    this.val$listener = animatorListener;
                    this.val$clockwise = z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, FlipCardView.this, animatorListener, Boolean.valueOf(z16));
                    }
                }

                @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
                public void onAnimationFinish() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        Logger.i(FlipCardView.TAG, "startEndAnimationStep1, onAnimationFinish");
                        FlipCardView.this.startEndAnimationStep2(this.val$listener, this.val$clockwise);
                    }
                }
            }, z16);
        }
        post(new Runnable() { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlipCardView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    FlipCardView.this.showDetailBitmapAnimation();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startEndAnimationStep2(Animator.AnimatorListener animatorListener, boolean z16) {
        Logger.i(TAG, "startEndAnimationStep2");
        this.mAnimatorView.removeLayer(this.mFrontLayer);
        this.mFrontLayer = null;
        FlipCardBackLayer flipCardBackLayer = new FlipCardBackLayer(getContext(), getWidth(), getHeight());
        this.mBackLayer = flipCardBackLayer;
        this.mAnimatorView.addLayer(flipCardBackLayer);
        com.tencent.ams.fusion.widget.animatorview.animator.Animator createFlipAnimator = this.mBackLayer.createFlipAnimator(z16);
        createFlipAnimator.setAnimatorListener(new Animator.AnimatorListener(animatorListener) { // from class: com.tencent.ams.fusion.widget.flipcard.FlipCardView.7
            static IPatchRedirector $redirector_;
            final /* synthetic */ Animator.AnimatorListener val$listener;

            {
                this.val$listener = animatorListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlipCardView.this, (Object) animatorListener);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    Logger.i(FlipCardView.TAG, "startEndAnimationStep2, onAnimationFinish");
                    FlipCardView.this.startEndAnimationStep3(this.val$listener);
                }
            }
        });
        this.mBackLayer.setAnimator(createFlipAnimator);
        FlipCardBottomTextLayer flipCardBottomTextLayer = this.mBottomLayer;
        if (flipCardBottomTextLayer != null) {
            flipCardBottomTextLayer.startDismissAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startEndAnimationStep3(Animator.AnimatorListener animatorListener) {
        Logger.i(TAG, "startEndAnimationStep3");
        FlipCardInfo flipCardInfo = this.mCardInfo;
        FlipCardBonusLayer flipCardBonusLayer = new FlipCardBonusLayer(getContext(), flipCardInfo, getWidth(), getHeight());
        this.mBonusLayer = flipCardBonusLayer;
        this.mAnimatorView.addLayer(flipCardBonusLayer);
        this.mBonusLayer.startAlphaAnimation(animatorListener);
        FlipCardBottomTextLayer flipCardBottomTextLayer = this.mBottomLayer;
        if (flipCardBottomTextLayer != null && flipCardInfo != null) {
            flipCardBottomTextLayer.setText(flipCardInfo.getBonusPageText());
            float height = this.mBonusLayer.getHeight() + this.mBonusLayer.getY();
            float textPaintHeight = Utils.getTextPaintHeight(Utils.getRelativeSize375(getContext(), 12));
            float y16 = this.mBottomLayer.getY() - textPaintHeight;
            float relativeSize375 = Utils.getRelativeSize375(getContext(), 12);
            if (y16 - height < relativeSize375) {
                this.mBottomLayer.setY(height + relativeSize375 + textPaintHeight);
            }
            this.mBottomLayer.startShowAnimation();
        }
    }

    private void stopCountdown() {
        this.mCountdownHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IFlipCardView.BonusPageClickListener bonusPageClickListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mEndAnimatorFinished) {
            boolean isClickInEndCard = isClickInEndCard(motionEvent.getX(), motionEvent.getY());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && this.mIsClickDownInBonusPageCard && isClickInEndCard && (bonusPageClickListener = this.mBonusPageClickListener) != null) {
                    bonusPageClickListener.onClick(motionEvent.getX(), motionEvent.getY());
                    this.mIsClickDownInBonusPageCard = false;
                    return true;
                }
            } else if (isClickInEndCard) {
                this.mIsClickDownInBonusPageCard = true;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.mSensor.setOnRotationChangeListener(this.mFlipRotationHandler);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mSensor.setOnRotationChangeListener(null);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mAnimatorView.isUserStarted() && !this.mIsInteractSuccess) {
            start();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mIsInteractSuccess) {
            return super.onTouchEvent(motionEvent);
        }
        GesturePathLayer gesturePathLayer = this.mGesturePathLayer;
        if (gesturePathLayer != null) {
            return gesturePathLayer.processEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mAnimatorView.pauseAnimation();
            this.mSensor.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mAnimatorView.resumeAnimation();
            this.mSensor.resume();
        }
    }

    @Override // com.tencent.ams.fusion.widget.flipcard.IFlipCardView
    public void setBonusPageClickListener(IFlipCardView.BonusPageClickListener bonusPageClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bonusPageClickListener);
        } else {
            this.mBonusPageClickListener = bonusPageClickListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.flipcard.IFlipCardView
    public void setFlipCardInfo(FlipCardInfo flipCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) flipCardInfo);
            return;
        }
        this.mCardInfo = flipCardInfo;
        this.mFlipRotationHandler.setIsEnabled(FlipCardAnimationHelper.isFlipMode(flipCardInfo));
        this.mFlipRotationHandler.setTargetRotationThreshold(flipCardInfo.getRotationThreshold());
        this.mFlipRotationHandler.setReverseRotationThreshold(flipCardInfo.getReverseRotationThreshold());
    }

    @Override // com.tencent.ams.fusion.widget.flipcard.IFlipCardView
    public void setInteractiveListener(FlipCardInteractiveListener flipCardInteractiveListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) flipCardInteractiveListener);
        } else {
            this.mInteractListener = flipCardInteractiveListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        FlipCardInfo flipCardInfo = this.mCardInfo;
        if (flipCardInfo == null) {
            Logger.w(TAG, "start failed: card info not set");
            return;
        }
        this.mAnimatorView.clearLayers();
        this.mAnimatorView.addLayer(createTopShadowLayer(getContext()));
        this.mAnimatorView.addLayer(createBottomShadowLayer(getContext()));
        FlipCardFrontLayer flipCardFrontLayer = new FlipCardFrontLayer(getContext(), getWidth(), getHeight(), flipCardInfo);
        this.mFrontLayer = flipCardFrontLayer;
        this.mAnimatorView.addLayer(flipCardFrontLayer);
        FlipCardBottomTextLayer createBottomTextLayer = createBottomTextLayer(getContext());
        this.mBottomLayer = createBottomTextLayer;
        this.mAnimatorView.addLayer(createBottomTextLayer);
        if (FlipCardAnimationHelper.isSlideMode(flipCardInfo) || FlipCardAnimationHelper.isClickMode(flipCardInfo)) {
            GesturePathLayer createGesturePathLayer = createGesturePathLayer();
            this.mGesturePathLayer = createGesturePathLayer;
            this.mAnimatorView.addLayer(createGesturePathLayer);
        }
        this.mAnimatorView.startAnimation();
        if (flipCardInfo.hasCountDown()) {
            startCountdown();
        }
        this.mSensor.start();
    }

    @Override // com.tencent.ams.fusion.widget.base.AnimatableView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        stopCountdown();
        this.mSensor.stop();
        this.mAnimatorView.stopAnimation();
        onInteractCallBack();
    }
}
