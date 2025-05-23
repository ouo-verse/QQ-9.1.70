package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProChannel extends Serializable {
    IGProApplicationChannelInfo getApplicationInfo();

    ArrayList<IGProAuthControlStatus> getAuthControlStatusList();

    int getBannedSpeak();

    int getCalcMsgNotifyType();

    IGProCmd0xf55CategoryInfo getCategoryInfo();

    long getChannelChangeSeq();

    long getChannelId();

    String getChannelName();

    int getChannelType();

    String getContentUrl();

    int getContentUrlType();

    long getCreateTime();

    long getCreatorTinyid();

    ArrayList<IGProChannelInfoExtendInfoEntry> getExtendInfoList();

    IGProForumChannelInfo getForumChannelInfo();

    long getGotoChannelId();

    long getGuildId();

    boolean getHasCustomMsgNotifyType();

    int getHiddenPostChannel();

    String getIconUrl();

    int getIsCategoryAdmin();

    int getIsChannelAdmin();

    IGProMsgSeq getLastCntMsgSeq();

    IGProMsgSeq getLastMsgSeq();

    IGProLiveChannelInfo getLiveChannelInfo();

    int getLivePermission();

    long getMaxEventSeq();

    IGProChannelMedalInfo getMedalInfo();

    String getMsgMeta();

    int getMsgNotifyType();

    int getMyMsgNotifyBackendFlag();

    int getMyMsgNotifyType();

    IGProQqMsgListSetting getMyQqMsgListSetting();

    IGProMsgSeq getMyReadCntSeq();

    IGProMsgSeq getMyReadMsgSeq();

    int getMySpeakPermissionType();

    String getOperationTitle();

    int getOperationType();

    int getPrivateType();

    String getReadMsgMeta();

    int getResult();

    ArrayList<IGProSlowModeInfo> getSlowModeInfoList();

    int getSlowModeKey();

    int getSpeakPermission();

    ArrayList<Integer> getSpecialTypeList();

    int getSwitchJumpChannelId();

    IGProTextChannelInfo getTextChannelInfo();

    IGProTopMsg getTopMsg();

    ArrayList<IGProTopMsg> getTopMsgList();

    int getVisibleType();

    IGProVoiceChannelInfo getVoiceChannelInfo();

    String toString();
}
