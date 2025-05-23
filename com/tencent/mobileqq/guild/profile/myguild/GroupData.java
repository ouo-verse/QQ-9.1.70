package com.tencent.mobileqq.guild.profile.myguild;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0006\u0010\n\u001a\u00020\tJ\t\u0010\u000b\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/b;", "Lcom/tencent/mobileqq/guild/profile/myguild/a;", "", tl.h.F, "", "d", "newItem", "", "e", "", "g", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "b", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "i", "()Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "type", "c", "I", "f", "()I", "count", "Z", "j", "()Z", "isCollapse", "<init>", "(Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;IZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.profile.myguild.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GroupData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GroupType type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCollapse;

    public GroupData(@NotNull GroupType type, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.count = i3;
        this.isCollapse = z16;
    }

    @Override // com.tencent.mobileqq.guild.profile.myguild.a
    public long d() {
        return Objects.hash(Integer.valueOf(h()), this.type);
    }

    @Override // com.tencent.mobileqq.guild.profile.myguild.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List<Integer> c(@NotNull a newItem) {
        List<Integer> emptyList;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof GroupData)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        boolean z16 = this.isCollapse;
        boolean z17 = ((GroupData) newItem).isCollapse;
        if (z16 != z17) {
            if (z17) {
                arrayList.add(3);
            } else {
                arrayList.add(2);
            }
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupData)) {
            return false;
        }
        GroupData groupData = (GroupData) other;
        if (this.type == groupData.type && this.count == groupData.count && this.isCollapse == groupData.isCollapse) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String g() {
        return this.type.getGroupName();
    }

    public int h() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.count) * 31;
        boolean z16 = this.isCollapse;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GroupType getType() {
        return this.type;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsCollapse() {
        return this.isCollapse;
    }

    @NotNull
    public String toString() {
        return "GroupData(type=" + this.type + ", count=" + this.count + ", isCollapse=" + this.isCollapse + ")";
    }
}
