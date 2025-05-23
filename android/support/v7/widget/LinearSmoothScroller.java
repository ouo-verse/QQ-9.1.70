package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final String TAG = "LinearSmoothScroller";
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    private final float MILLISECONDS_PER_PX;
    protected PointF mTargetVector;
    protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;

    public LinearSmoothScroller(Context context) {
        this.MILLISECONDS_PER_PX = calculateSpeedPerPixel(context.getResources().getDisplayMetrics());
    }

    private int clampApplyScroll(int i3, int i16) {
        int i17 = i3 - i16;
        if (i3 * i17 <= 0) {
            return 0;
        }
        return i17;
    }

    public int calculateDtToFit(int i3, int i16, int i17, int i18, int i19) {
        if (i19 != -1) {
            if (i19 != 0) {
                if (i19 == 1) {
                    return i18 - i16;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i26 = i17 - i3;
            if (i26 > 0) {
                return i26;
            }
            int i27 = i18 - i16;
            if (i27 < 0) {
                return i27;
            }
            return 0;
        }
        return i17 - i3;
    }

    public int calculateDxToMakeVisible(View view, int i3) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i3);
        }
        return 0;
    }

    public int calculateDyToMakeVisible(View view, int i3) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i3);
        }
        return 0;
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int calculateTimeForDeceleration(int i3) {
        return (int) Math.ceil(calculateTimeForScrolling(i3) / 0.3356d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int calculateTimeForScrolling(int i3) {
        return (int) Math.ceil(Math.abs(i3) * this.MILLISECONDS_PER_PX);
    }

    public abstract PointF computeScrollVectorForPosition(int i3);

    protected int getHorizontalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f16 = pointF.x;
            if (f16 != 0.0f) {
                if (f16 > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    protected int getVerticalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f16 = pointF.y;
            if (f16 != 0.0f) {
                if (f16 > 0.0f) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void onSeekTargetStep(int i3, int i16, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i3);
        int clampApplyScroll = clampApplyScroll(this.mInterimTargetDy, i16);
        this.mInterimTargetDy = clampApplyScroll;
        if (this.mInterimTargetDx == 0 && clampApplyScroll == 0) {
            updateActionForInterimTarget(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((calculateDxToMakeVisible * calculateDxToMakeVisible) + (calculateDyToMakeVisible * calculateDyToMakeVisible)));
        if (calculateTimeForDeceleration > 0) {
            action.update(-calculateDxToMakeVisible, -calculateDyToMakeVisible, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    protected void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action action) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
            normalize(computeScrollVectorForPosition);
            this.mTargetVector = computeScrollVectorForPosition;
            this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
            this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
            action.update((int) (this.mInterimTargetDx * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (this.mInterimTargetDy * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (calculateTimeForScrolling(10000) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
            return;
        }
        Log.e(TAG, "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
        action.jumpTo(getTargetPosition());
        stop();
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller
    protected void onStart() {
    }
}
