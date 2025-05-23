package com.tencent.mtt.hippy.views.scroll;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.I18nUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.supportui.views.ScrollChecker;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyHorizontalScrollView extends HorizontalScrollView implements NestedScrollingParent2, HippyViewBase, HippyScrollView, ScrollChecker.IScrollCheck {
    private boolean hasCompleteFirstBatch;
    private int initialContentOffset;
    private final boolean isTvPlatform;
    private final NestedScrollingChildHelper mChildHelper;
    private boolean mDoneFlinging;
    private boolean mDragging;
    private boolean mFlingEnabled;
    private HippyHorizontalScrollViewFocusHelper mFocusHelper;
    private NativeGestureDispatcher mGestureDispatcher;
    private boolean mHasUnsentScrollEvent;
    private final HippyOnScrollHelper mHippyOnScrollHelper;
    private long mLastScrollEventTimeStamp;
    private int mLastX;
    private boolean mMomentumScrollBeginEventEnable;
    private boolean mMomentumScrollEndEventEnable;
    private int mNestedScrollAxesNonTouch;
    private int mNestedXOffset;
    private boolean mPagingEnabled;
    private boolean mScrollBeginDragEventEnable;
    private final int[] mScrollConsumedPair;
    private boolean mScrollEnabled;
    private boolean mScrollEndDragEventEnable;
    private boolean mScrollEventEnable;
    protected int mScrollEventThrottle;
    protected int mScrollMinOffset;
    private final int[] mScrollOffsetPair;
    private HashMap<Integer, Integer> scrollOffsetForReuse;
    private int startScrollX;

    public HippyHorizontalScrollView(Context context) {
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
        this.startScrollX = 0;
        this.mLastX = 0;
        this.initialContentOffset = 0;
        this.hasCompleteFirstBatch = false;
        this.mFocusHelper = null;
        this.scrollOffsetForReuse = new HashMap<>();
        this.mScrollConsumedPair = new int[2];
        this.mScrollOffsetPair = new int[2];
        this.mChildHelper = new NestedScrollingChildHelper(this);
        this.mHippyOnScrollHelper = new HippyOnScrollHelper();
        setHorizontalScrollBarEnabled(false);
        setNestedScrollingEnabled(true);
        boolean isRunningOnTVPlatform = ((HippyInstanceContext) context).getEngineContext().isRunningOnTVPlatform();
        this.isTvPlatform = isRunningOnTVPlatform;
        if (isRunningOnTVPlatform) {
            this.mFocusHelper = new HippyHorizontalScrollViewFocusHelper(this);
            setFocusableInTouchMode(true);
        }
        if (I18nUtil.isRTL()) {
            setRotationY(180.0f);
        }
    }

    private void scheduleScrollEnd() {
        postOnAnimationDelayed(new Runnable() { // from class: com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                if (!HippyHorizontalScrollView.this.mDoneFlinging) {
                    HippyHorizontalScrollView.this.mDoneFlinging = true;
                    HippyHorizontalScrollView.this.postOnAnimationDelayed(this, 20L);
                    return;
                }
                if (HippyHorizontalScrollView.this.mHasUnsentScrollEvent) {
                    HippyHorizontalScrollView.this.sendOnScrollEvent();
                }
                if (HippyHorizontalScrollView.this.mMomentumScrollEndEventEnable) {
                    HippyScrollViewEventHelper.emitScrollMomentumEndEvent(HippyHorizontalScrollView.this);
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
        int width = getWidth();
        int i3 = 0;
        View childAt = getChildAt(0);
        if (width > 0 && childAt != null) {
            int width2 = childAt.getWidth() / width;
            int i16 = this.startScrollX / width;
            int scrollX = getScrollX() - this.startScrollX;
            if (scrollX == 0) {
                return;
            }
            if (i16 != width2 - 1 || scrollX <= 0) {
                if (Math.abs(scrollX) > width / 5) {
                    if (scrollX <= 0) {
                        i16--;
                    }
                }
                if (i16 >= 0) {
                    i3 = i16;
                }
                smoothScrollTo(i3 * width, getScrollY());
            }
            i16++;
            if (i16 >= 0) {
            }
            smoothScrollTo(i3 * width, getScrollY());
        }
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void callSmoothScrollTo(int i3, final int i16, int i17) {
        if (i17 > 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), i3);
            ofInt.setDuration(i17);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HippyHorizontalScrollView.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), i16);
                }
            });
            ofInt.start();
            return;
        }
        smoothScrollTo(i3, i16);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (hasNestedScrollingParent() && this.mNestedXOffset != 0) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(this.mNestedXOffset, 0.0f);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(obtain);
            obtain.recycle();
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void doPageScroll() {
        if (this.mMomentumScrollBeginEventEnable) {
            HippyScrollViewEventHelper.emitScrollMomentumBeginEvent(this);
        }
        smoothScrollToPage();
        scheduleScrollEnd();
    }

    @Override // android.widget.HorizontalScrollView
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

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes() | this.mNestedScrollAxesNonTouch;
    }

    @Override // android.view.View
    public int getOverScrollMode() {
        if (!hasNestedScrollingParent()) {
            return super.getOverScrollMode();
        }
        return 2;
    }

    @Override // com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck
    public boolean horizontalCanScroll(int i3) {
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (this.mScrollEnabled && getNestedScrollAxes() == 0) {
            int action = motionEvent.getAction() & 255;
            try {
                z16 = super.onInterceptTouchEvent(motionEvent);
            } catch (Exception unused) {
                z16 = false;
            }
            if (action != 0) {
                if (action == 1 || action == 3) {
                    stopNestedScroll();
                }
            } else {
                this.startScrollX = getScrollX();
                this.mNestedXOffset = 0;
                startNestedScroll(1);
            }
            if (z16 && !this.mDragging) {
                if (this.mScrollBeginDragEventEnable) {
                    LogUtils.d("HippyHorizontalScrollView", "emitScrollBeginDragEvent");
                    HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
                }
                this.mDragging = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        scrollTo(getScrollX(), getScrollY());
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr) {
        onNestedPreScroll(view, i3, i16, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18) {
        onNestedScroll(view, i3, i16, i17, i18, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3) {
        super.onNestedScrollAccepted(view, view2, i3);
        startNestedScroll(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        this.scrollOffsetForReuse.put(Integer.valueOf(getId()), Integer.valueOf(getScrollX()));
        if (this.mHippyOnScrollHelper.onScrollChanged(i3, i16)) {
            if (this.mScrollEventEnable) {
                int abs = Math.abs(i3 - this.mLastX);
                int i19 = this.mScrollMinOffset;
                if (i19 > 0 && abs >= i19) {
                    this.mLastX = i3;
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

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
        if (this.mPagingEnabled) {
            post(new Runnable() { // from class: com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.4
                @Override // java.lang.Runnable
                public void run() {
                    HippyHorizontalScrollView.this.doPageScroll();
                }
            });
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        if (!this.mScrollEnabled) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1 && action != 3) {
                onTouchEvent = super.onTouchEvent(motionEvent);
            } else {
                if (this.mDragging) {
                    if (this.mHasUnsentScrollEvent) {
                        sendOnScrollEvent();
                    }
                    if (this.mScrollEndDragEventEnable) {
                        LogUtils.d("HippyHorizontalScrollView", "emitScrollEndDragEvent");
                        HippyScrollViewEventHelper.emitScrollEndDragEvent(this);
                    }
                    if (this.mPagingEnabled) {
                        post(new Runnable() { // from class: com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.2
                            @Override // java.lang.Runnable
                            public void run() {
                                HippyHorizontalScrollView.this.doPageScroll();
                            }
                        });
                    }
                    this.mDragging = false;
                }
                onTouchEvent = super.onTouchEvent(motionEvent);
                stopNestedScroll();
            }
        } else {
            if (!this.mDragging) {
                this.mDragging = true;
                if (this.mScrollBeginDragEventEnable) {
                    LogUtils.d("HippyHorizontalScrollView", "emitScrollBeginDragEvent");
                    HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
                }
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            if (onTouchEvent) {
                this.mNestedXOffset = 0;
                startNestedScroll(1);
            }
        }
        NativeGestureDispatcher nativeGestureDispatcher = this.mGestureDispatcher;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (I18nUtil.isRTL()) {
            view.setRotationY(180.0f);
        }
        super.onViewAdded(view);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        int i29;
        int i36;
        int min;
        if (z16 && hasNestedScrollingParent() && i3 != 0) {
            int[] iArr = this.mScrollConsumedPair;
            iArr[0] = 0;
            iArr[1] = 0;
            if (dispatchNestedPreScroll(i3, 0, iArr, this.mScrollOffsetPair)) {
                int i37 = this.mScrollConsumedPair[0];
                int i38 = i3 - i37;
                this.mNestedXOffset += this.mScrollOffsetPair[0];
                if (i38 == 0) {
                    return false;
                }
                i29 = i38;
                i36 = i37;
            } else {
                i29 = i3;
                i36 = 0;
            }
            if (i29 < 0) {
                min = Math.max(i29, -i17);
            } else {
                min = Math.min(i29, (i19 - i17) - 1);
            }
            int i39 = min;
            if (i39 != 0) {
                super.overScrollBy(i39, 0, i17, i18, i19, i26, i27, i28, true);
                i36 += i39;
                i29 -= i39;
            }
            if (i29 != 0) {
                dispatchNestedScroll(i36, 0, i29, 0, this.mScrollOffsetPair);
                this.mNestedXOffset += this.mScrollOffsetPair[0];
            }
            return false;
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.isTvPlatform) {
            this.mFocusHelper.scrollToFocusChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void scrollToInitContentOffset() {
        if (this.hasCompleteFirstBatch) {
            return;
        }
        int i3 = this.initialContentOffset;
        if (i3 > 0) {
            scrollTo(i3, 0);
        }
        this.hasCompleteFirstBatch = true;
    }

    public void setContentOffset4Reuse() {
        Integer num = this.scrollOffsetForReuse.get(Integer.valueOf(getId()));
        if (num != null) {
            scrollTo(num.intValue(), 0);
        } else {
            scrollTo(0, 0);
        }
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
        setHorizontalScrollBarEnabled(z16);
    }

    @Override // com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck
    public boolean verticalCanScroll(int i3) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        if (this.mPagingEnabled && i17 == 1) {
            return;
        }
        if (i3 == 0 && i16 == 0) {
            return;
        }
        int i18 = iArr[0];
        int i19 = iArr[1];
        iArr[0] = 0;
        iArr[1] = 0;
        if (i17 == 0) {
            dispatchNestedPreScroll(i3, i16, iArr, null);
        } else {
            this.mChildHelper.dispatchNestedPreScroll(i3, i16, iArr, null, i17);
        }
        iArr[0] = iArr[0] + i18;
        iArr[1] = iArr[1] + i19;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
        if (this.mPagingEnabled && i19 == 1) {
            return;
        }
        if (i17 != 0) {
            int scrollX = getScrollX();
            scrollBy(i17, 0);
            int scrollX2 = getScrollX() - scrollX;
            i3 += scrollX2;
            i17 -= scrollX2;
        }
        int i26 = i3;
        int i27 = i17;
        if (i27 == 0 && i18 == 0) {
            return;
        }
        if (i19 == 0) {
            dispatchNestedScroll(i26, i16, i27, i18, null);
        } else {
            this.mChildHelper.dispatchNestedScroll(i26, i16, i27, i18, null, i19);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        if (i16 == 0) {
            super.onNestedScrollAccepted(view, view2, i3);
            startNestedScroll(1);
        } else {
            this.mNestedScrollAxesNonTouch = i3;
            this.mChildHelper.startNestedScroll(1, i16);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        return this.mScrollEnabled && (i3 & 1) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        } else {
            this.mChildHelper.stopNestedScroll(i3);
            this.mNestedScrollAxesNonTouch = 0;
        }
    }

    @Override // com.tencent.mtt.hippy.views.scroll.HippyScrollView
    public void setContentOffset4Reuse(HippyMap hippyMap) {
        scrollTo((int) PixelUtil.dp2px(hippyMap.getDouble(HippyTKDListViewAdapter.X)), 0);
    }
}
