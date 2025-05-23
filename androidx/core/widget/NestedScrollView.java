package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    private static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z16;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            accessibilityEvent.setScrollable(z16);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (super.performAccessibilityAction(view, i3, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i3 != 4096) {
                if (i3 != 8192 && i3 != 16908344) {
                    if (i3 != 16908346) {
                        return false;
                    }
                } else {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max, true);
                    return true;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.smoothScrollTo(0, min, true);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i3, int i16, int i17, int i18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
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
        public int scrollPosition;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.scrollPosition);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, null);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin <= (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private static int clamp(int i3, int i16, int i17) {
        if (i16 < i17 && i3 >= 0) {
            if (i16 + i3 > i17) {
                return i17 - i16;
            }
            return i3;
        }
        return 0;
    }

    private void doScrollY(int i3) {
        if (i3 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
    }

    private void ensureGlows() {
        if (getOverScrollMode() != 2) {
            if (this.mEdgeGlowTop == null) {
                Context context = getContext();
                this.mEdgeGlowTop = new EdgeEffect(context);
                this.mEdgeGlowBottom = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
    }

    private View findFocusableViewInBounds(boolean z16, int i3, int i16) {
        boolean z17;
        boolean z18;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z19 = false;
        for (int i17 = 0; i17 < size; i17++) {
            View view2 = focusables.get(i17);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i16) {
                if (i3 < top && bottom < i16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (view == null) {
                    view = view2;
                    z19 = z17;
                } else {
                    if ((z16 && top < view.getTop()) || (!z16 && bottom > view.getBottom())) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z19) {
                        if (z17) {
                            if (!z18) {
                            }
                            view = view2;
                        }
                    } else if (z17) {
                        view = view2;
                        z19 = true;
                    } else {
                        if (!z18) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int i3, int i16) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i16 < childAt.getTop() - scrollY || i16 >= childAt.getBottom() - scrollY || i3 < childAt.getLeft() || i3 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        if ((parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2)) {
            return true;
        }
        return false;
    }

    private boolean isWithinDeltaOfScreen(View view, int i3, int i16) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (this.mTempRect.bottom + i3 >= getScrollY() && this.mTempRect.top - i3 <= getScrollY() + i16) {
            return true;
        }
        return false;
    }

    private void onNestedScrollInternal(int i3, int i16, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i3);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScroll(0, scrollY2, 0, i3 - scrollY2, null, i16, iArr);
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
            this.mLastMotionY = (int) motionEvent.getY(i3);
            this.mActivePointerId = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void runAnimatedScroll(boolean z16) {
        if (z16) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private boolean scrollAndFocus(int i3, int i16, int i17) {
        boolean z16;
        int i18;
        int height = getHeight();
        int scrollY = getScrollY();
        int i19 = height + scrollY;
        boolean z17 = false;
        if (i3 == 33) {
            z16 = true;
        } else {
            z16 = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z16, i16, i17);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i16 < scrollY || i17 > i19) {
            if (z16) {
                i18 = i16 - scrollY;
            } else {
                i18 = i17 - i19;
            }
            doScrollY(i18);
            z17 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i3);
        }
        return z17;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z16) {
        boolean z17;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (z16) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z17;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int i3) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i3);
        } else {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollY(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int i3 = currY - this.mLastScrollerY;
        this.mLastScrollerY = currY;
        int[] iArr = this.mScrollConsumed;
        boolean z16 = false;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i3, iArr, null, 1);
        int i16 = i3 - this.mScrollConsumed[1];
        int scrollRange = getScrollRange();
        if (i16 != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, i16, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i17 = i16 - scrollY2;
            int[] iArr2 = this.mScrollConsumed;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i17, this.mScrollOffset, 1, iArr2);
            i16 = i17 - this.mScrollConsumed[1];
        }
        if (i16 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z16 = true;
            }
            if (z16) {
                ensureGlows();
                if (i16 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            }
            abortAnimatedScroll();
        }
        if (!this.mScroller.isFinished()) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            stopNestedScroll(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i3;
        int i16;
        int i17;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i18 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i3 = i18 - verticalFadingEdgeLength;
        } else {
            i3 = i18;
        }
        int i19 = rect.bottom;
        if (i19 > i3 && rect.top > scrollY) {
            if (rect.height() > height) {
                i17 = rect.top - scrollY;
            } else {
                i17 = rect.bottom - i3;
            }
            return Math.min(i17 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i18);
        }
        if (rect.top >= scrollY || i19 >= i3) {
            return 0;
        }
        if (rect.height() > height) {
            i16 = 0 - (i3 - rect.bottom);
        } else {
            i16 = 0 - (scrollY - rect.top);
        }
        return Math.max(i16, -getScrollY());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return this.mChildHelper.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return this.mChildHelper.dispatchNestedPreFling(f16, f17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        return this.mChildHelper.dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @NonNull int[] iArr2) {
        this.mChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int scrollY = getScrollY();
            int i16 = 0;
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i3 = getPaddingLeft() + 0;
                } else {
                    i3 = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(i3, min);
                this.mEdgeGlowTop.setSize(width, height);
                if (this.mEdgeGlowTop.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i16 = 0 + getPaddingLeft();
                }
                if (getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate(i16 - width2, max);
                canvas.rotate(180.0f, width2, 0.0f);
                this.mEdgeGlowBottom.setSize(width2, height2);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        int i3 = 130;
        if (!canScroll()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19) {
            if (keyCode != 20) {
                if (keyCode != 62) {
                    return false;
                }
                if (keyEvent.isShiftPressed()) {
                    i3 = 33;
                }
                pageScroll(i3);
                return false;
            }
            if (!keyEvent.isAltPressed()) {
                return arrowScroll(130);
            }
            return fullScroll(130);
        }
        if (!keyEvent.isAltPressed()) {
            return arrowScroll(33);
        }
        return fullScroll(33);
    }

    public void fling(int i3) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            runAnimatedScroll(true);
        }
    }

    public boolean fullScroll(int i3) {
        boolean z16;
        int childCount;
        if (i3 == 130) {
            z16 = true;
        } else {
            z16 = false;
        }
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z16 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i3, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return this.mChildHelper.hasNestedScrollingParent(i3);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i16) {
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i16, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY - verticalScrollFactorCompat;
                if (i3 < 0) {
                    scrollRange = 0;
                } else if (i3 <= scrollRange) {
                    scrollRange = i3;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int i16 = this.mActivePointerId;
                    if (i16 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i16);
                        if (findPointerIndex == -1) {
                            Log.e(TAG, "Invalid pointerId=" + i16 + " in onInterceptTouchEvent");
                        } else {
                            int y16 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y16 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = y16;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        } else {
            int y17 = (int) motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), y17)) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mLastMotionY = y17;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                this.mIsBeingDragged = !this.mScroller.isFinished();
                startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int i19 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i19 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i18 - i16) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int clamp = clamp(scrollY, paddingTop, i19);
            if (clamp != scrollY) {
                scrollTo(getScrollX(), clamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.mFillViewport && View.MeasureSpec.getMode(i16) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        if (!z16) {
            dispatchNestedFling(0.0f, f17, true);
            fling((int) f17);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f16, float f17) {
        return dispatchNestedPreFling(f16, f17);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        dispatchNestedPreScroll(i3, i16, iArr, null, i17);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        onNestedScrollInternal(i18, i19, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i3, i16);
        startNestedScroll(2, i16);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        super.scrollTo(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i3, Rect rect) {
        View findNextFocusFromRect;
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i3);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        }
        if (findNextFocusFromRect == null || isOffScreen(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i3, i16, i17, i18);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, i18)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        return (i3 & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        this.mParentHelper.onStopNestedScroll(view, i3);
        stopNestedScroll(i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z16;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                        this.mActivePointerId = -1;
                        endDrag();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    } else {
                        int y16 = (int) motionEvent.getY(findPointerIndex);
                        int i3 = this.mLastMotionY - y16;
                        if (!this.mIsBeingDragged && Math.abs(i3) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i3 = i3 > 0 ? i3 - this.mTouchSlop : i3 + this.mTouchSlop;
                        }
                        int i16 = i3;
                        if (this.mIsBeingDragged) {
                            if (dispatchNestedPreScroll(0, i16, this.mScrollConsumed, this.mScrollOffset, 0)) {
                                i16 -= this.mScrollConsumed[1];
                                this.mNestedYOffset += this.mScrollOffset[1];
                            }
                            int i17 = i16;
                            this.mLastMotionY = y16 - this.mScrollOffset[1];
                            int scrollY = getScrollY();
                            int scrollRange = getScrollRange();
                            int overScrollMode = getOverScrollMode();
                            if (overScrollMode != 0 && (overScrollMode != 1 || scrollRange <= 0)) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (overScrollByCompat(0, i17, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(0)) {
                                this.mVelocityTracker.clear();
                            }
                            int scrollY2 = getScrollY() - scrollY;
                            int[] iArr = this.mScrollConsumed;
                            iArr[1] = 0;
                            dispatchNestedScroll(0, scrollY2, 0, i17 - scrollY2, this.mScrollOffset, 0, iArr);
                            int i18 = this.mLastMotionY;
                            int i19 = this.mScrollOffset[1];
                            this.mLastMotionY = i18 - i19;
                            this.mNestedYOffset += i19;
                            if (z16) {
                                int i26 = i17 - this.mScrollConsumed[1];
                                ensureGlows();
                                int i27 = scrollY + i26;
                                if (i27 < 0) {
                                    EdgeEffectCompat.onPull(this.mEdgeGlowTop, i26 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                    if (!this.mEdgeGlowBottom.isFinished()) {
                                        this.mEdgeGlowBottom.onRelease();
                                    }
                                } else if (i27 > scrollRange) {
                                    EdgeEffectCompat.onPull(this.mEdgeGlowBottom, i26 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                    if (!this.mEdgeGlowTop.isFinished()) {
                                        this.mEdgeGlowTop.onRelease();
                                    }
                                }
                                EdgeEffect edgeEffect = this.mEdgeGlowTop;
                                if (edgeEffect != null && (!edgeEffect.isFinished() || !this.mEdgeGlowBottom.isFinished())) {
                                    ViewCompat.postInvalidateOnAnimation(this);
                                }
                            }
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    int i28 = -yVelocity;
                    float f16 = i28;
                    if (!dispatchNestedPreFling(0.0f, f16)) {
                        dispatchNestedFling(0.0f, f16, true);
                        fling(i28);
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.mActivePointerId = -1;
                endDrag();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z17 = !this.mScroller.isFinished();
            this.mIsBeingDragged = z17;
            if (z17 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            this.mLastMotionY = (int) motionEvent.getY();
            this.mActivePointerId = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    boolean overScrollByCompat(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i29;
        int i36;
        boolean z27;
        boolean z28;
        int overScrollMode = getOverScrollMode();
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z17)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z18)) {
            z26 = false;
        } else {
            z26 = true;
        }
        int i37 = i17 + i3;
        if (!z19) {
            i29 = 0;
        } else {
            i29 = i27;
        }
        int i38 = i18 + i16;
        if (!z26) {
            i36 = 0;
        } else {
            i36 = i28;
        }
        int i39 = -i29;
        int i46 = i29 + i19;
        int i47 = -i36;
        int i48 = i36 + i26;
        if (i37 > i46) {
            i37 = i46;
            z27 = true;
        } else if (i37 < i39) {
            z27 = true;
            i37 = i39;
        } else {
            z27 = false;
        }
        if (i38 > i48) {
            i38 = i48;
            z28 = true;
        } else if (i38 < i47) {
            z28 = true;
            i38 = i47;
        } else {
            z28 = false;
        }
        if (z28 && !hasNestedScrollingParent(1)) {
            this.mScroller.springBack(i37, i38, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i37, i38, z27, z28);
        if (!z27 && !z28) {
            return false;
        }
        return true;
    }

    public boolean pageScroll(int i3) {
        boolean z16;
        if (i3 == 130) {
            z16 = true;
        } else {
            z16 = false;
        }
        int height = getHeight();
        if (z16) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.mTempRect;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i16 = rect3.top;
        int i17 = height + i16;
        rect3.bottom = i17;
        return scrollAndFocus(i3, i16, i17);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mIsLayoutDirty) {
            scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        if (z16) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int clamp = clamp(i3, width, width2);
            int clamp2 = clamp(i16, height, height2);
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    public void setFillViewport(boolean z16) {
        if (z16 != this.mFillViewport) {
            this.mFillViewport = z16;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        this.mChildHelper.setNestedScrollingEnabled(z16);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z16) {
        this.mSmoothScrollingEnabled = z16;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i3, int i16) {
        smoothScrollBy(i3, i16, 250, false);
    }

    public final void smoothScrollTo(int i3, int i16) {
        smoothScrollTo(i3, i16, 250, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return this.mChildHelper.startNestedScroll(i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        this.mChildHelper.stopNestedScroll(i3);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.ayn);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i3, i16, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        return this.mChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr) {
        onNestedPreScroll(view, i3, i16, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
        onNestedScrollInternal(i18, i19, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    public final void smoothScrollBy(int i3, int i16, int i17) {
        smoothScrollBy(i3, i16, i17, false);
    }

    public final void smoothScrollTo(int i3, int i16, int i17) {
        smoothScrollTo(i3, i16, i17, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return startNestedScroll(i3, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i3, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int i3, int i16, int i17, boolean z16) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i16 + scrollY, Math.max(0, height - height2))) - scrollY, i17);
            runAnimatedScroll(z16);
        } else {
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(i3, i16);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18) {
        onNestedScrollInternal(i18, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3) {
        onNestedScrollAccepted(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    void smoothScrollTo(int i3, int i16, boolean z16) {
        smoothScrollTo(i3, i16, 250, z16);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    void smoothScrollTo(int i3, int i16, int i17, boolean z16) {
        smoothScrollBy(i3 - getScrollX(), i16 - getScrollY(), i17, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
