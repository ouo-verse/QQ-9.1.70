package com.tencent.mtt.hippy.views.scroll;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.widget.NestedScrollView;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyVerticalScrollView extends NestedScrollView implements NestedScrollingChild2, NestedScrollingParent2, HippyViewBase, HippyScrollView {
    private boolean hasCompleteFirstBatch;
    private int initialContentOffset;
    private final boolean isTvPlatform;
    private final Runnable mComputeScrollRunnable;
    private final Runnable mDoPageScrollRunnable;
    private boolean mDoneFlinging;
    private boolean mDragging;
    private boolean mFlingEnabled;
    private HippyVerticalScrollViewFocusHelper mFocusHelper;
    private NativeGestureDispatcher mGestureDispatcher;
    private boolean mHasUnsentScrollEvent;
    private final HippyOnScrollHelper mHippyOnScrollHelper;
    private long mLastScrollEventTimeStamp;
    private int mLastY;
    private boolean mMomentumScrollBeginEventEnable;
    private boolean mMomentumScrollEndEventEnable;
    private boolean mPagingEnabled;
    private boolean mScrollBeginDragEventEnable;
    private boolean mScrollEnabled;
    private boolean mScrollEndDragEventEnable;
    private boolean mScrollEventEnable;
    protected int mScrollEventThrottle;
    protected int mScrollMinOffset;
    private int startScrollY;

    public HippyVerticalScrollView(Context context) {
        super(context);
        this.mScrollEnabled = true;
        this.mScrollEventEnable = true;
        this.mScrollBeginDragEventEnable = false;
        this.mScrollEndDragEventEnable = false;
        this.mMomentumScrollBeginEventEnable = false;
        this.mMomentumScrollEndEventEnable = false;
        this.mFlingEnabled = true;
        this.mPagingEnabled = false;
        this.mScrollEventThrottle = 10;
        this.mLastScrollEventTimeStamp = -1L;
        this.mScrollMinOffset = 0;
        this.startScrollY = 0;
        this.mLastY = 0;
        this.initialContentOffset = 0;
        this.hasCompleteFirstBatch = false;
        this.mFocusHelper = null;
        this.mDoPageScrollRunnable = new Runnable() { // from class: com.tencent.mtt.hippy.views.scroll.a
            @Override // java.lang.Runnable
            public final void run() {
                HippyVerticalScrollView.this.doPageScroll();
            }
        };
        this.mComputeScrollRunnable = new Runnable() { // from class: com.tencent.mtt.hippy.views.scroll.b
            @Override // java.lang.Runnable
            public final void run() {
                HippyVerticalScrollView.this.lambda$new$0();
            }
        };
        this.mHippyOnScrollHelper = new HippyOnScrollHelper();
        setVerticalScrollBarEnabled(false);
        boolean isRunningOnTVPlatform = ((HippyInstanceContext) context).getEngineContext().isRunningOnTVPlatform();
        this.isTvPlatform = isRunningOnTVPlatform;
        if (isRunningOnTVPlatform) {
            this.mFocusHelper = new HippyVerticalScrollViewFocusHelper(this);
            setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        super.computeScroll();
    }

    private void scheduleScrollEnd() {
        postOnAnimationDelayed(new Runnable() { // from class: com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!HippyVerticalScrollView.this.mDoneFlinging) {
                    HippyVerticalScrollView.this.mDoneFlinging = true;
                    HippyVerticalScrollView.this.postOnAnimationDelayed(this, 20L);
                    return;
                }
                if (HippyVerticalScrollView.this.mHasUnsentScrollEvent) {
                    HippyVerticalScrollView.this.sendOnScrollEvent();
                }
                if (HippyVerticalScrollView.this.mMomentumScrollEndEventEnable) {
                    HippyScrollViewEventHelper.emitScrollMomentumEndEvent(HippyVerticalScrollView.this);
                }
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnScrollEvent() {
        this.mHasUnsentScrollEvent = false;
        HippyScrollViewEventHelper.emitScrollEvent(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void smoothScrollToPage() {
        int height = getHeight();
        int i3 = 0;
        View childAt = getChildAt(0);
        if (height > 0 && childAt != null) {
            int height2 = childAt.getHeight() / height;
            int i16 = this.startScrollY / height;
            int scrollY = getScrollY() - this.startScrollY;
            if (scrollY == 0) {
                return;
            }
            if (i16 != height2 - 1 || scrollY <= 0) {
                if (Math.abs(scrollY) > height / 5) {
                    if (scrollY <= 0) {
                        i16--;
                    }
                }
                if (i16 >= 0) {
                    i3 = i16;
                }
                smoothScrollTo(getScrollX(), i3 * height);
            }
            i16++;
            if (i16 >= 0) {
            }
            smoothScrollTo(getScrollX(), i3 * height);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        if (!this.isTvPlatform || !this.mFocusHelper.addFocusablesImp(arrayList, i3, i16)) {
            super.addFocusables(arrayList, i3, i16);
        }
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void callSmoothScrollTo(final int i3, int i16, int i17) {
        if (i17 > 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(getScrollY(), i16);
            ofInt.setDuration(i17);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HippyVerticalScrollView.this.scrollTo(i3, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.start();
            return;
        }
        smoothScrollTo(i3, i16);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        if (hasNestedScrollingParent(1)) {
            post(this.mComputeScrollRunnable);
        } else {
            super.computeScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doPageScroll() {
        if (this.mMomentumScrollBeginEventEnable) {
            HippyScrollViewEventHelper.emitScrollMomentumBeginEvent(this);
        }
        smoothScrollToPage();
        scheduleScrollEnd();
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int i3) {
        if (this.mFlingEnabled && !this.mPagingEnabled) {
            super.fling(i3);
            if (this.mMomentumScrollBeginEventEnable) {
                HippyScrollViewEventHelper.emitScrollMomentumBeginEvent(this);
            }
            scheduleScrollEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        if (this.isTvPlatform) {
            return this.mFocusHelper.focusSearch(view, i3);
        }
        return super.focusSearch(view, i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mComputeScrollRunnable);
        removeCallbacks(this.mDoPageScrollRunnable);
        smoothScrollBy(0, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        if ((motionEvent.getAction() & 255) == 0) {
            onStopNestedScroll(this, 1);
            this.startScrollY = getScrollY();
        }
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        if (this.mScrollBeginDragEventEnable) {
            HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
        }
        this.mDragging = true;
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        scrollTo(getScrollX(), getScrollY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        if (this.mPagingEnabled && i17 == 1) {
            return;
        }
        if (i3 != 0 || i16 != 0) {
            int i18 = iArr[0];
            int i19 = iArr[1];
            iArr[0] = 0;
            iArr[1] = 0;
            dispatchNestedPreScroll(i3, i16, iArr, null, i17);
            iArr[0] = iArr[0] + i18;
            iArr[1] = iArr[1] + i19;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        onNestedScrollInternal(view, i3, i16, i17, i18, 0, null);
    }

    void onNestedScrollInternal(@NonNull View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
        int i26;
        int i27;
        int i28;
        if (this.mPagingEnabled && i19 == 1) {
            return;
        }
        if (i18 != 0) {
            int scrollY = getScrollY();
            scrollBy(0, i18);
            int scrollY2 = getScrollY() - scrollY;
            i27 = i18 - scrollY2;
            i28 = scrollY2;
            i26 = i16 + scrollY2;
        } else {
            i26 = i16;
            i27 = i18;
            i28 = 0;
        }
        if (i17 != 0 || i27 != 0) {
            if (iArr == null) {
                dispatchNestedScroll(i3, i26, i17, i27, null, i19);
                return;
            }
            int i29 = iArr[0];
            int i36 = iArr[1] + i28;
            iArr[0] = 0;
            iArr[1] = 0;
            dispatchNestedScroll(i3, i26, i17, i27, null, i19, iArr);
            iArr[0] = iArr[0] + i29;
            iArr[1] = iArr[1] + i36;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (getVisibility() != 0) {
            return false;
        }
        if (this.isTvPlatform && this.mFocusHelper.requestFocusInDescendants(i3, rect)) {
            return true;
        }
        return super.onRequestFocusInDescendants(i3, rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (this.mHippyOnScrollHelper.onScrollChanged(i3, i16)) {
            if (this.mScrollEventEnable) {
                int abs = Math.abs(i16 - this.mLastY);
                int i19 = this.mScrollMinOffset;
                if (i19 > 0 && abs >= i19) {
                    this.mLastY = i16;
                } else {
                    if (i19 == 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (elapsedRealtime - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle) {
                            this.mLastScrollEventTimeStamp = elapsedRealtime;
                        }
                    }
                    this.mHasUnsentScrollEvent = true;
                }
                sendOnScrollEvent();
            }
            this.mDoneFlinging = false;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        if (!this.mScrollEnabled || (i3 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        super.onStopNestedScroll(view, i3);
        if (this.mPagingEnabled) {
            post(this.mDoPageScrollRunnable);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0 && !this.mDragging) {
            this.mDragging = true;
            if (this.mScrollBeginDragEventEnable) {
                HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
            }
        } else if ((action == 1 || action == 3) && this.mDragging) {
            if (this.mHasUnsentScrollEvent) {
                sendOnScrollEvent();
            }
            if (this.mScrollEndDragEventEnable) {
                HippyScrollViewEventHelper.emitScrollEndDragEvent(this);
            }
            if (this.mPagingEnabled) {
                post(this.mDoPageScrollRunnable);
            }
            this.mDragging = false;
        }
        if (!this.mDragging && this.isTvPlatform) {
            this.mFocusHelper.handleRequestFocusFromTouch(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher = this.mGestureDispatcher;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (this.isTvPlatform) {
            this.mFocusHelper.scrollToFocusChild(view2);
        }
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void scrollToInitContentOffset() {
        if (this.hasCompleteFirstBatch) {
            return;
        }
        int i3 = this.initialContentOffset;
        if (i3 > 0) {
            scrollTo(0, i3);
        }
        this.hasCompleteFirstBatch = true;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setContentOffset4Reuse(HippyMap hippyMap) {
        scrollTo(0, (int) PixelUtil.dp2px(hippyMap.getDouble("y")));
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setFlingEnabled(boolean z16) {
        this.mFlingEnabled = z16;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setInitialContentOffset(int i3) {
        this.initialContentOffset = i3;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setMomentumScrollBeginEventEnable(boolean z16) {
        this.mMomentumScrollBeginEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setMomentumScrollEndEventEnable(boolean z16) {
        this.mMomentumScrollEndEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setPagingEnabled(boolean z16) {
        this.mPagingEnabled = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollBeginDragEventEnable(boolean z16) {
        this.mScrollBeginDragEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEnabled(boolean z16) {
        this.mScrollEnabled = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEndDragEventEnable(boolean z16) {
        this.mScrollEndDragEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEventEnable(boolean z16) {
        this.mScrollEventEnable = z16;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollEventThrottle(int i3) {
        this.mScrollEventThrottle = i3;
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setScrollMinOffset(int i3) {
        this.mScrollMinOffset = (int) PixelUtil.dp2px(Math.max(5, i3));
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void showScrollIndicator(boolean z16) {
        setVerticalScrollBarEnabled(z16);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
        onNestedScrollInternal(view, i3, i16, i17, i18, i19, null);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        onNestedScrollInternal(view, i3, i16, i17, i18, i19, iArr);
    }
}
