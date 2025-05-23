package com.tencent.mobileqq.search.searchdetail.filter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "", "Lcom/tencent/mobileqq/search/searchdetail/filter/b;", "Ljava/util/List;", "()Ljava/util/List;", "districts", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.filter.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class CityFilter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<DistrictFilter> districts;

    public CityFilter(@NotNull String name, @NotNull List<DistrictFilter> districts) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(districts, "districts");
        this.name = name;
        this.districts = districts;
    }

    @NotNull
    public final List<DistrictFilter> a() {
        return this.districts;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CityFilter)) {
            return false;
        }
        CityFilter cityFilter = (CityFilter) other;
        if (Intrinsics.areEqual(this.name, cityFilter.name) && Intrinsics.areEqual(this.districts, cityFilter.districts)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.districts.hashCode();
    }

    @NotNull
    public String toString() {
        return "CityFilter(name=" + this.name + ", districts=" + this.districts + ")";
    }
}
