package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0001\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;", "getEMPTY_ORDER_DETAIL_PAY_INFO", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;", "EMPTY_ORDER_DETAIL_PAY_INFO", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "EMPTY_ORDER_DETAIL_STATE", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final ECOrderDetailPayInfo f103184a;

    /* renamed from: b, reason: collision with root package name */
    private static final ECOrderDetailState f103185b;

    static {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ECOrderDetailPayInfo eCOrderDetailPayInfo = new ECOrderDetailPayInfo("", 0L, 0L, PayType.UNKNOWN, 0L);
        f103184a = eCOrderDetailPayInfo;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.a());
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.ecommerce.biz.orders.buyerorders.detail.model.b.d());
        f103185b = new ECOrderDetailState("", QShopOrderState.UNKNOWN.value, null, null, "", 0L, 0L, false, null, null, null, new ECOrderDetailAccountInfoData(0, null, null, 7, null), com.tencent.ecommerce.biz.orders.common.f.a(), com.tencent.ecommerce.biz.orders.address.b.b(), null, arrayListOf, arrayListOf2, eCOrderDetailPayInfo, null, null, null, new ECOrderDetailGoodsOperateState(false, false, false, false, false, null, null, null, 255, null), null, new ECOrderDetailWidgetsVisibility(false, false, false, false, false, false, 63, null), null, null, null, null, null, 526125004, null);
    }

    public static final ECOrderDetailState a() {
        return f103185b;
    }
}
