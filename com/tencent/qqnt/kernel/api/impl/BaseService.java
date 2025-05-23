package com.tencent.qqnt.kernel.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.internel.CallMonitor;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.AIGCEmojiListInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchBotGetResponse;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetGroupSchoolRoleRsp;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadRsp;
import com.tencent.qqnt.kernel.nativeinterface.CheckImageResult;
import com.tencent.qqnt.kernel.nativeinterface.CheckInGroupSchoolTaskRsp;
import com.tencent.qqnt.kernel.nativeinterface.ConfirmGroupSchoolNoticeRsp;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.DigestRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetAIOBindGuildInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupBindGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupFlagForThirdAppRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupInviteNoAuthLimitRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSquareRedpointInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetHomeHeadRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetRecGroupsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetSubGroupInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetTopicPageRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupAvatarWallRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupEssenceMsgSwitchRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt0xEF0InfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoForGrayTipsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoForJoinRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberHonorListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberMaxNumRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgLimitFreqRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupPayToJoinStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupPrivilegeFlagRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreCategoryListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreDiscoveryRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreSearchRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolToolboxInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSecLevelInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupTagRecordRsp;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetUserGroupSchoolRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBatchQueryCachedGroupDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckEssenceCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckImageCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckInGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckIsBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IConfirmGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICreateGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICreateGroupOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDigestCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotCoreInfosCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIGCEmojiListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAIOBindGuildInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAddRobotGroupListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupBindGuildsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupFlagForThirdAppCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupInviteNoAuthLimitNumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupLatestEssenceListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskCheckInInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskStatisticsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTemplateListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolToolboxInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSquareRedpointInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetHomeHeadCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecGroupsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSubGroupInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTopicPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupAvatarWallCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupEssenceMsgSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupExt0xEF0InfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupInfoForGrayTipsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupInfoForJoinCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberCommonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberHonorCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberIllegalInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberMaxNumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberUidCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberUinCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMsgLimitFreqCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupPayToJoinStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupPrivilegeFlagCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupSecLevelInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupTagRecordCallback;
import com.tencent.qqnt.kernel.nativeinterface.IInviteToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IJoinGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IJoinGroupVerifyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKickMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKickMemberOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IModifyCategoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IModifyGroupExtCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryAIOBindGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryCachedEssenceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRcvJoinVerifyMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotShareLimitCallBack;
import com.tencent.qqnt.kernel.nativeinterface.IRobotStoreCategoryListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotStoreSearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISendCommonRobotCallBack;
import com.tencent.qqnt.kernel.nativeinterface.ISetAIOBindGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetGroupRelationToGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRobotMessagePushCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITransferGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUnbindAllGuildsCallback;
import com.tencent.qqnt.kernel.nativeinterface.InviteToGroupRsp;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupVerifyRsp;
import com.tencent.qqnt.kernel.nativeinterface.KickMemberV2Result;
import com.tencent.qqnt.kernel.nativeinterface.ModifyGroupExtResult;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeRsp;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
import com.tencent.qqnt.kernel.nativeinterface.QueryAIOBindGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.QueryAddRobotGroupListRsp;
import com.tencent.qqnt.kernel.nativeinterface.RcvJoinVerifyMsgRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendResponse;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareLimitRsp;
import com.tencent.qqnt.kernel.nativeinterface.SetAIOBindGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupMsgMaskRsp;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupRelationToGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.TransferGroupRsp;
import com.tencent.qqnt.kernel.nativeinterface.UnbindAllGuildsRsp;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\bh\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B'\u0012\u0007\u0010\u00e8\u0001\u001a\u00020\u0004\u0012\b\u0010\u00ed\u0001\u001a\u00030\u00ec\u0001\u0012\t\u0010\u00f1\u0001\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0006\b\u00fe\u0001\u0010\u00ff\u0001J$\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0014H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0016H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0017H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0019H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001aH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001eH\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001fH\u0002J$\u0010\n\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010 H\u0002J$\u0010\n\u001a\u0004\u0018\u00010!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010!H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\"H\u0002J$\u0010\n\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010#H\u0002J$\u0010\n\u001a\u0004\u0018\u00010$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010$H\u0002J$\u0010\n\u001a\u0004\u0018\u00010%2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010%H\u0002J$\u0010\n\u001a\u0004\u0018\u00010&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010&H\u0002J$\u0010\n\u001a\u0004\u0018\u00010'2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010'H\u0002J$\u0010\n\u001a\u0004\u0018\u00010(2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010(H\u0002J$\u0010\n\u001a\u0004\u0018\u00010)2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010)H\u0002J$\u0010\n\u001a\u0004\u0018\u00010*2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010*H\u0002J$\u0010\n\u001a\u0004\u0018\u00010+2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010+H\u0002J$\u0010\n\u001a\u0004\u0018\u00010,2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010,H\u0002J$\u0010\n\u001a\u0004\u0018\u00010-2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010-H\u0002J$\u0010\n\u001a\u0004\u0018\u00010.2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010.H\u0002J$\u0010\n\u001a\u0004\u0018\u00010/2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010/H\u0002J$\u0010\n\u001a\u0004\u0018\u0001002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000100H\u0002J$\u0010\n\u001a\u0004\u0018\u0001012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000101H\u0002J$\u0010\n\u001a\u0004\u0018\u0001022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000102H\u0002J$\u0010\n\u001a\u0004\u0018\u0001032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000103H\u0002J$\u0010\n\u001a\u0004\u0018\u0001042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000104H\u0002J$\u0010\n\u001a\u0004\u0018\u0001052\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000105H\u0002J$\u0010\n\u001a\u0004\u0018\u0001062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000106H\u0002J$\u0010\n\u001a\u0004\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000107H\u0002J$\u0010\n\u001a\u0004\u0018\u0001082\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000108H\u0002J$\u0010\n\u001a\u0004\u0018\u0001092\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000109H\u0002J$\u0010\n\u001a\u0004\u0018\u00010:2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010:H\u0002J$\u0010\n\u001a\u0004\u0018\u00010;2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010;H\u0002J$\u0010\n\u001a\u0004\u0018\u00010<2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010<H\u0002J$\u0010\n\u001a\u0004\u0018\u00010=2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010=H\u0002J$\u0010\n\u001a\u0004\u0018\u00010>2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010>H\u0002J$\u0010\n\u001a\u0004\u0018\u00010?2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010?H\u0002J$\u0010\n\u001a\u0004\u0018\u00010@2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010@H\u0002J$\u0010\n\u001a\u0004\u0018\u00010A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010AH\u0002J$\u0010\n\u001a\u0004\u0018\u00010B2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010BH\u0002J$\u0010\n\u001a\u0004\u0018\u00010C2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010CH\u0002J$\u0010\n\u001a\u0004\u0018\u00010D2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010DH\u0002J$\u0010\n\u001a\u0004\u0018\u00010E2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010EH\u0002J$\u0010\n\u001a\u0004\u0018\u00010G2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010GH\u0002J$\u0010\n\u001a\u0004\u0018\u00010H2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010HH\u0002J$\u0010\n\u001a\u0004\u0018\u00010I2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010IH\u0002J$\u0010\n\u001a\u0004\u0018\u00010J2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010JH\u0002J$\u0010\n\u001a\u0004\u0018\u00010K2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010KH\u0002J$\u0010\n\u001a\u0004\u0018\u00010L2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010LH\u0002J$\u0010\n\u001a\u0004\u0018\u00010M2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010MH\u0002J$\u0010\n\u001a\u0004\u0018\u00010N2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010NH\u0002J$\u0010\n\u001a\u0004\u0018\u00010O2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010OH\u0002J$\u0010\n\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010PH\u0002J$\u0010\n\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010QH\u0002J$\u0010\n\u001a\u0004\u0018\u00010R2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010RH\u0002J$\u0010\n\u001a\u0004\u0018\u00010S2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010SH\u0002J$\u0010\n\u001a\u0004\u0018\u00010T2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010TH\u0002J$\u0010\n\u001a\u0004\u0018\u00010U2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010UH\u0002J$\u0010\n\u001a\u0004\u0018\u00010V2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010VH\u0002J$\u0010\n\u001a\u0004\u0018\u00010W2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010WH\u0002J$\u0010\n\u001a\u0004\u0018\u00010X2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010XH\u0002J$\u0010\n\u001a\u0004\u0018\u00010Y2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010YH\u0002J$\u0010\n\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010ZH\u0002J$\u0010\n\u001a\u0004\u0018\u00010[2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010[H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\\H\u0002J$\u0010\n\u001a\u0004\u0018\u00010]2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010]H\u0002J$\u0010\n\u001a\u0004\u0018\u00010^2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010^H\u0002J$\u0010\n\u001a\u0004\u0018\u00010_2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010_H\u0002J$\u0010\n\u001a\u0004\u0018\u00010`2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010`H\u0002J$\u0010\n\u001a\u0004\u0018\u00010a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010aH\u0002J$\u0010\n\u001a\u0004\u0018\u00010b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010bH\u0002J$\u0010\n\u001a\u0004\u0018\u00010c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010cH\u0002J$\u0010\n\u001a\u0004\u0018\u00010d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010dH\u0002J$\u0010\n\u001a\u0004\u0018\u00010e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010eH\u0002J$\u0010\n\u001a\u0004\u0018\u00010f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010fH\u0002J$\u0010\n\u001a\u0004\u0018\u00010g2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010gH\u0002J$\u0010\n\u001a\u0004\u0018\u00010h2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010hH\u0002J$\u0010\n\u001a\u0004\u0018\u00010i2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010iH\u0002J<\u0010q\u001a\u00020p2\u0006\u0010j\u001a\u00028\u00002#\u0010o\u001a\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(j\u0012\u0006\u0012\u0004\u0018\u00010n0kH\u0004\u00a2\u0006\u0004\bq\u0010rJD\u0010w\u001a\u00020p2\u0006\u0010j\u001a\u00028\u00002\b\b\u0002\u0010t\u001a\u00020s2!\u0010v\u001a\u001d\u0012\u0013\u0012\u00110n\u00a2\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020p0kH\u0004\u00a2\u0006\u0004\bw\u0010xJ\u0010\u0010{\u001a\u00020p2\u0006\u0010z\u001a\u00020yH\u0004J\u0010\u0010|\u001a\u00020p2\u0006\u0010z\u001a\u00020yH\u0004J0\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00028\u00020~H\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001Jj\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0084\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0083\u00010\u0082\u0001\"\u00030\u0083\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u000b2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u000b\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0086\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u000b2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u000b\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0087\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010h2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010h\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0088\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010a2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010a\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0089\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010b2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010b\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u008a\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\f2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\f\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u008b\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\r2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\r\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u008c\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u000e2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u000e\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u008d\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u000f2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u000f\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u008e\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00102$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0010\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u008f\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00112$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0011\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0090\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\b\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0091\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00122$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0012\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0092\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00142$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0014\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0093\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00162$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0016\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0094\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00172$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0017\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0095\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00182$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0018\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0096\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00192$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0019\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0097\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001a2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u001a\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0098\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001b2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u001b\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0099\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001c2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u001c\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u009a\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001d2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u001d\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u009b\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001e2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u001e\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u009c\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001f2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u001f\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u009d\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010 2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010 \u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u009e\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010!2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010!\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u009f\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\"2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\"\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a0\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010#2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010#\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a1\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010$2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010$\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a2\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010%2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010%\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a3\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010&2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010&\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a4\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010'2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010'\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a5\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010(2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010(\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a6\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010)2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010)\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a7\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010*2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010*\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a8\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010+2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010+\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00a9\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010,2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010,\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00aa\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010-2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010-\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ab\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010.2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010.\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ac\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010/2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010/\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ad\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001002$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000100\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ae\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001012$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000101\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00af\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001022$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000102\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b0\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001032$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000103\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b1\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001042$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000104\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b2\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001052$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000105\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b3\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001062$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000106\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b4\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001072$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000107\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b5\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001082$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000108\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b6\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u0001092$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u000109\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b7\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010:2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010:\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b8\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010;2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010;\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00b9\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010<2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010<\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ba\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010=2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010=\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00bb\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010>2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010>\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00bc\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010?2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010?\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00bd\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010@2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010@\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00be\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010A2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010A\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00bf\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010B2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010B\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c0\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010C2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010C\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c1\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010D2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010D\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c2\u0001J\t\u0010\u00c3\u0001\u001a\u00020pH\u0016JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010E2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010E\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c4\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010G2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010G\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c5\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010H2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010H\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c6\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010I2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010I\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c7\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010J2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010J\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c8\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010K2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010K\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00c9\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010L2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010L\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ca\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010M2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010M\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00cb\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010N2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010N\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00cc\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010g2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010g\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00cd\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010O2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010O\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00ce\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010P2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010P\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00cf\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010Q2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010Q\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d0\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010R2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010R\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d1\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010S2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010S\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d2\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010T2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010T\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d3\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010U2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010U\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d4\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010V2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010V\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d5\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010W2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010W\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d6\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010X2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010X\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d7\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010Y2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010Y\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d8\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010Z2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010Z\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00d9\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010[2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010[\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00da\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\\2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010\\\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00db\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010]2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010]\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00dc\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010^2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010^\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00dd\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010_2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010_\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00de\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010`2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010`\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00df\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010c2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010c\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00e0\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010d2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010d\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00e1\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010e2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010e\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00e2\u0001JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010f2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010f\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00e3\u0001J1\u0010\u00e6\u0001\u001a\u00020p2\u0006\u0010\u0005\u001a\u00020\u00042\r\u0010\u00e4\u0001\u001a\b\u0012\u0004\u0012\u00020p0~2\u000f\b\u0002\u0010\u00e5\u0001\u001a\b\u0012\u0004\u0012\u00020p0~H\u0004JR\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010}2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010i2$\u0010\u007f\u001a \u0012\u0016\u0012\u0014\u0018\u00010i\u00a2\u0006\r\bl\u0012\t\bm\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00028\u00020kH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u00e7\u0001R\u001c\u0010\u00e8\u0001\u001a\u00020\u00048\u0006\u00a2\u0006\u0010\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001\u001a\u0006\b\u00ea\u0001\u0010\u00eb\u0001R \u0010\u00ed\u0001\u001a\u00030\u00ec\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00ed\u0001\u0010\u00ee\u0001\u001a\u0006\b\u00ef\u0001\u0010\u00f0\u0001R+\u0010\u00f1\u0001\u001a\u0004\u0018\u00018\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f1\u0001\u0010\u00f2\u0001\u001a\u0006\b\u00f3\u0001\u0010\u00f4\u0001\"\u0006\b\u00f5\u0001\u0010\u00f6\u0001R6\u0010\u00f8\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020n0\u00f7\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00f8\u0001\u0010\u00f9\u0001\u001a\u0006\b\u00fa\u0001\u0010\u00fb\u0001\"\u0006\b\u00fc\u0001\u0010\u00fd\u0001\u00a8\u0006\u0080\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/kernel/utils/c;", "", "method", "", "curSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;", "cb", "getCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDetailInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICanImportCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDataImportTableNamesCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddJsonGrayTipMsgCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupOperateCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;", "getGuildBinaryDataCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTempChatInfoCallback;", "getTempChatInfoCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelScanEndCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRobotFunctionsCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchRobotCoreInfosCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetRobotMessagePushCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRemoveFriendCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotAuthCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAddRobotToGroupCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetRemoveRobotFromGroupCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAddRobotGroupListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotShareLimitCallBack;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISendCommonRobotCallBack;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupRobotStoreDiscoveryCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotStoreSearchCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBuddyListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotStoreCategoryListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeDetailCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolNoticeCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IConfirmGroupSchoolNoticeCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeStatisticCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetUserGroupSchoolRoleCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberCommonCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberExtCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberHonorCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUidCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUinCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSubGroupInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTemplateListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolTaskCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskDetailCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckInGroupSchoolTaskCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskStatisticsCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskCheckInInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskUnCheckInCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIGCEmojiListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckImageCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadCompleteCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupRelationToGuildCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupBindGuildsCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAIOBindGuildCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryAIOBindGuildCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIOBindGuildInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnbindAllGuildsCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberIllegalInfoCallback;", "func", "Lcom/tencent/qqnt/kernel/nativeinterface/IKickMemberOperateCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKickMemberCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IJoinGroupCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupDetailInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ITransferGroupCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IInviteToGroupCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupMsgMaskCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IJoinGroupVerifyCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRcvJoinVerifyMsgCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPrivilegeFlagCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupEssenceMsgSwitchCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberMaxNumCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupSecLevelInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupAvatarWallCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForGrayTipsCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForJoinCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPayToJoinStatusCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMsgLimitFreqCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupTagRecordCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupFlagForThirdAppCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupInviteNoAuthLimitNumCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyGroupExtCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupLatestEssenceListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IDigestCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckEssenceCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryCachedEssenceCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupExt0xEF0InfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchQueryCachedGroupDetailInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetHomeHeadCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSquareRedpointInfoCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecGroupsCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetTopicPageCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckIsBuddyCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyCategoryCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolToolboxInfoCallback;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "add", "", "addListener", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "", "needCheck", "id", "remove", "removeListener", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)V", "Ljava/lang/Runnable;", "r", "postHandle", "postHandleWithLoginCheck", "T", "Lkotlin/Function0;", WidgetCacheConstellationData.WORK, "check", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "", "msg", "uCb", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IModifyCategoryCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupExt0xEF0InfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IBatchQueryCachedGroupDetailInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IDetailInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICanImportCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IDataImportTableNamesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IAddJsonGrayTipMsgCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICreateGroupCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetMsgsBoxesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetTempChatInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IKernelScanEndCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetRobotFunctionsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IFetchRobotCoreInfosCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetRobotMessagePushCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IRemoveFriendCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IRobotAuthCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetAddRobotToGroupCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetRemoveRobotFromGroupCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetAddRobotGroupListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IRobotShareLimitCallBack;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISendCommonRobotCallBack;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupRobotStoreDiscoveryCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IRobotStoreSearchCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IBuddyListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IRobotStoreCategoryListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeDetailCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolNoticeCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IConfirmGroupSchoolNoticeCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeStatisticCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetUserGroupSchoolRoleCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberCommonCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberExtCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberHonorCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUidCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberUinCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetSubGroupInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTemplateListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolTaskCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskDetailCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICheckInGroupSchoolTaskCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskStatisticsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskCheckInInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskUnCheckInCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIGCEmojiListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICheckImageCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadCompleteCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupRelationToGuildCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupBindGuildsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetAIOBindGuildCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IQueryAIOBindGuildCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetAIOBindGuildInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IUnbindAllGuildsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", QCircleLpReportDc05507.KEY_CLEAR, "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberIllegalInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IKickMemberOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IKickMemberCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IJoinGroupCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupDetailInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ITransferGroupCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IInviteToGroupCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ISetGroupMsgMaskCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IJoinGroupVerifyCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICheckIsBuddyCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IRcvJoinVerifyMsgCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPrivilegeFlagCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupEssenceMsgSwitchCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMemberMaxNumCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupSecLevelInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupAvatarWallCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForGrayTipsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupInfoForJoinCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupPayToJoinStatusCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupMsgLimitFreqCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGroupTagRecordCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupFlagForThirdAppCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupInviteNoAuthLimitNumCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IModifyGroupExtCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupLatestEssenceListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IDigestCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/ICheckEssenceCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IQueryCachedEssenceCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetHomeHeadCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSquareRedpointInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetRecGroupsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetTopicPageCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "suc", "fail", "checkCommon", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolToolboxInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "subTag", "Ljava/lang/String;", "getSubTag", "()Ljava/lang/String;", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "Lcom/tencent/qqnt/kernel/api/impl/py;", "getContent", "()Lcom/tencent/qqnt/kernel/api/impl/py;", "service", "Ljava/lang/Object;", "getService", "()Ljava/lang/Object;", "setService", "(Ljava/lang/Object;)V", "", "listenersMap", "Ljava/util/Map;", "getListenersMap", "()Ljava/util/Map;", "setListenersMap", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/api/impl/py;Ljava/lang/Object;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class BaseService<L, S> implements com.tencent.qqnt.kernel.utils.c {
    static IPatchRedirector $redirector_;

    @NotNull
    private final py content;

    @NotNull
    private Map<L, Long> listenersMap;

    @Nullable
    private S service;

    @NotNull
    private final String subTag;

    public BaseService(@NotNull String subTag, @NotNull py content, @Nullable S s16) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, subTag, content, s16);
            return;
        }
        this.subTag = subTag;
        this.content = content;
        this.service = s16;
        this.listenersMap = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkCommon$default(BaseService baseService, String str, Function0 function0, Function0 function02, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                function02 = BaseService$checkCommon$1.INSTANCE;
            }
            baseService.checkCommon(str, function0, function02);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkCommon");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetMsgsBoxesCallback getCallback(final String method, final int curSeq, final IGetMsgsBoxesCallback cb5) {
        if (cb5 != null) {
            return new IGetMsgsBoxesCallback() { // from class: com.tencent.qqnt.kernel.api.impl.dw
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgsBoxesCallback
                public final void onMsgBoxesInfo(int i3, String str, ArrayList arrayList) {
                    BaseService.getCallback$lambda$6$lambda$5(BaseService.this, method, curSeq, cb5, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$102$lambda$101(final BaseService this$0, final String method, final int i3, final IBatchGetUserGroupSchoolRoleCallback it, final int i16, final String str, final BatchGetGroupSchoolRoleRsp batchGetGroupSchoolRoleRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cz
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$102$lambda$101$lambda$100(BaseService.this, method, i16, str, i3, it, batchGetGroupSchoolRoleRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$102$lambda$101$lambda$100(BaseService this$0, String method, int i3, String str, int i16, IBatchGetUserGroupSchoolRoleCallback it, BatchGetGroupSchoolRoleRsp batchGetGroupSchoolRoleRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, batchGetGroupSchoolRoleRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$105$lambda$104(final BaseService this$0, final String method, final int i3, final IGroupMemberListCallback it, final int i16, final String str, final GroupMemberListResult groupMemberListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.go
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$105$lambda$104$lambda$103(BaseService.this, method, i16, str, i3, it, groupMemberListResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$105$lambda$104$lambda$103(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberListCallback it, GroupMemberListResult groupMemberListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMemberListResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$108$lambda$107(final BaseService this$0, final String method, final int i3, final IGroupMemberCommonCallback it, final int i16, final String str, final GroupMemberCommonListResult groupMemberCommonListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dd
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$108$lambda$107$lambda$106(BaseService.this, method, i16, str, i3, it, groupMemberCommonListResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$108$lambda$107$lambda$106(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberCommonCallback it, GroupMemberCommonListResult groupMemberCommonListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMemberCommonListResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$111$lambda$110(final BaseService this$0, final String method, final int i3, final IGroupMemberExtCallback it, final int i16, final String str, final GroupMemberExtListResult groupMemberExtListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ck
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$111$lambda$110$lambda$109(BaseService.this, method, i16, str, i3, it, groupMemberExtListResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$111$lambda$110$lambda$109(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberExtCallback it, GroupMemberExtListResult groupMemberExtListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMemberExtListResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$114$lambda$113(final BaseService this$0, final String method, final int i3, final IGroupMemberHonorCallback it, final int i16, final String str, final GroupMemberHonorListResult groupMemberHonorListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gd
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$114$lambda$113$lambda$112(BaseService.this, method, i16, str, i3, it, groupMemberHonorListResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$114$lambda$113$lambda$112(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberHonorCallback it, GroupMemberHonorListResult groupMemberHonorListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMemberHonorListResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$117$lambda$116(final BaseService this$0, final String method, final int i3, final IGroupMemberUidCallback it, final int i16, final String str, final HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gj
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$117$lambda$116$lambda$115(BaseService.this, method, i16, str, i3, it, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$117$lambda$116$lambda$115(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberUidCallback it, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$12$lambda$11(final BaseService this$0, final String method, final int i3, final IDetailInfoCallback it, final int i16, final String str, final Source source, final HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cb
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$12$lambda$11$lambda$10(BaseService.this, method, i16, source, i3, it, str, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$12$lambda$11$lambda$10(BaseService this$0, String method, int i3, Source source, int i16, IDetailInfoCallback it, String str, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", source)}, Integer.valueOf(i16));
        it.onResult(i3, str, source, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$120$lambda$119(final BaseService this$0, final String method, final int i3, final IGroupMemberUinCallback it, final int i16, final String str, final HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cw
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$120$lambda$119$lambda$118(BaseService.this, method, i16, str, i3, it, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$120$lambda$119$lambda$118(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberUinCallback it, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$123$lambda$122(final BaseService this$0, final String method, final int i3, final IGetSubGroupInfoCallback it, final int i16, final String str, final GetSubGroupInfoRsp getSubGroupInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gb
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$123$lambda$122$lambda$121(BaseService.this, method, i16, str, i3, it, getSubGroupInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$123$lambda$122$lambda$121(BaseService this$0, String method, int i3, String str, int i16, IGetSubGroupInfoCallback it, GetSubGroupInfoRsp getSubGroupInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getSubGroupInfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$126$lambda$125(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolTemplateListCallback it, final int i16, final String str, final GroupSchoolTemplateListRsp groupSchoolTemplateListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fl
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$126$lambda$125$lambda$124(BaseService.this, method, i16, str, i3, it, groupSchoolTemplateListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$126$lambda$125$lambda$124(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolTemplateListCallback it, GroupSchoolTemplateListRsp groupSchoolTemplateListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolTemplateListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$129$lambda$128(final BaseService this$0, final String method, final int i3, final IPublishGroupSchoolTaskCallback it, final int i16, final String str, final PublishGroupSchoolTaskRsp publishGroupSchoolTaskRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dm
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$129$lambda$128$lambda$127(BaseService.this, method, i16, str, i3, it, publishGroupSchoolTaskRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$129$lambda$128$lambda$127(BaseService this$0, String method, int i3, String str, int i16, IPublishGroupSchoolTaskCallback it, PublishGroupSchoolTaskRsp publishGroupSchoolTaskRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, publishGroupSchoolTaskRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$132$lambda$131(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolTaskDetailCallback it, final int i16, final String str, final GroupSchoolTaskDetailRsp groupSchoolTaskDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.di
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$132$lambda$131$lambda$130(BaseService.this, method, i16, str, i3, it, groupSchoolTaskDetailRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$132$lambda$131$lambda$130(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolTaskDetailCallback it, GroupSchoolTaskDetailRsp groupSchoolTaskDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolTaskDetailRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$135$lambda$134(final BaseService this$0, final String method, final int i3, final ICheckInGroupSchoolTaskCallback it, final int i16, final String str, final CheckInGroupSchoolTaskRsp checkInGroupSchoolTaskRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gn
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$135$lambda$134$lambda$133(BaseService.this, method, i16, str, i3, it, checkInGroupSchoolTaskRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$135$lambda$134$lambda$133(BaseService this$0, String method, int i3, String str, int i16, ICheckInGroupSchoolTaskCallback it, CheckInGroupSchoolTaskRsp checkInGroupSchoolTaskRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, checkInGroupSchoolTaskRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$138$lambda$137(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolTaskListCallback it, final int i16, final String str, final GroupSchoolTaskListRsp groupSchoolTaskListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gf
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$138$lambda$137$lambda$136(BaseService.this, method, i16, str, i3, it, groupSchoolTaskListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$138$lambda$137$lambda$136(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolTaskListCallback it, GroupSchoolTaskListRsp groupSchoolTaskListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolTaskListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$141$lambda$140(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolTaskStatisticsCallback it, final int i16, final String str, final GroupSchoolTaskStatisticsRsp groupSchoolTaskStatisticsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.eu
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$141$lambda$140$lambda$139(BaseService.this, method, i16, str, i3, it, groupSchoolTaskStatisticsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$141$lambda$140$lambda$139(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolTaskStatisticsCallback it, GroupSchoolTaskStatisticsRsp groupSchoolTaskStatisticsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolTaskStatisticsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$144$lambda$143(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolTaskCheckInInfoCallback it, final int i16, final String str, final GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ga
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$144$lambda$143$lambda$142(BaseService.this, method, i16, str, i3, it, groupSchoolTaskCheckInInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$144$lambda$143$lambda$142(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolTaskCheckInInfoCallback it, GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolTaskCheckInInfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$147$lambda$146(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolTaskUnCheckInCallback it, final int i16, final String str, final GroupSchoolTaskUnCheckInRsp groupSchoolTaskUnCheckInRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bp
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$147$lambda$146$lambda$145(BaseService.this, method, i16, str, i3, it, groupSchoolTaskUnCheckInRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$147$lambda$146$lambda$145(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolTaskUnCheckInCallback it, GroupSchoolTaskUnCheckInRsp groupSchoolTaskUnCheckInRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolTaskUnCheckInRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$15$lambda$14(final BaseService this$0, final String method, final int i3, final ICanImportCallback it, final int i16, final String str, final int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cm
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$15$lambda$14$lambda$13(BaseService.this, method, i16, str, i3, it, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$15$lambda$14$lambda$13(BaseService this$0, String method, int i3, String str, int i16, ICanImportCallback it, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$150$lambda$149(final BaseService this$0, final String method, final int i3, final IGetAIGCEmojiListCallback it, final AIGCEmojiListInfo aIGCEmojiListInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bh
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$150$lambda$149$lambda$148(BaseService.this, method, aIGCEmojiListInfo, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$150$lambda$149$lambda$148(BaseService this$0, String method, AIGCEmojiListInfo aIGCEmojiListInfo, int i3, IGetAIGCEmojiListCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", aIGCEmojiListInfo)}, Integer.valueOf(i3));
        it.onGetAIGCEmojiList(aIGCEmojiListInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$153$lambda$152(final BaseService this$0, final String method, final int i3, final ICheckImageCallback it, final CheckImageResult checkImageResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cp
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$153$lambda$152$lambda$151(BaseService.this, method, checkImageResult, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$153$lambda$152$lambda$151(BaseService this$0, String method, CheckImageResult checkImageResult, int i3, ICheckImageCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", checkImageResult)}, Integer.valueOf(i3));
        it.onCheckImage(checkImageResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$156$lambda$155(final BaseService this$0, final String method, final int i3, final IKernelBdhUploadCompleteCallback it, final int i16, final String str, final BdhUploadRsp bdhUploadRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bb
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$156$lambda$155$lambda$154(BaseService.this, method, i16, str, i3, it, bdhUploadRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$156$lambda$155$lambda$154(BaseService this$0, String method, int i3, String str, int i16, IKernelBdhUploadCompleteCallback it, BdhUploadRsp bdhUploadRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, bdhUploadRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$159$lambda$158(final BaseService this$0, final String method, final int i3, final ISetGroupRelationToGuildCallback it, final int i16, final String str, final SetGroupRelationToGuildRsp setGroupRelationToGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.y
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$159$lambda$158$lambda$157(BaseService.this, method, i16, str, i3, it, setGroupRelationToGuildRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$159$lambda$158$lambda$157(BaseService this$0, String method, int i3, String str, int i16, ISetGroupRelationToGuildCallback it, SetGroupRelationToGuildRsp setGroupRelationToGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, setGroupRelationToGuildRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$162$lambda$161(final BaseService this$0, final String method, final int i3, final IGetGroupBindGuildsCallback it, final int i16, final String str, final GetGroupBindGuildsRsp getGroupBindGuildsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dj
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$162$lambda$161$lambda$160(BaseService.this, method, i16, str, i3, it, getGroupBindGuildsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$162$lambda$161$lambda$160(BaseService this$0, String method, int i3, String str, int i16, IGetGroupBindGuildsCallback it, GetGroupBindGuildsRsp getGroupBindGuildsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupBindGuildsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$165$lambda$164(final BaseService this$0, final String method, final int i3, final ISetAIOBindGuildCallback it, final int i16, final String str, final SetAIOBindGuildRsp setAIOBindGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bt
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$165$lambda$164$lambda$163(BaseService.this, method, i16, str, i3, it, setAIOBindGuildRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$165$lambda$164$lambda$163(BaseService this$0, String method, int i3, String str, int i16, ISetAIOBindGuildCallback it, SetAIOBindGuildRsp setAIOBindGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, setAIOBindGuildRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$168$lambda$167(final BaseService this$0, final String method, final int i3, final IQueryAIOBindGuildCallback it, final int i16, final String str, final QueryAIOBindGuildRsp queryAIOBindGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dg
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$168$lambda$167$lambda$166(BaseService.this, method, i16, str, i3, it, queryAIOBindGuildRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$168$lambda$167$lambda$166(BaseService this$0, String method, int i3, String str, int i16, IQueryAIOBindGuildCallback it, QueryAIOBindGuildRsp queryAIOBindGuildRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, queryAIOBindGuildRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$171$lambda$170(final BaseService this$0, final String method, final int i3, final IGetAIOBindGuildInfoCallback it, final int i16, final String str, final GetAIOBindGuildInfoRsp getAIOBindGuildInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ag
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$171$lambda$170$lambda$169(BaseService.this, method, i16, str, i3, it, getAIOBindGuildInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$171$lambda$170$lambda$169(BaseService this$0, String method, int i3, String str, int i16, IGetAIOBindGuildInfoCallback it, GetAIOBindGuildInfoRsp getAIOBindGuildInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getAIOBindGuildInfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$174$lambda$173(final BaseService this$0, final String method, final int i3, final IUnbindAllGuildsCallback it, final int i16, final String str, final UnbindAllGuildsRsp unbindAllGuildsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.aw
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$174$lambda$173$lambda$172(BaseService.this, method, i16, str, i3, it, unbindAllGuildsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$174$lambda$173$lambda$172(BaseService this$0, String method, int i3, String str, int i16, IUnbindAllGuildsCallback it, UnbindAllGuildsRsp unbindAllGuildsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, unbindAllGuildsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$177$lambda$176(final BaseService this$0, final String method, final int i3, final IGroupMemberIllegalInfoCallback it, final int i16, final String str, final GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fe
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$177$lambda$176$lambda$175(BaseService.this, method, i16, str, i3, it, groupMemberIllegalInfoResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$177$lambda$176$lambda$175(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberIllegalInfoCallback it, GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMemberIllegalInfoResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$18$lambda$17(final BaseService this$0, final String method, final int i3, final IDataImportTableNamesCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.co
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$18$lambda$17$lambda$16(BaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$18$lambda$17$lambda$16(BaseService this$0, String method, int i3, String str, int i16, IDataImportTableNamesCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$180$lambda$179(final BaseService this$0, final String func, final int i3, final IKickMemberOperateCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(func, "$func");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fd
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$180$lambda$179$lambda$178(BaseService.this, func, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$180$lambda$179$lambda$178(BaseService this$0, String func, int i3, String str, int i16, IKickMemberOperateCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(func, "$func");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", func), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$183$lambda$182(final BaseService this$0, final String method, final int i3, final IKickMemberCallback it, final int i16, final String str, final KickMemberV2Result kickMemberV2Result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.eo
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$183$lambda$182$lambda$181(BaseService.this, method, i16, str, i3, it, kickMemberV2Result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$183$lambda$182$lambda$181(BaseService this$0, String method, int i3, String str, int i16, IKickMemberCallback it, KickMemberV2Result kickMemberV2Result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, kickMemberV2Result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$186$lambda$185(final BaseService this$0, final String method, final int i3, final IJoinGroupCallback it, final int i16, final String str, final JoinGroupNotifyMsg joinGroupNotifyMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ak
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$186$lambda$185$lambda$184(BaseService.this, method, i16, str, i3, it, joinGroupNotifyMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$186$lambda$185$lambda$184(BaseService this$0, String method, int i3, String str, int i16, IJoinGroupCallback it, JoinGroupNotifyMsg joinGroupNotifyMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, joinGroupNotifyMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$189$lambda$188(final BaseService this$0, final String method, final int i3, final IGroupDetailInfoCallback it, final int i16, final String str, final GroupDetailInfo groupDetailInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ei
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$189$lambda$188$lambda$187(BaseService.this, method, i16, str, i3, it, groupDetailInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$189$lambda$188$lambda$187(BaseService this$0, String method, int i3, String str, int i16, IGroupDetailInfoCallback it, GroupDetailInfo groupDetailInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupDetailInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$192$lambda$191(final BaseService this$0, final String method, final int i3, final ITransferGroupCallback it, final int i16, final String str, final TransferGroupRsp transferGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fq
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$192$lambda$191$lambda$190(BaseService.this, method, i16, str, i3, it, transferGroupRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$192$lambda$191$lambda$190(BaseService this$0, String method, int i3, String str, int i16, ITransferGroupCallback it, TransferGroupRsp transferGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, transferGroupRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$195$lambda$194(final BaseService this$0, final String method, final int i3, final IInviteToGroupCallback it, final int i16, final String str, final InviteToGroupRsp inviteToGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fi
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$195$lambda$194$lambda$193(BaseService.this, method, i16, str, i3, it, inviteToGroupRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$195$lambda$194$lambda$193(BaseService this$0, String method, int i3, String str, int i16, IInviteToGroupCallback it, InviteToGroupRsp inviteToGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, inviteToGroupRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$198$lambda$197(final BaseService this$0, final String method, final int i3, final ISetGroupMsgMaskCallback it, final int i16, final String str, final SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bi
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$198$lambda$197$lambda$196(BaseService.this, method, i16, str, i3, it, setGroupMsgMaskRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$198$lambda$197$lambda$196(BaseService this$0, String method, int i3, String str, int i16, ISetGroupMsgMaskCallback it, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, setGroupMsgMaskRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$201$lambda$200(final BaseService this$0, final String method, final int i3, final IJoinGroupVerifyCallback it, final int i16, final String str, final JoinGroupVerifyRsp joinGroupVerifyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gg
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$201$lambda$200$lambda$199(BaseService.this, method, i16, str, i3, it, joinGroupVerifyRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$201$lambda$200$lambda$199(BaseService this$0, String method, int i3, String str, int i16, IJoinGroupVerifyCallback it, JoinGroupVerifyRsp joinGroupVerifyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, joinGroupVerifyRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$204$lambda$203(final BaseService this$0, final String method, final int i3, final IRcvJoinVerifyMsgCallback it, final int i16, final String str, final RcvJoinVerifyMsgRsp rcvJoinVerifyMsgRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dt
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$204$lambda$203$lambda$202(BaseService.this, method, i16, str, i3, it, rcvJoinVerifyMsgRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$204$lambda$203$lambda$202(BaseService this$0, String method, int i3, String str, int i16, IRcvJoinVerifyMsgCallback it, RcvJoinVerifyMsgRsp rcvJoinVerifyMsgRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, rcvJoinVerifyMsgRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$207$lambda$206(final BaseService this$0, final String method, final int i3, final IGroupPrivilegeFlagCallback it, final int i16, final String str, final GroupPrivilegeFlagRsp groupPrivilegeFlagRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dx
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$207$lambda$206$lambda$205(BaseService.this, method, i16, str, i3, it, groupPrivilegeFlagRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$207$lambda$206$lambda$205(BaseService this$0, String method, int i3, String str, int i16, IGroupPrivilegeFlagCallback it, GroupPrivilegeFlagRsp groupPrivilegeFlagRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupPrivilegeFlagRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$21$lambda$20(final BaseService this$0, final String method, final int i3, final IAddJsonGrayTipMsgCallback it, final int i16, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ew
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$21$lambda$20$lambda$19(BaseService.this, method, i16, j3, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$21$lambda$20$lambda$19(BaseService this$0, String method, int i3, long j3, int i16, IAddJsonGrayTipMsgCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("msgId", Long.valueOf(j3))}, Integer.valueOf(i16));
        it.onResult(i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$210$lambda$209(final BaseService this$0, final String method, final int i3, final IGroupEssenceMsgSwitchCallback it, final int i16, final String str, final GroupEssenceMsgSwitchRsp groupEssenceMsgSwitchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.aq
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$210$lambda$209$lambda$208(BaseService.this, method, i16, str, i3, it, groupEssenceMsgSwitchRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$210$lambda$209$lambda$208(BaseService this$0, String method, int i3, String str, int i16, IGroupEssenceMsgSwitchCallback it, GroupEssenceMsgSwitchRsp groupEssenceMsgSwitchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupEssenceMsgSwitchRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$213$lambda$212(final BaseService this$0, final String method, final int i3, final IGroupMemberMaxNumCallback it, final int i16, final String str, final GroupMemberMaxNumRsp groupMemberMaxNumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.az
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$213$lambda$212$lambda$211(BaseService.this, method, i16, str, i3, it, groupMemberMaxNumRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$213$lambda$212$lambda$211(BaseService this$0, String method, int i3, String str, int i16, IGroupMemberMaxNumCallback it, GroupMemberMaxNumRsp groupMemberMaxNumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMemberMaxNumRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$216$lambda$215(final BaseService this$0, final String method, final int i3, final IGroupSecLevelInfoCallback it, final int i16, final String str, final GroupSecLevelInfoRsp groupSecLevelInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dv
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$216$lambda$215$lambda$214(BaseService.this, method, i16, str, i3, it, groupSecLevelInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$216$lambda$215$lambda$214(BaseService this$0, String method, int i3, String str, int i16, IGroupSecLevelInfoCallback it, GroupSecLevelInfoRsp groupSecLevelInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSecLevelInfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$219$lambda$218(final BaseService this$0, final String method, final int i3, final IGroupAvatarWallCallback it, final int i16, final String str, final GroupAvatarWallRsp groupAvatarWallRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dh
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$219$lambda$218$lambda$217(BaseService.this, method, i16, str, i3, it, groupAvatarWallRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$219$lambda$218$lambda$217(BaseService this$0, String method, int i3, String str, int i16, IGroupAvatarWallCallback it, GroupAvatarWallRsp groupAvatarWallRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupAvatarWallRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$222$lambda$221(final BaseService this$0, final String method, final int i3, final IGroupInfoForGrayTipsCallback it, final int i16, final String str, final GroupInfoForGrayTipsRsp groupInfoForGrayTipsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dy
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$222$lambda$221$lambda$220(BaseService.this, method, i16, str, i3, it, groupInfoForGrayTipsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$222$lambda$221$lambda$220(BaseService this$0, String method, int i3, String str, int i16, IGroupInfoForGrayTipsCallback it, GroupInfoForGrayTipsRsp groupInfoForGrayTipsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupInfoForGrayTipsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$225$lambda$224(final BaseService this$0, final String method, final int i3, final IGroupInfoForJoinCallback it, final int i16, final String str, final GroupInfoForJoinRsp groupInfoForJoinRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ax
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$225$lambda$224$lambda$223(BaseService.this, method, i16, str, i3, it, groupInfoForJoinRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$225$lambda$224$lambda$223(BaseService this$0, String method, int i3, String str, int i16, IGroupInfoForJoinCallback it, GroupInfoForJoinRsp groupInfoForJoinRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupInfoForJoinRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$228$lambda$227(final BaseService this$0, final String method, final int i3, final IGroupPayToJoinStatusCallback it, final int i16, final String str, final GroupPayToJoinStatusRsp groupPayToJoinStatusRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cl
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$228$lambda$227$lambda$226(BaseService.this, method, i16, str, i3, it, groupPayToJoinStatusRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$228$lambda$227$lambda$226(BaseService this$0, String method, int i3, String str, int i16, IGroupPayToJoinStatusCallback it, GroupPayToJoinStatusRsp groupPayToJoinStatusRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupPayToJoinStatusRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$231$lambda$230(final BaseService this$0, final String method, final int i3, final IGroupMsgLimitFreqCallback it, final int i16, final String str, final GroupMsgLimitFreqRsp groupMsgLimitFreqRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fx
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$231$lambda$230$lambda$229(BaseService.this, method, i16, str, i3, it, groupMsgLimitFreqRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$231$lambda$230$lambda$229(BaseService this$0, String method, int i3, String str, int i16, IGroupMsgLimitFreqCallback it, GroupMsgLimitFreqRsp groupMsgLimitFreqRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupMsgLimitFreqRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$234$lambda$233(final BaseService this$0, final String method, final int i3, final IGroupTagRecordCallback it, final int i16, final String str, final GroupTagRecordRsp groupTagRecordRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fr
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$234$lambda$233$lambda$232(BaseService.this, method, i16, str, i3, it, groupTagRecordRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$234$lambda$233$lambda$232(BaseService this$0, String method, int i3, String str, int i16, IGroupTagRecordCallback it, GroupTagRecordRsp groupTagRecordRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupTagRecordRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$237$lambda$236(final BaseService this$0, final String method, final int i3, final IGetGroupFlagForThirdAppCallback it, final int i16, final String str, final GetGroupFlagForThirdAppRsp getGroupFlagForThirdAppRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bz
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$237$lambda$236$lambda$235(BaseService.this, method, i16, str, i3, it, getGroupFlagForThirdAppRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$237$lambda$236$lambda$235(BaseService this$0, String method, int i3, String str, int i16, IGetGroupFlagForThirdAppCallback it, GetGroupFlagForThirdAppRsp getGroupFlagForThirdAppRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupFlagForThirdAppRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$24$lambda$23(final BaseService this$0, final String method, final int i3, final ICreateGroupOperateCallback it, final int i16, final String str, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bu
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$24$lambda$23$lambda$22(BaseService.this, method, i16, str, i3, it, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$24$lambda$23$lambda$22(BaseService this$0, String method, int i3, String str, int i16, ICreateGroupOperateCallback it, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$240$lambda$239(final BaseService this$0, final String method, final int i3, final IGetGroupInviteNoAuthLimitNumCallback it, final int i16, final String str, final GetGroupInviteNoAuthLimitRsp getGroupInviteNoAuthLimitRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gc
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$240$lambda$239$lambda$238(BaseService.this, method, i16, str, i3, it, getGroupInviteNoAuthLimitRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$240$lambda$239$lambda$238(BaseService this$0, String method, int i3, String str, int i16, IGetGroupInviteNoAuthLimitNumCallback it, GetGroupInviteNoAuthLimitRsp getGroupInviteNoAuthLimitRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupInviteNoAuthLimitRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$243$lambda$242(final BaseService this$0, final String method, final int i3, final IModifyGroupExtCallback it, final int i16, final String str, final ModifyGroupExtResult modifyGroupExtResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.am
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$243$lambda$242$lambda$241(BaseService.this, method, i16, str, i3, it, modifyGroupExtResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$243$lambda$242$lambda$241(BaseService this$0, String method, int i3, String str, int i16, IModifyGroupExtCallback it, ModifyGroupExtResult modifyGroupExtResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, modifyGroupExtResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$246$lambda$245(final BaseService this$0, final String method, final int i3, final IGetGroupLatestEssenceListCallback it, final int i16, final String str, final GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gh
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$246$lambda$245$lambda$244(BaseService.this, method, i16, str, i3, it, getGroupLatestEssenceListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$246$lambda$245$lambda$244(BaseService this$0, String method, int i3, String str, int i16, IGetGroupLatestEssenceListCallback it, GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupLatestEssenceListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$249$lambda$248(final BaseService this$0, final String method, final int i3, final IDigestCallback it, final int i16, final String str, final DigestRsp digestRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cn
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$249$lambda$248$lambda$247(BaseService.this, method, i16, str, i3, it, digestRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$249$lambda$248$lambda$247(BaseService this$0, String method, int i3, String str, int i16, IDigestCallback it, DigestRsp digestRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, digestRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$252$lambda$251(final BaseService this$0, final String method, final int i3, final ICheckEssenceCallback it, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bs
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$252$lambda$251$lambda$250(BaseService.this, method, z16, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$252$lambda$251$lambda$250(BaseService this$0, String method, boolean z16, int i3, ICheckEssenceCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Boolean.valueOf(z16))}, Integer.valueOf(i3));
        it.onResult(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$255$lambda$254(final BaseService this$0, final String method, final int i3, final IQueryCachedEssenceCallback it, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$255$lambda$254$lambda$253(BaseService.this, method, arrayList, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$255$lambda$254$lambda$253(BaseService this$0, String method, ArrayList arrayList, int i3, IQueryCachedEssenceCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(arrayList.size()))}, Integer.valueOf(i3));
        it.onResult(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$258$lambda$257(final BaseService this$0, final String method, final int i3, final IGroupExt0xEF0InfoCallback it, final int i16, final String str, final GroupExt0xEF0InfoRsp groupExt0xEF0InfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.eb
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$258$lambda$257$lambda$256(BaseService.this, method, groupExt0xEF0InfoRsp, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$258$lambda$257$lambda$256(BaseService this$0, String method, GroupExt0xEF0InfoRsp groupExt0xEF0InfoRsp, int i3, String str, int i16, IGroupExt0xEF0InfoCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", groupExt0xEF0InfoRsp), TuplesKt.to("errCode", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupExt0xEF0InfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$261$lambda$260(final BaseService this$0, final String method, final int i3, final IBatchQueryCachedGroupDetailInfoCallback it, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ed
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$261$lambda$260$lambda$259(BaseService.this, method, arrayList, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$261$lambda$260$lambda$259(BaseService this$0, String method, ArrayList arrayList, int i3, IBatchQueryCachedGroupDetailInfoCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", arrayList)}, Integer.valueOf(i3));
        it.onResult(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$264$lambda$263(final BaseService this$0, final String method, final int i3, final IGetHomeHeadCallback it, final int i16, final String str, final GetHomeHeadRsp getHomeHeadRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fg
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$264$lambda$263$lambda$262(BaseService.this, method, i16, str, i3, it, getHomeHeadRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$264$lambda$263$lambda$262(BaseService this$0, String method, int i3, String str, int i16, IGetHomeHeadCallback it, GetHomeHeadRsp getHomeHeadRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getHomeHeadRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$267$lambda$266(final BaseService this$0, final String method, final int i3, final IGetGroupSquareRedpointInfoCallback it, final int i16, final String str, final GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fu
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$267$lambda$266$lambda$265(BaseService.this, method, i16, str, i3, it, getGroupSquareRedpointInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$267$lambda$266$lambda$265(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSquareRedpointInfoCallback it, GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupSquareRedpointInfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$27$lambda$26(final BaseService this$0, final String method, final int i3, final ICreateGroupCallback it, final int i16, final String str, final CreateGroupResult createGroupResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dp
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$27$lambda$26$lambda$25(BaseService.this, method, i16, str, i3, it, createGroupResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$27$lambda$26$lambda$25(BaseService this$0, String method, int i3, String str, int i16, ICreateGroupCallback it, CreateGroupResult createGroupResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, createGroupResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$270$lambda$269(final BaseService this$0, final String method, final int i3, final IGetRecGroupsCallback it, final int i16, final String str, final GetRecGroupsRsp getRecGroupsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ge
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$270$lambda$269$lambda$268(BaseService.this, method, i16, str, i3, it, getRecGroupsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$270$lambda$269$lambda$268(BaseService this$0, String method, int i3, String str, int i16, IGetRecGroupsCallback it, GetRecGroupsRsp getRecGroupsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getRecGroupsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$273$lambda$272(final BaseService this$0, final String method, final int i3, final IGetTopicPageCallback it, final int i16, final String str, final GetTopicPageRsp getTopicPageRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bx
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$273$lambda$272$lambda$271(BaseService.this, method, i16, str, i3, it, getTopicPageRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$273$lambda$272$lambda$271(BaseService this$0, String method, int i3, String str, int i16, IGetTopicPageCallback it, GetTopicPageRsp getTopicPageRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getTopicPageRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$276$lambda$275(final BaseService this$0, final String method, final int i3, final ICheckIsBuddyCallback it, final String str, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ai
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$276$lambda$275$lambda$274(BaseService.this, method, z16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$276$lambda$275$lambda$274(BaseService this$0, String method, boolean z16, String str, int i3, ICheckIsBuddyCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Boolean.valueOf(z16)), TuplesKt.to("uid", str)}, Integer.valueOf(i3));
        it.onResult(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$279$lambda$278(final BaseService this$0, final String method, final int i3, final IModifyCategoryCallback it, final int i16, final String str, final byte[] bArr, final String str2, final int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dn
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$279$lambda$278$lambda$277(BaseService.this, method, i16, str, bArr, str2, i17, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$279$lambda$278$lambda$277(BaseService this$0, String method, int i3, String str, byte[] bArr, String str2, int i16, int i17, IModifyCategoryCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str), TuplesKt.to("context", bArr), TuplesKt.to("name", str2), TuplesKt.to("groupId", Integer.valueOf(i16))}, Integer.valueOf(i17));
        it.onResult(i3, str, bArr, str2, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$282$lambda$281(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolToolboxInfoCallback it, final int i16, final String str, final GroupSchoolToolboxInfoRsp groupSchoolToolboxInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ff
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$282$lambda$281$lambda$280(BaseService.this, method, i16, str, i3, it, groupSchoolToolboxInfoRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$282$lambda$281$lambda$280(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolToolboxInfoCallback it, GroupSchoolToolboxInfoRsp groupSchoolToolboxInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolToolboxInfoRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$36$lambda$35(final BaseService this$0, final String method, final int i3, final IKernelScanEndCallback it, final int i16, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.af
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$36$lambda$35$lambda$34(BaseService.this, method, i16, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$36$lambda$35$lambda$34(BaseService this$0, String method, int i3, int i16, IKernelScanEndCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3))}, Integer.valueOf(i16));
        it.onResult(i3, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$39$lambda$38(final BaseService this$0, final String method, final int i3, final IGetRobotFunctionsCallback it, final int i16, final String str, final BatchBotGetResponse batchBotGetResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cj
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$39$lambda$38$lambda$37(BaseService.this, method, i16, str, i3, it, batchBotGetResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$39$lambda$38$lambda$37(BaseService this$0, String method, int i3, String str, int i16, IGetRobotFunctionsCallback it, BatchBotGetResponse batchBotGetResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, batchBotGetResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$42$lambda$41(final BaseService this$0, final String method, final int i3, final IFetchRobotCoreInfosCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bq
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$42$lambda$41$lambda$40(BaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$42$lambda$41$lambda$40(BaseService this$0, String method, int i3, String str, int i16, IFetchRobotCoreInfosCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$45$lambda$44(final BaseService this$0, final String method, final int i3, final IGetGroupRobotProfileCallback it, final int i16, final String str, final GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bo
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$45$lambda$44$lambda$43(BaseService.this, method, i16, str, i3, it, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$45$lambda$44$lambda$43(BaseService this$0, String method, int i3, String str, int i16, IGetGroupRobotProfileCallback it, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupRobotProfile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$48$lambda$47(final BaseService this$0, final String method, final int i3, final ISetRobotMessagePushCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ex
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$48$lambda$47$lambda$46(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$48$lambda$47$lambda$46(BaseService this$0, String method, int i3, String str, int i16, ISetRobotMessagePushCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$51$lambda$50(final BaseService this$0, final String method, final int i3, final IAddFriendCallback it, final int i16, final String str, final RobotAddFriendResponse robotAddFriendResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.z
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$51$lambda$50$lambda$49(BaseService.this, method, i16, str, i3, it, robotAddFriendResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$51$lambda$50$lambda$49(BaseService this$0, String method, int i3, String str, int i16, IAddFriendCallback it, RobotAddFriendResponse robotAddFriendResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, robotAddFriendResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$54$lambda$53(final BaseService this$0, final String method, final int i3, final IRemoveFriendCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.au
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$54$lambda$53$lambda$52(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$54$lambda$53$lambda$52(BaseService this$0, String method, int i3, String str, int i16, IRemoveFriendCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$57$lambda$56(final BaseService this$0, final String method, final int i3, final IRobotAuthCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.s
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$57$lambda$56$lambda$55(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$57$lambda$56$lambda$55(BaseService this$0, String method, int i3, String str, int i16, IRobotAuthCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$6$lambda$5(final BaseService this$0, final String method, final int i3, final IGetMsgsBoxesCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fo
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$6$lambda$5$lambda$4(BaseService.this, method, i16, str, i3, it, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$6$lambda$5$lambda$4(BaseService this$0, String method, int i3, String str, int i16, IGetMsgsBoxesCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onMsgBoxesInfo(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$60$lambda$59(final BaseService this$0, final String method, final int i3, final ISetAddRobotToGroupCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fs
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$60$lambda$59$lambda$58(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$60$lambda$59$lambda$58(BaseService this$0, String method, int i3, String str, int i16, ISetAddRobotToGroupCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$63$lambda$62(final BaseService this$0, final String method, final int i3, final ISetRemoveRobotFromGroupCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bl
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$63$lambda$62$lambda$61(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$63$lambda$62$lambda$61(BaseService this$0, String method, int i3, String str, int i16, ISetRemoveRobotFromGroupCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$66$lambda$65(final BaseService this$0, final String method, final int i3, final IGetAddRobotGroupListCallback it, final int i16, final String str, final QueryAddRobotGroupListRsp queryAddRobotGroupListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bj
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$66$lambda$65$lambda$64(BaseService.this, method, i16, str, i3, it, queryAddRobotGroupListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$66$lambda$65$lambda$64(BaseService this$0, String method, int i3, String str, int i16, IGetAddRobotGroupListCallback it, QueryAddRobotGroupListRsp queryAddRobotGroupListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, queryAddRobotGroupListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$69$lambda$68(final BaseService this$0, final String method, final int i3, final IRobotShareLimitCallBack it, final int i16, final String str, final RobotShareLimitRsp robotShareLimitRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ev
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$69$lambda$68$lambda$67(BaseService.this, method, i16, str, i3, it, robotShareLimitRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$69$lambda$68$lambda$67(BaseService this$0, String method, int i3, String str, int i16, IRobotShareLimitCallBack it, RobotShareLimitRsp robotShareLimitRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, robotShareLimitRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$72$lambda$71(final BaseService this$0, final String method, final int i3, final ISendCommonRobotCallBack it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ay
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$72$lambda$71$lambda$70(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$72$lambda$71$lambda$70(BaseService this$0, String method, int i3, String str, int i16, ISendCommonRobotCallBack it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$75$lambda$74(final BaseService this$0, final String method, final int i3, final IGroupRobotStoreDiscoveryCallback it, final int i16, final String str, final GroupRobotStoreDiscoveryRsp groupRobotStoreDiscoveryRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.t
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$75$lambda$74$lambda$73(BaseService.this, method, i16, str, i3, it, groupRobotStoreDiscoveryRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$75$lambda$74$lambda$73(BaseService this$0, String method, int i3, String str, int i16, IGroupRobotStoreDiscoveryCallback it, GroupRobotStoreDiscoveryRsp groupRobotStoreDiscoveryRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupRobotStoreDiscoveryRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$78$lambda$77(final BaseService this$0, final String method, final int i3, final IRobotStoreSearchCallback it, final int i16, final String str, final GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bv
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$78$lambda$77$lambda$76(BaseService.this, method, i16, str, i3, it, groupRobotStoreSearchRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$78$lambda$77$lambda$76(BaseService this$0, String method, int i3, String str, int i16, IRobotStoreSearchCallback it, GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupRobotStoreSearchRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$81$lambda$80(final BaseService this$0, final String method, final int i3, final IBuddyListCallback it, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ar
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$81$lambda$80$lambda$79(BaseService.this, method, i16, str, i3, it, arrayList);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$81$lambda$80$lambda$79(BaseService this$0, String method, int i3, String str, int i16, IBuddyListCallback it, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$84$lambda$83(final BaseService this$0, final String method, final int i3, final IRobotStoreCategoryListCallback it, final int i16, final String str, final GroupRobotStoreCategoryListRsp groupRobotStoreCategoryListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.df
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$84$lambda$83$lambda$82(BaseService.this, method, i16, str, i3, it, groupRobotStoreCategoryListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$84$lambda$83$lambda$82(BaseService this$0, String method, int i3, String str, int i16, IRobotStoreCategoryListCallback it, GroupRobotStoreCategoryListRsp groupRobotStoreCategoryListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupRobotStoreCategoryListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$87$lambda$86(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolNoticeListCallback it, final int i16, final String str, final GetGroupSchoolNoticeListRsp getGroupSchoolNoticeListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fc
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$87$lambda$86$lambda$85(BaseService.this, method, i16, str, i3, it, getGroupSchoolNoticeListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$87$lambda$86$lambda$85(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolNoticeListCallback it, GetGroupSchoolNoticeListRsp getGroupSchoolNoticeListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupSchoolNoticeListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$9$lambda$8(final BaseService this$0, final String method, final int i3, final IOperateCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.dr
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$9$lambda$8$lambda$7(BaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$9$lambda$8$lambda$7(BaseService this$0, String method, int i3, String str, int i16, IOperateCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$90$lambda$89(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolNoticeDetailCallback it, final int i16, final String str, final GetGroupSchoolNoticeDetailRsp getGroupSchoolNoticeDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.x
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$90$lambda$89$lambda$88(BaseService.this, method, i16, str, i3, it, getGroupSchoolNoticeDetailRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$90$lambda$89$lambda$88(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolNoticeDetailCallback it, GetGroupSchoolNoticeDetailRsp getGroupSchoolNoticeDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, getGroupSchoolNoticeDetailRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$93$lambda$92(final BaseService this$0, final String method, final int i3, final IPublishGroupSchoolNoticeCallback it, final int i16, final String str, final PublishGroupSchoolNoticeRsp publishGroupSchoolNoticeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fw
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$93$lambda$92$lambda$91(BaseService.this, method, i16, str, i3, it, publishGroupSchoolNoticeRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$93$lambda$92$lambda$91(BaseService this$0, String method, int i3, String str, int i16, IPublishGroupSchoolNoticeCallback it, PublishGroupSchoolNoticeRsp publishGroupSchoolNoticeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, publishGroupSchoolNoticeRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$96$lambda$95(final BaseService this$0, final String method, final int i3, final IConfirmGroupSchoolNoticeCallback it, final int i16, final String str, final ConfirmGroupSchoolNoticeRsp confirmGroupSchoolNoticeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.eq
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$96$lambda$95$lambda$94(BaseService.this, method, i16, str, i3, it, confirmGroupSchoolNoticeRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$96$lambda$95$lambda$94(BaseService this$0, String method, int i3, String str, int i16, IConfirmGroupSchoolNoticeCallback it, ConfirmGroupSchoolNoticeRsp confirmGroupSchoolNoticeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, confirmGroupSchoolNoticeRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$99$lambda$98(final BaseService this$0, final String method, final int i3, final IGetGroupSchoolNoticeStatisticCallback it, final int i16, final String str, final GroupSchoolNoticeStatisticsRsp groupSchoolNoticeStatisticsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.cs
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getCallback$lambda$99$lambda$98$lambda$97(BaseService.this, method, i16, str, i3, it, groupSchoolNoticeStatisticsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCallback$lambda$99$lambda$98$lambda$97(BaseService this$0, String method, int i3, String str, int i16, IGetGroupSchoolNoticeStatisticCallback it, GroupSchoolNoticeStatisticsRsp groupSchoolNoticeStatisticsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, groupSchoolNoticeStatisticsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGuildBinaryDataCallback getGuildBinaryDataCallback(final String method, final int curSeq, final IGetGuildBinaryDataCallback cb5) {
        if (cb5 != null) {
            return new IGetGuildBinaryDataCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ci
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    BaseService.getGuildBinaryDataCallback$lambda$30$lambda$29(BaseService.this, method, curSeq, cb5, i3, str, hashMap);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGuildBinaryDataCallback$lambda$30$lambda$29(final BaseService this$0, final String method, final int i3, final IGetGuildBinaryDataCallback it, final int i16, final String str, final HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fk
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getGuildBinaryDataCallback$lambda$30$lambda$29$lambda$28(BaseService.this, method, i16, str, i3, it, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGuildBinaryDataCallback$lambda$30$lambda$29$lambda$28(BaseService this$0, String method, int i3, String str, int i16, IGetGuildBinaryDataCallback it, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetTempChatInfoCallback getTempChatInfoCallback(final String method, final int curSeq, final IGetTempChatInfoCallback cb5) {
        if (cb5 != null) {
            return new IGetTempChatInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bg
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                    BaseService.getTempChatInfoCallback$lambda$33$lambda$32(BaseService.this, method, curSeq, cb5, i3, str, tempChatInfo);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTempChatInfoCallback$lambda$33$lambda$32(final BaseService this$0, final String method, final int i3, final IGetTempChatInfoCallback it, final int i16, final String str, final TempChatInfo tempChatInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fz
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.getTempChatInfoCallback$lambda$33$lambda$32$lambda$31(BaseService.this, method, i16, str, i3, it, tempChatInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTempChatInfoCallback$lambda$33$lambda$32$lambda$31(BaseService this$0, String method, int i3, String str, int i16, IGetTempChatInfoCallback it, TempChatInfo tempChatInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f359087a.d(this$0.subTag, new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, tempChatInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postHandle$lambda$1(Runnable r16) {
        Intrinsics.checkNotNullParameter(r16, "$r");
        r16.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postHandleWithLoginCheck$lambda$3(BaseService this$0, Runnable r16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(r16, "$r");
        AppRuntime c16 = this$0.content.c();
        if (c16 != null && c16.isLogin()) {
            r16.run();
        }
    }

    public static /* synthetic */ void removeListener$default(BaseService baseService, Object obj, boolean z16, Function1 function1, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            baseService.removeListener(obj, z16, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeListener");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addListener(final L listener, @NotNull final Function1<? super L, Long> add) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener, (Object) add);
            return;
        }
        Intrinsics.checkNotNullParameter(add, "add");
        if (!this.listenersMap.containsKey(listener) && (l3 = (Long) check("addListener", new Function0<Long>(add, listener) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$addListener$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<L, Long> $add;
            final /* synthetic */ L $listener;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.$add = add;
                this.$listener = listener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) add, (Object) listener);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Long invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.$add.invoke(this.$listener) : (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        })) != null) {
            this.listenersMap.put(listener, Long.valueOf(l3.longValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull String method, @NotNull final Function0<? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (T) iPatchRedirector.redirect((short) 12, (Object) this, (Object) method, (Object) work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().a(this.subTag, method, new Function0<T>(work) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<T> $work;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.$work = work;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) work);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return this.$work.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkCommon(@NotNull String method, @NotNull final Function0<Unit> suc, @NotNull Function0<Unit> fail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, this, method, suc, fail);
            return;
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(suc, "suc");
        Intrinsics.checkNotNullParameter(fail, "fail");
        this.content.e().g1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, Unit>(suc) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$checkCommon$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<Unit> $suc;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$suc = suc;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) suc);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    this.$suc.invoke();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
            }
        }, fail);
    }

    @Override // com.tencent.qqnt.kernel.utils.c
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this);
            return;
        }
        QLog.i("BaseService", 1, this + " destroy");
        com.tencent.qqnt.kernel.utils.i iVar = com.tencent.qqnt.kernel.utils.i.f359265b;
        iVar.b(this.service);
        if (iVar.c()) {
            this.service = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final py getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (py) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.content;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<L, Long> getListenersMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.listenersMap;
    }

    @Nullable
    public final S getService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (S) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.service;
    }

    @NotNull
    public final String getSubTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.subTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void postHandle(@NotNull final Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) r16);
            return;
        }
        Intrinsics.checkNotNullParameter(r16, "r");
        System.currentTimeMillis();
        com.tencent.qqnt.kernel.utils.i.f359265b.a().post(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.bf
            @Override // java.lang.Runnable
            public final void run() {
                BaseService.postHandle$lambda$1(r16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void postHandleWithLoginCheck(@NotNull final Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) r16);
        } else {
            Intrinsics.checkNotNullParameter(r16, "r");
            com.tencent.qqnt.kernel.utils.i.f359265b.a().post(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.fa
                @Override // java.lang.Runnable
                public final void run() {
                    BaseService.postHandleWithLoginCheck$lambda$3(BaseService.this, r16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void removeListener(final L listener, boolean needCheck, @NotNull final Function1<? super Long, Unit> remove) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, listener, Boolean.valueOf(needCheck), remove);
            return;
        }
        Intrinsics.checkNotNullParameter(remove, "remove");
        Function0<Long> function0 = new Function0<Long>(this, listener, remove) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$removeListener$block$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ L $listener;
            final /* synthetic */ Function1<Long, Unit> $remove;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
                this.$listener = listener;
                this.$remove = remove;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, this, listener, remove);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Long invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Long l3 = (Long) this.this$0.getListenersMap().get(this.$listener);
                if (l3 == null) {
                    return null;
                }
                Function1<Long, Unit> function1 = this.$remove;
                BaseService<L, S> baseService = this.this$0;
                Object obj = this.$listener;
                function1.invoke(Long.valueOf(l3.longValue()));
                return (Long) baseService.getListenersMap().remove(obj);
            }
        };
        if (needCheck) {
            check("removeListener", function0);
        } else {
            function0.invoke();
        }
    }

    protected final void setListenersMap(@NotNull Map<L, Long> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.listenersMap = map;
        }
    }

    public final void setService(@Nullable S s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) s16);
        } else {
            this.service = s16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IOperateCallback getCallback(final String method, final int curSeq, final IOperateCallback cb5) {
        if (cb5 != null) {
            return new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bn
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$9$lambda$8(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @NotNull Object[] msg2, @Nullable final IOperateCallback cb5, @NotNull final Function1<? super IOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (T) iPatchRedirector.redirect((short) 13, this, method, msg2, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        CallMonitor e16 = this.content.e();
        String str = this.subTag;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to("method", method));
        spreadBuilder.addSpread(msg2);
        return (T) e16.H0(str, spreadBuilder.toArray(new Object[spreadBuilder.size()]), cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IOperateCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IOperateCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IOperateCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDetailInfoCallback getCallback(final String method, final int curSeq, final IDetailInfoCallback cb5) {
        if (cb5 != null) {
            return new IDetailInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
                public final void onResult(int i3, String str, Source source, HashMap hashMap) {
                    BaseService.getCallback$lambda$12$lambda$11(BaseService.this, method, curSeq, cb5, i3, str, source, hashMap);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IOperateCallback cb5, @NotNull final Function1<? super IOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (T) iPatchRedirector.redirect((short) 14, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().H0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IOperateCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IOperateCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IOperateCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICanImportCallback getCallback(final String method, final int curSeq, final ICanImportCallback cb5) {
        if (cb5 != null) {
            return new ICanImportCallback() { // from class: com.tencent.qqnt.kernel.api.impl.er
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
                public final void onResult(int i3, String str, int i16) {
                    BaseService.getCallback$lambda$15$lambda$14(BaseService.this, method, curSeq, cb5, i3, str, i16);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IModifyCategoryCallback cb5, @NotNull final Function1<? super IModifyCategoryCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (T) iPatchRedirector.redirect((short) 15, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().D0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ IModifyCategoryCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IModifyCategoryCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IModifyCategoryCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IModifyCategoryCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDataImportTableNamesCallback getCallback(final String method, final int curSeq, final IDataImportTableNamesCallback cb5) {
        if (cb5 != null) {
            return new IDataImportTableNamesCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ek
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    BaseService.getCallback$lambda$18$lambda$17(BaseService.this, method, curSeq, cb5, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupExt0xEF0InfoCallback cb5, @NotNull final Function1<? super IGroupExt0xEF0InfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (T) iPatchRedirector.redirect((short) 16, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().f1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$5
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupExt0xEF0InfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupExt0xEF0InfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupExt0xEF0InfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupExt0xEF0InfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        }, new Function0<Unit>(this) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$6
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IGroupExt0xEF0InfoCallback.this, (Object) this);
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
                IGroupExt0xEF0InfoCallback iGroupExt0xEF0InfoCallback = IGroupExt0xEF0InfoCallback.this;
                if (iGroupExt0xEF0InfoCallback != null) {
                    iGroupExt0xEF0InfoCallback.onResult(-1, this.this$0.getContent().e().i1(), null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAddJsonGrayTipMsgCallback getCallback(final String method, final int curSeq, final IAddJsonGrayTipMsgCallback cb5) {
        if (cb5 != null) {
            return new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cd
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                public final void onResult(int i3, long j3) {
                    BaseService.getCallback$lambda$21$lambda$20(BaseService.this, method, curSeq, cb5, i3, j3);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IBatchQueryCachedGroupDetailInfoCallback cb5, @NotNull final Function1<? super IBatchQueryCachedGroupDetailInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (T) iPatchRedirector.redirect((short) 17, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().f1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$7
            static IPatchRedirector $redirector_;
            final /* synthetic */ IBatchQueryCachedGroupDetailInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IBatchQueryCachedGroupDetailInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IBatchQueryCachedGroupDetailInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IBatchQueryCachedGroupDetailInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IBatchQueryCachedGroupDetailInfoCallback.this);
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
                IBatchQueryCachedGroupDetailInfoCallback iBatchQueryCachedGroupDetailInfoCallback = IBatchQueryCachedGroupDetailInfoCallback.this;
                if (iBatchQueryCachedGroupDetailInfoCallback != null) {
                    iBatchQueryCachedGroupDetailInfoCallback.onResult(new ArrayList<>());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICreateGroupOperateCallback getCallback(final String method, final int curSeq, final ICreateGroupOperateCallback cb5) {
        if (cb5 != null) {
            return new ICreateGroupOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bw
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICreateGroupOperateCallback
                public final void onResult(int i3, String str, long j3) {
                    BaseService.getCallback$lambda$24$lambda$23(BaseService.this, method, curSeq, cb5, i3, str, j3);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IDetailInfoCallback cb5, @NotNull final Function1<? super IDetailInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (T) iPatchRedirector.redirect((short) 18, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().e1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$9
            static IPatchRedirector $redirector_;
            final /* synthetic */ IDetailInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IDetailInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IDetailInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IDetailInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICreateGroupCallback getCallback(final String method, final int curSeq, final ICreateGroupCallback cb5) {
        if (cb5 != null) {
            return new ICreateGroupCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fy
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICreateGroupCallback
                public final void onResult(int i3, String str, CreateGroupResult createGroupResult) {
                    BaseService.getCallback$lambda$27$lambda$26(BaseService.this, method, curSeq, cb5, i3, str, createGroupResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ICanImportCallback cb5, @NotNull final Function1<? super ICanImportCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (T) iPatchRedirector.redirect((short) 19, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().e1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$10
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICanImportCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICanImportCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICanImportCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICanImportCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IKernelScanEndCallback getCallback(final String method, final int curSeq, final IKernelScanEndCallback cb5) {
        if (cb5 != null) {
            return new IKernelScanEndCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fv
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback
                public final void onResult(int i3, ArrayList arrayList) {
                    BaseService.getCallback$lambda$36$lambda$35(BaseService.this, method, curSeq, cb5, i3, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IDataImportTableNamesCallback cb5, @NotNull final Function1<? super IDataImportTableNamesCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (T) iPatchRedirector.redirect((short) 20, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().e1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$11
            static IPatchRedirector $redirector_;
            final /* synthetic */ IDataImportTableNamesCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IDataImportTableNamesCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IDataImportTableNamesCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IDataImportTableNamesCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetRobotFunctionsCallback getCallback(final String method, final int curSeq, final IGetRobotFunctionsCallback cb5) {
        if (cb5 != null) {
            return new IGetRobotFunctionsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cg
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback
                public final void onResult(int i3, String str, BatchBotGetResponse batchBotGetResponse) {
                    BaseService.getCallback$lambda$39$lambda$38(BaseService.this, method, curSeq, cb5, i3, str, batchBotGetResponse);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IAddJsonGrayTipMsgCallback cb5, @NotNull final Function1<? super IAddJsonGrayTipMsgCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (T) iPatchRedirector.redirect((short) 21, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().d(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$12
            static IPatchRedirector $redirector_;
            final /* synthetic */ IAddJsonGrayTipMsgCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IAddJsonGrayTipMsgCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IAddJsonGrayTipMsgCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IAddJsonGrayTipMsgCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFetchRobotCoreInfosCallback getCallback(final String method, final int curSeq, final IFetchRobotCoreInfosCallback cb5) {
        if (cb5 != null) {
            return new IFetchRobotCoreInfosCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fh
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchRobotCoreInfosCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    BaseService.getCallback$lambda$42$lambda$41(BaseService.this, method, curSeq, cb5, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final ICreateGroupOperateCallback cb5, @NotNull final Function1<? super ICreateGroupOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (T) iPatchRedirector.redirect((short) 22, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().l(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$13
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICreateGroupOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICreateGroupOperateCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICreateGroupOperateCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICreateGroupOperateCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupRobotProfileCallback getCallback(final String method, final int curSeq, final IGetGroupRobotProfileCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupRobotProfileCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fj
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
                public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                    BaseService.getCallback$lambda$45$lambda$44(BaseService.this, method, curSeq, cb5, i3, str, groupRobotProfile);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ICreateGroupCallback cb5, @NotNull final Function1<? super ICreateGroupCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (T) iPatchRedirector.redirect((short) 23, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().k(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$14
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICreateGroupCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICreateGroupCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICreateGroupCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICreateGroupCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetRobotMessagePushCallback getCallback(final String method, final int curSeq, final ISetRobotMessagePushCallback cb5) {
        if (cb5 != null) {
            return new ISetRobotMessagePushCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ce
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetRobotMessagePushCallback
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$48$lambda$47(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetMsgsBoxesCallback cb5, @NotNull final Function1<? super IGetMsgsBoxesCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (T) iPatchRedirector.redirect((short) 24, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().T(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$15
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetMsgsBoxesCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetMsgsBoxesCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetMsgsBoxesCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetMsgsBoxesCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAddFriendCallback getCallback(final String method, final int curSeq, final IAddFriendCallback cb5) {
        if (cb5 != null) {
            return new IAddFriendCallback() { // from class: com.tencent.qqnt.kernel.api.impl.gi
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback
                public final void onResult(int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
                    BaseService.getCallback$lambda$51$lambda$50(BaseService.this, method, curSeq, cb5, i3, str, robotAddFriendResponse);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGuildBinaryDataCallback cb5, @NotNull final Function1<? super IGetGuildBinaryDataCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (T) iPatchRedirector.redirect((short) 25, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().M(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$16
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGuildBinaryDataCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGuildBinaryDataCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGuildBinaryDataCallback guildBinaryDataCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGuildBinaryDataCallback, T> function1 = this.$work;
                guildBinaryDataCallback = this.this$0.getGuildBinaryDataCallback(this.$method, i3, this.$cb);
                return function1.invoke(guildBinaryDataCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRemoveFriendCallback getCallback(final String method, final int curSeq, final IRemoveFriendCallback cb5) {
        if (cb5 != null) {
            return new IRemoveFriendCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ad
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$54$lambda$53(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetTempChatInfoCallback cb5, @NotNull final Function1<? super IGetTempChatInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (T) iPatchRedirector.redirect((short) 26, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().Y(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$17
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetTempChatInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetTempChatInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetTempChatInfoCallback tempChatInfoCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetTempChatInfoCallback, T> function1 = this.$work;
                tempChatInfoCallback = this.this$0.getTempChatInfoCallback(this.$method, i3, this.$cb);
                return function1.invoke(tempChatInfoCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRobotAuthCallback getCallback(final String method, final int curSeq, final IRobotAuthCallback cb5) {
        if (cb5 != null) {
            return new IRobotAuthCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ah
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotAuthCallback
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$57$lambda$56(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IKernelScanEndCallback cb5, @NotNull final Function1<? super IKernelScanEndCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (T) iPatchRedirector.redirect((short) 27, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().A0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$18
            static IPatchRedirector $redirector_;
            final /* synthetic */ IKernelScanEndCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IKernelScanEndCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IKernelScanEndCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IKernelScanEndCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetAddRobotToGroupCallback getCallback(final String method, final int curSeq, final ISetAddRobotToGroupCallback cb5) {
        if (cb5 != null) {
            return new ISetAddRobotToGroupCallback() { // from class: com.tencent.qqnt.kernel.api.impl.as
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$60$lambda$59(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetRobotFunctionsCallback cb5, @NotNull final Function1<? super IGetRobotFunctionsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (T) iPatchRedirector.redirect((short) 28, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().W(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$19
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetRobotFunctionsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetRobotFunctionsCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetRobotFunctionsCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetRobotFunctionsCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetRemoveRobotFromGroupCallback getCallback(final String method, final int curSeq, final ISetRemoveRobotFromGroupCallback cb5) {
        if (cb5 != null) {
            return new ISetRemoveRobotFromGroupCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ej
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$63$lambda$62(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IFetchRobotCoreInfosCallback cb5, @NotNull final Function1<? super IFetchRobotCoreInfosCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (T) iPatchRedirector.redirect((short) 29, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().q(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$20
            static IPatchRedirector $redirector_;
            final /* synthetic */ IFetchRobotCoreInfosCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IFetchRobotCoreInfosCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IFetchRobotCoreInfosCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IFetchRobotCoreInfosCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetAddRobotGroupListCallback getCallback(final String method, final int curSeq, final IGetAddRobotGroupListCallback cb5) {
        if (cb5 != null) {
            return new IGetAddRobotGroupListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.en
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAddRobotGroupListCallback
                public final void onResult(int i3, String str, QueryAddRobotGroupListRsp queryAddRobotGroupListRsp) {
                    BaseService.getCallback$lambda$66$lambda$65(BaseService.this, method, curSeq, cb5, i3, str, queryAddRobotGroupListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupRobotProfileCallback cb5, @NotNull final Function1<? super IGetGroupRobotProfileCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (T) iPatchRedirector.redirect((short) 30, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().A(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$21
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupRobotProfileCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupRobotProfileCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupRobotProfileCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupRobotProfileCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRobotShareLimitCallBack getCallback(final String method, final int curSeq, final IRobotShareLimitCallBack cb5) {
        if (cb5 != null) {
            return new IRobotShareLimitCallBack() { // from class: com.tencent.qqnt.kernel.api.impl.dk
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotShareLimitCallBack
                public final void onResult(int i3, String str, RobotShareLimitRsp robotShareLimitRsp) {
                    BaseService.getCallback$lambda$69$lambda$68(BaseService.this, method, curSeq, cb5, i3, str, robotShareLimitRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISetRobotMessagePushCallback cb5, @NotNull final Function1<? super ISetRobotMessagePushCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (T) iPatchRedirector.redirect((short) 31, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().b1(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$22
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetRobotMessagePushCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetRobotMessagePushCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISetRobotMessagePushCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetRobotMessagePushCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISendCommonRobotCallBack getCallback(final String method, final int curSeq, final ISendCommonRobotCallBack cb5) {
        if (cb5 != null) {
            return new ISendCommonRobotCallBack() { // from class: com.tencent.qqnt.kernel.api.impl.cq
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISendCommonRobotCallBack
                public final void onResult(int i3, String str) {
                    BaseService.getCallback$lambda$72$lambda$71(BaseService.this, method, curSeq, cb5, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IAddFriendCallback cb5, @NotNull final Function1<? super IAddFriendCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (T) iPatchRedirector.redirect((short) 32, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().c(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$23
            static IPatchRedirector $redirector_;
            final /* synthetic */ IAddFriendCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IAddFriendCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IAddFriendCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IAddFriendCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupRobotStoreDiscoveryCallback getCallback(final String method, final int curSeq, final IGroupRobotStoreDiscoveryCallback cb5) {
        if (cb5 != null) {
            return new IGroupRobotStoreDiscoveryCallback() { // from class: com.tencent.qqnt.kernel.api.impl.w
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback
                public final void onResult(int i3, String str, GroupRobotStoreDiscoveryRsp groupRobotStoreDiscoveryRsp) {
                    BaseService.getCallback$lambda$75$lambda$74(BaseService.this, method, curSeq, cb5, i3, str, groupRobotStoreDiscoveryRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IRemoveFriendCallback cb5, @NotNull final Function1<? super IRemoveFriendCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (T) iPatchRedirector.redirect((short) 33, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().O0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$24
            static IPatchRedirector $redirector_;
            final /* synthetic */ IRemoveFriendCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IRemoveFriendCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IRemoveFriendCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IRemoveFriendCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRobotStoreSearchCallback getCallback(final String method, final int curSeq, final IRobotStoreSearchCallback cb5) {
        if (cb5 != null) {
            return new IRobotStoreSearchCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cu
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotStoreSearchCallback
                public final void onResult(int i3, String str, GroupRobotStoreSearchRsp groupRobotStoreSearchRsp) {
                    BaseService.getCallback$lambda$78$lambda$77(BaseService.this, method, curSeq, cb5, i3, str, groupRobotStoreSearchRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IRobotAuthCallback cb5, @NotNull final Function1<? super IRobotAuthCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (T) iPatchRedirector.redirect((short) 34, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().P0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$25
            static IPatchRedirector $redirector_;
            final /* synthetic */ IRobotAuthCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IRobotAuthCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IRobotAuthCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IRobotAuthCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IBuddyListCallback getCallback(final String method, final int curSeq, final IBuddyListCallback cb5) {
        if (cb5 != null) {
            return new IBuddyListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.du
                @Override // com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    BaseService.getCallback$lambda$81$lambda$80(BaseService.this, method, curSeq, cb5, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISetAddRobotToGroupCallback cb5, @NotNull final Function1<? super ISetAddRobotToGroupCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (T) iPatchRedirector.redirect((short) 35, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().V0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$26
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetAddRobotToGroupCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetAddRobotToGroupCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISetAddRobotToGroupCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetAddRobotToGroupCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRobotStoreCategoryListCallback getCallback(final String method, final int curSeq, final IRobotStoreCategoryListCallback cb5) {
        if (cb5 != null) {
            return new IRobotStoreCategoryListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ea
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotStoreCategoryListCallback
                public final void onResult(int i3, String str, GroupRobotStoreCategoryListRsp groupRobotStoreCategoryListRsp) {
                    BaseService.getCallback$lambda$84$lambda$83(BaseService.this, method, curSeq, cb5, i3, str, groupRobotStoreCategoryListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISetRemoveRobotFromGroupCallback cb5, @NotNull final Function1<? super ISetRemoveRobotFromGroupCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (T) iPatchRedirector.redirect((short) 36, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().a1(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$27
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetRemoveRobotFromGroupCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetRemoveRobotFromGroupCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISetRemoveRobotFromGroupCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetRemoveRobotFromGroupCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolNoticeListCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolNoticeListCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolNoticeListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cv
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeListCallback
                public final void onResult(int i3, String str, GetGroupSchoolNoticeListRsp getGroupSchoolNoticeListRsp) {
                    BaseService.getCallback$lambda$87$lambda$86(BaseService.this, method, curSeq, cb5, i3, str, getGroupSchoolNoticeListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetAddRobotGroupListCallback cb5, @NotNull final Function1<? super IGetAddRobotGroupListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (T) iPatchRedirector.redirect((short) 37, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().t(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$28
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetAddRobotGroupListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetAddRobotGroupListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetAddRobotGroupListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetAddRobotGroupListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolNoticeDetailCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolNoticeDetailCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolNoticeDetailCallback() { // from class: com.tencent.qqnt.kernel.api.impl.u
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeDetailCallback
                public final void onResult(int i3, String str, GetGroupSchoolNoticeDetailRsp getGroupSchoolNoticeDetailRsp) {
                    BaseService.getCallback$lambda$90$lambda$89(BaseService.this, method, curSeq, cb5, i3, str, getGroupSchoolNoticeDetailRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IRobotShareLimitCallBack cb5, @NotNull final Function1<? super IRobotShareLimitCallBack, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (T) iPatchRedirector.redirect((short) 38, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().Q0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$29
            static IPatchRedirector $redirector_;
            final /* synthetic */ IRobotShareLimitCallBack $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IRobotShareLimitCallBack, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IRobotShareLimitCallBack callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IRobotShareLimitCallBack, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPublishGroupSchoolNoticeCallback getCallback(final String method, final int curSeq, final IPublishGroupSchoolNoticeCallback cb5) {
        if (cb5 != null) {
            return new IPublishGroupSchoolNoticeCallback() { // from class: com.tencent.qqnt.kernel.api.impl.gl
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolNoticeCallback
                public final void onResult(int i3, String str, PublishGroupSchoolNoticeRsp publishGroupSchoolNoticeRsp) {
                    BaseService.getCallback$lambda$93$lambda$92(BaseService.this, method, curSeq, cb5, i3, str, publishGroupSchoolNoticeRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISendCommonRobotCallBack cb5, @NotNull final Function1<? super ISendCommonRobotCallBack, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (T) iPatchRedirector.redirect((short) 39, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().T0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$30
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISendCommonRobotCallBack $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISendCommonRobotCallBack, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISendCommonRobotCallBack callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISendCommonRobotCallBack, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IConfirmGroupSchoolNoticeCallback getCallback(final String method, final int curSeq, final IConfirmGroupSchoolNoticeCallback cb5) {
        if (cb5 != null) {
            return new IConfirmGroupSchoolNoticeCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ap
                @Override // com.tencent.qqnt.kernel.nativeinterface.IConfirmGroupSchoolNoticeCallback
                public final void onResult(int i3, String str, ConfirmGroupSchoolNoticeRsp confirmGroupSchoolNoticeRsp) {
                    BaseService.getCallback$lambda$96$lambda$95(BaseService.this, method, curSeq, cb5, i3, str, confirmGroupSchoolNoticeRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupRobotStoreDiscoveryCallback cb5, @NotNull final Function1<? super IGroupRobotStoreDiscoveryCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (T) iPatchRedirector.redirect((short) 40, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().q0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$31
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupRobotStoreDiscoveryCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupRobotStoreDiscoveryCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupRobotStoreDiscoveryCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupRobotStoreDiscoveryCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolNoticeStatisticCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolNoticeStatisticCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolNoticeStatisticCallback() { // from class: com.tencent.qqnt.kernel.api.impl.aj
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback
                public final void onResult(int i3, String str, GroupSchoolNoticeStatisticsRsp groupSchoolNoticeStatisticsRsp) {
                    BaseService.getCallback$lambda$99$lambda$98(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolNoticeStatisticsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IRobotStoreSearchCallback cb5, @NotNull final Function1<? super IRobotStoreSearchCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (T) iPatchRedirector.redirect((short) 41, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().S0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$32
            static IPatchRedirector $redirector_;
            final /* synthetic */ IRobotStoreSearchCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IRobotStoreSearchCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IRobotStoreSearchCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IRobotStoreSearchCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IBatchGetUserGroupSchoolRoleCallback getCallback(final String method, final int curSeq, final IBatchGetUserGroupSchoolRoleCallback cb5) {
        if (cb5 != null) {
            return new IBatchGetUserGroupSchoolRoleCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cr
                @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchGetUserGroupSchoolRoleCallback
                public final void onResult(int i3, String str, BatchGetGroupSchoolRoleRsp batchGetGroupSchoolRoleRsp) {
                    BaseService.getCallback$lambda$102$lambda$101(BaseService.this, method, curSeq, cb5, i3, str, batchGetGroupSchoolRoleRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IBuddyListCallback cb5, @NotNull final Function1<? super IBuddyListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (T) iPatchRedirector.redirect((short) 42, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().f(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$33
            static IPatchRedirector $redirector_;
            final /* synthetic */ IBuddyListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IBuddyListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IBuddyListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IBuddyListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberListCallback getCallback(final String method, final int curSeq, final IGroupMemberListCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cc
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                    BaseService.getCallback$lambda$105$lambda$104(BaseService.this, method, curSeq, cb5, i3, str, groupMemberListResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IRobotStoreCategoryListCallback cb5, @NotNull final Function1<? super IRobotStoreCategoryListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (T) iPatchRedirector.redirect((short) 43, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().R0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$34
            static IPatchRedirector $redirector_;
            final /* synthetic */ IRobotStoreCategoryListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IRobotStoreCategoryListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IRobotStoreCategoryListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IRobotStoreCategoryListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberCommonCallback getCallback(final String method, final int curSeq, final IGroupMemberCommonCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberCommonCallback() { // from class: com.tencent.qqnt.kernel.api.impl.eh
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberCommonCallback
                public final void onResult(int i3, String str, GroupMemberCommonListResult groupMemberCommonListResult) {
                    BaseService.getCallback$lambda$108$lambda$107(BaseService.this, method, curSeq, cb5, i3, str, groupMemberCommonListResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolNoticeListCallback cb5, @NotNull final Function1<? super IGetGroupSchoolNoticeListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (T) iPatchRedirector.redirect((short) 44, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().C(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$35
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolNoticeListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolNoticeListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolNoticeListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolNoticeListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberExtCallback getCallback(final String method, final int curSeq, final IGroupMemberExtCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberExtCallback() { // from class: com.tencent.qqnt.kernel.api.impl.v
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback
                public final void onResult(int i3, String str, GroupMemberExtListResult groupMemberExtListResult) {
                    BaseService.getCallback$lambda$111$lambda$110(BaseService.this, method, curSeq, cb5, i3, str, groupMemberExtListResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolNoticeDetailCallback cb5, @NotNull final Function1<? super IGetGroupSchoolNoticeDetailCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (T) iPatchRedirector.redirect((short) 45, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().B(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$36
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolNoticeDetailCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolNoticeDetailCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolNoticeDetailCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolNoticeDetailCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberHonorCallback getCallback(final String method, final int curSeq, final IGroupMemberHonorCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberHonorCallback() { // from class: com.tencent.qqnt.kernel.api.impl.be
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberHonorCallback
                public final void onResult(int i3, String str, GroupMemberHonorListResult groupMemberHonorListResult) {
                    BaseService.getCallback$lambda$114$lambda$113(BaseService.this, method, curSeq, cb5, i3, str, groupMemberHonorListResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IPublishGroupSchoolNoticeCallback cb5, @NotNull final Function1<? super IPublishGroupSchoolNoticeCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (T) iPatchRedirector.redirect((short) 46, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().I0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$37
            static IPatchRedirector $redirector_;
            final /* synthetic */ IPublishGroupSchoolNoticeCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IPublishGroupSchoolNoticeCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IPublishGroupSchoolNoticeCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IPublishGroupSchoolNoticeCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberUidCallback getCallback(final String method, final int curSeq, final IGroupMemberUidCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberUidCallback() { // from class: com.tencent.qqnt.kernel.api.impl.av
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberUidCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    BaseService.getCallback$lambda$117$lambda$116(BaseService.this, method, curSeq, cb5, i3, str, hashMap);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IConfirmGroupSchoolNoticeCallback cb5, @NotNull final Function1<? super IConfirmGroupSchoolNoticeCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (T) iPatchRedirector.redirect((short) 47, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().j(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$38
            static IPatchRedirector $redirector_;
            final /* synthetic */ IConfirmGroupSchoolNoticeCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IConfirmGroupSchoolNoticeCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IConfirmGroupSchoolNoticeCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IConfirmGroupSchoolNoticeCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberUinCallback getCallback(final String method, final int curSeq, final IGroupMemberUinCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberUinCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ab
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberUinCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    BaseService.getCallback$lambda$120$lambda$119(BaseService.this, method, curSeq, cb5, i3, str, hashMap);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolNoticeStatisticCallback cb5, @NotNull final Function1<? super IGetGroupSchoolNoticeStatisticCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (T) iPatchRedirector.redirect((short) 48, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().D(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$39
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolNoticeStatisticCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolNoticeStatisticCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolNoticeStatisticCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolNoticeStatisticCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetSubGroupInfoCallback getCallback(final String method, final int curSeq, final IGetSubGroupInfoCallback cb5) {
        if (cb5 != null) {
            return new IGetSubGroupInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ch
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSubGroupInfoCallback
                public final void onResult(int i3, String str, GetSubGroupInfoRsp getSubGroupInfoRsp) {
                    BaseService.getCallback$lambda$123$lambda$122(BaseService.this, method, curSeq, cb5, i3, str, getSubGroupInfoRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IBatchGetUserGroupSchoolRoleCallback cb5, @NotNull final Function1<? super IBatchGetUserGroupSchoolRoleCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (T) iPatchRedirector.redirect((short) 49, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().e(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$40
            static IPatchRedirector $redirector_;
            final /* synthetic */ IBatchGetUserGroupSchoolRoleCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IBatchGetUserGroupSchoolRoleCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IBatchGetUserGroupSchoolRoleCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IBatchGetUserGroupSchoolRoleCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolTemplateListCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolTemplateListCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolTemplateListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.dz
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTemplateListCallback
                public final void onResult(int i3, String str, GroupSchoolTemplateListRsp groupSchoolTemplateListRsp) {
                    BaseService.getCallback$lambda$126$lambda$125(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolTemplateListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberListCallback cb5, @NotNull final Function1<? super IGroupMemberListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (T) iPatchRedirector.redirect((short) 50, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().j0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$41
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPublishGroupSchoolTaskCallback getCallback(final String method, final int curSeq, final IPublishGroupSchoolTaskCallback cb5) {
        if (cb5 != null) {
            return new IPublishGroupSchoolTaskCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fn
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolTaskCallback
                public final void onResult(int i3, String str, PublishGroupSchoolTaskRsp publishGroupSchoolTaskRsp) {
                    BaseService.getCallback$lambda$129$lambda$128(BaseService.this, method, curSeq, cb5, i3, str, publishGroupSchoolTaskRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberCommonCallback cb5, @NotNull final Function1<? super IGroupMemberCommonCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (T) iPatchRedirector.redirect((short) 51, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().f0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$42
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberCommonCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberCommonCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberCommonCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberCommonCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolTaskDetailCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolTaskDetailCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolTaskDetailCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fb
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskDetailCallback
                public final void onResult(int i3, String str, GroupSchoolTaskDetailRsp groupSchoolTaskDetailRsp) {
                    BaseService.getCallback$lambda$132$lambda$131(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolTaskDetailRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberExtCallback cb5, @NotNull final Function1<? super IGroupMemberExtCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (T) iPatchRedirector.redirect((short) 52, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().g0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$43
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberExtCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberExtCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberExtCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberExtCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICheckInGroupSchoolTaskCallback getCallback(final String method, final int curSeq, final ICheckInGroupSchoolTaskCallback cb5) {
        if (cb5 != null) {
            return new ICheckInGroupSchoolTaskCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ct
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckInGroupSchoolTaskCallback
                public final void onResult(int i3, String str, CheckInGroupSchoolTaskRsp checkInGroupSchoolTaskRsp) {
                    BaseService.getCallback$lambda$135$lambda$134(BaseService.this, method, curSeq, cb5, i3, str, checkInGroupSchoolTaskRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGroupMemberHonorCallback cb5, @NotNull final Function1<? super IGroupMemberHonorCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (T) iPatchRedirector.redirect((short) 53, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().h0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$44
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberHonorCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberHonorCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberHonorCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberHonorCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolTaskListCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolTaskListCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolTaskListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fp
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskListCallback
                public final void onResult(int i3, String str, GroupSchoolTaskListRsp groupSchoolTaskListRsp) {
                    BaseService.getCallback$lambda$138$lambda$137(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolTaskListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberUidCallback cb5, @NotNull final Function1<? super IGroupMemberUidCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (T) iPatchRedirector.redirect((short) 54, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().l0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$45
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberUidCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberUidCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberUidCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberUidCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolTaskStatisticsCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolTaskStatisticsCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolTaskStatisticsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bc
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskStatisticsCallback
                public final void onResult(int i3, String str, GroupSchoolTaskStatisticsRsp groupSchoolTaskStatisticsRsp) {
                    BaseService.getCallback$lambda$141$lambda$140(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolTaskStatisticsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberUinCallback cb5, @NotNull final Function1<? super IGroupMemberUinCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (T) iPatchRedirector.redirect((short) 55, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().m0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$46
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberUinCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberUinCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberUinCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberUinCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolTaskCheckInInfoCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolTaskCheckInInfoCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolTaskCheckInInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ac
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskCheckInInfoCallback
                public final void onResult(int i3, String str, GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp) {
                    BaseService.getCallback$lambda$144$lambda$143(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolTaskCheckInInfoRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetSubGroupInfoCallback cb5, @NotNull final Function1<? super IGetSubGroupInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (T) iPatchRedirector.redirect((short) 56, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().X(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$47
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetSubGroupInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetSubGroupInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetSubGroupInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetSubGroupInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolTaskUnCheckInCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolTaskUnCheckInCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolTaskUnCheckInCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ez
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback
                public final void onResult(int i3, String str, GroupSchoolTaskUnCheckInRsp groupSchoolTaskUnCheckInRsp) {
                    BaseService.getCallback$lambda$147$lambda$146(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolTaskUnCheckInRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolTemplateListCallback cb5, @NotNull final Function1<? super IGetGroupSchoolTemplateListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (T) iPatchRedirector.redirect((short) 57, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().J(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$48
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolTemplateListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolTemplateListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolTemplateListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolTemplateListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetAIGCEmojiListCallback getCallback(final String method, final int curSeq, final IGetAIGCEmojiListCallback cb5) {
        if (cb5 != null) {
            return new IGetAIGCEmojiListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cy
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAIGCEmojiListCallback
                public final void onGetAIGCEmojiList(AIGCEmojiListInfo aIGCEmojiListInfo) {
                    BaseService.getCallback$lambda$150$lambda$149(BaseService.this, method, curSeq, cb5, aIGCEmojiListInfo);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IPublishGroupSchoolTaskCallback cb5, @NotNull final Function1<? super IPublishGroupSchoolTaskCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (T) iPatchRedirector.redirect((short) 58, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().J0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$49
            static IPatchRedirector $redirector_;
            final /* synthetic */ IPublishGroupSchoolTaskCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IPublishGroupSchoolTaskCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IPublishGroupSchoolTaskCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IPublishGroupSchoolTaskCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICheckImageCallback getCallback(final String method, final int curSeq, final ICheckImageCallback cb5) {
        if (cb5 != null) {
            return new ICheckImageCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ep
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckImageCallback
                public final void onCheckImage(CheckImageResult checkImageResult) {
                    BaseService.getCallback$lambda$153$lambda$152(BaseService.this, method, curSeq, cb5, checkImageResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolTaskDetailCallback cb5, @NotNull final Function1<? super IGetGroupSchoolTaskDetailCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (T) iPatchRedirector.redirect((short) 59, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().F(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$50
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolTaskDetailCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolTaskDetailCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolTaskDetailCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolTaskDetailCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IKernelBdhUploadCompleteCallback getCallback(final String method, final int curSeq, final IKernelBdhUploadCompleteCallback cb5) {
        if (cb5 != null) {
            return new IKernelBdhUploadCompleteCallback() { // from class: com.tencent.qqnt.kernel.api.impl.em
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback
                public final void onResult(int i3, String str, BdhUploadRsp bdhUploadRsp) {
                    BaseService.getCallback$lambda$156$lambda$155(BaseService.this, method, curSeq, cb5, i3, str, bdhUploadRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ICheckInGroupSchoolTaskCallback cb5, @NotNull final Function1<? super ICheckInGroupSchoolTaskCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (T) iPatchRedirector.redirect((short) 60, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().i(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$51
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICheckInGroupSchoolTaskCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICheckInGroupSchoolTaskCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICheckInGroupSchoolTaskCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICheckInGroupSchoolTaskCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetGroupRelationToGuildCallback getCallback(final String method, final int curSeq, final ISetGroupRelationToGuildCallback cb5) {
        if (cb5 != null) {
            return new ISetGroupRelationToGuildCallback() { // from class: com.tencent.qqnt.kernel.api.impl.gk
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetGroupRelationToGuildCallback
                public final void onResult(int i3, String str, SetGroupRelationToGuildRsp setGroupRelationToGuildRsp) {
                    BaseService.getCallback$lambda$159$lambda$158(BaseService.this, method, curSeq, cb5, i3, str, setGroupRelationToGuildRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolTaskListCallback cb5, @NotNull final Function1<? super IGetGroupSchoolTaskListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (T) iPatchRedirector.redirect((short) 61, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().G(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$52
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolTaskListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolTaskListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolTaskListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolTaskListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupBindGuildsCallback getCallback(final String method, final int curSeq, final IGetGroupBindGuildsCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupBindGuildsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.et
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupBindGuildsCallback
                public final void onResult(int i3, String str, GetGroupBindGuildsRsp getGroupBindGuildsRsp) {
                    BaseService.getCallback$lambda$162$lambda$161(BaseService.this, method, curSeq, cb5, i3, str, getGroupBindGuildsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolTaskStatisticsCallback cb5, @NotNull final Function1<? super IGetGroupSchoolTaskStatisticsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (T) iPatchRedirector.redirect((short) 62, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().H(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$53
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolTaskStatisticsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolTaskStatisticsCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolTaskStatisticsCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolTaskStatisticsCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetAIOBindGuildCallback getCallback(final String method, final int curSeq, final ISetAIOBindGuildCallback cb5) {
        if (cb5 != null) {
            return new ISetAIOBindGuildCallback() { // from class: com.tencent.qqnt.kernel.api.impl.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAIOBindGuildCallback
                public final void onResult(int i3, String str, SetAIOBindGuildRsp setAIOBindGuildRsp) {
                    BaseService.getCallback$lambda$165$lambda$164(BaseService.this, method, curSeq, cb5, i3, str, setAIOBindGuildRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolTaskCheckInInfoCallback cb5, @NotNull final Function1<? super IGetGroupSchoolTaskCheckInInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (T) iPatchRedirector.redirect((short) 63, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().E(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$54
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolTaskCheckInInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolTaskCheckInInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolTaskCheckInInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolTaskCheckInInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQueryAIOBindGuildCallback getCallback(final String method, final int curSeq, final IQueryAIOBindGuildCallback cb5) {
        if (cb5 != null) {
            return new IQueryAIOBindGuildCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bm
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryAIOBindGuildCallback
                public final void onResult(int i3, String str, QueryAIOBindGuildRsp queryAIOBindGuildRsp) {
                    BaseService.getCallback$lambda$168$lambda$167(BaseService.this, method, curSeq, cb5, i3, str, queryAIOBindGuildRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolTaskUnCheckInCallback cb5, @NotNull final Function1<? super IGetGroupSchoolTaskUnCheckInCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (T) iPatchRedirector.redirect((short) 64, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().I(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$55
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolTaskUnCheckInCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolTaskUnCheckInCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolTaskUnCheckInCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolTaskUnCheckInCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetAIOBindGuildInfoCallback getCallback(final String method, final int curSeq, final IGetAIOBindGuildInfoCallback cb5) {
        if (cb5 != null) {
            return new IGetAIOBindGuildInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ec
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAIOBindGuildInfoCallback
                public final void onResult(int i3, String str, GetAIOBindGuildInfoRsp getAIOBindGuildInfoRsp) {
                    BaseService.getCallback$lambda$171$lambda$170(BaseService.this, method, curSeq, cb5, i3, str, getAIOBindGuildInfoRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetAIGCEmojiListCallback cb5, @NotNull final Function1<? super IGetAIGCEmojiListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (T) iPatchRedirector.redirect((short) 65, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().r(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$56
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetAIGCEmojiListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetAIGCEmojiListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetAIGCEmojiListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetAIGCEmojiListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IUnbindAllGuildsCallback getCallback(final String method, final int curSeq, final IUnbindAllGuildsCallback cb5) {
        if (cb5 != null) {
            return new IUnbindAllGuildsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.aa
                @Override // com.tencent.qqnt.kernel.nativeinterface.IUnbindAllGuildsCallback
                public final void onResult(int i3, String str, UnbindAllGuildsRsp unbindAllGuildsRsp) {
                    BaseService.getCallback$lambda$174$lambda$173(BaseService.this, method, curSeq, cb5, i3, str, unbindAllGuildsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ICheckImageCallback cb5, @NotNull final Function1<? super ICheckImageCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (T) iPatchRedirector.redirect((short) 66, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().h(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$57
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICheckImageCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICheckImageCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICheckImageCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICheckImageCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberIllegalInfoCallback getCallback(final String method, final int curSeq, final IGroupMemberIllegalInfoCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberIllegalInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberIllegalInfoCallback
                public final void onResult(int i3, String str, GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
                    BaseService.getCallback$lambda$177$lambda$176(BaseService.this, method, curSeq, cb5, i3, str, groupMemberIllegalInfoResult);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IKernelBdhUploadCompleteCallback cb5, @NotNull final Function1<? super IKernelBdhUploadCompleteCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (T) iPatchRedirector.redirect((short) 67, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().z0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$58
            static IPatchRedirector $redirector_;
            final /* synthetic */ IKernelBdhUploadCompleteCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IKernelBdhUploadCompleteCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IKernelBdhUploadCompleteCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IKernelBdhUploadCompleteCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IKickMemberOperateCallback getCallback(final String func, final int curSeq, final IKickMemberOperateCallback cb5) {
        if (cb5 != null) {
            return new IKickMemberOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.dq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKickMemberOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    BaseService.getCallback$lambda$180$lambda$179(BaseService.this, func, curSeq, cb5, i3, str, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISetGroupRelationToGuildCallback cb5, @NotNull final Function1<? super ISetGroupRelationToGuildCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (T) iPatchRedirector.redirect((short) 68, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().X0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$59
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetGroupRelationToGuildCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetGroupRelationToGuildCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISetGroupRelationToGuildCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetGroupRelationToGuildCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IKickMemberCallback getCallback(final String method, final int curSeq, final IKickMemberCallback cb5) {
        if (cb5 != null) {
            return new IKickMemberCallback() { // from class: com.tencent.qqnt.kernel.api.impl.gm
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKickMemberCallback
                public final void onResult(int i3, String str, KickMemberV2Result kickMemberV2Result) {
                    BaseService.getCallback$lambda$183$lambda$182(BaseService.this, method, curSeq, cb5, i3, str, kickMemberV2Result);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupBindGuildsCallback cb5, @NotNull final Function1<? super IGetGroupBindGuildsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (T) iPatchRedirector.redirect((short) 69, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().w(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$60
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupBindGuildsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupBindGuildsCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupBindGuildsCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupBindGuildsCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IJoinGroupCallback getCallback(final String method, final int curSeq, final IJoinGroupCallback cb5) {
        if (cb5 != null) {
            return new IJoinGroupCallback() { // from class: com.tencent.qqnt.kernel.api.impl.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IJoinGroupCallback
                public final void onResult(int i3, String str, JoinGroupNotifyMsg joinGroupNotifyMsg) {
                    BaseService.getCallback$lambda$186$lambda$185(BaseService.this, method, curSeq, cb5, i3, str, joinGroupNotifyMsg);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISetAIOBindGuildCallback cb5, @NotNull final Function1<? super ISetAIOBindGuildCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (T) iPatchRedirector.redirect((short) 70, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().U0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$61
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetAIOBindGuildCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetAIOBindGuildCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISetAIOBindGuildCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetAIOBindGuildCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupDetailInfoCallback getCallback(final String method, final int curSeq, final IGroupDetailInfoCallback cb5) {
        if (cb5 != null) {
            return new IGroupDetailInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ft
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback
                public final void onResult(int i3, String str, GroupDetailInfo groupDetailInfo) {
                    BaseService.getCallback$lambda$189$lambda$188(BaseService.this, method, curSeq, cb5, i3, str, groupDetailInfo);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IQueryAIOBindGuildCallback cb5, @NotNull final Function1<? super IQueryAIOBindGuildCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (T) iPatchRedirector.redirect((short) 71, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().K0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$62
            static IPatchRedirector $redirector_;
            final /* synthetic */ IQueryAIOBindGuildCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IQueryAIOBindGuildCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IQueryAIOBindGuildCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IQueryAIOBindGuildCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ITransferGroupCallback getCallback(final String method, final int curSeq, final ITransferGroupCallback cb5) {
        if (cb5 != null) {
            return new ITransferGroupCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ee
                @Override // com.tencent.qqnt.kernel.nativeinterface.ITransferGroupCallback
                public final void onResult(int i3, String str, TransferGroupRsp transferGroupRsp) {
                    BaseService.getCallback$lambda$192$lambda$191(BaseService.this, method, curSeq, cb5, i3, str, transferGroupRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetAIOBindGuildInfoCallback cb5, @NotNull final Function1<? super IGetAIOBindGuildInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (T) iPatchRedirector.redirect((short) 72, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().s(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$63
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetAIOBindGuildInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetAIOBindGuildInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetAIOBindGuildInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetAIOBindGuildInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IInviteToGroupCallback getCallback(final String method, final int curSeq, final IInviteToGroupCallback cb5) {
        if (cb5 != null) {
            return new IInviteToGroupCallback() { // from class: com.tencent.qqnt.kernel.api.impl.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IInviteToGroupCallback
                public final void onResult(int i3, String str, InviteToGroupRsp inviteToGroupRsp) {
                    BaseService.getCallback$lambda$195$lambda$194(BaseService.this, method, curSeq, cb5, i3, str, inviteToGroupRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IUnbindAllGuildsCallback cb5, @NotNull final Function1<? super IUnbindAllGuildsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (T) iPatchRedirector.redirect((short) 73, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().d1(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$64
            static IPatchRedirector $redirector_;
            final /* synthetic */ IUnbindAllGuildsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IUnbindAllGuildsCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IUnbindAllGuildsCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IUnbindAllGuildsCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISetGroupMsgMaskCallback getCallback(final String method, final int curSeq, final ISetGroupMsgMaskCallback cb5) {
        if (cb5 != null) {
            return new ISetGroupMsgMaskCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ba
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetGroupMsgMaskCallback
                public final void onResult(int i3, String str, SetGroupMsgMaskRsp setGroupMsgMaskRsp) {
                    BaseService.getCallback$lambda$198$lambda$197(BaseService.this, method, curSeq, cb5, i3, str, setGroupMsgMaskRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberIllegalInfoCallback cb5, @NotNull final Function1<? super IGroupMemberIllegalInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return (T) iPatchRedirector.redirect((short) 75, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().i0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$65
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberIllegalInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberIllegalInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberIllegalInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberIllegalInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IJoinGroupVerifyCallback getCallback(final String method, final int curSeq, final IJoinGroupVerifyCallback cb5) {
        if (cb5 != null) {
            return new IJoinGroupVerifyCallback() { // from class: com.tencent.qqnt.kernel.api.impl.es
                @Override // com.tencent.qqnt.kernel.nativeinterface.IJoinGroupVerifyCallback
                public final void onResult(int i3, String str, JoinGroupVerifyRsp joinGroupVerifyRsp) {
                    BaseService.getCallback$lambda$201$lambda$200(BaseService.this, method, curSeq, cb5, i3, str, joinGroupVerifyRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IKickMemberOperateCallback cb5, @NotNull final Function1<? super IKickMemberOperateCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return (T) iPatchRedirector.redirect((short) 76, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().C0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$66
            static IPatchRedirector $redirector_;
            final /* synthetic */ IKickMemberOperateCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IKickMemberOperateCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IKickMemberOperateCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IKickMemberOperateCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IRcvJoinVerifyMsgCallback getCallback(final String method, final int curSeq, final IRcvJoinVerifyMsgCallback cb5) {
        if (cb5 != null) {
            return new IRcvJoinVerifyMsgCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ef
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRcvJoinVerifyMsgCallback
                public final void onResult(int i3, String str, RcvJoinVerifyMsgRsp rcvJoinVerifyMsgRsp) {
                    BaseService.getCallback$lambda$204$lambda$203(BaseService.this, method, curSeq, cb5, i3, str, rcvJoinVerifyMsgRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IKickMemberCallback cb5, @NotNull final Function1<? super IKickMemberCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (T) iPatchRedirector.redirect((short) 77, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().B0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$67
            static IPatchRedirector $redirector_;
            final /* synthetic */ IKickMemberCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IKickMemberCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IKickMemberCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IKickMemberCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupPrivilegeFlagCallback getCallback(final String method, final int curSeq, final IGroupPrivilegeFlagCallback cb5) {
        if (cb5 != null) {
            return new IGroupPrivilegeFlagCallback() { // from class: com.tencent.qqnt.kernel.api.impl.dc
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupPrivilegeFlagCallback
                public final void onResult(int i3, String str, GroupPrivilegeFlagRsp groupPrivilegeFlagRsp) {
                    BaseService.getCallback$lambda$207$lambda$206(BaseService.this, method, curSeq, cb5, i3, str, groupPrivilegeFlagRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IJoinGroupCallback cb5, @NotNull final Function1<? super IJoinGroupCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (T) iPatchRedirector.redirect((short) 78, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().x0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$68
            static IPatchRedirector $redirector_;
            final /* synthetic */ IJoinGroupCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IJoinGroupCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IJoinGroupCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IJoinGroupCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupEssenceMsgSwitchCallback getCallback(final String method, final int curSeq, final IGroupEssenceMsgSwitchCallback cb5) {
        if (cb5 != null) {
            return new IGroupEssenceMsgSwitchCallback() { // from class: com.tencent.qqnt.kernel.api.impl.do
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupEssenceMsgSwitchCallback
                public final void onResult(int i3, String str, GroupEssenceMsgSwitchRsp groupEssenceMsgSwitchRsp) {
                    BaseService.getCallback$lambda$210$lambda$209(BaseService.this, method, curSeq, cb5, i3, str, groupEssenceMsgSwitchRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupDetailInfoCallback cb5, @NotNull final Function1<? super IGroupDetailInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (T) iPatchRedirector.redirect((short) 79, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().b0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$69
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupDetailInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupDetailInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupDetailInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupDetailInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMemberMaxNumCallback getCallback(final String method, final int curSeq, final IGroupMemberMaxNumCallback cb5) {
        if (cb5 != null) {
            return new IGroupMemberMaxNumCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ae
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberMaxNumCallback
                public final void onResult(int i3, String str, GroupMemberMaxNumRsp groupMemberMaxNumRsp) {
                    BaseService.getCallback$lambda$213$lambda$212(BaseService.this, method, curSeq, cb5, i3, str, groupMemberMaxNumRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ITransferGroupCallback cb5, @NotNull final Function1<? super ITransferGroupCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (T) iPatchRedirector.redirect((short) 80, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().c1(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$70
            static IPatchRedirector $redirector_;
            final /* synthetic */ ITransferGroupCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ITransferGroupCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ITransferGroupCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ITransferGroupCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupSecLevelInfoCallback getCallback(final String method, final int curSeq, final IGroupSecLevelInfoCallback cb5) {
        if (cb5 != null) {
            return new IGroupSecLevelInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.da
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupSecLevelInfoCallback
                public final void onResult(int i3, String str, GroupSecLevelInfoRsp groupSecLevelInfoRsp) {
                    BaseService.getCallback$lambda$216$lambda$215(BaseService.this, method, curSeq, cb5, i3, str, groupSecLevelInfoRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IInviteToGroupCallback cb5, @NotNull final Function1<? super IInviteToGroupCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (T) iPatchRedirector.redirect((short) 81, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().w0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$71
            static IPatchRedirector $redirector_;
            final /* synthetic */ IInviteToGroupCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IInviteToGroupCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IInviteToGroupCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IInviteToGroupCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupAvatarWallCallback getCallback(final String method, final int curSeq, final IGroupAvatarWallCallback cb5) {
        if (cb5 != null) {
            return new IGroupAvatarWallCallback() { // from class: com.tencent.qqnt.kernel.api.impl.al
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupAvatarWallCallback
                public final void onResult(int i3, String str, GroupAvatarWallRsp groupAvatarWallRsp) {
                    BaseService.getCallback$lambda$219$lambda$218(BaseService.this, method, curSeq, cb5, i3, str, groupAvatarWallRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ISetGroupMsgMaskCallback cb5, @NotNull final Function1<? super ISetGroupMsgMaskCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return (T) iPatchRedirector.redirect((short) 82, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().W0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$72
            static IPatchRedirector $redirector_;
            final /* synthetic */ ISetGroupMsgMaskCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ISetGroupMsgMaskCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ISetGroupMsgMaskCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ISetGroupMsgMaskCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupInfoForGrayTipsCallback getCallback(final String method, final int curSeq, final IGroupInfoForGrayTipsCallback cb5) {
        if (cb5 != null) {
            return new IGroupInfoForGrayTipsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ao
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupInfoForGrayTipsCallback
                public final void onResult(int i3, String str, GroupInfoForGrayTipsRsp groupInfoForGrayTipsRsp) {
                    BaseService.getCallback$lambda$222$lambda$221(BaseService.this, method, curSeq, cb5, i3, str, groupInfoForGrayTipsRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IJoinGroupVerifyCallback cb5, @NotNull final Function1<? super IJoinGroupVerifyCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (T) iPatchRedirector.redirect((short) 83, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().y0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$73
            static IPatchRedirector $redirector_;
            final /* synthetic */ IJoinGroupVerifyCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IJoinGroupVerifyCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IJoinGroupVerifyCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IJoinGroupVerifyCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupInfoForJoinCallback getCallback(final String method, final int curSeq, final IGroupInfoForJoinCallback cb5) {
        if (cb5 != null) {
            return new IGroupInfoForJoinCallback() { // from class: com.tencent.qqnt.kernel.api.impl.br
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupInfoForJoinCallback
                public final void onResult(int i3, String str, GroupInfoForJoinRsp groupInfoForJoinRsp) {
                    BaseService.getCallback$lambda$225$lambda$224(BaseService.this, method, curSeq, cb5, i3, str, groupInfoForJoinRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final ICheckIsBuddyCallback cb5, @NotNull final Function1<? super ICheckIsBuddyCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (T) iPatchRedirector.redirect((short) 84, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().e1(this.subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$74
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICheckIsBuddyCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICheckIsBuddyCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICheckIsBuddyCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICheckIsBuddyCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupPayToJoinStatusCallback getCallback(final String method, final int curSeq, final IGroupPayToJoinStatusCallback cb5) {
        if (cb5 != null) {
            return new IGroupPayToJoinStatusCallback() { // from class: com.tencent.qqnt.kernel.api.impl.el
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupPayToJoinStatusCallback
                public final void onResult(int i3, String str, GroupPayToJoinStatusRsp groupPayToJoinStatusRsp) {
                    BaseService.getCallback$lambda$228$lambda$227(BaseService.this, method, curSeq, cb5, i3, str, groupPayToJoinStatusRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IRcvJoinVerifyMsgCallback cb5, @NotNull final Function1<? super IRcvJoinVerifyMsgCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (T) iPatchRedirector.redirect((short) 85, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().N0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$75
            static IPatchRedirector $redirector_;
            final /* synthetic */ IRcvJoinVerifyMsgCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IRcvJoinVerifyMsgCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IRcvJoinVerifyMsgCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IRcvJoinVerifyMsgCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupMsgLimitFreqCallback getCallback(final String method, final int curSeq, final IGroupMsgLimitFreqCallback cb5) {
        if (cb5 != null) {
            return new IGroupMsgLimitFreqCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ds
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMsgLimitFreqCallback
                public final void onResult(int i3, String str, GroupMsgLimitFreqRsp groupMsgLimitFreqRsp) {
                    BaseService.getCallback$lambda$231$lambda$230(BaseService.this, method, curSeq, cb5, i3, str, groupMsgLimitFreqRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupPrivilegeFlagCallback cb5, @NotNull final Function1<? super IGroupPrivilegeFlagCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (T) iPatchRedirector.redirect((short) 86, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().p0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$76
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupPrivilegeFlagCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupPrivilegeFlagCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupPrivilegeFlagCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupPrivilegeFlagCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupTagRecordCallback getCallback(final String method, final int curSeq, final IGroupTagRecordCallback cb5) {
        if (cb5 != null) {
            return new IGroupTagRecordCallback() { // from class: com.tencent.qqnt.kernel.api.impl.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupTagRecordCallback
                public final void onResult(int i3, String str, GroupTagRecordRsp groupTagRecordRsp) {
                    BaseService.getCallback$lambda$234$lambda$233(BaseService.this, method, curSeq, cb5, i3, str, groupTagRecordRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGroupEssenceMsgSwitchCallback cb5, @NotNull final Function1<? super IGroupEssenceMsgSwitchCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (T) iPatchRedirector.redirect((short) 87, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().c0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$77
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupEssenceMsgSwitchCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupEssenceMsgSwitchCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupEssenceMsgSwitchCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupEssenceMsgSwitchCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupFlagForThirdAppCallback getCallback(final String method, final int curSeq, final IGetGroupFlagForThirdAppCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupFlagForThirdAppCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ey
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupFlagForThirdAppCallback
                public final void onResult(int i3, String str, GetGroupFlagForThirdAppRsp getGroupFlagForThirdAppRsp) {
                    BaseService.getCallback$lambda$237$lambda$236(BaseService.this, method, curSeq, cb5, i3, str, getGroupFlagForThirdAppRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMemberMaxNumCallback cb5, @NotNull final Function1<? super IGroupMemberMaxNumCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return (T) iPatchRedirector.redirect((short) 88, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().k0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$78
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMemberMaxNumCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMemberMaxNumCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMemberMaxNumCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMemberMaxNumCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupInviteNoAuthLimitNumCallback getCallback(final String method, final int curSeq, final IGetGroupInviteNoAuthLimitNumCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupInviteNoAuthLimitNumCallback() { // from class: com.tencent.qqnt.kernel.api.impl.at
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupInviteNoAuthLimitNumCallback
                public final void onResult(int i3, String str, GetGroupInviteNoAuthLimitRsp getGroupInviteNoAuthLimitRsp) {
                    BaseService.getCallback$lambda$240$lambda$239(BaseService.this, method, curSeq, cb5, i3, str, getGroupInviteNoAuthLimitRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGroupSecLevelInfoCallback cb5, @NotNull final Function1<? super IGroupSecLevelInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return (T) iPatchRedirector.redirect((short) 89, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().r0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$79
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupSecLevelInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupSecLevelInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupSecLevelInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupSecLevelInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IModifyGroupExtCallback getCallback(final String method, final int curSeq, final IModifyGroupExtCallback cb5) {
        if (cb5 != null) {
            return new IModifyGroupExtCallback() { // from class: com.tencent.qqnt.kernel.api.impl.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IModifyGroupExtCallback
                public final void onResult(int i3, String str, ModifyGroupExtResult modifyGroupExtResult) {
                    BaseService.getCallback$lambda$243$lambda$242(BaseService.this, method, curSeq, cb5, i3, str, modifyGroupExtResult);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGroupAvatarWallCallback cb5, @NotNull final Function1<? super IGroupAvatarWallCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return (T) iPatchRedirector.redirect((short) 90, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().a0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$80
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupAvatarWallCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupAvatarWallCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupAvatarWallCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupAvatarWallCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupLatestEssenceListCallback getCallback(final String method, final int curSeq, final IGetGroupLatestEssenceListCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupLatestEssenceListCallback() { // from class: com.tencent.qqnt.kernel.api.impl.fm
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupLatestEssenceListCallback
                public final void onResult(int i3, String str, GetGroupLatestEssenceListRsp getGroupLatestEssenceListRsp) {
                    BaseService.getCallback$lambda$246$lambda$245(BaseService.this, method, curSeq, cb5, i3, str, getGroupLatestEssenceListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupInfoForGrayTipsCallback cb5, @NotNull final Function1<? super IGroupInfoForGrayTipsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return (T) iPatchRedirector.redirect((short) 91, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().d0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$81
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupInfoForGrayTipsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupInfoForGrayTipsCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupInfoForGrayTipsCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupInfoForGrayTipsCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDigestCallback getCallback(final String method, final int curSeq, final IDigestCallback cb5) {
        if (cb5 != null) {
            return new IDigestCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cf
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDigestCallback
                public final void onResult(int i3, String str, DigestRsp digestRsp) {
                    BaseService.getCallback$lambda$249$lambda$248(BaseService.this, method, curSeq, cb5, i3, str, digestRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupInfoForJoinCallback cb5, @NotNull final Function1<? super IGroupInfoForJoinCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return (T) iPatchRedirector.redirect((short) 92, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().e0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$82
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupInfoForJoinCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupInfoForJoinCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupInfoForJoinCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupInfoForJoinCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICheckEssenceCallback getCallback(final String method, final int curSeq, final ICheckEssenceCallback cb5) {
        if (cb5 != null) {
            return new ICheckEssenceCallback() { // from class: com.tencent.qqnt.kernel.api.impl.eg
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckEssenceCallback
                public final void onResult(boolean z16) {
                    BaseService.getCallback$lambda$252$lambda$251(BaseService.this, method, curSeq, cb5, z16);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupPayToJoinStatusCallback cb5, @NotNull final Function1<? super IGroupPayToJoinStatusCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return (T) iPatchRedirector.redirect((short) 93, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().o0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$83
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupPayToJoinStatusCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupPayToJoinStatusCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupPayToJoinStatusCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupPayToJoinStatusCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQueryCachedEssenceCallback getCallback(final String method, final int curSeq, final IQueryCachedEssenceCallback cb5) {
        if (cb5 != null) {
            return new IQueryCachedEssenceCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bd
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryCachedEssenceCallback
                public final void onResult(ArrayList arrayList) {
                    BaseService.getCallback$lambda$255$lambda$254(BaseService.this, method, curSeq, cb5, arrayList);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGroupMsgLimitFreqCallback cb5, @NotNull final Function1<? super IGroupMsgLimitFreqCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return (T) iPatchRedirector.redirect((short) 94, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().n0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$84
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupMsgLimitFreqCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupMsgLimitFreqCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupMsgLimitFreqCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupMsgLimitFreqCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGroupExt0xEF0InfoCallback getCallback(final String method, final int curSeq, final IGroupExt0xEF0InfoCallback cb5) {
        if (cb5 != null) {
            return new IGroupExt0xEF0InfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.dl
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupExt0xEF0InfoCallback
                public final void onResult(int i3, String str, GroupExt0xEF0InfoRsp groupExt0xEF0InfoRsp) {
                    BaseService.getCallback$lambda$258$lambda$257(BaseService.this, method, curSeq, cb5, i3, str, groupExt0xEF0InfoRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGroupTagRecordCallback cb5, @NotNull final Function1<? super IGroupTagRecordCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (T) iPatchRedirector.redirect((short) 95, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().s0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$85
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGroupTagRecordCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGroupTagRecordCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGroupTagRecordCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGroupTagRecordCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IBatchQueryCachedGroupDetailInfoCallback getCallback(final String method, final int curSeq, final IBatchQueryCachedGroupDetailInfoCallback cb5) {
        if (cb5 != null) {
            return new IBatchQueryCachedGroupDetailInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.an
                @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchQueryCachedGroupDetailInfoCallback
                public final void onResult(ArrayList arrayList) {
                    BaseService.getCallback$lambda$261$lambda$260(BaseService.this, method, curSeq, cb5, arrayList);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGetGroupFlagForThirdAppCallback cb5, @NotNull final Function1<? super IGetGroupFlagForThirdAppCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return (T) iPatchRedirector.redirect((short) 96, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().x(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$86
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupFlagForThirdAppCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupFlagForThirdAppCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupFlagForThirdAppCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupFlagForThirdAppCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetHomeHeadCallback getCallback(final String method, final int curSeq, final IGetHomeHeadCallback cb5) {
        if (cb5 != null) {
            return new IGetHomeHeadCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ca
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetHomeHeadCallback
                public final void onResult(int i3, String str, GetHomeHeadRsp getHomeHeadRsp) {
                    BaseService.getCallback$lambda$264$lambda$263(BaseService.this, method, curSeq, cb5, i3, str, getHomeHeadRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IGetGroupInviteNoAuthLimitNumCallback cb5, @NotNull final Function1<? super IGetGroupInviteNoAuthLimitNumCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return (T) iPatchRedirector.redirect((short) 97, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().y(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$87
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupInviteNoAuthLimitNumCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupInviteNoAuthLimitNumCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupInviteNoAuthLimitNumCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupInviteNoAuthLimitNumCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSquareRedpointInfoCallback getCallback(final String method, final int curSeq, final IGetGroupSquareRedpointInfoCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSquareRedpointInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.r
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSquareRedpointInfoCallback
                public final void onResult(int i3, String str, GetGroupSquareRedpointInfoRsp getGroupSquareRedpointInfoRsp) {
                    BaseService.getCallback$lambda$267$lambda$266(BaseService.this, method, curSeq, cb5, i3, str, getGroupSquareRedpointInfoRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IModifyGroupExtCallback cb5, @NotNull final Function1<? super IModifyGroupExtCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return (T) iPatchRedirector.redirect((short) 98, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().E0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$88
            static IPatchRedirector $redirector_;
            final /* synthetic */ IModifyGroupExtCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IModifyGroupExtCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IModifyGroupExtCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IModifyGroupExtCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetRecGroupsCallback getCallback(final String method, final int curSeq, final IGetRecGroupsCallback cb5) {
        if (cb5 != null) {
            return new IGetRecGroupsCallback() { // from class: com.tencent.qqnt.kernel.api.impl.cx
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRecGroupsCallback
                public final void onResult(int i3, String str, GetRecGroupsRsp getRecGroupsRsp) {
                    BaseService.getCallback$lambda$270$lambda$269(BaseService.this, method, curSeq, cb5, i3, str, getRecGroupsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupLatestEssenceListCallback cb5, @NotNull final Function1<? super IGetGroupLatestEssenceListCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (T) iPatchRedirector.redirect((short) 99, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().z(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$89
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupLatestEssenceListCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupLatestEssenceListCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupLatestEssenceListCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupLatestEssenceListCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetTopicPageCallback getCallback(final String method, final int curSeq, final IGetTopicPageCallback cb5) {
        if (cb5 != null) {
            return new IGetTopicPageCallback() { // from class: com.tencent.qqnt.kernel.api.impl.db
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTopicPageCallback
                public final void onResult(int i3, String str, GetTopicPageRsp getTopicPageRsp) {
                    BaseService.getCallback$lambda$273$lambda$272(BaseService.this, method, curSeq, cb5, i3, str, getTopicPageRsp);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IDigestCallback cb5, @NotNull final Function1<? super IDigestCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return (T) iPatchRedirector.redirect((short) 100, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().m(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$90
            static IPatchRedirector $redirector_;
            final /* synthetic */ IDigestCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IDigestCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IDigestCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IDigestCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICheckIsBuddyCallback getCallback(final String method, final int curSeq, final ICheckIsBuddyCallback cb5) {
        if (cb5 != null) {
            return new ICheckIsBuddyCallback() { // from class: com.tencent.qqnt.kernel.api.impl.bk
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckIsBuddyCallback
                public final void onResult(String str, boolean z16) {
                    BaseService.getCallback$lambda$276$lambda$275(BaseService.this, method, curSeq, cb5, str, z16);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final ICheckEssenceCallback cb5, @NotNull final Function1<? super ICheckEssenceCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (T) iPatchRedirector.redirect((short) 101, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().g(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$91
            static IPatchRedirector $redirector_;
            final /* synthetic */ ICheckEssenceCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<ICheckEssenceCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                ICheckEssenceCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<ICheckEssenceCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IModifyCategoryCallback getCallback(final String method, final int curSeq, final IModifyCategoryCallback cb5) {
        if (cb5 != null) {
            return new IModifyCategoryCallback() { // from class: com.tencent.qqnt.kernel.api.impl.gp
                @Override // com.tencent.qqnt.kernel.nativeinterface.IModifyCategoryCallback
                public final void onResult(int i3, String str, byte[] bArr, String str2, int i16) {
                    BaseService.getCallback$lambda$279$lambda$278(BaseService.this, method, curSeq, cb5, i3, str, bArr, str2, i16);
                }
            };
        }
        return null;
    }

    @Nullable
    protected final <T> T check(@NotNull final String method, @Nullable final IQueryCachedEssenceCallback cb5, @NotNull final Function1<? super IQueryCachedEssenceCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (T) iPatchRedirector.redirect((short) 102, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().L0(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$92
            static IPatchRedirector $redirector_;
            final /* synthetic */ IQueryCachedEssenceCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IQueryCachedEssenceCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IQueryCachedEssenceCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IQueryCachedEssenceCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGetGroupSchoolToolboxInfoCallback getCallback(final String method, final int curSeq, final IGetGroupSchoolToolboxInfoCallback cb5) {
        if (cb5 != null) {
            return new IGetGroupSchoolToolboxInfoCallback() { // from class: com.tencent.qqnt.kernel.api.impl.de
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolToolboxInfoCallback
                public final void onResult(int i3, String str, GroupSchoolToolboxInfoRsp groupSchoolToolboxInfoRsp) {
                    BaseService.getCallback$lambda$282$lambda$281(BaseService.this, method, curSeq, cb5, i3, str, groupSchoolToolboxInfoRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetHomeHeadCallback cb5, @NotNull final Function1<? super IGetHomeHeadCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (T) iPatchRedirector.redirect((short) 103, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().O(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$93
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetHomeHeadCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetHomeHeadCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetHomeHeadCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetHomeHeadCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSquareRedpointInfoCallback cb5, @NotNull final Function1<? super IGetGroupSquareRedpointInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            return (T) iPatchRedirector.redirect((short) 104, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().L(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$94
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSquareRedpointInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSquareRedpointInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSquareRedpointInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSquareRedpointInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetRecGroupsCallback cb5, @NotNull final Function1<? super IGetRecGroupsCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return (T) iPatchRedirector.redirect((short) 105, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().U(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$95
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetRecGroupsCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetRecGroupsCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetRecGroupsCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetRecGroupsCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetTopicPageCallback cb5, @NotNull final Function1<? super IGetTopicPageCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            return (T) iPatchRedirector.redirect((short) 106, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().Z(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$96
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetTopicPageCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetTopicPageCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetTopicPageCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetTopicPageCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T check(@NotNull final String method, @Nullable final IGetGroupSchoolToolboxInfoCallback cb5, @NotNull final Function1<? super IGetGroupSchoolToolboxInfoCallback, ? extends T> work) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            return (T) iPatchRedirector.redirect((short) 108, this, method, cb5, work);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.e().K(this.subTag, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>(work, this, method, cb5) { // from class: com.tencent.qqnt.kernel.api.impl.BaseService$check$97
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetGroupSchoolToolboxInfoCallback $cb;
            final /* synthetic */ String $method;
            final /* synthetic */ Function1<IGetGroupSchoolToolboxInfoCallback, T> $work;
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$work = work;
                this.this$0 = this;
                this.$method = method;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, work, this, method, cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                IGetGroupSchoolToolboxInfoCallback callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (T) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
                Function1<IGetGroupSchoolToolboxInfoCallback, T> function1 = this.$work;
                callback = this.this$0.getCallback(this.$method, i3, this.$cb);
                return function1.invoke(callback);
            }
        });
    }
}
