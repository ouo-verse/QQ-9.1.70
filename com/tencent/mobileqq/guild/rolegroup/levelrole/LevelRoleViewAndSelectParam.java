package com.tencent.mobileqq.guild.rolegroup.levelrole;

import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\tH\u00c6\u0003J\t\u0010)\u001a\u00020\u000bH\u00c6\u0003J\t\u0010*\u001a\u00020\rH\u00c6\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0003Jy\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u00c6\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\rH\u00d6\u0001J\t\u00102\u001a\u00020\u0003H\u00d6\u0001R!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;", "Ljava/io/Serializable;", "guildId", "", "title", "pageLayoutType", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", "channelId", "fetchType", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "isCreating", "", "requestCode", "", "allRolesSelected", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "Lkotlin/collections/ArrayList;", "tempSelectedLvRoles", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;ZILjava/util/ArrayList;Ljava/util/List;)V", "getAllRolesSelected", "()Ljava/util/ArrayList;", "getChannelId", "()Ljava/lang/String;", "getFetchType", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "getGuildId", "()Z", "getPageLayoutType", "()Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", "getRequestCode", "()I", "getTempSelectedLvRoles", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class LevelRoleViewAndSelectParam implements Serializable {

    @NotNull
    private final ArrayList<RoleLabelData> allRolesSelected;

    @NotNull
    private final String channelId;

    @NotNull
    private final GuildBindPermissionActionFactory.FetchType fetchType;

    @NotNull
    private final String guildId;
    private final boolean isCreating;

    @NotNull
    private final PageLayoutType pageLayoutType;
    private final int requestCode;

    @NotNull
    private final List<String> tempSelectedLvRoles;

    @NotNull
    private final String title;

    public LevelRoleViewAndSelectParam(@NotNull String guildId, @NotNull String title, @NotNull PageLayoutType pageLayoutType, @NotNull String channelId, @NotNull GuildBindPermissionActionFactory.FetchType fetchType, boolean z16, int i3, @NotNull ArrayList<RoleLabelData> allRolesSelected, @NotNull List<String> tempSelectedLvRoles) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pageLayoutType, "pageLayoutType");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        Intrinsics.checkNotNullParameter(allRolesSelected, "allRolesSelected");
        Intrinsics.checkNotNullParameter(tempSelectedLvRoles, "tempSelectedLvRoles");
        this.guildId = guildId;
        this.title = title;
        this.pageLayoutType = pageLayoutType;
        this.channelId = channelId;
        this.fetchType = fetchType;
        this.isCreating = z16;
        this.requestCode = i3;
        this.allRolesSelected = allRolesSelected;
        this.tempSelectedLvRoles = tempSelectedLvRoles;
    }

    public static /* synthetic */ LevelRoleViewAndSelectParam copy$default(LevelRoleViewAndSelectParam levelRoleViewAndSelectParam, String str, String str2, PageLayoutType pageLayoutType, String str3, GuildBindPermissionActionFactory.FetchType fetchType, boolean z16, int i3, ArrayList arrayList, List list, int i16, Object obj) {
        String str4;
        String str5;
        PageLayoutType pageLayoutType2;
        String str6;
        GuildBindPermissionActionFactory.FetchType fetchType2;
        boolean z17;
        int i17;
        ArrayList arrayList2;
        List list2;
        if ((i16 & 1) != 0) {
            str4 = levelRoleViewAndSelectParam.guildId;
        } else {
            str4 = str;
        }
        if ((i16 & 2) != 0) {
            str5 = levelRoleViewAndSelectParam.title;
        } else {
            str5 = str2;
        }
        if ((i16 & 4) != 0) {
            pageLayoutType2 = levelRoleViewAndSelectParam.pageLayoutType;
        } else {
            pageLayoutType2 = pageLayoutType;
        }
        if ((i16 & 8) != 0) {
            str6 = levelRoleViewAndSelectParam.channelId;
        } else {
            str6 = str3;
        }
        if ((i16 & 16) != 0) {
            fetchType2 = levelRoleViewAndSelectParam.fetchType;
        } else {
            fetchType2 = fetchType;
        }
        if ((i16 & 32) != 0) {
            z17 = levelRoleViewAndSelectParam.isCreating;
        } else {
            z17 = z16;
        }
        if ((i16 & 64) != 0) {
            i17 = levelRoleViewAndSelectParam.requestCode;
        } else {
            i17 = i3;
        }
        if ((i16 & 128) != 0) {
            arrayList2 = levelRoleViewAndSelectParam.allRolesSelected;
        } else {
            arrayList2 = arrayList;
        }
        if ((i16 & 256) != 0) {
            list2 = levelRoleViewAndSelectParam.tempSelectedLvRoles;
        } else {
            list2 = list;
        }
        return levelRoleViewAndSelectParam.copy(str4, str5, pageLayoutType2, str6, fetchType2, z17, i17, arrayList2, list2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final PageLayoutType getPageLayoutType() {
        return this.pageLayoutType;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final GuildBindPermissionActionFactory.FetchType getFetchType() {
        return this.fetchType;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsCreating() {
        return this.isCreating;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRequestCode() {
        return this.requestCode;
    }

    @NotNull
    public final ArrayList<RoleLabelData> component8() {
        return this.allRolesSelected;
    }

    @NotNull
    public final List<String> component9() {
        return this.tempSelectedLvRoles;
    }

    @NotNull
    public final LevelRoleViewAndSelectParam copy(@NotNull String guildId, @NotNull String title, @NotNull PageLayoutType pageLayoutType, @NotNull String channelId, @NotNull GuildBindPermissionActionFactory.FetchType fetchType, boolean isCreating, int requestCode, @NotNull ArrayList<RoleLabelData> allRolesSelected, @NotNull List<String> tempSelectedLvRoles) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pageLayoutType, "pageLayoutType");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        Intrinsics.checkNotNullParameter(allRolesSelected, "allRolesSelected");
        Intrinsics.checkNotNullParameter(tempSelectedLvRoles, "tempSelectedLvRoles");
        return new LevelRoleViewAndSelectParam(guildId, title, pageLayoutType, channelId, fetchType, isCreating, requestCode, allRolesSelected, tempSelectedLvRoles);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LevelRoleViewAndSelectParam)) {
            return false;
        }
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = (LevelRoleViewAndSelectParam) other;
        if (Intrinsics.areEqual(this.guildId, levelRoleViewAndSelectParam.guildId) && Intrinsics.areEqual(this.title, levelRoleViewAndSelectParam.title) && this.pageLayoutType == levelRoleViewAndSelectParam.pageLayoutType && Intrinsics.areEqual(this.channelId, levelRoleViewAndSelectParam.channelId) && this.fetchType == levelRoleViewAndSelectParam.fetchType && this.isCreating == levelRoleViewAndSelectParam.isCreating && this.requestCode == levelRoleViewAndSelectParam.requestCode && Intrinsics.areEqual(this.allRolesSelected, levelRoleViewAndSelectParam.allRolesSelected) && Intrinsics.areEqual(this.tempSelectedLvRoles, levelRoleViewAndSelectParam.tempSelectedLvRoles)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<RoleLabelData> getAllRolesSelected() {
        return this.allRolesSelected;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final GuildBindPermissionActionFactory.FetchType getFetchType() {
        return this.fetchType;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final PageLayoutType getPageLayoutType() {
        return this.pageLayoutType;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @NotNull
    public final List<String> getTempSelectedLvRoles() {
        return this.tempSelectedLvRoles;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.guildId.hashCode() * 31) + this.title.hashCode()) * 31) + this.pageLayoutType.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.fetchType.hashCode()) * 31;
        boolean z16 = this.isCreating;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((hashCode + i3) * 31) + this.requestCode) * 31) + this.allRolesSelected.hashCode()) * 31) + this.tempSelectedLvRoles.hashCode();
    }

    public final boolean isCreating() {
        return this.isCreating;
    }

    @NotNull
    public String toString() {
        return "LevelRoleViewAndSelectParam(guildId=" + this.guildId + ", title=" + this.title + ", pageLayoutType=" + this.pageLayoutType + ", channelId=" + this.channelId + ", fetchType=" + this.fetchType + ", isCreating=" + this.isCreating + ", requestCode=" + this.requestCode + ", allRolesSelected=" + this.allRolesSelected + ", tempSelectedLvRoles=" + this.tempSelectedLvRoles + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LevelRoleViewAndSelectParam(String str, String str2, PageLayoutType pageLayoutType, String str3, GuildBindPermissionActionFactory.FetchType fetchType, boolean z16, int i3, ArrayList arrayList, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, pageLayoutType, r6, r7, r8, r9, r10, r11);
        List list2;
        List emptyList;
        String str4 = (i16 & 8) != 0 ? "" : str3;
        GuildBindPermissionActionFactory.FetchType fetchType2 = (i16 & 16) != 0 ? GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE : fetchType;
        boolean z17 = (i16 & 32) != 0 ? false : z16;
        int i17 = (i16 & 64) != 0 ? 0 : i3;
        ArrayList arrayList2 = (i16 & 128) != 0 ? new ArrayList() : arrayList;
        if ((i16 & 256) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }
}
