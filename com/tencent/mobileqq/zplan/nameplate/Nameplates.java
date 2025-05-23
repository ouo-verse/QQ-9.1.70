package com.tencent.mobileqq.zplan.nameplate;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/nameplate/b;", "a", "Ljava/util/Collection;", "()Ljava/util/Collection;", "nameplates", "<init>", "(Ljava/util/Collection;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.nameplate.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class Nameplates {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Collection<Nameplate> nameplates;

    public Nameplates() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Collection<Nameplate> a() {
        return this.nameplates;
    }

    public int hashCode() {
        return this.nameplates.hashCode();
    }

    public String toString() {
        return "Nameplates(nameplates=" + this.nameplates + ")";
    }

    public Nameplates(Collection<Nameplate> nameplates) {
        Intrinsics.checkNotNullParameter(nameplates, "nameplates");
        this.nameplates = nameplates;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Nameplates(Collection collection, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection);
        List emptyList;
        if ((i3 & 1) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            collection = emptyList;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Nameplates) && Intrinsics.areEqual(this.nameplates, ((Nameplates) other).nameplates);
    }
}
