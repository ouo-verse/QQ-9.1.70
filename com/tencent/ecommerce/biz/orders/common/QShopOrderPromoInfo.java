package com.tencent.ecommerce.biz.orders.common;

import androidx.core.app.NotificationCompat;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$Promo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderPromoType;", "a", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderPromoType;", "type", "", "b", "J", "price", "c", "Ljava/lang/String;", "message", "d", "activityId", "<init>", "(Lcom/tencent/ecommerce/biz/orders/common/QShopOrderPromoType;JLjava/lang/String;Ljava/lang/String;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.common.j, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class QShopOrderPromoInfo {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final QShopOrderPromoType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long price;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String message;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String activityId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/j$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$Promo;", NotificationCompat.CATEGORY_PROMO, "Lcom/tencent/ecommerce/biz/orders/common/j;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.common.j$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final QShopOrderPromoInfo a(ECOrderCommon$Promo promo) {
            return new QShopOrderPromoInfo(QShopOrderPromoType.INSTANCE.a(promo.promo_type.get()), promo.promo_price.get(), promo.f105235msg.get(), promo.activity_id.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public QShopOrderPromoInfo(QShopOrderPromoType qShopOrderPromoType, long j3, String str, String str2) {
        this.type = qShopOrderPromoType;
        this.price = j3;
        this.message = str;
        this.activityId = str2;
    }

    public int hashCode() {
        QShopOrderPromoType qShopOrderPromoType = this.type;
        int hashCode = (((qShopOrderPromoType != null ? qShopOrderPromoType.hashCode() : 0) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.price)) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.activityId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "QShopOrderPromoInfo(type=" + this.type + ", price=" + this.price + ", message=" + this.message + ", activityId=" + this.activityId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QShopOrderPromoInfo)) {
            return false;
        }
        QShopOrderPromoInfo qShopOrderPromoInfo = (QShopOrderPromoInfo) other;
        return Intrinsics.areEqual(this.type, qShopOrderPromoInfo.type) && this.price == qShopOrderPromoInfo.price && Intrinsics.areEqual(this.message, qShopOrderPromoInfo.message) && Intrinsics.areEqual(this.activityId, qShopOrderPromoInfo.activityId);
    }
}
