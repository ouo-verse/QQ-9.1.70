package com.tenpay.fingerpay.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.fingerpay.type.PayTypeAdapter;
import com.tenpay.fingerpay.type.PayTypeInfo;
import com.tenpay.sdk.util.QWSoterConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B(\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018R)\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/fingerpay/type/PayTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tenpay/fingerpay/type/PayTypeAdapter$ViewHolder;", "onItemClickListener", "Lkotlin/Function1;", "Lcom/tenpay/fingerpay/type/PayTypeInfo;", "Lkotlin/ParameterName;", "name", "payTypeInfo", "", "(Lkotlin/jvm/functions/Function1;)V", "paySwitchItem", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateSwitchList", "payTypeList", "", "ViewHolder", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayTypeAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NotNull
    private final Function1<PayTypeInfo, Unit> onItemClickListener;

    @NotNull
    private final List<PayTypeInfo> paySwitchItem;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/fingerpay/type/PayTypeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "isChosen", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "payTypeName", "Landroid/widget/TextView;", "getPayTypeName", "()Landroid/widget/TextView;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final ImageView isChosen;

        @NotNull
        private final TextView payTypeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.f2291050);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.pay_type_name)");
            this.payTypeName = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.twf);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.choose_view)");
            this.isChosen = (ImageView) findViewById2;
        }

        @NotNull
        public final TextView getPayTypeName() {
            return this.payTypeName;
        }

        @NotNull
        /* renamed from: isChosen, reason: from getter */
        public final ImageView getIsChosen() {
            return this.isChosen;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PayTypeAdapter(@NotNull Function1<? super PayTypeInfo, Unit> onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
        this.paySwitchItem = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(PayTypeInfo payType, PayTypeAdapter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(payType, "$payType");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!payType.getIsChosen()) {
            this$0.onItemClickListener.invoke(payType);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.paySwitchItem.size();
    }

    public final void updateSwitchList(@NotNull List<PayTypeInfo> payTypeList) {
        Intrinsics.checkNotNullParameter(payTypeList, "payTypeList");
        this.paySwitchItem.clear();
        this.paySwitchItem.addAll(payTypeList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PayTypeInfo payTypeInfo = this.paySwitchItem.get(position);
        TextView payTypeName = holder.getPayTypeName();
        if (payTypeInfo.getIsCloseBtn()) {
            str = "\u5173\u95ed";
        } else {
            str = "\u5f00\u542f" + QWSoterConstans.getNameByBusiType(payTypeInfo.getBusiType());
        }
        payTypeName.setText(str);
        holder.getIsChosen().setVisibility(payTypeInfo.getIsChosen() ? 0 : 8);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: hy4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayTypeAdapter.onBindViewHolder$lambda$0(PayTypeInfo.this, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fyc, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ViewHolder(view);
    }
}
