package com.tenpay.bank.quick.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.bank.quick.BankItemData;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tenpay/bank/quick/type/BankTypeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tenpay/bank/quick/BankItemData$CardType;", "Lcom/tenpay/bank/quick/type/BankTypeAdapter$BankTypeViewHolder;", "bankItemData", "Lcom/tenpay/bank/quick/BankItemData;", "(Lcom/tenpay/bank/quick/BankItemData;)V", "selectCardType", "", "getCurrentItem", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "BankTypeViewHolder", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BankTypeAdapter extends ListAdapter<BankItemData.CardType, BankTypeViewHolder> {

    @NotNull
    private static final BankTypeAdapter$Companion$ITEM_CALLBACK$1 ITEM_CALLBACK = new DiffUtil.ItemCallback<BankItemData.CardType>() { // from class: com.tenpay.bank.quick.type.BankTypeAdapter$Companion$ITEM_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull BankItemData.CardType oldItem, @NotNull BankItemData.CardType newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull BankItemData.CardType oldItem, @NotNull BankItemData.CardType newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    @NotNull
    private final BankItemData bankItemData;
    private int selectCardType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tenpay/bank/quick/type/BankTypeAdapter$BankTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bankLogo", "Landroid/widget/ImageView;", "bankNameTextView", "Landroid/widget/TextView;", "border", "phoneSelect", "setItem", "", "bankItemData", "Lcom/tenpay/bank/quick/BankItemData;", "cardTypeName", "", "isSelect", "", "showBorder", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class BankTypeViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final ImageView bankLogo;

        @NotNull
        private final TextView bankNameTextView;

        @NotNull
        private final View border;

        @NotNull
        private final View phoneSelect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankTypeViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.t3i);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bank_type_item_logo)");
            this.bankLogo = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.t3j);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.bank_type_item_name)");
            this.bankNameTextView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.t3k);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.bank_type_item_select)");
            this.phoneSelect = findViewById3;
            View findViewById4 = view.findViewById(R.id.t3h);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.bank_type_item_border)");
            this.border = findViewById4;
        }

        public final void setItem(@NotNull BankItemData bankItemData, @NotNull String cardTypeName, boolean isSelect, boolean showBorder) {
            int i3;
            Intrinsics.checkNotNullParameter(bankItemData, "bankItemData");
            Intrinsics.checkNotNullParameter(cardTypeName, "cardTypeName");
            this.bankLogo.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(bankItemData.getLogoUrl()));
            this.bankNameTextView.setText(cardTypeName);
            View view = this.phoneSelect;
            int i16 = 0;
            if (isSelect) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            View view2 = this.border;
            if (!showBorder) {
                i16 = 8;
            }
            view2.setVisibility(i16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankTypeAdapter(@NotNull BankItemData bankItemData) {
        super(ITEM_CALLBACK);
        Intrinsics.checkNotNullParameter(bankItemData, "bankItemData");
        this.bankItemData = bankItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(BankTypeAdapter this$0, BankTypeViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.selectCardType = holder.getAdapterPosition();
        this$0.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    public final BankItemData.CardType getCurrentItem() {
        if (getCurrentList().isEmpty() || this.selectCardType >= getCurrentList().size() || this.selectCardType < 0) {
            return null;
        }
        return getCurrentList().get(this.selectCardType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final BankTypeViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setItem(this.bankItemData, getItem(position).getName(), position == this.selectCardType, position != getNUM_BACKGOURND_ICON() - 1);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.type.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankTypeAdapter.onBindViewHolder$lambda$0(BankTypeAdapter.this, holder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BankTypeViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hi6, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new BankTypeViewHolder(view);
    }
}
