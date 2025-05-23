package com.tencent.state.square.interaction.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "appendItem", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "appendList", "list", "", "getItemCount", "", "getItemViewType", "position", "lastData", "onBindViewHolder", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_COMM = 1;
    private static final int TYPE_NOT_SUPPORT = -1;
    private static final int TYPE_TIP = 2;
    private static final int TYPE_TITLE = 0;
    private final ArrayList<Object> dataList = new ArrayList<>();

    public final void appendItem(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int size = this.dataList.size();
        this.dataList.add(item);
        notifyItemInserted(size);
    }

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
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object obj = this.dataList.get(position);
        if (obj instanceof InteractionRecordTitleData) {
            return 0;
        }
        if (obj instanceof InteractionRecordTipData) {
            return 2;
        }
        return obj instanceof InteractionRecordData ? 1 : -1;
    }

    public final Object lastData() {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.dataList);
        return lastOrNull;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        boolean z16 = holder instanceof IInteractionRecordViewHolder;
        Object obj = holder;
        if (!z16) {
            obj = null;
        }
        IInteractionRecordViewHolder iInteractionRecordViewHolder = (IInteractionRecordViewHolder) obj;
        if (iInteractionRecordViewHolder != null) {
            Object obj2 = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj2, "dataList[position]");
            iInteractionRecordViewHolder.bind(obj2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.d5g, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare\u2026ord_title, parent, false)");
            return new InteractionRecordTitleViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.d5e, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "LayoutInflater.from(pare\u2026cord_comm, parent, false)");
            return new InteractionRecordCommViewHolder(inflate2);
        }
        if (viewType != 2) {
            return new InteractionRecordNotSupportViewHolder(new FrameLayout(parent.getContext()));
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.d5f, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "LayoutInflater.from(pare\u2026ecord_tip, parent, false)");
        return new InteractionRecordTipViewHolder(inflate3);
    }
}
