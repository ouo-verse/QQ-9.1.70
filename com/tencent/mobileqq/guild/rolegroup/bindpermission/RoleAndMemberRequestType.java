package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/RoleAndMemberRequestType;", "Ljava/io/Serializable;", "bindPermissionType", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "addRoleType", "", "addUserType", "manageUserType", "(Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;III)V", "getAddRoleType", "()I", "getAddUserType", "getBindPermissionType", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "getManageUserType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class RoleAndMemberRequestType implements Serializable {
    private final int addRoleType;
    private final int addUserType;

    @NotNull
    private final GuildBindPermissionActionFactory.FetchType bindPermissionType;
    private final int manageUserType;

    public RoleAndMemberRequestType(@NotNull GuildBindPermissionActionFactory.FetchType bindPermissionType, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(bindPermissionType, "bindPermissionType");
        this.bindPermissionType = bindPermissionType;
        this.addRoleType = i3;
        this.addUserType = i16;
        this.manageUserType = i17;
    }

    public static /* synthetic */ RoleAndMemberRequestType copy$default(RoleAndMemberRequestType roleAndMemberRequestType, GuildBindPermissionActionFactory.FetchType fetchType, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            fetchType = roleAndMemberRequestType.bindPermissionType;
        }
        if ((i18 & 2) != 0) {
            i3 = roleAndMemberRequestType.addRoleType;
        }
        if ((i18 & 4) != 0) {
            i16 = roleAndMemberRequestType.addUserType;
        }
        if ((i18 & 8) != 0) {
            i17 = roleAndMemberRequestType.manageUserType;
        }
        return roleAndMemberRequestType.copy(fetchType, i3, i16, i17);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final GuildBindPermissionActionFactory.FetchType getBindPermissionType() {
        return this.bindPermissionType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAddRoleType() {
        return this.addRoleType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAddUserType() {
        return this.addUserType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getManageUserType() {
        return this.manageUserType;
    }

    @NotNull
    public final RoleAndMemberRequestType copy(@NotNull GuildBindPermissionActionFactory.FetchType bindPermissionType, int addRoleType, int addUserType, int manageUserType) {
        Intrinsics.checkNotNullParameter(bindPermissionType, "bindPermissionType");
        return new RoleAndMemberRequestType(bindPermissionType, addRoleType, addUserType, manageUserType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleAndMemberRequestType)) {
            return false;
        }
        RoleAndMemberRequestType roleAndMemberRequestType = (RoleAndMemberRequestType) other;
        if (this.bindPermissionType == roleAndMemberRequestType.bindPermissionType && this.addRoleType == roleAndMemberRequestType.addRoleType && this.addUserType == roleAndMemberRequestType.addUserType && this.manageUserType == roleAndMemberRequestType.manageUserType) {
            return true;
        }
        return false;
    }

    public final int getAddRoleType() {
        return this.addRoleType;
    }

    public final int getAddUserType() {
        return this.addUserType;
    }

    @NotNull
    public final GuildBindPermissionActionFactory.FetchType getBindPermissionType() {
        return this.bindPermissionType;
    }

    public final int getManageUserType() {
        return this.manageUserType;
    }

    public int hashCode() {
        return (((((this.bindPermissionType.hashCode() * 31) + this.addRoleType) * 31) + this.addUserType) * 31) + this.manageUserType;
    }

    @NotNull
    public String toString() {
        return "RoleAndMemberRequestType(bindPermissionType=" + this.bindPermissionType + ", addRoleType=" + this.addRoleType + ", addUserType=" + this.addUserType + ", manageUserType=" + this.manageUserType + ")";
    }
}
