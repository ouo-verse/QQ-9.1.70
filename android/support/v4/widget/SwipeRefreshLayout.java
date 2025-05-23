package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
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

/* compiled from: P */
/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
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
    private int mCircleHeight;
    private CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private MaterialProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    private float mSpinnerFinalOffset;
    private float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private int mTouchSlop;
    private boolean mUsingCustomStart;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
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
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT, 20.0f);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(CIRCLE_BG_LIGHT);
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

    private float getMotionEventY(MotionEvent motionEvent, int i3) {
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return motionEvent.getY(findPointerIndex);
    }

    private boolean isAlphaUsedForScale() {
        return false;
    }

    private boolean isAnimationRunning(Animation animation) {
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToStart(float f16) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f16))) - this.mCircleView.getTop(), false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationProgress(float f16) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (f16 * 255.0f));
        } else {
            this.mCircleView.setScaleX(f16);
            this.mCircleView.setScaleY(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorViewAlpha(int i3) {
        this.mCircleView.getBackground().setAlpha(i3);
        this.mProgress.setAlpha(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i3, boolean z16) {
        this.mCircleView.bringToFront();
        this.mCircleView.offsetTopAndBottom(i3);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private Animation startAlphaAnimation(final int i3, final int i16) {
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        Animation animation = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.4
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

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.3
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

    private void startScaleDownReturnToStartAnimation(int i3, Animation.AnimationListener animationListener) {
        this.mFrom = i3;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = this.mProgress.getAlpha();
        } else {
            this.mStartingScale = this.mCircleView.getScaleX();
        }
        Animation animation = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.mStartingScale + ((-SwipeRefreshLayout.this.mStartingScale) * f16));
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
        Animation animation = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.2
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
        View view = this.mTarget;
        if (view == null) {
            return false;
        }
        return ViewCompat.canScrollVertically(view, -1);
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

    public int getProgressCircleDiameter() {
        CircleImageView circleImageView = this.mCircleView;
        if (circleImageView != null) {
            return circleImageView.getMeasuredHeight();
        }
        return 0;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing) {
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
                    float motionEventY = getMotionEventY(motionEvent, i3);
                    if (motionEventY == -1.0f) {
                        return false;
                    }
                    float f16 = this.mInitialDownY;
                    float f17 = motionEventY - f16;
                    int i16 = this.mTouchSlop;
                    if (f17 > i16 && !this.mIsBeingDragged) {
                        this.mInitialMotionY = f16 + i16;
                        this.mIsBeingDragged = true;
                        this.mProgress.setAlpha(76);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            float motionEventY2 = getMotionEventY(motionEvent, pointerId);
            if (motionEventY2 == -1.0f) {
                return false;
            }
            this.mInitialDownY = motionEventY2;
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
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
        if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
            this.mOriginalOffsetCalculated = true;
            int i17 = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = i17;
            this.mCurrentTargetOffsetTop = i17;
        }
        this.mCircleViewIndex = -1;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            if (getChildAt(i18) == this.mCircleView) {
                this.mCircleViewIndex = i18;
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Animation.AnimationListener animationListener;
        float f16;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (isEnabled() && !this.mReturningToStart && !canChildScrollUp()) {
            try {
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked != 5) {
                                    if (actionMasked == 6) {
                                        onSecondaryPointerUp(motionEvent);
                                    }
                                } else {
                                    this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                                }
                            }
                        } else {
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                                return false;
                            }
                            float y16 = (motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f;
                            if (this.mIsBeingDragged) {
                                this.mProgress.showArrow(true);
                                float f17 = y16 / this.mTotalDragDistance;
                                if (f17 < 0.0f) {
                                    return false;
                                }
                                float min = Math.min(1.0f, Math.abs(f17));
                                float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                                float abs = Math.abs(y16) - this.mTotalDragDistance;
                                if (this.mUsingCustomStart) {
                                    f16 = this.mSpinnerFinalOffset - this.mOriginalOffsetTop;
                                } else {
                                    f16 = this.mSpinnerFinalOffset;
                                }
                                double max2 = Math.max(0.0f, Math.min(abs, f16 * 2.0f) / f16) / 4.0f;
                                float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
                                int i3 = this.mOriginalOffsetTop + ((int) ((f16 * min) + (f16 * pow * 2.0f)));
                                if (this.mCircleView.getVisibility() != 0) {
                                    this.mCircleView.setVisibility(0);
                                }
                                if (!this.mScale) {
                                    this.mCircleView.setScaleX(1.0f);
                                    this.mCircleView.setScaleY(1.0f);
                                }
                                float f18 = this.mTotalDragDistance;
                                if (y16 < f18) {
                                    if (this.mScale) {
                                        setAnimationProgress(y16 / f18);
                                    }
                                    if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                                        startProgressAlphaStartAnimation();
                                    }
                                    this.mProgress.setStartEndTrim(0.0f, Math.min(0.8f, max * 0.8f));
                                    this.mProgress.setArrowScale(Math.min(1.0f, max));
                                } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
                                    startProgressAlphaMaxAnimation();
                                }
                                this.mProgress.setProgressRotation((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
                                setTargetOffsetTopAndBottom(i3 - this.mCurrentTargetOffsetTop, true);
                            }
                        }
                    }
                    int i16 = this.mActivePointerId;
                    if (i16 == -1) {
                        if (actionMasked == 1) {
                            Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                        }
                        return false;
                    }
                    float y17 = (motionEvent.getY(motionEvent.findPointerIndex(i16)) - this.mInitialMotionY) * 0.5f;
                    this.mIsBeingDragged = false;
                    if (y17 > this.mTotalDragDistance) {
                        setRefreshing(true, true);
                    } else {
                        this.mRefreshing = false;
                        this.mProgress.setStartEndTrim(0.0f, 0.0f);
                        if (!this.mScale) {
                            animationListener = new Animation.AnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.5
                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationEnd(Animation animation) {
                                    if (!SwipeRefreshLayout.this.mScale) {
                                        SwipeRefreshLayout.this.startScaleDownAnimation(null);
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
                        this.mProgress.showArrow(false);
                    }
                    this.mActivePointerId = -1;
                    return false;
                }
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr2[i3] = resources.getColor(iArr[i3]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i3) {
        this.mTotalDragDistance = i3;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i3) {
        setProgressBackgroundColorSchemeResource(i3);
    }

    public void setProgressBackgroundColorSchemeColor(int i3) {
        this.mCircleView.setBackgroundColor(i3);
        this.mProgress.setBackgroundColor(i3);
    }

    public void setProgressBackgroundColorSchemeResource(int i3) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i3));
    }

    public void setProgressViewEndTarget(boolean z16, int i3) {
        this.mSpinnerFinalOffset = i3;
        this.mScale = z16;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z16, int i3, int i16) {
        this.mScale = z16;
        this.mCircleView.setVisibility(8);
        this.mCurrentTargetOffsetTop = i3;
        this.mOriginalOffsetTop = i3;
        this.mSpinnerFinalOffset = i16;
        this.mUsingCustomStart = true;
        this.mCircleView.invalidate();
    }

    public void setRefreshing(boolean z16) {
        float f16;
        if (z16 && this.mRefreshing != z16) {
            this.mRefreshing = z16;
            if (!this.mUsingCustomStart) {
                f16 = this.mSpinnerFinalOffset + this.mOriginalOffsetTop;
            } else {
                f16 = this.mSpinnerFinalOffset;
            }
            setTargetOffsetTopAndBottom(((int) f16) - this.mCurrentTargetOffsetTop, true);
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
            int i16 = (int) (displayMetrics.density * 56.0f);
            this.mCircleWidth = i16;
            this.mCircleHeight = i16;
        } else {
            int i17 = (int) (displayMetrics.density * 40.0f);
            this.mCircleWidth = i17;
            this.mCircleHeight = i17;
        }
        this.mCircleView.setImageDrawable(null);
        this.mProgress.updateSizes(i3);
        this.mCircleView.setImageDrawable(this.mProgress);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.mRefreshing) {
                    SwipeRefreshLayout.this.mProgress.setAlpha(255);
                    SwipeRefreshLayout.this.mProgress.start();
                    if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                        SwipeRefreshLayout.this.mListener.onRefresh();
                    }
                } else {
                    SwipeRefreshLayout.this.mProgress.stop();
                    SwipeRefreshLayout.this.mCircleView.setVisibility(8);
                    SwipeRefreshLayout.this.setColorViewAlpha(255);
                    if (SwipeRefreshLayout.this.mScale) {
                        SwipeRefreshLayout.this.setAnimationProgress(0.0f);
                    } else {
                        SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                        swipeRefreshLayout.setTargetOffsetTopAndBottom(swipeRefreshLayout.mOriginalOffsetTop - swipeRefreshLayout.mCurrentTargetOffsetTop, true);
                    }
                }
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                swipeRefreshLayout2.mCurrentTargetOffsetTop = swipeRefreshLayout2.mCircleView.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                float f17;
                if (SwipeRefreshLayout.this.mUsingCustomStart) {
                    f17 = SwipeRefreshLayout.this.mSpinnerFinalOffset;
                } else {
                    f17 = SwipeRefreshLayout.this.mSpinnerFinalOffset - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop);
                }
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout.mFrom + ((int) ((((int) f17) - r1) * f16))) - swipeRefreshLayout.mCircleView.getTop(), false);
                SwipeRefreshLayout.this.mProgress.setArrowScale(1.0f - f16);
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                SwipeRefreshLayout.this.moveToStart(f16);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f16 = displayMetrics.density;
        this.mCircleWidth = (int) (f16 * 40.0f);
        this.mCircleHeight = (int) (f16 * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        float f17 = displayMetrics.density * 64.0f;
        this.mSpinnerFinalOffset = f17;
        this.mTotalDragDistance = f17;
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
    }
}
