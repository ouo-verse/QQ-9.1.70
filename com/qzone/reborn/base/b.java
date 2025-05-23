package com.qzone.reborn.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.itemview.QZoneEmptyOrForbiddenView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.biz.subscribe.part.block.base.RefreshHeaderView;
import com.tencent.mobileqq.R;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends BlockMerger {
    private a C;
    private int D;

    /* renamed from: m, reason: collision with root package name */
    private boolean f53562m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void S();
    }

    public b(BlockContainer blockContainer) {
        super(blockContainer);
        this.f53562m = false;
        this.D = 7;
        setRefreshViewProvider(new RefreshHeaderView(blockContainer.getContext()));
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

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    protected int getLinearPreloadCount() {
        return this.D;
    }

    public void j0(int i3) {
        this.D = i3;
    }

    public void k0(a aVar) {
        this.C = aVar;
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.f53562m || this.C == null) {
            return;
        }
        View view = viewHolder.itemView;
        if ((!(view instanceof QZoneBaseFeedItemView) && !(view instanceof QZoneEmptyOrForbiddenView) && !(view instanceof QzoneBaseFeedProItemView)) || viewHolder.getItemViewType() == -10000 || viewHolder.getItemViewType() == -99999) {
            return;
        }
        this.f53562m = true;
        this.C.S();
    }
}
