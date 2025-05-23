package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGuildService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelGuildService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        public static native GProGetCategoryPageGuildsRsp decodeGProGetCategoryPageGuildsRsp(byte[] bArr);

        public static native GProGetCategoryTabContentRsp decodeGProGetCategoryTabContentRsp(byte[] bArr);

        public static native GProGetConfigTabContentRsp decodeGProGetConfigTabContentRsp(byte[] bArr);

        public static native GProGetMyTabContentRsp decodeGProGetMyTabContentRsp(byte[] bArr);

        public static native GProGetRecommendTabContentRsp decodeGProGetRecommendTabContentRsp(byte[] bArr);

        public static native GProGuildAdvFeedPos decodeGProGuildAdvFeedPos(byte[] bArr);

        public static native ArrayList<GProGuild> decodeGProGuilds(byte[] bArr);

        public static native ArrayList<GProNavigationTab> decodeGProNavigationTabs(byte[] bArr);

        public static native GProSysPromptDigest decodeGProSysPromptDigest(byte[] bArr);

        public static native byte[] encodeGProGuilds(ArrayList<GProGuild> arrayList);

        public static native byte[] encodeGProNavigationTabs(ArrayList<GProNavigationTab> arrayList);

        public static native byte[] encodeShareAttaData(GProShareAttaData gProShareAttaData);

        public static native GProGetContentRecommendRsp fastDecodeMVPFeedsRspPb(byte[] bArr);

        public static native String getFullAvatarPendantUrl(String str);

        public static native String getFullAvatarUrl(String str, int i3);

        public static native byte[] lz4DecompressBuf(byte[] bArr);

        private native void nativeDestroy(long j3);

        private native void native_CancelDownloadBroadcastHelper(long j3);

        private native void native_DownloadBroadcastHelper(long j3);

        private native void native_GetMemberInfoByOpenId(long j3, String str, long j16, boolean z16, boolean z17, IGProGetMemberInfoByOpenIdCallback iGProGetMemberInfoByOpenIdCallback);

        private native void native_InstallBroadcastHelper(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_LoadGuildUserProfileInfo(long j3, long j16, long j17, IGProLoadGuildUserProfileCallback iGProLoadGuildUserProfileCallback);

        private native void native_activeBroadcast(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_addGuild(long j3, long j16, GProSourceId gProSourceId, String str, IGProJoinGuildCallback iGProJoinGuildCallback);

        private native void native_addGuildWithOption(long j3, GProAddGuildWithOptionReq gProAddGuildWithOptionReq, IGProJoinGuildCallback iGProJoinGuildCallback);

        private native void native_addGuilds(long j3, ArrayList<GProJoinGuilds> arrayList, GProSourceId gProSourceId, IGProJoinGuildsCallback iGProJoinGuildsCallback);

        private native void native_addGuildsForGrowth(long j3, String str, ArrayList<GProJoinGuilds> arrayList, IGProJoinGuildsCallback iGProJoinGuildsCallback);

        private native void native_addKernelGuildListener(long j3, IKernelGuildListener iKernelGuildListener);

        private native void native_addRecentVisitGuildsListSync(long j3, ArrayList<Long> arrayList, IGProAddRecentVisitGuildIdsCallback iGProAddRecentVisitGuildIdsCallback);

        private native void native_addSpeakOrderByUser(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_anchorEnterRoom(long j3, GProAnchorEnterRoomReq gProAnchorEnterRoomReq, IGProAnchorEnterRoomCallback iGProAnchorEnterRoomCallback);

        private native void native_anchorLeaveRoom(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_appAuthorization(long j3, int i3, IGProAppAuthorizationCallback iGProAppAuthorizationCallback);

        private native void native_audienceEnterRoom(long j3, GProLiveEnterRoomRequest gProLiveEnterRoomRequest, IGProOnAudienceEnterRoomCallback iGProOnAudienceEnterRoomCallback);

        private native void native_audienceLeaveRoom(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_authScreenShared(long j3, long j16, long j17, IGProScreenShareCallback iGProScreenShareCallback);

        private native void native_batchDeleteAISearchSession(long j3, GProAISearchBatchDeleteSessionReq gProAISearchBatchDeleteSessionReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_batchFetchAudioChannelSimpleUserList(long j3, long j16, ArrayList<Long> arrayList, boolean z16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback);

        private native void native_batchGetAudioBotStatus(long j3, GProGetAudioBotStatusReq gProGetAudioBotStatusReq, IGProBatchGetAudioBotStatusCallback iGProBatchGetAudioBotStatusCallback);

        private native void native_batchGetGuildLabelInfo(long j3, GProBatchGetGuildLabelInfoReq gProBatchGetGuildLabelInfoReq, IGProBatchGetGuildLabelInfoCallback iGProBatchGetGuildLabelInfoCallback);

        private native void native_batchGetItemDetail(long j3, GProGetItemDetailReq gProGetItemDetailReq, IGProGetItemDetailCallback iGProGetItemDetailCallback);

        private native void native_batchSetCategoryFolded(long j3, long j16, HashMap<Long, Boolean> hashMap, IGProResultCallback iGProResultCallback);

        private native void native_batchSetGuildInfoBoolField(long j3, long j16, HashMap<Integer, Boolean> hashMap, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_batchSetGuildInfoIntField(long j3, long j16, HashMap<Integer, Integer> hashMap, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_batchUpdateChannelsMsgNotifyType(long j3, long j16, ArrayList<GProChannelMsgNotify> arrayList, IGProResultCallback iGProResultCallback);

        private native void native_beforehandGetGuildSpeakPermission(long j3, long j16, int i3, IGProBeforehandGetSpeakPermissionCallback iGProBeforehandGetSpeakPermissionCallback);

        private native void native_bindAppRole(long j3, int i3, String str, int i16, IGProBindAppRoleCallback iGProBindAppRoleCallback);

        private native void native_cancelChannelTopMsg(long j3, long j16, long j17, ArrayList<GProTopMsg> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_cancelSpeakOrderByAdmin(long j3, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

        private native void native_cancelUserHandUpForAdmin(long j3, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

        private native void native_changeChannelCategoryNameWithId(long j3, long j16, long j17, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

        private native void native_changeGuildAllowSearch(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_checkAVState(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_checkAndEncryptText(long j3, GProEncryptTextReq gProEncryptTextReq, IGProCheckAndEncryptTextCallBack iGProCheckAndEncryptTextCallBack);

        private native void native_checkFeedAbstractInfo(long j3, GProCheckFeedAbstractInfoReq gProCheckFeedAbstractInfoReq, IGProCheckFeedAbstractInfoCallback iGProCheckFeedAbstractInfoCallback);

        private native void native_checkIsStrangerNewMember(long j3, IGProCheckIsStrangerNewMemberCallback iGProCheckIsStrangerNewMemberCallback);

        private native void native_checkLobbyAppAuthStatus(long j3, String str, long j16, long j17, IGProCheckLobbyAppAuthStatusCallback iGProCheckLobbyAppAuthStatusCallback);

        private native void native_checkPreventAddiction(long j3, GProPreventAddictionCheckReq gProPreventAddictionCheckReq, IGProPreventAddictionCheckCallback iGProPreventAddictionCheckCallback);

        private native void native_checkUserBannedSpeakInChannel(long j3, long j16, long j17, long j18, IGProCheckUserBannedSpeakInChannelCallback iGProCheckUserBannedSpeakInChannelCallback);

        private native void native_checkUserFreeGiftInfo(long j3, GProUserFreeGiftReq gProUserFreeGiftReq, IGProCheckUserFreeGiftCallback iGProCheckUserFreeGiftCallback);

        private native void native_clearGuildRelatedData(long j3, ArrayList<Long> arrayList);

        private native void native_closeAVLobbyApp(long j3, long j16, long j17, long j18, IGProDeleteLobbyCallback iGProDeleteLobbyCallback);

        private native void native_closeChannelActivitySwitch(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_closeChannelTopMsg(long j3, long j16, long j17, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_convertGuildAndThirdIds(long j3, GProConvertThirdIdReq gProConvertThirdIdReq, IGProConvertGuildAndThirdIdCallback iGProConvertGuildAndThirdIdCallback);

        private native GProInviteInfo native_convertToGuildInviteInfo(long j3, GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo);

        private native void native_createChannelCategoryWithId(long j3, long j16, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

        private native void native_createChannelWithId(long j3, long j16, GProChannelCreateInfo gProChannelCreateInfo, long j17, GProAssocCreateCategoryReq gProAssocCreateCategoryReq, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProCreateChannelCallback iGProCreateChannelCallback);

        private native void native_createDirectMsgSession(long j3, GProDirectMsgCreateInfo gProDirectMsgCreateInfo, IGProCreateDirectMsgSessionCallback iGProCreateDirectMsgSessionCallback);

        private native void native_createGuild(long j3, GProCreateGuildReq gProCreateGuildReq, IGProCreateGuildCallback iGProCreateGuildCallback);

        private native void native_createLinkChannelWithId(long j3, long j16, GProChannelCreateInfo gProChannelCreateInfo, long j17, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_createRole(long j3, long j16, GProRoleCreateInfo gProRoleCreateInfo, ArrayList<Long> arrayList, IGProCreateRoleCallback iGProCreateRoleCallback);

        private native void native_createSchedule(long j3, long j16, long j17, GProScheduleInfo gProScheduleInfo, IGProCreateScheduleCallback iGProCreateScheduleCallback);

        private native void native_createScheduleLimitQuery(long j3, long j16, IGProCreateScheduleLimitQueryCallback iGProCreateScheduleLimitQueryCallback);

        private native void native_createScheduleV2(long j3, GProCreateScheduleReq gProCreateScheduleReq, IGProCreateScheduleCallback iGProCreateScheduleCallback);

        private native void native_customChannelMsgNotifyType(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_dealHandUpRequestForAdmin(long j3, GProAdminAVReqInfo gProAdminAVReqInfo, boolean z16, IGProAdminDealResultCallback iGProAdminDealResultCallback);

        private native void native_dealNotice(long j3, String str, String str2, IGProDealNoticeCallback iGProDealNoticeCallback);

        private native void native_decodeInviteJumpInfo(long j3, String str, IGProDecodeInviteJumpInfoCallback iGProDecodeInviteJumpInfoCallback);

        private native GProGetContentRecommendRsp native_decodeMVPFeedsRspPb(long j3, byte[] bArr);

        private native GProScheduleInfo native_decodeScheduleInfo(long j3, byte[] bArr);

        private native void native_deleteAISearchSession(long j3, GProAISearchDeleteSessionReq gProAISearchDeleteSessionReq, IGProDeleteAISearchSessionCallback iGProDeleteAISearchSessionCallback);

        private native void native_deleteFeed(long j3, GProDeleteFeedReq gProDeleteFeedReq, IGProDeleteFeedCallback iGProDeleteFeedCallback);

        private native void native_deleteGuildEssence(long j3, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

        private native void native_deleteGuildGlobalBanner(long j3, GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback);

        private native void native_deleteRole(long j3, long j16, long j17, IGProResultCallback iGProResultCallback);

        private native void native_deleteSystemNoticeMessage(long j3, GProSystemNoticeMessageDeleteReq gProSystemNoticeMessageDeleteReq, IGProDeleteSystemNoticeMessageCallback iGProDeleteSystemNoticeMessageCallback);

        private native void native_destroyGuild(long j3, long j16, IGProResultCallback iGProResultCallback);

        private native void native_doGuildCheckin(long j3, GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback);

        private native void native_doRealNameAuth(long j3, int i3, IGProGetRealNameAuthCallback iGProGetRealNameAuthCallback);

        private native void native_domainResolveByLocalDns(long j3, String str);

        private native void native_editSchedule(long j3, long j16, long j17, GProScheduleInfo gProScheduleInfo, int i3, IGProEditScheduleCallback iGProEditScheduleCallback);

        private native void native_editScheduleV2(long j3, GProEditScheduleReq gProEditScheduleReq, IGProEditScheduleCallback iGProEditScheduleCallback);

        private native void native_endPush(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_enterAudioChannel(long j3, long j16, long j17, int i3, IGProEnterAudioChannelCallback iGProEnterAudioChannelCallback);

        private native void native_enterAudioLiveChannel(long j3, GProEnterAudioLiveChannelReq gProEnterAudioLiveChannelReq, IGProEnterAudioLiveChannelCallback iGProEnterAudioLiveChannelCallback);

        private native void native_exitAudioChannel(long j3, long j16, long j17, IGProResultCallback iGProResultCallback);

        private native void native_exitAudioLiveChannel(long j3, long j16, long j17, int i3, ArrayList<String> arrayList, IGProExitAudioLiveChannelCallback iGProExitAudioLiveChannelCallback);

        private native void native_exposeGuildTaskCard(long j3, GProExposureGuildTaskCardReq gProExposureGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_exposeRecommends(long j3, GProExposeRecommedsReq gProExposeRecommedsReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_fetchActiveChannels(long j3, long j16, IGProFetchActiveChannelsCallback iGProFetchActiveChannelsCallback);

        private native void native_fetchAddGuildInfo(long j3, int i3, long j16, IGProAddGuildInfoCallBack iGProAddGuildInfoCallBack);

        private native void native_fetchAddGuildOption(long j3, long j16, int i3, IGProFetchAddGuildOptionCallback iGProFetchAddGuildOptionCallback);

        private native void native_fetchAnchorPreparePage(long j3, GProAnchorPrepareReq gProAnchorPrepareReq, IGProFetchAnchorPreparePageCallback iGProFetchAnchorPreparePageCallback);

        private native void native_fetchAppInfos(long j3, long j16, IGProFetchAppInfosCallback iGProFetchAppInfosCallback);

        private native void native_fetchArchiveArkData(long j3, long j16, long j17, byte[] bArr, int i3, IGProFetchArchiveArkDataCallback iGProFetchArchiveArkDataCallback);

        private native void native_fetchAudioChannelUserList(long j3, long j16, long j17, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback);

        private native void native_fetchAudioLiveChannelBlockUserState(long j3, long j16, long j17, IGProFetchBlockUserStateCallback iGProFetchBlockUserStateCallback);

        private native void native_fetchAudioLiveChannelGroupList(long j3, GProAVMemberGroupListReq gProAVMemberGroupListReq, IGProFetchAudioLiveGroupListCallback iGProFetchAudioLiveGroupListCallback);

        private native void native_fetchAudioLiveChannelUserList(long j3, GProAudioLiveUserListReq gProAudioLiveUserListReq, IGProFetchAudioLiveUserListCallback iGProFetchAudioLiveUserListCallback);

        private native void native_fetchBatchBotGetCommand(long j3, GProBatchBotGetCommand gProBatchBotGetCommand, IGProFetchBatchBotGetCommandCallback iGProFetchBatchBotGetCommandCallback);

        private native void native_fetchCategoryAdminInfoList(long j3, GProFetchCategoryAdminDisplayInfoReq gProFetchCategoryAdminDisplayInfoReq, IGProFetchCategoryAdminInfoListCallback iGProFetchCategoryAdminInfoListCallback);

        private native void native_fetchChannelAdminInfoList(long j3, long j16, long j17, IGProChannelAdminInfoListCallback iGProChannelAdminInfoListCallback);

        private native void native_fetchChannelAuthControlMemberList(long j3, long j16, long j17, int i3, byte[] bArr, int i16, IGProFetchChannelAbleMemberListCallback iGProFetchChannelAbleMemberListCallback);

        private native void native_fetchChannelAuthControlRoleList(long j3, long j16, long j17, int i3, IGProFetchChannelAbleRoleListCallback iGProFetchChannelAbleRoleListCallback);

        private native void native_fetchChannelAuthControlUnableMemberList(long j3, long j16, long j17, int i3, byte[] bArr, int i16, IGProFetchChannelUnableMemberListCallback iGProFetchChannelUnableMemberListCallback);

        private native void native_fetchChannelInfo(long j3, long j16, long j17, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback);

        private native void native_fetchChannelInfoWithCategory(long j3, long j16, long j17, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback);

        private native void native_fetchChannelInfoWithUnreadStatus(long j3, long j16, boolean z16);

        private native void native_fetchChannelInvisibleMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelInvisibleMemberListCallback iGProFetchChannelInvisibleMemberListCallback);

        private native void native_fetchChannelInvisibleRoleList(long j3, long j16, long j17, IGProFetchChannelInvisibleRoleListCallback iGProFetchChannelInvisibleRoleListCallback);

        private native void native_fetchChannelList(long j3, ArrayList<Long> arrayList, IGProFetchChannelListCategoryCallback iGProFetchChannelListCategoryCallback);

        private native void native_fetchChannelListForJump(long j3, long j16, IGProFetchChannelListForJumpCallback iGProFetchChannelListForJumpCallback);

        private native void native_fetchChannelListState(long j3, ArrayList<GProGuildStateReqInfo> arrayList, IGProFetchChannelListStateCallback iGProFetchChannelListStateCallback);

        private native void native_fetchChannelLiveableMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelLiveableMemberListCallback iGProFetchChannelLiveableMemberListCallback);

        private native void native_fetchChannelLiveableRoleList(long j3, long j16, long j17, IGProFetchChannelLiveableRoleListCallback iGProFetchChannelLiveableRoleListCallback);

        private native void native_fetchChannelSpeakableMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelSpeakableMemberListCallback iGProFetchChannelSpeakableMemberListCallback);

        private native void native_fetchChannelSpeakableRoleList(long j3, long j16, long j17, IGProFetchChannelSpeakableRoleListCallback iGProFetchChannelSpeakableRoleListCallback);

        private native void native_fetchChannelUnlivableMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelUnlivableMemberListCallback iGProFetchChannelUnlivableMemberListCallback);

        private native void native_fetchChannelUnlivableRoleList(long j3, long j16, long j17, IGProFetchChannelUnlivableRoleListCallback iGProFetchChannelUnlivableRoleListCallback);

        private native void native_fetchChannelUnspeakableMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelUnspeakableMemberListCallback iGProFetchChannelUnspeakableMemberListCallback);

        private native void native_fetchChannelUnspeakableRoleList(long j3, long j16, long j17, IGProFetchChannelUnspeakableRoleListCallback iGProFetchChannelUnspeakableRoleListCallback);

        private native void native_fetchChannelUserPermission(long j3, long j16, long j17, int i3, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback);

        private native void native_fetchChannelVisibleAllMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback);

        private native void native_fetchChannelVisibleMemberList(long j3, long j16, long j17, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback);

        private native void native_fetchChannelVisibleRoleList(long j3, long j16, long j17, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback);

        private native void native_fetchChannelVisibleRoleListWithoutLevelRole(long j3, long j16, long j17, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback);

        private native void native_fetchComments(long j3, long j16, long j17, long j18, long j19, long j26, long j27, IGProFetchCommentsCallback iGProFetchCommentsCallback);

        private native void native_fetchCurrentLiveRoomInfo(long j3, long j16, IGProFetchCurrentLiveRoomInfoCallback iGProFetchCurrentLiveRoomInfoCallback);

        private native void native_fetchDirectMsgBlack(long j3, long j16, IGProFetchDirectMsgBlackCallback iGProFetchDirectMsgBlackCallback);

        private native void native_fetchDirectMsgStatus(long j3, IGProFetchDirectMsgStatusCallback iGProFetchDirectMsgStatusCallback);

        private native void native_fetchEndPageMessage(long j3, long j16, IGProFetchEndPageMessageCallback iGProFetchEndPageMessageCallback);

        private native void native_fetchFeedCommentsNotifySwitch(long j3, IGProGetFeedCommentsNotifySwitchCallback iGProGetFeedCommentsNotifySwitchCallback);

        private native void native_fetchGlobalPrivacySwitch(long j3, IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback);

        private native void native_fetchGuestGuild(long j3, long j16, boolean z16, int i3, IGProFetchGuestGuildCallback iGProFetchGuestGuildCallback);

        private native void native_fetchGuestGuildInfoWithChannelList(long j3, int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback);

        private native void native_fetchGuildActiveLiveChannelNum(long j3, GProFetchGuildActiveLiveChannelNumReq gProFetchGuildActiveLiveChannelNumReq, IGProFetchGuildActiveLiveChannelNumCallback iGProFetchGuildActiveLiveChannelNumCallback);

        private native void native_fetchGuildActiveValue(long j3, long j16, IGProGuildActiveValueCallback iGProGuildActiveValueCallback);

        private native void native_fetchGuildBlackList(long j3, long j16, byte[] bArr, IGProFetchGuildBlackListCallback iGProFetchGuildBlackListCallback);

        private native void native_fetchGuildBottomTabExp(long j3, GProBottomTabExpReq gProBottomTabExpReq, IGProFetchGuildBottomTabExpCallback iGProFetchGuildBottomTabExpCallback);

        private native void native_fetchGuildBoundGroupsWithGroupCodes(long j3, long j16, ArrayList<Long> arrayList, IGProFetchGuildBoundGroupsWithGroupCodesCallback iGProFetchGuildBoundGroupsWithGroupCodesCallback);

        private native void native_fetchGuildInfo(long j3, long j16, int i3, IGProFetchGuildInfoCallback iGProFetchGuildInfoCallback);

        private native void native_fetchGuildInfoAndMemberList(long j3, GProGuildInfoAndMemberListReq gProGuildInfoAndMemberListReq, IGProFetchGuildInfoAndMemberListCallback iGProFetchGuildInfoAndMemberListCallback);

        private native void native_fetchGuildInfoByAppIdentity(long j3, GProGuildIdentity gProGuildIdentity, String str, String str2, IGProFetchGuildInfoByAppIdentityCallback iGProFetchGuildInfoByAppIdentityCallback);

        private native void native_fetchGuildSearchSwitch(long j3, long j16, IGProFetchGuildSearchSwitchCallback iGProFetchGuildSearchSwitchCallback);

        private native void native_fetchGuildSpeakableMemberList(long j3, long j16, boolean z16, int i3, byte[] bArr, IGProFetchGuildSpeakableMemberListCallback iGProFetchGuildSpeakableMemberListCallback);

        private native void native_fetchGuildSpeakableRoleList(long j3, long j16, boolean z16, IGProFetchGuildSpeakableRoleListCallback iGProFetchGuildSpeakableRoleListCallback);

        private native void native_fetchGuildSpeakableRule(long j3, long j16, IGProFetchGuildSpeakableRuleCallback iGProFetchGuildSpeakableRuleCallback);

        private native void native_fetchGuildSpeakableThreshold(long j3, long j16, IGProFetchGuildSpeakableThresholdCallback iGProFetchGuildSpeakableThresholdCallback);

        private native void native_fetchGuildTaskCards(long j3, GProAllGuildTaskCardReq gProAllGuildTaskCardReq, IGProFetchGuildTaskCardsCallback iGProFetchGuildTaskCardsCallback);

        private native void native_fetchHandUpMemberList(long j3, long j16, long j17, IGProFetchHandUpMemberListCallback iGProFetchHandUpMemberListCallback);

        private native void native_fetchInviteInfo(long j3, String str, IGProFetchInviteInfoCallback iGProFetchInviteInfoCallback);

        private native void native_fetchInviteInfo0x10b4(long j3, String str, String str2, String str3, int i3, IGProFetchInviteInfo0x10b4Callback iGProFetchInviteInfo0x10b4Callback);

        private native void native_fetchIsLiveChannelOpen(long j3, long j16, IGProFetchIsLiveChannelOpenCallback iGProFetchIsLiveChannelOpenCallback);

        private native void native_fetchIsStartBroadcastVisible(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_fetchIsVoiceChannelOpen(long j3, long j16, IGProFetchIsVoiceChannelOpenCallback iGProFetchIsVoiceChannelOpenCallback);

        private native void native_fetchJoinGuildOption(long j3, GProFetchJoinGuildOptionReq gProFetchJoinGuildOptionReq, IGProFetchJoinGuildOptionCallback iGProFetchJoinGuildOptionCallback);

        private native void native_fetchJubaoMsgResId(long j3, long j16, long j17, long j18, IGProFetchJubaoMsgResIdCallback iGProFetchJubaoMsgResIdCallback);

        private native void native_fetchJubaoMsgsResId(long j3, long j16, long j17, ArrayList<Long> arrayList, IGProFetchJubaoMsgsResIdCallback iGProFetchJubaoMsgsResIdCallback);

        private native void native_fetchJumpInfo(long j3, long j16, IGProFetchJumpInfoCallback iGProFetchJumpInfoCallback);

        private native void native_fetchLatestComments(long j3, long j16, long j17, long j18, long j19, IGProFetchCommentsCallback iGProFetchCommentsCallback);

        private native void native_fetchLevelRolePermissions(long j3, long j16, int i3, IGProFetchLevelRoleListCallback iGProFetchLevelRoleListCallback);

        private native void native_fetchLiveChannelAnchorList(long j3, long j16, long j17, IGProFetchLiveChannelAnchorListCallback iGProFetchLiveChannelAnchorListCallback);

        private native void native_fetchLiveChannelBannedUserList(long j3, long j16, long j17, long j18, IGProFetchBannedUserListCallback iGProFetchBannedUserListCallback);

        private native void native_fetchLiveRoomInfo(long j3, GProLiveRoomInfoReq gProLiveRoomInfoReq, IGProFetchLiveChannelInfoListCallback iGProFetchLiveChannelInfoListCallback);

        private native void native_fetchLiveSecurityTips(long j3, IGProFetchLiveSecurityTipsCallback iGProFetchLiveSecurityTipsCallback);

        private native void native_fetchMVPFeedsFromServer(long j3, GProGetContentRecommendReq gProGetContentRecommendReq, IGProFetchMVPFeedsDataCallback iGProFetchMVPFeedsDataCallback);

        private native void native_fetchMemberListForFeed(long j3, GProFeedMemberListReq gProFeedMemberListReq, IGProFetchMemberListCallback iGProFetchMemberListCallback);

        private native void native_fetchMemberListWithRole(long j3, long j16, long j17, long j18, long j19, int i3, int i16, IGProFetchMemberListWithRoleCallback iGProFetchMemberListWithRoleCallback);

        private native void native_fetchMemberListWithRoleCookie(long j3, long j16, long j17, long j18, long j19, int i3, String str, int i16, IGProFetchMemberListWithRoleCookieCallback iGProFetchMemberListWithRoleCookieCallback);

        private native void native_fetchMemberRoles(long j3, long j16, long j17, long j18, int i3, IGProFetchMemberRolesCallback iGProFetchMemberRolesCallback);

        private native void native_fetchMyCreateGuilds(long j3, IGProFetchMyCreateGuildsCallback iGProFetchMyCreateGuildsCallback);

        private native void native_fetchNewestNotice(long j3, int i3, long j16, IGProFetchNewestNoticeCallback iGProFetchNewestNoticeCallback);

        private native void native_fetchNonRoleMembers(long j3, long j16, long j17, long j18, long j19, long j26, int i3, int i16, IGProFetchNonRoleMembersCallback iGProFetchNonRoleMembersCallback);

        private native void native_fetchOnlineUsers(long j3, long j16, int i3, int i16, ArrayList<Long> arrayList, IGProFetchOnlineUsersCallback iGProFetchOnlineUsersCallback);

        private native void native_fetchOtherChannelUserPermission(long j3, long j16, long j17, long j18, int i3, int i16, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback);

        private native void native_fetchProfileAddFriendField(long j3, long j16, long j17, IGProFetchProfileAddFriendFieldCallback iGProFetchProfileAddFriendFieldCallback);

        private native void native_fetchPskey(long j3, ArrayList<String> arrayList, IGProFetchPskeyCallback iGProFetchPskeyCallback);

        private native void native_fetchRecommendChannel(long j3, int i3, int i16, IGProFetchRecommendChannelCallback iGProFetchRecommendChannelCallback);

        private native void native_fetchRecommendEssenceInfo(long j3, long j16, int i3, IGProFetchRecommendEssenceInfoCallback iGProFetchRecommendEssenceInfoCallback);

        private native void native_fetchRemainAtSetInfo(long j3, long j16, IGProFetchAtSetInfoCallback iGProFetchAtSetInfoCallback);

        private native void native_fetchRetentionGuildList(long j3, int i3, int i16, byte[] bArr, long j16, IGProFetchRetentionGuildListCallback iGProFetchRetentionGuildListCallback);

        private native void native_fetchRole(long j3, long j16, long j17, int i3, boolean z16, IGProFetchRoleCallback iGProFetchRoleCallback);

        private native void native_fetchRoleListWithFilter(long j3, long j16, int i3, int i16, IGProFetchRoleListCallback iGProFetchRoleListCallback);

        private native void native_fetchRoleListWithPermission(long j3, long j16, int i3, IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback);

        private native void native_fetchRoleListWithoutLevelRoleWithFilter(long j3, long j16, int i3, int i16, IGProFetchRoleListWithoutLevelRoleCallback iGProFetchRoleListWithoutLevelRoleCallback);

        private native void native_fetchRoleMembers(long j3, long j16, long j17, long j18, long j19, long j26, int i3, IGProFetchRoleMembersCallback iGProFetchRoleMembersCallback);

        private native void native_fetchRoleWithPermission(long j3, long j16, long j17, int i3, IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback);

        private native void native_fetchShareButtonReq(long j3, ArrayList<Long> arrayList, boolean z16, IGProCommonCallback iGProCommonCallback);

        private native void native_fetchShareInfo0x10c3(long j3, long j16, long j17, GProFetchShareInfo0x10c3Req gProFetchShareInfo0x10c3Req, IGProFetchShareInfo0x10c3Callback iGProFetchShareInfo0x10c3Callback);

        private native void native_fetchShareUrlReq(long j3, long j16, long j17, long j18, String str, GProFetchShareUrlFilter gProFetchShareUrlFilter, ArrayList<GProURLParam> arrayList, IGProFetchShareUrlCallback iGProFetchShareUrlCallback);

        private native void native_fetchSpecifiedTypeChannelOpenState(long j3, long j16, long j17, IGProFetchSpecifiedTypeChannelOpenStateCallback iGProFetchSpecifiedTypeChannelOpenStateCallback);

        private native void native_fetchSpecifiedTypeChannelsOpenState(long j3, long j16, ArrayList<Integer> arrayList, int i3, IGProFetchSpecifiedTypeChannelsOpenStateCallback iGProFetchSpecifiedTypeChannelsOpenStateCallback);

        private native void native_fetchSubscribeUserGuide(long j3, IGProFetchSubscribeUserGuideCallback iGProFetchSubscribeUserGuideCallback);

        private native void native_fetchUserInfo(long j3, long j16, long j17, ArrayList<Long> arrayList, int i3, IGProGetUserInfoCallback iGProGetUserInfoCallback);

        private native void native_fetchUserJoinedGuildListV2(long j3, GProFetchUserJoinedGuildListReq gProFetchUserJoinedGuildListReq, IGProFetchUserJoinedGuildListCallbackV2 iGProFetchUserJoinedGuildListCallbackV2);

        private native void native_fetchUserList(long j3, long j16, long j17, int i3, IGProGetUserListCallback iGProGetUserListCallback);

        private native void native_fetchVersionNews(long j3, IGProFetchVersionNewsCallback iGProFetchVersionNewsCallback);

        private native void native_fetchVisibleMemberListByTinyId(long j3, long j16, long j17, ArrayList<Long> arrayList, int i3, IGProFetchVisibleMemberListByTinyIdCallback iGProFetchVisibleMemberListByTinyIdCallback);

        private native void native_fetchXWordInfo(long j3, long j16, IGproXWorldInfoCallback iGproXWorldInfoCallback);

        private native void native_getAISearchRecommendWords(long j3, IGProGetAISearchRecommendWordsCallback iGProGetAISearchRecommendWordsCallback);

        private native void native_getAISearchSessionList(long j3, GProAISearchGetSessionListReq gProAISearchGetSessionListReq, boolean z16, IGProGetAISearchSessionListCallback iGProGetAISearchSessionListCallback);

        private native void native_getAISearchSessionMsgList(long j3, GProAISearchGetSessionMsgListReq gProAISearchGetSessionMsgListReq, boolean z16, IGProGetAISearchSessionMsgListCallback iGProGetAISearchSessionMsgListCallback);

        private native void native_getAISearchShareURL(long j3, GProGetAISearchShareURLReq gProGetAISearchShareURLReq, IGProGetAISearchShareURLCallback iGProGetAISearchShareURLCallback);

        private native HashMap<Long, Integer> native_getAVChannelUserCnts(long j3, long j16);

        private native void native_getActiveLiveAudioChannelNum(long j3, long j16, IGProGetActiveLiveAudioChannelNumCallback iGProGetActiveLiveAudioChannelNumCallback);

        private native void native_getActiveLiveAudioChannelNumV2(long j3, GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetActiveLiveAudioChannelNumV2Callback iGProGetActiveLiveAudioChannelNumV2Callback);

        private native void native_getAllGuildSearchAIInfo(long j3, GProGuildSearchGetAllGuildAIInfoReq gProGuildSearchGetAllGuildAIInfoReq, IGProGetAllGuildSearchAIInfoCallback iGProGetAllGuildSearchAIInfoCallback);

        private native GProGuildUserState native_getAlreadyEnteredChannel(long j3);

        private native void native_getAppAuthorizationInfo(long j3, int i3, int i16, IGProGetAppAuthorizationInfoCallback iGProGetAppAuthorizationInfoCallback);

        private native GProAppChnnPreInfo native_getAppChannelPreInfo(long j3, long j16, long j17);

        private native ArrayList<GProAppChnnPreInfo> native_getAppChannelPreInfos(long j3, long j16);

        private native ArrayList<GProAppInfo> native_getAppInfos(long j3);

        private native void native_getAppRoleList(long j3, int i3, String str, byte[] bArr, IGProGetAppRoleListCallback iGProGetAppRoleListCallback);

        private native void native_getAssociativeWords(long j3, String str, IGProAssociativeWordsCallback iGProAssociativeWordsCallback);

        private native void native_getAtMemberList(long j3, String str, String str2, IGProGetUserInfoCallback iGProGetUserInfoCallback);

        private native void native_getBanners(long j3, GProGetBannersReq gProGetBannersReq, IGProGetBannersCallback iGProGetBannersCallback);

        private native void native_getBindClientService(long j3, int i3, int i16, byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback);

        private native void native_getBindingGroupInfos(long j3, ArrayList<Long> arrayList, IGProGetBindingGroupInfosCallback iGProGetBindingGroupInfosCallback);

        private native void native_getBlockRecGuilds(long j3, GProGetBlockRecGuildsReq gProGetBlockRecGuildsReq, IGProGetBlockRecGuildsCallback iGProGetBlockRecGuildsCallback);

        private native ArrayList<GProCategoryChannelIdList> native_getCategoryChannelIdList(long j3, long j16);

        private native ArrayList<GProCategoryChannelIdList> native_getCategoryChannelIdListExcludeCategoryType(long j3, long j16, ArrayList<Integer> arrayList);

        private native ArrayList<GProCategoryChannelInfoList> native_getCategoryChannelInfoList(long j3, long j16);

        private native ArrayList<GProCategoryChannelInfoList> native_getCategoryChannelInfoListByCategoryType(long j3, long j16, ArrayList<Integer> arrayList);

        private native void native_getCategoryChannelInfoListByFilter(long j3, GProGetCategoryChannelInfoListByFilterReq gProGetCategoryChannelInfoListByFilterReq, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback);

        private native void native_getCategoryChannelInfoListV2(long j3, GProGetCategoryChannelInfoListV2Req gProGetCategoryChannelInfoListV2Req, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback);

        private native void native_getCategoryGuilds(long j3, GProGetCategoryGuildsReq gProGetCategoryGuildsReq, IGProGetCategoryGuildsCallback iGProGetCategoryGuildsCallback);

        private native void native_getCategoryPageGuilds(long j3, GProGetCategoryPageGuildsReq gProGetCategoryPageGuildsReq, IGProGetCategoryPageGuildsCallback iGProGetCategoryPageGuildsCallback);

        private native ArrayList<Integer> native_getCategoryPermission(long j3, long j16, long j17);

        private native void native_getCategoryTabContent(long j3, GProGetCategoryTabContentReq gProGetCategoryTabContentReq, IGProGetCategoryTabContentCallback iGProGetCategoryTabContentCallback);

        private native void native_getChannelActivity(long j3, GProGetChannelActivityReq gProGetChannelActivityReq, IGProGetChannelActivityCallback iGProGetChannelActivityCallback);

        private native void native_getChannelHeartbeat(long j3, long j16, long j17, IGProGetChannelHeartbeatCallback iGProGetChannelHeartbeatCallback);

        private native HashMap<Long, ArrayList<Long>> native_getChannelIdsWithGuildIdsFromCache(long j3, GProGetChannelIdsWithGuildIdsFromCacheReq gProGetChannelIdsWithGuildIdsFromCacheReq);

        private native GProChannel native_getChannelInfo(long j3, long j16);

        private native ArrayList<Integer> native_getChannelPermission(long j3, long j16, long j17);

        private native void native_getChannelTopMsgFlashState(long j3, long j16, long j17, long j18, IGProGetChannelTopMsgFlashStateCallback iGProGetChannelTopMsgFlashStateCallback);

        private native void native_getChannelTopMsgState(long j3, long j16, long j17, IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback);

        private native int native_getChannelUserPermission(long j3, long j16, long j17);

        private native void native_getClientInfoList(long j3, int i3, byte[] bArr, IGProGetClientInfoListCallback iGProGetClientInfoListCallback);

        private native void native_getConfigTabContent(long j3, GProGetConfigTabContentReq gProGetConfigTabContentReq, IGProGetConfigTabContentCallback iGProGetConfigTabContentCallback);

        private native void native_getCurrPlaySong(long j3, long j16, long j17, IGProGetCurrPlaySongCallback iGProGetCurrPlaySongCallback);

        private native void native_getDiscoverAudioVideoInfos(long j3, GProDiscoverAudioVideoInfosReq gProDiscoverAudioVideoInfosReq, IGProGetDiscoverAudioVideoInfosCallback iGProGetDiscoverAudioVideoInfosCallback);

        private native ArrayList<Long> native_getEffectGuildIdsFromCache(long j3);

        private native GProFaceAuthInfo native_getFaceAuthInfo(long j3);

        private native void native_getFriendsInGuild(long j3, GProGetGuildFriendsReq gProGetGuildFriendsReq, IGProGetFriendsInGuildCallback iGProGetFriendsInGuildCallback);

        private native void native_getFriendsRecommend(long j3, GProGetFriendsRecommendReq gProGetFriendsRecommendReq, IGProGetFriendsRecommendCallback iGProGetFriendsRecommendCallback);

        private native ArrayList<GProGuild> native_getGroupGuildListFromCache(long j3);

        private native void native_getGuidePageInfo(long j3, long j16, String str, IGProGetGuidePageInfoCallback iGProGetGuidePageInfoCallback);

        private native void native_getGuildAndChannelListFromCache(long j3, IGProLoadGuildAndChnListCallback iGProLoadGuildAndChnListCallback);

        private native void native_getGuildBindableGroups(long j3, IGProGetGuildBindableGroupsCallback iGProGetGuildBindableGroupsCallback);

        private native void native_getGuildBindingInfo(long j3, long j16, IGProGetGuildBindingInfoCallback iGProGetGuildBindingInfoCallback);

        private native void native_getGuildBoundGroupsFirstPage(long j3, long j16, int i3, IGProGetGuildBoundGroupsFirstPageCallback iGProGetGuildBoundGroupsFirstPageCallback);

        private native void native_getGuildCheckinInfo(long j3, GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback);

        private native void native_getGuildCreatorTasks(long j3, long j16, boolean z16, IGProGetGuildCreatorTasksCallback iGProGetGuildCreatorTasksCallback);

        private native void native_getGuildFeedsValidCalendar(long j3, GProGuildSearchGetFeedCalendarReq gProGuildSearchGetFeedCalendarReq, IGProGuildGetFeedValidCalendarCallback iGProGuildGetFeedValidCalendarCallback);

        private native GProGlobalBanner native_getGuildGlobalBanner(long j3, long j16);

        private native void native_getGuildHomeCategories(long j3, GProGetGuildHomeCategoriesReq gProGetGuildHomeCategoriesReq, IGProGetGuildHomeCategoriesCallback iGProGetGuildHomeCategoriesCallback);

        private native void native_getGuildHomeSections(long j3, long j16, IGProGetGuildHomeSectionsCallback iGProGetGuildHomeSectionsCallback);

        private native GProGuild native_getGuildInfoFromCache(long j3, long j16);

        private native void native_getGuildLableInfo(long j3, GProGetGuildLabelReq gProGetGuildLabelReq, IGProGetGuildLableInfoCallback iGProGetGuildLableInfoCallback);

        private native ArrayList<GProGuild> native_getGuildListFromCache(long j3);

        private native void native_getGuildMainFrameHeaderInfo(long j3, long j16, IGProGetGuildMainFrameHeaderCallback iGProGetGuildMainFrameHeaderCallback);

        private native void native_getGuildMemberNum(long j3, long j16, IGProGetGuildMemberNumCallback iGProGetGuildMemberNumCallback);

        private native void native_getGuildNum(long j3, long j16, IGProGetGuildNumCallback iGProGetGuildNumCallback);

        private native ArrayList<Integer> native_getGuildPermission(long j3, long j16);

        private native void native_getGuildRecommend(long j3, byte[] bArr, int i3, IGProGetRecommendCallback iGProGetRecommendCallback);

        private native long native_getGuildRoleLimit(long j3, long j16);

        private native void native_getGuildShowWeakNotify(long j3, long j16, IGProGetGuildShowWeakNotifyCallback iGProGetGuildShowWeakNotifyCallback);

        private native GProSpeakPermissionInfo native_getGuildSpeakPermission(long j3, long j16, int i3);

        private native String native_getGuildUserAvatarPendantUrl(long j3, long j16);

        private native HashMap<Long, String> native_getGuildUserAvatarPendantUrls(long j3, ArrayList<Long> arrayList);

        private native String native_getGuildUserAvatarUrl(long j3, long j16, long j17, int i3);

        private native HashMap<Long, String> native_getGuildUserAvatarUrls(long j3, long j16, ArrayList<Long> arrayList, int i3);

        private native ArrayList<Long> native_getGuildUserChannelCategoryAdminList(long j3, long j16, long j17);

        private native HashMap<Long, ArrayList<Long>> native_getGuildUserChannelCategoryAdminLists(long j3, long j16, ArrayList<Long> arrayList);

        private native HashMap<Long, GProClientIdentity> native_getGuildUserClientIdentities(long j3, long j16, ArrayList<Long> arrayList);

        private native GProClientIdentity native_getGuildUserClientIdentity(long j3, long j16, long j17);

        private native String native_getGuildUserDisplayName(long j3, long j16, long j17);

        private native HashMap<Long, String> native_getGuildUserDisplayNames(long j3, long j16, ArrayList<Long> arrayList);

        private native int native_getGuildUserLevelRoleId(long j3, long j16, long j17);

        private native GProMedal native_getGuildUserMedal(long j3, long j16);

        private native HashMap<Long, GProMedal> native_getGuildUserMedals(long j3, ArrayList<Long> arrayList);

        private native String native_getGuildUserMemberName(long j3, long j16, long j17);

        private native HashMap<Long, String> native_getGuildUserMemberNames(long j3, long j16, ArrayList<Long> arrayList);

        private native String native_getGuildUserNickname(long j3, long j16);

        private native HashMap<Long, String> native_getGuildUserNicknames(long j3, ArrayList<Long> arrayList);

        private native long native_getGuildUserTopRoleId(long j3, long j16, long j17);

        private native void native_getGuildVerifyShareInfo(long j3, GProVerifyShareInfoReq gProVerifyShareInfoReq, IGuildVerifyShareInfoCallback iGuildVerifyShareInfoCallback);

        private native void native_getGuildsInContact(long j3, IGProGetGuildsInContactCallback iGProGetGuildsInContactCallback);

        private native void native_getHotLive(long j3, GProGetHotLiveReq gProGetHotLiveReq, IGProGetHotLiveCallback iGProGetHotLiveCallback);

        private native void native_getHotSearchWords(long j3, ArrayList<Integer> arrayList, int i3, IGProGetHotSearchWordsCallback iGProGetHotSearchWordsCallback);

        private native GProJumpToCategoryInfo native_getJumpToCategory(long j3, long j16);

        private native void native_getLabelGuilds(long j3, GetLabelGuildsReq getLabelGuildsReq, IGProGetLabelGuildsCallback iGProGetLabelGuildsCallback);

        private native void native_getLiveAudioPollingCtx(long j3, long j16, long j17, IGProGetLiveAudioPollingCtxCallback iGProGetLiveAudioPollingCtxCallback);

        private native void native_getLiveAudioPollingCtxV2(long j3, GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetLiveAudioPollingCtxV2Callback iGProGetLiveAudioPollingCtxV2Callback);

        private native GProGuildRole native_getMemberLevelRoleInfo(long j3, long j16, long j17, long j18);

        private native GProGuildRole native_getMemberTopRoleInfo(long j3, long j16, long j17, long j18, long j19, int i3);

        private native GProCategoryChannelInfoList native_getMiniCategoryInfoFromCache(long j3, long j16, long j17);

        private native void native_getMoreNoticeList(long j3, int i3, long j16, int i16, IGProGetMoreNoticeListCallback iGProGetMoreNoticeListCallback);

        private native void native_getMsgNotifyMap(long j3, long j16, IGProGetMsgNotifyTypeCallback iGProGetMsgNotifyTypeCallback);

        private native void native_getMyTabContent(long j3, GProGetMyTabContentReq gProGetMyTabContentReq, IGProGetMyTabContentCallback iGProGetMyTabContentCallback);

        private native void native_getNavigation(long j3, GProGetNavigationReq gProGetNavigationReq, IGProGetNavigationCallback iGProGetNavigationCallback);

        private native void native_getNavigationStatus(long j3, GProGetNavigationStatusReq gProGetNavigationStatusReq, IGProGetNavigationStatusCallback iGProGetNavigationStatusCallback);

        private native GProOnlineMemberInfo native_getOnlineMemberInfo(long j3, long j16);

        private native void native_getOpenShareInfo(long j3, GproGetOpenShareInfoReq gproGetOpenShareInfoReq, IGProGetOpenShareInfoCallback iGProGetOpenShareInfoCallback);

        private native int native_getPermissionChangeFilter(long j3, long j16, long j17);

        private native ArrayList<GProPersonalSignatureTemplate> native_getPersonalSignatureTemplate(long j3);

        private native GProPollingChannelState native_getPollingCtx(long j3, long j16, long j17, int i3);

        private native void native_getPopupInfo(long j3, long j16, int i3, IGProGetPopupInfoCallback iGProGetPopupInfoCallback);

        private native void native_getPreviewNavigation(long j3, GProGetPreviewNavigationReq gProGetPreviewNavigationReq, IGProGetPreviewNavigationCallback iGProGetPreviewNavigationCallback);

        private native void native_getProfileSwitch(long j3, IGProGetProfileSwitchCallback iGProGetProfileSwitchCallback);

        private native GProQQMsgListChannel native_getQQMsgListChannel(long j3, long j16, long j17);

        private native ArrayList<GProQQMsgListChannel> native_getQQMsgListChannels(long j3);

        private native ArrayList<GProQQMsgListGuild> native_getQQMsgListGuilds(long j3);

        private native GProRecentVisitChannelList native_getRecentVisitChannelList(long j3, long j16);

        private native GProGetRecentVisitGuildInfosFromCacheRsp native_getRecentVisitGuildInfosListSync(long j3, int i3, int i16);

        private native void native_getRecommendForIntro(long j3, GetRecommendForIntroReq getRecommendForIntroReq, IGProGetRecommendForIntroCallback iGProGetRecommendForIntroCallback);

        private native void native_getRecommendGuildInfoFromCacheAsync(long j3, IGProGetRecommendGuildInfoCallback iGProGetRecommendGuildInfoCallback);

        private native void native_getRecommendQuickJoin(long j3, GProGetRecommendQuickJoinReq gProGetRecommendQuickJoinReq, IGProGetRecommendQuickJoinCallback iGProGetRecommendQuickJoinCallback);

        private native void native_getRecommendTabContent(long j3, GProGetRecommendTabContentReq gProGetRecommendTabContentReq, IGProGetRecommendTabContentCallback iGProGetRecommendTabContentCallback);

        private native void native_getRecommendTagList(long j3, GProGetRecommendTagListReq gProGetRecommendTagListReq, IGProGetRecommendTagListCallback iGProGetRecommendTagListCallback);

        private native void native_getRiskMemberRedPoint(long j3, GProGetRiskMemberRedPointReq gProGetRiskMemberRedPointReq, IGProGetRiskMemberRedPointCallback iGProGetRiskMemberRedPointCallback);

        private native GProGuildRole native_getRoleInfo(long j3, long j16, long j17);

        private native ArrayList<Integer> native_getRolePermission(long j3, long j16, long j17);

        private native void native_getRtmpPushUrl(long j3, IGProGetRtmpPushUrlCallback iGProGetRtmpPushUrlCallback);

        private native void native_getScheduleDetail(long j3, long j16, long j17, long j18, IGProGetScheduleDetailCallback iGProGetScheduleDetailCallback);

        private native void native_getScheduleList(long j3, long j16, long j17, long j18, IGProGetScheduleListCallback iGProGetScheduleListCallback);

        private native void native_getScheduleListNew(long j3, long j16, long j17, int i3, long j18, String str, IGProGetScheduleListNewCallback iGProGetScheduleListNewCallback);

        private native void native_getScheduleUsers(long j3, long j16, long j17, long j18, int i3, byte[] bArr, IGProGetScheduleUsersCallback iGProGetScheduleUsersCallback);

        private native void native_getSchedulesStatus(long j3, long j16, long j17, long j18, long j19, IGProGetSchedulesStatusCallback iGProGetSchedulesStatusCallback);

        private native void native_getSelectChannelIDs(long j3, GProGetSelectChannelIDReq gProGetSelectChannelIDReq, IGProGetSelectChannelIDsCallback iGProGetSelectChannelIDsCallback);

        private native int native_getSelfLiveChannelBanStatus(long j3, long j16, long j17);

        private native int native_getShareButtonFromCache(long j3, long j16, long j17, boolean z16);

        private native GProSimpleProfile native_getSimpleProfile(long j3, long j16, long j17, int i3);

        private native void native_getSimpleProfileAsync(long j3, GProGetSimpleProfileAsyncReq gProGetSimpleProfileAsyncReq, IGProGetSimpleProfileAsyncCallback iGProGetSimpleProfileAsyncCallback);

        private native ArrayList<Long> native_getSortedGuildIdsFromCache(long j3);

        private native ArrayList<GProGuild> native_getSortedGuildsFromCache(long j3);

        private native ArrayList<GProChannel> native_getSpecificTypeChannelList(long j3, long j16, int i3);

        private native ArrayList<Long> native_getToppedGuildIdsFromCache(long j3);

        private native void native_getUIData(long j3, String str, IGProGetUIDataCallback iGProGetUIDataCallback);

        private native void native_getUnBindClientService(long j3, byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback);

        private native void native_getUnBindClientServiceV2(long j3, GProGetUnbindClientReq gProGetUnbindClientReq, IGProGetUnbindClientCallback iGProGetUnbindClientCallback);

        private native void native_getUserList(long j3, long j16, long j17, boolean z16, int i3, IGProGetUserListCallback iGProGetUserListCallback);

        private native void native_getUserLiveInfo(long j3, int i3, IGProGetUserLiveInfoCallback iGProGetUserLiveInfoCallback);

        private native boolean native_hasJoinChannelRole(long j3, long j16);

        private native void native_implantChatWindow(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_initGetNoticeList(long j3, int i3, long j16, boolean z16, IGProInitGetNoticeListCallback iGProInitGetNoticeListCallback);

        private native void native_inviteJoinSingleGuild(long j3, GProCmd0xf67ReqBody gProCmd0xf67ReqBody, IGProJoinGuildCallback iGProJoinGuildCallback);

        private native void native_inviteUserHandUpForAdmin(long j3, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

        private native void native_inviteUserQueueForAdmin(long j3, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

        private native boolean native_isGuildMember(long j3, long j16);

        private native boolean native_isQQMsgListChannel(long j3, long j16, long j17);

        private native boolean native_isQQMsgListGuild(long j3, long j16);

        private native boolean native_isQQMsgListReady(long j3);

        private native void native_joinChannelByGuildTask(long j3, GProGuildTaskJoinChannelReq gProGuildTaskJoinChannelReq, IGProJoinChannelByGuildTaskCallback iGProJoinChannelByGuildTaskCallback);

        private native void native_kickAudioChannelUsers(long j3, long j16, long j17, ArrayList<Long> arrayList, IGProKickChannelMemberCallback iGProKickChannelMemberCallback);

        private native void native_kickGuildUser(long j3, long j16, ArrayList<Long> arrayList, boolean z16, GProRevokeOptions gProRevokeOptions, IGProResultCallback iGProResultCallback);

        private native void native_loadAllMemberList(long j3, long j16, long j17, IGProLoadAllMemberListCallback iGProLoadAllMemberListCallback);

        private native void native_loadGuildAndChannels(long j3, boolean z16, IGProLoadGuildAndChannelsCallback iGProLoadGuildAndChannelsCallback);

        private native void native_loadMemberListByIndex(long j3, long j16, long j17, long j18, IGProLoadMemberListByIndexCallback iGProLoadMemberListByIndexCallback);

        private native void native_loadMemberRoles(long j3, long j16, long j17, IGProLoadMemberRolesCallback iGProLoadMemberRolesCallback);

        private native void native_loadNextPageMemberList(long j3, long j16, long j17, boolean z16, byte[] bArr, int i3, IGProLoadNextPageMemberListCallback iGProLoadNextPageMemberListCallback);

        private native void native_loadPartRoleMemberList(long j3, long j16, IGProGetUserInfoCallback iGProGetUserInfoCallback);

        private native void native_loadUserInfo(long j3, long j16, ArrayList<Long> arrayList, IGProGetUserInfoCallback iGProGetUserInfoCallback);

        private native void native_loadUserList(long j3, long j16, long j17, IGProGetUserListCallback iGProGetUserListCallback);

        private native void native_loginLive(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_modifyScheduleInviteStatus(long j3, long j16, long j17, long j18, int i3, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback);

        private native void native_modifyScheduleInviteStatusV2(long j3, GProModifyScheduleInviteReq gProModifyScheduleInviteReq, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback);

        private native boolean native_onServerPushMsg(long j3, int i3, int i16, GProMsgRouttingHead gProMsgRouttingHead, byte[] bArr);

        private native void native_openAVLobbyApp(long j3, GProCreateLobbyReq gProCreateLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback);

        private native void native_popChatWindow(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_queryAVState(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_queryApplyAddGuildStatus(long j3, long j16, IGProResultCallback iGProResultCallback);

        private native void native_queryGuildEssence(long j3, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

        private native void native_queryGuildVisitor(long j3, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

        private native void native_queryRealNameAuthStatus(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_queryTinyIdByLiveUID(long j3, ArrayList<Long> arrayList, IGProQueryTinyIdByLiveUIDCallback iGProQueryTinyIdByLiveUIDCallback);

        private native void native_refreshAppChannelPreInfos(long j3, long j16, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_refreshChannelInfo(long j3, long j16, long j17, int i3, boolean z16);

        private native void native_refreshGuildInfo(long j3, long j16, boolean z16, int i3);

        private native void native_refreshGuildInfoOnly(long j3, long j16, boolean z16, int i3);

        private native void native_refreshGuildList(long j3, boolean z16);

        private native void native_refreshGuildUserProfileInfo(long j3, long j16, long j17, int i3);

        private native void native_refreshPollingData(long j3, long j16, long j17, int i3);

        private native void native_removeBanBeforeBroadcast(long j3, long j16, long j17, IGProRemoveBanBeforeBroadcastCallback iGProRemoveBanBeforeBroadcastCallback);

        private native void native_removeChannel(long j3, GProRemoveChannelReq gProRemoveChannelReq, IGProResultCallback iGProResultCallback);

        private native void native_removeChannelCategoryWithId(long j3, long j16, long j17, boolean z16, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

        private native void native_removeGuild(long j3, long j16, IGProResultCallback iGProResultCallback);

        private native boolean native_removeGuildGlobalBanner(long j3, long j16);

        private native void native_removeGuildTaskCard(long j3, GProRemoveGuildTaskCardReq gProRemoveGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_removeKernelGuildListener(long j3, IKernelGuildListener iKernelGuildListener);

        private native void native_removeMemberFromGuildBlackList(long j3, long j16, ArrayList<Long> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_removeRiskMembers(long j3, GProRemoveRiskMembersReq gProRemoveRiskMembersReq, IGProRemoveRiskMembersCallback iGProRemoveRiskMembersCallback);

        private native void native_removeSpeakOrderByUser(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_reportAISearchRecommendWords(long j3, GProAISearchWordsReportReq gProAISearchWordsReportReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_reportAVState(long j3, GProAVReportReqInfo gProAVReportReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_reportCurrentGuild(long j3, long j16);

        private native void native_reportFeedShareData(long j3, long j16, long j17, int i3, GProFeedReportData gProFeedReportData, int i16, GProReportTarget gProReportTarget, IGProReportFeedShareDataCallback iGProReportFeedShareDataCallback);

        private native void native_reportFeedback(long j3, GProFeedbackReq gProFeedbackReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_reportJoinRecommendGuild(long j3, IGProReportJoinRecommendGuild iGProReportJoinRecommendGuild);

        private native void native_reportPreventAddictionInstructions(long j3, GProPAReportExecuteReq gProPAReportExecuteReq, IGProPAReportExecuteCallback iGProPAReportExecuteCallback);

        private native void native_reportShareAtta(long j3, GProReportShareAttaReq gProReportShareAttaReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_reportShareInfo(long j3, long j16, long j17, int i3, String str, int i16, IGProResultCallback iGProResultCallback);

        private native void native_reportUserViewGuild(long j3, ArrayList<String> arrayList, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_requestBeginBroadcast(long j3, long j16, long j17, long j18, int i3, GProProgrammeInfoReq gProProgrammeInfoReq, IGProResultCallback iGProResultCallback);

        private native void native_requestPubAccountMsgCount(long j3, IGProRequestPubAccountMsgCountCallback iGProRequestPubAccountMsgCountCallback);

        private native void native_riskMemberList(long j3, GProRiskMemberListReq gProRiskMemberListReq, IGProRiskMemberListCallback iGProRiskMemberListCallback);

        private native void native_saveCustomApplication(long j3, GProSaveCustomApplicationReq gProSaveCustomApplicationReq, IGProSaveCustomApplicationCallback iGProSaveCustomApplicationCallback);

        private native void native_saveGuidNavigation(long j3, GProSaveGuildNavigationReq gProSaveGuildNavigationReq, IGProSaveGuildNavigationCallback iGProSaveGuildNavigationCallback);

        private native void native_searchBlackUserFromServer(long j3, GProSearchBlackUserReq gProSearchBlackUserReq, IGProSearchBlackUserFromServerCallback iGProSearchBlackUserFromServerCallback);

        private native void native_searchChannelContent(long j3, long j16, long j17, String str, byte[] bArr, GProSearchType gProSearchType, GProSearchCond gProSearchCond, IGProSearchChannelContentCallback iGProSearchChannelContentCallback);

        private native void native_searchGuild(long j3, String str, byte[] bArr, int i3, int i16, int i17, IGProSearchGuildInfoCallback iGProSearchGuildInfoCallback);

        private native void native_searchGuildContent(long j3, GProGuildSearchNewSearchReq gProGuildSearchNewSearchReq, IGProGuildSearchCallback iGProGuildSearchCallback);

        private native void native_searchGuildFeeds(long j3, GProSearchGuildFeedsReq gProSearchGuildFeedsReq, IGProSearchChannelContentCallback iGProSearchChannelContentCallback);

        private native void native_searchGuildMembersBySourceId(long j3, GProGuildMemberSearchParams gProGuildMemberSearchParams, IGProSearchGuildMembersBySourceIdCallback iGProSearchGuildMembersBySourceIdCallback);

        private native void native_searchMsgSeqsFromServer(long j3, GProMsgSearchReq gProMsgSearchReq, IGProSearchMsgSeqsFromServerCallback iGProSearchMsgSeqsFromServerCallback);

        private native void native_searchUnion(long j3, String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, IGProSearchUnionCallback iGProSearchUnionCallback);

        private native void native_sendAudioOrLiveNotice(long j3, GProSendNoticeReq gProSendNoticeReq, IGProSendAudioOrLiveNoticeCallback iGProSendAudioOrLiveNoticeCallback);

        private native void native_sendChannelHeartbeat(long j3, GProHeartbeatReq gProHeartbeatReq);

        private native void native_sendDirectMsgReadReport(long j3, ArrayList<GProDirectMsgReport> arrayList);

        private native void native_sendOperationSaveMsg(long j3, GProSaveMsgReq gProSaveMsgReq, IGProSendOperationSaveMsgCallBack iGProSendOperationSaveMsgCallBack);

        private native void native_sendScheduleArkMessage(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProScheduleSendArkGuildInfo> arrayList3, GProScheduleSendArkGuildInfo gProScheduleSendArkGuildInfo, long j16, int i3, String str, String str2, String str3, byte[] bArr, IGProSendScheduleArkMessageCallback iGProSendScheduleArkMessageCallback);

        private native void native_setAVChannelInviteSpeakSwitch(long j3, long j16, long j17, GProInviteSpeakCfg gProInviteSpeakCfg, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setAVChannelSpeakMode(long j3, long j16, long j17, String str, GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg, IGProSetSpeakModeCallback iGProSetSpeakModeCallback);

        private native void native_setAVChannelSpeakOrder(long j3, long j16, long j17, GProVoiceQueueCfg gProVoiceQueueCfg, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setAddGuildOption(long j3, long j16, int i3, String str, String str2, IGProResultCallback iGProResultCallback);

        private native void native_setAnchorRoomInfo(long j3, GProAnchorSetRoomInfoReq gProAnchorSetRoomInfoReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setCategoryFolded(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setChannelAuthControl(long j3, long j16, long j17, int i3, int i16, IGProResultCallback iGProResultCallback);

        private native void native_setChannelAuthControlMemberList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelAuthControlRoleList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelBannedSpeak(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelCategoryInfoWithId(long j3, long j16, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

        private native void native_setChannelCategoryOrder(long j3, GProSetCategoryOrderReq gProSetCategoryOrderReq, IGProSetCategoryOrderCallback iGProSetCategoryOrderCallback);

        private native void native_setChannelCategoryOrderWithId(long j3, long j16, ArrayList<Long> arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

        private native void native_setChannelCategoryWithId(long j3, long j16, long j17, long j18, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

        private native void native_setChannelHeartbeat(long j3, GProHeartbeatReq gProHeartbeatReq);

        private native void native_setChannelLiveable(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelLiveableMemberList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setChannelLiveableRoleList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setChannelMsgNotifyType(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelName(long j3, long j16, long j17, String str, IGProResultCallback iGProResultCallback);

        private native void native_setChannelSlowMode(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelSpeakable(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelSpeakableMemberList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setChannelSpeakableRoleList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setChannelSpeakerPerm(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelTopMsg(long j3, long j16, long j17, long j18, int i3, IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback);

        private native void native_setChannelUserNumLimit(long j3, long j16, long j17, int i3, boolean z16, int i16, IGProResultCallback iGProResultCallback);

        private native void native_setChannelVisible(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setChannelVisibleMemberList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setChannelVisibleRoleList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setClientShowConfig(long j3, int i3, int i16, int i17, IGProSetClientShowConfigCallback iGProSetClientShowConfigCallback);

        private native void native_setDirectMsgBlack(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setDirectMsgNotify(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setDirectMsgNotifyForGuild(long j3, int i3, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setDirectMsgStatus(long j3, int i3, int i16, IGProResultCallback iGProResultCallback);

        private native void native_setEnteredChannelState(long j3, long j16, long j17, boolean z16);

        private native void native_setFeedCommentsNotifySwitch(long j3, int i3, IGProSetFeedCommentsNotifySwitchCallback iGProSetFeedCommentsNotifySwitchCallback);

        private native void native_setGender(long j3, int i3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setGlobalPrivacySwitch(long j3, int i3, int i16, IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback);

        private native void native_setGuildAdmin(long j3, long j16, long j17, boolean z16, IGProSetGuildAdminResultCallback iGProSetGuildAdminResultCallback);

        private native void native_setGuildAuditInfo(long j3, GProGuildAuditInfoReq gProGuildAuditInfoReq, IGProAuditInfoResultCallback iGProAuditInfoResultCallback);

        private native void native_setGuildBoundGroups(long j3, GProSortAndWriteBindGroupsReq gProSortAndWriteBindGroupsReq, IGProSetGuildBoundGroupsCallback iGProSetGuildBoundGroupsCallback);

        private native void native_setGuildClientId(long j3, long j16, int i3, IGProSetGuildClientIdCallback iGProSetGuildClientIdCallback);

        private native void native_setGuildCommonUnNotifyFlag(long j3, long j16, int i3, int i16, IGProSetGuildNotifyDisplayCallback iGProSetGuildNotifyDisplayCallback);

        private native void native_setGuildCoverFontColorId(long j3, long j16, int i3, IGProSetGuildCoverFontColorIdCallback iGProSetGuildCoverFontColorIdCallback);

        private native void native_setGuildCreatorTaskSkipStatus(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setGuildGlobalBanner(long j3, GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback);

        private native void native_setGuildGlobalPermission(long j3, GProSetGlobalPermissionReq gProSetGlobalPermissionReq, IGProResultCallback iGProResultCallback);

        private native void native_setGuildListSort(long j3, ArrayList<Long> arrayList, IGProSetGuildListSortCallback iGProSetGuildListSortCallback);

        private native void native_setGuildListTop(long j3, long j16, int i3, int i16, IGProSetGuildListTopCallback iGProSetGuildListTopCallback);

        private native void native_setGuildMemberName(long j3, long j16, String str, String str2, IGProResultCallback iGProResultCallback);

        private native void native_setGuildName(long j3, long j16, String str, IGProResultCallback iGProResultCallback);

        private native void native_setGuildNeedRealNameForVisitor(long j3, long j16, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setGuildNumSearchSwitch(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setGuildProfile(long j3, long j16, String str, IGProResultCallback iGProResultCallback);

        private native void native_setGuildQRCodePeriod(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setGuildQRCodeSwitch(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setGuildShutUp(long j3, long j16, long j17, IGProResultCallback iGProResultCallback);

        private native void native_setGuildSpeakableMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setGuildSpeakableRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setGuildSpeakableRule(long j3, long j16, GproGuildSpeakableRule gproGuildSpeakableRule, IGProResultCallback iGProResultCallback);

        private native void native_setGuildSpeakableThreshold(long j3, long j16, GProGuildSpeakableThreshold gProGuildSpeakableThreshold, IGProResultCallback iGProResultCallback);

        private native void native_setGuildTop(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setGuildUnNotifyFlag(long j3, long j16, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback);

        private native void native_setGuildVisibilityForVisitor(long j3, long j16, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setGuildWeakNotifyDisplay(long j3, long j16, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback);

        private native void native_setHeader(long j3, String str, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setJoinGuildOption(long j3, GProSetJoinGuildOptionReq gProSetJoinGuildOptionReq, IGProResultCallback iGProResultCallback);

        private native void native_setJumpToCategory(long j3, GProJumpToCategoryInfo gProJumpToCategoryInfo, IGProResultCallback iGProResultCallback);

        private native void native_setListenTogetherPlayOpt(long j3, long j16, long j17, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback);

        private native void native_setListenTogetherPlayVolumeByAdmin(long j3, long j16, long j17, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback);

        private native void native_setLiveChannelAnchorList(long j3, long j16, long j17, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setLiveChannelBannedUser(long j3, long j16, long j17, long j18, long j19, int i3, IGProResultCallback iGProResultCallback);

        private native void native_setLocation(long j3, GProLocation gProLocation, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setMemberRoles(long j3, long j16, long j17, long j18, long j19, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setMemberShutUp(long j3, long j16, long j17, long j18, IGProResultCallback iGProResultCallback);

        private native void native_setMyBirthday(long j3, short s16, short s17, short s18, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setMyPersonalSignature(long j3, String str, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setMyProfileShowTypeSwitch(long j3, long j16, int i3, int i16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setMyVoiceNetworkQuality(long j3, long j16, long j17, int i3);

        private native void native_setMyVoiceSysMicStatus(long j3, long j16, long j17, int i3);

        private native void native_setNickName(long j3, String str, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setOnLogin(long j3);

        private native void native_setPerformanceEnable(long j3, boolean z16);

        private native void native_setProfileSwitch(long j3, int i3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_setQQMsgListChannel(long j3, long j16, long j17, int i3, IGProSetQQMsgListChannelCallback iGProSetQQMsgListChannelCallback);

        private native void native_setQQMsgListGuild(long j3, long j16, int i3, int i16, IGProSetQQMsgListGuildCallback iGProSetQQMsgListGuildCallback);

        private native void native_setRoleChannels(long j3, long j16, long j17, int i3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProSetRoleChannelsCallback iGProSetRoleChannelsCallback);

        private native void native_setRoleInfo(long j3, long j16, long j17, GProRoleCreateInfo gProRoleCreateInfo, IGProResultCallback iGProResultCallback);

        private native void native_setRoleMembers(long j3, long j16, long j17, long j18, long j19, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

        private native void native_setRoleOrder(long j3, long j16, ArrayList<Long> arrayList, IGProResultCallback iGProResultCallback);

        private native void native_setScreenSharedInGuild(long j3, long j16, long j17, boolean z16, IGProScreenShareCallback iGProScreenShareCallback);

        private native void native_setSearchSwitch(long j3, GProSetSearchSwitchReq gProSetSearchSwitchReq, IGProSetSearchSwitchCallback iGProSetSearchSwitchCallback);

        private native void native_setSelfTinyId(long j3, long j16);

        private native void native_setShowArchive(long j3, int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback);

        private native void native_setShowPresence(long j3, int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback);

        private native void native_setTopicSquareEntranceSwitch(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setUIData(long j3, String str, String str2);

        private native void native_setUserLiveInfo(long j3, int i3, String str, String str2, int i16, IGProSetUserLiveInfoCallback iGProSetUserLiveInfoCallback);

        private native void native_setUserMuteSeatInGuild(long j3, long j16, long j17, long j18, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setUserPermissionInGuild(long j3, long j16, long j17, long j18, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setUserScreenSharedInGuild(long j3, long j16, long j17, long j18, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setUserType(long j3, String str, IGProUserTypeSetCallback iGProUserTypeSetCallback);

        private native void native_setUserTypeWithUserConfigure(long j3, boolean z16, IGProUserTypeSetCallback iGProUserTypeSetCallback);

        private native void native_setUserVoicelessToMe(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

        private native void native_setWindowFliter(long j3, ArrayList<Long> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_startAnchorBroadcast(long j3, long j16, long j17, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_startHeartbeat(long j3, long j16, long j17);

        private native void native_startPollingForDiscoverState(long j3);

        private native void native_startPush(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_stopPollingForDiscoverState(long j3, boolean z16);

        private native void native_subscribePolling(long j3, long j16, int i3);

        private native void native_subscribePollingChannels(long j3, ArrayList<GProPollingInfo> arrayList);

        private native void native_subscribePollingSchedule(long j3, GProSubscribePollingScheduleReq gProSubscribePollingScheduleReq);

        private native void native_superAdminBanUser(long j3, GProSuperAdminBanUserReq gProSuperAdminBanUserReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_superAdminUnListFeed(long j3, GProCmd0x92331SuperAdminUnListFeedReq gProCmd0x92331SuperAdminUnListFeedReq, IGProSuperAdminUnListFeedCallback iGProSuperAdminUnListFeedCallback);

        private native void native_switchAVLobbyApp(long j3, GProSwitchLobbyReq gProSwitchLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback);

        private native void native_terminateLiveStream(long j3, long j16, long j17, int i3, int i16, IGProTerminateLiveStreamCallback iGProTerminateLiveStreamCallback);

        private native void native_topSpeakOrderByAdmin(long j3, GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

        private native void native_transThirdPlatformURL(long j3, GProTransThirdPlatformURLReq gProTransThirdPlatformURLReq, IGProTransThirdPlatformURLCallback iGProTransThirdPlatformURLCallback);

        private native void native_transThirdVideoURL(long j3, GProTransThirdVideoURLReq gProTransThirdVideoURLReq, IGProTransThirdVideoURLCallback iGProTransThirdVideoURLCallback);

        private native void native_transferGuildOwner(long j3, GProTransferGuildOwnerReq gProTransferGuildOwnerReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_tryUnmuteMicrophone(long j3, long j16, long j17, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_ubSubscribePollingChannels(long j3, ArrayList<GProPollingInfo> arrayList);

        private native void native_unsubscribePolling(long j3, long j16);

        private native void native_updateArchiveShowSeq(long j3, ArrayList<Integer> arrayList, IGProUpdateArchiveShowSeqCallback iGProUpdateArchiveShowSeqCallback);

        private native void native_updateAudioLiveChannelTheme(long j3, GProUpdateChannelThemeReq gProUpdateChannelThemeReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_updateForumChannelSortMode(long j3, long j16, long j17, int i3, IGProResultCallback iGProResultCallback);

        private native void native_updateGuildEssence(long j3, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

        private native void native_updateGuildTaskCardProgress(long j3, GProUpdateGuildTaskCardProgressReq gProUpdateGuildTaskCardProgressReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_updateGuildVisitor(long j3, GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

        private native void native_upgradeGroupFeed(long j3, ArrayList<Long> arrayList, int i3, IGProUpgradeGroupCallback iGProUpgradeGroupCallback);

        private native void native_userDealSpeakInvitation(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_userHandUp(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_userOnlineReport(long j3, GProGuildOnlineReportReq gProGuildOnlineReportReq, IGProUserOnlineReportCallback iGProUserOnlineReportCallback);

        private native void native_userShareScreen(long j3, GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

        private native void native_voiceChannelAuth0x10b6(long j3, long j16, long j17, int i3, boolean z16, int i16, IGProVoiceChannelAuthCallback iGProVoiceChannelAuthCallback);

        private native void native_voiceSmobaGameCreateRoom(long j3, GProVoiceSmobaGameBaseRoomParams gProVoiceSmobaGameBaseRoomParams, GProVoiceSmobaGameSmobaRoomParams gProVoiceSmobaGameSmobaRoomParams, IGProVoiceSmobaGameCreateRoomCallback iGProVoiceSmobaGameCreateRoomCallback);

        private native void native_voiceSmobaGameDissmissRoom(long j3, GProVoiceSmobaGameDissmissRoomReq gProVoiceSmobaGameDissmissRoomReq, IGProSimpleResultCallback iGProSimpleResultCallback);

        private native void native_voiceSmobaGameEnterRoom(long j3, long j16, int i3, long j17, long j18, IGProVoiceSmobaGameEnterRoomCallback iGProVoiceSmobaGameEnterRoomCallback);

        private native void native_voiceSmobaGameKickOutRoom(long j3, GProVoiceSmobaGameKickOutRoomReq gProVoiceSmobaGameKickOutRoomReq, IGProVoiceSmobaKickOutRoomCallback iGProVoiceSmobaKickOutRoomCallback);

        private native void native_voiceSmobaGameQuitRoom(long j3, GProVoiceSmobaGameQuitRoomReq gProVoiceSmobaGameQuitRoomReq, IGProVoiceSmobaGameQuitRoomCallback iGProVoiceSmobaGameQuitRoomCallback);

        public static native void preloadInitJni();

        public static native int preloadMethod();

        public static native void setSdkLoggerLevel(int i3);

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void CancelDownloadBroadcastHelper() {
            native_CancelDownloadBroadcastHelper(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void DownloadBroadcastHelper() {
            native_DownloadBroadcastHelper(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void GetMemberInfoByOpenId(String str, long j3, boolean z16, boolean z17, IGProGetMemberInfoByOpenIdCallback iGProGetMemberInfoByOpenIdCallback) {
            native_GetMemberInfoByOpenId(this.nativeRef, str, j3, z16, z17, iGProGetMemberInfoByOpenIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void InstallBroadcastHelper(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_InstallBroadcastHelper(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void LoadGuildUserProfileInfo(long j3, long j16, IGProLoadGuildUserProfileCallback iGProLoadGuildUserProfileCallback) {
            native_LoadGuildUserProfileInfo(this.nativeRef, j3, j16, iGProLoadGuildUserProfileCallback);
        }

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void activeBroadcast(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_activeBroadcast(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addGuild(long j3, GProSourceId gProSourceId, String str, IGProJoinGuildCallback iGProJoinGuildCallback) {
            native_addGuild(this.nativeRef, j3, gProSourceId, str, iGProJoinGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addGuildWithOption(GProAddGuildWithOptionReq gProAddGuildWithOptionReq, IGProJoinGuildCallback iGProJoinGuildCallback) {
            native_addGuildWithOption(this.nativeRef, gProAddGuildWithOptionReq, iGProJoinGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addGuilds(ArrayList<GProJoinGuilds> arrayList, GProSourceId gProSourceId, IGProJoinGuildsCallback iGProJoinGuildsCallback) {
            native_addGuilds(this.nativeRef, arrayList, gProSourceId, iGProJoinGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addGuildsForGrowth(String str, ArrayList<GProJoinGuilds> arrayList, IGProJoinGuildsCallback iGProJoinGuildsCallback) {
            native_addGuildsForGrowth(this.nativeRef, str, arrayList, iGProJoinGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addKernelGuildListener(IKernelGuildListener iKernelGuildListener) {
            native_addKernelGuildListener(this.nativeRef, iKernelGuildListener);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addRecentVisitGuildsListSync(ArrayList<Long> arrayList, IGProAddRecentVisitGuildIdsCallback iGProAddRecentVisitGuildIdsCallback) {
            native_addRecentVisitGuildsListSync(this.nativeRef, arrayList, iGProAddRecentVisitGuildIdsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void addSpeakOrderByUser(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_addSpeakOrderByUser(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void anchorEnterRoom(GProAnchorEnterRoomReq gProAnchorEnterRoomReq, IGProAnchorEnterRoomCallback iGProAnchorEnterRoomCallback) {
            native_anchorEnterRoom(this.nativeRef, gProAnchorEnterRoomReq, iGProAnchorEnterRoomCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void anchorLeaveRoom(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_anchorLeaveRoom(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void appAuthorization(int i3, IGProAppAuthorizationCallback iGProAppAuthorizationCallback) {
            native_appAuthorization(this.nativeRef, i3, iGProAppAuthorizationCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void audienceEnterRoom(GProLiveEnterRoomRequest gProLiveEnterRoomRequest, IGProOnAudienceEnterRoomCallback iGProOnAudienceEnterRoomCallback) {
            native_audienceEnterRoom(this.nativeRef, gProLiveEnterRoomRequest, iGProOnAudienceEnterRoomCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void audienceLeaveRoom(long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_audienceLeaveRoom(this.nativeRef, j3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void authScreenShared(long j3, long j16, IGProScreenShareCallback iGProScreenShareCallback) {
            native_authScreenShared(this.nativeRef, j3, j16, iGProScreenShareCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchDeleteAISearchSession(GProAISearchBatchDeleteSessionReq gProAISearchBatchDeleteSessionReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_batchDeleteAISearchSession(this.nativeRef, gProAISearchBatchDeleteSessionReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchFetchAudioChannelSimpleUserList(long j3, ArrayList<Long> arrayList, boolean z16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback) {
            native_batchFetchAudioChannelSimpleUserList(this.nativeRef, j3, arrayList, z16, iGProFetchAudioChannelUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchGetAudioBotStatus(GProGetAudioBotStatusReq gProGetAudioBotStatusReq, IGProBatchGetAudioBotStatusCallback iGProBatchGetAudioBotStatusCallback) {
            native_batchGetAudioBotStatus(this.nativeRef, gProGetAudioBotStatusReq, iGProBatchGetAudioBotStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchGetGuildLabelInfo(GProBatchGetGuildLabelInfoReq gProBatchGetGuildLabelInfoReq, IGProBatchGetGuildLabelInfoCallback iGProBatchGetGuildLabelInfoCallback) {
            native_batchGetGuildLabelInfo(this.nativeRef, gProBatchGetGuildLabelInfoReq, iGProBatchGetGuildLabelInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchGetItemDetail(GProGetItemDetailReq gProGetItemDetailReq, IGProGetItemDetailCallback iGProGetItemDetailCallback) {
            native_batchGetItemDetail(this.nativeRef, gProGetItemDetailReq, iGProGetItemDetailCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchSetCategoryFolded(long j3, HashMap<Long, Boolean> hashMap, IGProResultCallback iGProResultCallback) {
            native_batchSetCategoryFolded(this.nativeRef, j3, hashMap, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchSetGuildInfoBoolField(long j3, HashMap<Integer, Boolean> hashMap, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_batchSetGuildInfoBoolField(this.nativeRef, j3, hashMap, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchSetGuildInfoIntField(long j3, HashMap<Integer, Integer> hashMap, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_batchSetGuildInfoIntField(this.nativeRef, j3, hashMap, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void batchUpdateChannelsMsgNotifyType(long j3, ArrayList<GProChannelMsgNotify> arrayList, IGProResultCallback iGProResultCallback) {
            native_batchUpdateChannelsMsgNotifyType(this.nativeRef, j3, arrayList, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void beforehandGetGuildSpeakPermission(long j3, int i3, IGProBeforehandGetSpeakPermissionCallback iGProBeforehandGetSpeakPermissionCallback) {
            native_beforehandGetGuildSpeakPermission(this.nativeRef, j3, i3, iGProBeforehandGetSpeakPermissionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void bindAppRole(int i3, String str, int i16, IGProBindAppRoleCallback iGProBindAppRoleCallback) {
            native_bindAppRole(this.nativeRef, i3, str, i16, iGProBindAppRoleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void cancelChannelTopMsg(long j3, long j16, ArrayList<GProTopMsg> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_cancelChannelTopMsg(this.nativeRef, j3, j16, arrayList, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void cancelSpeakOrderByAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
            native_cancelSpeakOrderByAdmin(this.nativeRef, gProAdminAVReqInfo, iGProAdminDealResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void cancelUserHandUpForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
            native_cancelUserHandUpForAdmin(this.nativeRef, gProAdminAVReqInfo, iGProAdminDealResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void changeChannelCategoryNameWithId(long j3, long j16, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
            native_changeChannelCategoryNameWithId(this.nativeRef, j3, j16, str, iGProSetChannelCategoryInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void changeGuildAllowSearch(long j3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_changeGuildAllowSearch(this.nativeRef, j3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkAVState(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_checkAVState(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkAndEncryptText(GProEncryptTextReq gProEncryptTextReq, IGProCheckAndEncryptTextCallBack iGProCheckAndEncryptTextCallBack) {
            native_checkAndEncryptText(this.nativeRef, gProEncryptTextReq, iGProCheckAndEncryptTextCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkFeedAbstractInfo(GProCheckFeedAbstractInfoReq gProCheckFeedAbstractInfoReq, IGProCheckFeedAbstractInfoCallback iGProCheckFeedAbstractInfoCallback) {
            native_checkFeedAbstractInfo(this.nativeRef, gProCheckFeedAbstractInfoReq, iGProCheckFeedAbstractInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkIsStrangerNewMember(IGProCheckIsStrangerNewMemberCallback iGProCheckIsStrangerNewMemberCallback) {
            native_checkIsStrangerNewMember(this.nativeRef, iGProCheckIsStrangerNewMemberCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkLobbyAppAuthStatus(String str, long j3, long j16, IGProCheckLobbyAppAuthStatusCallback iGProCheckLobbyAppAuthStatusCallback) {
            native_checkLobbyAppAuthStatus(this.nativeRef, str, j3, j16, iGProCheckLobbyAppAuthStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkPreventAddiction(GProPreventAddictionCheckReq gProPreventAddictionCheckReq, IGProPreventAddictionCheckCallback iGProPreventAddictionCheckCallback) {
            native_checkPreventAddiction(this.nativeRef, gProPreventAddictionCheckReq, iGProPreventAddictionCheckCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkUserBannedSpeakInChannel(long j3, long j16, long j17, IGProCheckUserBannedSpeakInChannelCallback iGProCheckUserBannedSpeakInChannelCallback) {
            native_checkUserBannedSpeakInChannel(this.nativeRef, j3, j16, j17, iGProCheckUserBannedSpeakInChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void checkUserFreeGiftInfo(GProUserFreeGiftReq gProUserFreeGiftReq, IGProCheckUserFreeGiftCallback iGProCheckUserFreeGiftCallback) {
            native_checkUserFreeGiftInfo(this.nativeRef, gProUserFreeGiftReq, iGProCheckUserFreeGiftCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void clearGuildRelatedData(ArrayList<Long> arrayList) {
            native_clearGuildRelatedData(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void closeAVLobbyApp(long j3, long j16, long j17, IGProDeleteLobbyCallback iGProDeleteLobbyCallback) {
            native_closeAVLobbyApp(this.nativeRef, j3, j16, j17, iGProDeleteLobbyCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void closeChannelActivitySwitch(long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_closeChannelActivitySwitch(this.nativeRef, j3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void closeChannelTopMsg(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_closeChannelTopMsg(this.nativeRef, j3, j16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void convertGuildAndThirdIds(GProConvertThirdIdReq gProConvertThirdIdReq, IGProConvertGuildAndThirdIdCallback iGProConvertGuildAndThirdIdCallback) {
            native_convertGuildAndThirdIds(this.nativeRef, gProConvertThirdIdReq, iGProConvertGuildAndThirdIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProInviteInfo convertToGuildInviteInfo(GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo) {
            return native_convertToGuildInviteInfo(this.nativeRef, gProCmd0xf5aGuildInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createChannelCategoryWithId(long j3, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
            native_createChannelCategoryWithId(this.nativeRef, j3, str, iGProSetChannelCategoryInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createChannelWithId(long j3, GProChannelCreateInfo gProChannelCreateInfo, long j16, GProAssocCreateCategoryReq gProAssocCreateCategoryReq, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProCreateChannelCallback iGProCreateChannelCallback) {
            native_createChannelWithId(this.nativeRef, j3, gProChannelCreateInfo, j16, gProAssocCreateCategoryReq, gProCategoryChannelIdList, arrayList, iGProCreateChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createDirectMsgSession(GProDirectMsgCreateInfo gProDirectMsgCreateInfo, IGProCreateDirectMsgSessionCallback iGProCreateDirectMsgSessionCallback) {
            native_createDirectMsgSession(this.nativeRef, gProDirectMsgCreateInfo, iGProCreateDirectMsgSessionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createGuild(GProCreateGuildReq gProCreateGuildReq, IGProCreateGuildCallback iGProCreateGuildCallback) {
            native_createGuild(this.nativeRef, gProCreateGuildReq, iGProCreateGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createLinkChannelWithId(long j3, GProChannelCreateInfo gProChannelCreateInfo, long j16, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_createLinkChannelWithId(this.nativeRef, j3, gProChannelCreateInfo, j16, gProCategoryChannelIdList, arrayList, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createRole(long j3, GProRoleCreateInfo gProRoleCreateInfo, ArrayList<Long> arrayList, IGProCreateRoleCallback iGProCreateRoleCallback) {
            native_createRole(this.nativeRef, j3, gProRoleCreateInfo, arrayList, iGProCreateRoleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createSchedule(long j3, long j16, GProScheduleInfo gProScheduleInfo, IGProCreateScheduleCallback iGProCreateScheduleCallback) {
            native_createSchedule(this.nativeRef, j3, j16, gProScheduleInfo, iGProCreateScheduleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createScheduleLimitQuery(long j3, IGProCreateScheduleLimitQueryCallback iGProCreateScheduleLimitQueryCallback) {
            native_createScheduleLimitQuery(this.nativeRef, j3, iGProCreateScheduleLimitQueryCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void createScheduleV2(GProCreateScheduleReq gProCreateScheduleReq, IGProCreateScheduleCallback iGProCreateScheduleCallback) {
            native_createScheduleV2(this.nativeRef, gProCreateScheduleReq, iGProCreateScheduleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void customChannelMsgNotifyType(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_customChannelMsgNotifyType(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void dealHandUpRequestForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, boolean z16, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
            native_dealHandUpRequestForAdmin(this.nativeRef, gProAdminAVReqInfo, z16, iGProAdminDealResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void dealNotice(String str, String str2, IGProDealNoticeCallback iGProDealNoticeCallback) {
            native_dealNotice(this.nativeRef, str, str2, iGProDealNoticeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void decodeInviteJumpInfo(String str, IGProDecodeInviteJumpInfoCallback iGProDecodeInviteJumpInfoCallback) {
            native_decodeInviteJumpInfo(this.nativeRef, str, iGProDecodeInviteJumpInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGetContentRecommendRsp decodeMVPFeedsRspPb(byte[] bArr) {
            return native_decodeMVPFeedsRspPb(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProScheduleInfo decodeScheduleInfo(byte[] bArr) {
            return native_decodeScheduleInfo(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void deleteAISearchSession(GProAISearchDeleteSessionReq gProAISearchDeleteSessionReq, IGProDeleteAISearchSessionCallback iGProDeleteAISearchSessionCallback) {
            native_deleteAISearchSession(this.nativeRef, gProAISearchDeleteSessionReq, iGProDeleteAISearchSessionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void deleteFeed(GProDeleteFeedReq gProDeleteFeedReq, IGProDeleteFeedCallback iGProDeleteFeedCallback) {
            native_deleteFeed(this.nativeRef, gProDeleteFeedReq, iGProDeleteFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void deleteGuildEssence(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
            native_deleteGuildEssence(this.nativeRef, gProGuildEssenceSvrReq, iGProGuildEssenceCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void deleteGuildGlobalBanner(GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback) {
            native_deleteGuildGlobalBanner(this.nativeRef, gProGlobalBannerRep, iGProGlobalBannerCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void deleteRole(long j3, long j16, IGProResultCallback iGProResultCallback) {
            native_deleteRole(this.nativeRef, j3, j16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void deleteSystemNoticeMessage(GProSystemNoticeMessageDeleteReq gProSystemNoticeMessageDeleteReq, IGProDeleteSystemNoticeMessageCallback iGProDeleteSystemNoticeMessageCallback) {
            native_deleteSystemNoticeMessage(this.nativeRef, gProSystemNoticeMessageDeleteReq, iGProDeleteSystemNoticeMessageCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void destroyGuild(long j3, IGProResultCallback iGProResultCallback) {
            native_destroyGuild(this.nativeRef, j3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void doGuildCheckin(GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback) {
            native_doGuildCheckin(this.nativeRef, gProGuildCheckinReq, iGProGuildCheckinCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void doRealNameAuth(int i3, IGProGetRealNameAuthCallback iGProGetRealNameAuthCallback) {
            native_doRealNameAuth(this.nativeRef, i3, iGProGetRealNameAuthCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void domainResolveByLocalDns(String str) {
            native_domainResolveByLocalDns(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void editSchedule(long j3, long j16, GProScheduleInfo gProScheduleInfo, int i3, IGProEditScheduleCallback iGProEditScheduleCallback) {
            native_editSchedule(this.nativeRef, j3, j16, gProScheduleInfo, i3, iGProEditScheduleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void editScheduleV2(GProEditScheduleReq gProEditScheduleReq, IGProEditScheduleCallback iGProEditScheduleCallback) {
            native_editScheduleV2(this.nativeRef, gProEditScheduleReq, iGProEditScheduleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void endPush(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_endPush(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void enterAudioChannel(long j3, long j16, int i3, IGProEnterAudioChannelCallback iGProEnterAudioChannelCallback) {
            native_enterAudioChannel(this.nativeRef, j3, j16, i3, iGProEnterAudioChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void enterAudioLiveChannel(GProEnterAudioLiveChannelReq gProEnterAudioLiveChannelReq, IGProEnterAudioLiveChannelCallback iGProEnterAudioLiveChannelCallback) {
            native_enterAudioLiveChannel(this.nativeRef, gProEnterAudioLiveChannelReq, iGProEnterAudioLiveChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void exitAudioChannel(long j3, long j16, IGProResultCallback iGProResultCallback) {
            native_exitAudioChannel(this.nativeRef, j3, j16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void exitAudioLiveChannel(long j3, long j16, int i3, ArrayList<String> arrayList, IGProExitAudioLiveChannelCallback iGProExitAudioLiveChannelCallback) {
            native_exitAudioLiveChannel(this.nativeRef, j3, j16, i3, arrayList, iGProExitAudioLiveChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void exposeGuildTaskCard(GProExposureGuildTaskCardReq gProExposureGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_exposeGuildTaskCard(this.nativeRef, gProExposureGuildTaskCardReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void exposeRecommends(GProExposeRecommedsReq gProExposeRecommedsReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_exposeRecommends(this.nativeRef, gProExposeRecommedsReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchActiveChannels(long j3, IGProFetchActiveChannelsCallback iGProFetchActiveChannelsCallback) {
            native_fetchActiveChannels(this.nativeRef, j3, iGProFetchActiveChannelsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAddGuildInfo(int i3, long j3, IGProAddGuildInfoCallBack iGProAddGuildInfoCallBack) {
            native_fetchAddGuildInfo(this.nativeRef, i3, j3, iGProAddGuildInfoCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAddGuildOption(long j3, int i3, IGProFetchAddGuildOptionCallback iGProFetchAddGuildOptionCallback) {
            native_fetchAddGuildOption(this.nativeRef, j3, i3, iGProFetchAddGuildOptionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAnchorPreparePage(GProAnchorPrepareReq gProAnchorPrepareReq, IGProFetchAnchorPreparePageCallback iGProFetchAnchorPreparePageCallback) {
            native_fetchAnchorPreparePage(this.nativeRef, gProAnchorPrepareReq, iGProFetchAnchorPreparePageCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAppInfos(long j3, IGProFetchAppInfosCallback iGProFetchAppInfosCallback) {
            native_fetchAppInfos(this.nativeRef, j3, iGProFetchAppInfosCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchArchiveArkData(long j3, long j16, byte[] bArr, int i3, IGProFetchArchiveArkDataCallback iGProFetchArchiveArkDataCallback) {
            native_fetchArchiveArkData(this.nativeRef, j3, j16, bArr, i3, iGProFetchArchiveArkDataCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAudioChannelUserList(long j3, long j16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback) {
            native_fetchAudioChannelUserList(this.nativeRef, j3, j16, iGProFetchAudioChannelUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAudioLiveChannelBlockUserState(long j3, long j16, IGProFetchBlockUserStateCallback iGProFetchBlockUserStateCallback) {
            native_fetchAudioLiveChannelBlockUserState(this.nativeRef, j3, j16, iGProFetchBlockUserStateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAudioLiveChannelGroupList(GProAVMemberGroupListReq gProAVMemberGroupListReq, IGProFetchAudioLiveGroupListCallback iGProFetchAudioLiveGroupListCallback) {
            native_fetchAudioLiveChannelGroupList(this.nativeRef, gProAVMemberGroupListReq, iGProFetchAudioLiveGroupListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchAudioLiveChannelUserList(GProAudioLiveUserListReq gProAudioLiveUserListReq, IGProFetchAudioLiveUserListCallback iGProFetchAudioLiveUserListCallback) {
            native_fetchAudioLiveChannelUserList(this.nativeRef, gProAudioLiveUserListReq, iGProFetchAudioLiveUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchBatchBotGetCommand(GProBatchBotGetCommand gProBatchBotGetCommand, IGProFetchBatchBotGetCommandCallback iGProFetchBatchBotGetCommandCallback) {
            native_fetchBatchBotGetCommand(this.nativeRef, gProBatchBotGetCommand, iGProFetchBatchBotGetCommandCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchCategoryAdminInfoList(GProFetchCategoryAdminDisplayInfoReq gProFetchCategoryAdminDisplayInfoReq, IGProFetchCategoryAdminInfoListCallback iGProFetchCategoryAdminInfoListCallback) {
            native_fetchCategoryAdminInfoList(this.nativeRef, gProFetchCategoryAdminDisplayInfoReq, iGProFetchCategoryAdminInfoListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelAdminInfoList(long j3, long j16, IGProChannelAdminInfoListCallback iGProChannelAdminInfoListCallback) {
            native_fetchChannelAdminInfoList(this.nativeRef, j3, j16, iGProChannelAdminInfoListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelAuthControlMemberList(long j3, long j16, int i3, byte[] bArr, int i16, IGProFetchChannelAbleMemberListCallback iGProFetchChannelAbleMemberListCallback) {
            native_fetchChannelAuthControlMemberList(this.nativeRef, j3, j16, i3, bArr, i16, iGProFetchChannelAbleMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelAuthControlRoleList(long j3, long j16, int i3, IGProFetchChannelAbleRoleListCallback iGProFetchChannelAbleRoleListCallback) {
            native_fetchChannelAuthControlRoleList(this.nativeRef, j3, j16, i3, iGProFetchChannelAbleRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelAuthControlUnableMemberList(long j3, long j16, int i3, byte[] bArr, int i16, IGProFetchChannelUnableMemberListCallback iGProFetchChannelUnableMemberListCallback) {
            native_fetchChannelAuthControlUnableMemberList(this.nativeRef, j3, j16, i3, bArr, i16, iGProFetchChannelUnableMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelInfo(long j3, long j16, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback) {
            native_fetchChannelInfo(this.nativeRef, j3, j16, i3, iGProFetchChannelInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelInfoWithCategory(long j3, long j16, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback) {
            native_fetchChannelInfoWithCategory(this.nativeRef, j3, j16, i3, iGProFetchChannelInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelInfoWithUnreadStatus(long j3, boolean z16) {
            native_fetchChannelInfoWithUnreadStatus(this.nativeRef, j3, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelInvisibleMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelInvisibleMemberListCallback iGProFetchChannelInvisibleMemberListCallback) {
            native_fetchChannelInvisibleMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelInvisibleMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelInvisibleRoleList(long j3, long j16, IGProFetchChannelInvisibleRoleListCallback iGProFetchChannelInvisibleRoleListCallback) {
            native_fetchChannelInvisibleRoleList(this.nativeRef, j3, j16, iGProFetchChannelInvisibleRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelList(ArrayList<Long> arrayList, IGProFetchChannelListCategoryCallback iGProFetchChannelListCategoryCallback) {
            native_fetchChannelList(this.nativeRef, arrayList, iGProFetchChannelListCategoryCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelListForJump(long j3, IGProFetchChannelListForJumpCallback iGProFetchChannelListForJumpCallback) {
            native_fetchChannelListForJump(this.nativeRef, j3, iGProFetchChannelListForJumpCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelListState(ArrayList<GProGuildStateReqInfo> arrayList, IGProFetchChannelListStateCallback iGProFetchChannelListStateCallback) {
            native_fetchChannelListState(this.nativeRef, arrayList, iGProFetchChannelListStateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelLiveableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelLiveableMemberListCallback iGProFetchChannelLiveableMemberListCallback) {
            native_fetchChannelLiveableMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelLiveableMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelLiveableRoleList(long j3, long j16, IGProFetchChannelLiveableRoleListCallback iGProFetchChannelLiveableRoleListCallback) {
            native_fetchChannelLiveableRoleList(this.nativeRef, j3, j16, iGProFetchChannelLiveableRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelSpeakableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelSpeakableMemberListCallback iGProFetchChannelSpeakableMemberListCallback) {
            native_fetchChannelSpeakableMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelSpeakableMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelSpeakableRoleList(long j3, long j16, IGProFetchChannelSpeakableRoleListCallback iGProFetchChannelSpeakableRoleListCallback) {
            native_fetchChannelSpeakableRoleList(this.nativeRef, j3, j16, iGProFetchChannelSpeakableRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelUnlivableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelUnlivableMemberListCallback iGProFetchChannelUnlivableMemberListCallback) {
            native_fetchChannelUnlivableMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelUnlivableMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelUnlivableRoleList(long j3, long j16, IGProFetchChannelUnlivableRoleListCallback iGProFetchChannelUnlivableRoleListCallback) {
            native_fetchChannelUnlivableRoleList(this.nativeRef, j3, j16, iGProFetchChannelUnlivableRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelUnspeakableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelUnspeakableMemberListCallback iGProFetchChannelUnspeakableMemberListCallback) {
            native_fetchChannelUnspeakableMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelUnspeakableMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelUnspeakableRoleList(long j3, long j16, IGProFetchChannelUnspeakableRoleListCallback iGProFetchChannelUnspeakableRoleListCallback) {
            native_fetchChannelUnspeakableRoleList(this.nativeRef, j3, j16, iGProFetchChannelUnspeakableRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelUserPermission(long j3, long j16, int i3, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback) {
            native_fetchChannelUserPermission(this.nativeRef, j3, j16, i3, iGProChannelUserPermissionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelVisibleAllMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback) {
            native_fetchChannelVisibleAllMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelVisibleMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelVisibleMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback) {
            native_fetchChannelVisibleMemberList(this.nativeRef, j3, j16, i3, bArr, iGProFetchChannelVisibleMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelVisibleRoleList(long j3, long j16, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback) {
            native_fetchChannelVisibleRoleList(this.nativeRef, j3, j16, iGProFetchChannelVisibleRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchChannelVisibleRoleListWithoutLevelRole(long j3, long j16, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback) {
            native_fetchChannelVisibleRoleListWithoutLevelRole(this.nativeRef, j3, j16, iGProFetchChannelVisibleRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchComments(long j3, long j16, long j17, long j18, long j19, long j26, IGProFetchCommentsCallback iGProFetchCommentsCallback) {
            native_fetchComments(this.nativeRef, j3, j16, j17, j18, j19, j26, iGProFetchCommentsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchCurrentLiveRoomInfo(long j3, IGProFetchCurrentLiveRoomInfoCallback iGProFetchCurrentLiveRoomInfoCallback) {
            native_fetchCurrentLiveRoomInfo(this.nativeRef, j3, iGProFetchCurrentLiveRoomInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchDirectMsgBlack(long j3, IGProFetchDirectMsgBlackCallback iGProFetchDirectMsgBlackCallback) {
            native_fetchDirectMsgBlack(this.nativeRef, j3, iGProFetchDirectMsgBlackCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchDirectMsgStatus(IGProFetchDirectMsgStatusCallback iGProFetchDirectMsgStatusCallback) {
            native_fetchDirectMsgStatus(this.nativeRef, iGProFetchDirectMsgStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchEndPageMessage(long j3, IGProFetchEndPageMessageCallback iGProFetchEndPageMessageCallback) {
            native_fetchEndPageMessage(this.nativeRef, j3, iGProFetchEndPageMessageCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchFeedCommentsNotifySwitch(IGProGetFeedCommentsNotifySwitchCallback iGProGetFeedCommentsNotifySwitchCallback) {
            native_fetchFeedCommentsNotifySwitch(this.nativeRef, iGProGetFeedCommentsNotifySwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGlobalPrivacySwitch(IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback) {
            native_fetchGlobalPrivacySwitch(this.nativeRef, iGProGlobalPrivacySwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuestGuild(long j3, boolean z16, int i3, IGProFetchGuestGuildCallback iGProFetchGuestGuildCallback) {
            native_fetchGuestGuild(this.nativeRef, j3, z16, i3, iGProFetchGuestGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuestGuildInfoWithChannelList(int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback) {
            native_fetchGuestGuildInfoWithChannelList(this.nativeRef, i3, gProGetGuildAndChannelReq, iGProFetchGuestGuildInfoWithChannelListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildActiveLiveChannelNum(GProFetchGuildActiveLiveChannelNumReq gProFetchGuildActiveLiveChannelNumReq, IGProFetchGuildActiveLiveChannelNumCallback iGProFetchGuildActiveLiveChannelNumCallback) {
            native_fetchGuildActiveLiveChannelNum(this.nativeRef, gProFetchGuildActiveLiveChannelNumReq, iGProFetchGuildActiveLiveChannelNumCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildActiveValue(long j3, IGProGuildActiveValueCallback iGProGuildActiveValueCallback) {
            native_fetchGuildActiveValue(this.nativeRef, j3, iGProGuildActiveValueCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildBlackList(long j3, byte[] bArr, IGProFetchGuildBlackListCallback iGProFetchGuildBlackListCallback) {
            native_fetchGuildBlackList(this.nativeRef, j3, bArr, iGProFetchGuildBlackListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildBottomTabExp(GProBottomTabExpReq gProBottomTabExpReq, IGProFetchGuildBottomTabExpCallback iGProFetchGuildBottomTabExpCallback) {
            native_fetchGuildBottomTabExp(this.nativeRef, gProBottomTabExpReq, iGProFetchGuildBottomTabExpCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildBoundGroupsWithGroupCodes(long j3, ArrayList<Long> arrayList, IGProFetchGuildBoundGroupsWithGroupCodesCallback iGProFetchGuildBoundGroupsWithGroupCodesCallback) {
            native_fetchGuildBoundGroupsWithGroupCodes(this.nativeRef, j3, arrayList, iGProFetchGuildBoundGroupsWithGroupCodesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildInfo(long j3, int i3, IGProFetchGuildInfoCallback iGProFetchGuildInfoCallback) {
            native_fetchGuildInfo(this.nativeRef, j3, i3, iGProFetchGuildInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildInfoAndMemberList(GProGuildInfoAndMemberListReq gProGuildInfoAndMemberListReq, IGProFetchGuildInfoAndMemberListCallback iGProFetchGuildInfoAndMemberListCallback) {
            native_fetchGuildInfoAndMemberList(this.nativeRef, gProGuildInfoAndMemberListReq, iGProFetchGuildInfoAndMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildInfoByAppIdentity(GProGuildIdentity gProGuildIdentity, String str, String str2, IGProFetchGuildInfoByAppIdentityCallback iGProFetchGuildInfoByAppIdentityCallback) {
            native_fetchGuildInfoByAppIdentity(this.nativeRef, gProGuildIdentity, str, str2, iGProFetchGuildInfoByAppIdentityCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildSearchSwitch(long j3, IGProFetchGuildSearchSwitchCallback iGProFetchGuildSearchSwitchCallback) {
            native_fetchGuildSearchSwitch(this.nativeRef, j3, iGProFetchGuildSearchSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildSpeakableMemberList(long j3, boolean z16, int i3, byte[] bArr, IGProFetchGuildSpeakableMemberListCallback iGProFetchGuildSpeakableMemberListCallback) {
            native_fetchGuildSpeakableMemberList(this.nativeRef, j3, z16, i3, bArr, iGProFetchGuildSpeakableMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildSpeakableRoleList(long j3, boolean z16, IGProFetchGuildSpeakableRoleListCallback iGProFetchGuildSpeakableRoleListCallback) {
            native_fetchGuildSpeakableRoleList(this.nativeRef, j3, z16, iGProFetchGuildSpeakableRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildSpeakableRule(long j3, IGProFetchGuildSpeakableRuleCallback iGProFetchGuildSpeakableRuleCallback) {
            native_fetchGuildSpeakableRule(this.nativeRef, j3, iGProFetchGuildSpeakableRuleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildSpeakableThreshold(long j3, IGProFetchGuildSpeakableThresholdCallback iGProFetchGuildSpeakableThresholdCallback) {
            native_fetchGuildSpeakableThreshold(this.nativeRef, j3, iGProFetchGuildSpeakableThresholdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchGuildTaskCards(GProAllGuildTaskCardReq gProAllGuildTaskCardReq, IGProFetchGuildTaskCardsCallback iGProFetchGuildTaskCardsCallback) {
            native_fetchGuildTaskCards(this.nativeRef, gProAllGuildTaskCardReq, iGProFetchGuildTaskCardsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchHandUpMemberList(long j3, long j16, IGProFetchHandUpMemberListCallback iGProFetchHandUpMemberListCallback) {
            native_fetchHandUpMemberList(this.nativeRef, j3, j16, iGProFetchHandUpMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchInviteInfo(String str, IGProFetchInviteInfoCallback iGProFetchInviteInfoCallback) {
            native_fetchInviteInfo(this.nativeRef, str, iGProFetchInviteInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchInviteInfo0x10b4(String str, String str2, String str3, int i3, IGProFetchInviteInfo0x10b4Callback iGProFetchInviteInfo0x10b4Callback) {
            native_fetchInviteInfo0x10b4(this.nativeRef, str, str2, str3, i3, iGProFetchInviteInfo0x10b4Callback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchIsLiveChannelOpen(long j3, IGProFetchIsLiveChannelOpenCallback iGProFetchIsLiveChannelOpenCallback) {
            native_fetchIsLiveChannelOpen(this.nativeRef, j3, iGProFetchIsLiveChannelOpenCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchIsStartBroadcastVisible(long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_fetchIsStartBroadcastVisible(this.nativeRef, j3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchIsVoiceChannelOpen(long j3, IGProFetchIsVoiceChannelOpenCallback iGProFetchIsVoiceChannelOpenCallback) {
            native_fetchIsVoiceChannelOpen(this.nativeRef, j3, iGProFetchIsVoiceChannelOpenCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchJoinGuildOption(GProFetchJoinGuildOptionReq gProFetchJoinGuildOptionReq, IGProFetchJoinGuildOptionCallback iGProFetchJoinGuildOptionCallback) {
            native_fetchJoinGuildOption(this.nativeRef, gProFetchJoinGuildOptionReq, iGProFetchJoinGuildOptionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchJubaoMsgResId(long j3, long j16, long j17, IGProFetchJubaoMsgResIdCallback iGProFetchJubaoMsgResIdCallback) {
            native_fetchJubaoMsgResId(this.nativeRef, j3, j16, j17, iGProFetchJubaoMsgResIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchJubaoMsgsResId(long j3, long j16, ArrayList<Long> arrayList, IGProFetchJubaoMsgsResIdCallback iGProFetchJubaoMsgsResIdCallback) {
            native_fetchJubaoMsgsResId(this.nativeRef, j3, j16, arrayList, iGProFetchJubaoMsgsResIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchJumpInfo(long j3, IGProFetchJumpInfoCallback iGProFetchJumpInfoCallback) {
            native_fetchJumpInfo(this.nativeRef, j3, iGProFetchJumpInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchLatestComments(long j3, long j16, long j17, long j18, IGProFetchCommentsCallback iGProFetchCommentsCallback) {
            native_fetchLatestComments(this.nativeRef, j3, j16, j17, j18, iGProFetchCommentsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchLevelRolePermissions(long j3, int i3, IGProFetchLevelRoleListCallback iGProFetchLevelRoleListCallback) {
            native_fetchLevelRolePermissions(this.nativeRef, j3, i3, iGProFetchLevelRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchLiveChannelAnchorList(long j3, long j16, IGProFetchLiveChannelAnchorListCallback iGProFetchLiveChannelAnchorListCallback) {
            native_fetchLiveChannelAnchorList(this.nativeRef, j3, j16, iGProFetchLiveChannelAnchorListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchLiveChannelBannedUserList(long j3, long j16, long j17, IGProFetchBannedUserListCallback iGProFetchBannedUserListCallback) {
            native_fetchLiveChannelBannedUserList(this.nativeRef, j3, j16, j17, iGProFetchBannedUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchLiveRoomInfo(GProLiveRoomInfoReq gProLiveRoomInfoReq, IGProFetchLiveChannelInfoListCallback iGProFetchLiveChannelInfoListCallback) {
            native_fetchLiveRoomInfo(this.nativeRef, gProLiveRoomInfoReq, iGProFetchLiveChannelInfoListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchLiveSecurityTips(IGProFetchLiveSecurityTipsCallback iGProFetchLiveSecurityTipsCallback) {
            native_fetchLiveSecurityTips(this.nativeRef, iGProFetchLiveSecurityTipsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchMVPFeedsFromServer(GProGetContentRecommendReq gProGetContentRecommendReq, IGProFetchMVPFeedsDataCallback iGProFetchMVPFeedsDataCallback) {
            native_fetchMVPFeedsFromServer(this.nativeRef, gProGetContentRecommendReq, iGProFetchMVPFeedsDataCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchMemberListForFeed(GProFeedMemberListReq gProFeedMemberListReq, IGProFetchMemberListCallback iGProFetchMemberListCallback) {
            native_fetchMemberListForFeed(this.nativeRef, gProFeedMemberListReq, iGProFetchMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchMemberListWithRole(long j3, long j16, long j17, long j18, int i3, int i16, IGProFetchMemberListWithRoleCallback iGProFetchMemberListWithRoleCallback) {
            native_fetchMemberListWithRole(this.nativeRef, j3, j16, j17, j18, i3, i16, iGProFetchMemberListWithRoleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchMemberListWithRoleCookie(long j3, long j16, long j17, long j18, int i3, String str, int i16, IGProFetchMemberListWithRoleCookieCallback iGProFetchMemberListWithRoleCookieCallback) {
            native_fetchMemberListWithRoleCookie(this.nativeRef, j3, j16, j17, j18, i3, str, i16, iGProFetchMemberListWithRoleCookieCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchMemberRoles(long j3, long j16, long j17, int i3, IGProFetchMemberRolesCallback iGProFetchMemberRolesCallback) {
            native_fetchMemberRoles(this.nativeRef, j3, j16, j17, i3, iGProFetchMemberRolesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchMyCreateGuilds(IGProFetchMyCreateGuildsCallback iGProFetchMyCreateGuildsCallback) {
            native_fetchMyCreateGuilds(this.nativeRef, iGProFetchMyCreateGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchNewestNotice(int i3, long j3, IGProFetchNewestNoticeCallback iGProFetchNewestNoticeCallback) {
            native_fetchNewestNotice(this.nativeRef, i3, j3, iGProFetchNewestNoticeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchNonRoleMembers(long j3, long j16, long j17, long j18, long j19, int i3, int i16, IGProFetchNonRoleMembersCallback iGProFetchNonRoleMembersCallback) {
            native_fetchNonRoleMembers(this.nativeRef, j3, j16, j17, j18, j19, i3, i16, iGProFetchNonRoleMembersCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchOnlineUsers(long j3, int i3, int i16, ArrayList<Long> arrayList, IGProFetchOnlineUsersCallback iGProFetchOnlineUsersCallback) {
            native_fetchOnlineUsers(this.nativeRef, j3, i3, i16, arrayList, iGProFetchOnlineUsersCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchOtherChannelUserPermission(long j3, long j16, long j17, int i3, int i16, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback) {
            native_fetchOtherChannelUserPermission(this.nativeRef, j3, j16, j17, i3, i16, iGProChannelUserPermissionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchProfileAddFriendField(long j3, long j16, IGProFetchProfileAddFriendFieldCallback iGProFetchProfileAddFriendFieldCallback) {
            native_fetchProfileAddFriendField(this.nativeRef, j3, j16, iGProFetchProfileAddFriendFieldCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchPskey(ArrayList<String> arrayList, IGProFetchPskeyCallback iGProFetchPskeyCallback) {
            native_fetchPskey(this.nativeRef, arrayList, iGProFetchPskeyCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRecommendChannel(int i3, int i16, IGProFetchRecommendChannelCallback iGProFetchRecommendChannelCallback) {
            native_fetchRecommendChannel(this.nativeRef, i3, i16, iGProFetchRecommendChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRecommendEssenceInfo(long j3, int i3, IGProFetchRecommendEssenceInfoCallback iGProFetchRecommendEssenceInfoCallback) {
            native_fetchRecommendEssenceInfo(this.nativeRef, j3, i3, iGProFetchRecommendEssenceInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRemainAtSetInfo(long j3, IGProFetchAtSetInfoCallback iGProFetchAtSetInfoCallback) {
            native_fetchRemainAtSetInfo(this.nativeRef, j3, iGProFetchAtSetInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRetentionGuildList(int i3, int i16, byte[] bArr, long j3, IGProFetchRetentionGuildListCallback iGProFetchRetentionGuildListCallback) {
            native_fetchRetentionGuildList(this.nativeRef, i3, i16, bArr, j3, iGProFetchRetentionGuildListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRole(long j3, long j16, int i3, boolean z16, IGProFetchRoleCallback iGProFetchRoleCallback) {
            native_fetchRole(this.nativeRef, j3, j16, i3, z16, iGProFetchRoleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRoleListWithFilter(long j3, int i3, int i16, IGProFetchRoleListCallback iGProFetchRoleListCallback) {
            native_fetchRoleListWithFilter(this.nativeRef, j3, i3, i16, iGProFetchRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRoleListWithPermission(long j3, int i3, IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback) {
            native_fetchRoleListWithPermission(this.nativeRef, j3, i3, iGProFetchRoleListPermissionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRoleListWithoutLevelRoleWithFilter(long j3, int i3, int i16, IGProFetchRoleListWithoutLevelRoleCallback iGProFetchRoleListWithoutLevelRoleCallback) {
            native_fetchRoleListWithoutLevelRoleWithFilter(this.nativeRef, j3, i3, i16, iGProFetchRoleListWithoutLevelRoleCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRoleMembers(long j3, long j16, long j17, long j18, long j19, int i3, IGProFetchRoleMembersCallback iGProFetchRoleMembersCallback) {
            native_fetchRoleMembers(this.nativeRef, j3, j16, j17, j18, j19, i3, iGProFetchRoleMembersCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchRoleWithPermission(long j3, long j16, int i3, IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback) {
            native_fetchRoleWithPermission(this.nativeRef, j3, j16, i3, iGProFetchRolePermissionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchShareButtonReq(ArrayList<Long> arrayList, boolean z16, IGProCommonCallback iGProCommonCallback) {
            native_fetchShareButtonReq(this.nativeRef, arrayList, z16, iGProCommonCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchShareInfo0x10c3(long j3, long j16, GProFetchShareInfo0x10c3Req gProFetchShareInfo0x10c3Req, IGProFetchShareInfo0x10c3Callback iGProFetchShareInfo0x10c3Callback) {
            native_fetchShareInfo0x10c3(this.nativeRef, j3, j16, gProFetchShareInfo0x10c3Req, iGProFetchShareInfo0x10c3Callback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchShareUrlReq(long j3, long j16, long j17, String str, GProFetchShareUrlFilter gProFetchShareUrlFilter, ArrayList<GProURLParam> arrayList, IGProFetchShareUrlCallback iGProFetchShareUrlCallback) {
            native_fetchShareUrlReq(this.nativeRef, j3, j16, j17, str, gProFetchShareUrlFilter, arrayList, iGProFetchShareUrlCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchSpecifiedTypeChannelOpenState(long j3, long j16, IGProFetchSpecifiedTypeChannelOpenStateCallback iGProFetchSpecifiedTypeChannelOpenStateCallback) {
            native_fetchSpecifiedTypeChannelOpenState(this.nativeRef, j3, j16, iGProFetchSpecifiedTypeChannelOpenStateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchSpecifiedTypeChannelsOpenState(long j3, ArrayList<Integer> arrayList, int i3, IGProFetchSpecifiedTypeChannelsOpenStateCallback iGProFetchSpecifiedTypeChannelsOpenStateCallback) {
            native_fetchSpecifiedTypeChannelsOpenState(this.nativeRef, j3, arrayList, i3, iGProFetchSpecifiedTypeChannelsOpenStateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchSubscribeUserGuide(IGProFetchSubscribeUserGuideCallback iGProFetchSubscribeUserGuideCallback) {
            native_fetchSubscribeUserGuide(this.nativeRef, iGProFetchSubscribeUserGuideCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchUserInfo(long j3, long j16, ArrayList<Long> arrayList, int i3, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
            native_fetchUserInfo(this.nativeRef, j3, j16, arrayList, i3, iGProGetUserInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchUserJoinedGuildListV2(GProFetchUserJoinedGuildListReq gProFetchUserJoinedGuildListReq, IGProFetchUserJoinedGuildListCallbackV2 iGProFetchUserJoinedGuildListCallbackV2) {
            native_fetchUserJoinedGuildListV2(this.nativeRef, gProFetchUserJoinedGuildListReq, iGProFetchUserJoinedGuildListCallbackV2);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchUserList(long j3, long j16, int i3, IGProGetUserListCallback iGProGetUserListCallback) {
            native_fetchUserList(this.nativeRef, j3, j16, i3, iGProGetUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchVersionNews(IGProFetchVersionNewsCallback iGProFetchVersionNewsCallback) {
            native_fetchVersionNews(this.nativeRef, iGProFetchVersionNewsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchVisibleMemberListByTinyId(long j3, long j16, ArrayList<Long> arrayList, int i3, IGProFetchVisibleMemberListByTinyIdCallback iGProFetchVisibleMemberListByTinyIdCallback) {
            native_fetchVisibleMemberListByTinyId(this.nativeRef, j3, j16, arrayList, i3, iGProFetchVisibleMemberListByTinyIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void fetchXWordInfo(long j3, IGproXWorldInfoCallback iGproXWorldInfoCallback) {
            native_fetchXWordInfo(this.nativeRef, j3, iGproXWorldInfoCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAISearchRecommendWords(IGProGetAISearchRecommendWordsCallback iGProGetAISearchRecommendWordsCallback) {
            native_getAISearchRecommendWords(this.nativeRef, iGProGetAISearchRecommendWordsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAISearchSessionList(GProAISearchGetSessionListReq gProAISearchGetSessionListReq, boolean z16, IGProGetAISearchSessionListCallback iGProGetAISearchSessionListCallback) {
            native_getAISearchSessionList(this.nativeRef, gProAISearchGetSessionListReq, z16, iGProGetAISearchSessionListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAISearchSessionMsgList(GProAISearchGetSessionMsgListReq gProAISearchGetSessionMsgListReq, boolean z16, IGProGetAISearchSessionMsgListCallback iGProGetAISearchSessionMsgListCallback) {
            native_getAISearchSessionMsgList(this.nativeRef, gProAISearchGetSessionMsgListReq, z16, iGProGetAISearchSessionMsgListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAISearchShareURL(GProGetAISearchShareURLReq gProGetAISearchShareURLReq, IGProGetAISearchShareURLCallback iGProGetAISearchShareURLCallback) {
            native_getAISearchShareURL(this.nativeRef, gProGetAISearchShareURLReq, iGProGetAISearchShareURLCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, Integer> getAVChannelUserCnts(long j3) {
            return native_getAVChannelUserCnts(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getActiveLiveAudioChannelNum(long j3, IGProGetActiveLiveAudioChannelNumCallback iGProGetActiveLiveAudioChannelNumCallback) {
            native_getActiveLiveAudioChannelNum(this.nativeRef, j3, iGProGetActiveLiveAudioChannelNumCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getActiveLiveAudioChannelNumV2(GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetActiveLiveAudioChannelNumV2Callback iGProGetActiveLiveAudioChannelNumV2Callback) {
            native_getActiveLiveAudioChannelNumV2(this.nativeRef, gProGetLiveAudioPollingInfoReq, iGProGetActiveLiveAudioChannelNumV2Callback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAllGuildSearchAIInfo(GProGuildSearchGetAllGuildAIInfoReq gProGuildSearchGetAllGuildAIInfoReq, IGProGetAllGuildSearchAIInfoCallback iGProGetAllGuildSearchAIInfoCallback) {
            native_getAllGuildSearchAIInfo(this.nativeRef, gProGuildSearchGetAllGuildAIInfoReq, iGProGetAllGuildSearchAIInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGuildUserState getAlreadyEnteredChannel() {
            return native_getAlreadyEnteredChannel(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAppAuthorizationInfo(int i3, int i16, IGProGetAppAuthorizationInfoCallback iGProGetAppAuthorizationInfoCallback) {
            native_getAppAuthorizationInfo(this.nativeRef, i3, i16, iGProGetAppAuthorizationInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProAppChnnPreInfo getAppChannelPreInfo(long j3, long j16) {
            return native_getAppChannelPreInfo(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProAppChnnPreInfo> getAppChannelPreInfos(long j3) {
            return native_getAppChannelPreInfos(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProAppInfo> getAppInfos() {
            return native_getAppInfos(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAppRoleList(int i3, String str, byte[] bArr, IGProGetAppRoleListCallback iGProGetAppRoleListCallback) {
            native_getAppRoleList(this.nativeRef, i3, str, bArr, iGProGetAppRoleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAssociativeWords(String str, IGProAssociativeWordsCallback iGProAssociativeWordsCallback) {
            native_getAssociativeWords(this.nativeRef, str, iGProAssociativeWordsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getAtMemberList(String str, String str2, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
            native_getAtMemberList(this.nativeRef, str, str2, iGProGetUserInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getBanners(GProGetBannersReq gProGetBannersReq, IGProGetBannersCallback iGProGetBannersCallback) {
            native_getBanners(this.nativeRef, gProGetBannersReq, iGProGetBannersCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getBindClientService(int i3, int i16, byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback) {
            native_getBindClientService(this.nativeRef, i3, i16, bArr, iGProGetClientAccountCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getBindingGroupInfos(ArrayList<Long> arrayList, IGProGetBindingGroupInfosCallback iGProGetBindingGroupInfosCallback) {
            native_getBindingGroupInfos(this.nativeRef, arrayList, iGProGetBindingGroupInfosCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getBlockRecGuilds(GProGetBlockRecGuildsReq gProGetBlockRecGuildsReq, IGProGetBlockRecGuildsCallback iGProGetBlockRecGuildsCallback) {
            native_getBlockRecGuilds(this.nativeRef, gProGetBlockRecGuildsReq, iGProGetBlockRecGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProCategoryChannelIdList> getCategoryChannelIdList(long j3) {
            return native_getCategoryChannelIdList(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProCategoryChannelIdList> getCategoryChannelIdListExcludeCategoryType(long j3, ArrayList<Integer> arrayList) {
            return native_getCategoryChannelIdListExcludeCategoryType(this.nativeRef, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProCategoryChannelInfoList> getCategoryChannelInfoList(long j3) {
            return native_getCategoryChannelInfoList(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProCategoryChannelInfoList> getCategoryChannelInfoListByCategoryType(long j3, ArrayList<Integer> arrayList) {
            return native_getCategoryChannelInfoListByCategoryType(this.nativeRef, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getCategoryChannelInfoListByFilter(GProGetCategoryChannelInfoListByFilterReq gProGetCategoryChannelInfoListByFilterReq, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback) {
            native_getCategoryChannelInfoListByFilter(this.nativeRef, gProGetCategoryChannelInfoListByFilterReq, iGProGetCategoryChannelInfoListV2Callback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getCategoryChannelInfoListV2(GProGetCategoryChannelInfoListV2Req gProGetCategoryChannelInfoListV2Req, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback) {
            native_getCategoryChannelInfoListV2(this.nativeRef, gProGetCategoryChannelInfoListV2Req, iGProGetCategoryChannelInfoListV2Callback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getCategoryGuilds(GProGetCategoryGuildsReq gProGetCategoryGuildsReq, IGProGetCategoryGuildsCallback iGProGetCategoryGuildsCallback) {
            native_getCategoryGuilds(this.nativeRef, gProGetCategoryGuildsReq, iGProGetCategoryGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getCategoryPageGuilds(GProGetCategoryPageGuildsReq gProGetCategoryPageGuildsReq, IGProGetCategoryPageGuildsCallback iGProGetCategoryPageGuildsCallback) {
            native_getCategoryPageGuilds(this.nativeRef, gProGetCategoryPageGuildsReq, iGProGetCategoryPageGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Integer> getCategoryPermission(long j3, long j16) {
            return native_getCategoryPermission(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getCategoryTabContent(GProGetCategoryTabContentReq gProGetCategoryTabContentReq, IGProGetCategoryTabContentCallback iGProGetCategoryTabContentCallback) {
            native_getCategoryTabContent(this.nativeRef, gProGetCategoryTabContentReq, iGProGetCategoryTabContentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getChannelActivity(GProGetChannelActivityReq gProGetChannelActivityReq, IGProGetChannelActivityCallback iGProGetChannelActivityCallback) {
            native_getChannelActivity(this.nativeRef, gProGetChannelActivityReq, iGProGetChannelActivityCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getChannelHeartbeat(long j3, long j16, IGProGetChannelHeartbeatCallback iGProGetChannelHeartbeatCallback) {
            native_getChannelHeartbeat(this.nativeRef, j3, j16, iGProGetChannelHeartbeatCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, ArrayList<Long>> getChannelIdsWithGuildIdsFromCache(GProGetChannelIdsWithGuildIdsFromCacheReq gProGetChannelIdsWithGuildIdsFromCacheReq) {
            return native_getChannelIdsWithGuildIdsFromCache(this.nativeRef, gProGetChannelIdsWithGuildIdsFromCacheReq);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProChannel getChannelInfo(long j3) {
            return native_getChannelInfo(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Integer> getChannelPermission(long j3, long j16) {
            return native_getChannelPermission(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getChannelTopMsgFlashState(long j3, long j16, long j17, IGProGetChannelTopMsgFlashStateCallback iGProGetChannelTopMsgFlashStateCallback) {
            native_getChannelTopMsgFlashState(this.nativeRef, j3, j16, j17, iGProGetChannelTopMsgFlashStateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getChannelTopMsgState(long j3, long j16, IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback) {
            native_getChannelTopMsgState(this.nativeRef, j3, j16, iGProGetChannelTopMsgStateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public int getChannelUserPermission(long j3, long j16) {
            return native_getChannelUserPermission(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getClientInfoList(int i3, byte[] bArr, IGProGetClientInfoListCallback iGProGetClientInfoListCallback) {
            native_getClientInfoList(this.nativeRef, i3, bArr, iGProGetClientInfoListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getConfigTabContent(GProGetConfigTabContentReq gProGetConfigTabContentReq, IGProGetConfigTabContentCallback iGProGetConfigTabContentCallback) {
            native_getConfigTabContent(this.nativeRef, gProGetConfigTabContentReq, iGProGetConfigTabContentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getCurrPlaySong(long j3, long j16, IGProGetCurrPlaySongCallback iGProGetCurrPlaySongCallback) {
            native_getCurrPlaySong(this.nativeRef, j3, j16, iGProGetCurrPlaySongCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getDiscoverAudioVideoInfos(GProDiscoverAudioVideoInfosReq gProDiscoverAudioVideoInfosReq, IGProGetDiscoverAudioVideoInfosCallback iGProGetDiscoverAudioVideoInfosCallback) {
            native_getDiscoverAudioVideoInfos(this.nativeRef, gProDiscoverAudioVideoInfosReq, iGProGetDiscoverAudioVideoInfosCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Long> getEffectGuildIdsFromCache() {
            return native_getEffectGuildIdsFromCache(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProFaceAuthInfo getFaceAuthInfo() {
            return native_getFaceAuthInfo(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getFriendsInGuild(GProGetGuildFriendsReq gProGetGuildFriendsReq, IGProGetFriendsInGuildCallback iGProGetFriendsInGuildCallback) {
            native_getFriendsInGuild(this.nativeRef, gProGetGuildFriendsReq, iGProGetFriendsInGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getFriendsRecommend(GProGetFriendsRecommendReq gProGetFriendsRecommendReq, IGProGetFriendsRecommendCallback iGProGetFriendsRecommendCallback) {
            native_getFriendsRecommend(this.nativeRef, gProGetFriendsRecommendReq, iGProGetFriendsRecommendCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProGuild> getGroupGuildListFromCache() {
            return native_getGroupGuildListFromCache(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuidePageInfo(long j3, String str, IGProGetGuidePageInfoCallback iGProGetGuidePageInfoCallback) {
            native_getGuidePageInfo(this.nativeRef, j3, str, iGProGetGuidePageInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildAndChannelListFromCache(IGProLoadGuildAndChnListCallback iGProLoadGuildAndChnListCallback) {
            native_getGuildAndChannelListFromCache(this.nativeRef, iGProLoadGuildAndChnListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildBindableGroups(IGProGetGuildBindableGroupsCallback iGProGetGuildBindableGroupsCallback) {
            native_getGuildBindableGroups(this.nativeRef, iGProGetGuildBindableGroupsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildBindingInfo(long j3, IGProGetGuildBindingInfoCallback iGProGetGuildBindingInfoCallback) {
            native_getGuildBindingInfo(this.nativeRef, j3, iGProGetGuildBindingInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildBoundGroupsFirstPage(long j3, int i3, IGProGetGuildBoundGroupsFirstPageCallback iGProGetGuildBoundGroupsFirstPageCallback) {
            native_getGuildBoundGroupsFirstPage(this.nativeRef, j3, i3, iGProGetGuildBoundGroupsFirstPageCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildCheckinInfo(GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback) {
            native_getGuildCheckinInfo(this.nativeRef, gProGuildCheckinReq, iGProGuildCheckinCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildCreatorTasks(long j3, boolean z16, IGProGetGuildCreatorTasksCallback iGProGetGuildCreatorTasksCallback) {
            native_getGuildCreatorTasks(this.nativeRef, j3, z16, iGProGetGuildCreatorTasksCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildFeedsValidCalendar(GProGuildSearchGetFeedCalendarReq gProGuildSearchGetFeedCalendarReq, IGProGuildGetFeedValidCalendarCallback iGProGuildGetFeedValidCalendarCallback) {
            native_getGuildFeedsValidCalendar(this.nativeRef, gProGuildSearchGetFeedCalendarReq, iGProGuildGetFeedValidCalendarCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGlobalBanner getGuildGlobalBanner(long j3) {
            return native_getGuildGlobalBanner(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildHomeCategories(GProGetGuildHomeCategoriesReq gProGetGuildHomeCategoriesReq, IGProGetGuildHomeCategoriesCallback iGProGetGuildHomeCategoriesCallback) {
            native_getGuildHomeCategories(this.nativeRef, gProGetGuildHomeCategoriesReq, iGProGetGuildHomeCategoriesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildHomeSections(long j3, IGProGetGuildHomeSectionsCallback iGProGetGuildHomeSectionsCallback) {
            native_getGuildHomeSections(this.nativeRef, j3, iGProGetGuildHomeSectionsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGuild getGuildInfoFromCache(long j3) {
            return native_getGuildInfoFromCache(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildLableInfo(GProGetGuildLabelReq gProGetGuildLabelReq, IGProGetGuildLableInfoCallback iGProGetGuildLableInfoCallback) {
            native_getGuildLableInfo(this.nativeRef, gProGetGuildLabelReq, iGProGetGuildLableInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProGuild> getGuildListFromCache() {
            return native_getGuildListFromCache(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildMainFrameHeaderInfo(long j3, IGProGetGuildMainFrameHeaderCallback iGProGetGuildMainFrameHeaderCallback) {
            native_getGuildMainFrameHeaderInfo(this.nativeRef, j3, iGProGetGuildMainFrameHeaderCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildMemberNum(long j3, IGProGetGuildMemberNumCallback iGProGetGuildMemberNumCallback) {
            native_getGuildMemberNum(this.nativeRef, j3, iGProGetGuildMemberNumCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildNum(long j3, IGProGetGuildNumCallback iGProGetGuildNumCallback) {
            native_getGuildNum(this.nativeRef, j3, iGProGetGuildNumCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Integer> getGuildPermission(long j3) {
            return native_getGuildPermission(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildRecommend(byte[] bArr, int i3, IGProGetRecommendCallback iGProGetRecommendCallback) {
            native_getGuildRecommend(this.nativeRef, bArr, i3, iGProGetRecommendCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public long getGuildRoleLimit(long j3) {
            return native_getGuildRoleLimit(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildShowWeakNotify(long j3, IGProGetGuildShowWeakNotifyCallback iGProGetGuildShowWeakNotifyCallback) {
            native_getGuildShowWeakNotify(this.nativeRef, j3, iGProGetGuildShowWeakNotifyCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProSpeakPermissionInfo getGuildSpeakPermission(long j3, int i3) {
            return native_getGuildSpeakPermission(this.nativeRef, j3, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public String getGuildUserAvatarPendantUrl(long j3) {
            return native_getGuildUserAvatarPendantUrl(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, String> getGuildUserAvatarPendantUrls(ArrayList<Long> arrayList) {
            return native_getGuildUserAvatarPendantUrls(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public String getGuildUserAvatarUrl(long j3, long j16, int i3) {
            return native_getGuildUserAvatarUrl(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, String> getGuildUserAvatarUrls(long j3, ArrayList<Long> arrayList, int i3) {
            return native_getGuildUserAvatarUrls(this.nativeRef, j3, arrayList, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Long> getGuildUserChannelCategoryAdminList(long j3, long j16) {
            return native_getGuildUserChannelCategoryAdminList(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, ArrayList<Long>> getGuildUserChannelCategoryAdminLists(long j3, ArrayList<Long> arrayList) {
            return native_getGuildUserChannelCategoryAdminLists(this.nativeRef, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, GProClientIdentity> getGuildUserClientIdentities(long j3, ArrayList<Long> arrayList) {
            return native_getGuildUserClientIdentities(this.nativeRef, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProClientIdentity getGuildUserClientIdentity(long j3, long j16) {
            return native_getGuildUserClientIdentity(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public String getGuildUserDisplayName(long j3, long j16) {
            return native_getGuildUserDisplayName(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, String> getGuildUserDisplayNames(long j3, ArrayList<Long> arrayList) {
            return native_getGuildUserDisplayNames(this.nativeRef, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public int getGuildUserLevelRoleId(long j3, long j16) {
            return native_getGuildUserLevelRoleId(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProMedal getGuildUserMedal(long j3) {
            return native_getGuildUserMedal(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, GProMedal> getGuildUserMedals(ArrayList<Long> arrayList) {
            return native_getGuildUserMedals(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public String getGuildUserMemberName(long j3, long j16) {
            return native_getGuildUserMemberName(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, String> getGuildUserMemberNames(long j3, ArrayList<Long> arrayList) {
            return native_getGuildUserMemberNames(this.nativeRef, j3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public String getGuildUserNickname(long j3) {
            return native_getGuildUserNickname(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public HashMap<Long, String> getGuildUserNicknames(ArrayList<Long> arrayList) {
            return native_getGuildUserNicknames(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public long getGuildUserTopRoleId(long j3, long j16) {
            return native_getGuildUserTopRoleId(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildVerifyShareInfo(GProVerifyShareInfoReq gProVerifyShareInfoReq, IGuildVerifyShareInfoCallback iGuildVerifyShareInfoCallback) {
            native_getGuildVerifyShareInfo(this.nativeRef, gProVerifyShareInfoReq, iGuildVerifyShareInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getGuildsInContact(IGProGetGuildsInContactCallback iGProGetGuildsInContactCallback) {
            native_getGuildsInContact(this.nativeRef, iGProGetGuildsInContactCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getHotLive(GProGetHotLiveReq gProGetHotLiveReq, IGProGetHotLiveCallback iGProGetHotLiveCallback) {
            native_getHotLive(this.nativeRef, gProGetHotLiveReq, iGProGetHotLiveCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getHotSearchWords(ArrayList<Integer> arrayList, int i3, IGProGetHotSearchWordsCallback iGProGetHotSearchWordsCallback) {
            native_getHotSearchWords(this.nativeRef, arrayList, i3, iGProGetHotSearchWordsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProJumpToCategoryInfo getJumpToCategory(long j3) {
            return native_getJumpToCategory(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getLabelGuilds(GetLabelGuildsReq getLabelGuildsReq, IGProGetLabelGuildsCallback iGProGetLabelGuildsCallback) {
            native_getLabelGuilds(this.nativeRef, getLabelGuildsReq, iGProGetLabelGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getLiveAudioPollingCtx(long j3, long j16, IGProGetLiveAudioPollingCtxCallback iGProGetLiveAudioPollingCtxCallback) {
            native_getLiveAudioPollingCtx(this.nativeRef, j3, j16, iGProGetLiveAudioPollingCtxCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getLiveAudioPollingCtxV2(GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetLiveAudioPollingCtxV2Callback iGProGetLiveAudioPollingCtxV2Callback) {
            native_getLiveAudioPollingCtxV2(this.nativeRef, gProGetLiveAudioPollingInfoReq, iGProGetLiveAudioPollingCtxV2Callback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGuildRole getMemberLevelRoleInfo(long j3, long j16, long j17) {
            return native_getMemberLevelRoleInfo(this.nativeRef, j3, j16, j17);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGuildRole getMemberTopRoleInfo(long j3, long j16, long j17, long j18, int i3) {
            return native_getMemberTopRoleInfo(this.nativeRef, j3, j16, j17, j18, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProCategoryChannelInfoList getMiniCategoryInfoFromCache(long j3, long j16) {
            return native_getMiniCategoryInfoFromCache(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getMoreNoticeList(int i3, long j3, int i16, IGProGetMoreNoticeListCallback iGProGetMoreNoticeListCallback) {
            native_getMoreNoticeList(this.nativeRef, i3, j3, i16, iGProGetMoreNoticeListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getMsgNotifyMap(long j3, IGProGetMsgNotifyTypeCallback iGProGetMsgNotifyTypeCallback) {
            native_getMsgNotifyMap(this.nativeRef, j3, iGProGetMsgNotifyTypeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getMyTabContent(GProGetMyTabContentReq gProGetMyTabContentReq, IGProGetMyTabContentCallback iGProGetMyTabContentCallback) {
            native_getMyTabContent(this.nativeRef, gProGetMyTabContentReq, iGProGetMyTabContentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getNavigation(GProGetNavigationReq gProGetNavigationReq, IGProGetNavigationCallback iGProGetNavigationCallback) {
            native_getNavigation(this.nativeRef, gProGetNavigationReq, iGProGetNavigationCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getNavigationStatus(GProGetNavigationStatusReq gProGetNavigationStatusReq, IGProGetNavigationStatusCallback iGProGetNavigationStatusCallback) {
            native_getNavigationStatus(this.nativeRef, gProGetNavigationStatusReq, iGProGetNavigationStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProOnlineMemberInfo getOnlineMemberInfo(long j3) {
            return native_getOnlineMemberInfo(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getOpenShareInfo(GproGetOpenShareInfoReq gproGetOpenShareInfoReq, IGProGetOpenShareInfoCallback iGProGetOpenShareInfoCallback) {
            native_getOpenShareInfo(this.nativeRef, gproGetOpenShareInfoReq, iGProGetOpenShareInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public int getPermissionChangeFilter(long j3, long j16) {
            return native_getPermissionChangeFilter(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProPersonalSignatureTemplate> getPersonalSignatureTemplate() {
            return native_getPersonalSignatureTemplate(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProPollingChannelState getPollingCtx(long j3, long j16, int i3) {
            return native_getPollingCtx(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getPopupInfo(long j3, int i3, IGProGetPopupInfoCallback iGProGetPopupInfoCallback) {
            native_getPopupInfo(this.nativeRef, j3, i3, iGProGetPopupInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getPreviewNavigation(GProGetPreviewNavigationReq gProGetPreviewNavigationReq, IGProGetPreviewNavigationCallback iGProGetPreviewNavigationCallback) {
            native_getPreviewNavigation(this.nativeRef, gProGetPreviewNavigationReq, iGProGetPreviewNavigationCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getProfileSwitch(IGProGetProfileSwitchCallback iGProGetProfileSwitchCallback) {
            native_getProfileSwitch(this.nativeRef, iGProGetProfileSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProQQMsgListChannel getQQMsgListChannel(long j3, long j16) {
            return native_getQQMsgListChannel(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProQQMsgListChannel> getQQMsgListChannels() {
            return native_getQQMsgListChannels(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProQQMsgListGuild> getQQMsgListGuilds() {
            return native_getQQMsgListGuilds(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProRecentVisitChannelList getRecentVisitChannelList(long j3) {
            return native_getRecentVisitChannelList(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGetRecentVisitGuildInfosFromCacheRsp getRecentVisitGuildInfosListSync(int i3, int i16) {
            return native_getRecentVisitGuildInfosListSync(this.nativeRef, i3, i16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRecommendForIntro(GetRecommendForIntroReq getRecommendForIntroReq, IGProGetRecommendForIntroCallback iGProGetRecommendForIntroCallback) {
            native_getRecommendForIntro(this.nativeRef, getRecommendForIntroReq, iGProGetRecommendForIntroCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRecommendGuildInfoFromCacheAsync(IGProGetRecommendGuildInfoCallback iGProGetRecommendGuildInfoCallback) {
            native_getRecommendGuildInfoFromCacheAsync(this.nativeRef, iGProGetRecommendGuildInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRecommendQuickJoin(GProGetRecommendQuickJoinReq gProGetRecommendQuickJoinReq, IGProGetRecommendQuickJoinCallback iGProGetRecommendQuickJoinCallback) {
            native_getRecommendQuickJoin(this.nativeRef, gProGetRecommendQuickJoinReq, iGProGetRecommendQuickJoinCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRecommendTabContent(GProGetRecommendTabContentReq gProGetRecommendTabContentReq, IGProGetRecommendTabContentCallback iGProGetRecommendTabContentCallback) {
            native_getRecommendTabContent(this.nativeRef, gProGetRecommendTabContentReq, iGProGetRecommendTabContentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRecommendTagList(GProGetRecommendTagListReq gProGetRecommendTagListReq, IGProGetRecommendTagListCallback iGProGetRecommendTagListCallback) {
            native_getRecommendTagList(this.nativeRef, gProGetRecommendTagListReq, iGProGetRecommendTagListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRiskMemberRedPoint(GProGetRiskMemberRedPointReq gProGetRiskMemberRedPointReq, IGProGetRiskMemberRedPointCallback iGProGetRiskMemberRedPointCallback) {
            native_getRiskMemberRedPoint(this.nativeRef, gProGetRiskMemberRedPointReq, iGProGetRiskMemberRedPointCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProGuildRole getRoleInfo(long j3, long j16) {
            return native_getRoleInfo(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Integer> getRolePermission(long j3, long j16) {
            return native_getRolePermission(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getRtmpPushUrl(IGProGetRtmpPushUrlCallback iGProGetRtmpPushUrlCallback) {
            native_getRtmpPushUrl(this.nativeRef, iGProGetRtmpPushUrlCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getScheduleDetail(long j3, long j16, long j17, IGProGetScheduleDetailCallback iGProGetScheduleDetailCallback) {
            native_getScheduleDetail(this.nativeRef, j3, j16, j17, iGProGetScheduleDetailCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getScheduleList(long j3, long j16, long j17, IGProGetScheduleListCallback iGProGetScheduleListCallback) {
            native_getScheduleList(this.nativeRef, j3, j16, j17, iGProGetScheduleListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getScheduleListNew(long j3, long j16, int i3, long j17, String str, IGProGetScheduleListNewCallback iGProGetScheduleListNewCallback) {
            native_getScheduleListNew(this.nativeRef, j3, j16, i3, j17, str, iGProGetScheduleListNewCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getScheduleUsers(long j3, long j16, long j17, int i3, byte[] bArr, IGProGetScheduleUsersCallback iGProGetScheduleUsersCallback) {
            native_getScheduleUsers(this.nativeRef, j3, j16, j17, i3, bArr, iGProGetScheduleUsersCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getSchedulesStatus(long j3, long j16, long j17, long j18, IGProGetSchedulesStatusCallback iGProGetSchedulesStatusCallback) {
            native_getSchedulesStatus(this.nativeRef, j3, j16, j17, j18, iGProGetSchedulesStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getSelectChannelIDs(GProGetSelectChannelIDReq gProGetSelectChannelIDReq, IGProGetSelectChannelIDsCallback iGProGetSelectChannelIDsCallback) {
            native_getSelectChannelIDs(this.nativeRef, gProGetSelectChannelIDReq, iGProGetSelectChannelIDsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public int getSelfLiveChannelBanStatus(long j3, long j16) {
            return native_getSelfLiveChannelBanStatus(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public int getShareButtonFromCache(long j3, long j16, boolean z16) {
            return native_getShareButtonFromCache(this.nativeRef, j3, j16, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public GProSimpleProfile getSimpleProfile(long j3, long j16, int i3) {
            return native_getSimpleProfile(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getSimpleProfileAsync(GProGetSimpleProfileAsyncReq gProGetSimpleProfileAsyncReq, IGProGetSimpleProfileAsyncCallback iGProGetSimpleProfileAsyncCallback) {
            native_getSimpleProfileAsync(this.nativeRef, gProGetSimpleProfileAsyncReq, iGProGetSimpleProfileAsyncCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Long> getSortedGuildIdsFromCache() {
            return native_getSortedGuildIdsFromCache(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProGuild> getSortedGuildsFromCache() {
            return native_getSortedGuildsFromCache(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<GProChannel> getSpecificTypeChannelList(long j3, int i3) {
            return native_getSpecificTypeChannelList(this.nativeRef, j3, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public ArrayList<Long> getToppedGuildIdsFromCache() {
            return native_getToppedGuildIdsFromCache(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getUIData(String str, IGProGetUIDataCallback iGProGetUIDataCallback) {
            native_getUIData(this.nativeRef, str, iGProGetUIDataCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getUnBindClientService(byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback) {
            native_getUnBindClientService(this.nativeRef, bArr, iGProGetClientAccountCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getUnBindClientServiceV2(GProGetUnbindClientReq gProGetUnbindClientReq, IGProGetUnbindClientCallback iGProGetUnbindClientCallback) {
            native_getUnBindClientServiceV2(this.nativeRef, gProGetUnbindClientReq, iGProGetUnbindClientCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getUserList(long j3, long j16, boolean z16, int i3, IGProGetUserListCallback iGProGetUserListCallback) {
            native_getUserList(this.nativeRef, j3, j16, z16, i3, iGProGetUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void getUserLiveInfo(int i3, IGProGetUserLiveInfoCallback iGProGetUserLiveInfoCallback) {
            native_getUserLiveInfo(this.nativeRef, i3, iGProGetUserLiveInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean hasJoinChannelRole(long j3) {
            return native_hasJoinChannelRole(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void implantChatWindow(long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_implantChatWindow(this.nativeRef, j3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void initGetNoticeList(int i3, long j3, boolean z16, IGProInitGetNoticeListCallback iGProInitGetNoticeListCallback) {
            native_initGetNoticeList(this.nativeRef, i3, j3, z16, iGProInitGetNoticeListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void inviteJoinSingleGuild(GProCmd0xf67ReqBody gProCmd0xf67ReqBody, IGProJoinGuildCallback iGProJoinGuildCallback) {
            native_inviteJoinSingleGuild(this.nativeRef, gProCmd0xf67ReqBody, iGProJoinGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void inviteUserHandUpForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
            native_inviteUserHandUpForAdmin(this.nativeRef, gProAdminAVReqInfo, iGProAdminDealResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void inviteUserQueueForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
            native_inviteUserQueueForAdmin(this.nativeRef, gProAdminAVReqInfo, iGProAdminDealResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean isGuildMember(long j3) {
            return native_isGuildMember(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean isQQMsgListChannel(long j3, long j16) {
            return native_isQQMsgListChannel(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean isQQMsgListGuild(long j3) {
            return native_isQQMsgListGuild(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean isQQMsgListReady() {
            return native_isQQMsgListReady(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void joinChannelByGuildTask(GProGuildTaskJoinChannelReq gProGuildTaskJoinChannelReq, IGProJoinChannelByGuildTaskCallback iGProJoinChannelByGuildTaskCallback) {
            native_joinChannelByGuildTask(this.nativeRef, gProGuildTaskJoinChannelReq, iGProJoinChannelByGuildTaskCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void kickAudioChannelUsers(long j3, long j16, ArrayList<Long> arrayList, IGProKickChannelMemberCallback iGProKickChannelMemberCallback) {
            native_kickAudioChannelUsers(this.nativeRef, j3, j16, arrayList, iGProKickChannelMemberCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void kickGuildUser(long j3, ArrayList<Long> arrayList, boolean z16, GProRevokeOptions gProRevokeOptions, IGProResultCallback iGProResultCallback) {
            native_kickGuildUser(this.nativeRef, j3, arrayList, z16, gProRevokeOptions, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadAllMemberList(long j3, long j16, IGProLoadAllMemberListCallback iGProLoadAllMemberListCallback) {
            native_loadAllMemberList(this.nativeRef, j3, j16, iGProLoadAllMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadGuildAndChannels(boolean z16, IGProLoadGuildAndChannelsCallback iGProLoadGuildAndChannelsCallback) {
            native_loadGuildAndChannels(this.nativeRef, z16, iGProLoadGuildAndChannelsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadMemberListByIndex(long j3, long j16, long j17, IGProLoadMemberListByIndexCallback iGProLoadMemberListByIndexCallback) {
            native_loadMemberListByIndex(this.nativeRef, j3, j16, j17, iGProLoadMemberListByIndexCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadMemberRoles(long j3, long j16, IGProLoadMemberRolesCallback iGProLoadMemberRolesCallback) {
            native_loadMemberRoles(this.nativeRef, j3, j16, iGProLoadMemberRolesCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadNextPageMemberList(long j3, long j16, boolean z16, byte[] bArr, int i3, IGProLoadNextPageMemberListCallback iGProLoadNextPageMemberListCallback) {
            native_loadNextPageMemberList(this.nativeRef, j3, j16, z16, bArr, i3, iGProLoadNextPageMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadPartRoleMemberList(long j3, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
            native_loadPartRoleMemberList(this.nativeRef, j3, iGProGetUserInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadUserInfo(long j3, ArrayList<Long> arrayList, IGProGetUserInfoCallback iGProGetUserInfoCallback) {
            native_loadUserInfo(this.nativeRef, j3, arrayList, iGProGetUserInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loadUserList(long j3, long j16, IGProGetUserListCallback iGProGetUserListCallback) {
            native_loadUserList(this.nativeRef, j3, j16, iGProGetUserListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void loginLive(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_loginLive(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void modifyScheduleInviteStatus(long j3, long j16, long j17, int i3, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback) {
            native_modifyScheduleInviteStatus(this.nativeRef, j3, j16, j17, i3, iGProModifyScheduleInviteStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void modifyScheduleInviteStatusV2(GProModifyScheduleInviteReq gProModifyScheduleInviteReq, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback) {
            native_modifyScheduleInviteStatusV2(this.nativeRef, gProModifyScheduleInviteReq, iGProModifyScheduleInviteStatusCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean onServerPushMsg(int i3, int i16, GProMsgRouttingHead gProMsgRouttingHead, byte[] bArr) {
            return native_onServerPushMsg(this.nativeRef, i3, i16, gProMsgRouttingHead, bArr);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void openAVLobbyApp(GProCreateLobbyReq gProCreateLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback) {
            native_openAVLobbyApp(this.nativeRef, gProCreateLobbyReq, iGProCreateLobbyCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void popChatWindow(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_popChatWindow(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void queryAVState(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_queryAVState(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void queryApplyAddGuildStatus(long j3, IGProResultCallback iGProResultCallback) {
            native_queryApplyAddGuildStatus(this.nativeRef, j3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void queryGuildEssence(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
            native_queryGuildEssence(this.nativeRef, gProGuildEssenceSvrReq, iGProGuildEssenceCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void queryGuildVisitor(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
            native_queryGuildVisitor(this.nativeRef, gProGuildEssenceSvrReq, iGProGuildEssenceCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void queryRealNameAuthStatus(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_queryRealNameAuthStatus(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void queryTinyIdByLiveUID(ArrayList<Long> arrayList, IGProQueryTinyIdByLiveUIDCallback iGProQueryTinyIdByLiveUIDCallback) {
            native_queryTinyIdByLiveUID(this.nativeRef, arrayList, iGProQueryTinyIdByLiveUIDCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshAppChannelPreInfos(long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_refreshAppChannelPreInfos(this.nativeRef, j3, z16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshChannelInfo(long j3, long j16, int i3, boolean z16) {
            native_refreshChannelInfo(this.nativeRef, j3, j16, i3, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshGuildInfo(long j3, boolean z16, int i3) {
            native_refreshGuildInfo(this.nativeRef, j3, z16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshGuildInfoOnly(long j3, boolean z16, int i3) {
            native_refreshGuildInfoOnly(this.nativeRef, j3, z16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshGuildList(boolean z16) {
            native_refreshGuildList(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshGuildUserProfileInfo(long j3, long j16, int i3) {
            native_refreshGuildUserProfileInfo(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void refreshPollingData(long j3, long j16, int i3) {
            native_refreshPollingData(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeBanBeforeBroadcast(long j3, long j16, IGProRemoveBanBeforeBroadcastCallback iGProRemoveBanBeforeBroadcastCallback) {
            native_removeBanBeforeBroadcast(this.nativeRef, j3, j16, iGProRemoveBanBeforeBroadcastCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeChannel(GProRemoveChannelReq gProRemoveChannelReq, IGProResultCallback iGProResultCallback) {
            native_removeChannel(this.nativeRef, gProRemoveChannelReq, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeChannelCategoryWithId(long j3, long j16, boolean z16, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
            native_removeChannelCategoryWithId(this.nativeRef, j3, j16, z16, iGProSetChannelCategoryInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeGuild(long j3, IGProResultCallback iGProResultCallback) {
            native_removeGuild(this.nativeRef, j3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public boolean removeGuildGlobalBanner(long j3) {
            return native_removeGuildGlobalBanner(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeGuildTaskCard(GProRemoveGuildTaskCardReq gProRemoveGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_removeGuildTaskCard(this.nativeRef, gProRemoveGuildTaskCardReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeKernelGuildListener(IKernelGuildListener iKernelGuildListener) {
            native_removeKernelGuildListener(this.nativeRef, iKernelGuildListener);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeMemberFromGuildBlackList(long j3, ArrayList<Long> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_removeMemberFromGuildBlackList(this.nativeRef, j3, arrayList, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeRiskMembers(GProRemoveRiskMembersReq gProRemoveRiskMembersReq, IGProRemoveRiskMembersCallback iGProRemoveRiskMembersCallback) {
            native_removeRiskMembers(this.nativeRef, gProRemoveRiskMembersReq, iGProRemoveRiskMembersCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void removeSpeakOrderByUser(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_removeSpeakOrderByUser(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportAISearchRecommendWords(GProAISearchWordsReportReq gProAISearchWordsReportReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_reportAISearchRecommendWords(this.nativeRef, gProAISearchWordsReportReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportAVState(GProAVReportReqInfo gProAVReportReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_reportAVState(this.nativeRef, gProAVReportReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportCurrentGuild(long j3) {
            native_reportCurrentGuild(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportFeedShareData(long j3, long j16, int i3, GProFeedReportData gProFeedReportData, int i16, GProReportTarget gProReportTarget, IGProReportFeedShareDataCallback iGProReportFeedShareDataCallback) {
            native_reportFeedShareData(this.nativeRef, j3, j16, i3, gProFeedReportData, i16, gProReportTarget, iGProReportFeedShareDataCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportFeedback(GProFeedbackReq gProFeedbackReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_reportFeedback(this.nativeRef, gProFeedbackReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportJoinRecommendGuild(IGProReportJoinRecommendGuild iGProReportJoinRecommendGuild) {
            native_reportJoinRecommendGuild(this.nativeRef, iGProReportJoinRecommendGuild);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportPreventAddictionInstructions(GProPAReportExecuteReq gProPAReportExecuteReq, IGProPAReportExecuteCallback iGProPAReportExecuteCallback) {
            native_reportPreventAddictionInstructions(this.nativeRef, gProPAReportExecuteReq, iGProPAReportExecuteCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportShareAtta(GProReportShareAttaReq gProReportShareAttaReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_reportShareAtta(this.nativeRef, gProReportShareAttaReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportShareInfo(long j3, long j16, int i3, String str, int i16, IGProResultCallback iGProResultCallback) {
            native_reportShareInfo(this.nativeRef, j3, j16, i3, str, i16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void reportUserViewGuild(ArrayList<String> arrayList, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_reportUserViewGuild(this.nativeRef, arrayList, str, str2, i3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void requestBeginBroadcast(long j3, long j16, long j17, int i3, GProProgrammeInfoReq gProProgrammeInfoReq, IGProResultCallback iGProResultCallback) {
            native_requestBeginBroadcast(this.nativeRef, j3, j16, j17, i3, gProProgrammeInfoReq, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void requestPubAccountMsgCount(IGProRequestPubAccountMsgCountCallback iGProRequestPubAccountMsgCountCallback) {
            native_requestPubAccountMsgCount(this.nativeRef, iGProRequestPubAccountMsgCountCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void riskMemberList(GProRiskMemberListReq gProRiskMemberListReq, IGProRiskMemberListCallback iGProRiskMemberListCallback) {
            native_riskMemberList(this.nativeRef, gProRiskMemberListReq, iGProRiskMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void saveCustomApplication(GProSaveCustomApplicationReq gProSaveCustomApplicationReq, IGProSaveCustomApplicationCallback iGProSaveCustomApplicationCallback) {
            native_saveCustomApplication(this.nativeRef, gProSaveCustomApplicationReq, iGProSaveCustomApplicationCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void saveGuidNavigation(GProSaveGuildNavigationReq gProSaveGuildNavigationReq, IGProSaveGuildNavigationCallback iGProSaveGuildNavigationCallback) {
            native_saveGuidNavigation(this.nativeRef, gProSaveGuildNavigationReq, iGProSaveGuildNavigationCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchBlackUserFromServer(GProSearchBlackUserReq gProSearchBlackUserReq, IGProSearchBlackUserFromServerCallback iGProSearchBlackUserFromServerCallback) {
            native_searchBlackUserFromServer(this.nativeRef, gProSearchBlackUserReq, iGProSearchBlackUserFromServerCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchChannelContent(long j3, long j16, String str, byte[] bArr, GProSearchType gProSearchType, GProSearchCond gProSearchCond, IGProSearchChannelContentCallback iGProSearchChannelContentCallback) {
            native_searchChannelContent(this.nativeRef, j3, j16, str, bArr, gProSearchType, gProSearchCond, iGProSearchChannelContentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchGuild(String str, byte[] bArr, int i3, int i16, int i17, IGProSearchGuildInfoCallback iGProSearchGuildInfoCallback) {
            native_searchGuild(this.nativeRef, str, bArr, i3, i16, i17, iGProSearchGuildInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchGuildContent(GProGuildSearchNewSearchReq gProGuildSearchNewSearchReq, IGProGuildSearchCallback iGProGuildSearchCallback) {
            native_searchGuildContent(this.nativeRef, gProGuildSearchNewSearchReq, iGProGuildSearchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchGuildFeeds(GProSearchGuildFeedsReq gProSearchGuildFeedsReq, IGProSearchChannelContentCallback iGProSearchChannelContentCallback) {
            native_searchGuildFeeds(this.nativeRef, gProSearchGuildFeedsReq, iGProSearchChannelContentCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchGuildMembersBySourceId(GProGuildMemberSearchParams gProGuildMemberSearchParams, IGProSearchGuildMembersBySourceIdCallback iGProSearchGuildMembersBySourceIdCallback) {
            native_searchGuildMembersBySourceId(this.nativeRef, gProGuildMemberSearchParams, iGProSearchGuildMembersBySourceIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchMsgSeqsFromServer(GProMsgSearchReq gProMsgSearchReq, IGProSearchMsgSeqsFromServerCallback iGProSearchMsgSeqsFromServerCallback) {
            native_searchMsgSeqsFromServer(this.nativeRef, gProMsgSearchReq, iGProSearchMsgSeqsFromServerCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void searchUnion(String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, IGProSearchUnionCallback iGProSearchUnionCallback) {
            native_searchUnion(this.nativeRef, str, bArr, i3, i16, i17, i18, i19, iGProSearchUnionCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void sendAudioOrLiveNotice(GProSendNoticeReq gProSendNoticeReq, IGProSendAudioOrLiveNoticeCallback iGProSendAudioOrLiveNoticeCallback) {
            native_sendAudioOrLiveNotice(this.nativeRef, gProSendNoticeReq, iGProSendAudioOrLiveNoticeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void sendChannelHeartbeat(GProHeartbeatReq gProHeartbeatReq) {
            native_sendChannelHeartbeat(this.nativeRef, gProHeartbeatReq);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void sendDirectMsgReadReport(ArrayList<GProDirectMsgReport> arrayList) {
            native_sendDirectMsgReadReport(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void sendOperationSaveMsg(GProSaveMsgReq gProSaveMsgReq, IGProSendOperationSaveMsgCallBack iGProSendOperationSaveMsgCallBack) {
            native_sendOperationSaveMsg(this.nativeRef, gProSaveMsgReq, iGProSendOperationSaveMsgCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void sendScheduleArkMessage(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProScheduleSendArkGuildInfo> arrayList3, GProScheduleSendArkGuildInfo gProScheduleSendArkGuildInfo, long j3, int i3, String str, String str2, String str3, byte[] bArr, IGProSendScheduleArkMessageCallback iGProSendScheduleArkMessageCallback) {
            native_sendScheduleArkMessage(this.nativeRef, arrayList, arrayList2, arrayList3, gProScheduleSendArkGuildInfo, j3, i3, str, str2, str3, bArr, iGProSendScheduleArkMessageCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setAVChannelInviteSpeakSwitch(long j3, long j16, GProInviteSpeakCfg gProInviteSpeakCfg, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setAVChannelInviteSpeakSwitch(this.nativeRef, j3, j16, gProInviteSpeakCfg, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setAVChannelSpeakMode(long j3, long j16, String str, GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg, IGProSetSpeakModeCallback iGProSetSpeakModeCallback) {
            native_setAVChannelSpeakMode(this.nativeRef, j3, j16, str, gProVoiceSpeakModeCfg, iGProSetSpeakModeCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setAVChannelSpeakOrder(long j3, long j16, GProVoiceQueueCfg gProVoiceQueueCfg, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setAVChannelSpeakOrder(this.nativeRef, j3, j16, gProVoiceQueueCfg, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setAddGuildOption(long j3, int i3, String str, String str2, IGProResultCallback iGProResultCallback) {
            native_setAddGuildOption(this.nativeRef, j3, i3, str, str2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setAnchorRoomInfo(GProAnchorSetRoomInfoReq gProAnchorSetRoomInfoReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setAnchorRoomInfo(this.nativeRef, gProAnchorSetRoomInfoReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setCategoryFolded(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setCategoryFolded(this.nativeRef, j3, j16, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelAuthControl(long j3, long j16, int i3, int i16, IGProResultCallback iGProResultCallback) {
            native_setChannelAuthControl(this.nativeRef, j3, j16, i3, i16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelAuthControlMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelAuthControlMemberList(this.nativeRef, j3, j16, arrayList, arrayList2, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelAuthControlRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelAuthControlRoleList(this.nativeRef, j3, j16, arrayList, arrayList2, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelBannedSpeak(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelBannedSpeak(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelCategoryInfoWithId(long j3, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
            native_setChannelCategoryInfoWithId(this.nativeRef, j3, gProCategoryChannelIdList, arrayList, iGProSetChannelCategoryInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelCategoryOrder(GProSetCategoryOrderReq gProSetCategoryOrderReq, IGProSetCategoryOrderCallback iGProSetCategoryOrderCallback) {
            native_setChannelCategoryOrder(this.nativeRef, gProSetCategoryOrderReq, iGProSetCategoryOrderCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelCategoryOrderWithId(long j3, ArrayList<Long> arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
            native_setChannelCategoryOrderWithId(this.nativeRef, j3, arrayList, iGProSetChannelCategoryInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelCategoryWithId(long j3, long j16, long j17, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback) {
            native_setChannelCategoryWithId(this.nativeRef, j3, j16, j17, iGProSetChannelCategoryInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelHeartbeat(GProHeartbeatReq gProHeartbeatReq) {
            native_setChannelHeartbeat(this.nativeRef, gProHeartbeatReq);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelLiveable(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelLiveable(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelLiveableMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setChannelLiveableMemberList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelLiveableRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setChannelLiveableRoleList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelMsgNotifyType(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelMsgNotifyType(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelName(long j3, long j16, String str, IGProResultCallback iGProResultCallback) {
            native_setChannelName(this.nativeRef, j3, j16, str, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelSlowMode(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelSlowMode(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelSpeakable(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelSpeakable(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelSpeakableMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setChannelSpeakableMemberList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelSpeakableRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setChannelSpeakableRoleList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelSpeakerPerm(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelSpeakerPerm(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelTopMsg(long j3, long j16, long j17, int i3, IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback) {
            native_setChannelTopMsg(this.nativeRef, j3, j16, j17, i3, iGProSetChannelTopMsgCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelUserNumLimit(long j3, long j16, int i3, boolean z16, int i16, IGProResultCallback iGProResultCallback) {
            native_setChannelUserNumLimit(this.nativeRef, j3, j16, i3, z16, i16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelVisible(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_setChannelVisible(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelVisibleMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setChannelVisibleMemberList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setChannelVisibleRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setChannelVisibleRoleList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setClientShowConfig(int i3, int i16, int i17, IGProSetClientShowConfigCallback iGProSetClientShowConfigCallback) {
            native_setClientShowConfig(this.nativeRef, i3, i16, i17, iGProSetClientShowConfigCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setDirectMsgBlack(long j3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setDirectMsgBlack(this.nativeRef, j3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setDirectMsgNotify(long j3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setDirectMsgNotify(this.nativeRef, j3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setDirectMsgNotifyForGuild(int i3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setDirectMsgNotifyForGuild(this.nativeRef, i3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setDirectMsgStatus(int i3, int i16, IGProResultCallback iGProResultCallback) {
            native_setDirectMsgStatus(this.nativeRef, i3, i16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setEnteredChannelState(long j3, long j16, boolean z16) {
            native_setEnteredChannelState(this.nativeRef, j3, j16, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setFeedCommentsNotifySwitch(int i3, IGProSetFeedCommentsNotifySwitchCallback iGProSetFeedCommentsNotifySwitchCallback) {
            native_setFeedCommentsNotifySwitch(this.nativeRef, i3, iGProSetFeedCommentsNotifySwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGender(int i3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setGender(this.nativeRef, i3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGlobalPrivacySwitch(int i3, int i16, IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback) {
            native_setGlobalPrivacySwitch(this.nativeRef, i3, i16, iGProGlobalPrivacySwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildAdmin(long j3, long j16, boolean z16, IGProSetGuildAdminResultCallback iGProSetGuildAdminResultCallback) {
            native_setGuildAdmin(this.nativeRef, j3, j16, z16, iGProSetGuildAdminResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildAuditInfo(GProGuildAuditInfoReq gProGuildAuditInfoReq, IGProAuditInfoResultCallback iGProAuditInfoResultCallback) {
            native_setGuildAuditInfo(this.nativeRef, gProGuildAuditInfoReq, iGProAuditInfoResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildBoundGroups(GProSortAndWriteBindGroupsReq gProSortAndWriteBindGroupsReq, IGProSetGuildBoundGroupsCallback iGProSetGuildBoundGroupsCallback) {
            native_setGuildBoundGroups(this.nativeRef, gProSortAndWriteBindGroupsReq, iGProSetGuildBoundGroupsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildClientId(long j3, int i3, IGProSetGuildClientIdCallback iGProSetGuildClientIdCallback) {
            native_setGuildClientId(this.nativeRef, j3, i3, iGProSetGuildClientIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildCommonUnNotifyFlag(long j3, int i3, int i16, IGProSetGuildNotifyDisplayCallback iGProSetGuildNotifyDisplayCallback) {
            native_setGuildCommonUnNotifyFlag(this.nativeRef, j3, i3, i16, iGProSetGuildNotifyDisplayCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildCoverFontColorId(long j3, int i3, IGProSetGuildCoverFontColorIdCallback iGProSetGuildCoverFontColorIdCallback) {
            native_setGuildCoverFontColorId(this.nativeRef, j3, i3, iGProSetGuildCoverFontColorIdCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildCreatorTaskSkipStatus(long j3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setGuildCreatorTaskSkipStatus(this.nativeRef, j3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildGlobalBanner(GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback) {
            native_setGuildGlobalBanner(this.nativeRef, gProGlobalBannerRep, iGProGlobalBannerCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildGlobalPermission(GProSetGlobalPermissionReq gProSetGlobalPermissionReq, IGProResultCallback iGProResultCallback) {
            native_setGuildGlobalPermission(this.nativeRef, gProSetGlobalPermissionReq, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildListSort(ArrayList<Long> arrayList, IGProSetGuildListSortCallback iGProSetGuildListSortCallback) {
            native_setGuildListSort(this.nativeRef, arrayList, iGProSetGuildListSortCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildListTop(long j3, int i3, int i16, IGProSetGuildListTopCallback iGProSetGuildListTopCallback) {
            native_setGuildListTop(this.nativeRef, j3, i3, i16, iGProSetGuildListTopCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildMemberName(long j3, String str, String str2, IGProResultCallback iGProResultCallback) {
            native_setGuildMemberName(this.nativeRef, j3, str, str2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildName(long j3, String str, IGProResultCallback iGProResultCallback) {
            native_setGuildName(this.nativeRef, j3, str, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildNeedRealNameForVisitor(long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setGuildNeedRealNameForVisitor(this.nativeRef, j3, z16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildNumSearchSwitch(long j3, int i3, IGProResultCallback iGProResultCallback) {
            native_setGuildNumSearchSwitch(this.nativeRef, j3, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildProfile(long j3, String str, IGProResultCallback iGProResultCallback) {
            native_setGuildProfile(this.nativeRef, j3, str, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildQRCodePeriod(long j3, int i3, IGProResultCallback iGProResultCallback) {
            native_setGuildQRCodePeriod(this.nativeRef, j3, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildQRCodeSwitch(long j3, int i3, IGProResultCallback iGProResultCallback) {
            native_setGuildQRCodeSwitch(this.nativeRef, j3, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildShutUp(long j3, long j16, IGProResultCallback iGProResultCallback) {
            native_setGuildShutUp(this.nativeRef, j3, j16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildSpeakableMemberList(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setGuildSpeakableMemberList(this.nativeRef, j3, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildSpeakableRoleList(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setGuildSpeakableRoleList(this.nativeRef, j3, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildSpeakableRule(long j3, GproGuildSpeakableRule gproGuildSpeakableRule, IGProResultCallback iGProResultCallback) {
            native_setGuildSpeakableRule(this.nativeRef, j3, gproGuildSpeakableRule, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildSpeakableThreshold(long j3, GProGuildSpeakableThreshold gProGuildSpeakableThreshold, IGProResultCallback iGProResultCallback) {
            native_setGuildSpeakableThreshold(this.nativeRef, j3, gProGuildSpeakableThreshold, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildTop(long j3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setGuildTop(this.nativeRef, j3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildUnNotifyFlag(long j3, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback) {
            native_setGuildUnNotifyFlag(this.nativeRef, j3, i3, iGProSetGuildWeakNotifyDisplayCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildVisibilityForVisitor(long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setGuildVisibilityForVisitor(this.nativeRef, j3, z16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setGuildWeakNotifyDisplay(long j3, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback) {
            native_setGuildWeakNotifyDisplay(this.nativeRef, j3, i3, iGProSetGuildWeakNotifyDisplayCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setHeader(String str, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setHeader(this.nativeRef, str, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setJoinGuildOption(GProSetJoinGuildOptionReq gProSetJoinGuildOptionReq, IGProResultCallback iGProResultCallback) {
            native_setJoinGuildOption(this.nativeRef, gProSetJoinGuildOptionReq, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setJumpToCategory(GProJumpToCategoryInfo gProJumpToCategoryInfo, IGProResultCallback iGProResultCallback) {
            native_setJumpToCategory(this.nativeRef, gProJumpToCategoryInfo, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setListenTogetherPlayOpt(long j3, long j16, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback) {
            native_setListenTogetherPlayOpt(this.nativeRef, j3, j16, i3, iGProListenTogetherPlayListOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setListenTogetherPlayVolumeByAdmin(long j3, long j16, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback) {
            native_setListenTogetherPlayVolumeByAdmin(this.nativeRef, j3, j16, i3, iGProListenTogetherPlayListOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setLiveChannelAnchorList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setLiveChannelAnchorList(this.nativeRef, j3, j16, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setLiveChannelBannedUser(long j3, long j16, long j17, long j18, int i3, IGProResultCallback iGProResultCallback) {
            native_setLiveChannelBannedUser(this.nativeRef, j3, j16, j17, j18, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setLocation(GProLocation gProLocation, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setLocation(this.nativeRef, gProLocation, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMemberRoles(long j3, long j16, long j17, long j18, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setMemberRoles(this.nativeRef, j3, j16, j17, j18, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMemberShutUp(long j3, long j16, long j17, IGProResultCallback iGProResultCallback) {
            native_setMemberShutUp(this.nativeRef, j3, j16, j17, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMyBirthday(short s16, short s17, short s18, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setMyBirthday(this.nativeRef, s16, s17, s18, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMyPersonalSignature(String str, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setMyPersonalSignature(this.nativeRef, str, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMyProfileShowTypeSwitch(long j3, int i3, int i16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setMyProfileShowTypeSwitch(this.nativeRef, j3, i3, i16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMyVoiceNetworkQuality(long j3, long j16, int i3) {
            native_setMyVoiceNetworkQuality(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setMyVoiceSysMicStatus(long j3, long j16, int i3) {
            native_setMyVoiceSysMicStatus(this.nativeRef, j3, j16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setNickName(String str, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setNickName(this.nativeRef, str, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setOnLogin() {
            native_setOnLogin(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setPerformanceEnable(boolean z16) {
            native_setPerformanceEnable(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setProfileSwitch(int i3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setProfileSwitch(this.nativeRef, i3, z16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setQQMsgListChannel(long j3, long j16, int i3, IGProSetQQMsgListChannelCallback iGProSetQQMsgListChannelCallback) {
            native_setQQMsgListChannel(this.nativeRef, j3, j16, i3, iGProSetQQMsgListChannelCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setQQMsgListGuild(long j3, int i3, int i16, IGProSetQQMsgListGuildCallback iGProSetQQMsgListGuildCallback) {
            native_setQQMsgListGuild(this.nativeRef, j3, i3, i16, iGProSetQQMsgListGuildCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setRoleChannels(long j3, long j16, int i3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProSetRoleChannelsCallback iGProSetRoleChannelsCallback) {
            native_setRoleChannels(this.nativeRef, j3, j16, i3, arrayList, arrayList2, iGProSetRoleChannelsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setRoleInfo(long j3, long j16, GProRoleCreateInfo gProRoleCreateInfo, IGProResultCallback iGProResultCallback) {
            native_setRoleInfo(this.nativeRef, j3, j16, gProRoleCreateInfo, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setRoleMembers(long j3, long j16, long j17, long j18, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback) {
            native_setRoleMembers(this.nativeRef, j3, j16, j17, j18, arrayList, arrayList2, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setRoleOrder(long j3, ArrayList<Long> arrayList, IGProResultCallback iGProResultCallback) {
            native_setRoleOrder(this.nativeRef, j3, arrayList, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setScreenSharedInGuild(long j3, long j16, boolean z16, IGProScreenShareCallback iGProScreenShareCallback) {
            native_setScreenSharedInGuild(this.nativeRef, j3, j16, z16, iGProScreenShareCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setSearchSwitch(GProSetSearchSwitchReq gProSetSearchSwitchReq, IGProSetSearchSwitchCallback iGProSetSearchSwitchCallback) {
            native_setSearchSwitch(this.nativeRef, gProSetSearchSwitchReq, iGProSetSearchSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setSelfTinyId(long j3) {
            native_setSelfTinyId(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setShowArchive(int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback) {
            native_setShowArchive(this.nativeRef, i3, z16, iGProSwitchPresenceArchiveCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setShowPresence(int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback) {
            native_setShowPresence(this.nativeRef, i3, z16, iGProSwitchPresenceArchiveCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setTopicSquareEntranceSwitch(long j3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setTopicSquareEntranceSwitch(this.nativeRef, j3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUIData(String str, String str2) {
            native_setUIData(this.nativeRef, str, str2);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserLiveInfo(int i3, String str, String str2, int i16, IGProSetUserLiveInfoCallback iGProSetUserLiveInfoCallback) {
            native_setUserLiveInfo(this.nativeRef, i3, str, str2, i16, iGProSetUserLiveInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserMuteSeatInGuild(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setUserMuteSeatInGuild(this.nativeRef, j3, j16, j17, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserPermissionInGuild(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setUserPermissionInGuild(this.nativeRef, j3, j16, j17, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserScreenSharedInGuild(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setUserScreenSharedInGuild(this.nativeRef, j3, j16, j17, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserType(String str, IGProUserTypeSetCallback iGProUserTypeSetCallback) {
            native_setUserType(this.nativeRef, str, iGProUserTypeSetCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserTypeWithUserConfigure(boolean z16, IGProUserTypeSetCallback iGProUserTypeSetCallback) {
            native_setUserTypeWithUserConfigure(this.nativeRef, z16, iGProUserTypeSetCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setUserVoicelessToMe(long j3, boolean z16, IGProResultCallback iGProResultCallback) {
            native_setUserVoicelessToMe(this.nativeRef, j3, z16, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void setWindowFliter(ArrayList<Long> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_setWindowFliter(this.nativeRef, arrayList, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void startAnchorBroadcast(long j3, long j16, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_startAnchorBroadcast(this.nativeRef, j3, j16, str, str2, i3, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void startHeartbeat(long j3, long j16) {
            native_startHeartbeat(this.nativeRef, j3, j16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void startPollingForDiscoverState() {
            native_startPollingForDiscoverState(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void startPush(IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_startPush(this.nativeRef, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void stopPollingForDiscoverState(boolean z16) {
            native_stopPollingForDiscoverState(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void subscribePolling(long j3, int i3) {
            native_subscribePolling(this.nativeRef, j3, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void subscribePollingChannels(ArrayList<GProPollingInfo> arrayList) {
            native_subscribePollingChannels(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void subscribePollingSchedule(GProSubscribePollingScheduleReq gProSubscribePollingScheduleReq) {
            native_subscribePollingSchedule(this.nativeRef, gProSubscribePollingScheduleReq);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void superAdminBanUser(GProSuperAdminBanUserReq gProSuperAdminBanUserReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_superAdminBanUser(this.nativeRef, gProSuperAdminBanUserReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void superAdminUnListFeed(GProCmd0x92331SuperAdminUnListFeedReq gProCmd0x92331SuperAdminUnListFeedReq, IGProSuperAdminUnListFeedCallback iGProSuperAdminUnListFeedCallback) {
            native_superAdminUnListFeed(this.nativeRef, gProCmd0x92331SuperAdminUnListFeedReq, iGProSuperAdminUnListFeedCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void switchAVLobbyApp(GProSwitchLobbyReq gProSwitchLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback) {
            native_switchAVLobbyApp(this.nativeRef, gProSwitchLobbyReq, iGProCreateLobbyCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void terminateLiveStream(long j3, long j16, int i3, int i16, IGProTerminateLiveStreamCallback iGProTerminateLiveStreamCallback) {
            native_terminateLiveStream(this.nativeRef, j3, j16, i3, i16, iGProTerminateLiveStreamCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void topSpeakOrderByAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback) {
            native_topSpeakOrderByAdmin(this.nativeRef, gProAdminAVReqInfo, iGProAdminDealResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void transThirdPlatformURL(GProTransThirdPlatformURLReq gProTransThirdPlatformURLReq, IGProTransThirdPlatformURLCallback iGProTransThirdPlatformURLCallback) {
            native_transThirdPlatformURL(this.nativeRef, gProTransThirdPlatformURLReq, iGProTransThirdPlatformURLCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void transThirdVideoURL(GProTransThirdVideoURLReq gProTransThirdVideoURLReq, IGProTransThirdVideoURLCallback iGProTransThirdVideoURLCallback) {
            native_transThirdVideoURL(this.nativeRef, gProTransThirdVideoURLReq, iGProTransThirdVideoURLCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void transferGuildOwner(GProTransferGuildOwnerReq gProTransferGuildOwnerReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_transferGuildOwner(this.nativeRef, gProTransferGuildOwnerReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void tryUnmuteMicrophone(long j3, long j16, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_tryUnmuteMicrophone(this.nativeRef, j3, j16, z16, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void ubSubscribePollingChannels(ArrayList<GProPollingInfo> arrayList) {
            native_ubSubscribePollingChannels(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void unsubscribePolling(long j3) {
            native_unsubscribePolling(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void updateArchiveShowSeq(ArrayList<Integer> arrayList, IGProUpdateArchiveShowSeqCallback iGProUpdateArchiveShowSeqCallback) {
            native_updateArchiveShowSeq(this.nativeRef, arrayList, iGProUpdateArchiveShowSeqCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void updateAudioLiveChannelTheme(GProUpdateChannelThemeReq gProUpdateChannelThemeReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_updateAudioLiveChannelTheme(this.nativeRef, gProUpdateChannelThemeReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void updateForumChannelSortMode(long j3, long j16, int i3, IGProResultCallback iGProResultCallback) {
            native_updateForumChannelSortMode(this.nativeRef, j3, j16, i3, iGProResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void updateGuildEssence(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
            native_updateGuildEssence(this.nativeRef, gProGuildEssenceSvrReq, iGProGuildEssenceCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void updateGuildTaskCardProgress(GProUpdateGuildTaskCardProgressReq gProUpdateGuildTaskCardProgressReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_updateGuildTaskCardProgress(this.nativeRef, gProUpdateGuildTaskCardProgressReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void updateGuildVisitor(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack) {
            native_updateGuildVisitor(this.nativeRef, gProGuildEssenceSvrReq, iGProGuildEssenceCallBack);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void upgradeGroupFeed(ArrayList<Long> arrayList, int i3, IGProUpgradeGroupCallback iGProUpgradeGroupCallback) {
            native_upgradeGroupFeed(this.nativeRef, arrayList, i3, iGProUpgradeGroupCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void userDealSpeakInvitation(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_userDealSpeakInvitation(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void userHandUp(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_userHandUp(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void userOnlineReport(GProGuildOnlineReportReq gProGuildOnlineReportReq, IGProUserOnlineReportCallback iGProUserOnlineReportCallback) {
            native_userOnlineReport(this.nativeRef, gProGuildOnlineReportReq, iGProUserOnlineReportCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void userShareScreen(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback) {
            native_userShareScreen(this.nativeRef, gProUserAVReqInfo, iGProUserAVOptCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void voiceChannelAuth0x10b6(long j3, long j16, int i3, boolean z16, int i16, IGProVoiceChannelAuthCallback iGProVoiceChannelAuthCallback) {
            native_voiceChannelAuth0x10b6(this.nativeRef, j3, j16, i3, z16, i16, iGProVoiceChannelAuthCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void voiceSmobaGameCreateRoom(GProVoiceSmobaGameBaseRoomParams gProVoiceSmobaGameBaseRoomParams, GProVoiceSmobaGameSmobaRoomParams gProVoiceSmobaGameSmobaRoomParams, IGProVoiceSmobaGameCreateRoomCallback iGProVoiceSmobaGameCreateRoomCallback) {
            native_voiceSmobaGameCreateRoom(this.nativeRef, gProVoiceSmobaGameBaseRoomParams, gProVoiceSmobaGameSmobaRoomParams, iGProVoiceSmobaGameCreateRoomCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void voiceSmobaGameDissmissRoom(GProVoiceSmobaGameDissmissRoomReq gProVoiceSmobaGameDissmissRoomReq, IGProSimpleResultCallback iGProSimpleResultCallback) {
            native_voiceSmobaGameDissmissRoom(this.nativeRef, gProVoiceSmobaGameDissmissRoomReq, iGProSimpleResultCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void voiceSmobaGameEnterRoom(long j3, int i3, long j16, long j17, IGProVoiceSmobaGameEnterRoomCallback iGProVoiceSmobaGameEnterRoomCallback) {
            native_voiceSmobaGameEnterRoom(this.nativeRef, j3, i3, j16, j17, iGProVoiceSmobaGameEnterRoomCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void voiceSmobaGameKickOutRoom(GProVoiceSmobaGameKickOutRoomReq gProVoiceSmobaGameKickOutRoomReq, IGProVoiceSmobaKickOutRoomCallback iGProVoiceSmobaKickOutRoomCallback) {
            native_voiceSmobaGameKickOutRoom(this.nativeRef, gProVoiceSmobaGameKickOutRoomReq, iGProVoiceSmobaKickOutRoomCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService
        public void voiceSmobaGameQuitRoom(GProVoiceSmobaGameQuitRoomReq gProVoiceSmobaGameQuitRoomReq, IGProVoiceSmobaGameQuitRoomCallback iGProVoiceSmobaGameQuitRoomCallback) {
            native_voiceSmobaGameQuitRoom(this.nativeRef, gProVoiceSmobaGameQuitRoomReq, iGProVoiceSmobaGameQuitRoomCallback);
        }
    }

    void CancelDownloadBroadcastHelper();

    void DownloadBroadcastHelper();

    void GetMemberInfoByOpenId(String str, long j3, boolean z16, boolean z17, IGProGetMemberInfoByOpenIdCallback iGProGetMemberInfoByOpenIdCallback);

    void InstallBroadcastHelper(IGProSimpleResultCallback iGProSimpleResultCallback);

    void LoadGuildUserProfileInfo(long j3, long j16, IGProLoadGuildUserProfileCallback iGProLoadGuildUserProfileCallback);

    void activeBroadcast(IGProSimpleResultCallback iGProSimpleResultCallback);

    void addGuild(long j3, GProSourceId gProSourceId, String str, IGProJoinGuildCallback iGProJoinGuildCallback);

    void addGuildWithOption(GProAddGuildWithOptionReq gProAddGuildWithOptionReq, IGProJoinGuildCallback iGProJoinGuildCallback);

    void addGuilds(ArrayList<GProJoinGuilds> arrayList, GProSourceId gProSourceId, IGProJoinGuildsCallback iGProJoinGuildsCallback);

    void addGuildsForGrowth(String str, ArrayList<GProJoinGuilds> arrayList, IGProJoinGuildsCallback iGProJoinGuildsCallback);

    void addKernelGuildListener(IKernelGuildListener iKernelGuildListener);

    void addRecentVisitGuildsListSync(ArrayList<Long> arrayList, IGProAddRecentVisitGuildIdsCallback iGProAddRecentVisitGuildIdsCallback);

    void addSpeakOrderByUser(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void anchorEnterRoom(GProAnchorEnterRoomReq gProAnchorEnterRoomReq, IGProAnchorEnterRoomCallback iGProAnchorEnterRoomCallback);

    void anchorLeaveRoom(IGProSimpleResultCallback iGProSimpleResultCallback);

    void appAuthorization(int i3, IGProAppAuthorizationCallback iGProAppAuthorizationCallback);

    void audienceEnterRoom(GProLiveEnterRoomRequest gProLiveEnterRoomRequest, IGProOnAudienceEnterRoomCallback iGProOnAudienceEnterRoomCallback);

    void audienceLeaveRoom(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void authScreenShared(long j3, long j16, IGProScreenShareCallback iGProScreenShareCallback);

    void batchDeleteAISearchSession(GProAISearchBatchDeleteSessionReq gProAISearchBatchDeleteSessionReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void batchFetchAudioChannelSimpleUserList(long j3, ArrayList<Long> arrayList, boolean z16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback);

    void batchGetAudioBotStatus(GProGetAudioBotStatusReq gProGetAudioBotStatusReq, IGProBatchGetAudioBotStatusCallback iGProBatchGetAudioBotStatusCallback);

    void batchGetGuildLabelInfo(GProBatchGetGuildLabelInfoReq gProBatchGetGuildLabelInfoReq, IGProBatchGetGuildLabelInfoCallback iGProBatchGetGuildLabelInfoCallback);

    void batchGetItemDetail(GProGetItemDetailReq gProGetItemDetailReq, IGProGetItemDetailCallback iGProGetItemDetailCallback);

    void batchSetCategoryFolded(long j3, HashMap<Long, Boolean> hashMap, IGProResultCallback iGProResultCallback);

    void batchSetGuildInfoBoolField(long j3, HashMap<Integer, Boolean> hashMap, IGProSimpleResultCallback iGProSimpleResultCallback);

    void batchSetGuildInfoIntField(long j3, HashMap<Integer, Integer> hashMap, IGProSimpleResultCallback iGProSimpleResultCallback);

    void batchUpdateChannelsMsgNotifyType(long j3, ArrayList<GProChannelMsgNotify> arrayList, IGProResultCallback iGProResultCallback);

    void beforehandGetGuildSpeakPermission(long j3, int i3, IGProBeforehandGetSpeakPermissionCallback iGProBeforehandGetSpeakPermissionCallback);

    void bindAppRole(int i3, String str, int i16, IGProBindAppRoleCallback iGProBindAppRoleCallback);

    void cancelChannelTopMsg(long j3, long j16, ArrayList<GProTopMsg> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

    void cancelSpeakOrderByAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

    void cancelUserHandUpForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

    void changeChannelCategoryNameWithId(long j3, long j16, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

    void changeGuildAllowSearch(long j3, boolean z16, IGProResultCallback iGProResultCallback);

    void checkAVState(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void checkAndEncryptText(GProEncryptTextReq gProEncryptTextReq, IGProCheckAndEncryptTextCallBack iGProCheckAndEncryptTextCallBack);

    void checkFeedAbstractInfo(GProCheckFeedAbstractInfoReq gProCheckFeedAbstractInfoReq, IGProCheckFeedAbstractInfoCallback iGProCheckFeedAbstractInfoCallback);

    void checkIsStrangerNewMember(IGProCheckIsStrangerNewMemberCallback iGProCheckIsStrangerNewMemberCallback);

    void checkLobbyAppAuthStatus(String str, long j3, long j16, IGProCheckLobbyAppAuthStatusCallback iGProCheckLobbyAppAuthStatusCallback);

    void checkPreventAddiction(GProPreventAddictionCheckReq gProPreventAddictionCheckReq, IGProPreventAddictionCheckCallback iGProPreventAddictionCheckCallback);

    void checkUserBannedSpeakInChannel(long j3, long j16, long j17, IGProCheckUserBannedSpeakInChannelCallback iGProCheckUserBannedSpeakInChannelCallback);

    void checkUserFreeGiftInfo(GProUserFreeGiftReq gProUserFreeGiftReq, IGProCheckUserFreeGiftCallback iGProCheckUserFreeGiftCallback);

    void clearGuildRelatedData(ArrayList<Long> arrayList);

    void closeAVLobbyApp(long j3, long j16, long j17, IGProDeleteLobbyCallback iGProDeleteLobbyCallback);

    void closeChannelActivitySwitch(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void closeChannelTopMsg(long j3, long j16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void convertGuildAndThirdIds(GProConvertThirdIdReq gProConvertThirdIdReq, IGProConvertGuildAndThirdIdCallback iGProConvertGuildAndThirdIdCallback);

    GProInviteInfo convertToGuildInviteInfo(GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo);

    void createChannelCategoryWithId(long j3, String str, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

    void createChannelWithId(long j3, GProChannelCreateInfo gProChannelCreateInfo, long j16, GProAssocCreateCategoryReq gProAssocCreateCategoryReq, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProCreateChannelCallback iGProCreateChannelCallback);

    void createDirectMsgSession(GProDirectMsgCreateInfo gProDirectMsgCreateInfo, IGProCreateDirectMsgSessionCallback iGProCreateDirectMsgSessionCallback);

    void createGuild(GProCreateGuildReq gProCreateGuildReq, IGProCreateGuildCallback iGProCreateGuildCallback);

    void createLinkChannelWithId(long j3, GProChannelCreateInfo gProChannelCreateInfo, long j16, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

    void createRole(long j3, GProRoleCreateInfo gProRoleCreateInfo, ArrayList<Long> arrayList, IGProCreateRoleCallback iGProCreateRoleCallback);

    void createSchedule(long j3, long j16, GProScheduleInfo gProScheduleInfo, IGProCreateScheduleCallback iGProCreateScheduleCallback);

    void createScheduleLimitQuery(long j3, IGProCreateScheduleLimitQueryCallback iGProCreateScheduleLimitQueryCallback);

    void createScheduleV2(GProCreateScheduleReq gProCreateScheduleReq, IGProCreateScheduleCallback iGProCreateScheduleCallback);

    void customChannelMsgNotifyType(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void dealHandUpRequestForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, boolean z16, IGProAdminDealResultCallback iGProAdminDealResultCallback);

    void dealNotice(String str, String str2, IGProDealNoticeCallback iGProDealNoticeCallback);

    void decodeInviteJumpInfo(String str, IGProDecodeInviteJumpInfoCallback iGProDecodeInviteJumpInfoCallback);

    GProGetContentRecommendRsp decodeMVPFeedsRspPb(byte[] bArr);

    GProScheduleInfo decodeScheduleInfo(byte[] bArr);

    void deleteAISearchSession(GProAISearchDeleteSessionReq gProAISearchDeleteSessionReq, IGProDeleteAISearchSessionCallback iGProDeleteAISearchSessionCallback);

    void deleteFeed(GProDeleteFeedReq gProDeleteFeedReq, IGProDeleteFeedCallback iGProDeleteFeedCallback);

    void deleteGuildEssence(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

    void deleteGuildGlobalBanner(GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback);

    void deleteRole(long j3, long j16, IGProResultCallback iGProResultCallback);

    void deleteSystemNoticeMessage(GProSystemNoticeMessageDeleteReq gProSystemNoticeMessageDeleteReq, IGProDeleteSystemNoticeMessageCallback iGProDeleteSystemNoticeMessageCallback);

    void destroyGuild(long j3, IGProResultCallback iGProResultCallback);

    void doGuildCheckin(GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback);

    void doRealNameAuth(int i3, IGProGetRealNameAuthCallback iGProGetRealNameAuthCallback);

    void domainResolveByLocalDns(String str);

    void editSchedule(long j3, long j16, GProScheduleInfo gProScheduleInfo, int i3, IGProEditScheduleCallback iGProEditScheduleCallback);

    void editScheduleV2(GProEditScheduleReq gProEditScheduleReq, IGProEditScheduleCallback iGProEditScheduleCallback);

    void endPush(IGProSimpleResultCallback iGProSimpleResultCallback);

    void enterAudioChannel(long j3, long j16, int i3, IGProEnterAudioChannelCallback iGProEnterAudioChannelCallback);

    void enterAudioLiveChannel(GProEnterAudioLiveChannelReq gProEnterAudioLiveChannelReq, IGProEnterAudioLiveChannelCallback iGProEnterAudioLiveChannelCallback);

    void exitAudioChannel(long j3, long j16, IGProResultCallback iGProResultCallback);

    void exitAudioLiveChannel(long j3, long j16, int i3, ArrayList<String> arrayList, IGProExitAudioLiveChannelCallback iGProExitAudioLiveChannelCallback);

    void exposeGuildTaskCard(GProExposureGuildTaskCardReq gProExposureGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void exposeRecommends(GProExposeRecommedsReq gProExposeRecommedsReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void fetchActiveChannels(long j3, IGProFetchActiveChannelsCallback iGProFetchActiveChannelsCallback);

    void fetchAddGuildInfo(int i3, long j3, IGProAddGuildInfoCallBack iGProAddGuildInfoCallBack);

    void fetchAddGuildOption(long j3, int i3, IGProFetchAddGuildOptionCallback iGProFetchAddGuildOptionCallback);

    void fetchAnchorPreparePage(GProAnchorPrepareReq gProAnchorPrepareReq, IGProFetchAnchorPreparePageCallback iGProFetchAnchorPreparePageCallback);

    void fetchAppInfos(long j3, IGProFetchAppInfosCallback iGProFetchAppInfosCallback);

    void fetchArchiveArkData(long j3, long j16, byte[] bArr, int i3, IGProFetchArchiveArkDataCallback iGProFetchArchiveArkDataCallback);

    void fetchAudioChannelUserList(long j3, long j16, IGProFetchAudioChannelUserListCallback iGProFetchAudioChannelUserListCallback);

    void fetchAudioLiveChannelBlockUserState(long j3, long j16, IGProFetchBlockUserStateCallback iGProFetchBlockUserStateCallback);

    void fetchAudioLiveChannelGroupList(GProAVMemberGroupListReq gProAVMemberGroupListReq, IGProFetchAudioLiveGroupListCallback iGProFetchAudioLiveGroupListCallback);

    void fetchAudioLiveChannelUserList(GProAudioLiveUserListReq gProAudioLiveUserListReq, IGProFetchAudioLiveUserListCallback iGProFetchAudioLiveUserListCallback);

    void fetchBatchBotGetCommand(GProBatchBotGetCommand gProBatchBotGetCommand, IGProFetchBatchBotGetCommandCallback iGProFetchBatchBotGetCommandCallback);

    void fetchCategoryAdminInfoList(GProFetchCategoryAdminDisplayInfoReq gProFetchCategoryAdminDisplayInfoReq, IGProFetchCategoryAdminInfoListCallback iGProFetchCategoryAdminInfoListCallback);

    void fetchChannelAdminInfoList(long j3, long j16, IGProChannelAdminInfoListCallback iGProChannelAdminInfoListCallback);

    void fetchChannelAuthControlMemberList(long j3, long j16, int i3, byte[] bArr, int i16, IGProFetchChannelAbleMemberListCallback iGProFetchChannelAbleMemberListCallback);

    void fetchChannelAuthControlRoleList(long j3, long j16, int i3, IGProFetchChannelAbleRoleListCallback iGProFetchChannelAbleRoleListCallback);

    void fetchChannelAuthControlUnableMemberList(long j3, long j16, int i3, byte[] bArr, int i16, IGProFetchChannelUnableMemberListCallback iGProFetchChannelUnableMemberListCallback);

    void fetchChannelInfo(long j3, long j16, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback);

    void fetchChannelInfoWithCategory(long j3, long j16, int i3, IGProFetchChannelInfoCallback iGProFetchChannelInfoCallback);

    void fetchChannelInfoWithUnreadStatus(long j3, boolean z16);

    void fetchChannelInvisibleMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelInvisibleMemberListCallback iGProFetchChannelInvisibleMemberListCallback);

    void fetchChannelInvisibleRoleList(long j3, long j16, IGProFetchChannelInvisibleRoleListCallback iGProFetchChannelInvisibleRoleListCallback);

    void fetchChannelList(ArrayList<Long> arrayList, IGProFetchChannelListCategoryCallback iGProFetchChannelListCategoryCallback);

    void fetchChannelListForJump(long j3, IGProFetchChannelListForJumpCallback iGProFetchChannelListForJumpCallback);

    void fetchChannelListState(ArrayList<GProGuildStateReqInfo> arrayList, IGProFetchChannelListStateCallback iGProFetchChannelListStateCallback);

    void fetchChannelLiveableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelLiveableMemberListCallback iGProFetchChannelLiveableMemberListCallback);

    void fetchChannelLiveableRoleList(long j3, long j16, IGProFetchChannelLiveableRoleListCallback iGProFetchChannelLiveableRoleListCallback);

    void fetchChannelSpeakableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelSpeakableMemberListCallback iGProFetchChannelSpeakableMemberListCallback);

    void fetchChannelSpeakableRoleList(long j3, long j16, IGProFetchChannelSpeakableRoleListCallback iGProFetchChannelSpeakableRoleListCallback);

    void fetchChannelUnlivableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelUnlivableMemberListCallback iGProFetchChannelUnlivableMemberListCallback);

    void fetchChannelUnlivableRoleList(long j3, long j16, IGProFetchChannelUnlivableRoleListCallback iGProFetchChannelUnlivableRoleListCallback);

    void fetchChannelUnspeakableMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelUnspeakableMemberListCallback iGProFetchChannelUnspeakableMemberListCallback);

    void fetchChannelUnspeakableRoleList(long j3, long j16, IGProFetchChannelUnspeakableRoleListCallback iGProFetchChannelUnspeakableRoleListCallback);

    void fetchChannelUserPermission(long j3, long j16, int i3, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback);

    void fetchChannelVisibleAllMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback);

    void fetchChannelVisibleMemberList(long j3, long j16, int i3, byte[] bArr, IGProFetchChannelVisibleMemberListCallback iGProFetchChannelVisibleMemberListCallback);

    void fetchChannelVisibleRoleList(long j3, long j16, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback);

    void fetchChannelVisibleRoleListWithoutLevelRole(long j3, long j16, IGProFetchChannelVisibleRoleListCallback iGProFetchChannelVisibleRoleListCallback);

    void fetchComments(long j3, long j16, long j17, long j18, long j19, long j26, IGProFetchCommentsCallback iGProFetchCommentsCallback);

    void fetchCurrentLiveRoomInfo(long j3, IGProFetchCurrentLiveRoomInfoCallback iGProFetchCurrentLiveRoomInfoCallback);

    void fetchDirectMsgBlack(long j3, IGProFetchDirectMsgBlackCallback iGProFetchDirectMsgBlackCallback);

    void fetchDirectMsgStatus(IGProFetchDirectMsgStatusCallback iGProFetchDirectMsgStatusCallback);

    void fetchEndPageMessage(long j3, IGProFetchEndPageMessageCallback iGProFetchEndPageMessageCallback);

    void fetchFeedCommentsNotifySwitch(IGProGetFeedCommentsNotifySwitchCallback iGProGetFeedCommentsNotifySwitchCallback);

    void fetchGlobalPrivacySwitch(IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback);

    void fetchGuestGuild(long j3, boolean z16, int i3, IGProFetchGuestGuildCallback iGProFetchGuestGuildCallback);

    void fetchGuestGuildInfoWithChannelList(int i3, GProGetGuildAndChannelReq gProGetGuildAndChannelReq, IGProFetchGuestGuildInfoWithChannelListCallback iGProFetchGuestGuildInfoWithChannelListCallback);

    void fetchGuildActiveLiveChannelNum(GProFetchGuildActiveLiveChannelNumReq gProFetchGuildActiveLiveChannelNumReq, IGProFetchGuildActiveLiveChannelNumCallback iGProFetchGuildActiveLiveChannelNumCallback);

    void fetchGuildActiveValue(long j3, IGProGuildActiveValueCallback iGProGuildActiveValueCallback);

    void fetchGuildBlackList(long j3, byte[] bArr, IGProFetchGuildBlackListCallback iGProFetchGuildBlackListCallback);

    void fetchGuildBottomTabExp(GProBottomTabExpReq gProBottomTabExpReq, IGProFetchGuildBottomTabExpCallback iGProFetchGuildBottomTabExpCallback);

    void fetchGuildBoundGroupsWithGroupCodes(long j3, ArrayList<Long> arrayList, IGProFetchGuildBoundGroupsWithGroupCodesCallback iGProFetchGuildBoundGroupsWithGroupCodesCallback);

    void fetchGuildInfo(long j3, int i3, IGProFetchGuildInfoCallback iGProFetchGuildInfoCallback);

    void fetchGuildInfoAndMemberList(GProGuildInfoAndMemberListReq gProGuildInfoAndMemberListReq, IGProFetchGuildInfoAndMemberListCallback iGProFetchGuildInfoAndMemberListCallback);

    void fetchGuildInfoByAppIdentity(GProGuildIdentity gProGuildIdentity, String str, String str2, IGProFetchGuildInfoByAppIdentityCallback iGProFetchGuildInfoByAppIdentityCallback);

    void fetchGuildSearchSwitch(long j3, IGProFetchGuildSearchSwitchCallback iGProFetchGuildSearchSwitchCallback);

    void fetchGuildSpeakableMemberList(long j3, boolean z16, int i3, byte[] bArr, IGProFetchGuildSpeakableMemberListCallback iGProFetchGuildSpeakableMemberListCallback);

    void fetchGuildSpeakableRoleList(long j3, boolean z16, IGProFetchGuildSpeakableRoleListCallback iGProFetchGuildSpeakableRoleListCallback);

    void fetchGuildSpeakableRule(long j3, IGProFetchGuildSpeakableRuleCallback iGProFetchGuildSpeakableRuleCallback);

    void fetchGuildSpeakableThreshold(long j3, IGProFetchGuildSpeakableThresholdCallback iGProFetchGuildSpeakableThresholdCallback);

    void fetchGuildTaskCards(GProAllGuildTaskCardReq gProAllGuildTaskCardReq, IGProFetchGuildTaskCardsCallback iGProFetchGuildTaskCardsCallback);

    void fetchHandUpMemberList(long j3, long j16, IGProFetchHandUpMemberListCallback iGProFetchHandUpMemberListCallback);

    void fetchInviteInfo(String str, IGProFetchInviteInfoCallback iGProFetchInviteInfoCallback);

    void fetchInviteInfo0x10b4(String str, String str2, String str3, int i3, IGProFetchInviteInfo0x10b4Callback iGProFetchInviteInfo0x10b4Callback);

    void fetchIsLiveChannelOpen(long j3, IGProFetchIsLiveChannelOpenCallback iGProFetchIsLiveChannelOpenCallback);

    void fetchIsStartBroadcastVisible(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void fetchIsVoiceChannelOpen(long j3, IGProFetchIsVoiceChannelOpenCallback iGProFetchIsVoiceChannelOpenCallback);

    void fetchJoinGuildOption(GProFetchJoinGuildOptionReq gProFetchJoinGuildOptionReq, IGProFetchJoinGuildOptionCallback iGProFetchJoinGuildOptionCallback);

    void fetchJubaoMsgResId(long j3, long j16, long j17, IGProFetchJubaoMsgResIdCallback iGProFetchJubaoMsgResIdCallback);

    void fetchJubaoMsgsResId(long j3, long j16, ArrayList<Long> arrayList, IGProFetchJubaoMsgsResIdCallback iGProFetchJubaoMsgsResIdCallback);

    void fetchJumpInfo(long j3, IGProFetchJumpInfoCallback iGProFetchJumpInfoCallback);

    void fetchLatestComments(long j3, long j16, long j17, long j18, IGProFetchCommentsCallback iGProFetchCommentsCallback);

    void fetchLevelRolePermissions(long j3, int i3, IGProFetchLevelRoleListCallback iGProFetchLevelRoleListCallback);

    void fetchLiveChannelAnchorList(long j3, long j16, IGProFetchLiveChannelAnchorListCallback iGProFetchLiveChannelAnchorListCallback);

    void fetchLiveChannelBannedUserList(long j3, long j16, long j17, IGProFetchBannedUserListCallback iGProFetchBannedUserListCallback);

    void fetchLiveRoomInfo(GProLiveRoomInfoReq gProLiveRoomInfoReq, IGProFetchLiveChannelInfoListCallback iGProFetchLiveChannelInfoListCallback);

    void fetchLiveSecurityTips(IGProFetchLiveSecurityTipsCallback iGProFetchLiveSecurityTipsCallback);

    void fetchMVPFeedsFromServer(GProGetContentRecommendReq gProGetContentRecommendReq, IGProFetchMVPFeedsDataCallback iGProFetchMVPFeedsDataCallback);

    void fetchMemberListForFeed(GProFeedMemberListReq gProFeedMemberListReq, IGProFetchMemberListCallback iGProFetchMemberListCallback);

    void fetchMemberListWithRole(long j3, long j16, long j17, long j18, int i3, int i16, IGProFetchMemberListWithRoleCallback iGProFetchMemberListWithRoleCallback);

    void fetchMemberListWithRoleCookie(long j3, long j16, long j17, long j18, int i3, String str, int i16, IGProFetchMemberListWithRoleCookieCallback iGProFetchMemberListWithRoleCookieCallback);

    void fetchMemberRoles(long j3, long j16, long j17, int i3, IGProFetchMemberRolesCallback iGProFetchMemberRolesCallback);

    void fetchMyCreateGuilds(IGProFetchMyCreateGuildsCallback iGProFetchMyCreateGuildsCallback);

    void fetchNewestNotice(int i3, long j3, IGProFetchNewestNoticeCallback iGProFetchNewestNoticeCallback);

    void fetchNonRoleMembers(long j3, long j16, long j17, long j18, long j19, int i3, int i16, IGProFetchNonRoleMembersCallback iGProFetchNonRoleMembersCallback);

    void fetchOnlineUsers(long j3, int i3, int i16, ArrayList<Long> arrayList, IGProFetchOnlineUsersCallback iGProFetchOnlineUsersCallback);

    void fetchOtherChannelUserPermission(long j3, long j16, long j17, int i3, int i16, IGProChannelUserPermissionCallback iGProChannelUserPermissionCallback);

    void fetchProfileAddFriendField(long j3, long j16, IGProFetchProfileAddFriendFieldCallback iGProFetchProfileAddFriendFieldCallback);

    void fetchPskey(ArrayList<String> arrayList, IGProFetchPskeyCallback iGProFetchPskeyCallback);

    void fetchRecommendChannel(int i3, int i16, IGProFetchRecommendChannelCallback iGProFetchRecommendChannelCallback);

    void fetchRecommendEssenceInfo(long j3, int i3, IGProFetchRecommendEssenceInfoCallback iGProFetchRecommendEssenceInfoCallback);

    void fetchRemainAtSetInfo(long j3, IGProFetchAtSetInfoCallback iGProFetchAtSetInfoCallback);

    void fetchRetentionGuildList(int i3, int i16, byte[] bArr, long j3, IGProFetchRetentionGuildListCallback iGProFetchRetentionGuildListCallback);

    void fetchRole(long j3, long j16, int i3, boolean z16, IGProFetchRoleCallback iGProFetchRoleCallback);

    void fetchRoleListWithFilter(long j3, int i3, int i16, IGProFetchRoleListCallback iGProFetchRoleListCallback);

    void fetchRoleListWithPermission(long j3, int i3, IGProFetchRoleListPermissionCallback iGProFetchRoleListPermissionCallback);

    void fetchRoleListWithoutLevelRoleWithFilter(long j3, int i3, int i16, IGProFetchRoleListWithoutLevelRoleCallback iGProFetchRoleListWithoutLevelRoleCallback);

    void fetchRoleMembers(long j3, long j16, long j17, long j18, long j19, int i3, IGProFetchRoleMembersCallback iGProFetchRoleMembersCallback);

    void fetchRoleWithPermission(long j3, long j16, int i3, IGProFetchRolePermissionCallback iGProFetchRolePermissionCallback);

    void fetchShareButtonReq(ArrayList<Long> arrayList, boolean z16, IGProCommonCallback iGProCommonCallback);

    void fetchShareInfo0x10c3(long j3, long j16, GProFetchShareInfo0x10c3Req gProFetchShareInfo0x10c3Req, IGProFetchShareInfo0x10c3Callback iGProFetchShareInfo0x10c3Callback);

    void fetchShareUrlReq(long j3, long j16, long j17, String str, GProFetchShareUrlFilter gProFetchShareUrlFilter, ArrayList<GProURLParam> arrayList, IGProFetchShareUrlCallback iGProFetchShareUrlCallback);

    void fetchSpecifiedTypeChannelOpenState(long j3, long j16, IGProFetchSpecifiedTypeChannelOpenStateCallback iGProFetchSpecifiedTypeChannelOpenStateCallback);

    void fetchSpecifiedTypeChannelsOpenState(long j3, ArrayList<Integer> arrayList, int i3, IGProFetchSpecifiedTypeChannelsOpenStateCallback iGProFetchSpecifiedTypeChannelsOpenStateCallback);

    void fetchSubscribeUserGuide(IGProFetchSubscribeUserGuideCallback iGProFetchSubscribeUserGuideCallback);

    void fetchUserInfo(long j3, long j16, ArrayList<Long> arrayList, int i3, IGProGetUserInfoCallback iGProGetUserInfoCallback);

    void fetchUserJoinedGuildListV2(GProFetchUserJoinedGuildListReq gProFetchUserJoinedGuildListReq, IGProFetchUserJoinedGuildListCallbackV2 iGProFetchUserJoinedGuildListCallbackV2);

    void fetchUserList(long j3, long j16, int i3, IGProGetUserListCallback iGProGetUserListCallback);

    void fetchVersionNews(IGProFetchVersionNewsCallback iGProFetchVersionNewsCallback);

    void fetchVisibleMemberListByTinyId(long j3, long j16, ArrayList<Long> arrayList, int i3, IGProFetchVisibleMemberListByTinyIdCallback iGProFetchVisibleMemberListByTinyIdCallback);

    void fetchXWordInfo(long j3, IGproXWorldInfoCallback iGproXWorldInfoCallback);

    void getAISearchRecommendWords(IGProGetAISearchRecommendWordsCallback iGProGetAISearchRecommendWordsCallback);

    void getAISearchSessionList(GProAISearchGetSessionListReq gProAISearchGetSessionListReq, boolean z16, IGProGetAISearchSessionListCallback iGProGetAISearchSessionListCallback);

    void getAISearchSessionMsgList(GProAISearchGetSessionMsgListReq gProAISearchGetSessionMsgListReq, boolean z16, IGProGetAISearchSessionMsgListCallback iGProGetAISearchSessionMsgListCallback);

    void getAISearchShareURL(GProGetAISearchShareURLReq gProGetAISearchShareURLReq, IGProGetAISearchShareURLCallback iGProGetAISearchShareURLCallback);

    HashMap<Long, Integer> getAVChannelUserCnts(long j3);

    void getActiveLiveAudioChannelNum(long j3, IGProGetActiveLiveAudioChannelNumCallback iGProGetActiveLiveAudioChannelNumCallback);

    void getActiveLiveAudioChannelNumV2(GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetActiveLiveAudioChannelNumV2Callback iGProGetActiveLiveAudioChannelNumV2Callback);

    void getAllGuildSearchAIInfo(GProGuildSearchGetAllGuildAIInfoReq gProGuildSearchGetAllGuildAIInfoReq, IGProGetAllGuildSearchAIInfoCallback iGProGetAllGuildSearchAIInfoCallback);

    GProGuildUserState getAlreadyEnteredChannel();

    void getAppAuthorizationInfo(int i3, int i16, IGProGetAppAuthorizationInfoCallback iGProGetAppAuthorizationInfoCallback);

    GProAppChnnPreInfo getAppChannelPreInfo(long j3, long j16);

    ArrayList<GProAppChnnPreInfo> getAppChannelPreInfos(long j3);

    ArrayList<GProAppInfo> getAppInfos();

    void getAppRoleList(int i3, String str, byte[] bArr, IGProGetAppRoleListCallback iGProGetAppRoleListCallback);

    void getAssociativeWords(String str, IGProAssociativeWordsCallback iGProAssociativeWordsCallback);

    void getAtMemberList(String str, String str2, IGProGetUserInfoCallback iGProGetUserInfoCallback);

    void getBanners(GProGetBannersReq gProGetBannersReq, IGProGetBannersCallback iGProGetBannersCallback);

    void getBindClientService(int i3, int i16, byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback);

    void getBindingGroupInfos(ArrayList<Long> arrayList, IGProGetBindingGroupInfosCallback iGProGetBindingGroupInfosCallback);

    void getBlockRecGuilds(GProGetBlockRecGuildsReq gProGetBlockRecGuildsReq, IGProGetBlockRecGuildsCallback iGProGetBlockRecGuildsCallback);

    ArrayList<GProCategoryChannelIdList> getCategoryChannelIdList(long j3);

    ArrayList<GProCategoryChannelIdList> getCategoryChannelIdListExcludeCategoryType(long j3, ArrayList<Integer> arrayList);

    ArrayList<GProCategoryChannelInfoList> getCategoryChannelInfoList(long j3);

    ArrayList<GProCategoryChannelInfoList> getCategoryChannelInfoListByCategoryType(long j3, ArrayList<Integer> arrayList);

    void getCategoryChannelInfoListByFilter(GProGetCategoryChannelInfoListByFilterReq gProGetCategoryChannelInfoListByFilterReq, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback);

    void getCategoryChannelInfoListV2(GProGetCategoryChannelInfoListV2Req gProGetCategoryChannelInfoListV2Req, IGProGetCategoryChannelInfoListV2Callback iGProGetCategoryChannelInfoListV2Callback);

    void getCategoryGuilds(GProGetCategoryGuildsReq gProGetCategoryGuildsReq, IGProGetCategoryGuildsCallback iGProGetCategoryGuildsCallback);

    void getCategoryPageGuilds(GProGetCategoryPageGuildsReq gProGetCategoryPageGuildsReq, IGProGetCategoryPageGuildsCallback iGProGetCategoryPageGuildsCallback);

    ArrayList<Integer> getCategoryPermission(long j3, long j16);

    void getCategoryTabContent(GProGetCategoryTabContentReq gProGetCategoryTabContentReq, IGProGetCategoryTabContentCallback iGProGetCategoryTabContentCallback);

    void getChannelActivity(GProGetChannelActivityReq gProGetChannelActivityReq, IGProGetChannelActivityCallback iGProGetChannelActivityCallback);

    void getChannelHeartbeat(long j3, long j16, IGProGetChannelHeartbeatCallback iGProGetChannelHeartbeatCallback);

    HashMap<Long, ArrayList<Long>> getChannelIdsWithGuildIdsFromCache(GProGetChannelIdsWithGuildIdsFromCacheReq gProGetChannelIdsWithGuildIdsFromCacheReq);

    GProChannel getChannelInfo(long j3);

    ArrayList<Integer> getChannelPermission(long j3, long j16);

    void getChannelTopMsgFlashState(long j3, long j16, long j17, IGProGetChannelTopMsgFlashStateCallback iGProGetChannelTopMsgFlashStateCallback);

    void getChannelTopMsgState(long j3, long j16, IGProGetChannelTopMsgStateCallback iGProGetChannelTopMsgStateCallback);

    int getChannelUserPermission(long j3, long j16);

    void getClientInfoList(int i3, byte[] bArr, IGProGetClientInfoListCallback iGProGetClientInfoListCallback);

    void getConfigTabContent(GProGetConfigTabContentReq gProGetConfigTabContentReq, IGProGetConfigTabContentCallback iGProGetConfigTabContentCallback);

    void getCurrPlaySong(long j3, long j16, IGProGetCurrPlaySongCallback iGProGetCurrPlaySongCallback);

    void getDiscoverAudioVideoInfos(GProDiscoverAudioVideoInfosReq gProDiscoverAudioVideoInfosReq, IGProGetDiscoverAudioVideoInfosCallback iGProGetDiscoverAudioVideoInfosCallback);

    ArrayList<Long> getEffectGuildIdsFromCache();

    GProFaceAuthInfo getFaceAuthInfo();

    void getFriendsInGuild(GProGetGuildFriendsReq gProGetGuildFriendsReq, IGProGetFriendsInGuildCallback iGProGetFriendsInGuildCallback);

    void getFriendsRecommend(GProGetFriendsRecommendReq gProGetFriendsRecommendReq, IGProGetFriendsRecommendCallback iGProGetFriendsRecommendCallback);

    ArrayList<GProGuild> getGroupGuildListFromCache();

    void getGuidePageInfo(long j3, String str, IGProGetGuidePageInfoCallback iGProGetGuidePageInfoCallback);

    void getGuildAndChannelListFromCache(IGProLoadGuildAndChnListCallback iGProLoadGuildAndChnListCallback);

    void getGuildBindableGroups(IGProGetGuildBindableGroupsCallback iGProGetGuildBindableGroupsCallback);

    void getGuildBindingInfo(long j3, IGProGetGuildBindingInfoCallback iGProGetGuildBindingInfoCallback);

    void getGuildBoundGroupsFirstPage(long j3, int i3, IGProGetGuildBoundGroupsFirstPageCallback iGProGetGuildBoundGroupsFirstPageCallback);

    void getGuildCheckinInfo(GProGuildCheckinReq gProGuildCheckinReq, IGProGuildCheckinCallback iGProGuildCheckinCallback);

    void getGuildCreatorTasks(long j3, boolean z16, IGProGetGuildCreatorTasksCallback iGProGetGuildCreatorTasksCallback);

    void getGuildFeedsValidCalendar(GProGuildSearchGetFeedCalendarReq gProGuildSearchGetFeedCalendarReq, IGProGuildGetFeedValidCalendarCallback iGProGuildGetFeedValidCalendarCallback);

    GProGlobalBanner getGuildGlobalBanner(long j3);

    void getGuildHomeCategories(GProGetGuildHomeCategoriesReq gProGetGuildHomeCategoriesReq, IGProGetGuildHomeCategoriesCallback iGProGetGuildHomeCategoriesCallback);

    void getGuildHomeSections(long j3, IGProGetGuildHomeSectionsCallback iGProGetGuildHomeSectionsCallback);

    GProGuild getGuildInfoFromCache(long j3);

    void getGuildLableInfo(GProGetGuildLabelReq gProGetGuildLabelReq, IGProGetGuildLableInfoCallback iGProGetGuildLableInfoCallback);

    ArrayList<GProGuild> getGuildListFromCache();

    void getGuildMainFrameHeaderInfo(long j3, IGProGetGuildMainFrameHeaderCallback iGProGetGuildMainFrameHeaderCallback);

    void getGuildMemberNum(long j3, IGProGetGuildMemberNumCallback iGProGetGuildMemberNumCallback);

    void getGuildNum(long j3, IGProGetGuildNumCallback iGProGetGuildNumCallback);

    ArrayList<Integer> getGuildPermission(long j3);

    void getGuildRecommend(byte[] bArr, int i3, IGProGetRecommendCallback iGProGetRecommendCallback);

    long getGuildRoleLimit(long j3);

    void getGuildShowWeakNotify(long j3, IGProGetGuildShowWeakNotifyCallback iGProGetGuildShowWeakNotifyCallback);

    GProSpeakPermissionInfo getGuildSpeakPermission(long j3, int i3);

    String getGuildUserAvatarPendantUrl(long j3);

    HashMap<Long, String> getGuildUserAvatarPendantUrls(ArrayList<Long> arrayList);

    String getGuildUserAvatarUrl(long j3, long j16, int i3);

    HashMap<Long, String> getGuildUserAvatarUrls(long j3, ArrayList<Long> arrayList, int i3);

    ArrayList<Long> getGuildUserChannelCategoryAdminList(long j3, long j16);

    HashMap<Long, ArrayList<Long>> getGuildUserChannelCategoryAdminLists(long j3, ArrayList<Long> arrayList);

    HashMap<Long, GProClientIdentity> getGuildUserClientIdentities(long j3, ArrayList<Long> arrayList);

    GProClientIdentity getGuildUserClientIdentity(long j3, long j16);

    String getGuildUserDisplayName(long j3, long j16);

    HashMap<Long, String> getGuildUserDisplayNames(long j3, ArrayList<Long> arrayList);

    int getGuildUserLevelRoleId(long j3, long j16);

    GProMedal getGuildUserMedal(long j3);

    HashMap<Long, GProMedal> getGuildUserMedals(ArrayList<Long> arrayList);

    String getGuildUserMemberName(long j3, long j16);

    HashMap<Long, String> getGuildUserMemberNames(long j3, ArrayList<Long> arrayList);

    String getGuildUserNickname(long j3);

    HashMap<Long, String> getGuildUserNicknames(ArrayList<Long> arrayList);

    long getGuildUserTopRoleId(long j3, long j16);

    void getGuildVerifyShareInfo(GProVerifyShareInfoReq gProVerifyShareInfoReq, IGuildVerifyShareInfoCallback iGuildVerifyShareInfoCallback);

    void getGuildsInContact(IGProGetGuildsInContactCallback iGProGetGuildsInContactCallback);

    void getHotLive(GProGetHotLiveReq gProGetHotLiveReq, IGProGetHotLiveCallback iGProGetHotLiveCallback);

    void getHotSearchWords(ArrayList<Integer> arrayList, int i3, IGProGetHotSearchWordsCallback iGProGetHotSearchWordsCallback);

    GProJumpToCategoryInfo getJumpToCategory(long j3);

    void getLabelGuilds(GetLabelGuildsReq getLabelGuildsReq, IGProGetLabelGuildsCallback iGProGetLabelGuildsCallback);

    void getLiveAudioPollingCtx(long j3, long j16, IGProGetLiveAudioPollingCtxCallback iGProGetLiveAudioPollingCtxCallback);

    void getLiveAudioPollingCtxV2(GProGetLiveAudioPollingInfoReq gProGetLiveAudioPollingInfoReq, IGProGetLiveAudioPollingCtxV2Callback iGProGetLiveAudioPollingCtxV2Callback);

    GProGuildRole getMemberLevelRoleInfo(long j3, long j16, long j17);

    GProGuildRole getMemberTopRoleInfo(long j3, long j16, long j17, long j18, int i3);

    GProCategoryChannelInfoList getMiniCategoryInfoFromCache(long j3, long j16);

    void getMoreNoticeList(int i3, long j3, int i16, IGProGetMoreNoticeListCallback iGProGetMoreNoticeListCallback);

    void getMsgNotifyMap(long j3, IGProGetMsgNotifyTypeCallback iGProGetMsgNotifyTypeCallback);

    void getMyTabContent(GProGetMyTabContentReq gProGetMyTabContentReq, IGProGetMyTabContentCallback iGProGetMyTabContentCallback);

    void getNavigation(GProGetNavigationReq gProGetNavigationReq, IGProGetNavigationCallback iGProGetNavigationCallback);

    void getNavigationStatus(GProGetNavigationStatusReq gProGetNavigationStatusReq, IGProGetNavigationStatusCallback iGProGetNavigationStatusCallback);

    GProOnlineMemberInfo getOnlineMemberInfo(long j3);

    void getOpenShareInfo(GproGetOpenShareInfoReq gproGetOpenShareInfoReq, IGProGetOpenShareInfoCallback iGProGetOpenShareInfoCallback);

    int getPermissionChangeFilter(long j3, long j16);

    ArrayList<GProPersonalSignatureTemplate> getPersonalSignatureTemplate();

    GProPollingChannelState getPollingCtx(long j3, long j16, int i3);

    void getPopupInfo(long j3, int i3, IGProGetPopupInfoCallback iGProGetPopupInfoCallback);

    void getPreviewNavigation(GProGetPreviewNavigationReq gProGetPreviewNavigationReq, IGProGetPreviewNavigationCallback iGProGetPreviewNavigationCallback);

    void getProfileSwitch(IGProGetProfileSwitchCallback iGProGetProfileSwitchCallback);

    GProQQMsgListChannel getQQMsgListChannel(long j3, long j16);

    ArrayList<GProQQMsgListChannel> getQQMsgListChannels();

    ArrayList<GProQQMsgListGuild> getQQMsgListGuilds();

    GProRecentVisitChannelList getRecentVisitChannelList(long j3);

    GProGetRecentVisitGuildInfosFromCacheRsp getRecentVisitGuildInfosListSync(int i3, int i16);

    void getRecommendForIntro(GetRecommendForIntroReq getRecommendForIntroReq, IGProGetRecommendForIntroCallback iGProGetRecommendForIntroCallback);

    void getRecommendGuildInfoFromCacheAsync(IGProGetRecommendGuildInfoCallback iGProGetRecommendGuildInfoCallback);

    void getRecommendQuickJoin(GProGetRecommendQuickJoinReq gProGetRecommendQuickJoinReq, IGProGetRecommendQuickJoinCallback iGProGetRecommendQuickJoinCallback);

    void getRecommendTabContent(GProGetRecommendTabContentReq gProGetRecommendTabContentReq, IGProGetRecommendTabContentCallback iGProGetRecommendTabContentCallback);

    void getRecommendTagList(GProGetRecommendTagListReq gProGetRecommendTagListReq, IGProGetRecommendTagListCallback iGProGetRecommendTagListCallback);

    void getRiskMemberRedPoint(GProGetRiskMemberRedPointReq gProGetRiskMemberRedPointReq, IGProGetRiskMemberRedPointCallback iGProGetRiskMemberRedPointCallback);

    GProGuildRole getRoleInfo(long j3, long j16);

    ArrayList<Integer> getRolePermission(long j3, long j16);

    void getRtmpPushUrl(IGProGetRtmpPushUrlCallback iGProGetRtmpPushUrlCallback);

    void getScheduleDetail(long j3, long j16, long j17, IGProGetScheduleDetailCallback iGProGetScheduleDetailCallback);

    void getScheduleList(long j3, long j16, long j17, IGProGetScheduleListCallback iGProGetScheduleListCallback);

    void getScheduleListNew(long j3, long j16, int i3, long j17, String str, IGProGetScheduleListNewCallback iGProGetScheduleListNewCallback);

    void getScheduleUsers(long j3, long j16, long j17, int i3, byte[] bArr, IGProGetScheduleUsersCallback iGProGetScheduleUsersCallback);

    void getSchedulesStatus(long j3, long j16, long j17, long j18, IGProGetSchedulesStatusCallback iGProGetSchedulesStatusCallback);

    void getSelectChannelIDs(GProGetSelectChannelIDReq gProGetSelectChannelIDReq, IGProGetSelectChannelIDsCallback iGProGetSelectChannelIDsCallback);

    int getSelfLiveChannelBanStatus(long j3, long j16);

    int getShareButtonFromCache(long j3, long j16, boolean z16);

    GProSimpleProfile getSimpleProfile(long j3, long j16, int i3);

    void getSimpleProfileAsync(GProGetSimpleProfileAsyncReq gProGetSimpleProfileAsyncReq, IGProGetSimpleProfileAsyncCallback iGProGetSimpleProfileAsyncCallback);

    ArrayList<Long> getSortedGuildIdsFromCache();

    ArrayList<GProGuild> getSortedGuildsFromCache();

    ArrayList<GProChannel> getSpecificTypeChannelList(long j3, int i3);

    ArrayList<Long> getToppedGuildIdsFromCache();

    void getUIData(String str, IGProGetUIDataCallback iGProGetUIDataCallback);

    void getUnBindClientService(byte[] bArr, IGProGetClientAccountCallback iGProGetClientAccountCallback);

    void getUnBindClientServiceV2(GProGetUnbindClientReq gProGetUnbindClientReq, IGProGetUnbindClientCallback iGProGetUnbindClientCallback);

    void getUserList(long j3, long j16, boolean z16, int i3, IGProGetUserListCallback iGProGetUserListCallback);

    void getUserLiveInfo(int i3, IGProGetUserLiveInfoCallback iGProGetUserLiveInfoCallback);

    boolean hasJoinChannelRole(long j3);

    void implantChatWindow(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void initGetNoticeList(int i3, long j3, boolean z16, IGProInitGetNoticeListCallback iGProInitGetNoticeListCallback);

    void inviteJoinSingleGuild(GProCmd0xf67ReqBody gProCmd0xf67ReqBody, IGProJoinGuildCallback iGProJoinGuildCallback);

    void inviteUserHandUpForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

    void inviteUserQueueForAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

    boolean isGuildMember(long j3);

    boolean isQQMsgListChannel(long j3, long j16);

    boolean isQQMsgListGuild(long j3);

    boolean isQQMsgListReady();

    void joinChannelByGuildTask(GProGuildTaskJoinChannelReq gProGuildTaskJoinChannelReq, IGProJoinChannelByGuildTaskCallback iGProJoinChannelByGuildTaskCallback);

    void kickAudioChannelUsers(long j3, long j16, ArrayList<Long> arrayList, IGProKickChannelMemberCallback iGProKickChannelMemberCallback);

    void kickGuildUser(long j3, ArrayList<Long> arrayList, boolean z16, GProRevokeOptions gProRevokeOptions, IGProResultCallback iGProResultCallback);

    void loadAllMemberList(long j3, long j16, IGProLoadAllMemberListCallback iGProLoadAllMemberListCallback);

    void loadGuildAndChannels(boolean z16, IGProLoadGuildAndChannelsCallback iGProLoadGuildAndChannelsCallback);

    void loadMemberListByIndex(long j3, long j16, long j17, IGProLoadMemberListByIndexCallback iGProLoadMemberListByIndexCallback);

    void loadMemberRoles(long j3, long j16, IGProLoadMemberRolesCallback iGProLoadMemberRolesCallback);

    void loadNextPageMemberList(long j3, long j16, boolean z16, byte[] bArr, int i3, IGProLoadNextPageMemberListCallback iGProLoadNextPageMemberListCallback);

    void loadPartRoleMemberList(long j3, IGProGetUserInfoCallback iGProGetUserInfoCallback);

    void loadUserInfo(long j3, ArrayList<Long> arrayList, IGProGetUserInfoCallback iGProGetUserInfoCallback);

    void loadUserList(long j3, long j16, IGProGetUserListCallback iGProGetUserListCallback);

    void loginLive(IGProSimpleResultCallback iGProSimpleResultCallback);

    void modifyScheduleInviteStatus(long j3, long j16, long j17, int i3, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback);

    void modifyScheduleInviteStatusV2(GProModifyScheduleInviteReq gProModifyScheduleInviteReq, IGProModifyScheduleInviteStatusCallback iGProModifyScheduleInviteStatusCallback);

    boolean onServerPushMsg(int i3, int i16, GProMsgRouttingHead gProMsgRouttingHead, byte[] bArr);

    void openAVLobbyApp(GProCreateLobbyReq gProCreateLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback);

    void popChatWindow(IGProSimpleResultCallback iGProSimpleResultCallback);

    void queryAVState(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void queryApplyAddGuildStatus(long j3, IGProResultCallback iGProResultCallback);

    void queryGuildEssence(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

    void queryGuildVisitor(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

    void queryRealNameAuthStatus(IGProSimpleResultCallback iGProSimpleResultCallback);

    void queryTinyIdByLiveUID(ArrayList<Long> arrayList, IGProQueryTinyIdByLiveUIDCallback iGProQueryTinyIdByLiveUIDCallback);

    void refreshAppChannelPreInfos(long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void refreshChannelInfo(long j3, long j16, int i3, boolean z16);

    void refreshGuildInfo(long j3, boolean z16, int i3);

    void refreshGuildInfoOnly(long j3, boolean z16, int i3);

    void refreshGuildList(boolean z16);

    void refreshGuildUserProfileInfo(long j3, long j16, int i3);

    void refreshPollingData(long j3, long j16, int i3);

    void removeBanBeforeBroadcast(long j3, long j16, IGProRemoveBanBeforeBroadcastCallback iGProRemoveBanBeforeBroadcastCallback);

    void removeChannel(GProRemoveChannelReq gProRemoveChannelReq, IGProResultCallback iGProResultCallback);

    void removeChannelCategoryWithId(long j3, long j16, boolean z16, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

    void removeGuild(long j3, IGProResultCallback iGProResultCallback);

    boolean removeGuildGlobalBanner(long j3);

    void removeGuildTaskCard(GProRemoveGuildTaskCardReq gProRemoveGuildTaskCardReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void removeKernelGuildListener(IKernelGuildListener iKernelGuildListener);

    void removeMemberFromGuildBlackList(long j3, ArrayList<Long> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

    void removeRiskMembers(GProRemoveRiskMembersReq gProRemoveRiskMembersReq, IGProRemoveRiskMembersCallback iGProRemoveRiskMembersCallback);

    void removeSpeakOrderByUser(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void reportAISearchRecommendWords(GProAISearchWordsReportReq gProAISearchWordsReportReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void reportAVState(GProAVReportReqInfo gProAVReportReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void reportCurrentGuild(long j3);

    void reportFeedShareData(long j3, long j16, int i3, GProFeedReportData gProFeedReportData, int i16, GProReportTarget gProReportTarget, IGProReportFeedShareDataCallback iGProReportFeedShareDataCallback);

    void reportFeedback(GProFeedbackReq gProFeedbackReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void reportJoinRecommendGuild(IGProReportJoinRecommendGuild iGProReportJoinRecommendGuild);

    void reportPreventAddictionInstructions(GProPAReportExecuteReq gProPAReportExecuteReq, IGProPAReportExecuteCallback iGProPAReportExecuteCallback);

    void reportShareAtta(GProReportShareAttaReq gProReportShareAttaReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void reportShareInfo(long j3, long j16, int i3, String str, int i16, IGProResultCallback iGProResultCallback);

    void reportUserViewGuild(ArrayList<String> arrayList, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void requestBeginBroadcast(long j3, long j16, long j17, int i3, GProProgrammeInfoReq gProProgrammeInfoReq, IGProResultCallback iGProResultCallback);

    void requestPubAccountMsgCount(IGProRequestPubAccountMsgCountCallback iGProRequestPubAccountMsgCountCallback);

    void riskMemberList(GProRiskMemberListReq gProRiskMemberListReq, IGProRiskMemberListCallback iGProRiskMemberListCallback);

    void saveCustomApplication(GProSaveCustomApplicationReq gProSaveCustomApplicationReq, IGProSaveCustomApplicationCallback iGProSaveCustomApplicationCallback);

    void saveGuidNavigation(GProSaveGuildNavigationReq gProSaveGuildNavigationReq, IGProSaveGuildNavigationCallback iGProSaveGuildNavigationCallback);

    void searchBlackUserFromServer(GProSearchBlackUserReq gProSearchBlackUserReq, IGProSearchBlackUserFromServerCallback iGProSearchBlackUserFromServerCallback);

    void searchChannelContent(long j3, long j16, String str, byte[] bArr, GProSearchType gProSearchType, GProSearchCond gProSearchCond, IGProSearchChannelContentCallback iGProSearchChannelContentCallback);

    void searchGuild(String str, byte[] bArr, int i3, int i16, int i17, IGProSearchGuildInfoCallback iGProSearchGuildInfoCallback);

    void searchGuildContent(GProGuildSearchNewSearchReq gProGuildSearchNewSearchReq, IGProGuildSearchCallback iGProGuildSearchCallback);

    void searchGuildFeeds(GProSearchGuildFeedsReq gProSearchGuildFeedsReq, IGProSearchChannelContentCallback iGProSearchChannelContentCallback);

    void searchGuildMembersBySourceId(GProGuildMemberSearchParams gProGuildMemberSearchParams, IGProSearchGuildMembersBySourceIdCallback iGProSearchGuildMembersBySourceIdCallback);

    void searchMsgSeqsFromServer(GProMsgSearchReq gProMsgSearchReq, IGProSearchMsgSeqsFromServerCallback iGProSearchMsgSeqsFromServerCallback);

    void searchUnion(String str, byte[] bArr, int i3, int i16, int i17, int i18, int i19, IGProSearchUnionCallback iGProSearchUnionCallback);

    void sendAudioOrLiveNotice(GProSendNoticeReq gProSendNoticeReq, IGProSendAudioOrLiveNoticeCallback iGProSendAudioOrLiveNoticeCallback);

    void sendChannelHeartbeat(GProHeartbeatReq gProHeartbeatReq);

    void sendDirectMsgReadReport(ArrayList<GProDirectMsgReport> arrayList);

    void sendOperationSaveMsg(GProSaveMsgReq gProSaveMsgReq, IGProSendOperationSaveMsgCallBack iGProSendOperationSaveMsgCallBack);

    void sendScheduleArkMessage(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<GProScheduleSendArkGuildInfo> arrayList3, GProScheduleSendArkGuildInfo gProScheduleSendArkGuildInfo, long j3, int i3, String str, String str2, String str3, byte[] bArr, IGProSendScheduleArkMessageCallback iGProSendScheduleArkMessageCallback);

    void setAVChannelInviteSpeakSwitch(long j3, long j16, GProInviteSpeakCfg gProInviteSpeakCfg, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setAVChannelSpeakMode(long j3, long j16, String str, GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg, IGProSetSpeakModeCallback iGProSetSpeakModeCallback);

    void setAVChannelSpeakOrder(long j3, long j16, GProVoiceQueueCfg gProVoiceQueueCfg, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setAddGuildOption(long j3, int i3, String str, String str2, IGProResultCallback iGProResultCallback);

    void setAnchorRoomInfo(GProAnchorSetRoomInfoReq gProAnchorSetRoomInfoReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setCategoryFolded(long j3, long j16, boolean z16, IGProResultCallback iGProResultCallback);

    void setChannelAuthControl(long j3, long j16, int i3, int i16, IGProResultCallback iGProResultCallback);

    void setChannelAuthControlMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, IGProResultCallback iGProResultCallback);

    void setChannelAuthControlRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, IGProResultCallback iGProResultCallback);

    void setChannelBannedSpeak(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelCategoryInfoWithId(long j3, GProCategoryChannelIdList gProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

    void setChannelCategoryOrder(GProSetCategoryOrderReq gProSetCategoryOrderReq, IGProSetCategoryOrderCallback iGProSetCategoryOrderCallback);

    void setChannelCategoryOrderWithId(long j3, ArrayList<Long> arrayList, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

    void setChannelCategoryWithId(long j3, long j16, long j17, IGProSetChannelCategoryInfoCallback iGProSetChannelCategoryInfoCallback);

    void setChannelHeartbeat(GProHeartbeatReq gProHeartbeatReq);

    void setChannelLiveable(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelLiveableMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setChannelLiveableRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setChannelMsgNotifyType(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelName(long j3, long j16, String str, IGProResultCallback iGProResultCallback);

    void setChannelSlowMode(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelSpeakable(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelSpeakableMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setChannelSpeakableRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setChannelSpeakerPerm(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelTopMsg(long j3, long j16, long j17, int i3, IGProSetChannelTopMsgCallback iGProSetChannelTopMsgCallback);

    void setChannelUserNumLimit(long j3, long j16, int i3, boolean z16, int i16, IGProResultCallback iGProResultCallback);

    void setChannelVisible(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void setChannelVisibleMemberList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setChannelVisibleRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setClientShowConfig(int i3, int i16, int i17, IGProSetClientShowConfigCallback iGProSetClientShowConfigCallback);

    void setDirectMsgBlack(long j3, boolean z16, IGProResultCallback iGProResultCallback);

    void setDirectMsgNotify(long j3, boolean z16, IGProResultCallback iGProResultCallback);

    void setDirectMsgNotifyForGuild(int i3, boolean z16, IGProResultCallback iGProResultCallback);

    void setDirectMsgStatus(int i3, int i16, IGProResultCallback iGProResultCallback);

    void setEnteredChannelState(long j3, long j16, boolean z16);

    void setFeedCommentsNotifySwitch(int i3, IGProSetFeedCommentsNotifySwitchCallback iGProSetFeedCommentsNotifySwitchCallback);

    void setGender(int i3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setGlobalPrivacySwitch(int i3, int i16, IGProGlobalPrivacySwitchCallback iGProGlobalPrivacySwitchCallback);

    void setGuildAdmin(long j3, long j16, boolean z16, IGProSetGuildAdminResultCallback iGProSetGuildAdminResultCallback);

    void setGuildAuditInfo(GProGuildAuditInfoReq gProGuildAuditInfoReq, IGProAuditInfoResultCallback iGProAuditInfoResultCallback);

    void setGuildBoundGroups(GProSortAndWriteBindGroupsReq gProSortAndWriteBindGroupsReq, IGProSetGuildBoundGroupsCallback iGProSetGuildBoundGroupsCallback);

    void setGuildClientId(long j3, int i3, IGProSetGuildClientIdCallback iGProSetGuildClientIdCallback);

    void setGuildCommonUnNotifyFlag(long j3, int i3, int i16, IGProSetGuildNotifyDisplayCallback iGProSetGuildNotifyDisplayCallback);

    void setGuildCoverFontColorId(long j3, int i3, IGProSetGuildCoverFontColorIdCallback iGProSetGuildCoverFontColorIdCallback);

    void setGuildCreatorTaskSkipStatus(long j3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setGuildGlobalBanner(GProGlobalBannerRep gProGlobalBannerRep, IGProGlobalBannerCallback iGProGlobalBannerCallback);

    void setGuildGlobalPermission(GProSetGlobalPermissionReq gProSetGlobalPermissionReq, IGProResultCallback iGProResultCallback);

    void setGuildListSort(ArrayList<Long> arrayList, IGProSetGuildListSortCallback iGProSetGuildListSortCallback);

    void setGuildListTop(long j3, int i3, int i16, IGProSetGuildListTopCallback iGProSetGuildListTopCallback);

    void setGuildMemberName(long j3, String str, String str2, IGProResultCallback iGProResultCallback);

    void setGuildName(long j3, String str, IGProResultCallback iGProResultCallback);

    void setGuildNeedRealNameForVisitor(long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setGuildNumSearchSwitch(long j3, int i3, IGProResultCallback iGProResultCallback);

    void setGuildProfile(long j3, String str, IGProResultCallback iGProResultCallback);

    void setGuildQRCodePeriod(long j3, int i3, IGProResultCallback iGProResultCallback);

    void setGuildQRCodeSwitch(long j3, int i3, IGProResultCallback iGProResultCallback);

    void setGuildShutUp(long j3, long j16, IGProResultCallback iGProResultCallback);

    void setGuildSpeakableMemberList(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setGuildSpeakableRoleList(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setGuildSpeakableRule(long j3, GproGuildSpeakableRule gproGuildSpeakableRule, IGProResultCallback iGProResultCallback);

    void setGuildSpeakableThreshold(long j3, GProGuildSpeakableThreshold gProGuildSpeakableThreshold, IGProResultCallback iGProResultCallback);

    void setGuildTop(long j3, boolean z16, IGProResultCallback iGProResultCallback);

    void setGuildUnNotifyFlag(long j3, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback);

    void setGuildVisibilityForVisitor(long j3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setGuildWeakNotifyDisplay(long j3, int i3, IGProSetGuildWeakNotifyDisplayCallback iGProSetGuildWeakNotifyDisplayCallback);

    void setHeader(String str, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setJoinGuildOption(GProSetJoinGuildOptionReq gProSetJoinGuildOptionReq, IGProResultCallback iGProResultCallback);

    void setJumpToCategory(GProJumpToCategoryInfo gProJumpToCategoryInfo, IGProResultCallback iGProResultCallback);

    void setListenTogetherPlayOpt(long j3, long j16, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback);

    void setListenTogetherPlayVolumeByAdmin(long j3, long j16, int i3, IGProListenTogetherPlayListOptCallback iGProListenTogetherPlayListOptCallback);

    void setLiveChannelAnchorList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setLiveChannelBannedUser(long j3, long j16, long j17, long j18, int i3, IGProResultCallback iGProResultCallback);

    void setLocation(GProLocation gProLocation, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setMemberRoles(long j3, long j16, long j17, long j18, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setMemberShutUp(long j3, long j16, long j17, IGProResultCallback iGProResultCallback);

    void setMyBirthday(short s16, short s17, short s18, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setMyPersonalSignature(String str, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setMyProfileShowTypeSwitch(long j3, int i3, int i16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setMyVoiceNetworkQuality(long j3, long j16, int i3);

    void setMyVoiceSysMicStatus(long j3, long j16, int i3);

    void setNickName(String str, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setOnLogin();

    void setPerformanceEnable(boolean z16);

    void setProfileSwitch(int i3, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void setQQMsgListChannel(long j3, long j16, int i3, IGProSetQQMsgListChannelCallback iGProSetQQMsgListChannelCallback);

    void setQQMsgListGuild(long j3, int i3, int i16, IGProSetQQMsgListGuildCallback iGProSetQQMsgListGuildCallback);

    void setRoleChannels(long j3, long j16, int i3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProSetRoleChannelsCallback iGProSetRoleChannelsCallback);

    void setRoleInfo(long j3, long j16, GProRoleCreateInfo gProRoleCreateInfo, IGProResultCallback iGProResultCallback);

    void setRoleMembers(long j3, long j16, long j17, long j18, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, IGProResultCallback iGProResultCallback);

    void setRoleOrder(long j3, ArrayList<Long> arrayList, IGProResultCallback iGProResultCallback);

    void setScreenSharedInGuild(long j3, long j16, boolean z16, IGProScreenShareCallback iGProScreenShareCallback);

    void setSearchSwitch(GProSetSearchSwitchReq gProSetSearchSwitchReq, IGProSetSearchSwitchCallback iGProSetSearchSwitchCallback);

    void setSelfTinyId(long j3);

    void setShowArchive(int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback);

    void setShowPresence(int i3, boolean z16, IGProSwitchPresenceArchiveCallback iGProSwitchPresenceArchiveCallback);

    void setTopicSquareEntranceSwitch(long j3, boolean z16, IGProResultCallback iGProResultCallback);

    void setUIData(String str, String str2);

    void setUserLiveInfo(int i3, String str, String str2, int i16, IGProSetUserLiveInfoCallback iGProSetUserLiveInfoCallback);

    void setUserMuteSeatInGuild(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback);

    void setUserPermissionInGuild(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback);

    void setUserScreenSharedInGuild(long j3, long j16, long j17, boolean z16, IGProResultCallback iGProResultCallback);

    void setUserType(String str, IGProUserTypeSetCallback iGProUserTypeSetCallback);

    void setUserTypeWithUserConfigure(boolean z16, IGProUserTypeSetCallback iGProUserTypeSetCallback);

    void setUserVoicelessToMe(long j3, boolean z16, IGProResultCallback iGProResultCallback);

    void setWindowFliter(ArrayList<Long> arrayList, IGProSimpleResultCallback iGProSimpleResultCallback);

    void startAnchorBroadcast(long j3, long j16, String str, String str2, int i3, IGProSimpleResultCallback iGProSimpleResultCallback);

    void startHeartbeat(long j3, long j16);

    void startPollingForDiscoverState();

    void startPush(IGProSimpleResultCallback iGProSimpleResultCallback);

    void stopPollingForDiscoverState(boolean z16);

    void subscribePolling(long j3, int i3);

    void subscribePollingChannels(ArrayList<GProPollingInfo> arrayList);

    void subscribePollingSchedule(GProSubscribePollingScheduleReq gProSubscribePollingScheduleReq);

    void superAdminBanUser(GProSuperAdminBanUserReq gProSuperAdminBanUserReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void superAdminUnListFeed(GProCmd0x92331SuperAdminUnListFeedReq gProCmd0x92331SuperAdminUnListFeedReq, IGProSuperAdminUnListFeedCallback iGProSuperAdminUnListFeedCallback);

    void switchAVLobbyApp(GProSwitchLobbyReq gProSwitchLobbyReq, IGProCreateLobbyCallback iGProCreateLobbyCallback);

    void terminateLiveStream(long j3, long j16, int i3, int i16, IGProTerminateLiveStreamCallback iGProTerminateLiveStreamCallback);

    void topSpeakOrderByAdmin(GProAdminAVReqInfo gProAdminAVReqInfo, IGProAdminDealResultCallback iGProAdminDealResultCallback);

    void transThirdPlatformURL(GProTransThirdPlatformURLReq gProTransThirdPlatformURLReq, IGProTransThirdPlatformURLCallback iGProTransThirdPlatformURLCallback);

    void transThirdVideoURL(GProTransThirdVideoURLReq gProTransThirdVideoURLReq, IGProTransThirdVideoURLCallback iGProTransThirdVideoURLCallback);

    void transferGuildOwner(GProTransferGuildOwnerReq gProTransferGuildOwnerReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void tryUnmuteMicrophone(long j3, long j16, boolean z16, IGProSimpleResultCallback iGProSimpleResultCallback);

    void ubSubscribePollingChannels(ArrayList<GProPollingInfo> arrayList);

    void unsubscribePolling(long j3);

    void updateArchiveShowSeq(ArrayList<Integer> arrayList, IGProUpdateArchiveShowSeqCallback iGProUpdateArchiveShowSeqCallback);

    void updateAudioLiveChannelTheme(GProUpdateChannelThemeReq gProUpdateChannelThemeReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void updateForumChannelSortMode(long j3, long j16, int i3, IGProResultCallback iGProResultCallback);

    void updateGuildEssence(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

    void updateGuildTaskCardProgress(GProUpdateGuildTaskCardProgressReq gProUpdateGuildTaskCardProgressReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void updateGuildVisitor(GProGuildEssenceSvrReq gProGuildEssenceSvrReq, IGProGuildEssenceCallBack iGProGuildEssenceCallBack);

    void upgradeGroupFeed(ArrayList<Long> arrayList, int i3, IGProUpgradeGroupCallback iGProUpgradeGroupCallback);

    void userDealSpeakInvitation(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void userHandUp(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void userOnlineReport(GProGuildOnlineReportReq gProGuildOnlineReportReq, IGProUserOnlineReportCallback iGProUserOnlineReportCallback);

    void userShareScreen(GProUserAVReqInfo gProUserAVReqInfo, IGProUserAVOptCallback iGProUserAVOptCallback);

    void voiceChannelAuth0x10b6(long j3, long j16, int i3, boolean z16, int i16, IGProVoiceChannelAuthCallback iGProVoiceChannelAuthCallback);

    void voiceSmobaGameCreateRoom(GProVoiceSmobaGameBaseRoomParams gProVoiceSmobaGameBaseRoomParams, GProVoiceSmobaGameSmobaRoomParams gProVoiceSmobaGameSmobaRoomParams, IGProVoiceSmobaGameCreateRoomCallback iGProVoiceSmobaGameCreateRoomCallback);

    void voiceSmobaGameDissmissRoom(GProVoiceSmobaGameDissmissRoomReq gProVoiceSmobaGameDissmissRoomReq, IGProSimpleResultCallback iGProSimpleResultCallback);

    void voiceSmobaGameEnterRoom(long j3, int i3, long j16, long j17, IGProVoiceSmobaGameEnterRoomCallback iGProVoiceSmobaGameEnterRoomCallback);

    void voiceSmobaGameKickOutRoom(GProVoiceSmobaGameKickOutRoomReq gProVoiceSmobaGameKickOutRoomReq, IGProVoiceSmobaKickOutRoomCallback iGProVoiceSmobaKickOutRoomCallback);

    void voiceSmobaGameQuitRoom(GProVoiceSmobaGameQuitRoomReq gProVoiceSmobaGameQuitRoomReq, IGProVoiceSmobaGameQuitRoomCallback iGProVoiceSmobaGameQuitRoomCallback);
}
