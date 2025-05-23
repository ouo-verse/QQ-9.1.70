package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.doublescrollview.HippyTKDDoubleScrollView;
import com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader;
import com.tencent.mobileqq.vip.e;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDListView extends HippyListView implements HippyTKDRefreshHeader.RefreshableCallback, IDoubleScroll {
    public static final int DEFAULT_REFRESH_TYPE = 1;
    public static final int HippyNoPicModeChange = 1002;
    public static final int HippySkinChange = 1001;
    private boolean isFirstFrame;
    boolean mEnableFooter;
    boolean mEnableRefresh;
    private boolean mEnableScrollToContentOffset;
    private boolean mHasInitialListEventDone;
    private int mInitialContentOffset;
    private int mInitialListSize;
    private boolean mIsResponseToDoubleScroll;
    protected IHippyTKDRefreshHeader mQBRefreshHeader;
    HippyArray mRefreshColors;
    private boolean mScrollEnabled;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ExposureForReport extends HippyViewEvent {
        public int mEndEdgePos;
        public int mFirstVisibleRowIndex;
        public int mLastVisibleRowIndex;
        public int mScrollState;
        public int mStartEdgePos;
        public int mVelocity;
        public HippyArray mVisibleRowFrames;

        public ExposureForReport(int i3, int i16, int i17, int i18, int i19, int i26, int i27, HippyArray hippyArray) {
            super("onExposureReport");
            this.mStartEdgePos = i16;
            this.mEndEdgePos = i17;
            this.mFirstVisibleRowIndex = i18;
            this.mLastVisibleRowIndex = i19;
            this.mVelocity = i26;
            this.mScrollState = i27;
            this.mVisibleRowFrames = hippyArray;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class OuterScroll extends HippyViewEvent {
        public int mEndEdgePos;
        public int mFirstVisibleRowIndex;
        public int mLastVisibleRowIndex;
        public int mScrollState;
        public int mStartEdgePos;
        public int mVelocity;
        public HippyArray mVisibleRowFrames;

        public OuterScroll(int i3, int i16, int i17, int i18, int i19, int i26, int i27, HippyArray hippyArray) {
            super("onOuterScroll");
            this.mStartEdgePos = i16;
            this.mEndEdgePos = i17;
            this.mFirstVisibleRowIndex = i18;
            this.mLastVisibleRowIndex = i19;
            this.mVelocity = i26;
            this.mScrollState = i27;
            this.mVisibleRowFrames = hippyArray;
        }
    }

    public HippyTKDListView(Context context) {
        super(context);
        this.mIsResponseToDoubleScroll = false;
        this.mScrollEnabled = true;
        this.mHasInitialListEventDone = false;
        this.mInitialListSize = 0;
        this.mInitialContentOffset = 0;
        this.mEnableScrollToContentOffset = false;
        this.isFirstFrame = false;
        this.mEnableFooter = true;
        this.mEnableRefresh = false;
        this.mRefreshColors = null;
        if (getAdapter() instanceof HippyTKDListViewAdapter) {
            ((HippyTKDListViewAdapter) getAdapter()).setLoadingStatus(1);
            addOnListScrollListener(((HippyTKDListViewAdapter) getAdapter()).getOnListScrollListener());
        }
    }

    private HippyTKDDoubleScrollView findDoubleScrollHandleView(View view) {
        while ((view instanceof View) && view.getParent() != null && !(view.getParent() instanceof HippyRootView)) {
            if (view.getParent() instanceof HippyTKDDoubleScrollView) {
                return (HippyTKDDoubleScrollView) view.getParent();
            }
            if (!(view.getParent() instanceof View)) {
                return null;
            }
            view = (View) view.getParent();
        }
        return null;
    }

    public static boolean isKingCardMobileNetWork() {
        if (e.a() == 1) {
            return true;
        }
        return false;
    }

    private void traversalChildViewForNoPicChange(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                traversalChildViewForNoPicChange(viewGroup.getChildAt(i3));
            }
        }
    }

    private void traversalChildViewForSkinChange(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                traversalChildViewForSkinChange(viewGroup.getChildAt(i3));
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void cancelTouch() {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.onCancelTouch();
        }
        super.cancelTouch();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean changeUpOverScrollEnableOnComputeDxDy(int i3, int i16, boolean z16, Scroller scroller, boolean z17, boolean z18) {
        if (!z18 && this.mQBRefreshHeader != null && !z17 && !z16) {
            return true;
        }
        return z18;
    }

    public void checkExposureForReport(int i3, int i16) {
        if (getAdapter() != null) {
            ((HippyTKDListViewAdapter) getAdapter()).checkExposureForReport(i3, i16);
        }
    }

    protected boolean checkNeedToReport(float f16, int i3) {
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected void checkRefreshHeadOnFlingRun() {
        if (this.mQBRefreshHeader != null) {
            if (this.mOffsetY <= 0 || !this.optimizeHeaderRefresh) {
                invalidate();
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean checkShouldStopScroll() {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null && this.mEnableRefresh && !iHippyTKDRefreshHeader.onScrolled()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void completeRefresh(int i3) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.completeRefresh(i3);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.onDraw(canvas);
        }
    }

    protected boolean enableOnSrollReport() {
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected int getAutoScrollVelocity() {
        return ImmersiveUtils.dpToPx(3.0f);
    }

    protected ExposureForReport getExposureForReport(int i3, int i16) {
        if (getAdapter() instanceof HippyTKDListViewAdapter) {
            return ((HippyTKDListViewAdapter) getAdapter()).getExposureForReportInner(i3, i16);
        }
        return null;
    }

    protected OuterScroll getExposureForScroll(int i3, int i16) {
        if (getAdapter() instanceof HippyTKDListViewAdapter) {
            return ((HippyTKDListViewAdapter) getAdapter()).getExposureForReportScrollInner(i3, i16);
        }
        return null;
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public int getLayoutHeight() {
        return getHeight();
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public int getNestViewScrollY() {
        return getOffsetY();
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public int getRealHeight() {
        int height = getHeight();
        if (getAdapter() != null) {
            height = getAdapter().getListTotalHeight();
        }
        if (height < getHeight()) {
            return getHeight();
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public int getSpringBackMaxDistance() {
        return ImmersiveUtils.dpToPx(40.0f);
    }

    public HippyMap getVisibleItems() {
        return ((HippyTKDListViewAdapter) getAdapter()).getVisibleItems();
    }

    public void handleDoubleScrollResponseChange(boolean z16) {
        this.mIsResponseToDoubleScroll = z16;
        HippyTKDDoubleScrollView findDoubleScrollHandleView = findDoubleScrollHandleView(this);
        if (findDoubleScrollHandleView != null) {
            findDoubleScrollHandleView.setDoubleScrollRespondView(this, z16);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void handleInTraversal(int i3, int i16, View view) {
        if (i3 == 1001) {
            traversalChildViewForSkinChange(view);
        } else if (i3 == 1002) {
            traversalChildViewForNoPicChange(view);
        }
    }

    public void handleNoPicModeChange() {
        traversal(1002);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected void invalidateRefreshHeader() {
        if (this.mQBRefreshHeader != null) {
            if (this.mOffsetY <= 0 || !this.optimizeHeaderRefresh) {
                invalidate();
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public boolean isRefreshing() {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null && iHippyTKDRefreshHeader.isRefreshing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean isTouchStopWhenFastFling() {
        return false;
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public void notifyNestViewToFling(int i3, int i16) {
        fling(0, i16);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void onAboutToRefresh() {
        if (isKingCardMobileNetWork()) {
            setRefreshWithTargetType(3);
        } else {
            setRefreshWithTargetType(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.restoreRefresh();
        }
        boolean z16 = this.mIsResponseToDoubleScroll;
        if (z16) {
            handleDoubleScrollResponseChange(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader == null || !iHippyTKDRefreshHeader.isRefreshHeaderShowing()) {
            stopScroll();
        }
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader2 = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader2 != null) {
            iHippyTKDRefreshHeader2.stopRefresh();
        }
        if (getAdapter() != null && (getAdapter() instanceof HippyTKDListViewAdapter)) {
            ((HippyTKDListViewAdapter) getAdapter()).cancelAllPreFetchTask();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void onRefresh() {
        RecyclerViewBase.Adapter<RecyclerViewBase.ViewHolder> adapter = this.mAdapter;
        if (adapter != null) {
            adapter.startRefreshData();
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrollStateChanged(int i3, int i16) {
        super.onScrollStateChanged(i3, i16);
        if (getAdapter() != null) {
            ((HippyTKDListViewAdapter) getAdapter()).checkScrollForReport();
            ((HippyTKDListViewAdapter) getAdapter()).checkOnScrollEvent();
            checkExposureForReport(i3, i16);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void postDelayedDelegate(Runnable runnable, long j3) {
        postDelayed(runnable, j3);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void removeCallbacksDelegate(Runnable runnable) {
        removeCallbacks(runnable);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void removeOnScrollFinishListener() {
        RecyclerViewBase.ViewFlinger viewFlinger = this.mViewFlinger;
        viewFlinger.mScrollFinishListener = null;
        viewFlinger.mTargetPosition = Integer.MAX_VALUE;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollBack(int i3, RecyclerViewBase.OnScrollFinishListener onScrollFinishListener, int i16) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader;
        int i17 = 0;
        if (hasNoItem() && (iHippyTKDRefreshHeader = this.mQBRefreshHeader) != null && iHippyTKDRefreshHeader.checkRefreshState(2)) {
            this.mOffsetY = 0;
            this.mViewFlinger.postOnAnimation();
        } else {
            if (i16 != 0 && this.mRecyclerViewAdapter != null) {
                for (int i18 = 0; i18 < i16; i18++) {
                    i3 += this.mRecyclerViewAdapter.getItemHeight(i18);
                }
            }
            smoothScrollBy(0, i3, false, true);
            i17 = i3;
        }
        RecyclerViewBase.ViewFlinger viewFlinger = this.mViewFlinger;
        viewFlinger.mScrollFinishListener = onScrollFinishListener;
        viewFlinger.mTargetPosition = i17;
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public void scrollNestViewBy(int i3, int i16) {
        scrollBy(0, i16);
        int listTotalHeight = getAdapter().getListTotalHeight();
        if (i16 > 0 && getOffsetY() + i16 >= listTotalHeight - getHeight() && this.needNotifyFooter) {
            if (shouldPrebindItem() && this.mOffsetY + getHeight() != listTotalHeight) {
                return;
            }
            this.needNotifyFooter = false;
            this.checkNotifyFooterOnRelease = false;
            getAdapter().notifyLastFooterAppeared();
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.doublescrollview.IDoubleScroll
    public void scrollNestViewTo(int i3, int i16) {
        scrollBy(0, i16 - getOffsetY());
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void scrollToPosition(int i3) {
        super.scrollToPosition(i3);
        checkExposureForReport(2, 0);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToShowHeader(int i3, RecyclerViewBase.OnScrollFinishListener onScrollFinishListener) {
        int i16 = -i3;
        smoothScrollBy(0, i16 - this.mOffsetY, false, true);
        RecyclerViewBase.ViewFlinger viewFlinger = this.mViewFlinger;
        viewFlinger.mScrollFinishListener = onScrollFinishListener;
        viewFlinger.mTargetPosition = i16 - this.mOffsetY;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToShowHeaderAtOnce(int i3) {
        int i16;
        RecyclerViewBase.LayoutManager layoutManager = this.mLayout;
        RecyclerViewBase.Adapter<RecyclerViewBase.ViewHolder> adapter = this.mAdapter;
        if (adapter != null) {
            i16 = -adapter.getHeaderViewCount();
        } else {
            i16 = 0;
        }
        layoutManager.scrollToPositionWithOffset(i16, i3);
        this.mLayout.mPreventFixGap = true;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToShowHeaderSmooth(int i3) {
        smoothScrollBy(0, (-i3) - this.mOffsetY, false, true);
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToTop(RecyclerViewBase.OnScrollFinishListener onScrollFinishListener, int i3) {
        if (this.mEnableScrollToContentOffset) {
            this.mEnableScrollToContentOffset = false;
        } else {
            scrollBack(-this.mOffsetY, onScrollFinishListener, i3);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToTopAtOnce() {
        super.scrollToTopAtOnce();
        checkExposureForReport(2, 0);
    }

    public void scrollToTopRightAway() {
        scrollToPosition(0, 0);
        post(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView.2
            @Override // java.lang.Runnable
            public void run() {
                HippyTKDListView.this.dispatchLayout();
            }
        });
    }

    public void setCustomHippyRefreshView(View view) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.setCustomHippyRefreshView(view);
        }
    }

    public void setCustomRefreshColor(int i3, int i16, int i17) {
        setRefreshEnabled(true);
        this.mQBRefreshHeader.setCustomRefreshBallColor(i3, i16, i17);
    }

    public void setEnableExposureReport(boolean z16) {
        if (getAdapter() != null) {
            ((HippyTKDListViewAdapter) getAdapter()).setEnableExposureReport(z16);
        }
    }

    public void setEnableScrollForReport(boolean z16) {
        if (getAdapter() != null) {
            ((HippyTKDListViewAdapter) getAdapter()).setEnableScrollForReport(z16);
        }
    }

    public void setEnableScrollToContentOffset(boolean z16) {
        this.mEnableScrollToContentOffset = z16;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public void setInitialContentOffset(int i3) {
        this.mInitialContentOffset = i3;
        this.mEnableScrollToContentOffset = false;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public void setListData() {
        if (getAdapter() != null) {
            ((HippyTKDListViewAdapter) getAdapter()).setPreloadItemNum(getAdapter().getPreloadThresholdInItemNumber());
        }
        int i3 = this.mInitialContentOffset;
        if (i3 > 0 && this.mEnableScrollToContentOffset) {
            scrollToPosition(0, -i3);
        } else {
            this.mEnableScrollToContentOffset = false;
        }
        super.setListData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadingStatus(int i3, String str) {
        ((HippyTKDListViewAdapter) getAdapter()).setLoadingStatus(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPreloadItemNumber(int i3) {
        if (getAdapter() != null) {
            ((HippyTKDListViewAdapter) getAdapter()).setPreloadItemNum(i3);
        }
    }

    public void setRefreshColors(HippyArray hippyArray) {
        this.mRefreshColors = hippyArray;
    }

    public void setRefreshEnabled(boolean z16) {
        if (this.mEnableRefresh != z16) {
            this.mEnableRefresh = z16;
            if (z16) {
                this.mQBRefreshHeader = new HippyTKDRefreshHeader(this);
            } else {
                this.mQBRefreshHeader = null;
            }
        }
    }

    public void setRefreshPromptInfo(String str, int i3, int i16, String str2, int i17, int i18, int i19) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.setRefreshPromptInfo(str, i3, i16, str2, i17, i18, i19);
        }
    }

    public void setRefreshWithTargetType(int i3) {
        if (this.mEnableRefresh) {
            this.mQBRefreshHeader.setRefreshWithTargetType(i3);
        }
    }

    public void setScrollEnabled(boolean z16) {
        this.mScrollEnabled = z16;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public void setScrollEventThrottle(int i3) {
        RecyclerViewBase.Adapter adapter = getAdapter();
        if (adapter instanceof HippyTKDListViewAdapter) {
            ((HippyTKDListViewAdapter) adapter).setScrollEventThrottle(i3);
        }
    }

    public void setScrollForReportThrottle(int i3) {
        RecyclerViewBase.Adapter adapter = getAdapter();
        if (adapter instanceof HippyTKDListViewAdapter) {
            ((HippyTKDListViewAdapter) adapter).setScrollForReportThrottle(i3);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopOnInterceptTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader;
        if ((this.mOffsetY < 0 || getHeight() > i3) && (iHippyTKDRefreshHeader = this.mQBRefreshHeader) != null && this.mEnableRefresh && iHippyTKDRefreshHeader.isRefreshHeaderShowing() && !z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopOnTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader;
        if ((this.mOffsetY < 0 || getHeight() > i3) && (iHippyTKDRefreshHeader = this.mQBRefreshHeader) != null && this.mEnableRefresh && iHippyTKDRefreshHeader.isRefreshHeaderShowing() && !z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopReleaseGlows(boolean z16, boolean z17) {
        if (this.mQBRefreshHeader != null && this.mEnableRefresh) {
            Scroller scroller = this.mViewFlinger.getScroller();
            if (scroller.isFinished() && scroller.isFling() && getOffsetY() < HippyTKDRefreshHeader.CONTENT_HEIGHT) {
                z16 = true;
            }
            if (this.mQBRefreshHeader.onUpAction(z16)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void startLoadMore() {
        if (getAdapter() instanceof HippyTKDListViewAdapter) {
            ((HippyTKDListViewAdapter) getAdapter()).startLoadMore();
        }
    }

    public void startRefresh(int i3) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader;
        if (this.mEnableRefresh && (iHippyTKDRefreshHeader = this.mQBRefreshHeader) != null && iHippyTKDRefreshHeader.checkRefreshState(0)) {
            if (getAdapter() instanceof HippyTKDListViewAdapter) {
                ((HippyTKDListViewAdapter) getAdapter()).setLoadingStatus(2, "");
            }
            scrollToTopRightAway();
            if (i3 == 1) {
                setRefreshWithTargetType(-1);
                startRefresh(true);
            } else if (i3 == 3) {
                setRefreshWithTargetType(i3);
                startRefresh(true);
            } else {
                setRefreshWithTargetType(-1);
                startRefreshWithType(true);
            }
        }
    }

    public void startRefreshWithOnlyAnimation(boolean z16) {
        if (this.mEnableRefresh) {
            this.mQBRefreshHeader.startRefreshOnlyWithAimation(z16);
        }
    }

    public void startRefreshWithType(boolean z16) {
        if (this.mEnableRefresh) {
            this.mQBRefreshHeader.startRefreshWithType(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public HippyListAdapter createAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        return new HippyTKDListViewAdapter(recyclerView, hippyEngineContext) { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView.1
            @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
            public int getItemHeight(int i3) {
                return super.getItemHeight(i3);
            }

            @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
            public void notifyDataSetChanged() {
                super.notifyDataSetChanged();
            }
        };
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void completeRefresh(int i3, String str, int i16, int i17, int i18, int i19, String str2, boolean z16, long j3, int i26, Promise promise, int i27) {
        IHippyTKDRefreshHeader iHippyTKDRefreshHeader = this.mQBRefreshHeader;
        if (iHippyTKDRefreshHeader != null) {
            iHippyTKDRefreshHeader.completeRefresh(i3, str, i16, i17, i18, i19, str2, z16, j3, promise, i27);
        }
    }

    public void startRefresh(boolean z16) {
        if (this.mEnableRefresh) {
            this.mQBRefreshHeader.startRefresh(z16);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    protected void onInitialListReady() {
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void onShowToast() {
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    protected void sendOnScrollEvent() {
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void checkNotifyFooterAppearWithFewChild(int i3) {
    }

    public void setFastScrollerEnabled(boolean z16) {
    }

    public void setLiftEnabled(boolean z16) {
    }

    public void setPlaceHolderDrawableEnabled(boolean z16) {
    }

    public void setScrollbarEnabled(boolean z16) {
    }
}
