package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.api.impl.QQGuildUtilApiImpl;
import com.tencent.mobileqq.qqguildsdk.data.GGProAVRoomOptPushInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProDiscoveryStateChangedMsg;
import com.tencent.mobileqq.qqguildsdk.data.GGProGuildData;
import com.tencent.mobileqq.qqguildsdk.data.GGProGuildMainFrameHeaderInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProHeartbeatRsq;
import com.tencent.mobileqq.qqguildsdk.data.GGProPollingData;
import com.tencent.mobileqq.qqguildsdk.data.GGProQueryRecommendGuildInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.GGProRecommendGuildPersonalSetting;
import com.tencent.mobileqq.qqguildsdk.data.GGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.GGProStickyChannel;
import com.tencent.mobileqq.qqguildsdk.data.GGProUserGiftRankInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProUserGuideMsg;
import com.tencent.mobileqq.qqguildsdk.data.GGProVoiceSmobaGameRoomManageSysMsg;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildSearchDataInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildSpeakRuleData;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProOnlineMember;
import com.tencent.mobileqq.qqguildsdk.data.GProRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProTopMsgInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeDealResult;
import com.tencent.mobileqq.qqguildsdk.data.GuildSchemaConfig;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.LiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.LiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVMemberGroupListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGetContentRecommendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProTaskInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl;
import com.tencent.mobileqq.qqguildsdk.state.ChannelStateUtil;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildNTConstants;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVChannelConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVMemberGroupListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVRoomOptPushInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVUserStateChangeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAppChnnPreInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProArchiveArkData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAreaLevel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAreaList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAssocCreateCategoryReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAssociativeWords;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtSetInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBroadcastHelperTransNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryAdminInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelIdList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryChannelInfoList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelUserChangeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientAccount;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x10b4RspExtendData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateGuildGuideInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgSession;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDiscoveryStateChangedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEditScheduleReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnterAudioLiveChannelRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFaceAuthInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchRecommendChannelRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGameModesResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetActiveLiveAudioChannelNumRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetChannelIdsWithGuildIdsFromCacheReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetContentRecommendReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetContentRecommendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetLiveAudioPollingCtxRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetLiveAudioPollingInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetUnbindClientReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetUnbindClientRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGlobalBanner;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInit;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildJoin;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildListSortInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMainFrameHeaderInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberCountInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSpeakableThreshold;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildStateReqInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildStateRspInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildUserProfile;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProHeartbeatReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProHeartbeatRsq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInviteInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLinkDetailInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveRoomInfoReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLocation;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMember;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProModifyScheduleInviteReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSearchRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProOnlineMemberInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPollingChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPollingData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPollingInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPopupConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreventAddictionPushInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProProgramInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgListChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgListGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQueryRecommendGuildInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannels;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendGuildPersonalSetting;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRemoveChannelReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRole;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleCreateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberChangeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoleMemberList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermission;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleDate;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleDayItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleGuildSurface;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSchedulePollingInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleSendArkGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSchemeConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScreenShareUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSecurityResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSendGiftEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSpeakPermissionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStickyChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTaskInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnionSearchResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserGiftRankInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserGuideMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserLiveRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameRoomManageSysMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameUserActionPush;
import com.tencent.qqnt.kernelgpro.nativeinterface.GproGuildSpeakableRule;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAppAuthorizationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAssociativeWordsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBindAppRoleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProChannelAdminInfoListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProChannelUserPermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckUserBannedSpeakInChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateDirectMsgSessionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateRoleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleLimitQueryCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDealNoticeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProEditScheduleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProEnterAudioLiveChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchArchiveArkDataCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAtSetInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAudioLiveGroupListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchBannedUserListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelInvisibleMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelInvisibleRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListCategoryCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListForJumpCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListStateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelLiveableMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelLiveableRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelSpeakableMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelSpeakableRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnlivableMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnlivableRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnspeakableMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnspeakableRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchCommentsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchDirectMsgBlackCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchDirectMsgStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildInfoByAppIdentityCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSearchSwitchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableRuleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableThresholdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchInviteInfo0x10b4Callback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchInviteInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchIsLiveChannelOpenCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchIsVoiceChannelOpenCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLiveChannelAnchorListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLiveChannelInfoListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLiveSecurityTipsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMVPFeedsDataCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMemberListWithRoleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMemberRolesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchNewestNoticeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchNonRoleMembersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRecommendChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListPermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleMembersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRolePermissionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchVisibleMemberListByTinyIdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetActiveLiveAudioChannelNumV2Callback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAppAuthorizationInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAppRoleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelHeartbeatCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTopMsgStateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetClientAccountCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetClientInfoListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsNotifySwitchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildMainFrameHeaderCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetLiveAudioPollingCtxCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetLiveAudioPollingCtxV2Callback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetMemberInfoByOpenIdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetMoreNoticeListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendGuildInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListNewCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleUsersCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSchedulesStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUnbindClientCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserLiveInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProInitGetNoticeListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProKickChannelMemberCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadGuildAndChannelsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadGuildUserProfileCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadMemberRolesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProModifyScheduleInviteStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProQueryTinyIdByLiveUIDCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProRemoveBanBeforeBroadcastCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProScreenShareCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchMsgSeqsFromServerCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchUnionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendScheduleArkMessageCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelTopMsgCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetClientShowConfigCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetFeedCommentsNotifySwitchCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildClientIdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildCoverFontColorIdCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildListSortCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildWeakNotifyDisplayCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetQQMsgListChannelCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetRoleChannelsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetUserLiveInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSwitchPresenceArchiveCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTerminateLiveStreamCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateArchiveShowSeqCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserTypeSetCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceChannelAuthCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes17.dex */
public abstract class GProSdkWrapperImpl extends GProSdkGenWrapperImpl implements hn {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final com.tencent.mobileqq.qqguildsdk.wrapper.a f268557d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<AppRuntime> f268558e;

    /* renamed from: i, reason: collision with root package name */
    private IKernelGuildListener f268562i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f268563j;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f268560g = false;

    /* renamed from: h, reason: collision with root package name */
    private String f268561h = "0";

    /* renamed from: k, reason: collision with root package name */
    private boolean f268564k = false;

    /* renamed from: f, reason: collision with root package name */
    private final long f268559f = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements com.tencent.mobileqq.qqguildsdk.data.ep {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GproGuildSpeakableRule f269543a;

        a(GproGuildSpeakableRule gproGuildSpeakableRule) {
            this.f269543a = gproGuildSpeakableRule;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public Boolean a() {
            return this.f269543a.getIsProhibiteQrCodePicture();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public Boolean b() {
            return this.f269543a.getIsProhibitDatingFeed();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public Boolean c() {
            return this.f269543a.getIsProhibitSuspectedRiskFeed();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public Boolean d() {
            return this.f269543a.getIsProhibiteAdvertise();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public ArrayList<String> e() {
            GproGuildSpeakableRule gproGuildSpeakableRule = this.f269543a;
            if (gproGuildSpeakableRule != null && gproGuildSpeakableRule.getProhibiteWords() != null) {
                return this.f269543a.getProhibiteWords();
            }
            return new ArrayList<>();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public Boolean f() {
            return this.f269543a.getIsProhibiteRedEnvelope();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.ep
        public Boolean g() {
            return this.f269543a.getIsProhibiteLink();
        }
    }

    /* loaded from: classes17.dex */
    class b implements com.tencent.mobileqq.qqguildsdk.data.eo {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProSpeakPermissionInfo f269545a;

        b(GProSpeakPermissionInfo gProSpeakPermissionInfo) {
            this.f269545a = gProSpeakPermissionInfo;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean a() {
            GProSpeakPermissionInfo gProSpeakPermissionInfo = this.f269545a;
            if (gProSpeakPermissionInfo != null && gProSpeakPermissionInfo.getSendRedPacket() != null && !this.f269545a.getSendRedPacket().booleanValue()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public ArrayList<String> b() {
            GProSpeakPermissionInfo gProSpeakPermissionInfo = this.f269545a;
            if (gProSpeakPermissionInfo != null && gProSpeakPermissionInfo.getSendProhibiteWords() != null) {
                return this.f269545a.getSendProhibiteWords();
            }
            return new ArrayList<>();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean c() {
            GProSpeakPermissionInfo gProSpeakPermissionInfo = this.f269545a;
            if (gProSpeakPermissionInfo != null && gProSpeakPermissionInfo.getSendAdvertise() != null && !this.f269545a.getSendAdvertise().booleanValue()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean d() {
            GProSpeakPermissionInfo gProSpeakPermissionInfo = this.f269545a;
            if (gProSpeakPermissionInfo != null && gProSpeakPermissionInfo.getSendLink() != null && !this.f269545a.getSendLink().booleanValue()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.eo
        public boolean e() {
            GProSpeakPermissionInfo gProSpeakPermissionInfo = this.f269545a;
            if (gProSpeakPermissionInfo != null && gProSpeakPermissionInfo.getSendQrCode() != null && !this.f269545a.getSendQrCode().booleanValue()) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes17.dex */
    class c implements IGProGetChannelHeartbeatCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ vh2.aw f269547a;

        c(vh2.aw awVar) {
            this.f269547a = awVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelHeartbeatCallback
        public void onGetChannelHeartbeat(int i3, GProHeartbeatReq gProHeartbeatReq) {
            this.f269547a.a(i3, com.tencent.mobileqq.qqguildsdk.util.g.Y(gProHeartbeatReq));
        }
    }

    /* loaded from: classes17.dex */
    class d implements wh2.dm {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ wh2.dm f269549a;

        d(wh2.dm dmVar) {
            this.f269549a = dmVar;
        }

        @Override // wh2.dm
        public void onJoinGuilds(int i3, String str, ArrayList<IGProJoinGuildResult> arrayList) {
            Iterator<IGProJoinGuildResult> it = arrayList.iterator();
            while (it.hasNext()) {
                IGProJoinGuildResult next = it.next();
                if (next instanceof GGProJoinGuildResult) {
                    GGProJoinGuildResult gGProJoinGuildResult = (GGProJoinGuildResult) next;
                    if (gGProJoinGuildResult.mInfo != null) {
                        GProSdkWrapperImpl.this.Xf(next.getRetCode(), com.tencent.mobileqq.qqguildsdk.util.g.X0(next.getGuildId()), gGProJoinGuildResult.mInfo.getGuildInfo());
                    }
                }
            }
            this.f269549a.onJoinGuilds(i3, str, arrayList);
        }
    }

    /* loaded from: classes17.dex */
    class e implements wh2.dm {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ wh2.dm f269551a;

        e(wh2.dm dmVar) {
            this.f269551a = dmVar;
        }

        @Override // wh2.dm
        public void onJoinGuilds(int i3, String str, ArrayList<IGProJoinGuildResult> arrayList) {
            Iterator<IGProJoinGuildResult> it = arrayList.iterator();
            while (it.hasNext()) {
                IGProJoinGuildResult next = it.next();
                if (next instanceof GGProJoinGuildResult) {
                    GGProJoinGuildResult gGProJoinGuildResult = (GGProJoinGuildResult) next;
                    if (gGProJoinGuildResult.mInfo != null) {
                        GProSdkWrapperImpl.this.Xf(next.getRetCode(), com.tencent.mobileqq.qqguildsdk.util.g.X0(next.getGuildId()), gGProJoinGuildResult.mInfo.getGuildInfo());
                    }
                }
            }
            this.f269551a.onJoinGuilds(i3, str, arrayList);
        }
    }

    /* loaded from: classes17.dex */
    class f implements IGProGetUserListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f269553a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f269554b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class g implements com.tencent.mobileqq.qqguildsdk.data.ei {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProResult f269555a;

        g(GProResult gProResult) {
            this.f269555a = gProResult;
        }
    }

    public GProSdkWrapperImpl(@NonNull AppRuntime appRuntime, @NonNull com.tencent.mobileqq.qqguildsdk.wrapper.a aVar) {
        this.f268557d = aVar;
        this.f268558e = new WeakReference<>(appRuntime);
        if (appRuntime != null) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("GProSdkWrapperImpl", true, "sdk service init", "GProSdkWrapperImpl new Handler");
            this.f266769b = new Handler(Looper.getMainLooper());
            this.f268562i = new GProSdkListenerImpl(appRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ag(int i3, String str, int i16, ArrayList arrayList, xh2.g gVar, int i17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelLiveableRoleList", "callback", i3, str, null, i16);
        gVar.a(i3, str, i17, com.tencent.mobileqq.qqguildsdk.util.g.C0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(final int i3, final IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback, final int i16, final String str, final GProGuildRole gProGuildRole, final GProRolePermission gProRolePermission, final ArrayList arrayList, final ArrayList arrayList2) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ab
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.zh(i16, str, gProGuildRole, gProRolePermission, arrayList2, i3, iGProFetchRolePermissionCallback, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ai(final int i3, final vh2.k kVar, final int i16, final int i17, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.af
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.zi(i17, str, i3, kVar, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bg(final int i3, final xh2.g gVar, final int i16, final String str, final int i17, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ds
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Ag(i16, str, i3, arrayList, gVar, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildShutUp", "", i3, str, "security=" + Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Cg(int i3, String str, int i16, ArrayList arrayList, xh2.h hVar, int i17, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelSpeakableMemberList", "callback", i3, str, null, i16);
        hVar.a(i3, str, i17, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(final vh2.ba baVar, final GProGetActiveLiveAudioChannelNumRsp gProGetActiveLiveAudioChannelNumRsp) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ct
            @Override // java.lang.Runnable
            public final void run() {
                vh2.ba.this.onResult(gProGetActiveLiveAudioChannelNumRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ci(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.al
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Bi(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dg(final int i3, final xh2.h hVar, final int i16, final String str, final int i17, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cu
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Cg(i16, str, i3, arrayList, hVar, i17, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Dh(int i3, String str, int i16, IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback, boolean z16, long j3) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getChannelTopMsgState", "", i3, str, "", i16);
        iGProGetChannelTopMsgStateCallback.onGetChannelTopMsgState(i3, str, z16, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Di(int i3, String str, GProSecurityResult gProSecurityResult, wh2.dv dvVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.t("GProSdkWrapperImpl", false, "result=" + i3 + ", errMsg=" + str);
        dvVar.a(i3, str, new GProSecurityInfo(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Eg(int i3, String str, int i16, ArrayList arrayList, xh2.i iVar, int i17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelSpeakableRoleList", "callback", i3, str, null, i16);
        iVar.a(i3, str, i17, com.tencent.mobileqq.qqguildsdk.util.g.C0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(final int i3, final IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback, final int i16, final String str, final boolean z16, final long j3) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ax
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Dh(i16, str, i3, iGProGetChannelTopMsgStateCallback, z16, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ei(final wh2.dv dvVar, final int i3, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.p
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Di(i3, str, gProSecurityResult, dvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fg(final int i3, final xh2.i iVar, final int i16, final String str, final int i17, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cx
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Eg(i16, str, i3, arrayList, iVar, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Fi(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildVisibilityForVisitor", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Gg(int i3, String str, int i16, ArrayList arrayList, xh2.j jVar, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelUnlivableMemberList", "callback", i3, str, null, i16);
        jVar.a(i3, str, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(final vh2.bb bbVar, final GProRealTimeChannels gProRealTimeChannels) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ec
            @Override // java.lang.Runnable
            public final void run() {
                vh2.bb.this.onResult(gProRealTimeChannels);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gi(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ad
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Fi(i16, str, i3, ccVar);
            }
        });
    }

    private boolean He(int i3, int i16) {
        if (i3 != 3841) {
            return false;
        }
        if (i16 != 1 && i16 != 2 && i16 != 14 && i16 != 15 && i16 != 16 && i16 != 39) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hg(final int i3, final xh2.j jVar, final int i16, final String str, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cw
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Gg(i16, str, i3, arrayList, jVar, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hi(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setMemberShutUp", "", i3, str, "security=" + Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ig(int i3, String str, int i16, ArrayList arrayList, xh2.k kVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelUnlivableRoleList", "callback", i3, str, null, i16);
        kVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.C0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(final vh2.bc bcVar, final GProGetLiveAudioPollingCtxRsp gProGetLiveAudioPollingCtxRsp) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cs
            @Override // java.lang.Runnable
            public final void run() {
                vh2.bc.this.onResult(gProGetLiveAudioPollingCtxRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ii(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cz
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Hi(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jg(final int i3, final xh2.k kVar, final int i16, final String str, final ArrayList arrayList) {
        this.f266769b.post(new Runnable(i16, str, i3, arrayList, kVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dl

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f269897d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f269898e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f269899f;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ ArrayList f269900h;

            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Ig(this.f269897d, this.f269898e, this.f269899f, this.f269900h, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(ArrayList arrayList) {
        if (this.f266768a == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[gpro_sdk] onLoadGuildAndChannelList.mHandler", new NullPointerException("kernelGuildService == null"));
            return;
        }
        QLog.i("GProSdkWrapperImpl", 1, "[gpro_sdk] onLoadGuildAndChannelList.mHandler notify UI start!");
        ej(50, "ILoadGuildAndChnListCallback", 0, "");
        ej(81, "ILoadGuildAndChnListCallback", new Object[0]);
        ej(1, "ILoadGuildAndChnListCallback", new Object[0]);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ej(2, "ILoadGuildAndChnListCallback", String.valueOf((Long) it.next()));
            }
        }
        QLog.i("GProSdkWrapperImpl", 1, "[gpro_sdk] onLoadGuildAndChannelList.mHandler notify UI completed!");
        this.f268560g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ji(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setQQMsgListChannel", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Kg(int i3, String str, int i16, ArrayList arrayList, xh2.l lVar, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelUnspeakableMemberList", "callback", i3, str, null, i16);
        lVar.a(i3, str, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(final ArrayList arrayList) {
        if (this.f266768a == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[gpro_sdk] onLoadGuildAndChannelList", new NullPointerException("kernelGuildService == null"));
            return;
        }
        bi2.a.d("load_guild_list_task", "sdk_init_guild_list_end_event");
        this.f268560g = true;
        TraceUtils.h("Guild.Async.GuildListUpdated.");
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.aq
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Jh(arrayList);
            }
        });
        TraceUtils.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ki(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dx
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Ji(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lg(final int i3, final xh2.l lVar, final int i16, final String str, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.en
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Kg(i16, str, i3, arrayList, lVar, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "kickGuildUsers", "callback", i3, str, Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Li(int i3, String str, ArrayList arrayList, ArrayList arrayList2, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setRoleChannels", "callback", i3, str, "success=" + arrayList + " fail=" + arrayList2, i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mg(int i3, String str, int i16, ArrayList arrayList, xh2.m mVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelUnspeakableRoleList", "callback", i3, str, null, i16);
        mVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.C0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.em
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Lh(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mi(final int i3, final vh2.cc ccVar, final int i16, final String str, final ArrayList arrayList, final ArrayList arrayList2) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dt
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Li(i16, str, arrayList, arrayList2, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ng(final int i3, final xh2.m mVar, final int i16, final String str, final ArrayList arrayList) {
        this.f266769b.post(new Runnable(i16, str, i3, arrayList, mVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dq

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f269920d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f269921e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f269922f;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ ArrayList f269923h;

            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Mg(this.f269920d, this.f269921e, this.f269922f, this.f269923h, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Nh(int i3, String str, GProSecurityResult gProSecurityResult, wh2.dv dvVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "sdkWrapper callback", "modifyGuildSpeakableMemberList", "", i3, str, "secResult:" + gProSecurityResult);
        dvVar.a(i3, str, new GProSecurityInfo(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ni(int i3, String str, boolean z16, int i16, vh2.dg dgVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setUserType", "", i3, str, "isGuildNewUser:" + z16, i16);
        dgVar.onResult(i3, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Og(int i3, String str, int i16, xh2.n nVar, int i17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelUserPermission", "callback", i3, str, null, i16);
        nVar.onResult(i3, str, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(final wh2.dv dvVar, final int i3, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ei
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Nh(i3, str, gProSecurityResult, dvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oi(final int i3, final vh2.dg dgVar, final int i16, final String str, final boolean z16) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dv
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Ni(i16, str, z16, i3, dgVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pg(final int i3, final xh2.n nVar, final int i16, final String str, final int i17) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.v
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Og(i16, str, i3, nVar, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ph(int i3, String str, GProSecurityResult gProSecurityResult, wh2.dv dvVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "sdkWrapper callback", "modifyGuildSpeakableRoleList", "", i3, str, "secResult:" + gProSecurityResult);
        dvVar.a(i3, str, new GProSecurityInfo(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Pi(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "tryUnmuteMicrophone", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    private String Qe(@NonNull GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull ArrayList<GProCategoryChannelIdList> arrayList) {
        if (gProCategoryChannelIdList.getChannelList() == null) {
            return "";
        }
        String str = "uncategorizedChannels size:" + gProCategoryChannelIdList.getChannelList().size() + MsgSummary.STR_COLON + gProCategoryChannelIdList + "\n  categoryList size: " + arrayList.size();
        if (!arrayList.isEmpty()) {
            Iterator<GProCategoryChannelIdList> it = arrayList.iterator();
            while (it.hasNext()) {
                GProCategoryChannelIdList next = it.next();
                str = str + "\n " + next.getName() + "(" + next.getCategoryId() + "): " + next.getChannelList();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Qf(GProSecurityResult gProSecurityResult) {
        if (gProSecurityResult == null) {
            return "";
        }
        return ", secResult :  actionCode" + gProSecurityResult.getAction() + ", strPrompt : " + com.tencent.mobileqq.qqguildsdk.util.j.a(gProSecurityResult.getStrPrompt()) + ", strPrompt : " + com.tencent.mobileqq.qqguildsdk.util.j.a(gProSecurityResult.getStrDetail());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Qg(int i3, String str, int i16, ArrayList arrayList, xh2.o oVar, int i17, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelVisibleAllMemberList", "callback", i3, str, null, i16);
        oVar.a(i3, str, i17, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(final wh2.dv dvVar, final int i3, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dp
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Ph(i3, str, gProSecurityResult, dvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qi(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.n
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Pi(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public String Re(GProSecurityResult gProSecurityResult, @NonNull GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull ArrayList<GProCategoryChannelIdList> arrayList) {
        return Qf(gProSecurityResult) + "\n" + Qe(gProCategoryChannelIdList, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rg(final int i3, final xh2.o oVar, final int i16, final String str, final int i17, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ek
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Qg(i16, str, i3, arrayList, oVar, i17, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Rh(int i3, String str, GProSecurityResult gProSecurityResult, wh2.dv dvVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "sdkWrapper callback", "modifyGuildSpeakableRule", "", i3, str, "secResult:" + gProSecurityResult);
        dvVar.a(i3, str, new GProSecurityInfo(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ri(GProSecurityResult gProSecurityResult, int i3, String str, int i16, vh2.cd cdVar) {
        IGProSecurityResult tf5 = tf(gProSecurityResult);
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "updateForumChannelSortMode", "", i3, str, "security=" + gProSecurityResult, i16);
        cdVar.a(i3, str, tf5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sg(final int i3, final xh2.o oVar, final int i16, final String str, final int i17, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.l
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Tg(i16, str, i3, arrayList, oVar, i17, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sh(final wh2.dv dvVar, final int i3, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.di
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Rh(i3, str, gProSecurityResult, dvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Si(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.z
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Ri(gProSecurityResult, i16, str, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Tg(int i3, String str, int i16, ArrayList arrayList, xh2.o oVar, int i17, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelVisibleMemberList", "callback", i3, str, null, i16);
        oVar.a(i3, str, i17, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Th() {
        QLog.i("GProSdkWrapperImpl", 1, "preload start");
        com.tencent.qqnt.kernelgpro.nativeinterface.k.ba();
        QLog.i("GProSdkWrapperImpl", 1, "preload finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ti(int i3, String str, int i16, ArrayList arrayList, vh2.dh dhVar, int i17, GProSecurityResult gProSecurityResult, String str2) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "voiceChannelAuth0x10b6", "", i3, str, "", i16);
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.dq> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.ah((GProGameModesResult) it.next()));
        }
        dhVar.a(i3, str, i17, tf(gProSecurityResult), str2, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ug(int i3, String str, int i16, ArrayList arrayList, wh2.aj ajVar, int i17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelVisibleRoleList", "callback", i3, str, null, i16);
        ajVar.onFetchChannelVisibleRoleList(i3, str, i17, (ArrayList) com.tencent.mobileqq.qqguildsdk.util.g.C0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Uh(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeMemberFromGuildBlackList", "callback", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ui(final int i3, final vh2.dh dhVar, final int i16, final String str, final int i17, final GProSecurityResult gProSecurityResult, final String str2, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.k
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Ti(i16, str, i3, arrayList, dhVar, i17, gProSecurityResult, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vg(final int i3, final wh2.aj ajVar, final int i16, final String str, final int i17, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.eb
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Ug(i16, str, i3, arrayList, ajVar, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vh(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.eg
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Uh(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Wg(int i3, String str, int i16, ArrayList arrayList, vh2.p pVar, long j3, long j16, boolean z16, boolean z17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchComments", "", i3, str, "", i16);
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.dm> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.ab((GProComment) it.next()));
        }
        pVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), arrayList2, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Wh(int i3, vh2.cp cpVar, int i16, String str, GProMsgSearchRsp gProMsgSearchRsp) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchMsgSeqsFromServer", "", i16, str, gProMsgSearchRsp.toString(), i3);
        cpVar.a(i16, str, new com.tencent.mobileqq.qqguildsdk.data.be(gProMsgSearchRsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xf(int i3, String str, GProGuild gProGuild) {
        GProGuildInfo gProGuildInfo;
        if (i3 != 0) {
            return;
        }
        if (gProGuild != null) {
            gProGuildInfo = new GProGuildInfo(gProGuild);
        } else {
            gProGuildInfo = null;
        }
        D(str, gProGuildInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xg(final int i3, final vh2.p pVar, final int i16, final String str, final long j3, final long j16, final ArrayList arrayList, final boolean z16, final boolean z17) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.db
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Wg(i16, str, i3, arrayList, pVar, j3, j16, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xh(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelLiveable", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yf(int i3, String str, GProJoinGuildResult gProJoinGuildResult) {
        if (gProJoinGuildResult == null) {
            return;
        }
        Xf(i3, str, gProJoinGuildResult.getGuildInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Yg(int i3, String str, boolean z16, int i16, vh2.q qVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchDirectMsgBlack", "", i3, str, "isBlack=" + z16, i16);
        qVar.onResult(i3, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yh(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dw
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Xh(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zg(final int i3, final vh2.q qVar, final int i16, final String str, final boolean z16) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dz
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Yg(i16, str, z16, i3, qVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelSpeakableMemberList", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    public static byte[] Zi(byte[] bArr) {
        return IKernelGuildService.CppProxy.lz4DecompressBuf(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ah(int i3, String str, int i16, int i17, int i18, vh2.r rVar, int i19) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchDirectMsgStatus", "", i3, str, "switchStatus=" + i16 + ", notifyStatus=" + i17, i18);
        rVar.a(i3, str, i16, i17, i19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.d
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.Zh(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bh(final int i3, final vh2.r rVar, final int i16, final String str, final int i17, final int i18, final int i19) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.c
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.ah(i16, str, i17, i18, i3, rVar, i19);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelSpeakableRoleList", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ch(final int i3, final vh2.k kVar, final int i16, final String str, final int i17) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ak
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.dh(i16, str, i17, i3, kVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dr
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.bi(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    public static String df(String str) {
        return IKernelGuildService.CppProxy.getFullAvatarPendantUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void dh(int i3, String str, int i16, int i17, vh2.k kVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchFeedsNotifySwitch", "", i3, str, "switchType=" + i16, i17);
        kVar.onResult(i3, str, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void di(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelSpeakable", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    public static String ef(String str, int i3) {
        return IKernelGuildService.CppProxy.getFullAvatarUrl(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void eh(int i3, String str, int i16, int i17, vh2.w wVar, String str2) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildSearchSwitch", "", i3, str, "switch:" + i16, i17);
        wVar.onFetchGuildSearchSwitch(i3, str, i16, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dm
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.di(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    private com.tencent.mobileqq.qqguildsdk.data.ei ff(GProResult gProResult) {
        return new g(gProResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fh(final int i3, final vh2.w wVar, final int i16, final String str, final int i17, final String str2) {
        this.f266769b.post(new Runnable(i16, str, i17, i3, wVar, str2) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dy

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f269959d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f269960e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f269961f;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f269962h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ String f269963i;

            {
                this.f269963i = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.eh(this.f269959d, this.f269960e, this.f269961f, this.f269962h, null, this.f269963i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fi(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelSpeakableMemberList", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.qqguildsdk.data.ei> gf(List<GProResult> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GProResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ff(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void gg(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "batchSetBoolField", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IGProUserInfo gh(GProUser gProUser) {
        return new GProUserInfo(gProUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gi(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.df
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.fi(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    private void gj() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.an
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.Th();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hg(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ar
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.gg(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hh(xh2.p pVar, int i3, String str, int i16, boolean z16, byte[] bArr, ArrayList arrayList) {
        List<IGProUserInfo> map;
        map = CollectionsKt___CollectionsKt.map(arrayList, new Function1() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ao
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                IGProUserInfo gh5;
                gh5 = GProSdkWrapperImpl.gh((GProUser) obj);
                return gh5;
            }
        });
        pVar.a(i3, str, i16, z16, bArr, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hi(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelSpeakableRoleList", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ig(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "batchSetIntField", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ih(final xh2.p pVar, final int i3, final String str, final int i16, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ed
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.hh(xh2.p.this, i3, str, i16, z16, bArr, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ii(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dg
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.hi(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jg(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.da
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.ig(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IGProGuildRoleInfo jh(GProGuildRole gProGuildRole) {
        return new GProGuildRoleInfo(gProGuildRole);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ji(int i3, String str, long j3, long j16, int i16, IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelTopMsg", "", i3, str, "msgSeq:" + j3 + " msgTime=" + j16, i16);
        iGProSetChannelTopMsgCallback.onSetChannelTopMsg(i3, str, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void kg(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "cancelChannelTopMsg", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void kh(xh2.q qVar, int i3, String str, int i16, ArrayList arrayList) {
        List<IGProGuildRoleInfo> map;
        map = CollectionsKt___CollectionsKt.map(arrayList, new Function1() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.as
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                IGProGuildRoleInfo jh5;
                jh5 = GProSdkWrapperImpl.jh((GProGuildRole) obj);
                return jh5;
            }
        });
        qVar.a(i3, str, i16, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ki(final int i3, final IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback, final int i16, final String str, final long j3, final long j16) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.av
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.ji(i16, str, j3, j16, i3, iGProSetChannelTopMsgCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lg(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ay
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.kg(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lh(final xh2.q qVar, final int i3, final String str, final int i16, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.eo
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.kh(xh2.q.this, i3, str, i16, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void li(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelVisible", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<com.tencent.mobileqq.qqguildsdk.data.co> mf(ArrayList<GProNotice> arrayList) {
        return com.tencent.mobileqq.qqguildsdk.util.g.g0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void mg(int i3, String str, int i16, vh2.cc ccVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "closeChannelTopMsg", "", i3, str, "", i16);
        ccVar.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mh(int i3, String str, GproGuildSpeakableRule gproGuildSpeakableRule, vh2.au auVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildSpeakableRule", "", i3, str, "rule:" + gproGuildSpeakableRule);
        auVar.a(i3, str, new a(gproGuildSpeakableRule));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mi(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.o
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.li(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ng(final int i3, final vh2.cc ccVar, final int i16, final String str) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.aw
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.mg(i16, str, i3, ccVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void nh(final vh2.au auVar, final int i3, final String str, final GproGuildSpeakableRule gproGuildSpeakableRule) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.s
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.mh(i3, str, gproGuildSpeakableRule, auVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ni(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelVisibleMemberList", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void og(int i3, String str, GProDirectMsgSession gProDirectMsgSession, int i16, int i17, GProSecurityResult gProSecurityResult, vh2.h hVar) {
        boolean z16;
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createDirectMsgSession", "", i3, str, "guildId=" + gProDirectMsgSession.getGuildId() + " channelId=" + gProDirectMsgSession.getChannelId() + " isInMyBlack=" + i16, i17);
        IGProSecurityResult tf5 = tf(gProSecurityResult);
        com.tencent.mobileqq.qqguildsdk.data.k k3 = com.tencent.mobileqq.qqguildsdk.util.g.k(gProDirectMsgSession);
        if (i16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        hVar.a(i3, str, tf5, z16, k3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void oh(int i3, String str, GProGuildSpeakableThreshold gProGuildSpeakableThreshold, vh2.x xVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.t("GProSdkWrapperImpl", false, "result=" + i3 + ", errMsg=" + str + ", threshold=" + gProGuildSpeakableThreshold.toString());
        xVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.t0(gProGuildSpeakableThreshold));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oi(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dh
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.ni(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pg(final int i3, final vh2.h hVar, final int i16, final String str, final GProSecurityResult gProSecurityResult, final int i17, final GProDirectMsgSession gProDirectMsgSession) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.aa
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.og(i16, str, gProDirectMsgSession, i17, i3, gProSecurityResult, hVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ph(final vh2.x xVar, final int i3, final String str, final GProGuildSpeakableThreshold gProGuildSpeakableThreshold) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.r
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.oh(i3, str, gProGuildSpeakableThreshold, xVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pi(int i3, String str, int i16, vh2.cd cdVar, GProSecurityResult gProSecurityResult) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelVisibleRoleList", "callback", i3, str, null, i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void qg(int i3, wh2.x xVar, int i16, String str, GProSecurityResult gProSecurityResult, GProEnterAudioLiveChannelRsp gProEnterAudioLiveChannelRsp) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "enterAudioLiveChannelAndCallbackDirect", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", i3);
        xVar.a(i16, str, new GProSecurityInfo(gProSecurityResult), new GGProEnterAudioLiveChannelRsp(gProEnterAudioLiveChannelRsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void qh(int i3, String str, int i16, ArrayList arrayList, vh2.p pVar, long j3, long j16, boolean z16, boolean z17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLatestComments", "", i3, str, "", i16);
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.dm> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.ab((GProComment) it.next()));
        }
        pVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), arrayList2, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qi(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.j
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.pi(i16, str, i3, cdVar, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void rg(int i3, wh2.ac acVar, int i16, String str, GProAVMemberGroupListRsp gProAVMemberGroupListRsp) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAudioLiveChannelGroupListAndCallbackDirect", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", i3);
        acVar.a(i16, str, new GGProAVMemberGroupListRsp(gProAVMemberGroupListRsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rh(final int i3, final vh2.p pVar, final int i16, final String str, final long j3, final long j16, final ArrayList arrayList, final boolean z16, final boolean z17) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.q
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.qh(i16, str, i3, arrayList, pVar, j3, j16, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ri(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setDirectMsgBlack", "", i3, str, "security=" + Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void sg(int i3, String str, boolean z16, int i16, ArrayList arrayList, vh2.e eVar, int i17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelAdminInfoList", "", i3, str, "allowModify=" + z16, i16);
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.dg> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.ar((GProCategoryAdminInfo) it.next()));
        }
        eVar.onResult(i3, str, arrayList2, i17, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void sh(int i3, wh2.au auVar, int i16, String str, GProGetContentRecommendRsp gProGetContentRecommendRsp, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchMVPFeedsFromServer", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", i3);
        auVar.a(i16, str, new GGProGetContentRecommendRsp(gProGetContentRecommendRsp), bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void si(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.au
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.ri(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IGProSecurityResult tf(GProSecurityResult gProSecurityResult) {
        if (gProSecurityResult == null) {
            return null;
        }
        return com.tencent.mobileqq.qqguildsdk.util.g.U(gProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tg(final int i3, final vh2.e eVar, final int i16, final String str, final ArrayList arrayList, final int i17, final boolean z16) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dd
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.sg(i16, str, z16, i3, arrayList, eVar, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void th(int i3, String str, int i16, GProNotice gProNotice, vh2.al alVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchNewestNotice", "", i3, str, "", i16);
        com.tencent.mobileqq.qqguildsdk.data.co f06 = com.tencent.mobileqq.qqguildsdk.util.g.f0(gProNotice);
        if (TextUtils.isEmpty(f06.f265885a)) {
            alVar.a(i3, str, null);
        } else {
            alVar.a(i3, str, f06);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ti(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setDirectMsgNotifyForGuild", "", i3, str, "security=" + Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ug(int i3, String str, int i16, ArrayList arrayList, xh2.d dVar, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelInvisibleMemberList", "callback", i3, str, null, i16);
        dVar.a(i3, str, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(final int i3, final vh2.al alVar, final int i16, final String str, final GProNotice gProNotice) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cr
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.th(i16, str, i3, gProNotice, alVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ui(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.am
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.ti(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vg(final int i3, final xh2.d dVar, final int i16, final String str, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.h
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.ug(i16, str, i3, arrayList, dVar, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void vh(ArrayList arrayList, ArrayList arrayList2, long j3, int i3, String str, int i16, di2.c cVar) {
        List<GProGuildRoleInfo> v3 = com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList);
        List<GProGuildRoleInfo> v16 = com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList2);
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRoleList", "callback", i3, str, "limit=" + j3 + " roleInfoList=" + v3.toString(), i16);
        cVar.a(i3, str, j3, v3, v16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vi(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setDirectMsgNotifyType", "", i3, str, "security=" + Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wg(int i3, String str, int i16, ArrayList arrayList, xh2.e eVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelInvisibleRoleList", "callback", i3, str, null, i16);
        eVar.a(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.C0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wh(final int i3, final di2.c cVar, final int i16, final String str, final long j3, final ArrayList arrayList, final ArrayList arrayList2) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dn
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.vh(arrayList, arrayList2, j3, i16, str, i3, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wi(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ae
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.vi(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xg(final int i3, final xh2.e eVar, final int i16, final String str, final ArrayList arrayList) {
        this.f266769b.post(new Runnable(i16, str, i3, arrayList, eVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dk

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f269893d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f269894e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f269895f;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ ArrayList f269896h;

            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.wg(this.f269893d, this.f269894e, this.f269895f, this.f269896h, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xh(int i3, String str, ArrayList arrayList, ArrayList arrayList2, long j3, int i16, IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback, ArrayList arrayList3) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRoleListWithPermission", "cb", i3, str, "roleList=" + arrayList.size() + " myRoles=" + arrayList2 + " limit=" + j3, i16);
        iGProFetchRoleListPermissionCallback.onFetchRoleListPermissionCallback(i3, str, arrayList, arrayList3, arrayList2, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xi(int i3, String str, GProSecurityResult gProSecurityResult, int i16, vh2.cd cdVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setDirectMsgStatus", "", i3, str, "security=" + Qf(gProSecurityResult), i16);
        cdVar.a(i3, str, tf(gProSecurityResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void yg(int i3, String str, int i16, ArrayList arrayList, xh2.f fVar, int i17, boolean z16, byte[] bArr) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelLiveableMemberList", "callback", i3, str, null, i16);
        fVar.a(i3, str, i17, z16, bArr, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(final int i3, final IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback, final int i16, final String str, final ArrayList arrayList, final ArrayList arrayList2, final ArrayList arrayList3, final long j3) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.y
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.xh(i16, str, arrayList, arrayList3, j3, i3, iGProFetchRoleListPermissionCallback, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(final int i3, final vh2.cd cdVar, final int i16, final String str, final GProSecurityResult gProSecurityResult) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ah
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.this.xi(i16, str, gProSecurityResult, i3, cdVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zg(final int i3, final xh2.f fVar, final int i16, final String str, final int i17, final boolean z16, final byte[] bArr, final ArrayList arrayList) {
        this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.w
            @Override // java.lang.Runnable
            public final void run() {
                GProSdkWrapperImpl.yg(i16, str, i3, arrayList, fVar, i17, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zh(int i3, String str, GProGuildRole gProGuildRole, GProRolePermission gProRolePermission, ArrayList arrayList, int i16, IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback, ArrayList arrayList2) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRoleWithPermission", "cb", i3, str, " roleInfo=" + gProGuildRole + " allowPermission=" + gProRolePermission + " permissionCategories=" + arrayList, i16);
        iGProFetchRolePermissionCallback.onFetchRolePermissionCallback(i3, str, gProGuildRole, gProRolePermission, arrayList2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zi(int i3, String str, int i16, vh2.k kVar, int i17) {
        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setFeedCommentsNotifySwitch", "", i3, str, "", i16);
        kVar.onResult(i3, str, i17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ad(String str, String str2, int i3, final vh2.cs csVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMyMsgNotifyType", "ui-self", " channelUin \uff1a " + str2 + "\uff0c type \uff1a " + i3, i16);
        this.f266768a.customChannelMsgNotifyType(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.23
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str3, GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "customChannelMsgNotifyType", "ui-setMyMsgNotifyType", i17, str3, null, q16);
                        csVar.a(i17, null, str3);
                    }
                });
            }
        });
    }

    public void Ae(String str, String str2, boolean z16, int i3, final di2.b bVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRole", "call", "guildId: " + str + ", roleId: " + str2, i16);
        this.f266768a.fetchRole(O0, O02, i3, z16, new IGProFetchRoleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.95
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleCallback
            public void onFetchRoleCallback(final int i17, final String str3, final GProGuildRole gProGuildRole) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.95.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GProGuildRoleInfo gProGuildRoleInfo = new GProGuildRoleInfo(gProGuildRole);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRole", "callback", i17, str3, "roleInfo: " + gProGuildRoleInfo.toString(), q16);
                        bVar.a(i17, str3, gProGuildRoleInfo);
                    }
                });
            }
        });
    }

    public IGProGuildRoleInfo Af(long j3, long j16, long j17, long j18, int i3) {
        GProGuildRole memberTopRoleInfo = this.f266768a.getMemberTopRoleInfo(j3, j16, j17, j18, i3);
        if (memberTopRoleInfo != null) {
            return new GProGuildRoleInfo(memberTopRoleInfo);
        }
        return null;
    }

    public void Aj(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProScheduleSendArkGuildInfo> arrayList3, GProScheduleSendArkGuildInfo gProScheduleSendArkGuildInfo, long j3, int i3, String str, String str2, String str3, byte[] bArr, final IGProSendScheduleArkMessageCallback iGProSendScheduleArkMessageCallback) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getScheduleUsers", "", "targetType:" + i3, i16);
        this.f266768a.sendScheduleArkMessage(arrayList, arrayList2, arrayList3, gProScheduleSendArkGuildInfo, j3, i3, str, str2, str3, bArr, new IGProSendScheduleArkMessageCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.114
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSendScheduleArkMessageCallback
            public void onSendArkMessage(final int i17, final String str4) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.114.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getScheduleUsers", "", i17, str4, "", q16);
                        iGProSendScheduleArkMessageCallback.onSendArkMessage(i17, str4);
                    }
                });
            }
        });
    }

    public void Ak(int i3, String str, String str2, int i16, final vh2.dc dcVar) {
        String str3;
        String str4;
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserLiveInfo", "", "liveType = " + i3 + " title = " + str3 + " coverUrl = " + str4, i17);
        this.f266768a.setUserLiveInfo(i3, str3, str4, i16, new IGProSetUserLiveInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.37
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetUserLiveInfoCallback
            public void onSetUserLiveInfoResult(final int i18, final String str5, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.37.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setUserLiveInfo", "", i18, str5, gProSecurityResult.toString(), q16);
                        AnonymousClass37 anonymousClass37 = AnonymousClass37.this;
                        dcVar.a(i18, str5, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void Bd(String str, String str2, final vh2.j jVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", true, "sdkWrapper interface", "dealNotice", SensorJsPlugin.SENSOR_INTERVAL_UI, "noticeId \uff1a" + str + " actionId \uff1a" + str2, i3);
        this.f266768a.dealNotice(str, str2, new IGProDealNoticeCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.58
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDealNoticeCallback
            public void onDealNoticeResult(final int i16, final String str3, final int i17, final String str4, final boolean z16, final GProNotice gProNotice) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.58.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildNoticeDealResult guildNoticeDealResult = new GuildNoticeDealResult(i17, str4, z16, com.tencent.mobileqq.qqguildsdk.util.g.f0(gProNotice));
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", true, "sdkWrapper callback", "on dealNotice", "", i16, str3, "guildNotice:" + gProNotice, q16);
                        jVar.a(i16, str3, guildNoticeDealResult);
                    }
                });
            }
        });
    }

    public void Be(String str, int i3, int i16, final di2.c cVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRoleList", "call", "guildId=" + str + " filter=" + i3, i17);
        this.f266768a.fetchRoleListWithFilter(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i3, i16, new IGProFetchRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ba
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListCallback
            public final void onFetchRoleListCallback(int i18, String str2, long j3, ArrayList arrayList, ArrayList arrayList2) {
                GProSdkWrapperImpl.this.wh(q16, cVar, i18, str2, j3, arrayList, arrayList2);
            }
        });
    }

    public IGProGuildRoleInfo Bf(long j3, long j16) {
        GProGuildRole roleInfo = this.f266768a.getRoleInfo(j3, j16);
        if (roleInfo != null) {
            return new GProGuildRoleInfo(roleInfo);
        }
        return null;
    }

    public void Bj(String str, String str2, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelBannedSpeak", SensorJsPlugin.SENSOR_INTERVAL_UI, " channelUin \uff1a " + str2 + "\uff0c bannedSpeak \uff1a " + i3, i16);
        this.f266768a.setChannelBannedSpeak(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.18
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelTalkPermission", SensorJsPlugin.SENSOR_INTERVAL_UI, i17, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass18 anonymousClass18 = AnonymousClass18.this;
                        cdVar.a(i17, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void Bk(String str, String str2, String str3, boolean z16, final vh2.cc ccVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserMuteSeatInGuild", "", "guildId \uff1a" + str + "\uff0c tinyId \uff1a " + str3 + "\uff0c bMute \uff1a " + z16, i3);
        this.f266768a.setUserMuteSeatInGuild(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.41
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str4, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.41.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setUserMuteSeatInGuild", "", i16, str4, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        ccVar.onResult(i16, str4);
                    }
                });
            }
        });
    }

    public void Cd(String str, String str2, final vh2.cd cdVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "deleteRole", "call", "guildId: " + str + ", roleId: " + str2, i3);
        this.f266768a.deleteRole(O0, O02, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.89
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.89.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "deleteRole", "callback", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass89 anonymousClass89 = AnonymousClass89.this;
                        cdVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void Ce(String str, int i3, final IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRoleListWithPermission", "call", "guildId=" + str, i16);
        this.f266768a.fetchRoleListWithPermission(O0, i3, new IGProFetchRoleListPermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dc
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleListPermissionCallback
            public final void onFetchRoleListPermissionCallback(int i17, String str2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, long j3) {
                GProSdkWrapperImpl.this.yh(q16, iGProFetchRoleListPermissionCallback, i17, str2, arrayList, arrayList2, arrayList3, j3);
            }
        });
    }

    @Nullable
    public GProOnlineMember Cf(String str) {
        GProOnlineMemberInfo onlineMemberInfo = this.f266768a.getOnlineMemberInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str));
        if (onlineMemberInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getOnlineMemberInfo return null");
            return null;
        }
        return new GProOnlineMember(str, onlineMemberInfo);
    }

    public void Cj(String str, String str2, long j3, final di2.d dVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryWithId", " ", "guildId \uff1a" + str + "\uff0cchannelId \uff1a" + str2 + "\uff0c categoryId \uff1a " + j3, i3);
        this.f266768a.setChannelCategoryWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, new IGProSetChannelCategoryInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.45
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback
            public void onSetChannelCategoryInfo(final int i16, final String str3, final GProSecurityResult gProSecurityResult, HashMap<Long, GProChannel> hashMap, @NonNull final GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull final ArrayList<GProCategoryChannelIdList> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.45.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelCategoryWithId", "", i16, str3, GProSdkWrapperImpl.this.Re(gProSecurityResult, gProCategoryChannelIdList, arrayList), q16);
                        AnonymousClass45 anonymousClass45 = AnonymousClass45.this;
                        dVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList));
                    }
                });
            }
        });
    }

    public void Ck(String str, final vh2.dg dgVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserType", "", "", i3);
        this.f266768a.setUserType(str, new IGProUserTypeSetCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bz
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUserTypeSetCallback
            public final void onUserTypeSetResult(int i16, String str2, boolean z16) {
                GProSdkWrapperImpl.this.Oi(q16, dgVar, i16, str2, z16);
            }
        });
    }

    public void Dd(String str, String str2, GProScheduleInfo gProScheduleInfo, int i3, final IGProEditScheduleCallback iGProEditScheduleCallback) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "editSchedule", "", "guildId:" + str, i16);
        this.f266768a.editSchedule(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), gProScheduleInfo, i3, new IGProEditScheduleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.107
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProEditScheduleCallback
            public void onEditSchedule(final int i17, final String str3, final GProScheduleInfo gProScheduleInfo2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.107.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "editSchedule", "", i17, str3, "", q16);
                        iGProEditScheduleCallback.onEditSchedule(i17, str3, gProScheduleInfo2);
                    }
                });
            }
        });
    }

    public void De(String str, String str2, String str3, String str4, long j3, int i3, final vh2.as asVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        long O03 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str3);
        long O04 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str4);
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRoleMemberListInternal", "call", "guildId: " + str + ", channelId: " + str2 + "categoryId: " + str3 + ", roleId: " + str4 + ", startIndex: " + j3 + ", count: " + i3, i16);
        this.f266768a.fetchRoleMembers(O0, O02, O03, O04, j3, i3, new IGProFetchRoleMembersCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.98
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRoleMembersCallback
            public void onFetchRoleMembersCallback(final int i17, final String str5, final int i18, final int i19, final long j16, final ArrayList<GProUser> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.98.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        List<IGProUserInfo> K0 = com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRoleMemberListInternal", "callback", i17, str5, "memberCount: " + i18 + ", isFinished: " + i19 + ", nextIndex: " + j16 + ", memberListSize: " + K0.size(), q16);
                        vh2.as asVar2 = asVar;
                        int i26 = i17;
                        String str6 = str5;
                        int i27 = i18;
                        if (i19 != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        asVar2.a(i26, str6, i27, z16, j16, K0);
                    }
                });
            }
        });
    }

    public int Df(String str, String str2) {
        return this.f266768a.getPermissionChangeFilter(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
    }

    public void Dj(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList, final di2.d dVar) {
        String str2 = "guildId \uff1a" + str + "\uff0c unCategory \uff1a " + bVar.b();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryInfoWithId", "", str2, i3);
        this.f266768a.setChannelCategoryInfoWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.e(bVar), com.tencent.mobileqq.qqguildsdk.util.g.h(arrayList), new IGProSetChannelCategoryInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.50
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback
            public void onSetChannelCategoryInfo(final int i16, final String str3, final GProSecurityResult gProSecurityResult, HashMap<Long, GProChannel> hashMap, @NonNull final GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull final ArrayList<GProCategoryChannelIdList> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.50.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelCategoryInfoWithId", "", i16, str3, GProSdkWrapperImpl.this.Re(gProSecurityResult, gProCategoryChannelIdList, arrayList2), q16);
                        AnonymousClass50 anonymousClass50 = AnonymousClass50.this;
                        dVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList2));
                    }
                });
            }
        });
    }

    public void Dk(String str, boolean z16, final vh2.cc ccVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setUserVoicelessToMe", "", "tinyId \uff1a" + str + "\uff0c bVoiceless \uff1a " + z16, i3);
        this.f266768a.setUserVoicelessToMe(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.40
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str2, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setUserVoicelessToMe", "", i16, str2, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        ccVar.onResult(i16, str2);
                    }
                });
            }
        });
    }

    public void Ed(com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar, final wh2.x xVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "enterAudioLiveChannelAndCallbackDirect", "", "", i3);
        this.f266768a.enterAudioLiveChannel(com.tencent.mobileqq.qqguildsdk.engine.aa.I(aiVar), new IGProEnterAudioLiveChannelCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.g
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProEnterAudioLiveChannelCallback
            public final void onEnterAudioLiveChannel(int i16, String str, GProSecurityResult gProSecurityResult, GProEnterAudioLiveChannelRsp gProEnterAudioLiveChannelRsp) {
                GProSdkWrapperImpl.qg(q16, xVar, i16, str, gProSecurityResult, gProEnterAudioLiveChannelRsp);
            }
        });
    }

    public void Ee(String str, String str2, int i3, final IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRoleWithPermission", "call", "guildId=" + str + ", roleId=" + str2, i16);
        this.f266768a.fetchRoleWithPermission(O0, O02, i3, new IGProFetchRolePermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ep
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRolePermissionCallback
            public final void onFetchRolePermissionCallback(int i17, String str3, GProGuildRole gProGuildRole, GProRolePermission gProRolePermission, ArrayList arrayList, ArrayList arrayList2) {
                GProSdkWrapperImpl.this.Ah(q16, iGProFetchRolePermissionCallback, i17, str3, gProGuildRole, gProRolePermission, arrayList, arrayList2);
            }
        });
    }

    public IGProAppChnnPreInfo Ef(String str, String str2) {
        GProPollingChannelState pollingCtx = this.f266768a.getPollingCtx(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), 3);
        if (pollingCtx == null) {
            return null;
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bi(pollingCtx).a();
    }

    public void Ej(String str, ArrayList<Long> arrayList, final di2.d dVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelCategoryOrderWithId", "", "guildId \uff1a" + str + "\uff0c categoryList \uff1a " + arrayList, i3);
        this.f266768a.setChannelCategoryOrderWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), arrayList, new IGProSetChannelCategoryInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.49
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback
            public void onSetChannelCategoryInfo(final int i16, final String str2, final GProSecurityResult gProSecurityResult, HashMap<Long, GProChannel> hashMap, @NonNull final GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull final ArrayList<GProCategoryChannelIdList> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelCategoryOrderWithId", "", i16, str2, GProSdkWrapperImpl.this.Re(gProSecurityResult, gProCategoryChannelIdList, arrayList2), q16);
                        AnonymousClass49 anonymousClass49 = AnonymousClass49.this;
                        dVar.a(i16, str2, GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList2));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ek(String str) {
        TraceUtils.n("Guild.SDK.NT.StartNTSdk.");
        AppRuntime appRuntime = this.f268558e.get();
        if (appRuntime != null) {
            com.tencent.mobileqq.startup.a.f289680u = SystemClock.elapsedRealtime();
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "sdkWrapper interface", "startGProSdk", "sdk-init", "account= " + str + ", this hash= " + hashCode() + ", app.hash= " + appRuntime.hashCode() + ", ntEndTime= " + com.tencent.mobileqq.startup.a.f289679t + ", gproEndTime= " + com.tencent.mobileqq.startup.a.f289680u);
            IGProSession iGProSession = (IGProSession) appRuntime.getRuntimeService(IGProSession.class, "");
            try {
                com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "sdkWrapper interface", "startGProSdk", "sdk-init", "account= " + str + ", start gpro finished result=" + iGProSession.getGproStartCountDownLatch().await(2L, TimeUnit.SECONDS));
            } catch (InterruptedException e16) {
                com.tencent.mobileqq.qqguildsdk.util.h.k("GProSdkWrapperImpl", 1, "startGProSdk", "sdk-init, account= " + str + ", error:" + e16.getMessage());
            }
            IKernelGuildService guildService = iGProSession.getGuildService();
            this.f266768a = guildService;
            if (guildService == null) {
                if (iGProSession.getIsDestroy()) {
                    com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "NTSDKInit IKernelService is being destroyed.");
                    return false;
                }
                if (!appRuntime.isLogin()) {
                    com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "NTSDKInit AppRuntime is not login.");
                    return false;
                }
                throw new IllegalStateException("session shouldn't be null with account=" + str + " app.hash= " + appRuntime.hashCode());
            }
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "NTSDKInit GProSdkWrapperImpl startGPro: " + com.tencent.mobileqq.qqguildsdk.util.j.b(new Exception("StartGPro stack")) + ", AppRuntime hash: " + appRuntime.hashCode());
            IKernelGuildService iKernelGuildService = this.f266768a;
            if (iKernelGuildService != null) {
                iKernelGuildService.addKernelGuildListener(this.f268562i);
                this.f266768a.setPerformanceEnable(false);
            }
            gj();
            iGProSession.notifyGProSdkStart();
            this.f268557d.notifyChange(304, "startGProSdk", new Object[0]);
            return true;
        }
        throw new IllegalStateException("appRuntime shouldn't be null with account=" + str);
    }

    public void Fd(String str, String str2, byte[] bArr, int i3, final vh2.l lVar) {
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        String str3 = "tinyId: " + str + " guildId:" + str2 + " cookie.length: " + Integer.valueOf(bArr2.length) + " pullSize: " + i3;
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchArchiveArkData", "call", str3, i16);
        this.f266768a.fetchArchiveArkData(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), bArr2, i3, new IGProFetchArchiveArkDataCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.76
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchArchiveArkDataCallback
            public void onFetchArchiveArkData(final int i17, final String str4, final boolean z16, final byte[] bArr3, final ArrayList<GProArchiveArkData> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.76.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchArchiveArkData", "callback", i17, str4, "isEnd=" + z16 + ", cookie=" + bArr3 + ", sortedArchives.size=" + arrayList.size(), q16);
                        ArrayList<xh2.c> arrayList2 = new ArrayList<>();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.aj((GProArchiveArkData) it.next()));
                        }
                        lVar.onFetchArchiveArkData(i17, str4, z16, bArr3, arrayList2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fe(String str, String str2, List<String> list, int i3, final di2.f fVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchUserInfo", "ui-after loadUserInfo", "guildId \uff1a" + str + ", channelId \uff1a" + str2 + "\uff0c tinydList \uff1a " + list, i16);
        this.f266768a.fetchUserInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), i3, new IGProGetUserInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.4
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserInfoCallback
            public void onGetUserInfo(final int i17, final String str3, final ArrayList<GProUser> arrayList, final ArrayList<Long> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18;
                        int i19 = i17;
                        String str4 = str3;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("sucList size : ");
                        ArrayList arrayList3 = arrayList;
                        if (arrayList3 != null) {
                            i18 = arrayList3.size();
                        } else {
                            i18 = 0;
                        }
                        sb5.append(i18);
                        sb5.append(", failList \uff1a");
                        sb5.append(arrayList2);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchUserInfo", "Get Svr member list", i19, str4, sb5.toString(), q16);
                        fVar.a(i17, str3, com.tencent.mobileqq.qqguildsdk.util.g.X(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList2));
                    }
                });
            }
        });
    }

    public ILiveRoomInfo Ff(String str, String str2) {
        GProPollingChannelState pollingCtx = this.f266768a.getPollingCtx(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), 2);
        if (pollingCtx == null) {
            return null;
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bi(pollingCtx).e();
    }

    public void Fj(String str, String str2, int i3, @NonNull final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelLiveable", "call", "guildId=" + str + " channelId=" + str2 + " type=" + i3, i16);
        this.f266768a.setChannelLiveable(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.az
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i17, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Yh(q16, cdVar, i17, str3, gProSecurityResult);
            }
        });
    }

    public void Fk() {
        this.f266768a = null;
        com.tencent.mobileqq.qqguildsdk.util.h.u("sdkWrapper interface", true, "stopSdkWrapper", "close sdk service, kernelGuildService is setting to null, hash" + hashCode());
    }

    public void Gd(com.tencent.mobileqq.qqguildsdk.data.genc.m mVar, final wh2.ac acVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchAudioLiveChannelGroupListAndCallbackDirect", "", "", i3);
        this.f266768a.fetchAudioLiveChannelGroupList(com.tencent.mobileqq.qqguildsdk.engine.aa.m(mVar), new IGProFetchAudioLiveGroupListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ea
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAudioLiveGroupListCallback
            public final void onFetchAudioLiveChannelGroups(int i16, String str, GProAVMemberGroupListRsp gProAVMemberGroupListRsp) {
                GProSdkWrapperImpl.rg(q16, acVar, i16, str, gProAVMemberGroupListRsp);
            }
        });
    }

    public void Ge(String str, String str2, List<String> list, int i3, final vh2.av avVar) {
        String str3 = "channelId: " + str2 + ", tinyIdList: " + list.size();
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchVisibleMemberListByTinyId", "call", str3, i16);
        this.f266768a.fetchVisibleMemberListByTinyId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), i3, new IGProFetchVisibleMemberListByTinyIdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.28
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchVisibleMemberListByTinyIdCallback
            public void onFetchVisibleMemberListByTinyId(final int i17, final String str4, final ArrayList<GProUser> arrayList, final ArrayList<Long> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.28.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchVisibleMemberListByTinyId", "callback", i17, str4, "memberList: " + arrayList + ", failList: " + arrayList2.size(), q16);
                        avVar.a(i17, str4, com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList2));
                    }
                });
            }
        });
    }

    @Nullable
    public IAudioChannelMemberInfos Gf(String str, String str2) {
        GProPollingChannelState pollingCtx = this.f266768a.getPollingCtx(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), 1);
        if (pollingCtx == null) {
            return null;
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bi(pollingCtx).h();
    }

    public void Gj(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelLiveableMemberList", "call", "guildId=" + str + " channelId=" + str2 + " addUserList=" + list + " removeUserList=" + list2, i3);
        this.f266768a.setChannelLiveableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bm
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.ai(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void Gk(@NonNull String str, int i3) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.subscribePolling(O0, i3);
        }
    }

    public void Hd(String str, String str2, final vh2.e eVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelAdminInfoList", "", "guildId:" + str + " channelId:" + str2, i3);
        this.f266768a.fetchChannelAdminInfoList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProChannelAdminInfoListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.br
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProChannelAdminInfoListCallback
            public final void onResult(int i16, String str3, ArrayList arrayList, int i17, boolean z16) {
                GProSdkWrapperImpl.this.tg(q16, eVar, i16, str3, arrayList, i17, z16);
            }
        });
    }

    public com.tencent.mobileqq.qqguildsdk.data.fk Hf(String str, String str2) {
        return com.tencent.mobileqq.qqguildsdk.util.g.S0(this.f266768a.getQQMsgListChannel(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2)));
    }

    public void Hj(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelLiveableRoleList", "call", "guildId=" + str + " channelId=" + str2 + " addRoleList=" + list + " removeRoleList=" + list2, i3);
        this.f266768a.setChannelLiveableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.be
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.ci(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void Hk(@NonNull List<com.tencent.mobileqq.qqguildsdk.data.fj> list) {
        ArrayList<GProPollingInfo> G = com.tencent.mobileqq.qqguildsdk.util.g.G(list);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.subscribePollingChannels(G);
        }
    }

    public void Id(String str, String str2, int i3, final vh2.n nVar) {
        this.f266768a.fetchChannelInfoWithCategory(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProFetchChannelInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.15
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelInfoCallback
            public void onFetchChannelInfo(final int i16, final String str3, final GProChannel gProChannel) {
                if (nVar == null) {
                    return;
                }
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GProChannelInfo gProChannelInfo;
                        vh2.n nVar2 = nVar;
                        int i17 = i16;
                        String str4 = str3;
                        GProChannel gProChannel2 = gProChannel;
                        if (gProChannel2 == null) {
                            gProChannelInfo = null;
                        } else {
                            gProChannelInfo = new GProChannelInfo(gProChannel2);
                        }
                        nVar2.a(i17, str4, gProChannelInfo);
                    }
                });
            }
        });
    }

    public void Ie(com.tencent.mobileqq.qqguildsdk.data.ai aiVar, final vh2.ba baVar) {
        if (this.f266768a == null) {
            hj();
            return;
        }
        GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq = new GProGetLiveAudioPollingInfoReq();
        gProGetLiveAudioPollingInfoReq.guildId = com.tencent.mobileqq.qqguildsdk.util.g.O0(aiVar.b());
        gProGetLiveAudioPollingInfoReq.categoryTypeList = aiVar.a();
        this.f266768a.getActiveLiveAudioChannelNumV2(gProGetLiveAudioPollingInfoReq, new IGProGetActiveLiveAudioChannelNumV2Callback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ca
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetActiveLiveAudioChannelNumV2Callback
            public final void onResult(GProGetActiveLiveAudioChannelNumRsp gProGetActiveLiveAudioChannelNumRsp) {
                GProSdkWrapperImpl.this.Ch(baVar, gProGetActiveLiveAudioChannelNumRsp);
            }
        });
    }

    public List<com.tencent.mobileqq.qqguildsdk.data.fk> If() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
            return Collections.emptyList();
        }
        return com.tencent.mobileqq.qqguildsdk.util.g.T0(iKernelGuildService.getQQMsgListChannels());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ij(String str, String str2, int i3, final vh2.cr crVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelMsgNotifyType", "ui-for manage", "channelUin \uff1a " + str2 + "\uff0c type \uff1a " + i3, i16);
        this.f266768a.setChannelMsgNotifyType(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.21
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelMsgNotifyType", "ui-for manager", i17, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass21 anonymousClass21 = AnonymousClass21.this;
                        crVar.a(i17, null, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void Ik(String str, String str2, int i3, int i16, final vh2.de deVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "terminateLiveStream", "", "guildId \uff1a" + str + ", channelId:" + str2, i17);
        this.f266768a.terminateLiveStream(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, i16, new IGProTerminateLiveStreamCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.62
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTerminateLiveStreamCallback
            public void onTerminateLiveStreamCallback(final int i18, final String str3) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.62.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper callback", "onTerminateLiveStreamCallback", "", str3);
                        deVar.a(i18, str3);
                    }
                });
            }
        });
    }

    public void Jd(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.d dVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelInvisibleMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelInvisibleMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelInvisibleMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bd
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelInvisibleMemberListCallback
            public final void onFetchChannelInvisibleMemberList(int i17, String str3, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.vg(q16, dVar, i17, str3, z16, bArr2, arrayList);
            }
        });
    }

    public void Je(String str, final int i3, final vh2.be beVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAppAuthorizationInfo", "", "clientId: " + str + ", type: " + i3, i16);
        this.f266768a.getAppAuthorizationInfo(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), i3, new IGProGetAppAuthorizationInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.73
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAppAuthorizationInfoCallback
            public void onGetAppAuthorizationInfo(final int i17, final String str2, final int i18, int i19, final boolean z16, final GProPopupConfig gProPopupConfig, final GProRole gProRole) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.73.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAppAuthorizationInfo", "", i17, str2, "clientId: " + i18 + ", type: " + i3 + ", bAuthorization: " + z16 + ", popupConfig: " + gProPopupConfig + ", role: " + gProRole, q16);
                        beVar.a(i17, str2, com.tencent.mobileqq.qqguildsdk.util.g.W0(i18), i3, z16, new com.tencent.mobileqq.qqguildsdk.data.bj(gProPopupConfig), new GProRoleInfo(gProRole));
                    }
                });
            }
        });
    }

    @Nullable
    public IGProRecommendEssenceSvrRsp Jf(String str, String str2) {
        GProPollingChannelState pollingCtx = this.f266768a.getPollingCtx(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), 11);
        if (pollingCtx == null) {
            return null;
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bi(pollingCtx).g();
    }

    public void Jj(String str, String str2, String str3, final vh2.ct ctVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelName", SensorJsPlugin.SENSOR_INTERVAL_UI, " channelUin \uff1a " + str2 + "\uff0c name \uff1a " + str3, i3);
        this.f266768a.setChannelName(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), str3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.20
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str4, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelName", SensorJsPlugin.SENSOR_INTERVAL_UI, i16, str4, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        ctVar.a(i16, null, str4, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void Jk(String str, String str2, boolean z16, final vh2.cc ccVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "tryUnmuteMicrophone", "", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.tryUnmuteMicrophone(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), z16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cg
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i16, String str3) {
                GProSdkWrapperImpl.this.Qi(q16, ccVar, i16, str3);
            }
        });
    }

    public void Kd(String str, String str2, @NonNull final xh2.e eVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelInvisibleRoleList", "call", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.fetchChannelInvisibleRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchChannelInvisibleRoleListCallback(q16, eVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bk

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f269710b;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelInvisibleRoleListCallback
            public final void onFetchChannelInvisibleRoleList(int i16, String str3, ArrayList arrayList) {
                GProSdkWrapperImpl.this.xg(this.f269710b, null, i16, str3, arrayList);
            }
        });
    }

    public IGProAppChnnPreInfo Ke(String str, String str2) {
        GProAppChnnPreInfo appChannelPreInfo = this.f266768a.getAppChannelPreInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
        if (appChannelPreInfo == null) {
            return null;
        }
        return new GGProAppChnnPreInfo(appChannelPreInfo);
    }

    @Nullable
    public void Kf(vh2.ay ayVar) {
        if (this.f266768a == null) {
            hj();
            return;
        }
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.getRecommendGuildInfoFromCacheAsync(new IGProGetRecommendGuildInfoCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getRecommendGuildInfoFromCache", "", "", i3), ayVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.118

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268686a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendGuildInfoCallback
            public void onGetRecommendGuildInfoCallback(final int i16, final String str, final GProQueryRecommendGuildInfoRsp gProQueryRecommendGuildInfoRsp) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.118.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getRecommendGuildInfoFromCache", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", AnonymousClass118.this.f268686a);
                        new GGProQueryRecommendGuildInfoRsp(gProQueryRecommendGuildInfoRsp);
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    public void Kj(String str, String str2, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelSlowMode", SensorJsPlugin.SENSOR_INTERVAL_UI, "guildId \uff1a " + str + "\uff0c channelUin \uff1a " + str2 + "\uff0c slowModeKey \uff1a " + i3, i16);
        this.f266768a.setChannelSlowMode(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.19
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelSlowMode", SensorJsPlugin.SENSOR_INTERVAL_UI, i17, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass19 anonymousClass19 = AnonymousClass19.this;
                        cdVar.a(i17, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void Kk(@NonNull List<com.tencent.mobileqq.qqguildsdk.data.fj> list) {
        ArrayList<GProPollingInfo> G = com.tencent.mobileqq.qqguildsdk.util.g.G(list);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.ubSubscribePollingChannels(G);
        }
    }

    public void Ld(String str, vh2.o oVar) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(com.tencent.mobileqq.qqguildsdk.util.g.O0(str)));
        this.f266768a.fetchChannelList(arrayList, new IGProFetchChannelListCategoryCallback(oVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.14
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListCategoryCallback
            public void onFetchChannelListCategory(final int i3, final String str2, final ArrayList<GProGuildInit> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object obj;
                        int i16 = i3;
                        String str3 = str2;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("guildInitList size \uff1a");
                        ArrayList arrayList3 = arrayList2;
                        if (arrayList3 != null) {
                            obj = Integer.valueOf(arrayList3.size());
                        } else {
                            obj = "0";
                        }
                        sb5.append(obj);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelList", "", i16, str3, sb5.toString(), 0);
                        getClass();
                    }
                });
            }
        });
    }

    public void Le(String str, String str2, byte[] bArr, final vh2.bf bfVar) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = "clientId: " + str + " areaId:" + str2 + " cookies.length:" + bArr.length;
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAppRoleList", "", str3, i3);
        this.f266768a.getAppRoleList(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), str2, bArr, new IGProGetAppRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.75
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAppRoleListCallback
            public void onGetAppRoleList(final int i16, final String str4, final int i17, final ArrayList<GProRole> arrayList, final String str5, final String str6, final int i18, final GProAreaList gProAreaList, final ArrayList<GProAreaLevel> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.75.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAppRoleList", "", i16, str4, "clientId: " + i17 + ", roleList: " + arrayList + ", title: " + str5 + ", toast: " + str6 + ",resultType:" + i18 + ",areaList:" + gProAreaList + ",areaLevels:" + arrayList2, q16);
                        bfVar.a(i16, str4, com.tencent.mobileqq.qqguildsdk.util.g.W0(i17), com.tencent.mobileqq.qqguildsdk.util.g.E0(arrayList), str5, str6, i18, new com.tencent.mobileqq.qqguildsdk.data.am(gProAreaList), com.tencent.mobileqq.qqguildsdk.util.g.b(arrayList2));
                    }
                });
            }
        });
    }

    public void Lf(String str, String str2, String str3, final IGProGetScheduleDetailCallback iGProGetScheduleDetailCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getScheduleDetail", "", "guildId:" + str, i3);
        this.f266768a.getScheduleDetail(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), new IGProGetScheduleDetailCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.108
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleDetailCallback
            public void onGetScheduleDetail(final int i16, final String str4, final GProScheduleInfo gProScheduleInfo, final int i17, final boolean z16, final GProScheduleGuildSurface gProScheduleGuildSurface) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.108.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getScheduleDetail", "", i16, str4, "", q16);
                        iGProGetScheduleDetailCallback.onGetScheduleDetail(i16, str4, gProScheduleInfo, i17, z16, gProScheduleGuildSurface);
                    }
                });
            }
        });
    }

    public void Lj(String str, String str2, int i3, @NonNull final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelSpeakable", "call", "guildId=" + str + " channelId=" + str2 + " type=" + i3, i16);
        this.f266768a.setChannelSpeakable(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bp
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i17, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.ei(q16, cdVar, i17, str3, gProSecurityResult);
            }
        });
    }

    public void Lk(@NonNull String str) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.unsubscribePolling(O0);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void M5(com.tencent.mobileqq.qqguildsdk.data.genc.cn cnVar, wh2.es esVar) {
        long currentTimeMillis = System.currentTimeMillis();
        super.M5(cnVar, esVar);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 30) {
            QLog.e("GProSdkWrapperImpl", 1, "userOnlineReport cost:" + currentTimeMillis2);
        }
    }

    public void Md(long j3, final IGProFetchChannelListForJumpCallback iGProFetchChannelListForJumpCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelListForJump", "", "guildId:" + j3 + " ", i3);
        this.f266768a.fetchChannelListForJump(j3, new IGProFetchChannelListForJumpCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.51
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListForJumpCallback
            public void onFetchChannelListForJump(final int i16, final String str, final GProGuildInit gProGuildInit) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.51.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelListForJump", "", i16, str, "result:" + i16 + " errMsg:" + str + " ", q16);
                        iGProFetchChannelListForJumpCallback.onFetchChannelListForJump(i16, str, gProGuildInit);
                    }
                });
            }
        });
    }

    public void Me(String str, vh2.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.getAssociativeWords(str, new IGProAssociativeWordsCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getAssociativeWorks", "", "searchTerm:" + str, i3), bVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.104

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268607a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAssociativeWordsCallback
            public void onAssociativeWordsResult(final int i16, final String str2, final ArrayList<GProAssociativeWords> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.104.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAssociativeWorks", "", i16, str2, "", AnonymousClass104.this.f268607a);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.u((GProAssociativeWords) it.next()));
                        }
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    public void Mf(String str, String str2, long j3, final IGProGetScheduleListCallback iGProGetScheduleListCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getScheduleList", "", "guildId:" + str, i3);
        this.f266768a.getScheduleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, new IGProGetScheduleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.109
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListCallback
            public void onGetScheduleList(final int i16, final String str3, final ArrayList<GProScheduleInfo> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.109.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getScheduleList", "", i16, str3, "", q16);
                        iGProGetScheduleListCallback.onGetScheduleList(i16, str3, arrayList);
                    }
                });
            }
        });
    }

    public void Mj(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelSpeakableMemberList", "call", "guildId=" + str + " channelId=" + str2 + " addUserList=" + list + " removeUserList=" + list2, i3);
        this.f266768a.setChannelSpeakableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.co
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.gi(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void Mk(ArrayList<Integer> arrayList, vh2.df dfVar) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("clientIds.size: ");
        if (arrayList != null) {
            obj = Integer.valueOf(arrayList.size());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        String sb6 = sb5.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.updateArchiveShowSeq(arrayList, new IGProUpdateArchiveShowSeqCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "updateArchiveShowSeq", "call", sb6, i3), dfVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.77

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269190a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateArchiveShowSeqCallback
            public void onUpdateArchiveShowSeq(final int i16, final String str) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.77.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "OnUpdateArchiveShowSeq", "callback", i16, str, "", AnonymousClass77.this.f269190a);
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void N0(ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.da> arrayList, com.tencent.mobileqq.qqguildsdk.data.genc.ep epVar, wh2.dm dmVar) {
        super.N0(arrayList, epVar, new d(dmVar));
    }

    public void Nd(ArrayList<GProGuildStateReqInfo> arrayList, final IGProFetchChannelListStateCallback iGProFetchChannelListStateCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelListState", "", "req:" + arrayList, i3);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[gpro_sdk] fetchChannelListState", new NullPointerException("kernelGuildService == null"));
        } else {
            iKernelGuildService.fetchChannelListState(arrayList, new IGProFetchChannelListStateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.101
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelListStateCallback
                public void onFetchChannelListState(final int i16, final String str, final GProGuildStateRspInfo gProGuildStateRspInfo) {
                    ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.101.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelListState", "", i16, str, "nextTs:" + gProGuildStateRspInfo.getNextTs() + " guildStateList:" + gProGuildStateRspInfo.getGuildStatusList().size(), q16);
                            iGProFetchChannelListStateCallback.onFetchChannelListState(i16, str, gProGuildStateRspInfo);
                        }
                    });
                }
            });
        }
    }

    public String Ne(String str, long j3, int i3) {
        return QQGuildUtilApiImpl.INSTANCE.a(str, j3, i3);
    }

    public void Nf(String str, String str2, int i3, long j3, String str3, final IGProGetScheduleListNewCallback iGProGetScheduleListNewCallback) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getScheduleListNew", "", "guildId:" + str, i16);
        this.f266768a.getScheduleListNew(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, j3, str3, new IGProGetScheduleListNewCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.110
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleListNewCallback
            public void onGetScheduleListNew(final int i17, final String str4, final ArrayList<GProScheduleDayItem> arrayList, final String str5) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.110.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getScheduleListNew", "", i17, str4, "", q16);
                        iGProGetScheduleListNewCallback.onGetScheduleListNew(i17, str4, arrayList, str5);
                    }
                });
            }
        });
    }

    public void Nj(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelSpeakableRoleList", "call", "guildId=" + str + " channelId=" + str2 + " addRoleList=" + list + " removeRoleList=" + list2, i3);
        this.f266768a.setChannelSpeakableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bn
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.ii(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void Nk(String str, String str2, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "updateForumChannelSortMode", "", "guildId=" + str + " channelId=" + str2 + " sortMode=" + i3, i16);
        this.f266768a.updateForumChannelSortMode(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.u
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i17, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Si(q16, cdVar, i17, str3, gProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.engine.GProSdkGenWrapperImpl
    public void O0(String str, ArrayList<com.tencent.mobileqq.qqguildsdk.data.genc.da> arrayList, wh2.dm dmVar) {
        super.O0(str, arrayList, new e(dmVar));
    }

    public void Od(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.f fVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelLiveableMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelLiveableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelLiveableMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cb
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelLiveableMemberListCallback
            public final void onFetchChannelLiveableMemberList(int i17, String str3, int i18, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.zg(q16, fVar, i17, str3, i18, z16, bArr2, arrayList);
            }
        });
    }

    public void Oe(int i3, String str, byte[] bArr, final vh2.bi biVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getBindClientService", "", "serviceType: " + i3 + ", clientID: " + str + ", cookie: " + bArr, i16);
        this.f266768a.getBindClientService(i3, com.tencent.mobileqq.qqguildsdk.util.g.M0(str), bArr, new IGProGetClientAccountCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.85
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetClientAccountCallback
            public void onGetClientAccount(final int i17, final String str2, final byte[] bArr2, final boolean z16, final ArrayList<GProClientAccount> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.85.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getBindClientService", "", i17, str2, "cookie: " + bArr2 + ", isEnd: " + z16 + ", clientAccount: " + arrayList, q16);
                        biVar.onGetClientAccount(i17, str2, bArr2, z16, com.tencent.mobileqq.qqguildsdk.util.g.y0(arrayList));
                    }
                });
            }
        });
    }

    public void Of(String str, String str2, String str3, int i3, byte[] bArr, final IGProGetScheduleUsersCallback iGProGetScheduleUsersCallback) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getScheduleUsers", "", "guildId:" + str, i16);
        this.f266768a.getScheduleUsers(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), i3, bArr, new IGProGetScheduleUsersCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.113
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetScheduleUsersCallback
            public void onGetScheduleUsers(final int i17, final String str4, final ArrayList<GProScheduleUser> arrayList, final boolean z16, final byte[] bArr2, final int i18, final int i19) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.113.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getScheduleUsers", "", i17, str4, "", q16);
                        iGProGetScheduleUsersCallback.onGetScheduleUsers(i17, str4, arrayList, z16, bArr2, i18, i19);
                    }
                });
            }
        });
    }

    public void Oj(String str, String str2, long j3, int i3, final IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelTopMsg", "", "guildId:" + str + " channelId:" + str2 + " msgSeq:" + j3 + " updateType:" + i3, i16);
        this.f266768a.setChannelTopMsg(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, i3, new IGProSetChannelTopMsgCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.aj
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelTopMsgCallback
            public final void onSetChannelTopMsg(int i17, String str3, long j16, long j17) {
                GProSdkWrapperImpl.this.ki(q16, iGProSetChannelTopMsgCallback, i17, str3, j16, j17);
            }
        });
    }

    public void Ok(String str, String str2, int i3, boolean z16, int i16, final vh2.dh dhVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "voiceChannelAuth0x10b6", "", "guildId=" + str + " channelId=" + str2, i17);
        this.f266768a.voiceChannelAuth0x10b6(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, z16, i16, new IGProVoiceChannelAuthCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bo
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProVoiceChannelAuthCallback
            public final void onVoiceChannelAuth(int i18, String str3, int i19, GProSecurityResult gProSecurityResult, String str4, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Ui(q16, dhVar, i18, str3, i19, gProSecurityResult, str4, arrayList);
            }
        });
    }

    public void Pd(String str, String str2, @NonNull final xh2.g gVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelLiveableRoleList", "call", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.fetchChannelLiveableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchChannelLiveableRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cl
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelLiveableRoleListCallback
            public final void onFetchChannelLiveableRoleList(int i16, String str3, int i17, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Bg(q16, gVar, i16, str3, i17, arrayList);
            }
        });
    }

    public ArrayList<GProCategoryChannelInfoList> Pe(long j3) {
        if (j3 == 0) {
            QLog.e("GProSdkWrapperImpl", 1, "getCategoryChannelInfoList error : guildId is zero");
            return new ArrayList<>();
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getCategoryChannelInfoList error : kernelGuildService is null");
            return new ArrayList<>();
        }
        return iKernelGuildService.getCategoryChannelInfoList(j3);
    }

    public void Pf(String str, String str2, long j3, long j16, final IGProGetSchedulesStatusCallback iGProGetSchedulesStatusCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getScheduleList", "", "guildId:" + str, i3);
        this.f266768a.getSchedulesStatus(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, j16, new IGProGetSchedulesStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.111
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetSchedulesStatusCallback
            public void onGetSchedulesStatus(final int i16, final String str3, final ArrayList<GProScheduleDate> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.111.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getScheduleList", "", i16, str3, "", q16);
                        iGProGetSchedulesStatusCallback.onGetSchedulesStatus(i16, str3, arrayList);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pj(String str, String str2, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelVisible", "call", "guildId=" + str + " channelId=" + str2 + " type=" + i3, i16);
        this.f266768a.setChannelVisible(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cm
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i17, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.mi(q16, cdVar, i17, str3, gProSecurityResult);
            }
        });
    }

    public void Qd(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.h hVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelSpeakableMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelSpeakableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelSpeakableMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bg
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelSpeakableMemberListCallback
            public final void onFetchChannelSpeakableMemberList(int i17, String str3, int i18, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Dg(q16, hVar, i17, str3, i18, z16, bArr2, arrayList);
            }
        });
    }

    public void Qj(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelVisibleMemberList", "call", "guildId=" + str + " channelId=" + str2 + " addUserList=" + list + " removeUserList=" + list2, i3);
        this.f266768a.setChannelVisibleMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bw
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.oi(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void Rd(String str, String str2, @NonNull final xh2.i iVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelSpeakableRoleList", "call", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.fetchChannelSpeakableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchChannelSpeakableRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bl
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelSpeakableRoleListCallback
            public final void onFetchChannelSpeakableRoleList(int i16, String str3, int i17, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Fg(q16, iVar, i16, str3, i17, arrayList);
            }
        });
    }

    public String Rf() {
        return this.f268561h;
    }

    public void Rj(String str, String str2, @Nullable List<String> list, @Nullable List<String> list2, @NonNull final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setChannelVisibleRoleList", "call", "guildId=" + str + " channelId=" + str2 + " addRoleList=" + list + " removeRoleList=" + list2, i3);
        this.f266768a.setChannelVisibleRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cq
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.qi(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void Sd(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.j jVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelUnlivableMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelUnlivableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelUnlivableMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.b
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnlivableMemberListCallback
            public final void onFetchChannelUnlivableMemberList(int i17, String str3, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Hg(q16, jVar, i17, str3, z16, bArr2, arrayList);
            }
        });
    }

    public com.tencent.mobileqq.qqguildsdk.data.bg Se(String str, String str2) {
        if (this.f266768a == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[gpro_sdk] getCategoryPermission", new NullPointerException("kernelGuildService == null"));
            return new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet());
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet(this.f266768a.getCategoryPermission(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2))));
    }

    public ArrayList<GProChannel> Sf(long j3, int i3) {
        if (j3 == 0) {
            QLog.e("GProSdkWrapperImpl", 1, "getSpecificTypeChannelList error : guildId is zero");
            return new ArrayList<>();
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getSpecificTypeChannelList error : kernelGuildService is null");
            return new ArrayList<>();
        }
        return iKernelGuildService.getSpecificTypeChannelList(j3, i3);
    }

    public void Sj(String str, int i3, int i16, final vh2.cu cuVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setClientShowConfig", "", "clientId: " + str + ", configId: " + i3 + ", showOff: " + i16, i17);
        this.f266768a.setClientShowConfig(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), i3, i16, new IGProSetClientShowConfigCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.87
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetClientShowConfigCallback
            public void onSetClientShowConfig(final int i18, final String str2, final int i19, final int i26, final int i27) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.87.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setClientShowConfig", "", i18, str2, "clientId: " + i19 + ", configId: " + i26 + ", configStatus: " + i27, q16);
                        cuVar.a(i18, str2, com.tencent.mobileqq.qqguildsdk.util.g.W0(i19), i26, i27);
                    }
                });
            }
        });
    }

    public void Td(String str, String str2, @NonNull final xh2.k kVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelUnlivableRoleList", "call", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.fetchChannelUnlivableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchChannelUnlivableRoleListCallback(q16, kVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bb

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f269686b;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnlivableRoleListCallback
            public final void onFetchChannelUnlivableRoleList(int i16, String str3, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Jg(this.f269686b, null, i16, str3, arrayList);
            }
        });
    }

    public void Te(String str, String str2, vh2.aw awVar) {
        this.f266768a.getChannelHeartbeat(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new c(awVar));
    }

    public void Tf(final byte[] bArr, final vh2.bj bjVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getUnBindClientServiceV2", "", "cookie: " + bArr, i3);
        GProGetUnbindClientReq gProGetUnbindClientReq = new GProGetUnbindClientReq();
        gProGetUnbindClientReq.cookie = bArr;
        this.f266768a.getUnBindClientServiceV2(gProGetUnbindClientReq, new IGProGetUnbindClientCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.86
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUnbindClientCallback
            public void onResult(final int i16, final String str, final GProGetUnbindClientRsp gProGetUnbindClientRsp) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.86.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getBindClientService", "", i16, str, "cookie: " + bArr + ", isEnd: " + gProGetUnbindClientRsp.isEnd + ", unbindClientInfo: " + gProGetUnbindClientRsp.unbindClients, q16);
                        AnonymousClass86 anonymousClass86 = AnonymousClass86.this;
                        vh2.bj bjVar2 = bjVar;
                        int i17 = i16;
                        String str2 = str;
                        byte[] bArr2 = bArr;
                        GProGetUnbindClientRsp gProGetUnbindClientRsp2 = gProGetUnbindClientRsp;
                        bjVar2.onGetClientAccount(i17, str2, bArr2, gProGetUnbindClientRsp2.isEnd, com.tencent.mobileqq.qqguildsdk.util.g.s(gProGetUnbindClientRsp2.unbindClients));
                    }
                });
            }
        });
    }

    public void Tj(String str, boolean z16, final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setDirectMsgBlack", "", "tinyId=" + str + " isBlack=" + z16, i3);
        this.f266768a.setDirectMsgBlack(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.f
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.si(q16, cdVar, i16, str2, gProSecurityResult);
            }
        });
    }

    public void Ud(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.l lVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelUnspeakableMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelUnspeakableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelUnspeakableMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ef
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnspeakableMemberListCallback
            public final void onFetchChannelUnspeakableMemberList(int i17, String str3, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Lg(q16, lVar, i17, str3, z16, bArr2, arrayList);
            }
        });
    }

    public HashSet<String> Ue(String str) {
        HashSet<String> hashSet = new HashSet<>();
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getChannelIds error : kernelGuildService is null");
            return hashSet;
        }
        Iterator<GProCategoryChannelIdList> it = iKernelGuildService.getCategoryChannelIdList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str)).iterator();
        while (it.hasNext()) {
            Iterator<Long> it5 = it.next().getChannelList().iterator();
            while (it5.hasNext()) {
                hashSet.add(com.tencent.mobileqq.qqguildsdk.util.g.X0(it5.next().longValue()));
            }
        }
        return hashSet;
    }

    public void Uf(String str, long j3, boolean z16, int i3, vh2.br brVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getUserList", SensorJsPlugin.SENSOR_INTERVAL_UI, "guildId \uff1a" + str + ", count : " + j3, i16);
        new hm(this.f266768a).g(str, j3, z16, i3, brVar);
    }

    public void Uj(int i3, boolean z16, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setDirectMsgNotifyForGuild", "", "notifyType=" + i3 + " isNotify=" + z16, i16);
        this.f266768a.setDirectMsgNotifyForGuild(i3, z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ee
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i17, String str, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.ui(q16, cdVar, i17, str, gProSecurityResult);
            }
        });
    }

    public void Vd(String str, String str2, @NonNull final xh2.m mVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelUnspeakableRoleList", "call", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.fetchChannelUnspeakableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchChannelUnspeakableRoleListCallback(q16, mVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bu

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f269738b;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelUnspeakableRoleListCallback
            public final void onFetchChannelUnspeakableRoleList(int i16, String str3, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Ng(this.f269738b, null, i16, str3, arrayList);
            }
        });
    }

    @NonNull
    public HashMap<Long, ArrayList<Long>> Ve(ArrayList<Long> arrayList, ArrayList<Integer> arrayList2) {
        GProGetChannelIdsWithGuildIdsFromCacheReq gProGetChannelIdsWithGuildIdsFromCacheReq = new GProGetChannelIdsWithGuildIdsFromCacheReq(arrayList, arrayList2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getChannelInfo error : kernelGuildService is null");
            return new HashMap<>();
        }
        HashMap<Long, ArrayList<Long>> channelIdsWithGuildIdsFromCache = iKernelGuildService.getChannelIdsWithGuildIdsFromCache(gProGetChannelIdsWithGuildIdsFromCacheReq);
        if (channelIdsWithGuildIdsFromCache == null) {
            return new HashMap<>();
        }
        return channelIdsWithGuildIdsFromCache;
    }

    public void Vf(String str, Object obj, boolean z16, int i3, @NonNull vh2.bl blVar) {
        GProUserListPaginationRequest.j(this.f266768a).h(z16).k(100L).i(str, obj, i3, blVar);
    }

    public void Vi(String str, String str2, final vh2.bz bzVar) {
        if (this.f266768a == null) {
            hj();
            return;
        }
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadGProUserProfileInfo", SensorJsPlugin.SENSOR_INTERVAL_UI, "guildId \uff1a " + str + "\uff0c tinyId \uff1a " + str2, i3);
        this.f266768a.LoadGuildUserProfileInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProLoadGuildUserProfileCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.22
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadGuildUserProfileCallback
            public void onLoadGuildUserProfileInfo(final int i16, final String str3, long j3, long j16, final GProGuildUserProfile gProGuildUserProfile) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.22.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.data.cf cfVar;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadGProUserProfileInfo", SensorJsPlugin.SENSOR_INTERVAL_UI, i16, str3, null, q16);
                        vh2.bz bzVar2 = bzVar;
                        int i17 = i16;
                        String str4 = str3;
                        GProGuildUserProfile gProGuildUserProfile2 = gProGuildUserProfile;
                        if (gProGuildUserProfile2 != null) {
                            cfVar = new com.tencent.mobileqq.qqguildsdk.data.cf(gProGuildUserProfile2);
                        } else {
                            cfVar = new com.tencent.mobileqq.qqguildsdk.data.cf(com.tencent.mobileqq.qqguildsdk.util.g.b1());
                        }
                        bzVar2.a(i17, str4, cfVar);
                    }
                });
            }
        });
    }

    public void Vj(String str, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setDirectMsgNotifyType", "", "peerTinyId=" + str + " notifyType=" + i3, i16);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this.f266768a.setDirectMsgNotify(O0, z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ej
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i17, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.wi(q16, cdVar, i17, str2, gProSecurityResult);
            }
        });
    }

    public void Wd(String str, String str2, int i3, @NonNull final xh2.n nVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelUserPermission", "call", "guildId=" + str + " channelId=" + str2 + " sourceType=" + i3, i16);
        this.f266768a.fetchChannelUserPermission(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProChannelUserPermissionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ch
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProChannelUserPermissionCallback
            public final void onFetchChannelUserPermission(int i17, String str3, int i18) {
                GProSdkWrapperImpl.this.Pg(q16, nVar, i17, str3, i18);
            }
        });
    }

    @Nullable
    public IGProChannelInfo We(long j3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getChannelInfo error : kernelGuildService is null");
            return null;
        }
        GProChannel channelInfo = iKernelGuildService.getChannelInfo(j3);
        if (channelInfo == null) {
            return null;
        }
        return new GProChannelInfo(channelInfo);
    }

    public void Wf(int i3, final vh2.bs bsVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getUserLiveInfo", "", "liveType = " + i3, i16);
        this.f266768a.getUserLiveInfo(i3, new IGProGetUserLiveInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.38
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserLiveInfoCallback
            public void onGetUserLiveInfoResult(final int i17, final String str, final GProUserLiveRoomInfo gProUserLiveRoomInfo) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getUserLiveInfo", "", i17, str, gProUserLiveRoomInfo.toString(), q16);
                        bsVar.a(i17, str, new com.tencent.mobileqq.qqguildsdk.data.fo(gProUserLiveRoomInfo));
                    }
                });
            }
        });
    }

    public void Wi(String str, String str2, final di2.h hVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadMemberRoleList", "call", "guildId: " + str + ", tinyId: " + str2, i3);
        this.f266768a.loadMemberRoles(O0, O02, new IGProLoadMemberRolesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.97
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadMemberRolesCallback
            public void onLoadMemberRoles(final int i16, final String str3, final ArrayList<GProGuildRole> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.97.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<GProGuildRoleInfo> v3 = com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadMemberRoleList", "callback", i16, str3, "roles: " + v3.toString(), q16);
                        hVar.a(i16, str3, v3);
                    }
                });
            }
        });
    }

    public void Wj(int i3, int i16, final vh2.cd cdVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setDirectMsgStatus", "", "status=" + i3, i17);
        this.f266768a.setDirectMsgStatus(i3, i16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cv
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i18, String str, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.yi(q16, cdVar, i18, str, gProSecurityResult);
            }
        });
    }

    public void Xd(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.o oVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelVisibleAllMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelVisibleAllMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelVisibleMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ck
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleMemberListCallback
            public final void onFetchChannelVisibleMemberList(int i17, String str3, int i18, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Rg(q16, oVar, i17, str3, i18, z16, bArr2, arrayList);
            }
        });
    }

    public com.tencent.mobileqq.qqguildsdk.data.bg Xe(String str, String str2) {
        if (this.f266768a == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[gpro_sdk] getChannelPermission", new NullPointerException("kernelGuildService == null"));
            return new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet());
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet(this.f266768a.getChannelPermission(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2))));
    }

    public void Xi(String str, List<String> list, final di2.f fVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadUserInfo", "ui-for fetchUserInfo", "guildId \uff1a" + str + "\uff0c tinydList \uff1a " + list, i3);
        this.f266768a.loadUserInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), new IGProGetUserInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.3
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserInfoCallback
            public void onGetUserInfo(final int i16, final String str2, final ArrayList<GProUser> arrayList, final ArrayList<Long> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i17;
                        int i18 = i16;
                        String str3 = str2;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("sucList size : ");
                        ArrayList arrayList3 = arrayList;
                        if (arrayList3 != null) {
                            i17 = arrayList3.size();
                        } else {
                            i17 = 0;
                        }
                        sb5.append(i17);
                        sb5.append(", failList \uff1a");
                        sb5.append(arrayList2);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadUserInfo", "Get DB member list", i18, str3, sb5.toString(), q16);
                        fVar.a(i16, str2, com.tencent.mobileqq.qqguildsdk.util.g.X(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList2));
                    }
                });
            }
        });
    }

    public void Xj(final int i3, final vh2.k kVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setFeedCommentsNotifySwitch", "", "switchType=" + i3, i16);
        this.f266768a.setFeedCommentsNotifySwitch(i3, new IGProSetFeedCommentsNotifySwitchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.eh
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetFeedCommentsNotifySwitchCallback
            public final void onResult(int i17, String str) {
                GProSdkWrapperImpl.this.Ai(q16, kVar, i3, i17, str);
            }
        });
    }

    public void Yd(String str, String str2, int i3, @NonNull byte[] bArr, @NonNull final xh2.o oVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelVisibleMemberList", "call", "guildId=" + str + " channelId=" + str2, i16);
        this.f266768a.fetchChannelVisibleMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, bArr, new IGProFetchChannelVisibleMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bf
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleMemberListCallback
            public final void onFetchChannelVisibleMemberList(int i17, String str3, int i18, boolean z16, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Sg(q16, oVar, i17, str3, i18, z16, bArr2, arrayList);
            }
        });
    }

    public void Ye(String str, String str2, final IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getChannelTopMsgState", "", "guildId:" + str + " channelId:" + str2, i3);
        this.f266768a.getChannelTopMsgState(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProGetChannelTopMsgStateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ac
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTopMsgStateCallback
            public final void onGetChannelTopMsgState(int i16, String str3, boolean z16, long j3) {
                GProSdkWrapperImpl.this.Eh(q16, iGProGetChannelTopMsgStateCallback, i16, str3, z16, j3);
            }
        });
    }

    public void Yi(String str, long j3, vh2.br brVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.loadUserList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), j3, new IGProGetUserListCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "loadUserList", "call", "guildId: " + str + " count:" + j3, i3), brVar, str) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.27

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268792a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f268793b;

            {
                this.f268793b = str;
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserListCallback
            public void onGetUserList(final int i16, final String str2, boolean z16, boolean z17, final byte[] bArr, final ArrayList<GProUser> arrayList, final ArrayList<GProUser> arrayList2, final ArrayList<GProUser> arrayList3) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.27.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadUserList", "callback", i16, str2, "adminList.size=" + arrayList.size() + ", normalUserList.size=" + arrayList2.size() + ", robotList.size=" + arrayList3.size(), AnonymousClass27.this.f268792a);
                        getClass();
                    }
                });
            }
        });
    }

    public void Yj(int i3, final vh2.cc ccVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGender", SensorJsPlugin.SENSOR_INTERVAL_UI, " gender \uff1a " + i3, i16);
        this.f266768a.setGender(i3, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.31
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public void onResult(final int i17, final String str) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.31.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGender", "", i17, str, "", q16);
                        ccVar.onResult(i17, str);
                    }
                });
            }
        });
    }

    public void Zd(String str, String str2, @NonNull final wh2.aj ajVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchChannelVisibleRoleList", "call", "guildId=" + str + " channelId=" + str2, i3);
        this.f266768a.fetchChannelVisibleRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchChannelVisibleRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ce
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchChannelVisibleRoleListCallback
            public final void onFetchChannelVisibleRoleList(int i16, String str3, int i17, ArrayList arrayList) {
                GProSdkWrapperImpl.this.Vg(q16, ajVar, i16, str3, i17, arrayList);
            }
        });
    }

    public int Ze(String str, String str2) {
        return this.f266768a.getChannelUserPermission(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
    }

    public void Zf(int i3, String str, boolean z16, final vh2.bu buVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", true, "sdkWrapper interface", "initGetNoticeList", SensorJsPlugin.SENSOR_INTERVAL_UI, "noticeType:" + i3 + "guildId:" + str + ", forceRefresh:" + z16, i16);
        this.f266768a.initGetNoticeList(i3, com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, new IGProInitGetNoticeListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.56
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProInitGetNoticeListCallback
            public void onInitGetNoticeList(final int i17, final String str2, @NonNull final ArrayList<GProNotice> arrayList, final int i18, final boolean z17, final int i19) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.56.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", true, "sdkWrapper callback", "on initGetNoticeList", "", i17, str2, "noticeList:" + arrayList.size() + " listOffset:" + i18 + " isEnd:" + z17 + " unreadCnt:" + i19, q16);
                        List<com.tencent.mobileqq.qqguildsdk.data.co> mf5 = GProSdkWrapperImpl.this.mf(arrayList);
                        Iterator<com.tencent.mobileqq.qqguildsdk.data.co> it = mf5.iterator();
                        while (it.hasNext()) {
                            com.tencent.mobileqq.qqguildsdk.util.h.c("GProSdkWrapperImpl", false, "sdkWrapper callback", "initGetNoticeList", "", 0, "", "noticeInfo:" + it.next().toString());
                        }
                        buVar.a(i17, str2, i18, z17, i19, mf5);
                    }
                });
            }
        });
    }

    public void Zj(String str, String str2, final vh2.cv cvVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildClientId", "", "guildId:" + str + ", clientId:" + str2, i3);
        this.f266768a.setGuildClientId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.M0(str2), new IGProSetGuildClientIdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.82
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildClientIdCallback
            public void onSetGuildClientId(final int i16, final String str3, final long j3, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.82.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildClientId", "", i16, str3, "", q16);
                        cvVar.a(i16, str3, com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.W0(i17));
                    }
                });
            }
        });
    }

    public void ae(String str, String str2, long j3, long j16, long j17, long j18, final vh2.p pVar) {
        if (this.f266768a == null) {
            hj();
            return;
        }
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchComments", "", "guildId:" + str + " channelId:" + str2 + " rootMsgSeq:" + j3 + " msgSeq:" + j16 + " upCnt:" + j17 + " downCnt:" + j18, i3);
        this.f266768a.fetchComments(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, j16, j17, j18, new IGProFetchCommentsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bi
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchCommentsCallback
            public final void onFetchComments(int i16, String str3, long j19, long j26, ArrayList arrayList, boolean z16, boolean z17) {
                GProSdkWrapperImpl.this.Xg(q16, pVar, i16, str3, j19, j26, arrayList, z16, z17);
            }
        });
    }

    public void af(int i3, byte[] bArr, final vh2.bk bkVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "getClientInfoList", "", "", i16);
        this.f266768a.getClientInfoList(i3, bArr, new IGProGetClientInfoListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.79
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetClientInfoListCallback
            public void onGetClientInfoList(final int i17, final String str, final int i18, final ArrayList<GProClientInfo> arrayList, final boolean z16, final byte[] bArr2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.79.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getClientInfoList", "", i17, str, "clientInfoList: " + arrayList + ", isEnd: " + z16 + ", cookie: " + bArr2, q16);
                        bkVar.a(i17, str, i18, com.tencent.mobileqq.qqguildsdk.util.g.w0(arrayList), z16, bArr2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ag(boolean z16) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "initGuildAndChannelList", "sdk-init", "refresh=" + z16, i3);
        bi2.a.d("load_guild_list_task", "sdk_init_guild_list_start_event");
        this.f266768a.loadGuildAndChannels(z16, new IGProLoadGuildAndChannelsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.e
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadGuildAndChannelsCallback
            public final void onLoadGuildAndChannels(ArrayList arrayList) {
                GProSdkWrapperImpl.this.Kh(arrayList);
            }
        });
    }

    public void aj(String str, List<String> list, List<String> list2, final wh2.dv dvVar) {
        this.f266768a.setGuildSpeakableMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.m
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i3, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Oh(dvVar, i3, str2, gProSecurityResult);
            }
        });
    }

    public void ak(String str, int i3, final vh2.cw cwVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", true, "sdkWrapper interface", "setGuildCoverFontColorId", SensorJsPlugin.SENSOR_INTERVAL_UI, "guildId: " + str + " coverFontColorId: " + i3, i16);
        this.f266768a.setGuildCoverFontColorId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i3, new IGProSetGuildCoverFontColorIdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.55
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildCoverFontColorIdCallback
            public void onSetGuildCoverFontColorId(final int i17, final String str2, final long j3, final int i18) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.55.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", true, "sdkWrapper callback", "on setGuildCoverFontColorId", "", i17, str2, "set guild cover font color id guildId: " + j3 + " coverFontColorId:" + i18, q16);
                        cwVar.a(i17, str2, com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), i18);
                    }
                });
            }
        });
    }

    public void be(String str, final vh2.q qVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchDirectMsgBlack", "", "tinyId=" + str, i3);
        this.f266768a.fetchDirectMsgBlack(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchDirectMsgBlackCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cn
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchDirectMsgBlackCallback
            public final void onFetchDirectMsgBlackCallback(int i16, String str2, boolean z16) {
                GProSdkWrapperImpl.this.Zg(q16, qVar, i16, str2, z16);
            }
        });
    }

    public ArrayList<Long> bf() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getGuildListFromCache error : kernelGuildService is null");
            return new ArrayList<>();
        }
        return iKernelGuildService.getEffectGuildIdsFromCache();
    }

    public boolean bg() {
        return this.f268564k;
    }

    public void bj(String str, List<String> list, List<String> list2, final wh2.dv dvVar) {
        this.f266768a.setGuildSpeakableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bq
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i3, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Qh(dvVar, i3, str2, gProSecurityResult);
            }
        });
    }

    public void bk(ArrayList<String> arrayList, final vh2.cy cyVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int m3 = com.tencent.mobileqq.qqguildsdk.util.h.m("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildListSort", "call", i3);
        ArrayList<Long> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(com.tencent.mobileqq.qqguildsdk.util.g.O0(it.next())));
        }
        this.f266768a.setGuildListSort(arrayList2, new IGProSetGuildListSortCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.26
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildListSortCallback
            public void onSetGuildListSort(final int i16, final String str) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildListSort", "callback", i16, str, "", m3);
                        cyVar.onSetGuildListSort(i16, str);
                    }
                });
            }
        });
    }

    public void ce(final vh2.r rVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int l3 = com.tencent.mobileqq.qqguildsdk.util.h.l("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchDirectMsgStatus", i3);
        this.f266768a.fetchDirectMsgStatus(new IGProFetchDirectMsgStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cj
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchDirectMsgStatusCallback
            public final void onFetchDirectMsgStatusCallback(int i16, String str, int i17, int i18, int i19) {
                GProSdkWrapperImpl.this.bh(l3, rVar, i16, str, i17, i18, i19);
            }
        });
    }

    public GProFaceAuthInfo cf() {
        GProFaceAuthInfo faceAuthInfo = this.f266768a.getFaceAuthInfo();
        if (faceAuthInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getFaceAuthInfo return null");
        }
        return faceAuthInfo;
    }

    public boolean cg() {
        return this.f268563j;
    }

    public void cj(String str, GProGuildSpeakRuleData gProGuildSpeakRuleData, final wh2.dv dvVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        GproGuildSpeakableRule gproGuildSpeakableRule = new GproGuildSpeakableRule(gProGuildSpeakRuleData.getIsProhibitRedEnvelope(), gProGuildSpeakRuleData.getIsProhibitLink(), gProGuildSpeakRuleData.getIsProhibitQrCode(), gProGuildSpeakRuleData.getIsProhibiteAdvertise(), gProGuildSpeakRuleData.a());
        gproGuildSpeakableRule.isProhibitSuspectedRiskFeed = gProGuildSpeakRuleData.getIsProhibitSuspectedRiskFeed();
        gproGuildSpeakableRule.isProhibitDatingFeed = gProGuildSpeakRuleData.getIsProhibitDatingFeed();
        this.f266768a.setGuildSpeakableRule(O0, gproGuildSpeakableRule, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.du
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i3, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Sh(dvVar, i3, str2, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ck(String str, String str2, final vh2.cx cxVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildName", " ui", "guildId \uff1a " + str + "\uff0c name \uff1a " + str2, i3);
        this.f266768a.setGuildName(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), str2, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.29
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.29.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildName", SensorJsPlugin.SENSOR_INTERVAL_UI, i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass29 anonymousClass29 = AnonymousClass29.this;
                        cxVar.a(i16, null, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void de(final vh2.k kVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int m3 = com.tencent.mobileqq.qqguildsdk.util.h.m("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchFeedsNotifySwitch", "", i3);
        this.f266768a.fetchFeedCommentsNotifySwitch(new IGProGetFeedCommentsNotifySwitchCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.el
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsNotifySwitchCallback
            public final void onResult(int i16, String str, int i17) {
                GProSdkWrapperImpl.this.ch(m3, kVar, i16, str, i17);
            }
        });
    }

    public boolean dg(String str, String str2) {
        return this.f266768a.isQQMsgListChannel(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
    }

    public void dj(String str, String str2, String str3, int i3, final IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "modifyScheduleInviteStatus", "", "guildId:" + str, i16);
        this.f266768a.modifyScheduleInviteStatus(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), i3, new IGProModifyScheduleInviteStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.112
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProModifyScheduleInviteStatusCallback
            public void onModifyInviteStatus(final int i17, final String str4) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.112.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "modifyScheduleInviteStatus", "", i17, str4, "", q16);
                        iGProModifyScheduleInviteStatusCallback.onModifyInviteStatus(i17, str4);
                    }
                });
            }
        });
    }

    public void dk(String str, String str2, final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildProfile", "", "guildId \uff1a" + str + ", profile:" + str2, i3);
        this.f266768a.setGuildProfile(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), str2, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.53
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.53.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildProfile", "", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass53 anonymousClass53 = AnonymousClass53.this;
                        cdVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void ee(com.tencent.mobileqq.qqguildsdk.data.cj cjVar, String str, String str2, final vh2.u uVar) {
        com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoByAppIdentity", "", "identity\uff1a" + cjVar.toString() + ", guildOpenId: " + str + "\uff0c rawUrl \uff1a " + str2);
        this.f266768a.fetchGuildInfoByAppIdentity(com.tencent.mobileqq.qqguildsdk.util.g.c0(cjVar), str, str2, new IGProFetchGuildInfoByAppIdentityCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.44
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildInfoByAppIdentityCallback
            public void onFetchGuildInfoByAppIdentity(final int i3, final String str3, final GProGuildJoin gProGuildJoin, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.44.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoByAppIdentity", "", i3, str3, "guildJoin \uff1a" + gProGuildJoin.toString() + GProSdkWrapperImpl.this.Qf(gProSecurityResult));
                        uVar.a(i3, str3, new com.tencent.mobileqq.qqguildsdk.data.cm(gProGuildJoin), GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void eg(String str, String str2, ArrayList<String> arrayList, final vh2.bw bwVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "exitAudioChannel", "", "guildId \uff1a" + str + "\uff0c channelId \uff1a " + str2 + "tinyIdLst:" + arrayList, i3);
        this.f266768a.kickAudioChannelUsers(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(arrayList), new IGProKickChannelMemberCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.36
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProKickChannelMemberCallback
            public void onKickChannelMembers(final int i16, final String str3, final GProSecurityResult gProSecurityResult, final ArrayList<GProResult> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.36.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "kickAudioChannelUsers", "", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass36 anonymousClass36 = AnonymousClass36.this;
                        bwVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult), GProSdkWrapperImpl.this.gf(arrayList2));
                    }
                });
            }
        });
    }

    public void ej(int i3, String str, Object... objArr) {
        this.f268557d.notifyChange(i3, str, objArr);
    }

    public void ek(String str, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildQRCodePeriod", "", "guildId \uff1a" + str + ", QRCodePeriod:" + i3, i16);
        this.f266768a.setGuildQRCodePeriod(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.54
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str2, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.54.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildQRCodePeriod", "", i17, str2, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass54 anonymousClass54 = AnonymousClass54.this;
                        cdVar.a(i17, str2, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void fe(String str, final vh2.aa aaVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoByInviteCode", SensorJsPlugin.SENSOR_INTERVAL_UI, "inviteCode \uff1a " + str, i3);
        this.f266768a.fetchInviteInfo(str, new IGProFetchInviteInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.33
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchInviteInfoCallback
            public void onFetchInviteInfo(final int i16, final String str2, final GProSecurityResult gProSecurityResult, final GProInviteInfo gProInviteInfo, final long j3) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.33.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        com.tencent.mobileqq.qqguildsdk.data.cl clVar;
                        int i17 = i16;
                        String str4 = str2;
                        StringBuilder sb5 = new StringBuilder();
                        if (gProInviteInfo != null) {
                            str3 = "getName \uff1a" + gProInviteInfo.getName() + ", getNickName \uff1a" + gProInviteInfo.getNickName();
                        } else {
                            str3 = "inviteInfo is null";
                        }
                        sb5.append(str3);
                        sb5.append(GProSdkWrapperImpl.this.Qf(gProSecurityResult));
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoByInviteCode", SensorJsPlugin.SENSOR_INTERVAL_UI, i17, str4, sb5.toString(), q16);
                        vh2.aa aaVar2 = aaVar;
                        int i18 = i16;
                        String str5 = str2;
                        GProInviteInfo gProInviteInfo2 = gProInviteInfo;
                        if (gProInviteInfo2 != null) {
                            clVar = new com.tencent.mobileqq.qqguildsdk.data.cl(gProInviteInfo2);
                        } else {
                            clVar = null;
                        }
                        aaVar2.a(i18, str5, clVar, GProSdkWrapperImpl.this.tf(gProSecurityResult), j3);
                    }
                });
            }
        });
    }

    public void fg(String str, List<String> list, boolean z16, @NonNull com.tencent.mobileqq.qqguildsdk.data.fm fmVar, final vh2.cd cdVar) {
        String str2 = "guildId:" + str + ", listSize:" + list.size() + ", toBlack:" + z16 + ", " + fmVar.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "kickGuildUser", "call", str2, i3);
        this.f266768a.kickGuildUser(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), z16, com.tencent.mobileqq.qqguildsdk.util.g.I(fmVar), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cp
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Mh(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void fj(int i3, int i16, com.tencent.mobileqq.qqguildsdk.data.fi fiVar, byte[] bArr) {
        if (He(i3, i16)) {
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "onServerPushMsg", " push msg to server", "msgType : " + i3 + ", subType :" + i16);
        this.f266768a.onServerPushMsg(i3, i16, com.tencent.mobileqq.qqguildsdk.util.g.y(fiVar), bArr);
    }

    public void fk(String str, long j3, final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildShutUp", "", "guildId=" + str + " expireTime=" + j3, i3);
        this.f266768a.setGuildShutUp(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), j3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.t
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Ci(q16, cdVar, i16, str2, gProSecurityResult);
            }
        });
    }

    public void ge(String str, String str2, String str3, int i3, vh2.z zVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        this.f266768a.fetchInviteInfo0x10b4(str, str2, str3, i3, new IGProFetchInviteInfo0x10b4Callback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildInfoByInviteCodeAndContentID", SensorJsPlugin.SENSOR_INTERVAL_UI, "inviteCode \uff1a " + str + ", contentID \uff1a " + str2, i16), zVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.34

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268851a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchInviteInfo0x10b4Callback
            public void onFetchInviteInfo(final int i17, final String str4, final GProSecurityResult gProSecurityResult, final GProInviteInfo gProInviteInfo, final GProBusinessData gProBusinessData, final GProLinkDetailInfo gProLinkDetailInfo, final GProCmd0x10b4RspExtendData gProCmd0x10b4RspExtendData) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.34.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str5;
                        int i18 = i17;
                        String str6 = str4;
                        StringBuilder sb5 = new StringBuilder();
                        if (gProInviteInfo != null) {
                            str5 = "getName \uff1a" + gProInviteInfo.getName() + ", getNickName \uff1a" + gProInviteInfo.getNickName();
                        } else {
                            str5 = "inviteInfo is null";
                        }
                        sb5.append(str5);
                        sb5.append(GProSdkWrapperImpl.this.Qf(gProSecurityResult));
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoByInviteCodeAndContentID", SensorJsPlugin.SENSOR_INTERVAL_UI, i18, str6, sb5.toString(), AnonymousClass34.this.f268851a);
                        GProInviteInfo gProInviteInfo2 = gProInviteInfo;
                        if (gProInviteInfo2 != null) {
                            new com.tencent.mobileqq.qqguildsdk.data.cl(gProInviteInfo2).c(gProBusinessData);
                        }
                        GProLinkDetailInfo gProLinkDetailInfo2 = gProLinkDetailInfo;
                        if (gProLinkDetailInfo2 != null) {
                            new com.tencent.mobileqq.qqguildsdk.data.ba(gProLinkDetailInfo2);
                        }
                        GProCmd0x10b4RspExtendData gProCmd0x10b4RspExtendData2 = gProCmd0x10b4RspExtendData;
                        if (gProCmd0x10b4RspExtendData2 != null) {
                            new com.tencent.mobileqq.qqguildsdk.data.m(gProCmd0x10b4RspExtendData2);
                        }
                        getClass();
                        GProSdkWrapperImpl.this.tf(gProSecurityResult);
                        throw null;
                    }
                });
            }
        });
    }

    public void gk(String str, com.tencent.mobileqq.qqguildsdk.data.fc fcVar, final wh2.dv dvVar) {
        this.f266768a.setGuildSpeakableThreshold(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new GProGuildSpeakableThreshold(fcVar.c(), fcVar.f(), fcVar.b(), fcVar.e(), fcVar.a(), fcVar.d()), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bh
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i3, String str2, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Ei(dvVar, i3, str2, gProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hd(final String str, final GuildSourceId guildSourceId, String str2, final vh2.bv bvVar) {
        Object valueOf;
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = guildSourceId;
        objArr[2] = str2;
        if (guildSourceId == null) {
            valueOf = "no sourceType because sourceId is null";
        } else {
            valueOf = Integer.valueOf(guildSourceId.p());
        }
        objArr[3] = valueOf;
        String format = String.format("guildId: %s, sourceId: %s, sig: %s, sourceType: %s", objArr);
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuild", SensorJsPlugin.SENSOR_INTERVAL_UI, format, i3);
        if (str != null && guildSourceId != null && guildSourceId.o() != null && guildSourceId.q() != null && str2 != null) {
            this.f266768a.addGuild(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.W(guildSourceId), str2, new IGProJoinGuildCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.8
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildCallback
                public void onJoinGuild(final int i16, final String str3, final GProJoinGuildResult gProJoinGuildResult) {
                    ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GProSecurityResult gProSecurityResult;
                            GProJoinGuildResult gProJoinGuildResult2 = gProJoinGuildResult;
                            if (gProJoinGuildResult2 != null) {
                                gProSecurityResult = gProJoinGuildResult2.getSecRet();
                            } else {
                                gProSecurityResult = null;
                            }
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            GProSdkWrapperImpl.this.Yf(i16, str, gProJoinGuildResult);
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "addGuild", SensorJsPlugin.SENSOR_INTERVAL_UI, i16, str3, "guildId \uff1a" + str + " sourceType: " + guildSourceId.p() + GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                            AnonymousClass8 anonymousClass82 = AnonymousClass8.this;
                            bvVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult), new GGProJoinGuildResult(gProJoinGuildResult));
                        }
                    });
                }
            });
        } else {
            this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    bvVar.a(-90, "parameter error", null, null);
                }
            });
        }
    }

    public void he(String str, @NonNull final vh2.w wVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchGuildSearchSwitch", "", "guild:" + str, i3);
        this.f266768a.fetchGuildSearchSwitch(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchGuildSearchSwitchCallback(q16, wVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ci

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f269778b;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSearchSwitchCallback
            public final void onFetchGuildSearchSwitch(int i16, String str2, int i17, String str3) {
                GProSdkWrapperImpl.this.fh(this.f269778b, null, i16, str2, i17, str3);
            }
        });
    }

    public ArrayList<IGProGuildInfo> hf() {
        ArrayList<IGProGuildInfo> arrayList = new ArrayList<>();
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getGuildListFromCache error : kernelGuildService is null");
            return arrayList;
        }
        Iterator<GProGuild> it = iKernelGuildService.getGroupGuildListFromCache().iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hj() {
        String str;
        AppRuntime appRuntime = this.f268558e.get();
        if (appRuntime == null) {
            str = "appRuntime=null";
        } else {
            str = "appRuntime.hash=" + appRuntime.hashCode() + ", account=" + appRuntime.getAccount();
        }
        com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, QLog.getStackTraceString(new IllegalStateException(str)));
    }

    public void hk(String str, boolean z16, final vh2.da daVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildTop", SensorJsPlugin.SENSOR_INTERVAL_UI, " guildId \uff1a " + str + "\uff0c isTop \uff1a " + z16, i3);
        this.f266768a.setGuildTop(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.16
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str2, GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildTop", SensorJsPlugin.SENSOR_INTERVAL_UI, i16, str2, null, q16);
                        daVar.a(i16, null, str2);
                    }
                });
            }
        });
    }

    public void id(com.tencent.mobileqq.qqguildsdk.data.az azVar, final vh2.bv bvVar) {
        String azVar2 = azVar.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "addGuildWithOption", SensorJsPlugin.SENSOR_INTERVAL_UI, azVar2, i3);
        final String c16 = azVar.c();
        final GuildSourceId e16 = azVar.e();
        if (c16 != null && e16 != null && e16.o() != null && e16.q() != null && azVar.d() != null && azVar.b() != null && azVar.a() != null) {
            this.f266768a.addGuildWithOption(com.tencent.mobileqq.qqguildsdk.util.g.l(azVar), new IGProJoinGuildCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.10
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProJoinGuildCallback
                public void onJoinGuild(final int i16, final String str, final GProJoinGuildResult gProJoinGuildResult) {
                    ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GProSecurityResult gProSecurityResult;
                            GProJoinGuildResult gProJoinGuildResult2 = gProJoinGuildResult;
                            if (gProJoinGuildResult2 != null) {
                                gProSecurityResult = gProJoinGuildResult2.getSecRet();
                            } else {
                                gProSecurityResult = null;
                            }
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            GProSdkWrapperImpl.this.Yf(i16, c16, gProJoinGuildResult);
                            com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "on addGuildWithOption", SensorJsPlugin.SENSOR_INTERVAL_UI, i16, str, "guildId \uff1a" + c16 + " sourceType: " + e16.p() + GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                            AnonymousClass10 anonymousClass102 = AnonymousClass10.this;
                            bvVar.a(i16, str, GProSdkWrapperImpl.this.tf(gProSecurityResult), new GGProJoinGuildResult(gProJoinGuildResult));
                        }
                    });
                }
            });
        } else {
            this.f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    bvVar.a(-90, "parameter error", null, null);
                }
            });
        }
    }

    public void ie(String str, boolean z16, byte[] bArr, final xh2.p pVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (bArr == null) {
            bArr = new byte[0];
        }
        iKernelGuildService.fetchGuildSpeakableMemberList(O0, z16, 100, bArr, new IGProFetchGuildSpeakableMemberListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cf
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableMemberListCallback
            public final void onFetchGuildSpeakableMemberList(int i3, String str2, int i16, boolean z17, byte[] bArr2, ArrayList arrayList) {
                GProSdkWrapperImpl.this.ih(pVar, i3, str2, i16, z17, bArr2, arrayList);
            }
        });
    }

    @Nullable
    /* renamed from: if, reason: not valid java name */
    public IGProGuildInfo m217if(long j3) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getGuildInfo error : kernelGuildService is null");
            return null;
        }
        GProGuild guildInfoFromCache = iKernelGuildService.getGuildInfoFromCache(j3);
        if (guildInfoFromCache == null) {
            return null;
        }
        return new GProGuildInfo(guildInfoFromCache);
    }

    public void ij(List<String> list, final vh2.ca caVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int m3 = com.tencent.mobileqq.qqguildsdk.util.h.m("GProSdkWrapperImpl", false, "sdkWrapper interface", "queryTinyIdByLiveUID", "", i3);
        this.f266768a.queryTinyIdByLiveUID(com.tencent.mobileqq.qqguildsdk.util.g.P0(list), new IGProQueryTinyIdByLiveUIDCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.71
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProQueryTinyIdByLiveUIDCallback
            public void onQueryTinyIdByLiveUIDCallback(final int i16, final String str, final HashMap<Long, Long> hashMap) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.71.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i17 = i16;
                        String str2 = str;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "queryTinyIdByLiveUID", "", i17, str2, str2, m3);
                        caVar.a(i16, str, hashMap);
                    }
                });
            }
        });
    }

    public void ik(String str, int i3, final vh2.cz czVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildUnNotifyFlag", "", "guildId:" + str + ", guildUnNotifyFlag:" + i3, i16);
        this.f266768a.setGuildUnNotifyFlag(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i3, new IGProSetGuildWeakNotifyDisplayCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.84
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildWeakNotifyDisplayCallback
            public void onSetGuildWeakNotifyDisplay(final int i17, final String str2, final int i18) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.84.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setGuildUnNotifyFlag", "", i17, str2, "", q16);
                        czVar.a(i17, str2, i18);
                    }
                });
            }
        });
    }

    public void jd(String str, final vh2.a aVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "appAuthorization", "", "clientId: " + str, i3);
        this.f266768a.appAuthorization(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), new IGProAppAuthorizationCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.74
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAppAuthorizationCallback
            public void onAppAuthorization(final int i16, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.74.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "appAuthorization", "", i16, str2, "clientId: " + i17, q16);
                        aVar.a(i16, str2, com.tencent.mobileqq.qqguildsdk.util.g.W0(i17));
                    }
                });
            }
        });
    }

    public void je(String str, boolean z16, final xh2.q qVar) {
        this.f266768a.fetchGuildSpeakableRoleList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, new IGProFetchGuildSpeakableRoleListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cd
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableRoleListCallback
            public final void onFetchGuildSpeakableRoleList(int i3, String str2, int i16, ArrayList arrayList) {
                GProSdkWrapperImpl.this.lh(qVar, i3, str2, i16, arrayList);
            }
        });
    }

    public ArrayList<IGProGuildInfo> jf() {
        ArrayList<IGProGuildInfo> arrayList = new ArrayList<>();
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            QLog.e("GProSdkWrapperImpl", 1, "getGuildListFromCache error : kernelGuildService is null");
            return arrayList;
        }
        Iterator<GProGuild> it = iKernelGuildService.getGuildListFromCache().iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo(it.next()));
        }
        return arrayList;
    }

    public void jj(String str, String str2, boolean z16, int i3) {
        if (this.f266768a == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.k("GProSdkWrapperImpl", 1, "network", "refreshChannelInfo but kernelGuildService == null, gid:" + str + ", cid:" + str2 + ", force:" + z16);
            return;
        }
        if (z16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshChannelInfo", "", " channelId \uff1a" + str2 + " isForce \uff1a " + z16);
        }
        this.f266768a.refreshChannelInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, z16);
    }

    public void jk(String str, boolean z16, final vh2.cc ccVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildVisibilityForVisitor", "", "guildId:" + str + ", isVisible:" + z16, i3);
        this.f266768a.setGuildVisibilityForVisitor(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.do
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i16, String str2) {
                GProSdkWrapperImpl.this.Gi(q16, ccVar, i16, str2);
            }
        });
    }

    public void kd(String str, String str2, vh2.co coVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.authScreenShared(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProScreenShareCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "authScreenShared", "", "guildId \uff1a" + str + "\uff0c channelId \uff1a " + str2, i3), coVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.43

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268915a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProScreenShareCallback
            public void onScreenShareCallback(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "authScreenShared", "", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), AnonymousClass43.this.f268915a);
                        getClass();
                        GProSdkWrapperImpl.this.tf(gProSecurityResult);
                        throw null;
                    }
                });
            }
        });
    }

    public void ke(String str, final vh2.au auVar) {
        this.f266768a.fetchGuildSpeakableRule(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchGuildSpeakableRuleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bc
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableRuleCallback
            public final void onFetchGuildSpeakableRule(int i3, String str2, GproGuildSpeakableRule gproGuildSpeakableRule) {
                GProSdkWrapperImpl.this.nh(auVar, i3, str2, gproGuildSpeakableRule);
            }
        });
    }

    public void kf(long j3, final vh2.ax axVar) {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "getGuildMainFrameHeaderInfo kernelGuildService is null");
        } else {
            iKernelGuildService.getGuildMainFrameHeaderInfo(j3, new IGProGetGuildMainFrameHeaderCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.119
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildMainFrameHeaderCallback
                public void onGetGuildMainFrameHeader(final int i3, final String str, final long j16, final GProGuildMainFrameHeaderInfo gProGuildMainFrameHeaderInfo) {
                    ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.119.1
                        @Override // java.lang.Runnable
                        public void run() {
                            axVar.a(i3, str, j16, new GGProGuildMainFrameHeaderInfo(gProGuildMainFrameHeaderInfo));
                        }
                    });
                }
            });
        }
    }

    public void kj(String str, boolean z16, int i3) {
        if (z16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildInfo", "", "guildId: " + str + " isForce: true");
        }
        this.f266768a.refreshGuildInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, i3);
    }

    public void kk(String str, int i3, final vh2.db dbVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setGuildWeakNotifyDisplay", "", "guildId:" + str + ", weakNotifyDisplay:" + i3, i16);
        this.f266768a.setGuildWeakNotifyDisplay(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i3, new IGProSetGuildWeakNotifyDisplayCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.83
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetGuildWeakNotifyDisplayCallback
            public void onSetGuildWeakNotifyDisplay(final int i17, final String str2, final int i18) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.83.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "onSetGuildWeakNotifyDisplay", "", i17, str2, "", q16);
                        dbVar.onSetGuildWeakNotifyDisplay(i17, str2, i18);
                    }
                });
            }
        });
    }

    public void ld(String str, HashMap<Integer, Boolean> hashMap, final vh2.cc ccVar) {
        final int p16 = com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "batchSetBoolField", "", "guildId:" + str);
        this.f266768a.batchSetGuildInfoBoolField(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), hashMap, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.i
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i3, String str2) {
                GProSdkWrapperImpl.this.hg(p16, ccVar, i3, str2);
            }
        });
    }

    public void le(String str, final vh2.x xVar) {
        this.f266768a.fetchGuildSpeakableThreshold(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchGuildSpeakableThresholdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cy
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchGuildSpeakableThresholdCallback
            public final void onFetchGuildSpeakableThreshold(int i3, String str2, GProGuildSpeakableThreshold gProGuildSpeakableThreshold) {
                GProSdkWrapperImpl.this.ph(xVar, i3, str2, gProGuildSpeakableThreshold);
            }
        });
    }

    public IGProClientIdentityInfo lf(String str, String str2) {
        GProClientIdentity guildUserClientIdentity = this.f266768a.getGuildUserClientIdentity(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
        if (guildUserClientIdentity == null) {
            return null;
        }
        return new GProClientIdentityInfo(guildUserClientIdentity);
    }

    public void lj(String str, boolean z16, int i3) {
        if (z16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildInfoOnly", "", "guildId: " + str + " isForce: true");
        }
        this.f266768a.refreshGuildInfoOnly(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), z16, i3);
    }

    public void lk(String str, String str2, List<String> list, List<String> list2, final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setLiveChannelAnchorList", "", "guildId \uff1a" + str + ", channelId:" + str2, i3);
        this.f266768a.setLiveChannelAnchorList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.60
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.60.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setLiveChannelHostList", "", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass60 anonymousClass60 = AnonymousClass60.this;
                        cdVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void md(String str, HashMap<Integer, Integer> hashMap, final vh2.cc ccVar) {
        final int p16 = com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "batchSetIntField", "", "guildId:" + str);
        this.f266768a.batchSetGuildInfoIntField(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), hashMap, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.eq
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i3, String str2) {
                GProSdkWrapperImpl.this.jg(p16, ccVar, i3, str2);
            }
        });
    }

    public void me(String str, vh2.ab abVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.fetchIsLiveChannelOpen(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchIsLiveChannelOpenCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchIsLiveChannelOpen", "", "guildId \uff1a" + str, i3), abVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.68

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269120a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchIsLiveChannelOpenCallback
            public void onRequestFetchIsLiveChannelOpenCallback(final int i16, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.68.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i16;
                        String str3 = str2;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchIsLiveChannelOpen", "", i18, str3, str3, AnonymousClass68.this.f269120a);
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mj(boolean z16) {
        if (z16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildList", "", "isForce: true");
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.k("GProSdkWrapperImpl", 1, "sdkWrapper interface", "refreshGuildList but kernelGuildService == null");
            return;
        }
        iKernelGuildService.refreshGuildList(z16);
        if (z16) {
            this.f266768a.setOnLogin();
        }
    }

    public void mk(String str, String str2, String str3, String str4, int i3, final vh2.cc ccVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setLiveChannelBannedUser", "", "guildId \uff1a" + str + ", channelId:" + str2 + ", roomId:" + str3 + ", bannedUser:" + str4 + ", operateType:" + i3, i16);
        this.f266768a.setLiveChannelBannedUser(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), com.tencent.mobileqq.qqguildsdk.util.g.O0(str4), i3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.65
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str5, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.65.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setLiveChannelBannedUser", "", i17, str5, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        ccVar.onResult(i17, str5);
                    }
                });
            }
        });
    }

    public void nd(final String str, List<com.tencent.mobileqq.qqguildsdk.data.f> list, final vh2.c cVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "batchUpdateChannelsMsgNotifyType", "ui-self", " guildId \uff1a " + str + " channelMsgNotifyList \uff1a " + list, i3);
        this.f266768a.batchUpdateChannelsMsgNotifyType(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.x0(list), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.24
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str2, GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "batchUpdateChannelsMsgNotifyType", "ui-batchUpdateChannelsMsgNotifyType", i16, str2, null, q16);
                        AnonymousClass24 anonymousClass24 = AnonymousClass24.this;
                        cVar.a(i16, str2, str, null);
                    }
                });
            }
        });
    }

    public void ne(String str, vh2.ac acVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.fetchIsVoiceChannelOpen(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchIsVoiceChannelOpenCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchIsVoiceChannelOpen", "", "guildId \uff1a" + str, i3), acVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.35

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268859a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchIsVoiceChannelOpenCallback
            public void onRequestFetchIsVoiceChannelOpenCallback(final int i16, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.35.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i16;
                        String str3 = str2;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchIsVoiceChannelOpen", "", i18, str3, str3, AnonymousClass35.this.f268859a);
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    public com.tencent.mobileqq.qqguildsdk.data.bg nf(String str) {
        if (this.f266768a == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[gpro_sdk] getGuildPermission", new NullPointerException("kernelGuildService == null"));
            return new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet());
        }
        return new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet(this.f266768a.getGuildPermission(com.tencent.mobileqq.qqguildsdk.util.g.O0(str))));
    }

    public void nj(String str, String str2, int i3) {
        if (this.f266768a == null) {
            hj();
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdkWrapper interface", "refreshGuildUserProfileInfo", "", "guildId \uff1a" + str + "\uff0c tinyId \uff1a " + str2 + "\uff0c type \uff1a " + i3);
        this.f266768a.refreshGuildUserProfileInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3);
    }

    public void nk(GProLocationInfo gProLocationInfo, final vh2.cc ccVar) {
        String str = " location \uff1a " + gProLocationInfo.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setLocation", SensorJsPlugin.SENSOR_INTERVAL_UI, str, i3);
        this.f266768a.setLocation(new GProLocation(gProLocationInfo.g(), gProLocationInfo.k(), gProLocationInfo.b(), gProLocationInfo.e(), gProLocationInfo.f(), gProLocationInfo.j(), gProLocationInfo.a(), gProLocationInfo.c()), new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.32
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public void onResult(final int i16, final String str2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.32.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setLocation", "", i16, str2, "", q16);
                        ccVar.onResult(i16, str2);
                    }
                });
            }
        });
    }

    public void od(String str, final String str2, final int i3, final vh2.d dVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "bindAppRole", "", "clientId: " + str + ", roleId: " + str2 + ", type: " + i3, i16);
        this.f266768a.bindAppRole(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), str2, i3, new IGProBindAppRoleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.78
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBindAppRoleCallback
            public void onBindAppRole(final int i17, final String str3, final int i18, int i19, String str4) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.78.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "bindAppRole", "", i17, str3, "clientId: " + i18 + ", roleId: " + str2 + ", type: " + i3, q16);
                        vh2.d dVar2 = dVar;
                        int i26 = i17;
                        String str5 = str3;
                        String W0 = com.tencent.mobileqq.qqguildsdk.util.g.W0(i18);
                        AnonymousClass78 anonymousClass78 = AnonymousClass78.this;
                        dVar2.a(i26, str5, W0, str2, i3);
                    }
                });
            }
        });
    }

    public void oe(String str, String str2, long j3, long j16, final vh2.p pVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLatestComments", "", "guildId:" + str + " channelId:" + str2 + " rootMsgSeq:" + j3 + " msgSeq:" + j16, i3);
        this.f266768a.fetchLatestComments(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, j16, new IGProFetchCommentsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ai
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchCommentsCallback
            public final void onFetchComments(int i16, String str3, long j17, long j18, ArrayList arrayList, boolean z16, boolean z17) {
                GProSdkWrapperImpl.this.rh(q16, pVar, i16, str3, j17, j18, arrayList, z16, z17);
            }
        });
    }

    public void of(byte[] bArr, vh2.bp bpVar) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.getGuildRecommend(bArr, 1, new IGProGetRecommendCallback(com.tencent.mobileqq.qqguildsdk.util.h.l("GProSdkWrapperImpl", false, "sdkWrapper interface", "getGuildRecommend", i3), bpVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.103

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268599a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetRecommendCallback
            public void onGetRecommendResult(final int i16, final String str, final boolean z16, final byte[] bArr2, final ArrayList<GProRecommendResult> arrayList, final boolean z17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.103.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "getGuildRecommend", "", i16, str, "", AnonymousClass103.this.f268599a);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.br((GProRecommendResult) it.next()));
                        }
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    public void oj() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.refreshPollingData(0L, 0L, 0);
        }
    }

    public void ok(String str, String str2, String str3, String str4, List<String> list, List<String> list2, final vh2.cd cdVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        long O03 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str3);
        long O04 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str4);
        ArrayList<Long> P0 = com.tencent.mobileqq.qqguildsdk.util.g.P0(list);
        ArrayList<Long> P02 = com.tencent.mobileqq.qqguildsdk.util.g.P0(list2);
        String str5 = "guildId: " + str + ", tinyId: " + str2 + ", addRoleList: " + P0.toString() + ", removeRoleList: " + P02.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMemberRoles", "call", str5, i3);
        this.f266768a.setMemberRoles(O0, O03, O04, O02, P0, P02, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.93
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str6, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.93.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setMemberRoles", "callback", i16, str6, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass93 anonymousClass93 = AnonymousClass93.this;
                        cdVar.a(i16, str6, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void pd(String str, String str2, ArrayList<IGProTopMsg> arrayList, final vh2.cc ccVar) {
        String str3 = "guildId:" + str + " channelId:" + str2 + " topMsgList.size:" + arrayList.size();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "cancelChannelTopMsg", "", str3, i3);
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        ArrayList<GProTopMsg> arrayList2 = new ArrayList<>();
        Iterator<IGProTopMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((GProTopMsgInfo) it.next()).mInfo);
        }
        this.f266768a.cancelChannelTopMsg(O0, O02, arrayList2, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ap
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i16, String str4) {
                GProSdkWrapperImpl.this.lg(q16, ccVar, i16, str4);
            }
        });
    }

    public void pe(String str, String str2, vh2.ad adVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.fetchLiveChannelAnchorList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProFetchLiveChannelAnchorListCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveChannelAnchorList", "", "guildId \uff1a" + str + ", channelId:" + str2, i3), adVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.61

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269072a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLiveChannelAnchorListCallback
            public void onFetchLiveChannelAnchorList(final int i16, final String str3, final ArrayList<Long> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.61.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i17 = i16;
                        String str4 = str3;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveChannelAnchorList", "", i17, str4, str4, AnonymousClass61.this.f269072a);
                        getClass();
                        com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList);
                        throw null;
                    }
                });
            }
        });
    }

    public com.tencent.mobileqq.qqguildsdk.data.eo pf(String str, int i3) {
        GProSpeakPermissionInfo gProSpeakPermissionInfo;
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService != null) {
            gProSpeakPermissionInfo = iKernelGuildService.getGuildSpeakPermission(O0, i3);
        } else {
            hj();
            gProSpeakPermissionInfo = null;
        }
        if (gProSpeakPermissionInfo == null) {
            QLog.e("GProSdkWrapperImpl", 1, "[NeedInterceptSpeech] info:null");
        }
        return new b(gProSpeakPermissionInfo);
    }

    public void pj(@NonNull String str, int i3) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.refreshPollingData(O0, 0L, i3);
        }
    }

    public void pk(String str, String str2, long j3, final vh2.cd cdVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setMemberShutUp", "", "guildId=" + str + " tinyId=" + str2 + " expireTime=" + j3, i3);
        this.f266768a.setMemberShutUp(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), j3, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bt
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public final void onResult(int i16, String str3, GProSecurityResult gProSecurityResult) {
                GProSdkWrapperImpl.this.Ii(q16, cdVar, i16, str3, gProSecurityResult);
            }
        });
    }

    public void qd(String str, long j3, String str2, final di2.d dVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "changeChannelCategoryNameWithId", "", "guildId \uff1a" + str + "\uff0c categoryId \uff1a " + j3 + "\uff0c dstName\uff1a" + str2, i3);
        this.f266768a.changeChannelCategoryNameWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), j3, str2, new IGProSetChannelCategoryInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.48
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback
            public void onSetChannelCategoryInfo(final int i16, final String str3, final GProSecurityResult gProSecurityResult, HashMap<Long, GProChannel> hashMap, @NonNull final GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull final ArrayList<GProCategoryChannelIdList> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "changeChannelCategoryNameWithId", "", i16, str3, GProSdkWrapperImpl.this.Re(gProSecurityResult, gProCategoryChannelIdList, arrayList), q16);
                        AnonymousClass48 anonymousClass48 = AnonymousClass48.this;
                        dVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList));
                    }
                });
            }
        });
    }

    public void qe(String str, String str2, String str3, vh2.ae aeVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.fetchLiveChannelBannedUserList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), new IGProFetchBannedUserListCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveChannelBannedUserList", "", "guildId \uff1a" + str + " channelId:" + str2 + " roomId:" + str3, i3), aeVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.67

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269114a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchBannedUserListCallback
            public void onFetchBannedUserList(final int i16, final String str4, final ArrayList<Long> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.67.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i17 = i16;
                        String str5 = str4;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveChannelBannedUserList", "", i17, str5, str5, AnonymousClass67.this.f269114a);
                        getClass();
                        com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList);
                        throw null;
                    }
                });
            }
        });
    }

    public HashMap<String, String> qf(String str, List<String> list, int i3) {
        return com.tencent.mobileqq.qqguildsdk.util.g.Q0(this.f266768a.getGuildUserAvatarUrls(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), i3));
    }

    public void qj(@NonNull String str, @NonNull String str2) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.refreshPollingData(O0, O02, 0);
        }
    }

    public void qk(String str, final vh2.cc ccVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setNickName", SensorJsPlugin.SENSOR_INTERVAL_UI, " nickName \uff1a " + str, i3);
        this.f266768a.setNickName(str, new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.30
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public void onResult(final int i16, final String str2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.30.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setNickName", "", i16, str2, "", q16);
                        ccVar.onResult(i16, str2);
                    }
                });
            }
        });
    }

    public void rd(String str, String str2, String str3, final vh2.f fVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "checkUserBannedSpeakInChannel", "", "guildId \uff1a" + str + " channelId:" + str2 + " tinyId:" + str3, i3);
        this.f266768a.checkUserBannedSpeakInChannel(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), new IGProCheckUserBannedSpeakInChannelCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.70
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCheckUserBannedSpeakInChannelCallback
            public void onRequestCheckUserBannedSpeakInChannel(final int i16, final String str4, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.70.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i16;
                        String str5 = str4;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "checkUserBannedSpeakInChannel", "", i18, str5, str5, q16);
                        fVar.a(i16, str4, i17);
                    }
                });
            }
        });
    }

    public void re(com.tencent.mobileqq.qqguildsdk.data.ag agVar, final vh2.af afVar) {
        String agVar2 = agVar.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveRoomInfo", "", agVar2, i3);
        GProLiveRoomInfoReq gProLiveRoomInfoReq = new GProLiveRoomInfoReq();
        gProLiveRoomInfoReq.guildId = com.tencent.mobileqq.qqguildsdk.util.g.O0(agVar.b());
        gProLiveRoomInfoReq.channelIdList = com.tencent.mobileqq.qqguildsdk.util.g.P0(agVar.a());
        gProLiveRoomInfoReq.liveRoomIdList = com.tencent.mobileqq.qqguildsdk.util.g.P0(agVar.c());
        gProLiveRoomInfoReq.needDecodeData = agVar.d();
        this.f266768a.fetchLiveRoomInfo(gProLiveRoomInfoReq, new IGProFetchLiveChannelInfoListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.64
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLiveChannelInfoListCallback
            public void onFetchLiveRoomInfoList(final int i16, final String str, final ArrayList<GProLiveRoomInfo> arrayList, final ArrayList<Long> arrayList2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.64.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i16;
                        String str2 = str;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveRoomInfo", "", i18, str2, str2, q16);
                        afVar.a(i16, str, com.tencent.mobileqq.qqguildsdk.util.g.N0(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList2), i17);
                    }
                });
            }
        });
    }

    public HashMap<String, String> rf(String str, List<String> list) {
        return com.tencent.mobileqq.qqguildsdk.util.g.Q0(this.f266768a.getGuildUserMemberNames(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list)));
    }

    public void rj(String str, String str2, final vh2.cb cbVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeBanBeforeBroadcast", "", "uid: " + str + ", roomId: " + str2, i3);
        this.f266768a.removeBanBeforeBroadcast(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProRemoveBanBeforeBroadcastCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.66
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProRemoveBanBeforeBroadcastCallback
            public void onRemoveBanBeforeBroadcastCallback(final int i16, final String str3, final int i17, final String str4) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.66.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i18 = i16;
                        String str5 = str3;
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeBanBeforeBroadcast", "", i18, str5, str5, q16);
                        cbVar.a(i16, str3, i17, str4);
                    }
                });
            }
        });
    }

    public void rk(String str, String str2, int i3, @NonNull final vh2.cc ccVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setQQMsgListChannel", "", "guildId=" + str + " channelId=" + str2 + " op=" + i3, i16);
        this.f266768a.setQQMsgListChannel(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, new IGProSetQQMsgListChannelCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bs
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetQQMsgListChannelCallback
            public final void onSetQQMsgListChannelCallback(int i17, String str3) {
                GProSdkWrapperImpl.this.Ki(q16, ccVar, i17, str3);
            }
        });
    }

    public void sd(String str, String str2, final vh2.cc ccVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "closeChannelTopMsg", "", "guildId:" + str + " channelId:" + str2, i3);
        this.f266768a.closeChannelTopMsg(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ag
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i16, String str3) {
                GProSdkWrapperImpl.this.ng(q16, ccVar, i16, str3);
            }
        });
    }

    public void se(vh2.ag agVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.fetchLiveSecurityTips(new IGProFetchLiveSecurityTipsCallback(com.tencent.mobileqq.qqguildsdk.util.h.l("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchLiveSecurityTips", i3), agVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.69

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269126a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchLiveSecurityTipsCallback
            public void onFetchLiveSecurityTipsCallback(final int i16, final String str, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.69.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchLiveSecurityTips", "", i16, str, str2, AnonymousClass69.this.f269126a);
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    public HashMap<String, String> sf(List<String> list) {
        return com.tencent.mobileqq.qqguildsdk.util.g.Q0(this.f266768a.getGuildUserNicknames(com.tencent.mobileqq.qqguildsdk.util.g.P0(list)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sj(String str, String str2, int i3, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeChannel", SensorJsPlugin.SENSOR_INTERVAL_UI, " channelUin \uff1a " + str2, i16);
        GProRemoveChannelReq gProRemoveChannelReq = new GProRemoveChannelReq();
        gProRemoveChannelReq.setGuildId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str));
        gProRemoveChannelReq.setChannelId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str2));
        gProRemoveChannelReq.setMovePost(i3);
        this.f266768a.removeChannel(gProRemoveChannelReq, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.13
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeChannel", SensorJsPlugin.SENSOR_INTERVAL_UI, i17, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                        cdVar.a(i17, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void sk(String str, String str2, int i3, List<String> list, List<String> list2, final vh2.cc ccVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setRoleChannels", "call", "guildId=" + str + " roleId=" + str2 + " filter=" + i3 + " addList=" + list + " removeList=" + list2, i16);
        this.f266768a.setRoleChannels(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, com.tencent.mobileqq.qqguildsdk.util.g.P0(list), com.tencent.mobileqq.qqguildsdk.util.g.P0(list2), new IGProSetRoleChannelsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bv
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetRoleChannelsCallback
            public final void onSetRoleChannels(int i17, String str3, ArrayList arrayList, ArrayList arrayList2) {
                GProSdkWrapperImpl.this.Mi(q16, ccVar, i17, str3, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void td(final String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, int i3, com.tencent.mobileqq.qqguildsdk.data.b bVar, com.tencent.mobileqq.qqguildsdk.data.b bVar2, ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList, final di2.e eVar) {
        com.tencent.mobileqq.qqguildsdk.data.b bVar3;
        String str2 = "guildId \uff1a" + str + ", info : " + dVar.m() + ", categoryId:" + j3 + ", assocCreateCategoryType:" + i3;
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createChannelWithId", SensorJsPlugin.SENSOR_INTERVAL_UI, str2, i16);
        GProAssocCreateCategoryReq gProAssocCreateCategoryReq = new GProAssocCreateCategoryReq();
        gProAssocCreateCategoryReq.specificCateype = i3;
        if (bVar == null) {
            bVar3 = new com.tencent.mobileqq.qqguildsdk.data.b("", 0L);
        } else {
            bVar3 = bVar;
        }
        gProAssocCreateCategoryReq.categoryInfo = com.tencent.mobileqq.qqguildsdk.util.g.e(bVar3);
        this.f266768a.createChannelWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.j(dVar), j3, gProAssocCreateCategoryReq, com.tencent.mobileqq.qqguildsdk.util.g.e(bVar2), com.tencent.mobileqq.qqguildsdk.util.g.h(arrayList), new IGProCreateChannelCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.5
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateChannelCallback
            public void onCreateChannelResult(final int i17, final String str3, final GProSecurityResult gProSecurityResult, final GProChannel gProChannel, HashMap<Long, GProChannel> hashMap, final GProCategoryChannelIdList gProCategoryChannelIdList, final ArrayList<GProCategoryChannelIdList> arrayList2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createChannelWithId", "new id", i17, str3, "guildId \uff1a" + str + ", channelId:" + gProChannel.getChannelId() + GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        eVar.a(i17, str3, new GProChannelInfo(gProChannel), GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList2));
                    }
                });
            }
        });
    }

    public void te(com.tencent.mobileqq.qqguildsdk.data.genc.bj bjVar, final wh2.au auVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchMVPFeedsFromServer", "", "", i3);
        GProGetContentRecommendReq j06 = com.tencent.mobileqq.qqguildsdk.engine.aa.j0(bjVar);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GProSdkWrapperImpl", 1, "fetchMVPFeedsFromServer kernelGuildService is null");
        } else {
            iKernelGuildService.fetchMVPFeedsFromServer(j06, new IGProFetchMVPFeedsDataCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.at
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMVPFeedsDataCallback
                public final void onFetchMVPFeedsData(int i16, String str, GProGetContentRecommendRsp gProGetContentRecommendRsp, byte[] bArr) {
                    GProSdkWrapperImpl.sh(q16, auVar, i16, str, gProGetContentRecommendRsp, bArr);
                }
            });
        }
    }

    public void tj(String str, long j3, boolean z16, final di2.d dVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeChannelCategoryWithId", "", "guildId \uff1a" + str + "\uff0c categoryId \uff1a " + j3 + ", isRemoveChannel: " + z16, i3);
        this.f266768a.removeChannelCategoryWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), j3, z16, new IGProSetChannelCategoryInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.47
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback
            public void onSetChannelCategoryInfo(final int i16, final String str2, final GProSecurityResult gProSecurityResult, HashMap<Long, GProChannel> hashMap, @NonNull final GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull final ArrayList<GProCategoryChannelIdList> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "removeChannelCategoryWithId", "", i16, str2, GProSdkWrapperImpl.this.Re(gProSecurityResult, gProCategoryChannelIdList, arrayList), q16);
                        AnonymousClass47 anonymousClass47 = AnonymousClass47.this;
                        dVar.a(i16, str2, GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList));
                    }
                });
            }
        });
    }

    public void tk(String str, String str2, com.tencent.mobileqq.qqguildsdk.data.fn fnVar, final vh2.cd cdVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        GProRoleCreateInfo J = com.tencent.mobileqq.qqguildsdk.util.g.J(fnVar);
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setRoleInfo", "call", "guildId: " + str + ", roleId: " + str2 + ", roleInfo: " + fnVar, i3);
        this.f266768a.setRoleInfo(O0, O02, J, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.90
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.90.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setRoleInfo", "callback", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass90 anonymousClass90 = AnonymousClass90.this;
                        cdVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void ud(String str, String str2, final di2.d dVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createChannelCategoryWithId", "", "guildId \uff1a" + str + "\uff0c categoryName \uff1a " + str2, i3);
        this.f266768a.createChannelCategoryWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), str2, new IGProSetChannelCategoryInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.46
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetChannelCategoryInfoCallback
            public void onSetChannelCategoryInfo(final int i16, final String str3, final GProSecurityResult gProSecurityResult, HashMap<Long, GProChannel> hashMap, @NonNull final GProCategoryChannelIdList gProCategoryChannelIdList, @NonNull final ArrayList<GProCategoryChannelIdList> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createChannelCategoryWithId", "", i16, str3, GProSdkWrapperImpl.this.Re(gProSecurityResult, gProCategoryChannelIdList, arrayList), q16);
                        AnonymousClass46 anonymousClass46 = AnonymousClass46.this;
                        dVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList));
                    }
                });
            }
        });
    }

    public void ue(String str, String str2, long j3, long j16, int i3, int i16, final vh2.aj ajVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchMemberListWithRoleInternal", "call", "guildId: " + str + ", channelId: " + str2 + ", startIndex: " + j3 + ", roleIdIndex: " + j16 + ", count: " + i3, i17);
        this.f266768a.fetchMemberListWithRole(O0, O02, j3, j16, i3, i16, new IGProFetchMemberListWithRoleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.100
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMemberListWithRoleCallback
            public void onFetchMemberListWithRoleCallback(final int i18, final String str3, final boolean z16, final long j17, final long j18, final boolean z17, final int i19, final ArrayList<GProRoleMemberList> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.100.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<IGProRoleMemberListInfo> G0 = com.tencent.mobileqq.qqguildsdk.util.g.G0(arrayList);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchMemberListWithRoleInternal", "callback", i18, str3, "isFinished: " + z16 + ", nextIndex: " + j17 + ", nextRoleIdIndex: " + j18 + ", isSmallGuild: " + z17 + ", roleList: " + G0.toString(), q16);
                        ajVar.a(i18, str3, z16, j17, j18, z17, i19, G0);
                    }
                });
            }
        });
    }

    public boolean uf() {
        return this.f268560g;
    }

    public void uj(String str, List<String> list, final vh2.cc ccVar) {
        String str2 = "guildId:" + str + ", tinyIdList size:" + list.size();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "removeMemberFromGuildBlackList", "call", str2, i3);
        this.f266768a.removeMemberFromGuildBlackList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.P0(list), new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bx
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public final void onResult(int i16, String str3) {
                GProSdkWrapperImpl.this.Vh(q16, ccVar, i16, str3);
            }
        });
    }

    public void uk(String str, String str2, String str3, String str4, List<String> list, List<String> list2, final vh2.cd cdVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        long O03 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str3);
        long O04 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str4);
        ArrayList<Long> P0 = com.tencent.mobileqq.qqguildsdk.util.g.P0(list);
        ArrayList<Long> P02 = com.tencent.mobileqq.qqguildsdk.util.g.P0(list2);
        String str5 = "guildId: " + str + ", roleId: " + str2 + ", addMembers: " + P0.toString() + ", removeMembers: " + P02.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setRoleMembers", "call", str5, i3);
        this.f266768a.setRoleMembers(O0, O03, O04, O02, P0, P02, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.92
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str6, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.92.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setRoleMembers", "callback", i16, str6, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass92 anonymousClass92 = AnonymousClass92.this;
                        cdVar.a(i16, str6, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void vd(@NonNull com.tencent.mobileqq.qqguildsdk.data.i iVar, final vh2.h hVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createDirectMsgSession", "", "createInfo=" + iVar, i3);
        this.f266768a.createDirectMsgSession(com.tencent.mobileqq.qqguildsdk.util.g.q(iVar), new IGProCreateDirectMsgSessionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.de
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateDirectMsgSessionCallback
            public final void onCreateDirectMsgSessionCallback(int i16, String str, GProSecurityResult gProSecurityResult, int i17, GProDirectMsgSession gProDirectMsgSession) {
                GProSdkWrapperImpl.this.pg(q16, hVar, i16, str, gProSecurityResult, i17, gProDirectMsgSession);
            }
        });
    }

    public void ve(String str, String str2, String str3, int i3, final di2.a aVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str3);
        long O03 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchMemberRoleList", "call", "guildId: " + str + ",cid:" + O03 + ", tinyId: " + str3, i16);
        this.f266768a.fetchMemberRoles(O0, O03, O02, i3, new IGProFetchMemberRolesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.96
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchMemberRolesCallback
            public void onFetchMemberRolesCallback(final int i17, final String str4, final ArrayList<GProGuildRole> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.96.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<GProGuildRoleInfo> v3 = com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchMemberRoleList", "callback", i17, str4, "roles: " + v3.toString(), q16);
                        aVar.a(i17, str4, v3);
                    }
                });
            }
        });
    }

    public void vf(String str, String str2, final vh2.bb bbVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
        } else {
            iKernelGuildService.getLiveAudioPollingCtx(O0, O02, new IGProGetLiveAudioPollingCtxCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.dj
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetLiveAudioPollingCtxCallback
                public final void onResult(GProRealTimeChannels gProRealTimeChannels) {
                    GProSdkWrapperImpl.this.Gh(bbVar, gProRealTimeChannels);
                }
            });
        }
    }

    public void vj(String str, String str2, int i3, String str3, int i16, final vh2.cc ccVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int m3 = com.tencent.mobileqq.qqguildsdk.util.h.m("GProSdkWrapperImpl", false, "sdkWrapper interface", "reportShareInfo", "", i17);
        this.f266768a.reportShareInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), i3, str3, i16, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.72
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i18, final String str4, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.72.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "reportShareInfo", "", i18, str4, GProSdkWrapperImpl.this.Qf(gProSecurityResult), m3);
                        ccVar.onResult(i18, str4);
                    }
                });
            }
        });
    }

    public void vk(String str, List<String> list, final vh2.cd cdVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        ArrayList<Long> P0 = com.tencent.mobileqq.qqguildsdk.util.g.P0(list);
        String str2 = "guildId: " + str + ", roleIdList: " + list.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setRoleOrder", "call", str2, i3);
        this.f266768a.setRoleOrder(O0, P0, new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.91
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.91.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setRoleOrder", "callback", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass91 anonymousClass91 = AnonymousClass91.this;
                        cdVar.a(i16, str3, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wd(final String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, long j3, com.tencent.mobileqq.qqguildsdk.data.b bVar, ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList, @NonNull final IGProSimpleResultCallback iGProSimpleResultCallback) {
        String str2 = "guildId \uff1a" + str + ", info : " + dVar.m() + ", categoryId:" + j3;
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createChannelWithId", SensorJsPlugin.SENSOR_INTERVAL_UI, str2, i3);
        this.f266768a.createLinkChannelWithId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.j(dVar), j3, com.tencent.mobileqq.qqguildsdk.util.g.e(bVar), com.tencent.mobileqq.qqguildsdk.util.g.h(arrayList), new IGProSimpleResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.6
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSimpleResultCallback
            public void onResult(final int i16, final String str3) {
                final String str4 = "guildId \uff1a" + str + ", channelId:";
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createChannelWithId", "new id", i16, str3, str4, q16);
                        iGProSimpleResultCallback.onResult(i16, str3);
                    }
                });
            }
        });
    }

    public void we(int i3, String str, final vh2.al alVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int m3 = com.tencent.mobileqq.qqguildsdk.util.h.m("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchNewestNotice", "type=" + i3 + "guildId=" + str, i16);
        this.f266768a.fetchNewestNotice(i3, com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchNewestNoticeCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.bj
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchNewestNoticeCallback
            public final void onFetchNewestNoticeCallback(int i17, String str2, GProNotice gProNotice) {
                GProSdkWrapperImpl.this.uh(m3, alVar, i17, str2, gProNotice);
            }
        });
    }

    public void wf(com.tencent.mobileqq.qqguildsdk.data.ai aiVar, final vh2.bc bcVar) {
        if (this.f266768a == null) {
            hj();
            return;
        }
        GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq = new GProGetLiveAudioPollingInfoReq();
        gProGetLiveAudioPollingInfoReq.guildId = com.tencent.mobileqq.qqguildsdk.util.g.O0(aiVar.b());
        gProGetLiveAudioPollingInfoReq.categoryTypeList = aiVar.a();
        this.f266768a.getLiveAudioPollingCtxV2(gProGetLiveAudioPollingInfoReq, new IGProGetLiveAudioPollingCtxV2Callback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.x
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetLiveAudioPollingCtxV2Callback
            public final void onResult(GProGetLiveAudioPollingCtxRsp gProGetLiveAudioPollingCtxRsp) {
                GProSdkWrapperImpl.this.Ih(bcVar, gProGetLiveAudioPollingCtxRsp);
            }
        });
    }

    public void wj(String str, String str2, String str3, int i3, com.tencent.mobileqq.qqguildsdk.data.bl blVar, final vh2.cd cdVar) {
        int i16 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i16 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "requestBeginBroadcast", "", "guildId \uff1a" + str + ", channelId:" + str2 + ", roomId:" + str3, i16);
        this.f266768a.requestBeginBroadcast(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), com.tencent.mobileqq.qqguildsdk.util.g.O0(str3), i3, com.tencent.mobileqq.qqguildsdk.util.g.H(blVar), new IGProResultCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.63
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProResultCallback
            public void onResult(final int i17, final String str4, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.63.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "requestBeginBroadcast", "", i17, str4, GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass63 anonymousClass63 = AnonymousClass63.this;
                        cdVar.a(i17, str4, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void wk(String str, String str2, boolean z16, vh2.co coVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.setScreenSharedInGuild(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), z16, new IGProScreenShareCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setScreenSharedInGuild", "", "guildId \uff1a" + str + "\uff0c channelId \uff1a " + str2 + "\uff0c bShare \uff1a " + z16, i3), coVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.42

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268909a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProScreenShareCallback
            public void onScreenShareCallback(final int i16, final String str3, final GProSecurityResult gProSecurityResult) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.42.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setScreenSharedInGuild", "", i16, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), AnonymousClass42.this.f268909a);
                        getClass();
                        GProSdkWrapperImpl.this.tf(gProSecurityResult);
                        throw null;
                    }
                });
            }
        });
    }

    public void xd(String str, com.tencent.mobileqq.qqguildsdk.data.fn fnVar, List<String> list, final di2.g gVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        GProRoleCreateInfo J = com.tencent.mobileqq.qqguildsdk.util.g.J(fnVar);
        ArrayList<Long> P0 = com.tencent.mobileqq.qqguildsdk.util.g.P0(list);
        String str2 = "guildId\uff1a" + str + ", roleName: " + fnVar.c();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createRole", "call", str2, i3);
        this.f266768a.createRole(O0, J, P0, new IGProCreateRoleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.88
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateRoleCallback
            public void onCreateRoleResult(final int i16, final String str3, final GProSecurityResult gProSecurityResult, final GProGuildRole gProGuildRole) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.88.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GProGuildRoleInfo gProGuildRoleInfo = new GProGuildRoleInfo(gProGuildRole);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createRole", "callback", i16, str3, "roleInfo: " + gProGuildRoleInfo.toString() + GProSdkWrapperImpl.this.Qf(gProSecurityResult), q16);
                        AnonymousClass88 anonymousClass88 = AnonymousClass88.this;
                        gVar.a(i16, str3, gProGuildRoleInfo, GProSdkWrapperImpl.this.tf(gProSecurityResult));
                    }
                });
            }
        });
    }

    public void xe(String str, String str2, String str3, String str4, long j3, int i3, int i16, final vh2.an anVar) {
        long O0 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str);
        long O02 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str2);
        long O03 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str3);
        long O04 = com.tencent.mobileqq.qqguildsdk.util.g.O0(str4);
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchNonRoleMemberListInternal", "call", "guildId: " + str + ", channelId: " + str2 + ", categoryId:" + str3 + ", roleId: " + str4 + ", startIndex: " + j3 + ", count: " + i3, i17);
        this.f266768a.fetchNonRoleMembers(O0, O02, O03, O04, j3, i3, i16, new IGProFetchNonRoleMembersCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.99
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchNonRoleMembersCallback
            public void onFetchNonRoleMembersCallback(final int i18, final String str5, final long j16, final boolean z16, final ArrayList<GProUser> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.99.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<IGProUserInfo> K0 = com.tencent.mobileqq.qqguildsdk.util.g.K0(arrayList);
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchNonRoleMemberListInternal", "callback", i18, str5, "nextIndex: " + j16 + ", isSmallGuild: " + z16 + ", memberListSize: " + arrayList.size(), q16);
                        anVar.a(i18, str5, j16, z16, K0);
                    }
                });
            }
        });
    }

    public void xf(String str, long j3, boolean z16, boolean z17, final vh2.bn bnVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "GetMemberInfoByOpenId", "call", "guildOpenId: " + str, i3);
        this.f266768a.GetMemberInfoByOpenId(str, j3, z16, z17, new IGProGetMemberInfoByOpenIdCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.25
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetMemberInfoByOpenIdCallback
            public void onGetMemberInfoByOpenId(final int i16, final String str2, final String str3, final String str4, final int i17, final boolean z18, final String str5) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.25.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "GetMemberInfoByOpenId", "callback", i16, str2, "nick=" + str3 + ", avatar=" + str4.length() + ", identity=" + i17, q16);
                        bnVar.a(i16, str2, str3, str4, i17, z18, str5);
                    }
                });
            }
        });
    }

    public void xj(@NonNull com.tencent.mobileqq.qqguildsdk.data.bd bdVar, @NonNull final vh2.cp cpVar) {
        String bdVar2 = bdVar.toString();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchMsgSeqsFromServer", "", bdVar2, i3);
        this.f266768a.searchMsgSeqsFromServer(com.tencent.mobileqq.qqguildsdk.util.g.A(bdVar), new IGProSearchMsgSeqsFromServerCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.cc
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchMsgSeqsFromServerCallback
            public final void onSearchMsgSeqsFromServer(int i16, String str, GProMsgSearchRsp gProMsgSearchRsp) {
                GProSdkWrapperImpl.Wh(q16, cpVar, i16, str, gProMsgSearchRsp);
            }
        });
    }

    public void xk(final String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            if (this.f266768a == null) {
                com.tencent.mobileqq.qqguildsdk.util.h.k("GProSdkWrapperImpl", 1, "network", "setSelfTinyId but kernelGuildService == null");
                return;
            }
            com.tencent.mobileqq.qqguildsdk.util.h.e("GProSdkWrapperImpl", false, "sdkWrapper interface", "setSelfTinyId", "", "old tid=" + this.f268561h + " new tid=" + str);
            this.f266768a.setSelfTinyId(com.tencent.mobileqq.qqguildsdk.util.g.O0(str));
            if (!TextUtils.equals(this.f268561h, str)) {
                this.f268561h = str;
                ej(110, "setSelfTinyId", str);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.tianjige.h.f().x(str);
                }
            }, 16, null, false);
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.k("GProSdkWrapperImpl", 1, "sdkWrapper interface", "setSelfTinyId invalid tinyId");
    }

    public void yd(String str, String str2, GProScheduleInfo gProScheduleInfo, final IGProCreateScheduleCallback iGProCreateScheduleCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createSchedule", "", "guildId:" + str, i3);
        this.f266768a.createSchedule(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), com.tencent.mobileqq.qqguildsdk.util.g.O0(str2), gProScheduleInfo, new IGProCreateScheduleCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.106
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleCallback
            public void onCreateSchedule(final int i16, final String str3, final GProScheduleInfo gProScheduleInfo2) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.106.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createSchedule", "", i16, str3, "", q16);
                        iGProCreateScheduleCallback.onCreateSchedule(i16, str3, gProScheduleInfo2);
                    }
                });
            }
        });
    }

    public void ye(int i3, int i16, vh2.ao aoVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        this.f266768a.fetchRecommendChannel(i3, i16, new IGProFetchRecommendChannelCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRecommendChannel", "", "businessType:" + i3 + ", limit:" + i16, i17), aoVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.52

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268999a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchRecommendChannelCallback
            public void onFetchRecommendChannel(final int i18, final String str, final int i19, final ArrayList<GProFetchRecommendChannelRsp> arrayList) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.52.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRecommendChannel", "", i18, str, "limitNum:" + i19 + " recommendChannel:" + arrayList.size(), AnonymousClass52.this.f268999a);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.GProFetchRecommendChannelRsp((GProFetchRecommendChannelRsp) it.next()));
                        }
                        getClass();
                        throw null;
                    }
                });
            }
        });
    }

    public void yf(int i3, String str, int i16, final vh2.bo boVar) {
        int i17 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i17 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", true, "sdkWrapper interface", "getMoreNoticeList", SensorJsPlugin.SENSOR_INTERVAL_UI, "noticeType:" + i3 + "guildId:" + str + ", listOffset:" + i16, i17);
        this.f266768a.getMoreNoticeList(i3, com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i16, new IGProGetMoreNoticeListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.57
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetMoreNoticeListCallback
            public void onGetMoreNoticeList(final int i18, final String str2, final boolean z16, @NonNull final ArrayList<GProNotice> arrayList, final int i19, final boolean z17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.57.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", true, "sdkWrapper callback", "on getMoreNoticeList", "", i18, str2, "noticeList:" + arrayList + " listOffset:" + i19 + " isEnd:" + z17 + " resetList:" + z16, q16);
                        List<com.tencent.mobileqq.qqguildsdk.data.co> mf5 = GProSdkWrapperImpl.this.mf(arrayList);
                        Iterator<com.tencent.mobileqq.qqguildsdk.data.co> it = mf5.iterator();
                        while (it.hasNext()) {
                            com.tencent.mobileqq.qqguildsdk.util.h.c("GProSdkWrapperImpl", false, "sdkWrapper callback", "getMoreNoticeList", "", 0, "", "noticeInfo:" + it.next().toString());
                        }
                        boVar.a(i18, str2, z16, i19, z17, mf5);
                    }
                });
            }
        });
    }

    public void yj(String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, vh2.cq cqVar) {
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "keyWord:" + str + " cookie.length:" + bArr2.length + " size:" + i3 + " type:" + i16;
        int i26 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i26 + 1;
        this.f266768a.searchUnion(str, bArr2, i3, i16, i17, i18, i19, new IGProSearchUnionCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "searchUnion", "", str2, i26), cqVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.102

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f268591a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSearchUnionCallback
            public void onResult(final int i27, final String str3, final GProSecurityResult gProSecurityResult, final boolean z16, final byte[] bArr3, final GProUnionSearchResult gProUnionSearchResult, final ArrayList<GProGuildSearchInfo> arrayList, final String str4, final int i28, final int i29, final String str5) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.102.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchUnion", "", i27, str3, GProSdkWrapperImpl.this.Qf(gProSecurityResult), AnonymousClass102.this.f268591a);
                        new com.tencent.mobileqq.qqguildsdk.data.cc(gProUnionSearchResult);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new GProGuildSearchDataInfo((GProGuildSearchInfo) it.next()));
                        }
                        getClass();
                        GProSdkWrapperImpl.this.tf(gProSecurityResult);
                        throw null;
                    }
                });
            }
        });
    }

    public void yk(String str, boolean z16, vh2.dd ddVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.setShowArchive(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), z16, new IGProSwitchPresenceArchiveCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setShowArchive", "", "clientId: " + str + ", showArchive: " + z16, i3), ddVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.81

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269228a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSwitchPresenceArchiveCallback
            public void onSwitchPresenceArchive(final int i16, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.81.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setShowArchive", "", i16, str2, "", AnonymousClass81.this.f269228a);
                        getClass();
                        com.tencent.mobileqq.qqguildsdk.util.g.W0(i17);
                        throw null;
                    }
                });
            }
        });
    }

    public void zd(String str, final IGProCreateScheduleLimitQueryCallback iGProCreateScheduleLimitQueryCallback) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "createScheduleLimitQuery", "", "guildId:" + str, i3);
        this.f266768a.createScheduleLimitQuery(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProCreateScheduleLimitQueryCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.105
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateScheduleLimitQueryCallback
            public void onCreateScheduleLimitQuery(final int i16, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.105.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "createScheduleLimitQuery", "", i16, str2, "", q16);
                        iGProCreateScheduleLimitQueryCallback.onCreateScheduleLimitQuery(i16, str2, i17);
                    }
                });
            }
        });
    }

    public void ze(String str, final vh2.m mVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        final int q16 = com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "fetchRemainAtSetInfo", "call", "guildId=" + str, i3);
        this.f266768a.fetchRemainAtSetInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), new IGProFetchAtSetInfoCallback() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.94
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProFetchAtSetInfoCallback
            public void onFetchAtSetInfoCallback(final int i16, final String str2, final GProAtSetInfo gProAtSetInfo) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.94.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRemainAtSetInfo", "callback", i16, str2, "result=" + i16 + " errMsg=" + str2 + "atSetInfo: " + gProAtSetInfo, q16);
                        mVar.a(i16, str2, com.tencent.mobileqq.qqguildsdk.util.g.L0(gProAtSetInfo));
                    }
                });
            }
        });
    }

    public IGProGuildRoleInfo zf(long j3, long j16, long j17) {
        GProGuildRole memberLevelRoleInfo = this.f266768a.getMemberLevelRoleInfo(j3, j16, j17);
        if (memberLevelRoleInfo != null) {
            return new GProGuildRoleInfo(memberLevelRoleInfo);
        }
        return null;
    }

    public void zj(@NonNull List<com.tencent.mobileqq.qqguildsdk.data.j> list) {
        String str = "reportData.size=" + list.size();
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "sendDirectMsgReadReport", "", str, i3);
        ArrayList<GProDirectMsgReport> arrayList = new ArrayList<>(list.size());
        Iterator<com.tencent.mobileqq.qqguildsdk.data.j> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.tencent.mobileqq.qqguildsdk.util.g.r(it.next()));
        }
        this.f266768a.sendDirectMsgReadReport(arrayList);
    }

    public void zk(String str, boolean z16, vh2.dd ddVar) {
        int i3 = GProSdkGenWrapperImpl.f266767c;
        GProSdkGenWrapperImpl.f266767c = i3 + 1;
        this.f266768a.setShowPresence(com.tencent.mobileqq.qqguildsdk.util.g.M0(str), z16, new IGProSwitchPresenceArchiveCallback(com.tencent.mobileqq.qqguildsdk.util.h.q("GProSdkWrapperImpl", false, "sdkWrapper interface", "setShowPresence", "", "clientId: " + str + ", showPresence: " + z16, i3), ddVar) { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.80

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f269222a;

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProSwitchPresenceArchiveCallback
            public void onSwitchPresenceArchive(final int i16, final String str2, final int i17) {
                ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.80.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.qqguildsdk.util.h.o("GProSdkWrapperImpl", false, "sdkWrapper callback", "setShowPresence", "", i16, str2, "", AnonymousClass80.this.f269222a);
                        getClass();
                        com.tencent.mobileqq.qqguildsdk.util.g.W0(i17);
                        throw null;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class GProSdkListenerImpl implements IKernelGuildListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AppRuntime> f269372a;

        public GProSdkListenerImpl(AppRuntime appRuntime) {
            this.f269372a = new WeakReference<>(appRuntime);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A0(GProDiscoveryStateChangedMsg gProDiscoveryStateChangedMsg) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onDiscoveryStateChanged", "notify", "");
            GProSdkWrapperImpl.this.ej(302, "onDiscoveryStateChanged", new GGProDiscoveryStateChangedMsg(gProDiscoveryStateChangedMsg));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A1(GProRecommendGuildInfo gProRecommendGuildInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onRecommendGuildInfoUpdate", "notify", "");
            GProSdkWrapperImpl.this.ej(AppConstants.RichMediaErrorCode.ERROR_EXP_ILLEGAL_ARGUMENT, "onRecommendGuildInfoUpdate", new GGProRecommendGuildInfo(gProRecommendGuildInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B0(int i3, String str, GProEditScheduleReq gProEditScheduleReq) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onEditSchedule", "notify", "");
            GProSdkWrapperImpl.this.ej(115, "onEditScheduleNew", Integer.valueOf(i3), str, gProEditScheduleReq);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B1(GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onRecommendGuildPersonalSettingUpdate", "notify", "");
            GProSdkWrapperImpl.this.ej(AppConstants.RichMediaErrorCode.ERROR_EXP_SECURITY, "onRecommendGuildPersonalSettingUpdate", new GGProRecommendGuildPersonalSetting(gProRecommendGuildPersonalSetting));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onEnterSpeakQueueNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.l0(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C1(ArrayList arrayList) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onRecommendGuildPollingResult", "notify", "");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new GGProPollingData((GProPollingData) it.next()));
            }
            GProSdkWrapperImpl.this.ej(FileMsg.RESULT_CODE_HTTPDECODE_EXCEPTION, "onRecommendGuildPollingResult", arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D0(GProGlobalBanner gProGlobalBanner) {
            GProSdkWrapperImpl.this.ej(9002, "onGlobalBannerRemoved", new GGProGlobalBanner(gProGlobalBanner));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D1(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onRecommendGuildStickyTopUpdated", "notify", "");
            ArrayList arrayList4 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList4.add(new GGProStickyChannel((GProStickyChannel) it.next()));
            }
            GProSdkWrapperImpl.this.ej(9024, "onRecommendGuildStickyTopAdd", arrayList4);
            ArrayList arrayList5 = new ArrayList();
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                arrayList5.add(new GGProStickyChannel((GProStickyChannel) it5.next()));
            }
            GProSdkWrapperImpl.this.ej(9025, "onRecommendGuildStickyTopUpdate", arrayList5);
            ArrayList arrayList6 = new ArrayList();
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                arrayList6.add(new GGProStickyChannel((GProStickyChannel) it6.next()));
            }
            GProSdkWrapperImpl.this.ej(9026, "onRecommendGuildStickyTopRemove", arrayList6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E0(GProGlobalBanner gProGlobalBanner) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "sdk callback", "onGlobalBannerUpdated", "notify", "gid=" + gProGlobalBanner.getGuildId() + ", bannerId=" + gProGlobalBanner.getBannerId());
            GProSdkWrapperImpl.this.ej(9001, "onGlobalBannerUpdated", new GGProGlobalBanner(gProGlobalBanner));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void E1(int i3, String str) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onReportSqliteError", "notify", "result=" + i3 + ", errMsg=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("ret", String.valueOf(i3));
            hashMap.put("msg", str);
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#error_code#gprosdk_sqlite", hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F0(GProCreateGuildGuideInfo gProCreateGuildGuideInfo) {
            int size = gProCreateGuildGuideInfo.getTaskList().size();
            ArrayList arrayList = new ArrayList();
            Iterator<GProTaskInfo> it = gProCreateGuildGuideInfo.getTaskList().iterator();
            boolean z16 = false;
            int i3 = 0;
            while (it.hasNext()) {
                GProTaskInfo next = it.next();
                if (next.getStatus() == 1) {
                    i3++;
                }
                arrayList.add(new GGProTaskInfo(next));
            }
            GProSdkWrapperImpl gProSdkWrapperImpl = GProSdkWrapperImpl.this;
            Object[] objArr = new Object[6];
            objArr[0] = String.valueOf(gProCreateGuildGuideInfo.getGuildId());
            objArr[1] = Integer.valueOf(gProCreateGuildGuideInfo.getSkipStatus());
            if (i3 == size) {
                z16 = true;
            }
            objArr[2] = Boolean.valueOf(z16);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(size);
            objArr[5] = arrayList;
            gProSdkWrapperImpl.ej(92, "onGuildCreatorGuideUpdated", objArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onRobotStateChangeNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.n0(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G0() {
            com.tencent.mobileqq.qqguildsdk.util.h.u("GProSdkWrapperImpl", false, "system notify", "onGuildListLoaded");
            GProSdkWrapperImpl gProSdkWrapperImpl = GProSdkWrapperImpl.this;
            gProSdkWrapperImpl.f268560g = true;
            gProSdkWrapperImpl.ej(50, "onGuildListLoaded", 0, "");
            GProSdkWrapperImpl.this.ej(81, "onGuildListLoaded", new Object[0]);
            GProSdkWrapperImpl.this.ej(1, "onGuildListLoaded", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onSmobaGameUserChangeNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.c(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void H0(long j3, ArrayList arrayList) {
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GProSdkWrapperImpl.this.ej(15, "onGuildUserAvatarMetasUpdated", X0, com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) it.next()).longValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void H1(ArrayList arrayList, ArrayList arrayList2) {
            ArrayList<String> Y0 = com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList);
            ArrayList<com.tencent.mobileqq.qqguildsdk.data.fc> v06 = com.tencent.mobileqq.qqguildsdk.util.g.v0(arrayList2);
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < Y0.size(); i3++) {
                sb5.append("gid=");
                sb5.append(Y0.get(i3));
                sb5.append("thres=");
                sb5.append(v06.get(i3));
            }
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onSpeakableThresholdUpdate", "notify", sb5.toString());
            GProSdkWrapperImpl.this.D0(Y0, v06);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I0(HashMap hashMap) {
            for (Map.Entry entry : hashMap.entrySet()) {
                GProSdkWrapperImpl.this.ej(1501, "onGuildUserAvatarPendantsUpdated", com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) entry.getKey()).longValue()), (String) entry.getValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserAVStateResetNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.d0(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J0(long j3, ArrayList arrayList) {
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GProSdkWrapperImpl.this.ej(80, "onGuildUserChannelCategoryAdminListUpdated", X0, com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) it.next()).longValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserEnterListNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.Y(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K0(long j3, ArrayList arrayList) {
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GProSdkWrapperImpl.this.ej(42, "onGuildUserClientIdentitiesUpdated", X0, com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) it.next()).longValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K1(GProUserGuideMsg gProUserGuideMsg) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserGuidePush", "notify", "");
            GProSdkWrapperImpl.this.ej(303, "onUserGuidePush", new GGProUserGuideMsg(gProUserGuideMsg));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void L0(long j3, HashMap hashMap) {
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                GProSdkWrapperImpl.this.ej(96, "onGuildUserLevelRolesChanged", X0, com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) ((Map.Entry) it.next()).getKey()).longValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void L1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserHandUpRequestNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.j0(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void M0(HashMap hashMap) {
            for (Map.Entry entry : hashMap.entrySet()) {
                GProSdkWrapperImpl.this.ej(24, "onGuildUserMedalsUpdated", com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) entry.getKey()).longValue()), (String) entry.getValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void M1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserLeaveListNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.C0(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void N0(long j3, HashMap hashMap) {
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                String X02 = com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) entry.getKey()).longValue());
                arrayList.add(new com.tencent.mobileqq.qqguildsdk.data.fh(X02, (String) entry.getValue()));
                GProSdkWrapperImpl.this.ej(120, "onGuildUserMemberNamesUpdated", X02);
            }
            GProSdkWrapperImpl.this.ej(62, "onGuildUserMemberNamesUpdated", X0, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void N1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserSpeakingNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.W(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O0(HashMap hashMap) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) entry.getKey()).longValue());
                String str = (String) entry.getValue();
                arrayList.add(new com.tencent.mobileqq.qqguildsdk.data.fh(X0, str));
                GProSdkWrapperImpl.this.ej(14, "onGuildUserNicknamesUpdated", X0, str);
                GProSdkWrapperImpl.this.ej(120, "onGuildUserNicknamesUpdated", X0);
            }
            GProSdkWrapperImpl.this.ej(60, "onGuildUserNicknamesUpdated", arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O1(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onUserWaitingToSpeakNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.C(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void P0(long j3, ArrayList arrayList) {
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GProSdkWrapperImpl.this.ej(80, "onGuildUserTopRolesChanged", X0, com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) it.next()).longValue()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void P1(long j3, long j16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onVoiceHeartbeatTimeout", "notify", "gid=" + j3 + ", cid=" + j16);
            GProSdkWrapperImpl.this.o(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
            GProSdkWrapperImpl.this.ej(53, "onVoiceHeartbeatTimeout", com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Q0(int i3, String str, GProModifyScheduleInviteReq gProModifyScheduleInviteReq) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onModifyInviteStatus", "notify", "");
            GProSdkWrapperImpl.this.ej(119, "onModifyScheduleInviteStatusNew", Integer.valueOf(i3), str, gProModifyScheduleInviteReq);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void R0(String str, boolean z16, HashMap hashMap) {
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricCount(GuildNTConstants.f268493b.get(str), z16, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void S0(String str, HashMap hashMap, long j3) {
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildNTConstants.f268492a.get(str), hashMap, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void T0(String str, HashMap hashMap) {
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent(str, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U0(ArrayList arrayList, boolean z16) {
            GProSdkWrapperImpl.this.ej(9102, "onPollingGuildRefresh", com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList), Boolean.valueOf(z16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void V0(ArrayList arrayList, List list, HashSet hashSet, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, HashSet hashSet2, ArrayList arrayList6) {
            GProSdkWrapperImpl.this.z(arrayList);
            GProSdkWrapperImpl.this.G(list);
            GProSdkWrapperImpl.this.a(hashSet);
            GProSdkWrapperImpl.this.g(arrayList2);
            GProSdkWrapperImpl.this.R(arrayList3);
            GProSdkWrapperImpl.this.h(arrayList4);
            GProSdkWrapperImpl.this.P(arrayList5);
            GProSdkWrapperImpl.this.w(new ArrayList(hashSet2));
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPollingResult", "aohe#", "size=" + arrayList6.size());
            if (arrayList6.size() == 1) {
                GProSdkWrapperImpl.this.i((GProSchedulePollingInfo) arrayList6.get(0));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W0(String str) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushAVChannelAppMsg", "notify", "channelAppMsgInfo=" + str);
            GProSdkWrapperImpl.this.Q(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void X0(long j3, long j16, GProAVChannelConfig gProAVChannelConfig) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushAVChannelConfigUpdate", "notify", "guildId=" + j3 + " ,channelId=" + j16 + " ,config=" + gProAVChannelConfig);
            GProSdkWrapperImpl.this.f0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), gProAVChannelConfig);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Y0(long j3, long j16, int i3, String str, String str2) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushAVChannelPlayListChange", "notify", "guildId=" + j3 + " ,channelId=" + j16 + " ,sourceNum=" + i3 + ", grayTips = " + str + " ,info=" + str2);
            GProSdkWrapperImpl.this.L(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), str2, i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Z0(int i3, String str, GProHeartbeatRsq gProHeartbeatRsq) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "system notify", "onPushAVHeartbeatRsp", "notify", "result=" + i3 + ", errMsg=" + str + ", heartbeatRsq=" + gProHeartbeatRsq);
            GProSdkWrapperImpl.this.S(i3, str, new GGProHeartbeatRsq(gProHeartbeatRsq));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a1(GProAVRoomOptPushInfo gProAVRoomOptPushInfo) {
            String roomId;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("guildId=");
            sb5.append(gProAVRoomOptPushInfo.getGuildId());
            sb5.append(", channelId=");
            sb5.append(gProAVRoomOptPushInfo.getChannelId());
            sb5.append(", optType=");
            sb5.append(gProAVRoomOptPushInfo.getOptType());
            sb5.append(", switchRoomId=");
            sb5.append(gProAVRoomOptPushInfo.getSwitchRoomId());
            sb5.append(", delRoomId=");
            sb5.append(gProAVRoomOptPushInfo.getDelRoomId());
            sb5.append(", addUpRoomId=");
            if (gProAVRoomOptPushInfo.getRoomAddUpInfo() == null) {
                roomId = "";
            } else {
                roomId = gProAVRoomOptPushInfo.getRoomAddUpInfo().getRoomId();
            }
            sb5.append(roomId);
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushAVRoomOptChange", "notify", sb5.toString());
            GProSdkWrapperImpl.this.K0(new GGProAVRoomOptPushInfo(gProAVRoomOptPushInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b1(GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushAVUserStateChange", "notify", "gid=" + gProAVUserStateChangeInfo.getGuildId() + ", cid=" + gProAVUserStateChangeInfo.getChannelId() + ", tinyId=" + gProAVUserStateChangeInfo.getTinyId() + ", msg=" + gProAVUserStateChangeInfo.getMsg());
            GProSdkWrapperImpl.this.I(new GGProAVUserStateChangeInfo(gProAVUserStateChangeInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c1(long j3, long j16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushAddChannelSpeakPermission", "notify", "guildId=" + j3 + ", channelId=" + j16);
            GProSdkWrapperImpl.this.E(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d1(long j3, boolean z16, boolean z17, boolean z18, long j16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushBannedStatusChanged", "notify", "guildId=" + j3 + ", isValid=" + z16 + ", isBanned=" + z17 + ", isFrozen=" + z18 + ", guildBannedTimeLimit=" + j16);
            GProSdkWrapperImpl.this.g0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), z16, z17, z18, j16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e1(int i3, byte[] bArr) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushBussinessConfig", "notify", "bussinessId=" + i3);
            GProSdkWrapperImpl.this.K(i3, bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f1(GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushCanceledSpeak", "notify", "gid=" + gProAVUserStateChangeInfo.getGuildId() + ", cid=" + gProAVUserStateChangeInfo.getChannelId() + ", tinyId=" + gProAVUserStateChangeInfo.getTinyId() + ", msg=" + gProAVUserStateChangeInfo.getMsg());
            GProSdkWrapperImpl.this.o0(new GGProAVUserStateChangeInfo(gProAVUserStateChangeInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g1(long j3, long j16, int i3, ArrayList arrayList) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelAdminChange", "notify", "guildId=" + j3 + ", channelId=" + j16 + ", changeType=" + i3 + ", listSize=" + arrayList.size());
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            String X02 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j16);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) it.next()).longValue()));
            }
            GProSdkWrapperImpl.this.B(X0, X02, i3, arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h1(ArrayList arrayList) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelStateChange", "notify", "channelState size=" + arrayList.size());
            GProSdkWrapperImpl.this.v(ChannelStateUtil.b(arrayList));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i1(long j3, ArrayList arrayList, ArrayList arrayList2, long j16, long j17) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelTopMsgUpdated", "notify", "guildId: " + j3 + ", oldlist.size: " + arrayList.size() + ", newList.size: " + arrayList2.size());
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            String X02 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j16);
            String X03 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j17);
            ArrayList<IGProTopMsg> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new GProTopMsgInfo((GProTopMsg) it.next()));
            }
            ArrayList<IGProTopMsg> arrayList4 = new ArrayList<>();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList4.add(new GProTopMsgInfo((GProTopMsg) it5.next()));
            }
            GProSdkWrapperImpl.this.z0(X0, X02, X03, arrayList3, arrayList4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j1(ArrayList arrayList, long j3) {
            GProSdkWrapperImpl.this.A(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), new com.tencent.mobileqq.qqguildsdk.data.bg(new HashSet(arrayList)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k1(GProGuildStateRspInfo gProGuildStateRspInfo) {
            GProSdkWrapperImpl.this.x(gProGuildStateRspInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l1(long j3, long j16, long j17, String str) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushInvitationRefused", "notify", "gid=" + j3 + ", cid=" + j16 + ", tid=" + j17 + ", nickName=" + str);
            GProSdkWrapperImpl.this.ej(3109, "onPushInvitationRefused", com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m1(long j3, long j16, long j17, GProSchemeConfig gProSchemeConfig) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushInviteMemberEvent", "notify", "guildId: " + j3 + ", channelId: " + j16 + ", tinyId: " + j17 + ", schema: " + gProSchemeConfig.getSchema());
            GProSdkWrapperImpl.this.k(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), new GuildSchemaConfig(gProSchemeConfig));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n1(GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushInvitedToSpeak", "notify", "gid=" + gProAVUserStateChangeInfo.getGuildId() + ", cid=" + gProAVUserStateChangeInfo.getChannelId() + ", tinyId=" + gProAVUserStateChangeInfo.getTinyId() + ", msg=" + gProAVUserStateChangeInfo.getMsg());
            GProSdkWrapperImpl.this.ej(3103, "onPushInvitedToSpeak", new GGProAVUserStateChangeInfo(gProAVUserStateChangeInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o1(long j3, long j16, boolean z16, long j17) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushPermissionInGuild", "notify", "guildId=" + j3 + " ,tinyId=" + j16 + " ,bAllow=" + z16 + " ,source=" + j17);
            GProSdkWrapperImpl.this.y(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), z16, j17);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p1(GProPreventAddictionPushInfo gProPreventAddictionPushInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushPreventAddictionInstructions", "notify", "pushInfo=" + gProPreventAddictionPushInfo);
            GProSdkWrapperImpl.this.f(new com.tencent.mobileqq.qqguildsdk.data.o(gProPreventAddictionPushInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q1(long j3, long j16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushRemoveChannelSpeakPermission", "notify", "guildId=" + j3 + ", channelId=" + j16);
            GProSdkWrapperImpl.this.y0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r1(GProSendGiftEventData gProSendGiftEventData) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushSendGiftEventNotify", "notify", "");
            GGProSendGiftEventData gGProSendGiftEventData = new GGProSendGiftEventData(gProSendGiftEventData);
            GProSdkWrapperImpl.this.ej(AppConstants.RichMediaErrorCode.ERROR_NET_SOCKET_EXCEPTION, "onPushSendGiftEventNotify", com.tencent.mobileqq.qqguildsdk.util.g.X0(gGProSendGiftEventData.getGuildId()), com.tencent.mobileqq.qqguildsdk.util.g.X0(gGProSendGiftEventData.getChannelId()), gGProSendGiftEventData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s1(long j3, long j16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushShutUpStateChanged", "notify", "guildId=" + j3 + ", expireTime=" + j16);
            GProSdkWrapperImpl.this.q0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), j16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t1(GProUserGiftRankInfo gProUserGiftRankInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushUserGiftRankChangeNotify", "notify", "");
            GGProUserGiftRankInfo gGProUserGiftRankInfo = new GGProUserGiftRankInfo(gProUserGiftRankInfo);
            GProSdkWrapperImpl.this.ej(AppConstants.RichMediaErrorCode.ERROR_NET_CONNECT_TIMEOUT, "onPushUserGiftRankChangeNotify", com.tencent.mobileqq.qqguildsdk.util.g.X0(gGProUserGiftRankInfo.getGuildId()), com.tencent.mobileqq.qqguildsdk.util.g.X0(gGProUserGiftRankInfo.getChannelId()), gGProUserGiftRankInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u1(GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onPushUserHandUpResult", "notify", "gid=" + gProAVUserStateChangeInfo.getGuildId() + ", cid=" + gProAVUserStateChangeInfo.getChannelId() + ", tinyId=" + gProAVUserStateChangeInfo.getTinyId() + ", msg=" + gProAVUserStateChangeInfo.getMsg());
            GProSdkWrapperImpl.this.U(new GGProAVUserStateChangeInfo(gProAVUserStateChangeInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v0(long j3, long j16, GProAVChannelConfig gProAVChannelConfig) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onAVChannelThemeUpdate", "notify", "guildId=" + j3 + " ,channelId=" + j16 + " ,themeType=" + gProAVChannelConfig.getThemeInfo().getThemeType());
            GProSdkWrapperImpl.this.ej(230, "onAVChannelThemeUpdate", com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), new GGProAVChannelConfig(gProAVChannelConfig));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v1() {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onQQMsgListChannelDataReady", "notify", "");
            GProSdkWrapperImpl.this.b0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onAVUserInfoChangeNotifyForAll", "notify", "gid=" + gProChannelUserChangeInfo.getGuildId() + ", cid=" + gProChannelUserChangeInfo.getChannelId() + ", list size=" + gProChannelUserChangeInfo.getChangeUserList().size());
            GProSdkWrapperImpl.this.b(gProChannelUserChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w1(ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onQQMsgListChannelUpdated", "notify", "ops=" + arrayList + ", list=" + arrayList2);
            GProSdkWrapperImpl.this.u0(arrayList, com.tencent.mobileqq.qqguildsdk.util.g.T0(arrayList2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x0(long j3, ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onAppChannelPreInfosUpdated", "notify", "gid=" + j3 + ", removedCids=" + arrayList.size() + ", changedCids=" + arrayList2.size());
            GProSdkWrapperImpl.this.ej(52, "onAppChannelPreInfosUpdated", com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x1(ArrayList arrayList, ArrayList arrayList2) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onQQMsgListGuildUpdated", "notify", "ops=" + arrayList + ", list=" + arrayList2);
            GProSdkWrapperImpl.this.u(arrayList, com.tencent.mobileqq.qqguildsdk.util.g.V0(arrayList2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y0(long j3, String str, int i3) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onChangeGuildNumber", "notify", "");
            GProSdkWrapperImpl.this.ej(9030, "onChangeGuildNumber", Long.valueOf(j3), str, Integer.valueOf(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y1(int i3, long j3, int i16) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onRecentVisitGuildListChange", "notify", "changeType : " + i3 + ", timeStamp : " + j3 + ", changeNum" + i16);
            GProSdkWrapperImpl.this.J(i3, j3, i16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z0(long j3, ArrayList arrayList) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onChannelUserPermissionChange", "notify", "guildId=" + j3 + ", listSize=" + arrayList.size());
            String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(com.tencent.mobileqq.qqguildsdk.util.g.X0(((Long) it.next()).longValue()));
            }
            GProSdkWrapperImpl.this.F(X0, arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z1(GProGuildData gProGuildData) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "sdk callback", "onRecommendGuildChannelListUpdate", "notify", "");
            GProSdkWrapperImpl.this.ej(9021, "onRecommendGuildChannelListUpdate", new GGProGuildData(gProGuildData));
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onAVChannelThemeUpdate(final long j3, final long j16, final GProAVChannelConfig gProAVChannelConfig) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hc
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.v0(j3, j16, gProAVChannelConfig);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onAVUserInfoChangeNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ga
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.w0(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onAllGuildChannelListFetchCompleted() {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "system notify", "onAllGuildChannelListFetchCompleted", "notify", "Guild cost, in logic thread!");
            GProSdkWrapperImpl.this.H0();
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    GProSdkWrapperImpl.this.f268564k = true;
                    GProSdkWrapperImpl.this.G0();
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onAnchorStatusChange(long j3, long j16, int i3) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.d(this, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onAppChannelPreInfosUpdated(final long j3, final ArrayList<Long> arrayList, final ArrayList<Long> arrayList2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gg
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.x0(j3, arrayList, arrayList2);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onBroadcastHelperDownloadComplete(GProBroadcastHelperTransNotifyInfo gProBroadcastHelperTransNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.g(this, gProBroadcastHelperTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onBroadcastHelperProgerssUpdate(GProBroadcastHelperTransNotifyInfo gProBroadcastHelperTransNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.h(this, gProBroadcastHelperTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onBroadcastRoomClose(long j3, int i3, String str) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.i(this, j3, i3, str);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onBroadcastUserCountUpdate(long j3, int i3) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.j(this, j3, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onChangeGuildNumber(final long j3, final String str, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gx
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.y0(j3, str, i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onChannelInfoUpdated(final int i3, final String str, final GProChannel gProChannel) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    GProChannelInfo gProChannelInfo;
                    int i16 = i3;
                    String str3 = str;
                    if (gProChannel != null) {
                        str2 = "guildId : " + gProChannel.getGuildId() + "\uff0c channeluin \uff1a" + gProChannel.getChannelId() + "\uff0c gotoChannel:" + gProChannel.getGotoChannelId() + " switch:" + gProChannel.getSwitchJumpChannelId();
                    } else {
                        str2 = "channelinfo is null";
                    }
                    com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onChannelInfoUpdated", "notify", i16, str3, str2);
                    GProSdkWrapperImpl gProSdkWrapperImpl = GProSdkWrapperImpl.this;
                    int i17 = i3;
                    GProChannel gProChannel2 = gProChannel;
                    if (gProChannel2 != null) {
                        gProChannelInfo = new GProChannelInfo(gProChannel2);
                    } else {
                        gProChannelInfo = null;
                    }
                    gProSdkWrapperImpl.e0(i17, gProChannelInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onChannelListUpdated(final int i3, final String str, final long j3, final int i16, final HashMap<Long, GProChannel> hashMap, final GProCategoryChannelIdList gProCategoryChannelIdList, final ArrayList<GProCategoryChannelIdList> arrayList) {
            Iterator<GProCategoryChannelIdList> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onChannelListUpdated", "notify", i3, str, "name : " + it.next().name);
            }
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    int i17;
                    int i18 = i3;
                    String str2 = str;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("size : ");
                    HashMap hashMap2 = hashMap;
                    if (hashMap2 != null) {
                        i17 = hashMap2.size();
                    } else {
                        i17 = 0;
                    }
                    sb5.append(i17);
                    sb5.append(", sourceType=");
                    sb5.append(i16);
                    com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onChannelListUpdated", "notify", i18, str2, sb5.toString());
                    GProSdkWrapperImpl.this.H(i3, com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), i16, com.tencent.mobileqq.qqguildsdk.util.g.p(hashMap), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onChannelUserPermissionChange(final long j3, final ArrayList<Long> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gl
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.z0(j3, arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onDiscoveryStateChanged(final GProDiscoveryStateChangedMsg gProDiscoveryStateChangedMsg) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fv
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.A0(gProDiscoveryStateChangedMsg);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onEditSchedule(final int i3, final String str, final GProEditScheduleReq gProEditScheduleReq) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ha
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.B0(i3, str, gProEditScheduleReq);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onEnterSpeakQueueNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gd
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.C0(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGetSelfTinyId(final long j3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.32
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onGetSelfTinyId", "notify", "tinyId:" + j3);
                    long j16 = j3;
                    if (j16 == 0) {
                        com.tencent.mobileqq.qqguildsdk.util.h.v("GProSdkWrapperImpl", "onGetSelfTinyId", "tinyId:" + j3);
                        return;
                    }
                    GProSdkWrapperImpl.this.xk(com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGlobalBannerRemoved(final GProGlobalBanner gProGlobalBanner) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hj
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.D0(gProGlobalBanner);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGlobalBannerUpdated(final GProGlobalBanner gProGlobalBanner) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fj
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.E0(gProGlobalBanner);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildCreatorGuideUpdated(final GProCreateGuildGuideInfo gProCreateGuildGuideInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fy
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.F0(gProCreateGuildGuideInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildInfoUpdated(final int i3, final String str, final GProGuild gProGuild, final boolean z16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    GProGuildInfo gProGuildInfo;
                    String str2;
                    GProGuild gProGuild2 = gProGuild;
                    if (gProGuild2 != null) {
                        gProGuildInfo = new GProGuildInfo(gProGuild2);
                    } else {
                        gProGuildInfo = null;
                    }
                    int i16 = i3;
                    String str3 = str;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("guildId :");
                    if (gProGuildInfo != null) {
                        str2 = gProGuildInfo.getGuildID() + ", usertype : " + gProGuildInfo.getUserType() + ", fetchChannelList : " + z16;
                    } else {
                        str2 = "null";
                    }
                    sb5.append(str2);
                    com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onGuildInfoUpdated", "notify", i16, str3, sb5.toString());
                    GProSdkWrapperImpl.this.B0(i3, gProGuildInfo, z16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildListLoaded() {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hg
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.G0();
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildListUpdated(final int i3, final String str, final boolean z16, final ArrayList<Long> arrayList, final ArrayList<GProGuild> arrayList2, final GProGuildListSortInfo gProGuildListSortInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    int i16;
                    int i17 = i3;
                    String str2 = str;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("isChanged : ");
                    sb5.append(z16);
                    sb5.append(", size : ");
                    ArrayList arrayList3 = arrayList2;
                    if (arrayList3 != null) {
                        i16 = arrayList3.size();
                    } else {
                        i16 = 0;
                    }
                    sb5.append(i16);
                    com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onGuildListUpdated", "notify", i17, str2, sb5.toString());
                    GProSdkWrapperImpl.this.m(i3, str, z16, com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.t(arrayList2), gProGuildListSortInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserAvatarMetasUpdated(final long j3, final ArrayList<Long> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.er
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.H0(j3, arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserAvatarPendantsUpdated(final HashMap<Long, String> hashMap) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.he
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.I0(hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserChannelCategoryAdminListUpdated(final long j3, final ArrayList<Long> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gj
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.J0(j3, arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserClientIdentitiesUpdated(final long j3, final ArrayList<Long> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gp
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.K0(j3, arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserLevelRolesChanged(final long j3, final HashMap<Long, Integer> hashMap) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gz
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.L0(j3, hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserMedalsUpdated(final HashMap<Long, String> hashMap) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hk
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.M0(hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserMemberNamesUpdated(final long j3, final HashMap<Long, String> hashMap) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gb
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.N0(j3, hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserNicknamesUpdated(final HashMap<Long, String> hashMap) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ge
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.O0(hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onGuildUserTopRolesChanged(final long j3, final ArrayList<Long> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ey
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.P0(j3, arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onLocalMemberCountUpdate(long j3, long j16) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.H(this, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onMemberCountUpdate(final GProGuildMemberCountInfo gProGuildMemberCountInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.31
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (("memberCountInfo:" + gProGuildMemberCountInfo) != null) {
                        str = gProGuildMemberCountInfo.toString();
                    } else {
                        str = " is null";
                    }
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onMemberCountUpdate", "notify", str);
                    GProSdkWrapperImpl.this.t(com.tencent.mobileqq.qqguildsdk.util.g.e0(gProGuildMemberCountInfo));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onModifyInviteStatus(final GProModifyScheduleInviteReq gProModifyScheduleInviteReq, final int i3, final String str) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.go
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.Q0(i3, str, gProModifyScheduleInviteReq);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onOpenTelemetryMetricCountReport(final String str, final HashMap<String, String> hashMap, final boolean z16) {
            if (!GuildNTConstants.f268493b.containsKey(str)) {
                return;
            }
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ff
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.R0(str, z16, hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onOpenTelemetryMetricTimeCostReport(final String str, final HashMap<String, String> hashMap, final long j3) {
            if (!GuildNTConstants.f268492a.containsKey(str)) {
                return;
            }
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fn
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.S0(str, hashMap, j3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onOpenTelemetryTraceReport(final String str, final HashMap<String, String> hashMap) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gu
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.T0(str, hashMap);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPollingGuildRefresh(final ArrayList<Long> arrayList, final boolean z16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gf
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.U0(arrayList, z16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPollingResult(ArrayList<GProPollingChannelState> arrayList) {
            com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPollingResult", "notify", "channelStates size: " + arrayList.size());
            final ArrayList arrayList2 = new ArrayList();
            final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            final ArrayList arrayList3 = new ArrayList();
            final ArrayList arrayList4 = new ArrayList();
            final ArrayList arrayList5 = new ArrayList();
            final ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final ArrayList arrayList8 = new ArrayList();
            Iterator<GProPollingChannelState> it = arrayList.iterator();
            while (it.hasNext()) {
                GProPollingChannelState next = it.next();
                hashSet.add(String.valueOf(next.getGuildId()));
                if (next.getType() == 1) {
                    arrayList2.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                    hashSet2.add(String.valueOf(next.getGuildId()));
                } else if (next.getType() == 2) {
                    copyOnWriteArrayList.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                    hashSet2.add(String.valueOf(next.getGuildId()));
                } else if (next.getType() == 6) {
                    arrayList3.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                } else if (next.getType() == 9) {
                    arrayList4.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                } else if (next.getType() == 11) {
                    arrayList5.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                } else if (next.getType() == 15) {
                    arrayList6.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                } else if (next.getType() == 18) {
                    arrayList7.add(new com.tencent.mobileqq.qqguildsdk.data.bi(next));
                } else if (next.getType() == 23) {
                    arrayList8.add(next.schedulePollingInfo);
                }
            }
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gt
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.V0(arrayList2, copyOnWriteArrayList, hashSet2, arrayList4, arrayList5, arrayList3, arrayList6, hashSet, arrayList8);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAVChannelAppMsg(final String str) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gv
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.W0(str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAVChannelConfigUpdate(final long j3, final long j16, final GProAVChannelConfig gProAVChannelConfig) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hh
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.X0(j3, j16, gProAVChannelConfig);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAVChannelPlayListChange(final long j3, final long j16, final String str, final int i3, final String str2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gk
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.Y0(j3, j16, i3, str2, str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAVHeartbeatRsp(final int i3, final String str, final GProHeartbeatRsq gProHeartbeatRsq) {
            if (i3 != 0) {
                com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "system notify", "onPushAVHeartbeatRsp", "notify", "result=" + i3 + ", errMsg=" + str);
                return;
            }
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fg
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.Z0(i3, str, gProHeartbeatRsq);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAVRoomOptChange(final GProAVRoomOptPushInfo gProAVRoomOptPushInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fs
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.a1(gProAVRoomOptPushInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAVUserStateChange(final GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fu
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.b1(gProAVUserStateChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAddChannelSpeakPermission(final long j3, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fa
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.c1(j3, j16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAdminChanged(final long j3, final boolean z16, final long j16, final long j17) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.15
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushAdminChanged", "", "guildId : " + j3 + "\uff0c operatorTinyId \uff1a" + j16 + "\uff0c adminTinyId \uff1a" + j17 + "\uff0c bAdmin\uff1a" + z16);
                    GProSdkWrapperImpl.this.O(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), z16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAllowScreenShareInGuild(final long j3, final long j16, final boolean z16, final long j17) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.24
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushAllowScreenShareInGuild", "notify", "guildId=" + j3 + ", tinyId=" + j16 + ", bAllow = " + z16 + ", source = " + j17);
                    GProSdkWrapperImpl.this.h0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), z16, j17);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAudioChannelUserPlatSwitch(final long j3, final long j16, final long j17, int i3, final int i16, final String str, long j18) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.20
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushAudioChannelUserPlatSwitch", "notify", "guildId:" + j3 + ", channelId: " + j16 + ", tinyId:" + j17);
                    GProSdkWrapperImpl.this.t0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), i16, str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushBannedStatusChanged(final long j3, final boolean z16, final boolean z17, final boolean z18, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.et
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.d1(j3, z16, z17, z18, j16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushBussinessConfig(final int i3, final byte[] bArr) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ev
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.e1(i3, bArr);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushCanceledSpeak(final GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gq
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.f1(gProAVUserStateChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChangeRoleMember(final long j3, final ArrayList<GProRoleMemberChangeInfo> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.41
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChangeRoleMember", "notify", "guildId: " + j3);
                    GProSdkWrapperImpl.this.n(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.F0(arrayList));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelAdminChange(final long j3, final long j16, final int i3, final ArrayList<Long> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fk
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.g1(j3, j16, i3, arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelCategoryChanged(final GProGuildInit gProGuildInit) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.30
                @Override // java.lang.Runnable
                public void run() {
                    if (gProGuildInit != null) {
                        com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelCategoryChanged", "notify", "getGuildId:" + gProGuildInit.getGuildId());
                        GProSdkWrapperImpl.this.I0(com.tencent.mobileqq.qqguildsdk.util.g.X0(gProGuildInit.getGuildId()), com.tencent.mobileqq.qqguildsdk.util.g.d0(gProGuildInit));
                        return;
                    }
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelCategoryChanged", "notify", "guildInit is null");
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelCreated(final long j3, long j16, final GProGuildInit gProGuildInit) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.13
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb5;
                    long j17;
                    if (gProGuildInit != null) {
                        sb5 = new StringBuilder();
                        sb5.append("guildId : ");
                        j17 = gProGuildInit.getGuildId();
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append("\uff0c channelId\uff1a");
                        j17 = j3;
                    }
                    sb5.append(j17);
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelCreated", "", sb5.toString());
                    GProGuildInit gProGuildInit2 = gProGuildInit;
                    if (gProGuildInit2 != null) {
                        GProSdkWrapperImpl.this.M(com.tencent.mobileqq.qqguildsdk.util.g.X0(gProGuildInit2.getGuildId()), com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.d0(gProGuildInit));
                    }
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelDestroy(final long j3, final ArrayList<Long> arrayList, long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.14
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelDestroy", "", "guildId : " + j3);
                    GProSdkWrapperImpl.this.i0(com.tencent.mobileqq.qqguildsdk.util.g.Y0(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.X0(j3));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelStateChange(final ArrayList<GProChannelState> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fz
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.h1(arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelTopMsgUpdated(final long j3, final long j16, final long j17, final ArrayList<GProTopMsg> arrayList, final ArrayList<GProTopMsg> arrayList2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gy
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.i1(j3, arrayList2, arrayList, j16, j17);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushChannelVisibleChanged(final long j3, final long j16, final int i3, final int i16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.33
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushChannelVisibleChanged", "notify", "guildId: " + j3 + ", channelId: " + j16 + ", type: " + i3 + "->" + i16);
                    GProSdkWrapperImpl.this.N(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), i3, i16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushCreateGuild(final long j3, final GProGuild gProGuild, final HashMap<Long, GProChannel> hashMap, final GProCategoryChannelIdList gProCategoryChannelIdList, final ArrayList<GProCategoryChannelIdList> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushCreateGuild", "", "guildId : " + j3);
                    GProSdkWrapperImpl.this.Z(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), new GProGuildInfo(gProGuild), com.tencent.mobileqq.qqguildsdk.util.g.p(hashMap), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushCreateRole(final long j3, final ArrayList<GProGuildRole> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.37
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushCreateRole", "notify", "guildId: " + j3);
                    GProSdkWrapperImpl.this.E0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushDeleteRole(final long j3, final ArrayList<GProGuildRole> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.38
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushDeleteRole", "notify", "guildId: " + j3);
                    GProSdkWrapperImpl.this.x0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.v(arrayList));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushDestroyGuild(final long j3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushDestroyGuild", "", "guildId : " + j3);
                    GProSdkWrapperImpl.this.V(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushDirectMsgSwitchUpdate(final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.17
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushDirectMsgSwitchUpdate", "switchStatus", "switchStatus : " + i3);
                    GProSdkWrapperImpl.this.p0(i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushGuildPermissionChanged(final long j3, final ArrayList<Integer> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ew
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.j1(arrayList, j3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushGuildStateChange(int i3, String str, final GProGuildStateRspInfo gProGuildStateRspInfo) {
            if (i3 != 0) {
                com.tencent.mobileqq.qqguildsdk.util.h.k("GProSdkWrapperImpl", 1, "onPushGuildStateChange", "result=" + i3 + ", errMsg=" + str);
                return;
            }
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fl
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.k1(gProGuildStateRspInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushInvitationRefused(final long j3, final long j16, final long j17, final String str) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gw
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.l1(j3, j16, j17, str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushInviteMemberEvent(final long j3, final long j16, final long j17, final GProSchemeConfig gProSchemeConfig) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.es
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.m1(j3, j16, j17, gProSchemeConfig);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushInvitedToSpeak(final GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fd
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.n1(gProAVUserStateChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushJoinGuild(final long j3, long j16, final long j17, int i3, final GProGuild gProGuild, final HashMap<Long, GProChannel> hashMap, final GProCategoryChannelIdList gProCategoryChannelIdList, final ArrayList<GProCategoryChannelIdList> arrayList, final int i16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushJoinGuild", "", "guildId : " + j3 + "sourceType: " + i16);
                    GProSdkWrapperImpl.this.p(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), new GProGuildInfo(gProGuild), com.tencent.mobileqq.qqguildsdk.util.g.p(hashMap), com.tencent.mobileqq.qqguildsdk.util.g.f(gProCategoryChannelIdList), com.tencent.mobileqq.qqguildsdk.util.g.g(arrayList), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), i16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushJoinGuildFail(final long j3, final long j16, final int i3, final int i16, final String str) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.10
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushJoinGuildFail", "", "guildId : " + j3 + "  sourceTyp: " + i3 + "  memberTinyId: " + j16 + "  errorCode: " + i16 + "  errMsg :" + str);
                    GProSdkWrapperImpl.this.l(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), i3, i16, str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushKickOffGuild(final long j3, long j16, final long j17, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.11
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushKickOffGuild", "be kick by other", "guildId : " + j3);
                    GProSdkWrapperImpl.this.r0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushKickOutAudioChannel(final long j3, final long j16, final long j17, final long j18, final int i3, final String str, final int i16, long j19) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.21
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushKickOutAudioChannel", "notify", "guildId:" + j3 + ", channelId: " + j16 + ", tinyId:" + j18 + ", operatorTinyId:" + j17 + ",leavePlatform:" + i16);
                    GProSdkWrapperImpl.this.A0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), com.tencent.mobileqq.qqguildsdk.util.g.X0(j18), i3, str, i16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushLiveChannelAnchorIdentityChange(final long j3, final long j16, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.25
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushLiveChannelAnchorIdentityChange", "notify", "guidId:" + j3 + ", channelId:" + j16 + ", action: " + i3);
                    GProSdkWrapperImpl.this.J0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushLiveRoomInfoChange(final long j3, final long j16, final String str, final String str2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.29
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushLiveRoomInfoChange", "notify", "guildId:" + j3 + ", channelId:" + j16 + ", title:" + str + ", coverUrl: " + str2);
                    GProSdkWrapperImpl.this.q(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), str, str2);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushLiveRoomStatusChangeMsg(final long j3, final long j16, final long j17, final String str, final long j18, final int i3, final int i16, final GProProgramInfo gProProgramInfo, final long j19, final GProLiveRoomInfo gProLiveRoomInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.26
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushLiveRoomStatusChangeMsg", "notify", "tinyId:" + j18 + ", action: " + i3);
                    GProSdkWrapperImpl.this.w0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), str, com.tencent.mobileqq.qqguildsdk.util.g.X0(j18), i3, i16, new LiveProgramInfo(gProProgramInfo), j19, new LiveRoomInfo(gProLiveRoomInfo));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushMemberTopRoleChanged(final long j3, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.42
                @Override // java.lang.Runnable
                public void run() {
                    GProSdkWrapperImpl.this.L0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushModifyRole(final long j3, final long j16, final GProGuildRole gProGuildRole) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.39
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushModifyRole", "notify", "guildId: " + j3 + ", roleId: " + j16);
                    GProSdkWrapperImpl.this.M0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.u(gProGuildRole));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushMsgRecvTypeChanged(final long j3, final long j16, long j17, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.16
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushMsgRecvTypeChanged", "myMsgNotifyType", "guildId : " + j3 + "\uff0c channelId\uff1a" + j16);
                    GProSdkWrapperImpl.this.v0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushNotifySwitchUpdate(final long j3, final long j16, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.18
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushNotifySwitchUpdate", "notifyStatus", "guildId: " + j3 + ", channelId: " + j16 + ", notifyStatus: " + i3);
                    GProSdkWrapperImpl.this.a0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushPermissionInGuild(final long j3, final long j16, final boolean z16, final long j17) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gc
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.o1(j3, j16, z16, j17);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushPreventAddictionInstructions(final GProPreventAddictionPushInfo gProPreventAddictionPushInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fm
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.p1(gProPreventAddictionPushInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushQuitGuild(final long j3, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.12
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushQuitGuild", "quit active", "guildId : " + j3 + "\uff0c operatorId\uff1a" + j16);
                    GProSdkWrapperImpl.this.m0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushRemoveChannelSpeakPermission(final long j3, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.eu
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.q1(j3, j16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public /* synthetic */ void onPushRevokeGuild(long j3, long j16, long j17, int i3, GProGuild gProGuild, HashMap hashMap, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList arrayList, int i16) {
            com.tencent.qqnt.kernelgpro.nativeinterface.j.P0(this, j3, j16, j17, i3, gProGuild, hashMap, gProCategoryChannelIdList, arrayList, i16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushSecurityResult(final GProSecurityResult gProSecurityResult) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.43
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushSecurityResult", "notify", gProSecurityResult.toString());
                    GProSdkWrapperImpl.this.s0(com.tencent.mobileqq.qqguildsdk.util.g.U(gProSecurityResult));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushSelfBannedSpeakChange(final long j3, final long j16, final long j17, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.28
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushSelfBannedSpeakChange", "notify", "guildId:" + j3 + ", channelId:" + j16 + ", roomId:" + j17 + ", action: " + i3);
                    GProSdkWrapperImpl.this.d(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.X0(j17), i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushSendGiftEventNotify(final GProSendGiftEventData gProSendGiftEventData) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fq
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.r1(gProSendGiftEventData);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushShutUpStateChanged(final long j3, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ex
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.s1(j3, j16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushSortRole(final long j3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.40
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushSortRole", "notify", "guildId: " + j3);
                    GProSdkWrapperImpl.this.r(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushSwitchLiveRoom(final long j3, final long j16, final ArrayList<GProMember> arrayList, final int i3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.27
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushSwitchLiveRoom", "notify", "count:" + arrayList.size() + ", action: " + i3);
                    GProSdkWrapperImpl.this.F0(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.R0(arrayList), i3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushUserChannelStateChange(final GProUserChannelState gProUserChannelState) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.34
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushUserChannelStateChange", "notify", "userChannelState: " + gProUserChannelState);
                    GProSdkWrapperImpl.this.s(ChannelStateUtil.d(gProUserChannelState));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushUserGiftRankChangeNotify(final GProUserGiftRankInfo gProUserGiftRankInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gn
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.t1(gProUserGiftRankInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushUserHandUpResult(final GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fw
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.u1(gProAVUserStateChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushUserMuteSeatInGuild(final long j3, final long j16, final boolean z16, final long j17) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.22
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushUserMuteSeatInGuild", "notify", "guildId:" + j3 + "tinyId:" + j16 + ", bMute: " + z16 + "source: " + j17);
                    GProSdkWrapperImpl.this.T(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), z16, j17);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushUserScreenShare(final long j3, final long j16, final ArrayList<GProScreenShareUser> arrayList, final byte[] bArr) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.23
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    byte[] bArr2 = bArr;
                    if (bArr2 != null) {
                        str = new String(bArr2);
                    } else {
                        str = "";
                    }
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onPushUserScreenShare", "notify", "guildId=" + j3 + ", channelId=" + j16 + ", screenShareUsers = " + arrayList.toString() + ", extraInfo = " + str);
                    GProSdkWrapperImpl.this.j(com.tencent.mobileqq.qqguildsdk.util.g.X0(j3), com.tencent.mobileqq.qqguildsdk.util.g.X0(j16), com.tencent.mobileqq.qqguildsdk.util.g.T(arrayList), str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onQQMsgListChannelDataReady() {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fb
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.v1();
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onQQMsgListChannelUpdated(final ArrayList<Integer> arrayList, final ArrayList<GProQQMsgListChannel> arrayList2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gm
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.w1(arrayList, arrayList2);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onQQMsgListGuildUpdated(final ArrayList<Integer> arrayList, final ArrayList<GProQQMsgListGuild> arrayList2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gr
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.x1(arrayList, arrayList2);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRecentVisitGuildListChange(final int i3, final long j3, final int i16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fc
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.y1(i3, j3, i16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRecommendGuildChannelListUpdate(final GProGuildData gProGuildData) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ft
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.z1(gProGuildData);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRecommendGuildInfoUpdate(final GProRecommendGuildInfo gProRecommendGuildInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gs
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.A1(gProRecommendGuildInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRecommendGuildPersonalSettingUpdate(final GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hf
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.B1(gProRecommendGuildPersonalSetting);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRecommendGuildPollingResult(final ArrayList<GProPollingData> arrayList) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hi
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.C1(arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRecommendGuildStickyTopUpdated(final ArrayList<GProStickyChannel> arrayList, final ArrayList<GProStickyChannel> arrayList2, final ArrayList<GProStickyChannel> arrayList3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fx
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.D1(arrayList, arrayList2, arrayList3);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRefreshGuildUserProfileInfo(final int i3, final String str, final long j3, final long j16, final GProGuildUserProfile gProGuildUserProfile) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.19
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    com.tencent.mobileqq.qqguildsdk.data.cf cfVar;
                    int i16 = i3;
                    String str3 = str;
                    if (("guildId\uff1a" + j3 + "\uff0c tinyId\uff1a" + j16 + gProGuildUserProfile) != null) {
                        str2 = gProGuildUserProfile.getAvatarMeta();
                    } else {
                        str2 = "";
                    }
                    com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onRefreshGuildUserProfileInfo", "notify", i16, str3, str2);
                    GProSdkWrapperImpl gProSdkWrapperImpl = GProSdkWrapperImpl.this;
                    int i17 = i3;
                    String str4 = str;
                    String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j3);
                    String X02 = com.tencent.mobileqq.qqguildsdk.util.g.X0(j16);
                    GProGuildUserProfile gProGuildUserProfile2 = gProGuildUserProfile;
                    if (gProGuildUserProfile2 != null) {
                        cfVar = new com.tencent.mobileqq.qqguildsdk.data.cf(gProGuildUserProfile2);
                    } else {
                        cfVar = null;
                    }
                    gProSdkWrapperImpl.e(i17, str4, X0, X02, cfVar);
                    if (!String.valueOf(j16).equals(GProSdkWrapperImpl.this.Rf())) {
                        com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", true, "system notify", "onRefreshGuildUserProfileInfo", "notify", "guildId=" + j3 + ", tinyId=" + j16 + ", selfTinyId=" + GProSdkWrapperImpl.this.Rf());
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(String.valueOf(j3));
                    GProSdkWrapperImpl.this.w(arrayList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onReportSqliteError(final int i3, final String str) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gh
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.E1(i3, str);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onRobotStateChangeNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hl
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.F1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onSessionInitComplete(int i3, String str) {
            com.tencent.mobileqq.qqguildsdk.util.h.r("GProSdkWrapperImpl", 1, "NTSDKInit onSessionInitComplete GPro sessionId:" + str);
            GProSdkWrapperImpl.this.f268563j = true;
            GProSdkWrapperImpl.this.ej(300, "onSessionInitComplete", new Object[0]);
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_NT_INIT_DURATION, null, (double) (System.currentTimeMillis() - GProSdkWrapperImpl.this.f268559f));
            TraceUtils.n("Guild.SDK.NT.StartGProSdkCompleted.");
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onSmobaGameUserChangeNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fp
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.G1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onSpeakableThresholdUpdate(final ArrayList<Long> arrayList, final ArrayList<GProGuildSpeakableThreshold> arrayList2) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fi
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.H1(arrayList, arrayList2);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserAVStateResetNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.ez
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.I1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserEnterListNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hb
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.J1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserGuidePush(final GProUserGuideMsg gProUserGuideMsg) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.hd
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.K1(gProUserGuideMsg);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserHandUpRequestNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.gi
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.L1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserLeaveListNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fr
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.M1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserListFetchFinish(final int i3, final String str, final long j3) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.n("GProSdkWrapperImpl", false, "system notify", "onUserListFetchFinish", "notify", i3, str, "guildId : " + j3);
                    GProSdkWrapperImpl.this.X(i3, com.tencent.mobileqq.qqguildsdk.util.g.X0(j3));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserSpeakingNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fh
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.N1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onUserWaitingToSpeakNotifyForAll(final GProChannelUserChangeInfo gProChannelUserChangeInfo) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fe
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.O1(gProChannelUserChangeInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onVoiceHeartbeatTimeout(final long j3, final long j16) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.fo
                @Override // java.lang.Runnable
                public final void run() {
                    GProSdkWrapperImpl.GProSdkListenerImpl.this.P1(j3, j16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onVoiceSmobaGameRooManageUpdate(final GProVoiceSmobaGameRoomManageSysMsg gProVoiceSmobaGameRoomManageSysMsg) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.36
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onVoiceSmobaGameRooManageUpdate", "notify", "roomId");
                    GProSdkWrapperImpl.this.c0(new GGProVoiceSmobaGameRoomManageSysMsg(gProVoiceSmobaGameRoomManageSysMsg));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onVoiceSmobaGameUserActionUpdate(final GProVoiceSmobaGameUserActionPush gProVoiceSmobaGameUserActionPush) {
            ((GProSdkGenWrapperImpl) GProSdkWrapperImpl.this).f266769b.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.35
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.qqguildsdk.util.h.p("GProSdkWrapperImpl", false, "system notify", "onVoiceSmobaGameUserActionUpdate", "notify", "roomId: " + gProVoiceSmobaGameUserActionPush.getRoomId());
                    GProSdkWrapperImpl.this.k0(new com.tencent.mobileqq.qqguildsdk.data.ch(gProVoiceSmobaGameUserActionPush));
                }
            });
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onAppInfosUpdated() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushBatchJoinChannel(long j3, ArrayList<Long> arrayList) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushBatchLeaveChannel(long j3, ArrayList<Long> arrayList) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushJoinChannel(long j3, long j16, ArrayList<Long> arrayList) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushLeaveChannel(long j3, long j16, ArrayList<Long> arrayList) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAudioChannelUserEnter(long j3, long j16, GProUser gProUser, long j17) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildListener
        public void onPushAudioChannelUserExit(long j3, long j16, long j17, long j18) {
        }
    }
}
