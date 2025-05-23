package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/EmptyMiniAppHintViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/EmptyMiniAppHintViewHolder;", "()V", "mEmptyMiniAppViewHolder", "mIsShowEmptyView", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setData", "isShowEmptyView", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class EmptyMiniAppHintViewAdapter extends RecyclerView.Adapter<EmptyMiniAppHintViewHolder> {
    private static final int EMPTY_VIEW_HIDE_COUNT = 0;
    private static final int EMPTY_VIEW_SHOW_COUNT = 1;
    private static final String TAG = "EmptyMiniAppHintViewAdapter";
    private EmptyMiniAppHintViewHolder mEmptyMiniAppViewHolder;
    private boolean mIsShowEmptyView;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mIsShowEmptyView ? 1 : 0;
    }

    public final void setData(boolean isShowEmptyView) {
        this.mIsShowEmptyView = isShowEmptyView;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmptyMiniAppHintViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        EmptyMiniAppHintViewHolder emptyMiniAppHintViewHolder = this.mEmptyMiniAppViewHolder;
        if (emptyMiniAppHintViewHolder != null) {
            emptyMiniAppHintViewHolder.bindView(this.mIsShowEmptyView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmptyMiniAppHintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fhl, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026mpty_hint, parent, false)");
        EmptyMiniAppHintViewHolder emptyMiniAppHintViewHolder = new EmptyMiniAppHintViewHolder(inflate);
        this.mEmptyMiniAppViewHolder = emptyMiniAppHintViewHolder;
        Intrinsics.checkNotNull(emptyMiniAppHintViewHolder);
        return emptyMiniAppHintViewHolder;
    }
}
