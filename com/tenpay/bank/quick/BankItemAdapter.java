package com.tenpay.bank.quick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0017\u0018B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/bank/quick/BankItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tenpay/bank/quick/BankItemData;", "Lcom/tenpay/bank/quick/BankItemAdapter$BankItemViewHolder;", "itemClickListener", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "maxItemSize", "getMaxItemSize", "()I", "setMaxItemSize", "(I)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "BankItemViewHolder", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BankItemAdapter extends ListAdapter<BankItemData, BankItemViewHolder> {

    @NotNull
    private static final BankItemAdapter$Companion$ITEM_CALLBACK$1 ITEM_CALLBACK = new DiffUtil.ItemCallback<BankItemData>() { // from class: com.tenpay.bank.quick.BankItemAdapter$Companion$ITEM_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull BankItemData oldItem, @NotNull BankItemData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull BankItemData oldItem, @NotNull BankItemData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    @NotNull
    private static final String TAG = "BankItemAdapter";

    @NotNull
    private final Function1<BankItemData, Unit> itemClickListener;
    private int maxItemSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/bank/quick/BankItemAdapter$BankItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bankLogo", "Landroid/widget/ImageView;", "bankName", "Landroid/widget/TextView;", "bankPromotion", "onBind", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tenpay/bank/quick/BankItemData;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class BankItemViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final ImageView bankLogo;

        @NotNull
        private final TextView bankName;

        @NotNull
        private final TextView bankPromotion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankItemViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.t39);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bank_item_logo)");
            this.bankLogo = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.t3_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.bank_item_name)");
            this.bankName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.t3a);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.bank_item_promotion)");
            this.bankPromotion = (TextView) findViewById3;
        }

        public final void onBind(@NotNull BankItemData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.bankName.setText(item.getName());
            this.bankPromotion.setText(item.getPromotion());
            this.bankLogo.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(item.getLogoUrl()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BankItemAdapter(@NotNull Function1<? super BankItemData, Unit> itemClickListener) {
        super(ITEM_CALLBACK);
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(BankItemAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<BankItemData, Unit> function1 = this$0.itemClickListener;
        BankItemData item = this$0.getItem(i3);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        function1.invoke(item);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int itemCount = super.getItemCount();
        int i3 = this.maxItemSize;
        boolean z16 = false;
        if (1 <= i3 && i3 < itemCount) {
            z16 = true;
        }
        if (z16) {
            return i3;
        }
        return itemCount;
    }

    public final int getMaxItemSize() {
        return this.maxItemSize;
    }

    public final void setMaxItemSize(int i3) {
        this.maxItemSize = i3;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull BankItemViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BankItemData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        holder.onBind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankItemAdapter.onBindViewHolder$lambda$0(BankItemAdapter.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BankItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168972hi1, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new BankItemViewHolder(view);
    }
}
