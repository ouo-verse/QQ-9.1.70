package com.tencent.mobileqq.guild.rolegroup.levelrole;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\rH\u00c6\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020\bH\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "Ljava/io/Serializable;", "roleId", "", "roleLVName", "roleName", "roleDesc", "roleMemberCount", "", "roleIcon", "channelNumCanSee", "channelNumCanSpeak", "height", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIF)V", "getChannelNumCanSee", "()I", "getChannelNumCanSpeak", "getHeight", "()F", "getRoleDesc", "()Ljava/lang/String;", "getRoleIcon", "getRoleId", "getRoleLVName", "getRoleMemberCount", "getRoleName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class LevelRoleUIData implements Serializable {
    private final int channelNumCanSee;
    private final int channelNumCanSpeak;
    private final float height;

    @NotNull
    private final String roleDesc;

    @NotNull
    private final String roleIcon;

    @NotNull
    private final String roleId;

    @NotNull
    private final String roleLVName;
    private final int roleMemberCount;

    @NotNull
    private final String roleName;

    public LevelRoleUIData() {
        this(null, null, null, null, 0, null, 0, 0, 0.0f, 511, null);
    }

    public static /* synthetic */ LevelRoleUIData copy$default(LevelRoleUIData levelRoleUIData, String str, String str2, String str3, String str4, int i3, String str5, int i16, int i17, float f16, int i18, Object obj) {
        String str6;
        String str7;
        String str8;
        String str9;
        int i19;
        String str10;
        int i26;
        int i27;
        float f17;
        if ((i18 & 1) != 0) {
            str6 = levelRoleUIData.roleId;
        } else {
            str6 = str;
        }
        if ((i18 & 2) != 0) {
            str7 = levelRoleUIData.roleLVName;
        } else {
            str7 = str2;
        }
        if ((i18 & 4) != 0) {
            str8 = levelRoleUIData.roleName;
        } else {
            str8 = str3;
        }
        if ((i18 & 8) != 0) {
            str9 = levelRoleUIData.roleDesc;
        } else {
            str9 = str4;
        }
        if ((i18 & 16) != 0) {
            i19 = levelRoleUIData.roleMemberCount;
        } else {
            i19 = i3;
        }
        if ((i18 & 32) != 0) {
            str10 = levelRoleUIData.roleIcon;
        } else {
            str10 = str5;
        }
        if ((i18 & 64) != 0) {
            i26 = levelRoleUIData.channelNumCanSee;
        } else {
            i26 = i16;
        }
        if ((i18 & 128) != 0) {
            i27 = levelRoleUIData.channelNumCanSpeak;
        } else {
            i27 = i17;
        }
        if ((i18 & 256) != 0) {
            f17 = levelRoleUIData.height;
        } else {
            f17 = f16;
        }
        return levelRoleUIData.copy(str6, str7, str8, str9, i19, str10, i26, i27, f17);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRoleId() {
        return this.roleId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getRoleLVName() {
        return this.roleLVName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRoleName() {
        return this.roleName;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getRoleDesc() {
        return this.roleDesc;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRoleMemberCount() {
        return this.roleMemberCount;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getRoleIcon() {
        return this.roleIcon;
    }

    /* renamed from: component7, reason: from getter */
    public final int getChannelNumCanSee() {
        return this.channelNumCanSee;
    }

    /* renamed from: component8, reason: from getter */
    public final int getChannelNumCanSpeak() {
        return this.channelNumCanSpeak;
    }

    /* renamed from: component9, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    @NotNull
    public final LevelRoleUIData copy(@NotNull String roleId, @NotNull String roleLVName, @NotNull String roleName, @NotNull String roleDesc, int roleMemberCount, @NotNull String roleIcon, int channelNumCanSee, int channelNumCanSpeak, float height) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(roleLVName, "roleLVName");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(roleDesc, "roleDesc");
        Intrinsics.checkNotNullParameter(roleIcon, "roleIcon");
        return new LevelRoleUIData(roleId, roleLVName, roleName, roleDesc, roleMemberCount, roleIcon, channelNumCanSee, channelNumCanSpeak, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LevelRoleUIData)) {
            return false;
        }
        LevelRoleUIData levelRoleUIData = (LevelRoleUIData) other;
        if (Intrinsics.areEqual(this.roleId, levelRoleUIData.roleId) && Intrinsics.areEqual(this.roleLVName, levelRoleUIData.roleLVName) && Intrinsics.areEqual(this.roleName, levelRoleUIData.roleName) && Intrinsics.areEqual(this.roleDesc, levelRoleUIData.roleDesc) && this.roleMemberCount == levelRoleUIData.roleMemberCount && Intrinsics.areEqual(this.roleIcon, levelRoleUIData.roleIcon) && this.channelNumCanSee == levelRoleUIData.channelNumCanSee && this.channelNumCanSpeak == levelRoleUIData.channelNumCanSpeak && Float.compare(this.height, levelRoleUIData.height) == 0) {
            return true;
        }
        return false;
    }

    public final int getChannelNumCanSee() {
        return this.channelNumCanSee;
    }

    public final int getChannelNumCanSpeak() {
        return this.channelNumCanSpeak;
    }

    public final float getHeight() {
        return this.height;
    }

    @NotNull
    public final String getRoleDesc() {
        return this.roleDesc;
    }

    @NotNull
    public final String getRoleIcon() {
        return this.roleIcon;
    }

    @NotNull
    public final String getRoleId() {
        return this.roleId;
    }

    @NotNull
    public final String getRoleLVName() {
        return this.roleLVName;
    }

    public final int getRoleMemberCount() {
        return this.roleMemberCount;
    }

    @NotNull
    public final String getRoleName() {
        return this.roleName;
    }

    public int hashCode() {
        return (((((((((((((((this.roleId.hashCode() * 31) + this.roleLVName.hashCode()) * 31) + this.roleName.hashCode()) * 31) + this.roleDesc.hashCode()) * 31) + this.roleMemberCount) * 31) + this.roleIcon.hashCode()) * 31) + this.channelNumCanSee) * 31) + this.channelNumCanSpeak) * 31) + Float.floatToIntBits(this.height);
    }

    @NotNull
    public String toString() {
        return "LevelRoleUIData(roleId=" + this.roleId + ", roleLVName=" + this.roleLVName + ", roleName=" + this.roleName + ", roleDesc=" + this.roleDesc + ", roleMemberCount=" + this.roleMemberCount + ", roleIcon=" + this.roleIcon + ", channelNumCanSee=" + this.channelNumCanSee + ", channelNumCanSpeak=" + this.channelNumCanSpeak + ", height=" + this.height + ")";
    }

    public LevelRoleUIData(@NotNull String roleId, @NotNull String roleLVName, @NotNull String roleName, @NotNull String roleDesc, int i3, @NotNull String roleIcon, int i16, int i17, float f16) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(roleLVName, "roleLVName");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(roleDesc, "roleDesc");
        Intrinsics.checkNotNullParameter(roleIcon, "roleIcon");
        this.roleId = roleId;
        this.roleLVName = roleLVName;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleMemberCount = i3;
        this.roleIcon = roleIcon;
        this.channelNumCanSee = i16;
        this.channelNumCanSpeak = i17;
        this.height = f16;
    }

    public /* synthetic */ LevelRoleUIData(String str, String str2, String str3, String str4, int i3, String str5, int i16, int i17, float f16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? "" : str3, (i18 & 8) != 0 ? "" : str4, (i18 & 16) != 0 ? 0 : i3, (i18 & 32) == 0 ? str5 : "", (i18 & 64) != 0 ? 0 : i16, (i18 & 128) == 0 ? i17 : 0, (i18 & 256) != 0 ? 13.0f : f16);
    }
}
