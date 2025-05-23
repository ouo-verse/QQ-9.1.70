package com.tencent.mobileqq.guild.util;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQQGuildSPUtilsApi extends QRouteApi {
    void addOneRecentTalkedChannel(boolean z16, String str);

    void addShowTroopJoinGuildTipsTimes();

    void clearAllMMVK();

    void clearMMKVBool(String str, boolean z16, boolean z17);

    void clearMMKVInt(String str, boolean z16, boolean z17);

    void clearMMKVLong(String str, boolean z16, boolean z17);

    /* synthetic */ boolean containsKey(String str);

    /* synthetic */ int decodeInt(String str, int i3);

    /* synthetic */ long decodeLong(String str, long j3);

    @Nullable
    /* synthetic */ <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t16);

    /* synthetic */ void encodeInt(String str, int i3);

    /* synthetic */ void encodeLong(String str, long j3);

    /* synthetic */ void encodeParcelable(String str, Parcelable parcelable);

    List<Integer> getAioBubbleWidth();

    boolean getAioGuildTabDakaPopupShowed();

    boolean getAioGuildTabPopupShowed();

    String getAtRemainNum(String str);

    String getAtRobotRecentRecord(String str);

    String getAtRoleRecentRecord(String str);

    Integer getFeedContentWidth();

    String getGuildCoverConfigUrl();

    int getGuildCoverConfigVersion();

    String getGuildCoverInfoList();

    String getGuildOnePlayConfigJson();

    String getGuildOnePlayConfigUrl();

    int getGuildOnePlayConfigVersion();

    long getGuildSpeakManageGuideLastTime(String str);

    Long getGuildUserOnBackgroundTime();

    String getMiniAppGuildShareInfo(String str);

    boolean getRecentChannelGuildAnimationClosed();

    boolean getRecentChannelGuildAnimationShowed();

    String getRecentTalkedChannelsWithTime();

    boolean getShowTroopJoinGuildTipsHasClose();

    int getShowTroopJoinGuildTipsTimes();

    int getShowTroopJoinGuildTipsVersion();

    boolean guildMsgDebugOpen();

    boolean hasSubscribeChannelSuccessfullyEver();

    boolean isAioNewGuideHasShow();

    boolean isChannelShowedBlockAdsTip(String str);

    boolean isNewGuideHasShow();

    boolean isOpenGProDelayInitMode();

    boolean isPlusBtnRobotDotHasShow();

    boolean isRobotSlashPanelUsed();

    boolean isRobotSlashRedDotHasShow();

    void resetGuideAnimationMMKV();

    void resetShowTroopJoinGuildTipsHasClose();

    void resetShowTroopJoinGuildTipsTimes();

    void resetUINSubscribeMMKV();

    void saveAtRemainNum(String str, String str2);

    void setAioBubbleWidth(List<Integer> list);

    void setAioGuildTabDakaPopupShowed();

    void setAioGuildTabPopupShowed();

    void setAioNewGuideHasShow();

    void setAtRobotRecentRecord(String str, String str2);

    void setAtRoleRecentRecord(String str, String str2);

    void setChannelShowedBlockAdsTip(String str);

    void setFeedContentWidth(Integer num);

    void setGuildCoverConfigUrl(String str);

    void setGuildCoverConfigVersion(int i3);

    void setGuildCoverInfoList(String str);

    void setGuildOnePlayConfigJson(String str);

    void setGuildOnePlayConfigUrl(String str);

    void setGuildOnePlayConfigVersion(int i3);

    void setGuildSpeakManageGuideLastTime(String str, long j3);

    void setNewGuideHasShow();

    void setNewVersionGuideHasShow();

    void setOpenGProDelayInitMode(boolean z16);

    void setPlusBtnRobotDotHasShow();

    void setRecentChannelGuildAnimationClosed();

    void setRecentChannelGuildAnimationShowed();

    void setRecentTalkedChannelsWithTime(String str);

    void setRobotSlashPanelUsed();

    void setRobotSlashRedDotHasShow();

    void setShowTroopJoinGuildTipsHasClose();

    void setShowTroopJoinGuildTipsVersion(int i3);

    void setSubscribeChannelSuccessfully();

    void suppressRecommendedChannelGuide();

    /* synthetic */ String uinKeyOf(String str);
}
