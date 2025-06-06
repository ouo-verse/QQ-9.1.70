package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteSpeakCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes17.dex */
public interface IGProChannelInfo extends Serializable {
    @Deprecated
    int getAllowOtherRaiseHand();

    String getAppChannelIconUrl();

    int getAppChannelJumpType();

    String getAppChannelJumpUrl();

    long getApplicationId();

    ArrayList<df> getAuthControlStatusList();

    int getBannedSpeak();

    long getCategoryId();

    String getCategoryName();

    int getCategoryType();

    int getChannelLiveableType();

    int getChannelMemberMax();

    String getChannelName();

    String getChannelUin();

    String getContentUrl();

    int getContentUrlType();

    long getCreateTime();

    String getCreatorId();

    int getFinalMsgNotify();

    int getForumSortMode();

    ArrayList<ISlowModeInfo> getGProSlowModeInfoList();

    long getGotoChannelId();

    String getGuildId();

    String getHotIcon();

    int getHotIndex();

    String getIconUrl();

    IGProInviteSpeakCfg getInviteSpeakCfg();

    int getIsCategoryAdmin();

    int getIsChannelAdmin();

    int getJumpSwitch();

    long getLastCntMsgSeq();

    long getLastCntMsgTime();

    long getLastMsgSeq();

    long getLastMsgTime();

    long getLiveAnchorTinyId();

    long getLiveRoomId();

    String getLiveRoomName();

    IGProMedalInfo getMedalInfo();

    byte[] getMsgMeta();

    int getMsgNotify();

    int getMyTalkPermissionType();

    int getNoMemberMaxLimited();

    String getOperationTitle();

    int getOperationType();

    long getReadCntMsgSeq();

    long getReadCntMsgTime();

    byte[] getReadMsgMeta();

    long getReadMsgSeq();

    long getReadMsgTime();

    int getSlowModeKey();

    @NonNull
    List<Integer> getSpecialType();

    int getTalkPermission();

    int getTextChannelSubtypeId();

    ArrayList<IGProTopMsg> getTopMsgList();

    String getTopMsgOperatorTinyId();

    long getTopMsgSeq();

    long getTopMsgTime();

    int getType();

    int getVisibleType();

    IGProVoiceQueueCfg getVoiceQueueCfg();

    IGProVoiceSpeakModeCfg getVoiceSpeakModeCfg();

    boolean isAllowOtherRaiseHand();

    boolean isChannelOrCategoryAdmin();

    boolean isHiddenPostChannel();

    void setFinalMsgNotify(int i3);
}
