package com.tencent.qqnt.kernel.api.impl;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.impl.GroupService;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.ActiveExtGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.BatchQueryCachedGroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.ConsumeGroupTopBannerReq;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupProfileShareReq;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.DestroyGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAIOBindGuildInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAppCenterReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAppListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetCapsuleAppReq;
import com.tencent.qqnt.kernel.nativeinterface.GetCapsuleAppRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupBindGuildsReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupMedalListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetSubGroupInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpMembersReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpTemplateListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistDelApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistGetAllApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFilter;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupGeoInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoCacheReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCacheReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelName;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberShutUpInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupModifyInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyTemplateItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareTabItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
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
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupService;
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
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.KickMemberReq;
import com.tencent.qqnt.kernel.nativeinterface.ListAllVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MiniAppGetGroupInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryGroupTopBannersReq;
import com.tencent.qqnt.kernel.nativeinterface.QuitGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.RcvJoinVerifyMsgReq;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
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
import com.tencent.qqnt.kernel.nativeinterface.ShareTopicRsp;
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
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00ad\u00022\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u00ae\u0002B\u001e\u0012\t\u0010\u00a8\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u00aa\u0002\u001a\u00030\u00a9\u0002\u00a2\u0006\u0006\b\u00ab\u0002\u0010\u00ac\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016JR\u0010\u0018\u001a\u00020\u00062\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J2\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J*\u0010(\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010.\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010-\u001a\u00020,2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u00101\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020/2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\r\u001a\u0004\u0018\u000100H\u0016J\u001a\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\b\u0010#\u001a\u0004\u0018\u000104H\u0016J(\u0010:\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u0002062\f\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00102\b\u0010\r\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010=\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010?\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020>2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J*\u0010C\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\b\u0010\r\u001a\u0004\u0018\u00010BH\u0016J \u0010E\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010D\u001a\u00020%2\u0006\u0010\r\u001a\u00020\fH\u0016J2\u0010K\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u001f2\b\u0010\r\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010L\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010M\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010N\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u001f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010R\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\n2\u0006\u0010P\u001a\u00020O2\b\u0010\r\u001a\u0004\u0018\u00010QH\u0016J\"\u0010T\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010V\u001a\u0004\u0018\u00010%2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010U\u001a\u00020%H\u0016J\u0010\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020%H\u0016J \u0010Z\u001a\u00020\u00062\u0006\u0010W\u001a\u00020%2\u0006\u0010Y\u001a\u00020%2\u0006\u0010<\u001a\u00020\fH\u0016J*\u0010_\u001a\u00020\u00062\u0006\u0010W\u001a\u00020%2\b\u0010\\\u001a\u0004\u0018\u00010[2\u0006\u0010]\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020^H\u0016J\u001a\u0010`\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010^H\u0016J\"\u0010b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010^H\u0016J\u001a\u0010e\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020c2\b\u0010#\u001a\u0004\u0018\u00010dH\u0016J\u001a\u0010h\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020f2\b\u0010#\u001a\u0004\u0018\u00010gH\u0016JB\u0010k\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020%0\u0010j\b\u0012\u0004\u0012\u00020%`\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010j\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010^H\u0016J:\u0010m\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020%0\u0010j\b\u0012\u0004\u0012\u00020%`\u00122\u0006\u0010l\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010q\u001a\u00020\u00062\u0006\u0010o\u001a\u00020n2\b\u0010\r\u001a\u0004\u0018\u00010pH\u0016J\u001a\u0010s\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010rH\u0016J\u0019\u0010u\u001a\u0004\u0018\u00010\u001f2\u0006\u0010t\u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\bu\u0010vJ \u0010y\u001a\u00020\u00062\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010#\u001a\u0004\u0018\u00010xH\u0016J \u0010{\u001a\u00020\u00062\f\u0010i\u001a\b\u0012\u0004\u0012\u00020%0\u00102\b\u0010#\u001a\u0004\u0018\u00010zH\u0016J\u0010\u0010~\u001a\u00020\u00062\u0006\u0010}\u001a\u00020|H\u0016J\u001c\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u007f2\t\u0010#\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u001d\u0010\u0084\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0082\u00012\t\u0010#\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u001d\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0085\u00012\t\u0010#\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u001d\u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0088\u00012\t\u0010#\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\u001d\u0010\u008d\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u008b\u00012\t\u0010#\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\u001d\u0010\u0090\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u008e\u00012\t\u0010#\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u001c\u0010\u0092\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\t\u0010#\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J+\u0010\u0095\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u000e\u0010\u0094\u0001\u001a\t\u0012\u0005\u0012\u00030\u0093\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u0099\u0001\u001a\u00020\u00062\b\u0010\u0097\u0001\u001a\u00030\u0096\u00012\t\u0010#\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\u001c\u0010\u009b\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u009a\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001d\u0010\u009e\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u009c\u00012\t\u0010#\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\u001c\u0010\u00a0\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u009f\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J+\u0010\u00a3\u0001\u001a\u00020\u00062\r\u0010\u00a1\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010 \u001a\u00020\u001f2\t\u0010#\u001a\u0005\u0018\u00010\u00a2\u0001H\u0016J$\u0010\u00a5\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\t\u0010#\u001a\u0005\u0018\u00010\u00a4\u0001H\u0016J\u001c\u0010\u00a7\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\t\u0010#\u001a\u0005\u0018\u00010\u00a6\u0001H\u0016J-\u0010\u00aa\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0007\u0010\u00a8\u0001\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\t\u0010#\u001a\u0005\u0018\u00010\u00a9\u0001H\u0016J\u001c\u0010\u00ac\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\t\u0010#\u001a\u0005\u0018\u00010\u00ab\u0001H\u0016J\u001c\u0010\u00ae\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\t\u0010#\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016J&\u0010\u00b2\u0001\u001a\u00020\u00062\b\u0010\u00b0\u0001\u001a\u00030\u00af\u00012\u0006\u0010\u0016\u001a\u00020\u00152\t\u0010#\u001a\u0005\u0018\u00010\u00b1\u0001H\u0016J\u001d\u0010\u00b5\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00b3\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00b4\u0001H\u0016J%\u0010\u00b8\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0007\u0010\u00b6\u0001\u001a\u00020%2\t\u0010#\u001a\u0005\u0018\u00010\u00b7\u0001H\u0016J%\u0010\u00bb\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00b9\u00012\u0006\u0010\u000b\u001a\u00020\n2\t\u0010#\u001a\u0005\u0018\u00010\u00ba\u0001H\u0016J\u0011\u0010\u00bc\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J/\u0010\u00c1\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u00be\u0001\u001a\u00030\u00bd\u00012\u0007\u0010\u00bf\u0001\u001a\u00020%2\t\u0010#\u001a\u0005\u0018\u00010\u00c0\u0001H\u0016J7\u0010\u00c4\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0007\u0010\u00c2\u0001\u001a\u00020\u00112\u0007\u0010\u00bf\u0001\u001a\u00020%2\u0007\u0010\u00b6\u0001\u001a\u00020%2\t\u0010#\u001a\u0005\u0018\u00010\u00c3\u0001H\u0016J\u001d\u0010\u00c7\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00c5\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00c6\u0001H\u0016J\u0012\u0010\u00c9\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00c8\u0001H\u0016J\u001b\u0010\u00ca\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u00cc\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00cb\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001d\u0010\u00cf\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00cd\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00ce\u0001H\u0016J\u001d\u0010\u00d2\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00d0\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00d1\u0001H\u0016J\u001d\u0010\u00d5\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00d3\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00d4\u0001H\u0016J\u001d\u0010\u00d8\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00d6\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00d7\u0001H\u0016J\u001d\u0010\u00db\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00d9\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00da\u0001H\u0016J\u001d\u0010\u00de\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00dc\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00dd\u0001H\u0016J\u001c\u0010\u00e0\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00df\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001d\u0010\u00e3\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00e1\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00e2\u0001H\u0016J\u001c\u0010\u00e5\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00e4\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001d\u0010\u00e8\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00e6\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00e7\u0001H\u0016J\u001c\u0010\u00ea\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00e9\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001b\u0010\u00ed\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00eb\u00012\u0007\u0010#\u001a\u00030\u00ec\u0001H\u0016J\u001b\u0010\u00f0\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00ee\u00012\u0007\u0010#\u001a\u00030\u00ef\u0001H\u0016J\u001d\u0010\u00f3\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00f1\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00f2\u0001H\u0016J\u001c\u0010\u00f5\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00f4\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u001d\u0010\u00f8\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00f6\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00f7\u0001H\u0016J\u001d\u0010\u00fb\u0001\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00f9\u00012\t\u0010#\u001a\u0005\u0018\u00010\u00fa\u0001H\u0016J'\u0010\u00fe\u0001\u001a\u00020\u00062\t\u0010\u001e\u001a\u0005\u0018\u00010\u00fc\u00012\u0006\u0010\u000b\u001a\u00020\n2\t\u0010#\u001a\u0005\u0018\u00010\u00fd\u0001H\u0016J\u001e\u0010\u0080\u0002\u001a\u00020\u00062\t\u0010\u001e\u001a\u0005\u0018\u00010\u00ff\u00012\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\u0011\u0010\u0081\u0002\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u001b\u0010\u0084\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0082\u00022\u0007\u0010#\u001a\u00030\u0083\u0002H\u0016J\u001b\u0010\u0087\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0085\u00022\u0007\u0010#\u001a\u00030\u0086\u0002H\u0016J\u001b\u0010\u008a\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0088\u00022\u0007\u0010#\u001a\u00030\u0089\u0002H\u0016J\u001b\u0010\u008d\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u008b\u00022\u0007\u0010#\u001a\u00030\u008c\u0002H\u0016J\u001f\u0010\u0090\u0002\u001a\u00020\u00062\t\u0010\u001e\u001a\u0005\u0018\u00010\u008e\u00022\t\u0010#\u001a\u0005\u0018\u00010\u008f\u0002H\u0016J\u001b\u0010\u0093\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0091\u00022\u0007\u0010#\u001a\u00030\u0092\u0002H\u0016J\u001a\u0010\u0095\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0094\u00022\u0006\u0010#\u001a\u00020\fH\u0016J\u001b\u0010\u0098\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0096\u00022\u0007\u0010#\u001a\u00030\u0097\u0002H\u0016J\u001b\u0010\u009b\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u0099\u00022\u0007\u0010#\u001a\u00030\u009a\u0002H\u0016J\u001a\u0010\u009d\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u009c\u00022\u0006\u0010#\u001a\u00020\fH\u0016J\u001a\u0010\u009f\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u009e\u00022\u0006\u0010#\u001a\u00020\fH\u0016J\u001b\u0010\u00a2\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00a0\u00022\u0007\u0010#\u001a\u00030\u00a1\u0002H\u0016J\u001a\u0010\u00a4\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00a3\u00022\u0006\u0010#\u001a\u00020\fH\u0016J\u001b\u0010\u00a7\u0002\u001a\u00020\u00062\u0007\u0010\u001e\u001a\u00030\u00a5\u00022\u0007\u0010#\u001a\u00030\u00a6\u0002H\u0016\u00a8\u0006\u00af\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GroupService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupService;", "Lcom/tencent/qqnt/kernel/api/s;", "listener", "", "D", "x0", "p4", "", "forceFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "getGroupList", "getGroupExtList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "enableGroupCodes", "bannedGroupCodes", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFilter;", "filter", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupExt0xEF0InfoCallback;", "E0", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupInfoSource;", "source", "getGroupDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfoReq;", "req", "", "serviceType", "callFrom", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupDetailInfoCallback;", "callback", "getGroupDetailInfoByFilter", "", "groupName", "isConf", "modifyGroupName", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupModifyInfoReq;", "modifyInfoReq", "modifyGroupDetailInfoV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "msgMask", "setGroupMsgMask", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupMsgMaskReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupMsgMaskCallback;", "setGroupMsgMaskV2", "Lcom/tencent/qqnt/kernel/nativeinterface/InviteGroupReq;", "inviteReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IInviteToGroupCallback;", "inviteToGroupV2", "Lcom/tencent/qqnt/kernel/nativeinterface/CreateGroupReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/InviteMemberInfo;", "membersInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupCallback;", "createGroupV2", "Lcom/tencent/qqnt/kernel/nativeinterface/QuitGroupReq;", "result", "quitGroupV2", "Lcom/tencent/qqnt/kernel/nativeinterface/DestroyGroupReq;", "destroyGroupV2", "oldOwnerUid", "newOwnerUid", "Lcom/tencent/qqnt/kernel/nativeinterface/ITransferGroupCallback;", "transferGroupV2", "groupRemark", "modifyGroupRemark", "doubt", "startSeq", "number", "category", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSingleScreenNotifiesCallback;", "getSingleScreenNotifiesV2", "clearGroupNotifies", "clearGroupNotifiesUnreadCount", "clearGroupNotifyLocalUnreadCount", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateMsg;", "operateMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupNotifyOperateCallback;", "operateSysNotifyV2", "isTop", "setTop", "scene", "createMemberListScene", WadlProxyConsts.SCENE_ID, "destroyMemberListScene", "keyword", "searchMember", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberInfoListId;", "lastId", WidgetCacheConstellationData.NUM, "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberListCallback;", "getNextMemberList", "N", "getAllMemberList", "getAllMemberListV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberCommonCallback;", "getMemberCommonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberExtCallback;", "getMemberExtInfo", "uids", "from", "e", "forceUpdate", "getMemberInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/KickMemberReq;", "kickReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IKickMemberCallback;", "kickMemberV2", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRemainAtAllTimesOperateCallback;", "getGroupRemainAtTimes", "tableId", "getGroupDBVersion", "(I)Ljava/lang/Integer;", "uins", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUidCallback;", "getUidByUins", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUinCallback;", "getUinByUids", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCacheReq;", "memberInfoReq", "updateMemberInfoByMqq", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupRelationToGuildReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupRelationToGuildCallback;", "setGroupRelationToGuild", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupBindGuildsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupBindGuildsCallback;", "getGroupBindGuilds", "Lcom/tencent/qqnt/kernel/nativeinterface/UnbindAllGuildsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnbindAllGuildsCallback;", "unbindAllGuilds", "Lcom/tencent/qqnt/kernel/nativeinterface/SetAIOBindGuildReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAIOBindGuildCallback;", "setAIOBindGuild", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAIOBindGuildInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIOBindGuildInfoCallback;", "getAIOBindGuildInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GetSubGroupInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSubGroupInfoCallback;", "getSubGroupInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberIllegalInfoCallback;", "getIllegalMemberList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberShutUpInfo;", "memList", "setMemberShutUp", "Lcom/tencent/qqnt/kernel/nativeinterface/ReqToGroup;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IJoinGroupCallback;", "joinGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/ActiveExtGroupReq;", "setActiveExtGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/RcvJoinVerifyMsgReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRcvJoinVerifyMsgCallback;", "setRcvJoinVerifyMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGeoInfoReq;", "setGroupGeoInfo", "groupCodes", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPrivilegeFlagCallback;", "getAllGroupPrivilegeFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberMaxNumCallback;", "getGroupMemberMaxNum", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForGrayTipsCallback;", "getGroupSeqAndJoinTimeForGrayTips", "needPrivilegeFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForJoinCallback;", "getGroupInfoForJoinGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPayToJoinStatusCallback;", "getGroupPayToJoinStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMsgLimitFreqCallback;", "getGroupMsgLimitFreq", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "extInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyGroupExtCallback;", "modifyGroupExtInfoV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupLatestEssenceListCallback;", "getGroupLatestEssenceList", "ext", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetHomeHeadCallback;", "h0", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSquareRedpointInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSquareRedpointInfoCallback;", "getGroupSquareRedpointInfo", "clearGroupSquareRedpointCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareTabItem;", "tab", "cookies", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecGroupsCallback;", "getRecGroups", "bannerId", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTopicPageCallback;", "getTopicPage", "Lcom/tencent/qqnt/kernel/nativeinterface/ShareTopicReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IShareTopicCallback;", "shareTopic", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupInfoCacheReq;", "updateGroupInfoByMqq", "getGroupMemberLevelInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupAppListReq;", "setGroupAppList", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchQueryCachedGroupDetailInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchQueryCachedGroupDetailInfoCallback;", "batchQueryCachedGroupDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpListCallback;", "getTeamUpList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpDetailCallback;", "getTeamUpDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpTemplateListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpTemplateListCallback;", "getTeamUpTemplateList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetTeamUpMembersReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTeamUpMembersCallback;", "getTeamUpMembers", "Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPostTeamUpCallback;", "postTeamUp", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpApplyReq;", "applyTeamUp", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpCreateGroupReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITeamUpCreateGroupCallback;", "teamUpCreateGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpInviteToGroupReq;", "teamUpInviteToGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpRequestToJoinReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITeamUpRequestToJoinCallback;", "teamUpRequestToJoin", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpSubmitDeadlineReq;", "teamUpSubmitDeadline", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBlacklistGetAllApplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupBlacklistGetAllApplyCallback;", "groupBlacklistGetAllApply", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBlacklistDelApplyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupBlacklistDelApplyCallback;", "groupBlacklistDelApply", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicRecallReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITopicRecallCallback;", "getTopicRecall", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicFeedbackReq;", "topicFeedback", "Lcom/tencent/qqnt/kernel/nativeinterface/TopicReportReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITopicReportCallback;", "topicReport", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppCenterReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAppCenterCallback;", "getAppCenter", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCapsuleAppReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetCapsuleAppProCallback;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/SetCapsuleSwitchReq;", BdhLogUtil.LogTag.Tag_Conn, "cleanCapsuleCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GetVoiceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetVoiceCallback;", "getAICommonVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/ListAllVoiceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IListAllVoiceCallback;", "listAllAIVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/SaveVoiceReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISaveVoiceCallback;", "saveAIVoice", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupMedalListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupMedalListCallback;", "getGroupMedalList", "Lcom/tencent/qqnt/kernel/nativeinterface/MiniAppGetGroupInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IMiniAppGetGroupInfoCallback;", "miniAppGetGroupInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenPullNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IHalfScreenPullNoticeCallback;", "halfScreenPullNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfScreenReportClickReq;", "halfScreenReportClick", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAppListCallback;", "getGroupPlusAppList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetIdentityListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetIdentityListCallback;", "getIdentityList", "Lcom/tencent/qqnt/kernel/nativeinterface/SetIdentityTitleInfoReq;", "setIdentityTitleInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SetIdentityInteractionTagReq;", "setIdentityInteractionTag", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryGroupTopBannersReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryGroupTopBannersCallback;", "queryGroupTopBanners", "Lcom/tencent/qqnt/kernel/nativeinterface/ConsumeGroupTopBannerReq;", "consumeGroupTopBanner", "Lcom/tencent/qqnt/kernel/nativeinterface/CreateGroupProfileShareReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupProfileShareCallback;", "createGroupProfileShare", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GroupService extends BaseService<IKernelGroupListener, IKernelGroupService> implements com.tencent.qqnt.kernel.api.s {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GroupService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.GroupService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u00af\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016JP\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0004H\u0016J4\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00112\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0006H\u0016J \u0010\"\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0018H\u0016J8\u0010&\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018H\u0016J,\u0010'\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0006H\u0016J8\u0010(\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00112\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0004H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0016J0\u0010.\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u001e\u0010-\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u0001`\u0006H\u0016J\u001a\u00101\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00103\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u000102H\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016J$\u0010:\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010,2\b\u00109\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J<\u0010D\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>2\"\u0010C\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020A0@j\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020A`BH\u0016J`\u0010J\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010,2\b\u0010F\u001a\u0004\u0018\u00010,2\u001a\u0010H\u001a\u0016\u0012\u0004\u0012\u00020G\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020G\u0018\u0001`\u00062&\u0010I\u001a\"\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020A\u0018\u00010@j\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020A\u0018\u0001`BH\u0016J\u001a\u0010M\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010N\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006O"}, d2 = {"com/tencent/qqnt/kernel/api/impl/GroupService$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupListUpdateType;", "updateType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "groupList", "", "onGroupListUpdate", "", "listEmpty", "onGroupListInited", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtListUpdateType;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "groupExtList", "onGroupExtListUpdate", "", "groupCode", "onGroupAdd", "doubt", "curReadedSeq", "nextStartSeq", "hasMore", "", "category", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "notifies", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyTemplateItem;", DKConfiguration.Directory.TEMPLATES, "onGroupSingleScreenNotifiesV2", "onGroupSingleScreenNotifies", "oldestUnreadSeq", "unreadCount", "onGroupNotifiesUnreadCountUpdated", "unHandleCount", "unHandleAndUnreadCount", "memberQuitUnreadCount", "onGroupNotifiesUnreadCountUpdatedV2", "onGroupNotifiesUpdated", "onGroupNotifiesUpdatedV2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "onGroupDetailInfoChange", "", "membersUid", "onGroupConfMemberChange", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBulletin;", "groupBulletin", "onGroupBulletinChange", "Lcom/tencent/qqnt/kernel/nativeinterface/RemindGroupBulletinMsg;", "onGroupBulletinRemindNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstGroupBulletinInfo;", "firstGroupBulletinInfo", "onGroupFirstBulletinNotify", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBulletinListResult;", "result", "onGetGroupBulletinListResult", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberListChangeInfo;", "info", "onMemberListChange", "Lcom/tencent/qqnt/kernel/nativeinterface/DataSource;", "dataSource", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lkotlin/collections/HashMap;", "members", "onMemberInfoChange", WadlProxyConsts.SCENE_ID, "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberInfoListId;", "ids", "infos", "onSearchMemberChange", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberLevelInfo;", "memberLevelInfo", "onGroupMemberLevelInfoChange", "onGroupEssenceListChange", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelGroupListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IKernelGroupListener f357243e;

        b(IKernelGroupListener iKernelGroupListener) {
            this.f357243e = iKernelGroupListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) iKernelGroupListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(long j3, IKernelGroupListener listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupEssenceListChange, " + j3}, null, 4, null);
            listener.onGroupEssenceListChange(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(IKernelGroupListener listener, GroupExtListUpdateType updateType, ArrayList groupExtList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(updateType, "$updateType");
            Intrinsics.checkNotNullParameter(groupExtList, "$groupExtList");
            listener.onGroupExtListUpdate(updateType, groupExtList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(IKernelGroupListener listener, FirstGroupBulletinInfo firstGroupBulletinInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(firstGroupBulletinInfo, "$firstGroupBulletinInfo");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupFirstBulletinNotify"}, null, 4, null);
            listener.onGroupFirstBulletinNotify(firstGroupBulletinInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(boolean z16, IKernelGroupListener listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{TuplesKt.to("onGroupListInited listEmpty", Boolean.valueOf(z16))}, null, 4, null);
            listener.onGroupListInited(z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E(IKernelGroupListener listener, GroupListUpdateType updateType, ArrayList groupList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(updateType, "$updateType");
            Intrinsics.checkNotNullParameter(groupList, "$groupList");
            listener.onGroupListUpdate(updateType, groupList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F(long j3, GroupMemberLevelInfo groupMemberLevelInfo, IKernelGroupListener listener) {
            Integer num;
            ArrayList<GroupMemberLevelName> arrayList;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (groupMemberLevelInfo != null && (arrayList = groupMemberLevelInfo.levelNameNewList) != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            objArr[0] = "onGroupMemberLevelInfoChange, " + j3 + ", " + num;
            KLog.e(kLog, "GroupService", objArr, null, 4, null);
            listener.onGroupMemberLevelInfoChange(j3, groupMemberLevelInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(IKernelGroupListener listener, boolean z16, long j3, int i3) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupNotifiesUnreadCountUpdated"}, null, 4, null);
            listener.onGroupNotifiesUnreadCountUpdated(z16, j3, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(IKernelGroupListener listener, boolean z16, long j3, int i3, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupNotifiesUnreadCountUpdatedV2"}, null, 4, null);
            listener.onGroupNotifiesUnreadCountUpdatedV2(z16, j3, i3, i16, i17, i18);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(IKernelGroupListener listener, boolean z16, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupNotifiesUpdated"}, null, 4, null);
            listener.onGroupNotifiesUpdated(z16, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void J(IKernelGroupListener listener, boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupNotifiesUpdatedV2"}, null, 4, null);
            listener.onGroupNotifiesUpdatedV2(z16, j3, arrayList, arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void K(IKernelGroupListener listener, boolean z16, long j3, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupSingleScreenNotifies"}, null, 4, null);
            listener.onGroupSingleScreenNotifies(z16, j3, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L(HashMap members, IKernelGroupListener listener, long j3, DataSource dataSource) {
            Intrinsics.checkNotNullParameter(members, "$members");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(dataSource, "$dataSource");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{TuplesKt.to("onMemberInfoChange members.size", Integer.valueOf(members.size()))}, null, 4, null);
            try {
                listener.onMemberInfoChange(j3, dataSource, members);
            } catch (ClassNotFoundException e16) {
                String stackTraceString = QLog.getStackTraceString(e16);
                KLog.g(KLog.f359087a, "GroupService", new Object[]{"onMemberInfoChange class not found error stack: " + stackTraceString}, null, 4, null);
            } catch (Exception e17) {
                String stackTraceString2 = QLog.getStackTraceString(e17);
                KLog.g(KLog.f359087a, "GroupService", new Object[]{"onMemberInfoChange error stack: " + stackTraceString2}, null, 4, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M(GroupMemberListChangeInfo groupMemberListChangeInfo, IKernelGroupListener listener) {
            Integer num;
            HashMap<String, MemberInfo> hashMap;
            Collection<MemberInfo> values;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (groupMemberListChangeInfo != null && (hashMap = groupMemberListChangeInfo.infos) != null && (values = hashMap.values()) != null) {
                num = Integer.valueOf(values.size());
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onMemberListChange memberList.size", num);
            KLog.e(kLog, "GroupService", objArr, null, 4, null);
            listener.onMemberListChange(groupMemberListChangeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void N(ArrayList arrayList, IKernelGroupListener listener, String str, String str2, HashMap hashMap) {
            Integer num;
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog kLog = KLog.f359087a;
            Object[] objArr = new Object[1];
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            objArr[0] = TuplesKt.to("onSearchMemberChange ids.size", num);
            KLog.e(kLog, "GroupService", objArr, null, 4, null);
            listener.onSearchMemberChange(str, str2, arrayList, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(IKernelGroupListener listener, long j3, String str, GroupBulletinListResult groupBulletinListResult) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGetGroupBulletinListResult"}, null, 4, null);
            listener.onGetGroupBulletinListResult(j3, str, groupBulletinListResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(long j3, IKernelGroupListener listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{TuplesKt.to("onGroupAdd groupCode", Long.valueOf(j3))}, null, 4, null);
            listener.onGroupAdd(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(IKernelGroupListener listener, long j3, GroupBulletin groupBulletin) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupBulletinChange"}, null, 4, null);
            listener.onGroupBulletinChange(j3, groupBulletin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(IKernelGroupListener listener, long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupBulletinRemindNotify"}, null, 4, null);
            listener.onGroupBulletinRemindNotify(j3, remindGroupBulletinMsg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(IKernelGroupListener listener, long j3, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            try {
                listener.onGroupConfMemberChange(j3, arrayList);
            } catch (ClassNotFoundException e16) {
                String stackTraceString = QLog.getStackTraceString(e16);
                KLog.g(KLog.f359087a, "GroupService", new Object[]{"onMemberInfoChange class not found error stack: " + stackTraceString}, null, 4, null);
            } catch (Exception e17) {
                String stackTraceString2 = QLog.getStackTraceString(e17);
                KLog.g(KLog.f359087a, "GroupService", new Object[]{"onGroupConfMemberChange error stack: " + stackTraceString2}, null, 4, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(IKernelGroupListener listener, GroupDetailInfo groupDetail) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(groupDetail, "$groupDetail");
            listener.onGroupDetailInfoChange(groupDetail);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGetGroupBulletinListResult(final long groupCode, @Nullable final String context, @Nullable final GroupBulletinListResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Long.valueOf(groupCode), context, result);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ht
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.u(IKernelGroupListener.this, groupCode, context, result);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupAdd(final long groupCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, groupCode);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hj
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.v(groupCode, iKernelGroupListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.c(this, groupAllInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.d(this, j3, groupArkInviteStateInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupBulletinChange(final long groupCode, @Nullable final GroupBulletin groupBulletin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Long.valueOf(groupCode), groupBulletin);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hc
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.w(IKernelGroupListener.this, groupCode, groupBulletin);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupBulletinRemindNotify(final long groupCode, @Nullable final RemindGroupBulletinMsg notifies) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Long.valueOf(groupCode), notifies);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hi
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.x(IKernelGroupListener.this, groupCode, notifies);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.g(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.h(this, bulletinFeedsDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupConfMemberChange(final long groupCode, @Nullable final ArrayList<String> membersUid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Long.valueOf(groupCode), membersUid);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hh
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.y(IKernelGroupListener.this, groupCode, membersUid);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupDetailInfoChange(@NotNull final GroupDetailInfo groupDetail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) groupDetail);
                return;
            }
            Intrinsics.checkNotNullParameter(groupDetail, "groupDetail");
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hk
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.z(IKernelGroupListener.this, groupDetail);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupEssenceListChange(final long groupCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, groupCode);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hn
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.A(groupCode, iKernelGroupListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupExtListUpdate(@NotNull final GroupExtListUpdateType updateType, @NotNull final ArrayList<GroupExtInfo> groupExtList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) updateType, (Object) groupExtList);
                return;
            }
            Intrinsics.checkNotNullParameter(updateType, "updateType");
            Intrinsics.checkNotNullParameter(groupExtList, "groupExtList");
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hr
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.B(IKernelGroupListener.this, updateType, groupExtList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupFirstBulletinNotify(@NotNull final FirstGroupBulletinInfo firstGroupBulletinInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) firstGroupBulletinInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(firstGroupBulletinInfo, "firstGroupBulletinInfo");
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hl
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.C(IKernelGroupListener.this, firstGroupBulletinInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupListInited(final boolean listEmpty) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, listEmpty);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hp
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.D(listEmpty, iKernelGroupListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupListUpdate(@NotNull final GroupListUpdateType updateType, @NotNull final ArrayList<GroupSimpleInfo> groupList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateType, (Object) groupList);
                return;
            }
            Intrinsics.checkNotNullParameter(updateType, "updateType");
            Intrinsics.checkNotNullParameter(groupList, "groupList");
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hf
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.E(IKernelGroupListener.this, updateType, groupList);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupMemberLevelInfoChange(final long groupCode, @Nullable final GroupMemberLevelInfo memberLevelInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, this, Long.valueOf(groupCode), memberLevelInfo);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hu
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.F(groupCode, memberLevelInfo, iKernelGroupListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupNotifiesUnreadCountUpdated(final boolean doubt, final long oldestUnreadSeq, final int unreadCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(doubt), Long.valueOf(oldestUnreadSeq), Integer.valueOf(unreadCount));
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hm
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.G(IKernelGroupListener.this, doubt, oldestUnreadSeq, unreadCount);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupNotifiesUnreadCountUpdatedV2(final boolean doubt, final long oldestUnreadSeq, final int unreadCount, final int unHandleCount, final int unHandleAndUnreadCount, final int memberQuitUnreadCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(doubt), Long.valueOf(oldestUnreadSeq), Integer.valueOf(unreadCount), Integer.valueOf(unHandleCount), Integer.valueOf(unHandleAndUnreadCount), Integer.valueOf(memberQuitUnreadCount));
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ho
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.H(IKernelGroupListener.this, doubt, oldestUnreadSeq, unreadCount, unHandleCount, unHandleAndUnreadCount, memberQuitUnreadCount);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupNotifiesUpdated(final boolean doubt, @Nullable final ArrayList<GroupNotifyMsg> notifies) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(doubt), notifies);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hg
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.I(IKernelGroupListener.this, doubt, notifies);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupNotifiesUpdatedV2(final boolean doubt, final long curReadedSeq, @Nullable final ArrayList<GroupNotifyMsg> notifies, @Nullable final ArrayList<GroupNotifyTemplateItem> templates) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(doubt), Long.valueOf(curReadedSeq), notifies, templates);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hq
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.J(IKernelGroupListener.this, doubt, curReadedSeq, notifies, templates);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupSingleScreenNotifies(final boolean doubt, final long nextStartSeq, @Nullable final ArrayList<GroupNotifyMsg> notifies) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(doubt), Long.valueOf(nextStartSeq), notifies);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.he
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.K(IKernelGroupListener.this, doubt, nextStartSeq, notifies);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onGroupSingleScreenNotifiesV2(boolean doubt, long curReadedSeq, long nextStartSeq, boolean hasMore, int category, @Nullable ArrayList<GroupNotifyMsg> notifies, @Nullable ArrayList<GroupNotifyTemplateItem> templates) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(doubt), Long.valueOf(curReadedSeq), Long.valueOf(nextStartSeq), Boolean.valueOf(hasMore), Integer.valueOf(category), notifies, templates);
            } else {
                KLog.e(KLog.f359087a, "GroupService", new Object[]{"onGroupSingleScreenNotifiesV2"}, null, 4, null);
                this.f357243e.onGroupSingleScreenNotifiesV2(doubt, curReadedSeq, nextStartSeq, hasMore, category, notifies, templates);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
            com.tencent.qqnt.kernel.nativeinterface.am.w(this, j3, groupStatisticInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
            com.tencent.qqnt.kernel.nativeinterface.am.y(this, j3, z16, z17);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
            com.tencent.qqnt.kernel.nativeinterface.am.z(this, joinGroupNotifyMsg);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onMemberInfoChange(final long groupCode, @NotNull final DataSource dataSource, @NotNull final HashMap<String, MemberInfo> members) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, Long.valueOf(groupCode), dataSource, members);
                return;
            }
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            Intrinsics.checkNotNullParameter(members, "members");
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hb
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.L(members, iKernelGroupListener, groupCode, dataSource);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onMemberListChange(@Nullable final GroupMemberListChangeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) info);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hd
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.M(GroupMemberListChangeInfo.this, iKernelGroupListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public void onSearchMemberChange(@Nullable final String sceneId, @Nullable final String keyword, @Nullable final ArrayList<GroupMemberInfoListId> ids, @Nullable final HashMap<String, MemberInfo> infos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, this, sceneId, keyword, ids, infos);
                return;
            }
            GroupService groupService = GroupService.this;
            final IKernelGroupListener iKernelGroupListener = this.f357243e;
            groupService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.hs
                @Override // java.lang.Runnable
                public final void run() {
                    GroupService.b.N(ids, iKernelGroupListener, sceneId, keyword, infos);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
        public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.am.D(this, j3, arrayList);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 147)) {
            redirector.redirect((short) 147);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupService(@Nullable IKernelGroupService iKernelGroupService, @NotNull py content) {
        super("GroupService", content, iKernelGroupService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelGroupService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void C(@Nullable final SetCapsuleSwitchReq req, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            iPatchRedirector.redirect((short) 131, (Object) this, (Object) req, (Object) callback);
        } else {
            checkCommon("setCapsuleSwitch", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setCapsuleSwitchWithReq$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ SetCapsuleSwitchReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.setCapsuleSwitch(this.$req, this.$callback);
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setCapsuleSwitchWithReq$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IOperateCallback.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IOperateCallback iOperateCallback = IOperateCallback.this;
                    if (iOperateCallback != null) {
                        iOperateCallback.onResult(-1, "[SetCapsuleSwitchReq] inner error");
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void D(@Nullable IKernelGroupListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else if (listener != null) {
            addListener(listener, new Function1<IKernelGroupListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$addGroupListener$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Long invoke(@NotNull IKernelGroupListener id5) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) id5);
                    }
                    Intrinsics.checkNotNullParameter(id5, "id");
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        return Long.valueOf(service.addKernelGroupListener(GroupService.this.p4(id5)));
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void E0(@NotNull final ArrayList<Long> enableGroupCodes, @NotNull final ArrayList<Long> bannedGroupCodes, @NotNull final GroupExtFilter filter, final boolean forceFetch, @Nullable IGroupExt0xEF0InfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, enableGroupCodes, bannedGroupCodes, filter, Boolean.valueOf(forceFetch), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(enableGroupCodes, "enableGroupCodes");
        Intrinsics.checkNotNullParameter(bannedGroupCodes, "bannedGroupCodes");
        Intrinsics.checkNotNullParameter(filter, "filter");
        check("getGroupExtInfo", cb5, new Function1<IGroupExt0xEF0InfoCallback, Unit>(enableGroupCodes, bannedGroupCodes, filter, forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupExtInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<Long> $bannedGroupCodes;
            final /* synthetic */ ArrayList<Long> $enableGroupCodes;
            final /* synthetic */ GroupExtFilter $filter;
            final /* synthetic */ boolean $forceFetch;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$enableGroupCodes = enableGroupCodes;
                this.$bannedGroupCodes = bannedGroupCodes;
                this.$filter = filter;
                this.$forceFetch = forceFetch;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, enableGroupCodes, bannedGroupCodes, filter, Boolean.valueOf(forceFetch));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGroupExt0xEF0InfoCallback iGroupExt0xEF0InfoCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupExt0xEF0InfoCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getGroupExt0xEF0Info(this.$enableGroupCodes, this.$bannedGroupCodes, this.$filter, this.$forceFetch, iGroupExt0xEF0InfoCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void N(long groupCode, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Long.valueOf(groupCode), cb5);
        } else {
            check("getMemberList", cb5, GroupService$getMemberList$1.INSTANCE);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void applyTeamUp(@NotNull final TeamUpApplyReq req, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "applyTeamUp", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$applyTeamUp$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ TeamUpApplyReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.applyTeamUp(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void batchQueryCachedGroupDetailInfo(@NotNull final BatchQueryCachedGroupDetailInfoReq req, @Nullable IBatchQueryCachedGroupDetailInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("batchQueryCachedGroupDetailInfo", callback, new Function1<IBatchQueryCachedGroupDetailInfoCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$batchQueryCachedGroupDetailInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ BatchQueryCachedGroupDetailInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IBatchQueryCachedGroupDetailInfoCallback iBatchQueryCachedGroupDetailInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iBatchQueryCachedGroupDetailInfoCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.batchQueryCachedGroupDetailInfo(this.$req, iBatchQueryCachedGroupDetailInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void cleanCapsuleCache(long groupCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            iPatchRedirector.redirect((short) 132, (Object) this, groupCode);
            return;
        }
        IKernelGroupService service = getService();
        if (service != null) {
            service.cleanCapsuleCache(groupCode);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void clearGroupNotifies(final boolean doubt, @Nullable final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(doubt), cb5);
        } else {
            BaseService.checkCommon$default(this, "clearGroupNotifies", new Function0<Unit>(doubt, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$clearGroupNotifies$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $cb;
                final /* synthetic */ boolean $doubt;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$doubt = doubt;
                    this.$cb = cb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(doubt), cb5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.clearGroupNotifies(this.$doubt, this.$cb);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void clearGroupNotifiesUnreadCount(final boolean doubt, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(doubt), cb5);
        } else {
            check("clearGroupNotifiesUnreadCount", cb5, new Function1<IOperateCallback, Unit>(doubt) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$clearGroupNotifiesUnreadCount$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $doubt;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$doubt = doubt;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(doubt));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.clearGroupNotifiesUnreadCount(this.$doubt, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void clearGroupNotifyLocalUnreadCount(final boolean doubt, final int category, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Boolean.valueOf(doubt), Integer.valueOf(category), cb5);
        } else {
            check("clearGroupNotifyLocalUnreadCount", cb5, new Function1<IOperateCallback, Unit>(doubt, category) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$clearGroupNotifyLocalUnreadCount$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $category;
                final /* synthetic */ boolean $doubt;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$doubt = doubt;
                    this.$category = category;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(doubt), Integer.valueOf(category));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.clearGroupNotifyLocalUnreadCount(this.$doubt, this.$category, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void clearGroupSquareRedpointCache(long groupCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, groupCode);
            return;
        }
        IKernelGroupService service = getService();
        if (service != null) {
            service.clearGroupSquareRedpointCache(groupCode);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void consumeGroupTopBanner(@NotNull final ConsumeGroupTopBannerReq req, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            iPatchRedirector.redirect((short) 145, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "consumeGroupTopBanner", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$consumeGroupTopBanner$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ ConsumeGroupTopBannerReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.consumeGroupTopBanner(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void createGroupProfileShare(@NotNull final CreateGroupProfileShareReq req, @NotNull final ICreateGroupProfileShareCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            iPatchRedirector.redirect((short) 146, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "createGroupProfileShare", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$createGroupProfileShare$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICreateGroupProfileShareCallback $callback;
            final /* synthetic */ CreateGroupProfileShareReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.createGroupProfileShare(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void createGroupV2(@NotNull final CreateGroupReq req, @NotNull final ArrayList<InviteMemberInfo> membersInfo, @Nullable ICreateGroupCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, req, membersInfo, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(membersInfo, "membersInfo");
        check("createGroupV2", cb5, new Function1<ICreateGroupCallback, Unit>(req, membersInfo) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$createGroupV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<InviteMemberInfo> $membersInfo;
            final /* synthetic */ CreateGroupReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$req = req;
                this.$membersInfo = membersInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, membersInfo);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable ICreateGroupCallback iCreateGroupCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iCreateGroupCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.createGroupV2(this.$req, this.$membersInfo, iCreateGroupCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    @Nullable
    public String createMemberListScene(final long groupCode, @NotNull final String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, this, Long.valueOf(groupCode), scene);
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        return (String) check("createMemberListScene", new Function0<String>(groupCode, scene) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$createMemberListScene$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $groupCode;
            final /* synthetic */ String $scene;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$groupCode = groupCode;
                this.$scene = scene;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), scene);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    return service.createMemberListScene(this.$groupCode, this.$scene);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void destroyGroupV2(@NotNull final DestroyGroupReq req, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("destroyGroupV2", cb5, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$destroyGroupV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DestroyGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.destroyGroupV2(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void destroyMemberListScene(@NotNull final String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) sceneId);
        } else {
            Intrinsics.checkNotNullParameter(sceneId, "sceneId");
            check("destroyMemberListScene", new Function0<Unit>(sceneId) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$destroyMemberListScene$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $sceneId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$sceneId = sceneId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) sceneId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.destroyMemberListScene(this.$sceneId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void e(final long groupCode, @NotNull final ArrayList<String> uids, final boolean forceFetch, @NotNull final String from, @Nullable IGroupMemberListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Long.valueOf(groupCode), uids, Boolean.valueOf(forceFetch), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(from, "from");
        check("getMemberInfoForMqq", callback, new Function1<IGroupMemberListCallback, Unit>(groupCode, uids, forceFetch, from) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getMemberInfoForMqq$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $forceFetch;
            final /* synthetic */ String $from;
            final /* synthetic */ long $groupCode;
            final /* synthetic */ ArrayList<String> $uids;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupCode = groupCode;
                this.$uids = uids;
                this.$forceFetch = forceFetch;
                this.$from = from;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), uids, Boolean.valueOf(forceFetch), from);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGroupMemberListCallback iGroupMemberListCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberListCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getMemberInfoForMqqV2(this.$groupCode, this.$uids, this.$forceFetch, this.$from, iGroupMemberListCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getAICommonVoice(@NotNull final GetVoiceReq req, @NotNull final IGetVoiceCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "getAICommonVoice", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getAICommonVoice$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetVoiceCallback $callback;
            final /* synthetic */ GetVoiceReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.getAICommonVoice(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getAIOBindGuildInfo(@NotNull final GetAIOBindGuildInfoReq req, @Nullable IGetAIOBindGuildInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getAIOBindGuildInfo", callback, new Function1<IGetAIOBindGuildInfoCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getAIOBindGuildInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GetAIOBindGuildInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetAIOBindGuildInfoCallback iGetAIOBindGuildInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetAIOBindGuildInfoCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getAIOBindGuildInfo(this.$req, iGetAIOBindGuildInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getAllGroupPrivilegeFlag(@NotNull final ArrayList<Long> groupCodes, final int serviceType, @Nullable IGroupPrivilegeFlagCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, groupCodes, Integer.valueOf(serviceType), callback);
        } else {
            Intrinsics.checkNotNullParameter(groupCodes, "groupCodes");
            check("getAllGroupPrivilegeFlag", callback, new Function1<IGroupPrivilegeFlagCallback, Unit>(groupCodes, serviceType) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getAllGroupPrivilegeFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<Long> $groupCodes;
                final /* synthetic */ int $serviceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCodes = groupCodes;
                    this.$serviceType = serviceType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, groupCodes, Integer.valueOf(serviceType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupPrivilegeFlagCallback iGroupPrivilegeFlagCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupPrivilegeFlagCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getAllGroupPrivilegeFlag(this.$groupCodes, this.$serviceType, iGroupPrivilegeFlagCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getAllMemberList(final long groupCode, final boolean forceFetch, @Nullable IGroupMemberListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Long.valueOf(groupCode), Boolean.valueOf(forceFetch), callback);
        } else {
            check("getAllMemberList", callback, new Function1<IGroupMemberListCallback, Unit>(groupCode, forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getAllMemberList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceFetch;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$forceFetch = forceFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), Boolean.valueOf(forceFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberListCallback iGroupMemberListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberListCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getAllMemberList(this.$groupCode, this.$forceFetch, iGroupMemberListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getAllMemberListV2(final long groupCode, final boolean forceFetch, @Nullable IGroupMemberListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Long.valueOf(groupCode), Boolean.valueOf(forceFetch), callback);
        } else {
            check("getAllMemberListV2", callback, new Function1<IGroupMemberListCallback, Unit>(groupCode, forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getAllMemberListV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceFetch;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$forceFetch = forceFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), Boolean.valueOf(forceFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberListCallback iGroupMemberListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberListCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getAllMemberListV2(this.$groupCode, this.$forceFetch, iGroupMemberListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getAppCenter(@NotNull final GetAppCenterReq req, @Nullable final IGetAppCenterCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "getAppCenter", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getAppCenter$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetAppCenterCallback $callback;
                final /* synthetic */ GetAppCenterReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getAppCenter(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupBindGuilds(@NotNull final GetGroupBindGuildsReq req, @Nullable IGetGroupBindGuildsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupBindGuilds", callback, new Function1<IGetGroupBindGuildsCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupBindGuilds$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GetGroupBindGuildsReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupBindGuildsCallback iGetGroupBindGuildsCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupBindGuildsCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupBindGuilds(this.$req, iGetGroupBindGuildsCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    @Nullable
    public Integer getGroupDBVersion(int tableId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (Integer) iPatchRedirector.redirect((short) 62, (Object) this, tableId);
        }
        IKernelGroupService service = getService();
        if (service != null) {
            return Integer.valueOf(service.getGroupDBVersion(tableId));
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupDetailInfo(final long groupCode, @NotNull final GroupInfoSource source, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(groupCode), source, cb5);
        } else {
            Intrinsics.checkNotNullParameter(source, "source");
            check("getGroupDetailInfo", cb5, new Function1<IOperateCallback, Unit>(groupCode, source) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupDetailInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ GroupInfoSource $source;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$source = source;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), source);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupDetailInfo(this.$groupCode, this.$source, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupDetailInfoByFilter(@NotNull final GroupDetailInfoReq req, final int serviceType, final int callFrom, final boolean forceFetch, @Nullable IGroupDetailInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, req, Integer.valueOf(serviceType), Integer.valueOf(callFrom), Boolean.valueOf(forceFetch), callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupDetailInfoByFilter", callback, new Function1<IGroupDetailInfoCallback, Unit>(req, serviceType, callFrom, forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupDetailInfoByFilter$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $callFrom;
                final /* synthetic */ boolean $forceFetch;
                final /* synthetic */ GroupDetailInfoReq $req;
                final /* synthetic */ int $serviceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    this.$serviceType = serviceType;
                    this.$callFrom = callFrom;
                    this.$forceFetch = forceFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, Integer.valueOf(serviceType), Integer.valueOf(callFrom), Boolean.valueOf(forceFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupDetailInfoCallback iGroupDetailInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupDetailInfoCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupDetailInfoByFilter(this.$req, this.$serviceType, this.$callFrom, this.$forceFetch, iGroupDetailInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupExtList(final boolean forceFetch, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(forceFetch), cb5);
        } else {
            check("getGroupExtList", cb5, new Function1<IOperateCallback, Unit>(forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupExtList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceFetch;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$forceFetch = forceFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(forceFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupExtList(this.$forceFetch, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupInfoForJoinGroup(final long groupCode, final boolean needPrivilegeFlag, final int serviceType, @Nullable IGroupInfoForJoinCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, Long.valueOf(groupCode), Boolean.valueOf(needPrivilegeFlag), Integer.valueOf(serviceType), callback);
        } else {
            check("getGroupInfoForJoinGroup", callback, new Function1<IGroupInfoForJoinCallback, Unit>(groupCode, needPrivilegeFlag, serviceType) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupInfoForJoinGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ boolean $needPrivilegeFlag;
                final /* synthetic */ int $serviceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$needPrivilegeFlag = needPrivilegeFlag;
                    this.$serviceType = serviceType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), Boolean.valueOf(needPrivilegeFlag), Integer.valueOf(serviceType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupInfoForJoinCallback iGroupInfoForJoinCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupInfoForJoinCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupInfoForJoinGroup(this.$groupCode, this.$needPrivilegeFlag, this.$serviceType, iGroupInfoForJoinCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupLatestEssenceList(@NotNull final GetGroupLatestEssenceListReq req, @Nullable IGetGroupLatestEssenceListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupLatestEssenceList", callback, new Function1<IGetGroupLatestEssenceListCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupLatestEssenceList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GetGroupLatestEssenceListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupLatestEssenceListCallback iGetGroupLatestEssenceListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupLatestEssenceListCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupLatestEssenceList(this.$req, iGetGroupLatestEssenceListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupList(final boolean forceFetch, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(forceFetch), cb5);
        } else {
            check("getGroupList", cb5, new Function1<IOperateCallback, Unit>(forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceFetch;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$forceFetch = forceFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(forceFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupList(this.$forceFetch, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupMedalList(@NotNull final GetGroupMedalListReq req, @NotNull final IGetGroupMedalListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "getGroupMedalList", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupMedalList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupMedalListCallback $callback;
            final /* synthetic */ GetGroupMedalListReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.getGroupMedalList(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupMemberLevelInfo(final long groupCode, @Nullable final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, this, Long.valueOf(groupCode), cb5);
        } else {
            check("getGroupMemberLevelInfo", new Function0<Unit>(groupCode, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupMemberLevelInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $cb;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$groupCode = groupCode;
                    this.$cb = cb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), cb5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupMemberLevelInfo(this.$groupCode, this.$cb);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupMemberMaxNum(final long groupCode, final int serviceType, @Nullable IGroupMemberMaxNumCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, Long.valueOf(groupCode), Integer.valueOf(serviceType), callback);
        } else {
            check("getGroupMemberMaxNum", callback, new Function1<IGroupMemberMaxNumCallback, Unit>(groupCode, serviceType) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupMemberMaxNum$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ int $serviceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$serviceType = serviceType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), Integer.valueOf(serviceType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberMaxNumCallback iGroupMemberMaxNumCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberMaxNumCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupMemberMaxNum(this.$groupCode, this.$serviceType, iGroupMemberMaxNumCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupMsgLimitFreq(final long groupCode, @Nullable IGroupMsgLimitFreqCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, this, Long.valueOf(groupCode), callback);
        } else {
            check("getGroupMsgLimitFreq", callback, new Function1<IGroupMsgLimitFreqCallback, Unit>(groupCode) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupMsgLimitFreq$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMsgLimitFreqCallback iGroupMsgLimitFreqCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMsgLimitFreqCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupMsgLimitFreq(this.$groupCode, iGroupMsgLimitFreqCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupPayToJoinStatus(final long groupCode, @Nullable IGroupPayToJoinStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, Long.valueOf(groupCode), callback);
        } else {
            check("getGroupPayToJoinStatus", callback, new Function1<IGroupPayToJoinStatusCallback, Unit>(groupCode) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupPayToJoinStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupPayToJoinStatusCallback iGroupPayToJoinStatusCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupPayToJoinStatusCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupPayToJoinStatus(this.$groupCode, iGroupPayToJoinStatusCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupPlusAppList(@NotNull final GetAppListReq req, @NotNull final IGetAppListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "getGroupPlusAppList", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupPlusAppList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetAppListCallback $callback;
            final /* synthetic */ GetAppListReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.getGroupPlusAppList(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupRemainAtTimes(final long groupCode, @Nullable final IGetGroupRemainAtAllTimesOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Long.valueOf(groupCode), cb5);
        } else {
            check("getGroupRemainAtTimes", new Function0<Unit>(groupCode, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupRemainAtTimes$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetGroupRemainAtAllTimesOperateCallback $cb;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$groupCode = groupCode;
                    this.$cb = cb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), cb5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupRemainAtTimes(this.$groupCode, this.$cb);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupSeqAndJoinTimeForGrayTips(final long groupCode, @Nullable IGroupInfoForGrayTipsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, Long.valueOf(groupCode), callback);
        } else {
            check("getGroupSeqAndJoinTimeForGrayTips", callback, new Function1<IGroupInfoForGrayTipsCallback, Unit>(groupCode) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupSeqAndJoinTimeForGrayTips$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupInfoForGrayTipsCallback iGroupInfoForGrayTipsCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupInfoForGrayTipsCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSeqAndJoinTimeForGrayTips(this.$groupCode, iGroupInfoForGrayTipsCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getGroupSquareRedpointInfo(@NotNull final GetGroupSquareRedpointInfoReq req, final boolean forceFetch, @Nullable IGetGroupSquareRedpointInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, this, req, Boolean.valueOf(forceFetch), callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSquareRedpointInfo", callback, new Function1<IGetGroupSquareRedpointInfoCallback, Unit>(req, forceFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getGroupSquareRedpointInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceFetch;
                final /* synthetic */ GetGroupSquareRedpointInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    this.$forceFetch = forceFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, Boolean.valueOf(forceFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSquareRedpointInfoCallback iGetGroupSquareRedpointInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSquareRedpointInfoCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSquareRedpointInfo(this.$req, this.$forceFetch, iGetGroupSquareRedpointInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getIdentityList(@NotNull final GetIdentityListReq req, @NotNull final IGetIdentityListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            iPatchRedirector.redirect((short) 141, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "getIdentityList", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getIdentityList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetIdentityListCallback $callback;
            final /* synthetic */ GetIdentityListReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.getIdentityList(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getIllegalMemberList(final long groupCode, @Nullable IGroupMemberIllegalInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, Long.valueOf(groupCode), callback);
        } else {
            check("getIllegalMemberList", callback, new Function1<IGroupMemberIllegalInfoCallback, Unit>(groupCode) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getIllegalMemberList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberIllegalInfoCallback iGroupMemberIllegalInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberIllegalInfoCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getIllegalMemberList(this.$groupCode, iGroupMemberIllegalInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getMemberCommonInfo(@NotNull final GroupMemberCommonReq req, @Nullable IGroupMemberCommonCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getMemberCommonInfo", callback, new Function1<IGroupMemberCommonCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getMemberCommonInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupMemberCommonReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberCommonCallback iGroupMemberCommonCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberCommonCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getMemberCommonInfo(this.$req, iGroupMemberCommonCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getMemberExtInfo(@NotNull final GroupMemberExtReq req, @Nullable IGroupMemberExtCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getMemberExtInfo", callback, new Function1<IGroupMemberExtCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getMemberExtInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupMemberExtReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberExtCallback iGroupMemberExtCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberExtCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getMemberExtInfo(this.$req, iGroupMemberExtCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getMemberInfo(final long groupCode, @NotNull final ArrayList<String> uids, final boolean forceUpdate, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, Long.valueOf(groupCode), uids, Boolean.valueOf(forceUpdate), cb5);
        } else {
            Intrinsics.checkNotNullParameter(uids, "uids");
            check("getMemberInfo", cb5, new Function1<IOperateCallback, Unit>(groupCode, uids, forceUpdate) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getMemberInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceUpdate;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ ArrayList<String> $uids;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$uids = uids;
                    this.$forceUpdate = forceUpdate;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), uids, Boolean.valueOf(forceUpdate));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getMemberInfo(this.$groupCode, this.$uids, this.$forceUpdate, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getNextMemberList(@NotNull final String sceneId, @Nullable final GroupMemberInfoListId lastId, final int num, @NotNull final IGroupMemberListCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, sceneId, lastId, Integer.valueOf(num), result);
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(result, "result");
        check("getNextMemberList", new Function0<Unit>(sceneId, lastId, num, result) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getNextMemberList$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ GroupMemberInfoListId $lastId;
            final /* synthetic */ int $num;
            final /* synthetic */ IGroupMemberListCallback $result;
            final /* synthetic */ String $sceneId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sceneId = sceneId;
                this.$lastId = lastId;
                this.$num = num;
                this.$result = result;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, sceneId, lastId, Integer.valueOf(num), result);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getNextMemberList(this.$sceneId, this.$lastId, this.$num, this.$result);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getRecGroups(final long groupCode, @NotNull final GroupSquareTabItem tab, @NotNull final String cookies, @Nullable IGetRecGroupsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, this, Long.valueOf(groupCode), tab, cookies, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        check("getRecGroups", callback, new Function1<IGetRecGroupsCallback, Unit>(groupCode, tab, cookies) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getRecGroups$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $cookies;
            final /* synthetic */ long $groupCode;
            final /* synthetic */ GroupSquareTabItem $tab;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupCode = groupCode;
                this.$tab = tab;
                this.$cookies = cookies;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), tab, cookies);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGetRecGroupsCallback iGetRecGroupsCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetRecGroupsCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getRecGroups(this.$groupCode, this.$tab, this.$cookies, iGetRecGroupsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getSingleScreenNotifiesV2(final boolean doubt, final long startSeq, final int number, final int category, @Nullable final IGetGroupSingleScreenNotifiesCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(doubt), Long.valueOf(startSeq), Integer.valueOf(number), Integer.valueOf(category), cb5);
        } else {
            BaseService.checkCommon$default(this, "getSingleScreenNotifiesV2", new Function0<Unit>(doubt, startSeq, number, category, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getSingleScreenNotifiesV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $category;
                final /* synthetic */ IGetGroupSingleScreenNotifiesCallback $cb;
                final /* synthetic */ boolean $doubt;
                final /* synthetic */ int $number;
                final /* synthetic */ long $startSeq;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$doubt = doubt;
                    this.$startSeq = startSeq;
                    this.$number = number;
                    this.$category = category;
                    this.$cb = cb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(doubt), Long.valueOf(startSeq), Integer.valueOf(number), Integer.valueOf(category), cb5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getSingleScreenNotifiesV2(this.$doubt, this.$startSeq, this.$number, this.$category, this.$cb);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getSubGroupInfo(@NotNull final GetSubGroupInfoReq req, @Nullable IGetSubGroupInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getSubGroupInfo", callback, new Function1<IGetSubGroupInfoCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getSubGroupInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GetSubGroupInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetSubGroupInfoCallback iGetSubGroupInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetSubGroupInfoCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getSubGroupInfo(this.$req, iGetSubGroupInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getTeamUpDetail(@NotNull final GetTeamUpDetailReq req, @Nullable final IGetTeamUpDetailCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "getTeamUpDetail", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTeamUpDetail$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetTeamUpDetailCallback $callback;
                final /* synthetic */ GetTeamUpDetailReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getTeamUpDetail(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getTeamUpList(@NotNull final GetTeamUpListReq req, @Nullable final IGetTeamUpListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            checkCommon("getTeamUpList", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTeamUpList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetTeamUpListCallback $callback;
                final /* synthetic */ GetTeamUpListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getTeamUpList(this.$req, this.$callback);
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTeamUpList$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IGetTeamUpListCallback.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IGetTeamUpListCallback iGetTeamUpListCallback = IGetTeamUpListCallback.this;
                    if (iGetTeamUpListCallback != null) {
                        iGetTeamUpListCallback.onResult(-1, "inner error", new GetTeamUpListRsp());
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getTeamUpMembers(@NotNull final GetTeamUpMembersReq req, @Nullable final IGetTeamUpMembersCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "getTeamUpMembers", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTeamUpMembers$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetTeamUpMembersCallback $callback;
                final /* synthetic */ GetTeamUpMembersReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getTeamUpMembers(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getTeamUpTemplateList(@NotNull final GetTeamUpTemplateListReq req, @Nullable final IGetTeamUpTemplateListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "getTeamUpTemplateList", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTeamUpTemplateList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetTeamUpTemplateListCallback $callback;
                final /* synthetic */ GetTeamUpTemplateListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getTeamUpTemplateList(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getTopicPage(final long groupCode, final long bannerId, @NotNull final String cookies, @NotNull final String ext, @Nullable IGetTopicPageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, this, Long.valueOf(groupCode), Long.valueOf(bannerId), cookies, ext, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(ext, "ext");
        check("getTopicPage", callback, new Function1<IGetTopicPageCallback, Unit>(groupCode, bannerId, cookies, ext) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTopicPage$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $bannerId;
            final /* synthetic */ String $cookies;
            final /* synthetic */ String $ext;
            final /* synthetic */ long $groupCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupCode = groupCode;
                this.$bannerId = bannerId;
                this.$cookies = cookies;
                this.$ext = ext;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), Long.valueOf(bannerId), cookies, ext);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGetTopicPageCallback iGetTopicPageCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetTopicPageCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getTopicPage(this.$groupCode, this.$bannerId, this.$cookies, this.$ext, iGetTopicPageCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getTopicRecall(@NotNull final TopicRecallReq req, @Nullable final ITopicRecallCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "getTopicRecall", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getTopicRecall$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ITopicRecallCallback $callback;
                final /* synthetic */ TopicRecallReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getTopicRecall(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getUidByUins(@NotNull final ArrayList<Long> uins, @Nullable IGroupMemberUidCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) uins, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(uins, "uins");
            check("getUidByUins", callback, new Function1<IGroupMemberUidCallback, Unit>(uins) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getUidByUins$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<Long> $uins;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uins = uins;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) uins);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberUidCallback iGroupMemberUidCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberUidCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getUidByUins(this.$uins, iGroupMemberUidCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void getUinByUids(@NotNull final ArrayList<String> uids, @Nullable IGroupMemberUinCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) uids, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(uids, "uids");
            check("getUinByUids", callback, new Function1<IGroupMemberUinCallback, Unit>(uids) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getUinByUids$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<String> $uids;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uids = uids;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) uids);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupMemberUinCallback iGroupMemberUinCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupMemberUinCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getUinByUids(this.$uids, iGroupMemberUinCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void groupBlacklistDelApply(@NotNull final GroupBlacklistDelApplyReq req, @NotNull final IGroupBlacklistDelApplyCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            iPatchRedirector.redirect((short) 123, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "groupBlacklistDelApply", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$groupBlacklistDelApply$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupBlacklistDelApplyCallback $callback;
            final /* synthetic */ GroupBlacklistDelApplyReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.groupBlacklistDelApply(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void groupBlacklistGetAllApply(@NotNull final GroupBlacklistGetAllApplyReq req, @NotNull final IGroupBlacklistGetAllApplyCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "groupBlacklistGetAllApply", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$groupBlacklistGetAllApply$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupBlacklistGetAllApplyCallback $callback;
            final /* synthetic */ GroupBlacklistGetAllApplyReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.groupBlacklistGetAllApply(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void h0(final long groupCode, @NotNull final String ext, @Nullable IGetHomeHeadCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, Long.valueOf(groupCode), ext, callback);
        } else {
            Intrinsics.checkNotNullParameter(ext, "ext");
            check("getHomeHead", callback, new Function1<IGetHomeHeadCallback, Unit>(groupCode, ext) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getHomeHead$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $ext;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$ext = ext;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), ext);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetHomeHeadCallback iGetHomeHeadCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetHomeHeadCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSquareHomeHead(this.$groupCode, this.$ext, iGetHomeHeadCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void halfScreenPullNotice(@NotNull final HalfScreenPullNoticeReq req, @NotNull final IHalfScreenPullNoticeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "halfScreenPullNotice", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$halfScreenPullNotice$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IHalfScreenPullNoticeCallback $callback;
            final /* synthetic */ HalfScreenPullNoticeReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.halfScreenPullNotice(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void halfScreenReportClick(@NotNull final HalfScreenReportClickReq req, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "halfScreenReportClick", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$halfScreenReportClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ HalfScreenReportClickReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.halfScreenReportClick(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void inviteToGroupV2(@NotNull final InviteGroupReq inviteReq, @Nullable IInviteToGroupCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) inviteReq, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(inviteReq, "inviteReq");
            check("inviteToGroupV2", callback, new Function1<IInviteToGroupCallback, Unit>(inviteReq) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$inviteToGroupV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ InviteGroupReq $inviteReq;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$inviteReq = inviteReq;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) inviteReq);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IInviteToGroupCallback iInviteToGroupCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iInviteToGroupCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.inviteToGroupV2(this.$inviteReq, iInviteToGroupCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void joinGroup(@NotNull final ReqToGroup reqInfo, @Nullable IJoinGroupCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) reqInfo, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(reqInfo, "reqInfo");
            check("joinGroup", callback, new Function1<IJoinGroupCallback, Unit>(reqInfo) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$joinGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ReqToGroup $reqInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$reqInfo = reqInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) reqInfo);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IJoinGroupCallback iJoinGroupCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iJoinGroupCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.joinGroup(this.$reqInfo, iJoinGroupCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void kickMemberV2(@NotNull final KickMemberReq kickReq, @Nullable IKickMemberCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) kickReq, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(kickReq, "kickReq");
            check("kickMemberV2", cb5, new Function1<IKickMemberCallback, Unit>(kickReq) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$kickMemberV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ KickMemberReq $kickReq;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$kickReq = kickReq;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) kickReq);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IKickMemberCallback iKickMemberCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iKickMemberCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.kickMemberV2(this.$kickReq, iKickMemberCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void listAllAIVoice(@NotNull final ListAllVoiceReq req, @NotNull final IListAllVoiceCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "listAllAIVoice", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$listAllAIVoice$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IListAllVoiceCallback $callback;
            final /* synthetic */ ListAllVoiceReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.listAllAIVoice(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void miniAppGetGroupInfo(@Nullable final MiniAppGetGroupInfoReq req, @Nullable final IMiniAppGetGroupInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, (Object) this, (Object) req, (Object) callback);
        } else {
            BaseService.checkCommon$default(this, "miniAppGetGroupInfo", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$miniAppGetGroupInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IMiniAppGetGroupInfoCallback $callback;
                final /* synthetic */ MiniAppGetGroupInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.miniAppGetGroupInfo(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void modifyGroupDetailInfoV2(@NotNull final GroupModifyInfoReq modifyInfoReq, final int serviceType, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, modifyInfoReq, Integer.valueOf(serviceType), cb5);
        } else {
            Intrinsics.checkNotNullParameter(modifyInfoReq, "modifyInfoReq");
            check("modifyGroupDetailInfoV2", cb5, new Function1<IOperateCallback, Unit>(modifyInfoReq, serviceType) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$modifyGroupDetailInfoV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupModifyInfoReq $modifyInfoReq;
                final /* synthetic */ int $serviceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$modifyInfoReq = modifyInfoReq;
                    this.$serviceType = serviceType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, modifyInfoReq, Integer.valueOf(serviceType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.modifyGroupDetailInfoV2(this.$modifyInfoReq, this.$serviceType, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void modifyGroupExtInfoV2(@NotNull final GroupExtInfo extInfo, @NotNull final GroupExtFilter filter, @Nullable IModifyGroupExtCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, this, extInfo, filter, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Intrinsics.checkNotNullParameter(filter, "filter");
        check("modifyGroupExtInfoV2", callback, new Function1<IModifyGroupExtCallback, Unit>(extInfo, filter) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$modifyGroupExtInfoV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ GroupExtInfo $extInfo;
            final /* synthetic */ GroupExtFilter $filter;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$extInfo = extInfo;
                this.$filter = filter;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, extInfo, filter);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IModifyGroupExtCallback iModifyGroupExtCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iModifyGroupExtCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.modifyGroupExtInfoV2(this.$extInfo, this.$filter, iModifyGroupExtCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void modifyGroupName(final long groupCode, @NotNull final String groupName, final boolean isConf, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(groupCode), groupName, Boolean.valueOf(isConf), cb5);
        } else {
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            check("modifyGroupName", cb5, new Function1<IOperateCallback, Unit>(groupCode, groupName, isConf) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$modifyGroupName$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ String $groupName;
                final /* synthetic */ boolean $isConf;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$groupName = groupName;
                    this.$isConf = isConf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), groupName, Boolean.valueOf(isConf));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.modifyGroupName(this.$groupCode, this.$groupName, this.$isConf, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void modifyGroupRemark(final long groupCode, @NotNull final String groupRemark, @NotNull IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Long.valueOf(groupCode), groupRemark, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(groupRemark, "groupRemark");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        check("modifyGroupRemark", cb5, new Function1<IOperateCallback, Unit>(groupCode, groupRemark) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$modifyGroupRemark$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $groupCode;
            final /* synthetic */ String $groupRemark;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupCode = groupCode;
                this.$groupRemark = groupRemark;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), groupRemark);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.modifyGroupRemark(this.$groupCode, this.$groupRemark, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void operateSysNotifyV2(final boolean doubt, @NotNull final GroupNotifyOperateMsg operateMsg, @Nullable final IGroupNotifyOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Boolean.valueOf(doubt), operateMsg, cb5);
        } else {
            Intrinsics.checkNotNullParameter(operateMsg, "operateMsg");
            BaseService.checkCommon$default(this, "getSysNotifyListV2", new Function0<Unit>(doubt, operateMsg, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$operateSysNotifyV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGroupNotifyOperateCallback $cb;
                final /* synthetic */ boolean $doubt;
                final /* synthetic */ GroupNotifyOperateMsg $operateMsg;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$doubt = doubt;
                    this.$operateMsg = operateMsg;
                    this.$cb = cb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Boolean.valueOf(doubt), operateMsg, cb5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.operateSysNotifyV2(this.$doubt, this.$operateMsg, this.$cb);
                    }
                }
            }, null, 4, null);
        }
    }

    @NotNull
    public final IKernelGroupListener p4(@NotNull IKernelGroupListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IKernelGroupListener) iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new b(listener);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void postTeamUp(@NotNull final PostTeamUpReq req, @Nullable final IPostTeamUpCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "postTeamUp", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$postTeamUp$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IPostTeamUpCallback $callback;
                final /* synthetic */ PostTeamUpReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.postTeamUp(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void queryGroupTopBanners(@NotNull final QueryGroupTopBannersReq req, @NotNull final IQueryGroupTopBannersCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            iPatchRedirector.redirect((short) 144, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "queryGroupTopBanners", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$queryGroupTopBanners$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IQueryGroupTopBannersCallback $callback;
            final /* synthetic */ QueryGroupTopBannersReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.queryGroupTopBanners(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void quitGroupV2(@NotNull final QuitGroupReq req, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("quitGroup", result, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$quitGroupV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QuitGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.quitGroupV2(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void s(@Nullable final GetCapsuleAppReq req, final boolean forceFetch, @Nullable final IGetCapsuleAppProCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, this, req, Boolean.valueOf(forceFetch), callback);
        } else {
            checkCommon("getCapsuleApp", new Function0<Unit>(req, forceFetch, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getCapsuleApp$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetCapsuleAppProCallback $callback;
                final /* synthetic */ boolean $forceFetch;
                final /* synthetic */ GetCapsuleAppReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$forceFetch = forceFetch;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, Boolean.valueOf(forceFetch), callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.getCapsuleAppPro(this.$req, this.$forceFetch, this.$callback);
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$getCapsuleApp$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IGetCapsuleAppProCallback.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IGetCapsuleAppProCallback iGetCapsuleAppProCallback = IGetCapsuleAppProCallback.this;
                    if (iGetCapsuleAppProCallback != null) {
                        iGetCapsuleAppProCallback.onResult(-1, "inner error", new GetCapsuleAppRsp());
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void saveAIVoice(@NotNull final SaveVoiceReq req, @NotNull final ISaveVoiceCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "saveAIVoice", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$saveAIVoice$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISaveVoiceCallback $callback;
            final /* synthetic */ SaveVoiceReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.saveAIVoice(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void searchMember(@NotNull final String sceneId, @NotNull final String keyword, @NotNull final IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, sceneId, keyword, result);
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(result, "result");
        check("searchMember", result, new Function1<IOperateCallback, Unit>(sceneId, keyword, result) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$searchMember$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $keyword;
            final /* synthetic */ IOperateCallback $result;
            final /* synthetic */ String $sceneId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$sceneId = sceneId;
                this.$keyword = keyword;
                this.$result = result;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, sceneId, keyword, result);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.searchMember(this.$sceneId, this.$keyword, this.$result);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setAIOBindGuild(@NotNull final SetAIOBindGuildReq req, @Nullable ISetAIOBindGuildCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setAIOBindGuild", callback, new Function1<ISetAIOBindGuildCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setAIOBindGuild$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SetAIOBindGuildReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISetAIOBindGuildCallback iSetAIOBindGuildCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSetAIOBindGuildCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setAIOBindGuild(this.$req, iSetAIOBindGuildCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setActiveExtGroup(@NotNull final ActiveExtGroupReq req, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setActiveExtGroup", callback, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setActiveExtGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ActiveExtGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setActiveExtGroup(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setGroupAppList(@NotNull final SetGroupAppListReq req, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setGroupAppList", callback, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setGroupAppList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SetGroupAppListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupAppList(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setGroupGeoInfo(@NotNull final GroupGeoInfoReq req, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setGroupGeoInfo", callback, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setGroupGeoInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupGeoInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupGeoInfo(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setGroupMsgMask(final long groupCode, @NotNull final GroupMsgMask msgMask, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(groupCode), msgMask, cb5);
        } else {
            Intrinsics.checkNotNullParameter(msgMask, "msgMask");
            check("setGroupMsgMask", cb5, new Function1<IOperateCallback, Unit>(groupCode, msgMask) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setGroupMsgMask$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ GroupMsgMask $msgMask;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$msgMask = msgMask;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), msgMask);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupMsgMask(this.$groupCode, this.$msgMask, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setGroupMsgMaskV2(@NotNull final SetGroupMsgMaskReq req, final int serviceType, @Nullable ISetGroupMsgMaskCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, req, Integer.valueOf(serviceType), cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setGroupMsgMaskV2", cb5, new Function1<ISetGroupMsgMaskCallback, Unit>(req, serviceType) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setGroupMsgMaskV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SetGroupMsgMaskReq $req;
                final /* synthetic */ int $serviceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    this.$serviceType = serviceType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, Integer.valueOf(serviceType));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISetGroupMsgMaskCallback iSetGroupMsgMaskCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSetGroupMsgMaskCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupMsgMaskV2(this.$req, this.$serviceType, iSetGroupMsgMaskCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setGroupRelationToGuild(@NotNull final SetGroupRelationToGuildReq req, @Nullable ISetGroupRelationToGuildCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setGroupRelationToGuild", callback, new Function1<ISetGroupRelationToGuildCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setGroupRelationToGuild$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SetGroupRelationToGuildReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISetGroupRelationToGuildCallback iSetGroupRelationToGuildCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSetGroupRelationToGuildCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupRelationToGuild(this.$req, iSetGroupRelationToGuildCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setIdentityInteractionTag(@NotNull final SetIdentityInteractionTagReq req, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            iPatchRedirector.redirect((short) 143, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "setIdentityInteractionTag", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setIdentityInteractionTag$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ SetIdentityInteractionTagReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.setIdentityInteractionTag(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setIdentityTitleInfo(@NotNull final SetIdentityTitleInfoReq req, @NotNull final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            iPatchRedirector.redirect((short) 142, (Object) this, (Object) req, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseService.checkCommon$default(this, "setIdentityTitleInfo", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setIdentityTitleInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ SetIdentityTitleInfoReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$req = req;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service != null) {
                    service.setIdentityTitleInfo(this.$req, this.$callback);
                }
            }
        }, null, 4, null);
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setMemberShutUp(final long groupCode, @NotNull final ArrayList<GroupMemberShutUpInfo> memList, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, Long.valueOf(groupCode), memList, callback);
        } else {
            Intrinsics.checkNotNullParameter(memList, "memList");
            check("setMemberShutUp", callback, new Function1<IOperateCallback, Unit>(groupCode, memList) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setMemberShutUp$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ ArrayList<GroupMemberShutUpInfo> $memList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$memList = memList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), memList);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setMemberShutUp(this.$groupCode, this.$memList, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setRcvJoinVerifyMsg(@NotNull final RcvJoinVerifyMsgReq req, @Nullable IRcvJoinVerifyMsgCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setRcvJoinVerifyMsg", callback, new Function1<IRcvJoinVerifyMsgCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setRcvJoinVerifyMsg$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RcvJoinVerifyMsgReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IRcvJoinVerifyMsgCallback iRcvJoinVerifyMsgCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iRcvJoinVerifyMsgCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setRcvJoinVerifyMsg(this.$req, iRcvJoinVerifyMsgCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void setTop(final long groupCode, final boolean isTop, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Long.valueOf(groupCode), Boolean.valueOf(isTop), result);
        } else {
            check("setTop", result, new Function1<IOperateCallback, Unit>(groupCode, isTop) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$setTop$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;
                final /* synthetic */ boolean $isTop;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    this.$isTop = isTop;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), Boolean.valueOf(isTop));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setTop(this.$groupCode, this.$isTop, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void shareTopic(@NotNull final ShareTopicReq req, @Nullable final IShareTopicCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            checkCommon("shareTopic", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$shareTopic$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IShareTopicCallback $callback;
                final /* synthetic */ ShareTopicReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.shareTopic(this.$req, this.$callback);
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$shareTopic$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IShareTopicCallback.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IShareTopicCallback iShareTopicCallback = IShareTopicCallback.this;
                    if (iShareTopicCallback != null) {
                        iShareTopicCallback.onResult(-1, "inner error", new ShareTopicRsp());
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void teamUpCreateGroup(@NotNull final TeamUpCreateGroupReq req, @Nullable final ITeamUpCreateGroupCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "teamUpCreateGroup", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$teamUpCreateGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ITeamUpCreateGroupCallback $callback;
                final /* synthetic */ TeamUpCreateGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.teamUpCreateGroup(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void teamUpInviteToGroup(@NotNull final TeamUpInviteToGroupReq req, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            iPatchRedirector.redirect((short) 119, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "teamUpInviteToGroup", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$teamUpInviteToGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ TeamUpInviteToGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.teamUpInviteToGroup(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void teamUpRequestToJoin(@NotNull final TeamUpRequestToJoinReq req, @Nullable final ITeamUpRequestToJoinCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "teamUpRequestToJoin", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$teamUpRequestToJoin$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ITeamUpRequestToJoinCallback $callback;
                final /* synthetic */ TeamUpRequestToJoinReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.teamUpRequestToJoin(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void teamUpSubmitDeadline(@NotNull final TeamUpSubmitDeadlineReq req, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            iPatchRedirector.redirect((short) 121, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "teamUpSubmitDeadline", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$teamUpSubmitDeadline$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ TeamUpSubmitDeadlineReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.teamUpSubmitDeadline(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void topicFeedback(@NotNull final TopicFeedbackReq req, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "topicFeedback", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$topicFeedback$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ TopicFeedbackReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.topicFeedback(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void topicReport(@NotNull final TopicReportReq req, @Nullable final ITopicReportCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "topicReport", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$topicReport$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ITopicReportCallback $callback;
                final /* synthetic */ TopicReportReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.topicReport(this.$req, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void transferGroupV2(final long groupCode, @NotNull final String oldOwnerUid, @NotNull final String newOwnerUid, @Nullable ITransferGroupCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Long.valueOf(groupCode), oldOwnerUid, newOwnerUid, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(oldOwnerUid, "oldOwnerUid");
        Intrinsics.checkNotNullParameter(newOwnerUid, "newOwnerUid");
        check("transferGroupV2", cb5, new Function1<ITransferGroupCallback, Unit>(groupCode, oldOwnerUid, newOwnerUid) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$transferGroupV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $groupCode;
            final /* synthetic */ String $newOwnerUid;
            final /* synthetic */ String $oldOwnerUid;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupCode = groupCode;
                this.$oldOwnerUid = oldOwnerUid;
                this.$newOwnerUid = newOwnerUid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupService.this, Long.valueOf(groupCode), oldOwnerUid, newOwnerUid);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable ITransferGroupCallback iTransferGroupCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iTransferGroupCallback);
                }
                IKernelGroupService service = GroupService.this.getService();
                if (service == null) {
                    return null;
                }
                service.transferGroupV2(this.$groupCode, this.$oldOwnerUid, this.$newOwnerUid, iTransferGroupCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void unbindAllGuilds(@NotNull final UnbindAllGuildsReq req, @Nullable IUnbindAllGuildsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("unbindAllGuilds", callback, new Function1<IUnbindAllGuildsCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$unbindAllGuilds$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ UnbindAllGuildsReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IUnbindAllGuildsCallback iUnbindAllGuildsCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iUnbindAllGuildsCallback);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.unbindAllGuilds(this.$req, iUnbindAllGuildsCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void updateGroupInfoByMqq(@NotNull final GroupInfoCacheReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this, (Object) req);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("updateGroupInfoByMqq", new Function0<Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$updateGroupInfoByMqq$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupInfoCacheReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.updateGroupInfoByMqq(this.$req);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void updateMemberInfoByMqq(@NotNull GroupMemberCacheReq memberInfoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) memberInfoReq);
            return;
        }
        Intrinsics.checkNotNullParameter(memberInfoReq, "memberInfoReq");
        IKernelGroupService service = getService();
        if (service != null) {
            service.updateMemberInfoByMqq(memberInfoReq);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.s
    public void x0(@Nullable IKernelGroupListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else if (listener != null) {
            removeListener(listener, false, new Function1<Long, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.GroupService$removeGroupListener$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                        return;
                    }
                    IKernelGroupService service = GroupService.this.getService();
                    if (service != null) {
                        service.removeKernelGroupListener(j3);
                    }
                }
            });
        }
    }
}
