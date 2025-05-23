package com.tencent.qqnt.kernel.api;

import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchManageOperateReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusiData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareReq;
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
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H&J$\u0010\u0018\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0017H&J\u001c\u0010\u001b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u001aH&J$\u0010\u001e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u001dH&J\u001c\u0010!\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010 H&J\u001c\u0010$\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\"2\b\u0010\u0005\u001a\u0004\u0018\u00010#H&J\u001c\u0010'\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010%2\b\u0010\u0005\u001a\u0004\u0018\u00010&H&J\u001c\u0010*\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010(2\b\u0010\u0005\u001a\u0004\u0018\u00010)H&J\u001c\u0010-\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010+2\b\u0010\u0005\u001a\u0004\u0018\u00010,H&J\u001c\u00100\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010.2\b\u0010\u0005\u001a\u0004\u0018\u00010/H&J\u001c\u00103\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u0001012\b\u0010\u0005\u001a\u0004\u0018\u000102H&J\u001c\u00106\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u0001042\b\u0010\u0005\u001a\u0004\u0018\u000105H&J\u001c\u00109\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u0001072\b\u0010\u0005\u001a\u0004\u0018\u000108H&J\u001c\u0010<\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010:2\b\u0010\u0005\u001a\u0004\u0018\u00010;H&J\u0014\u0010@\u001a\u0004\u0018\u00010?2\b\u0010>\u001a\u0004\u0018\u00010=H&J\u0014\u0010A\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H&J$\u0010D\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010B2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010CH&J\u001c\u0010G\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010E2\b\u0010\u0005\u001a\u0004\u0018\u00010FH&J\u001c\u0010J\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010H2\b\u0010\u0005\u001a\u0004\u0018\u00010IH&J\u001c\u0010M\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010K2\b\u0010\u0005\u001a\u0004\u0018\u00010LH&J\u0018\u0010P\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020N2\u0006\u0010\u0005\u001a\u00020OH&J\u001c\u0010S\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010Q2\b\u0010\u0005\u001a\u0004\u0018\u00010RH&J\u0018\u0010V\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020T2\u0006\u0010\u0005\u001a\u00020UH&J\u001c\u0010Y\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010W2\b\u0010\u0005\u001a\u0004\u0018\u00010XH&J$\u0010\\\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010[H&J$\u0010^\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010]H&J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020_H&J\u0018\u0010b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020a2\u0006\u0010\u0005\u001a\u00020_H&J\u0018\u0010e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020c2\u0006\u0010\u0005\u001a\u00020dH&J\u0018\u0010h\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020f2\u0006\u0010\u0005\u001a\u00020gH&J\u0018\u0010k\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020i2\u0006\u0010\u0005\u001a\u00020jH&J \u0010p\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020l2\u0006\u0010n\u001a\u00020m2\u0006\u0010\u0005\u001a\u00020oH&J\u0018\u0010s\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020rH&J\u0018\u0010v\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020t2\u0006\u0010\u0005\u001a\u00020uH&J\u0012\u0010x\u001a\u0004\u0018\u00010w2\u0006\u0010>\u001a\u00020=H&J \u0010{\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020y2\u0006\u0010n\u001a\u00020m2\u0006\u0010\u0005\u001a\u00020zH&J\u0012\u0010}\u001a\u0004\u0018\u00010|2\u0006\u0010>\u001a\u00020=H&\u00a8\u0006~"}, d2 = {"Lcom/tencent/qqnt/kernel/api/o;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedCountReq;", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCountCallback;", "cb", "", "getFeedCount", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDelFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDelFeedCallback;", "delFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopFeedActionReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopFeedActionCallback;", "topFeedAction", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProMoveFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProMoveFeedCallback;", "moveFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchManageOperateReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchManageOperateCallback;", "batchManageOperate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsReq;", "", VideoProxy.PARAM_ENABLE_CACHE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetChannelTimelineFeedsCallback;", "getChannelTimelineFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStPublishFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGPropublishFeedCallback;", "publishFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedDetailReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;", "getFeedDetail", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedCommentsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCommentsCallback;", "getFeedComments", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStAlterFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProAlterFeedCallback;", "alterFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoLikeReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", "doLike", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoCommentCallback;", "doComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoReplyCallback;", "doReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImpeachReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;", "impeach", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDoFeedPreferReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;", "doFeedPrefer", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchGetFeedDetailReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchGetFeedDetailCallback;", "batchGetFeedDetail", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetNextPageRepliesCallback;", "getNextPageReplies", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetFeedsCallback;", "getFeeds", "", "data", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "decodeStFeed", "encodeStFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetGuildFeedsCallback;", "getGuildFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopFeedConfigReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedConfigCallback;", "getTopFeedConfig", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedsCallback;", "getTopFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopChannelFeedReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopChannelFeedCallback;", "topChannelFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProSetTopCommentCallback;", "setTopComment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetTopicFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopicFeedsCallback;", "getTopicFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedsByIndexReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;", "getFeedsByIndex", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetImmersiveFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetImmersiveFeedsCallback;", "getImmersiveFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedNoticesReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedNoticesCallback;", "getFeedNotices", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetAllFeedNoticesCallback;", "getAllFeedNotices", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGproFeedOperateCallback;", "clearFeedsRecentViewHistory", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProReportRecentViewFeedReq;", "reportRecentViewFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProPreloadGuildFeedsCallback;", "preloadGuildFeeds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetExternalCommentsReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetExternalCommentsCallback;", "getExternalComments", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchTransThirdPlatformURCallback;", "batchTransThirdPlatformURL", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProFeedLikeUserListReq;", "", "serviceType", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedLikeUserListCallback;", "getFeedLikeUserList", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDeleteInteractReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDeleteFeedInteractNoticeCallback;", "deleteFeedInteractNotice", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUPdateFeedInteractSwitchReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProUpdateFeedInteractBlockedStatusCallback;", "updateFeedInteractBlockedStatus", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRecommendCardPosAdvertise;", "T", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProCreateShareCallback;", "createShare", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBusiData;", "decodeBusiData", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface o extends j {
    @Nullable
    GProRecommendCardPosAdvertise T(@NotNull byte[] data);

    void alterFeed(@Nullable GProStAlterFeedReq req, @Nullable IGProAlterFeedCallback cb5);

    void batchGetFeedDetail(@Nullable GProBatchGetFeedDetailReq req, @Nullable IGProBatchGetFeedDetailCallback cb5);

    void batchManageOperate(@Nullable GProBatchManageOperateReq req, @Nullable IGProBatchManageOperateCallback cb5);

    void batchTransThirdPlatformURL(@NotNull GProBatchTransThirdPlatformURLReq req, @NotNull IGProBatchTransThirdPlatformURCallback cb5);

    void clearFeedsRecentViewHistory(@NotNull IGproFeedOperateCallback cb5);

    void createShare(@NotNull GProCreateShareReq req, int serviceType, @NotNull IGProCreateShareCallback cb5);

    @Nullable
    GProBusiData decodeBusiData(@NotNull byte[] data);

    @Nullable
    GProStFeed decodeStFeed(@Nullable byte[] data);

    void delFeed(@Nullable GProStDelFeedReq req, @Nullable IGProDelFeedCallback cb5);

    void deleteFeedInteractNotice(@NotNull GProDeleteInteractReq req, @NotNull IGProDeleteFeedInteractNoticeCallback cb5);

    void doComment(@Nullable GProStDoCommentReq req, @Nullable IGProDoCommentCallback cb5);

    void doFeedPrefer(@Nullable GProDoFeedPreferReq req, @Nullable IGProDoFeedPreferCallback cb5);

    void doLike(@Nullable GProStDoLikeReq req, @Nullable IGProDoLikeCallback cb5);

    void doReply(@Nullable GProStDoReplyReq req, @Nullable IGProDoReplyCallback cb5);

    @Nullable
    byte[] encodeStFeed(@Nullable GProStFeed data);

    void getAllFeedNotices(@Nullable GProGetFeedNoticesReq req, boolean enableCache, @Nullable IGProGetAllFeedNoticesCallback cb5);

    void getChannelTimelineFeeds(@Nullable GProStGetChannelFeedsReq req, boolean enableCache, @Nullable IGProGetChannelTimelineFeedsCallback cb5);

    void getExternalComments(@NotNull GProGetExternalCommentsReq req, @NotNull IGProGetExternalCommentsCallback cb5);

    void getFeedComments(@Nullable GProStGetFeedCommentsReq req, @Nullable IGProGetFeedCommentsCallback cb5);

    void getFeedCount(@NotNull GProGetFeedCountReq req, @NotNull IGProGetFeedCountCallback cb5);

    void getFeedDetail(@Nullable GProStGetFeedDetailReq req, boolean enableCache, @Nullable IGProGetFeedDetailCallback cb5);

    void getFeedLikeUserList(@NotNull GProFeedLikeUserListReq req, int serviceType, @NotNull IGProGetFeedLikeUserListCallback cb5);

    void getFeedNotices(@Nullable GProGetFeedNoticesReq req, boolean enableCache, @Nullable IGProGetFeedNoticesCallback cb5);

    void getFeeds(@Nullable GProGetFeedsReq req, @Nullable IGProgetFeedsCallback cb5);

    void getFeedsByIndex(@NotNull GProGetFeedsByIndexReq req, @NotNull IGProGetFeedsByIndexCallback cb5);

    void getGuildFeeds(@Nullable GProGetGuildFeedsReq req, boolean enableCache, @Nullable IGProGetGuildFeedsCallback cb5);

    void getImmersiveFeeds(@Nullable GProGetImmersiveFeedsReq req, @Nullable IGProGetImmersiveFeedsCallback cb5);

    void getNextPageReplies(@Nullable GProGetNextPageRepliesReq req, @Nullable IGProgetNextPageRepliesCallback cb5);

    void getTopFeedConfig(@Nullable GProGetTopFeedConfigReq req, @Nullable IGProGetTopFeedConfigCallback cb5);

    void getTopFeeds(@Nullable GProGetTopFeedsReq req, @Nullable IGProGetTopFeedsCallback cb5);

    void getTopicFeeds(@Nullable GProGetTopicFeedsReq req, @Nullable IGProGetTopicFeedsCallback cb5);

    void impeach(@Nullable GProImpeachReq req, @Nullable IGProImpeachCallback cb5);

    void moveFeed(@Nullable GProMoveFeedReq req, @Nullable IGProMoveFeedCallback cb5);

    void preloadGuildFeeds(@NotNull GProPreloadGuildFeedsReq req, @NotNull IGProPreloadGuildFeedsCallback cb5);

    void publishFeed(@Nullable GProStPublishFeedReq req, @Nullable IGPropublishFeedCallback cb5);

    void reportRecentViewFeed(@NotNull GProReportRecentViewFeedReq req, @NotNull IGproFeedOperateCallback cb5);

    void setTopComment(@NotNull GProSetTopCommentReq req, @NotNull IGProSetTopCommentCallback cb5);

    void topChannelFeed(@Nullable GProTopChannelFeedReq req, @Nullable IGProTopChannelFeedCallback cb5);

    void topFeedAction(@Nullable GProTopFeedActionReq req, @Nullable IGProTopFeedActionCallback cb5);

    void updateFeedInteractBlockedStatus(@NotNull GProUPdateFeedInteractSwitchReq req, @NotNull IGProUpdateFeedInteractBlockedStatusCallback cb5);
}
