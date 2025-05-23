package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/BindPermissionWord;", "Ljava/io/Serializable;", "titleStr", "", "allBtnStr", "partBtnStr", "manageMemberTitleStr", "addMemberTitleStr", "manageRoleTitleStr", "manageRoleSubAdminTip", "manageRoleCategoryAdminTip", "manageLevelRoleTitleStr", "addLevelRoleTitleStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddLevelRoleTitleStr", "()Ljava/lang/String;", "getAddMemberTitleStr", "getAllBtnStr", "getManageLevelRoleTitleStr", "getManageMemberTitleStr", "getManageRoleCategoryAdminTip", "getManageRoleSubAdminTip", "getManageRoleTitleStr", "getPartBtnStr", "getTitleStr", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class BindPermissionWord implements Serializable {

    @NotNull
    private final String addLevelRoleTitleStr;

    @NotNull
    private final String addMemberTitleStr;

    @NotNull
    private final String allBtnStr;

    @NotNull
    private final String manageLevelRoleTitleStr;

    @NotNull
    private final String manageMemberTitleStr;

    @NotNull
    private final String manageRoleCategoryAdminTip;

    @NotNull
    private final String manageRoleSubAdminTip;

    @NotNull
    private final String manageRoleTitleStr;

    @NotNull
    private final String partBtnStr;

    @NotNull
    private final String titleStr;

    public BindPermissionWord(@NotNull String titleStr, @NotNull String allBtnStr, @NotNull String partBtnStr, @NotNull String manageMemberTitleStr, @NotNull String addMemberTitleStr, @NotNull String manageRoleTitleStr, @NotNull String manageRoleSubAdminTip, @NotNull String manageRoleCategoryAdminTip, @NotNull String manageLevelRoleTitleStr, @NotNull String addLevelRoleTitleStr) {
        Intrinsics.checkNotNullParameter(titleStr, "titleStr");
        Intrinsics.checkNotNullParameter(allBtnStr, "allBtnStr");
        Intrinsics.checkNotNullParameter(partBtnStr, "partBtnStr");
        Intrinsics.checkNotNullParameter(manageMemberTitleStr, "manageMemberTitleStr");
        Intrinsics.checkNotNullParameter(addMemberTitleStr, "addMemberTitleStr");
        Intrinsics.checkNotNullParameter(manageRoleTitleStr, "manageRoleTitleStr");
        Intrinsics.checkNotNullParameter(manageRoleSubAdminTip, "manageRoleSubAdminTip");
        Intrinsics.checkNotNullParameter(manageRoleCategoryAdminTip, "manageRoleCategoryAdminTip");
        Intrinsics.checkNotNullParameter(manageLevelRoleTitleStr, "manageLevelRoleTitleStr");
        Intrinsics.checkNotNullParameter(addLevelRoleTitleStr, "addLevelRoleTitleStr");
        this.titleStr = titleStr;
        this.allBtnStr = allBtnStr;
        this.partBtnStr = partBtnStr;
        this.manageMemberTitleStr = manageMemberTitleStr;
        this.addMemberTitleStr = addMemberTitleStr;
        this.manageRoleTitleStr = manageRoleTitleStr;
        this.manageRoleSubAdminTip = manageRoleSubAdminTip;
        this.manageRoleCategoryAdminTip = manageRoleCategoryAdminTip;
        this.manageLevelRoleTitleStr = manageLevelRoleTitleStr;
        this.addLevelRoleTitleStr = addLevelRoleTitleStr;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitleStr() {
        return this.titleStr;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getAddLevelRoleTitleStr() {
        return this.addLevelRoleTitleStr;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAllBtnStr() {
        return this.allBtnStr;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPartBtnStr() {
        return this.partBtnStr;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getManageMemberTitleStr() {
        return this.manageMemberTitleStr;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAddMemberTitleStr() {
        return this.addMemberTitleStr;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getManageRoleTitleStr() {
        return this.manageRoleTitleStr;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getManageRoleSubAdminTip() {
        return this.manageRoleSubAdminTip;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getManageRoleCategoryAdminTip() {
        return this.manageRoleCategoryAdminTip;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getManageLevelRoleTitleStr() {
        return this.manageLevelRoleTitleStr;
    }

    @NotNull
    public final BindPermissionWord copy(@NotNull String titleStr, @NotNull String allBtnStr, @NotNull String partBtnStr, @NotNull String manageMemberTitleStr, @NotNull String addMemberTitleStr, @NotNull String manageRoleTitleStr, @NotNull String manageRoleSubAdminTip, @NotNull String manageRoleCategoryAdminTip, @NotNull String manageLevelRoleTitleStr, @NotNull String addLevelRoleTitleStr) {
        Intrinsics.checkNotNullParameter(titleStr, "titleStr");
        Intrinsics.checkNotNullParameter(allBtnStr, "allBtnStr");
        Intrinsics.checkNotNullParameter(partBtnStr, "partBtnStr");
        Intrinsics.checkNotNullParameter(manageMemberTitleStr, "manageMemberTitleStr");
        Intrinsics.checkNotNullParameter(addMemberTitleStr, "addMemberTitleStr");
        Intrinsics.checkNotNullParameter(manageRoleTitleStr, "manageRoleTitleStr");
        Intrinsics.checkNotNullParameter(manageRoleSubAdminTip, "manageRoleSubAdminTip");
        Intrinsics.checkNotNullParameter(manageRoleCategoryAdminTip, "manageRoleCategoryAdminTip");
        Intrinsics.checkNotNullParameter(manageLevelRoleTitleStr, "manageLevelRoleTitleStr");
        Intrinsics.checkNotNullParameter(addLevelRoleTitleStr, "addLevelRoleTitleStr");
        return new BindPermissionWord(titleStr, allBtnStr, partBtnStr, manageMemberTitleStr, addMemberTitleStr, manageRoleTitleStr, manageRoleSubAdminTip, manageRoleCategoryAdminTip, manageLevelRoleTitleStr, addLevelRoleTitleStr);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindPermissionWord)) {
            return false;
        }
        BindPermissionWord bindPermissionWord = (BindPermissionWord) other;
        if (Intrinsics.areEqual(this.titleStr, bindPermissionWord.titleStr) && Intrinsics.areEqual(this.allBtnStr, bindPermissionWord.allBtnStr) && Intrinsics.areEqual(this.partBtnStr, bindPermissionWord.partBtnStr) && Intrinsics.areEqual(this.manageMemberTitleStr, bindPermissionWord.manageMemberTitleStr) && Intrinsics.areEqual(this.addMemberTitleStr, bindPermissionWord.addMemberTitleStr) && Intrinsics.areEqual(this.manageRoleTitleStr, bindPermissionWord.manageRoleTitleStr) && Intrinsics.areEqual(this.manageRoleSubAdminTip, bindPermissionWord.manageRoleSubAdminTip) && Intrinsics.areEqual(this.manageRoleCategoryAdminTip, bindPermissionWord.manageRoleCategoryAdminTip) && Intrinsics.areEqual(this.manageLevelRoleTitleStr, bindPermissionWord.manageLevelRoleTitleStr) && Intrinsics.areEqual(this.addLevelRoleTitleStr, bindPermissionWord.addLevelRoleTitleStr)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAddLevelRoleTitleStr() {
        return this.addLevelRoleTitleStr;
    }

    @NotNull
    public final String getAddMemberTitleStr() {
        return this.addMemberTitleStr;
    }

    @NotNull
    public final String getAllBtnStr() {
        return this.allBtnStr;
    }

    @NotNull
    public final String getManageLevelRoleTitleStr() {
        return this.manageLevelRoleTitleStr;
    }

    @NotNull
    public final String getManageMemberTitleStr() {
        return this.manageMemberTitleStr;
    }

    @NotNull
    public final String getManageRoleCategoryAdminTip() {
        return this.manageRoleCategoryAdminTip;
    }

    @NotNull
    public final String getManageRoleSubAdminTip() {
        return this.manageRoleSubAdminTip;
    }

    @NotNull
    public final String getManageRoleTitleStr() {
        return this.manageRoleTitleStr;
    }

    @NotNull
    public final String getPartBtnStr() {
        return this.partBtnStr;
    }

    @NotNull
    public final String getTitleStr() {
        return this.titleStr;
    }

    public int hashCode() {
        return (((((((((((((((((this.titleStr.hashCode() * 31) + this.allBtnStr.hashCode()) * 31) + this.partBtnStr.hashCode()) * 31) + this.manageMemberTitleStr.hashCode()) * 31) + this.addMemberTitleStr.hashCode()) * 31) + this.manageRoleTitleStr.hashCode()) * 31) + this.manageRoleSubAdminTip.hashCode()) * 31) + this.manageRoleCategoryAdminTip.hashCode()) * 31) + this.manageLevelRoleTitleStr.hashCode()) * 31) + this.addLevelRoleTitleStr.hashCode();
    }

    @NotNull
    public String toString() {
        return "BindPermissionWord(titleStr=" + this.titleStr + ", allBtnStr=" + this.allBtnStr + ", partBtnStr=" + this.partBtnStr + ", manageMemberTitleStr=" + this.manageMemberTitleStr + ", addMemberTitleStr=" + this.addMemberTitleStr + ", manageRoleTitleStr=" + this.manageRoleTitleStr + ", manageRoleSubAdminTip=" + this.manageRoleSubAdminTip + ", manageRoleCategoryAdminTip=" + this.manageRoleCategoryAdminTip + ", manageLevelRoleTitleStr=" + this.manageLevelRoleTitleStr + ", addLevelRoleTitleStr=" + this.addLevelRoleTitleStr + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BindPermissionWord(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, r12, r13);
        String str11;
        String str12;
        if ((i3 & 256) != 0) {
            String qqStr = HardCodeUtil.qqStr(R.string.f154741fm);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_list_level_role)");
            str11 = qqStr;
        } else {
            str11 = str9;
        }
        if ((i3 & 512) != 0) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.f154751fn);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_role_list_level_role_add)");
            str12 = qqStr2;
        } else {
            str12 = str10;
        }
    }
}
