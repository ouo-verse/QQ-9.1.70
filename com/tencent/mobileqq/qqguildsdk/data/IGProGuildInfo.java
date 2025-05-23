package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildGlobalAuthInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSafetyRisk;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildInfo extends Serializable {
    public static final long serialVersionUID = 1;

    boolean getAllowSearch();

    long getAvatarSeq();

    String getAvatarUrl(int i3);

    long getBannedTimeLimit();

    String getCanBeEmptyCoverUrl(int i3, int i16);

    long getChangeNameInterval();

    String getClientId();

    int getCoverFontColorId();

    String getCoverUrl(int i3, int i16);

    long getCreateTime();

    String getCreatorId();

    String getErrMsg();

    int getFeedInteractionNotify();

    int getFeedInteractionNotifyAll();

    int getFeedInteractionNotifyIdentityGroup();

    GProGuildSafetyRisk getGProGuildSafetyRisk();

    long getGroupId();

    int getGuildAudioChannelNotify();

    GProGuildAuditInfo getGuildAuditInfo();

    boolean getGuildCanShare();

    GProGuildGlobalAuthInfo getGuildGlobalAuthInfo();

    String getGuildID();

    int getGuildManagementNotify();

    String getGuildName();

    long getGuildNameChangeTime();

    int getGuildNumSearch();

    String getGuildNumber();

    int getGuildPostFeedNotify();

    ArrayList<GProGuildAuditBaseItem> getGuildRules();

    int getGuildSignInNotify();

    int getGuildTopFeedMsgNotify();

    int getGuildType();

    int getGuildUnNotifyFlag();

    com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo getInnerGuildInfo();

    boolean getIsBanned();

    boolean getIsFrozen();

    boolean getIsValid();

    long getJoinTime();

    long getJumpChannelId();

    boolean getJumpChannelSwitch();

    int getKeywordSearchSwitch();

    ArrayList<IGProMedalInfo> getMedalInfoList();

    int getMedalLevel();

    int getMemberCode();

    int getMyGuildGlobalAuth();

    long getMyShutUpExpireTime();

    ArrayList<IGProNavigationInfo> getNavigationInfoList();

    String getProfile();

    int getQRCodePeriod();

    int getQRCodeSwitch();

    int getResult();

    int getScheduleNotify();

    String getShowNumber();

    long getShutUpExpireTime();

    int getSignInNotifySwitch();

    fc getSpeakThreshold();

    int getSupportRecommendSwitch();

    String getTagDesc();

    long getTagId();

    boolean getTopicSquareSwitch();

    long getU64guildSeq();

    String getUIData(String str);

    long getUint32GuildRuleChangeTime();

    int getUserNum();

    int getUserType();

    int getVisitorInteractionAllSwitch();

    int getWeakNotifyDisplay();

    boolean isGroupGuild();

    boolean isInteractiveForVisitor();

    boolean isMember();

    boolean isMovePostSection();

    boolean isNeedRealNameForVisitor();

    boolean isTop();

    boolean isVisibleForVisitor();
}
