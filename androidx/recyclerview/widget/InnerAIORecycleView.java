package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.AIOOverScroller;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes.dex */
public class InnerAIORecycleView extends RecyclerView {
    private static final String TAG = "InnerAIORecycleView";
    private static Field viewFlingFiled;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private int mOriginFlingVelocity;
    private float maxFlingRate;
    private float realFlingRate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ViewFlinger extends RecyclerView.ViewFlinger {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        AIOOverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;

        ViewFlinger() {
            super();
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new AIOOverScroller(InnerAIORecycleView.this.getContext(), interpolator);
            com.tencent.aio.base.log.a.f69187b.d(InnerAIORecycleView.TAG, "change viewFlinger success ");
        }

        private int computeScrollDuration(int i3, int i16, int i17, int i18) {
            boolean z16;
            int height;
            int i19;
            int abs = Math.abs(i3);
            int abs2 = Math.abs(i16);
            if (abs > abs2) {
                z16 = true;
            } else {
                z16 = false;
            }
            int sqrt = (int) Math.sqrt((i17 * i17) + (i18 * i18));
            int sqrt2 = (int) Math.sqrt((i3 * i3) + (i16 * i16));
            InnerAIORecycleView innerAIORecycleView = InnerAIORecycleView.this;
            if (z16) {
                height = innerAIORecycleView.getWidth();
            } else {
                height = innerAIORecycleView.getHeight();
            }
            int i26 = height / 2;
            float f16 = height;
            float f17 = i26;
            float distanceInfluenceForSnapDuration = f17 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (sqrt2 * 1.0f) / f16)) * f17);
            if (sqrt > 0) {
                i19 = Math.round(Math.abs(distanceInfluenceForSnapDuration / sqrt) * 1000.0f) * 4;
            } else {
                if (!z16) {
                    abs = abs2;
                }
                i19 = (int) (((abs / f16) + 1.0f) * 300.0f);
            }
            return Math.min(i19, 2000);
        }

        private float distanceInfluenceForSnapDuration(float f16) {
            return (float) Math.sin((f16 - 0.5f) * 0.47123894f);
        }

        private void internalPostOnAnimation() {
            InnerAIORecycleView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(InnerAIORecycleView.this, this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewFlinger
        public void fling(int i3, int i16) {
            InnerAIORecycleView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new AIOOverScroller(InnerAIORecycleView.this.getContext(), interpolator2);
            }
            this.mOverScroller.fling(0, 0, i3, i16, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewFlinger
        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewFlinger, java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            int i17;
            InnerAIORecycleView innerAIORecycleView = InnerAIORecycleView.this;
            if (innerAIORecycleView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            try {
                innerAIORecycleView.consumePendingUpdateOperations();
            } catch (Exception e16) {
                com.tencent.aio.base.log.a.f69187b.a(InnerAIORecycleView.TAG, "consumePendingUpdateOperations", e16);
            }
            AIOOverScroller aIOOverScroller = this.mOverScroller;
            if (aIOOverScroller.computeScrollOffset()) {
                int currX = aIOOverScroller.getCurrX();
                int currY = aIOOverScroller.getCurrY();
                int i18 = currX - this.mLastFlingX;
                int i19 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                InnerAIORecycleView innerAIORecycleView2 = InnerAIORecycleView.this;
                int[] iArr = innerAIORecycleView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (innerAIORecycleView2.dispatchNestedPreScroll(i18, i19, iArr, null, 1)) {
                    int[] iArr2 = InnerAIORecycleView.this.mReusableIntPair;
                    i18 -= iArr2[0];
                    i19 -= iArr2[1];
                }
                if (InnerAIORecycleView.this.getOverScrollMode() != 2) {
                    InnerAIORecycleView.this.considerReleasingGlowsOnScroll(i18, i19);
                }
                InnerAIORecycleView innerAIORecycleView3 = InnerAIORecycleView.this;
                if (innerAIORecycleView3.mAdapter != null) {
                    int[] iArr3 = innerAIORecycleView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    innerAIORecycleView3.scrollStep(i18, i19, iArr3);
                    InnerAIORecycleView innerAIORecycleView4 = InnerAIORecycleView.this;
                    int[] iArr4 = innerAIORecycleView4.mReusableIntPair;
                    i16 = iArr4[0];
                    i3 = iArr4[1];
                    i18 -= i16;
                    i19 -= i3;
                    RecyclerView.SmoothScroller smoothScroller = innerAIORecycleView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = InnerAIORecycleView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i16, i3);
                        } else {
                            smoothScroller.onAnimation(i16, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                if (!InnerAIORecycleView.this.mItemDecorations.isEmpty()) {
                    InnerAIORecycleView.this.invalidate();
                }
                InnerAIORecycleView innerAIORecycleView5 = InnerAIORecycleView.this;
                int[] iArr5 = innerAIORecycleView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                innerAIORecycleView5.dispatchNestedScroll(i16, i3, i18, i19, null, 1, iArr5);
                InnerAIORecycleView innerAIORecycleView6 = InnerAIORecycleView.this;
                int[] iArr6 = innerAIORecycleView6.mReusableIntPair;
                int i26 = i18 - iArr6[0];
                int i27 = i19 - iArr6[1];
                if (i16 != 0 || i3 != 0) {
                    innerAIORecycleView6.dispatchOnScrolled(i16, i3);
                }
                if (!InnerAIORecycleView.this.awakenScrollBars()) {
                    InnerAIORecycleView.this.invalidate();
                }
                if (aIOOverScroller.getCurrX() == aIOOverScroller.getFinalX()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (aIOOverScroller.getCurrY() == aIOOverScroller.getFinalY()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!aIOOverScroller.isFinished() && ((!z16 && i26 == 0) || (!z17 && i27 == 0))) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                RecyclerView.SmoothScroller smoothScroller2 = InnerAIORecycleView.this.mLayout.mSmoothScroller;
                if (smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19 && z18) {
                    if (InnerAIORecycleView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) aIOOverScroller.getCurrVelocity();
                        if (i26 < 0) {
                            i17 = -currVelocity;
                        } else if (i26 > 0) {
                            i17 = currVelocity;
                        } else {
                            i17 = 0;
                        }
                        if (i27 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i27 <= 0) {
                            currVelocity = 0;
                        }
                        InnerAIORecycleView.this.absorbGlows(i17, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        InnerAIORecycleView.this.mPrefetchRegistry.clearPrefetchPositions();
                    }
                } else {
                    postOnAnimation();
                    InnerAIORecycleView innerAIORecycleView7 = InnerAIORecycleView.this;
                    GapWorker gapWorker = innerAIORecycleView7.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(innerAIORecycleView7, i16, i3);
                    }
                }
            }
            RecyclerView.SmoothScroller smoothScroller3 = InnerAIORecycleView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                InnerAIORecycleView.this.setScrollState(0);
                InnerAIORecycleView.this.stopNestedScroll(1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewFlinger
        public void smoothScrollBy(int i3, int i16, int i17, @Nullable Interpolator interpolator) {
            if (i17 == Integer.MIN_VALUE) {
                i17 = computeScrollDuration(i3, i16, 0, 0);
            }
            int i18 = i17;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new AIOOverScroller(InnerAIORecycleView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            InnerAIORecycleView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i3, i16, i18);
            postOnAnimation();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewFlinger
        public void stop() {
            InnerAIORecycleView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    static {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mViewFlinger");
            viewFlingFiled = declaredField;
            declaredField.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public InnerAIORecycleView(@NonNull Context context) {
        super(context);
        this.maxFlingRate = 1.0f;
        this.realFlingRate = 1.0f;
        init();
    }

    private void init() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        int scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOriginFlingVelocity = scaledMaximumFlingVelocity;
        this.mMaxFlingVelocity = (int) (this.maxFlingRate * scaledMaximumFlingVelocity);
        try {
            viewFlingFiled.set(this, new ViewFlinger());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        boolean z16;
        RecyclerView.LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            com.tencent.aio.base.log.a.f69187b.d(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally == 0 || Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (!canScrollVertically || Math.abs(i16) < this.mMinFlingVelocity) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return false;
        }
        float f16 = i3;
        float f17 = i16;
        if (!dispatchNestedPreFling(f16, f17)) {
            if (canScrollHorizontally == 0 && !canScrollVertically) {
                z16 = false;
            } else {
                z16 = true;
            }
            dispatchNestedFling(f16, f17, z16);
            int i17 = canScrollHorizontally;
            if (z16) {
                if (canScrollVertically) {
                    i17 = (canScrollHorizontally ? 1 : 0) | 2;
                }
                startNestedScroll(i17, 1);
                int i18 = this.mMaxFlingVelocity;
                int max = Math.max(-i18, Math.min(i3, i18));
                int i19 = this.mMaxFlingVelocity;
                this.mViewFlinger.fling(max, (int) (Math.max(-i19, Math.min(i16, i19)) * this.realFlingRate));
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean scrollByInternal(int i3, int i16, MotionEvent motionEvent) {
        return super.scrollByInternal(i3, i16, motionEvent);
    }

    public void setMaxFlingRate(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.maxFlingRate = f16;
        this.mMaxFlingVelocity = (int) (this.mOriginFlingVelocity * f16);
    }

    public void setRealFlingRate(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.realFlingRate = f16;
    }

    public InnerAIORecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxFlingRate = 1.0f;
        this.realFlingRate = 1.0f;
        init();
    }

    public InnerAIORecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.maxFlingRate = 1.0f;
        this.realFlingRate = 1.0f;
        init();
    }
}
