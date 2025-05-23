package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "EMPTY_ORDER_SKU_DETAIL", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "", "b", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;)Z", "isBlindBox", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final OrderSkuDetail f103616a;

    static {
        List emptyList;
        List emptyList2;
        OrderShop orderShop = new OrderShop("", "", "", "", null, 16, null);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        f103616a = new OrderSkuDetail("", "", 0, orderShop, "", "", emptyList, emptyList2, 0L, 0L, "", "", 0, 0, new j.PhysicalProduct(0), 8192, null);
    }

    public static final OrderSkuDetail a() {
        return f103616a;
    }

    public static final boolean b(j jVar) {
        return (jVar instanceof j.PhysicalProduct) && ((j.PhysicalProduct) jVar).type == 4;
    }
}
