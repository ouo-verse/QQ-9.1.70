package com.tencent.richframework.widget.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.refresh.R$styleable;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshContent;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.DimensionStatus;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.richframework.widget.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.tencent.richframework.widget.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.tencent.richframework.widget.refresh.layout.listener.DefaultRefreshInitializer;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.richframework.widget.refresh.layout.listener.ScrollBoundaryDecider;
import com.tencent.richframework.widget.refresh.layout.util.SmartUtil;
import com.tencent.richframework.widget.refresh.layout.wrapper.RefreshContentWrapper;
import com.tencent.richframework.widget.refresh.layout.wrapper.RefreshFooterWrapper;
import com.tencent.richframework.widget.refresh.layout.wrapper.RefreshHeaderWrapper;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes25.dex */
public class SmartRefreshLayout extends ViewGroup implements IRefreshLayout, NestedScrollingParent {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableDisallowIntercept;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected DimensionStatus mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected DimensionStatus mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected IRefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected NestedScrollingChildHelper mNestedChild;
    protected boolean mNestedInProgress;
    protected NestedScrollingParentHelper mNestedParent;
    protected OnMultiListener mOnMultiListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected IRefreshContent mRefreshContent;
    protected IRefreshComponent mRefreshFooter;
    protected IRefreshComponent mRefreshHeader;
    protected OnRefreshListener mRefreshListener;
    protected int mScreenHeightPixels;
    protected ScrollBoundaryDecider mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected float mTwoLevelBottomPullUpToCloseRate;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout$10, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout$7, reason: invalid class name */
    /* loaded from: classes25.dex */
    public class AnonymousClass7 implements Runnable {
        int count = 0;
        final /* synthetic */ int val$more;
        final /* synthetic */ boolean val$noMoreData;
        final /* synthetic */ boolean val$success;

        AnonymousClass7(int i3, boolean z16, boolean z17) {
            this.val$more = i3;
            this.val$noMoreData = z16;
            this.val$success = z17;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        
            if (r6.mRefreshContent.canLoadMore() != false) goto L49;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            int i16;
            int i17 = this.count;
            long j3 = 0;
            boolean z16 = true;
            if (i17 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.mState;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Loading) {
                    smartRefreshLayout.mViceState = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.reboundAnimator.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.reboundAnimator = null;
                        if (smartRefreshLayout2.mKernel.animSpinner(0) == null) {
                            SmartRefreshLayout.this.notifyStateChanged(refreshState2);
                        } else {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpCanceled);
                        }
                    } else if (refreshState == RefreshState.Loading && smartRefreshLayout.mRefreshFooter != null && smartRefreshLayout.mRefreshContent != null) {
                        this.count = i17 + 1;
                        smartRefreshLayout.mHandler.postDelayed(this, this.val$more);
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadFinish);
                        return;
                    }
                }
                if (this.val$noMoreData) {
                    SmartRefreshLayout.this.setNoMoreData(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int onFinish = smartRefreshLayout3.mRefreshFooter.onFinish(smartRefreshLayout3, this.val$success);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            OnMultiListener onMultiListener = smartRefreshLayout4.mOnMultiListener;
            if (onMultiListener != null) {
                IRefreshComponent iRefreshComponent = smartRefreshLayout4.mRefreshFooter;
                if (iRefreshComponent instanceof IRefreshFooter) {
                    onMultiListener.onFooterFinish((IRefreshFooter) iRefreshComponent, this.val$success);
                }
            }
            if (onFinish < Integer.MAX_VALUE) {
                if (this.val$noMoreData) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.mEnableFooterFollowWhenNoMoreData) {
                        if (smartRefreshLayout5.mSpinner < 0) {
                        }
                    }
                }
                z16 = false;
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                int i18 = smartRefreshLayout6.mSpinner;
                if (z16) {
                    i3 = Math.max(i18, -smartRefreshLayout6.mFooterHeight);
                } else {
                    i3 = 0;
                }
                final int i19 = i18 - i3;
                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                if (smartRefreshLayout7.mIsBeingDragged || smartRefreshLayout7.mNestedInProgress) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.mIsBeingDragged) {
                        float f16 = smartRefreshLayout8.mLastTouchY;
                        smartRefreshLayout8.mTouchY = f16;
                        smartRefreshLayout8.mTouchSpinner = smartRefreshLayout8.mSpinner - i19;
                        smartRefreshLayout8.mIsBeingDragged = false;
                        if (smartRefreshLayout8.mEnableFooterTranslationContent) {
                            i16 = i19;
                        } else {
                            i16 = 0;
                        }
                        float f17 = i16;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout8.mLastTouchX, f16 + f17 + (smartRefreshLayout8.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout9.mLastTouchX, smartRefreshLayout9.mLastTouchY + f17, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (smartRefreshLayout10.mNestedInProgress) {
                        smartRefreshLayout10.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout10.mLastTouchX, smartRefreshLayout10.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        smartRefreshLayout11.mNestedInProgress = false;
                        smartRefreshLayout11.mTouchSpinner = 0;
                    }
                }
                Handler handler = SmartRefreshLayout.this.mHandler;
                Runnable runnable = new Runnable() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
                        ValueAnimator valueAnimator2;
                        SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                        if (smartRefreshLayout12.mEnableScrollContentWhenLoaded && i19 < 0) {
                            animatorUpdateListener = smartRefreshLayout12.mRefreshContent.scrollContentWhenFinished(smartRefreshLayout12.mSpinner);
                            if (animatorUpdateListener != null) {
                                animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                            }
                        } else {
                            animatorUpdateListener = null;
                        }
                        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.7.1.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (animator != null && animator.getDuration() == 0) {
                                    return;
                                }
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                                smartRefreshLayout13.mFooterLocked = false;
                                if (anonymousClass7.val$noMoreData) {
                                    smartRefreshLayout13.setNoMoreData(true);
                                }
                                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                                if (smartRefreshLayout14.mState == RefreshState.LoadFinish) {
                                    smartRefreshLayout14.notifyStateChanged(RefreshState.None);
                                }
                            }
                        };
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        int i26 = smartRefreshLayout13.mSpinner;
                        if (i26 > 0) {
                            valueAnimator2 = smartRefreshLayout13.mKernel.animSpinner(0);
                        } else {
                            if (animatorUpdateListener == null && i26 != 0) {
                                if (anonymousClass7.val$noMoreData && smartRefreshLayout13.mEnableFooterFollowWhenNoMoreData) {
                                    int i27 = smartRefreshLayout13.mFooterHeight;
                                    if (i26 >= (-i27)) {
                                        smartRefreshLayout13.notifyStateChanged(RefreshState.None);
                                    } else {
                                        valueAnimator2 = smartRefreshLayout13.mKernel.animSpinner(-i27);
                                    }
                                } else {
                                    valueAnimator2 = smartRefreshLayout13.mKernel.animSpinner(0);
                                }
                            } else {
                                ValueAnimator valueAnimator3 = smartRefreshLayout13.reboundAnimator;
                                if (valueAnimator3 != null) {
                                    valueAnimator3.setDuration(0L);
                                    SmartRefreshLayout.this.reboundAnimator.cancel();
                                    SmartRefreshLayout.this.reboundAnimator = null;
                                }
                                SmartRefreshLayout.this.mKernel.moveSpinner(0, false);
                                SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                            }
                            valueAnimator2 = null;
                        }
                        if (valueAnimator2 != null) {
                            valueAnimator2.addListener(animatorListenerAdapter);
                        } else {
                            animatorListenerAdapter.onAnimationEnd(null);
                        }
                    }
                };
                if (SmartRefreshLayout.this.mSpinner < 0) {
                    j3 = onFinish;
                }
                handler.postDelayed(runnable, j3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout$9, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ SmartRefreshLayout this$0;
        final /* synthetic */ boolean val$animationOnly;
        final /* synthetic */ float val$dragRate;
        final /* synthetic */ int val$duration;

        @Override // java.lang.Runnable
        public void run() {
            float f16;
            SmartRefreshLayout smartRefreshLayout = this.this$0;
            if (smartRefreshLayout.mViceState != RefreshState.Loading) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                this.this$0.reboundAnimator.cancel();
                this.this$0.reboundAnimator = null;
            }
            this.this$0.mLastTouchX = r0.getMeasuredWidth() / 2.0f;
            this.this$0.mKernel.setState(RefreshState.PullUpToLoad);
            IRefreshComponent iRefreshComponent = this.this$0.mRefreshFooter;
            if (iRefreshComponent != null && iRefreshComponent.autoOpen(this.val$duration, this.val$dragRate, this.val$animationOnly)) {
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = this.this$0;
            int i3 = smartRefreshLayout2.mFooterHeight;
            if (i3 == 0) {
                f16 = smartRefreshLayout2.mFooterTriggerRate;
            } else {
                f16 = i3;
            }
            float f17 = this.val$dragRate;
            if (f17 < 10.0f) {
                f17 *= f16;
            }
            smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout2.mSpinner, -((int) f17));
            this.this$0.reboundAnimator.setDuration(this.val$duration);
            this.this$0.reboundAnimator.setInterpolator(new SmartUtil(SmartUtil.INTERPOLATOR_VISCOUS_FLUID));
            this.this$0.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.9.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SmartRefreshLayout smartRefreshLayout3 = AnonymousClass9.this.this$0;
                    if (smartRefreshLayout3.reboundAnimator != null && smartRefreshLayout3.mRefreshFooter != null) {
                        smartRefreshLayout3.mKernel.moveSpinner(((Integer) valueAnimator2.getAnimatedValue()).intValue(), true);
                    }
                }
            });
            this.this$0.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.9.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                    anonymousClass9.this$0.mKernel.onAutoLoadMoreAnimationEnd(animator, anonymousClass9.val$animationOnly);
                }
            });
            this.this$0.reboundAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class BounceRunnable implements Runnable {
        int mSmoothDistance;
        float mVelocity;
        int mFrame = 0;
        int mFrameDelay = 10;
        float mOffset = 0.0f;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();

        BounceRunnable(float f16, int i3) {
            this.mVelocity = f16;
            this.mSmoothDistance = i3;
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
            if (f16 > 0.0f) {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable == this && !smartRefreshLayout.mState.isFinishing) {
                if (Math.abs(smartRefreshLayout.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                    if (this.mSmoothDistance != 0) {
                        double d16 = this.mVelocity;
                        this.mFrame = this.mFrame + 1;
                        this.mVelocity = (float) (d16 * Math.pow(0.44999998807907104d, r2 * 2));
                    } else {
                        double d17 = this.mVelocity;
                        this.mFrame = this.mFrame + 1;
                        this.mVelocity = (float) (d17 * Math.pow(0.8500000238418579d, r2 * 2));
                    }
                } else {
                    double d18 = this.mVelocity;
                    this.mFrame = this.mFrame + 1;
                    this.mVelocity = (float) (d18 * Math.pow(0.949999988079071d, r2 * 2));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f16 = this.mVelocity * ((((float) (currentAnimationTimeMillis - this.mLastTime)) * 1.0f) / 1000.0f);
                if (Math.abs(f16) >= 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    float f17 = this.mOffset + f16;
                    this.mOffset = f17;
                    SmartRefreshLayout.this.moveSpinnerInfinitely(f17);
                    SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout2.mViceState;
                boolean z16 = refreshState.isDragging;
                if (z16 && refreshState.isHeader) {
                    smartRefreshLayout2.mKernel.setState(RefreshState.PullDownCanceled);
                } else if (z16 && refreshState.isFooter) {
                    smartRefreshLayout2.mKernel.setState(RefreshState.PullUpCanceled);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.animationRunnable = null;
                if (Math.abs(smartRefreshLayout3.mSpinner) >= Math.abs(this.mSmoothDistance)) {
                    int min = Math.min(Math.max((int) SmartUtil.px2dp(Math.abs(SmartRefreshLayout.this.mSpinner - this.mSmoothDistance)), 30), 100) * 10;
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    smartRefreshLayout4.animSpinner(this.mSmoothDistance, 0, smartRefreshLayout4.mReboundInterpolator, min);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class FlingRunnable implements Runnable {
        int mOffset;
        float mVelocity;
        int mFrame = 0;
        int mFrameDelay = 10;
        float mDamping = 0.98f;
        long mStartTime = 0;
        long mLastTime = AnimationUtils.currentAnimationTimeMillis();

        FlingRunnable(float f16) {
            this.mVelocity = f16;
            this.mOffset = SmartRefreshLayout.this.mSpinner;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable == this && !smartRefreshLayout.mState.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j3 = currentAnimationTimeMillis - this.mLastTime;
                float pow = (float) (this.mVelocity * Math.pow(this.mDamping, ((float) (currentAnimationTimeMillis - this.mStartTime)) / (1000.0f / this.mFrameDelay)));
                this.mVelocity = pow;
                float f16 = pow * ((((float) j3) * 1.0f) / 1000.0f);
                if (Math.abs(f16) > 1.0f) {
                    this.mLastTime = currentAnimationTimeMillis;
                    int i3 = (int) (this.mOffset + f16);
                    this.mOffset = i3;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mSpinner * i3 > 0) {
                        smartRefreshLayout2.mKernel.moveSpinner(i3, true);
                        SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
                        return;
                    }
                    smartRefreshLayout2.animationRunnable = null;
                    smartRefreshLayout2.mKernel.moveSpinner(0, true);
                    SmartUtil.fling(SmartRefreshLayout.this.mRefreshContent.getScrollableView(), (int) (-this.mVelocity));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.mFooterLocked && f16 > 0.0f) {
                        smartRefreshLayout3.mFooterLocked = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.animationRunnable = null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0057, code lost:
        
            if (r0.mSpinner > r0.mHeaderHeight) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0049, code lost:
        
            if (r0.mSpinner >= (-r0.mFooterHeight)) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Runnable start() {
            RefreshState refreshState;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState2 = smartRefreshLayout.mState;
            if (refreshState2.isFinishing) {
                return null;
            }
            if (smartRefreshLayout.mSpinner != 0) {
                if (refreshState2.isOpening || (smartRefreshLayout.mFooterNoMoreData && smartRefreshLayout.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout.mFooterNoMoreDataEffective && smartRefreshLayout.isEnableRefreshOrLoadMore(smartRefreshLayout.mEnableLoadMore))) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mState == RefreshState.Loading || (smartRefreshLayout2.mFooterNoMoreData && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout2.mFooterNoMoreDataEffective && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableLoadMore))) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.mState == RefreshState.Refreshing) {
                    }
                }
                int i3 = SmartRefreshLayout.this.mSpinner;
                float f16 = this.mVelocity;
                int i16 = 0;
                int i17 = i3;
                while (true) {
                    if (i3 * i17 <= 0) {
                        break;
                    }
                    i16++;
                    f16 = (float) (f16 * Math.pow(this.mDamping, (this.mFrameDelay * i16) / 10.0f));
                    float f17 = ((this.mFrameDelay * 1.0f) / 1000.0f) * f16;
                    if (Math.abs(f17) < 1.0f) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        RefreshState refreshState3 = smartRefreshLayout5.mState;
                        if (!refreshState3.isOpening || ((refreshState3 == (refreshState = RefreshState.Refreshing) && i17 > smartRefreshLayout5.mHeaderHeight) || (refreshState3 != refreshState && i17 < (-smartRefreshLayout5.mFooterHeight)))) {
                            return null;
                        }
                    } else {
                        i17 = (int) (i17 + f17);
                    }
                }
            }
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.mFrameDelay);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class RefreshKernelImpl implements IRefreshKernel {
        public RefreshKernelImpl() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        public ValueAnimator animSpinner(int i3) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i3, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        public IRefreshKernel finishTwoLevel() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == RefreshState.TwoLevel) {
                smartRefreshLayout.mKernel.setState(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    moveSpinner(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    animSpinner(0).setDuration(SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        @NonNull
        public IRefreshLayout getRefreshLayout() {
            return SmartRefreshLayout.this;
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00b8  */
        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public IRefreshKernel moveSpinner(int i3, boolean z16) {
            int i16;
            int i17;
            int i18;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            OnMultiListener onMultiListener;
            int i19;
            ViewGroup.MarginLayoutParams marginLayoutParams2;
            OnMultiListener onMultiListener2;
            int i26;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            IRefreshComponent iRefreshComponent;
            IRefreshComponent iRefreshComponent2;
            IRefreshComponent iRefreshComponent3;
            IRefreshComponent iRefreshComponent4;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mSpinner == i3 && (((iRefreshComponent3 = smartRefreshLayout.mRefreshHeader) == null || !iRefreshComponent3.isSupportHorizontalDrag()) && ((iRefreshComponent4 = SmartRefreshLayout.this.mRefreshFooter) == null || !iRefreshComponent4.isSupportHorizontalDrag()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i27 = smartRefreshLayout2.mSpinner;
            smartRefreshLayout2.mSpinner = i3;
            if (z16) {
                RefreshState refreshState = smartRefreshLayout2.mViceState;
                if (refreshState.isDragging || refreshState.isOpening) {
                    float f16 = i3;
                    float f17 = smartRefreshLayout2.mHeaderTriggerRate;
                    if (f17 < 10.0f) {
                        f17 *= smartRefreshLayout2.mHeaderHeight;
                    }
                    if (f16 > f17) {
                        if (smartRefreshLayout2.mState != RefreshState.ReleaseToTwoLevel) {
                            smartRefreshLayout2.mKernel.setState(RefreshState.ReleaseToRefresh);
                        }
                    } else {
                        float f18 = -i3;
                        float f19 = smartRefreshLayout2.mFooterTriggerRate;
                        if (f19 < 10.0f) {
                            f19 *= smartRefreshLayout2.mFooterHeight;
                        }
                        if (f18 > f19 && !smartRefreshLayout2.mFooterNoMoreData) {
                            smartRefreshLayout2.mKernel.setState(RefreshState.ReleaseToLoad);
                        } else if (i3 < 0 && !smartRefreshLayout2.mFooterNoMoreData) {
                            smartRefreshLayout2.mKernel.setState(RefreshState.PullUpToLoad);
                        } else if (i3 > 0) {
                            smartRefreshLayout2.mKernel.setState(RefreshState.PullDownToRefresh);
                        }
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (smartRefreshLayout3.mRefreshContent != null) {
                if (i3 >= 0) {
                    if (smartRefreshLayout3.isEnableTranslationContent(smartRefreshLayout3.mEnableHeaderTranslationContent, smartRefreshLayout3.mRefreshHeader)) {
                        i26 = i3;
                    } else if (i27 < 0) {
                        i26 = 0;
                    }
                    z17 = true;
                    if (i3 <= 0) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.isEnableTranslationContent(smartRefreshLayout4.mEnableFooterTranslationContent, smartRefreshLayout4.mRefreshFooter)) {
                            i26 = i3;
                        } else if (i27 > 0) {
                            i26 = 0;
                        }
                        z17 = true;
                    }
                    if (z17) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.mRefreshContent.moveSpinner(i26, smartRefreshLayout5.mHeaderTranslationViewId, smartRefreshLayout5.mFooterTranslationViewId);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.mFooterNoMoreData && smartRefreshLayout6.mFooterNoMoreDataEffective && smartRefreshLayout6.mEnableFooterFollowWhenNoMoreData) {
                            IRefreshComponent iRefreshComponent5 = smartRefreshLayout6.mRefreshFooter;
                            if ((iRefreshComponent5 instanceof IRefreshFooter) && iRefreshComponent5.getSpinnerStyle() == SpinnerStyle.Translate) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.isEnableRefreshOrLoadMore(smartRefreshLayout7.mEnableLoadMore)) {
                                    SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(Math.max(0, i26));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.mEnableClipHeaderWhenFixedBehind && (iRefreshComponent2 = smartRefreshLayout8.mRefreshHeader) != null && iRefreshComponent2.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18 && SmartRefreshLayout.this.mHeaderBackgroundColor == 0) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        if (smartRefreshLayout9.mEnableClipFooterWhenFixedBehind && (iRefreshComponent = smartRefreshLayout9.mRefreshFooter) != null && iRefreshComponent.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        if (!z26 && SmartRefreshLayout.this.mFooterBackgroundColor == 0) {
                            z27 = false;
                        } else {
                            z27 = true;
                        }
                        if ((z19 && (i26 >= 0 || i27 > 0)) || (z27 && (i26 <= 0 || i27 < 0))) {
                            smartRefreshLayout2.invalidate();
                        }
                    }
                }
                i26 = 0;
                z17 = false;
                if (i3 <= 0) {
                }
                if (z17) {
                }
            }
            if ((i3 >= 0 || i27 > 0) && SmartRefreshLayout.this.mRefreshHeader != null) {
                int max = Math.max(i3, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i28 = smartRefreshLayout10.mHeaderHeight;
                float f26 = smartRefreshLayout10.mHeaderMaxDragRate;
                if (f26 < 10.0f) {
                    f26 *= i28;
                }
                int i29 = (int) f26;
                float f27 = max * 1.0f;
                float f28 = smartRefreshLayout10.mHeaderTriggerRate;
                if (f28 < 10.0f) {
                    f28 *= i28;
                }
                float f29 = f27 / f28;
                if (!smartRefreshLayout10.isEnableRefreshOrLoadMore(smartRefreshLayout10.mEnableRefresh) && (SmartRefreshLayout.this.mState != RefreshState.RefreshFinish || z16)) {
                    i16 = i29;
                    i17 = i28;
                } else {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i27 != smartRefreshLayout11.mSpinner) {
                        if (smartRefreshLayout11.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.Translate) {
                            SmartRefreshLayout.this.mRefreshHeader.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (smartRefreshLayout12.mHeaderBackgroundColor != 0 && smartRefreshLayout12.mPaint != null && !smartRefreshLayout12.isEnableTranslationContent(smartRefreshLayout12.mEnableHeaderTranslationContent, smartRefreshLayout12.mRefreshHeader)) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshHeader.getSpinnerStyle().scale) {
                            View view = SmartRefreshLayout.this.mRefreshHeader.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            } else {
                                marginLayoutParams = SmartRefreshLayout.sDefaultMarginLP;
                            }
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.mSpinner - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i36 = marginLayoutParams.leftMargin;
                            int i37 = marginLayoutParams.topMargin + SmartRefreshLayout.this.mHeaderInsetStart;
                            view.layout(i36, i37, view.getMeasuredWidth() + i36, view.getMeasuredHeight() + i37);
                        }
                        i16 = i29;
                        i17 = i28;
                        SmartRefreshLayout.this.mRefreshHeader.onMoving(z16, f29, max, i28, i16);
                    } else {
                        i16 = i29;
                        i17 = i28;
                    }
                    if (z16 && SmartRefreshLayout.this.mRefreshHeader.isSupportHorizontalDrag()) {
                        int i38 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        float f36 = smartRefreshLayout13.mLastTouchX;
                        if (width == 0) {
                            i18 = 1;
                        } else {
                            i18 = width;
                        }
                        smartRefreshLayout13.mRefreshHeader.onHorizontalDrag(f36 / i18, i38, width);
                    }
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i27 != smartRefreshLayout14.mSpinner && (onMultiListener = smartRefreshLayout14.mOnMultiListener) != null) {
                    IRefreshComponent iRefreshComponent6 = smartRefreshLayout14.mRefreshHeader;
                    if (iRefreshComponent6 instanceof IRefreshHeader) {
                        onMultiListener.onHeaderMoving((IRefreshHeader) iRefreshComponent6, z16, f29, max, i17, i16);
                    }
                }
            }
            if ((i3 <= 0 || i27 < 0) && SmartRefreshLayout.this.mRefreshFooter != null) {
                int i39 = -Math.min(i3, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i46 = smartRefreshLayout15.mFooterHeight;
                float f37 = smartRefreshLayout15.mFooterMaxDragRate;
                if (f37 < 10.0f) {
                    f37 *= i46;
                }
                int i47 = (int) f37;
                float f38 = i39 * 1.0f;
                float f39 = smartRefreshLayout15.mFooterTriggerRate;
                if (f39 < 10.0f) {
                    f39 *= i46;
                }
                float f46 = f38 / f39;
                if (smartRefreshLayout15.isEnableRefreshOrLoadMore(smartRefreshLayout15.mEnableLoadMore) || (SmartRefreshLayout.this.mState == RefreshState.LoadFinish && !z16)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i27 != smartRefreshLayout16.mSpinner) {
                        if (smartRefreshLayout16.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate) {
                            SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (smartRefreshLayout17.mFooterBackgroundColor != 0 && smartRefreshLayout17.mPaint != null && !smartRefreshLayout17.isEnableTranslationContent(smartRefreshLayout17.mEnableFooterTranslationContent, smartRefreshLayout17.mRefreshFooter)) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshFooter.getSpinnerStyle().scale) {
                            View view2 = SmartRefreshLayout.this.mRefreshFooter.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                            } else {
                                marginLayoutParams2 = SmartRefreshLayout.sDefaultMarginLP;
                            }
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.mSpinner) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i48 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout2.getMeasuredHeight()) - SmartRefreshLayout.this.mFooterInsetStart;
                            view2.layout(i48, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i48, measuredHeight);
                        }
                        SmartRefreshLayout.this.mRefreshFooter.onMoving(z16, f46, i39, i46, i47);
                    }
                    if (z16 && SmartRefreshLayout.this.mRefreshFooter.isSupportHorizontalDrag()) {
                        int i49 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width2 = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        float f47 = smartRefreshLayout18.mLastTouchX;
                        if (width2 == 0) {
                            i19 = 1;
                        } else {
                            i19 = width2;
                        }
                        smartRefreshLayout18.mRefreshFooter.onHorizontalDrag(f47 / i19, i49, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i27 != smartRefreshLayout19.mSpinner && (onMultiListener2 = smartRefreshLayout19.mOnMultiListener) != null) {
                    IRefreshComponent iRefreshComponent7 = smartRefreshLayout19.mRefreshFooter;
                    if (iRefreshComponent7 instanceof IRefreshFooter) {
                        onMultiListener2.onFooterMoving((IRefreshFooter) iRefreshComponent7, z16, f46, i39, i46, i47);
                    }
                }
            }
            return this;
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        public IRefreshKernel onAutoLoadMoreAnimationEnd(Animator animator, boolean z16) {
            if (animator != null && animator.getDuration() == 0) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mRefreshFooter != null) {
                RefreshState refreshState = smartRefreshLayout.mState;
                RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                if (refreshState != refreshState2) {
                    setState(refreshState2);
                }
                SmartRefreshLayout.this.setStateLoading(!z16);
            } else {
                setState(RefreshState.None);
            }
            return this;
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        public IRefreshKernel onAutoRefreshAnimationEnd(Animator animator, boolean z16) {
            if (animator != null && animator.getDuration() == 0) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mRefreshHeader != null) {
                RefreshState refreshState = smartRefreshLayout.mState;
                RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                if (refreshState != refreshState2) {
                    setState(refreshState2);
                }
                SmartRefreshLayout.this.setStateRefreshing(!z16);
            } else {
                setState(RefreshState.None);
            }
            return this;
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        public IRefreshKernel requestDrawBackgroundFor(@NonNull IRefreshComponent iRefreshComponent, int i3) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i3 != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (iRefreshComponent.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i3;
            } else if (iRefreshComponent.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i3;
            }
            return this;
        }

        @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel
        public IRefreshKernel setState(@NonNull RefreshState refreshState) {
            switch (AnonymousClass10.$SwitchMap$com$tencent$richframework$widget$refresh$layout$constant$RefreshState[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.mState;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(refreshState3);
                        return null;
                    }
                    if (smartRefreshLayout.mSpinner != 0) {
                        animSpinner(0);
                        return null;
                    }
                    return null;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.mState.isOpening && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.mState;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout4.notifyStateChanged(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.mState.isOpening && smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        setState(RefreshState.None);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.isOpening && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout7.notifyStateChanged(RefreshState.PullUpCanceled);
                            setState(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.mState.isOpening && smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.mState;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout10.notifyStateChanged(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.mState.isOpening && smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.mState.isOpening && smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.mState.isOpening && smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                default:
                    SmartRefreshLayout.this.notifyStateChanged(refreshState);
                    return null;
            }
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    protected ValueAnimator animSpinner(int i3, int i16, Interpolator interpolator, int i17) {
        if (this.mSpinner == i3) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.animationRunnable = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mSpinner, i3);
        this.reboundAnimator = ofInt;
        ofInt.setDuration(i17);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RefreshState refreshState;
                RefreshState refreshState2;
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.reboundAnimator = null;
                if (smartRefreshLayout.mSpinner == 0 && (refreshState = smartRefreshLayout.mState) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                    smartRefreshLayout.notifyStateChanged(refreshState2);
                    return;
                }
                RefreshState refreshState3 = smartRefreshLayout.mState;
                if (refreshState3 != smartRefreshLayout.mViceState) {
                    smartRefreshLayout.setViceState(refreshState3);
                }
            }
        });
        this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SmartRefreshLayout.this.mKernel.moveSpinner(((Integer) valueAnimator2.getAnimatedValue()).intValue(), false);
            }
        });
        this.reboundAnimator.setStartDelay(i16);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    protected void animSpinnerBounce(float f16) {
        RefreshState refreshState;
        if (this.reboundAnimator == null) {
            if (f16 > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.animationRunnable = new BounceRunnable(f16, this.mHeaderHeight);
                return;
            }
            if (f16 < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
                this.animationRunnable = new BounceRunnable(f16, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new BounceRunnable(f16, 0);
            }
        }
    }

    public boolean autoRefresh() {
        return autoRefresh(this.mAttachedToWindow ? 0 : 400, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, false);
    }

    public IRefreshLayout closeHeaderOrFooter() {
        RefreshState refreshState;
        RefreshState refreshState2 = this.mState;
        RefreshState refreshState3 = RefreshState.None;
        if (refreshState2 == refreshState3 && ((refreshState = this.mViceState) == RefreshState.Refreshing || refreshState == RefreshState.Loading)) {
            this.mViceState = refreshState3;
        }
        if (refreshState2 == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState2 == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mKernel.animSpinner(0) == null) {
            notifyStateChanged(refreshState3);
        } else if (this.mState.isHeader) {
            notifyStateChanged(RefreshState.PullDownCanceled);
        } else {
            notifyStateChanged(RefreshState.PullUpCanceled);
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        float currVelocity;
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && this.mRefreshContent.canRefresh())) || (finalY > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && this.mRefreshContent.canLoadMore()))) {
                if (this.mVerticalPermit) {
                    if (finalY > 0) {
                        currVelocity = -this.mScroller.getCurrVelocity();
                    } else {
                        currVelocity = this.mScroller.getCurrVelocity();
                    }
                    animSpinnerBounce(currVelocity);
                }
                this.mScroller.forceFinished(true);
                return;
            }
            this.mVerticalPermit = true;
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c6, code lost:
    
        if (r2.isFinishing == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ca, code lost:
    
        if (r2.isHeader == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
    
        if (r2.isFinishing == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dc, code lost:
    
        if (r2.isFooter == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0108, code lost:
    
        if (r6 != 3) goto L233;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState;
        char c16;
        RefreshState refreshState2;
        IRefreshComponent iRefreshComponent;
        IRefreshComponent iRefreshComponent2;
        int actionMasked = motionEvent.getActionMasked();
        int i3 = 0;
        boolean z16 = actionMasked == 6;
        int actionIndex = z16 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i16 = 0; i16 < pointerCount; i16++) {
            if (actionIndex != i16) {
                f16 += motionEvent.getX(i16);
                f17 += motionEvent.getY(i16);
            }
        }
        if (z16) {
            pointerCount--;
        }
        float f18 = pointerCount;
        float f19 = f16 / f18;
        float f26 = f17 / f18;
        if ((actionMasked == 6 || actionMasked == 5) && this.mIsBeingDragged) {
            this.mTouchY += f26 - this.mLastTouchY;
        }
        this.mLastTouchX = f19;
        this.mLastTouchY = f26;
        if (this.mNestedInProgress) {
            int i17 = this.mTotalUnconsumed;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i17 == this.mTotalUnconsumed) {
                int i18 = (int) this.mLastTouchX;
                int width = getWidth();
                float f27 = this.mLastTouchX / (width != 0 ? width : 1);
                if (isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mSpinner > 0 && (iRefreshComponent2 = this.mRefreshHeader) != null && iRefreshComponent2.isSupportHorizontalDrag()) {
                    this.mRefreshHeader.onHorizontalDrag(f27, i18, width);
                } else if (isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mSpinner < 0 && (iRefreshComponent = this.mRefreshFooter) != null && iRefreshComponent.isSupportHorizontalDrag()) {
                    this.mRefreshFooter.onHorizontalDrag(f27, i18, width);
                }
            }
            return dispatchTouchEvent;
        }
        if (isEnabled() && (this.mEnableRefresh || this.mEnableLoadMore || this.mEnableOverScrollDrag)) {
            if (this.mHeaderNeedTouchEventWhenRefreshing) {
                RefreshState refreshState3 = this.mState;
                if (!refreshState3.isOpening) {
                }
            }
            if (this.mFooterNeedTouchEventWhenLoading) {
                RefreshState refreshState4 = this.mState;
                if (!refreshState4.isOpening) {
                }
            }
            if (!interceptAnimatorByAction(actionMasked)) {
                RefreshState refreshState5 = this.mState;
                if (!refreshState5.isFinishing && ((refreshState5 != (refreshState = RefreshState.Loading) || !this.mDisableContentWhenLoading) && (refreshState5 != RefreshState.Refreshing || !this.mDisableContentWhenRefresh))) {
                    if (actionMasked != 0) {
                        if (actionMasked == 1) {
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            this.mCurrentVelocity = (int) this.mVelocityTracker.getYVelocity();
                            startFlingIfNeed(0.0f);
                        } else {
                            if (actionMasked == 2) {
                                float f28 = f19 - this.mTouchX;
                                float f29 = f26 - this.mTouchY;
                                this.mVelocityTracker.addMovement(motionEvent);
                                if (!this.mIsBeingDragged && !this.mEnableDisallowIntercept && (c16 = this.mDragDirection) != 'h' && this.mRefreshContent != null) {
                                    if (c16 == 'v' || (Math.abs(f29) >= this.mTouchSlop && Math.abs(f28) < Math.abs(f29))) {
                                        this.mDragDirection = 'v';
                                        if (f29 > 0.0f && (this.mSpinner < 0 || ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.canRefresh()))) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = f26 - this.mTouchSlop;
                                        } else if (f29 < 0.0f && (this.mSpinner > 0 || ((this.mEnableOverScrollDrag || this.mEnableLoadMore) && ((this.mState == refreshState && this.mFooterLocked) || this.mRefreshContent.canLoadMore())))) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = this.mTouchSlop + f26;
                                        }
                                        if (this.mIsBeingDragged) {
                                            f29 = f26 - this.mTouchY;
                                            if (this.mSuperDispatchTouchEvent) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            IRefreshKernel iRefreshKernel = this.mKernel;
                                            int i19 = this.mSpinner;
                                            if (i19 <= 0 && (i19 != 0 || f29 <= 0.0f)) {
                                                refreshState2 = RefreshState.PullUpToLoad;
                                            } else {
                                                refreshState2 = RefreshState.PullDownToRefresh;
                                            }
                                            iRefreshKernel.setState(refreshState2);
                                            ViewParent parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else if (Math.abs(f28) >= this.mTouchSlop && Math.abs(f28) > Math.abs(f29) && this.mDragDirection != 'v') {
                                        this.mDragDirection = 'h';
                                    }
                                }
                                if (this.mIsBeingDragged) {
                                    int i26 = ((int) f29) + this.mTouchSpinner;
                                    RefreshState refreshState6 = this.mViceState;
                                    if ((refreshState6.isHeader && (i26 < 0 || this.mLastSpinner < 0)) || (refreshState6.isFooter && (i26 > 0 || this.mLastSpinner > 0))) {
                                        this.mLastSpinner = i26;
                                        long eventTime = motionEvent.getEventTime();
                                        if (this.mFalsifyEvent == null) {
                                            MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f28, this.mTouchY, 0);
                                            this.mFalsifyEvent = obtain;
                                            super.dispatchTouchEvent(obtain);
                                        }
                                        MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f28, this.mTouchY + i26, 0);
                                        super.dispatchTouchEvent(obtain2);
                                        if (this.mFooterLocked && f29 > this.mTouchSlop && this.mSpinner < 0) {
                                            this.mFooterLocked = false;
                                        }
                                        if (i26 > 0 && ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.canRefresh())) {
                                            this.mLastTouchY = f26;
                                            this.mTouchY = f26;
                                            this.mTouchSpinner = 0;
                                            this.mKernel.setState(RefreshState.PullDownToRefresh);
                                        } else if (i26 >= 0 || !((this.mEnableOverScrollDrag || this.mEnableLoadMore) && this.mRefreshContent.canLoadMore())) {
                                            i3 = i26;
                                        } else {
                                            this.mLastTouchY = f26;
                                            this.mTouchY = f26;
                                            this.mTouchSpinner = 0;
                                            this.mKernel.setState(RefreshState.PullUpToLoad);
                                        }
                                        RefreshState refreshState7 = this.mViceState;
                                        if ((refreshState7.isHeader && i3 < 0) || (refreshState7.isFooter && i3 > 0)) {
                                            if (this.mSpinner != 0) {
                                                moveSpinnerInfinitely(0.0f);
                                            }
                                            return true;
                                        }
                                        if (this.mFalsifyEvent != null) {
                                            this.mFalsifyEvent = null;
                                            obtain2.setAction(3);
                                            super.dispatchTouchEvent(obtain2);
                                        }
                                        obtain2.recycle();
                                        i26 = i3;
                                    }
                                    moveSpinnerInfinitely(i26);
                                    return true;
                                }
                                if (this.mFooterLocked && f29 > this.mTouchSlop && this.mSpinner < 0) {
                                    this.mFooterLocked = false;
                                }
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.mVelocityTracker.clear();
                        this.mDragDirection = 'n';
                        MotionEvent motionEvent2 = this.mFalsifyEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.mFalsifyEvent = null;
                            long eventTime2 = motionEvent.getEventTime();
                            MotionEvent obtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.mTouchX, f26, 0);
                            super.dispatchTouchEvent(obtain3);
                            obtain3.recycle();
                        }
                        overSpinner();
                        if (this.mIsBeingDragged) {
                            this.mIsBeingDragged = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    this.mCurrentVelocity = 0;
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mScroller.forceFinished(true);
                    this.mTouchX = f19;
                    this.mTouchY = f26;
                    this.mLastSpinner = 0;
                    this.mTouchSpinner = this.mSpinner;
                    this.mIsBeingDragged = false;
                    this.mEnableDisallowIntercept = false;
                    this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                    if (this.mState == RefreshState.TwoLevel && this.mTouchY < getMeasuredHeight() * (1.0f - this.mTwoLevelBottomPullUpToCloseRate)) {
                        this.mDragDirection = 'h';
                        return this.mSuperDispatchTouchEvent;
                    }
                    IRefreshContent iRefreshContent = this.mRefreshContent;
                    if (iRefreshContent != null) {
                        iRefreshContent.onActionDown(motionEvent);
                    }
                    return true;
                }
            }
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        View view2;
        Paint paint;
        Paint paint2;
        IRefreshContent iRefreshContent = this.mRefreshContent;
        if (iRefreshContent != null) {
            view2 = iRefreshContent.getView();
        } else {
            view2 = null;
        }
        IRefreshComponent iRefreshComponent = this.mRefreshHeader;
        if (iRefreshComponent != null && iRefreshComponent.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i3 = this.mHeaderBackgroundColor;
                if (i3 != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i3);
                    if (this.mRefreshHeader.getSpinnerStyle().scale) {
                        max = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.Translate) {
                        max = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.mPaint);
                }
                if ((this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.FixedBehind) || this.mRefreshHeader.getSpinnerStyle().scale) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j3);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
        if (iRefreshComponent2 != null && iRefreshComponent2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i16 = this.mFooterBackgroundColor;
                if (i16 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i16);
                    if (this.mRefreshFooter.getSpinnerStyle().scale) {
                        min = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate) {
                        min = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.mPaint);
                }
                if ((this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.FixedBehind) || this.mRefreshFooter.getSpinnerStyle().scale) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j3);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j3);
    }

    public IRefreshLayout finishLoadMore() {
        return finishLoadMore(true);
    }

    public IRefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout
    public IRefreshLayout finishRefresh() {
        return finishRefresh(true);
    }

    public IRefreshLayout finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    @Nullable
    public IRefreshHeader getRefreshHeader() {
        IRefreshComponent iRefreshComponent = this.mRefreshHeader;
        if (iRefreshComponent instanceof IRefreshHeader) {
            return (IRefreshHeader) iRefreshComponent;
        }
        return null;
    }

    @NonNull
    public RefreshState getState() {
        return this.mState;
    }

    protected boolean interceptAnimatorByAction(int i3) {
        if (i3 == 0) {
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.mKernel.setState(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.mKernel.setState(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.setDuration(0L);
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        if (this.reboundAnimator != null) {
            return true;
        }
        return false;
    }

    protected boolean isEnableRefreshOrLoadMore(boolean z16) {
        if (z16 && !this.mEnablePureScrollMode) {
            return true;
        }
        return false;
    }

    protected boolean isEnableTranslationContent(boolean z16, @Nullable IRefreshComponent iRefreshComponent) {
        if (!z16 && !this.mEnablePureScrollMode && iRefreshComponent != null && iRefreshComponent.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        if (this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore)) {
            return true;
        }
        return false;
    }

    protected void moveSpinnerInfinitely(float f16) {
        float f17;
        double d16;
        double d17;
        RefreshState refreshState;
        if (this.mNestedInProgress && !this.mEnableLoadMoreWhenContentNotFull && f16 < 0.0f && !this.mRefreshContent.canLoadMore()) {
            f17 = 0.0f;
        } else {
            f17 = f16;
        }
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f17 > 0.0f) {
            this.mKernel.moveSpinner(Math.min((int) f17, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f17 >= 0.0f) {
            int i3 = this.mHeaderHeight;
            if (f17 < i3) {
                this.mKernel.moveSpinner((int) f17, true);
            } else {
                float f18 = this.mHeaderMaxDragRate;
                if (f18 < 10.0f) {
                    f18 *= i3;
                }
                double d18 = f18 - i3;
                int max = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i16 = this.mHeaderHeight;
                double d19 = max - i16;
                double max2 = Math.max(0.0f, (f17 - i16) * this.mDragRate);
                double d26 = -max2;
                if (d19 == 0.0d) {
                    d19 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) Math.min(d18 * (1.0d - Math.pow(100.0d, d26 / d19)), max2)) + this.mHeaderHeight, true);
            }
        } else if (f17 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i17 = this.mFooterHeight;
            if (f17 > (-i17)) {
                this.mKernel.moveSpinner((int) f17, true);
            } else {
                float f19 = this.mFooterMaxDragRate;
                if (f19 < 10.0f) {
                    f19 *= i17;
                }
                double d27 = f19 - i17;
                int max3 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i18 = this.mFooterHeight;
                double d28 = max3 - i18;
                double d29 = -Math.min(0.0f, (i18 + f17) * this.mDragRate);
                double d36 = -d29;
                if (d28 == 0.0d) {
                    d28 = 1.0d;
                }
                this.mKernel.moveSpinner(((int) (-Math.min(d27 * (1.0d - Math.pow(100.0d, d36 / d28)), d29))) - this.mFooterHeight, true);
            }
        } else if (f17 >= 0.0f) {
            float f26 = this.mHeaderMaxDragRate;
            if (f26 < 10.0f) {
                d17 = this.mHeaderHeight * f26;
            } else {
                d17 = f26;
            }
            double max4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double max5 = Math.max(0.0f, this.mDragRate * f17);
            double d37 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.mKernel.moveSpinner((int) Math.min(d17 * (1.0d - Math.pow(100.0d, d37 / max4)), max5), true);
        } else {
            float f27 = this.mFooterMaxDragRate;
            if (f27 < 10.0f) {
                d16 = this.mFooterHeight * f27;
            } else {
                d16 = f27;
            }
            double max6 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d38 = -Math.min(0.0f, this.mDragRate * f17);
            double d39 = -d38;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            this.mKernel.moveSpinner((int) (-Math.min(d16 * (1.0d - Math.pow(100.0d, d39 / max6)), d38)), true);
        }
        if (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && f17 < 0.0f && (refreshState = this.mState) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            if (this.mDisableContentWhenLoading) {
                this.animationRunnable = null;
                this.mKernel.animSpinner(-this.mFooterHeight);
            }
            setStateDirectLoading(false);
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.5
                @Override // java.lang.Runnable
                public void run() {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    OnLoadMoreListener onLoadMoreListener = smartRefreshLayout.mLoadMoreListener;
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore(smartRefreshLayout);
                    } else if (smartRefreshLayout.mOnMultiListener == null) {
                        smartRefreshLayout.finishLoadMore(2000);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    OnMultiListener onMultiListener = smartRefreshLayout2.mOnMultiListener;
                    if (onMultiListener != null) {
                        onMultiListener.onLoadMore(smartRefreshLayout2);
                    }
                }
            }, this.mReboundDuration);
        }
    }

    protected void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 != refreshState) {
            this.mState = refreshState;
            this.mViceState = refreshState;
            IRefreshComponent iRefreshComponent = this.mRefreshHeader;
            IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
            OnMultiListener onMultiListener = this.mOnMultiListener;
            if (iRefreshComponent != null) {
                iRefreshComponent.onStateChanged(this, refreshState2, refreshState);
            }
            if (iRefreshComponent2 != null) {
                iRefreshComponent2.onStateChanged(this, refreshState2, refreshState);
            }
            if (onMultiListener != null) {
                onMultiListener.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.mFooterLocked = false;
                return;
            }
            return;
        }
        if (this.mViceState != refreshState2) {
            this.mViceState = refreshState2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IRefreshComponent iRefreshComponent;
        super.onAttachedToWindow();
        boolean z16 = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            IRefreshComponent iRefreshComponent2 = this.mRefreshHeader;
            if (this.mRefreshFooter != null) {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z16 = false;
                }
                this.mEnableLoadMore = z16;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    IRefreshComponent iRefreshComponent3 = this.mRefreshHeader;
                    if ((iRefreshComponent3 == null || childAt != iRefreshComponent3.getView()) && ((iRefreshComponent = this.mRefreshFooter) == null || childAt != iRefreshComponent.getView())) {
                        this.mRefreshContent = new RefreshContentWrapper(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int dp2px = SmartUtil.dp2px(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.f228206t4);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                RefreshContentWrapper refreshContentWrapper = new RefreshContentWrapper(textView);
                this.mRefreshContent = refreshContentWrapper;
                refreshContentWrapper.getView().setPadding(dp2px, dp2px, dp2px, dp2px);
            }
            View findViewById = findViewById(this.mFixedHeaderViewId);
            View findViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, findViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                IRefreshContent iRefreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                iRefreshContent.moveSpinner(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            IRefreshComponent iRefreshComponent4 = this.mRefreshHeader;
            if (iRefreshComponent4 != null) {
                iRefreshComponent4.setPrimaryColors(iArr);
            }
            IRefreshComponent iRefreshComponent5 = this.mRefreshFooter;
            if (iRefreshComponent5 != null) {
                iRefreshComponent5.setPrimaryColors(this.mPrimaryColors);
            }
        }
        IRefreshContent iRefreshContent2 = this.mRefreshContent;
        if (iRefreshContent2 != null) {
            super.bringChildToFront(iRefreshContent2.getView());
        }
        IRefreshComponent iRefreshComponent6 = this.mRefreshHeader;
        if (iRefreshComponent6 != null && iRefreshComponent6.getSpinnerStyle().front) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        IRefreshComponent iRefreshComponent7 = this.mRefreshFooter;
        if (iRefreshComponent7 != null && iRefreshComponent7.getSpinnerStyle().front) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.setDuration(0L);
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        IRefreshComponent iRefreshComponent = this.mRefreshHeader;
        if (iRefreshComponent != null && this.mState == RefreshState.Refreshing) {
            iRefreshComponent.onFinish(this, false);
        }
        IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
        if (iRefreshComponent2 != null && this.mState == RefreshState.Loading) {
            iRefreshComponent2.onFinish(this, false);
        }
        if (this.mSpinner != 0) {
            this.mKernel.moveSpinner(0, true);
        }
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            notifyStateChanged(refreshState2);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mFooterLocked = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinishInflate() {
        int i3;
        int i16;
        int i17;
        IRefreshHeader refreshHeaderWrapper;
        boolean z16;
        IRefreshFooter refreshFooterWrapper;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i18 = -1;
            int i19 = 0;
            char c16 = 0;
            while (true) {
                i3 = 2;
                if (i19 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i19);
                if (SmartUtil.isContentView(childAt) && (c16 < 2 || i19 == 1)) {
                    i18 = i19;
                    c16 = 2;
                } else if (!(childAt instanceof IRefreshComponent) && c16 < 1) {
                    if (i19 > 0) {
                        c16 = 1;
                    } else {
                        c16 = 0;
                    }
                    i18 = i19;
                }
                i19++;
            }
            if (i18 >= 0) {
                this.mRefreshContent = new RefreshContentWrapper(super.getChildAt(i18));
                if (i18 == 1) {
                    if (childCount != 3) {
                        i3 = -1;
                    }
                    i16 = 0;
                } else if (childCount == 2) {
                    i16 = -1;
                    i3 = 1;
                }
                for (i17 = 0; i17 < childCount; i17++) {
                    View childAt2 = super.getChildAt(i17);
                    if (i17 != i16 && (i17 == i3 || i16 != -1 || this.mRefreshHeader != null || !(childAt2 instanceof IRefreshHeader))) {
                        if (i17 == i3 || (i3 == -1 && (childAt2 instanceof IRefreshFooter))) {
                            if (!this.mEnableLoadMore && this.mManualLoadMore) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            this.mEnableLoadMore = z16;
                            if (childAt2 instanceof IRefreshFooter) {
                                refreshFooterWrapper = (IRefreshFooter) childAt2;
                            } else {
                                refreshFooterWrapper = new RefreshFooterWrapper(childAt2);
                            }
                            this.mRefreshFooter = refreshFooterWrapper;
                        }
                    } else {
                        if (childAt2 instanceof IRefreshHeader) {
                            refreshHeaderWrapper = (IRefreshHeader) childAt2;
                        } else {
                            refreshHeaderWrapper = new RefreshHeaderWrapper(childAt2);
                        }
                        this.mRefreshHeader = refreshHeaderWrapper;
                    }
                }
                return;
            }
            i16 = -1;
            i3 = -1;
            while (i17 < childCount) {
            }
            return;
        }
        throw new RuntimeException("\u6700\u591a\u53ea\u652f\u63013\u4e2a\u5b50View\uff0cMost only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i19;
        int i26;
        int i27;
        boolean z17;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        boolean z18;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = super.getChildAt(i28);
            if (childAt.getVisibility() != 8 && !ParseCommon.GONE.equals(childAt.getTag(R.id.f87754v8))) {
                IRefreshContent iRefreshContent = this.mRefreshContent;
                boolean z19 = true;
                if (iRefreshContent != null && iRefreshContent.getView() == childAt) {
                    if (isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams3 = sDefaultMarginLP;
                    }
                    int i29 = marginLayoutParams3.leftMargin + paddingLeft;
                    int i36 = marginLayoutParams3.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i29;
                    int measuredHeight = view.getMeasuredHeight() + i36;
                    if (z18 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i37 = this.mHeaderHeight;
                        i36 += i37;
                        measuredHeight += i37;
                    }
                    view.layout(i29, i36, measuredWidth, measuredHeight);
                }
                IRefreshComponent iRefreshComponent = this.mRefreshHeader;
                if (iRefreshComponent != null && iRefreshComponent.getView() == childAt) {
                    if (isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    } else {
                        marginLayoutParams2 = sDefaultMarginLP;
                    }
                    int i38 = marginLayoutParams2.leftMargin;
                    int i39 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i38;
                    int measuredHeight2 = view2.getMeasuredHeight() + i39;
                    if (!z17 && this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.Translate) {
                        int i46 = this.mHeaderHeight;
                        i39 -= i46;
                        measuredHeight2 -= i46;
                    }
                    view2.layout(i38, i39, measuredWidth2, measuredHeight2);
                }
                IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
                if (iRefreshComponent2 != null && iRefreshComponent2.getView() == childAt) {
                    if (!isInEditMode() || !this.mEnablePreviewInEditMode || !isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        z19 = false;
                    }
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    } else {
                        marginLayoutParams = sDefaultMarginLP;
                    }
                    SpinnerStyle spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i47 = marginLayoutParams.leftMargin;
                    int measuredHeight3 = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                            i27 = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
                        } else {
                            i27 = 0;
                        }
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + i27;
                    }
                    if (spinnerStyle == SpinnerStyle.MatchLayout) {
                        measuredHeight3 = marginLayoutParams.topMargin - this.mFooterInsetStart;
                    } else {
                        if (!z19 && spinnerStyle != SpinnerStyle.FixedFront && spinnerStyle != SpinnerStyle.FixedBehind) {
                            if (spinnerStyle.scale && this.mSpinner < 0) {
                                if (isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                    i26 = -this.mSpinner;
                                } else {
                                    i26 = 0;
                                }
                                i19 = Math.max(i26, 0);
                            }
                        } else {
                            i19 = this.mFooterHeight;
                        }
                        measuredHeight3 -= i19;
                    }
                    view3.layout(i47, measuredHeight3, view3.getMeasuredWidth() + i47, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i19;
        int i26;
        int i27;
        int i28;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i29;
        int i36;
        DimensionStatus dimensionStatus;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i37;
        int i38;
        int i39;
        if (isInEditMode() && this.mEnablePreviewInEditMode) {
            z16 = true;
        } else {
            z16 = false;
        }
        int childCount = super.getChildCount();
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        while (i46 < childCount) {
            View childAt = super.getChildAt(i46);
            if (childAt.getVisibility() != 8 && !ParseCommon.GONE.equals(childAt.getTag(R.id.f87754v8))) {
                IRefreshComponent iRefreshComponent = this.mRefreshHeader;
                if (iRefreshComponent != null && iRefreshComponent.getView() == childAt) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams3 = sDefaultMarginLP;
                    }
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams.width);
                    int i49 = this.mHeaderHeight;
                    DimensionStatus dimensionStatus2 = this.mHeaderHeightStatus;
                    i17 = childCount;
                    if (dimensionStatus2.ordinal < DimensionStatus.XmlLayoutUnNotify.ordinal) {
                        int i56 = layoutParams.height;
                        if (i56 > 0) {
                            int i57 = i56 + marginLayoutParams3.bottomMargin + marginLayoutParams3.topMargin;
                            DimensionStatus dimensionStatus3 = DimensionStatus.XmlExactUnNotify;
                            if (dimensionStatus2.canReplaceWith(dimensionStatus3)) {
                                this.mHeaderHeight = layoutParams.height + marginLayoutParams3.bottomMargin + marginLayoutParams3.topMargin;
                                this.mHeaderHeightStatus = dimensionStatus3;
                            }
                            i49 = i57;
                        } else if (i56 == -2 && (this.mRefreshHeader.getSpinnerStyle() != SpinnerStyle.MatchLayout || !this.mHeaderHeightStatus.notified)) {
                            int max = Math.max((View.MeasureSpec.getSize(i16) - marginLayoutParams3.bottomMargin) - marginLayoutParams3.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredHeight > 0) {
                                if (measuredHeight != max) {
                                    DimensionStatus dimensionStatus4 = this.mHeaderHeightStatus;
                                    DimensionStatus dimensionStatus5 = DimensionStatus.XmlWrapUnNotify;
                                    if (dimensionStatus4.canReplaceWith(dimensionStatus5)) {
                                        this.mHeaderHeight = measuredHeight + marginLayoutParams3.bottomMargin + marginLayoutParams3.topMargin;
                                        this.mHeaderHeightStatus = dimensionStatus5;
                                    }
                                }
                                i49 = -1;
                            }
                        }
                    }
                    if (this.mRefreshHeader.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                        i49 = View.MeasureSpec.getSize(i16);
                        i38 = -1;
                        i37 = 0;
                    } else {
                        if (this.mRefreshHeader.getSpinnerStyle().scale && !z16) {
                            if (isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                                i39 = this.mSpinner;
                            } else {
                                i39 = 0;
                            }
                            i37 = 0;
                            i49 = Math.max(0, i39);
                        } else {
                            i37 = 0;
                        }
                        i38 = -1;
                    }
                    if (i49 != i38) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((i49 - marginLayoutParams3.bottomMargin) - marginLayoutParams3.topMargin, i37), 1073741824));
                    }
                    DimensionStatus dimensionStatus6 = this.mHeaderHeightStatus;
                    if (!dimensionStatus6.notified) {
                        float f16 = this.mHeaderMaxDragRate;
                        if (f16 < 10.0f) {
                            f16 *= this.mHeaderHeight;
                        }
                        this.mHeaderHeightStatus = dimensionStatus6.notified();
                        this.mRefreshHeader.onInitialized(this.mKernel, this.mHeaderHeight, (int) f16);
                    }
                    if (z16 && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        i47 += view.getMeasuredWidth();
                        i48 += view.getMeasuredHeight();
                    }
                } else {
                    i17 = childCount;
                }
                IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
                if (iRefreshComponent2 != null && iRefreshComponent2.getView() == childAt) {
                    View view2 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    } else {
                        marginLayoutParams2 = sDefaultMarginLP;
                    }
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i58 = this.mFooterHeight;
                    DimensionStatus dimensionStatus7 = this.mFooterHeightStatus;
                    if (dimensionStatus7.ordinal < DimensionStatus.XmlLayoutUnNotify.ordinal) {
                        int i59 = layoutParams2.height;
                        if (i59 > 0) {
                            i58 = marginLayoutParams2.bottomMargin + i59 + marginLayoutParams2.topMargin;
                            DimensionStatus dimensionStatus8 = DimensionStatus.XmlExactUnNotify;
                            if (dimensionStatus7.canReplaceWith(dimensionStatus8)) {
                                this.mFooterHeight = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.mFooterHeightStatus = dimensionStatus8;
                            }
                        } else if (i59 == -2 && (this.mRefreshFooter.getSpinnerStyle() != SpinnerStyle.MatchLayout || !this.mFooterHeightStatus.notified)) {
                            int max2 = Math.max((View.MeasureSpec.getSize(i16) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE));
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != max2) {
                                    DimensionStatus dimensionStatus9 = this.mFooterHeightStatus;
                                    DimensionStatus dimensionStatus10 = DimensionStatus.XmlWrapUnNotify;
                                    if (dimensionStatus9.canReplaceWith(dimensionStatus10)) {
                                        this.mFooterHeight = measuredHeight2 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.mFooterHeightStatus = dimensionStatus10;
                                    }
                                }
                                i29 = -1;
                                if (this.mRefreshFooter.getSpinnerStyle() != SpinnerStyle.MatchLayout) {
                                    i29 = View.MeasureSpec.getSize(i16);
                                } else if (this.mRefreshFooter.getSpinnerStyle().scale && !z16) {
                                    if (isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                        i36 = -this.mSpinner;
                                    } else {
                                        i36 = 0;
                                    }
                                    i18 = 0;
                                    i29 = Math.max(0, i36);
                                    if (i29 != -1) {
                                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((i29 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i18), 1073741824));
                                    }
                                    dimensionStatus = this.mFooterHeightStatus;
                                    if (!dimensionStatus.notified) {
                                        float f17 = this.mFooterMaxDragRate;
                                        if (f17 < 10.0f) {
                                            f17 *= this.mFooterHeight;
                                        }
                                        this.mFooterHeightStatus = dimensionStatus.notified();
                                        this.mRefreshFooter.onInitialized(this.mKernel, this.mFooterHeight, (int) f17);
                                    }
                                    if (z16 && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                                        i47 += view2.getMeasuredWidth();
                                        i48 += view2.getMeasuredHeight();
                                    }
                                }
                                i18 = 0;
                                if (i29 != -1) {
                                }
                                dimensionStatus = this.mFooterHeightStatus;
                                if (!dimensionStatus.notified) {
                                }
                                if (z16) {
                                    i47 += view2.getMeasuredWidth();
                                    i48 += view2.getMeasuredHeight();
                                }
                            }
                        }
                    }
                    i29 = i58;
                    if (this.mRefreshFooter.getSpinnerStyle() != SpinnerStyle.MatchLayout) {
                    }
                    i18 = 0;
                    if (i29 != -1) {
                    }
                    dimensionStatus = this.mFooterHeightStatus;
                    if (!dimensionStatus.notified) {
                    }
                    if (z16) {
                    }
                } else {
                    i18 = 0;
                }
                IRefreshContent iRefreshContent = this.mRefreshContent;
                if (iRefreshContent != null && iRefreshContent.getView() == childAt) {
                    View view3 = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    } else {
                        marginLayoutParams = sDefaultMarginLP;
                    }
                    if (this.mRefreshHeader != null && isEnableRefreshOrLoadMore(this.mEnableRefresh) && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        i19 = 1;
                    } else {
                        i19 = i18;
                    }
                    if (this.mRefreshFooter != null && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableFooterTranslationContent, this.mRefreshFooter)) {
                        i26 = 1;
                    } else {
                        i26 = i18;
                    }
                    int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams3.width);
                    int paddingTop = getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    if (z16 && i19 != 0) {
                        i27 = this.mHeaderHeight;
                    } else {
                        i27 = i18;
                    }
                    int i65 = paddingTop + i27;
                    if (z16 && i26 != 0) {
                        i28 = this.mFooterHeight;
                    } else {
                        i28 = i18;
                    }
                    view3.measure(childMeasureSpec3, ViewGroup.getChildMeasureSpec(i16, i65 + i28, layoutParams3.height));
                    i47 += view3.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i48 += view3.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                }
            } else {
                i17 = childCount;
            }
            i46++;
            childCount = i17;
        }
        super.setMeasuredDimension(View.resolveSize(Math.max(i47 + getPaddingLeft() + getPaddingRight(), super.getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(i48 + getPaddingTop() + getPaddingBottom(), super.getSuggestedMinimumHeight()), i16));
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        return this.mNestedChild.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f16, float f17) {
        if ((!this.mFooterLocked || f17 <= 0.0f) && !startFlingIfNeed(-f17) && !this.mNestedChild.dispatchNestedPreFling(f16, f17)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr) {
        int i17 = this.mTotalUnconsumed;
        int i18 = 0;
        if (i16 * i17 > 0) {
            if (Math.abs(i16) > Math.abs(this.mTotalUnconsumed)) {
                int i19 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i18 = i19;
            } else {
                this.mTotalUnconsumed -= i16;
                i18 = i16;
            }
            moveSpinnerInfinitely(this.mTotalUnconsumed);
        } else if (i16 > 0 && this.mFooterLocked) {
            int i26 = i17 - i16;
            this.mTotalUnconsumed = i26;
            moveSpinnerInfinitely(i26);
            i18 = i16;
        }
        this.mNestedChild.dispatchNestedPreScroll(i3, i16 - i18, iArr, null);
        iArr[1] = iArr[1] + i18;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18) {
        ScrollBoundaryDecider scrollBoundaryDecider;
        RefreshState refreshState;
        ViewParent parent;
        ScrollBoundaryDecider scrollBoundaryDecider2;
        boolean dispatchNestedScroll = this.mNestedChild.dispatchNestedScroll(i3, i16, i17, i18, this.mParentOffsetInWindow);
        int i19 = i18 + this.mParentOffsetInWindow[1];
        if ((i19 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider2 = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider2.canRefresh(this.mRefreshContent.getView())))) || (i19 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (scrollBoundaryDecider = this.mScrollBoundaryDecider) == null || scrollBoundaryDecider.canLoadMore(this.mRefreshContent.getView()))))) {
            RefreshState refreshState2 = this.mViceState;
            if (refreshState2 == RefreshState.None || refreshState2.isOpening) {
                IRefreshKernel iRefreshKernel = this.mKernel;
                if (i19 > 0) {
                    refreshState = RefreshState.PullUpToLoad;
                } else {
                    refreshState = RefreshState.PullDownToRefresh;
                }
                iRefreshKernel.setState(refreshState);
                if (!dispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i26 = this.mTotalUnconsumed - i19;
            this.mTotalUnconsumed = i26;
            moveSpinnerInfinitely(i26);
        }
        if (this.mFooterLocked && i16 < 0) {
            this.mFooterLocked = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i3);
        this.mNestedChild.startNestedScroll(i3 & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        boolean z16;
        if (isEnabled() && isNestedScrollingEnabled() && (i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.mNestedParent.onStopNestedScroll(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.stopNestedScroll();
    }

    protected void overSpinner() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.mCurrentVelocity > -1000 && this.mSpinner > getHeight() / 2) {
                ValueAnimator animSpinner = this.mKernel.animSpinner(getHeight());
                if (animSpinner != null) {
                    animSpinner.setDuration(this.mFloorDuration);
                    return;
                }
                return;
            }
            if (this.mIsBeingDragged) {
                this.mKernel.finishTwoLevel();
                return;
            }
            return;
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2 && (!this.mEnableFooterFollowWhenNoMoreData || !this.mFooterNoMoreData || !this.mFooterNoMoreDataEffective || this.mSpinner >= 0 || !isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            RefreshState refreshState3 = this.mState;
            RefreshState refreshState4 = RefreshState.Refreshing;
            if (refreshState3 == refreshState4) {
                int i3 = this.mSpinner;
                int i16 = this.mHeaderHeight;
                if (i3 > i16) {
                    this.mKernel.animSpinner(i16);
                    return;
                } else {
                    if (i3 < 0) {
                        this.mKernel.animSpinner(0);
                        return;
                    }
                    return;
                }
            }
            if (refreshState3 == RefreshState.PullDownToRefresh) {
                this.mKernel.setState(RefreshState.PullDownCanceled);
                return;
            }
            if (refreshState3 == RefreshState.PullUpToLoad) {
                this.mKernel.setState(RefreshState.PullUpCanceled);
                return;
            }
            if (refreshState3 == RefreshState.ReleaseToRefresh) {
                this.mKernel.setState(refreshState4);
                return;
            }
            if (refreshState3 == RefreshState.ReleaseToLoad) {
                this.mKernel.setState(refreshState2);
                return;
            }
            if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
                this.mKernel.setState(RefreshState.TwoLevelReleased);
                return;
            }
            if (refreshState3 == RefreshState.RefreshReleased) {
                if (this.reboundAnimator == null) {
                    this.mKernel.animSpinner(this.mHeaderHeight);
                    return;
                }
                return;
            } else if (refreshState3 == RefreshState.LoadReleased) {
                if (this.reboundAnimator == null) {
                    this.mKernel.animSpinner(-this.mFooterHeight);
                    return;
                }
                return;
            } else {
                if (refreshState3 != RefreshState.LoadFinish && this.mSpinner != 0) {
                    this.mKernel.animSpinner(0);
                    return;
                }
                return;
            }
        }
        int i17 = this.mSpinner;
        int i18 = this.mFooterHeight;
        if (i17 < (-i18)) {
            this.mKernel.animSpinner(-i18);
        } else if (i17 > 0) {
            this.mKernel.animSpinner(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        if (ViewCompat.isNestedScrollingEnabled(this.mRefreshContent.getScrollableView())) {
            this.mEnableDisallowIntercept = z16;
            super.requestDisallowInterceptTouchEvent(z16);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout
    public IRefreshLayout setEnableAutoLoadMore(boolean z16) {
        this.mEnableAutoLoadMore = z16;
        return this;
    }

    public IRefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z16) {
        this.mEnableFooterFollowWhenNoMoreData = z16;
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout
    public IRefreshLayout setEnableLoadMore(boolean z16) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z16;
        return this;
    }

    public IRefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z16) {
        this.mEnableLoadMoreWhenContentNotFull = z16;
        IRefreshContent iRefreshContent = this.mRefreshContent;
        if (iRefreshContent != null) {
            iRefreshContent.setEnableLoadMoreWhenContentNotFull(z16);
        }
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout
    public IRefreshLayout setEnableOverScrollBounce(boolean z16) {
        this.mEnableOverScrollBounce = z16;
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout
    public IRefreshLayout setEnableOverScrollDrag(boolean z16) {
        this.mEnableOverScrollDrag = z16;
        return this;
    }

    public IRefreshLayout setEnableRefresh(boolean z16) {
        this.mEnableRefresh = z16;
        return this;
    }

    public IRefreshLayout setFooterHeight(float f16) {
        return setFooterHeightPx(SmartUtil.dp2px(f16));
    }

    public IRefreshLayout setFooterHeightPx(int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (i3 == this.mFooterHeight) {
            return this;
        }
        DimensionStatus dimensionStatus = this.mFooterHeightStatus;
        DimensionStatus dimensionStatus2 = DimensionStatus.CodeExact;
        if (dimensionStatus.canReplaceWith(dimensionStatus2)) {
            this.mFooterHeight = i3;
            IRefreshComponent iRefreshComponent = this.mRefreshFooter;
            if (iRefreshComponent != null && this.mAttachedToWindow && this.mFooterHeightStatus.notified) {
                SpinnerStyle spinnerStyle = iRefreshComponent.getSpinnerStyle();
                if (spinnerStyle != SpinnerStyle.MatchLayout && !spinnerStyle.scale) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = sDefaultMarginLP;
                    }
                    int i16 = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i17 = marginLayoutParams.leftMargin;
                    int measuredHeight = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (spinnerStyle != SpinnerStyle.Translate) {
                        i16 = this.mFooterHeight;
                    }
                    int i18 = measuredHeight - i16;
                    view.layout(i17, i18, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i18);
                }
                float f16 = this.mFooterMaxDragRate;
                if (f16 < 10.0f) {
                    f16 *= this.mFooterHeight;
                }
                this.mFooterHeightStatus = dimensionStatus2;
                this.mRefreshFooter.onInitialized(this.mKernel, this.mFooterHeight, (int) f16);
            } else {
                this.mFooterHeightStatus = DimensionStatus.CodeExactUnNotify;
            }
        }
        return this;
    }

    public IRefreshLayout setFooterMaxDragRate(float f16) {
        this.mFooterMaxDragRate = f16;
        IRefreshComponent iRefreshComponent = this.mRefreshFooter;
        if (iRefreshComponent != null && this.mAttachedToWindow) {
            if (f16 < 10.0f) {
                f16 *= this.mFooterHeight;
            }
            iRefreshComponent.onInitialized(this.mKernel, this.mFooterHeight, (int) f16);
        } else {
            this.mFooterHeightStatus = this.mFooterHeightStatus.unNotify();
        }
        return this;
    }

    public IRefreshLayout setFooterTriggerRate(float f16) {
        this.mFooterTriggerRate = f16;
        return this;
    }

    public IRefreshLayout setHeaderMaxDragRate(float f16) {
        this.mHeaderMaxDragRate = f16;
        IRefreshComponent iRefreshComponent = this.mRefreshHeader;
        if (iRefreshComponent != null && this.mAttachedToWindow) {
            if (f16 < 10.0f) {
                f16 *= this.mHeaderHeight;
            }
            iRefreshComponent.onInitialized(this.mKernel, this.mHeaderHeight, (int) f16);
        } else {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.unNotify();
        }
        return this;
    }

    public IRefreshLayout setHeaderTriggerRate(float f16) {
        this.mHeaderTriggerRate = f16;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z16) {
        this.mEnableNestedScrolling = z16;
        this.mNestedChild.setNestedScrollingEnabled(z16);
    }

    public IRefreshLayout setNoMoreData(boolean z16) {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.Refreshing && z16) {
            finishRefreshWithNoMoreData();
        } else if (refreshState == RefreshState.Loading && z16) {
            finishLoadMoreWithNoMoreData();
        } else if (this.mFooterNoMoreData != z16) {
            this.mFooterNoMoreData = z16;
            IRefreshComponent iRefreshComponent = this.mRefreshFooter;
            if (iRefreshComponent instanceof IRefreshFooter) {
                if (((IRefreshFooter) iRefreshComponent).setNoMoreData(z16)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == SpinnerStyle.Translate && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY(this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(\u4e0d\u652f\u6301NoMoreData\uff0c\u8bf7\u4f7f\u7528[ClassicsFooter]\u6216\u8005[\u81ea\u5b9a\u4e49Footer\u5e76\u5b9e\u73b0setNoMoreData\u65b9\u6cd5\u4e14\u8fd4\u56detrue])").printStackTrace();
                }
            }
        }
        return this;
    }

    public IRefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        boolean z16;
        this.mLoadMoreListener = onLoadMoreListener;
        if (!this.mEnableLoadMore && (this.mManualLoadMore || onLoadMoreListener == null)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mEnableLoadMore = z16;
        return this;
    }

    public IRefreshLayout setOnMultiListener(OnMultiListener onMultiListener) {
        this.mOnMultiListener = onMultiListener;
        return this;
    }

    public IRefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    public IRefreshLayout setRefreshFooter(@NonNull IRefreshFooter iRefreshFooter) {
        return setRefreshFooter(iRefreshFooter, 0, 0);
    }

    protected void setStateDirectLoading(boolean z16) {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                if (z16) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.mOnMultiListener == null) {
                finishLoadMore(2000);
            }
            IRefreshComponent iRefreshComponent = this.mRefreshFooter;
            if (iRefreshComponent != null) {
                float f16 = this.mFooterMaxDragRate;
                if (f16 < 10.0f) {
                    f16 *= this.mFooterHeight;
                }
                iRefreshComponent.onStartAnimator(this, this.mFooterHeight, (int) f16);
            }
            OnMultiListener onMultiListener = this.mOnMultiListener;
            if (onMultiListener != null && (this.mRefreshFooter instanceof IRefreshFooter)) {
                if (z16) {
                    onMultiListener.onLoadMore(this);
                }
                float f17 = this.mFooterMaxDragRate;
                if (f17 < 10.0f) {
                    f17 *= this.mFooterHeight;
                }
                this.mOnMultiListener.onFooterStartAnimator((IRefreshFooter) this.mRefreshFooter, this.mFooterHeight, (int) f17);
            }
        }
    }

    protected void setStateLoading(final boolean z16) {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout.this.setStateDirectLoading(z16);
            }
        };
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(-this.mFooterHeight);
        if (animSpinner != null) {
            animSpinner.addListener(animatorListenerAdapter);
        }
        IRefreshComponent iRefreshComponent = this.mRefreshFooter;
        if (iRefreshComponent != null) {
            float f16 = this.mFooterMaxDragRate;
            if (f16 < 10.0f) {
                f16 *= this.mFooterHeight;
            }
            iRefreshComponent.onReleased(this, this.mFooterHeight, (int) f16);
        }
        OnMultiListener onMultiListener = this.mOnMultiListener;
        if (onMultiListener != null) {
            IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
            if (iRefreshComponent2 instanceof IRefreshFooter) {
                float f17 = this.mFooterMaxDragRate;
                if (f17 < 10.0f) {
                    f17 *= this.mFooterHeight;
                }
                onMultiListener.onFooterReleased((IRefreshFooter) iRefreshComponent2, this.mFooterHeight, (int) f17);
            }
        }
        if (animSpinner == null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing(final boolean z16) {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                OnRefreshListener onRefreshListener = smartRefreshLayout.mRefreshListener;
                if (onRefreshListener != null) {
                    if (z16) {
                        onRefreshListener.onRefresh(smartRefreshLayout);
                    }
                } else if (smartRefreshLayout.mOnMultiListener == null) {
                    smartRefreshLayout.finishRefresh(3000);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                IRefreshComponent iRefreshComponent = smartRefreshLayout2.mRefreshHeader;
                if (iRefreshComponent != null) {
                    float f16 = smartRefreshLayout2.mHeaderMaxDragRate;
                    if (f16 < 10.0f) {
                        f16 *= smartRefreshLayout2.mHeaderHeight;
                    }
                    iRefreshComponent.onStartAnimator(smartRefreshLayout2, smartRefreshLayout2.mHeaderHeight, (int) f16);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                OnMultiListener onMultiListener = smartRefreshLayout3.mOnMultiListener;
                if (onMultiListener != null && (smartRefreshLayout3.mRefreshHeader instanceof IRefreshHeader)) {
                    if (z16) {
                        onMultiListener.onRefresh(smartRefreshLayout3);
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    float f17 = smartRefreshLayout4.mHeaderMaxDragRate;
                    if (f17 < 10.0f) {
                        f17 *= smartRefreshLayout4.mHeaderHeight;
                    }
                    smartRefreshLayout4.mOnMultiListener.onHeaderStartAnimator((IRefreshHeader) smartRefreshLayout4.mRefreshHeader, smartRefreshLayout4.mHeaderHeight, (int) f17);
                }
            }
        };
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator animSpinner = this.mKernel.animSpinner(this.mHeaderHeight);
        if (animSpinner != null) {
            animSpinner.addListener(animatorListenerAdapter);
        }
        IRefreshComponent iRefreshComponent = this.mRefreshHeader;
        if (iRefreshComponent != null) {
            float f16 = this.mHeaderMaxDragRate;
            if (f16 < 10.0f) {
                f16 *= this.mHeaderHeight;
            }
            iRefreshComponent.onReleased(this, this.mHeaderHeight, (int) f16);
        }
        OnMultiListener onMultiListener = this.mOnMultiListener;
        if (onMultiListener != null) {
            IRefreshComponent iRefreshComponent2 = this.mRefreshHeader;
            if (iRefreshComponent2 instanceof IRefreshHeader) {
                float f17 = this.mHeaderMaxDragRate;
                if (f17 < 10.0f) {
                    f17 *= this.mHeaderHeight;
                }
                onMultiListener.onHeaderReleased((IRefreshHeader) iRefreshComponent2, this.mHeaderHeight, (int) f17);
            }
        }
        if (animSpinner == null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    protected boolean startFlingIfNeed(float f16) {
        if (f16 == 0.0f) {
            f16 = this.mCurrentVelocity;
        }
        if (Math.abs(f16) > this.mMinimumVelocity) {
            int i3 = this.mSpinner;
            if (i3 * f16 < 0.0f) {
                RefreshState refreshState = this.mState;
                if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.Loading && (i3 >= 0 || !this.mFooterNoMoreData)) {
                    if (refreshState.isReleaseToOpening) {
                        return true;
                    }
                } else {
                    this.animationRunnable = new FlingRunnable(f16).start();
                    return true;
                }
            }
            if ((f16 < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && i3 >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f16 > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f16), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new NestedScrollingChildHelper(this);
        this.mNestedParent = new NestedScrollingParentHelper(this);
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.mHeaderHeightStatus = dimensionStatus;
        this.mFooterHeightStatus = dimensionStatus;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mTwoLevelBottomPullUpToCloseRate = 0.16666667f;
        this.mKernel = new RefreshKernelImpl();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        this.mReboundInterpolator = new SmartUtil(SmartUtil.INTERPOLATOR_VISCOUS_FLUID);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = SmartUtil.dp2px(60.0f);
        this.mHeaderHeight = SmartUtil.dp2px(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        this.mDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = obtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = obtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i3 = R$styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = obtainStyledAttributes.getBoolean(i3, this.mEnableLoadMore);
        int i16 = R$styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = obtainStyledAttributes.getDimensionPixelOffset(i16, this.mHeaderHeight);
        int i17 = R$styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = obtainStyledAttributes.getDimensionPixelOffset(i17, this.mFooterHeight);
        this.mHeaderInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i18 = R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = obtainStyledAttributes.getBoolean(i18, this.mEnableHeaderTranslationContent);
        int i19 = R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.mEnableFooterTranslationContent = obtainStyledAttributes.getBoolean(i19, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = z16;
        this.mEnableFooterFollowWhenNoMoreData = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z16);
        this.mEnableClipHeaderWhenFixedBehind = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = obtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z17 = obtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z17;
        this.mNestedChild.setNestedScrollingEnabled(z17);
        this.mManualLoadMore = this.mManualLoadMore || obtainStyledAttributes.hasValue(i3);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || obtainStyledAttributes.hasValue(i18);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || obtainStyledAttributes.hasValue(i19);
        this.mHeaderHeightStatus = obtainStyledAttributes.hasValue(i16) ? DimensionStatus.XmlLayoutUnNotify : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = obtainStyledAttributes.hasValue(i17) ? DimensionStatus.XmlLayoutUnNotify : this.mFooterHeightStatus;
        int color = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        obtainStyledAttributes.recycle();
    }

    public boolean autoRefresh(int i3) {
        return autoRefresh(i3, this.mReboundDuration, (this.mHeaderMaxDragRate + this.mHeaderTriggerRate) / 2.0f, false);
    }

    public IRefreshLayout finishLoadMore(int i3) {
        return finishLoadMore(i3, true, false);
    }

    public IRefreshLayout finishRefresh(int i3) {
        return finishRefresh(i3, true, Boolean.FALSE);
    }

    public IRefreshLayout setRefreshFooter(@NonNull IRefreshFooter iRefreshFooter, int i3, int i16) {
        IRefreshComponent iRefreshComponent;
        IRefreshComponent iRefreshComponent2 = this.mRefreshFooter;
        if (iRefreshComponent2 != null) {
            super.removeView(iRefreshComponent2.getView());
        }
        this.mRefreshFooter = iRefreshFooter;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = DimensionStatus.DefaultUnNotify;
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (i3 == 0) {
            i3 = -1;
        }
        if (i16 == 0) {
            i16 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i3, i16);
        ViewGroup.LayoutParams layoutParams2 = iRefreshFooter.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        if (this.mRefreshFooter.getSpinnerStyle().front) {
            super.addView(this.mRefreshFooter.getView(), getChildCount(), layoutParams);
        } else {
            super.addView(this.mRefreshFooter.getView(), 0, layoutParams);
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (iRefreshComponent = this.mRefreshFooter) != null) {
            iRefreshComponent.setPrimaryColors(iArr);
        }
        return this;
    }

    public boolean autoRefresh(int i3, final int i16, final float f16, final boolean z16) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.8
            @Override // java.lang.Runnable
            public void run() {
                float f17;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.mViceState != RefreshState.Refreshing) {
                    return;
                }
                ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                if (valueAnimator != null) {
                    valueAnimator.setDuration(0L);
                    SmartRefreshLayout.this.reboundAnimator.cancel();
                    SmartRefreshLayout.this.reboundAnimator = null;
                }
                SmartRefreshLayout.this.mLastTouchX = r0.getMeasuredWidth() / 2.0f;
                SmartRefreshLayout.this.mKernel.setState(RefreshState.PullDownToRefresh);
                IRefreshComponent iRefreshComponent = SmartRefreshLayout.this.mRefreshHeader;
                if (iRefreshComponent != null && iRefreshComponent.autoOpen(i16, f16, z16)) {
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i17 = smartRefreshLayout2.mHeaderHeight;
                if (i17 == 0) {
                    f17 = smartRefreshLayout2.mHeaderTriggerRate;
                } else {
                    f17 = i17;
                }
                float f18 = f16;
                if (f18 < 10.0f) {
                    f18 *= f17;
                }
                smartRefreshLayout2.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout2.mSpinner, (int) f18);
                SmartRefreshLayout.this.reboundAnimator.setDuration(i16);
                SmartRefreshLayout.this.reboundAnimator.setInterpolator(new SmartUtil(SmartUtil.INTERPOLATOR_VISCOUS_FLUID));
                SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.8.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        if (smartRefreshLayout3.reboundAnimator != null && smartRefreshLayout3.mRefreshHeader != null) {
                            smartRefreshLayout3.mKernel.moveSpinner(((Integer) valueAnimator2.getAnimatedValue()).intValue(), true);
                        }
                    }
                });
                SmartRefreshLayout.this.reboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.8.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        SmartRefreshLayout.this.mKernel.onAutoRefreshAnimationEnd(animator, z16);
                    }
                });
                SmartRefreshLayout.this.reboundAnimator.start();
            }
        };
        setViceState(RefreshState.Refreshing);
        if (i3 > 0) {
            this.mHandler.postDelayed(runnable, i3);
            return true;
        }
        runnable.run();
        return true;
    }

    public IRefreshLayout finishLoadMore(boolean z16) {
        return finishLoadMore(z16 ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z16, false);
    }

    public IRefreshLayout finishRefresh(boolean z16) {
        if (z16) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, null);
    }

    public IRefreshLayout finishLoadMore(int i3, boolean z16, boolean z17) {
        int i16 = i3 >> 16;
        int i17 = (i3 << 16) >> 16;
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(i16, z17, z16);
        if (i17 > 0) {
            this.mHandler.postDelayed(anonymousClass7, i17);
        } else {
            anonymousClass7.run();
        }
        return this;
    }

    public IRefreshLayout finishRefresh(int i3, final boolean z16, final Boolean bool) {
        final int i16 = i3 >> 16;
        int i17 = (i3 << 16) >> 16;
        Runnable runnable = new Runnable() { // from class: com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout.6
            int count = 0;

            @Override // java.lang.Runnable
            public void run() {
                int i18 = this.count;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                if (i18 == 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState == refreshState2 && smartRefreshLayout.mViceState == RefreshState.Refreshing) {
                        smartRefreshLayout.mViceState = refreshState2;
                    } else {
                        ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                        if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                            valueAnimator.setDuration(0L);
                            SmartRefreshLayout.this.reboundAnimator.cancel();
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.reboundAnimator = null;
                            if (smartRefreshLayout2.mKernel.animSpinner(0) == null) {
                                SmartRefreshLayout.this.notifyStateChanged(refreshState2);
                            } else {
                                SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                            }
                        } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.mRefreshHeader != null && smartRefreshLayout.mRefreshContent != null) {
                            this.count = i18 + 1;
                            smartRefreshLayout.mHandler.postDelayed(this, i16);
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshFinish);
                            if (bool == Boolean.FALSE) {
                                SmartRefreshLayout.this.setNoMoreData(false);
                            }
                        }
                    }
                    if (bool == Boolean.TRUE) {
                        SmartRefreshLayout.this.setNoMoreData(true);
                        return;
                    }
                    return;
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                int onFinish = smartRefreshLayout3.mRefreshHeader.onFinish(smartRefreshLayout3, z16);
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                OnMultiListener onMultiListener = smartRefreshLayout4.mOnMultiListener;
                if (onMultiListener != null) {
                    IRefreshComponent iRefreshComponent = smartRefreshLayout4.mRefreshHeader;
                    if (iRefreshComponent instanceof IRefreshHeader) {
                        onMultiListener.onHeaderFinish((IRefreshHeader) iRefreshComponent, z16);
                    }
                }
                if (onFinish < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.mIsBeingDragged || smartRefreshLayout5.mNestedInProgress) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.mIsBeingDragged) {
                            float f16 = smartRefreshLayout6.mLastTouchY;
                            smartRefreshLayout6.mTouchY = f16;
                            smartRefreshLayout6.mTouchSpinner = 0;
                            smartRefreshLayout6.mIsBeingDragged = false;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout6.mLastTouchX, (f16 + smartRefreshLayout6.mSpinner) - (smartRefreshLayout6.mTouchSlop * 2), 0));
                            SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout7.mLastTouchX, smartRefreshLayout7.mLastTouchY + smartRefreshLayout7.mSpinner, 0));
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.mNestedInProgress) {
                            smartRefreshLayout8.mTotalUnconsumed = 0;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout8.mLastTouchX, smartRefreshLayout8.mLastTouchY, 0));
                            SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                            smartRefreshLayout9.mNestedInProgress = false;
                            smartRefreshLayout9.mTouchSpinner = 0;
                        }
                    }
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    int i19 = smartRefreshLayout10.mSpinner;
                    if (i19 > 0) {
                        ValueAnimator animSpinner = smartRefreshLayout10.animSpinner(0, onFinish, smartRefreshLayout10.mReboundInterpolator, smartRefreshLayout10.mReboundDuration);
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        if (smartRefreshLayout11.mEnableScrollContentWhenRefreshed) {
                            animatorUpdateListener = smartRefreshLayout11.mRefreshContent.scrollContentWhenFinished(smartRefreshLayout11.mSpinner);
                        }
                        if (animSpinner != null && animatorUpdateListener != null) {
                            animSpinner.addUpdateListener(animatorUpdateListener);
                            return;
                        }
                        return;
                    }
                    if (i19 < 0) {
                        smartRefreshLayout10.animSpinner(0, onFinish, smartRefreshLayout10.mReboundInterpolator, smartRefreshLayout10.mReboundDuration);
                    } else {
                        smartRefreshLayout10.mKernel.moveSpinner(0, false);
                        SmartRefreshLayout.this.mKernel.setState(RefreshState.None);
                    }
                }
            }
        };
        if (i17 > 0) {
            this.mHandler.postDelayed(runnable, i17);
        } else {
            runnable.run();
        }
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int backgroundColor;
        public SpinnerStyle spinnerStyle;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
            this.backgroundColor = obtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.backgroundColor);
            int i3 = R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.spinnerStyle = SpinnerStyle.values[obtainStyledAttributes.getInt(i3, SpinnerStyle.Translate.ordinal)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.backgroundColor = 0;
            this.spinnerStyle = null;
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
    }

    public static void setDefaultRefreshInitializer(@NonNull DefaultRefreshInitializer defaultRefreshInitializer) {
    }
}
