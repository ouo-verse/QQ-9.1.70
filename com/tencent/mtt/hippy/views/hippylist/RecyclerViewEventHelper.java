package com.tencent.mtt.hippy.views.hippylist;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.HippyOverPullListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListItemView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RecyclerViewEventHelper extends RecyclerView.OnScrollListener implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener, HippyOverPullListener {
    public static final String INITIAL_LIST_READY = "initialListReady";
    private int currentState;
    private boolean exposureEventEnable;
    protected final HippyRecyclerView hippyRecyclerView;
    private boolean isLastTimeReachEnd;
    private long lastScrollEventTimeStamp;
    private boolean mHasUnsentScrollEvent;
    private boolean momentumScrollBeginEventEnable;
    private boolean momentumScrollEndEventEnable;
    private HippyViewEvent onScrollDragEndedEvent;
    private HippyViewEvent onScrollDragStartedEvent;
    private HippyViewEvent onScrollEvent;
    private HippyViewEvent onScrollFlingEndedEvent;
    private HippyViewEvent onScrollFlingStartedEvent;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private int preloadItemNumber;
    private boolean scrollBeginDragEventEnable;
    private boolean scrollEndDragEventEnable;
    private int scrollEventThrottle;
    private ViewTreeObserver viewTreeObserver;
    protected boolean onScrollEventEnable = true;
    private boolean isInitialListReadyNotified = false;

    public RecyclerViewEventHelper(HippyRecyclerView hippyRecyclerView) {
        this.hippyRecyclerView = hippyRecyclerView;
        hippyRecyclerView.addOnScrollListener(this);
        hippyRecyclerView.addOnAttachStateChangeListener(this);
        hippyRecyclerView.addOnLayoutChangeListener(this);
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                RecyclerViewEventHelper.this.notifyInitialListReady();
                return true;
            }
        };
    }

    private boolean canNotifyInit() {
        if (!this.isInitialListReadyNotified && this.hippyRecyclerView.getAdapter().getItemCount() > 0 && this.hippyRecyclerView.getChildCount() > 0 && this.viewTreeObserver.isAlive()) {
            return true;
        }
        return false;
    }

    private void checkSendReachEndEvent() {
        boolean isVerticalReachEnd;
        if (HippyListUtils.isHorizontalLayout(this.hippyRecyclerView)) {
            isVerticalReachEnd = isHorizontalReachEnd();
        } else {
            isVerticalReachEnd = isVerticalReachEnd();
        }
        if (!this.isLastTimeReachEnd && isVerticalReachEnd) {
            sendOnReachedEvent();
        }
        this.isLastTimeReachEnd = isVerticalReachEnd;
    }

    private View findHippyListItemView(ViewGroup viewGroup) {
        if (viewGroup instanceof HippyListItemView) {
            return viewGroup;
        }
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof HippyListItemView) {
                return childAt;
            }
            return null;
        }
        return null;
    }

    private boolean isHorizontalReachEnd() {
        if (this.preloadItemNumber > 0) {
            RecyclerView.LayoutManager layoutManager = this.hippyRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= layoutManager.getItemCount() - this.preloadItemNumber) {
                    return true;
                }
                return false;
            }
        }
        return !this.hippyRecyclerView.canScrollHorizontally(1);
    }

    private boolean isOverPulling(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean isReleaseDrag(int i3, int i16) {
        if (i3 == 1 && (i16 == 0 || i16 == 2)) {
            return true;
        }
        return false;
    }

    private boolean isVerticalReachEnd() {
        if (this.preloadItemNumber > 0) {
            RecyclerView.LayoutManager layoutManager = this.hippyRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= layoutManager.getItemCount() - this.preloadItemNumber) {
                    return true;
                }
                return false;
            }
        }
        return !this.hippyRecyclerView.canScrollVertically(1);
    }

    private boolean isViewVisible(View view) {
        if (view == null) {
            return false;
        }
        if (!view.getGlobalVisibleRect(new Rect()) || r1.height() * r1.width() <= view.getMeasuredWidth() * view.getMeasuredHeight() * 0.1f) {
            return false;
        }
        return true;
    }

    private void observePreDraw() {
        if (!this.isInitialListReadyNotified) {
            if (this.viewTreeObserver == null) {
                this.viewTreeObserver = this.hippyRecyclerView.getViewTreeObserver();
            }
            this.viewTreeObserver.addOnPreDrawListener(this.preDrawListener);
        }
    }

    protected void checkExposureView(View view) {
        int i3;
        String str;
        if (view instanceof HippyListItemView) {
            HippyListItemView hippyListItemView = (HippyListItemView) view;
            if (isViewVisible(view)) {
                i3 = 1;
                if (hippyListItemView.getExposureState() != 1) {
                    str = HippyListItemView.EXPOSURE_EVENT_APPEAR;
                } else {
                    return;
                }
            } else {
                i3 = 2;
                if (hippyListItemView.getExposureState() != 2) {
                    str = HippyListItemView.EXPOSURE_EVENT_DISAPPEAR;
                } else {
                    return;
                }
            }
            sendExposureEvent(view, str);
            hippyListItemView.setExposureState(i3);
        }
    }

    public void checkSendExposureEvent() {
        if (!this.exposureEventEnable) {
            return;
        }
        int childCount = this.hippyRecyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            checkExposureView(findHippyListItemView((ViewGroup) this.hippyRecyclerView.getChildAt(i3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkSendOnScrollEvent() {
        if (this.onScrollEventEnable) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.lastScrollEventTimeStamp >= this.scrollEventThrottle) {
                this.lastScrollEventTimeStamp = elapsedRealtime;
                sendOnScrollEvent();
            } else {
                this.mHasUnsentScrollEvent = true;
            }
        }
    }

    public final HippyMap generateScrollEvent() {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble(HippyTKDListViewAdapter.X, PixelUtil.px2dp(this.hippyRecyclerView.getContentOffsetX()));
        hippyMap.pushDouble("y", PixelUtil.px2dp(this.hippyRecyclerView.getContentOffsetY()));
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushMap("contentOffset", hippyMap);
        return hippyMap2;
    }

    protected HippyViewEvent getOnScrollDragEndedEvent() {
        if (this.onScrollDragEndedEvent == null) {
            this.onScrollDragEndedEvent = new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_END_DRAG);
        }
        return this.onScrollDragEndedEvent;
    }

    protected HippyViewEvent getOnScrollDragStartedEvent() {
        if (this.onScrollDragStartedEvent == null) {
            this.onScrollDragStartedEvent = new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_BEGIN_DRAG);
        }
        return this.onScrollDragStartedEvent;
    }

    protected HippyViewEvent getOnScrollEvent() {
        if (this.onScrollEvent == null) {
            this.onScrollEvent = new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        }
        return this.onScrollEvent;
    }

    protected HippyViewEvent getOnScrollFlingEndedEvent() {
        if (this.onScrollFlingEndedEvent == null) {
            this.onScrollFlingEndedEvent = new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_END);
        }
        return this.onScrollFlingEndedEvent;
    }

    protected HippyViewEvent getOnScrollFlingStartedEvent() {
        if (this.onScrollFlingStartedEvent == null) {
            this.onScrollFlingStartedEvent = new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_MOMENTUM_BEGIN);
        }
        return this.onScrollFlingStartedEvent;
    }

    protected View getParentView() {
        return (View) this.hippyRecyclerView.getParent();
    }

    void notifyInitialListReady() {
        if (canNotifyInit()) {
            this.isInitialListReadyNotified = true;
            this.viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
            this.hippyRecyclerView.post(new Runnable() { // from class: com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    new HippyViewEvent(RecyclerViewEventHelper.INITIAL_LIST_READY).send(RecyclerViewEventHelper.this.getParentView(), null);
                }
            });
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        checkSendExposureEvent();
    }

    @Override // androidx.recyclerview.widget.HippyOverPullListener
    public void onOverPullStateChanged(int i3, int i16, int i17) {
        LogUtils.d("QBRecyclerViewEventHelper", "oldState:" + i3 + ",newState:" + i16);
        if (i3 == 0 && (isOverPulling(i16) || i16 == 3)) {
            getOnScrollDragStartedEvent().send(getParentView(), generateScrollEvent());
        }
        if (isOverPulling(i3) && isOverPulling(i16)) {
            sendOnScrollEvent();
        }
        if (i16 == 4 && i3 != 4) {
            getOnScrollDragEndedEvent().send(getParentView(), generateScrollEvent());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        int i16 = this.currentState;
        this.currentState = i3;
        if (this.mHasUnsentScrollEvent) {
            sendOnScrollEvent();
        }
        sendDragEvent(i3);
        sendDragEndEvent(i16, this.currentState);
        sendFlingEvent(i3);
        sendFlingEndEvent(i16, this.currentState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        if (scrollHappened(i3, i16)) {
            checkSendOnScrollEvent();
        }
        checkSendExposureEvent();
        if (scrollHappened(i3, i16)) {
            checkSendReachEndEvent();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        observePreDraw();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver;
        if (!this.isInitialListReadyNotified && (viewTreeObserver = this.viewTreeObserver) != null) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
        }
    }

    protected boolean scrollHappened(int i3, int i16) {
        if (i3 == 0 && i16 == 0) {
            return false;
        }
        return true;
    }

    protected void sendDragEndEvent(int i3, int i16) {
        if (this.scrollEndDragEventEnable && isReleaseDrag(i3, i16) && !this.hippyRecyclerView.isOverPulling()) {
            getOnScrollDragEndedEvent().send(getParentView(), generateScrollEvent());
        }
    }

    protected void sendDragEvent(int i3) {
        if (this.scrollBeginDragEventEnable && i3 == 1) {
            getOnScrollDragStartedEvent().send(getParentView(), generateScrollEvent());
        }
    }

    protected void sendExposureEvent(View view, String str) {
        if (str.equals(HippyListItemView.EXPOSURE_EVENT_APPEAR) || str.equals(HippyListItemView.EXPOSURE_EVENT_DISAPPEAR)) {
            new HippyViewEvent(str).send(view, null);
        }
    }

    protected void sendFlingEndEvent(int i3, int i16) {
        if (this.momentumScrollEndEventEnable && i3 == 2 && i16 != 2) {
            getOnScrollFlingEndedEvent().send(getParentView(), generateScrollEvent());
        }
    }

    protected void sendFlingEvent(int i3) {
        if (this.momentumScrollBeginEventEnable && i3 == 2) {
            getOnScrollFlingStartedEvent().send(getParentView(), generateScrollEvent());
        }
    }

    protected void sendOnReachedEvent() {
        new HippyViewEvent("onEndReached").send(getParentView(), null);
    }

    public void sendOnScrollEvent() {
        this.mHasUnsentScrollEvent = false;
        getOnScrollEvent().send(getParentView(), generateScrollEvent());
    }

    public void setExposureEventEnable(boolean z16) {
        this.exposureEventEnable = z16;
    }

    public void setMomentumScrollBeginEventEnable(boolean z16) {
        this.momentumScrollBeginEventEnable = z16;
    }

    public void setMomentumScrollEndEventEnable(boolean z16) {
        this.momentumScrollEndEventEnable = z16;
    }

    public void setOnScrollEventEnable(boolean z16) {
        this.onScrollEventEnable = z16;
    }

    public void setPreloadItemNumber(int i3) {
        this.preloadItemNumber = i3;
        checkSendReachEndEvent();
    }

    public void setScrollBeginDragEventEnable(boolean z16) {
        this.scrollBeginDragEventEnable = z16;
    }

    public void setScrollEndDragEventEnable(boolean z16) {
        this.scrollEndDragEventEnable = z16;
    }

    public void setScrollEventThrottle(int i3) {
        this.scrollEventThrottle = i3;
    }
}
