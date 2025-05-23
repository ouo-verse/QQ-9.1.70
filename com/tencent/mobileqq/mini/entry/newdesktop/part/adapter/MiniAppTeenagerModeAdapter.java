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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppTeenagerModeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppTeenagerModeViewHolder;", "()V", "mMiniAppTeenagerModeViewHolder", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppTeenagerModeAdapter extends RecyclerView.Adapter<MiniAppTeenagerModeViewHolder> {
    private static final int TEENAGER_MODE_VIEW_COUNT = 1;
    private MiniAppTeenagerModeViewHolder mMiniAppTeenagerModeViewHolder;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniAppTeenagerModeViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiniAppTeenagerModeViewHolder miniAppTeenagerModeViewHolder = this.mMiniAppTeenagerModeViewHolder;
        if (miniAppTeenagerModeViewHolder != null) {
            miniAppTeenagerModeViewHolder.bindView();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniAppTeenagerModeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.djn, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ty_layout, parent, false)");
        MiniAppTeenagerModeViewHolder miniAppTeenagerModeViewHolder = new MiniAppTeenagerModeViewHolder(inflate);
        this.mMiniAppTeenagerModeViewHolder = miniAppTeenagerModeViewHolder;
        Intrinsics.checkNotNull(miniAppTeenagerModeViewHolder);
        return miniAppTeenagerModeViewHolder;
    }
}
