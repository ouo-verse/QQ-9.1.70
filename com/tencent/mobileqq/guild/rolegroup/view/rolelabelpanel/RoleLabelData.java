package com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000eJ\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u000bH\u00c6\u0003J\t\u0010'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00100\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u000bJ\t\u00102\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "Ljava/io/Serializable;", "roleId", "", "roleColor", "", "roleName", "roleType", "lvName", "lvIcon", "enableModify", "", "hasRolePermission", "displayType", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZI)V", "getDisplayType", "()I", "setDisplayType", "(I)V", "getEnableModify", "()Z", "setEnableModify", "(Z)V", "getHasRolePermission", "setHasRolePermission", "getLvIcon", "()Ljava/lang/String;", "getLvName", "getRoleColor", "getRoleId", "getRoleName", "getRoleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "isCategoryAdmin", "isChannelAdmin", "isLevelRole", "isNormalRole", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class RoleLabelData implements Serializable {
    private int displayType;
    private boolean enableModify;
    private boolean hasRolePermission;

    @NotNull
    private final String lvIcon;

    @NotNull
    private final String lvName;
    private final int roleColor;

    @NotNull
    private final String roleId;

    @NotNull
    private final String roleName;
    private final int roleType;

    public RoleLabelData() {
        this(null, 0, null, 0, null, null, false, false, 0, 511, null);
    }

    public static /* synthetic */ RoleLabelData copy$default(RoleLabelData roleLabelData, String str, int i3, String str2, int i16, String str3, String str4, boolean z16, boolean z17, int i17, int i18, Object obj) {
        String str5;
        int i19;
        String str6;
        int i26;
        String str7;
        String str8;
        boolean z18;
        boolean z19;
        int i27;
        if ((i18 & 1) != 0) {
            str5 = roleLabelData.roleId;
        } else {
            str5 = str;
        }
        if ((i18 & 2) != 0) {
            i19 = roleLabelData.roleColor;
        } else {
            i19 = i3;
        }
        if ((i18 & 4) != 0) {
            str6 = roleLabelData.roleName;
        } else {
            str6 = str2;
        }
        if ((i18 & 8) != 0) {
            i26 = roleLabelData.roleType;
        } else {
            i26 = i16;
        }
        if ((i18 & 16) != 0) {
            str7 = roleLabelData.lvName;
        } else {
            str7 = str3;
        }
        if ((i18 & 32) != 0) {
            str8 = roleLabelData.lvIcon;
        } else {
            str8 = str4;
        }
        if ((i18 & 64) != 0) {
            z18 = roleLabelData.enableModify;
        } else {
            z18 = z16;
        }
        if ((i18 & 128) != 0) {
            z19 = roleLabelData.hasRolePermission;
        } else {
            z19 = z17;
        }
        if ((i18 & 256) != 0) {
            i27 = roleLabelData.displayType;
        } else {
            i27 = i17;
        }
        return roleLabelData.copy(str5, i19, str6, i26, str7, str8, z18, z19, i27);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRoleId() {
        return this.roleId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRoleColor() {
        return this.roleColor;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRoleName() {
        return this.roleName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRoleType() {
        return this.roleType;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getLvName() {
        return this.lvName;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getLvIcon() {
        return this.lvIcon;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableModify() {
        return this.enableModify;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getHasRolePermission() {
        return this.hasRolePermission;
    }

    /* renamed from: component9, reason: from getter */
    public final int getDisplayType() {
        return this.displayType;
    }

    @NotNull
    public final RoleLabelData copy(@NotNull String roleId, int roleColor, @NotNull String roleName, int roleType, @NotNull String lvName, @NotNull String lvIcon, boolean enableModify, boolean hasRolePermission, int displayType) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(lvName, "lvName");
        Intrinsics.checkNotNullParameter(lvIcon, "lvIcon");
        return new RoleLabelData(roleId, roleColor, roleName, roleType, lvName, lvIcon, enableModify, hasRolePermission, displayType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleLabelData)) {
            return false;
        }
        RoleLabelData roleLabelData = (RoleLabelData) other;
        if (Intrinsics.areEqual(this.roleId, roleLabelData.roleId) && this.roleColor == roleLabelData.roleColor && Intrinsics.areEqual(this.roleName, roleLabelData.roleName) && this.roleType == roleLabelData.roleType && Intrinsics.areEqual(this.lvName, roleLabelData.lvName) && Intrinsics.areEqual(this.lvIcon, roleLabelData.lvIcon) && this.enableModify == roleLabelData.enableModify && this.hasRolePermission == roleLabelData.hasRolePermission && this.displayType == roleLabelData.displayType) {
            return true;
        }
        return false;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final boolean getEnableModify() {
        return this.enableModify;
    }

    public final boolean getHasRolePermission() {
        return this.hasRolePermission;
    }

    @NotNull
    public final String getLvIcon() {
        return this.lvIcon;
    }

    @NotNull
    public final String getLvName() {
        return this.lvName;
    }

    public final int getRoleColor() {
        return this.roleColor;
    }

    @NotNull
    public final String getRoleId() {
        return this.roleId;
    }

    @NotNull
    public final String getRoleName() {
        return this.roleName;
    }

    public final int getRoleType() {
        return this.roleType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.roleId.hashCode() * 31) + this.roleColor) * 31) + this.roleName.hashCode()) * 31) + this.roleType) * 31) + this.lvName.hashCode()) * 31) + this.lvIcon.hashCode()) * 31;
        boolean z16 = this.enableModify;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.hasRolePermission;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i17 + i3) * 31) + this.displayType;
    }

    public final boolean isCategoryAdmin() {
        if (this.roleType == 7) {
            return true;
        }
        return false;
    }

    public final boolean isChannelAdmin() {
        if (this.roleType == 5) {
            return true;
        }
        return false;
    }

    public final boolean isLevelRole() {
        if (this.lvName.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean isNormalRole() {
        if (this.roleType == 0) {
            return true;
        }
        return false;
    }

    public final void setDisplayType(int i3) {
        this.displayType = i3;
    }

    public final void setEnableModify(boolean z16) {
        this.enableModify = z16;
    }

    public final void setHasRolePermission(boolean z16) {
        this.hasRolePermission = z16;
    }

    @NotNull
    public String toString() {
        return "RoleLabelData(roleId=" + this.roleId + ", roleColor=" + this.roleColor + ", roleName=" + this.roleName + ", roleType=" + this.roleType + ", lvName=" + this.lvName + ", lvIcon=" + this.lvIcon + ", enableModify=" + this.enableModify + ", hasRolePermission=" + this.hasRolePermission + ", displayType=" + this.displayType + ")";
    }

    public RoleLabelData(@NotNull String roleId, int i3, @NotNull String roleName, int i16, @NotNull String lvName, @NotNull String lvIcon, boolean z16, boolean z17, int i17) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(lvName, "lvName");
        Intrinsics.checkNotNullParameter(lvIcon, "lvIcon");
        this.roleId = roleId;
        this.roleColor = i3;
        this.roleName = roleName;
        this.roleType = i16;
        this.lvName = lvName;
        this.lvIcon = lvIcon;
        this.enableModify = z16;
        this.hasRolePermission = z17;
        this.displayType = i17;
    }

    public /* synthetic */ RoleLabelData(String str, int i3, String str2, int i16, String str3, String str4, boolean z16, boolean z17, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? -16711936 : i3, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? "" : str3, (i18 & 32) == 0 ? str4 : "", (i18 & 64) != 0 ? false : z16, (i18 & 128) != 0 ? false : z17, (i18 & 256) == 0 ? i17 : 0);
    }
}
