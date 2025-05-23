package com.tencent.mobileqq.data.troop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/data/troop/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "c", "pyFirst", "pyAll", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.data.troop.c, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class TroopMemberNickSearchInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pyFirst;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pyAll;

    public TroopMemberNickSearchInfo(@NotNull String name, @NotNull String pyFirst, @NotNull String pyAll) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pyFirst, "pyFirst");
        Intrinsics.checkNotNullParameter(pyAll, "pyAll");
        this.name = name;
        this.pyFirst = pyFirst;
        this.pyAll = pyAll;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPyAll() {
        return this.pyAll;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPyFirst() {
        return this.pyFirst;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopMemberNickSearchInfo)) {
            return false;
        }
        TroopMemberNickSearchInfo troopMemberNickSearchInfo = (TroopMemberNickSearchInfo) other;
        if (Intrinsics.areEqual(this.name, troopMemberNickSearchInfo.name) && Intrinsics.areEqual(this.pyFirst, troopMemberNickSearchInfo.pyFirst) && Intrinsics.areEqual(this.pyAll, troopMemberNickSearchInfo.pyAll)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.pyFirst.hashCode()) * 31) + this.pyAll.hashCode();
    }

    @NotNull
    public String toString() {
        return "TroopMemberNickSearchInfo(name=" + this.name + ", pyFirst=" + this.pyFirst + ", pyAll=" + this.pyAll + ')';
    }
}
