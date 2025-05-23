package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGroupService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelGroupService {
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

        private native void nativeDestroy(long j3);

        private native void native_addGroupEssence(long j3, DigestReq digestReq, IDigestCallback iDigestCallback);

        private native long native_addKernelGroupListener(long j3, IKernelGroupListener iKernelGroupListener);

        private native void native_applyTeamUp(long j3, TeamUpApplyReq teamUpApplyReq, IOperateCallback iOperateCallback);

        private native void native_batchQueryCachedGroupDetailInfo(long j3, BatchQueryCachedGroupDetailInfoReq batchQueryCachedGroupDetailInfoReq, IBatchQueryCachedGroupDetailInfoCallback iBatchQueryCachedGroupDetailInfoCallback);

        private native void native_changeGroupShieldSettingTemp(long j3, long j16, boolean z16, IOperateCallback iOperateCallback);

        private native void native_checkGroupMemberCache(long j3, ArrayList<Long> arrayList, IGroupMemberCacheCallback iGroupMemberCacheCallback);

        private native void native_cleanCapsuleCache(long j3, long j16);

        private native void native_clearGroupNotifies(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_clearGroupNotifiesUnreadCount(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_clearGroupNotifyLocalUnreadCount(long j3, boolean z16, int i3, IOperateCallback iOperateCallback);

        private native void native_clearGroupSquareRedpointCache(long j3, long j16);

        private native void native_consumeGroupTopBanner(long j3, ConsumeGroupTopBannerReq consumeGroupTopBannerReq, IOperateCallback iOperateCallback);

        private native void native_createGroup(long j3, ArrayList<InviteMemberInfo> arrayList, ICreateGroupCallback iCreateGroupCallback);

        private native void native_createGroupProfileShare(long j3, CreateGroupProfileShareReq createGroupProfileShareReq, ICreateGroupProfileShareCallback iCreateGroupProfileShareCallback);

        private native void native_createGroupV2(long j3, CreateGroupReq createGroupReq, ArrayList<InviteMemberInfo> arrayList, ICreateGroupCallback iCreateGroupCallback);

        private native void native_createGroupWithMembers(long j3, String str, ArrayList<String> arrayList, ICreateGroupCallback iCreateGroupCallback);

        private native String native_createMemberListScene(long j3, long j16, String str);

        private native void native_deleteGroupBulletin(long j3, long j16, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_deleteTeamUp(long j3, DeleteTeamUpReq deleteTeamUpReq, IOperateCallback iOperateCallback);

        private native void native_destroyGroup(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_destroyGroupV2(long j3, DestroyGroupReq destroyGroupReq, IOperateCallback iOperateCallback);

        private native void native_destroyMemberListScene(long j3, String str);

        private native void native_downloadGroupBulletinRichMedia(long j3, BulletinFeedsRichMediaDownloadReq bulletinFeedsRichMediaDownloadReq);

        private native void native_fetchGroupEssenceList(long j3, FetchGroupEssenceListReq fetchGroupEssenceListReq, String str, IFetchGroupEssenceListCallback iFetchGroupEssenceListCallback);

        private native void native_fetchGroupNotify(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getAICommonVoice(long j3, GetVoiceReq getVoiceReq, IGetVoiceCallback iGetVoiceCallback);

        private native void native_getAIOBindGuildInfo(long j3, GetAIOBindGuildInfoReq getAIOBindGuildInfoReq, IGetAIOBindGuildInfoCallback iGetAIOBindGuildInfoCallback);

        private native void native_getAllGroupPrivilegeFlag(long j3, ArrayList<Long> arrayList, int i3, IGroupPrivilegeFlagCallback iGroupPrivilegeFlagCallback);

        private native void native_getAllMemberList(long j3, long j16, boolean z16, IGroupMemberListCallback iGroupMemberListCallback);

        private native void native_getAllMemberListV2(long j3, long j16, boolean z16, IGroupMemberListCallback iGroupMemberListCallback);

        private native void native_getAppCenter(long j3, GetAppCenterReq getAppCenterReq, IGetAppCenterCallback iGetAppCenterCallback);

        private native void native_getCapsuleApp(long j3, GetCapsuleAppReq getCapsuleAppReq, boolean z16, IGetCapsuleAppCallback iGetCapsuleAppCallback);

        private native void native_getCapsuleAppPro(long j3, GetCapsuleAppReq getCapsuleAppReq, boolean z16, IGetCapsuleAppProCallback iGetCapsuleAppProCallback);

        private native void native_getCardAppList(long j3, GetCardAppListReq getCardAppListReq, boolean z16, IGetCardAppListCallback iGetCardAppListCallback);

        private native void native_getDiscussExistInfo(long j3, long j16, IDiscussSimpleInfoCallback iDiscussSimpleInfoCallback);

        private native void native_getGroupAllInfo(long j3, long j16, GroupInfoSource groupInfoSource, IOperateCallback iOperateCallback);

        private native void native_getGroupArkInviteState(long j3, long j16, long j17, long j18, IOperateCallback iOperateCallback);

        private native void native_getGroupAvatarWall(long j3, long j16, IGroupAvatarWallCallback iGroupAvatarWallCallback);

        private native void native_getGroupBindGuilds(long j3, GetGroupBindGuildsReq getGroupBindGuildsReq, IGetGroupBindGuildsCallback iGetGroupBindGuildsCallback);

        private native void native_getGroupBulletin(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_getGroupBulletinList(long j3, long j16, String str, String str2, GroupBulletinListReq groupBulletinListReq, IOperateCallback iOperateCallback);

        private native void native_getGroupConfMember(long j3, long j16, boolean z16, IOperateCallback iOperateCallback);

        private native int native_getGroupDBVersion(long j3, int i3);

        private native void native_getGroupDetailInfo(long j3, long j16, GroupInfoSource groupInfoSource, IOperateCallback iOperateCallback);

        private native void native_getGroupDetailInfoByFilter(long j3, GroupDetailInfoReq groupDetailInfoReq, int i3, int i16, boolean z16, IGroupDetailInfoCallback iGroupDetailInfoCallback);

        private native void native_getGroupDetailInfoForMqq(long j3, long j16, int i3, int i16, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getGroupExt0xEF0Info(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, GroupExtFilter groupExtFilter, boolean z16, IGroupExt0xEF0InfoCallback iGroupExt0xEF0InfoCallback);

        private native void native_getGroupExtList(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getGroupFlagForThirdApp(long j3, ArrayList<Long> arrayList, IGetGroupFlagForThirdAppCallback iGetGroupFlagForThirdAppCallback);

        private native void native_getGroupHonorList(long j3, GroupMemberHonorReq groupMemberHonorReq, IGroupMemberHonorCallback iGroupMemberHonorCallback);

        private native void native_getGroupInfoForJoinGroup(long j3, long j16, boolean z16, int i3, IGroupInfoForJoinCallback iGroupInfoForJoinCallback);

        private native void native_getGroupInviteNoAuthLimitNum(long j3, ArrayList<Long> arrayList, IGetGroupInviteNoAuthLimitNumCallback iGetGroupInviteNoAuthLimitNumCallback);

        private native void native_getGroupLatestEssenceList(long j3, GetGroupLatestEssenceListReq getGroupLatestEssenceListReq, IGetGroupLatestEssenceListCallback iGetGroupLatestEssenceListCallback);

        private native void native_getGroupList(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getGroupMedalList(long j3, GetGroupMedalListReq getGroupMedalListReq, IGetGroupMedalListCallback iGetGroupMedalListCallback);

        private native void native_getGroupMemberLevelInfo(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_getGroupMemberMaxNum(long j3, long j16, int i3, IGroupMemberMaxNumCallback iGroupMemberMaxNumCallback);

        private native void native_getGroupMsgLimitFreq(long j3, long j16, IGroupMsgLimitFreqCallback iGroupMsgLimitFreqCallback);

        private native void native_getGroupMsgMask(long j3, IOperateCallback iOperateCallback);

        private native void native_getGroupNotifiesUnreadCount(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getGroupPayToJoinStatus(long j3, long j16, IGroupPayToJoinStatusCallback iGroupPayToJoinStatusCallback);

        private native void native_getGroupPlusAppList(long j3, GetAppListReq getAppListReq, IGetAppListCallback iGetAppListCallback);

        private native void native_getGroupPortrait(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_getGroupRecommendContactArkJson(long j3, long j16, IGetGroupRecommendContactArkJsonCallback iGetGroupRecommendContactArkJsonCallback);

        private native void native_getGroupRemainAtTimes(long j3, long j16, IGetGroupRemainAtAllTimesOperateCallback iGetGroupRemainAtAllTimesOperateCallback);

        private native void native_getGroupSecLevelInfo(long j3, long j16, int i3, IGroupSecLevelInfoCallback iGroupSecLevelInfoCallback);

        private native void native_getGroupSeqAndJoinTimeForGrayTips(long j3, long j16, IGroupInfoForGrayTipsCallback iGroupInfoForGrayTipsCallback);

        private native void native_getGroupShutUpMemberList(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_getGroupSquareHomeHead(long j3, long j16, String str, IGetHomeHeadCallback iGetHomeHeadCallback);

        private native void native_getGroupSquareRedpointInfo(long j3, GetGroupSquareRedpointInfoReq getGroupSquareRedpointInfoReq, boolean z16, IGetGroupSquareRedpointInfoCallback iGetGroupSquareRedpointInfoCallback);

        private native void native_getGroupStatisticInfo(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_getGroupTagRecords(long j3, long j16, IGroupTagRecordCallback iGroupTagRecordCallback);

        private native void native_getIdentityList(long j3, GetIdentityListReq getIdentityListReq, IGetIdentityListCallback iGetIdentityListCallback);

        private native void native_getIllegalMemberList(long j3, long j16, IGroupMemberIllegalInfoCallback iGroupMemberIllegalInfoCallback);

        private native void native_getJoinGroupLink(long j3, GroupLinkReq groupLinkReq, IGetJoinGroupLinkCallback iGetJoinGroupLinkCallback);

        private native void native_getJoinGroupNoVerifyFlag(long j3, long j16, String str, IOperateCallback iOperateCallback);

        private native void native_getMemberCommonInfo(long j3, GroupMemberCommonReq groupMemberCommonReq, IGroupMemberCommonCallback iGroupMemberCommonCallback);

        private native void native_getMemberExtInfo(long j3, GroupMemberExtReq groupMemberExtReq, IGroupMemberExtCallback iGroupMemberExtCallback);

        private native void native_getMemberInfo(long j3, long j16, ArrayList<String> arrayList, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getMemberInfoForMqq(long j3, long j16, ArrayList<String> arrayList, boolean z16, IGroupMemberListCallback iGroupMemberListCallback);

        private native void native_getMemberInfoForMqqV2(long j3, long j16, ArrayList<String> arrayList, boolean z16, String str, IGroupMemberListCallback iGroupMemberListCallback);

        private native void native_getNextMemberList(long j3, String str, GroupMemberInfoListId groupMemberInfoListId, int i3, IGroupMemberListCallback iGroupMemberListCallback);

        private native void native_getPrevMemberList(long j3, String str, GroupMemberInfoListId groupMemberInfoListId, int i3, IGroupMemberListCallback iGroupMemberListCallback);

        private native void native_getRecGroups(long j3, long j16, GroupSquareTabItem groupSquareTabItem, String str, IGetRecGroupsCallback iGetRecGroupsCallback);

        private native void native_getSingleScreenNotifies(long j3, boolean z16, long j16, int i3, IOperateCallback iOperateCallback);

        private native void native_getSingleScreenNotifiesV2(long j3, boolean z16, long j16, int i3, int i16, IGetGroupSingleScreenNotifiesCallback iGetGroupSingleScreenNotifiesCallback);

        private native void native_getSubGroupInfo(long j3, GetSubGroupInfoReq getSubGroupInfoReq, IGetSubGroupInfoCallback iGetSubGroupInfoCallback);

        private native void native_getSwitchStatusForEssenceMsg(long j3, long j16, IGroupEssenceMsgSwitchCallback iGroupEssenceMsgSwitchCallback);

        private native void native_getTeamUpDetail(long j3, GetTeamUpDetailReq getTeamUpDetailReq, IGetTeamUpDetailCallback iGetTeamUpDetailCallback);

        private native void native_getTeamUpList(long j3, GetTeamUpListReq getTeamUpListReq, IGetTeamUpListCallback iGetTeamUpListCallback);

        private native void native_getTeamUpMembers(long j3, GetTeamUpMembersReq getTeamUpMembersReq, IGetTeamUpMembersCallback iGetTeamUpMembersCallback);

        private native void native_getTeamUpTemplateList(long j3, GetTeamUpTemplateListReq getTeamUpTemplateListReq, IGetTeamUpTemplateListCallback iGetTeamUpTemplateListCallback);

        private native void native_getTopicPage(long j3, long j16, long j17, String str, String str2, IGetTopicPageCallback iGetTopicPageCallback);

        private native void native_getTopicRecall(long j3, TopicRecallReq topicRecallReq, ITopicRecallCallback iTopicRecallCallback);

        private native void native_getTransferableMemberInfo(long j3, long j16, IGetTransferableMemberCallback iGetTransferableMemberCallback);

        private native void native_getUidByUins(long j3, ArrayList<Long> arrayList, IGroupMemberUidCallback iGroupMemberUidCallback);

        private native void native_getUinByUids(long j3, ArrayList<String> arrayList, IGroupMemberUinCallback iGroupMemberUinCallback);

        private native void native_getWxNotifyStatus(long j3, ArrayList<Long> arrayList, IGetGroupWxNotifyStatusCallback iGetGroupWxNotifyStatusCallback);

        private native void native_groupBlacklistDelApply(long j3, GroupBlacklistDelApplyReq groupBlacklistDelApplyReq, IGroupBlacklistDelApplyCallback iGroupBlacklistDelApplyCallback);

        private native void native_groupBlacklistGetAllApply(long j3, GroupBlacklistGetAllApplyReq groupBlacklistGetAllApplyReq, IGroupBlacklistGetAllApplyCallback iGroupBlacklistGetAllApplyCallback);

        private native void native_halfScreenPullNotice(long j3, HalfScreenPullNoticeReq halfScreenPullNoticeReq, IHalfScreenPullNoticeCallback iHalfScreenPullNoticeCallback);

        private native void native_halfScreenReportClick(long j3, HalfScreenReportClickReq halfScreenReportClickReq, IOperateCallback iOperateCallback);

        private native void native_inviteMembersToGroup(long j3, long j16, HashMap<String, Long> hashMap, IOperateCallback iOperateCallback);

        private native void native_inviteMembersToGroupWithMsg(long j3, long j16, HashMap<String, Long> hashMap, ArrayList<ShareMsgInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_inviteToGroup(long j3, long j16, ArrayList<String> arrayList, IOperateCallback iOperateCallback);

        private native void native_inviteToGroupV2(long j3, InviteGroupReq inviteGroupReq, IInviteToGroupCallback iInviteToGroupCallback);

        private native void native_isEssenceMsg(long j3, EssenceKey essenceKey, ICheckEssenceCallback iCheckEssenceCallback);

        private native void native_joinGroup(long j3, ReqToGroup reqToGroup, IJoinGroupCallback iJoinGroupCallback);

        private native void native_kickMember(long j3, long j16, ArrayList<String> arrayList, boolean z16, String str, IKickMemberOperateCallback iKickMemberOperateCallback);

        private native void native_kickMemberV2(long j3, KickMemberReq kickMemberReq, IKickMemberCallback iKickMemberCallback);

        private native void native_listAllAIVoice(long j3, ListAllVoiceReq listAllVoiceReq, IListAllVoiceCallback iListAllVoiceCallback);

        private native void native_miniAppGetGroupInfo(long j3, MiniAppGetGroupInfoReq miniAppGetGroupInfoReq, IMiniAppGetGroupInfoCallback iMiniAppGetGroupInfoCallback);

        private native void native_modifyGroupDetailInfo(long j3, long j16, GroupModifyInfo groupModifyInfo, IOperateCallback iOperateCallback);

        private native void native_modifyGroupDetailInfoV2(long j3, GroupModifyInfoReq groupModifyInfoReq, int i3, IOperateCallback iOperateCallback);

        private native void native_modifyGroupExtInfo(long j3, GroupExtInfo groupExtInfo, IOperateCallback iOperateCallback);

        private native void native_modifyGroupExtInfoV2(long j3, GroupExtInfo groupExtInfo, GroupExtFilter groupExtFilter, IModifyGroupExtCallback iModifyGroupExtCallback);

        private native void native_modifyGroupName(long j3, long j16, String str, boolean z16, IOperateCallback iOperateCallback);

        private native void native_modifyGroupRemark(long j3, long j16, String str, IOperateCallback iOperateCallback);

        private native void native_modifyMemberCardName(long j3, long j16, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_modifyMemberRole(long j3, long j16, String str, MemberRole memberRole, IOperateCallback iOperateCallback);

        private native void native_modifyWxNotifyStatus(long j3, long j16, GroupWxNotifyStatus groupWxNotifyStatus, IOperateCallback iOperateCallback);

        private native void native_monitorMemberList(long j3, String str, GroupMemberInfoListId groupMemberInfoListId, GroupMemberInfoListId groupMemberInfoListId2);

        private native void native_operateSysNotify(long j3, boolean z16, GroupNotifyOperateMsg groupNotifyOperateMsg, IOperateCallback iOperateCallback);

        private native void native_operateSysNotifyV2(long j3, boolean z16, GroupNotifyOperateMsg groupNotifyOperateMsg, IGroupNotifyOperateCallback iGroupNotifyOperateCallback);

        private native void native_postTeamUp(long j3, PostTeamUpReq postTeamUpReq, IPostTeamUpCallback iPostTeamUpCallback);

        private native void native_publishGroupBulletin(long j3, long j16, String str, GroupBulletinPublishReq groupBulletinPublishReq, IOperateCallback iOperateCallback);

        private native void native_publishInstructionForNewcomers(long j3, long j16, String str, GroupBulletinPublishReq groupBulletinPublishReq, IOperateCallback iOperateCallback);

        private native void native_queryAIOBindGuild(long j3, QueryAIOBindGuildReq queryAIOBindGuildReq, IQueryAIOBindGuildCallback iQueryAIOBindGuildCallback);

        private native void native_queryCachedEssenceMsg(long j3, EssenceKey essenceKey, IQueryCachedEssenceCallback iQueryCachedEssenceCallback);

        private native void native_queryGroupTopBanners(long j3, QueryGroupTopBannersReq queryGroupTopBannersReq, IQueryGroupTopBannersCallback iQueryGroupTopBannersCallback);

        private native void native_queryJoinGroupCanNoVerify(long j3, JoinGroupVerifyReq joinGroupVerifyReq, IJoinGroupVerifyCallback iJoinGroupVerifyCallback);

        private native void native_quitGroup(long j3, long j16, IOperateCallback iOperateCallback);

        private native void native_quitGroupV2(long j3, QuitGroupReq quitGroupReq, IOperateCallback iOperateCallback);

        private native void native_removeGroupEssence(long j3, DigestReq digestReq, IDigestCallback iDigestCallback);

        private native void native_removeGroupFromGroupList(long j3, long j16);

        private native void native_removeKernelGroupListener(long j3, long j16);

        private native void native_reqToJoinGroup(long j3, ReqToGroup reqToGroup, IOperateCallback iOperateCallback);

        private native void native_saveAIVoice(long j3, SaveVoiceReq saveVoiceReq, ISaveVoiceCallback iSaveVoiceCallback);

        private native void native_searchMember(long j3, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_setAIOBindGuild(long j3, SetAIOBindGuildReq setAIOBindGuildReq, ISetAIOBindGuildCallback iSetAIOBindGuildCallback);

        private native void native_setActiveExtGroup(long j3, ActiveExtGroupReq activeExtGroupReq, IOperateCallback iOperateCallback);

        private native void native_setCapsuleSwitch(long j3, SetCapsuleSwitchReq setCapsuleSwitchReq, IOperateCallback iOperateCallback);

        private native void native_setGroupAppList(long j3, SetGroupAppListReq setGroupAppListReq, IOperateCallback iOperateCallback);

        private native void native_setGroupGeoInfo(long j3, GroupGeoInfoReq groupGeoInfoReq, IOperateCallback iOperateCallback);

        private native void native_setGroupMsgMask(long j3, long j16, GroupMsgMask groupMsgMask, IOperateCallback iOperateCallback);

        private native void native_setGroupMsgMaskV2(long j3, SetGroupMsgMaskReq setGroupMsgMaskReq, int i3, ISetGroupMsgMaskCallback iSetGroupMsgMaskCallback);

        private native void native_setGroupRelationToGuild(long j3, SetGroupRelationToGuildReq setGroupRelationToGuildReq, ISetGroupRelationToGuildCallback iSetGroupRelationToGuildCallback);

        private native void native_setGroupShutUp(long j3, long j16, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setIdentityInteractionTag(long j3, SetIdentityInteractionTagReq setIdentityInteractionTagReq, IOperateCallback iOperateCallback);

        private native void native_setIdentityTitleInfo(long j3, SetIdentityTitleInfoReq setIdentityTitleInfoReq, IOperateCallback iOperateCallback);

        private native void native_setMemberShutUp(long j3, long j16, ArrayList<GroupMemberShutUpInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_setRcvJoinVerifyMsg(long j3, RcvJoinVerifyMsgReq rcvJoinVerifyMsgReq, IRcvJoinVerifyMsgCallback iRcvJoinVerifyMsgCallback);

        private native void native_setTop(long j3, long j16, boolean z16, IOperateCallback iOperateCallback);

        private native void native_shareTopic(long j3, ShareTopicReq shareTopicReq, IShareTopicCallback iShareTopicCallback);

        private native void native_teamUpCreateGroup(long j3, TeamUpCreateGroupReq teamUpCreateGroupReq, ITeamUpCreateGroupCallback iTeamUpCreateGroupCallback);

        private native void native_teamUpInviteToGroup(long j3, TeamUpInviteToGroupReq teamUpInviteToGroupReq, IOperateCallback iOperateCallback);

        private native void native_teamUpRequestToJoin(long j3, TeamUpRequestToJoinReq teamUpRequestToJoinReq, ITeamUpRequestToJoinCallback iTeamUpRequestToJoinCallback);

        private native void native_teamUpSubmitDeadline(long j3, TeamUpSubmitDeadlineReq teamUpSubmitDeadlineReq, IOperateCallback iOperateCallback);

        private native void native_topicFeedback(long j3, TopicFeedbackReq topicFeedbackReq, IOperateCallback iOperateCallback);

        private native void native_topicReport(long j3, TopicReportReq topicReportReq, ITopicReportCallback iTopicReportCallback);

        private native void native_transferGroup(long j3, long j16, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_transferGroupV2(long j3, long j16, String str, String str2, ITransferGroupCallback iTransferGroupCallback);

        private native void native_unbindAllGuilds(long j3, UnbindAllGuildsReq unbindAllGuildsReq, IUnbindAllGuildsCallback iUnbindAllGuildsCallback);

        private native void native_updateGroupInfoByMqq(long j3, GroupInfoCacheReq groupInfoCacheReq);

        private native void native_updateMemberInfoByMqq(long j3, GroupMemberCacheReq groupMemberCacheReq);

        private native void native_updateTeamUp(long j3, UpdateTeamUpReq updateTeamUpReq, IOperateCallback iOperateCallback);

        private native void native_uploadGroupBulletinPic(long j3, long j16, String str, String str2, IUploadGroupBulletinPicCallback iUploadGroupBulletinPicCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void addGroupEssence(DigestReq digestReq, IDigestCallback iDigestCallback) {
            native_addGroupEssence(this.nativeRef, digestReq, iDigestCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public long addKernelGroupListener(IKernelGroupListener iKernelGroupListener) {
            return native_addKernelGroupListener(this.nativeRef, iKernelGroupListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void applyTeamUp(TeamUpApplyReq teamUpApplyReq, IOperateCallback iOperateCallback) {
            native_applyTeamUp(this.nativeRef, teamUpApplyReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void batchQueryCachedGroupDetailInfo(BatchQueryCachedGroupDetailInfoReq batchQueryCachedGroupDetailInfoReq, IBatchQueryCachedGroupDetailInfoCallback iBatchQueryCachedGroupDetailInfoCallback) {
            native_batchQueryCachedGroupDetailInfo(this.nativeRef, batchQueryCachedGroupDetailInfoReq, iBatchQueryCachedGroupDetailInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void changeGroupShieldSettingTemp(long j3, boolean z16, IOperateCallback iOperateCallback) {
            native_changeGroupShieldSettingTemp(this.nativeRef, j3, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void checkGroupMemberCache(ArrayList<Long> arrayList, IGroupMemberCacheCallback iGroupMemberCacheCallback) {
            native_checkGroupMemberCache(this.nativeRef, arrayList, iGroupMemberCacheCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void cleanCapsuleCache(long j3) {
            native_cleanCapsuleCache(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void clearGroupNotifies(boolean z16, IOperateCallback iOperateCallback) {
            native_clearGroupNotifies(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void clearGroupNotifiesUnreadCount(boolean z16, IOperateCallback iOperateCallback) {
            native_clearGroupNotifiesUnreadCount(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void clearGroupNotifyLocalUnreadCount(boolean z16, int i3, IOperateCallback iOperateCallback) {
            native_clearGroupNotifyLocalUnreadCount(this.nativeRef, z16, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void clearGroupSquareRedpointCache(long j3) {
            native_clearGroupSquareRedpointCache(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void consumeGroupTopBanner(ConsumeGroupTopBannerReq consumeGroupTopBannerReq, IOperateCallback iOperateCallback) {
            native_consumeGroupTopBanner(this.nativeRef, consumeGroupTopBannerReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void createGroup(ArrayList<InviteMemberInfo> arrayList, ICreateGroupCallback iCreateGroupCallback) {
            native_createGroup(this.nativeRef, arrayList, iCreateGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void createGroupProfileShare(CreateGroupProfileShareReq createGroupProfileShareReq, ICreateGroupProfileShareCallback iCreateGroupProfileShareCallback) {
            native_createGroupProfileShare(this.nativeRef, createGroupProfileShareReq, iCreateGroupProfileShareCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void createGroupV2(CreateGroupReq createGroupReq, ArrayList<InviteMemberInfo> arrayList, ICreateGroupCallback iCreateGroupCallback) {
            native_createGroupV2(this.nativeRef, createGroupReq, arrayList, iCreateGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void createGroupWithMembers(String str, ArrayList<String> arrayList, ICreateGroupCallback iCreateGroupCallback) {
            native_createGroupWithMembers(this.nativeRef, str, arrayList, iCreateGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public String createMemberListScene(long j3, String str) {
            return native_createMemberListScene(this.nativeRef, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void deleteGroupBulletin(long j3, String str, String str2, IOperateCallback iOperateCallback) {
            native_deleteGroupBulletin(this.nativeRef, j3, str, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void deleteTeamUp(DeleteTeamUpReq deleteTeamUpReq, IOperateCallback iOperateCallback) {
            native_deleteTeamUp(this.nativeRef, deleteTeamUpReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void destroyGroup(long j3, IOperateCallback iOperateCallback) {
            native_destroyGroup(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void destroyGroupV2(DestroyGroupReq destroyGroupReq, IOperateCallback iOperateCallback) {
            native_destroyGroupV2(this.nativeRef, destroyGroupReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void destroyMemberListScene(String str) {
            native_destroyMemberListScene(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void downloadGroupBulletinRichMedia(BulletinFeedsRichMediaDownloadReq bulletinFeedsRichMediaDownloadReq) {
            native_downloadGroupBulletinRichMedia(this.nativeRef, bulletinFeedsRichMediaDownloadReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void fetchGroupEssenceList(FetchGroupEssenceListReq fetchGroupEssenceListReq, String str, IFetchGroupEssenceListCallback iFetchGroupEssenceListCallback) {
            native_fetchGroupEssenceList(this.nativeRef, fetchGroupEssenceListReq, str, iFetchGroupEssenceListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void fetchGroupNotify(boolean z16, IOperateCallback iOperateCallback) {
            native_fetchGroupNotify(this.nativeRef, z16, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getAICommonVoice(GetVoiceReq getVoiceReq, IGetVoiceCallback iGetVoiceCallback) {
            native_getAICommonVoice(this.nativeRef, getVoiceReq, iGetVoiceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getAIOBindGuildInfo(GetAIOBindGuildInfoReq getAIOBindGuildInfoReq, IGetAIOBindGuildInfoCallback iGetAIOBindGuildInfoCallback) {
            native_getAIOBindGuildInfo(this.nativeRef, getAIOBindGuildInfoReq, iGetAIOBindGuildInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getAllGroupPrivilegeFlag(ArrayList<Long> arrayList, int i3, IGroupPrivilegeFlagCallback iGroupPrivilegeFlagCallback) {
            native_getAllGroupPrivilegeFlag(this.nativeRef, arrayList, i3, iGroupPrivilegeFlagCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getAllMemberList(long j3, boolean z16, IGroupMemberListCallback iGroupMemberListCallback) {
            native_getAllMemberList(this.nativeRef, j3, z16, iGroupMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getAllMemberListV2(long j3, boolean z16, IGroupMemberListCallback iGroupMemberListCallback) {
            native_getAllMemberListV2(this.nativeRef, j3, z16, iGroupMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getAppCenter(GetAppCenterReq getAppCenterReq, IGetAppCenterCallback iGetAppCenterCallback) {
            native_getAppCenter(this.nativeRef, getAppCenterReq, iGetAppCenterCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getCapsuleApp(GetCapsuleAppReq getCapsuleAppReq, boolean z16, IGetCapsuleAppCallback iGetCapsuleAppCallback) {
            native_getCapsuleApp(this.nativeRef, getCapsuleAppReq, z16, iGetCapsuleAppCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getCapsuleAppPro(GetCapsuleAppReq getCapsuleAppReq, boolean z16, IGetCapsuleAppProCallback iGetCapsuleAppProCallback) {
            native_getCapsuleAppPro(this.nativeRef, getCapsuleAppReq, z16, iGetCapsuleAppProCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getCardAppList(GetCardAppListReq getCardAppListReq, boolean z16, IGetCardAppListCallback iGetCardAppListCallback) {
            native_getCardAppList(this.nativeRef, getCardAppListReq, z16, iGetCardAppListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getDiscussExistInfo(long j3, IDiscussSimpleInfoCallback iDiscussSimpleInfoCallback) {
            native_getDiscussExistInfo(this.nativeRef, j3, iDiscussSimpleInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupAllInfo(long j3, GroupInfoSource groupInfoSource, IOperateCallback iOperateCallback) {
            native_getGroupAllInfo(this.nativeRef, j3, groupInfoSource, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupArkInviteState(long j3, long j16, long j17, IOperateCallback iOperateCallback) {
            native_getGroupArkInviteState(this.nativeRef, j3, j16, j17, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupAvatarWall(long j3, IGroupAvatarWallCallback iGroupAvatarWallCallback) {
            native_getGroupAvatarWall(this.nativeRef, j3, iGroupAvatarWallCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupBindGuilds(GetGroupBindGuildsReq getGroupBindGuildsReq, IGetGroupBindGuildsCallback iGetGroupBindGuildsCallback) {
            native_getGroupBindGuilds(this.nativeRef, getGroupBindGuildsReq, iGetGroupBindGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupBulletin(long j3, IOperateCallback iOperateCallback) {
            native_getGroupBulletin(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupBulletinList(long j3, String str, String str2, GroupBulletinListReq groupBulletinListReq, IOperateCallback iOperateCallback) {
            native_getGroupBulletinList(this.nativeRef, j3, str, str2, groupBulletinListReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupConfMember(long j3, boolean z16, IOperateCallback iOperateCallback) {
            native_getGroupConfMember(this.nativeRef, j3, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public int getGroupDBVersion(int i3) {
            return native_getGroupDBVersion(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupDetailInfo(long j3, GroupInfoSource groupInfoSource, IOperateCallback iOperateCallback) {
            native_getGroupDetailInfo(this.nativeRef, j3, groupInfoSource, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupDetailInfoByFilter(GroupDetailInfoReq groupDetailInfoReq, int i3, int i16, boolean z16, IGroupDetailInfoCallback iGroupDetailInfoCallback) {
            native_getGroupDetailInfoByFilter(this.nativeRef, groupDetailInfoReq, i3, i16, z16, iGroupDetailInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupDetailInfoForMqq(long j3, int i3, int i16, boolean z16, IOperateCallback iOperateCallback) {
            native_getGroupDetailInfoForMqq(this.nativeRef, j3, i3, i16, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupExt0xEF0Info(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, GroupExtFilter groupExtFilter, boolean z16, IGroupExt0xEF0InfoCallback iGroupExt0xEF0InfoCallback) {
            native_getGroupExt0xEF0Info(this.nativeRef, arrayList, arrayList2, groupExtFilter, z16, iGroupExt0xEF0InfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupExtList(boolean z16, IOperateCallback iOperateCallback) {
            native_getGroupExtList(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupFlagForThirdApp(ArrayList<Long> arrayList, IGetGroupFlagForThirdAppCallback iGetGroupFlagForThirdAppCallback) {
            native_getGroupFlagForThirdApp(this.nativeRef, arrayList, iGetGroupFlagForThirdAppCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupHonorList(GroupMemberHonorReq groupMemberHonorReq, IGroupMemberHonorCallback iGroupMemberHonorCallback) {
            native_getGroupHonorList(this.nativeRef, groupMemberHonorReq, iGroupMemberHonorCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupInfoForJoinGroup(long j3, boolean z16, int i3, IGroupInfoForJoinCallback iGroupInfoForJoinCallback) {
            native_getGroupInfoForJoinGroup(this.nativeRef, j3, z16, i3, iGroupInfoForJoinCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupInviteNoAuthLimitNum(ArrayList<Long> arrayList, IGetGroupInviteNoAuthLimitNumCallback iGetGroupInviteNoAuthLimitNumCallback) {
            native_getGroupInviteNoAuthLimitNum(this.nativeRef, arrayList, iGetGroupInviteNoAuthLimitNumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupLatestEssenceList(GetGroupLatestEssenceListReq getGroupLatestEssenceListReq, IGetGroupLatestEssenceListCallback iGetGroupLatestEssenceListCallback) {
            native_getGroupLatestEssenceList(this.nativeRef, getGroupLatestEssenceListReq, iGetGroupLatestEssenceListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupList(boolean z16, IOperateCallback iOperateCallback) {
            native_getGroupList(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupMedalList(GetGroupMedalListReq getGroupMedalListReq, IGetGroupMedalListCallback iGetGroupMedalListCallback) {
            native_getGroupMedalList(this.nativeRef, getGroupMedalListReq, iGetGroupMedalListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupMemberLevelInfo(long j3, IOperateCallback iOperateCallback) {
            native_getGroupMemberLevelInfo(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupMemberMaxNum(long j3, int i3, IGroupMemberMaxNumCallback iGroupMemberMaxNumCallback) {
            native_getGroupMemberMaxNum(this.nativeRef, j3, i3, iGroupMemberMaxNumCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupMsgLimitFreq(long j3, IGroupMsgLimitFreqCallback iGroupMsgLimitFreqCallback) {
            native_getGroupMsgLimitFreq(this.nativeRef, j3, iGroupMsgLimitFreqCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupMsgMask(IOperateCallback iOperateCallback) {
            native_getGroupMsgMask(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupNotifiesUnreadCount(boolean z16, IOperateCallback iOperateCallback) {
            native_getGroupNotifiesUnreadCount(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupPayToJoinStatus(long j3, IGroupPayToJoinStatusCallback iGroupPayToJoinStatusCallback) {
            native_getGroupPayToJoinStatus(this.nativeRef, j3, iGroupPayToJoinStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupPlusAppList(GetAppListReq getAppListReq, IGetAppListCallback iGetAppListCallback) {
            native_getGroupPlusAppList(this.nativeRef, getAppListReq, iGetAppListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupPortrait(long j3, IOperateCallback iOperateCallback) {
            native_getGroupPortrait(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupRecommendContactArkJson(long j3, IGetGroupRecommendContactArkJsonCallback iGetGroupRecommendContactArkJsonCallback) {
            native_getGroupRecommendContactArkJson(this.nativeRef, j3, iGetGroupRecommendContactArkJsonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupRemainAtTimes(long j3, IGetGroupRemainAtAllTimesOperateCallback iGetGroupRemainAtAllTimesOperateCallback) {
            native_getGroupRemainAtTimes(this.nativeRef, j3, iGetGroupRemainAtAllTimesOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupSecLevelInfo(long j3, int i3, IGroupSecLevelInfoCallback iGroupSecLevelInfoCallback) {
            native_getGroupSecLevelInfo(this.nativeRef, j3, i3, iGroupSecLevelInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupSeqAndJoinTimeForGrayTips(long j3, IGroupInfoForGrayTipsCallback iGroupInfoForGrayTipsCallback) {
            native_getGroupSeqAndJoinTimeForGrayTips(this.nativeRef, j3, iGroupInfoForGrayTipsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupShutUpMemberList(long j3, IOperateCallback iOperateCallback) {
            native_getGroupShutUpMemberList(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupSquareHomeHead(long j3, String str, IGetHomeHeadCallback iGetHomeHeadCallback) {
            native_getGroupSquareHomeHead(this.nativeRef, j3, str, iGetHomeHeadCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupSquareRedpointInfo(GetGroupSquareRedpointInfoReq getGroupSquareRedpointInfoReq, boolean z16, IGetGroupSquareRedpointInfoCallback iGetGroupSquareRedpointInfoCallback) {
            native_getGroupSquareRedpointInfo(this.nativeRef, getGroupSquareRedpointInfoReq, z16, iGetGroupSquareRedpointInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupStatisticInfo(long j3, IOperateCallback iOperateCallback) {
            native_getGroupStatisticInfo(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getGroupTagRecords(long j3, IGroupTagRecordCallback iGroupTagRecordCallback) {
            native_getGroupTagRecords(this.nativeRef, j3, iGroupTagRecordCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getIdentityList(GetIdentityListReq getIdentityListReq, IGetIdentityListCallback iGetIdentityListCallback) {
            native_getIdentityList(this.nativeRef, getIdentityListReq, iGetIdentityListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getIllegalMemberList(long j3, IGroupMemberIllegalInfoCallback iGroupMemberIllegalInfoCallback) {
            native_getIllegalMemberList(this.nativeRef, j3, iGroupMemberIllegalInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getJoinGroupLink(GroupLinkReq groupLinkReq, IGetJoinGroupLinkCallback iGetJoinGroupLinkCallback) {
            native_getJoinGroupLink(this.nativeRef, groupLinkReq, iGetJoinGroupLinkCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getJoinGroupNoVerifyFlag(long j3, String str, IOperateCallback iOperateCallback) {
            native_getJoinGroupNoVerifyFlag(this.nativeRef, j3, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getMemberCommonInfo(GroupMemberCommonReq groupMemberCommonReq, IGroupMemberCommonCallback iGroupMemberCommonCallback) {
            native_getMemberCommonInfo(this.nativeRef, groupMemberCommonReq, iGroupMemberCommonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getMemberExtInfo(GroupMemberExtReq groupMemberExtReq, IGroupMemberExtCallback iGroupMemberExtCallback) {
            native_getMemberExtInfo(this.nativeRef, groupMemberExtReq, iGroupMemberExtCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getMemberInfo(long j3, ArrayList<String> arrayList, boolean z16, IOperateCallback iOperateCallback) {
            native_getMemberInfo(this.nativeRef, j3, arrayList, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getMemberInfoForMqq(long j3, ArrayList<String> arrayList, boolean z16, IGroupMemberListCallback iGroupMemberListCallback) {
            native_getMemberInfoForMqq(this.nativeRef, j3, arrayList, z16, iGroupMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getMemberInfoForMqqV2(long j3, ArrayList<String> arrayList, boolean z16, String str, IGroupMemberListCallback iGroupMemberListCallback) {
            native_getMemberInfoForMqqV2(this.nativeRef, j3, arrayList, z16, str, iGroupMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getNextMemberList(String str, GroupMemberInfoListId groupMemberInfoListId, int i3, IGroupMemberListCallback iGroupMemberListCallback) {
            native_getNextMemberList(this.nativeRef, str, groupMemberInfoListId, i3, iGroupMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getPrevMemberList(String str, GroupMemberInfoListId groupMemberInfoListId, int i3, IGroupMemberListCallback iGroupMemberListCallback) {
            native_getPrevMemberList(this.nativeRef, str, groupMemberInfoListId, i3, iGroupMemberListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getRecGroups(long j3, GroupSquareTabItem groupSquareTabItem, String str, IGetRecGroupsCallback iGetRecGroupsCallback) {
            native_getRecGroups(this.nativeRef, j3, groupSquareTabItem, str, iGetRecGroupsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getSingleScreenNotifies(boolean z16, long j3, int i3, IOperateCallback iOperateCallback) {
            native_getSingleScreenNotifies(this.nativeRef, z16, j3, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getSingleScreenNotifiesV2(boolean z16, long j3, int i3, int i16, IGetGroupSingleScreenNotifiesCallback iGetGroupSingleScreenNotifiesCallback) {
            native_getSingleScreenNotifiesV2(this.nativeRef, z16, j3, i3, i16, iGetGroupSingleScreenNotifiesCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getSubGroupInfo(GetSubGroupInfoReq getSubGroupInfoReq, IGetSubGroupInfoCallback iGetSubGroupInfoCallback) {
            native_getSubGroupInfo(this.nativeRef, getSubGroupInfoReq, iGetSubGroupInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getSwitchStatusForEssenceMsg(long j3, IGroupEssenceMsgSwitchCallback iGroupEssenceMsgSwitchCallback) {
            native_getSwitchStatusForEssenceMsg(this.nativeRef, j3, iGroupEssenceMsgSwitchCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTeamUpDetail(GetTeamUpDetailReq getTeamUpDetailReq, IGetTeamUpDetailCallback iGetTeamUpDetailCallback) {
            native_getTeamUpDetail(this.nativeRef, getTeamUpDetailReq, iGetTeamUpDetailCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTeamUpList(GetTeamUpListReq getTeamUpListReq, IGetTeamUpListCallback iGetTeamUpListCallback) {
            native_getTeamUpList(this.nativeRef, getTeamUpListReq, iGetTeamUpListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTeamUpMembers(GetTeamUpMembersReq getTeamUpMembersReq, IGetTeamUpMembersCallback iGetTeamUpMembersCallback) {
            native_getTeamUpMembers(this.nativeRef, getTeamUpMembersReq, iGetTeamUpMembersCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTeamUpTemplateList(GetTeamUpTemplateListReq getTeamUpTemplateListReq, IGetTeamUpTemplateListCallback iGetTeamUpTemplateListCallback) {
            native_getTeamUpTemplateList(this.nativeRef, getTeamUpTemplateListReq, iGetTeamUpTemplateListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTopicPage(long j3, long j16, String str, String str2, IGetTopicPageCallback iGetTopicPageCallback) {
            native_getTopicPage(this.nativeRef, j3, j16, str, str2, iGetTopicPageCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTopicRecall(TopicRecallReq topicRecallReq, ITopicRecallCallback iTopicRecallCallback) {
            native_getTopicRecall(this.nativeRef, topicRecallReq, iTopicRecallCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getTransferableMemberInfo(long j3, IGetTransferableMemberCallback iGetTransferableMemberCallback) {
            native_getTransferableMemberInfo(this.nativeRef, j3, iGetTransferableMemberCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getUidByUins(ArrayList<Long> arrayList, IGroupMemberUidCallback iGroupMemberUidCallback) {
            native_getUidByUins(this.nativeRef, arrayList, iGroupMemberUidCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getUinByUids(ArrayList<String> arrayList, IGroupMemberUinCallback iGroupMemberUinCallback) {
            native_getUinByUids(this.nativeRef, arrayList, iGroupMemberUinCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void getWxNotifyStatus(ArrayList<Long> arrayList, IGetGroupWxNotifyStatusCallback iGetGroupWxNotifyStatusCallback) {
            native_getWxNotifyStatus(this.nativeRef, arrayList, iGetGroupWxNotifyStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void groupBlacklistDelApply(GroupBlacklistDelApplyReq groupBlacklistDelApplyReq, IGroupBlacklistDelApplyCallback iGroupBlacklistDelApplyCallback) {
            native_groupBlacklistDelApply(this.nativeRef, groupBlacklistDelApplyReq, iGroupBlacklistDelApplyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void groupBlacklistGetAllApply(GroupBlacklistGetAllApplyReq groupBlacklistGetAllApplyReq, IGroupBlacklistGetAllApplyCallback iGroupBlacklistGetAllApplyCallback) {
            native_groupBlacklistGetAllApply(this.nativeRef, groupBlacklistGetAllApplyReq, iGroupBlacklistGetAllApplyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void halfScreenPullNotice(HalfScreenPullNoticeReq halfScreenPullNoticeReq, IHalfScreenPullNoticeCallback iHalfScreenPullNoticeCallback) {
            native_halfScreenPullNotice(this.nativeRef, halfScreenPullNoticeReq, iHalfScreenPullNoticeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void halfScreenReportClick(HalfScreenReportClickReq halfScreenReportClickReq, IOperateCallback iOperateCallback) {
            native_halfScreenReportClick(this.nativeRef, halfScreenReportClickReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void inviteMembersToGroup(long j3, HashMap<String, Long> hashMap, IOperateCallback iOperateCallback) {
            native_inviteMembersToGroup(this.nativeRef, j3, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void inviteMembersToGroupWithMsg(long j3, HashMap<String, Long> hashMap, ArrayList<ShareMsgInfo> arrayList, IOperateCallback iOperateCallback) {
            native_inviteMembersToGroupWithMsg(this.nativeRef, j3, hashMap, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void inviteToGroup(long j3, ArrayList<String> arrayList, IOperateCallback iOperateCallback) {
            native_inviteToGroup(this.nativeRef, j3, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void inviteToGroupV2(InviteGroupReq inviteGroupReq, IInviteToGroupCallback iInviteToGroupCallback) {
            native_inviteToGroupV2(this.nativeRef, inviteGroupReq, iInviteToGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void isEssenceMsg(EssenceKey essenceKey, ICheckEssenceCallback iCheckEssenceCallback) {
            native_isEssenceMsg(this.nativeRef, essenceKey, iCheckEssenceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void joinGroup(ReqToGroup reqToGroup, IJoinGroupCallback iJoinGroupCallback) {
            native_joinGroup(this.nativeRef, reqToGroup, iJoinGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void kickMember(long j3, ArrayList<String> arrayList, boolean z16, String str, IKickMemberOperateCallback iKickMemberOperateCallback) {
            native_kickMember(this.nativeRef, j3, arrayList, z16, str, iKickMemberOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void kickMemberV2(KickMemberReq kickMemberReq, IKickMemberCallback iKickMemberCallback) {
            native_kickMemberV2(this.nativeRef, kickMemberReq, iKickMemberCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void listAllAIVoice(ListAllVoiceReq listAllVoiceReq, IListAllVoiceCallback iListAllVoiceCallback) {
            native_listAllAIVoice(this.nativeRef, listAllVoiceReq, iListAllVoiceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void miniAppGetGroupInfo(MiniAppGetGroupInfoReq miniAppGetGroupInfoReq, IMiniAppGetGroupInfoCallback iMiniAppGetGroupInfoCallback) {
            native_miniAppGetGroupInfo(this.nativeRef, miniAppGetGroupInfoReq, iMiniAppGetGroupInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyGroupDetailInfo(long j3, GroupModifyInfo groupModifyInfo, IOperateCallback iOperateCallback) {
            native_modifyGroupDetailInfo(this.nativeRef, j3, groupModifyInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyGroupDetailInfoV2(GroupModifyInfoReq groupModifyInfoReq, int i3, IOperateCallback iOperateCallback) {
            native_modifyGroupDetailInfoV2(this.nativeRef, groupModifyInfoReq, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyGroupExtInfo(GroupExtInfo groupExtInfo, IOperateCallback iOperateCallback) {
            native_modifyGroupExtInfo(this.nativeRef, groupExtInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyGroupExtInfoV2(GroupExtInfo groupExtInfo, GroupExtFilter groupExtFilter, IModifyGroupExtCallback iModifyGroupExtCallback) {
            native_modifyGroupExtInfoV2(this.nativeRef, groupExtInfo, groupExtFilter, iModifyGroupExtCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyGroupName(long j3, String str, boolean z16, IOperateCallback iOperateCallback) {
            native_modifyGroupName(this.nativeRef, j3, str, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyGroupRemark(long j3, String str, IOperateCallback iOperateCallback) {
            native_modifyGroupRemark(this.nativeRef, j3, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyMemberCardName(long j3, String str, String str2, IOperateCallback iOperateCallback) {
            native_modifyMemberCardName(this.nativeRef, j3, str, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyMemberRole(long j3, String str, MemberRole memberRole, IOperateCallback iOperateCallback) {
            native_modifyMemberRole(this.nativeRef, j3, str, memberRole, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void modifyWxNotifyStatus(long j3, GroupWxNotifyStatus groupWxNotifyStatus, IOperateCallback iOperateCallback) {
            native_modifyWxNotifyStatus(this.nativeRef, j3, groupWxNotifyStatus, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void monitorMemberList(String str, GroupMemberInfoListId groupMemberInfoListId, GroupMemberInfoListId groupMemberInfoListId2) {
            native_monitorMemberList(this.nativeRef, str, groupMemberInfoListId, groupMemberInfoListId2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void operateSysNotify(boolean z16, GroupNotifyOperateMsg groupNotifyOperateMsg, IOperateCallback iOperateCallback) {
            native_operateSysNotify(this.nativeRef, z16, groupNotifyOperateMsg, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void operateSysNotifyV2(boolean z16, GroupNotifyOperateMsg groupNotifyOperateMsg, IGroupNotifyOperateCallback iGroupNotifyOperateCallback) {
            native_operateSysNotifyV2(this.nativeRef, z16, groupNotifyOperateMsg, iGroupNotifyOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void postTeamUp(PostTeamUpReq postTeamUpReq, IPostTeamUpCallback iPostTeamUpCallback) {
            native_postTeamUp(this.nativeRef, postTeamUpReq, iPostTeamUpCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void publishGroupBulletin(long j3, String str, GroupBulletinPublishReq groupBulletinPublishReq, IOperateCallback iOperateCallback) {
            native_publishGroupBulletin(this.nativeRef, j3, str, groupBulletinPublishReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void publishInstructionForNewcomers(long j3, String str, GroupBulletinPublishReq groupBulletinPublishReq, IOperateCallback iOperateCallback) {
            native_publishInstructionForNewcomers(this.nativeRef, j3, str, groupBulletinPublishReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void queryAIOBindGuild(QueryAIOBindGuildReq queryAIOBindGuildReq, IQueryAIOBindGuildCallback iQueryAIOBindGuildCallback) {
            native_queryAIOBindGuild(this.nativeRef, queryAIOBindGuildReq, iQueryAIOBindGuildCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void queryCachedEssenceMsg(EssenceKey essenceKey, IQueryCachedEssenceCallback iQueryCachedEssenceCallback) {
            native_queryCachedEssenceMsg(this.nativeRef, essenceKey, iQueryCachedEssenceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void queryGroupTopBanners(QueryGroupTopBannersReq queryGroupTopBannersReq, IQueryGroupTopBannersCallback iQueryGroupTopBannersCallback) {
            native_queryGroupTopBanners(this.nativeRef, queryGroupTopBannersReq, iQueryGroupTopBannersCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void queryJoinGroupCanNoVerify(JoinGroupVerifyReq joinGroupVerifyReq, IJoinGroupVerifyCallback iJoinGroupVerifyCallback) {
            native_queryJoinGroupCanNoVerify(this.nativeRef, joinGroupVerifyReq, iJoinGroupVerifyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void quitGroup(long j3, IOperateCallback iOperateCallback) {
            native_quitGroup(this.nativeRef, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void quitGroupV2(QuitGroupReq quitGroupReq, IOperateCallback iOperateCallback) {
            native_quitGroupV2(this.nativeRef, quitGroupReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void removeGroupEssence(DigestReq digestReq, IDigestCallback iDigestCallback) {
            native_removeGroupEssence(this.nativeRef, digestReq, iDigestCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void removeGroupFromGroupList(long j3) {
            native_removeGroupFromGroupList(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void removeKernelGroupListener(long j3) {
            native_removeKernelGroupListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void reqToJoinGroup(ReqToGroup reqToGroup, IOperateCallback iOperateCallback) {
            native_reqToJoinGroup(this.nativeRef, reqToGroup, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void saveAIVoice(SaveVoiceReq saveVoiceReq, ISaveVoiceCallback iSaveVoiceCallback) {
            native_saveAIVoice(this.nativeRef, saveVoiceReq, iSaveVoiceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void searchMember(String str, String str2, IOperateCallback iOperateCallback) {
            native_searchMember(this.nativeRef, str, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setAIOBindGuild(SetAIOBindGuildReq setAIOBindGuildReq, ISetAIOBindGuildCallback iSetAIOBindGuildCallback) {
            native_setAIOBindGuild(this.nativeRef, setAIOBindGuildReq, iSetAIOBindGuildCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setActiveExtGroup(ActiveExtGroupReq activeExtGroupReq, IOperateCallback iOperateCallback) {
            native_setActiveExtGroup(this.nativeRef, activeExtGroupReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setCapsuleSwitch(SetCapsuleSwitchReq setCapsuleSwitchReq, IOperateCallback iOperateCallback) {
            native_setCapsuleSwitch(this.nativeRef, setCapsuleSwitchReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setGroupAppList(SetGroupAppListReq setGroupAppListReq, IOperateCallback iOperateCallback) {
            native_setGroupAppList(this.nativeRef, setGroupAppListReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setGroupGeoInfo(GroupGeoInfoReq groupGeoInfoReq, IOperateCallback iOperateCallback) {
            native_setGroupGeoInfo(this.nativeRef, groupGeoInfoReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setGroupMsgMask(long j3, GroupMsgMask groupMsgMask, IOperateCallback iOperateCallback) {
            native_setGroupMsgMask(this.nativeRef, j3, groupMsgMask, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setGroupMsgMaskV2(SetGroupMsgMaskReq setGroupMsgMaskReq, int i3, ISetGroupMsgMaskCallback iSetGroupMsgMaskCallback) {
            native_setGroupMsgMaskV2(this.nativeRef, setGroupMsgMaskReq, i3, iSetGroupMsgMaskCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setGroupRelationToGuild(SetGroupRelationToGuildReq setGroupRelationToGuildReq, ISetGroupRelationToGuildCallback iSetGroupRelationToGuildCallback) {
            native_setGroupRelationToGuild(this.nativeRef, setGroupRelationToGuildReq, iSetGroupRelationToGuildCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setGroupShutUp(long j3, boolean z16, IOperateCallback iOperateCallback) {
            native_setGroupShutUp(this.nativeRef, j3, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setIdentityInteractionTag(SetIdentityInteractionTagReq setIdentityInteractionTagReq, IOperateCallback iOperateCallback) {
            native_setIdentityInteractionTag(this.nativeRef, setIdentityInteractionTagReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setIdentityTitleInfo(SetIdentityTitleInfoReq setIdentityTitleInfoReq, IOperateCallback iOperateCallback) {
            native_setIdentityTitleInfo(this.nativeRef, setIdentityTitleInfoReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setMemberShutUp(long j3, ArrayList<GroupMemberShutUpInfo> arrayList, IOperateCallback iOperateCallback) {
            native_setMemberShutUp(this.nativeRef, j3, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setRcvJoinVerifyMsg(RcvJoinVerifyMsgReq rcvJoinVerifyMsgReq, IRcvJoinVerifyMsgCallback iRcvJoinVerifyMsgCallback) {
            native_setRcvJoinVerifyMsg(this.nativeRef, rcvJoinVerifyMsgReq, iRcvJoinVerifyMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void setTop(long j3, boolean z16, IOperateCallback iOperateCallback) {
            native_setTop(this.nativeRef, j3, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void shareTopic(ShareTopicReq shareTopicReq, IShareTopicCallback iShareTopicCallback) {
            native_shareTopic(this.nativeRef, shareTopicReq, iShareTopicCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void teamUpCreateGroup(TeamUpCreateGroupReq teamUpCreateGroupReq, ITeamUpCreateGroupCallback iTeamUpCreateGroupCallback) {
            native_teamUpCreateGroup(this.nativeRef, teamUpCreateGroupReq, iTeamUpCreateGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void teamUpInviteToGroup(TeamUpInviteToGroupReq teamUpInviteToGroupReq, IOperateCallback iOperateCallback) {
            native_teamUpInviteToGroup(this.nativeRef, teamUpInviteToGroupReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void teamUpRequestToJoin(TeamUpRequestToJoinReq teamUpRequestToJoinReq, ITeamUpRequestToJoinCallback iTeamUpRequestToJoinCallback) {
            native_teamUpRequestToJoin(this.nativeRef, teamUpRequestToJoinReq, iTeamUpRequestToJoinCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void teamUpSubmitDeadline(TeamUpSubmitDeadlineReq teamUpSubmitDeadlineReq, IOperateCallback iOperateCallback) {
            native_teamUpSubmitDeadline(this.nativeRef, teamUpSubmitDeadlineReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void topicFeedback(TopicFeedbackReq topicFeedbackReq, IOperateCallback iOperateCallback) {
            native_topicFeedback(this.nativeRef, topicFeedbackReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void topicReport(TopicReportReq topicReportReq, ITopicReportCallback iTopicReportCallback) {
            native_topicReport(this.nativeRef, topicReportReq, iTopicReportCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void transferGroup(long j3, String str, String str2, IOperateCallback iOperateCallback) {
            native_transferGroup(this.nativeRef, j3, str, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void transferGroupV2(long j3, String str, String str2, ITransferGroupCallback iTransferGroupCallback) {
            native_transferGroupV2(this.nativeRef, j3, str, str2, iTransferGroupCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void unbindAllGuilds(UnbindAllGuildsReq unbindAllGuildsReq, IUnbindAllGuildsCallback iUnbindAllGuildsCallback) {
            native_unbindAllGuilds(this.nativeRef, unbindAllGuildsReq, iUnbindAllGuildsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void updateGroupInfoByMqq(GroupInfoCacheReq groupInfoCacheReq) {
            native_updateGroupInfoByMqq(this.nativeRef, groupInfoCacheReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void updateMemberInfoByMqq(GroupMemberCacheReq groupMemberCacheReq) {
            native_updateMemberInfoByMqq(this.nativeRef, groupMemberCacheReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void updateTeamUp(UpdateTeamUpReq updateTeamUpReq, IOperateCallback iOperateCallback) {
            native_updateTeamUp(this.nativeRef, updateTeamUpReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService
        public void uploadGroupBulletinPic(long j3, String str, String str2, IUploadGroupBulletinPicCallback iUploadGroupBulletinPicCallback) {
            native_uploadGroupBulletinPic(this.nativeRef, j3, str, str2, iUploadGroupBulletinPicCallback);
        }
    }

    void addGroupEssence(DigestReq digestReq, IDigestCallback iDigestCallback);

    long addKernelGroupListener(IKernelGroupListener iKernelGroupListener);

    void applyTeamUp(TeamUpApplyReq teamUpApplyReq, IOperateCallback iOperateCallback);

    void batchQueryCachedGroupDetailInfo(BatchQueryCachedGroupDetailInfoReq batchQueryCachedGroupDetailInfoReq, IBatchQueryCachedGroupDetailInfoCallback iBatchQueryCachedGroupDetailInfoCallback);

    void changeGroupShieldSettingTemp(long j3, boolean z16, IOperateCallback iOperateCallback);

    void checkGroupMemberCache(ArrayList<Long> arrayList, IGroupMemberCacheCallback iGroupMemberCacheCallback);

    void cleanCapsuleCache(long j3);

    void clearGroupNotifies(boolean z16, IOperateCallback iOperateCallback);

    void clearGroupNotifiesUnreadCount(boolean z16, IOperateCallback iOperateCallback);

    void clearGroupNotifyLocalUnreadCount(boolean z16, int i3, IOperateCallback iOperateCallback);

    void clearGroupSquareRedpointCache(long j3);

    void consumeGroupTopBanner(ConsumeGroupTopBannerReq consumeGroupTopBannerReq, IOperateCallback iOperateCallback);

    void createGroup(ArrayList<InviteMemberInfo> arrayList, ICreateGroupCallback iCreateGroupCallback);

    void createGroupProfileShare(CreateGroupProfileShareReq createGroupProfileShareReq, ICreateGroupProfileShareCallback iCreateGroupProfileShareCallback);

    void createGroupV2(CreateGroupReq createGroupReq, ArrayList<InviteMemberInfo> arrayList, ICreateGroupCallback iCreateGroupCallback);

    void createGroupWithMembers(String str, ArrayList<String> arrayList, ICreateGroupCallback iCreateGroupCallback);

    String createMemberListScene(long j3, String str);

    void deleteGroupBulletin(long j3, String str, String str2, IOperateCallback iOperateCallback);

    void deleteTeamUp(DeleteTeamUpReq deleteTeamUpReq, IOperateCallback iOperateCallback);

    void destroyGroup(long j3, IOperateCallback iOperateCallback);

    void destroyGroupV2(DestroyGroupReq destroyGroupReq, IOperateCallback iOperateCallback);

    void destroyMemberListScene(String str);

    void downloadGroupBulletinRichMedia(BulletinFeedsRichMediaDownloadReq bulletinFeedsRichMediaDownloadReq);

    void fetchGroupEssenceList(FetchGroupEssenceListReq fetchGroupEssenceListReq, String str, IFetchGroupEssenceListCallback iFetchGroupEssenceListCallback);

    void fetchGroupNotify(boolean z16, IOperateCallback iOperateCallback);

    void getAICommonVoice(GetVoiceReq getVoiceReq, IGetVoiceCallback iGetVoiceCallback);

    void getAIOBindGuildInfo(GetAIOBindGuildInfoReq getAIOBindGuildInfoReq, IGetAIOBindGuildInfoCallback iGetAIOBindGuildInfoCallback);

    void getAllGroupPrivilegeFlag(ArrayList<Long> arrayList, int i3, IGroupPrivilegeFlagCallback iGroupPrivilegeFlagCallback);

    void getAllMemberList(long j3, boolean z16, IGroupMemberListCallback iGroupMemberListCallback);

    void getAllMemberListV2(long j3, boolean z16, IGroupMemberListCallback iGroupMemberListCallback);

    void getAppCenter(GetAppCenterReq getAppCenterReq, IGetAppCenterCallback iGetAppCenterCallback);

    void getCapsuleApp(GetCapsuleAppReq getCapsuleAppReq, boolean z16, IGetCapsuleAppCallback iGetCapsuleAppCallback);

    void getCapsuleAppPro(GetCapsuleAppReq getCapsuleAppReq, boolean z16, IGetCapsuleAppProCallback iGetCapsuleAppProCallback);

    void getCardAppList(GetCardAppListReq getCardAppListReq, boolean z16, IGetCardAppListCallback iGetCardAppListCallback);

    void getDiscussExistInfo(long j3, IDiscussSimpleInfoCallback iDiscussSimpleInfoCallback);

    void getGroupAllInfo(long j3, GroupInfoSource groupInfoSource, IOperateCallback iOperateCallback);

    void getGroupArkInviteState(long j3, long j16, long j17, IOperateCallback iOperateCallback);

    void getGroupAvatarWall(long j3, IGroupAvatarWallCallback iGroupAvatarWallCallback);

    void getGroupBindGuilds(GetGroupBindGuildsReq getGroupBindGuildsReq, IGetGroupBindGuildsCallback iGetGroupBindGuildsCallback);

    void getGroupBulletin(long j3, IOperateCallback iOperateCallback);

    void getGroupBulletinList(long j3, String str, String str2, GroupBulletinListReq groupBulletinListReq, IOperateCallback iOperateCallback);

    void getGroupConfMember(long j3, boolean z16, IOperateCallback iOperateCallback);

    int getGroupDBVersion(int i3);

    void getGroupDetailInfo(long j3, GroupInfoSource groupInfoSource, IOperateCallback iOperateCallback);

    void getGroupDetailInfoByFilter(GroupDetailInfoReq groupDetailInfoReq, int i3, int i16, boolean z16, IGroupDetailInfoCallback iGroupDetailInfoCallback);

    void getGroupDetailInfoForMqq(long j3, int i3, int i16, boolean z16, IOperateCallback iOperateCallback);

    void getGroupExt0xEF0Info(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, GroupExtFilter groupExtFilter, boolean z16, IGroupExt0xEF0InfoCallback iGroupExt0xEF0InfoCallback);

    void getGroupExtList(boolean z16, IOperateCallback iOperateCallback);

    void getGroupFlagForThirdApp(ArrayList<Long> arrayList, IGetGroupFlagForThirdAppCallback iGetGroupFlagForThirdAppCallback);

    void getGroupHonorList(GroupMemberHonorReq groupMemberHonorReq, IGroupMemberHonorCallback iGroupMemberHonorCallback);

    void getGroupInfoForJoinGroup(long j3, boolean z16, int i3, IGroupInfoForJoinCallback iGroupInfoForJoinCallback);

    void getGroupInviteNoAuthLimitNum(ArrayList<Long> arrayList, IGetGroupInviteNoAuthLimitNumCallback iGetGroupInviteNoAuthLimitNumCallback);

    void getGroupLatestEssenceList(GetGroupLatestEssenceListReq getGroupLatestEssenceListReq, IGetGroupLatestEssenceListCallback iGetGroupLatestEssenceListCallback);

    void getGroupList(boolean z16, IOperateCallback iOperateCallback);

    void getGroupMedalList(GetGroupMedalListReq getGroupMedalListReq, IGetGroupMedalListCallback iGetGroupMedalListCallback);

    void getGroupMemberLevelInfo(long j3, IOperateCallback iOperateCallback);

    void getGroupMemberMaxNum(long j3, int i3, IGroupMemberMaxNumCallback iGroupMemberMaxNumCallback);

    void getGroupMsgLimitFreq(long j3, IGroupMsgLimitFreqCallback iGroupMsgLimitFreqCallback);

    void getGroupMsgMask(IOperateCallback iOperateCallback);

    void getGroupNotifiesUnreadCount(boolean z16, IOperateCallback iOperateCallback);

    void getGroupPayToJoinStatus(long j3, IGroupPayToJoinStatusCallback iGroupPayToJoinStatusCallback);

    void getGroupPlusAppList(GetAppListReq getAppListReq, IGetAppListCallback iGetAppListCallback);

    void getGroupPortrait(long j3, IOperateCallback iOperateCallback);

    void getGroupRecommendContactArkJson(long j3, IGetGroupRecommendContactArkJsonCallback iGetGroupRecommendContactArkJsonCallback);

    void getGroupRemainAtTimes(long j3, IGetGroupRemainAtAllTimesOperateCallback iGetGroupRemainAtAllTimesOperateCallback);

    void getGroupSecLevelInfo(long j3, int i3, IGroupSecLevelInfoCallback iGroupSecLevelInfoCallback);

    void getGroupSeqAndJoinTimeForGrayTips(long j3, IGroupInfoForGrayTipsCallback iGroupInfoForGrayTipsCallback);

    void getGroupShutUpMemberList(long j3, IOperateCallback iOperateCallback);

    void getGroupSquareHomeHead(long j3, String str, IGetHomeHeadCallback iGetHomeHeadCallback);

    void getGroupSquareRedpointInfo(GetGroupSquareRedpointInfoReq getGroupSquareRedpointInfoReq, boolean z16, IGetGroupSquareRedpointInfoCallback iGetGroupSquareRedpointInfoCallback);

    void getGroupStatisticInfo(long j3, IOperateCallback iOperateCallback);

    void getGroupTagRecords(long j3, IGroupTagRecordCallback iGroupTagRecordCallback);

    void getIdentityList(GetIdentityListReq getIdentityListReq, IGetIdentityListCallback iGetIdentityListCallback);

    void getIllegalMemberList(long j3, IGroupMemberIllegalInfoCallback iGroupMemberIllegalInfoCallback);

    void getJoinGroupLink(GroupLinkReq groupLinkReq, IGetJoinGroupLinkCallback iGetJoinGroupLinkCallback);

    void getJoinGroupNoVerifyFlag(long j3, String str, IOperateCallback iOperateCallback);

    void getMemberCommonInfo(GroupMemberCommonReq groupMemberCommonReq, IGroupMemberCommonCallback iGroupMemberCommonCallback);

    void getMemberExtInfo(GroupMemberExtReq groupMemberExtReq, IGroupMemberExtCallback iGroupMemberExtCallback);

    void getMemberInfo(long j3, ArrayList<String> arrayList, boolean z16, IOperateCallback iOperateCallback);

    void getMemberInfoForMqq(long j3, ArrayList<String> arrayList, boolean z16, IGroupMemberListCallback iGroupMemberListCallback);

    void getMemberInfoForMqqV2(long j3, ArrayList<String> arrayList, boolean z16, String str, IGroupMemberListCallback iGroupMemberListCallback);

    void getNextMemberList(String str, GroupMemberInfoListId groupMemberInfoListId, int i3, IGroupMemberListCallback iGroupMemberListCallback);

    void getPrevMemberList(String str, GroupMemberInfoListId groupMemberInfoListId, int i3, IGroupMemberListCallback iGroupMemberListCallback);

    void getRecGroups(long j3, GroupSquareTabItem groupSquareTabItem, String str, IGetRecGroupsCallback iGetRecGroupsCallback);

    void getSingleScreenNotifies(boolean z16, long j3, int i3, IOperateCallback iOperateCallback);

    void getSingleScreenNotifiesV2(boolean z16, long j3, int i3, int i16, IGetGroupSingleScreenNotifiesCallback iGetGroupSingleScreenNotifiesCallback);

    void getSubGroupInfo(GetSubGroupInfoReq getSubGroupInfoReq, IGetSubGroupInfoCallback iGetSubGroupInfoCallback);

    void getSwitchStatusForEssenceMsg(long j3, IGroupEssenceMsgSwitchCallback iGroupEssenceMsgSwitchCallback);

    void getTeamUpDetail(GetTeamUpDetailReq getTeamUpDetailReq, IGetTeamUpDetailCallback iGetTeamUpDetailCallback);

    void getTeamUpList(GetTeamUpListReq getTeamUpListReq, IGetTeamUpListCallback iGetTeamUpListCallback);

    void getTeamUpMembers(GetTeamUpMembersReq getTeamUpMembersReq, IGetTeamUpMembersCallback iGetTeamUpMembersCallback);

    void getTeamUpTemplateList(GetTeamUpTemplateListReq getTeamUpTemplateListReq, IGetTeamUpTemplateListCallback iGetTeamUpTemplateListCallback);

    void getTopicPage(long j3, long j16, String str, String str2, IGetTopicPageCallback iGetTopicPageCallback);

    void getTopicRecall(TopicRecallReq topicRecallReq, ITopicRecallCallback iTopicRecallCallback);

    void getTransferableMemberInfo(long j3, IGetTransferableMemberCallback iGetTransferableMemberCallback);

    void getUidByUins(ArrayList<Long> arrayList, IGroupMemberUidCallback iGroupMemberUidCallback);

    void getUinByUids(ArrayList<String> arrayList, IGroupMemberUinCallback iGroupMemberUinCallback);

    void getWxNotifyStatus(ArrayList<Long> arrayList, IGetGroupWxNotifyStatusCallback iGetGroupWxNotifyStatusCallback);

    void groupBlacklistDelApply(GroupBlacklistDelApplyReq groupBlacklistDelApplyReq, IGroupBlacklistDelApplyCallback iGroupBlacklistDelApplyCallback);

    void groupBlacklistGetAllApply(GroupBlacklistGetAllApplyReq groupBlacklistGetAllApplyReq, IGroupBlacklistGetAllApplyCallback iGroupBlacklistGetAllApplyCallback);

    void halfScreenPullNotice(HalfScreenPullNoticeReq halfScreenPullNoticeReq, IHalfScreenPullNoticeCallback iHalfScreenPullNoticeCallback);

    void halfScreenReportClick(HalfScreenReportClickReq halfScreenReportClickReq, IOperateCallback iOperateCallback);

    void inviteMembersToGroup(long j3, HashMap<String, Long> hashMap, IOperateCallback iOperateCallback);

    void inviteMembersToGroupWithMsg(long j3, HashMap<String, Long> hashMap, ArrayList<ShareMsgInfo> arrayList, IOperateCallback iOperateCallback);

    void inviteToGroup(long j3, ArrayList<String> arrayList, IOperateCallback iOperateCallback);

    void inviteToGroupV2(InviteGroupReq inviteGroupReq, IInviteToGroupCallback iInviteToGroupCallback);

    void isEssenceMsg(EssenceKey essenceKey, ICheckEssenceCallback iCheckEssenceCallback);

    void joinGroup(ReqToGroup reqToGroup, IJoinGroupCallback iJoinGroupCallback);

    void kickMember(long j3, ArrayList<String> arrayList, boolean z16, String str, IKickMemberOperateCallback iKickMemberOperateCallback);

    void kickMemberV2(KickMemberReq kickMemberReq, IKickMemberCallback iKickMemberCallback);

    void listAllAIVoice(ListAllVoiceReq listAllVoiceReq, IListAllVoiceCallback iListAllVoiceCallback);

    void miniAppGetGroupInfo(MiniAppGetGroupInfoReq miniAppGetGroupInfoReq, IMiniAppGetGroupInfoCallback iMiniAppGetGroupInfoCallback);

    void modifyGroupDetailInfo(long j3, GroupModifyInfo groupModifyInfo, IOperateCallback iOperateCallback);

    void modifyGroupDetailInfoV2(GroupModifyInfoReq groupModifyInfoReq, int i3, IOperateCallback iOperateCallback);

    void modifyGroupExtInfo(GroupExtInfo groupExtInfo, IOperateCallback iOperateCallback);

    void modifyGroupExtInfoV2(GroupExtInfo groupExtInfo, GroupExtFilter groupExtFilter, IModifyGroupExtCallback iModifyGroupExtCallback);

    void modifyGroupName(long j3, String str, boolean z16, IOperateCallback iOperateCallback);

    void modifyGroupRemark(long j3, String str, IOperateCallback iOperateCallback);

    void modifyMemberCardName(long j3, String str, String str2, IOperateCallback iOperateCallback);

    void modifyMemberRole(long j3, String str, MemberRole memberRole, IOperateCallback iOperateCallback);

    void modifyWxNotifyStatus(long j3, GroupWxNotifyStatus groupWxNotifyStatus, IOperateCallback iOperateCallback);

    void monitorMemberList(String str, GroupMemberInfoListId groupMemberInfoListId, GroupMemberInfoListId groupMemberInfoListId2);

    void operateSysNotify(boolean z16, GroupNotifyOperateMsg groupNotifyOperateMsg, IOperateCallback iOperateCallback);

    void operateSysNotifyV2(boolean z16, GroupNotifyOperateMsg groupNotifyOperateMsg, IGroupNotifyOperateCallback iGroupNotifyOperateCallback);

    void postTeamUp(PostTeamUpReq postTeamUpReq, IPostTeamUpCallback iPostTeamUpCallback);

    void publishGroupBulletin(long j3, String str, GroupBulletinPublishReq groupBulletinPublishReq, IOperateCallback iOperateCallback);

    void publishInstructionForNewcomers(long j3, String str, GroupBulletinPublishReq groupBulletinPublishReq, IOperateCallback iOperateCallback);

    void queryAIOBindGuild(QueryAIOBindGuildReq queryAIOBindGuildReq, IQueryAIOBindGuildCallback iQueryAIOBindGuildCallback);

    void queryCachedEssenceMsg(EssenceKey essenceKey, IQueryCachedEssenceCallback iQueryCachedEssenceCallback);

    void queryGroupTopBanners(QueryGroupTopBannersReq queryGroupTopBannersReq, IQueryGroupTopBannersCallback iQueryGroupTopBannersCallback);

    void queryJoinGroupCanNoVerify(JoinGroupVerifyReq joinGroupVerifyReq, IJoinGroupVerifyCallback iJoinGroupVerifyCallback);

    void quitGroup(long j3, IOperateCallback iOperateCallback);

    void quitGroupV2(QuitGroupReq quitGroupReq, IOperateCallback iOperateCallback);

    void removeGroupEssence(DigestReq digestReq, IDigestCallback iDigestCallback);

    void removeGroupFromGroupList(long j3);

    void removeKernelGroupListener(long j3);

    void reqToJoinGroup(ReqToGroup reqToGroup, IOperateCallback iOperateCallback);

    void saveAIVoice(SaveVoiceReq saveVoiceReq, ISaveVoiceCallback iSaveVoiceCallback);

    void searchMember(String str, String str2, IOperateCallback iOperateCallback);

    void setAIOBindGuild(SetAIOBindGuildReq setAIOBindGuildReq, ISetAIOBindGuildCallback iSetAIOBindGuildCallback);

    void setActiveExtGroup(ActiveExtGroupReq activeExtGroupReq, IOperateCallback iOperateCallback);

    void setCapsuleSwitch(SetCapsuleSwitchReq setCapsuleSwitchReq, IOperateCallback iOperateCallback);

    void setGroupAppList(SetGroupAppListReq setGroupAppListReq, IOperateCallback iOperateCallback);

    void setGroupGeoInfo(GroupGeoInfoReq groupGeoInfoReq, IOperateCallback iOperateCallback);

    void setGroupMsgMask(long j3, GroupMsgMask groupMsgMask, IOperateCallback iOperateCallback);

    void setGroupMsgMaskV2(SetGroupMsgMaskReq setGroupMsgMaskReq, int i3, ISetGroupMsgMaskCallback iSetGroupMsgMaskCallback);

    void setGroupRelationToGuild(SetGroupRelationToGuildReq setGroupRelationToGuildReq, ISetGroupRelationToGuildCallback iSetGroupRelationToGuildCallback);

    void setGroupShutUp(long j3, boolean z16, IOperateCallback iOperateCallback);

    void setIdentityInteractionTag(SetIdentityInteractionTagReq setIdentityInteractionTagReq, IOperateCallback iOperateCallback);

    void setIdentityTitleInfo(SetIdentityTitleInfoReq setIdentityTitleInfoReq, IOperateCallback iOperateCallback);

    void setMemberShutUp(long j3, ArrayList<GroupMemberShutUpInfo> arrayList, IOperateCallback iOperateCallback);

    void setRcvJoinVerifyMsg(RcvJoinVerifyMsgReq rcvJoinVerifyMsgReq, IRcvJoinVerifyMsgCallback iRcvJoinVerifyMsgCallback);

    void setTop(long j3, boolean z16, IOperateCallback iOperateCallback);

    void shareTopic(ShareTopicReq shareTopicReq, IShareTopicCallback iShareTopicCallback);

    void teamUpCreateGroup(TeamUpCreateGroupReq teamUpCreateGroupReq, ITeamUpCreateGroupCallback iTeamUpCreateGroupCallback);

    void teamUpInviteToGroup(TeamUpInviteToGroupReq teamUpInviteToGroupReq, IOperateCallback iOperateCallback);

    void teamUpRequestToJoin(TeamUpRequestToJoinReq teamUpRequestToJoinReq, ITeamUpRequestToJoinCallback iTeamUpRequestToJoinCallback);

    void teamUpSubmitDeadline(TeamUpSubmitDeadlineReq teamUpSubmitDeadlineReq, IOperateCallback iOperateCallback);

    void topicFeedback(TopicFeedbackReq topicFeedbackReq, IOperateCallback iOperateCallback);

    void topicReport(TopicReportReq topicReportReq, ITopicReportCallback iTopicReportCallback);

    void transferGroup(long j3, String str, String str2, IOperateCallback iOperateCallback);

    void transferGroupV2(long j3, String str, String str2, ITransferGroupCallback iTransferGroupCallback);

    void unbindAllGuilds(UnbindAllGuildsReq unbindAllGuildsReq, IUnbindAllGuildsCallback iUnbindAllGuildsCallback);

    void updateGroupInfoByMqq(GroupInfoCacheReq groupInfoCacheReq);

    void updateMemberInfoByMqq(GroupMemberCacheReq groupMemberCacheReq);

    void updateTeamUp(UpdateTeamUpReq updateTeamUpReq, IOperateCallback iOperateCallback);

    void uploadGroupBulletinPic(long j3, String str, String str2, IUploadGroupBulletinPicCallback iUploadGroupBulletinPicCallback);
}
