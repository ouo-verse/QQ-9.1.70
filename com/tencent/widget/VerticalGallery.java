package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.Scroller;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.AdapterView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VerticalGallery extends VerticalAbsSpinner implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    static IPatchRedirector $redirector_ = null;
    public static final int HORIZONTAL = 1;
    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    private static final String TAG = "Gallery";
    public static final int VERTICAL = 2;
    private int mAnimationDuration;
    private AdapterView.AdapterContextMenuInfo mContextMenuInfo;
    private Runnable mDisableSuppressSelectionChangedRunnable;
    private int mDownTouchPosition;
    private View mDownTouchView;
    private int mFirstChildOffset;
    private FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsDisableScroll;
    private boolean mIsFirstScroll;
    private boolean mIsScrollCycle;
    private boolean mIsScrollCycleTemp;
    private boolean mIsSlotCenter;
    private int mLeftMost;
    private OnEndFlingListener mOnEndFlingListener;
    private OnEndMovementListener mOnEndMovementListener;
    private OnSelectViewDataUpdateListener mOnSelectViewDataUpdateListener;
    private int mOrientation;
    private boolean mReceivedInvokeKeyDown;
    private int mRightMost;
    private int mScrollBarBottomMargin;
    private int mScrollBarSize;
    private boolean mScrolling;
    private View mSelectedChild;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mShouldStopFling;
    private int mSpacing;
    private boolean mSuppressSelectionChanged;
    private float mUnselectedAlpha;
    private float mVelocityRatio;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class FlingRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private int mLastFlingX;
        private int mLastFlingY;
        private Scroller mScroller;

        public FlingRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerticalGallery.this);
            } else {
                this.mScroller = new Scroller(VerticalGallery.this.getContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endFling(boolean z16) {
            VerticalGallery.this.mScrolling = false;
            this.mScroller.forceFinished(true);
            if (z16) {
                VerticalGallery.this.scrollIntoSlots();
            }
            VerticalGallery.this.onEndFling();
        }

        private void startCommon() {
            VerticalGallery.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (VerticalGallery.this.isOrientationVertical()) {
                runVertical();
                return;
            }
            VerticalGallery verticalGallery = VerticalGallery.this;
            if (verticalGallery.mItemCount != 0) {
                verticalGallery.mShouldStopFling = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i3 = this.mLastFlingX - currX;
                if (i3 > 0) {
                    VerticalGallery verticalGallery2 = VerticalGallery.this;
                    verticalGallery2.mDownTouchPosition = verticalGallery2.mFirstPosition;
                    max = Math.min(((VerticalGallery.this.getWidth() - VerticalGallery.this.getPaddingLeft()) - VerticalGallery.this.getPaddingRight()) - 1, i3);
                } else {
                    int childCount = VerticalGallery.this.getChildCount() - 1;
                    VerticalGallery verticalGallery3 = VerticalGallery.this;
                    verticalGallery3.mDownTouchPosition = verticalGallery3.mFirstPosition + childCount;
                    max = Math.max(-(((VerticalGallery.this.getWidth() - VerticalGallery.this.getPaddingRight()) - VerticalGallery.this.getPaddingLeft()) - 1), i3);
                }
                VerticalGallery.this.trackMotionScroll(max);
                if (computeScrollOffset && !VerticalGallery.this.mShouldStopFling) {
                    this.mLastFlingX = currX;
                    VerticalGallery.this.post(this);
                    return;
                } else {
                    endFling(true);
                    return;
                }
            }
            endFling(true);
        }

        public void runVertical() {
            int max;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            VerticalGallery verticalGallery = VerticalGallery.this;
            if (verticalGallery.mItemCount != 0) {
                verticalGallery.mShouldStopFling = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currY = scroller.getCurrY();
                int i3 = this.mLastFlingY - currY;
                if (i3 > 0) {
                    VerticalGallery verticalGallery2 = VerticalGallery.this;
                    verticalGallery2.mDownTouchPosition = verticalGallery2.mFirstPosition;
                    max = Math.min(((VerticalGallery.this.getHeight() - VerticalGallery.this.getPaddingTop()) - VerticalGallery.this.getPaddingBottom()) - 1, i3);
                } else {
                    int childCount = VerticalGallery.this.getChildCount() - 1;
                    VerticalGallery verticalGallery3 = VerticalGallery.this;
                    verticalGallery3.mDownTouchPosition = verticalGallery3.mFirstPosition + childCount;
                    max = Math.max(-(((VerticalGallery.this.getHeight() - VerticalGallery.this.getPaddingBottom()) - VerticalGallery.this.getPaddingTop()) - 1), i3);
                }
                VerticalGallery.this.trackMotionScrollVertical(max);
                if (computeScrollOffset && !VerticalGallery.this.mShouldStopFling) {
                    this.mLastFlingY = currY;
                    VerticalGallery.this.post(this);
                    return;
                } else {
                    endFling(true);
                    return;
                }
            }
            endFling(true);
        }

        public void startUsingDistance(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                return;
            }
            if (VerticalGallery.this.isOrientationVertical()) {
                startCommon();
                VerticalGallery.this.mScrolling = true;
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, -i3, VerticalGallery.this.mAnimationDuration);
                VerticalGallery.this.post(this);
                return;
            }
            startCommon();
            VerticalGallery.this.mScrolling = true;
            this.mLastFlingX = 0;
            this.mScroller.startScroll(0, 0, -i3, 0, VerticalGallery.this.mAnimationDuration);
            VerticalGallery.this.post(this);
        }

        public void startUsingVelocity(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                return;
            }
            startCommon();
            int i17 = Integer.MAX_VALUE;
            if (VerticalGallery.this.isOrientationVertical()) {
                if (i3 < 0) {
                    i16 = Integer.MAX_VALUE;
                } else {
                    i16 = 0;
                }
                this.mLastFlingY = i16;
                this.mScroller.fling(0, i16, 0, i3, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                VerticalGallery.this.post(this);
                return;
            }
            if (i3 >= 0) {
                i17 = 0;
            }
            this.mLastFlingX = i17;
            this.mScroller.fling(i17, 0, i3, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            VerticalGallery.this.post(this);
        }

        public void stop(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                VerticalGallery.this.removeCallbacks(this);
                endFling(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        static IPatchRedirector $redirector_;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnEndFlingListener {
        void onEndFling(VerticalGallery verticalGallery);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnEndMovementListener {
        void onEndMovement(VerticalGallery verticalGallery);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnSelectViewDataUpdateListener {
        void onSelectDataUpdate(View view, int i3);
    }

    public VerticalGallery(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int calculateLeft(View view, boolean z16) {
        int width;
        int width2;
        if (z16) {
            width = getMeasuredWidth();
        } else {
            width = getWidth();
        }
        if (z16) {
            width2 = view.getMeasuredWidth();
        } else {
            width2 = view.getWidth();
        }
        int i3 = this.mGravity;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 5) {
                    return 0;
                }
                return (width - this.mSpinnerPadding.right) - width2;
            }
            return this.mSpinnerPadding.left;
        }
        Rect rect = this.mSpinnerPadding;
        int i16 = width - rect.right;
        int i17 = rect.left;
        return i17 + (((i16 - i17) - width2) / 2);
    }

    private int calculateTop(View view, boolean z16) {
        int height;
        int height2;
        if (z16) {
            height = getMeasuredHeight();
        } else {
            height = getHeight();
        }
        if (z16) {
            height2 = view.getMeasuredHeight();
        } else {
            height2 = view.getHeight();
        }
        int i3 = this.mGravity;
        if (i3 != 16) {
            if (i3 != 48) {
                if (i3 != 80) {
                    return 0;
                }
                return (height - this.mSpinnerPadding.bottom) - height2;
            }
            return this.mSpinnerPadding.top;
        }
        Rect rect = this.mSpinnerPadding;
        int i16 = height - rect.bottom;
        int i17 = rect.top;
        return i17 + (((i16 - i17) - height2) / 2);
    }

    private void detachOffScreenChildren(boolean z16) {
        int i3;
        int childCount = getChildCount();
        int i16 = this.mFirstPosition;
        int i17 = 0;
        if (z16) {
            int paddingLeft = getPaddingLeft();
            i3 = 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                if (childAt.getRight() >= paddingLeft) {
                    break;
                }
                i3++;
                this.mRecycler.put(i16 + i18, childAt);
            }
            if (i3 == childCount) {
                i3--;
            }
        } else {
            int width = getWidth() - getPaddingRight();
            int i19 = 0;
            int i26 = 0;
            for (int i27 = childCount - 1; i27 >= 0; i27--) {
                View childAt2 = getChildAt(i27);
                if (childAt2.getLeft() <= width) {
                    break;
                }
                i26++;
                this.mRecycler.put(i16 + i27, childAt2);
                i19 = i27;
            }
            if (i19 == 0) {
                i17 = i19 + 1;
                i3 = i26;
            } else {
                i3 = i26;
                i17 = i19;
            }
        }
        detachViewsFromParent(i17, i3);
        if (z16) {
            this.mFirstPosition += i3;
            if (isScrollCycle()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    private void detachOffScreenChildrenVertical(boolean z16) {
        int i3;
        int childCount = getChildCount();
        int i16 = this.mFirstPosition;
        int i17 = 0;
        if (z16) {
            int paddingTop = getPaddingTop();
            i3 = 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                if (childAt.getBottom() >= paddingTop) {
                    break;
                }
                i3++;
                this.mRecycler.put(i16 + i18, childAt);
            }
            if (i3 == childCount) {
                i3--;
            }
        } else {
            int height = getHeight() - getPaddingBottom();
            int i19 = 0;
            int i26 = 0;
            for (int i27 = childCount - 1; i27 >= 0; i27--) {
                View childAt2 = getChildAt(i27);
                if (childAt2.getTop() <= height) {
                    break;
                }
                i26++;
                this.mRecycler.put(i16 + i27, childAt2);
                i19 = i27;
            }
            if (i19 == 0) {
                i17 = i19 + 1;
                i3 = i26;
            } else {
                i3 = i26;
                i17 = i19;
            }
        }
        detachViewsFromParent(i17, i3);
        if (z16) {
            this.mFirstPosition += i3;
            if (isScrollCycle()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    private boolean dispatchLongPress(View view, int i3, long j3) {
        boolean z16;
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            z16 = onItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, j3);
        } else {
            z16 = false;
        }
        if (!z16) {
            this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(view, i3, j3);
            z16 = super.showContextMenuForChild(this);
        }
        if (z16) {
            performHapticFeedback(0);
        }
        return z16;
    }

    private void dispatchPress(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    private void fillToGalleryBottom() {
        int i3;
        int paddingTop;
        if (isScrollCycle()) {
            fillToGalleryBottomCycle();
            return;
        }
        int i16 = this.mSpacing;
        int bottom = (getBottom() - getTop()) - getPaddingRight();
        int childCount = getChildCount();
        int i17 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i16;
        } else {
            i3 = this.mItemCount - 1;
            this.mFirstPosition = i3;
            paddingTop = getPaddingTop();
            this.mShouldStopFling = true;
        }
        while (paddingTop < bottom && i3 < i17) {
            paddingTop = makeAndAddViewVertical(i3, i3 - this.mSelectedPosition, paddingTop, true).getBottom() + i16;
            i3++;
        }
    }

    private void fillToGalleryBottomCycle() {
        int i3;
        int paddingTop;
        int i16 = this.mSpacing;
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i17 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i16;
        } else {
            i3 = this.mItemCount - 1;
            this.mFirstPosition = i3;
            paddingTop = getPaddingTop();
            this.mShouldStopFling = true;
        }
        while (paddingTop < bottom && i3 < i17) {
            paddingTop = makeAndAddViewVertical(i3, i3 - this.mSelectedPosition, paddingTop, true).getBottom() + i16;
            i3++;
        }
        int i18 = i3 % i17;
        while (paddingTop <= bottom && getChildCount() < this.mItemCount) {
            paddingTop = makeAndAddViewVertical(i18, i18 - this.mSelectedPosition, paddingTop, true).getBottom() + i16;
            i18++;
        }
    }

    private void fillToGalleryLeft() {
        int right;
        int i3;
        if (isScrollCycle()) {
            fillToGalleryLeftCycle();
            return;
        }
        int i16 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.mFirstPosition - 1;
            right = childAt.getLeft() - i16;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
            i3 = 0;
        }
        while (right > paddingLeft && i3 >= 0) {
            View makeAndAddView = makeAndAddView(i3, i3 - this.mSelectedPosition, right, false);
            this.mFirstPosition = i3;
            right = makeAndAddView.getLeft() - i16;
            i3--;
        }
    }

    private void fillToGalleryLeftCycle() {
        int right;
        int i3;
        int i16 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.mFirstPosition - 1;
            right = childAt.getLeft() - i16;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
            i3 = 0;
        }
        while (right > paddingLeft && i3 >= 0) {
            View makeAndAddView = makeAndAddView(i3, i3 - this.mSelectedPosition, right, false);
            this.mFirstPosition = i3;
            right = makeAndAddView.getLeft() - i16;
            i3--;
        }
        int i17 = this.mItemCount - 1;
        while (right > paddingLeft && getChildCount() < this.mItemCount) {
            View makeAndAddView2 = makeAndAddView(i17, i17 - this.mSelectedPosition, right, false);
            this.mFirstPosition = i17;
            right = makeAndAddView2.getLeft() - i16;
            i17--;
        }
    }

    private void fillToGalleryRight() {
        int i3;
        int paddingLeft;
        if (isScrollCycle()) {
            fillToGalleryRightCycle();
            return;
        }
        int i16 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i17 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i16;
        } else {
            i3 = this.mItemCount - 1;
            this.mFirstPosition = i3;
            paddingLeft = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (paddingLeft < right && i3 < i17) {
            paddingLeft = makeAndAddView(i3, i3 - this.mSelectedPosition, paddingLeft, true).getRight() + i16;
            i3++;
        }
    }

    private void fillToGalleryRightCycle() {
        int i3;
        int paddingLeft;
        int i16 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i17 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i16;
        } else {
            i3 = this.mItemCount - 1;
            this.mFirstPosition = i3;
            paddingLeft = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (paddingLeft < right && i3 < i17) {
            paddingLeft = makeAndAddView(i3, i3 - this.mSelectedPosition, paddingLeft, true).getRight() + i16;
            i3++;
        }
        int i18 = i3 % i17;
        while (paddingLeft <= right && getChildCount() < this.mItemCount) {
            paddingLeft = makeAndAddView(i18, i18 - this.mSelectedPosition, paddingLeft, true).getRight() + i16;
            i18++;
        }
    }

    private void fillToGalleryTop() {
        int bottom;
        int i3;
        if (isScrollCycle()) {
            fillToGalleryTopCycle();
            return;
        }
        int i16 = this.mSpacing;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i16;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.mShouldStopFling = true;
            i3 = 0;
        }
        while (bottom > paddingTop && i3 >= 0) {
            View makeAndAddViewVertical = makeAndAddViewVertical(i3, i3 - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i3;
            bottom = makeAndAddViewVertical.getTop() - i16;
            i3--;
        }
    }

    private void fillToGalleryTopCycle() {
        int bottom;
        int i3;
        int i16 = this.mSpacing;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i16;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.mShouldStopFling = true;
            i3 = 0;
        }
        while (bottom > paddingTop && i3 >= 0) {
            View makeAndAddViewVertical = makeAndAddViewVertical(i3, i3 - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i3;
            bottom = makeAndAddViewVertical.getTop() - i16;
            i3--;
        }
        int i17 = this.mItemCount - 1;
        while (bottom > paddingTop && getChildCount() < this.mItemCount) {
            View makeAndAddViewVertical2 = makeAndAddViewVertical(i17, i17 - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i17;
            bottom = makeAndAddViewVertical2.getTop() - i16;
            i17--;
        }
    }

    private int getCenterOfView(View view) {
        int left;
        int width;
        if (isOrientationVertical()) {
            left = view.getTop();
            width = view.getHeight() / 2;
        } else {
            left = view.getLeft();
            width = view.getWidth() / 2;
        }
        return left + width;
    }

    private float getStopFlingPosition() {
        float width;
        int paddingLeft;
        if (isOrientationVertical()) {
            width = ((getHeight() - getPaddingTop()) - getPaddingBottom()) * onStopFlingPosRatio();
            paddingLeft = getPaddingTop();
        } else {
            width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) * onStopFlingPosRatio();
            paddingLeft = getPaddingLeft();
        }
        return width + paddingLeft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrientationVertical() {
        if (this.mOrientation == 2) {
            return true;
        }
        return false;
    }

    private View makeAndAddView(int i3, int i16, int i17, boolean z16) {
        View view;
        if (!this.mDataChanged && (view = this.mRecycler.get(i3)) != null) {
            int left = view.getLeft();
            this.mRightMost = Math.max(this.mRightMost, view.getMeasuredWidth() + left);
            this.mLeftMost = Math.min(this.mLeftMost, left);
            setUpChild(view, i16, i17, z16);
            return view;
        }
        View view2 = this.mAdapter.getView(i3, null, this);
        setUpChild(view2, i16, i17, z16);
        return view2;
    }

    private View makeAndAddViewVertical(int i3, int i16, int i17, boolean z16) {
        View view;
        if (!this.mDataChanged && (view = this.mRecycler.get(i3)) != null) {
            int top = view.getTop();
            this.mRightMost = Math.max(this.mRightMost, view.getMeasuredHeight() + top);
            this.mLeftMost = Math.min(this.mLeftMost, top);
            setUpChildVertical(view, i16, i17, z16);
            return view;
        }
        View view2 = this.mAdapter.getView(i3, null, this);
        setUpChildVertical(view2, i16, i17, z16);
        return view2;
    }

    private void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
            super.selectionChanged();
        }
        invalidate();
        OnEndMovementListener onEndMovementListener = this.mOnEndMovementListener;
        if (onEndMovementListener != null) {
            onEndMovementListener.onEndMovement(this);
        }
    }

    private boolean performItemSelect(int i3) {
        if (i3 != this.mSelectedPosition) {
            setSelectedPositionInt(i3);
            setNextSelectedPositionInt(i3);
            checkSelectionChanged();
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void scrollIntoSlotsVertical() {
        int height;
        int bottom;
        int height2;
        int bottom2;
        View view;
        if (isSlotInCenter()) {
            if (getChildCount() != 0 && (view = this.mSelectedChild) != null) {
                int centerOfGallery = getCenterOfGallery() - getCenterOfView(view);
                if (centerOfGallery != 0) {
                    this.mFlingRunnable.startUsingDistance(centerOfGallery);
                    return;
                } else {
                    onFinishedMovement();
                    return;
                }
            }
            return;
        }
        if (getChildCount() == 0) {
            return;
        }
        int i3 = this.mFirstPosition;
        int i16 = 0;
        if (i3 == 0) {
            View childAt = getChildAt(0);
            if (childAt.getTop() >= 0) {
                height = getPaddingTop();
                bottom = childAt.getTop();
                i16 = height - bottom;
                if (i16 == 0) {
                    this.mFlingRunnable.startUsingDistance(i16);
                    return;
                } else {
                    onFinishedMovement();
                    return;
                }
            }
            View childAt2 = getChildAt(getChildCount() - 1);
            if (childAt2.getBottom() - childAt.getTop() < getBottom() - getPaddingBottom()) {
                height2 = getPaddingLeft();
                bottom2 = this.mFirstChildOffset;
            } else {
                if (childAt2.getBottom() < getBottom() - getPaddingBottom()) {
                    height2 = getHeight() - getPaddingBottom();
                    bottom2 = childAt2.getBottom();
                }
                if (i16 == 0) {
                }
            }
            i16 = height2 - bottom2;
            if (i16 == 0) {
            }
        } else {
            if (i3 + getChildCount() == this.mItemCount) {
                View childAt3 = getChildAt(getChildCount() - 1);
                if (childAt3.getBottom() < getBottom() - getPaddingBottom()) {
                    height = getHeight() - getPaddingBottom();
                    bottom = childAt3.getBottom();
                    i16 = height - bottom;
                }
            }
            if (i16 == 0) {
            }
        }
    }

    private boolean scrollToChild(int i3) {
        View childAt = getChildAt(i3);
        if (childAt != null) {
            this.mFlingRunnable.startUsingDistance(getCenterOfGallery() - getCenterOfView(childAt));
            return true;
        }
        return false;
    }

    private void setSelectionToCenterChild() {
        View view = this.mSelectedChild;
        if (view == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view.getLeft() <= centerOfGallery && view.getRight() >= centerOfGallery) {
            return;
        }
        int childCount = getChildCount() - 1;
        int i3 = Integer.MAX_VALUE;
        int i16 = 0;
        while (true) {
            if (childCount >= 0) {
                View childAt = getChildAt(childCount);
                if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                    break;
                }
                int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
                if (min < i3) {
                    i16 = childCount;
                    i3 = min;
                }
                childCount--;
            } else {
                childCount = i16;
                break;
            }
        }
        int i17 = this.mFirstPosition + childCount;
        if (isScrollCycle()) {
            i17 %= this.mItemCount;
        }
        if (i17 != this.mSelectedPosition) {
            setSelectedPositionInt(i17);
            setNextSelectedPositionInt(i17);
            checkSelectionChanged();
        }
    }

    private void setSelectionToCenterChildVertical() {
        View view = this.mSelectedChild;
        if (view == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view != null && view.getTop() <= centerOfGallery && view.getBottom() >= centerOfGallery) {
            return;
        }
        int childCount = getChildCount() - 1;
        int i3 = Integer.MAX_VALUE;
        int i16 = 0;
        while (true) {
            if (childCount >= 0) {
                View childAt = getChildAt(childCount);
                if (childAt.getTop() <= centerOfGallery && childAt.getBottom() >= centerOfGallery) {
                    break;
                }
                int min = Math.min(Math.abs(childAt.getTop() - centerOfGallery), Math.abs(childAt.getBottom() - centerOfGallery));
                if (min < i3) {
                    i16 = childCount;
                    i3 = min;
                }
                childCount--;
            } else {
                childCount = i16;
                break;
            }
        }
        int i17 = this.mFirstPosition + childCount;
        if (isScrollCycle()) {
            i17 %= this.mItemCount;
        }
        if (i17 != this.mSelectedPosition) {
            setSelectedPositionInt(i17);
            setNextSelectedPositionInt(i17);
            checkSelectionChanged();
        }
    }

    private void setUpChild(View view, int i3, int i16, boolean z16) {
        int i17;
        int i18;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        boolean z17 = false;
        if (z16) {
            i17 = -1;
        } else {
            i17 = 0;
        }
        addViewInLayout(view, i17, layoutParams);
        if (i3 == 0) {
            z17 = true;
        }
        view.setSelected(z17);
        int i19 = this.mHeightMeasureSpec;
        Rect rect = this.mSpinnerPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i19, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i26 = this.mWidthMeasureSpec;
        Rect rect2 = this.mSpinnerPadding;
        view.measure(ViewGroup.getChildMeasureSpec(i26, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
        int calculateTop = calculateTop(view, true);
        int measuredHeight = view.getMeasuredHeight() + calculateTop;
        int measuredWidth = view.getMeasuredWidth();
        if (z16) {
            i18 = measuredWidth + i16;
        } else {
            int i27 = i16 - measuredWidth;
            i18 = i16;
            i16 = i27;
        }
        view.layout(i16, calculateTop, i18, measuredHeight);
    }

    private void setUpChildVertical(View view, int i3, int i16, boolean z16) {
        int i17;
        int i18;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        boolean z17 = false;
        if (z16) {
            i17 = -1;
        } else {
            i17 = 0;
        }
        addViewInLayout(view, i17, layoutParams);
        if (i3 == 0) {
            z17 = true;
        }
        view.setSelected(z17);
        int i19 = this.mHeightMeasureSpec;
        Rect rect = this.mSpinnerPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i19, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i26 = this.mWidthMeasureSpec;
        Rect rect2 = this.mSpinnerPadding;
        view.measure(ViewGroup.getChildMeasureSpec(i26, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
        int calculateLeft = calculateLeft(view, true);
        int measuredWidth = view.getMeasuredWidth() + calculateLeft;
        int measuredHeight = view.getMeasuredHeight();
        if (z16) {
            i18 = measuredHeight + i16;
        } else {
            int i27 = i16 - measuredHeight;
            i18 = i16;
            i16 = i27;
        }
        view.layout(calculateLeft, i16, measuredWidth, i18);
    }

    private void updateSelectedItemMetadata() {
        int i3;
        int i16;
        View view = this.mSelectedChild;
        int i17 = this.mSelectedPosition - this.mFirstPosition;
        if (isScrollCycle() && (i3 = this.mFirstPosition) > (i16 = this.mSelectedPosition)) {
            i17 = (this.mItemCount - i3) + i16;
        }
        View childAt = getChildAt(i17);
        this.mSelectedChild = childAt;
        if (childAt == null) {
            return;
        }
        childAt.setSelected(true);
        childAt.setFocusable(true);
        if (hasFocus()) {
            childAt.requestFocus();
        }
        OnSelectViewDataUpdateListener onSelectViewDataUpdateListener = this.mOnSelectViewDataUpdateListener;
        if (onSelectViewDataUpdateListener != null) {
            onSelectViewDataUpdateListener.onSelectDataUpdate(childAt, i17);
        }
        if (view != null && view != this.mSelectedChild) {
            view.setSelected(false);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) layoutParams)).booleanValue();
        }
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int childCount = getChildCount();
        boolean z17 = false;
        if (childCount <= 0) {
            return 0;
        }
        int i3 = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            if (this.mFirstPosition == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || left <= 0) {
                i3 += (left * 100) / width;
            }
        }
        View childAt2 = getChildAt(childCount - 1);
        int right = childAt2.getRight();
        int width2 = childAt2.getWidth();
        if (width2 > 0) {
            if (this.mFirstPosition + childCount == this.mItemCount) {
                z17 = true;
            }
            if (!z17 || right >= getWidth()) {
                return i3 - (((right - getWidth()) * 100) / width2);
            }
            return i3;
        }
        return i3;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (this.mFirstPosition >= 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((this.mFirstPosition / 1) * 100) - ((left * 100) / width), 0);
            }
        }
        return this.mSelectedPosition;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return Math.max((((this.mItemCount + 1) - 1) / 1) * 100, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return keyEvent.dispatch(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
            return;
        }
        View view = this.mSelectedChild;
        if (view != null) {
            view.setPressed(z16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
        }
    }

    protected void dispatchUnpress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    @Override // com.tencent.widget.VerticalAbsSpinner, com.tencent.widget.AbsSpinner, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 16, (Object) this, (Object) layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCenterOfGallery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        if (isOrientationVertical()) {
            return (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2) + getPaddingTop();
        }
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int i17 = this.mSelectedPosition - this.mFirstPosition;
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

    @Override // com.tencent.widget.AbsSpinner
    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) transformation)).booleanValue();
        }
        transformation.clear();
        if (view == this.mSelectedChild) {
            f16 = 1.0f;
        } else {
            f16 = this.mUnselectedAlpha;
        }
        transformation.setAlpha(f16);
        return true;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ContextMenu.ContextMenuInfo) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.mContextMenuInfo;
    }

    public int getFirstPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }
        return this.mFirstPosition;
    }

    public int getItemIndexFromPoint(Point point) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this, (Object) point)).intValue();
        }
        int childCount = getChildCount();
        Rect rect = new Rect();
        getDrawingRect(rect);
        if (rect.contains(point.x, point.y)) {
            i3 = 0;
            while (i3 < childCount) {
                getChildAt(i3).getHitRect(rect);
                if (rect.contains(point.x, point.y)) {
                    break;
                }
                i3++;
            }
        }
        i3 = -1;
        if (i3 < 0) {
            return -1;
        }
        return i3 + this.mFirstPosition;
    }

    int getLimitedMotionScrollAmount(boolean z16, int i3) {
        int i16;
        if (z16) {
            i16 = this.mItemCount - 1;
        } else {
            i16 = 0;
        }
        View childAt = getChildAt(i16 - this.mFirstPosition);
        if (childAt == null) {
            return i3;
        }
        int centerOfView = getCenterOfView(childAt);
        int centerOfGallery = getCenterOfGallery();
        if (z16) {
            if (centerOfView <= centerOfGallery) {
                return 0;
            }
        } else if (centerOfView >= centerOfGallery) {
            return 0;
        }
        int i17 = centerOfGallery - centerOfView;
        if (z16) {
            return Math.max(i17, i3);
        }
        return Math.min(i17, i3);
    }

    public int getOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.mOrientation;
    }

    public int getSpacing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this)).intValue();
        }
        return this.mSpacing;
    }

    public float getVelocityRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Float) iPatchRedirector.redirect((short) 66, (Object) this)).floatValue();
        }
        return this.mVelocityRatio;
    }

    @Override // android.view.View
    public void invalidate(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.invalidate(i3, i16 - (this.mScrollBarSize + this.mScrollBarBottomMargin), i17, i18);
        }
    }

    public boolean isPointInChild(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (f16 >= childAt.getLeft() && f16 <= childAt.getRight() && f17 >= childAt.getTop() && f17 <= childAt.getBottom()) {
                return true;
            }
        }
        return false;
    }

    public boolean isScrollCycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Boolean) iPatchRedirector.redirect((short) 74, (Object) this)).booleanValue();
        }
        if (this.mIsScrollCycle && this.mIsScrollCycleTemp) {
            return true;
        }
        return false;
    }

    public boolean isScrolling() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        return this.mScrolling;
    }

    public boolean isSlotInCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.mIsSlotCenter;
    }

    @Override // com.tencent.widget.AbsSpinner
    void layout(int i3, boolean z16) {
        if (isOrientationVertical()) {
            layoutVertical(i3, z16);
            return;
        }
        int i16 = this.mSpinnerPadding.left + this.mFirstChildOffset;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        int i17 = this.mNextSelectedPosition;
        if (i17 >= 0) {
            setSelectedPositionInt(i17);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        boolean z17 = false;
        this.mRightMost = 0;
        this.mLeftMost = 0;
        int i18 = this.mSelectedPosition;
        this.mFirstPosition = i18;
        View makeAndAddView = makeAndAddView(i18, 0, 0, true);
        int i19 = this.mSpacing + i16;
        if (isSlotInCenter()) {
            int right = getRight() - getLeft();
            Rect rect = this.mSpinnerPadding;
            i19 = (i16 + (((right - rect.left) - rect.right) / 2)) - (makeAndAddView.getWidth() / 2);
        }
        makeAndAddView.offsetLeftAndRight(i19);
        fillToGalleryRight();
        fillToGalleryLeft();
        this.mRecycler.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
        if (getChildCount() < this.mItemCount) {
            z17 = true;
        }
        this.mIsScrollCycleTemp = z17;
    }

    void layoutVertical(int i3, boolean z16) {
        int i16 = this.mSpinnerPadding.top + this.mFirstChildOffset;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        int i17 = this.mNextSelectedPosition;
        if (i17 >= 0) {
            setSelectedPositionInt(i17);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        boolean z17 = false;
        this.mRightMost = 0;
        this.mLeftMost = 0;
        int i18 = this.mSelectedPosition;
        this.mFirstPosition = i18;
        View makeAndAddViewVertical = makeAndAddViewVertical(i18, 0, 0, true);
        int i19 = this.mSpacing + i16;
        if (isSlotInCenter()) {
            int bottom = getBottom() - getTop();
            Rect rect = this.mSpinnerPadding;
            i19 = (i16 + (((bottom - rect.top) - rect.bottom) / 2)) - (makeAndAddViewVertical.getHeight() / 2);
        }
        makeAndAddViewVertical.offsetTopAndBottom(i19);
        fillToGalleryBottom();
        fillToGalleryTop();
        this.mRecycler.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
        if (getChildCount() < this.mItemCount) {
            z17 = true;
        }
        this.mIsScrollCycleTemp = z17;
    }

    boolean moveNext() {
        int i3 = this.mItemCount;
        if (i3 > 0 && this.mSelectedPosition < i3 - 1) {
            return true;
        }
        return false;
    }

    boolean movePrevious() {
        if (this.mItemCount > 0 && this.mSelectedPosition > 0) {
            return true;
        }
        return false;
    }

    public void offsetChildrenLeftAndRight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i3);
            getChildAt(childCount).invalidate();
        }
    }

    public void offsetChildrenTopAndBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetTopAndBottom(i3);
            getChildAt(childCount).invalidate();
        }
    }

    void onCancel() {
        onUp();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (1 == motionEvent.getAction() && this.mDownTouchPosition >= 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.mFlingRunnable.stop(false);
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        this.mDownTouchPosition = pointToPosition;
        if (pointToPosition >= 0) {
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            this.mDownTouchView = childAt;
            childAt.setPressed(true);
        }
        this.mIsFirstScroll = true;
        return true;
    }

    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable drawable, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, canvas, drawable, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int i19 = i18 - this.mScrollBarBottomMargin;
        drawable.setBounds(i3, i19 - this.mScrollBarSize, i17, i19);
        drawable.draw(canvas);
    }

    protected void onEndFling() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
            return;
        }
        OnEndFlingListener onEndFlingListener = this.mOnEndFlingListener;
        if (onEndFlingListener != null) {
            onEndFlingListener.onEndFling(this);
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (shouldDisableScroll()) {
            return true;
        }
        if (!this.mShouldCallbackDuringFling) {
            removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
        }
        if (isOrientationVertical()) {
            this.mFlingRunnable.startUsingVelocity((int) (-(f17 * getVelocityRatio())));
        } else {
            this.mFlingRunnable.startUsingVelocity((int) (-(f16 * getVelocityRatio())));
        }
        return true;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
            return;
        }
        super.onFocusChanged(z16, i3, rect);
        if (z16 && (view = this.mSelectedChild) != null) {
            view.requestFocus(i3);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 != 66) {
            switch (i3) {
                case 21:
                    if (movePrevious()) {
                        playSoundEffect(1);
                    }
                    return true;
                case 22:
                    if (moveNext()) {
                        playSoundEffect(3);
                    }
                    return true;
            }
            return super.onKeyDown(i3, keyEvent);
        }
        this.mReceivedInvokeKeyDown = true;
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 != 23 && i3 != 66) {
            return super.onKeyUp(i3, keyEvent);
        }
        if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
            dispatchPress(this.mSelectedChild);
            postDelayed(new Runnable() { // from class: com.tencent.widget.VerticalGallery.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerticalGallery.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        VerticalGallery.this.dispatchUnpress();
                    }
                }
            }, ViewConfiguration.getPressedStateDuration());
            View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
            int i16 = this.mSelectedPosition;
            performItemClick(childAt, i16, this.mAdapter.getItemId(i16));
        }
        this.mReceivedInvokeKeyDown = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) motionEvent);
        } else {
            if (this.mDownTouchPosition < 0) {
                return;
            }
            performHapticFeedback(0);
            dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, getItemIdAtPosition(this.mDownTouchPosition));
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (shouldDisableScroll()) {
            return true;
        }
        this.mScrolling = true;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.mShouldCallbackDuringFling) {
            if (this.mIsFirstScroll) {
                if (!this.mSuppressSelectionChanged) {
                    this.mSuppressSelectionChanged = true;
                }
                postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
            }
        } else if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
        }
        if (isOrientationVertical()) {
            trackMotionScrollVertical(((int) f17) * (-1));
        } else {
            trackMotionScroll(((int) f16) * (-1));
        }
        this.mIsFirstScroll = false;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Boolean) iPatchRedirector.redirect((short) 69, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mDownTouchPosition >= 0) {
            if (isScrollCycle()) {
                this.mDownTouchPosition %= getCount();
            }
            if (isSlotInCenter()) {
                scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
            }
            performItemSelect(this.mDownTouchPosition);
            if (this.mShouldCallbackOnUnselectedItemClick || this.mDownTouchPosition == this.mSelectedPosition) {
                View view = this.mDownTouchView;
                int i3 = this.mDownTouchPosition;
                performItemClick(view, i3, this.mAdapter.getItemId(i3));
                return true;
            }
            return true;
        }
        return false;
    }

    protected float onStopFlingPosRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return 0.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            onUp();
        } else if (action == 3) {
            onCancel();
        }
        return onTouchEvent;
    }

    protected void onUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (this.mFlingRunnable.mScroller.isFinished()) {
            scrollIntoSlots();
        }
        dispatchUnpress();
    }

    public int scrollGalleryItems(boolean z16) {
        int min;
        FlingRunnable flingRunnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Integer) iPatchRedirector.redirect((short) 62, (Object) this, z16)).intValue();
        }
        if (getChildCount() == 0) {
            return 0;
        }
        if (z16) {
            View childAt = getChildAt(getChildCount() - 1);
            min = Math.max(childAt != null ? (childAt.getRight() - getRight()) + getPaddingRight() : 0, 0);
            if (min == 0 && this.mFirstPosition + getChildCount() != this.mItemCount) {
                min += childAt != null ? childAt.getWidth() : 0;
            }
        } else {
            View childAt2 = getChildAt(0);
            min = Math.min(childAt2 != null ? childAt2.getLeft() - getPaddingLeft() : 0, 0);
            if (min == 0 && this.mFirstPosition != 0) {
                min -= childAt2 != null ? childAt2.getWidth() : 0;
            }
        }
        if (min != 0 && (flingRunnable = this.mFlingRunnable) != null) {
            flingRunnable.startUsingDistance(min * (-1));
        }
        return min * (-1);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scrollIntoSlots() {
        int width;
        int right;
        int width2;
        int right2;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (isOrientationVertical()) {
            scrollIntoSlotsVertical();
            return;
        }
        if (isSlotInCenter()) {
            if (getChildCount() != 0 && (view = this.mSelectedChild) != null) {
                int centerOfGallery = getCenterOfGallery() - getCenterOfView(view);
                if (centerOfGallery != 0) {
                    this.mFlingRunnable.startUsingDistance(centerOfGallery);
                    return;
                } else {
                    onFinishedMovement();
                    return;
                }
            }
            return;
        }
        if (getChildCount() == 0) {
            return;
        }
        int i3 = this.mFirstPosition;
        int i16 = 0;
        if (i3 == 0) {
            View childAt = getChildAt(0);
            if (childAt.getLeft() >= 0) {
                width = getPaddingLeft();
                right = childAt.getLeft();
                i16 = width - right;
                if (i16 == 0) {
                    this.mFlingRunnable.startUsingDistance(i16);
                    return;
                } else {
                    onFinishedMovement();
                    return;
                }
            }
            View childAt2 = getChildAt(getChildCount() - 1);
            if (childAt2.getRight() - childAt.getLeft() < getRight() - getPaddingRight()) {
                width2 = getPaddingLeft();
                right2 = this.mFirstChildOffset;
            } else {
                if (childAt2.getRight() < getRight() - getPaddingRight()) {
                    width2 = getWidth() - getPaddingRight();
                    right2 = childAt2.getRight();
                }
                if (i16 == 0) {
                }
            }
            i16 = width2 - right2;
            if (i16 == 0) {
            }
        } else {
            if (i3 + getChildCount() == this.mItemCount) {
                View childAt3 = getChildAt(getChildCount() - 1);
                if (childAt3.getRight() < getRight() - getPaddingRight()) {
                    width = getWidth() - getPaddingRight();
                    right = childAt3.getRight();
                    i16 = width - right;
                }
            }
            if (i16 == 0) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void selectionChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else if (!this.mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    public void setAnimationDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mAnimationDuration = i3;
        }
    }

    public void setCallbackDuringFling(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mShouldCallbackDuringFling = z16;
        }
    }

    public void setCallbackOnUnselectedItemClick(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mShouldCallbackOnUnselectedItemClick = z16;
        }
    }

    public void setDisableScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
        } else {
            this.mIsDisableScroll = z16;
        }
    }

    public void setFirstChildOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
        } else {
            this.mFirstChildOffset = i3;
        }
    }

    public void setFirstPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3);
        } else {
            this.mFirstPosition = i3;
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
        } else if (this.mGravity != i3) {
            this.mGravity = i3;
            requestLayout();
        }
    }

    public void setOnEndFlingListener(OnEndFlingListener onEndFlingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) onEndFlingListener);
        } else {
            this.mOnEndFlingListener = onEndFlingListener;
        }
    }

    public void setOnEndMovementListener(OnEndMovementListener onEndMovementListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) onEndMovementListener);
        } else {
            this.mOnEndMovementListener = onEndMovementListener;
        }
    }

    public void setOnSelectViewDataUpdateListener(OnSelectViewDataUpdateListener onSelectViewDataUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) onSelectViewDataUpdateListener);
        } else {
            this.mOnSelectViewDataUpdateListener = onSelectViewDataUpdateListener;
        }
    }

    public void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else {
            this.mOrientation = i3;
        }
    }

    public void setScrollBarBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, i3);
        } else {
            this.mScrollBarBottomMargin = i3;
        }
    }

    @Override // android.view.View
    public void setScrollBarSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, i3);
        } else {
            this.mScrollBarSize = i3;
        }
    }

    public void setScrollCycle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, z16);
        } else {
            this.mIsScrollCycle = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView
    public void setSelectedPositionInt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        } else {
            super.setSelectedPositionInt(i3);
            updateSelectedItemMetadata();
        }
    }

    public void setSlotInCenter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.mIsSlotCenter = z16;
        }
    }

    public void setSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mSpacing = i3;
        }
    }

    public void setUnselectedAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.mUnselectedAlpha = f16;
        }
    }

    public void setVelocityRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, Float.valueOf(f16));
            return;
        }
        this.mVelocityRatio = f16;
        if (f16 < 0.5f) {
            this.mVelocityRatio = 0.5f;
        } else if (f16 > 1.5f) {
            this.mVelocityRatio = 1.5f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldDisableScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Boolean) iPatchRedirector.redirect((short) 68, (Object) this)).booleanValue();
        }
        if (!this.mIsDisableScroll || getChildCount() < this.mItemCount) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getLeft() < getLeft()) {
            return false;
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        if (childAt2 != null && childAt2.getRight() > getRight()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        if (isPressed() && (i3 = this.mSelectedPosition) >= 0) {
            return dispatchLongPress(getChildAt(i3 - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) view)).booleanValue();
        }
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return dispatchLongPress(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void trackMotionScroll(int i3) {
        boolean z16;
        if (getChildCount() == 0) {
            return;
        }
        if (i3 < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isSlotInCenter()) {
            if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z16, i3) != i3) {
                this.mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            offsetChildrenLeftAndRight(i3);
            detachOffScreenChildren(z16);
            if (z16) {
                fillToGalleryRight();
            } else {
                fillToGalleryLeft();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            invalidate();
            return;
        }
        if (z16) {
            if (getChildAt(getChildCount() - 1) != null && r0.getRight() < getStopFlingPosition()) {
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    flingRunnable.stop(false);
                }
                i3 = 0;
            }
            offsetChildrenLeftAndRight(i3);
            detachOffScreenChildren(z16);
            if (!z16) {
                fillToGalleryRight();
            } else {
                fillToGalleryLeft();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
        if (getChildAt(0) != null && r0.getLeft() > getWidth() - getStopFlingPosition()) {
            FlingRunnable flingRunnable2 = this.mFlingRunnable;
            if (flingRunnable2 != null) {
                flingRunnable2.stop(false);
            }
            i3 = 0;
        }
        offsetChildrenLeftAndRight(i3);
        detachOffScreenChildren(z16);
        if (!z16) {
        }
        this.mRecycler.clear();
        setSelectionToCenterChild();
        awakenScrollBars();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void trackMotionScrollVertical(int i3) {
        boolean z16;
        if (getChildCount() == 0) {
            return;
        }
        if (i3 < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isSlotInCenter()) {
            if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z16, i3) != i3) {
                this.mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            offsetChildrenTopAndBottom(i3);
            detachOffScreenChildrenVertical(z16);
            if (z16) {
                fillToGalleryBottom();
            } else {
                fillToGalleryTop();
            }
            this.mRecycler.clear();
            setSelectionToCenterChildVertical();
            invalidate();
            return;
        }
        if (z16) {
            if (getChildAt(getChildCount() - 1) != null && r0.getRight() < getStopFlingPosition()) {
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    flingRunnable.stop(false);
                }
                i3 = 0;
            }
            offsetChildrenTopAndBottom(i3);
            detachOffScreenChildrenVertical(z16);
            if (!z16) {
                fillToGalleryBottom();
            } else {
                fillToGalleryTop();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
        if (getChildAt(0) != null && r0.getLeft() > getWidth() - getStopFlingPosition()) {
            FlingRunnable flingRunnable2 = this.mFlingRunnable;
            if (flingRunnable2 != null) {
                flingRunnable2.stop(false);
            }
            i3 = 0;
        }
        offsetChildrenTopAndBottom(i3);
        detachOffScreenChildrenVertical(z16);
        if (!z16) {
        }
        this.mRecycler.clear();
        setSelectionToCenterChild();
        awakenScrollBars();
        invalidate();
    }

    public VerticalGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f156471ve);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 17, (Object) this, (Object) attributeSet);
    }

    public VerticalGallery(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSpacing = 0;
        this.mAnimationDuration = 400;
        this.mFlingRunnable = new FlingRunnable();
        this.mDisableSuppressSelectionChangedRunnable = new Runnable() { // from class: com.tencent.widget.VerticalGallery.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerticalGallery.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VerticalGallery.this.mSuppressSelectionChanged = false;
                    VerticalGallery.this.selectionChanged();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.mShouldCallbackDuringFling = true;
        this.mShouldCallbackOnUnselectedItemClick = true;
        this.mIsDisableScroll = false;
        this.mScrolling = false;
        this.mFirstChildOffset = 0;
        this.mScrollBarBottomMargin = 0;
        this.mScrollBarSize = 5;
        this.mVelocityRatio = 1.0f;
        this.mIsScrollCycle = false;
        this.mIsScrollCycleTemp = true;
        this.mIsSlotCenter = false;
        this.mOrientation = 1;
        this.mOnEndFlingListener = null;
        this.mOnEndMovementListener = null;
        this.mOnSelectViewDataUpdateListener = null;
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410190r9, i3, 0);
        int i16 = obtainStyledAttributes.getInt(jj2.b.f410202s9, -1);
        if (i16 >= 0) {
            setGravity(i16);
        }
        int i17 = obtainStyledAttributes.getInt(jj2.b.f410213t9, -1);
        if (i17 > 0) {
            setAnimationDuration(i17);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(jj2.b.f410224u9, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(jj2.b.f410234v9, 0.5f));
        obtainStyledAttributes.recycle();
        setChildrenDrawingOrderEnabled(true);
        setStaticTransformationsEnabled(true);
        this.mScrollBarSize = ViewConfiguration.get(context).getScaledScrollBarSize();
        if (isOrientationVertical()) {
            this.mGravity = 1;
        } else {
            this.mGravity = 16;
        }
    }

    public int scrollGalleryItems(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Integer) iPatchRedirector.redirect((short) 63, (Object) this, i3)).intValue();
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.startUsingDistance(i3 * (-1));
        }
        return i3 * (-1);
    }
}
