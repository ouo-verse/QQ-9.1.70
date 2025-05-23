package ck0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lck0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "id", "b", "Ljava/lang/String;", "name", "c", "I", "goodsType", "d", "Z", "isSelected", "()Z", "<init>", "(JLjava/lang/String;IZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ck0.b, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class Category {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int goodsType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelected;

    public Category() {
        this(0L, null, 0, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = com.tencent.ecommerce.biz.commission.forecast.b.a(this.id) * 31;
        String str = this.name;
        int hashCode = (((a16 + (str != null ? str.hashCode() : 0)) * 31) + this.goodsType) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "Category(id=" + this.id + ", name=" + this.name + ", goodsType=" + this.goodsType + ", isSelected=" + this.isSelected + ")";
    }

    public Category(long j3, String str, int i3, boolean z16) {
        this.id = j3;
        this.name = str;
        this.goodsType = i3;
        this.isSelected = z16;
    }

    public /* synthetic */ Category(long j3, String str, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1L : j3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Category)) {
            return false;
        }
        Category category = (Category) other;
        return this.id == category.id && Intrinsics.areEqual(this.name, category.name) && this.goodsType == category.goodsType && this.isSelected == category.isSelected;
    }
}
