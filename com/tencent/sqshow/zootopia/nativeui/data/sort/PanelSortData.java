package com.tencent.sqshow.zootopia.nativeui.data.sort;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.ah;
import uv4.ap;
import uv4.ar;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\tj\b\u0012\u0004\u0012\u00020\u0011`\u000b\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\tj\b\u0012\u0004\u0012\u00020\u0014`\u000b\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\tj\b\u0012\u0004\u0012\u00020\u0011`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000fR'\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\tj\b\u0012\u0004\u0012\u00020\u0014`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0015\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b#\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Luv4/ar;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "orderTypePool", "Luv4/ap;", "b", "filterTypePool", "Luv4/ah;", "c", "filterValuePool", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "f", "(Ljava/lang/Integer;)V", "currentOrderType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/d;", "e", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "sortDataChangeInfo", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/GenderFilter;", "getCurrentGenderFilter", "currentGenderFilter", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.sort.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class PanelSortData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<ar> orderTypePool;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<ap> filterTypePool;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<ah> filterValuePool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Integer currentOrderType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<d> sortDataChangeInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<GenderFilter> currentGenderFilter;

    public PanelSortData() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Integer getCurrentOrderType() {
        return this.currentOrderType;
    }

    public final ArrayList<ap> b() {
        return this.filterTypePool;
    }

    public final ArrayList<ah> c() {
        return this.filterValuePool;
    }

    public final ArrayList<ar> d() {
        return this.orderTypePool;
    }

    public final MutableLiveData<d> e() {
        return this.sortDataChangeInfo;
    }

    public final void f(Integer num) {
        this.currentOrderType = num;
    }

    public int hashCode() {
        return (((this.orderTypePool.hashCode() * 31) + this.filterTypePool.hashCode()) * 31) + this.filterValuePool.hashCode();
    }

    public String toString() {
        return "PanelSortData(orderTypePool=" + this.orderTypePool + ", filterTypePool=" + this.filterTypePool + ", filterValuePool=" + this.filterValuePool + ")";
    }

    public PanelSortData(ArrayList<ar> orderTypePool, ArrayList<ap> filterTypePool, ArrayList<ah> filterValuePool) {
        Intrinsics.checkNotNullParameter(orderTypePool, "orderTypePool");
        Intrinsics.checkNotNullParameter(filterTypePool, "filterTypePool");
        Intrinsics.checkNotNullParameter(filterValuePool, "filterValuePool");
        this.orderTypePool = orderTypePool;
        this.filterTypePool = filterTypePool;
        this.filterValuePool = filterValuePool;
        this.sortDataChangeInfo = new MutableLiveData<>();
        MutableLiveData<GenderFilter> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(GenderFilter.ALL);
        this.currentGenderFilter = mutableLiveData;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelSortData)) {
            return false;
        }
        PanelSortData panelSortData = (PanelSortData) other;
        return Intrinsics.areEqual(this.orderTypePool, panelSortData.orderTypePool) && Intrinsics.areEqual(this.filterTypePool, panelSortData.filterTypePool) && Intrinsics.areEqual(this.filterValuePool, panelSortData.filterValuePool);
    }

    public /* synthetic */ PanelSortData(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList, (i3 & 2) != 0 ? new ArrayList() : arrayList2, (i3 & 4) != 0 ? new ArrayList() : arrayList3);
    }
}
