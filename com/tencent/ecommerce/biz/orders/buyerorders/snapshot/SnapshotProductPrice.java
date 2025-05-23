package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductPrice;", "", "priceTxt", "", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotProductPrice {

    @SerializedName("price_txt")
    public final String priceTxt;

    public SnapshotProductPrice(String str) {
        this.priceTxt = str;
    }

    /* renamed from: component1, reason: from getter */
    public final String getPriceTxt() {
        return this.priceTxt;
    }

    public final SnapshotProductPrice copy(String priceTxt) {
        return new SnapshotProductPrice(priceTxt);
    }

    public int hashCode() {
        String str = this.priceTxt;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SnapshotProductPrice(priceTxt=" + this.priceTxt + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SnapshotProductPrice) && Intrinsics.areEqual(this.priceTxt, ((SnapshotProductPrice) other).priceTxt);
        }
        return true;
    }

    public static /* synthetic */ SnapshotProductPrice copy$default(SnapshotProductPrice snapshotProductPrice, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = snapshotProductPrice.priceTxt;
        }
        return snapshotProductPrice.copy(str);
    }
}
