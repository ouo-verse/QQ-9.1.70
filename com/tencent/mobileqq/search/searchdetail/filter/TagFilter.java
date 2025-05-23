package com.tencent.mobileqq.search.searchdetail.filter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.filter.j, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class TagFilter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    public TagFilter(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TagFilter) && Intrinsics.areEqual(this.name, ((TagFilter) other).name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "TagFilter(name=" + this.name + ")";
    }
}
