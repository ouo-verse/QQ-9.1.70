package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\tH\u00c6\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductInfo;", "", "spuId", "", "bizType", "", "product", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProduct;", "shop", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopInfo;", "(Ljava/lang/String;ILcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProduct;Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopInfo;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotProductInfo {

    @SerializedName("biz_type")
    public final int bizType;
    public final SnapshotProduct product;
    public final SnapshotShopInfo shop;

    @SerializedName("spu_id")
    public final String spuId;

    public SnapshotProductInfo(String str, int i3, SnapshotProduct snapshotProduct, SnapshotShopInfo snapshotShopInfo) {
        this.spuId = str;
        this.bizType = i3;
        this.product = snapshotProduct;
        this.shop = snapshotShopInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSpuId() {
        return this.spuId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBizType() {
        return this.bizType;
    }

    /* renamed from: component3, reason: from getter */
    public final SnapshotProduct getProduct() {
        return this.product;
    }

    /* renamed from: component4, reason: from getter */
    public final SnapshotShopInfo getShop() {
        return this.shop;
    }

    public final SnapshotProductInfo copy(String spuId, int bizType, SnapshotProduct product, SnapshotShopInfo shop) {
        return new SnapshotProductInfo(spuId, bizType, product, shop);
    }

    public int hashCode() {
        String str = this.spuId;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.bizType) * 31;
        SnapshotProduct snapshotProduct = this.product;
        int hashCode2 = (hashCode + (snapshotProduct != null ? snapshotProduct.hashCode() : 0)) * 31;
        SnapshotShopInfo snapshotShopInfo = this.shop;
        return hashCode2 + (snapshotShopInfo != null ? snapshotShopInfo.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotProductInfo(spuId=" + this.spuId + ", bizType=" + this.bizType + ", product=" + this.product + ", shop=" + this.shop + ")";
    }

    public /* synthetic */ SnapshotProductInfo(String str, int i3, SnapshotProduct snapshotProduct, SnapshotShopInfo snapshotShopInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 1 : i3, snapshotProduct, snapshotShopInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotProductInfo)) {
            return false;
        }
        SnapshotProductInfo snapshotProductInfo = (SnapshotProductInfo) other;
        return Intrinsics.areEqual(this.spuId, snapshotProductInfo.spuId) && this.bizType == snapshotProductInfo.bizType && Intrinsics.areEqual(this.product, snapshotProductInfo.product) && Intrinsics.areEqual(this.shop, snapshotProductInfo.shop);
    }

    public static /* synthetic */ SnapshotProductInfo copy$default(SnapshotProductInfo snapshotProductInfo, String str, int i3, SnapshotProduct snapshotProduct, SnapshotShopInfo snapshotShopInfo, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = snapshotProductInfo.spuId;
        }
        if ((i16 & 2) != 0) {
            i3 = snapshotProductInfo.bizType;
        }
        if ((i16 & 4) != 0) {
            snapshotProduct = snapshotProductInfo.product;
        }
        if ((i16 & 8) != 0) {
            snapshotShopInfo = snapshotProductInfo.shop;
        }
        return snapshotProductInfo.copy(str, i3, snapshotProduct, snapshotShopInfo);
    }
}
