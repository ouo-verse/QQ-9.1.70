package com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.AddressItemData;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.q;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitAddressViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/b;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "", "u", "o", "data", ReportConstant.COSTREPORT_PREFIX, "", "", "payloads", "t", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "streetTv", "G", "detailTv", "H", "nameTv", "I", "phoneTv", "Landroidx/constraintlayout/widget/Group;", "J", "Landroidx/constraintlayout/widget/Group;", "notEmptyAddressGroup", "K", "emptyAddressTv", "L", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "Landroid/view/View;", "itemView", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "itemOperationListener", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitAddressViewHolder extends q<AddressItemData> {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView streetTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView detailTv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView nameTv;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView phoneTv;

    /* renamed from: J, reason: from kotlin metadata */
    private Group notEmptyAddressGroup;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView emptyAddressTv;

    /* renamed from: L, reason: from kotlin metadata */
    private ECAddress address;

    public ECOrderSubmitAddressViewHolder(View view, OrderSubmitListItemOperationListener orderSubmitListItemOperationListener) {
        super(view, orderSubmitListItemOperationListener);
    }

    private final void u(ECAddress address) {
        TextView textView = this.streetTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("streetTv");
        }
        textView.setText(address.province + TokenParser.SP + address.city + TokenParser.SP + address.district + TokenParser.SP + address.street);
        TextView textView2 = this.detailTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTv");
        }
        textView2.setText(address.detailAddress);
        TextView textView3 = this.nameTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameTv");
        }
        textView3.setText(address.consignee);
        TextView textView4 = this.phoneTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneTv");
        }
        textView4.setText(address.phoneNumber);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void o() {
        View view = this.itemView;
        this.streetTv = (TextView) view.findViewById(R.id.ob7);
        this.detailTv = (TextView) view.findViewById(R.id.nvg);
        this.nameTv = (TextView) view.findViewById(R.id.f163070o50);
        this.phoneTv = (TextView) view.findViewById(R.id.o6n);
        Group group = (Group) view.findViewById(R.id.f163075o55);
        this.notEmptyAddressGroup = group;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notEmptyAddressGroup");
        }
        ECViewUtilKt.b(group, R.id.ob7, R.id.nvg, R.id.f163070o50, R.id.o6n);
        this.emptyAddressTv = (TextView) view.findViewById(R.id.f163032ny2);
        ViewExtKt.c(view, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitAddressViewHolder$onCreate$$inlined$with$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                OrderSubmitListItemOperationListener orderSubmitListItemOperationListener;
                ECAddress eCAddress;
                orderSubmitListItemOperationListener = ((q) ECOrderSubmitAddressViewHolder.this).itemOperationListener;
                if (orderSubmitListItemOperationListener != null) {
                    eCAddress = ECOrderSubmitAddressViewHolder.this.address;
                    orderSubmitListItemOperationListener.onAddressClick(eCAddress);
                }
            }
        }, 1, null);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void m(AddressItemData data) {
        ECAddress eCAddress = data.address;
        this.address = eCAddress;
        if (eCAddress == null) {
            Group group = this.notEmptyAddressGroup;
            if (group == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notEmptyAddressGroup");
            }
            group.setVisibility(8);
            TextView textView = this.emptyAddressTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyAddressTv");
            }
            textView.setVisibility(0);
            return;
        }
        Group group2 = this.notEmptyAddressGroup;
        if (group2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notEmptyAddressGroup");
        }
        group2.setVisibility(0);
        TextView textView2 = this.emptyAddressTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyAddressTv");
        }
        textView2.setVisibility(8);
        u(data.address);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(AddressItemData data, List<? extends Object> payloads) {
        Object firstOrNull;
        ECAddress eCAddress;
        this.address = data.address;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(payloads);
        if (!(firstOrNull instanceof AddressItemData)) {
            firstOrNull = null;
        }
        AddressItemData addressItemData = (AddressItemData) firstOrNull;
        if (addressItemData != null && (eCAddress = addressItemData.address) != null) {
            u(eCAddress);
        } else {
            m(data);
        }
    }
}
