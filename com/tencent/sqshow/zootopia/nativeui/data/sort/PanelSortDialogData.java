package com.tencent.sqshow.zootopia.nativeui.data.sort;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ar;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/sort/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "currentOrderType", "", "Luv4/ar;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "orderList", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/a;", "filterList", "<init>", "(ILjava/util/List;Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.sort.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class PanelSortDialogData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int currentOrderType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ar> orderList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<CombineOrderFilterData> filterList;

    public PanelSortDialogData(int i3, List<ar> orderList, List<CombineOrderFilterData> filterList) {
        Intrinsics.checkNotNullParameter(orderList, "orderList");
        Intrinsics.checkNotNullParameter(filterList, "filterList");
        this.currentOrderType = i3;
        this.orderList = orderList;
        this.filterList = filterList;
    }

    /* renamed from: a, reason: from getter */
    public final int getCurrentOrderType() {
        return this.currentOrderType;
    }

    public final List<CombineOrderFilterData> b() {
        return this.filterList;
    }

    public final List<ar> c() {
        return this.orderList;
    }

    public int hashCode() {
        return (((this.currentOrderType * 31) + this.orderList.hashCode()) * 31) + this.filterList.hashCode();
    }

    public String toString() {
        return "PanelSortDialogData(currentOrderType=" + this.currentOrderType + ", orderList=" + this.orderList + ", filterList=" + this.filterList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelSortDialogData)) {
            return false;
        }
        PanelSortDialogData panelSortDialogData = (PanelSortDialogData) other;
        return this.currentOrderType == panelSortDialogData.currentOrderType && Intrinsics.areEqual(this.orderList, panelSortDialogData.orderList) && Intrinsics.areEqual(this.filterList, panelSortDialogData.filterList);
    }
}
