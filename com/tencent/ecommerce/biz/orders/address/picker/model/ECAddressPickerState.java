package com.tencent.ecommerce.biz.orders.address.picker.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/model/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "selectedAddress", "b", "districtAddressInfoListList", "Z", "d", "()Z", "isFinishSelected", "menuList", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.address.picker.model.f, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAddressPickerState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<DistrictAddressInfo> selectedAddress;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<List<DistrictAddressInfo>> districtAddressInfoListList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFinishSelected;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAddressPickerState(List<DistrictAddressInfo> list, List<? extends List<DistrictAddressInfo>> list2, boolean z16) {
        this.selectedAddress = list;
        this.districtAddressInfoListList = list2;
        this.isFinishSelected = z16;
    }

    public final List<List<DistrictAddressInfo>> a() {
        return this.districtAddressInfoListList;
    }

    public final List<String> b() {
        int collectionSizeOrDefault;
        List<DistrictAddressInfo> list = this.selectedAddress;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((DistrictAddressInfo) obj).type.ordinal() > DistrictType.Nation.ordinal()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((DistrictAddressInfo) it.next()).name);
        }
        return arrayList2;
    }

    public final List<DistrictAddressInfo> c() {
        return this.selectedAddress;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsFinishSelected() {
        return this.isFinishSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<DistrictAddressInfo> list = this.selectedAddress;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<List<DistrictAddressInfo>> list2 = this.districtAddressInfoListList;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z16 = this.isFinishSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "ECAddressPickerState(selectedAddress=" + this.selectedAddress + ", districtAddressInfoListList=" + this.districtAddressInfoListList + ", isFinishSelected=" + this.isFinishSelected + ")";
    }

    public /* synthetic */ ECAddressPickerState(List list, List list2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i3 & 4) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAddressPickerState)) {
            return false;
        }
        ECAddressPickerState eCAddressPickerState = (ECAddressPickerState) other;
        return Intrinsics.areEqual(this.selectedAddress, eCAddressPickerState.selectedAddress) && Intrinsics.areEqual(this.districtAddressInfoListList, eCAddressPickerState.districtAddressInfoListList) && this.isFinishSelected == eCAddressPickerState.isFinishSelected;
    }
}
