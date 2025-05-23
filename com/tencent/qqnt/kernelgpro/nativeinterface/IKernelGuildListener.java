package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGuildListener {
    void onAVChannelThemeUpdate(long j3, long j16, GProAVChannelConfig gProAVChannelConfig);

    void onAVUserInfoChangeNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onAllGuildChannelListFetchCompleted();

    void onAnchorStatusChange(long j3, long j16, int i3);

    void onAppChannelPreInfosUpdated(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2);

    void onAppInfosUpdated();

    void onBroadcastHelperDownloadComplete(GProBroadcastHelperTransNotifyInfo gProBroadcastHelperTransNotifyInfo);

    void onBroadcastHelperProgerssUpdate(GProBroadcastHelperTransNotifyInfo gProBroadcastHelperTransNotifyInfo);

    void onBroadcastRoomClose(long j3, int i3, String str);

    void onBroadcastUserCountUpdate(long j3, int i3);

    void onChangeGuildNumber(long j3, String str, int i3);

    void onChannelInfoUpdated(int i3, String str, GProChannel gProChannel);

    void onChannelListUpdated(int i3, String str, long j3, int i16, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList);

    void onChannelUserPermissionChange(long j3, ArrayList<Long> arrayList);

    void onDiscoveryStateChanged(GProDiscoveryStateChangedMsg gProDiscoveryStateChangedMsg);

    void onEditSchedule(int i3, String str, GProEditScheduleReq gProEditScheduleReq);

    void onEnterSpeakQueueNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onGetSelfTinyId(long j3);

    void onGlobalBannerRemoved(GProGlobalBanner gProGlobalBanner);

    void onGlobalBannerUpdated(GProGlobalBanner gProGlobalBanner);

    void onGuildCreatorGuideUpdated(GProCreateGuildGuideInfo gProCreateGuildGuideInfo);

    void onGuildInfoUpdated(int i3, String str, GProGuild gProGuild, boolean z16);

    void onGuildListLoaded();

    void onGuildListUpdated(int i3, String str, boolean z16, ArrayList<Long> arrayList, ArrayList<GProGuild> arrayList2, GProGuildListSortInfo gProGuildListSortInfo);

    void onGuildUserAvatarMetasUpdated(long j3, ArrayList<Long> arrayList);

    void onGuildUserAvatarPendantsUpdated(HashMap<Long, String> hashMap);

    void onGuildUserChannelCategoryAdminListUpdated(long j3, ArrayList<Long> arrayList);

    void onGuildUserClientIdentitiesUpdated(long j3, ArrayList<Long> arrayList);

    void onGuildUserLevelRolesChanged(long j3, HashMap<Long, Integer> hashMap);

    void onGuildUserMedalsUpdated(HashMap<Long, String> hashMap);

    void onGuildUserMemberNamesUpdated(long j3, HashMap<Long, String> hashMap);

    void onGuildUserNicknamesUpdated(HashMap<Long, String> hashMap);

    void onGuildUserTopRolesChanged(long j3, ArrayList<Long> arrayList);

    void onLocalMemberCountUpdate(long j3, long j16);

    void onMemberCountUpdate(GProGuildMemberCountInfo gProGuildMemberCountInfo);

    void onModifyInviteStatus(GProModifyScheduleInviteReq gProModifyScheduleInviteReq, int i3, String str);

    void onOpenTelemetryMetricCountReport(String str, HashMap<String, String> hashMap, boolean z16);

    void onOpenTelemetryMetricTimeCostReport(String str, HashMap<String, String> hashMap, long j3);

    void onOpenTelemetryTraceReport(String str, HashMap<String, String> hashMap);

    void onPollingGuildRefresh(ArrayList<Long> arrayList, boolean z16);

    void onPollingResult(ArrayList<GProPollingChannelState> arrayList);

    void onPushAVChannelAppMsg(String str);

    void onPushAVChannelConfigUpdate(long j3, long j16, GProAVChannelConfig gProAVChannelConfig);

    void onPushAVChannelPlayListChange(long j3, long j16, String str, int i3, String str2);

    void onPushAVHeartbeatRsp(int i3, String str, GProHeartbeatRsq gProHeartbeatRsq);

    void onPushAVRoomOptChange(GProAVRoomOptPushInfo gProAVRoomOptPushInfo);

    void onPushAVUserStateChange(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushAddChannelSpeakPermission(long j3, long j16);

    void onPushAdminChanged(long j3, boolean z16, long j16, long j17);

    void onPushAllowScreenShareInGuild(long j3, long j16, boolean z16, long j17);

    void onPushAudioChannelUserEnter(long j3, long j16, GProUser gProUser, long j17);

    void onPushAudioChannelUserExit(long j3, long j16, long j17, long j18);

    void onPushAudioChannelUserPlatSwitch(long j3, long j16, long j17, int i3, int i16, String str, long j18);

    void onPushBannedStatusChanged(long j3, boolean z16, boolean z17, boolean z18, long j16);

    void onPushBatchJoinChannel(long j3, ArrayList<Long> arrayList);

    void onPushBatchLeaveChannel(long j3, ArrayList<Long> arrayList);

    void onPushBussinessConfig(int i3, byte[] bArr);

    void onPushCanceledSpeak(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushChangeRoleMember(long j3, ArrayList<GProRoleMemberChangeInfo> arrayList);

    void onPushChannelAdminChange(long j3, long j16, int i3, ArrayList<Long> arrayList);

    void onPushChannelCategoryChanged(GProGuildInit gProGuildInit);

    void onPushChannelCreated(long j3, long j16, GProGuildInit gProGuildInit);

    void onPushChannelDestroy(long j3, ArrayList<Long> arrayList, long j16);

    void onPushChannelStateChange(ArrayList<GProChannelState> arrayList);

    void onPushChannelTopMsgUpdated(long j3, long j16, long j17, ArrayList<GProTopMsg> arrayList, ArrayList<GProTopMsg> arrayList2);

    void onPushChannelVisibleChanged(long j3, long j16, int i3, int i16);

    void onPushCreateGuild(long j3, GProGuild gProGuild, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList);

    void onPushCreateRole(long j3, ArrayList<GProGuildRole> arrayList);

    void onPushDeleteRole(long j3, ArrayList<GProGuildRole> arrayList);

    void onPushDestroyGuild(long j3);

    void onPushDirectMsgSwitchUpdate(int i3);

    void onPushGuildPermissionChanged(long j3, ArrayList<Integer> arrayList);

    void onPushGuildStateChange(int i3, String str, GProGuildStateRspInfo gProGuildStateRspInfo);

    void onPushInvitationRefused(long j3, long j16, long j17, String str);

    void onPushInviteMemberEvent(long j3, long j16, long j17, GProSchemeConfig gProSchemeConfig);

    void onPushInvitedToSpeak(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushJoinChannel(long j3, long j16, ArrayList<Long> arrayList);

    void onPushJoinGuild(long j3, long j16, long j17, int i3, GProGuild gProGuild, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, int i16);

    void onPushJoinGuildFail(long j3, long j16, int i3, int i16, String str);

    void onPushKickOffGuild(long j3, long j16, long j17, int i3);

    void onPushKickOutAudioChannel(long j3, long j16, long j17, long j18, int i3, String str, int i16, long j19);

    void onPushLeaveChannel(long j3, long j16, ArrayList<Long> arrayList);

    void onPushLiveChannelAnchorIdentityChange(long j3, long j16, int i3);

    void onPushLiveRoomInfoChange(long j3, long j16, String str, String str2);

    void onPushLiveRoomStatusChangeMsg(long j3, long j16, long j17, String str, long j18, int i3, int i16, GProProgramInfo gProProgramInfo, long j19, GProLiveRoomInfo gProLiveRoomInfo);

    void onPushMemberTopRoleChanged(long j3, long j16);

    void onPushModifyRole(long j3, long j16, GProGuildRole gProGuildRole);

    void onPushMsgRecvTypeChanged(long j3, long j16, long j17, int i3);

    void onPushNotifySwitchUpdate(long j3, long j16, int i3);

    void onPushPermissionInGuild(long j3, long j16, boolean z16, long j17);

    void onPushPreventAddictionInstructions(GProPreventAddictionPushInfo gProPreventAddictionPushInfo);

    void onPushQuitGuild(long j3, long j16);

    void onPushRemoveChannelSpeakPermission(long j3, long j16);

    void onPushRevokeGuild(long j3, long j16, long j17, int i3, GProGuild gProGuild, HashMap<Long, GProChannel> hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, int i16);

    void onPushSecurityResult(GProSecurityResult gProSecurityResult);

    void onPushSelfBannedSpeakChange(long j3, long j16, long j17, int i3);

    void onPushSendGiftEventNotify(GProSendGiftEventData gProSendGiftEventData);

    void onPushShutUpStateChanged(long j3, long j16);

    void onPushSortRole(long j3);

    void onPushSwitchLiveRoom(long j3, long j16, ArrayList<GProMember> arrayList, int i3);

    void onPushUserChannelStateChange(GProUserChannelState gProUserChannelState);

    void onPushUserGiftRankChangeNotify(GProUserGiftRankInfo gProUserGiftRankInfo);

    void onPushUserHandUpResult(GProAVUserStateChangeInfo gProAVUserStateChangeInfo);

    void onPushUserMuteSeatInGuild(long j3, long j16, boolean z16, long j17);

    void onPushUserScreenShare(long j3, long j16, ArrayList<GProScreenShareUser> arrayList, byte[] bArr);

    void onQQMsgListChannelDataReady();

    void onQQMsgListChannelUpdated(ArrayList<Integer> arrayList, ArrayList<GProQQMsgListChannel> arrayList2);

    void onQQMsgListGuildUpdated(ArrayList<Integer> arrayList, ArrayList<GProQQMsgListGuild> arrayList2);

    void onRecentVisitGuildListChange(int i3, long j3, int i16);

    void onRecommendGuildChannelListUpdate(GProGuildData gProGuildData);

    void onRecommendGuildInfoUpdate(GProRecommendGuildInfo gProRecommendGuildInfo);

    void onRecommendGuildPersonalSettingUpdate(GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting);

    void onRecommendGuildPollingResult(ArrayList<GProPollingData> arrayList);

    void onRecommendGuildStickyTopUpdated(ArrayList<GProStickyChannel> arrayList, ArrayList<GProStickyChannel> arrayList2, ArrayList<GProStickyChannel> arrayList3);

    void onRefreshGuildUserProfileInfo(int i3, String str, long j3, long j16, GProGuildUserProfile gProGuildUserProfile);

    void onReportSqliteError(int i3, String str);

    void onRobotStateChangeNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onSessionInitComplete(int i3, String str);

    void onSmobaGameUserChangeNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onSpeakableThresholdUpdate(ArrayList<Long> arrayList, ArrayList<GProGuildSpeakableThreshold> arrayList2);

    void onUserAVStateResetNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserEnterListNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserGuidePush(GProUserGuideMsg gProUserGuideMsg);

    void onUserHandUpRequestNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserLeaveListNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserListFetchFinish(int i3, String str, long j3);

    void onUserSpeakingNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onUserWaitingToSpeakNotifyForAll(GProChannelUserChangeInfo gProChannelUserChangeInfo);

    void onVoiceHeartbeatTimeout(long j3, long j16);

    void onVoiceSmobaGameRooManageUpdate(GProVoiceSmobaGameRoomManageSysMsg gProVoiceSmobaGameRoomManageSysMsg);

    void onVoiceSmobaGameUserActionUpdate(GProVoiceSmobaGameUserActionPush gProVoiceSmobaGameUserActionPush);
}
