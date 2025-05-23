package com.tencent.ecommerce.biz.orders.sellerorders.orderfilter;

import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.f;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJG\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;", "", "", "searchKey", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;", "category", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "timeOption", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "platformOptions", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/b;", "orderStatusOptions", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;", "c", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;", "d", "Ljava/util/List;", "()Ljava/util/List;", "e", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/f;Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/g;Ljava/util/List;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class SellerOrderFilterOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String searchKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final f category;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final g timeOption;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<c> platformOptions;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<b> orderStatusOptions;

    public SellerOrderFilterOption() {
        this(null, null, null, null, null, 31, null);
    }

    public final SellerOrderFilterOption a(String searchKey, f category, g timeOption, List<c> platformOptions, List<? extends b> orderStatusOptions) {
        return new SellerOrderFilterOption(searchKey, category, timeOption, platformOptions, orderStatusOptions);
    }

    public final List<b> c() {
        return this.orderStatusOptions;
    }

    public final List<c> d() {
        return this.platformOptions;
    }

    public int hashCode() {
        String str = this.searchKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        f fVar = this.category;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 31;
        g gVar = this.timeOption;
        int hashCode3 = (hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
        List<c> list = this.platformOptions;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<b> list2 = this.orderStatusOptions;
        return hashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "SellerOrderFilterOption(searchKey=" + this.searchKey + ", category=" + this.category + ", timeOption=" + this.timeOption + ", platformOptions=" + this.platformOptions + ", orderStatusOptions=" + this.orderStatusOptions + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SellerOrderFilterOption(String str, f fVar, g gVar, List<c> list, List<? extends b> list2) {
        this.searchKey = str;
        this.category = fVar;
        this.timeOption = gVar;
        this.platformOptions = list;
        this.orderStatusOptions = list2;
    }

    public /* synthetic */ SellerOrderFilterOption(String str, f fVar, g gVar, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? f.a.f103871c : fVar, (i3 & 4) != 0 ? g.a.f103876c : gVar, (i3 & 8) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(e.a()) : list, (i3 & 16) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(b.a.f103855c) : list2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SellerOrderFilterOption)) {
            return false;
        }
        SellerOrderFilterOption sellerOrderFilterOption = (SellerOrderFilterOption) other;
        return Intrinsics.areEqual(this.searchKey, sellerOrderFilterOption.searchKey) && Intrinsics.areEqual(this.category, sellerOrderFilterOption.category) && Intrinsics.areEqual(this.timeOption, sellerOrderFilterOption.timeOption) && Intrinsics.areEqual(this.platformOptions, sellerOrderFilterOption.platformOptions) && Intrinsics.areEqual(this.orderStatusOptions, sellerOrderFilterOption.orderStatusOptions);
    }

    public static /* synthetic */ SellerOrderFilterOption b(SellerOrderFilterOption sellerOrderFilterOption, String str, f fVar, g gVar, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sellerOrderFilterOption.searchKey;
        }
        if ((i3 & 2) != 0) {
            fVar = sellerOrderFilterOption.category;
        }
        f fVar2 = fVar;
        if ((i3 & 4) != 0) {
            gVar = sellerOrderFilterOption.timeOption;
        }
        g gVar2 = gVar;
        if ((i3 & 8) != 0) {
            list = sellerOrderFilterOption.platformOptions;
        }
        List list3 = list;
        if ((i3 & 16) != 0) {
            list2 = sellerOrderFilterOption.orderStatusOptions;
        }
        return sellerOrderFilterOption.a(str, fVar2, gVar2, list3, list2);
    }
}
