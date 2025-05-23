package com.tencent.state.square.pickfriend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.pickfriend.service.PickFriendItemData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/pickfriend/PickFriendListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "", "Lcom/tencent/state/square/pickfriend/service/PickFriendItemData;", "getItemCount", "", "impEndReport", "", "onBindViewHolder", "holder", "position", "payloads", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateList", "list", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PickFriendListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PickFriendListAdapter";
    private List<PickFriendItemData> dataList = new ArrayList();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemUpdateEvent.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ItemUpdateEvent.IMP_END.ordinal()] = 1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final void impEndReport() {
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            notifyItemChanged(i3, ItemUpdateEvent.IMP_END);
            i3 = i16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        boolean z16 = holder instanceof IPickFriendItemViewHolder;
        Object obj = holder;
        if (!z16) {
            obj = null;
        }
        IPickFriendItemViewHolder iPickFriendItemViewHolder = (IPickFriendItemViewHolder) obj;
        if (iPickFriendItemViewHolder != null) {
            iPickFriendItemViewHolder.bind(this.dataList.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.d6m, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare\u2026iend_item, parent, false)");
        return new ItemViewHolder(inflate);
    }

    public final void updateList(List<PickFriendItemData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (!(firstOrNull instanceof ItemUpdateEvent)) {
            firstOrNull = null;
        }
        ItemUpdateEvent itemUpdateEvent = (ItemUpdateEvent) firstOrNull;
        if (itemUpdateEvent == null) {
            onBindViewHolder(holder, position);
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[itemUpdateEvent.ordinal()] != 1) {
            return;
        }
        boolean z16 = holder instanceof IPickFriendItemViewHolder;
        Object obj = holder;
        if (!z16) {
            obj = null;
        }
        IPickFriendItemViewHolder iPickFriendItemViewHolder = (IPickFriendItemViewHolder) obj;
        if (iPickFriendItemViewHolder != null) {
            iPickFriendItemViewHolder.impEnd();
        }
    }
}
