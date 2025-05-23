package com.tencent.mobileqq.mini.entry.search.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.LoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchLoadMoreAdapter;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "()V", "holder", "Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchLoadMoreAdapter$LoadMoreViewHolder;", "getItemViewType", "", "position", "hide", "", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "p1", "onLoadMoreEnd", "hasMore", "", "onLoadMoreStart", "setLoadState", "isLoading", "show", "Companion", "LoadMoreStrategy", "LoadMoreViewHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppSearchLoadMoreAdapter extends RFWAbsLoadMoreAdapter {
    public static final int LOAD_MORE_MAX_RETRY_COUNT = 3;
    private static final int PRELOAD_COUNT = 15;
    public static final String TAG = "MiniAppSearchLoadMoreAdapter";
    private LoadMoreViewHolder holder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchLoadMoreAdapter$LoadMoreStrategy;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWCountLoadMoreStrategy;", "preloadCount", "", "(I)V", "getLinearPreloadCount", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class LoadMoreStrategy extends RFWCountLoadMoreStrategy {
        private final int preloadCount;

        public LoadMoreStrategy(int i3) {
            this.preloadCount = i3;
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy
        /* renamed from: getLinearPreloadCount, reason: from getter */
        protected int getPreloadCount() {
            return this.preloadCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/adapter/MiniAppSearchLoadMoreAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "progressBar", "Lcom/tencent/widget/LoadingView;", "getProgressBar", "()Lcom/tencent/widget/LoadingView;", "progressInfo", "Landroid/widget/TextView;", "getProgressInfo", "()Landroid/widget/TextView;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        private final LoadingView progressBar;
        private final TextView progressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadMoreViewHolder(View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            View findViewById = v3.findViewById(R.id.rkb);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.pb_loading)");
            this.progressBar = (LoadingView) findViewById;
            View findViewById2 = v3.findViewById(R.id.rlt);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(R.id.tv_tips)");
            this.progressInfo = (TextView) findViewById2;
        }

        public final LoadingView getProgressBar() {
            return this.progressBar;
        }

        public final TextView getProgressInfo() {
            return this.progressInfo;
        }
    }

    public MiniAppSearchLoadMoreAdapter() {
        this.mLoadMoreStrategy = new LoadMoreStrategy(15);
        setMaxAutoLoadMoreTimes(3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int p16) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.djj, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026load_more, parent, false)");
        LoadMoreViewHolder loadMoreViewHolder = new LoadMoreViewHolder(inflate);
        loadMoreViewHolder.itemView.setVisibility(8);
        this.holder = loadMoreViewHolder;
        return loadMoreViewHolder;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void setLoadState(boolean isLoading, boolean hasMore) {
        super.setLoadState(isLoading, hasMore);
        if (hasMore) {
            return;
        }
        onLoadMoreEnd(false);
    }

    public final void hide() {
        QLog.i(TAG, 1, "hide");
        LoadMoreViewHolder loadMoreViewHolder = this.holder;
        View view = loadMoreViewHolder != null ? loadMoreViewHolder.itemView : null;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        TextView progressInfo;
        TextView progressInfo2;
        QLog.i(TAG, 1, "onLoadMoreEnd");
        LoadMoreViewHolder loadMoreViewHolder = this.holder;
        LoadingView progressBar = loadMoreViewHolder != null ? loadMoreViewHolder.getProgressBar() : null;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (hasMore) {
            LoadMoreViewHolder loadMoreViewHolder2 = this.holder;
            if (loadMoreViewHolder2 == null || (progressInfo2 = loadMoreViewHolder2.getProgressInfo()) == null) {
                return;
            }
            progressInfo2.setText(R.string.xza);
            return;
        }
        LoadMoreViewHolder loadMoreViewHolder3 = this.holder;
        if (loadMoreViewHolder3 == null || (progressInfo = loadMoreViewHolder3.getProgressInfo()) == null) {
            return;
        }
        progressInfo.setText(R.string.xzc);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        TextView progressInfo;
        QLog.i(TAG, 1, "onLoadMoreStart");
        LoadMoreViewHolder loadMoreViewHolder = this.holder;
        LoadingView progressBar = loadMoreViewHolder != null ? loadMoreViewHolder.getProgressBar() : null;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        LoadMoreViewHolder loadMoreViewHolder2 = this.holder;
        if (loadMoreViewHolder2 == null || (progressInfo = loadMoreViewHolder2.getProgressInfo()) == null) {
            return;
        }
        progressInfo.setText(R.string.xzb);
    }

    public final void show() {
        QLog.i(TAG, 1, "show");
        LoadMoreViewHolder loadMoreViewHolder = this.holder;
        View view = loadMoreViewHolder != null ? loadMoreViewHolder.itemView : null;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }
}
