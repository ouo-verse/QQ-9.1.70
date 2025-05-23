package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotOrderInfo;", "", "id", "", "specStr", "propertyStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotOrderInfo {
    public final String id;

    @SerializedName("property_str")
    public final String propertyStr;

    @SerializedName("spec_str")
    public final String specStr;

    public SnapshotOrderInfo(String str, String str2, String str3) {
        this.id = str;
        this.specStr = str2;
        this.propertyStr = str3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSpecStr() {
        return this.specStr;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPropertyStr() {
        return this.propertyStr;
    }

    public final SnapshotOrderInfo copy(String id5, String specStr, String propertyStr) {
        return new SnapshotOrderInfo(id5, specStr, propertyStr);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.specStr;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.propertyStr;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotOrderInfo(id=" + this.id + ", specStr=" + this.specStr + ", propertyStr=" + this.propertyStr + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotOrderInfo)) {
            return false;
        }
        SnapshotOrderInfo snapshotOrderInfo = (SnapshotOrderInfo) other;
        return Intrinsics.areEqual(this.id, snapshotOrderInfo.id) && Intrinsics.areEqual(this.specStr, snapshotOrderInfo.specStr) && Intrinsics.areEqual(this.propertyStr, snapshotOrderInfo.propertyStr);
    }

    public static /* synthetic */ SnapshotOrderInfo copy$default(SnapshotOrderInfo snapshotOrderInfo, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = snapshotOrderInfo.id;
        }
        if ((i3 & 2) != 0) {
            str2 = snapshotOrderInfo.specStr;
        }
        if ((i3 & 4) != 0) {
            str3 = snapshotOrderInfo.propertyStr;
        }
        return snapshotOrderInfo.copy(str, str2, str3);
    }
}
