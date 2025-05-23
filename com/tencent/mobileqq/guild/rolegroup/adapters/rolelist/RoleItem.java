package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/s;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "c", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "d", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/g;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/g;", "()Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/g;", "extra", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.s, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RoleItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RoleGroupModel role;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final DisplayExtra extra;

    public /* synthetic */ RoleItem(RoleGroupModel roleGroupModel, DisplayExtra displayExtra, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(roleGroupModel, (i3 & 2) != 0 ? new DisplayExtra(false, null, 3, null) : displayExtra);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final DisplayExtra getExtra() {
        return this.extra;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RoleGroupModel getRole() {
        return this.role;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleItem)) {
            return false;
        }
        RoleItem roleItem = (RoleItem) other;
        if (Intrinsics.areEqual(this.role, roleItem.role) && Intrinsics.areEqual(this.extra, roleItem.extra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.role.hashCode() * 31) + this.extra.hashCode();
    }

    @NotNull
    public String toString() {
        return "RoleItem(role=" + this.role + ", extra=" + this.extra + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleItem(@NotNull RoleGroupModel role, @NotNull DisplayExtra extra) {
        super(1, role.getId(), null);
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.role = role;
        this.extra = extra;
    }
}
