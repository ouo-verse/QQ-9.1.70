package com.tencent.ecommerce.biz.orders.buyerorders.detail.model;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PicInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$PropertyItem;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$PicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002\"\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$PicInfo;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/c;", "e", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$PicInfo;", "f", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$PropertyItem;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/d;", "g", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "d", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "EMPTY_ORDER_SPU_DETAIL", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a */
    private static final OrderSpuDetail f103220a;

    static {
        List emptyList;
        List emptyList2;
        List emptyList3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        f103220a = new OrderSpuDetail("", "", "", "", emptyList, emptyList2, emptyList3, 0L, null, 256, null);
    }

    public static final /* synthetic */ OrderSpuPicInfo a(ECOrderCommon$PicInfo eCOrderCommon$PicInfo) {
        return e(eCOrderCommon$PicInfo);
    }

    public static final /* synthetic */ OrderSpuPicInfo b(ECSampleData$PicInfo eCSampleData$PicInfo) {
        return f(eCSampleData$PicInfo);
    }

    public static final /* synthetic */ OrderSpuProperty c(ECOrderCommon$PropertyItem eCOrderCommon$PropertyItem) {
        return g(eCOrderCommon$PropertyItem);
    }

    public static final OrderSpuDetail d() {
        return f103220a;
    }

    public static final OrderSpuPicInfo e(ECOrderCommon$PicInfo eCOrderCommon$PicInfo) {
        return new OrderSpuPicInfo(eCOrderCommon$PicInfo.url.get(), eCOrderCommon$PicInfo.width.get(), eCOrderCommon$PicInfo.height.get());
    }

    public static final OrderSpuPicInfo f(ECSampleData$PicInfo eCSampleData$PicInfo) {
        return new OrderSpuPicInfo(eCSampleData$PicInfo.url.get(), eCSampleData$PicInfo.width.get(), eCSampleData$PicInfo.height.get());
    }

    public static final OrderSpuProperty g(ECOrderCommon$PropertyItem eCOrderCommon$PropertyItem) {
        return new OrderSpuProperty(eCOrderCommon$PropertyItem.f105236id.get(), eCOrderCommon$PropertyItem.name.get(), eCOrderCommon$PropertyItem.value.get());
    }
}
