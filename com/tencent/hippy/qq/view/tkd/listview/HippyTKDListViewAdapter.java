package com.tencent.hippy.qq.view.tkd.listview;

import android.util.Log;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDListViewAdapter extends HippyListAdapter {
    public static final String END_EDGE_POS = "endEdgePos";
    public static final String FIRST_VISIBLE_ROW_INDEX = "firstVisibleRowIndex";
    public static final String HEIGHT = "height";
    public static final String LAST_VISIBLE_ROW_INDEX = "lastVisibleRowIndex";
    public static final String SCROLL_STATE = "scrollState";
    public static final String START_EDGE_POS = "startEdgePos";
    public static final String TAG = "HippyTKDListViewAdapter";
    public static final String VISIBLE_ROW_FRAMES = "visibleRowFrames";
    public static final String WIDTH = "width";
    public static final String X = "x";
    public static final String Y = "y";
    private final int[] fixedEndEdge;
    private IContainerPositionGetter mContainerPositionGetter;
    private boolean mEnableExposureReport;
    private boolean mEnableScrollForReport;
    private boolean mHasExposureReport;
    private boolean mHasLoadMore;
    private boolean mHasOnFooterAppeared;
    private boolean mHasOnRefresh;
    private boolean mHasOnScroll;
    private boolean mHasOnScrollForReport;
    private boolean mHasPreload;
    private long mLastScrollEventTimeStamp;
    private long mLastScrollForReportTimeStamp;
    private OnFooterAppearedEvent mOnFooterAppearedEvent;
    private OnScrollEvent mOnListScrollEvent;
    private RecyclerView.OnListScrollListener mOnListScrollListener;
    private boolean mOnPreloadCalled;
    private OnRefreshEvent mOnRefreshEvent;
    private OnScrollForReportEvent mOnScrollForReportEvent;
    private int mPreloadDistanceWithItemNumber;
    private int mPreloadItemNum;
    int mScrollEventThrottle;
    int mScrollForReportThrottle;
    private boolean mShouldUpdatePreloadDistance;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ContainerPosition {
        public int marginTop;
        public int offset;
        public int top;

        public String toString() {
            return "ContainerPosition{offset=" + this.offset + ", top=" + this.top + ", marginTop=" + this.marginTop + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IContainerPositionGetter {
        ContainerPosition getContainerPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class OnFooterAppearedEvent extends HippyViewEvent {
        public OnFooterAppearedEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class OnRefreshEvent extends HippyViewEvent {
        public OnRefreshEvent(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class OnScrollEvent extends HippyViewEvent {
        public OnScrollEvent() {
            super(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class OnScrollForReportEvent extends HippyViewEvent {
        public OnScrollForReportEvent(String str) {
            super(str);
        }
    }

    public HippyTKDListViewAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        super(recyclerView, hippyEngineContext);
        this.mScrollEventThrottle = 200;
        this.mScrollForReportThrottle = 200;
        this.mLastScrollEventTimeStamp = -1L;
        this.mLastScrollForReportTimeStamp = -1L;
        this.fixedEndEdge = new int[2];
        this.mHasOnScrollForReport = false;
        this.mHasExposureReport = false;
        this.mHasOnScroll = false;
        this.mHasOnRefresh = false;
        this.mHasOnFooterAppeared = false;
        this.mHasPreload = false;
        this.mHasLoadMore = false;
        this.mDefaultLoadingView = new HippyTKDDefaultFooter(recyclerView.getContext());
    }

    private int[] fixEndEdgeAndLastVisiblePosition(int i3, int i16) {
        int fixedLastPositionYByDp = getFixedLastPositionYByDp(i3);
        if (fixedLastPositionYByDp != i3) {
            i16 = getFixedLastPosition(i16, fixedLastPositionYByDp);
        }
        int[] iArr = this.fixedEndEdge;
        iArr[0] = fixedLastPositionYByDp;
        iArr[1] = i16;
        return iArr;
    }

    private int getFixedLastPosition(int i3, int i16) {
        int dp2px = (int) PixelUtil.dp2px(i16);
        int i17 = 0;
        for (int i18 = 0; i18 <= i3; i18++) {
            i17 += getItemHeight(i18);
            if (i17 > 0 && i17 > dp2px) {
                return i18;
            }
        }
        return i3;
    }

    private int getFixedLastPositionYByDp(int i3) {
        ContainerPosition containerPosition;
        IContainerPositionGetter iContainerPositionGetter = this.mContainerPositionGetter;
        if (iContainerPositionGetter != null && (containerPosition = iContainerPositionGetter.getContainerPosition()) != null) {
            return (int) PixelUtil.px2dp(PixelUtil.dp2px(i3) - ((containerPosition.top - containerPosition.marginTop) + containerPosition.offset));
        }
        return i3;
    }

    private OnFooterAppearedEvent getOnFooterAppearedEvent() {
        if (this.mOnFooterAppearedEvent == null) {
            this.mOnFooterAppearedEvent = new OnFooterAppearedEvent("onFooterAppeared");
        }
        return this.mOnFooterAppearedEvent;
    }

    private OnRefreshEvent getOnRefreshEvent() {
        if (this.mOnRefreshEvent == null) {
            this.mOnRefreshEvent = new OnRefreshEvent(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
        }
        return this.mOnRefreshEvent;
    }

    private OnScrollEvent getOnScrollEvent() {
        if (this.mOnListScrollEvent == null) {
            this.mOnListScrollEvent = new OnScrollEvent();
        }
        return this.mOnListScrollEvent;
    }

    private OnScrollForReportEvent getOnScrollForReportEvent() {
        if (this.mOnScrollForReportEvent == null) {
            this.mOnScrollForReportEvent = new OnScrollForReportEvent("onScrollForReport");
        }
        return this.mOnScrollForReportEvent;
    }

    private void preLoadImageRecursive(RenderNode renderNode) {
        if (renderNode != null) {
            if (renderNode.getClassName().equals("Image")) {
                HippyMap props = renderNode.getProps();
                props.getString("src");
                props.getBoolean(HippyTKDImageView.EXTRA_REQUEST_GIF_ENABLED);
                renderNode.getWidth();
                renderNode.getHeight();
            }
            for (int i3 = 0; i3 < renderNode.getChildCount(); i3++) {
                preLoadImageRecursive(renderNode.getChildAt(i3));
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int calcPreloadThresholdWithItemNumber() {
        if (this.mShouldUpdatePreloadDistance) {
            int itemCount = getItemCount() - this.mPreloadItemNum;
            if (itemCount < 0) {
                itemCount = 0;
            }
            this.mPreloadDistanceWithItemNumber = 0;
            for (int itemCount2 = getItemCount() - 1; itemCount2 >= itemCount; itemCount2--) {
                this.mPreloadDistanceWithItemNumber += getItemHeight(itemCount2);
            }
            this.mShouldUpdatePreloadDistance = false;
        }
        return this.mPreloadDistanceWithItemNumber;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkExposureForReport(int i3, int i16) {
        HippyTKDListView.ExposureForReport exposureForReportInner;
        if (this.mEnableExposureReport && (exposureForReportInner = getExposureForReportInner(i3, i16)) != null && checkNeedToReport(exposureForReportInner.mVelocity, i16)) {
            HippyMap hippyMap = new HippyMap();
            int[] fixEndEdgeAndLastVisiblePosition = fixEndEdgeAndLastVisiblePosition(exposureForReportInner.mEndEdgePos, exposureForReportInner.mLastVisibleRowIndex);
            hippyMap.pushInt(START_EDGE_POS, exposureForReportInner.mStartEdgePos);
            hippyMap.pushInt(END_EDGE_POS, fixEndEdgeAndLastVisiblePosition[0]);
            hippyMap.pushInt(FIRST_VISIBLE_ROW_INDEX, exposureForReportInner.mFirstVisibleRowIndex);
            hippyMap.pushInt(LAST_VISIBLE_ROW_INDEX, fixEndEdgeAndLastVisiblePosition[1]);
            hippyMap.pushInt(SCROLL_STATE, exposureForReportInner.mScrollState);
            hippyMap.pushArray(VISIBLE_ROW_FRAMES, exposureForReportInner.mVisibleRowFrames);
            exposureForReportInner.send(this.mParentRecyclerView, hippyMap);
        }
    }

    protected boolean checkNeedToReport(float f16, int i3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkOnScrollEvent() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {
            return;
        }
        this.mLastScrollEventTimeStamp = currentTimeMillis;
        HippyMap onScrollDataMap = getOnScrollDataMap();
        if (onScrollDataMap != null) {
            this.mHasOnScroll = true;
            getOnScrollEvent().send(this.mParentRecyclerView, onScrollDataMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkScrollForReport() {
        if (!this.mEnableScrollForReport) {
            return;
        }
        int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
        int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
        int findFirstVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        if (findLastVisibleItemPosition >= 1 && (this.mParentRecyclerView.getLayoutManager().findViewByPosition(findLastVisibleItemPosition) instanceof HippyTKDDefaultFooter)) {
            findLastVisibleItemPosition--;
        }
        float abs = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
        int scrollState = this.mParentRecyclerView.getScrollState();
        HippyArray hippyArray = new HippyArray();
        int i3 = 0;
        for (int i16 = 0; i16 < findFirstVisibleItemPosition; i16++) {
            i3 = i3 + getItemHeight(i16) + getItemMaigin(1, i16) + getItemMaigin(3, i16);
        }
        for (int i17 = findFirstVisibleItemPosition; i17 <= findLastVisibleItemPosition; i17++) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(X, 0);
            hippyMap.pushInt("y", (int) PixelUtil.px2dp(i3));
            i3 += getItemHeight(i17);
            hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i17)));
            hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i17)));
            hippyArray.pushMap(hippyMap);
        }
        HippyMap hippyMap2 = new HippyMap();
        if (scrollState == 0 && checkNeedToReport(0.0f, scrollState)) {
            this.mHasOnScrollForReport = true;
            int[] fixEndEdgeAndLastVisiblePosition = fixEndEdgeAndLastVisiblePosition(px2dp2, findLastVisibleItemPosition);
            hippyMap2.pushInt(START_EDGE_POS, px2dp);
            hippyMap2.pushInt(END_EDGE_POS, fixEndEdgeAndLastVisiblePosition[0]);
            hippyMap2.pushInt(FIRST_VISIBLE_ROW_INDEX, findFirstVisibleItemPosition);
            hippyMap2.pushInt(LAST_VISIBLE_ROW_INDEX, fixEndEdgeAndLastVisiblePosition[1]);
            hippyMap2.pushInt(SCROLL_STATE, scrollState);
            hippyMap2.pushArray(VISIBLE_ROW_FRAMES, hippyArray);
            getOnScrollForReportEvent().send(this.mParentRecyclerView, hippyMap2);
            return;
        }
        if (abs < this.mParentRecyclerView.getHeight() * 2 && checkNeedToReport(abs, scrollState)) {
            this.mHasOnScrollForReport = true;
            int[] fixEndEdgeAndLastVisiblePosition2 = fixEndEdgeAndLastVisiblePosition(px2dp2, findLastVisibleItemPosition);
            hippyMap2.pushInt(START_EDGE_POS, px2dp);
            hippyMap2.pushInt(END_EDGE_POS, fixEndEdgeAndLastVisiblePosition2[0]);
            hippyMap2.pushInt(FIRST_VISIBLE_ROW_INDEX, findFirstVisibleItemPosition);
            hippyMap2.pushInt(LAST_VISIBLE_ROW_INDEX, fixEndEdgeAndLastVisiblePosition2[1]);
            hippyMap2.pushInt(SCROLL_STATE, scrollState);
            hippyMap2.pushArray(VISIBLE_ROW_FRAMES, hippyArray);
            getOnScrollForReportEvent().send(this.mParentRecyclerView, hippyMap2);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getDefaultFooterHeight() {
        return ImmersiveUtils.dpToPx(36.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyTKDListView.ExposureForReport getExposureForReportInner(int i3, int i16) {
        if (!this.mEnableExposureReport) {
            return null;
        }
        this.mHasExposureReport = true;
        int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
        int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
        int findFirstVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        if (findLastVisibleItemPosition >= 1 && (this.mParentRecyclerView.getLayoutManager().findViewByPosition(findLastVisibleItemPosition) instanceof HippyTKDDefaultFooter)) {
            findLastVisibleItemPosition--;
        }
        int i17 = findLastVisibleItemPosition;
        HippyArray hippyArray = new HippyArray();
        int i18 = 0;
        for (int i19 = 0; i19 < findFirstVisibleItemPosition; i19++) {
            i18 = i18 + getItemHeight(i19) + getItemMaigin(1, i19) + getItemMaigin(3, i19);
        }
        for (int i26 = findFirstVisibleItemPosition; i26 <= i17; i26++) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(X, 0);
            hippyMap.pushInt("y", (int) PixelUtil.px2dp(i18));
            i18 += getItemHeight(i26);
            hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i26)));
            hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i26)));
            hippyArray.pushMap(hippyMap);
        }
        return new HippyTKDListView.ExposureForReport(this.mParentRecyclerView.getId(), px2dp, px2dp2, findFirstVisibleItemPosition, i17, (int) Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity()), i16, hippyArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyTKDListView.OuterScroll getExposureForReportScrollInner(int i3, int i16) {
        if (!this.mEnableExposureReport) {
            return null;
        }
        int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
        int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
        int findFirstVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        if (findLastVisibleItemPosition >= 1 && (this.mParentRecyclerView.getLayoutManager().findViewByPosition(findLastVisibleItemPosition) instanceof HippyTKDDefaultFooter)) {
            findLastVisibleItemPosition--;
        }
        int i17 = findLastVisibleItemPosition;
        HippyArray hippyArray = new HippyArray();
        int i18 = 0;
        for (int i19 = 0; i19 < findFirstVisibleItemPosition; i19++) {
            i18 = i18 + getItemHeight(i19) + getItemMaigin(1, i19) + getItemMaigin(3, i19);
        }
        for (int i26 = findFirstVisibleItemPosition; i26 <= i17; i26++) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(X, 0);
            hippyMap.pushInt("y", (int) PixelUtil.px2dp(i18));
            int itemWidth = getItemWidth(i26);
            int itemHeight = getItemHeight(i26);
            i18 += itemHeight;
            hippyMap.pushInt("width", (int) PixelUtil.px2dp(itemWidth));
            hippyMap.pushInt("height", (int) PixelUtil.px2dp(itemHeight));
            hippyArray.pushMap(hippyMap);
        }
        return new HippyTKDListView.OuterScroll(this.mParentRecyclerView.getId(), px2dp, px2dp2, findFirstVisibleItemPosition, i17, (int) Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity()), i16, hippyArray);
    }

    public RecyclerView.OnListScrollListener getOnListScrollListener() {
        if (this.mOnListScrollListener == null) {
            this.mOnListScrollListener = new RecyclerView.OnListScrollListener() { // from class: com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.1
                @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                public void onScroll(int i3, int i16) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - HippyTKDListViewAdapter.this.mLastScrollForReportTimeStamp;
                    HippyTKDListViewAdapter hippyTKDListViewAdapter = HippyTKDListViewAdapter.this;
                    if (j3 >= hippyTKDListViewAdapter.mScrollForReportThrottle) {
                        hippyTKDListViewAdapter.mLastScrollForReportTimeStamp = currentTimeMillis;
                        HippyTKDListViewAdapter.this.checkScrollForReport();
                    }
                    HippyTKDListViewAdapter.this.checkOnScrollEvent();
                }

                @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                public void onScrollEnd() {
                    HippyTKDListViewAdapter.this.checkScrollForReport();
                    HippyTKDListViewAdapter.this.checkOnScrollEvent();
                }

                @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                public void onDragEnd() {
                }

                @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                public void onStartDrag() {
                }

                @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                public void onStartFling() {
                }
            };
        }
        return this.mOnListScrollListener;
    }

    protected HippyMap getOnScrollDataMap() {
        if (this.mParentRecyclerView == null) {
            return null;
        }
        int px2dp = (int) PixelUtil.px2dp(r0.mOffsetY);
        int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
        int findFirstVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((LinearLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
        if (findLastVisibleItemPosition >= 1 && (this.mParentRecyclerView.getLayoutManager().findViewByPosition(findLastVisibleItemPosition) instanceof HippyTKDDefaultFooter)) {
            findLastVisibleItemPosition--;
        }
        int scrollState = this.mParentRecyclerView.getScrollState();
        HippyArray hippyArray = new HippyArray();
        int i3 = 0;
        for (int i16 = 0; i16 < findFirstVisibleItemPosition; i16++) {
            i3 = i3 + getItemHeight(i16) + getItemMaigin(1, i16) + getItemMaigin(3, i16);
        }
        for (int i17 = findFirstVisibleItemPosition; i17 <= findLastVisibleItemPosition; i17++) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(X, 0);
            hippyMap.pushInt("y", (int) PixelUtil.px2dp(i3));
            i3 += getItemHeight(i17);
            hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i17)));
            hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i17)));
            hippyArray.pushMap(hippyMap);
        }
        HippyMap hippyMap2 = new HippyMap();
        int[] fixEndEdgeAndLastVisiblePosition = fixEndEdgeAndLastVisiblePosition(px2dp2, findLastVisibleItemPosition);
        hippyMap2.pushInt(START_EDGE_POS, px2dp);
        hippyMap2.pushInt(END_EDGE_POS, fixEndEdgeAndLastVisiblePosition[0]);
        hippyMap2.pushInt(FIRST_VISIBLE_ROW_INDEX, findFirstVisibleItemPosition);
        hippyMap2.pushInt(LAST_VISIBLE_ROW_INDEX, fixEndEdgeAndLastVisiblePosition[1]);
        hippyMap2.pushInt(SCROLL_STATE, scrollState);
        hippyMap2.pushArray(VISIBLE_ROW_FRAMES, hippyArray);
        QLog.d(TAG, 4, "firstPosition=" + findFirstVisibleItemPosition + ", lastPosition=" + fixEndEdgeAndLastVisiblePosition[1]);
        return hippyMap2;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getPreloadThresholdInItemNumber() {
        return this.mPreloadItemNum;
    }

    public HippyMap getVisibleItems() {
        return getOnScrollDataMap();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyDataSetChanged() {
        Log.d("HippyQBListViewAdapter", "notifyDataSetChanged ");
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyEndReached() {
        if (!this.mOnPreloadCalled && getItemCount() > 0) {
            super.notifyEndReached();
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyLastFooterAppeared() {
        super.notifyLastFooterAppeared();
        int i3 = this.mLoadingStatus;
        if (i3 != 1 && i3 != 100 && i3 != 6) {
            setLoadingStatus(1);
        }
        this.mHasOnFooterAppeared = true;
        getOnFooterAppearedEvent().send(this.mParentRecyclerView, null);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    public void onBindContentView(ContentHolder contentHolder, int i3, int i16) {
        int i17;
        super.onBindContentView(contentHolder, i3, i16);
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && (i17 = i3 + 1) < renderNode.getChildCount()) {
            preLoadImageRecursive(renderNode.getChildAt(i17));
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    protected void onClickBackward() {
        RecyclerView recyclerView = this.mParentRecyclerView;
        if (recyclerView instanceof HippyTKDListView) {
            ((HippyTKDListView) recyclerView).scrollToTopRightAway();
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    protected void onClickRetry() {
        startLoadMore();
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onPreload() {
        this.mHasPreload = true;
        this.mOnPreloadCalled = true;
        getOnEndReachedEvent().send(this.mParentRecyclerView, null);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onSuddenStop() {
        checkScrollForReport();
        checkOnScrollEvent();
    }

    public void setContainerPositionGetter(IContainerPositionGetter iContainerPositionGetter) {
        this.mContainerPositionGetter = iContainerPositionGetter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnableExposureReport(boolean z16) {
        this.mEnableExposureReport = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnableScrollForReport(boolean z16) {
        this.mEnableScrollForReport = z16;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    public void setLoadingStatus(int i3) {
        if (((HippyTKDListView) this.mParentRecyclerView).mEnableFooter) {
            super.setLoadingStatus(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPreloadItemNum(int i3) {
        this.mPreloadItemNum = i3;
        this.mShouldUpdatePreloadDistance = true;
    }

    public void setScrollEventThrottle(int i3) {
        this.mScrollEventThrottle = i3;
    }

    public void setScrollForReportThrottle(int i3) {
        this.mScrollForReportThrottle = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoadMore() {
        this.mHasLoadMore = true;
        getOnEndReachedEvent().send(this.mParentRecyclerView, null);
        setLoadingStatus(1);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void startRefreshData() {
        this.mHasOnRefresh = true;
        getOnRefreshEvent().send(this.mParentRecyclerView, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoadingStatus(int i3, String str) {
        if (((HippyTKDListView) this.mParentRecyclerView).mEnableFooter) {
            if (i3 != 1) {
                if (i3 != 100) {
                    setLoadingStatus(i3);
                    View view = this.mDefaultLoadingView;
                    if (view != null && (view instanceof HippyTKDDefaultFooter)) {
                        ((HippyTKDDefaultFooter) view).setText(str);
                    }
                } else {
                    View view2 = this.mDefaultLoadingView;
                    if (view2 != null && (view2 instanceof HippyTKDDefaultFooter)) {
                        ((HippyTKDDefaultFooter) view2).setLoadingStatus(100, str);
                    }
                    setLoadingStatus(i3);
                }
                View view3 = this.mDefaultLoadingView;
                if (view3 != null) {
                    view3.measure(View.MeasureSpec.makeMeasureSpec(view3.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getHeight(), 1073741824));
                    View view4 = this.mDefaultLoadingView;
                    view4.layout(view4.getLeft(), this.mDefaultLoadingView.getTop(), this.mDefaultLoadingView.getRight(), this.mDefaultLoadingView.getBottom());
                    this.mDefaultLoadingView.invalidate();
                }
                this.mOnPreloadCalled = false;
                return;
            }
            setLoadingStatus(i3);
        }
    }

    public void cancelAllPreFetchTask() {
    }
}
