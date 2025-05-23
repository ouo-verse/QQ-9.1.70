package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/SnapshotProductPic;", "", "url", "", "width", "", "height", "(Ljava/lang/String;II)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SnapshotProductPic {
    public final int height;
    public final String url;
    public final int width;

    public SnapshotProductPic(String str, int i3, int i16) {
        this.url = str;
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final SnapshotProductPic copy(String url, int width, int height) {
        return new SnapshotProductPic(url, width, height);
    }

    public int hashCode() {
        String str = this.url;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "SnapshotProductPic(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotProductPic)) {
            return false;
        }
        SnapshotProductPic snapshotProductPic = (SnapshotProductPic) other;
        return Intrinsics.areEqual(this.url, snapshotProductPic.url) && this.width == snapshotProductPic.width && this.height == snapshotProductPic.height;
    }

    public static /* synthetic */ SnapshotProductPic copy$default(SnapshotProductPic snapshotProductPic, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = snapshotProductPic.url;
        }
        if ((i17 & 2) != 0) {
            i3 = snapshotProductPic.width;
        }
        if ((i17 & 4) != 0) {
            i16 = snapshotProductPic.height;
        }
        return snapshotProductPic.copy(str, i3, i16);
    }
}
