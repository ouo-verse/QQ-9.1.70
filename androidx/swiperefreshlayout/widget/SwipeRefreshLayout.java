package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

/* compiled from: P */
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent3, NestedScrollingParent2, NestedScrollingChild3, NestedScrollingChild2, NestedScrollingParent, NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;

    @VisibleForTesting
    static final int CIRCLE_DIAMETER = 40;

    @VisibleForTesting
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private boolean mEnableLegacyRequestDisallowInterceptTouch;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private final int[] mNestedScrollingV2ConsumedCompat;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    CircularProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    private void animateOffsetToCorrectPosition(int i3, Animation.AnimationListener animationListener) {
        this.mFrom = i3;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i3, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i3, animationListener);
            return;
        }
        this.mFrom = i3;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext());
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.mProgress = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f16) {
        Animation.AnimationListener animationListener;
        if (f16 > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        if (!this.mScale) {
            animationListener = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    if (!swipeRefreshLayout.mScale) {
                        swipeRefreshLayout.startScaleDownAnimation(null);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            };
        } else {
            animationListener = null;
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, animationListener);
        this.mProgress.setArrowEnabled(false);
    }

    private boolean isAnimationRunning(Animation animation) {
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            return true;
        }
        return false;
    }

    private void moveSpinner(float f16) {
        this.mProgress.setArrowEnabled(true);
        float min = Math.min(1.0f, Math.abs(f16 / this.mTotalDragDistance));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f16) - this.mTotalDragDistance;
        int i3 = this.mCustomSlingshotDistance;
        if (i3 <= 0) {
            if (this.mUsingCustomStart) {
                i3 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
            } else {
                i3 = this.mSpinnerOffsetEnd;
            }
        }
        float f17 = i3;
        double max2 = Math.max(0.0f, Math.min(abs, f17 * 2.0f) / f17) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i16 = this.mOriginalOffsetTop + ((int) ((f17 * min) + (f17 * pow * 2.0f)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f16 / this.mTotalDragDistance));
        }
        if (f16 < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
        this.mProgress.setArrowScale(Math.min(1.0f, max));
        this.mProgress.setProgressRotation((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i16 - this.mCurrentTargetOffsetTop);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i3;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.mActivePointerId = motionEvent.getPointerId(i3);
        }
    }

    private void setColorViewAlpha(int i3) {
        this.mCircleView.getBackground().setAlpha(i3);
        this.mProgress.setAlpha(i3);
    }

    private Animation startAlphaAnimation(final int i3, final int i16) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout.this.mProgress.setAlpha((int) (i3 + ((i16 - r0) * f16)));
            }
        };
        animation.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(animation);
        return animation;
    }

    private void startDragging(float f16) {
        float f17 = this.mInitialDownY;
        float f18 = f16 - f17;
        int i3 = this.mTouchSlop;
        if (f18 > i3 && !this.mIsBeingDragged) {
            this.mInitialMotionY = f17 + i3;
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startScaleDownReturnToStartAnimation(int i3, Animation.AnimationListener animationListener) {
        this.mFrom = i3;
        this.mStartingScale = this.mCircleView.getScaleX();
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f17 = swipeRefreshLayout.mStartingScale;
                swipeRefreshLayout.setAnimationProgress(f17 + ((-f17) * f16));
                SwipeRefreshLayout.this.moveToStart(f16);
            }
        };
        this.mScaleDownToStartAnimation = animation;
        animation.setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f16);
            }
        };
        this.mScaleAnimation = animation;
        animation.setDuration(this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.mChildScrollUpCallback;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.mTarget);
        }
        View view = this.mTarget;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f16, f17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        return i17 == 0 && dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @NonNull int[] iArr2) {
        if (i19 == 0) {
            this.mNestedScrollingChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        int i17 = this.mCircleViewIndex;
        if (i17 < 0) {
            return i16;
        }
        if (i16 == i3 - 1) {
            return i17;
        }
        if (i16 >= i17) {
            return i16 + 1;
        }
        return i16;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return i3 == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    void moveToStart(float f16) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f16))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int i3 = this.mActivePointerId;
                    if (i3 == -1) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i3);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    startDragging(motionEvent.getY(findPointerIndex));
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.mInitialDownY = motionEvent.getY(findPointerIndex2);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        int i19 = measuredWidth / 2;
        int i26 = measuredWidth2 / 2;
        int i27 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i19 - i26, i27, i19 + i26, measuredHeight2 + i27);
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
        this.mCircleViewIndex = -1;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            if (getChildAt(i17) == this.mCircleView) {
                this.mCircleViewIndex = i17;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        return dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        return dispatchNestedPreFling(f16, f17);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr, int i17) {
        if (i17 == 0) {
            onNestedPreScroll(view, i3, i16, iArr);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        if (i19 != 0) {
            return;
        }
        int i26 = iArr[1];
        dispatchNestedScroll(i3, i16, i17, i18, this.mParentOffsetInWindow, i19, iArr);
        int i27 = i18 - (iArr[1] - i26);
        if ((i27 == 0 ? i18 + this.mParentOffsetInWindow[1] : i27) >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.mTotalUnconsumed + Math.abs(r1);
        this.mTotalUnconsumed = abs;
        moveSpinner(abs);
        iArr[1] = iArr[1] + i27;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i3, int i16) {
        if (i16 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.mRefreshing);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mRefreshing);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i3, int i16) {
        if (i16 == 0) {
            return onStartNestedScroll(view, view2, i3);
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        return false;
                    }
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    } else {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex < 0) {
                            Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float y16 = motionEvent.getY(findPointerIndex);
                    startDragging(y16);
                    if (this.mIsBeingDragged) {
                        float f16 = (y16 - this.mInitialMotionY) * 0.5f;
                        if (f16 <= 0.0f) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        moveSpinner(f16);
                    }
                }
            } else {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 < 0) {
                    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsBeingDragged) {
                    float y17 = (motionEvent.getY(findPointerIndex2) - this.mInitialMotionY) * 0.5f;
                    this.mIsBeingDragged = false;
                    finishSpinner(y17);
                }
                this.mActivePointerId = -1;
                return false;
            }
        } else {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        View view;
        if (this.mEnableLegacyRequestDisallowInterceptTouch && (view = this.mTarget) != null && !ViewCompat.isNestedScrollingEnabled(view)) {
            return;
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    void setAnimationProgress(float f16) {
        this.mCircleView.setScaleX(f16);
        this.mCircleView.setScaleY(f16);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr2[i3] = ContextCompat.getColor(context, iArr[i3]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i3) {
        this.mTotalDragDistance = i3;
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        if (!z16) {
            reset();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z16) {
        this.mEnableLegacyRequestDisallowInterceptTouch = z16;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z16);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mChildScrollUpCallback = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i3) {
        setProgressBackgroundColorSchemeResource(i3);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i3) {
        this.mCircleView.setBackgroundColor(i3);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i3) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i3));
    }

    public void setProgressViewEndTarget(boolean z16, int i3) {
        this.mSpinnerOffsetEnd = i3;
        this.mScale = z16;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z16, int i3, int i16) {
        this.mScale = z16;
        this.mOriginalOffsetTop = i3;
        this.mSpinnerOffsetEnd = i16;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean z16) {
        int i3;
        if (z16 && this.mRefreshing != z16) {
            this.mRefreshing = z16;
            if (!this.mUsingCustomStart) {
                i3 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
            } else {
                i3 = this.mSpinnerOffsetEnd;
            }
            setTargetOffsetTopAndBottom(i3 - this.mCurrentTargetOffsetTop);
            this.mNotify = false;
            startScaleUpAnimation(this.mRefreshListener);
            return;
        }
        setRefreshing(z16, false);
    }

    public void setSize(int i3) {
        if (i3 != 0 && i3 != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i3 == 0) {
            this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
        } else {
            this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        }
        this.mCircleView.setImageDrawable(null);
        this.mProgress.setStyle(i3);
        this.mCircleView.setImageDrawable(this.mProgress);
    }

    public void setSlingshotDistance(@Px int i3) {
        this.mCustomSlingshotDistance = i3;
    }

    void setTargetOffsetTopAndBottom(int i3) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, i3);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return i16 == 0 && startNestedScroll(i3);
    }

    void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f16);
            }
        };
        this.mScaleDownAnimation = animation;
        animation.setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        if (i3 == 0) {
            stopNestedScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };
        final boolean mRefreshing;

        SavedState(Parcelable parcelable, boolean z16) {
            super(parcelable);
            this.mRefreshing = z16;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.mRefreshing ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.mRefreshing = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.mRefreshing) {
                    swipeRefreshLayout.mProgress.setAlpha(255);
                    SwipeRefreshLayout.this.mProgress.start();
                    SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                    if (swipeRefreshLayout2.mNotify && (onRefreshListener = swipeRefreshLayout2.mListener) != null) {
                        onRefreshListener.onRefresh();
                    }
                    SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                    swipeRefreshLayout3.mCurrentTargetOffsetTop = swipeRefreshLayout3.mCircleView.getTop();
                    return;
                }
                swipeRefreshLayout.reset();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                int i3;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.mUsingCustomStart) {
                    i3 = swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop);
                } else {
                    i3 = swipeRefreshLayout.mSpinnerOffsetEnd;
                }
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.mFrom + ((int) ((i3 - r1) * f16))) - swipeRefreshLayout2.mCircleView.getTop());
                SwipeRefreshLayout.this.mProgress.setArrowScale(1.0f - f16);
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout.this.moveToStart(f16);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int i3 = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i3;
        this.mTotalDragDistance = i3;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i16 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i16;
        this.mOriginalOffsetTop = i16;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        return i19 == 0 && this.mNestedScrollingChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        if (i16 > 0) {
            float f16 = this.mTotalUnconsumed;
            if (f16 > 0.0f) {
                float f17 = i16;
                if (f17 > f16) {
                    iArr[1] = (int) f16;
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f16 - f17;
                    iArr[1] = i16;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i16 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i16 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i3 - iArr[0], i16 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i3);
        startNestedScroll(i3 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (i3 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        float f16 = this.mTotalUnconsumed;
        if (f16 > 0.0f) {
            finishSpinner(f16);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18, int i19) {
        onNestedScroll(view, i3, i16, i17, i18, i19, this.mNestedScrollingV2ConsumedCompat);
    }

    private void setRefreshing(boolean z16, boolean z17) {
        if (this.mRefreshing != z16) {
            this.mNotify = z17;
            ensureTarget();
            this.mRefreshing = z16;
            if (z16) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        onNestedScroll(view, i3, i16, i17, i18, 0, this.mNestedScrollingV2ConsumedCompat);
    }
}
