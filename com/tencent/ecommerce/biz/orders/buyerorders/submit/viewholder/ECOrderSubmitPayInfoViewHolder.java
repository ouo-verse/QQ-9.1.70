package com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.OrderSubmitListItemOperationListener;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.PayInfoItemData;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.i;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.q;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitPayInfoViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/r;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "newPayType", "", "t", "o", "data", "r", "", "", "payloads", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitPayInfoViewHolder$a;", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "allPayItemView", "", "G", "Ljava/util/List;", "currentSupportedPayType", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "itemOperationListener", "<init>", "(Landroid/widget/LinearLayout;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitPayInfoViewHolder extends q<PayInfoItemData> {

    /* renamed from: F, reason: from kotlin metadata */
    private Map<PayType, a> allPayItemView;

    /* renamed from: G, reason: from kotlin metadata */
    private final List<PayType> currentSupportedPayType;

    /* renamed from: H, reason: from kotlin metadata */
    private final LinearLayout container;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/viewholder/ECOrderSubmitPayInfoViewHolder$a;", "", "", "checked", "", "a", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "checkboxIv", "Landroid/view/View;", "b", "Landroid/view/View;", "view", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ImageView checkboxIv;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final View view;

        public a(View view, PayType payType) {
            this.view = view;
            ((ImageView) view.findViewById(R.id.o6_)).setImageResource(payType == PayType.QQ ? R.drawable.e1b : R.drawable.e1j);
            ((TextView) view.findViewById(R.id.o6e)).setText(payType.name(view.getContext()));
            ImageView imageView = (ImageView) view.findViewById(R.id.nt7);
            imageView.setTag(payType);
            Unit unit = Unit.INSTANCE;
            this.checkboxIv = imageView;
        }

        public final void a(boolean checked) {
            this.checkboxIv.setSelected(checked);
        }
    }

    public ECOrderSubmitPayInfoViewHolder(LinearLayout linearLayout, OrderSubmitListItemOperationListener orderSubmitListItemOperationListener) {
        super(linearLayout, orderSubmitListItemOperationListener);
        this.container = linearLayout;
        this.currentSupportedPayType = new ArrayList();
    }

    private final void t(PayType newPayType) {
        Map<PayType, a> map = this.allPayItemView;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allPayItemView");
        }
        for (Map.Entry<PayType, a> entry : map.entrySet()) {
            entry.getValue().a(entry.getKey() == newPayType);
        }
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    public void o() {
        int mapCapacity;
        int coerceAtLeast;
        PayType[] values = PayType.values();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(values.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (PayType payType : values) {
            linkedHashMap.put(payType, new a(LayoutInflater.from(this.container.getContext()).inflate(R.layout.csw, (ViewGroup) this.container, false), payType));
        }
        this.allPayItemView = linkedHashMap;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void m(PayInfoItemData data) {
        View view;
        if (!i.b(data.a(), this.currentSupportedPayType)) {
            this.container.removeAllViews();
            for (final PayType payType : data.a()) {
                Map<PayType, a> map = this.allPayItemView;
                if (map == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("allPayItemView");
                }
                a aVar = map.get(payType);
                if (aVar != null && (view = aVar.view) != null) {
                    this.container.addView(view);
                    ViewExtKt.c(view, 0L, new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitPayInfoViewHolder$onBindData$$inlined$forEach$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            orderSubmitListItemOperationListener = ((q) this).itemOperationListener;
                            if (orderSubmitListItemOperationListener != null) {
                                orderSubmitListItemOperationListener.onPayTypeSwitch(PayType.this);
                            }
                        }
                    }, 1, null);
                }
            }
            this.currentSupportedPayType.clear();
            this.currentSupportedPayType.addAll(data.a());
        }
        t(data.selectedPayType);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.q
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(PayInfoItemData data, List<? extends Object> payloads) {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(payloads);
        if (!(firstOrNull instanceof PayType)) {
            firstOrNull = null;
        }
        PayType payType = (PayType) firstOrNull;
        if (payType != null) {
            t(payType);
        } else {
            m(data);
        }
    }
}
