package com.tencent.mobileqq.qqguildsdk.internal;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchManageOperateRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedLikeUserListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetExternalCommentsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedCountRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedNoticesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsByIndexRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetImmersiveFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedConfigRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopicFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImpeachRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMoveFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigateResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStAlterFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDelFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedCommentsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStPublishFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopChannelFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedActionRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchNavigateInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProAlterFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetFeedDetailCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchManageOperateCallback;
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
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProMoveFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreloadGuildFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopFeedActionCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetNextPageRepliesCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGPropublishFeedCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 <2\u00020\u0001:\u0001\u000fB\t\u00a2\u0006\u0006\b\u009f\u0001\u0010\u00a0\u0001J+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001H\u0002\u00a2\u0006\u0004\b\t\u0010\bJ\b\u0010\u000b\u001a\u00020\nH&J3\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b\u000f\u0010\u0010JT\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J^\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ^\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJ^\u0010 \u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001f2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b \u0010!J^\u0010#\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\"2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b#\u0010$J^\u0010&\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010%2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b&\u0010'J^\u0010)\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010(2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b)\u0010*J^\u0010,\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010+2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b,\u0010-J^\u0010/\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010.2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b/\u00100J^\u00102\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u0001012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b2\u00103J^\u00105\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u0001042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b5\u00106J^\u00108\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u0001072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b8\u00109Jf\u0010<\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\n2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010;2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b<\u0010=J^\u0010?\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010>2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b?\u0010@J^\u0010B\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010A2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bB\u0010CJ^\u0010E\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010D2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bE\u0010FJ^\u0010H\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010G2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bH\u0010IJ^\u0010K\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010J2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bK\u0010LJ^\u0010N\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010M2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bN\u0010OJ^\u0010Q\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010P2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bQ\u0010RJ^\u0010T\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010S2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bT\u0010UJ^\u0010W\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010V2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bW\u0010XJ^\u0010Z\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010Y2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bZ\u0010[J^\u0010]\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\\2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b]\u0010^J^\u0010`\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010_2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b`\u0010aJ^\u0010c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010b2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bc\u0010dJf\u0010f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\n2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010e2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bf\u0010gJ^\u0010i\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010h2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bi\u0010jJ^\u0010l\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010k2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bl\u0010mJ^\u0010o\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010n2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\bo\u0010pJ{\u0010v\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010q\u001a\u0004\u0018\u00018\u00002\u0018\u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060r2&\u0010u\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\u0012\u0004\u0012\u00020\u00060t\u00a2\u0006\u0004\bv\u0010wJ^\u0010y\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010x2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\by\u0010zJ^\u0010|\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010{2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b|\u0010}J_\u0010\u007f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010~2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001Jb\u0010\u0082\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u0081\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001Jb\u0010\u0085\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u0084\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001Jb\u0010\u0088\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001Jb\u0010\u008b\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u008a\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001Jb\u0010\u008e\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u008d\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001Jb\u0010\u0091\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u0090\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001Jb\u0010\u0094\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u0093\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001Jb\u0010\u0097\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u00012\t\u0010\u0019\u001a\u0005\u0018\u00010\u0096\u00012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001R(\u0010\u009e\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u000f\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/internal/CallMonitor;", "", "", "subTag", "", "msg", "", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;[Ljava/lang/Object;)V", "T", "", BdhLogUtil.LogTag.Tag_Req, "method", "Lkotlin/Function0;", WidgetCacheConstellationData.WORK, "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "seq", "P", "(Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IUnreadCntCallback;", "cb", "O", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IUnreadCntCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "N", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildFetchChannelLatestSeqCallback;", "L", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildFetchChannelLatestSeqCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchNavigateInfoCallback;", "e", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchNavigateInfoCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildGetMsgAbstractsCallback;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGuildGetMsgAbstractsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildInteractiveNotificationCallback;", "M", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildInteractiveNotificationCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCountCallback;", "r", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCountCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDelFeedCallback;", "i", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDelFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopFeedActionCallback;", UserInfo.SEX_FEMALE, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopFeedActionCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProMoveFeedCallback;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProMoveFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchManageOperateCallback;", h.F, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchManageOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", VideoProxy.PARAM_ENABLE_CACHE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetChannelTimelineFeedsCallback;", "b", "(Ljava/lang/String;Z[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetChannelTimelineFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGPropublishFeedCallback;", "J", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGPropublishFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCommentsCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCommentsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProAlterFeedCallback;", "f", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProAlterFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoCommentCallback;", "k", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoCommentCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoReplyCallback;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoReplyCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;", "B", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;", "l", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchGetFeedDetailCallback;", "g", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchGetFeedDetailCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetNextPageRepliesCallback;", "I", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetNextPageRepliesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetFeedsCallback;", "H", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGproFeedOperateCallback;", "K", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGproFeedOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetGuildFeedsCallback;", "c", "(Ljava/lang/String;Z[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetGuildFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedConfigCallback;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedConfigCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopChannelFeedCallback;", "E", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopChannelFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedsCallback;", "y", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "service", "Lkotlin/Function2;", "onCheckFail", "Lkotlin/Function3;", "onCheckSuccess", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopicFeedsCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopicFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;", "v", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetImmersiveFeedsCallback;", "w", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetImmersiveFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedNoticesCallback;", "u", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedNoticesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetAllFeedNoticesCallback;", "o", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetAllFeedNoticesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchListCallback;", "d", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProPreloadGuildFeedsCallback;", "D", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProPreloadGuildFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetExternalCommentsCallback;", "p", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetExternalCommentsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDeleteFeedInteractNoticeCallback;", "j", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDeleteFeedInteractNoticeCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProUpdateFeedInteractBlockedStatusCallback;", "G", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProUpdateFeedInteractBlockedStatusCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedLikeUserListCallback;", "t", "(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedLikeUserListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "U", "(Ljava/lang/String;)V", "errorMsg", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class CallMonitor {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static AtomicInteger f268414c = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String errorMsg = "";

    private final void S(String subTag, Object... msg2) {
        KLog.f268416a.b(subTag, Arrays.copyOf(msg2, msg2.length), Integer.valueOf(f268414c.incrementAndGet()));
    }

    private final void T(String subTag, Object... msg2) {
        KLog kLog = KLog.f268416a;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.addSpread(msg2);
        spreadBuilder.add("illegal!!!");
        spreadBuilder.add(this.errorMsg);
        kLog.d(subTag, spreadBuilder.toArray(new Object[spreadBuilder.size()]), Integer.valueOf(f268414c.incrementAndGet()));
    }

    @Nullable
    public final <T> T A(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGuildGetMsgAbstractsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onGetMsgAbstracts(-1, this.errorMsg, new ArrayList<>());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T B(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProImpeachCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProImpeachRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T C(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProMoveFeedCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProMoveFeedRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T D(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProPreloadGuildFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProPreloadGuildFeedsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T E(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProTopChannelFeedCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProTopChannelFeedRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T F(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProTopFeedActionCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProTopFeedActionRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T G(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProUpdateFeedInteractBlockedStatusCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg);
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T H(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProgetFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProGetFeedsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T I(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProgetNextPageRepliesCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProGetNextPageRepliesRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T J(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGPropublishFeedCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStPublishFeedRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T K(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGproFeedOperateCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg);
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T L(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGuildFetchChannelLatestSeqCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onFetchChannelLatestSeq(-1, this.errorMsg, 0L);
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T M(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGuildInteractiveNotificationCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GuildInteractiveNotificationItem());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T N(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGuildOperateCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg);
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T O(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IUnreadCntCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new ArrayList<>());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T P(@NotNull String subTag, @NotNull Object[] msg2, @NotNull Function1<? super Integer, ? extends T> work) {
        Object orNull;
        Object second;
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        Pair pair = null;
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            return null;
        }
        boolean z16 = false;
        orNull = ArraysKt___ArraysKt.getOrNull(msg2, 0);
        if (orNull instanceof Pair) {
            pair = (Pair) orNull;
        }
        if (pair != null && (second = pair.getSecond()) != null && second.equals("assembleMobileQQRichMediaFilePath")) {
            z16 = true;
        }
        if (!z16) {
            S(subTag, Arrays.copyOf(msg2, msg2.length));
        }
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    public final <S> void Q(@NotNull String subTag, @NotNull Object[] msg2, @Nullable S service, @NotNull Function2<? super Integer, ? super String, Unit> onCheckFail, @NotNull Function3<? super S, ? super Integer, ? super Object[], Unit> onCheckSuccess) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(onCheckFail, "onCheckFail");
        Intrinsics.checkNotNullParameter(onCheckSuccess, "onCheckSuccess");
        if (service == null) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            onCheckFail.invoke(-1, this.errorMsg);
        } else if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            onCheckFail.invoke(-1, this.errorMsg);
        } else {
            S(subTag, Arrays.copyOf(msg2, msg2.length));
            onCheckSuccess.invoke(service, Integer.valueOf(f268414c.get()), msg2);
        }
    }

    public abstract boolean R();

    public final void U(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMsg = str;
    }

    @Nullable
    public final <T> T a(@NotNull String subTag, @NotNull String method, @NotNull final Function0<? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) P(subTag, new Object[]{TuplesKt.to("method", method)}, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.internal.CallMonitor$check$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final T invoke(int i3) {
                return work.invoke();
            }
        });
    }

    @Nullable
    public final <T> T b(@NotNull String subTag, boolean enableCache, @NotNull Object[] msg2, @Nullable IGProGetChannelTimelineFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, enableCache, new GProStGetChannelFeedsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T c(@NotNull String subTag, boolean enableCache, @NotNull Object[] msg2, @Nullable IGProGetGuildFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, enableCache, new GProGetGuildFeedsRsp(), new GuildInteractiveNotificationItem());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T d(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IFetchListCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new ArrayList<>());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T e(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IFetchNavigateInfoCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onFetchNavigateInfo(-1, this.errorMsg, new GProNavigateResult());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T f(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProAlterFeedCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStAlterFeedRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T g(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProBatchGetFeedDetailCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProBatchGetFeedDetailRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T h(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProBatchManageOperateCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProBatchManageOperateRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T i(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProDelFeedCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProStDelFeedRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T j(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProDeleteFeedInteractNoticeCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg);
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T k(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProDoCommentCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStDoCommentRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T l(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProDoFeedPreferCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProDoFeedPreferRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T m(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProDoLikeCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStDoLikeRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T n(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProDoReplyCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStDoReplyRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T o(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetAllFeedNoticesCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, 0, new GProGetFeedNoticesRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T p(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetExternalCommentsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetExternalCommentsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T q(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetFeedCommentsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStGetFeedCommentsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T r(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetFeedCountCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetFeedCountRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T s(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetFeedDetailCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, new GProStGetFeedDetailRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T t(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetFeedLikeUserListCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProFeedLikeUserListRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T u(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetFeedNoticesCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, false, 0, new GProGetFeedNoticesRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T v(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetFeedsByIndexCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetFeedsByIndexRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T w(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetImmersiveFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetImmersiveFeedsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T x(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetTopFeedConfigCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetTopFeedConfigRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T y(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetTopFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetTopFeedsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }

    @Nullable
    public final <T> T z(@NotNull String subTag, @NotNull Object[] msg2, @Nullable IGProGetTopicFeedsCallback cb5, @NotNull Function1<? super Integer, ? extends T> work) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(work, "work");
        if (!R()) {
            T(subTag, Arrays.copyOf(msg2, msg2.length));
            if (cb5 != null) {
                cb5.onResult(-1, this.errorMsg, new GProGetTopicFeedsRsp());
                return null;
            }
            return null;
        }
        S(subTag, Arrays.copyOf(msg2, msg2.length));
        return work.invoke(Integer.valueOf(f268414c.get()));
    }
}
