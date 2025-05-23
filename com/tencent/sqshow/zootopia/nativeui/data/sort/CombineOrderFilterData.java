package com.tencent.sqshow.zootopia.nativeui.data.sort;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ah;
import uv4.ap;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/sort/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Luv4/ap;", "a", "Luv4/ap;", "()Luv4/ap;", "filter", "Luv4/ah;", "b", "Luv4/ah;", "()Luv4/ah;", "value", "<init>", "(Luv4/ap;Luv4/ah;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.sort.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class CombineOrderFilterData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ap filter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ah value;

    public CombineOrderFilterData(ap filter, ah value) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(value, "value");
        this.filter = filter;
        this.value = value;
    }

    /* renamed from: a, reason: from getter */
    public final ap getFilter() {
        return this.filter;
    }

    /* renamed from: b, reason: from getter */
    public final ah getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.filter.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "CombineOrderFilterData(filter=" + this.filter + ", value=" + this.value + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CombineOrderFilterData)) {
            return false;
        }
        CombineOrderFilterData combineOrderFilterData = (CombineOrderFilterData) other;
        return Intrinsics.areEqual(this.filter, combineOrderFilterData.filter) && Intrinsics.areEqual(this.value, combineOrderFilterData.value);
    }
}
