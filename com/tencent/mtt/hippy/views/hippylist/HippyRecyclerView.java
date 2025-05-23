package com.tencent.mtt.hippy.views.hippylist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.HippyRecyclerViewBase;
import androidx.recyclerview.widget.IHippyViewAboundListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollHelper;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderAttachListener;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderHost;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.StickyHeaderHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRecyclerView<ADP extends HippyRecyclerListAdapter> extends HippyRecyclerViewBase implements IHippyViewAboundListener, HippyNestedScrollComponent.HippyNestedScrollTarget2, IHeaderAttachListener {
    protected static int DEFAULT_ITEM_VIEW_CACHE_SIZE = 4;
    private static ArrayList<View> sTempViews;
    protected IHeaderHost headerHost;
    protected HippyEngineContext hippyEngineContext;
    protected boolean isEnableScroll;
    private boolean isTvPlatform;
    protected RecyclerView.LayoutManager layoutManager;
    protected ADP listAdapter;
    private HippyRecycleViewFocusHelper mFocusHelper;
    private int mInitialContentOffset;
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;
    private final HippyNestedScrollComponent.Priority[] mNestedScrollPriority;
    private final int[] mScrollConsumedPair;
    private NodePositionHelper nodePositionHelper;
    protected RecyclerViewEventHelper recyclerViewEventHelper;
    protected int renderNodeCount;
    private boolean stickEventEnable;
    protected StickyHeaderHelper stickyHeaderHelper;
    private ViewStickEventHelper viewStickEventHelper;

    public HippyRecyclerView(Context context) {
        super(context);
        this.isEnableScroll = true;
        this.renderNodeCount = 0;
        this.isTvPlatform = false;
        this.mFocusHelper = null;
        this.mScrollConsumedPair = new int[2];
        HippyNestedScrollComponent.Priority priority = HippyNestedScrollComponent.Priority.NOT_SET;
        this.mNestedScrollPriority = new HippyNestedScrollComponent.Priority[]{HippyNestedScrollComponent.Priority.SELF, priority, priority, priority, priority};
    }

    private boolean canScrollToContentOffset() {
        if (this.renderNodeCount == getAdapter().getRenderNodeCount()) {
            return true;
        }
        return false;
    }

    private int computeHorizontallyScrollDistance(int i3) {
        if (i3 < 0) {
            return Math.max(i3, -computeHorizontalScrollOffset());
        }
        if (i3 > 0) {
            return Math.min(i3, ((computeHorizontalScrollRange() - computeHorizontalScrollExtent()) - computeHorizontalScrollOffset()) - 1);
        }
        return 0;
    }

    private int computeVerticallyScrollDistance(int i3) {
        if (i3 < 0) {
            return Math.max(i3, -computeVerticalScrollOffset());
        }
        if (i3 > 0) {
            return Math.min(i3, ((computeVerticalScrollRange() - computeVerticalScrollExtent()) - computeVerticalScrollOffset()) - 1);
        }
        return 0;
    }

    private void destoryViewStickEventHelper() {
        StickyHeaderHelper stickyHeaderHelper = this.stickyHeaderHelper;
        if (stickyHeaderHelper != null) {
            stickyHeaderHelper.setStickViewListener(null);
        }
        this.viewStickEventHelper = null;
    }

    private void doSmoothScrollBy(int i3, int i16, int i17) {
        if (i3 == 0 && i16 == 0) {
            return;
        }
        if (i17 != 0) {
            if (!didStructureChange()) {
                smoothScrollBy(i3, i16, i17);
            } else {
                return;
            }
        } else {
            smoothScrollBy(i3, i16);
        }
        postDispatchLayout();
    }

    private void ensureViewStickEventHelper() {
        if (this.viewStickEventHelper == null) {
            this.viewStickEventHelper = new ViewStickEventHelper((View) getParent());
        }
        StickyHeaderHelper stickyHeaderHelper = this.stickyHeaderHelper;
        if (stickyHeaderHelper != null) {
            stickyHeaderHelper.setStickViewListener(this.viewStickEventHelper);
        }
    }

    private boolean fillContentView(View view, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            View view2 = viewHolder.itemView;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (viewGroup.getChildCount() <= 0) {
                    viewGroup.addView(view, generateStickyLayoutParams());
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private int getFirstVisiblePositionByOffset(int i3) {
        int itemWidth;
        int itemCount = getAdapter().getItemCount();
        boolean isVerticalLayout = HippyListUtils.isVerticalLayout(this);
        int i16 = 0;
        for (int i17 = 0; i17 < itemCount; i17++) {
            ADP adp = this.listAdapter;
            if (isVerticalLayout) {
                itemWidth = adp.getItemHeight(i17);
            } else {
                itemWidth = adp.getItemWidth(i17);
            }
            i16 += itemWidth;
            if (i16 > i3) {
                return i17;
            }
        }
        return 0;
    }

    private Rect getViewVisibleRect(View view) {
        Rect rect = new Rect();
        if (view != null) {
            view.getLocalVisibleRect(rect);
        }
        return rect;
    }

    private void postDispatchLayout() {
        post(new Runnable() { // from class: com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                HippyRecyclerView.this.dispatchLayout();
            }
        });
    }

    private void scrollToInitContentOffset() {
        int firstVisiblePositionByOffset = getFirstVisiblePositionByOffset(this.mInitialContentOffset);
        scrollToPositionWithOffset(firstVisiblePositionByOffset, -(this.mInitialContentOffset - getTotalHeightBefore(firstVisiblePositionByOffset)));
        this.mInitialContentOffset = 0;
    }

    private boolean verifyFocusable(@NonNull View view, int i3) {
        boolean isInTouchMode = isInTouchMode();
        if (!isInTouchMode ? view.isFocusable() : view.isFocusableInTouchMode()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        if (sTempViews == null) {
            sTempViews = new ArrayList<>();
        }
        view.addFocusables(sTempViews, i3, isInTouchMode ? 1 : 0);
        boolean z16 = !sTempViews.isEmpty();
        sTempViews.clear();
        return z16;
    }

    protected RecyclerViewEventHelper createEventHelper() {
        return new RecyclerViewEventHelper(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && this.isTvPlatform) {
            this.mFocusHelper.setKeyCode(keyEvent.getKeyCode());
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        int[] iArr3 = this.mScrollConsumedPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i3, i16, iArr3, iArr2);
        if (dispatchNestedPreScroll) {
            int[] iArr4 = this.mScrollConsumedPair;
            int i17 = iArr4[0];
            i3 -= i17;
            int i18 = iArr4[1];
            i16 -= i18;
            if (iArr != null) {
                iArr[0] = iArr[0] + i17;
                iArr[1] = iArr[1] + i18;
            }
        }
        return handlePullRefresh(i3, i16, iArr) || dispatchNestedPreScroll;
    }

    public void enableStickEvent(boolean z16) {
        this.stickEventEnable = z16;
    }

    protected void endPullRefresh() {
        ADP adp = this.listAdapter;
        if (adp == null) {
            return;
        }
        PullHeaderRefreshHelper pullHeaderRefreshHelper = adp.headerRefreshHelper;
        if (pullHeaderRefreshHelper != null) {
            pullHeaderRefreshHelper.endDrag();
        }
        PullFooterRefreshHelper pullFooterRefreshHelper = this.listAdapter.footerRefreshHelper;
        if (pullFooterRefreshHelper != null) {
            pullFooterRefreshHelper.endDrag();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        if (this.isTvPlatform) {
            return this.mFocusHelper.focusSearch(view, i3);
        }
        View focusSearch = super.focusSearch(view, i3);
        if (focusSearch != null && verifyFocusable(focusSearch, i3)) {
            return focusSearch;
        }
        return null;
    }

    ViewGroup.LayoutParams generateStickyLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public int getChildDrawingOrder(int i3, int i16) {
        if (this.isTvPlatform) {
            return this.mFocusHelper.getChildDrawingOrder(i3, i16);
        }
        return super.getChildDrawingOrder(i3, i16);
    }

    public int getContentOffsetX() {
        if (HippyListUtils.isHorizontalLayout(this)) {
            int computeHorizontalScrollOffset = computeHorizontalScrollOffset();
            PullHeaderRefreshHelper pullHeaderRefreshHelper = this.listAdapter.headerRefreshHelper;
            if (pullHeaderRefreshHelper != null) {
                return computeHorizontalScrollOffset - pullHeaderRefreshHelper.getVisibleSize();
            }
            return computeHorizontalScrollOffset;
        }
        return 0;
    }

    public int getContentOffsetY() {
        if (HippyListUtils.isVerticalLayout(this)) {
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            PullHeaderRefreshHelper pullHeaderRefreshHelper = this.listAdapter.headerRefreshHelper;
            if (pullHeaderRefreshHelper != null) {
                return computeVerticalScrollOffset - pullHeaderRefreshHelper.getVisibleSize();
            }
            return computeVerticalScrollOffset;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch;
    }

    @Override // com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent
    public HippyNestedScrollComponent.Priority getNestedScrollPriority(int i3) {
        HippyNestedScrollComponent.Priority[] priorityArr = this.mNestedScrollPriority;
        HippyNestedScrollComponent.Priority priority = priorityArr[i3];
        if (priority == HippyNestedScrollComponent.Priority.NOT_SET) {
            return priorityArr[0];
        }
        return priority;
    }

    public NodePositionHelper getNodePositionHelper() {
        if (this.nodePositionHelper == null) {
            this.nodePositionHelper = new NodePositionHelper();
        }
        return this.nodePositionHelper;
    }

    public int getNodePositionInAdapter(int i3) {
        if (this.listAdapter.headerRefreshHelper != null) {
            return i3 + 1;
        }
        return i3;
    }

    public RecyclerViewEventHelper getRecyclerViewEventHelper() {
        return intEventHelper();
    }

    public int getRenderNodeHeightBefore(int i3) {
        int renderNodeWidth;
        boolean isVerticalLayout = HippyListUtils.isVerticalLayout(this);
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            ADP adp = this.listAdapter;
            if (isVerticalLayout) {
                renderNodeWidth = adp.getRenderNodeHeight(i17);
            } else {
                renderNodeWidth = adp.getRenderNodeWidth(i17);
            }
            i16 += renderNodeWidth;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroup getStickyContainer(Context context, View view) {
        FrameLayout frameLayout = new FrameLayout(context);
        if (view != null) {
            frameLayout.addView(view, generateStickyLayoutParams());
        }
        return frameLayout;
    }

    public int getTotalHeightBefore(int i3) {
        int itemWidth;
        boolean isVerticalLayout = HippyListUtils.isVerticalLayout(this);
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            ADP adp = this.listAdapter;
            if (isVerticalLayout) {
                itemWidth = adp.getItemHeight(i17);
            } else {
                itemWidth = adp.getItemWidth(i17);
            }
            i16 += itemWidth;
        }
        return i16;
    }

    public int getTotalWithBefore(int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 += this.listAdapter.getItemWidth(i17);
        }
        return i16;
    }

    protected int getVisibleHeight(View view) {
        return getViewVisibleRect(view).height();
    }

    protected int getVisibleWidth(View view) {
        return getViewVisibleRect(view).width();
    }

    protected boolean handlePullRefresh(int i3, int i16, @Nullable int[] iArr) {
        int handleDrag;
        int handleDrag2;
        ADP adp = this.listAdapter;
        if (adp != null && (adp.headerRefreshHelper != null || adp.footerRefreshHelper != null)) {
            boolean isHorizontalLayout = HippyListUtils.isHorizontalLayout(this);
            if (!isHorizontalLayout) {
                i3 = i16;
            }
            if (i3 == 0) {
                return false;
            }
            PullHeaderRefreshHelper pullHeaderRefreshHelper = this.listAdapter.headerRefreshHelper;
            if (pullHeaderRefreshHelper != null && (handleDrag2 = pullHeaderRefreshHelper.handleDrag(i3)) != 0) {
                if (iArr != null) {
                    int i17 = !isHorizontalLayout ? 1 : 0;
                    iArr[i17] = iArr[i17] + handleDrag2;
                }
                return true;
            }
            PullFooterRefreshHelper pullFooterRefreshHelper = this.listAdapter.footerRefreshHelper;
            if (pullFooterRefreshHelper != null && (handleDrag = pullFooterRefreshHelper.handleDrag(i3)) != 0) {
                if (iArr != null) {
                    int i18 = !isHorizontalLayout ? 1 : 0;
                    iArr[i18] = iArr[i18] + handleDrag;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerViewBase
    public void init() {
        super.init();
        setNestedScrollingEnabled(true);
    }

    public void initRecyclerView() {
        this.isTvPlatform = this.hippyEngineContext.isRunningOnTVPlatform();
        setAdapter(new HippyRecyclerListAdapter(this, this.hippyEngineContext));
        intEventHelper();
        setItemViewCacheSize(DEFAULT_ITEM_VIEW_CACHE_SIZE);
        if (this.isTvPlatform) {
            this.mFocusHelper = new HippyRecycleViewFocusHelper(this);
            setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RecyclerViewEventHelper intEventHelper() {
        if (this.recyclerViewEventHelper == null) {
            this.recyclerViewEventHelper = createEventHelper();
        }
        return this.recyclerViewEventHelper;
    }

    protected boolean isPullRefreshShowing() {
        PullFooterRefreshHelper pullFooterRefreshHelper;
        ADP adp = this.listAdapter;
        if (adp == null) {
            return false;
        }
        PullHeaderRefreshHelper pullHeaderRefreshHelper = adp.headerRefreshHelper;
        if ((pullHeaderRefreshHelper == null || pullHeaderRefreshHelper.getVisibleSize() <= 0) && ((pullFooterRefreshHelper = this.listAdapter.footerRefreshHelper) == null || pullFooterRefreshHelper.getVisibleSize() <= 0)) {
            return false;
        }
        return true;
    }

    public boolean isTheSameRenderNode(HippyRecyclerViewHolder hippyRecyclerViewHolder, HippyRecyclerViewHolder hippyRecyclerViewHolder2) {
        ListItemRenderNode listItemRenderNode = hippyRecyclerViewHolder2.bindNode;
        if (listItemRenderNode == null || hippyRecyclerViewHolder.bindNode == null || listItemRenderNode.getId() != hippyRecyclerViewHolder.bindNode.getId()) {
            return false;
        }
        return true;
    }

    public void onAfterUpdateProps() {
        if (this.stickEventEnable) {
            ensureViewStickEventHelper();
        } else {
            destoryViewStickEventHelper();
        }
    }

    public void onDestroy() {
        StickyHeaderHelper stickyHeaderHelper = this.stickyHeaderHelper;
        if (stickyHeaderHelper != null) {
            stickyHeaderHelper.detachSticky();
        }
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderAttachListener
    public void onHeaderDetached(RecyclerView.ViewHolder viewHolder, View view) {
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= getChildCountWithCaches()) {
                break;
            }
            RecyclerView.ViewHolder childViewHolder = getChildViewHolder(getChildAtWithCaches(i3));
            if (isTheSameRenderNode((HippyRecyclerViewHolder) viewHolder, (HippyRecyclerViewHolder) childViewHolder)) {
                fillContentView(view, childViewHolder);
                z16 = true;
                break;
            }
            i3++;
        }
        if (!z16) {
            onViewAbound((HippyRecyclerViewHolder) viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isEnableScroll && this.mNestedScrollAxesTouch == 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
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
        onNestedScrollAccepted(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerViewBase, androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnableScroll) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.IHippyViewAboundListener
    public void onViewAbound(HippyRecyclerViewHolder hippyRecyclerViewHolder) {
        ListItemRenderNode listItemRenderNode = hippyRecyclerViewHolder.bindNode;
        if (listItemRenderNode != null && !listItemRenderNode.isDelete()) {
            getAdapter().deleteExistRenderView(hippyRecyclerViewHolder.bindNode);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (this.isTvPlatform) {
            this.mFocusHelper.requestChildFocus(view, view2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        if (this.isTvPlatform) {
            return this.mFocusHelper.requestChildRectangleOnScreen(view, rect, z16);
        }
        return super.requestChildRectangleOnScreen(view, rect, z16);
    }

    public void scrollToContentOffset(double d16, double d17, boolean z16, int i3) {
        if (!canScrollToContentOffset()) {
            return;
        }
        int dp2px = ((int) PixelUtil.dp2px(d16)) - getContentOffsetX();
        int dp2px2 = ((int) PixelUtil.dp2px(d17)) - getContentOffsetY();
        if (z16) {
            doSmoothScrollBy(dp2px, dp2px2, i3);
        } else {
            scrollBy(dp2px, dp2px2);
        }
    }

    public void scrollToIndex(int i3, int i16, boolean z16, int i17) {
        int computeVerticalScrollOffset;
        boolean isHorizontalLayout = HippyListUtils.isHorizontalLayout(this);
        if (!isHorizontalLayout) {
            i3 = i16;
        }
        int nodePositionInAdapter = getNodePositionInAdapter(i3);
        int i18 = 0;
        if (z16) {
            int totalHeightBefore = getTotalHeightBefore(nodePositionInAdapter);
            if (isHorizontalLayout) {
                i18 = totalHeightBefore - computeHorizontalScrollOffset();
                computeVerticalScrollOffset = 0;
            } else {
                computeVerticalScrollOffset = totalHeightBefore - computeVerticalScrollOffset();
            }
            doSmoothScrollBy(i18, computeVerticalScrollOffset, i17);
            postDispatchLayout();
            return;
        }
        scrollToPositionWithOffset(nodePositionInAdapter, 0);
        dispatchLayout();
    }

    public void scrollToTop() {
        if (HippyListUtils.isHorizontalLayout(this)) {
            smoothScrollBy(-getContentOffsetX(), 0);
        } else {
            smoothScrollBy(0, -getContentOffsetY());
        }
        postDispatchLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        this.listAdapter = (ADP) adapter;
        super.setAdapter(adapter);
    }

    public void setHeaderHost(IHeaderHost iHeaderHost) {
        this.headerHost = iHeaderHost;
    }

    public void setHippyEngineContext(HippyEngineContext hippyEngineContext) {
        this.hippyEngineContext = hippyEngineContext;
    }

    public void setInitialContentOffset(int i3) {
        this.mInitialContentOffset = i3;
    }

    public void setListData() {
        LogUtils.d("HippyRecyclerView", "itemCount =" + this.listAdapter.getItemCount());
        this.listAdapter.notifyDataSetChanged();
        if (this.isTvPlatform) {
            this.mFocusHelper.setListData();
        }
        int renderNodeCount = this.listAdapter.getRenderNodeCount();
        this.renderNodeCount = renderNodeCount;
        if (renderNodeCount > 0 && this.mInitialContentOffset > 0) {
            scrollToInitContentOffset();
        }
        dispatchLayout();
    }

    @Override // com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent
    public void setNestedScrollPriority(int i3, HippyNestedScrollComponent.Priority priority) {
        this.mNestedScrollPriority[i3] = priority;
    }

    public void setNodePositionHelper(NodePositionHelper nodePositionHelper) {
        this.nodePositionHelper = nodePositionHelper;
    }

    public void setOrientation(LinearLayoutManager linearLayoutManager) {
        this.layoutManager = linearLayoutManager;
    }

    public void setRowShouldSticky(boolean z16) {
        if (z16) {
            if (this.stickyHeaderHelper == null) {
                StickyHeaderHelper stickyHeaderHelper = new StickyHeaderHelper(this, this.listAdapter, this, this.headerHost);
                this.stickyHeaderHelper = stickyHeaderHelper;
                addOnScrollListener(stickyHeaderHelper);
                return;
            }
            return;
        }
        StickyHeaderHelper stickyHeaderHelper2 = this.stickyHeaderHelper;
        if (stickyHeaderHelper2 != null) {
            removeOnScrollListener(stickyHeaderHelper2);
        }
    }

    public void setScrollEnable(boolean z16) {
        this.isEnableScroll = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        super.stopNestedScroll();
        endPullRefresh();
    }

    @Override // android.view.View
    public String toString() {
        return getClass().getSimpleName() + "{renderNodeCount:" + this.renderNodeCount + ",state:" + getStateInfo() + "}";
    }

    public HippyRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isEnableScroll = true;
        this.renderNodeCount = 0;
        this.isTvPlatform = false;
        this.mFocusHelper = null;
        this.mScrollConsumedPair = new int[2];
        HippyNestedScrollComponent.Priority priority = HippyNestedScrollComponent.Priority.NOT_SET;
        this.mNestedScrollPriority = new HippyNestedScrollComponent.Priority[]{HippyNestedScrollComponent.Priority.SELF, priority, priority, priority, priority};
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        int[] iArr3 = this.mScrollConsumedPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i3, i16, iArr3, iArr2, i17);
        if (dispatchNestedPreScroll) {
            int[] iArr4 = this.mScrollConsumedPair;
            int i18 = iArr4[0];
            i3 -= i18;
            int i19 = iArr4[1];
            i16 -= i19;
            if (iArr != null) {
                iArr[0] = iArr[0] + i18;
                iArr[1] = iArr[1] + i19;
            }
        }
        return (i17 == 0 && handlePullRefresh(i3, i16, iArr)) || dispatchNestedPreScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public ADP getAdapter() {
        return this.listAdapter;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        HippyNestedScrollComponent.Priority priorityOfX = HippyNestedScrollHelper.priorityOfX(this, i3);
        HippyNestedScrollComponent.Priority priority = HippyNestedScrollComponent.Priority.NONE;
        int i18 = priorityOfX == priority ? 0 : i3;
        int i19 = HippyNestedScrollHelper.priorityOfY(this, i16) == priority ? 0 : i16;
        if (i18 != 0 || i19 != 0) {
            int[] iArr2 = this.mScrollConsumedPair;
            iArr2[0] = 0;
            iArr2[1] = 0;
            super.dispatchNestedPreScroll(i18, i19, iArr2, null, i17);
            int i26 = iArr[0];
            int[] iArr3 = this.mScrollConsumedPair;
            iArr[0] = i26 + iArr3[0];
            iArr[1] = iArr[1] + iArr3[1];
            i3 -= iArr3[0];
            i16 -= iArr3[1];
        }
        HippyNestedScrollComponent.Priority priorityOfX2 = HippyNestedScrollHelper.priorityOfX(view, i3);
        HippyNestedScrollComponent.Priority priority2 = HippyNestedScrollComponent.Priority.PARENT;
        if (priorityOfX2 == priority2 || HippyNestedScrollHelper.priorityOfY(view, i16) == priority2) {
            if (i17 == 0) {
                int[] iArr4 = this.mScrollConsumedPair;
                iArr4[0] = 0;
                iArr4[1] = 0;
                if (handlePullRefresh(i3, i16, iArr4)) {
                    int i27 = iArr[0];
                    int[] iArr5 = this.mScrollConsumedPair;
                    iArr[0] = i27 + iArr5[0];
                    iArr[1] = iArr[1] + iArr5[1];
                    i3 -= iArr5[0];
                    i16 -= iArr5[1];
                }
            } else if (isPullRefreshShowing()) {
                iArr[0] = iArr[0] + i3;
                iArr[1] = iArr[1] + i16;
                return;
            }
        }
        int computeHorizontallyScrollDistance = HippyNestedScrollHelper.priorityOfX(view, i3) == priority2 ? computeHorizontallyScrollDistance(i3) : 0;
        int computeVerticallyScrollDistance = HippyNestedScrollHelper.priorityOfY(view, i16) == priority2 ? computeVerticallyScrollDistance(i16) : 0;
        if (computeHorizontallyScrollDistance == 0 && computeVerticallyScrollDistance == 0) {
            return;
        }
        iArr[0] = iArr[0] + computeHorizontallyScrollDistance;
        iArr[1] = iArr[1] + computeVerticallyScrollDistance;
        scrollBy(computeHorizontallyScrollDistance, computeVerticallyScrollDistance);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
        if (i19 == 0) {
            HippyNestedScrollComponent.Priority priorityOfX = HippyNestedScrollHelper.priorityOfX(view, i17);
            HippyNestedScrollComponent.Priority priority = HippyNestedScrollComponent.Priority.SELF;
            if (priorityOfX == priority || HippyNestedScrollHelper.priorityOfY(view, i18) == priority) {
                int[] iArr = this.mScrollConsumedPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (handlePullRefresh(i17, i18, iArr)) {
                    int[] iArr2 = this.mScrollConsumedPair;
                    int i26 = iArr2[0];
                    i3 += i26;
                    int i27 = iArr2[1];
                    i16 += i27;
                    i17 -= i26;
                    i18 -= i27;
                }
            }
        } else if (isPullRefreshShowing()) {
            return;
        }
        HippyNestedScrollComponent.Priority priorityOfX2 = HippyNestedScrollHelper.priorityOfX(view, i17);
        HippyNestedScrollComponent.Priority priority2 = HippyNestedScrollComponent.Priority.SELF;
        int computeHorizontallyScrollDistance = priorityOfX2 == priority2 ? computeHorizontallyScrollDistance(i17) : 0;
        int computeVerticallyScrollDistance = HippyNestedScrollHelper.priorityOfY(view, i18) == priority2 ? computeVerticallyScrollDistance(i18) : 0;
        if (computeHorizontallyScrollDistance != 0 || computeVerticallyScrollDistance != 0) {
            scrollBy(computeHorizontallyScrollDistance, computeVerticallyScrollDistance);
            i3 += computeHorizontallyScrollDistance;
            i16 += computeVerticallyScrollDistance;
            i17 -= computeHorizontallyScrollDistance;
            i18 -= computeVerticallyScrollDistance;
        }
        int i28 = i3;
        int i29 = i16;
        HippyNestedScrollComponent.Priority priorityOfX3 = HippyNestedScrollHelper.priorityOfX(this, i17);
        HippyNestedScrollComponent.Priority priority3 = HippyNestedScrollComponent.Priority.NONE;
        int i36 = priorityOfX3 == priority3 ? 0 : i17;
        int i37 = HippyNestedScrollHelper.priorityOfY(this, i18) == priority3 ? 0 : i18;
        if (i36 == 0 && i37 == 0) {
            return;
        }
        dispatchNestedScroll(i28, i29, i36, i37, null, i19);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        startNestedScroll(i16 == 0 ? this.mNestedScrollAxesTouch : this.mNestedScrollAxesNonTouch, i16);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        RecyclerView.LayoutManager layoutManager;
        if (!this.isEnableScroll || (layoutManager = getLayoutManager()) == null) {
            return false;
        }
        int i17 = (!layoutManager.canScrollVertically() || (i3 & 2) == 0) ? 0 : 2;
        if (layoutManager.canScrollHorizontally() && (i3 & 1) != 0) {
            i17 |= 1;
        }
        if (i17 == 0) {
            return false;
        }
        if (i16 == 0) {
            this.mNestedScrollAxesTouch = i17;
        } else {
            this.mNestedScrollAxesNonTouch = i17;
        }
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        if (i3 == 0) {
            this.mNestedScrollAxesTouch = 0;
        } else {
            this.mNestedScrollAxesNonTouch = 0;
        }
        stopNestedScroll(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        super.stopNestedScroll(i3);
        if (i3 == 0) {
            endPullRefresh();
        }
    }

    public HippyRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isEnableScroll = true;
        this.renderNodeCount = 0;
        this.isTvPlatform = false;
        this.mFocusHelper = null;
        this.mScrollConsumedPair = new int[2];
        HippyNestedScrollComponent.Priority priority = HippyNestedScrollComponent.Priority.NOT_SET;
        this.mNestedScrollPriority = new HippyNestedScrollComponent.Priority[]{HippyNestedScrollComponent.Priority.SELF, priority, priority, priority, priority};
    }
}
