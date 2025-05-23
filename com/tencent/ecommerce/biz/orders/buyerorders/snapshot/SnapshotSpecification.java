package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotSpecification;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotSpecification {
    public final String name;
    public final String value;

    public SnapshotSpecification(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final SnapshotSpecification copy(String name, String value) {
        return new SnapshotSpecification(name, value);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotSpecification(name=" + this.name + ", value=" + this.value + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotSpecification)) {
            return false;
        }
        SnapshotSpecification snapshotSpecification = (SnapshotSpecification) other;
        return Intrinsics.areEqual(this.name, snapshotSpecification.name) && Intrinsics.areEqual(this.value, snapshotSpecification.value);
    }

    public static /* synthetic */ SnapshotSpecification copy$default(SnapshotSpecification snapshotSpecification, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = snapshotSpecification.name;
        }
        if ((i3 & 2) != 0) {
            str2 = snapshotSpecification.value;
        }
        return snapshotSpecification.copy(str, str2);
    }
}
