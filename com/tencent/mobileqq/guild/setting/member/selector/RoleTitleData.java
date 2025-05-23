package com.tencent.mobileqq.guild.setting.member.selector;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/t;", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "newItem", "", "b", "", "toString", "", "hashCode", "", "other", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.member.selector.t, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RoleTitleData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    public RoleTitleData(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @Override // com.tencent.mobileqq.guild.setting.member.selector.a
    public boolean b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof RoleTitleData) && Intrinsics.areEqual(this.name, ((RoleTitleData) newItem).name)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RoleTitleData) && Intrinsics.areEqual(this.name, ((RoleTitleData) other).name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "RoleTitleData(name=" + this.name + ")";
    }
}
