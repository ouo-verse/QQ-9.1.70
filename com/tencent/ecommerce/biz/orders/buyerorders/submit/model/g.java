package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponOrderInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g {
    public static final List<String> a(ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo) {
        int collectionSizeOrDefault;
        List<ECQshopOrderQuerySvr$CouponOrderInfo> list = eCQshopOrderQuerySvr$CouponInfo.coupon_order_info.get();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ECQshopOrderQuerySvr$CouponOrderInfo) obj).is_user_select.get()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ECQshopOrderQuerySvr$CouponOrderInfo) it.next()).coupon_id.get());
        }
        return arrayList2;
    }
}
