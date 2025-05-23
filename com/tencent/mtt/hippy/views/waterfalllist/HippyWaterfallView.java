package com.tencent.mtt.hippy.views.waterfalllist;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.uimanager.j;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.refresh.FooterUtil;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.IFooterContainer;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallItemRenderNode;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.Scroller;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallView extends HippyListView implements IFooterContainer {
    public static final int DEFAULT_REFRESH_TYPE = 1;
    public static final int HIPPY_SKIN_CHANGE = 1001;
    static final String TAG = "HippyWaterfallView";
    HippyWaterfallAdapter mAdapter;
    private Runnable mDispatchLayout;
    boolean mEnableFooter;
    boolean mEnableRefresh;
    private WaterfallEndChecker mEndChecker;
    private int mFooterState;
    private NativeGestureDispatcher mGestureDispatcher;
    private boolean mHasCompeleteRefresh;
    private boolean mHasLoadMore;
    private boolean mHasRemovePreDraw;
    private boolean mHasScrollToContentOffset;
    private boolean mHasScrollToIndex;
    private boolean mHasStartRefresh;
    private HippyEngineContext mHippyContext;
    private OnInitialListReadyEvent mOnInitialListReadyEvent;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    HippyArray mRefreshColors;
    private ViewTreeObserver mViewTreeObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView$1 */
    /* loaded from: classes20.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HippyWaterfallView.this.dispatchLayout();
            int itemCount = HippyWaterfallView.this.mLayout.getItemCount();
            boolean z16 = true;
            if (itemCount <= 1 && (itemCount != 1 || (HippyWaterfallView.this.mAdapter.getItemNode(0) instanceof i))) {
                z16 = false;
            }
            if (z16) {
                HippyWaterfallView.this.mEndChecker.reset();
                HippyWaterfallView.this.mEndChecker.check(HippyWaterfallView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView$2 */
    /* loaded from: classes20.dex */
    public class AnonymousClass2 implements ViewTreeObserver.OnPreDrawListener {

        /* compiled from: P */
        /* renamed from: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView$2$1 */
        /* loaded from: classes20.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                HippyWaterfallView.this.getOnInitialListReadyEvent().send(HippyWaterfallView.this, null);
            }
        }

        AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (HippyWaterfallView.this.mAdapter.getItemCount() > 0 && HippyWaterfallView.this.getChildCount() > 0) {
                HippyWaterfallView.this.mViewTreeObserver.removeOnPreDrawListener(this);
                HippyWaterfallView.this.mHasRemovePreDraw = true;
                HippyWaterfallView.this.post(new Runnable() { // from class: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        HippyWaterfallView.this.getOnInitialListReadyEvent().send(HippyWaterfallView.this, null);
                    }
                });
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
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
    /* loaded from: classes20.dex */
    public class HippyWaterfallAdapter extends RecyclerAdapter implements HippyWaterfallItemRenderNode.IRecycleItemTypeChange {
        private boolean mEnableExposureReport;
        private boolean mEnableScrollForReport;
        private HippyMap mExposureReportResultMap;
        private boolean mHasExposureReport;
        private boolean mHasOnFooterAppeared;
        private boolean mHasOnRefresh;
        private boolean mHasOnScrollForReport;
        private boolean mHasPreload;
        private boolean mHasSetLoadingStatus;
        ArrayList<RecyclerViewBase.ViewHolder> mListViewHolder;
        private HippyWaterfallEvent mOnFooterAppearedEvent;
        private RecyclerView.OnListScrollListener mOnListScrollListener;
        private boolean mOnPreloadCalled;
        private HippyWaterfallEvent mOnRefreshEvent;
        private HippyWaterfallEvent mOnScrollForReportEvent;
        private int mPreloadDistanceWithItemNumber;
        private int mPreloadItemNum;
        private HippyMap mScrollReportResultMap;
        private boolean mShouldUpdatePreloadDistance;

        public HippyWaterfallAdapter(RecyclerView recyclerView) {
            super(recyclerView);
            this.mHasOnScrollForReport = false;
            this.mHasExposureReport = false;
            this.mHasOnRefresh = false;
            this.mHasOnFooterAppeared = false;
            this.mHasPreload = false;
            this.mHasSetLoadingStatus = false;
            setLoadingStatus(1);
        }

        private void checkHolderType(int i3, int i16, HippyWaterfallItemRenderNode hippyWaterfallItemRenderNode) {
            if (doCheckHolderTypeOnScreen(i3, i16, hippyWaterfallItemRenderNode)) {
                return;
            }
            int size = ((RecyclerViewBase) HippyWaterfallView.this).mRecycler.mAttachedScrap.size();
            for (int i17 = 0; i17 < size; i17++) {
                RecyclerViewBase.ViewHolder viewHolder = ((RecyclerViewBase) HippyWaterfallView.this).mRecycler.mAttachedScrap.get(i17);
                if (viewHolder.getItemViewType() == i3) {
                    ContentHolder contentHolder = viewHolder.mContentHolder;
                    if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == hippyWaterfallItemRenderNode) {
                        viewHolder.setItemViewType(i16);
                        return;
                    }
                }
            }
            int size2 = ((RecyclerViewBase) HippyWaterfallView.this).mRecycler.mCachedViews.size();
            for (int i18 = 0; i18 < size2; i18++) {
                RecyclerViewBase.ViewHolder viewHolder2 = ((RecyclerViewBase) HippyWaterfallView.this).mRecycler.mCachedViews.get(i18);
                if (viewHolder2.getItemViewType() == i3) {
                    ContentHolder contentHolder2 = viewHolder2.mContentHolder;
                    if ((contentHolder2 instanceof NodeHolder) && ((NodeHolder) contentHolder2).mBindNode == hippyWaterfallItemRenderNode) {
                        viewHolder2.setItemViewType(i16);
                        return;
                    }
                }
            }
            doHeadToTheSharedPool(i3, i16, hippyWaterfallItemRenderNode);
        }

        private boolean doCheckHolderTypeOnScreen(int i3, int i16, HippyWaterfallItemRenderNode hippyWaterfallItemRenderNode) {
            int childCount = this.mParentRecyclerView.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                RecyclerView recyclerView = this.mParentRecyclerView;
                RecyclerViewBase.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i17));
                if (childViewHolder.getItemViewType() == i3) {
                    ContentHolder contentHolder = childViewHolder.mContentHolder;
                    if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == hippyWaterfallItemRenderNode) {
                        childViewHolder.setItemViewType(i16);
                        return true;
                    }
                }
            }
            return false;
        }

        private void doHeadToTheSharedPool(int i3, int i16, HippyWaterfallItemRenderNode hippyWaterfallItemRenderNode) {
            RecyclerViewBase.ViewHolderArrayList viewHolderArrayList;
            if (((RecyclerViewBase) HippyWaterfallView.this).mRecycler.getRecycledViewPool() != null && (viewHolderArrayList = ((RecyclerViewBase) HippyWaterfallView.this).mRecycler.getRecycledViewPool().mScrap.get(i3)) != null && !viewHolderArrayList.isEmpty()) {
                Iterator it = viewHolderArrayList.iterator();
                while (it.hasNext()) {
                    RecyclerViewBase.ViewHolder viewHolder = (RecyclerViewBase.ViewHolder) it.next();
                    if (viewHolder.getItemViewType() == i3) {
                        ContentHolder contentHolder = viewHolder.mContentHolder;
                        if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == hippyWaterfallItemRenderNode) {
                            viewHolder.setItemViewType(i16);
                            viewHolderArrayList.remove(viewHolder);
                            ((RecyclerViewBase) HippyWaterfallView.this).mRecycler.getRecycledViewPool().getScrapHeapForType(i16).add(viewHolder);
                            return;
                        }
                    }
                }
            }
        }

        private HippyWaterfallEvent getOnFooterAppearedEvent() {
            if (this.mOnFooterAppearedEvent == null) {
                this.mOnFooterAppearedEvent = new HippyWaterfallEvent("onFooterAppeared");
            }
            return this.mOnFooterAppearedEvent;
        }

        private HippyWaterfallEvent getOnRefreshEvent() {
            if (this.mOnRefreshEvent == null) {
                this.mOnRefreshEvent = new HippyWaterfallEvent(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            }
            return this.mOnRefreshEvent;
        }

        private HippyWaterfallEvent getOnScrollForReportEvent() {
            if (this.mOnScrollForReportEvent == null) {
                this.mOnScrollForReportEvent = new HippyWaterfallEvent("onScrollForReport");
            }
            return this.mOnScrollForReportEvent;
        }

        private RecyclerViewBase.ViewHolder getRecycledViewFromPoolInner(RecyclerViewBase.RecycledViewPool recycledViewPool, int i3, int i16) {
            RecyclerViewBase.ViewHolderArrayList viewHolderArrayList;
            if (recycledViewPool != null && (viewHolderArrayList = recycledViewPool.mScrap.get(i3)) != null && !viewHolderArrayList.isEmpty()) {
                Iterator it = viewHolderArrayList.iterator();
                while (it.hasNext()) {
                    RecyclerViewBase.ViewHolder viewHolder = (RecyclerViewBase.ViewHolder) it.next();
                    if (viewHolder.getItemViewType() == i3) {
                        ContentHolder contentHolder = viewHolder.mContentHolder;
                        if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i16)) {
                            viewHolderArrayList.remove(viewHolder);
                            return viewHolder;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        private RecyclerViewBase.ViewHolder getScrapViewForPositionInner(int i3, int i16, RecyclerViewBase.Recycler recycler) {
            int size = recycler.mAttachedScrap.size();
            for (int i17 = 0; i17 < size; i17++) {
                RecyclerViewBase.ViewHolder viewHolder = recycler.mAttachedScrap.get(i17);
                if (viewHolder.getPosition() == i3 && !viewHolder.isInvalid() && !viewHolder.isRemoved() && viewHolder.getItemViewType() == i16) {
                    ContentHolder contentHolder = viewHolder.mContentHolder;
                    if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3)) {
                        recycler.mAttachedScrap.remove(i17);
                        viewHolder.setScrapContainer(null);
                        return viewHolder;
                    }
                }
            }
            int size2 = recycler.mCachedViews.size();
            for (int i18 = 0; i18 < size2; i18++) {
                RecyclerViewBase.ViewHolder viewHolder2 = recycler.mCachedViews.get(i18);
                if (viewHolder2.getPosition() == i3 && viewHolder2.getItemId() == i16 && !viewHolder2.isInvalid()) {
                    ContentHolder contentHolder2 = viewHolder2.mContentHolder;
                    if ((contentHolder2 instanceof NodeHolder) && ((NodeHolder) contentHolder2).mBindNode == HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3)) {
                        recycler.mCachedViews.remove(i18);
                        return viewHolder2;
                    }
                }
            }
            return getRecycledViewFromPoolInner(recycler.getRecycledViewPool(), i16, i3);
        }

        private void sendOnScrollForReport(int i3, int i16, int i17, int i18, int i19, HippyArray hippyArray) {
            this.mHasOnScrollForReport = true;
            if (this.mScrollReportResultMap == null) {
                this.mScrollReportResultMap = new HippyMap();
            }
            this.mScrollReportResultMap.clear();
            this.mScrollReportResultMap.pushInt(HippyTKDListViewAdapter.START_EDGE_POS, i3);
            this.mScrollReportResultMap.pushInt(HippyTKDListViewAdapter.END_EDGE_POS, i16);
            this.mScrollReportResultMap.pushInt(HippyTKDListViewAdapter.FIRST_VISIBLE_ROW_INDEX, i17);
            this.mScrollReportResultMap.pushInt(HippyTKDListViewAdapter.LAST_VISIBLE_ROW_INDEX, i18);
            this.mScrollReportResultMap.pushInt(HippyTKDListViewAdapter.SCROLL_STATE, i19);
            this.mScrollReportResultMap.pushArray(HippyTKDListViewAdapter.VISIBLE_ROW_FRAMES, hippyArray);
            getOnScrollForReportEvent().send(this.mParentRecyclerView, this.mScrollReportResultMap);
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

        protected void checkExposureForReport(int i3, int i16) {
            ExposureForReport exposureForReport;
            if (this.mEnableExposureReport && (exposureForReport = HippyWaterfallView.this.getExposureForReport(i3, i16)) != null && checkNeedToReport(exposureForReport.mVelocity, i16)) {
                if (this.mExposureReportResultMap == null) {
                    this.mExposureReportResultMap = new HippyMap();
                }
                this.mExposureReportResultMap.clear();
                this.mExposureReportResultMap.pushInt(HippyTKDListViewAdapter.START_EDGE_POS, exposureForReport.mStartEdgePos);
                this.mExposureReportResultMap.pushInt(HippyTKDListViewAdapter.END_EDGE_POS, exposureForReport.mEndEdgePos);
                this.mExposureReportResultMap.pushInt(HippyTKDListViewAdapter.FIRST_VISIBLE_ROW_INDEX, exposureForReport.mFirstVisibleRowIndex);
                this.mExposureReportResultMap.pushInt(HippyTKDListViewAdapter.LAST_VISIBLE_ROW_INDEX, exposureForReport.mLastVisibleRowIndex);
                this.mExposureReportResultMap.pushInt(HippyTKDListViewAdapter.SCROLL_STATE, exposureForReport.mScrollState);
                this.mExposureReportResultMap.pushArray(HippyTKDListViewAdapter.VISIBLE_ROW_FRAMES, exposureForReport.mVisibleRowFrames);
                exposureForReport.send(this.mParentRecyclerView, this.mExposureReportResultMap);
            }
        }

        protected boolean checkNeedToReport(float f16, int i3) {
            return true;
        }

        protected void checkScrollForReport() {
            if (!this.mEnableScrollForReport) {
                return;
            }
            int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
            int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
            int findFirstVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
            if (findLastVisibleItemPosition >= 1 && (this.mParentRecyclerView.getLayoutManager().findViewByPosition(findLastVisibleItemPosition) instanceof HippyPullFooterView)) {
                findLastVisibleItemPosition--;
            }
            int i3 = findLastVisibleItemPosition;
            if (this.mParentRecyclerView.mViewFlinger.getScroller() == null) {
                return;
            }
            float abs = Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity());
            int scrollState = this.mParentRecyclerView.getScrollState();
            HippyArray hippyArray = new HippyArray();
            for (int i16 = findFirstVisibleItemPosition; i16 <= i3; i16++) {
                View findViewByPosition = this.mParentRecyclerView.getLayoutManager().findViewByPosition(i16);
                if (findViewByPosition != null) {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushInt(HippyTKDListViewAdapter.X, findViewByPosition.getLeft());
                    hippyMap.pushInt("y", findViewByPosition.getTop() + HippyWaterfallView.this.mOffsetY);
                    hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i16)));
                    hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i16)));
                    hippyArray.pushMap(hippyMap);
                }
            }
            handleCurrentScrollStateInner(px2dp, px2dp2, findFirstVisibleItemPosition, i3, abs, scrollState, hippyArray);
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public RecyclerViewBase.ViewHolder findBestHolderForPosition(int i3, RecyclerViewBase.Recycler recycler) {
            return findBestHolderRecursive(i3, getItemViewType(i3), recycler);
        }

        RecyclerViewBase.ViewHolder findBestHolderRecursive(int i3, int i16, RecyclerViewBase.Recycler recycler) {
            RecyclerViewBase.ViewHolder scrapViewForPositionInner = getScrapViewForPositionInner(i3, i16, recycler);
            if (scrapViewForPositionInner == null) {
                scrapViewForPositionInner = recycler.getViewHolderForPosition(i3);
            }
            if (scrapViewForPositionInner != null && ((NodeHolder) scrapViewForPositionInner.mContentHolder).mBindNode.isDelete()) {
                return findBestHolderRecursive(i3, i16, recycler);
            }
            return scrapViewForPositionInner;
        }

        protected ExposureForReport getExposureForReportInner(int i3, int i16) {
            if (!this.mEnableExposureReport || this.mParentRecyclerView.mViewFlinger.getScroller() == null) {
                return null;
            }
            this.mHasExposureReport = true;
            int px2dp = (int) PixelUtil.px2dp(this.mParentRecyclerView.mOffsetY);
            int px2dp2 = (int) PixelUtil.px2dp(this.mParentRecyclerView.getHeight() + this.mParentRecyclerView.mOffsetY);
            int findFirstVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
            if (findLastVisibleItemPosition >= 1 && (this.mParentRecyclerView.getLayoutManager().findViewByPosition(findLastVisibleItemPosition) instanceof HippyPullFooterView)) {
                findLastVisibleItemPosition--;
            }
            int i17 = findLastVisibleItemPosition;
            HippyArray hippyArray = new HippyArray();
            for (int i18 = findFirstVisibleItemPosition; i18 <= i17; i18++) {
                View findViewByPosition = this.mParentRecyclerView.getLayoutManager().findViewByPosition(i18);
                if (findViewByPosition != null) {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushInt(HippyTKDListViewAdapter.X, findViewByPosition.getLeft());
                    hippyMap.pushInt("y", findViewByPosition.getTop() + HippyWaterfallView.this.mOffsetY);
                    hippyMap.pushInt("width", (int) PixelUtil.px2dp(getItemWidth(i18)));
                    hippyMap.pushInt("height", (int) PixelUtil.px2dp(getItemHeight(i18)));
                    hippyArray.pushMap(hippyMap);
                }
            }
            return new ExposureForReport(this.mParentRecyclerView.getId(), px2dp, px2dp2, findFirstVisibleItemPosition, i17, (int) Math.abs(this.mParentRecyclerView.mViewFlinger.getScroller().getCurrVelocity()), i16, hippyArray);
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public int getHeightBefore(int i3) {
            return ((HippyWaterfallLayoutManager) HippyWaterfallView.this.getLayoutManager()).getHeightBefore(i3);
        }

        View getHippyView(int i3) {
            return HippyWaterfallView.this.mHippyContext.getRenderManager().getControllerManager().findView(i3);
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public int getItemCount() {
            try {
                return getRenderNode().getChildCount();
            } catch (NullPointerException e16) {
                e16.printStackTrace();
                return 0;
            }
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public int getItemHeight(int i3) {
            int i16;
            RenderNode childAt;
            RenderNode renderNode = HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
            if (renderNode != null && renderNode.getChildCount() > i3 && i3 >= 0 && (childAt = renderNode.getChildAt(i3)) != null) {
                i16 = childAt.getHeight();
            } else {
                i16 = 0;
            }
            return i16 + ((HippyWaterfallLayoutManager) this.mParentRecyclerView.getLayoutManager()).getItemGap();
        }

        public RenderNode getItemNode(int i3) {
            return getRenderNode().getChildAt(i3);
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public int getItemViewType(int i3) {
            RenderNode itemNode = getItemNode(i3);
            if (itemNode != null) {
                HippyMap props = itemNode.getProps();
                if (props != null && props.containsKey("type")) {
                    return props.getInt("type");
                }
                if (itemNode instanceof i) {
                    return -5;
                }
                if (itemNode instanceof j) {
                    return -4;
                }
                return 0;
            }
            return 0;
        }

        public RecyclerView.OnListScrollListener getOnListScrollListener() {
            if (this.mOnListScrollListener == null) {
                this.mOnListScrollListener = new RecyclerView.OnListScrollListener() { // from class: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView.HippyWaterfallAdapter.1
                    AnonymousClass1() {
                    }

                    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                    public void onScroll(int i3, int i16) {
                        RecyclerView recyclerView = HippyWaterfallAdapter.this.mParentRecyclerView;
                        if ((recyclerView instanceof HippyWaterfallView) && ((HippyWaterfallView) recyclerView).enableOnSrollReport()) {
                            HippyWaterfallAdapter.this.checkScrollForReport();
                        }
                    }

                    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
                    public void onScrollEnd() {
                        HippyWaterfallAdapter.this.checkScrollForReport();
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

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public int getPreloadThresholdInItemNumber() {
            return this.mPreloadItemNum;
        }

        public int getRecyclerItemCount() {
            this.mListViewHolder = new ArrayList<>();
            RecyclerViewBase.Recycler recycler = this.mParentRecyclerView.getRecycler();
            this.mListViewHolder.addAll(recycler.mAttachedScrap);
            this.mListViewHolder.addAll(recycler.mCachedViews);
            for (int i3 = 0; i3 < recycler.getRecycledViewPool().mScrap.size(); i3++) {
                this.mListViewHolder.addAll(recycler.getRecycledViewPool().mScrap.valueAt(i3));
            }
            return this.mListViewHolder.size() + this.mParentRecyclerView.getChildCount();
        }

        public View getRecyclerItemView(int i3) {
            if (i3 < this.mListViewHolder.size()) {
                return this.mListViewHolder.get(i3).mContent;
            }
            return this.mParentRecyclerView.getChildAt(i3 - this.mListViewHolder.size());
        }

        RenderNode getRenderNode() {
            return HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(HippyWaterfallView.this.getId());
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public int getTotalHeight() {
            return HippyWaterfallView.this.getLayoutManager().getTotalHeight();
        }

        void handleCurrentScrollStateInner(int i3, int i16, int i17, int i18, float f16, int i19, HippyArray hippyArray) {
            if (((i19 == 0 || i19 == 1) && checkNeedToReport(0.0f, i19)) || (f16 < this.mParentRecyclerView.getHeight() * 2 && checkNeedToReport(f16, i19))) {
                sendOnScrollForReport(i3, i16, i17, i18, i19, hippyArray);
            }
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public boolean hasCustomRecycler() {
            return true;
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
        public boolean isAutoCalculateItemHeight() {
            return true;
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public void notifyDataSetChanged() {
            setPreloadItemNum(getPreloadThresholdInItemNumber());
            super.notifyDataSetChanged();
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public void notifyLastFooterAppeared() {
            super.notifyLastFooterAppeared();
            int i3 = this.mLoadingStatus;
            if (i3 != 1 && i3 != 100 && i3 != 6) {
                setLoadingStatus(1);
            }
            if (this.mLoadingStatus == 1) {
                this.mHasOnFooterAppeared = true;
                getOnFooterAppearedEvent().send(this.mParentRecyclerView, null);
            }
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
        public void onBindContentView(ContentHolder contentHolder, int i3, int i16) {
            NodeHolder nodeHolder = (NodeHolder) contentHolder;
            if (nodeHolder.isCreated) {
                try {
                    nodeHolder.mBindNode.updateViewRecursive();
                    nodeHolder.isCreated = false;
                } finally {
                }
            } else {
                RenderNode renderNode = nodeHolder.mBindNode;
                if (renderNode != null) {
                    renderNode.setLazy(true);
                }
                try {
                    RenderNode childAt = HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(HippyWaterfallView.this.getId()).getChildAt(i3);
                    childAt.setLazy(false);
                    ArrayList<DiffUtils.PatchType> diff = DiffUtils.diff(nodeHolder.mBindNode, childAt);
                    try {
                        DiffUtils.deleteViews(HippyWaterfallView.this.mHippyContext.getRenderManager().getControllerManager(), diff);
                        DiffUtils.replaceIds(HippyWaterfallView.this.mHippyContext.getRenderManager().getControllerManager(), diff);
                        DiffUtils.createView(diff);
                        DiffUtils.doPatch(HippyWaterfallView.this.mHippyContext.getRenderManager().getControllerManager(), diff);
                        nodeHolder.mBindNode = childAt;
                    } finally {
                    }
                } catch (Throwable unused) {
                }
            }
            View view = nodeHolder.mContentView;
            if (view instanceof HippyPullFooterView) {
                FooterUtil.sendFooterReleasedEvent((HippyPullFooterView) view);
            }
            RenderNode renderNode2 = nodeHolder.mBindNode;
            if (renderNode2 instanceof HippyWaterfallItemRenderNode) {
                ((HippyWaterfallItemRenderNode) renderNode2).setRecycleItemTypeChangeListener(this);
            }
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
        public ContentHolder onCreateContentViewWithPos(ViewGroup viewGroup, int i3, int i16) {
            View createViewRecursive;
            NodeHolder nodeHolder = new NodeHolder();
            RenderNode childAt = HippyWaterfallView.this.mHippyContext.getRenderManager().getRenderNode(HippyWaterfallView.this.getId()).getChildAt(i3);
            if (!childAt.isIsLazyLoad()) {
                createViewRecursive = HippyWaterfallView.this.mHippyContext.getRenderManager().getControllerManager().findView(childAt.getId());
            } else {
                childAt.setLazy(false);
                createViewRecursive = childAt.createViewRecursive();
            }
            nodeHolder.mContentView = createViewRecursive;
            FooterUtil.checkFooterBinding(this.mParentRecyclerView, nodeHolder.mContentView);
            nodeHolder.mBindNode = childAt;
            nodeHolder.isCreated = true;
            return nodeHolder;
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public void onPreload() {
            this.mHasPreload = true;
            this.mOnPreloadCalled = true;
        }

        @Override // com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallItemRenderNode.IRecycleItemTypeChange
        public void onRecycleItemTypeChanged(int i3, int i16, HippyWaterfallItemRenderNode hippyWaterfallItemRenderNode) {
            checkHolderType(i3, i16, hippyWaterfallItemRenderNode);
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public void onSuddenStop() {
            checkScrollForReport();
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public void onViewAbandon(RecyclerView.ViewHolderWrapper viewHolderWrapper) {
            NodeHolder nodeHolder = (NodeHolder) viewHolderWrapper.mContentHolder;
            RenderNode renderNode = nodeHolder.mBindNode;
            if (renderNode != null) {
                renderNode.setLazy(true);
                HippyWaterfallView.this.mHippyContext.getRenderManager().getControllerManager().deleteChild(this.mParentRecyclerView.getId(), nodeHolder.mBindNode.getId());
            }
            RenderNode renderNode2 = nodeHolder.mBindNode;
            if (renderNode2 instanceof HippyWaterfallItemRenderNode) {
                ((HippyWaterfallItemRenderNode) renderNode2).setRecycleItemTypeChangeListener(null);
            }
            super.onViewAbandon(viewHolderWrapper);
        }

        public void onViewAbandonHelper(RecyclerView.ViewHolderWrapper viewHolderWrapper) {
            onViewAbandon(viewHolderWrapper);
        }

        protected void setEnableExposureReport(boolean z16) {
            this.mEnableExposureReport = z16;
        }

        protected void setEnableScrollForReport(boolean z16) {
            this.mEnableScrollForReport = z16;
        }

        protected void setLoadingStatus(int i3, String str) {
            if (i3 != 1) {
                this.mHasSetLoadingStatus = true;
                setLoadingStatus(i3);
                View view = this.mDefaultLoadingView;
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mDefaultLoadingView.getHeight(), 1073741824));
                    View view2 = this.mDefaultLoadingView;
                    view2.layout(view2.getLeft(), this.mDefaultLoadingView.getTop(), this.mDefaultLoadingView.getRight(), this.mDefaultLoadingView.getBottom());
                    this.mDefaultLoadingView.invalidate();
                }
                this.mOnPreloadCalled = false;
                return;
            }
            this.mHasSetLoadingStatus = true;
            setLoadingStatus(i3);
        }

        protected void setPreloadItemNum(int i3) {
            this.mPreloadItemNum = i3;
            this.mShouldUpdatePreloadDistance = true;
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
        public void startRefreshData() {
            this.mHasOnRefresh = true;
            getOnRefreshEvent().send(this.mParentRecyclerView, null);
        }

        public void startRefreshData(boolean z16) {
            this.mHasOnRefresh = true;
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("refreshFrom", z16 ? "pull" : "command");
            getOnRefreshEvent().send(this.mParentRecyclerView, hippyMap);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView$HippyWaterfallAdapter$1 */
        /* loaded from: classes20.dex */
        public class AnonymousClass1 implements RecyclerView.OnListScrollListener {
            AnonymousClass1() {
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
            public void onScroll(int i3, int i16) {
                RecyclerView recyclerView = HippyWaterfallAdapter.this.mParentRecyclerView;
                if ((recyclerView instanceof HippyWaterfallView) && ((HippyWaterfallView) recyclerView).enableOnSrollReport()) {
                    HippyWaterfallAdapter.this.checkScrollForReport();
                }
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
            public void onScrollEnd() {
                HippyWaterfallAdapter.this.checkScrollForReport();
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
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class HippyWaterfallEvent extends HippyViewEvent {
        String eventName;

        public HippyWaterfallEvent(String str) {
            super(str);
            this.eventName = str;
        }

        @Override // com.tencent.mtt.hippy.uimanager.HippyViewEvent
        public void send(View view, Object obj) {
            super.send(view, obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class NodeHolder extends ContentHolder {
        public boolean isCreated;
        public RenderNode mBindNode;

        NodeHolder() {
            this.isCreated = true;
        }

        public String toString() {
            return "NodeHolder@" + Integer.toHexString(hashCode()) + " created=" + this.isCreated + " node=" + this.mBindNode.toString();
        }

        /* synthetic */ NodeHolder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnInitialListReadyEvent extends HippyViewEvent {
        public OnInitialListReadyEvent(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class RNWFRecyclerPool extends RecyclerViewBase.RecycledViewPool {
        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.RecycledViewPool
        public void putRecycledView(RecyclerViewBase.ViewHolder viewHolder, RecyclerViewBase.Adapter adapter) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<RecyclerViewBase.ViewHolder> scrapHeapForType = getScrapHeapForType(itemViewType);
            if (this.mMaxScrap.get(itemViewType) <= scrapHeapForType.size()) {
                RecyclerViewBase.ViewHolder viewHolder2 = scrapHeapForType.get(0);
                scrapHeapForType.remove(0);
                if ((adapter instanceof RecyclerViewBase.Adapter) && (viewHolder2 instanceof RecyclerView.ViewHolderWrapper)) {
                    ((HippyWaterfallAdapter) adapter).onViewAbandonHelper((RecyclerView.ViewHolderWrapper) viewHolder2);
                }
            }
            viewHolder.mPosition = Integer.MIN_VALUE;
            viewHolder.mOldPosition = Integer.MIN_VALUE;
            viewHolder.mItemId = -1L;
            viewHolder.clearFlagsForSharedPool();
            scrapHeapForType.add(viewHolder);
        }
    }

    public HippyWaterfallView(Context context) {
        super(context);
        this.mDispatchLayout = null;
        this.mHasRemovePreDraw = false;
        this.mPreDrawListener = null;
        this.mViewTreeObserver = null;
        this.mEndChecker = new WaterfallEndChecker();
        this.mHasLoadMore = false;
        this.mHasScrollToIndex = false;
        this.mHasScrollToContentOffset = false;
        this.mHasStartRefresh = false;
        this.mHasCompeleteRefresh = false;
        this.mFooterState = 0;
        this.mHippyContext = ((HippyInstanceContext) context).getEngineContext();
        setLayoutManager(new HippyWaterfallLayoutManager(context));
        this.mAdapter = (HippyWaterfallAdapter) getAdapter();
        setRecycledViewPool(new RNWFRecyclerPool());
        this.mEnableFooter = true;
        this.mEnableRefresh = false;
        this.mRefreshColors = null;
        addOnListScrollListener(this.mAdapter.getOnListScrollListener());
        setClipToPadding(false);
    }

    public OnInitialListReadyEvent getOnInitialListReadyEvent() {
        if (this.mOnInitialListReadyEvent == null) {
            this.mOnInitialListReadyEvent = new OnInitialListReadyEvent(RecyclerViewEventHelper.INITIAL_LIST_READY);
        }
        return this.mOnInitialListReadyEvent;
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

    public void checkExposureForReport(int i3, int i16) {
        if (getAdapter() != null) {
            this.mAdapter.checkExposureForReport(i3, i16);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean checkShouldStopScroll() {
        return false;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public HippyWaterfallAdapter createAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        return new HippyWaterfallAdapter(this);
    }

    protected boolean enableOnSrollReport() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public HippyMap generateScrollEvent() {
        HippyMap generateScrollEvent = super.generateScrollEvent();
        generateScrollEvent.pushDouble(HippyTKDListViewAdapter.START_EDGE_POS, PixelUtil.px2dp(getOffsetY()));
        generateScrollEvent.pushDouble(HippyTKDListViewAdapter.END_EDGE_POS, PixelUtil.px2dp(getOffsetY() + getHeight()));
        generateScrollEvent.pushInt(HippyTKDListViewAdapter.FIRST_VISIBLE_ROW_INDEX, getFirstVisibleItemPos());
        generateScrollEvent.pushInt(HippyTKDListViewAdapter.LAST_VISIBLE_ROW_INDEX, getFirstVisibleItemPos() + getChildCountInItem());
        HippyArray hippyArray = new HippyArray();
        for (int i3 = 0; i3 < getChildCountInItem(); i3++) {
            if (getChildAt(i3) != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushDouble(HippyTKDListViewAdapter.X, PixelUtil.px2dp(r3.getX()));
                hippyMap.pushDouble("y", PixelUtil.px2dp(r3.getY()));
                hippyMap.pushDouble("width", PixelUtil.px2dp(r3.getWidth()));
                hippyMap.pushDouble("height", PixelUtil.px2dp(r3.getHeight()));
                hippyArray.pushMap(hippyMap);
            }
        }
        generateScrollEvent.pushArray(HippyTKDListViewAdapter.VISIBLE_ROW_FRAMES, hippyArray);
        return generateScrollEvent;
    }

    protected ExposureForReport getExposureForReport(int i3, int i16) {
        return this.mAdapter.getExposureForReportInner(i3, i16);
    }

    @Override // com.tencent.mtt.hippy.views.refresh.IFooterContainer
    public int getFooterState() {
        return this.mFooterState;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void handleInTraversal(int i3, int i16, View view) {
        if (i3 == 1001) {
            traversalChildViewForSkinChange(view);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public boolean isRefreshing() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mHasRemovePreDraw) {
            this.mViewTreeObserver = getViewTreeObserver();
            if (this.mPreDrawListener == null) {
                this.mPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView.2

                    /* compiled from: P */
                    /* renamed from: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView$2$1 */
                    /* loaded from: classes20.dex */
                    class AnonymousClass1 implements Runnable {
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            HippyWaterfallView.this.getOnInitialListReadyEvent().send(HippyWaterfallView.this, null);
                        }
                    }

                    AnonymousClass2() {
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (HippyWaterfallView.this.mAdapter.getItemCount() > 0 && HippyWaterfallView.this.getChildCount() > 0) {
                            HippyWaterfallView.this.mViewTreeObserver.removeOnPreDrawListener(this);
                            HippyWaterfallView.this.mHasRemovePreDraw = true;
                            HippyWaterfallView.this.post(new Runnable() { // from class: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView.2.1
                                AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    HippyWaterfallView.this.getOnInitialListReadyEvent().send(HippyWaterfallView.this, null);
                                }
                            });
                        }
                        return true;
                    }
                };
            }
            this.mViewTreeObserver.removeOnPreDrawListener(this.mPreDrawListener);
            this.mViewTreeObserver.addOnPreDrawListener(this.mPreDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        stopScroll();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.mPreDrawListener;
        if (onPreDrawListener != null && (viewTreeObserver = this.mViewTreeObserver) != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.hippy.views.refresh.IFooterContainer
    public void onFooterRefreshFinish() {
        setFooterState(1);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrollStateChanged(int i3, int i16) {
        super.onScrollStateChanged(i3, i16);
        if (getAdapter() != null) {
            this.mAdapter.checkScrollForReport();
            this.mAdapter.checkExposureForReport(i3, i16);
        }
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollListener
    public void onScrolled(int i3, int i16) {
        super.onScrolled(i3, i16);
        this.mEndChecker.check(this);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher = this.mGestureDispatcher;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void scrollToContentOffset(double d16, double d17, boolean z16) {
        this.mHasScrollToContentOffset = true;
        if (z16) {
            smoothScrollBy(0, (int) d17);
        } else {
            scrollToPosition(0, (int) (-PixelUtil.dp2px(d17)));
            post(new a(this));
        }
    }

    public void scrollToIndex(int i3, int i16, boolean z16) {
        this.mHasScrollToIndex = true;
        if (z16) {
            scrollToIndex(i3, i16, true, 0);
        } else {
            scrollToPosition(i16, 0);
            post(new a(this));
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase, com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
    public void scrollToTopAtOnce() {
        super.scrollToTopAtOnce();
    }

    public void setEnableExposureReport(boolean z16) {
        this.mAdapter.setEnableExposureReport(z16);
    }

    public void setEnableScrollForReport(boolean z16) {
        this.mAdapter.setEnableScrollForReport(z16);
    }

    @Override // com.tencent.mtt.hippy.views.refresh.IFooterContainer
    public void setFooterState(int i3) {
        this.mFooterState = i3;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView
    public void setListData() {
        if (getAdapter() == null) {
            setAdapter(this.mAdapter);
        }
        setFooterState(0);
        this.mAdapter.notifyDataSetChanged();
        if (this.mDispatchLayout == null) {
            this.mDispatchLayout = new Runnable() { // from class: com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    HippyWaterfallView.this.dispatchLayout();
                    int itemCount = HippyWaterfallView.this.mLayout.getItemCount();
                    boolean z16 = true;
                    if (itemCount <= 1 && (itemCount != 1 || (HippyWaterfallView.this.mAdapter.getItemNode(0) instanceof i))) {
                        z16 = false;
                    }
                    if (z16) {
                        HippyWaterfallView.this.mEndChecker.reset();
                        HippyWaterfallView.this.mEndChecker.check(HippyWaterfallView.this);
                    }
                }
            };
        }
        removeCallbacks(this.mDispatchLayout);
        post(this.mDispatchLayout);
    }

    public void setLoadingStatus(int i3, String str) {
        this.mAdapter.setLoadingStatus(i3, str);
    }

    public void setPreloadItemNumber(int i3) {
        this.mAdapter.setPreloadItemNum(i3);
    }

    public void setRefreshColors(HippyArray hippyArray) {
        this.mRefreshColors = hippyArray;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopOnInterceptTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopOnTouchEvent(MotionEvent motionEvent, int i3, boolean z16) {
        return false;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListView, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean shouldStopReleaseGlows(boolean z16, boolean z17) {
        return false;
    }

    public void startLoadMore() {
        this.mHasLoadMore = true;
        this.mAdapter.setLoadingStatus(1);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected void checkRefreshHeadOnFlingRun() {
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected void invalidateRefreshHeader() {
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

    public void setRefreshEnabled(boolean z16) {
    }

    public void setScrollbarEnabled(boolean z16) {
    }

    public void startRefresh(int i3) {
    }

    public void startRefreshWithOnlyAnimation(boolean z16) {
    }

    public void startRefreshWithType(boolean z16) {
    }

    public void setCustomRefreshColor(int i3, int i16, int i17) {
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean changeUpOverScrollEnableOnComputeDxDy(int i3, int i16, boolean z16, Scroller scroller, boolean z17, boolean z18) {
        return z18;
    }

    public void setRefreshPromptInfo(String str, int i3, int i16, String str2, int i17, int i18) {
    }
}
