package com.tencent.ecommerce.biz.orders.common;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$UsedCouponItem;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "id", "b", "batchId", "c", "issuerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.i, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class QShopOrderCouponInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String batchId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String issuerId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/i$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$UsedCouponItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/ecommerce/biz/orders/common/i;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.i$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final QShopOrderCouponInfo a(ECOrderCommon$UsedCouponItem item) {
            String joinToString$default;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(item.coupon_id.get(), ";", null, null, 0, null, null, 62, null);
            return new QShopOrderCouponInfo(joinToString$default, item.coupon_batch_id.get(), item.issuer.f105233id.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public QShopOrderCouponInfo(String str, String str2, String str3) {
        this.id = str;
        this.batchId = str2;
        this.issuerId = str3;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.batchId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.issuerId;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "QShopOrderCouponInfo(id=" + this.id + ", batchId=" + this.batchId + ", issuerId=" + this.issuerId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QShopOrderCouponInfo)) {
            return false;
        }
        QShopOrderCouponInfo qShopOrderCouponInfo = (QShopOrderCouponInfo) other;
        return Intrinsics.areEqual(this.id, qShopOrderCouponInfo.id) && Intrinsics.areEqual(this.batchId, qShopOrderCouponInfo.batchId) && Intrinsics.areEqual(this.issuerId, qShopOrderCouponInfo.issuerId);
    }
}
