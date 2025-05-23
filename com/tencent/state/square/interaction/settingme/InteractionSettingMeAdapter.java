package com.tencent.state.square.interaction.settingme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "appendList", "", "list", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "payloads", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionSettingMeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ArrayList<Object> dataList = new ArrayList<>();

    public final void appendList(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            return;
        }
        int size = this.dataList.size();
        this.dataList.addAll(list);
        notifyItemRangeInserted(size, this.dataList.size() - size);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.d5h, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare\u2026etting_me, parent, false)");
        return new InteractionSettingMeItemHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean z16 = holder instanceof IInteractionSettingMeHolder;
        Object obj = holder;
        if (!z16) {
            obj = null;
        }
        IInteractionSettingMeHolder iInteractionSettingMeHolder = (IInteractionSettingMeHolder) obj;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        ItemUpdateEvent itemUpdateEvent = (ItemUpdateEvent) (firstOrNull instanceof ItemUpdateEvent ? firstOrNull : null);
        if (itemUpdateEvent != null) {
            if (iInteractionSettingMeHolder != null) {
                iInteractionSettingMeHolder.bind(itemUpdateEvent);
            }
        } else if (iInteractionSettingMeHolder != null) {
            iInteractionSettingMeHolder.bind(this, this.dataList, position);
        }
    }
}
