package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J3\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "timeOption", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "platformOptions", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/b;", "orderStatusOptions", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "c", "<init>", "(Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;Ljava/util/List;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class FilterDialogSelectedOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final g timeOption;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<c> platformOptions;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<b> orderStatusOptions;

    public FilterDialogSelectedOption() {
        this(null, null, null, 7, null);
    }

    public final FilterDialogSelectedOption a(g timeOption, List<c> platformOptions, List<? extends b> orderStatusOptions) {
        return new FilterDialogSelectedOption(timeOption, platformOptions, orderStatusOptions);
    }

    public final List<b> c() {
        return this.orderStatusOptions;
    }

    public final List<c> d() {
        return this.platformOptions;
    }

    public int hashCode() {
        g gVar = this.timeOption;
        int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
        List<c> list = this.platformOptions;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<b> list2 = this.orderStatusOptions;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "FilterDialogSelectedOption(timeOption=" + this.timeOption + ", platformOptions=" + this.platformOptions + ", orderStatusOptions=" + this.orderStatusOptions + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterDialogSelectedOption(g gVar, List<c> list, List<? extends b> list2) {
        this.timeOption = gVar;
        this.platformOptions = list;
        this.orderStatusOptions = list2;
    }

    public /* synthetic */ FilterDialogSelectedOption(g gVar, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? g.a.f103876c : gVar, (i3 & 2) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(e.a()) : list, (i3 & 4) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(b.a.f103855c) : list2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterDialogSelectedOption)) {
            return false;
        }
        FilterDialogSelectedOption filterDialogSelectedOption = (FilterDialogSelectedOption) other;
        return Intrinsics.areEqual(this.timeOption, filterDialogSelectedOption.timeOption) && Intrinsics.areEqual(this.platformOptions, filterDialogSelectedOption.platformOptions) && Intrinsics.areEqual(this.orderStatusOptions, filterDialogSelectedOption.orderStatusOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterDialogSelectedOption b(FilterDialogSelectedOption filterDialogSelectedOption, g gVar, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gVar = filterDialogSelectedOption.timeOption;
        }
        if ((i3 & 2) != 0) {
            list = filterDialogSelectedOption.platformOptions;
        }
        if ((i3 & 4) != 0) {
            list2 = filterDialogSelectedOption.orderStatusOptions;
        }
        return filterDialogSelectedOption.a(gVar, list, list2);
    }
}
