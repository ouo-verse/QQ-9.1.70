package com.tencent.guild.aio.input.at.utils.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProBusinessData;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010:\u001a\u00020\t\u0012\u0006\u0010>\u001a\u00020\u0003\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J \u0010)\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010'j\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`(H\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\"\u00103\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u00032\u0006\u00102\u001a\u00020\u000bH\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\u0010\u00107\u001a\u00020\u00182\u0006\u00106\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J\u0006\u00109\u001a\u00020\u0003R\u0017\u0010:\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010C\u001a\u0004\u0018\u00010B8\u0006\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\u00a8\u0006I"}, d2 = {"Lcom/tencent/guild/aio/input/at/utils/data/AtUserWithRoleInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Ljava/io/Serializable;", "", "getTinyId", "getMemberName", "getNickName", "getDisplayName", "getAvatarMeta", "", "getUserType", "", "getUserJoinTime", "getRobotType", "", "isMuteSeat", "isVoiceless", "getPlatform", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "getClientIdentity", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientPresenceInfo;", "getClientPresence", "getShutUpExpireTime", "muteLastSecond", "", "setShutUpExpireTime", MessageRoamJsPlugin.USERTYPE, "setUserType", "getRobotMuteStatus", "getRobotPunishmentStatus", "getRobotTestGuilds", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceInfo;", "getGProVoiceInfo", "getGender", "getAllowScreenShare", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProBusinessData;", "getBusinessInfo", "getUserOnlineState", "getLevelRoleId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMyRoles", "isVisitorRole", "getAvatarPendant", "Lcom/tencent/mobileqq/qqguildsdk/data/eu;", "getPersonalMedal", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "getRoleManagementTag", "roleId", "tagName", "color", "setRoleManagementTag", "", "getVasPlateData", NotifyMsgApiImpl.KEY_GROUP_TYPE, "setGroupType", "getGroupType", "getKey", "atType", "I", "getAtType", "()I", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "atRole", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "getAtRole", "()Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "<init>", "(ILjava/lang/String;Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AtUserWithRoleInfo implements IGProUserInfo, Serializable {

    @Nullable
    private final AtRoleInfo atRole;
    private final int atType;

    @NotNull
    private final String name;

    public AtUserWithRoleInfo(int i3, @NotNull String name, @Nullable AtRoleInfo atRoleInfo) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.atType = i3;
        this.name = name;
        this.atRole = atRoleInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getAllowScreenShare() {
        return 0;
    }

    @Nullable
    public final AtRoleInfo getAtRole() {
        return this.atRole;
    }

    public final int getAtType() {
        return this.atType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @NotNull
    public String getAvatarMeta() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public String getAvatarPendant() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public IGProBusinessData getBusinessInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public IGProClientIdentityInfo getClientIdentity() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public IGProClientPresenceInfo getClientPresence() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @NotNull
    /* renamed from: getDisplayName, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public IGProVoiceInfo getGProVoiceInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getGender() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getGroupType() {
        return 0;
    }

    @NotNull
    public final String getKey() {
        String str;
        int i3 = this.atType;
        if (i3 == 8) {
            String tinyId = getTinyId();
            AtRoleInfo atRoleInfo = this.atRole;
            if (atRoleInfo != null) {
                str = atRoleInfo.getRoleId();
            } else {
                str = null;
            }
            return tinyId + str;
        }
        if (i3 == 64) {
            return "1";
        }
        return getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getLevelRoleId() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public String getMemberName() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public ArrayList<Integer> getMyRoles() {
        return new ArrayList<>();
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @NotNull
    public String getNickName() {
        return this.name;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public eu getPersonalMedal() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getPlatform() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotMuteStatus() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotPunishmentStatus() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public String getRobotTestGuilds() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public IGProRoleManagementTag getRoleManagementTag() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public long getShutUpExpireTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @NotNull
    public String getTinyId() {
        return "0";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public long getUserJoinTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getUserOnlineState() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getUserType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public byte[] getVasPlateData() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isMuteSeat() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isVisitorRole() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isVoiceless() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setGroupType(int groupType) {
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setShutUpExpireTime(long muteLastSecond) {
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setUserType(int userType) {
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setRoleManagementTag(long roleId, @Nullable String tagName, long color) {
    }
}
