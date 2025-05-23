package com.tencent.biz.qqcircle.fragments;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleBlockMerger extends BlockMerger {

    /* renamed from: m, reason: collision with root package name */
    private final List<a> f84437m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void onLoadMoreDisplay();
    }

    public QCircleBlockMerger(BlockContainer blockContainer) {
        super(blockContainer);
        this.f84437m = new CopyOnWriteArrayList();
        setRefreshViewProvider(new RefreshHeaderView(blockContainer.getContext()));
    }

    private int j0(int i3) {
        int realPosition;
        if ((isEnableRefresh() && i3 == 0) || (realPosition = getRealPosition(i3)) >= getCount()) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i16 = 0; i16 < size; i16++) {
            int itemCount = ((MultiViewBlock) this.mDataList.get(i16)).getItemCount();
            if (realPosition < itemCount) {
                return i16;
            }
            realPosition = Math.max(realPosition - itemCount, 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public RecyclerView.ViewHolder createProgressViewHolder(ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder createProgressViewHolder = super.createProgressViewHolder(viewGroup, i3);
        if (createProgressViewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder) {
            PullLoadMoreAdapter.LoadMoreViewHolder loadMoreViewHolder = (PullLoadMoreAdapter.LoadMoreViewHolder) createProgressViewHolder;
            loadMoreViewHolder.mProgressbar.setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(((PullLoadMoreAdapter) this).mRecyclerView.getContext(), 2));
            loadMoreViewHolder.mProgressInfo.setTextColor(((PullLoadMoreAdapter) this).mRecyclerView.getContext().getColor(R.color.qui_common_text_secondary));
        }
        return createProgressViewHolder;
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        MultiViewBlock multiViewBlock = (MultiViewBlock) RFSafeListUtils.get(this.mDataList, j0(i3));
        long itemId = super.getItemId(i3);
        if (multiViewBlock != null && getBlockContainer() != null && getBlockContainer().isEnablePageRecyclerViewPool()) {
            return multiViewBlock.getItemId(multiViewBlock.getLocalPosition(i3));
        }
        return itemId;
    }

    public void k0() {
        if (((PullLoadMoreAdapter) this).mRecyclerView != null && getRefreshViewProvider() != null) {
            QLog.d("BlockMerger", 4, "onShowRefreshAnim");
            getRefreshViewProvider().setState(4);
            this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.QCircleBlockMerger.1
                @Override // java.lang.Runnable
                public void run() {
                    ((PullLoadMoreAdapter) QCircleBlockMerger.this).mRecyclerView.scrollToPosition(0);
                }
            }, 100L);
        }
    }

    public void l0(a aVar) {
        if (!this.f84437m.contains(aVar)) {
            this.f84437m.add(aVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (viewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder) {
            for (int i3 = 0; i3 < this.f84437m.size(); i3++) {
                a aVar = this.f84437m.get(i3);
                if (aVar != null) {
                    aVar.onLoadMoreDisplay();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger
    protected void checkFixedViewType(MultiViewBlock multiViewBlock, int i3) {
    }
}
