package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0012\u001a\u00020\nH\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0014R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/e;", "Lcom/tencent/biz/richframework/part/block/base/PullLoadMoreAdapter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onViewAttachedToWindow", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "", "position", "onBindItemViewHolder", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "createItemViewHolder", "createProgressViewHolder", "getProgressLayoutId", "triggerToLoadMore", "Lkotlin/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function0;", "getLoadMoreCallback", "()Lkotlin/jvm/functions/Function0;", "i0", "(Lkotlin/jvm/functions/Function0;)V", "loadMoreCallback", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends PullLoadMoreAdapter<FeedCloudMeta$StFeed> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> loadMoreCallback;

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    @NotNull
    protected RecyclerView.ViewHolder createItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grc, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new g(itemView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    @NotNull
    public RecyclerView.ViewHolder createProgressViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PullLoadMoreAdapter.LoadMoreViewHolder loadMoreViewHolder = new PullLoadMoreAdapter.LoadMoreViewHolder(LayoutInflater.from(parent.getContext()).inflate(getProgressLayoutId(), parent, false));
        ProgressBar progressBar = loadMoreViewHolder.mProgressbar;
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(((PullLoadMoreAdapter) this).mRecyclerView.getContext(), 2));
        }
        return loadMoreViewHolder;
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    protected int getProgressLayoutId() {
        return R.layout.grp;
    }

    public final void i0(@Nullable Function0<Unit> function0) {
        this.loadMoreCallback = function0;
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.mLoadingHint = com.tencent.biz.qqcircle.utils.h.a(R.string.f195124dr);
        this.mNoMoreHint = com.tencent.biz.qqcircle.utils.h.a(R.string.f195134ds);
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    protected void onBindItemViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof g) {
            FeedCloudMeta$StFeed item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            ((g) holder).o(item, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if ((this.mLayoutManager instanceof StaggeredGridLayoutManager) && holder.getItemViewType() == -99999) {
            ViewGroup.LayoutParams layoutParams2 = holder.itemView.getLayoutParams();
            if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.setFullSpan(true);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    protected void triggerToLoadMore() {
        if (!isLoading() && !isFinish() && !getDataList().isEmpty()) {
            QLog.d("QFSSearchPromptRankStaggeredAdapter", 1, "[triggerToLoadMore] ");
            onLoadingStart();
            Function0<Unit> function0 = this.loadMoreCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }
}
