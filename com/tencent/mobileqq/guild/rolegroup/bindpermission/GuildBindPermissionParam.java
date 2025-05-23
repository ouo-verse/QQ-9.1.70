package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J1\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010-\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010/H\u00d6\u0003J\t\u00100\u001a\u00020\u000fH\u00d6\u0001J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u000fJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000fJ\u0019\u00106\u001a\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020 08\u00a2\u0006\u0002\u00109J\u0019\u0010:\u001a\u00020\u00002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020%08\u00a2\u0006\u0002\u0010<J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR>\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R>\u0010&\u001a\u0012\u0012\u0004\u0012\u00020%0\u001fj\b\u0012\u0004\u0012\u00020%`!2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020%0\u001fj\b\u0012\u0004\u0012\u00020%`!@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010$\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "Ljava/io/Serializable;", "guildId", "", "requestType", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/RoleAndMemberRequestType;", "permissionWord", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/BindPermissionWord;", "dtReportParam", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/DTReportParam;", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/RoleAndMemberRequestType;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/BindPermissionWord;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/DTReportParam;)V", "<set-?>", "channelId", "getChannelId", "()Ljava/lang/String;", "", "channelType", "getChannelType", "()I", "getDtReportParam", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/DTReportParam;", "getGuildId", "", "isCreating", "()Z", "getPermissionWord", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/BindPermissionWord;", "requestCode", "getRequestCode", "getRequestType", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/RoleAndMemberRequestType;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "Lkotlin/collections/ArrayList;", "selectRoles", "getSelectRoles", "()Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "selectUsers", "getSelectUsers", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "setChannelId", "setChannelType", "type", "setIsCreating", "setRequestCode", "setSelectRoles", "roles", "", "([Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;)Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "setSelectUsers", "users", "([Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;)Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class GuildBindPermissionParam implements Serializable {

    @NotNull
    private String channelId;
    private int channelType;

    @NotNull
    private final DTReportParam dtReportParam;

    @NotNull
    private final String guildId;
    private boolean isCreating;

    @NotNull
    private final BindPermissionWord permissionWord;
    private int requestCode;

    @NotNull
    private final RoleAndMemberRequestType requestType;

    @NotNull
    private ArrayList<RoleLabelData> selectRoles;

    @NotNull
    private ArrayList<RoleGroupUserUIData> selectUsers;

    public GuildBindPermissionParam(@NotNull String guildId, @NotNull RoleAndMemberRequestType requestType, @NotNull BindPermissionWord permissionWord, @NotNull DTReportParam dtReportParam) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(permissionWord, "permissionWord");
        Intrinsics.checkNotNullParameter(dtReportParam, "dtReportParam");
        this.guildId = guildId;
        this.requestType = requestType;
        this.permissionWord = permissionWord;
        this.dtReportParam = dtReportParam;
        this.channelId = "";
        this.requestCode = 10086;
        this.selectRoles = new ArrayList<>();
        this.selectUsers = new ArrayList<>();
    }

    public static /* synthetic */ GuildBindPermissionParam copy$default(GuildBindPermissionParam guildBindPermissionParam, String str, RoleAndMemberRequestType roleAndMemberRequestType, BindPermissionWord bindPermissionWord, DTReportParam dTReportParam, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildBindPermissionParam.guildId;
        }
        if ((i3 & 2) != 0) {
            roleAndMemberRequestType = guildBindPermissionParam.requestType;
        }
        if ((i3 & 4) != 0) {
            bindPermissionWord = guildBindPermissionParam.permissionWord;
        }
        if ((i3 & 8) != 0) {
            dTReportParam = guildBindPermissionParam.dtReportParam;
        }
        return guildBindPermissionParam.copy(str, roleAndMemberRequestType, bindPermissionWord, dTReportParam);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final RoleAndMemberRequestType getRequestType() {
        return this.requestType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final BindPermissionWord getPermissionWord() {
        return this.permissionWord;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final DTReportParam getDtReportParam() {
        return this.dtReportParam;
    }

    @NotNull
    public final GuildBindPermissionParam copy(@NotNull String guildId, @NotNull RoleAndMemberRequestType requestType, @NotNull BindPermissionWord permissionWord, @NotNull DTReportParam dtReportParam) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(permissionWord, "permissionWord");
        Intrinsics.checkNotNullParameter(dtReportParam, "dtReportParam");
        return new GuildBindPermissionParam(guildId, requestType, permissionWord, dtReportParam);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBindPermissionParam)) {
            return false;
        }
        GuildBindPermissionParam guildBindPermissionParam = (GuildBindPermissionParam) other;
        if (Intrinsics.areEqual(this.guildId, guildBindPermissionParam.guildId) && Intrinsics.areEqual(this.requestType, guildBindPermissionParam.requestType) && Intrinsics.areEqual(this.permissionWord, guildBindPermissionParam.permissionWord) && Intrinsics.areEqual(this.dtReportParam, guildBindPermissionParam.dtReportParam)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    public final DTReportParam getDtReportParam() {
        return this.dtReportParam;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final BindPermissionWord getPermissionWord() {
        return this.permissionWord;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @NotNull
    public final RoleAndMemberRequestType getRequestType() {
        return this.requestType;
    }

    @NotNull
    public final ArrayList<RoleLabelData> getSelectRoles() {
        return this.selectRoles;
    }

    @NotNull
    public final ArrayList<RoleGroupUserUIData> getSelectUsers() {
        return this.selectUsers;
    }

    public int hashCode() {
        return (((((this.guildId.hashCode() * 31) + this.requestType.hashCode()) * 31) + this.permissionWord.hashCode()) * 31) + this.dtReportParam.hashCode();
    }

    /* renamed from: isCreating, reason: from getter */
    public final boolean getIsCreating() {
        return this.isCreating;
    }

    @NotNull
    public final GuildBindPermissionParam setChannelId(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.channelId = channelId;
        return this;
    }

    @NotNull
    public final GuildBindPermissionParam setChannelType(int type) {
        this.channelType = type;
        return this;
    }

    @NotNull
    public final GuildBindPermissionParam setIsCreating(boolean isCreating) {
        this.isCreating = isCreating;
        return this;
    }

    @NotNull
    public final GuildBindPermissionParam setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    @NotNull
    public final GuildBindPermissionParam setSelectRoles(@NotNull RoleLabelData[] roles) {
        Intrinsics.checkNotNullParameter(roles, "roles");
        this.selectRoles.clear();
        for (RoleLabelData roleLabelData : roles) {
            this.selectRoles.add(roleLabelData);
        }
        return this;
    }

    @NotNull
    public final GuildBindPermissionParam setSelectUsers(@NotNull RoleGroupUserUIData[] users) {
        Intrinsics.checkNotNullParameter(users, "users");
        this.selectUsers.clear();
        for (RoleGroupUserUIData roleGroupUserUIData : users) {
            this.selectUsers.add(roleGroupUserUIData);
        }
        return this;
    }

    @NotNull
    public String toString() {
        return "GuildBindPermissionParam(guildId=" + this.guildId + ", requestType=" + this.requestType + ", permissionWord=" + this.permissionWord + ", dtReportParam=" + this.dtReportParam + ")";
    }
}
