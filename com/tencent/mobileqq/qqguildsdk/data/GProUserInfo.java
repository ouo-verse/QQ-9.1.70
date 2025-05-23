package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedal;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleManagementTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GProUserInfo implements IGProUserInfo {
    private GProUser mUser;
    private String tinyId;

    public GProUserInfo(GProUser gProUser) {
        this.mUser = gProUser;
        this.tinyId = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProUser.getTinyId());
    }

    private String a(GProUser gProUser) {
        return "GProUser{tinyId=" + gProUser.tinyId + ",guildId=" + gProUser.guildId + ",memberName=" + com.tencent.qqnt.kernel.nativeinterface.cq.w(gProUser.memberName, 2) + ",nickName=" + com.tencent.qqnt.kernel.nativeinterface.cq.w(gProUser.nickName, 2) + ",type=" + gProUser.type + ",joinTime=" + gProUser.joinTime + ",robotType=" + gProUser.robotType + ",chnRole=" + gProUser.chnRole + ",guildMute=" + gProUser.guildMute + ",inBlack=" + gProUser.inBlack + ",platform=" + gProUser.platform + ",clientIdentity=" + gProUser.clientIdentity + ",clientPresence=" + gProUser.clientPresence + ",shutUpExpireTime=" + gProUser.shutUpExpireTime + ",robotMuteStatus=" + gProUser.robotMuteStatus + ",robotPunishmentStatus=" + gProUser.robotPunishmentStatus + ",robotTestGuilds=" + gProUser.robotTestGuilds + ",avatarMeta=" + gProUser.avatarMeta + ",voiceInfo=" + gProUser.voiceInfo + ",gender=" + gProUser.gender + ",allowScreenShare=" + gProUser.allowScreenShare + ",businessInfo=" + gProUser.businessInfo + ",onlineState=" + gProUser.onlineState + ",levelRoleId=" + gProUser.levelRoleId + ",myRoles=" + gProUser.myRoles + ",avatarPendant=" + gProUser.avatarPendant + ",personalMedal=" + gProUser.personalMedal + ",roleManagementTag=" + gProUser.roleManagementTag + "}";
    }

    private void b(String str) {
        this.mUser.setMemberName(str);
    }

    private void c(int i3) {
        this.mUser.setRobotType(i3);
    }

    private void d(long j3) {
        this.mUser.setJoinTime(j3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getAllowScreenShare() {
        return this.mUser.getAllowScreenShare();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getAvatarMeta() {
        return this.mUser.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getAvatarPendant() {
        return this.mUser.getAvatarPendant();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProBusinessData getBusinessInfo() {
        return new GProBusinessData(this.mUser.getBusinessInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProClientIdentityInfo getClientIdentity() {
        return new GProClientIdentityInfo(this.mUser.getClientIdentity());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProClientPresenceInfo getClientPresence() {
        return new GProClientPresenceInfo(this.mUser.getClientPresence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    /* renamed from: getDisplayName */
    public String getName() {
        if (!TextUtils.isEmpty(getMemberName())) {
            return getMemberName();
        }
        return getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProVoiceInfo getGProVoiceInfo() {
        if (this.mUser.getVoiceInfo() == null) {
            return new GGProVoiceInfo(new GProVoiceInfo(0, 2, "", 0L, 0L));
        }
        return new GGProVoiceInfo(this.mUser.getVoiceInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getGender() {
        return this.mUser.getGender();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getGroupType() {
        return this.mUser.businessInfo.userListGroupInfo.groupType;
    }

    public String getGuildId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mUser.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getLevelRoleId() {
        return this.mUser.getLevelRoleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getMemberName() {
        return this.mUser.getMemberName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public ArrayList<Integer> getMyRoles() {
        return this.mUser.getMyRoles();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getNickName() {
        return this.mUser.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public eu getPersonalMedal() {
        return new ce(this.mUser.getPersonalMedal());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getPlatform() {
        return this.mUser.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotMuteStatus() {
        return this.mUser.getRobotMuteStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotPunishmentStatus() {
        return this.mUser.getRobotPunishmentStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getRobotTestGuilds() {
        return this.mUser.getRobotTestGuilds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getRobotType() {
        return this.mUser.getRobotType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public IGProRoleManagementTag getRoleManagementTag() {
        return new GGProRoleManagementTag(this.mUser.getRoleManagementTag());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public long getShutUpExpireTime() {
        return this.mUser.getShutUpExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public String getTinyId() {
        return this.tinyId;
    }

    public GProUser getUser() {
        return this.mUser;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public long getUserJoinTime() {
        return this.mUser.getJoinTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getUserOnlineState() {
        return this.mUser.getOnlineState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public int getUserType() {
        return this.mUser.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    @Nullable
    public byte[] getVasPlateData() {
        ArrayList<GProIdentityWithClientId> defaultIdentitys;
        GProClientIdentityBytes identityBytes = this.mUser.getClientIdentity().getIdentityBytes();
        if (identityBytes == null || (defaultIdentitys = identityBytes.getDefaultIdentitys()) == null) {
            return null;
        }
        Iterator<GProIdentityWithClientId> it = defaultIdentitys.iterator();
        while (it.hasNext()) {
            GProIdentityWithClientId next = it.next();
            if (next.getIdentitys().getIdentityType() == 2) {
                return next.getIdentitys().getThirdPartyData();
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isMuteSeat() {
        return this.mUser.getGuildMute();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isVisitorRole() {
        if (this.mUser.getMyRoles() == null || this.mUser.getMyRoles().isEmpty()) {
            return false;
        }
        Iterator<Integer> it = this.mUser.getMyRoles().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == 6) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public boolean isVoiceless() {
        return this.mUser.getInBlack();
    }

    public GProUserInfo reflash(e eVar) {
        if (!TextUtils.isEmpty(eVar.e())) {
            setNickName(eVar.e());
        }
        return this;
    }

    public void setGProVoiceInfo(IGProVoiceInfo iGProVoiceInfo) {
        GProVoiceInfo gProVoiceInfo;
        if (iGProVoiceInfo == null) {
            gProVoiceInfo = new GProVoiceInfo(0, 2, "", 0L, 0L);
        } else {
            gProVoiceInfo = new GProVoiceInfo(iGProVoiceInfo.getVoiceState(), iGProVoiceInfo.getScreenState(), iGProVoiceInfo.getScreenPic(), iGProVoiceInfo.getScreenUpdateTime(), iGProVoiceInfo.getScreenShareTinyId());
        }
        this.mUser.setVoiceInfo(gProVoiceInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setGroupType(int i3) {
        this.mUser.businessInfo.userListGroupInfo.groupType = i3;
    }

    public void setNickName(String str) {
        this.mUser.setNickName(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setRoleManagementTag(long j3, String str, long j16) {
        this.mUser.setRoleManagementTag(new GProRoleManagementTag(j3, str, j16));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setShutUpExpireTime(long j3) {
        this.mUser.setShutUpExpireTime(j3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo
    public void setUserType(int i3) {
        this.mUser.setType(i3);
    }

    public void setVoiceless(boolean z16) {
        this.mUser.setInBlack(z16);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GProUserInfo{");
        stringBuffer.append("mUser=");
        stringBuffer.append(a(this.mUser));
        stringBuffer.append(", tinyId='");
        stringBuffer.append(this.tinyId);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public GProUserInfo reflash(IGProUserInfo iGProUserInfo) {
        setNickName(iGProUserInfo.getNickName());
        b(iGProUserInfo.getMemberName());
        c(iGProUserInfo.getRobotType());
        d(iGProUserInfo.getUserJoinTime());
        setUserType(iGProUserInfo.getUserType());
        return this;
    }

    public GProUserInfo(String str, e eVar) {
        this.mUser = new GProUser(com.tencent.mobileqq.qqguildsdk.util.g.O0(eVar.b()), com.tencent.mobileqq.qqguildsdk.util.g.O0(str), "", eVar.a(), 0, 1L, 0, 0, false, false, 0, new byte[0], null, null, 0L, 0, 0, "", "", null, 0, 0, null, 0, 0, new ArrayList(), "", new GProMedal(0L, 0L, "", ""), new GProRoleManagementTag(0L, "", 0L));
        this.tinyId = eVar.b();
    }

    public GProUserInfo(String str) {
        this.mUser = new GProUser(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), 0L, "", "", 0, 1L, 0, 0, false, false, 0, new byte[0], null, null, 0L, 0, 0, "", "", null, 0, 0, null, 0, 0, new ArrayList(), "", new GProMedal(0L, 0L, "", ""), new GProRoleManagementTag(0L, "", 0L));
        this.tinyId = str;
    }

    public GProUserInfo reflash(GProUser gProUser) {
        this.mUser = gProUser;
        return this;
    }
}
