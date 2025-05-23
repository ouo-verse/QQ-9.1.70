package com.tenpay.bank.quick.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.bank.quick.BankItemData;
import com.tenpay.bank.quick.type.BankProtoAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/bank/quick/type/BankProtoAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "Lcom/tenpay/bank/quick/type/BankProtoAdapter$BankProtoViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "BankProtoViewHolder", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BankProtoAdapter extends ListAdapter<BankItemData.Proto, BankProtoViewHolder> {

    @NotNull
    private static final BankProtoAdapter$Companion$ITEM_CALLBACK$1 ITEM_CALLBACK = new DiffUtil.ItemCallback<BankItemData.Proto>() { // from class: com.tenpay.bank.quick.type.BankProtoAdapter$Companion$ITEM_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull BankItemData.Proto oldItem, @NotNull BankItemData.Proto newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull BankItemData.Proto oldItem, @NotNull BankItemData.Proto newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/bank/quick/type/BankProtoAdapter$BankProtoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bankProtoName", "Landroid/widget/TextView;", "setItem", "", "bankItemData", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class BankProtoViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final TextView bankProtoName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankProtoViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.t3c);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bank_proto_item_name)");
            this.bankProtoName = (TextView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setItem$lambda$0(BankProtoViewHolder this$0, BankItemData.Proto bankItemData, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(bankItemData, "$bankItemData");
            k.h(this$0.itemView.getContext(), bankItemData.getUrl());
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void setItem(@NotNull final BankItemData.Proto bankItemData) {
            Intrinsics.checkNotNullParameter(bankItemData, "bankItemData");
            this.bankProtoName.setText(bankItemData.getName());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.type.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BankProtoAdapter.BankProtoViewHolder.setItem$lambda$0(BankProtoAdapter.BankProtoViewHolder.this, bankItemData, view);
                }
            });
        }
    }

    public BankProtoAdapter() {
        super(ITEM_CALLBACK);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull BankProtoViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BankItemData.Proto item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        holder.setItem(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BankProtoViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168974hi3, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new BankProtoViewHolder(view);
    }
}
