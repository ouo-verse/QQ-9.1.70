package com.tencent.qqnt.kernel.api.impl;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.AddRobotToGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarInfo;
import com.tencent.qqnt.kernel.nativeinterface.AiGenAvatarReq;
import com.tencent.qqnt.kernel.nativeinterface.AiGenBotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.AiGenTemplateInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchBotGetReq;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetBotsMenuResponse;
import com.tencent.qqnt.kernel.nativeinterface.BotsMenuRequest;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotReq;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRequest;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.kernel.nativeinterface.FetchAiGenTemplateInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.FetchShareInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.FetchShareInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.FetchUgcSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.GProAddGuildRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProFetchGuildRobotDirectMsgSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.GProFetchGuildRobotDirectMsgSettingRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotDownMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineSearchReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineSearchRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotSetPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProQueryGlobalRobotSubscriptionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProQueryGlobalRobotSubscriptionRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProSetGuildRobotDirectMsgSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.GProSubscribeGlobalRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupCmd0xce5Req;
import com.tencent.qqnt.kernel.nativeinterface.GroupCmd0xce5Rsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfileReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreCategoryListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreDiscoveryReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreSearchReq;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAiGenAvatarCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAiGenTemplateInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetBotsMenuCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICommandCbCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchAllRobotsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchGuildRobotPlusPanelCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchMyRobotListsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotCoreInfosCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotRecommendCardsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotStoryHalfViewCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchShareInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchSubcribeMsgTemplateStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchSubscribeMsgTemplateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFetchUgcSettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProAudioLiveRobotStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotDirectMsgSettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAddRobotGroupListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotCardRecommendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotInlineSearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetRobotFunctionsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupRobotInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService;
import com.tencent.qqnt.kernel.nativeinterface.IListRobotCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMyBotInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryGuildGlobalRobotSubscriptionCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRecentUsedRobotsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotCommonCallBack;
import com.tencent.qqnt.kernel.nativeinterface.IRobotShareLimitCallBack;
import com.tencent.qqnt.kernel.nativeinterface.IRobotStoreCategoryListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotStoreSearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotUinRangeCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISendCommonRobotCallBack;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRobotMessagePushCallback;
import com.tencent.qqnt.kernel.nativeinterface.IShareArkInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback;
import com.tencent.qqnt.kernel.nativeinterface.ListRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.ListRobotRsp;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListReq;
import com.tencent.qqnt.kernel.nativeinterface.MyRobotsListRsp;
import com.tencent.qqnt.kernel.nativeinterface.QueryAddRobotGroupListReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataReq;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateReq;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateRsp;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecentUsedRobotsReq;
import com.tencent.qqnt.kernel.nativeinterface.RecentUsedRobotsRsp;
import com.tencent.qqnt.kernel.nativeinterface.RemoveRobotFromGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.ResetRobotConversationRq;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotAuthRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotCategoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotMsgPushSetReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardsRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotRemoveFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotSelectAIModelReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareLimitReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotStoryActionSetReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotTTsConfigReq;
import com.tencent.qqnt.kernel.nativeinterface.RobotUinRangeReq;
import com.tencent.qqnt.kernel.nativeinterface.SaveAIModelReq;
import com.tencent.qqnt.kernel.nativeinterface.SendCommonRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateSetReq;
import com.tencent.qqnt.kernel.nativeinterface.UgcSettingInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fa\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00cf\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u00d0\u0001B\u001e\u0012\t\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u00cc\u0001\u001a\u00030\u00cb\u0001\u00a2\u0006\u0006\b\u00cd\u0001\u0010\u00ce\u0001J\"\u0010\n\u001a\u00020\t2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u001fH\u0016J\u001a\u0010#\u001a\u00020\t2\u0006\u0010\f\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010$\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010!2\b\u0010\b\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010&\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010%2\b\u0010\b\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020\t2\u0006\u0010\f\u001a\u00020'2\b\u0010\b\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010,\u001a\u00020\t2\u0006\u0010\f\u001a\u00020*2\b\u0010\b\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010/\u001a\u00020\t2\u0006\u0010\f\u001a\u00020-2\b\u0010\b\u001a\u0004\u0018\u00010.H\u0016J\u001a\u00102\u001a\u00020\t2\u0006\u0010\f\u001a\u0002002\b\u0010\b\u001a\u0004\u0018\u000101H\u0016J\u001a\u00105\u001a\u00020\t2\u0006\u0010\f\u001a\u0002032\b\u0010\b\u001a\u0004\u0018\u000104H\u0016J\u001a\u00108\u001a\u00020\t2\u0006\u0010\f\u001a\u0002062\b\u0010\b\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010;\u001a\u00020\t2\u0006\u0010\f\u001a\u0002092\b\u0010\b\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\f\u001a\u00020<2\b\u0010\b\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010A\u001a\u00020\t2\u0006\u0010\f\u001a\u00020?2\b\u0010\b\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010F\u001a\u00020\t2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020DH\u0016J\u0018\u0010I\u001a\u00020\t2\u0006\u0010C\u001a\u00020G2\u0006\u0010E\u001a\u00020HH\u0016J\u0018\u0010L\u001a\u00020\t2\u0006\u0010C\u001a\u00020J2\u0006\u0010E\u001a\u00020KH\u0016J\u001a\u0010O\u001a\u00020\t2\u0006\u0010\f\u001a\u00020M2\b\u0010\b\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010R\u001a\u00020\t2\u0006\u0010\f\u001a\u00020P2\b\u0010\b\u001a\u0004\u0018\u00010QH\u0016J\u001a\u0010U\u001a\u00020\t2\u0006\u0010\f\u001a\u00020S2\b\u0010\b\u001a\u0004\u0018\u00010TH\u0016J\u001c\u0010X\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010V2\b\u0010\b\u001a\u0004\u0018\u00010WH\u0016J\u001a\u0010[\u001a\u00020\t2\u0006\u0010\f\u001a\u00020Y2\b\u0010\b\u001a\u0004\u0018\u00010ZH\u0016J\u001c\u0010^\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\\2\b\u0010\b\u001a\u0004\u0018\u00010]H\u0016J\u001a\u0010a\u001a\u00020\t2\u0006\u0010\f\u001a\u00020_2\b\u0010\b\u001a\u0004\u0018\u00010`H\u0016J\u001a\u0010d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020b2\b\u0010\b\u001a\u0004\u0018\u00010cH\u0016J\u001a\u0010g\u001a\u00020\t2\u0006\u0010\f\u001a\u00020e2\b\u0010\b\u001a\u0004\u0018\u00010fH\u0016J\u001a\u0010j\u001a\u00020\t2\u0006\u0010\f\u001a\u00020h2\b\u0010\b\u001a\u0004\u0018\u00010iH\u0016J\u001a\u0010m\u001a\u00020\t2\u0006\u0010\f\u001a\u00020k2\b\u0010\b\u001a\u0004\u0018\u00010lH\u0016J\u001a\u0010o\u001a\u00020\t2\u0006\u0010\f\u001a\u00020n2\b\u0010\b\u001a\u0004\u0018\u00010iH\u0016J\u001a\u0010q\u001a\u00020\t2\u0006\u0010\f\u001a\u00020p2\b\u0010\b\u001a\u0004\u0018\u00010iH\u0016J\u001a\u0010t\u001a\u00020\t2\u0006\u0010\f\u001a\u00020r2\b\u0010\b\u001a\u0004\u0018\u00010sH\u0016J\u001c\u0010w\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010u2\b\u0010\b\u001a\u0004\u0018\u00010vH\u0016J\u001a\u0010z\u001a\u00020\t2\u0006\u0010\f\u001a\u00020x2\b\u0010\b\u001a\u0004\u0018\u00010yH\u0016J\u001a\u0010|\u001a\u00020\t2\u0006\u0010\f\u001a\u00020{2\b\u0010\b\u001a\u0004\u0018\u00010iH\u0016J\u001a\u0010\u007f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020}2\b\u0010\b\u001a\u0004\u0018\u00010~H\u0016J\u001d\u0010\u0082\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u0080\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\u001c\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u0083\u00012\b\u0010\b\u001a\u0004\u0018\u00010iH\u0016J\u001d\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u0085\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u001b\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u0088\u00012\u0007\u0010\b\u001a\u00030\u0089\u0001H\u0016J\u001d\u0010\u008b\u0001\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010!2\b\u0010\b\u001a\u0004\u0018\u00010\"H\u0016J \u0010\u008f\u0001\u001a\u00020\t2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0015\u0010\u0092\u0001\u001a\u00020\u00172\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\t2\u0007\u0010\u0093\u0001\u001a\u00020\u0017H\u0016J\u0010\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010\u0004H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0017H\u0016J\u0014\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0014\u0010\u009a\u0001\u001a\u00020\t2\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J(\u0010\u00a0\u0001\u001a\u00020\t2\b\u0010\u009c\u0001\u001a\u00030\u009b\u00012\b\u0010\u009e\u0001\u001a\u00030\u009d\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\u001d\u0010\u00a3\u0001\u001a\u00020\t2\u0007\u0010C\u001a\u00030\u00a1\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00a2\u0001H\u0016J\u001d\u0010\u00a5\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u00a4\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\u001a\u0010\u00a7\u0001\u001a\u00020\t2\u0007\u0010\f\u001a\u00030\u00a6\u00012\u0006\u0010\b\u001a\u00020\u001fH\u0016J \u0010\u00ab\u0001\u001a\u00020\t2\n\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a8\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00aa\u0001H\u0016J \u0010\u00ae\u0001\u001a\u00020\t2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00ac\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00aa\u0001H\u0016J \u0010\u00b2\u0001\u001a\u00020\t2\n\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00af\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00b1\u0001H\u0016J\u0014\u0010\u00b3\u0001\u001a\u00020\t2\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J \u0010\u00b7\u0001\u001a\u00020\t2\n\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b4\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00b6\u0001H\u0016J\u001f\u0010\u00ba\u0001\u001a\u00020\t2\t\u0010C\u001a\u0005\u0018\u00010\u00b8\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00b9\u0001H\u0016J\u001f\u0010\u00bd\u0001\u001a\u00020\t2\t\u0010C\u001a\u0005\u0018\u00010\u00bb\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00bc\u0001H\u0016J&\u0010\u00bf\u0001\u001a\u00020\t2\u0010\u0010\u00be\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u00042\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\u001f\u0010\u00c2\u0001\u001a\u00020\t2\t\u0010C\u001a\u0005\u0018\u00010\u00c0\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u00c1\u0001H\u0016J\u001d\u0010\u00c4\u0001\u001a\u00020\t2\u0007\u0010C\u001a\u00030\u00c3\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\u001d\u0010\u00c5\u0001\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u001fH\u0016J\u001f\u0010\u00c7\u0001\u001a\u00020\t2\t\u0010\f\u001a\u0005\u0018\u00010\u00c6\u00012\t\u0010\b\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\u001e\u0010\u00c9\u0001\u001a\u00020\t2\t\u0010\f\u001a\u0005\u0018\u00010\u00c8\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u001fH\u0016\u00a8\u0006\u00d1\u0001"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/RobotService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotService;", "Lcom/tencent/qqnt/kernel/api/ac;", "Ljava/util/ArrayList;", "", "uids", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchRobotCoreInfosCallback;", "cb", "", "batchFetchRobotCoreInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/FetchShareInfoReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchShareInfoCallback;", "fetchShareInfo", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchBotGetReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetRobotFunctionsCallback;", "getRobotFunctions", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotUinRangeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotUinRangeCallback;", "getRobotUinRange", "", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/IShareArkInfoCallback;", "fetchShareArkInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/BotsMenuRequest;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetBotsMenuCallback;", "batchGetBotsMenu", "Lcom/tencent/qqnt/kernel/nativeinterface/CommandCbRequest;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICommandCbCallback;", "commandCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfileReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "fetchGroupRobotProfile", "fetchGroupRobotProfileWithReq", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureReq;", "fetchRobotFeatureWithReq", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotMsgPushSetReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetRobotMessagePushCallback;", "setRobotMessagePush", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotAddFriendRequest;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;", QQFriendJsPlugin.API_ADD_FRIEND, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRemoveFriendRequest;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRemoveFriendCallback;", "removeFriend", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotAuthRequest;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotAuthCallback;", "robotAuth", "Lcom/tencent/qqnt/kernel/nativeinterface/AddRobotToGroupReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAddRobotToGroupCallback;", "setAddRobotToGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/RemoveRobotFromGroupReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetRemoveRobotFromGroupCallback;", "setRemoveRobotFromGroup", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryAddRobotGroupListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAddRobotGroupListCallback;", "fetchAddRobotGroupList", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotShareLimitReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotShareLimitCallBack;", "fetchRobotShareLimit", "Lcom/tencent/qqnt/kernel/nativeinterface/SendCommonRobotReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ISendCommonRobotCallBack;", "sendCommonRobotToGuild", "Lcom/tencent/qqnt/kernel/nativeinterface/QuerySubscribeMsgTemplateReq;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchSubscribeMsgTemplateCallback;", "callback", "FetchSubscribeMsgTemplate", "Lcom/tencent/qqnt/kernel/nativeinterface/QuerySubscribeMsgTemplateStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchSubcribeMsgTemplateStatusCallback;", "FetchSubcribeMsgTemplateStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/SubscribeMsgTemplateSetReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotCommonCallBack;", "SubscribeMsgTemplateSet", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreDiscoveryReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupRobotStoreDiscoveryCallback;", "fetchGroupRobotStoreDiscovery", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreSearchReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotStoreSearchCallback;", "sendGroupRobotStoreSearch", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreCategoryListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotStoreCategoryListCallback;", "fetchGroupRobotStoreCategoryList", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IListRobotCallback;", "fetchListRobot", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentUsedRobotsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IRecentUsedRobotsCallback;", "fetchRecentUsedRobots", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchGuildRobotPlusPanelCallback;", "fetchGuildRobotPlusPanel", "Lcom/tencent/qqnt/kernel/nativeinterface/GProRobotCommonGuildReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGProFetchRobotCommonGuildCallback;", "fetchRobotCommonGuild", "Lcom/tencent/qqnt/kernel/nativeinterface/GProAudioLiveRobotStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGProAudioLiveRobotStatusCallback;", "getAudioLiveRobotStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPermissionReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGProFetchGuildRobotPermissionCallback;", "fetchGuildRobotPermission", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotSetPermissionReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGProRobotSimpleResultCallback;", "setGuildRobotPermission", "Lcom/tencent/qqnt/kernel/nativeinterface/GProFetchGuildRobotDirectMsgSettingReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGProFetchGuildRobotDirectMsgSettingCallback;", "fetchGuildRobotDirectMsgSetting", "Lcom/tencent/qqnt/kernel/nativeinterface/GProSetGuildRobotDirectMsgSettingReq;", "setGuildRobotDirectMsgSetting", "Lcom/tencent/qqnt/kernel/nativeinterface/GProAddGuildRobotReq;", "addGuildRobot", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGetGuildRobotListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildRobotListCallback;", "getGuildRobotList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupCmd0xce5Req;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupRobotInfoCallback;", "FetchGroupRobotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotUpMicReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IUpMicGuildRobotCallback;", "upMicGuildRobot", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotDownMicReq;", "downMicGuildRobot", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInlineSearchReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildRobotInlineSearchCallback;", "getGuildRobotInlineSearch", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotCardRecommendReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildRobotCardRecommendCallback;", "getGuildRobotCardRecommend", "Lcom/tencent/qqnt/kernel/nativeinterface/GProSubscribeGlobalRobotReq;", "subscribeGuildGlobalRobot", "Lcom/tencent/qqnt/kernel/nativeinterface/GProQueryGlobalRobotSubscriptionReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryGuildGlobalRobotSubscriptionCallback;", "queryGuildGlobalRobotSubscription", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGProFetchGuildRobotInfoCallback;", "fetchGuildRobotInfo", "getGroupRobotProfile", "uid", "", "profileBuf", "updateGroupRobotProfile", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "listener", "addKernelRobotListener", "listenerId", "removeKernelRobotListener", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "getAllRobotFriendsFromCache", "getAllRobotFriendsCountFromCache", "getRobotFriendsFromCacheWithUin", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "removeAllRecommendCache", "", "restart", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCategoryInfo;", "categoryInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchAllRobotsCallback;", "fetchAllRobots", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchRobotRecommendCardsCallback;", "fetchMobileRobotRecommendCards", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTTsConfigReq;", "setRobotTTsConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/ResetRobotConversationRq;", "resetConversation", "Lcom/tencent/qqnt/kernel/nativeinterface/AiGenBotInfoReq;", "aiGenBotInfoReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IMyBotInfoCallback;", "aiGenBotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ChangeMyBotReq;", "changeMyBotReq", "changeMyBot", "Lcom/tencent/qqnt/kernel/nativeinterface/FetchAiGenTemplateInfoReq;", "fetchAiGenTemplateInfoReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IAiGenTemplateInfoCallback;", "fetchAiGenTemplateInfo", "checkMyBotNum", "Lcom/tencent/qqnt/kernel/nativeinterface/AiGenAvatarReq;", "aiGenAvatarReq", "Lcom/tencent/qqnt/kernel/nativeinterface/IAiGenAvatarCallback;", "aiGenAvatar", "Lcom/tencent/qqnt/kernel/nativeinterface/MyRobotsListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchMyRobotListsCallback;", "fetchMyRobotLists", "Lcom/tencent/qqnt/kernel/nativeinterface/FetchUgcSettingReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchUgcSettingCallback;", "fetchUgcSetting", "pbs", "backFlowRobotCoreInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFetchRobotStoryHalfViewCallback;", "fetchRobotStoryHalfViewData", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotStoryActionSetReq;", "reportRobotStoryActionData", "setRobotStoryEnter", "Lcom/tencent/qqnt/kernel/nativeinterface/SaveAIModelReq;", "saveSelectedAIModelOrOptIds", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotSelectAIModelReq;", "selectAIModel", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RobotService extends BaseService<IKernelRobotService, IKernelRobotService> implements com.tencent.qqnt.kernel.api.ac {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/RobotService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.RobotService$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 74)) {
            redirector.redirect((short) 74);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotService(@Nullable IKernelRobotService iKernelRobotService, @NotNull py content) {
        super("RobotService", content, iKernelRobotService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelRobotService, (Object) content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A5(IQueryGuildGlobalRobotSubscriptionCallback iQueryGuildGlobalRobotSubscriptionCallback, int i3, String str) {
        if (iQueryGuildGlobalRobotSubscriptionCallback != null) {
            iQueryGuildGlobalRobotSubscriptionCallback.onQueryGuildGlobalRobotSubscription(i3, str, new GProQueryGlobalRobotSubscriptionRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B5(IOperateCallback iOperateCallback, int i3, String str) {
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C5(ICommandCbCallback cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.onResult(i3, str, new CommandCbRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D5(ICommandCbCallback iCommandCbCallback, int i3, String str) {
        if (iCommandCbCallback != null) {
            iCommandCbCallback.onResult(i3, str, new CommandCbRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E5(IUpMicGuildRobotCallback iUpMicGuildRobotCallback, int i3, String str) {
        if (iUpMicGuildRobotCallback != null) {
            iUpMicGuildRobotCallback.onUpMicGuildRobot(i3, str, new GProGuildRobotUpMicRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X4(IGroupRobotInfoCallback iGroupRobotInfoCallback, int i3, String str) {
        if (iGroupRobotInfoCallback != null) {
            iGroupRobotInfoCallback.onResult(i3, str, new GroupCmd0xce5Rsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y4(IFetchSubcribeMsgTemplateStatusCallback callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onResult(i3, str, new QuerySubscribeMsgTemplateStatusRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z4(IFetchSubscribeMsgTemplateCallback callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onResult(i3, str, new QuerySubscribeMsgTemplateRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a5(IRobotCommonCallBack callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b5(IAiGenAvatarCallback iAiGenAvatarCallback, int i3, String str) {
        if (iAiGenAvatarCallback != null) {
            iAiGenAvatarCallback.onResult(i3, str, new AiAvatarInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c5(IMyBotInfoCallback iMyBotInfoCallback, int i3, String str) {
        if (iMyBotInfoCallback != null) {
            iMyBotInfoCallback.onResult(i3, str, new MyBotInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d5(IOperateCallback iOperateCallback, int i3, String str) {
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e5(IBatchGetBotsMenuCallback cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.onResult(i3, str, new BatchGetBotsMenuResponse());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f5(IMyBotInfoCallback iMyBotInfoCallback, int i3, String str) {
        if (iMyBotInfoCallback != null) {
            iMyBotInfoCallback.onResult(i3, str, new MyBotInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g5(IOperateCallback iOperateCallback, int i3, String str) {
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h5(ICommandCbCallback cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.onResult(i3, str, new CommandCbRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i5(IAiGenTemplateInfoCallback iAiGenTemplateInfoCallback, int i3, String str) {
        if (iAiGenTemplateInfoCallback != null) {
            iAiGenTemplateInfoCallback.onResult(i3, str, new AiGenTemplateInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j5(IFetchAllRobotsCallback iFetchAllRobotsCallback, int i3, String str) {
        if (iFetchAllRobotsCallback != null) {
            iFetchAllRobotsCallback.onResult(i3, str, new ArrayList<>(), new ArrayList<>(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k5(IGProFetchGuildRobotDirectMsgSettingCallback iGProFetchGuildRobotDirectMsgSettingCallback, int i3, String str) {
        if (iGProFetchGuildRobotDirectMsgSettingCallback != null) {
            iGProFetchGuildRobotDirectMsgSettingCallback.onFetchGuildRobotDirectMsgSetting(i3, str, new GProFetchGuildRobotDirectMsgSettingRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l5(IGProFetchGuildRobotInfoCallback cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.onFetchGuildRobotInfo(i3, str, new GProGuildRobotInfoRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m5(IGProFetchGuildRobotPermissionCallback iGProFetchGuildRobotPermissionCallback, int i3, String str) {
        if (iGProFetchGuildRobotPermissionCallback != null) {
            iGProFetchGuildRobotPermissionCallback.onFetchGuildRobotPermission(i3, str, new GProGuildRobotPermissionRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n5(IFetchGuildRobotPlusPanelCallback iFetchGuildRobotPlusPanelCallback, int i3, String str) {
        if (iFetchGuildRobotPlusPanelCallback != null) {
            iFetchGuildRobotPlusPanelCallback.onResult(i3, str, new GProGuildRobotPlusPanelRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o5(IListRobotCallback iListRobotCallback, int i3, String str) {
        if (iListRobotCallback != null) {
            iListRobotCallback.onResult(i3, str, new ListRobotRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p5(IFetchRobotRecommendCardsCallback iFetchRobotRecommendCardsCallback, int i3, String str) {
        if (iFetchRobotRecommendCardsCallback != null) {
            iFetchRobotRecommendCardsCallback.onResult(i3, str, new RobotRecommendCardsRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q5(IFetchMyRobotListsCallback iFetchMyRobotListsCallback, int i3, String str) {
        if (iFetchMyRobotListsCallback != null) {
            iFetchMyRobotListsCallback.onResult(i3, str, new MyRobotsListRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r5(IRecentUsedRobotsCallback iRecentUsedRobotsCallback, int i3, String str) {
        if (iRecentUsedRobotsCallback != null) {
            iRecentUsedRobotsCallback.onResult(i3, str, new RecentUsedRobotsRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s5(IGProFetchRobotCommonGuildCallback iGProFetchRobotCommonGuildCallback, int i3, String str) {
        if (iGProFetchRobotCommonGuildCallback != null) {
            iGProFetchRobotCommonGuildCallback.onFetchRobotCommonGuild(i3, str, new GProRobotCommonGuildRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t5(IFetchRobotStoryHalfViewCallback iFetchRobotStoryHalfViewCallback, int i3, String str) {
        if (iFetchRobotStoryHalfViewCallback != null) {
            iFetchRobotStoryHalfViewCallback.onResult(i3, str, new QueryHalfViewDataRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u5(IFetchShareInfoCallback cb5, int i3, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.onResult(i3, str, new FetchShareInfoRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v5(IFetchUgcSettingCallback iFetchUgcSettingCallback, int i3, String str) {
        if (iFetchUgcSettingCallback != null) {
            iFetchUgcSettingCallback.onResult(i3, str, new UgcSettingInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w5(IGProAudioLiveRobotStatusCallback iGProAudioLiveRobotStatusCallback, int i3, String str) {
        if (iGProAudioLiveRobotStatusCallback != null) {
            iGProAudioLiveRobotStatusCallback.onResult(i3, str, new GProAudioLiveRobotStatusRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x5(IGetGuildRobotCardRecommendCallback iGetGuildRobotCardRecommendCallback, int i3, String str) {
        if (iGetGuildRobotCardRecommendCallback != null) {
            iGetGuildRobotCardRecommendCallback.onGetGuildRobotCardRecommend(i3, str, new GProGuildRobotCardRecommendRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y5(IGetGuildRobotInlineSearchCallback iGetGuildRobotInlineSearchCallback, int i3, String str) {
        if (iGetGuildRobotInlineSearchCallback != null) {
            iGetGuildRobotInlineSearchCallback.onGetGuildRobotInlineSearch(i3, str, new GProGuildRobotInlineSearchRsp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z5(IGetGuildRobotListCallback iGetGuildRobotListCallback, int i3, String str) {
        if (iGetGuildRobotListCallback != null) {
            iGetGuildRobotListCallback.onGetGuildRobotList(i3, str, new GProGetGuildRobotListRsp());
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void FetchGroupRobotInfo(@Nullable GroupCmd0xce5Req req, @Nullable final IGroupRobotInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) req, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "FetchGroupRobotInfo")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ln
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.X4(IGroupRobotInfoCallback.this, i3, str);
                }
            }, new RobotService$FetchGroupRobotInfo$2(this, req, "FetchGroupRobotInfo", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void FetchSubcribeMsgTemplateStatus(@NotNull QuerySubscribeMsgTemplateStatusReq request, @NotNull final IFetchSubcribeMsgTemplateStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) request, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchSubscribeMsgTemplateStatus")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ls
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.Y4(IFetchSubcribeMsgTemplateStatusCallback.this, i3, str);
            }
        }, new RobotService$FetchSubcribeMsgTemplateStatus$2(this, request, "fetchSubscribeMsgTemplateStatus", callback));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void FetchSubscribeMsgTemplate(@NotNull QuerySubscribeMsgTemplateReq request, @NotNull final IFetchSubscribeMsgTemplateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) request, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchSubscribeMsgTemplate")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mb
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.Z4(IFetchSubscribeMsgTemplateCallback.this, i3, str);
            }
        }, new RobotService$FetchSubscribeMsgTemplate$2(this, request, "fetchSubscribeMsgTemplate", callback));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void SubscribeMsgTemplateSet(@NotNull SubscribeMsgTemplateSetReq request, @NotNull final IRobotCommonCallBack callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) request, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "subscribeMsgTemplateSet")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.md
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.a5(IRobotCommonCallBack.this, i3, str);
            }
        }, new RobotService$SubscribeMsgTemplateSet$2(this, request, "subscribeMsgTemplateSet", callback));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void addFriend(@NotNull final RobotAddFriendRequest req, @Nullable IAddFriendCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check(QQFriendJsPlugin.API_ADD_FRIEND, cb5, new Function1<IAddFriendCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$addFriend$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RobotAddFriendRequest $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IAddFriendCallback iAddFriendCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iAddFriendCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addFriend(this.$req, iAddFriendCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void addGuildRobot(@NotNull final GProAddGuildRobotReq req, @Nullable final IGProRobotSimpleResultCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final String str = "addGuildRobot";
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "addGuildRobot")}, new nn(cb5), new Function1<Integer, Unit>(str, cb5, this, req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$addGuildRobot$$inlined$checkEnableWithSimpleCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $methodName;
            final /* synthetic */ IGProRobotSimpleResultCallback $originCallback;
            final /* synthetic */ GProAddGuildRobotReq $req$inlined;
            final /* synthetic */ RobotService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$methodName = str;
                this.$originCallback = cb5;
                this.this$0 = this;
                this.$req$inlined = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, str, cb5, this, req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback = new IGProRobotSimpleResultCallback(this.$methodName, i3, this.$originCallback) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$addGuildRobot$$inlined$checkEnableWithSimpleCallback$1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f357321b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ int f357322c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ IGProRobotSimpleResultCallback f357323d;

                    {
                        this.f357321b = r6;
                        this.f357322c = i3;
                        this.f357323d = r8;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i3), r8);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
                    public final void onResult(int i16, String str2) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, i16, (Object) str2);
                        } else {
                            RobotService robotService = RobotService.this;
                            robotService.postHandle(new Runnable(this.f357321b, i16, str2, this.f357322c, this.f357323d) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$addGuildRobot$.inlined.checkEnableWithSimpleCallback.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f357324d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f357325e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f357326f;

                                /* renamed from: h, reason: collision with root package name */
                                final /* synthetic */ int f357327h;

                                /* renamed from: i, reason: collision with root package name */
                                final /* synthetic */ IGProRobotSimpleResultCallback f357328i;

                                {
                                    this.f357324d = r6;
                                    this.f357325e = i16;
                                    this.f357326f = str2;
                                    this.f357327h = r9;
                                    this.f357328i = r10;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i16), str2, Integer.valueOf(r9), r10);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 2)) {
                                        iPatchRedirector4.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    KLog.f359087a.d(RobotService.this.getSubTag(), new Object[]{TuplesKt.to("method", this.f357324d), TuplesKt.to("result", Integer.valueOf(this.f357325e)), TuplesKt.to("errMsg", this.f357326f)}, Integer.valueOf(this.f357327h));
                                    IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback2 = this.f357328i;
                                    if (iGProRobotSimpleResultCallback2 != null) {
                                        iGProRobotSimpleResultCallback2.onResult(this.f357325e, this.f357326f);
                                    }
                                }
                            });
                        }
                    }
                };
                IKernelRobotService service = this.this$0.getService();
                if (service != null) {
                    service.addGuildRobot(this.$req$inlined, iGProRobotSimpleResultCallback);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public long addKernelRobotListener(@Nullable final IKernelRobotListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Long) iPatchRedirector.redirect((short) 51, (Object) this, (Object) listener)).longValue();
        }
        Long l3 = (Long) check("addKernelRobotListener", new Function0<Long>(listener) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$addKernelRobotListener$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IKernelRobotListener $listener;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$listener = listener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) listener);
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
                IKernelRobotService service = RobotService.this.getService();
                if (service != null) {
                    return Long.valueOf(service.addKernelRobotListener(this.$listener));
                }
                return null;
            }
        });
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void aiGenAvatar(@Nullable AiGenAvatarReq aiGenAvatarReq, @Nullable final IAiGenAvatarCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) aiGenAvatarReq, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "aiGenAvatar")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mj
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.b5(IAiGenAvatarCallback.this, i3, str);
                }
            }, new RobotService$aiGenAvatar$2(this, aiGenAvatarReq, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void aiGenBotInfo(@Nullable AiGenBotInfoReq aiGenBotInfoReq, @Nullable final IMyBotInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) aiGenBotInfoReq, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "aiGenBotInfo")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ms
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.c5(IMyBotInfoCallback.this, i3, str);
                }
            }, new RobotService$aiGenBotInfo$2(this, aiGenBotInfoReq, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void backFlowRobotCoreInfos(@Nullable ArrayList<byte[]> pbs, @Nullable final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) pbs, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "backFlowRobotCoreInfos")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mr
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.d5(IOperateCallback.this, i3, str);
                }
            }, new RobotService$backFlowRobotCoreInfos$2(this, pbs, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void batchFetchRobotCoreInfos(@Nullable final ArrayList<String> uids, @Nullable IFetchRobotCoreInfosCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) cb5);
        } else {
            check("batchFetchRobotCoreInfos", cb5, new Function1<IFetchRobotCoreInfosCallback, Unit>(uids) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$batchFetchRobotCoreInfos$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<String> $uids;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uids = uids;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) uids);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IFetchRobotCoreInfosCallback iFetchRobotCoreInfosCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iFetchRobotCoreInfosCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.batchFetchRobotCoreInfos(this.$uids, iFetchRobotCoreInfosCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void batchGetBotsMenu(@NotNull BotsMenuRequest req, @NotNull final IBatchGetBotsMenuCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "batchGetBotsMenu")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lv
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.e5(IBatchGetBotsMenuCallback.this, i3, str);
            }
        }, new RobotService$batchGetBotsMenu$2(this, req, "batchGetBotsMenu", cb5));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void changeMyBot(@Nullable ChangeMyBotReq changeMyBotReq, @Nullable final IMyBotInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) changeMyBotReq, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "changeMyBot")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lt
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.f5(IMyBotInfoCallback.this, i3, str);
                }
            }, new RobotService$changeMyBot$2(this, changeMyBotReq, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void checkMyBotNum(@Nullable final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "checkMyBotNum")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lp
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.g5(IOperateCallback.this, i3, str);
                }
            }, new RobotService$checkMyBotNum$2(this, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void commandCallback(@NotNull CommandCbRequest req, @NotNull final ICommandCbCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "commandCallback")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ma
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.h5(ICommandCbCallback.this, i3, str);
            }
        }, new RobotService$commandCallback$2(this, req, "commandCallback", cb5));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void downMicGuildRobot(@NotNull final GProGuildRobotDownMicReq req, @Nullable final IGProRobotSimpleResultCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final String str = "downMicGuildRobot";
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "downMicGuildRobot")}, new nn(cb5), new Function1<Integer, Unit>(str, cb5, this, req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$downMicGuildRobot$$inlined$checkEnableWithSimpleCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $methodName;
            final /* synthetic */ IGProRobotSimpleResultCallback $originCallback;
            final /* synthetic */ GProGuildRobotDownMicReq $req$inlined;
            final /* synthetic */ RobotService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$methodName = str;
                this.$originCallback = cb5;
                this.this$0 = this;
                this.$req$inlined = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, str, cb5, this, req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback = new IGProRobotSimpleResultCallback(this.$methodName, i3, this.$originCallback) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$downMicGuildRobot$$inlined$checkEnableWithSimpleCallback$1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f357330b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ int f357331c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ IGProRobotSimpleResultCallback f357332d;

                    {
                        this.f357330b = r6;
                        this.f357331c = i3;
                        this.f357332d = r8;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i3), r8);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
                    public final void onResult(int i16, String str2) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, i16, (Object) str2);
                        } else {
                            RobotService robotService = RobotService.this;
                            robotService.postHandle(new Runnable(this.f357330b, i16, str2, this.f357331c, this.f357332d) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$downMicGuildRobot$.inlined.checkEnableWithSimpleCallback.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f357333d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f357334e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f357335f;

                                /* renamed from: h, reason: collision with root package name */
                                final /* synthetic */ int f357336h;

                                /* renamed from: i, reason: collision with root package name */
                                final /* synthetic */ IGProRobotSimpleResultCallback f357337i;

                                {
                                    this.f357333d = r6;
                                    this.f357334e = i16;
                                    this.f357335f = str2;
                                    this.f357336h = r9;
                                    this.f357337i = r10;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i16), str2, Integer.valueOf(r9), r10);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 2)) {
                                        iPatchRedirector4.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    KLog.f359087a.d(RobotService.this.getSubTag(), new Object[]{TuplesKt.to("method", this.f357333d), TuplesKt.to("result", Integer.valueOf(this.f357334e)), TuplesKt.to("errMsg", this.f357335f)}, Integer.valueOf(this.f357336h));
                                    IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback2 = this.f357337i;
                                    if (iGProRobotSimpleResultCallback2 != null) {
                                        iGProRobotSimpleResultCallback2.onResult(this.f357334e, this.f357335f);
                                    }
                                }
                            });
                        }
                    }
                };
                IKernelRobotService service = this.this$0.getService();
                if (service != null) {
                    service.downMicGuildRobot(this.$req$inlined, iGProRobotSimpleResultCallback);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public /* synthetic */ void editMyRobotSetting(MyRobotSettingReq myRobotSettingReq, IOperateCallback iOperateCallback) {
        com.tencent.qqnt.kernel.nativeinterface.bl.q(this, myRobotSettingReq, iOperateCallback);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchAddRobotGroupList(@NotNull final QueryAddRobotGroupListReq req, @Nullable IGetAddRobotGroupListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("fetchAddRobotGroupList", cb5, new Function1<IGetAddRobotGroupListCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchAddRobotGroupList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QueryAddRobotGroupListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetAddRobotGroupListCallback iGetAddRobotGroupListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetAddRobotGroupListCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchAddRobotGroupList(this.$req, iGetAddRobotGroupListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchAiGenTemplateInfo(@Nullable FetchAiGenTemplateInfoReq fetchAiGenTemplateInfoReq, @Nullable final IAiGenTemplateInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) fetchAiGenTemplateInfoReq, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchAiGenTemplateInfo")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mn
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.i5(IAiGenTemplateInfoCallback.this, i3, str);
                }
            }, new RobotService$fetchAiGenTemplateInfo$2(this, fetchAiGenTemplateInfoReq, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchAllRobots(boolean restart, @NotNull RobotCategoryInfo categoryInfo, @Nullable final IFetchAllRobotsCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, Boolean.valueOf(restart), categoryInfo, cb5);
        } else {
            Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchAllRobots")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.j5(IFetchAllRobotsCallback.this, i3, str);
                }
            }, new RobotService$fetchAllRobots$2(this, restart, categoryInfo, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGroupRobotProfile(@NotNull final GroupRobotProfileReq req, @Nullable IGetGroupRobotProfileCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("fetchGroupRobotProfile", cb5, new Function1<IGetGroupRobotProfileCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchGroupRobotProfile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupRobotProfileReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupRobotProfileCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchGroupRobotProfile(this.$req, iGetGroupRobotProfileCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGroupRobotProfileWithReq(@Nullable final GroupRobotProfileReq req, @Nullable IGetGroupRobotProfileCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) req, (Object) cb5);
        } else {
            check("fetchGroupRobotProfileWithReq", cb5, new Function1<IGetGroupRobotProfileCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchGroupRobotProfileWithReq$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupRobotProfileReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupRobotProfileCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchGroupRobotProfileWithReq(this.$req, iGetGroupRobotProfileCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGroupRobotStoreCategoryList(@NotNull final GroupRobotStoreCategoryListReq req, @Nullable IRobotStoreCategoryListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("fetchGroupRobotStoreCategoryList", cb5, new Function1<IRobotStoreCategoryListCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchGroupRobotStoreCategoryList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupRobotStoreCategoryListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IRobotStoreCategoryListCallback iRobotStoreCategoryListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iRobotStoreCategoryListCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchGroupRobotStoreCategoryList(this.$req, iRobotStoreCategoryListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGroupRobotStoreDiscovery(@NotNull final GroupRobotStoreDiscoveryReq req, @Nullable IGroupRobotStoreDiscoveryCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("fetchGroupRobotStoreDiscovery", cb5, new Function1<IGroupRobotStoreDiscoveryCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchGroupRobotStoreDiscovery$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupRobotStoreDiscoveryReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGroupRobotStoreDiscoveryCallback iGroupRobotStoreDiscoveryCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGroupRobotStoreDiscoveryCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchGroupRobotStoreDiscovery(this.$req, iGroupRobotStoreDiscoveryCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGuildRobotDirectMsgSetting(@NotNull GProFetchGuildRobotDirectMsgSettingReq req, @Nullable final IGProFetchGuildRobotDirectMsgSettingCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchGuildRobotDirectMsgSetting")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.k5(IGProFetchGuildRobotDirectMsgSettingCallback.this, i3, str);
                }
            }, new RobotService$fetchGuildRobotDirectMsgSetting$2(this, req, "fetchGuildRobotDirectMsgSetting", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGuildRobotInfo(@NotNull GProGuildRobotInfoReq req, @NotNull final IGProFetchGuildRobotInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchGuildRobotInfo")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mc
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.l5(IGProFetchGuildRobotInfoCallback.this, i3, str);
            }
        }, new RobotService$fetchGuildRobotInfo$2(this, req, "fetchGuildRobotInfo", cb5));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGuildRobotPermission(@NotNull GProGuildRobotPermissionReq req, @Nullable final IGProFetchGuildRobotPermissionCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchGuildRobotPermission")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lo
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.m5(IGProFetchGuildRobotPermissionCallback.this, i3, str);
                }
            }, new RobotService$fetchGuildRobotPermission$2(this, req, "fetchGuildRobotPermission", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchGuildRobotPlusPanel(@Nullable GProGuildRobotPlusPanelReq req, @Nullable final IFetchGuildRobotPlusPanelCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) req, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchGuildRobotPlusPanel")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lx
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.n5(IFetchGuildRobotPlusPanelCallback.this, i3, str);
                }
            }, new RobotService$fetchGuildRobotPlusPanel$2(this, req, "fetchGuildRobotPlusPanel", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchListRobot(@Nullable ListRobotReq req, @Nullable final IListRobotCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) req, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchListRobot")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mk
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.o5(IListRobotCallback.this, i3, str);
                }
            }, new RobotService$fetchListRobot$2(this, req, "fetchListRobot", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchMobileRobotRecommendCards(@NotNull RobotRecommendCardsReq request, @Nullable final IFetchRobotRecommendCardsCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) request, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(request, "request");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchMobileRobotRecommendCards")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mu
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.p5(IFetchRobotRecommendCardsCallback.this, i3, str);
                }
            }, new RobotService$fetchMobileRobotRecommendCards$2(this, request, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchMyRobotLists(@Nullable MyRobotsListReq request, @Nullable final IFetchMyRobotListsCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) request, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchMyRobotLists")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mp
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.q5(IFetchMyRobotListsCallback.this, i3, str);
                }
            }, new RobotService$fetchMyRobotLists$2(this, request, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchRecentUsedRobots(@NotNull RecentUsedRobotsReq req, @Nullable final IRecentUsedRobotsCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchRecentUsedRobots")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lz
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.r5(IRecentUsedRobotsCallback.this, i3, str);
                }
            }, new RobotService$fetchRecentUsedRobots$2(this, req, "fetchRecentUsedRobots", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchRobotCommonGuild(@NotNull GProRobotCommonGuildReq req, @Nullable final IGProFetchRobotCommonGuildCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchRobotCommonGuild")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lu
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.s5(IGProFetchRobotCommonGuildCallback.this, i3, str);
                }
            }, new RobotService$fetchRobotCommonGuild$2(this, req, "fetchRobotCommonGuild", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchRobotFeatureWithReq(@Nullable final RobotFeatureReq req, @Nullable IGetGroupRobotProfileCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) req, (Object) cb5);
        } else {
            check("fetchRobotFeatureWithReq", cb5, new Function1<IGetGroupRobotProfileCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchRobotFeatureWithReq$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RobotFeatureReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupRobotProfileCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchRobotFeatureWithReq(this.$req, iGetGroupRobotProfileCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchRobotShareLimit(@NotNull final RobotShareLimitReq req, @Nullable IRobotShareLimitCallBack cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("fetchRobotShareLimit", cb5, new Function1<IRobotShareLimitCallBack, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$fetchRobotShareLimit$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RobotShareLimitReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IRobotShareLimitCallBack iRobotShareLimitCallBack) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iRobotShareLimitCallBack);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchRobotShareLimit(this.$req, iRobotShareLimitCallBack);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchRobotStoryHalfViewData(@Nullable QueryHalfViewDataReq request, @Nullable final IFetchRobotStoryHalfViewCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) request, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchUgcSetting")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mi
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.t5(IFetchRobotStoryHalfViewCallback.this, i3, str);
                }
            }, new RobotService$fetchRobotStoryHalfViewData$2(this, request, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchShareArkInfo(long uin, @Nullable IShareArkInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(uin), cb5);
            return;
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchShareInfo(@NotNull FetchShareInfoReq req, @NotNull final IFetchShareInfoCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchShareInfo")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.me
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.u5(IFetchShareInfoCallback.this, i3, str);
            }
        }, new RobotService$fetchShareInfo$2(this, req, "fetchShareInfo", cb5));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void fetchUgcSetting(@Nullable FetchUgcSettingReq request, @Nullable final IFetchUgcSettingCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) request, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "fetchUgcSetting")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mg
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.v5(IFetchUgcSettingCallback.this, i3, str);
                }
            }, new RobotService$fetchUgcSetting$2(this, request, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public long getAllRobotFriendsCountFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Long) iPatchRedirector.redirect((short) 54, (Object) this)).longValue();
        }
        Long l3 = (Long) check("getAllRobotFriendsCountFromCache", new Function0<Long>() { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$getAllRobotFriendsCountFromCache$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this);
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
                IKernelRobotService service = RobotService.this.getService();
                if (service != null) {
                    return Long.valueOf(service.getAllRobotFriendsCountFromCache());
                }
                return null;
            }
        });
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    @NotNull
    public ArrayList<RobotCoreInfo> getAllRobotFriendsFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (ArrayList) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        ArrayList<RobotCoreInfo> arrayList = (ArrayList) check("getAllRobotFriendsFromCache", new Function0<ArrayList<RobotCoreInfo>>() { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$getAllRobotFriendsFromCache$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ArrayList<RobotCoreInfo> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelRobotService service = RobotService.this.getService();
                if (service != null) {
                    return service.getAllRobotFriendsFromCache();
                }
                return null;
            }
        });
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getAudioLiveRobotStatus(@NotNull GProAudioLiveRobotStatusReq req, @Nullable final IGProAudioLiveRobotStatusCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "getAudioLiveRobotStatus")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mm
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.w5(IGProAudioLiveRobotStatusCallback.this, i3, str);
                }
            }, new RobotService$getAudioLiveRobotStatus$2(this, req, "getAudioLiveRobotStatus", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getGroupRobotProfile(@Nullable final GroupRobotProfileReq req, @Nullable IGetGroupRobotProfileCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) req, (Object) cb5);
        } else {
            check("getGroupRobotProfile", cb5, new Function1<IGetGroupRobotProfileCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$getGroupRobotProfile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupRobotProfileReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupRobotProfileCallback iGetGroupRobotProfileCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupRobotProfileCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupRobotProfile(this.$req, iGetGroupRobotProfileCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getGuildRobotCardRecommend(@NotNull GProGuildRobotCardRecommendReq req, @Nullable final IGetGuildRobotCardRecommendCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "getGuildRobotCardRecommend")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lw
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.x5(IGetGuildRobotCardRecommendCallback.this, i3, str);
                }
            }, new RobotService$getGuildRobotCardRecommend$2(this, req, "getGuildRobotCardRecommend", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getGuildRobotInlineSearch(@NotNull GProGuildRobotInlineSearchReq req, @Nullable final IGetGuildRobotInlineSearchCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "getGuildRobotInlineSearch")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mo
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.y5(IGetGuildRobotInlineSearchCallback.this, i3, str);
                }
            }, new RobotService$getGuildRobotInlineSearch$2(this, req, "getGuildRobotInlineSearch", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getGuildRobotList(@NotNull GProGetGuildRobotListReq req, @Nullable final IGetGuildRobotListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "getGuildRobotList")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ly
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.z5(IGetGuildRobotListCallback.this, i3, str);
                }
            }, new RobotService$getGuildRobotList$2(this, req, "getGuildRobotList", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    @Nullable
    public RobotCoreInfo getRobotFriendsFromCacheWithUin(final long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (RobotCoreInfo) iPatchRedirector.redirect((short) 55, (Object) this, uin);
        }
        return (RobotCoreInfo) check("getRobotFriendsFromCacheWithUin", new Function0<RobotCoreInfo>(uin) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$getRobotFriendsFromCacheWithUin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $uin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$uin = uin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, Long.valueOf(uin));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final RobotCoreInfo invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RobotCoreInfo) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelRobotService service = RobotService.this.getService();
                if (service != null) {
                    return service.getRobotFriendsFromCacheWithUin(this.$uin);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getRobotFunctions(@NotNull final Contact contact, @NotNull final BatchBotGetReq req, @Nullable IGetRobotFunctionsCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, contact, req, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(req, "req");
        check("getRobotFunctions", cb5, new Function1<IGetRobotFunctionsCallback, Unit>(contact, req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$getRobotFunctions$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Contact $contact;
            final /* synthetic */ BatchBotGetReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$contact = contact;
                this.$req = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, contact, req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGetRobotFunctionsCallback iGetRobotFunctionsCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetRobotFunctionsCallback);
                }
                IKernelRobotService service = RobotService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getRobotFunctions(this.$contact, this.$req, iGetRobotFunctionsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void getRobotUinRange(@Nullable RobotUinRangeReq req, @Nullable IRobotUinRangeCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void queryGuildGlobalRobotSubscription(@NotNull GProQueryGlobalRobotSubscriptionReq req, @Nullable final IQueryGuildGlobalRobotSubscriptionCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "queryGuildGlobalRobotSubscription")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mf
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.A5(IQueryGuildGlobalRobotSubscriptionCallback.this, i3, str);
                }
            }, new RobotService$queryGuildGlobalRobotSubscription$2(this, req, "queryGuildGlobalRobotSubscription", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void removeAllRecommendCache(@Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) cb5);
        } else {
            check("removeAllRecommendCache", cb5, new Function1<IOperateCallback, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$removeAllRecommendCache$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.removeAllRecommendCache(iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void removeFriend(@NotNull final RobotRemoveFriendRequest req, @Nullable IRemoveFriendCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("removeFriend", cb5, new Function1<IRemoveFriendCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$removeFriend$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RobotRemoveFriendRequest $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IRemoveFriendCallback iRemoveFriendCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iRemoveFriendCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.removeFriend(this.$req, iRemoveFriendCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void removeKernelRobotListener(final long listenerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, listenerId);
        } else {
            check("removeKernelRobotListener", new Function0<Unit>(listenerId) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$removeKernelRobotListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $listenerId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$listenerId = listenerId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RobotService.this, Long.valueOf(listenerId));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.removeKernelRobotListener(this.$listenerId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void reportRobotStoryActionData(@NotNull RobotStoryActionSetReq request, @Nullable final IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) request, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(request, "request");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "reportRobotStoryActionData")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lr
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.B5(IOperateCallback.this, i3, str);
                }
            }, new RobotService$reportRobotStoryActionData$2(this, request, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void resetConversation(@NotNull ResetRobotConversationRq req, @NotNull final ICommandCbCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "resetConversation")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.ml
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotService.C5(ICommandCbCallback.this, i3, str);
            }
        }, new RobotService$resetConversation$2(this, req, "resetConversation", cb5));
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void robotAuth(@NotNull final RobotAuthRequest req, @Nullable IRobotAuthCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("robotAuth", cb5, new Function1<IRobotAuthCallback, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$robotAuth$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IRobotAuthCallback iRobotAuthCallback) {
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.robotAuth(req, iRobotAuthCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void saveSelectedAIModelOrOptIds(@Nullable SaveAIModelReq req, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        IKernelRobotService service = getService();
        if (service != null) {
            service.saveSelectedAIModelOrOptIds(req, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void selectAIModel(@Nullable RobotSelectAIModelReq req, @Nullable ICommandCbCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        IKernelRobotService service = getService();
        if (service != null) {
            service.selectAIModel(req, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void sendCommonRobotToGuild(@NotNull final SendCommonRobotReq req, @Nullable ISendCommonRobotCallBack cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("sendCommonRobotToGuild", cb5, new Function1<ISendCommonRobotCallBack, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$sendCommonRobotToGuild$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ SendCommonRobotReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISendCommonRobotCallBack iSendCommonRobotCallBack) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSendCommonRobotCallBack);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.sendCommonRobotToGuild(this.$req, iSendCommonRobotCallBack);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void sendGroupRobotStoreSearch(@NotNull final GroupRobotStoreSearchReq req, @Nullable IRobotStoreSearchCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("sendGroupRobotStoreSearch", cb5, new Function1<IRobotStoreSearchCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$sendGroupRobotStoreSearch$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupRobotStoreSearchReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IRobotStoreSearchCallback iRobotStoreSearchCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iRobotStoreSearchCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.sendGroupRobotStoreSearch(this.$req, iRobotStoreSearchCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setAddRobotToGroup(@NotNull final AddRobotToGroupReq req, @Nullable ISetAddRobotToGroupCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setAddRobotToGroup", cb5, new Function1<ISetAddRobotToGroupCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setAddRobotToGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AddRobotToGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISetAddRobotToGroupCallback iSetAddRobotToGroupCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSetAddRobotToGroupCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setAddRobotToGroup(this.$req, iSetAddRobotToGroupCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setGuildRobotDirectMsgSetting(@NotNull final GProSetGuildRobotDirectMsgSettingReq req, @Nullable final IGProRobotSimpleResultCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final String str = "setGuildRobotDirectMsgSetting";
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "setGuildRobotDirectMsgSetting")}, new nn(cb5), new Function1<Integer, Unit>(str, cb5, this, req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setGuildRobotDirectMsgSetting$$inlined$checkEnableWithSimpleCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $methodName;
            final /* synthetic */ IGProRobotSimpleResultCallback $originCallback;
            final /* synthetic */ GProSetGuildRobotDirectMsgSettingReq $req$inlined;
            final /* synthetic */ RobotService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$methodName = str;
                this.$originCallback = cb5;
                this.this$0 = this;
                this.$req$inlined = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, str, cb5, this, req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback = new IGProRobotSimpleResultCallback(this.$methodName, i3, this.$originCallback) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setGuildRobotDirectMsgSetting$$inlined$checkEnableWithSimpleCallback$1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f357339b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ int f357340c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ IGProRobotSimpleResultCallback f357341d;

                    {
                        this.f357339b = r6;
                        this.f357340c = i3;
                        this.f357341d = r8;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i3), r8);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
                    public final void onResult(int i16, String str2) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, i16, (Object) str2);
                        } else {
                            RobotService robotService = RobotService.this;
                            robotService.postHandle(new Runnable(this.f357339b, i16, str2, this.f357340c, this.f357341d) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setGuildRobotDirectMsgSetting$.inlined.checkEnableWithSimpleCallback.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f357342d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f357343e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f357344f;

                                /* renamed from: h, reason: collision with root package name */
                                final /* synthetic */ int f357345h;

                                /* renamed from: i, reason: collision with root package name */
                                final /* synthetic */ IGProRobotSimpleResultCallback f357346i;

                                {
                                    this.f357342d = r6;
                                    this.f357343e = i16;
                                    this.f357344f = str2;
                                    this.f357345h = r9;
                                    this.f357346i = r10;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i16), str2, Integer.valueOf(r9), r10);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 2)) {
                                        iPatchRedirector4.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    KLog.f359087a.d(RobotService.this.getSubTag(), new Object[]{TuplesKt.to("method", this.f357342d), TuplesKt.to("result", Integer.valueOf(this.f357343e)), TuplesKt.to("errMsg", this.f357344f)}, Integer.valueOf(this.f357345h));
                                    IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback2 = this.f357346i;
                                    if (iGProRobotSimpleResultCallback2 != null) {
                                        iGProRobotSimpleResultCallback2.onResult(this.f357343e, this.f357344f);
                                    }
                                }
                            });
                        }
                    }
                };
                IKernelRobotService service = this.this$0.getService();
                if (service != null) {
                    service.setGuildRobotDirectMsgSetting(this.$req$inlined, iGProRobotSimpleResultCallback);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setGuildRobotPermission(@NotNull final GProGuildRobotSetPermissionReq req, @Nullable final IGProRobotSimpleResultCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final String str = "setGuildRobotPermission";
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "setGuildRobotPermission")}, new nn(cb5), new Function1<Integer, Unit>(str, cb5, this, req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setGuildRobotPermission$$inlined$checkEnableWithSimpleCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $methodName;
            final /* synthetic */ IGProRobotSimpleResultCallback $originCallback;
            final /* synthetic */ GProGuildRobotSetPermissionReq $req$inlined;
            final /* synthetic */ RobotService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$methodName = str;
                this.$originCallback = cb5;
                this.this$0 = this;
                this.$req$inlined = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, str, cb5, this, req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback = new IGProRobotSimpleResultCallback(this.$methodName, i3, this.$originCallback) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setGuildRobotPermission$$inlined$checkEnableWithSimpleCallback$1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f357348b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ int f357349c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ IGProRobotSimpleResultCallback f357350d;

                    {
                        this.f357348b = r6;
                        this.f357349c = i3;
                        this.f357350d = r8;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i3), r8);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
                    public final void onResult(int i16, String str2) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, i16, (Object) str2);
                        } else {
                            RobotService robotService = RobotService.this;
                            robotService.postHandle(new Runnable(this.f357348b, i16, str2, this.f357349c, this.f357350d) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setGuildRobotPermission$.inlined.checkEnableWithSimpleCallback.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f357351d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f357352e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f357353f;

                                /* renamed from: h, reason: collision with root package name */
                                final /* synthetic */ int f357354h;

                                /* renamed from: i, reason: collision with root package name */
                                final /* synthetic */ IGProRobotSimpleResultCallback f357355i;

                                {
                                    this.f357351d = r6;
                                    this.f357352e = i16;
                                    this.f357353f = str2;
                                    this.f357354h = r9;
                                    this.f357355i = r10;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i16), str2, Integer.valueOf(r9), r10);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 2)) {
                                        iPatchRedirector4.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    KLog.f359087a.d(RobotService.this.getSubTag(), new Object[]{TuplesKt.to("method", this.f357351d), TuplesKt.to("result", Integer.valueOf(this.f357352e)), TuplesKt.to("errMsg", this.f357353f)}, Integer.valueOf(this.f357354h));
                                    IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback2 = this.f357355i;
                                    if (iGProRobotSimpleResultCallback2 != null) {
                                        iGProRobotSimpleResultCallback2.onResult(this.f357352e, this.f357353f);
                                    }
                                }
                            });
                        }
                    }
                };
                IKernelRobotService service = this.this$0.getService();
                if (service != null) {
                    service.setGuildRobotPermission(this.$req$inlined, iGProRobotSimpleResultCallback);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setRemoveRobotFromGroup(@NotNull final RemoveRobotFromGroupReq req, @Nullable ISetRemoveRobotFromGroupCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setRemoveRobotFromGroup", cb5, new Function1<ISetRemoveRobotFromGroupCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setRemoveRobotFromGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RemoveRobotFromGroupReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISetRemoveRobotFromGroupCallback iSetRemoveRobotFromGroupCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSetRemoveRobotFromGroupCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setRemoveRobotFromGroup(this.$req, iSetRemoveRobotFromGroupCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setRobotMessagePush(@NotNull final RobotMsgPushSetReq req, @Nullable ISetRobotMessagePushCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setRobotMessagePush", cb5, new Function1<ISetRobotMessagePushCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setRobotMessagePush$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RobotMsgPushSetReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ISetRobotMessagePushCallback iSetRobotMessagePushCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iSetRobotMessagePushCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setRobotMessagePush(this.$req, iSetRobotMessagePushCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setRobotStoryEnter(@Nullable CommandCbRequest req, @Nullable final ICommandCbCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) req, (Object) cb5);
        } else {
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "reportRobotStoryActionData")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mt
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.D5(ICommandCbCallback.this, i3, str);
                }
            }, new RobotService$setRobotStoryEnter$2(this, req, cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void setRobotTTsConfig(@NotNull final RobotTTsConfigReq req, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("setRobotTTsConfig", cb5, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$setRobotTTsConfig$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RobotTTsConfigReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RobotService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setRobotTTsConfig(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void subscribeGuildGlobalRobot(@NotNull final GProSubscribeGlobalRobotReq req, @Nullable final IGProRobotSimpleResultCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) req, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        final String str = "subscribeGuildGlobalRobot";
        getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "subscribeGuildGlobalRobot")}, new nn(cb5), new Function1<Integer, Unit>(str, cb5, this, req) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$subscribeGuildGlobalRobot$$inlined$checkEnableWithSimpleCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $methodName;
            final /* synthetic */ IGProRobotSimpleResultCallback $originCallback;
            final /* synthetic */ GProSubscribeGlobalRobotReq $req$inlined;
            final /* synthetic */ RobotService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$methodName = str;
                this.$originCallback = cb5;
                this.this$0 = this;
                this.$req$inlined = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RobotService.this, str, cb5, this, req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback = new IGProRobotSimpleResultCallback(this.$methodName, i3, this.$originCallback) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$subscribeGuildGlobalRobot$$inlined$checkEnableWithSimpleCallback$1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f357357b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ int f357358c;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ IGProRobotSimpleResultCallback f357359d;

                    {
                        this.f357357b = r6;
                        this.f357358c = i3;
                        this.f357359d = r8;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i3), r8);
                        }
                    }

                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
                    public final void onResult(int i16, String str2) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, i16, (Object) str2);
                        } else {
                            RobotService robotService = RobotService.this;
                            robotService.postHandle(new Runnable(this.f357357b, i16, str2, this.f357358c, this.f357359d) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$subscribeGuildGlobalRobot$.inlined.checkEnableWithSimpleCallback.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f357360d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f357361e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ String f357362f;

                                /* renamed from: h, reason: collision with root package name */
                                final /* synthetic */ int f357363h;

                                /* renamed from: i, reason: collision with root package name */
                                final /* synthetic */ IGProRobotSimpleResultCallback f357364i;

                                {
                                    this.f357360d = r6;
                                    this.f357361e = i16;
                                    this.f357362f = str2;
                                    this.f357363h = r9;
                                    this.f357364i = r10;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, this, RobotService.this, r6, Integer.valueOf(i16), str2, Integer.valueOf(r9), r10);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 2)) {
                                        iPatchRedirector4.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    KLog.f359087a.d(RobotService.this.getSubTag(), new Object[]{TuplesKt.to("method", this.f357360d), TuplesKt.to("result", Integer.valueOf(this.f357361e)), TuplesKt.to("errMsg", this.f357362f)}, Integer.valueOf(this.f357363h));
                                    IGProRobotSimpleResultCallback iGProRobotSimpleResultCallback2 = this.f357364i;
                                    if (iGProRobotSimpleResultCallback2 != null) {
                                        iGProRobotSimpleResultCallback2.onResult(this.f357361e, this.f357362f);
                                    }
                                }
                            });
                        }
                    }
                };
                IKernelRobotService service = this.this$0.getService();
                if (service != null) {
                    service.subscribeGuildGlobalRobot(this.$req$inlined, iGProRobotSimpleResultCallback);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void upMicGuildRobot(@NotNull GProGuildRobotUpMicReq req, @Nullable final IUpMicGuildRobotCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) req, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            getContent().e().H0(getSubTag(), new Object[]{TuplesKt.to("method", "upMicGuildRobot")}, new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.mh
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotService.E5(IUpMicGuildRobotCallback.this, i3, str);
                }
            }, new RobotService$upMicGuildRobot$2(this, req, "upMicGuildRobot", cb5));
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotService
    public void updateGroupRobotProfile(@Nullable final String uid, @Nullable final byte[] profileBuf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) uid, (Object) profileBuf);
        } else {
            check("updateGroupRobotProfile", new Function0<Unit>(uid, profileBuf) { // from class: com.tencent.qqnt.kernel.api.impl.RobotService$updateGroupRobotProfile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ byte[] $profileBuf;
                final /* synthetic */ String $uid;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$uid = uid;
                    this.$profileBuf = profileBuf;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RobotService.this, uid, profileBuf);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelRobotService service = RobotService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.updateGroupRobotProfile(this.$uid, this.$profileBuf);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
