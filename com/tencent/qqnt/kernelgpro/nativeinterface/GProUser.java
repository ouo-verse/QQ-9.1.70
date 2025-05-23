package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUser implements Serializable {
    public int allowScreenShare;
    public String avatarMeta;
    public String avatarPendant;
    public GProBusinessInfo businessInfo;
    public int chnRole;
    public GProClientIdentity clientIdentity;
    public GProClientPresence clientPresence;
    public byte[] cookie;
    public int gender;
    public long guildId;
    public boolean guildMute;
    public boolean inBlack;
    public long joinTime;
    public int levelRoleId;
    public String memberName;
    public ArrayList<Integer> myRoles;
    public String nickName;
    public int onlineState;
    public GProMedal personalMedal;
    public int platform;
    public int robotMuteStatus;
    public int robotPunishmentStatus;
    public String robotTestGuilds;
    public int robotType;
    public GProRoleManagementTag roleManagementTag;
    long serialVersionUID;
    public long shutUpExpireTime;
    public long tinyId;
    public int type;
    public GProVoiceInfo voiceInfo;

    public GProUser() {
        this.serialVersionUID = 1L;
        this.memberName = "";
        this.nickName = "";
        this.cookie = new byte[0];
        this.clientIdentity = new GProClientIdentity();
        this.clientPresence = new GProClientPresence();
        this.robotTestGuilds = "";
        this.avatarMeta = "";
        this.voiceInfo = new GProVoiceInfo();
        this.businessInfo = new GProBusinessInfo();
        this.myRoles = new ArrayList<>();
        this.avatarPendant = "";
        this.personalMedal = new GProMedal();
        this.roleManagementTag = new GProRoleManagementTag();
    }

    public int getAllowScreenShare() {
        return this.allowScreenShare;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public GProBusinessInfo getBusinessInfo() {
        return this.businessInfo;
    }

    public int getChnRole() {
        return this.chnRole;
    }

    public GProClientIdentity getClientIdentity() {
        return this.clientIdentity;
    }

    public GProClientPresence getClientPresence() {
        return this.clientPresence;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public int getGender() {
        return this.gender;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getGuildMute() {
        return this.guildMute;
    }

    public boolean getInBlack() {
        return this.inBlack;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public int getLevelRoleId() {
        return this.levelRoleId;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public ArrayList<Integer> getMyRoles() {
        return this.myRoles;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getOnlineState() {
        return this.onlineState;
    }

    public GProMedal getPersonalMedal() {
        return this.personalMedal;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getRobotMuteStatus() {
        return this.robotMuteStatus;
    }

    public int getRobotPunishmentStatus() {
        return this.robotPunishmentStatus;
    }

    public String getRobotTestGuilds() {
        return this.robotTestGuilds;
    }

    public int getRobotType() {
        return this.robotType;
    }

    public GProRoleManagementTag getRoleManagementTag() {
        return this.roleManagementTag;
    }

    public long getShutUpExpireTime() {
        return this.shutUpExpireTime;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getType() {
        return this.type;
    }

    public GProVoiceInfo getVoiceInfo() {
        return this.voiceInfo;
    }

    public void setAllowScreenShare(int i3) {
        this.allowScreenShare = i3;
    }

    public void setAvatarMeta(String str) {
        this.avatarMeta = str;
    }

    public void setAvatarPendant(String str) {
        this.avatarPendant = str;
    }

    public void setBusinessInfo(GProBusinessInfo gProBusinessInfo) {
        this.businessInfo = gProBusinessInfo;
    }

    public void setChnRole(int i3) {
        this.chnRole = i3;
    }

    public void setClientIdentity(GProClientIdentity gProClientIdentity) {
        this.clientIdentity = gProClientIdentity;
    }

    public void setClientPresence(GProClientPresence gProClientPresence) {
        this.clientPresence = gProClientPresence;
    }

    public void setCookie(byte[] bArr) {
        this.cookie = bArr;
    }

    public void setGender(int i3) {
        this.gender = i3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setGuildMute(boolean z16) {
        this.guildMute = z16;
    }

    public void setInBlack(boolean z16) {
        this.inBlack = z16;
    }

    public void setJoinTime(long j3) {
        this.joinTime = j3;
    }

    public void setLevelRoleId(int i3) {
        this.levelRoleId = i3;
    }

    public void setMemberName(String str) {
        this.memberName = str;
    }

    public void setMyRoles(ArrayList<Integer> arrayList) {
        this.myRoles = arrayList;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOnlineState(int i3) {
        this.onlineState = i3;
    }

    public void setPersonalMedal(GProMedal gProMedal) {
        this.personalMedal = gProMedal;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setRobotMuteStatus(int i3) {
        this.robotMuteStatus = i3;
    }

    public void setRobotPunishmentStatus(int i3) {
        this.robotPunishmentStatus = i3;
    }

    public void setRobotTestGuilds(String str) {
        this.robotTestGuilds = str;
    }

    public void setRobotType(int i3) {
        this.robotType = i3;
    }

    public void setRoleManagementTag(GProRoleManagementTag gProRoleManagementTag) {
        this.roleManagementTag = gProRoleManagementTag;
    }

    public void setShutUpExpireTime(long j3) {
        this.shutUpExpireTime = j3;
    }

    public void setTinyId(long j3) {
        this.tinyId = j3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setVoiceInfo(GProVoiceInfo gProVoiceInfo) {
        this.voiceInfo = gProVoiceInfo;
    }

    public String toString() {
        return "GProUser{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",memberName=" + this.memberName + ",nickName=" + this.nickName + ",type=" + this.type + ",joinTime=" + this.joinTime + ",robotType=" + this.robotType + ",chnRole=" + this.chnRole + ",guildMute=" + this.guildMute + ",inBlack=" + this.inBlack + ",platform=" + this.platform + ",cookie=" + this.cookie + ",clientIdentity=" + this.clientIdentity + ",clientPresence=" + this.clientPresence + ",shutUpExpireTime=" + this.shutUpExpireTime + ",robotMuteStatus=" + this.robotMuteStatus + ",robotPunishmentStatus=" + this.robotPunishmentStatus + ",robotTestGuilds=" + this.robotTestGuilds + ",avatarMeta=" + this.avatarMeta + ",voiceInfo=" + this.voiceInfo + ",gender=" + this.gender + ",allowScreenShare=" + this.allowScreenShare + ",businessInfo=" + this.businessInfo + ",onlineState=" + this.onlineState + ",levelRoleId=" + this.levelRoleId + ",myRoles=" + this.myRoles + ",avatarPendant=" + this.avatarPendant + ",personalMedal=" + this.personalMedal + ",roleManagementTag=" + this.roleManagementTag + ",}";
    }

    public GProUser(long j3, long j16, String str, String str2, int i3, long j17, int i16, int i17, boolean z16, boolean z17, int i18, byte[] bArr, GProClientIdentity gProClientIdentity, GProClientPresence gProClientPresence, long j18, int i19, int i26, String str3, String str4, GProVoiceInfo gProVoiceInfo, int i27, int i28, GProBusinessInfo gProBusinessInfo, int i29, int i36, ArrayList<Integer> arrayList, String str5, GProMedal gProMedal, GProRoleManagementTag gProRoleManagementTag) {
        this.serialVersionUID = 1L;
        this.memberName = "";
        this.nickName = "";
        this.cookie = new byte[0];
        this.clientIdentity = new GProClientIdentity();
        this.clientPresence = new GProClientPresence();
        this.robotTestGuilds = "";
        this.avatarMeta = "";
        this.voiceInfo = new GProVoiceInfo();
        this.businessInfo = new GProBusinessInfo();
        this.myRoles = new ArrayList<>();
        this.avatarPendant = "";
        this.personalMedal = new GProMedal();
        new GProRoleManagementTag();
        this.tinyId = j3;
        this.guildId = j16;
        this.memberName = str;
        this.nickName = str2;
        this.type = i3;
        this.joinTime = j17;
        this.robotType = i16;
        this.chnRole = i17;
        this.guildMute = z16;
        this.inBlack = z17;
        this.platform = i18;
        this.cookie = bArr;
        this.clientIdentity = gProClientIdentity;
        this.clientPresence = gProClientPresence;
        this.shutUpExpireTime = j18;
        this.robotMuteStatus = i19;
        this.robotPunishmentStatus = i26;
        this.robotTestGuilds = str3;
        this.avatarMeta = str4;
        this.voiceInfo = gProVoiceInfo;
        this.gender = i27;
        this.allowScreenShare = i28;
        this.businessInfo = gProBusinessInfo;
        this.onlineState = i29;
        this.levelRoleId = i36;
        this.myRoles = arrayList;
        this.avatarPendant = str5;
        this.personalMedal = gProMedal;
        this.roleManagementTag = gProRoleManagementTag;
    }
}
