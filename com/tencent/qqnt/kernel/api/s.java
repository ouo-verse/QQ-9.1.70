package com.tencent.qqnt.kernel.api;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.ActiveExtGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.BatchQueryCachedGroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.ConsumeGroupTopBannerReq;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupProfileShareReq;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.DestroyGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAIOBindGuildInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAppCenterReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAppListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetCapsuleAppReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupBindGuildsReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupMedalListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetSubGroupInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpMembersReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpTemplateListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistDelApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistGetAllApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoCacheReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCacheReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberShutUpInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareTabItem;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenPullNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.HalfScreenReportClickReq;
import com.tencent.qqnt.kernel.nativeinterface.IBatchQueryCachedGroupDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICreateGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICreateGroupProfileShareCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIOBindGuildInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAppCenterCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAppListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetCapsuleAppProCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupBindGuildsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupLatestEssenceListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupMedalListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRemainAtAllTimesOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSingleScreenNotifiesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSquareRedpointInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetHomeHeadCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetIdentityListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecGroupsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSubGroupInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpMembersCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpTemplateListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTopicPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetVoiceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupBlacklistDelApplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupBlacklistGetAllApplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupExt0xEF0InfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupInfoForGrayTipsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupInfoForJoinCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberCommonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberIllegalInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberMaxNumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberUidCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberUinCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMsgLimitFreqCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupNotifyOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupPayToJoinStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupPrivilegeFlagCallback;
import com.tencent.qqnt.kernel.nativeinterface.IHalfScreenPullNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IInviteToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IJoinGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.IKickMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.IListAllVoiceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMiniAppGetGroupInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IModifyGroupExtCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPostTeamUpCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryGroupTopBannersCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRcvJoinVerifyMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISaveVoiceCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAIOBindGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetGroupRelationToGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.IShareTopicCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITeamUpCreateGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITeamUpRequestToJoinCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITopicRecallCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITopicReportCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITransferGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUnbindAllGuildsCallback;
import com.tencent.qqnt.kernel.nativeinterface.InviteGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.InviteMemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickMemberReq;
import com.tencent.qqnt.kernel.nativeinterface.ListAllVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.MiniAppGetGroupInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryGroupTopBannersReq;
import com.tencent.qqnt.kernel.nativeinterface.QuitGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.RcvJoinVerifyMsgReq;
import com.tencent.qqnt.kernel.nativeinterface.ReqToGroup;
import com.tencent.qqnt.kernel.nativeinterface.SaveVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.SetAIOBindGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.SetCapsuleSwitchReq;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupAppListReq;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupMsgMaskReq;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupRelationToGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.SetIdentityInteractionTagReq;
import com.tencent.qqnt.kernel.nativeinterface.SetIdentityTitleInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.ShareTopicReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpCreateGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpInviteToGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpRequestToJoinReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpSubmitDeadlineReq;
import com.tencent.qqnt.kernel.nativeinterface.TopicFeedbackReq;
import com.tencent.qqnt.kernel.nativeinterface.TopicRecallReq;
import com.tencent.qqnt.kernel.nativeinterface.TopicReportReq;
import com.tencent.qqnt.kernel.nativeinterface.UnbindAllGuildsReq;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014H&J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0017H&JB\u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J:\u0010 \u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\u0010\n\u001a\u0004\u0018\u00010#H&J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u0010)\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J2\u0010/\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020*2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010.H&J*\u00102\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0006\u0010,\u001a\u00020+2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u00108\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u0010;\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u0002092\u0006\u0010,\u001a\u00020+2\b\u0010\n\u001a\u0004\u0018\u00010:H&J\u001a\u0010?\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\b\u0010\u000f\u001a\u0004\u0018\u00010>H&J2\u0010D\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020@2\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020A0\u0019j\b\u0012\u0004\u0012\u00020A`\u001b2\b\u0010\n\u001a\u0004\u0018\u00010CH&J\u001a\u0010G\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\tH&J\u001a\u0010I\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020H2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J*\u0010M\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u001a2\u0006\u0010K\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010LH&J \u0010O\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tH&J\u001a\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u0010S\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\f2\u0006\u0010R\u001a\u00020+2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\"\u0010W\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\f2\u0006\u0010U\u001a\u00020T2\b\u0010\n\u001a\u0004\u0018\u00010VH&J\"\u0010Y\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\f2\b\u0010F\u001a\u0004\u0018\u00010\tH&J\u001a\u0010[\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u001aH&J\u0010\u0010]\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u001aH&J*\u0010a\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u001a2\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010`\u001a\u00020+2\u0006\u0010F\u001a\u00020\u000eH&J \u0010c\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u001a2\u0006\u0010b\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\tH&J\u001a\u0010e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010dH&J\u0019\u0010g\u001a\u0004\u0018\u00010+2\u0006\u0010f\u001a\u00020+H&\u00a2\u0006\u0004\bg\u0010hJ*\u0010k\u001a\u00020\u00042\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010jH&J*\u0010m\u001a\u00020\u00042\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010lH&J\u0010\u0010p\u001a\u00020\u00042\u0006\u0010o\u001a\u00020nH&J\u001a\u0010s\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020q2\b\u0010\u000f\u001a\u0004\u0018\u00010rH&J\u001a\u0010v\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020t2\b\u0010\u000f\u001a\u0004\u0018\u00010uH&J\u001a\u0010y\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020w2\b\u0010\u000f\u001a\u0004\u0018\u00010xH&J\u001a\u0010|\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020z2\b\u0010\u000f\u001a\u0004\u0018\u00010{H&J\u001a\u0010\u007f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020}2\b\u0010\u000f\u001a\u0004\u0018\u00010~H&J\u001d\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0080\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u0081\u0001H&J\u001c\u0010\u0084\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\t\u0010\u000f\u001a\u0005\u0018\u00010\u0083\u0001H&J%\u0010\u0087\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u001a2\t\u0010\u000f\u001a\u0005\u0018\u00010\u0086\u0001H&J%\u0010\u008a\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0088\u00012\u0006\u0010\r\u001a\u00020\f2\t\u0010\u000f\u001a\u0005\u0018\u00010\u0089\u0001H&J\u0011\u0010\u008b\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J/\u0010\u0090\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u008d\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u001a2\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u0001H&J7\u0010\u0093\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0007\u0010\u0091\u0001\u001a\u00020\u00072\u0007\u0010\u008e\u0001\u001a\u00020\u001a2\u0007\u0010\u0085\u0001\u001a\u00020\u001a2\t\u0010\u000f\u001a\u0005\u0018\u00010\u0092\u0001H&J\u001d\u0010\u0096\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0094\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u0095\u0001H&J6\u0010\u0099\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0019\u0010\u0098\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0097\u00010\u0019j\t\u0012\u0005\u0012\u00030\u0097\u0001`\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001e\u0010\u009d\u0001\u001a\u00020\u00042\b\u0010\u009b\u0001\u001a\u00030\u009a\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u009c\u0001H&J\u001c\u0010\u009f\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u009e\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001d\u0010\u00a2\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00a0\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00a1\u0001H&J\u001c\u0010\u00a4\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00a3\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J5\u0010\u00a7\u0001\u001a\u00020\u00042\u0017\u0010\u00a5\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001b2\u0006\u0010,\u001a\u00020+2\t\u0010\u000f\u001a\u0005\u0018\u00010\u00a6\u0001H&J$\u0010\u00a9\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\t\u0010\u000f\u001a\u0005\u0018\u00010\u00a8\u0001H&J\u001c\u0010\u00ab\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\t\u0010\u000f\u001a\u0005\u0018\u00010\u00aa\u0001H&J-\u0010\u00ae\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0007\u0010\u00ac\u0001\u001a\u00020\f2\u0006\u0010,\u001a\u00020+2\t\u0010\u000f\u001a\u0005\u0018\u00010\u00ad\u0001H&J\u001c\u0010\u00b0\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\t\u0010\u000f\u001a\u0005\u0018\u00010\u00af\u0001H&J\u001c\u0010\u00b2\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\t\u0010\u000f\u001a\u0005\u0018\u00010\u00b1\u0001H&J(\u0010\u00b8\u0001\u001a\u00020\u00042\b\u0010\u00b4\u0001\u001a\u00030\u00b3\u00012\b\u0010\u00b6\u0001\u001a\u00030\u00b5\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00b7\u0001H&J\u001d\u0010\u00bb\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00b9\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00ba\u0001H&J\u0012\u0010\u00bd\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00bc\u0001H&J\u001b\u0010\u00be\u0001\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&JX\u0010\u00c2\u0001\u001a\u00020\u00042\u0017\u0010\u00bf\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001b2\u0017\u0010\u00c0\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0019j\b\u0012\u0004\u0012\u00020\u0007`\u001b2\b\u0010\u00b6\u0001\u001a\u00030\u00b5\u00012\u0006\u0010\r\u001a\u00020\f2\t\u0010\n\u001a\u0005\u0018\u00010\u00c1\u0001H&J\u001c\u0010\u00c4\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00c3\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001d\u0010\u00c7\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00c5\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00c6\u0001H&J\u001d\u0010\u00ca\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00c8\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00c9\u0001H&J\u001d\u0010\u00cd\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00cb\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00cc\u0001H&J\u001d\u0010\u00d0\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00ce\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00cf\u0001H&J\u001d\u0010\u00d3\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00d1\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00d2\u0001H&J\u001d\u0010\u00d6\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00d4\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00d5\u0001H&J\u001c\u0010\u00d8\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00d7\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001d\u0010\u00db\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00d9\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00da\u0001H&J\u001c\u0010\u00dd\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00dc\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001d\u0010\u00e0\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00de\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00df\u0001H&J\u001c\u0010\u00e2\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00e1\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001b\u0010\u00e5\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00e3\u00012\u0007\u0010\u000f\u001a\u00030\u00e4\u0001H&J\u001b\u0010\u00e8\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00e6\u00012\u0007\u0010\u000f\u001a\u00030\u00e7\u0001H&J\u001d\u0010\u00eb\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00e9\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00ea\u0001H&J\u001c\u0010\u00ed\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00ec\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001d\u0010\u00f0\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00ee\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00ef\u0001H&J\u001d\u0010\u00f3\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00f1\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u00f2\u0001H&J\u001b\u0010\u00f6\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00f4\u00012\u0007\u0010\u000f\u001a\u00030\u00f5\u0001H&J\u001b\u0010\u00f9\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00f7\u00012\u0007\u0010\u000f\u001a\u00030\u00f8\u0001H&J\u001b\u0010\u00fc\u0001\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00fa\u00012\u0007\u0010\u000f\u001a\u00030\u00fb\u0001H&J'\u0010\u00ff\u0001\u001a\u00020\u00042\t\u0010\u0013\u001a\u0005\u0018\u00010\u00fd\u00012\u0006\u0010\r\u001a\u00020\f2\t\u0010\u000f\u001a\u0005\u0018\u00010\u00fe\u0001H&J\u001e\u0010\u0081\u0002\u001a\u00020\u00042\t\u0010\u0013\u001a\u0005\u0018\u00010\u0080\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u0011\u0010\u0082\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J6\u0010\u0086\u0002\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\f2\u0007\u0010\u0083\u0002\u001a\u00020\u00072\u0007\u0010\u0084\u0002\u001a\u00020+2\u0006\u0010R\u001a\u00020+2\t\u0010\n\u001a\u0005\u0018\u00010\u0085\u0002H&J\u001b\u0010\u0087\u0002\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001b\u0010\u008a\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0088\u00022\u0007\u0010\u000f\u001a\u00030\u0089\u0002H&J\u001f\u0010\u008d\u0002\u001a\u00020\u00042\t\u0010\u0013\u001a\u0005\u0018\u00010\u008b\u00022\t\u0010\u000f\u001a\u0005\u0018\u00010\u008c\u0002H&J\u001b\u0010\u0090\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u008e\u00022\u0007\u0010\u000f\u001a\u00030\u008f\u0002H&J\u001a\u0010\u0092\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0091\u00022\u0006\u0010\u000f\u001a\u00020\tH&J\u001b\u0010\u0095\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0093\u00022\u0007\u0010\u000f\u001a\u00030\u0094\u0002H&J\u001b\u0010\u0098\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0096\u00022\u0007\u0010\u000f\u001a\u00030\u0097\u0002H&J\u001a\u0010\u009a\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u0099\u00022\u0006\u0010\u000f\u001a\u00020\tH&J\u001a\u0010\u009c\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u009b\u00022\u0006\u0010\u000f\u001a\u00020\tH&J\u001b\u0010\u009f\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u009d\u00022\u0007\u0010\u000f\u001a\u00030\u009e\u0002H&J\u001a\u0010\u00a1\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00a0\u00022\u0006\u0010\u000f\u001a\u00020\tH&J\u001b\u0010\u00a4\u0002\u001a\u00020\u00042\u0007\u0010\u0013\u001a\u00030\u00a2\u00022\u0007\u0010\u000f\u001a\u00030\u00a3\u0002H&\u00a8\u0006\u00a5\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/api/s;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "listener", "", "D", "x0", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "N", "", "forceFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberListCallback;", "callback", "getAllMemberList", "getAllMemberListV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberCommonCallback;", "getMemberCommonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberExtCallback;", "getMemberExtInfo", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "from", "e", "forceUpdate", "getMemberInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/KickMemberReq;", "kickReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IKickMemberCallback;", "kickMemberV2", "getGroupList", "getGroupExtList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupInfoSource;", "source", "getGroupDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "", "serviceType", "callFrom", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupDetailInfoCallback;", "getGroupDetailInfoByFilter", "groupName", "isConf", "modifyGroupName", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfoReq;", "modifyInfoReq", "modifyGroupDetailInfoV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "msgMask", "setGroupMsgMask", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupMsgMaskReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupMsgMaskCallback;", "setGroupMsgMaskV2", "Lcom/tencent/qqnt/kernel/nativeinterface/InviteGroupReq;", "inviteReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IInviteToGroupCallback;", "inviteToGroupV2", "Lcom/tencent/qqnt/kernel/nativeinterface/CreateGroupReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/InviteMemberInfo;", "membersInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupCallback;", "createGroupV2", "Lcom/tencent/qqnt/kernel/nativeinterface/QuitGroupReq;", "result", "quitGroupV2", "Lcom/tencent/qqnt/kernel/nativeinterface/DestroyGroupReq;", "destroyGroupV2", "oldOwnerUid", "newOwnerUid", "Lcom/tencent/qqnt/kernel/nativeinterface/ITransferGroupCallback;", "transferGroupV2", "groupRemark", "modifyGroupRemark", "doubt", "clearGroupNotifiesUnreadCount", "category", "clearGroupNotifyLocalUnreadCount", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateMsg;", "operateMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupNotifyOperateCallback;", "operateSysNotifyV2", "isTop", "setTop", "scene", "createMemberListScene", WadlProxyConsts.SCENE_ID, "destroyMemberListScene", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberInfoListId;", "lastId", WidgetCacheConstellationData.NUM, "getNextMemberList", "keyword", "searchMember", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRemainAtAllTimesOperateCallback;", "getGroupRemainAtTimes", "tableId", "getGroupDBVersion", "(I)Ljava/lang/Integer;", "uins", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUidCallback;", "getUidByUins", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUinCallback;", "getUinByUids", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCacheReq;", "memberInfoReq", "updateMemberInfoByMqq", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupRelationToGuildReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupRelationToGuildCallback;", "setGroupRelationToGuild", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupBindGuildsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupBindGuildsCallback;", "getGroupBindGuilds", "Lcom/tencent/qqnt/kernel/nativeinterface/UnbindAllGuildsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnbindAllGuildsCallback;", "unbindAllGuilds", "Lcom/tencent/qqnt/kernel/nativeinterface/SetAIOBindGuildReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAIOBindGuildCallback;", "setAIOBindGuild", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAIOBindGuildInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIOBindGuildInfoCallback;", "getAIOBindGuildInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GetSubGroupInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSubGroupInfoCallback;", "getSubGroupInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberIllegalInfoCallback;", "getIllegalMemberList", "ext", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetHomeHeadCallback;", "h0", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSquareRedpointInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSquareRedpointInfoCallback;", "getGroupSquareRedpointInfo", "clearGroupSquareRedpointCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareTabItem;", "tab", "cookies", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecGroupsCallback;", "getRecGroups", "bannerId", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTopicPageCallback;", "getTopicPage", "Lcom/tencent/qqnt/kernel/nativeinterface/ShareTopicReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IShareTopicCallback;", "shareTopic", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberShutUpInfo;", "memList", "setMemberShutUp", "Lcom/tencent/qqnt/kernel/nativeinterface/ReqToGroup;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IJoinGroupCallback;", "joinGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/ActiveExtGroupReq;", "setActiveExtGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/RcvJoinVerifyMsgReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRcvJoinVerifyMsgCallback;", "setRcvJoinVerifyMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGeoInfoReq;", "setGroupGeoInfo", "groupCodes", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPrivilegeFlagCallback;", "getAllGroupPrivilegeFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberMaxNumCallback;", "getGroupMemberMaxNum", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForGrayTipsCallback;", "getGroupSeqAndJoinTimeForGrayTips", "needPrivilegeFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForJoinCallback;", "getGroupInfoForJoinGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPayToJoinStatusCallback;", "getGroupPayToJoinStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMsgLimitFreqCallback;", "getGroupMsgLimitFreq", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "extInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFilter;", "filter", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyGroupExtCallback;", "modifyGroupExtInfoV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupLatestEssenceListCallback;", "getGroupLatestEssenceList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupInfoCacheReq;", "updateGroupInfoByMqq", "getGroupMemberLevelInfo", "enableGroupCodes", "bannedGroupCodes", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupExt0xEF0InfoCallback;", "E0", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupAppListReq;", "setGroupAppList", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchQueryCachedGroupDetailInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchQueryCachedGroupDetailInfoCallback;", "batchQueryCachedGroupDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpListCallback;", "getTeamUpList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpDetailCallback;", "getTeamUpDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpTemplateListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpTemplateListCallback;", "getTeamUpTemplateList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpMembersReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpMembersCallback;", "getTeamUpMembers", "Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPostTeamUpCallback;", "postTeamUp", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpApplyReq;", "applyTeamUp", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpCreateGroupReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITeamUpCreateGroupCallback;", "teamUpCreateGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpInviteToGroupReq;", "teamUpInviteToGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpRequestToJoinReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITeamUpRequestToJoinCallback;", "teamUpRequestToJoin", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpSubmitDeadlineReq;", "teamUpSubmitDeadline", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBlacklistGetAllApplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupBlacklistGetAllApplyCallback;", "groupBlacklistGetAllApply", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBlacklistDelApplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupBlacklistDelApplyCallback;", "groupBlacklistDelApply", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicRecallReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITopicRecallCallback;", "getTopicRecall", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicFeedbackReq;", "topicFeedback", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicReportReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITopicReportCallback;", "topicReport", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppCenterReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAppCenterCallback;", "getAppCenter", "Lcom/tencent/qqnt/kernel/nativeinterface/GetVoiceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetVoiceCallback;", "getAICommonVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/ListAllVoiceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IListAllVoiceCallback;", "listAllAIVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/SaveVoiceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISaveVoiceCallback;", "saveAIVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCapsuleAppReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetCapsuleAppProCallback;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/SetCapsuleSwitchReq;", BdhLogUtil.LogTag.Tag_Conn, "cleanCapsuleCache", "startSeq", "number", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSingleScreenNotifiesCallback;", "getSingleScreenNotifiesV2", "clearGroupNotifies", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupMedalListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupMedalListCallback;", "getGroupMedalList", "Lcom/tencent/qqnt/kernel/nativeinterface/MiniAppGetGroupInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IMiniAppGetGroupInfoCallback;", "miniAppGetGroupInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenPullNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IHalfScreenPullNoticeCallback;", "halfScreenPullNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenReportClickReq;", "halfScreenReportClick", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAppListCallback;", "getGroupPlusAppList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetIdentityListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetIdentityListCallback;", "getIdentityList", "Lcom/tencent/qqnt/kernel/nativeinterface/SetIdentityTitleInfoReq;", "setIdentityTitleInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SetIdentityInteractionTagReq;", "setIdentityInteractionTag", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryGroupTopBannersReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryGroupTopBannersCallback;", "queryGroupTopBanners", "Lcom/tencent/qqnt/kernel/nativeinterface/ConsumeGroupTopBannerReq;", "consumeGroupTopBanner", "Lcom/tencent/qqnt/kernel/nativeinterface/CreateGroupProfileShareReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupProfileShareCallback;", "createGroupProfileShare", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface s extends j {
    void C(@Nullable SetCapsuleSwitchReq req, @Nullable IOperateCallback callback);

    void D(@Nullable IKernelGroupListener listener);

    void E0(@NotNull ArrayList<Long> enableGroupCodes, @NotNull ArrayList<Long> bannedGroupCodes, @NotNull GroupExtFilter filter, boolean forceFetch, @Nullable IGroupExt0xEF0InfoCallback cb5);

    void N(long groupCode, @Nullable IOperateCallback cb5);

    void applyTeamUp(@NotNull TeamUpApplyReq req, @Nullable IOperateCallback callback);

    void batchQueryCachedGroupDetailInfo(@NotNull BatchQueryCachedGroupDetailInfoReq req, @Nullable IBatchQueryCachedGroupDetailInfoCallback callback);

    void cleanCapsuleCache(long groupCode);

    void clearGroupNotifies(boolean doubt, @Nullable IOperateCallback cb5);

    void clearGroupNotifiesUnreadCount(boolean doubt, @Nullable IOperateCallback cb5);

    void clearGroupNotifyLocalUnreadCount(boolean doubt, int category, @Nullable IOperateCallback cb5);

    void clearGroupSquareRedpointCache(long groupCode);

    void consumeGroupTopBanner(@NotNull ConsumeGroupTopBannerReq req, @NotNull IOperateCallback callback);

    void createGroupProfileShare(@NotNull CreateGroupProfileShareReq req, @NotNull ICreateGroupProfileShareCallback callback);

    void createGroupV2(@NotNull CreateGroupReq req, @NotNull ArrayList<InviteMemberInfo> membersInfo, @Nullable ICreateGroupCallback cb5);

    @Nullable
    String createMemberListScene(long groupCode, @NotNull String scene);

    void destroyGroupV2(@NotNull DestroyGroupReq req, @Nullable IOperateCallback cb5);

    void destroyMemberListScene(@NotNull String sceneId);

    void e(long groupCode, @NotNull ArrayList<String> uids, boolean forceFetch, @NotNull String from, @Nullable IGroupMemberListCallback callback);

    void getAICommonVoice(@NotNull GetVoiceReq req, @NotNull IGetVoiceCallback callback);

    void getAIOBindGuildInfo(@NotNull GetAIOBindGuildInfoReq req, @Nullable IGetAIOBindGuildInfoCallback callback);

    void getAllGroupPrivilegeFlag(@NotNull ArrayList<Long> groupCodes, int serviceType, @Nullable IGroupPrivilegeFlagCallback callback);

    void getAllMemberList(long groupCode, boolean forceFetch, @Nullable IGroupMemberListCallback callback);

    void getAllMemberListV2(long groupCode, boolean forceFetch, @Nullable IGroupMemberListCallback callback);

    void getAppCenter(@NotNull GetAppCenterReq req, @Nullable IGetAppCenterCallback callback);

    void getGroupBindGuilds(@NotNull GetGroupBindGuildsReq req, @Nullable IGetGroupBindGuildsCallback callback);

    @Nullable
    Integer getGroupDBVersion(int tableId);

    void getGroupDetailInfo(long groupCode, @NotNull GroupInfoSource source, @Nullable IOperateCallback cb5);

    void getGroupDetailInfoByFilter(@NotNull GroupDetailInfoReq req, int serviceType, int callFrom, boolean forceFetch, @Nullable IGroupDetailInfoCallback callback);

    void getGroupExtList(boolean forceFetch, @Nullable IOperateCallback cb5);

    void getGroupInfoForJoinGroup(long groupCode, boolean needPrivilegeFlag, int serviceType, @Nullable IGroupInfoForJoinCallback callback);

    void getGroupLatestEssenceList(@NotNull GetGroupLatestEssenceListReq req, @Nullable IGetGroupLatestEssenceListCallback callback);

    void getGroupList(boolean forceFetch, @Nullable IOperateCallback cb5);

    void getGroupMedalList(@NotNull GetGroupMedalListReq req, @NotNull IGetGroupMedalListCallback callback);

    void getGroupMemberLevelInfo(long groupCode, @Nullable IOperateCallback cb5);

    void getGroupMemberMaxNum(long groupCode, int serviceType, @Nullable IGroupMemberMaxNumCallback callback);

    void getGroupMsgLimitFreq(long groupCode, @Nullable IGroupMsgLimitFreqCallback callback);

    void getGroupPayToJoinStatus(long groupCode, @Nullable IGroupPayToJoinStatusCallback callback);

    void getGroupPlusAppList(@NotNull GetAppListReq req, @NotNull IGetAppListCallback callback);

    void getGroupRemainAtTimes(long groupCode, @Nullable IGetGroupRemainAtAllTimesOperateCallback cb5);

    void getGroupSeqAndJoinTimeForGrayTips(long groupCode, @Nullable IGroupInfoForGrayTipsCallback callback);

    void getGroupSquareRedpointInfo(@NotNull GetGroupSquareRedpointInfoReq req, boolean forceFetch, @Nullable IGetGroupSquareRedpointInfoCallback callback);

    void getIdentityList(@NotNull GetIdentityListReq req, @NotNull IGetIdentityListCallback callback);

    void getIllegalMemberList(long groupCode, @Nullable IGroupMemberIllegalInfoCallback callback);

    void getMemberCommonInfo(@NotNull GroupMemberCommonReq req, @Nullable IGroupMemberCommonCallback callback);

    void getMemberExtInfo(@NotNull GroupMemberExtReq req, @Nullable IGroupMemberExtCallback callback);

    void getMemberInfo(long groupCode, @NotNull ArrayList<String> uids, boolean forceUpdate, @Nullable IOperateCallback cb5);

    void getNextMemberList(@NotNull String sceneId, @Nullable GroupMemberInfoListId lastId, int num, @NotNull IGroupMemberListCallback result);

    void getRecGroups(long groupCode, @NotNull GroupSquareTabItem tab, @NotNull String cookies, @Nullable IGetRecGroupsCallback callback);

    void getSingleScreenNotifiesV2(boolean doubt, long startSeq, int number, int category, @Nullable IGetGroupSingleScreenNotifiesCallback cb5);

    void getSubGroupInfo(@NotNull GetSubGroupInfoReq req, @Nullable IGetSubGroupInfoCallback callback);

    void getTeamUpDetail(@NotNull GetTeamUpDetailReq req, @Nullable IGetTeamUpDetailCallback callback);

    void getTeamUpList(@NotNull GetTeamUpListReq req, @Nullable IGetTeamUpListCallback callback);

    void getTeamUpMembers(@NotNull GetTeamUpMembersReq req, @Nullable IGetTeamUpMembersCallback callback);

    void getTeamUpTemplateList(@NotNull GetTeamUpTemplateListReq req, @Nullable IGetTeamUpTemplateListCallback callback);

    void getTopicPage(long groupCode, long bannerId, @NotNull String cookies, @NotNull String ext, @Nullable IGetTopicPageCallback callback);

    void getTopicRecall(@NotNull TopicRecallReq req, @Nullable ITopicRecallCallback callback);

    void getUidByUins(@NotNull ArrayList<Long> uins, @Nullable IGroupMemberUidCallback callback);

    void getUinByUids(@NotNull ArrayList<String> uids, @Nullable IGroupMemberUinCallback callback);

    void groupBlacklistDelApply(@NotNull GroupBlacklistDelApplyReq req, @NotNull IGroupBlacklistDelApplyCallback callback);

    void groupBlacklistGetAllApply(@NotNull GroupBlacklistGetAllApplyReq req, @NotNull IGroupBlacklistGetAllApplyCallback callback);

    void h0(long groupCode, @NotNull String ext, @Nullable IGetHomeHeadCallback callback);

    void halfScreenPullNotice(@NotNull HalfScreenPullNoticeReq req, @NotNull IHalfScreenPullNoticeCallback callback);

    void halfScreenReportClick(@NotNull HalfScreenReportClickReq req, @NotNull IOperateCallback callback);

    void inviteToGroupV2(@NotNull InviteGroupReq inviteReq, @Nullable IInviteToGroupCallback callback);

    void joinGroup(@NotNull ReqToGroup reqInfo, @Nullable IJoinGroupCallback callback);

    void kickMemberV2(@NotNull KickMemberReq kickReq, @Nullable IKickMemberCallback cb5);

    void listAllAIVoice(@NotNull ListAllVoiceReq req, @NotNull IListAllVoiceCallback callback);

    void miniAppGetGroupInfo(@Nullable MiniAppGetGroupInfoReq req, @Nullable IMiniAppGetGroupInfoCallback callback);

    void modifyGroupDetailInfoV2(@NotNull GroupModifyInfoReq modifyInfoReq, int serviceType, @Nullable IOperateCallback cb5);

    void modifyGroupExtInfoV2(@NotNull GroupExtInfo extInfo, @NotNull GroupExtFilter filter, @Nullable IModifyGroupExtCallback callback);

    void modifyGroupName(long groupCode, @NotNull String groupName, boolean isConf, @Nullable IOperateCallback cb5);

    void modifyGroupRemark(long groupCode, @NotNull String groupRemark, @NotNull IOperateCallback cb5);

    void operateSysNotifyV2(boolean doubt, @NotNull GroupNotifyOperateMsg operateMsg, @Nullable IGroupNotifyOperateCallback cb5);

    void postTeamUp(@NotNull PostTeamUpReq req, @Nullable IPostTeamUpCallback callback);

    void queryGroupTopBanners(@NotNull QueryGroupTopBannersReq req, @NotNull IQueryGroupTopBannersCallback callback);

    void quitGroupV2(@NotNull QuitGroupReq req, @Nullable IOperateCallback result);

    void s(@Nullable GetCapsuleAppReq req, boolean forceFetch, @Nullable IGetCapsuleAppProCallback callback);

    void saveAIVoice(@NotNull SaveVoiceReq req, @NotNull ISaveVoiceCallback callback);

    void searchMember(@NotNull String sceneId, @NotNull String keyword, @NotNull IOperateCallback result);

    void setAIOBindGuild(@NotNull SetAIOBindGuildReq req, @Nullable ISetAIOBindGuildCallback callback);

    void setActiveExtGroup(@NotNull ActiveExtGroupReq req, @Nullable IOperateCallback callback);

    void setGroupAppList(@NotNull SetGroupAppListReq req, @Nullable IOperateCallback callback);

    void setGroupGeoInfo(@NotNull GroupGeoInfoReq req, @Nullable IOperateCallback callback);

    void setGroupMsgMask(long groupCode, @NotNull GroupMsgMask msgMask, @Nullable IOperateCallback cb5);

    void setGroupMsgMaskV2(@NotNull SetGroupMsgMaskReq req, int serviceType, @Nullable ISetGroupMsgMaskCallback cb5);

    void setGroupRelationToGuild(@NotNull SetGroupRelationToGuildReq req, @Nullable ISetGroupRelationToGuildCallback callback);

    void setIdentityInteractionTag(@NotNull SetIdentityInteractionTagReq req, @NotNull IOperateCallback callback);

    void setIdentityTitleInfo(@NotNull SetIdentityTitleInfoReq req, @NotNull IOperateCallback callback);

    void setMemberShutUp(long groupCode, @NotNull ArrayList<GroupMemberShutUpInfo> memList, @Nullable IOperateCallback callback);

    void setRcvJoinVerifyMsg(@NotNull RcvJoinVerifyMsgReq req, @Nullable IRcvJoinVerifyMsgCallback callback);

    void setTop(long groupCode, boolean isTop, @Nullable IOperateCallback result);

    void shareTopic(@NotNull ShareTopicReq req, @Nullable IShareTopicCallback callback);

    void teamUpCreateGroup(@NotNull TeamUpCreateGroupReq req, @Nullable ITeamUpCreateGroupCallback callback);

    void teamUpInviteToGroup(@NotNull TeamUpInviteToGroupReq req, @Nullable IOperateCallback callback);

    void teamUpRequestToJoin(@NotNull TeamUpRequestToJoinReq req, @Nullable ITeamUpRequestToJoinCallback callback);

    void teamUpSubmitDeadline(@NotNull TeamUpSubmitDeadlineReq req, @Nullable IOperateCallback callback);

    void topicFeedback(@NotNull TopicFeedbackReq req, @Nullable IOperateCallback callback);

    void topicReport(@NotNull TopicReportReq req, @Nullable ITopicReportCallback callback);

    void transferGroupV2(long groupCode, @NotNull String oldOwnerUid, @NotNull String newOwnerUid, @Nullable ITransferGroupCallback cb5);

    void unbindAllGuilds(@NotNull UnbindAllGuildsReq req, @Nullable IUnbindAllGuildsCallback callback);

    void updateGroupInfoByMqq(@NotNull GroupInfoCacheReq req);

    void updateMemberInfoByMqq(@NotNull GroupMemberCacheReq memberInfoReq);

    void x0(@Nullable IKernelGroupListener listener);
}
