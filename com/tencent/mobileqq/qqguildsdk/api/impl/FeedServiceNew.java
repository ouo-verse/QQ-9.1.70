package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchManageOperateReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusiData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDeleteInteractReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedLikeUserListReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetExternalCommentsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedCountReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetImmersiveFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedConfigReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMoveFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCardPosAdvertise;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportRecentViewFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStAlterFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDelFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedCommentsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStPublishFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopChannelFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedActionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUPdateFeedInteractSwitchReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAlterFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetFeedDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchManageOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchTransThirdPlatformURCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDelFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedInteractNoticeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAllFeedNoticesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTimelineFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetExternalCommentsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCountCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedLikeUserListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedNoticesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetImmersiveFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedConfigCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopicFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProMoveFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreloadGuildFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProSetTopCommentCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopFeedActionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetNextPageRepliesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGPropublishFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0086\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0087\u0001B\u001e\u0012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u001b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010!\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010$\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\"2\b\u0010\b\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010%2\b\u0010\b\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010*\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010(2\b\u0010\b\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010-\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010+2\b\u0010\b\u001a\u0004\u0018\u00010,H\u0016J\u001c\u00100\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010.2\b\u0010\b\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00103\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u0001012\b\u0010\b\u001a\u0004\u0018\u000102H\u0016J\u001c\u00106\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u0001042\b\u0010\b\u001a\u0004\u0018\u000105H\u0016J\u001c\u00109\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u0001072\b\u0010\b\u001a\u0004\u0018\u000108H\u0016J\u001c\u0010<\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010:2\b\u0010\b\u001a\u0004\u0018\u00010;H\u0016J\u001c\u0010?\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010=2\b\u0010\b\u001a\u0004\u0018\u00010>H\u0016J\u0014\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0014\u0010D\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J$\u0010G\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010E2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010FH\u0016J\u001c\u0010J\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010H2\b\u0010\b\u001a\u0004\u0018\u00010IH\u0016J\u001c\u0010M\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010K2\b\u0010\b\u001a\u0004\u0018\u00010LH\u0016J\u001c\u0010P\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010N2\b\u0010\b\u001a\u0004\u0018\u00010OH\u0016J\u001c\u0010S\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010Q2\b\u0010\b\u001a\u0004\u0018\u00010RH\u0016J\u0018\u0010V\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020T2\u0006\u0010\b\u001a\u00020UH\u0016J\u0010\u0010X\u001a\u00020\t2\u0006\u0010\b\u001a\u00020WH\u0016J\u0018\u0010Z\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020Y2\u0006\u0010\b\u001a\u00020WH\u0016J\u001c\u0010]\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010[2\b\u0010\b\u001a\u0004\u0018\u00010\\H\u0016J$\u0010`\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010^2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010_H\u0016J$\u0010b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010^2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010aH\u0016J\u0018\u0010e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020c2\u0006\u0010\b\u001a\u00020dH\u0016J\u0018\u0010h\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020f2\u0006\u0010\b\u001a\u00020gH\u0016J\u0018\u0010k\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020i2\u0006\u0010\b\u001a\u00020jH\u0016J\u0018\u0010n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020l2\u0006\u0010\b\u001a\u00020mH\u0016J\u0018\u0010q\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020o2\u0006\u0010\b\u001a\u00020pH\u0016J\u0018\u0010t\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020r2\u0006\u0010\b\u001a\u00020sH\u0016J\u0012\u0010v\u001a\u0004\u0018\u00010u2\u0006\u0010A\u001a\u00020@H\u0016J \u0010{\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020w2\u0006\u0010y\u001a\u00020x2\u0006\u0010\b\u001a\u00020zH\u0016J\u0012\u0010}\u001a\u0004\u0018\u00010|2\u0006\u0010A\u001a\u00020@H\u0016J!\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020~2\u0006\u0010y\u001a\u00020x2\u0006\u0010\b\u001a\u00020\u007fH\u0016\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/FeedServiceNew;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/FeedNewBaseService;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedServiceNew;", "Lcom/tencent/qqnt/kernel/api/o;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedCountReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCountCallback;", "cb", "", "getFeedCount", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDelFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDelFeedCallback;", "delFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopFeedActionReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopFeedActionCallback;", "topFeedAction", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProMoveFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProMoveFeedCallback;", "moveFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchManageOperateReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchManageOperateCallback;", "batchManageOperate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsReq;", "", VideoProxy.PARAM_ENABLE_CACHE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetChannelTimelineFeedsCallback;", "getChannelTimelineFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStPublishFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGPropublishFeedCallback;", "publishFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedDetailReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;", "getFeedDetail", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedCommentsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCommentsCallback;", "getFeedComments", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStAlterFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProAlterFeedCallback;", "alterFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoLikeReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", "doLike", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoCommentCallback;", "doComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoReplyCallback;", "doReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImpeachReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;", "impeach", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDoFeedPreferReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;", "doFeedPrefer", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchGetFeedDetailReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchGetFeedDetailCallback;", "batchGetFeedDetail", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetNextPageRepliesCallback;", "getNextPageReplies", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetFeedsCallback;", "getFeeds", "", "data", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "decodeStFeed", "encodeStFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetGuildFeedsCallback;", "getGuildFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopFeedConfigReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedConfigCallback;", "getTopFeedConfig", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedsCallback;", "getTopFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopChannelFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopChannelFeedCallback;", "topChannelFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopicFeedsCallback;", "getTopicFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;", "getFeedsByIndex", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGproFeedOperateCallback;", "clearFeedsRecentViewHistory", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProReportRecentViewFeedReq;", "reportRecentViewFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetImmersiveFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetImmersiveFeedsCallback;", "getImmersiveFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedNoticesReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedNoticesCallback;", "getFeedNotices", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetAllFeedNoticesCallback;", "getAllFeedNotices", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProPreloadGuildFeedsCallback;", "preloadGuildFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetExternalCommentsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetExternalCommentsCallback;", "getExternalComments", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProSetTopCommentCallback;", "setTopComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchTransThirdPlatformURCallback;", "batchTransThirdPlatformURL", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDeleteInteractReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDeleteFeedInteractNoticeCallback;", "deleteFeedInteractNotice", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUPdateFeedInteractSwitchReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProUpdateFeedInteractBlockedStatusCallback;", "updateFeedInteractBlockedStatus", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRecommendCardPosAdvertise;", "T", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareReq;", "", "serviceType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProCreateShareCallback;", "createShare", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBusiData;", "decodeBusiData", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProFeedLikeUserListReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedLikeUserListCallback;", "getFeedLikeUserList", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedServiceNew;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class FeedServiceNew extends FeedNewBaseService<IKernelFeedListener, IKernelFeedServiceNew> implements com.tencent.qqnt.kernel.api.o {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedServiceNew(@Nullable IKernelFeedServiceNew iKernelFeedServiceNew, @NotNull ServiceContent content) {
        super("FeedServiceNew", content, iKernelFeedServiceNew);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    @Override // com.tencent.qqnt.kernel.api.o
    @Nullable
    public GProRecommendCardPosAdvertise T(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return com.tencent.qqnt.kernelgpro.nativeinterface.d.k0(data);
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void alterFeed(@Nullable final GProStAlterFeedReq req, @Nullable IGProAlterFeedCallback cb5) {
        T2("alterFeed", cb5, new Function1<IGProAlterFeedCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$alterFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProAlterFeedCallback iGProAlterFeedCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.alterFeed(req, iGProAlterFeedCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void batchGetFeedDetail(@Nullable final GProBatchGetFeedDetailReq req, @Nullable IGProBatchGetFeedDetailCallback cb5) {
        U2("batchGetFeedDetail", cb5, new Function1<IGProBatchGetFeedDetailCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$batchGetFeedDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProBatchGetFeedDetailCallback iGProBatchGetFeedDetailCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.batchGetFeedDetail(req, iGProBatchGetFeedDetailCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void batchManageOperate(@Nullable final GProBatchManageOperateReq req, @Nullable IGProBatchManageOperateCallback cb5) {
        V2("batchManageOperate", cb5, new Function1<IGProBatchManageOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$batchManageOperate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProBatchManageOperateCallback iGProBatchManageOperateCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.batchManageOperate(req, iGProBatchManageOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void batchTransThirdPlatformURL(@NotNull GProBatchTransThirdPlatformURLReq req, @NotNull final IGProBatchTransThirdPlatformURCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        P0("batchTransThirdPlatformURL", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$batchTransThirdPlatformURL$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String err) {
                Intrinsics.checkNotNullParameter(err, "err");
                IGProBatchTransThirdPlatformURCallback.this.onResult(i3, err, new GProBatchTransThirdPlatformURLRsp());
            }
        }, new FeedServiceNew$batchTransThirdPlatformURL$2(req, this, cb5));
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void clearFeedsRecentViewHistory(@NotNull IGproFeedOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        x3("clearFeedsRecentViewHistory", cb5, new Function1<IGproFeedOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$clearFeedsRecentViewHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGproFeedOperateCallback iGproFeedOperateCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.clearFeedsRecentViewHistory(iGproFeedOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void createShare(@NotNull GProCreateShareReq req, int serviceType, @NotNull final IGProCreateShareCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        P0("createShare", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$createShare$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String err) {
                Intrinsics.checkNotNullParameter(err, "err");
                IGProCreateShareCallback.this.onResult(i3, err, new GProCreateShareRsp());
            }
        }, new FeedServiceNew$createShare$2(req, serviceType, this, cb5));
    }

    @Override // com.tencent.qqnt.kernel.api.o
    @Nullable
    public GProBusiData decodeBusiData(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IKernelFeedServiceNew S0 = S0();
        if (S0 != null) {
            return S0.decodeBusiData(data);
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.o
    @Nullable
    public GProStFeed decodeStFeed(@Nullable final byte[] data) {
        return (GProStFeed) O0("decodeStFeed", new Function0<GProStFeed>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$decodeStFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GProStFeed invoke() {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 != null) {
                    return S0.decodeStFeed(data);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void delFeed(@Nullable final GProStDelFeedReq req, @Nullable IGProDelFeedCallback cb5) {
        W2("delFeed", cb5, new Function1<IGProDelFeedCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$delFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProDelFeedCallback iGProDelFeedCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.delFeed(req, iGProDelFeedCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void deleteFeedInteractNotice(@NotNull final GProDeleteInteractReq req, @NotNull IGProDeleteFeedInteractNoticeCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        X2("deleteFeedInteractNotice", cb5, new Function1<IGProDeleteFeedInteractNoticeCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$deleteFeedInteractNotice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProDeleteFeedInteractNoticeCallback iGProDeleteFeedInteractNoticeCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.deleteFeedInteractNotice(req, iGProDeleteFeedInteractNoticeCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void doComment(@Nullable final GProStDoCommentReq req, @Nullable IGProDoCommentCallback cb5) {
        Y2("doComment", cb5, new Function1<IGProDoCommentCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$doComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProDoCommentCallback iGProDoCommentCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.doComment(req, iGProDoCommentCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void doFeedPrefer(@Nullable final GProDoFeedPreferReq req, @Nullable IGProDoFeedPreferCallback cb5) {
        Z2("doFeedPrefer", cb5, new Function1<IGProDoFeedPreferCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$doFeedPrefer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProDoFeedPreferCallback iGProDoFeedPreferCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.doFeedPrefer(req, iGProDoFeedPreferCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void doLike(@Nullable final GProStDoLikeReq req, @Nullable IGProDoLikeCallback cb5) {
        a3("doLike", cb5, new Function1<IGProDoLikeCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$doLike$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProDoLikeCallback iGProDoLikeCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.doLike(req, iGProDoLikeCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void doReply(@Nullable final GProStDoReplyReq req, @Nullable IGProDoReplyCallback cb5) {
        b3("doReply", cb5, new Function1<IGProDoReplyCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$doReply$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProDoReplyCallback iGProDoReplyCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.doReply(req, iGProDoReplyCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    @Nullable
    public byte[] encodeStFeed(@Nullable final GProStFeed data) {
        return (byte[]) O0("encodeStFeed", new Function0<byte[]>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$encodeStFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final byte[] invoke() {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 != null) {
                    return S0.encodeStFeed(data);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getAllFeedNotices(@Nullable final GProGetFeedNoticesReq req, final boolean enableCache, @Nullable IGProGetAllFeedNoticesCallback cb5) {
        c3("getAllFeedNotices", cb5, new Function1<IGProGetAllFeedNoticesCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getAllFeedNotices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetAllFeedNoticesCallback iGProGetAllFeedNoticesCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getAllFeedNotices(req, enableCache, iGProGetAllFeedNoticesCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getChannelTimelineFeeds(@Nullable final GProStGetChannelFeedsReq req, final boolean enableCache, @Nullable IGProGetChannelTimelineFeedsCallback cb5) {
        y3("getChannelTimelineFeeds", enableCache, cb5, new Function1<IGProGetChannelTimelineFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getChannelTimelineFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetChannelTimelineFeedsCallback iGProGetChannelTimelineFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getChannelTimelineFeeds(req, enableCache, iGProGetChannelTimelineFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getExternalComments(@NotNull final GProGetExternalCommentsReq req, @NotNull IGProGetExternalCommentsCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        d3("getExternalComments", cb5, new Function1<IGProGetExternalCommentsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getExternalComments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetExternalCommentsCallback iGProGetExternalCommentsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getExternalComments(req, iGProGetExternalCommentsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeedComments(@Nullable final GProStGetFeedCommentsReq req, @Nullable IGProGetFeedCommentsCallback cb5) {
        e3("getFeedComments", cb5, new Function1<IGProGetFeedCommentsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeedComments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetFeedCommentsCallback iGProGetFeedCommentsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeedComments(req, iGProGetFeedCommentsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeedCount(@NotNull final GProGetFeedCountReq req, @NotNull IGProGetFeedCountCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        f3("getFeedCount", cb5, new Function1<IGProGetFeedCountCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeedCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetFeedCountCallback iGProGetFeedCountCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeedCount(req, iGProGetFeedCountCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeedDetail(@Nullable final GProStGetFeedDetailReq req, final boolean enableCache, @Nullable IGProGetFeedDetailCallback cb5) {
        g3("getFeedDetail", cb5, new Function1<IGProGetFeedDetailCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeedDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetFeedDetailCallback iGProGetFeedDetailCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeedDetail(req, enableCache, iGProGetFeedDetailCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeedLikeUserList(@NotNull final GProFeedLikeUserListReq req, final int serviceType, @NotNull IGProGetFeedLikeUserListCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        h3("getFeedLikeUserList", cb5, new Function1<IGProGetFeedLikeUserListCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeedLikeUserList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetFeedLikeUserListCallback iGProGetFeedLikeUserListCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeedLikeUserList(req, serviceType, iGProGetFeedLikeUserListCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeedNotices(@Nullable final GProGetFeedNoticesReq req, final boolean enableCache, @Nullable IGProGetFeedNoticesCallback cb5) {
        i3("getFeedNotices", cb5, new Function1<IGProGetFeedNoticesCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeedNotices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetFeedNoticesCallback iGProGetFeedNoticesCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeedNotices(req, enableCache, iGProGetFeedNoticesCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeeds(@Nullable final GProGetFeedsReq req, @Nullable IGProgetFeedsCallback cb5) {
        u3("getFeeds", cb5, new Function1<IGProgetFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProgetFeedsCallback iGProgetFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeeds(req, iGProgetFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getFeedsByIndex(@NotNull final GProGetFeedsByIndexReq req, @NotNull IGProGetFeedsByIndexCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        j3("getFeedsByIndex", cb5, new Function1<IGProGetFeedsByIndexCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getFeedsByIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetFeedsByIndexCallback iGProGetFeedsByIndexCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getFeedsByIndex(req, iGProGetFeedsByIndexCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getGuildFeeds(@Nullable final GProGetGuildFeedsReq req, final boolean enableCache, @Nullable IGProGetGuildFeedsCallback cb5) {
        z3("getGuildFeeds", enableCache, cb5, new Function1<IGProGetGuildFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getGuildFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetGuildFeedsCallback iGProGetGuildFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getGuildFeeds(req, enableCache, iGProGetGuildFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getImmersiveFeeds(@Nullable final GProGetImmersiveFeedsReq req, @Nullable IGProGetImmersiveFeedsCallback cb5) {
        k3("getImmersiveFeeds", cb5, new Function1<IGProGetImmersiveFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getImmersiveFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetImmersiveFeedsCallback iGProGetImmersiveFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getImmersiveFeeds(req, iGProGetImmersiveFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getNextPageReplies(@Nullable final GProGetNextPageRepliesReq req, @Nullable IGProgetNextPageRepliesCallback cb5) {
        v3("getNextPageReplies", cb5, new Function1<IGProgetNextPageRepliesCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getNextPageReplies$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProgetNextPageRepliesCallback iGProgetNextPageRepliesCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getNextPageReplies(req, iGProgetNextPageRepliesCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getTopFeedConfig(@Nullable final GProGetTopFeedConfigReq req, @Nullable IGProGetTopFeedConfigCallback cb5) {
        l3("getTopFeedConfig", cb5, new Function1<IGProGetTopFeedConfigCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getTopFeedConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetTopFeedConfigCallback iGProGetTopFeedConfigCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getTopFeedConfig(req, iGProGetTopFeedConfigCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getTopFeeds(@Nullable final GProGetTopFeedsReq req, @Nullable IGProGetTopFeedsCallback cb5) {
        m3("getTopFeeds", cb5, new Function1<IGProGetTopFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getTopFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetTopFeedsCallback iGProGetTopFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getTopFeeds(req, iGProGetTopFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void getTopicFeeds(@Nullable final GProGetTopicFeedsReq req, @Nullable IGProGetTopicFeedsCallback cb5) {
        n3("getTopicFeeds", cb5, new Function1<IGProGetTopicFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$getTopicFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProGetTopicFeedsCallback iGProGetTopicFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getTopicFeeds(req, iGProGetTopicFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void impeach(@Nullable final GProImpeachReq req, @Nullable IGProImpeachCallback cb5) {
        o3("impeach", cb5, new Function1<IGProImpeachCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$impeach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProImpeachCallback iGProImpeachCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.impeach(req, iGProImpeachCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void moveFeed(@Nullable final GProMoveFeedReq req, @Nullable IGProMoveFeedCallback cb5) {
        p3("moveFeed", cb5, new Function1<IGProMoveFeedCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$moveFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProMoveFeedCallback iGProMoveFeedCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.moveFeed(req, iGProMoveFeedCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void preloadGuildFeeds(@NotNull final GProPreloadGuildFeedsReq req, @NotNull IGProPreloadGuildFeedsCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        q3("preloadGuildFeeds", cb5, new Function1<IGProPreloadGuildFeedsCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$preloadGuildFeeds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProPreloadGuildFeedsCallback iGProPreloadGuildFeedsCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.preloadGuildFeeds(req, iGProPreloadGuildFeedsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void publishFeed(@Nullable final GProStPublishFeedReq req, @Nullable IGPropublishFeedCallback cb5) {
        w3("publishFeed", cb5, new Function1<IGPropublishFeedCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$publishFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGPropublishFeedCallback iGPropublishFeedCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.publishFeed(req, iGPropublishFeedCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void reportRecentViewFeed(@NotNull final GProReportRecentViewFeedReq req, @NotNull IGproFeedOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        x3("reportRecentViewFeed", cb5, new Function1<IGproFeedOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$reportRecentViewFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGproFeedOperateCallback iGproFeedOperateCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.reportRecentViewFeed(req, iGproFeedOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void setTopComment(@NotNull GProSetTopCommentReq req, @NotNull final IGProSetTopCommentCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        P0("setTopComment", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$setTopComment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String err) {
                Intrinsics.checkNotNullParameter(err, "err");
                IGProSetTopCommentCallback.this.onResult(i3, err, new GProSetTopCommentRsp());
            }
        }, new FeedServiceNew$setTopComment$2(req, this, cb5));
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void topChannelFeed(@Nullable final GProTopChannelFeedReq req, @Nullable IGProTopChannelFeedCallback cb5) {
        r3("topChannelFeed", cb5, new Function1<IGProTopChannelFeedCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$topChannelFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProTopChannelFeedCallback iGProTopChannelFeedCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.topChannelFeed(req, iGProTopChannelFeedCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void topFeedAction(@Nullable final GProTopFeedActionReq req, @Nullable IGProTopFeedActionCallback cb5) {
        s3("topFeedAction", cb5, new Function1<IGProTopFeedActionCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$topFeedAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProTopFeedActionCallback iGProTopFeedActionCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.topFeedAction(req, iGProTopFeedActionCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.o
    public void updateFeedInteractBlockedStatus(@NotNull final GProUPdateFeedInteractSwitchReq req, @NotNull IGProUpdateFeedInteractBlockedStatusCallback cb5) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        t3("updateFeedInteractBlockedStatus", cb5, new Function1<IGProUpdateFeedInteractBlockedStatusCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$updateFeedInteractBlockedStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGProUpdateFeedInteractBlockedStatusCallback iGProUpdateFeedInteractBlockedStatusCallback) {
                IKernelFeedServiceNew S0 = FeedServiceNew.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.updateFeedInteractBlockedStatus(req, iGProUpdateFeedInteractBlockedStatusCallback);
                return Unit.INSTANCE;
            }
        });
    }
}
