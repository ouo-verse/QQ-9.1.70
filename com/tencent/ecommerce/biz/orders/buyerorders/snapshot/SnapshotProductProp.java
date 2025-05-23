package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductProp;", "", "id", "", "name", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotProductProp {
    public final String id;
    public final String name;
    public final String value;

    public SnapshotProductProp(String str, String str2, String str3) {
        this.id = str;
        this.name = str2;
        this.value = str3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final SnapshotProductProp copy(String id5, String name, String value) {
        return new SnapshotProductProp(id5, name, value);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotProductProp(id=" + this.id + ", name=" + this.name + ", value=" + this.value + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotProductProp)) {
            return false;
        }
        SnapshotProductProp snapshotProductProp = (SnapshotProductProp) other;
        return Intrinsics.areEqual(this.id, snapshotProductProp.id) && Intrinsics.areEqual(this.name, snapshotProductProp.name) && Intrinsics.areEqual(this.value, snapshotProductProp.value);
    }

    public static /* synthetic */ SnapshotProductProp copy$default(SnapshotProductProp snapshotProductProp, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = snapshotProductProp.id;
        }
        if ((i3 & 2) != 0) {
            str2 = snapshotProductProp.name;
        }
        if ((i3 & 4) != 0) {
            str3 = snapshotProductProp.value;
        }
        return snapshotProductProp.copy(str, str2, str3);
    }
}
