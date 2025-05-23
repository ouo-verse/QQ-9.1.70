package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.HippyItemTypeHelper;
import androidx.recyclerview.widget.ItemLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.uimanager.j;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IStickyItemsProvider;
import com.tencent.mtt.hippy.views.hippylistpager.HippyRecyclerPagerView;
import com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRecyclerListAdapter<HRCV extends HippyRecyclerView> extends RecyclerView.Adapter<HippyRecyclerViewHolder> implements ItemLayoutParams, IStickyItemsProvider, IRecycleItemTypeChange {
    private static final int STICK_ITEM_VIEW_TYPE_BASE = -100000;
    protected PullFooterRefreshHelper footerRefreshHelper;
    protected PullHeaderRefreshHelper headerRefreshHelper;
    protected final HippyItemTypeHelper hippyItemTypeHelper;
    protected final HRCV hippyRecyclerView;
    protected final HippyEngineContext hpContext;
    protected int positionToCreateHolder;

    public HippyRecyclerListAdapter(HRCV hrcv, HippyEngineContext hippyEngineContext) {
        this.hpContext = hippyEngineContext;
        this.hippyRecyclerView = hrcv;
        this.hippyItemTypeHelper = new HippyItemTypeHelper(hrcv);
    }

    private int getHippyListViewId() {
        if (this.hippyRecyclerView.getParent() != null) {
            return ((View) this.hippyRecyclerView.getParent()).getId();
        }
        return 0;
    }

    private void initFooterRefreshHelper(View view, RenderNode renderNode) {
        if (this.footerRefreshHelper == null) {
            this.footerRefreshHelper = new PullFooterRefreshHelper(this.hippyRecyclerView, renderNode);
        }
        this.footerRefreshHelper.setItemView(view);
    }

    private void initHeaderRefreshHelper(View view, RenderNode renderNode) {
        if (this.headerRefreshHelper == null) {
            this.headerRefreshHelper = new PullHeaderRefreshHelper(this.hippyRecyclerView, renderNode);
        }
        this.headerRefreshHelper.setItemView(view);
    }

    private boolean isPullHeader(int i3) {
        if (i3 != 0) {
            return false;
        }
        return getChildNodeByAdapterPosition(0).c();
    }

    protected View createRenderView(ListItemRenderNode listItemRenderNode) {
        if (listItemRenderNode.d() && !listItemRenderNode.shouldSticky()) {
            deleteExistRenderView(listItemRenderNode);
        }
        listItemRenderNode.setLazy(false);
        View createViewRecursive = listItemRenderNode.createViewRecursive();
        listItemRenderNode.updateViewRecursive();
        return createViewRecursive;
    }

    public void deleteExistRenderView(ListItemRenderNode listItemRenderNode) {
        listItemRenderNode.setLazy(true);
        RenderNode parentNode = getParentNode();
        if (parentNode != null) {
            this.hpContext.getRenderManager().getControllerManager().deleteChild(parentNode.getId(), listItemRenderNode.getId());
        } else {
            this.hpContext.getRenderManager().getControllerManager().b(listItemRenderNode.getId());
        }
        listItemRenderNode.a((IRecycleItemTypeChange) null);
    }

    public void enableHeaderRefresh() {
        PullHeaderRefreshHelper pullHeaderRefreshHelper = this.headerRefreshHelper;
        if (pullHeaderRefreshHelper != null) {
            pullHeaderRefreshHelper.enableRefresh();
        }
    }

    String getAttachedIds() {
        StringBuilder sb5 = new StringBuilder();
        int childCount = this.hippyRecyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.hippyRecyclerView.getChildAt(i3);
            sb5.append("|p_" + this.hippyRecyclerView.getChildAdapterPosition(childAt));
            sb5.append("_i_" + childAt.getId());
        }
        return sb5.toString();
    }

    public ListItemRenderNode getChildNode(int i3) {
        RenderNode parentNode = getParentNode();
        if (parentNode != null && i3 < parentNode.getChildCount() && i3 >= 0) {
            return (ListItemRenderNode) parentNode.getChildAt(i3);
        }
        return null;
    }

    public ListItemRenderNode getChildNodeByAdapterPosition(int i3) {
        return getChildNode(this.hippyRecyclerView.getNodePositionHelper().getRenderNodePosition(i3));
    }

    public int getFooterVisibleHeight() {
        PullFooterRefreshHelper pullFooterRefreshHelper = this.footerRefreshHelper;
        if (pullFooterRefreshHelper != null) {
            return pullFooterRefreshHelper.getVisibleHeight();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getRenderNodeCount();
    }

    public int getItemCountExceptHeaderAndFooter() {
        int renderNodeCount = getRenderNodeCount();
        if (hasPullHeader()) {
            renderNodeCount--;
        }
        if (hasPullFooter()) {
            return renderNodeCount - 1;
        }
        return renderNodeCount;
    }

    public int getItemHeight(int i3) {
        Integer valueOf = Integer.valueOf(getRenderNodeHeight(i3));
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return getChildNodeByAdapterPosition(i3).getId();
    }

    @Override // androidx.recyclerview.widget.ItemLayoutParams
    public void getItemLayoutParams(int i3, RecyclerView.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).height = getItemHeight(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        setPositionToCreate(i3);
        ListItemRenderNode childNodeByAdapterPosition = getChildNodeByAdapterPosition(i3);
        if (childNodeByAdapterPosition == null) {
            return 0;
        }
        if (childNodeByAdapterPosition.shouldSticky()) {
            return (-100000) - i3;
        }
        return childNodeByAdapterPosition.a();
    }

    public int getItemWidth(int i3) {
        Integer valueOf = Integer.valueOf(getRenderNodeWidth(i3));
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    protected RecyclerView.LayoutParams getLayoutParams(View view) {
        RecyclerView.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof RecyclerView.LayoutParams) {
            layoutParams = (RecyclerView.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            return new RecyclerView.LayoutParams(-1, 0);
        }
        return layoutParams;
    }

    protected RenderNode getParentNode() {
        return this.hpContext.getRenderManager().getRenderNode(getHippyListViewId());
    }

    public int getRenderNodeCount() {
        RenderNode parentNode = getParentNode();
        if (parentNode != null) {
            return parentNode.getChildCount();
        }
        return 0;
    }

    public int getRenderNodeHeight(int i3) {
        ListItemRenderNode childNode = getChildNode(i3);
        if (childNode == null) {
            return 0;
        }
        if (childNode.c()) {
            PullHeaderRefreshHelper pullHeaderRefreshHelper = this.headerRefreshHelper;
            if (pullHeaderRefreshHelper == null) {
                return 0;
            }
            return pullHeaderRefreshHelper.getVisibleHeight();
        }
        if (childNode.b()) {
            PullFooterRefreshHelper pullFooterRefreshHelper = this.footerRefreshHelper;
            if (pullFooterRefreshHelper == null) {
                return 0;
            }
            return pullFooterRefreshHelper.getVisibleHeight();
        }
        return childNode.getHeight();
    }

    public int getRenderNodeTotalHeight() {
        int renderNodeCount = getRenderNodeCount();
        int i3 = 0;
        for (int i16 = 0; i16 < renderNodeCount; i16++) {
            i3 += getRenderNodeHeight(i16);
        }
        return i3;
    }

    public int getRenderNodeWidth(int i3) {
        ListItemRenderNode childNode = getChildNode(i3);
        if (childNode == null) {
            return 0;
        }
        if (childNode.c()) {
            PullHeaderRefreshHelper pullHeaderRefreshHelper = this.headerRefreshHelper;
            if (pullHeaderRefreshHelper == null) {
                return 0;
            }
            return pullHeaderRefreshHelper.getVisibleWidth();
        }
        if (childNode.b()) {
            PullFooterRefreshHelper pullFooterRefreshHelper = this.footerRefreshHelper;
            if (pullFooterRefreshHelper == null) {
                return 0;
            }
            return pullFooterRefreshHelper.getVisibleWidth();
        }
        return childNode.getWidth();
    }

    public boolean hasPullFooter() {
        if (this.footerRefreshHelper != null) {
            return true;
        }
        return false;
    }

    public boolean hasPullHeader() {
        if (this.headerRefreshHelper != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IStickyItemsProvider
    public boolean isStickyPosition(int i3) {
        if (i3 >= 0 && i3 < getItemCount()) {
            return getChildNodeByAdapterPosition(i3).shouldSticky();
        }
        return false;
    }

    public void onFooterDestroy() {
        PullFooterRefreshHelper pullFooterRefreshHelper = this.footerRefreshHelper;
        if (pullFooterRefreshHelper != null) {
            pullFooterRefreshHelper.onDestroy();
            this.footerRefreshHelper = null;
        }
    }

    public void onFooterRefreshCompleted() {
        int i3;
        PullFooterRefreshHelper pullFooterRefreshHelper = this.footerRefreshHelper;
        if (pullFooterRefreshHelper != null) {
            if (this.hippyRecyclerView instanceof HippyRecyclerPagerView) {
                i3 = 0;
            } else {
                i3 = 200;
            }
            pullFooterRefreshHelper.onRefreshCompleted(i3);
        }
    }

    public void onHeaderDestroy() {
        PullHeaderRefreshHelper pullHeaderRefreshHelper = this.headerRefreshHelper;
        if (pullHeaderRefreshHelper != null) {
            pullHeaderRefreshHelper.onDestroy();
            this.headerRefreshHelper = null;
        }
    }

    public void onHeaderRefreshCompleted() {
        PullHeaderRefreshHelper pullHeaderRefreshHelper = this.headerRefreshHelper;
        if (pullHeaderRefreshHelper != null) {
            pullHeaderRefreshHelper.onRefreshCompleted(200);
        }
    }

    public void onLayoutOrientationChanged() {
        PullHeaderRefreshHelper pullHeaderRefreshHelper = this.headerRefreshHelper;
        if (pullHeaderRefreshHelper != null) {
            pullHeaderRefreshHelper.onLayoutOrientationChanged();
        }
        PullFooterRefreshHelper pullFooterRefreshHelper = this.footerRefreshHelper;
        if (pullFooterRefreshHelper != null) {
            pullFooterRefreshHelper.onLayoutOrientationChanged();
        }
        this.hippyRecyclerView.enableOverPullIfNeeded();
    }

    @Override // com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange
    public void onRecycleItemTypeChanged(int i3, int i16, ListItemRenderNode listItemRenderNode) {
        this.hippyItemTypeHelper.updateItemType(i3, i16, listItemRenderNode);
    }

    protected void setLayoutParams(View view, int i3) {
        int i16;
        RecyclerView.LayoutParams layoutParams = getLayoutParams(view);
        ListItemRenderNode childNodeByAdapterPosition = getChildNodeByAdapterPosition(i3);
        if (!(childNodeByAdapterPosition instanceof i) && !(childNodeByAdapterPosition instanceof j)) {
            if (HippyListUtils.isLinearLayout(this.hippyRecyclerView)) {
                boolean isVerticalLayout = HippyListUtils.isVerticalLayout(this.hippyRecyclerView);
                int i17 = -1;
                if (isVerticalLayout) {
                    i16 = childNodeByAdapterPosition.getHeight();
                } else {
                    i16 = -1;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).height = i16;
                if (!isVerticalLayout) {
                    i17 = childNodeByAdapterPosition.getWidth();
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).width = i17;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = childNodeByAdapterPosition.getHeight();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = childNodeByAdapterPosition.getWidth();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    protected void setPositionToCreate(int i3) {
        this.positionToCreateHolder = i3;
    }

    public String toString() {
        return "HippyRecyclerAdapter: itemCount:" + getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HippyRecyclerViewHolder hippyRecyclerViewHolder, int i3) {
        setLayoutParams(hippyRecyclerViewHolder.itemView, i3);
        ListItemRenderNode listItemRenderNode = hippyRecyclerViewHolder.bindNode;
        ListItemRenderNode childNodeByAdapterPosition = getChildNodeByAdapterPosition(i3);
        listItemRenderNode.setLazy(true);
        childNodeByAdapterPosition.setLazy(false);
        if (listItemRenderNode != childNodeByAdapterPosition) {
            ArrayList<DiffUtils.PatchType> diff = DiffUtils.diff(listItemRenderNode, childNodeByAdapterPosition);
            DiffUtils.deleteViews(this.hpContext.getRenderManager().getControllerManager(), diff);
            DiffUtils.replaceIds(this.hpContext.getRenderManager().getControllerManager(), diff);
            DiffUtils.createView(diff);
            DiffUtils.doPatch(this.hpContext.getRenderManager().getControllerManager(), diff);
        }
        childNodeByAdapterPosition.a(this);
        hippyRecyclerViewHolder.bindNode = childNodeByAdapterPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public HippyRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        ListItemRenderNode childNodeByAdapterPosition = getChildNodeByAdapterPosition(this.positionToCreateHolder);
        boolean f16 = childNodeByAdapterPosition.f();
        boolean d16 = childNodeByAdapterPosition.d();
        View createRenderView = createRenderView(childNodeByAdapterPosition);
        if (isPullHeader(this.positionToCreateHolder)) {
            ((HippyPullHeaderView) createRenderView).setRecyclerView(this.hippyRecyclerView);
            initHeaderRefreshHelper(createRenderView, childNodeByAdapterPosition);
            return new HippyRecyclerViewHolder(this.headerRefreshHelper.getView(), childNodeByAdapterPosition);
        }
        if (createRenderView instanceof HippyPullFooterView) {
            ((HippyPullFooterView) createRenderView).setRecyclerView(this.hippyRecyclerView);
            initFooterRefreshHelper(createRenderView, childNodeByAdapterPosition);
            return new HippyRecyclerViewHolder(this.footerRefreshHelper.getView(), childNodeByAdapterPosition);
        }
        if (isStickyPosition(this.positionToCreateHolder)) {
            return new HippyRecyclerViewHolder(this.hippyRecyclerView.getStickyContainer(viewGroup.getContext(), createRenderView), childNodeByAdapterPosition);
        }
        if (createRenderView != null) {
            return new HippyRecyclerViewHolder(createRenderView, childNodeByAdapterPosition);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("createRenderView error!,isDelete:");
        sb5.append(childNodeByAdapterPosition.isDelete());
        sb5.append(",isViewExist:");
        sb5.append(f16);
        sb5.append(",needsDelete:");
        sb5.append(d16);
        sb5.append(",className:");
        sb5.append(childNodeByAdapterPosition.getClassName());
        sb5.append(",isLazy :");
        sb5.append(childNodeByAdapterPosition.isIsLazyLoad());
        sb5.append(",itemCount :");
        sb5.append(getItemCount());
        sb5.append(",getNodeCount:");
        sb5.append(getRenderNodeCount());
        sb5.append(",notifyCount:");
        sb5.append(this.hippyRecyclerView.renderNodeCount);
        sb5.append("curPos:");
        sb5.append(this.positionToCreateHolder);
        sb5.append(",rootView:");
        sb5.append(childNodeByAdapterPosition.g());
        sb5.append(",parentNode:");
        sb5.append(childNodeByAdapterPosition.getParent() != null);
        sb5.append(",offset:");
        sb5.append(this.hippyRecyclerView.computeVerticalScrollOffset());
        sb5.append(",range:");
        sb5.append(this.hippyRecyclerView.computeVerticalScrollRange());
        sb5.append(",extent:");
        sb5.append(this.hippyRecyclerView.computeVerticalScrollExtent());
        sb5.append(",viewType:");
        sb5.append(i3);
        sb5.append(",id:");
        sb5.append(childNodeByAdapterPosition.getId());
        sb5.append(",attachedIds:");
        sb5.append(getAttachedIds());
        sb5.append(",nodeOffset:");
        sb5.append(this.hippyRecyclerView.getNodePositionHelper().getNodeOffset());
        sb5.append(",view:");
        sb5.append(this.hippyRecyclerView);
        throw new IllegalArgumentException(sb5.toString());
    }
}
