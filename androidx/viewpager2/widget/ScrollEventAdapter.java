package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;

    @NonNull
    private final LinearLayoutManager mLayoutManager;

    @NonNull
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;

    @NonNull
    private final ViewPager2 mViewPager;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        ScrollEventValues() {
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int i3, float f16, int i16) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i3, f16, i16);
        }
    }

    private void dispatchSelected(int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i3);
        }
    }

    private void dispatchStateChanged(int i3) {
        if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i3) {
            return;
        }
        this.mScrollState = i3;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i3);
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int i3 = this.mAdapterState;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean z16) {
        int i3;
        this.mFakeDragging = z16;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        this.mAdapterState = i3;
        int i16 = this.mTarget;
        if (i16 != -1) {
            this.mDragStartPosition = i16;
            this.mTarget = -1;
        } else if (this.mDragStartPosition == -1) {
            this.mDragStartPosition = getPosition();
        }
        dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        boolean z16;
        int top;
        float f16;
        ScrollEventValues scrollEventValues = this.mScrollValues;
        int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        scrollEventValues.mPosition = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.reset();
            return;
        }
        View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.reset();
            return;
        }
        int leftDecorationWidth = this.mLayoutManager.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.mLayoutManager.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.mLayoutManager.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.mLayoutManager.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.mLayoutManager.getOrientation() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
            if (this.mViewPager.isRtl()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
        }
        int i3 = -top;
        scrollEventValues.mOffsetPx = i3;
        if (i3 < 0) {
            if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.mOffsetPx)));
        }
        if (height == 0) {
            f16 = 0.0f;
        } else {
            f16 = i3 / height;
        }
        scrollEventValues.mOffset = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        return scrollEventValues.mPosition + scrollEventValues.mOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScrollState() {
        return this.mScrollState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDragging() {
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIdle() {
        if (this.mScrollState == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyEndFakeDrag() {
        if (isDragging() && !this.mFakeDragging) {
            return;
        }
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        if (scrollEventValues.mOffsetPx == 0) {
            int i3 = scrollEventValues.mPosition;
            if (i3 != this.mDragStartPosition) {
                dispatchSelected(i3);
            }
            dispatchStateChanged(0);
            resetState();
            return;
        }
        dispatchStateChanged(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyProgrammaticScroll(int i3, boolean z16) {
        int i16;
        if (z16) {
            i16 = 2;
        } else {
            i16 = 3;
        }
        this.mAdapterState = i16;
        boolean z17 = false;
        this.mFakeDragging = false;
        if (this.mTarget != i3) {
            z17 = true;
        }
        this.mTarget = i3;
        dispatchStateChanged(2);
        if (z17) {
            dispatchSelected(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
        boolean z16 = true;
        if ((this.mAdapterState != 1 || this.mScrollState != 1) && i3 == 1) {
            startDrag(false);
            return;
        }
        if (isInAnyDraggingState() && i3 == 2) {
            if (this.mScrollHappened) {
                dispatchStateChanged(2);
                this.mDispatchSelected = true;
                return;
            }
            return;
        }
        if (isInAnyDraggingState() && i3 == 0) {
            updateScrollEventValues();
            if (!this.mScrollHappened) {
                int i16 = this.mScrollValues.mPosition;
                if (i16 != -1) {
                    dispatchScrolled(i16, 0.0f, 0);
                }
            } else {
                ScrollEventValues scrollEventValues = this.mScrollValues;
                if (scrollEventValues.mOffsetPx == 0) {
                    int i17 = this.mDragStartPosition;
                    int i18 = scrollEventValues.mPosition;
                    if (i17 != i18) {
                        dispatchSelected(i18);
                    }
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                dispatchStateChanged(0);
                resetState();
            }
        }
        if (this.mAdapterState == 2 && i3 == 0 && this.mDataSetChangeHappened) {
            updateScrollEventValues();
            ScrollEventValues scrollEventValues2 = this.mScrollValues;
            if (scrollEventValues2.mOffsetPx == 0) {
                int i19 = this.mTarget;
                int i26 = scrollEventValues2.mPosition;
                if (i19 != i26) {
                    if (i26 == -1) {
                        i26 = 0;
                    }
                    dispatchSelected(i26);
                }
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r5 == r3.mViewPager.isRtl()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        boolean z16;
        int i17;
        boolean z17;
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected) {
            this.mDispatchSelected = false;
            if (i16 <= 0) {
                if (i16 == 0) {
                    if (i3 < 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z16 = false;
                if (z16) {
                    ScrollEventValues scrollEventValues = this.mScrollValues;
                    if (scrollEventValues.mOffsetPx != 0) {
                        i17 = scrollEventValues.mPosition + 1;
                        this.mTarget = i17;
                        if (this.mDragStartPosition != i17) {
                            dispatchSelected(i17);
                        }
                    }
                }
                i17 = this.mScrollValues.mPosition;
                this.mTarget = i17;
                if (this.mDragStartPosition != i17) {
                }
            }
            z16 = true;
            if (z16) {
            }
            i17 = this.mScrollValues.mPosition;
            this.mTarget = i17;
            if (this.mDragStartPosition != i17) {
            }
        } else if (this.mAdapterState == 0) {
            int i18 = this.mScrollValues.mPosition;
            if (i18 == -1) {
                i18 = 0;
            }
            dispatchSelected(i18);
        }
        ScrollEventValues scrollEventValues2 = this.mScrollValues;
        int i19 = scrollEventValues2.mPosition;
        if (i19 == -1) {
            i19 = 0;
        }
        dispatchScrolled(i19, scrollEventValues2.mOffset, scrollEventValues2.mOffsetPx);
        ScrollEventValues scrollEventValues3 = this.mScrollValues;
        int i26 = scrollEventValues3.mPosition;
        int i27 = this.mTarget;
        if ((i26 == i27 || i27 == -1) && scrollEventValues3.mOffsetPx == 0 && this.mScrollState != 1) {
            dispatchStateChanged(0);
            resetState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallback = onPageChangeCallback;
    }
}
