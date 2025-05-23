package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup != null) {
            if (callback != null) {
                this.mParentView = viewGroup;
                this.mCallback = callback;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i3 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.mDefaultEdgeSize = i3;
                this.mEdgeSize = i3;
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mScroller = new OverScroller(context, sInterpolator);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkNewEdgeDrag(float f16, float f17, int i3, int i16) {
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        if ((this.mInitialEdgesTouched[i3] & i16) != i16 || (this.mTrackingEdges & i16) == 0 || (this.mEdgeDragsLocked[i3] & i16) == i16 || (this.mEdgeDragsInProgress[i3] & i16) == i16) {
            return false;
        }
        int i17 = this.mTouchSlop;
        if (abs <= i17 && abs2 <= i17) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.mCallback.onEdgeLock(i16)) {
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i3] = iArr[i3] | i16;
            return false;
        }
        if ((this.mEdgeDragsInProgress[i3] & i16) != 0 || abs <= this.mTouchSlop) {
            return false;
        }
        return true;
    }

    private boolean checkTouchSlop(View view, float f16, float f17) {
        if (view == null) {
            return false;
        }
        boolean z16 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z17 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z16 || !z17) {
            return z16 ? Math.abs(f16) > ((float) this.mTouchSlop) : z17 && Math.abs(f17) > ((float) this.mTouchSlop);
        }
        float f18 = (f16 * f16) + (f17 * f17);
        int i3 = this.mTouchSlop;
        return f18 > ((float) (i3 * i3));
    }

    private int clampMag(int i3, int i16, int i17) {
        int abs = Math.abs(i3);
        if (abs < i16) {
            return 0;
        }
        return abs > i17 ? i3 > 0 ? i17 : -i17 : i3;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i3, int i16, int i17) {
        int abs;
        if (i3 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f16 = width / 2;
        float distanceInfluenceForSnapDuration = f16 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i3) / width)) * f16);
        int abs2 = Math.abs(i16);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i3) / i17) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int computeSettleDuration(View view, int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        float f19;
        int clampMag = clampMag(i17, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i18, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i16);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i19 = abs3 + abs4;
        int i26 = abs + abs2;
        if (clampMag != 0) {
            f16 = abs3;
            f17 = i19;
        } else {
            f16 = abs;
            f17 = i26;
        }
        float f26 = f16 / f17;
        if (clampMag2 != 0) {
            f18 = abs4;
            f19 = i19;
        } else {
            f18 = abs2;
            f19 = i26;
        }
        return (int) ((computeAxisDuration(i3, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f26) + (computeAxisDuration(i16, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f18 / f19)));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f16, float f17) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f16, f17);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f16) {
        return (float) Math.sin((f16 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i3, int i16, int i17, int i18) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i17 != 0) {
            i3 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i3, i17);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i3 - left);
        }
        int i19 = i3;
        if (i18 != 0) {
            i16 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i16, i18);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i16 - top);
        }
        int i26 = i16;
        if (i17 != 0 || i18 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i19, i26, i19 - left, i26 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i3) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i3) {
            int i16 = i3 + 1;
            float[] fArr2 = new float[i16];
            float[] fArr3 = new float[i16];
            float[] fArr4 = new float[i16];
            float[] fArr5 = new float[i16];
            int[] iArr = new int[i16];
            int[] iArr2 = new int[i16];
            int[] iArr3 = new int[i16];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i3, int i16, int i17, int i18) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i19 = i3 - left;
        int i26 = i16 - top;
        if (i19 == 0 && i26 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i19, i26, computeSettleDuration(this.mCapturedView, i19, i26, i17, i18));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i3, int i16) {
        int i17;
        if (i3 < this.mParentView.getLeft() + this.mEdgeSize) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        if (i16 < this.mParentView.getTop() + this.mEdgeSize) {
            i17 |= 4;
        }
        if (i3 > this.mParentView.getRight() - this.mEdgeSize) {
            i17 |= 2;
        }
        if (i16 > this.mParentView.getBottom() - this.mEdgeSize) {
            return i17 | 8;
        }
        return i17;
    }

    private boolean isValidPointerForActionMove(int i3) {
        if (!isPointerDown(i3)) {
            Log.e(TAG, "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    private void reportNewEdgeDrags(float f16, float f17, int i3) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f16, f17, i3, 1);
        boolean z16 = checkNewEdgeDrag;
        if (checkNewEdgeDrag(f17, f16, i3, 4)) {
            z16 = (checkNewEdgeDrag ? 1 : 0) | 4;
        }
        boolean z17 = z16;
        if (checkNewEdgeDrag(f16, f17, i3, 2)) {
            z17 = (z16 ? 1 : 0) | 2;
        }
        ?? r06 = z17;
        if (checkNewEdgeDrag(f17, f16, i3, 8)) {
            r06 = (z17 ? 1 : 0) | 8;
        }
        if (r06 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i3] = iArr[i3] | r06;
            this.mCallback.onEdgeDragStarted(r06, i3);
        }
    }

    private void saveInitialMotion(float f16, float f17, int i3) {
        ensureMotionHistorySizeForId(i3);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i3] = f16;
        fArr[i3] = f16;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i3] = f17;
        fArr2[i3] = f17;
        this.mInitialEdgesTouched[i3] = getEdgesTouched((int) f16, (int) f17);
        this.mPointersDown |= 1 << i3;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (isValidPointerForActionMove(pointerId)) {
                float x16 = motionEvent.getX(i3);
                float y16 = motionEvent.getY(i3);
                this.mLastMotionX[pointerId] = x16;
                this.mLastMotionY[pointerId] = y16;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    protected boolean canScroll(@NonNull View view, boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i26 = i17 + scrollX;
                if (i26 >= childAt.getLeft() && i26 < childAt.getRight() && (i19 = i18 + scrollY) >= childAt.getTop() && i19 < childAt.getBottom() && canScroll(childAt, true, i3, i16, i26 - childAt.getLeft(), i19 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z16 && (view.canScrollHorizontally(-i3) || view.canScrollVertically(-i16))) {
            return true;
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i3) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i3;
            this.mCallback.onViewCaptured(view, i3);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean z16) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z16) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        if (this.mDragState != 2) {
            return false;
        }
        return true;
    }

    @Nullable
    public View findTopChildUnder(int i3, int i16) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i16 >= childAt.getTop() && i16 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i3, int i16, int i17, int i18) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i3, i17, i16, i18);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i3, int i16) {
        return isViewUnder(this.mCapturedView, i3, i16);
    }

    public boolean isEdgeTouched(int i3) {
        int length = this.mInitialEdgesTouched.length;
        for (int i16 = 0; i16 < length; i16++) {
            if (isEdgeTouched(i3, i16)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i3) {
        if (((1 << i3) & this.mPointersDown) != 0) {
            return true;
        }
        return false;
    }

    public boolean isViewUnder(@Nullable View view, int i3, int i16) {
        if (view == null || i3 < view.getLeft() || i3 >= view.getRight() || i16 < view.getTop() || i16 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i16 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.mDragState == 1 && pointerId == this.mActivePointerId) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (i16 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i16);
                                            if (pointerId2 != this.mActivePointerId) {
                                                View findTopChildUnder = findTopChildUnder((int) motionEvent.getX(i16), (int) motionEvent.getY(i16));
                                                View view = this.mCapturedView;
                                                if (findTopChildUnder == view && tryCaptureViewForDrag(view, pointerId2)) {
                                                    i3 = this.mActivePointerId;
                                                    break;
                                                }
                                            }
                                            i16++;
                                        } else {
                                            i3 = -1;
                                            break;
                                        }
                                    }
                                    if (i3 == -1) {
                                        releaseViewForPointerUp();
                                    }
                                }
                                clearMotionHistory(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x16 = motionEvent.getX(actionIndex);
                        float y16 = motionEvent.getY(actionIndex);
                        saveInitialMotion(x16, y16, pointerId3);
                        if (this.mDragState == 0) {
                            tryCaptureViewForDrag(findTopChildUnder((int) x16, (int) y16), pointerId3);
                            int i17 = this.mInitialEdgesTouched[pointerId3];
                            int i18 = this.mTrackingEdges;
                            if ((i17 & i18) != 0) {
                                this.mCallback.onEdgeTouched(i17 & i18, pointerId3);
                                return;
                            }
                            return;
                        }
                        if (isCapturedViewUnder((int) x16, (int) y16)) {
                            tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                            return;
                        }
                        return;
                    }
                    if (this.mDragState == 1) {
                        dispatchViewReleased(0.0f, 0.0f);
                    }
                    cancel();
                    return;
                }
                if (this.mDragState == 1) {
                    if (isValidPointerForActionMove(this.mActivePointerId)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        float x17 = motionEvent.getX(findPointerIndex);
                        float y17 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.mLastMotionX;
                        int i19 = this.mActivePointerId;
                        int i26 = (int) (x17 - fArr[i19]);
                        int i27 = (int) (y17 - this.mLastMotionY[i19]);
                        dragTo(this.mCapturedView.getLeft() + i26, this.mCapturedView.getTop() + i27, i26, i27);
                        saveLastMotion(motionEvent);
                        return;
                    }
                    return;
                }
                int pointerCount2 = motionEvent.getPointerCount();
                while (i16 < pointerCount2) {
                    int pointerId4 = motionEvent.getPointerId(i16);
                    if (isValidPointerForActionMove(pointerId4)) {
                        float x18 = motionEvent.getX(i16);
                        float y18 = motionEvent.getY(i16);
                        float f16 = x18 - this.mInitialMotionX[pointerId4];
                        float f17 = y18 - this.mInitialMotionY[pointerId4];
                        reportNewEdgeDrags(f16, f17, pointerId4);
                        if (this.mDragState != 1) {
                            View findTopChildUnder2 = findTopChildUnder((int) x18, (int) y18);
                            if (checkTouchSlop(findTopChildUnder2, f16, f17) && tryCaptureViewForDrag(findTopChildUnder2, pointerId4)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i16++;
                }
                saveLastMotion(motionEvent);
                return;
            }
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        float x19 = motionEvent.getX();
        float y19 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View findTopChildUnder3 = findTopChildUnder((int) x19, (int) y19);
        saveInitialMotion(x19, y19, pointerId5);
        tryCaptureViewForDrag(findTopChildUnder3, pointerId5);
        int i28 = this.mInitialEdgesTouched[pointerId5];
        int i29 = this.mTrackingEdges;
        if ((i28 & i29) != 0) {
            this.mCallback.onEdgeTouched(i28 & i29, pointerId5);
        }
    }

    void setDragState(int i3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i3) {
            this.mDragState = i3;
            this.mCallback.onViewDragStateChanged(i3);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int i3) {
        this.mEdgeSize = i3;
    }

    public void setEdgeTrackingEnabled(int i3) {
        this.mTrackingEdges = i3;
    }

    public void setMinVelocity(float f16) {
        this.mMinVelocity = f16;
    }

    public boolean settleCapturedViewAt(int i3, int i16) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i3, i16, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                clearMotionHistory(motionEvent.getPointerId(actionIndex));
                            }
                        } else {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x16 = motionEvent.getX(actionIndex);
                            float y16 = motionEvent.getY(actionIndex);
                            saveInitialMotion(x16, y16, pointerId);
                            int i3 = this.mDragState;
                            if (i3 == 0) {
                                int i16 = this.mInitialEdgesTouched[pointerId];
                                int i17 = this.mTrackingEdges;
                                if ((i16 & i17) != 0) {
                                    this.mCallback.onEdgeTouched(i16 & i17, pointerId);
                                }
                            } else if (i3 == 2 && (findTopChildUnder = findTopChildUnder((int) x16, (int) y16)) == this.mCapturedView) {
                                tryCaptureViewForDrag(findTopChildUnder, pointerId);
                            }
                        }
                    }
                } else if (this.mInitialMotionX != null && this.mInitialMotionY != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i18 = 0; i18 < pointerCount; i18++) {
                        int pointerId2 = motionEvent.getPointerId(i18);
                        if (isValidPointerForActionMove(pointerId2)) {
                            float x17 = motionEvent.getX(i18);
                            float y17 = motionEvent.getY(i18);
                            float f16 = x17 - this.mInitialMotionX[pointerId2];
                            float f17 = y17 - this.mInitialMotionY[pointerId2];
                            View findTopChildUnder2 = findTopChildUnder((int) x17, (int) y17);
                            if (findTopChildUnder2 != null && checkTouchSlop(findTopChildUnder2, f16, f17)) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                int left = findTopChildUnder2.getLeft();
                                int i19 = (int) f16;
                                int clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(findTopChildUnder2, left + i19, i19);
                                int top = findTopChildUnder2.getTop();
                                int i26 = (int) f17;
                                int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(findTopChildUnder2, top + i26, i26);
                                int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(findTopChildUnder2);
                                int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(findTopChildUnder2);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange == 0) {
                                    break;
                                }
                                if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                    break;
                                }
                            }
                            reportNewEdgeDrags(f16, f17, pointerId2);
                            if (this.mDragState == 1) {
                                break;
                            }
                            if (z17 && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                                break;
                            }
                        }
                    }
                    saveLastMotion(motionEvent);
                }
                z16 = false;
            }
            cancel();
            z16 = false;
        } else {
            float x18 = motionEvent.getX();
            float y18 = motionEvent.getY();
            z16 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            saveInitialMotion(x18, y18, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x18, (int) y18);
            if (findTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(findTopChildUnder3, pointerId3);
            }
            int i27 = this.mInitialEdgesTouched[pointerId3];
            int i28 = this.mTrackingEdges;
            if ((i27 & i28) != 0) {
                this.mCallback.onEdgeTouched(i27 & i28, pointerId3);
            }
        }
        if (this.mDragState == 1) {
            return true;
        }
        return z16;
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i3, int i16) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i3, i16, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    boolean tryCaptureViewForDrag(View view, int i3) {
        if (view == this.mCapturedView && this.mActivePointerId == i3) {
            return true;
        }
        if (view != null && this.mCallback.tryCaptureView(view, i3)) {
            this.mActivePointerId = i3;
            captureChildView(view, i3);
            return true;
        }
        return false;
    }

    private float clampMag(float f16, float f17, float f18) {
        float abs = Math.abs(f16);
        if (abs < f17) {
            return 0.0f;
        }
        return abs > f18 ? f16 > 0.0f ? f18 : -f18 : f16;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f16, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (create.mTouchSlop * (1.0f / f16));
        return create;
    }

    public boolean isEdgeTouched(int i3, int i16) {
        return isPointerDown(i16) && (i3 & this.mInitialEdgesTouched[i16]) != 0;
    }

    public boolean checkTouchSlop(int i3) {
        int length = this.mInitialMotionX.length;
        for (int i16 = 0; i16 < length; i16++) {
            if (checkTouchSlop(i3, i16)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i3, int i16) {
        if (!isPointerDown(i16)) {
            return false;
        }
        boolean z16 = (i3 & 1) == 1;
        boolean z17 = (i3 & 2) == 2;
        float f16 = this.mLastMotionX[i16] - this.mInitialMotionX[i16];
        float f17 = this.mLastMotionY[i16] - this.mInitialMotionY[i16];
        if (!z16 || !z17) {
            return z16 ? Math.abs(f16) > ((float) this.mTouchSlop) : z17 && Math.abs(f17) > ((float) this.mTouchSlop);
        }
        float f18 = (f16 * f16) + (f17 * f17);
        int i17 = this.mTouchSlop;
        return f18 > ((float) (i17 * i17));
    }

    private void clearMotionHistory(int i3) {
        if (this.mInitialMotionX == null || !isPointerDown(i3)) {
            return;
        }
        this.mInitialMotionX[i3] = 0.0f;
        this.mInitialMotionY[i3] = 0.0f;
        this.mLastMotionX[i3] = 0.0f;
        this.mLastMotionY[i3] = 0.0f;
        this.mInitialEdgesTouched[i3] = 0;
        this.mEdgeDragsInProgress[i3] = 0;
        this.mEdgeDragsLocked[i3] = 0;
        this.mPointersDown = (~(1 << i3)) & this.mPointersDown;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i3, int i16) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i3, int i16) {
            return 0;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public boolean onEdgeLock(int i3) {
            return false;
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i3);

        public int getOrderedChildIndex(int i3) {
            return i3;
        }

        public void onViewDragStateChanged(int i3) {
        }

        public void onEdgeDragStarted(int i3, int i16) {
        }

        public void onEdgeTouched(int i3, int i16) {
        }

        public void onViewCaptured(@NonNull View view, int i3) {
        }

        public void onViewReleased(@NonNull View view, float f16, float f17) {
        }

        public void onViewPositionChanged(@NonNull View view, int i3, int i16, @Px int i17, @Px int i18) {
        }
    }
}
