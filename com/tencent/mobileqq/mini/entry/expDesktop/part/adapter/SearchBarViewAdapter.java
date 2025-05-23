package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.SearchBarViewHolder;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/SearchBarViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/SearchBarViewHolder;", "()V", "mModuleType", "", "mSearchBarViewHolder", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "setModuleType", "moduleType", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SearchBarViewAdapter extends RecyclerView.Adapter<SearchBarViewHolder> {
    private static final int SHOW_SEARCH_COUNT = 1;
    private static final String TAG = "MiniAppExpDesktopPart.SearchBarViewAdapter";
    private int mModuleType = -1;
    private SearchBarViewHolder mSearchBarViewHolder;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public final void setModuleType(int moduleType) {
        this.mModuleType = moduleType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SearchBarViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SearchBarViewHolder searchBarViewHolder = this.mSearchBarViewHolder;
        if (searchBarViewHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBarViewHolder");
            searchBarViewHolder = null;
        }
        searchBarViewHolder.bindView(this.mModuleType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SearchBarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dj7, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        SearchBarViewHolder searchBarViewHolder = new SearchBarViewHolder(inflate);
        this.mSearchBarViewHolder = searchBarViewHolder;
        return searchBarViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(SearchBarViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((SearchBarViewAdapter) holder);
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_expo", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XIALA_SOUSUOKUANG, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
    }
}
