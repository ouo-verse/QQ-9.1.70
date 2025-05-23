package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "a", "Ljava/util/List;", "()Ljava/util/List;", "activeGroups", "b", "inactiveGroups", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProBindingGroup> activeGroups;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProBindingGroup> inactiveGroups;

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull List<? extends IGProBindingGroup> activeGroups, @NotNull List<? extends IGProBindingGroup> inactiveGroups) {
        Intrinsics.checkNotNullParameter(activeGroups, "activeGroups");
        Intrinsics.checkNotNullParameter(inactiveGroups, "inactiveGroups");
        this.activeGroups = activeGroups;
        this.inactiveGroups = inactiveGroups;
    }

    @NotNull
    public final List<IGProBindingGroup> a() {
        return this.activeGroups;
    }

    @NotNull
    public final List<IGProBindingGroup> b() {
        return this.inactiveGroups;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.activeGroups, fVar.activeGroups) && Intrinsics.areEqual(this.inactiveGroups, fVar.inactiveGroups)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.activeGroups.hashCode() * 31) + this.inactiveGroups.hashCode();
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<IGProBindingGroup> list = this.activeGroups;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProBindingGroup iGProBindingGroup : list) {
            arrayList.add(iGProBindingGroup.getGroupCode() + "-" + iGProBindingGroup.getGroupFlag());
        }
        List<IGProBindingGroup> list2 = this.inactiveGroups;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (IGProBindingGroup iGProBindingGroup2 : list2) {
            arrayList2.add(iGProBindingGroup2.getGroupCode() + "-" + iGProBindingGroup2.getGroupFlag());
        }
        return "BindableGroupData(actives=" + arrayList + ", inactiveGroups=" + arrayList2 + ")";
    }
}
