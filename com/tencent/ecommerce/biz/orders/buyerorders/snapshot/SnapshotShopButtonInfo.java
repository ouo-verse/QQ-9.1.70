package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotShopButtonInfo;", "", FileReaderHelper.TXT_EXT, "", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotShopButtonInfo {
    public final String txt;

    public SnapshotShopButtonInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTxt() {
        return this.txt;
    }

    public final SnapshotShopButtonInfo copy(String txt) {
        return new SnapshotShopButtonInfo(txt);
    }

    public int hashCode() {
        String str = this.txt;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SnapshotShopButtonInfo(txt=" + this.txt + ")";
    }

    public SnapshotShopButtonInfo(String str) {
        this.txt = str;
    }

    public /* synthetic */ SnapshotShopButtonInfo(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "\u8fdb\u5e97\u901b\u901b" : str);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SnapshotShopButtonInfo) && Intrinsics.areEqual(this.txt, ((SnapshotShopButtonInfo) other).txt);
        }
        return true;
    }

    public static /* synthetic */ SnapshotShopButtonInfo copy$default(SnapshotShopButtonInfo snapshotShopButtonInfo, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = snapshotShopButtonInfo.txt;
        }
        return snapshotShopButtonInfo.copy(str);
    }
}
