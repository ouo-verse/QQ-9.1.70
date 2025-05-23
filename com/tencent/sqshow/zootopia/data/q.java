package com.tencent.sqshow.zootopia.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lgv4/e;", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "reddotList", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<gv4.e> reddotList;

    public q() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<gv4.e> a() {
        return this.reddotList;
    }

    public final void b(List<gv4.e> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.reddotList = list;
    }

    public int hashCode() {
        return this.reddotList.hashCode();
    }

    public String toString() {
        int collectionSizeOrDefault;
        List<gv4.e> list = this.reddotList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (gv4.e eVar : list) {
            arrayList.add("[id = " + eVar.f403425a + " , type = " + eVar.f403426b + "]");
        }
        return arrayList.toString();
    }

    public q(List<gv4.e> reddotList) {
        Intrinsics.checkNotNullParameter(reddotList, "reddotList");
        this.reddotList = reddotList;
    }

    public /* synthetic */ q(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof q) && Intrinsics.areEqual(this.reddotList, ((q) other).reddotList);
    }
}
