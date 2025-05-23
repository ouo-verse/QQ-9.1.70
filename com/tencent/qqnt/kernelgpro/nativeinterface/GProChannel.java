package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannel implements Serializable {
    public GProApplicationChannelInfo applicationInfo;
    public ArrayList<GProAuthControlStatus> authControlStatusList;
    public int bannedSpeak;
    public int calcMsgNotifyType;
    public GProCmd0xf55CategoryInfo categoryInfo;
    public long channelChangeSeq;
    public long channelId;
    public String channelName;
    public int channelType;
    public String contentUrl;
    public int contentUrlType;
    public long createTime;
    public long creatorTinyid;
    public ArrayList<GProChannelInfoExtendInfoEntry> extendInfoList;
    public GProForumChannelInfo forumChannelInfo;
    public long gotoChannelId;
    public long guildId;
    public boolean hasCustomMsgNotifyType;
    public int hiddenPostChannel;
    public String iconUrl;
    public int isCategoryAdmin;
    public int isChannelAdmin;
    public GProMsgSeq lastCntMsgSeq;
    public GProMsgSeq lastMsgSeq;
    public GProLiveChannelInfo liveChannelInfo;
    public int livePermission;
    public long maxEventSeq;
    public GProChannelMedalInfo medalInfo;
    public String msgMeta;
    public int msgNotifyType;
    public int myMsgNotifyBackendFlag;
    public int myMsgNotifyType;
    public GProQqMsgListSetting myQqMsgListSetting;
    public GProMsgSeq myReadCntSeq;
    public GProMsgSeq myReadMsgSeq;
    public int mySpeakPermissionType;
    public String operationTitle;
    public int operationType;
    public int privateType;
    public String readMsgMeta;
    public int result;
    long serialVersionUID;
    public ArrayList<GProSlowModeInfo> slowModeInfoList;
    public int slowModeKey;
    public int speakPermission;
    public ArrayList<Integer> specialTypeList;
    public int switchJumpChannelId;
    public GProTextChannelInfo textChannelInfo;
    public GProTopMsg topMsg;
    public ArrayList<GProTopMsg> topMsgList;
    public int visibleType;
    public GProVoiceChannelInfo voiceChannelInfo;

    public GProChannel() {
        this.serialVersionUID = 1L;
        this.channelName = "";
        this.lastMsgSeq = new GProMsgSeq();
        this.lastCntMsgSeq = new GProMsgSeq();
        this.myReadMsgSeq = new GProMsgSeq();
        this.myReadCntSeq = new GProMsgSeq();
        this.voiceChannelInfo = new GProVoiceChannelInfo();
        this.msgMeta = "";
        this.readMsgMeta = "";
        this.liveChannelInfo = new GProLiveChannelInfo();
        this.specialTypeList = new ArrayList<>();
        this.applicationInfo = new GProApplicationChannelInfo();
        this.topMsg = new GProTopMsg();
        this.slowModeInfoList = new ArrayList<>();
        this.textChannelInfo = new GProTextChannelInfo();
        this.forumChannelInfo = new GProForumChannelInfo();
        this.topMsgList = new ArrayList<>();
        this.myQqMsgListSetting = new GProQqMsgListSetting();
        this.authControlStatusList = new ArrayList<>();
        this.medalInfo = new GProChannelMedalInfo();
        this.iconUrl = "";
        this.operationTitle = "";
        this.extendInfoList = new ArrayList<>();
        this.categoryInfo = new GProCmd0xf55CategoryInfo();
        this.contentUrl = "";
    }

    public GProApplicationChannelInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public ArrayList<GProAuthControlStatus> getAuthControlStatusList() {
        return this.authControlStatusList;
    }

    public int getBannedSpeak() {
        return this.bannedSpeak;
    }

    public int getCalcMsgNotifyType() {
        return this.calcMsgNotifyType;
    }

    public GProCmd0xf55CategoryInfo getCategoryInfo() {
        return this.categoryInfo;
    }

    public long getChannelChangeSeq() {
        return this.channelChangeSeq;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public int getContentUrlType() {
        return this.contentUrlType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreatorTinyid() {
        return this.creatorTinyid;
    }

    public ArrayList<GProChannelInfoExtendInfoEntry> getExtendInfoList() {
        return this.extendInfoList;
    }

    public GProForumChannelInfo getForumChannelInfo() {
        return this.forumChannelInfo;
    }

    public long getGotoChannelId() {
        return this.gotoChannelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasCustomMsgNotifyType() {
        return this.hasCustomMsgNotifyType;
    }

    public int getHiddenPostChannel() {
        return this.hiddenPostChannel;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getIsCategoryAdmin() {
        return this.isCategoryAdmin;
    }

    public int getIsChannelAdmin() {
        return this.isChannelAdmin;
    }

    public GProMsgSeq getLastCntMsgSeq() {
        return this.lastCntMsgSeq;
    }

    public GProMsgSeq getLastMsgSeq() {
        return this.lastMsgSeq;
    }

    public GProLiveChannelInfo getLiveChannelInfo() {
        return this.liveChannelInfo;
    }

    public int getLivePermission() {
        return this.livePermission;
    }

    public long getMaxEventSeq() {
        return this.maxEventSeq;
    }

    public GProChannelMedalInfo getMedalInfo() {
        return this.medalInfo;
    }

    public String getMsgMeta() {
        return this.msgMeta;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public int getMyMsgNotifyBackendFlag() {
        return this.myMsgNotifyBackendFlag;
    }

    public int getMyMsgNotifyType() {
        return this.myMsgNotifyType;
    }

    public GProQqMsgListSetting getMyQqMsgListSetting() {
        return this.myQqMsgListSetting;
    }

    public GProMsgSeq getMyReadCntSeq() {
        return this.myReadCntSeq;
    }

    public GProMsgSeq getMyReadMsgSeq() {
        return this.myReadMsgSeq;
    }

    public int getMySpeakPermissionType() {
        return this.mySpeakPermissionType;
    }

    public String getOperationTitle() {
        return this.operationTitle;
    }

    public int getOperationType() {
        return this.operationType;
    }

    public int getPrivateType() {
        return this.privateType;
    }

    public String getReadMsgMeta() {
        return this.readMsgMeta;
    }

    public int getResult() {
        return this.result;
    }

    public ArrayList<GProSlowModeInfo> getSlowModeInfoList() {
        return this.slowModeInfoList;
    }

    public int getSlowModeKey() {
        return this.slowModeKey;
    }

    public int getSpeakPermission() {
        return this.speakPermission;
    }

    public ArrayList<Integer> getSpecialTypeList() {
        return this.specialTypeList;
    }

    public int getSwitchJumpChannelId() {
        return this.switchJumpChannelId;
    }

    public GProTextChannelInfo getTextChannelInfo() {
        return this.textChannelInfo;
    }

    public GProTopMsg getTopMsg() {
        return this.topMsg;
    }

    public ArrayList<GProTopMsg> getTopMsgList() {
        return this.topMsgList;
    }

    public int getVisibleType() {
        return this.visibleType;
    }

    public GProVoiceChannelInfo getVoiceChannelInfo() {
        return this.voiceChannelInfo;
    }

    public void setApplicationInfo(GProApplicationChannelInfo gProApplicationChannelInfo) {
        this.applicationInfo = gProApplicationChannelInfo;
    }

    public void setAuthControlStatusList(ArrayList<GProAuthControlStatus> arrayList) {
        this.authControlStatusList = arrayList;
    }

    public void setBannedSpeak(int i3) {
        this.bannedSpeak = i3;
    }

    public void setCalcMsgNotifyType(int i3) {
        this.calcMsgNotifyType = i3;
    }

    public void setCategoryInfo(GProCmd0xf55CategoryInfo gProCmd0xf55CategoryInfo) {
        this.categoryInfo = gProCmd0xf55CategoryInfo;
    }

    public void setChannelChangeSeq(long j3) {
        this.channelChangeSeq = j3;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setChannelType(int i3) {
        this.channelType = i3;
    }

    public void setContentUrl(String str) {
        this.contentUrl = str;
    }

    public void setContentUrlType(int i3) {
        this.contentUrlType = i3;
    }

    public void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public void setCreatorTinyid(long j3) {
        this.creatorTinyid = j3;
    }

    public void setExtendInfoList(ArrayList<GProChannelInfoExtendInfoEntry> arrayList) {
        this.extendInfoList = arrayList;
    }

    public void setForumChannelInfo(GProForumChannelInfo gProForumChannelInfo) {
        this.forumChannelInfo = gProForumChannelInfo;
    }

    public void setGotoChannelId(long j3) {
        this.gotoChannelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setHasCustomMsgNotifyType(boolean z16) {
        this.hasCustomMsgNotifyType = z16;
    }

    public void setHiddenPostChannel(int i3) {
        this.hiddenPostChannel = i3;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setIsCategoryAdmin(int i3) {
        this.isCategoryAdmin = i3;
    }

    public void setIsChannelAdmin(int i3) {
        this.isChannelAdmin = i3;
    }

    public void setLastCntMsgSeq(GProMsgSeq gProMsgSeq) {
        this.lastCntMsgSeq = gProMsgSeq;
    }

    public void setLastMsgSeq(GProMsgSeq gProMsgSeq) {
        this.lastMsgSeq = gProMsgSeq;
    }

    public void setLiveChannelInfo(GProLiveChannelInfo gProLiveChannelInfo) {
        this.liveChannelInfo = gProLiveChannelInfo;
    }

    public void setLivePermission(int i3) {
        this.livePermission = i3;
    }

    public void setMaxEventSeq(long j3) {
        this.maxEventSeq = j3;
    }

    public void setMedalInfo(GProChannelMedalInfo gProChannelMedalInfo) {
        this.medalInfo = gProChannelMedalInfo;
    }

    public void setMsgMeta(String str) {
        this.msgMeta = str;
    }

    public void setMsgNotifyType(int i3) {
        this.msgNotifyType = i3;
    }

    public void setMyMsgNotifyBackendFlag(int i3) {
        this.myMsgNotifyBackendFlag = i3;
    }

    public void setMyMsgNotifyType(int i3) {
        this.myMsgNotifyType = i3;
    }

    public void setMyQqMsgListSetting(GProQqMsgListSetting gProQqMsgListSetting) {
        this.myQqMsgListSetting = gProQqMsgListSetting;
    }

    public void setMyReadCntSeq(GProMsgSeq gProMsgSeq) {
        this.myReadCntSeq = gProMsgSeq;
    }

    public void setMyReadMsgSeq(GProMsgSeq gProMsgSeq) {
        this.myReadMsgSeq = gProMsgSeq;
    }

    public void setMySpeakPermissionType(int i3) {
        this.mySpeakPermissionType = i3;
    }

    public void setOperationTitle(String str) {
        this.operationTitle = str;
    }

    public void setOperationType(int i3) {
        this.operationType = i3;
    }

    public void setPrivateType(int i3) {
        this.privateType = i3;
    }

    public void setReadMsgMeta(String str) {
        this.readMsgMeta = str;
    }

    public void setResult(int i3) {
        this.result = i3;
    }

    public void setSlowModeInfoList(ArrayList<GProSlowModeInfo> arrayList) {
        this.slowModeInfoList = arrayList;
    }

    public void setSlowModeKey(int i3) {
        this.slowModeKey = i3;
    }

    public void setSpeakPermission(int i3) {
        this.speakPermission = i3;
    }

    public void setSpecialTypeList(ArrayList<Integer> arrayList) {
        this.specialTypeList = arrayList;
    }

    public void setSwitchJumpChannelId(int i3) {
        this.switchJumpChannelId = i3;
    }

    public void setTextChannelInfo(GProTextChannelInfo gProTextChannelInfo) {
        this.textChannelInfo = gProTextChannelInfo;
    }

    public void setTopMsg(GProTopMsg gProTopMsg) {
        this.topMsg = gProTopMsg;
    }

    public void setTopMsgList(ArrayList<GProTopMsg> arrayList) {
        this.topMsgList = arrayList;
    }

    public void setVisibleType(int i3) {
        this.visibleType = i3;
    }

    public void setVoiceChannelInfo(GProVoiceChannelInfo gProVoiceChannelInfo) {
        this.voiceChannelInfo = gProVoiceChannelInfo;
    }

    public String toString() {
        return "GProChannel{channelId=" + this.channelId + ",channelName=" + this.channelName + ",createTime=" + this.createTime + ",guildId=" + this.guildId + ",msgNotifyType=" + this.msgNotifyType + ",channelType=" + this.channelType + ",speakPermission=" + this.speakPermission + ",result=" + this.result + ",myMsgNotifyType=" + this.myMsgNotifyType + ",lastMsgSeq=" + this.lastMsgSeq + ",lastCntMsgSeq=" + this.lastCntMsgSeq + ",myReadMsgSeq=" + this.myReadMsgSeq + ",myReadCntSeq=" + this.myReadCntSeq + ",creatorTinyid=" + this.creatorTinyid + ",voiceChannelInfo=" + this.voiceChannelInfo + ",msgMeta=" + this.msgMeta + ",readMsgMeta=" + this.readMsgMeta + ",liveChannelInfo=" + this.liveChannelInfo + ",bannedSpeak=" + this.bannedSpeak + ",privateType=" + this.privateType + ",specialTypeList=" + this.specialTypeList + ",calcMsgNotifyType=" + this.calcMsgNotifyType + ",applicationInfo=" + this.applicationInfo + ",topMsg=" + this.topMsg + ",slowModeKey=" + this.slowModeKey + ",slowModeInfoList=" + this.slowModeInfoList + ",textChannelInfo=" + this.textChannelInfo + ",forumChannelInfo=" + this.forumChannelInfo + ",visibleType=" + this.visibleType + ",mySpeakPermissionType=" + this.mySpeakPermissionType + ",isChannelAdmin=" + this.isChannelAdmin + ",topMsgList=" + this.topMsgList + ",myQqMsgListSetting=" + this.myQqMsgListSetting + ",livePermission=" + this.livePermission + ",authControlStatusList=" + this.authControlStatusList + ",gotoChannelId=" + this.gotoChannelId + ",switchJumpChannelId=" + this.switchJumpChannelId + ",maxEventSeq=" + this.maxEventSeq + ",isCategoryAdmin=" + this.isCategoryAdmin + ",medalInfo=" + this.medalInfo + ",operationType=" + this.operationType + ",iconUrl=" + this.iconUrl + ",operationTitle=" + this.operationTitle + ",hiddenPostChannel=" + this.hiddenPostChannel + ",myMsgNotifyBackendFlag=" + this.myMsgNotifyBackendFlag + ",extendInfoList=" + this.extendInfoList + ",channelChangeSeq=" + this.channelChangeSeq + ",hasCustomMsgNotifyType=" + this.hasCustomMsgNotifyType + ",categoryInfo=" + this.categoryInfo + ",contentUrl=" + this.contentUrl + ",contentUrlType=" + this.contentUrlType + ",}";
    }

    public GProChannel(long j3, String str, long j16, long j17, int i3, int i16, int i17, int i18, int i19, GProMsgSeq gProMsgSeq, GProMsgSeq gProMsgSeq2, GProMsgSeq gProMsgSeq3, GProMsgSeq gProMsgSeq4, long j18, GProVoiceChannelInfo gProVoiceChannelInfo, String str2, String str3, GProLiveChannelInfo gProLiveChannelInfo, int i26, int i27, ArrayList<Integer> arrayList, int i28, GProApplicationChannelInfo gProApplicationChannelInfo, GProTopMsg gProTopMsg, int i29, ArrayList<GProSlowModeInfo> arrayList2, GProTextChannelInfo gProTextChannelInfo, GProForumChannelInfo gProForumChannelInfo, int i36, int i37, int i38, ArrayList<GProTopMsg> arrayList3, GProQqMsgListSetting gProQqMsgListSetting, int i39, ArrayList<GProAuthControlStatus> arrayList4, long j19, int i46, long j26, int i47, GProChannelMedalInfo gProChannelMedalInfo, int i48, String str4, String str5, int i49, long j27, boolean z16, GProCmd0xf55CategoryInfo gProCmd0xf55CategoryInfo) {
        this.serialVersionUID = 1L;
        this.channelName = "";
        this.lastMsgSeq = new GProMsgSeq();
        this.lastCntMsgSeq = new GProMsgSeq();
        this.myReadMsgSeq = new GProMsgSeq();
        this.myReadCntSeq = new GProMsgSeq();
        this.voiceChannelInfo = new GProVoiceChannelInfo();
        this.msgMeta = "";
        this.readMsgMeta = "";
        this.liveChannelInfo = new GProLiveChannelInfo();
        this.specialTypeList = new ArrayList<>();
        this.applicationInfo = new GProApplicationChannelInfo();
        this.topMsg = new GProTopMsg();
        this.slowModeInfoList = new ArrayList<>();
        this.textChannelInfo = new GProTextChannelInfo();
        this.forumChannelInfo = new GProForumChannelInfo();
        this.topMsgList = new ArrayList<>();
        this.myQqMsgListSetting = new GProQqMsgListSetting();
        this.authControlStatusList = new ArrayList<>();
        this.medalInfo = new GProChannelMedalInfo();
        this.iconUrl = "";
        this.operationTitle = "";
        this.extendInfoList = new ArrayList<>();
        new GProCmd0xf55CategoryInfo();
        this.contentUrl = "";
        this.channelId = j3;
        this.channelName = str;
        this.createTime = j16;
        this.guildId = j17;
        this.msgNotifyType = i3;
        this.channelType = i16;
        this.speakPermission = i17;
        this.result = i18;
        this.myMsgNotifyType = i19;
        this.lastMsgSeq = gProMsgSeq;
        this.lastCntMsgSeq = gProMsgSeq2;
        this.myReadMsgSeq = gProMsgSeq3;
        this.myReadCntSeq = gProMsgSeq4;
        this.creatorTinyid = j18;
        this.voiceChannelInfo = gProVoiceChannelInfo;
        this.msgMeta = str2;
        this.readMsgMeta = str3;
        this.liveChannelInfo = gProLiveChannelInfo;
        this.bannedSpeak = i26;
        this.privateType = i27;
        this.specialTypeList = arrayList;
        this.calcMsgNotifyType = i28;
        this.applicationInfo = gProApplicationChannelInfo;
        this.topMsg = gProTopMsg;
        this.slowModeKey = i29;
        this.slowModeInfoList = arrayList2;
        this.textChannelInfo = gProTextChannelInfo;
        this.forumChannelInfo = gProForumChannelInfo;
        this.visibleType = i36;
        this.mySpeakPermissionType = i37;
        this.isChannelAdmin = i38;
        this.topMsgList = arrayList3;
        this.myQqMsgListSetting = gProQqMsgListSetting;
        this.livePermission = i39;
        this.authControlStatusList = arrayList4;
        this.gotoChannelId = j19;
        this.switchJumpChannelId = i46;
        this.maxEventSeq = j26;
        this.isCategoryAdmin = i47;
        this.medalInfo = gProChannelMedalInfo;
        this.operationType = i48;
        this.iconUrl = str4;
        this.operationTitle = str5;
        this.hiddenPostChannel = i49;
        this.channelChangeSeq = j27;
        this.hasCustomMsgNotifyType = z16;
        this.categoryInfo = gProCmd0xf55CategoryInfo;
    }
}
