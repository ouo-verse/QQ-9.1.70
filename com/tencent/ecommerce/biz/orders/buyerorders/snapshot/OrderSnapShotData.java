package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.ecommerce.base.network.json.IgnoreFailureTypeAdapterFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/OrderSnapShotData;", "", "", "toJsonString", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductInfo;", "component1", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotOrderInfo;", "component2", "productInfo", "orderInfo", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductInfo;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotOrderInfo;", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductInfo;Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotOrderInfo;)V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class OrderSnapShotData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Gson gson = new GsonBuilder().registerTypeAdapterFactory(new IgnoreFailureTypeAdapterFactory()).create();

    @SerializedName("order_info")
    public final SnapshotOrderInfo orderInfo;

    @SerializedName("product_info")
    public final SnapshotProductInfo productInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/OrderSnapShotData$a;", "", "", "jsonStr", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/OrderSnapShotData;", "a", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.snapshot.OrderSnapShotData$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final OrderSnapShotData a(String jsonStr) {
            return (OrderSnapShotData) OrderSnapShotData.gson.fromJson(jsonStr, OrderSnapShotData.class);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderSnapShotData(SnapshotProductInfo snapshotProductInfo, SnapshotOrderInfo snapshotOrderInfo) {
        this.productInfo = snapshotProductInfo;
        this.orderInfo = snapshotOrderInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final SnapshotProductInfo getProductInfo() {
        return this.productInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final SnapshotOrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public final OrderSnapShotData copy(SnapshotProductInfo productInfo, SnapshotOrderInfo orderInfo) {
        return new OrderSnapShotData(productInfo, orderInfo);
    }

    public int hashCode() {
        SnapshotProductInfo snapshotProductInfo = this.productInfo;
        int hashCode = (snapshotProductInfo != null ? snapshotProductInfo.hashCode() : 0) * 31;
        SnapshotOrderInfo snapshotOrderInfo = this.orderInfo;
        return hashCode + (snapshotOrderInfo != null ? snapshotOrderInfo.hashCode() : 0);
    }

    public final String toJsonString() {
        return gson.toJson(this);
    }

    public String toString() {
        return "OrderSnapShotData(productInfo=" + this.productInfo + ", orderInfo=" + this.orderInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderSnapShotData)) {
            return false;
        }
        OrderSnapShotData orderSnapShotData = (OrderSnapShotData) other;
        return Intrinsics.areEqual(this.productInfo, orderSnapShotData.productInfo) && Intrinsics.areEqual(this.orderInfo, orderSnapShotData.orderInfo);
    }

    public static /* synthetic */ OrderSnapShotData copy$default(OrderSnapShotData orderSnapShotData, SnapshotProductInfo snapshotProductInfo, SnapshotOrderInfo snapshotOrderInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            snapshotProductInfo = orderSnapShotData.productInfo;
        }
        if ((i3 & 2) != 0) {
            snapshotOrderInfo = orderSnapShotData.orderInfo;
        }
        return orderSnapShotData.copy(snapshotProductInfo, snapshotOrderInfo);
    }
}
