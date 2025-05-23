package com.tencent.sqshow.zootopia.nativeui.data.sort;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ah;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/sort/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "newOrderType", "", "Luv4/ah;", "Ljava/util/List;", "()Ljava/util/List;", "changedFilterValue", "<init>", "(ILjava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int newOrderType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ah> changedFilterValue;

    public d(int i3, List<ah> changedFilterValue) {
        Intrinsics.checkNotNullParameter(changedFilterValue, "changedFilterValue");
        this.newOrderType = i3;
        this.changedFilterValue = changedFilterValue;
    }

    public final List<ah> a() {
        return this.changedFilterValue;
    }

    /* renamed from: b, reason: from getter */
    public final int getNewOrderType() {
        return this.newOrderType;
    }

    public int hashCode() {
        return (this.newOrderType * 31) + this.changedFilterValue.hashCode();
    }

    public String toString() {
        return "{newOrderType=" + this.newOrderType + ", changedFilterValue=" + r94.b.H(this.changedFilterValue) + "}";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        return this.newOrderType == dVar.newOrderType && Intrinsics.areEqual(this.changedFilterValue, dVar.changedFilterValue);
    }
}
