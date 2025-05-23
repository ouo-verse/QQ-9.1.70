package com.tencent.mtt.hippy.views.list;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.uimanager.j;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyListAdapter extends RecyclerAdapter implements IRecycleItemTypeChange {
    protected final HippyEngineContext mHippyContext;
    ArrayList<RecyclerViewBase.ViewHolder> mListViewHolder;
    private int mPreloadItemNum;
    private RecyclerViewBase.Recycler mRecycler;
    private HippyViewEvent onEndReachedEvent;
    private HippyViewEvent onLoadMoreEvent;

    public HippyListAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        super(recyclerView);
        this.mPreloadItemNum = 0;
        this.mHippyContext = hippyEngineContext;
    }

    private void checkHolderType(int i3, int i16, ListItemRenderNode listItemRenderNode) {
        RecyclerViewBase.ViewHolderArrayList viewHolderArrayList;
        int childCount = this.mParentRecyclerView.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            RecyclerView recyclerView = this.mParentRecyclerView;
            RecyclerViewBase.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i17));
            if (childViewHolder.getItemViewType() == i3) {
                ContentHolder contentHolder = childViewHolder.mContentHolder;
                if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == listItemRenderNode) {
                    childViewHolder.setItemViewType(i16);
                    return;
                }
            }
        }
        int size = this.mRecycler.mAttachedScrap.size();
        for (int i18 = 0; i18 < size; i18++) {
            RecyclerViewBase.ViewHolder viewHolder = this.mRecycler.mAttachedScrap.get(i18);
            if (viewHolder.getItemViewType() == i3) {
                ContentHolder contentHolder2 = viewHolder.mContentHolder;
                if ((contentHolder2 instanceof NodeHolder) && ((NodeHolder) contentHolder2).mBindNode == listItemRenderNode) {
                    viewHolder.setItemViewType(i16);
                    return;
                }
            }
        }
        int size2 = this.mRecycler.mCachedViews.size();
        for (int i19 = 0; i19 < size2; i19++) {
            RecyclerViewBase.ViewHolder viewHolder2 = this.mRecycler.mCachedViews.get(i19);
            if (viewHolder2.getItemViewType() == i3) {
                ContentHolder contentHolder3 = viewHolder2.mContentHolder;
                if ((contentHolder3 instanceof NodeHolder) && ((NodeHolder) contentHolder3).mBindNode == listItemRenderNode) {
                    viewHolder2.setItemViewType(i16);
                    return;
                }
            }
        }
        if (this.mRecycler.getRecycledViewPool() != null && (viewHolderArrayList = this.mRecycler.getRecycledViewPool().mScrap.get(i3)) != null && !viewHolderArrayList.isEmpty()) {
            Iterator it = viewHolderArrayList.iterator();
            while (it.hasNext()) {
                RecyclerViewBase.ViewHolder viewHolder3 = (RecyclerViewBase.ViewHolder) it.next();
                if (viewHolder3.getItemViewType() == i3) {
                    ContentHolder contentHolder4 = viewHolder3.mContentHolder;
                    if ((contentHolder4 instanceof NodeHolder) && ((NodeHolder) contentHolder4).mBindNode == listItemRenderNode) {
                        viewHolder3.setItemViewType(i16);
                        viewHolderArrayList.remove(viewHolder3);
                        this.mRecycler.getRecycledViewPool().getScrapHeapForType(i16).add(viewHolder3);
                        return;
                    }
                }
            }
        }
    }

    private RecyclerViewBase.ViewHolder getRecycledViewFromPoolInner(RecyclerViewBase.RecycledViewPool recycledViewPool, int i3, int i16) {
        RecyclerViewBase.ViewHolderArrayList viewHolderArrayList;
        if (recycledViewPool != null && (viewHolderArrayList = recycledViewPool.mScrap.get(i3)) != null && !viewHolderArrayList.isEmpty()) {
            Iterator it = viewHolderArrayList.iterator();
            while (it.hasNext()) {
                RecyclerViewBase.ViewHolder viewHolder = (RecyclerViewBase.ViewHolder) it.next();
                if (viewHolder.getItemViewType() == i3) {
                    ContentHolder contentHolder = viewHolder.mContentHolder;
                    if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i16)) {
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
        if (this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()) == null || this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildCount() <= i3) {
            return null;
        }
        int size = recycler.mAttachedScrap.size();
        for (int i17 = 0; i17 < size; i17++) {
            RecyclerViewBase.ViewHolder viewHolder = recycler.mAttachedScrap.get(i17);
            if (viewHolder.getPosition() == i3 && !viewHolder.isInvalid() && !viewHolder.isRemoved() && viewHolder.getItemViewType() == i16) {
                ContentHolder contentHolder = viewHolder.mContentHolder;
                if ((contentHolder instanceof NodeHolder) && ((NodeHolder) contentHolder).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3)) {
                    recycler.mAttachedScrap.remove(i17);
                    viewHolder.setScrapContainer(null);
                    return viewHolder;
                }
            }
        }
        int size2 = recycler.mCachedViews.size();
        for (int i18 = 0; i18 < size2; i18++) {
            RecyclerViewBase.ViewHolder viewHolder2 = recycler.mCachedViews.get(i18);
            if (viewHolder2.getPosition() == i3 && viewHolder2.getItemViewType() == i16 && !viewHolder2.isInvalid()) {
                ContentHolder contentHolder2 = viewHolder2.mContentHolder;
                if ((contentHolder2 instanceof NodeHolder) && ((NodeHolder) contentHolder2).mBindNode == this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3)) {
                    recycler.mCachedViews.remove(i18);
                    return viewHolder2;
                }
            }
        }
        return getRecycledViewFromPoolInner(recycler.getRecycledViewPool(), i16, i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public RecyclerViewBase.ViewHolder findBestHolderForPosition(int i3, RecyclerViewBase.Recycler recycler) {
        LogUtils.d("HippyListView", "findBestHolderForPosition start : " + i3);
        this.mRecycler = recycler;
        RecyclerViewBase.ViewHolder findBestHolderRecursive = findBestHolderRecursive(i3, getItemViewType(i3), recycler);
        LogUtils.d("HippyListView", "findBestHolderForPosition end : " + i3);
        return findBestHolderRecursive;
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

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public RecyclerViewBase.ViewHolder findSuspendHolderForPosition(int i3, RecyclerViewBase.Recycler recycler) {
        this.mRecycler = recycler;
        RecyclerViewBase.ViewHolder scrapViewForPositionInner = getScrapViewForPositionInner(i3, getItemViewType(i3), recycler);
        if (scrapViewForPositionInner != null && ((NodeHolder) scrapViewForPositionInner.mContentHolder).mBindNode.isDelete()) {
            return null;
        }
        return scrapViewForPositionInner;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomFooterViewHeight() {
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > 0) {
            RenderNode childAt = renderNode.getChildAt(renderNode.getChildCount() - 1);
            if (childAt instanceof i) {
                return childAt.getHeight();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomFooterViewWidth() {
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > 0) {
            RenderNode childAt = renderNode.getChildAt(renderNode.getChildCount() - 1);
            if (childAt instanceof i) {
                return childAt.getWidth();
            }
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomHeaderViewHeight() {
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > 0) {
            RenderNode childAt = renderNode.getChildAt(0);
            if (childAt instanceof j) {
                return childAt.getHeight();
            }
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomHeaderViewWidth() {
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > 0) {
            RenderNode childAt = renderNode.getChildAt(0);
            if (childAt instanceof j) {
                return childAt.getWidth();
            }
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemCount() {
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null) {
            return renderNode.getChildCount();
        }
        return super.getItemCount();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemHeight(int i3) {
        RenderNode childAt;
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > i3 && i3 >= 0 && (childAt = renderNode.getChildAt(i3)) != null) {
            return childAt.getHeight();
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemViewType(int i3) {
        RenderNode childAt;
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > i3 && (childAt = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3)) != null) {
            if (childAt instanceof i) {
                return -5;
            }
            if (childAt instanceof j) {
                return -4;
            }
            if (childAt.getProps() != null) {
                HippyMap props = childAt.getProps();
                if (props.get("type") != null) {
                    return props.getInt("type");
                }
            }
        }
        return super.getItemViewType(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    public int getItemWidth(int i3) {
        RenderNode childAt;
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > i3 && i3 >= 0 && (childAt = renderNode.getChildAt(i3)) != null) {
            return childAt.getWidth();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyViewEvent getOnEndReachedEvent() {
        if (this.onEndReachedEvent == null) {
            this.onEndReachedEvent = new HippyViewEvent("onEndReached");
        }
        return this.onEndReachedEvent;
    }

    protected HippyViewEvent getOnLoadMoreEvent() {
        if (this.onLoadMoreEvent == null) {
            this.onLoadMoreEvent = new HippyViewEvent("onLoadMore");
        }
        return this.onLoadMoreEvent;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getRecyclerItemView(int i3) {
        if (i3 < this.mListViewHolder.size()) {
            return this.mListViewHolder.get(i3).mContent;
        }
        return this.mParentRecyclerView.getChildAt(i3 - this.mListViewHolder.size());
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getTotalHeight() {
        int customFooterViewHeight;
        int itemMaigin;
        int i3;
        if (isAutoCalculateItemHeight()) {
            this.mContentHeight = -1;
        }
        if (this.mContentHeight == -1) {
            int itemCount = getItemCount();
            this.mContentHeight = 0;
            if (this.mParentRecyclerView.mLayoutType == 1) {
                for (int i16 = 0; i16 < itemCount; i16++) {
                    if (this.mParentRecyclerView.mLayout.canScrollHorizontally()) {
                        int itemWidth = this.mContentHeight + getItemWidth(i16);
                        this.mContentHeight = itemWidth;
                        itemMaigin = itemWidth + getItemMaigin(0, i16);
                        this.mContentHeight = itemMaigin;
                        i3 = 2;
                    } else {
                        int itemHeight = this.mContentHeight + getItemHeight(i16);
                        this.mContentHeight = itemHeight;
                        itemMaigin = itemHeight + getItemMaigin(1, i16);
                        this.mContentHeight = itemMaigin;
                        i3 = 3;
                    }
                    this.mContentHeight = itemMaigin + getItemMaigin(i3, i16);
                }
            }
        }
        if (this.mParentRecyclerView.mLayout.canScrollHorizontally()) {
            customFooterViewHeight = getCustomFooterViewWidth();
        } else {
            customFooterViewHeight = getCustomFooterViewHeight();
        }
        return this.mContentHeight - customFooterViewHeight;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public String getViewHolderReUseKey(int i3) {
        if (i3 >= 0 && i3 <= getItemCount()) {
            return String.valueOf(i3);
        }
        return null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public boolean hasCustomRecycler() {
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    public boolean isAutoCalculateItemHeight() {
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public boolean isSuspentedItem(int i3) {
        RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId());
        if (renderNode != null && renderNode.getChildCount() > i3) {
            RenderNode childAt = renderNode.getChildAt(i3);
            if (childAt instanceof ListItemRenderNode) {
                return ((ListItemRenderNode) childAt).shouldSticky();
            }
        }
        return super.isSuspentedItem(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyEndReached() {
        getOnEndReachedEvent().send(this.mParentRecyclerView, null);
        getOnLoadMoreEvent().send(this.mParentRecyclerView, null);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    public void onBindContentView(ContentHolder contentHolder, int i3, int i16) {
        RenderNode renderNode;
        NodeHolder nodeHolder = (NodeHolder) contentHolder;
        if (nodeHolder.isCreated) {
            nodeHolder.mBindNode.updateViewRecursive();
            nodeHolder.isCreated = false;
        } else {
            nodeHolder.mBindNode.setLazy(true);
            try {
                renderNode = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3);
            } catch (Throwable th5) {
                LogUtils.d("HippyListAdapter", "onBindContentView: " + th5.getMessage());
                renderNode = null;
            }
            if (renderNode == null) {
                return;
            }
            renderNode.setLazy(false);
            ArrayList<DiffUtils.PatchType> diff = DiffUtils.diff(nodeHolder.mBindNode, renderNode);
            DiffUtils.deleteViews(this.mHippyContext.getRenderManager().getControllerManager(), diff);
            DiffUtils.replaceIds(this.mHippyContext.getRenderManager().getControllerManager(), diff);
            DiffUtils.createView(diff);
            DiffUtils.doPatch(this.mHippyContext.getRenderManager().getControllerManager(), diff);
            nodeHolder.mBindNode = renderNode;
        }
        RenderNode renderNode2 = nodeHolder.mBindNode;
        if (renderNode2 instanceof ListItemRenderNode) {
            ((ListItemRenderNode) renderNode2).a(this);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter
    public ContentHolder onCreateContentViewWithPos(ViewGroup viewGroup, int i3, int i16) {
        NodeHolder nodeHolder = new NodeHolder();
        RenderNode childAt = this.mHippyContext.getRenderManager().getRenderNode(this.mParentRecyclerView.getId()).getChildAt(i3);
        childAt.setLazy(false);
        View createViewRecursive = childAt.createViewRecursive();
        nodeHolder.mContentView = createViewRecursive;
        if (createViewRecursive instanceof HippyPullHeaderView) {
            ((HippyPullHeaderView) createViewRecursive).setRecyclerView(this.mParentRecyclerView);
        }
        if (createViewRecursive instanceof HippyPullFooterView) {
            ((HippyPullFooterView) createViewRecursive).setRecyclerView(this.mParentRecyclerView);
        }
        nodeHolder.mBindNode = childAt;
        nodeHolder.isCreated = true;
        return nodeHolder;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public RecyclerView.ViewHolderWrapper onCreateSuspendViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
        return null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onPreload() {
        getOnEndReachedEvent().send(this.mParentRecyclerView, null);
        getOnLoadMoreEvent().send(this.mParentRecyclerView, null);
    }

    @Override // com.tencent.mtt.hippy.views.list.IRecycleItemTypeChange
    public void onRecycleItemTypeChanged(int i3, int i16, ListItemRenderNode listItemRenderNode) {
        checkHolderType(i3, i16, listItemRenderNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onViewAbandon(RecyclerView.ViewHolderWrapper viewHolderWrapper) {
        NodeHolder nodeHolder = (NodeHolder) viewHolderWrapper.mContentHolder;
        RenderNode renderNode = nodeHolder.mBindNode;
        if (renderNode != null && !renderNode.isDelete()) {
            nodeHolder.mBindNode.setLazy(true);
            RenderNode parent = nodeHolder.mBindNode.getParent();
            if (parent != null) {
                this.mHippyContext.getRenderManager().getControllerManager().deleteChild(parent.getId(), nodeHolder.mBindNode.getId());
            }
        }
        RenderNode renderNode2 = nodeHolder.mBindNode;
        if (renderNode2 instanceof ListItemRenderNode) {
            ((ListItemRenderNode) renderNode2).a((IRecycleItemTypeChange) null);
        }
        super.onViewAbandon(viewHolderWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPreloadItemNumber(int i3) {
        this.mPreloadItemNum = i3;
    }
}
