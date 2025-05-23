package com.tencent.biz.richframework.part.block;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.ViewHolderHelper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.biz.richframework.part.utils.LayoutManagerUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class BlockMerger extends PullLoadMoreAdapter<MultiViewBlock> {
    private BlockContainer mBlockContainer;
    private BlockPart mBlockPart;
    private RecyclerView.ViewHolder mDefaultViewHolder;
    private final SparseIntArray mViewTypes = new SparseIntArray();
    private final SparseIntArray mFixViewTypes = new SparseIntArray();
    private final Map<String, MultiViewBlock> mUniqueKeyMap = new ConcurrentHashMap();
    private int mSafeTryToLoadMoreCount = 0;
    private int mSafeRetryMaxCount = 0;
    private final ViewTreeObserver.OnGlobalLayoutListener mTryTooLoadMoreListener = new BlockViewTreeListener();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class BlockViewTreeListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<BlockMerger> mBlockMerger;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            BlockMerger blockMerger = this.mBlockMerger.get();
            if (blockMerger != null) {
                blockMerger.triggerAutoLoadMore();
            }
        }

        BlockViewTreeListener(BlockMerger blockMerger) {
            this.mBlockMerger = new WeakReference<>(blockMerger);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class PtrDefaultViewHolder extends RecyclerView.ViewHolder {
        public PtrDefaultViewHolder(View view) {
            super(view);
        }
    }

    public BlockMerger(BlockContainer blockContainer) {
        this.mBlockContainer = blockContainer;
        setHasStableIds(true);
    }

    private boolean checkIsInValidRetry() {
        int i3 = this.mSafeTryToLoadMoreCount;
        if (i3 != 0 && i3 >= this.mSafeRetryMaxCount) {
            return true;
        }
        return false;
    }

    private void checkStaggeredFullSpan(RecyclerView.ViewHolder viewHolder, MultiViewBlock multiViewBlock, ViewGroup.LayoutParams layoutParams) {
        if (multiViewBlock.getSpanCount(viewHolder.getLayoutPosition() - multiViewBlock.getPositionOffsetStart()) == 1) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    private int getBlockViewType(int i3, int i16) {
        if (i16 != 0) {
            return i3 - ((MultiViewBlock) this.mDataList.get(i16)).getViewTypeOffsetStart();
        }
        return i3;
    }

    private int initViewType(int i3, int i16, MultiViewBlock multiViewBlock, int i17) {
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null && blockContainer.isEnablePageRecyclerViewPool()) {
            int fixedViewTypeOffset = multiViewBlock.getFixedViewTypeOffset() + i17;
            multiViewBlock.setViewTypeOffset(multiViewBlock.getFixedViewTypeOffset());
            return fixedViewTypeOffset;
        }
        if (i17 >= 0) {
            i17 += i3;
        }
        multiViewBlock.setViewTypeOffset(i3);
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBlockChange(MultiViewBlock multiViewBlock, int i3) {
        Iterator it = this.mDataList.iterator();
        while (it.hasNext()) {
            ((MultiViewBlock) it.next()).handleBlockChange(multiViewBlock, i3);
        }
    }

    private void removeGlobalListener() {
        RecyclerView recyclerView = ((PullLoadMoreAdapter) this).mRecyclerView;
        if (recyclerView != null) {
            recyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.mTryTooLoadMoreListener);
        }
    }

    public int calculateCount(List<MultiViewBlock> list) {
        int i3;
        try {
            int size = list.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                if (ArrayUtils.isOutOfArrayIndex(i17, list)) {
                    return i16;
                }
                MultiViewBlock multiViewBlock = list.get(i17);
                if (multiViewBlock != null) {
                    if (isEnableRefresh()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    multiViewBlock.setGlobalPositionOffset(i3 + i16);
                    i16 += multiViewBlock.getItemCount();
                }
            }
            return i16;
        } catch (Exception unused) {
            return 0;
        }
    }

    protected void checkFixedViewType(MultiViewBlock multiViewBlock, int i3) {
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null && blockContainer.isEnablePageRecyclerViewPool()) {
            int fixedViewTypeOffset = multiViewBlock.getFixedViewTypeOffset() / 100000;
            if (RFWApplication.isDebug()) {
                if (multiViewBlock.getFixedViewTypeOffset() >= 100000) {
                    if (this.mFixViewTypes.get(fixedViewTypeOffset, -1) != -1) {
                        throw new RuntimeException("the FixViewTypeOffset has been register by" + ((MultiViewBlock) this.mDataList.get(i3)).getClass().getSimpleName());
                    }
                } else {
                    throw new RuntimeException("the FixViewTypeOffset must bigger than100000");
                }
            }
            this.mFixViewTypes.put(fixedViewTypeOffset, i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup viewGroup, int i3) {
        if (this.mDataList.size() == 0) {
            if (this.mDefaultViewHolder == null) {
                this.mDefaultViewHolder = new PtrDefaultViewHolder(new View(viewGroup.getContext()));
            }
            return this.mDefaultViewHolder;
        }
        if (i3 == -99999) {
            return super.onCreateViewHolder(viewGroup, i3);
        }
        int i16 = this.mViewTypes.get(i3);
        RecyclerView.ViewHolder onCreateViewHolder = ((MultiViewBlock) this.mDataList.get(i16)).onCreateViewHolder(viewGroup, getBlockViewType(i3, i16));
        if (onCreateViewHolder != null) {
            View view = onCreateViewHolder.itemView;
            if (view instanceof BaseWidgetView) {
                ((BaseWidgetView) view).setParentView(viewGroup);
            }
        }
        return onCreateViewHolder;
    }

    public void destroy() {
        this.mBlockContainer = null;
        this.mUniqueKeyMap.clear();
        this.mBlockPart = null;
    }

    public MultiViewBlock findBlock(int i3) {
        if (i3 < getCount()) {
            int size = this.mDataList.size();
            for (int i16 = 0; i16 < size; i16++) {
                MultiViewBlock multiViewBlock = (MultiViewBlock) this.mDataList.get(i16);
                int itemCount = multiViewBlock.getItemCount();
                if (i3 < itemCount) {
                    return multiViewBlock;
                }
                i3 = Math.max(i3 - itemCount, 0);
            }
            return null;
        }
        return null;
    }

    public MultiViewBlock getBlock(int i3) {
        if (ArrayUtils.isOutOfArrayIndex(i3, this.mDataList)) {
            return null;
        }
        return (MultiViewBlock) this.mDataList.get(i3);
    }

    public BlockContainer getBlockContainer() {
        return this.mBlockContainer;
    }

    public BlockPart getBlockPart() {
        return this.mBlockPart;
    }

    public int getBlockPositionStartOffset(BaseListViewAdapter baseListViewAdapter) {
        BaseListViewAdapter baseListViewAdapter2;
        Iterator it = this.mDataList.iterator();
        int i3 = 0;
        while (it.hasNext() && (baseListViewAdapter2 = (BaseListViewAdapter) it.next()) != baseListViewAdapter) {
            i3 += baseListViewAdapter2.getItemCount();
        }
        return i3;
    }

    public int getCount() {
        return calculateCount(this.mDataList);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public int getDataNumber() {
        return getCount();
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getCount() + getExtraCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (isEnableRefresh() && i3 == 0) {
            return -10000;
        }
        int realPosition = getRealPosition(i3);
        if (realPosition < getCount()) {
            int size = this.mDataList.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                MultiViewBlock multiViewBlock = (MultiViewBlock) this.mDataList.get(i17);
                int itemCount = multiViewBlock.getItemCount();
                if (realPosition < itemCount) {
                    int initViewType = initViewType(i16, -1, multiViewBlock, multiViewBlock.getItemViewType(realPosition));
                    this.mViewTypes.put(initViewType, i17);
                    return initViewType;
                }
                realPosition = Math.max(realPosition - itemCount, 0);
                if (multiViewBlock.getViewTypeCount() != 0) {
                    i16 += multiViewBlock.getViewTypeCount();
                } else {
                    throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
                }
            }
            return -1;
        }
        return -99999;
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.IRefreshViewProvider.OnRefreshListener
    public String getRefreshUpdateTips() {
        return null;
    }

    public GridLayoutManager.SpanSizeLookup getSpanSizeLookupListener() {
        return new GridLayoutManager.SpanSizeLookup() { // from class: com.tencent.biz.richframework.part.block.BlockMerger.2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                int realPosition = BlockMerger.this.getRealPosition(i3);
                MultiViewBlock findBlock = BlockMerger.this.findBlock(realPosition);
                if (findBlock != null) {
                    return findBlock.getSpanCount(realPosition);
                }
                return ((GridLayoutManager) ((PullLoadMoreAdapter) BlockMerger.this).mLayoutManager).getSpanCount();
            }
        };
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        for (int i17 = 0; i17 < this.mDataList.size(); i17++) {
            ((MultiViewBlock) this.mDataList.get(i17)).onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public boolean onBackEvent() {
        Iterator it = this.mDataList.iterator();
        while (it.hasNext()) {
            if (((MultiViewBlock) it.next()).onBackEvent()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int size = this.mDataList.size();
        for (int i16 = 0; i16 < size; i16++) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) this.mDataList.get(i16);
            int itemCount = multiViewBlock.getItemCount();
            if (i3 < itemCount) {
                multiViewBlock.onBindViewHolder(viewHolder, i3, ViewHolderHelper.getUnmodifiedPayloads(viewHolder));
                return;
            }
            i3 = Math.max(i3 - itemCount, 0);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        int size = this.mDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((MultiViewBlock) this.mDataList.get(i3)).onDetachedFromRecyclerView(recyclerView);
        }
        removeGlobalListener();
    }

    public void onInitEachBlock() {
        for (E e16 : this.mDataList) {
            if (!e16.isLazyLoad()) {
                e16.onInit();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        removeGlobalListener();
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            ((MultiViewBlock) this.mDataList.get(i3)).onPartDestroy(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            ((MultiViewBlock) this.mDataList.get(i3)).onPartPause(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            ((MultiViewBlock) this.mDataList.get(i3)).onPartResume(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        super.onPartSaveInstanceState(activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            ((MultiViewBlock) this.mDataList.get(i3)).onPartStart(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            ((MultiViewBlock) this.mDataList.get(i3)).onPartStop(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.IRefreshViewProvider.OnRefreshListener
    public void onRefresh() {
        super.onRefresh();
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null && this.mDataList.size() > 0) {
            blockContainer.setRefreshing(true);
        }
        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) this.mDataList.get(i3);
            if (multiViewBlock.isEnableRefresh()) {
                multiViewBlock.onRefreshData();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        boolean z16 = layoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
        if (z16 && ((viewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder) || (viewHolder instanceof PullLoadMoreAdapter.RefreshViewHolder))) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            return;
        }
        int realPosition = getRealPosition(viewHolder.getAdapterPosition());
        if (realPosition < 0) {
            return;
        }
        int size = this.mDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) this.mDataList.get(i3);
            int itemCount = multiViewBlock.getItemCount();
            if (realPosition < itemCount) {
                if (z16) {
                    checkStaggeredFullSpan(viewHolder, multiViewBlock, layoutParams);
                }
                multiViewBlock.onViewAttachedToWindow(viewHolder);
                return;
            }
            realPosition = Math.max(realPosition - itemCount, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        int realPosition = getRealPosition(viewHolder.getAdapterPosition());
        if (realPosition < 0) {
            return;
        }
        int size = this.mDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            BaseListViewAdapter baseListViewAdapter = (BaseListViewAdapter) this.mDataList.get(i3);
            int itemCount = baseListViewAdapter.getItemCount();
            if (realPosition < itemCount) {
                baseListViewAdapter.onViewDetachedFromWindow(viewHolder);
                return;
            }
            realPosition = Math.max(realPosition - itemCount, 0);
        }
    }

    public void registerBlock(MultiViewBlock multiViewBlock) {
        registerBlock(multiViewBlock, -1);
    }

    public void resetTryToLoadMoreCount() {
        this.mSafeTryToLoadMoreCount = 0;
    }

    public void setBlockContainer(BlockContainer blockContainer) {
        this.mBlockContainer = blockContainer;
    }

    public void setBlockWrapper(BlockPart blockPart) {
        this.mBlockPart = blockPart;
    }

    public void setTryToLoadMoreWhenNotFullScreen(int i3) {
        this.mSafeRetryMaxCount = i3;
        RecyclerView recyclerView = ((PullLoadMoreAdapter) this).mRecyclerView;
        if (recyclerView != null) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.mTryTooLoadMoreListener);
        }
    }

    public boolean triggerAutoLoadMore() {
        int findLastCompletelyVisibleItemPositions;
        if (this.mDataList.size() == 0) {
            return false;
        }
        List<E> list = this.mDataList;
        MultiViewBlock multiViewBlock = (MultiViewBlock) list.get(list.size() - 1);
        if (multiViewBlock == null || this.mSafeRetryMaxCount == 0 || multiViewBlock.getLoadInfo().isLoading() || (findLastCompletelyVisibleItemPositions = LayoutManagerUtils.findLastCompletelyVisibleItemPositions(((PullLoadMoreAdapter) this).mRecyclerView)) == -1 || findLastCompletelyVisibleItemPositions < multiViewBlock.getItemCount() - 1 || checkIsInValidRetry()) {
            return false;
        }
        if (((PullLoadMoreAdapter) this).mRecyclerView != null && !isFinish()) {
            this.mSafeTryToLoadMoreCount++;
            triggerToLoadMore();
            return true;
        }
        this.mSafeTryToLoadMoreCount = 0;
        return false;
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public void triggerToLoadMore() {
        MultiViewBlock multiViewBlock = (MultiViewBlock) this.mDataList.get(r0.size() - 1);
        BlockContainer blockContainer = getBlockContainer();
        if ((blockContainer != null && !blockContainer.isEnableLoadMore()) || multiViewBlock.getLoadInfo().isLoading()) {
            return;
        }
        if (multiViewBlock.getLoadInfo().isFinish()) {
            multiViewBlock.getLoadInfo().setCurrentState(4);
        } else if (multiViewBlock.getDataList().size() > 0) {
            onLoadingStart();
            multiViewBlock.getLoadInfo().setCurrentState(3);
            multiViewBlock.loadMoreData(multiViewBlock.getLoadInfo());
        }
    }

    public void unRegisterBlock(final MultiViewBlock multiViewBlock) {
        if (multiViewBlock != null && this.mDataList.contains(multiViewBlock)) {
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.BlockMerger.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BlockContainer blockContainer = BlockMerger.this.getBlockContainer();
                        if (blockContainer != null) {
                            multiViewBlock.onDetachedFromRecyclerView(blockContainer.getRecyclerView());
                        }
                        ((BaseListViewAdapter) BlockMerger.this).mDataList.remove(multiViewBlock);
                        BlockMerger.this.notifyBlockChange(multiViewBlock, 2);
                        BlockMerger.this.notifyDataSetChanged();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }

    public void registerBlock(MultiViewBlock multiViewBlock, int i3) {
        if (multiViewBlock == null || this.mDataList.contains(multiViewBlock)) {
            return;
        }
        if (i3 == -1) {
            i3 = this.mDataList.size();
        }
        if (multiViewBlock.getUniqueKey() != null) {
            this.mUniqueKeyMap.put(multiViewBlock.getUniqueKey(), multiViewBlock);
        }
        this.mDataList.add(i3, multiViewBlock);
        checkFixedViewType(multiViewBlock, i3);
        multiViewBlock.setBlockMerger(this);
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer != null) {
            multiViewBlock.onAttachedToRecyclerView(blockContainer.getRecyclerView());
        }
        notifyBlockChange(multiViewBlock, 1);
    }
}
