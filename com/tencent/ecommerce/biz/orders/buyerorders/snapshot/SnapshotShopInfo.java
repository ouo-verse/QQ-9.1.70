package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopInfo;", "", "id", "", "icon", "name", "button", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopButtonInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopButtonInfo;)V", "getButton", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopButtonInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotShopInfo {
    private final SnapshotShopButtonInfo button;
    public final String icon;
    public final String id;
    public final String name;

    public SnapshotShopInfo(String str, String str2, String str3, SnapshotShopButtonInfo snapshotShopButtonInfo) {
        this.id = str;
        this.icon = str2;
        this.name = str3;
        this.button = snapshotShopButtonInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final SnapshotShopButtonInfo getButton() {
        return this.button;
    }

    public final SnapshotShopInfo copy(String id5, String icon, String name, SnapshotShopButtonInfo button) {
        return new SnapshotShopInfo(id5, icon, name, button);
    }

    public final SnapshotShopButtonInfo getButton() {
        return this.button;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SnapshotShopButtonInfo snapshotShopButtonInfo = this.button;
        return hashCode3 + (snapshotShopButtonInfo != null ? snapshotShopButtonInfo.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotShopInfo(id=" + this.id + ", icon=" + this.icon + ", name=" + this.name + ", button=" + this.button + ")";
    }

    public /* synthetic */ SnapshotShopInfo(String str, String str2, String str3, SnapshotShopButtonInfo snapshotShopButtonInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? new SnapshotShopButtonInfo(null, 1, null) : snapshotShopButtonInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotShopInfo)) {
            return false;
        }
        SnapshotShopInfo snapshotShopInfo = (SnapshotShopInfo) other;
        return Intrinsics.areEqual(this.id, snapshotShopInfo.id) && Intrinsics.areEqual(this.icon, snapshotShopInfo.icon) && Intrinsics.areEqual(this.name, snapshotShopInfo.name) && Intrinsics.areEqual(this.button, snapshotShopInfo.button);
    }

    public static /* synthetic */ SnapshotShopInfo copy$default(SnapshotShopInfo snapshotShopInfo, String str, String str2, String str3, SnapshotShopButtonInfo snapshotShopButtonInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = snapshotShopInfo.id;
        }
        if ((i3 & 2) != 0) {
            str2 = snapshotShopInfo.icon;
        }
        if ((i3 & 4) != 0) {
            str3 = snapshotShopInfo.name;
        }
        if ((i3 & 8) != 0) {
            snapshotShopButtonInfo = snapshotShopInfo.button;
        }
        return snapshotShopInfo.copy(str, str2, str3, snapshotShopButtonInfo);
    }
}
