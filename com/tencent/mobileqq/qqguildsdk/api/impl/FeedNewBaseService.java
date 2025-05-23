package com.tencent.mobileqq.qqguildsdk.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qqguildsdk.internal.KLog;
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
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B'\u0012\u0007\u0010\u0096\u0001\u001a\u00020\u0004\u0012\b\u0010\u0098\u0001\u001a\u00030\u0097\u0001\u0012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J$\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0017H\u0002J$\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0019H\u0002J$\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u001fH\u0002J$\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010!H\u0002J$\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010#H\u0002J$\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010%H\u0002J$\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010'H\u0002J$\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010)H\u0002J$\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010+H\u0002J$\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010-H\u0002J$\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010/H\u0002J$\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000101H\u0002J$\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000103H\u0002J$\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000105H\u0002J$\u00108\u001a\u0004\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000107H\u0002J$\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u000109H\u0002J$\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010;H\u0002J$\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010=H\u0002J$\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010?H\u0002J$\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010AH\u0002J$\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010CH\u0002J$\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010EH\u0002J$\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010GH\u0002J$\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010IH\u0002JN\u0010R\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\b2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bR\u0010SJN\u0010T\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u000b2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bT\u0010UJN\u0010V\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\r2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bV\u0010WJN\u0010X\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u000f2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bX\u0010YJN\u0010Z\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u00112#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bZ\u0010[JV\u0010^\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\\2\b\u0010L\u001a\u0004\u0018\u00010\u00132#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\b^\u0010_JN\u0010`\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u00152#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\b`\u0010aJN\u0010b\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u00172#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bb\u0010cJN\u0010d\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u00192#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bd\u0010eJN\u0010f\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u001b2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bf\u0010gJN\u0010h\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u001d2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bh\u0010iJN\u0010j\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u001f2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001f\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bj\u0010kJN\u0010l\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010!2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bl\u0010mJN\u0010n\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010#2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bn\u0010oJN\u0010p\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010%2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010%\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bp\u0010qJN\u0010r\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010'2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010'\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\br\u0010sJN\u0010t\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010)2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010)\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bt\u0010uJN\u0010v\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010+2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010+\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bv\u0010wJN\u0010x\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010-2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bx\u0010yJV\u0010z\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\\2\b\u0010L\u001a\u0004\u0018\u00010/2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010/\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\bz\u0010{JN\u0010|\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u0001012#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000101\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\b|\u0010}JN\u0010~\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u0001032#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0004\b~\u0010\u007fJQ\u0010\u0080\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u0001052#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000105\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001JQ\u0010\u0082\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u0001072#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000107\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001JQ\u0010\u0084\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u0001092#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000109\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001JQ\u0010\u0086\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010;2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010;\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JQ\u0010\u0088\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010=2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010=\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001JQ\u0010\u008a\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010?2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010?\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001JQ\u0010\u008c\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010A2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010A\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JQ\u0010\u008e\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010C2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010C\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001JQ\u0010\u0090\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010E2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010E\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001JQ\u0010\u0092\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010G2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010G\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001JQ\u0010\u0094\u0001\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010K2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010I2#\u0010Q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010I\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00020MH\u0004\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/FeedNewBaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService;", "", "method", "", "curSeq", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCountCallback;", "result", "q4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopFeedActionCallback;", ICustomDataEditor.STRING_ARRAY_PARAM_5, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDelFeedCallback;", "M3", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProMoveFeedCallback;", "R4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchManageOperateCallback;", "J3", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetChannelTimelineFeedsCallback;", "h4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGPropublishFeedCallback;", "j5", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;", "t4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCommentsCallback;", ICustomDataEditor.NUMBER_PARAM_4, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProAlterFeedCallback;", Constants.BASE_IN_APP_NAME, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", "V3", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoCommentCallback;", "P3", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoReplyCallback;", "Y3", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;", "O4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;", "S3", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchGetFeedDetailCallback;", Constants.EMULATOR_INFO, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetNextPageRepliesCallback;", "g5", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetFeedsCallback;", "d5", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGproFeedOperateCallback;", "m5", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetGuildFeedsCallback;", "z4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedConfigCallback;", "C4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopChannelFeedCallback;", "X4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedsCallback;", "F4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopicFeedsCallback;", "I4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;", "w4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetImmersiveFeedsCallback;", "L4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedNoticesCallback;", "c4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetAllFeedNoticesCallback;", "b4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProPreloadGuildFeedsCallback;", "U4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetExternalCommentsCallback;", "k4", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDeleteFeedInteractNoticeCallback;", "p5", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProUpdateFeedInteractBlockedStatusCallback;", ICustomDataEditor.STRING_PARAM_5, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedLikeUserListCallback;", "A3", "T", "cb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uCb", WidgetCacheConstellationData.WORK, "f3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCountCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ICustomDataEditor.STRING_PARAM_3, "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopFeedActionCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "W2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDelFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "p3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProMoveFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "V2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchManageOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", VideoProxy.PARAM_ENABLE_CACHE, "y3", "(Ljava/lang/String;ZLcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetChannelTimelineFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "w3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGPropublishFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "g3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "e3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedCommentsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "T2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProAlterFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ICustomDataEditor.STRING_ARRAY_PARAM_3, "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Y2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoCommentCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "b3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoReplyCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "o3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProImpeachCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Z2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "U2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProBatchGetFeedDetailCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "v3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetNextPageRepliesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "u3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProgetFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "x3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGproFeedOperateCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "z3", "(Ljava/lang/String;ZLcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetGuildFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "l3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedConfigCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "r3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTopChannelFeedCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "m3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", ICustomDataEditor.NUMBER_PARAM_3, "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetTopicFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "j3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedsByIndexCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "k3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetImmersiveFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "i3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedNoticesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "c3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetAllFeedNoticesCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "q3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProPreloadGuildFeedsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "d3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetExternalCommentsCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "X2", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDeleteFeedInteractNoticeCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "t3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProUpdateFeedInteractBlockedStatusCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "h3", "(Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedLikeUserListCallback;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "subTag", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "service", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;Ljava/lang/Object;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class FeedNewBaseService<L, S> extends BaseService<L, S> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNewBaseService(@NotNull String subTag, @NotNull ServiceContent content, @Nullable S s16) {
        super(subTag, content, s16);
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetFeedLikeUserListCallback A3(final String method, final int curSeq, final IGProGetFeedLikeUserListCallback result) {
        if (result != null) {
            return new IGProGetFeedLikeUserListCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.i
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedLikeUserListCallback
                public final void onResult(int i3, String str, GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
                    FeedNewBaseService.B3(FeedNewBaseService.this, method, curSeq, result, i3, str, gProFeedLikeUserListRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetGuildFeedsCallback it, final int i16, final String str, final boolean z16, final GProGetGuildFeedsRsp gProGetGuildFeedsRsp, final GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.aq
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.B4(FeedNewBaseService.this, method, i16, str, guildInteractiveNotificationItem, i3, it, z16, gProGetGuildFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B3(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetFeedLikeUserListCallback it, final int i16, final String str, final GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ab
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.C3(FeedNewBaseService.this, method, i16, str, i3, it, gProFeedLikeUserListRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B4(FeedNewBaseService this$0, String method, int i3, String str, GuildInteractiveNotificationItem guildInteractiveNotificationItem, int i16, IGProGetGuildFeedsCallback it, boolean z16, GProGetGuildFeedsRsp gProGetGuildFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str), TuplesKt.to("notificationItem", guildInteractiveNotificationItem)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProGetGuildFeedsRsp, guildInteractiveNotificationItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetFeedLikeUserListCallback it, GProFeedLikeUserListRsp gProFeedLikeUserListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProFeedLikeUserListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetTopFeedConfigCallback C4(final String method, final int curSeq, final IGProGetTopFeedConfigCallback result) {
        if (result != null) {
            return new IGProGetTopFeedConfigCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bn
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedConfigCallback
                public final void onResult(int i3, String str, GProGetTopFeedConfigRsp gProGetTopFeedConfigRsp) {
                    FeedNewBaseService.D4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetTopFeedConfigRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProAlterFeedCallback D3(final String method, final int curSeq, final IGProAlterFeedCallback result) {
        if (result != null) {
            return new IGProAlterFeedCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bh
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProAlterFeedCallback
                public final void onResult(int i3, String str, boolean z16, GProStAlterFeedRsp gProStAlterFeedRsp) {
                    FeedNewBaseService.E3(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStAlterFeedRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetTopFeedConfigCallback it, final int i16, final String str, final GProGetTopFeedConfigRsp gProGetTopFeedConfigRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.E4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetTopFeedConfigRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E3(final FeedNewBaseService this$0, final String method, final int i3, final IGProAlterFeedCallback it, final int i16, final String str, final boolean z16, final GProStAlterFeedRsp gProStAlterFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bm
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.F3(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStAlterFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetTopFeedConfigCallback it, GProGetTopFeedConfigRsp gProGetTopFeedConfigRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetTopFeedConfigRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProAlterFeedCallback it, boolean z16, GProStAlterFeedRsp gProStAlterFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStAlterFeedRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetTopFeedsCallback F4(final String method, final int curSeq, final IGProGetTopFeedsCallback result) {
        if (result != null) {
            return new IGProGetTopFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.w
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedsCallback
                public final void onResult(int i3, String str, GProGetTopFeedsRsp gProGetTopFeedsRsp) {
                    FeedNewBaseService.G4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetTopFeedsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProBatchGetFeedDetailCallback G3(final String method, final int curSeq, final IGProBatchGetFeedDetailCallback result) {
        if (result != null) {
            return new IGProBatchGetFeedDetailCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.az
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchGetFeedDetailCallback
                public final void onResult(int i3, String str, boolean z16, GProBatchGetFeedDetailRsp gProBatchGetFeedDetailRsp) {
                    FeedNewBaseService.H3(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProBatchGetFeedDetailRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetTopFeedsCallback it, final int i16, final String str, final GProGetTopFeedsRsp gProGetTopFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.aj
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.H4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetTopFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H3(final FeedNewBaseService this$0, final String method, final int i3, final IGProBatchGetFeedDetailCallback it, final int i16, final String str, final boolean z16, final GProBatchGetFeedDetailRsp gProBatchGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bc
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.I3(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProBatchGetFeedDetailRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetTopFeedsCallback it, GProGetTopFeedsRsp gProGetTopFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetTopFeedsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProBatchGetFeedDetailCallback it, boolean z16, GProBatchGetFeedDetailRsp gProBatchGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProBatchGetFeedDetailRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetTopicFeedsCallback I4(final String method, final int curSeq, final IGProGetTopicFeedsCallback result) {
        if (result != null) {
            return new IGProGetTopicFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.x
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopicFeedsCallback
                public final void onResult(int i3, String str, GProGetTopicFeedsRsp gProGetTopicFeedsRsp) {
                    FeedNewBaseService.J4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetTopicFeedsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProBatchManageOperateCallback J3(final String method, final int curSeq, final IGProBatchManageOperateCallback result) {
        if (result != null) {
            return new IGProBatchManageOperateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.q
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchManageOperateCallback
                public final void onResult(int i3, String str, GProBatchManageOperateRsp gProBatchManageOperateRsp) {
                    FeedNewBaseService.K3(FeedNewBaseService.this, method, curSeq, result, i3, str, gProBatchManageOperateRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetTopicFeedsCallback it, final int i16, final String str, final GProGetTopicFeedsRsp gProGetTopicFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.aw
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.K4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetTopicFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(final FeedNewBaseService this$0, final String method, final int i3, final IGProBatchManageOperateCallback it, final int i16, final String str, final GProBatchManageOperateRsp gProBatchManageOperateRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.aa
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.L3(FeedNewBaseService.this, method, i16, str, i3, it, gProBatchManageOperateRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetTopicFeedsCallback it, GProGetTopicFeedsRsp gProGetTopicFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetTopicFeedsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProBatchManageOperateCallback it, GProBatchManageOperateRsp gProBatchManageOperateRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProBatchManageOperateRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetImmersiveFeedsCallback L4(final String method, final int curSeq, final IGProGetImmersiveFeedsCallback result) {
        if (result != null) {
            return new IGProGetImmersiveFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.s
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetImmersiveFeedsCallback
                public final void onResult(int i3, String str, GProGetImmersiveFeedsRsp gProGetImmersiveFeedsRsp) {
                    FeedNewBaseService.M4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetImmersiveFeedsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProDelFeedCallback M3(final String method, final int curSeq, final IGProDelFeedCallback result) {
        if (result != null) {
            return new IGProDelFeedCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.y
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDelFeedCallback
                public final void onResult(int i3, String str, GProStDelFeedRsp gProStDelFeedRsp) {
                    FeedNewBaseService.N3(FeedNewBaseService.this, method, curSeq, result, i3, str, gProStDelFeedRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetImmersiveFeedsCallback it, final int i16, final String str, final GProGetImmersiveFeedsRsp gProGetImmersiveFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.an
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.N4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetImmersiveFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N3(final FeedNewBaseService this$0, final String method, final int i3, final IGProDelFeedCallback it, final int i16, final String str, final GProStDelFeedRsp gProStDelFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.au
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.O3(FeedNewBaseService.this, method, i16, str, i3, it, gProStDelFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetImmersiveFeedsCallback it, GProGetImmersiveFeedsRsp gProGetImmersiveFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetImmersiveFeedsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProDelFeedCallback it, GProStDelFeedRsp gProStDelFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProStDelFeedRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProImpeachCallback O4(final String method, final int curSeq, final IGProImpeachCallback result) {
        if (result != null) {
            return new IGProImpeachCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProImpeachCallback
                public final void onResult(int i3, String str, boolean z16, GProImpeachRsp gProImpeachRsp) {
                    FeedNewBaseService.P4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProImpeachRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProDoCommentCallback P3(final String method, final int curSeq, final IGProDoCommentCallback result) {
        if (result != null) {
            return new IGProDoCommentCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ah
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoCommentRsp gProStDoCommentRsp) {
                    FeedNewBaseService.Q3(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStDoCommentRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P4(final FeedNewBaseService this$0, final String method, final int i3, final IGProImpeachCallback it, final int i16, final String str, final boolean z16, final GProImpeachRsp gProImpeachRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bo
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.Q4(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProImpeachRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q3(final FeedNewBaseService this$0, final String method, final int i3, final IGProDoCommentCallback it, final int i16, final String str, final boolean z16, final GProStDoCommentRsp gProStDoCommentRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ay
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.R3(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStDoCommentRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProImpeachCallback it, boolean z16, GProImpeachRsp gProImpeachRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProImpeachRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProDoCommentCallback it, boolean z16, GProStDoCommentRsp gProStDoCommentRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStDoCommentRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProMoveFeedCallback R4(final String method, final int curSeq, final IGProMoveFeedCallback result) {
        if (result != null) {
            return new IGProMoveFeedCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ao
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProMoveFeedCallback
                public final void onResult(int i3, String str, GProMoveFeedRsp gProMoveFeedRsp) {
                    FeedNewBaseService.S4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProMoveFeedRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProDoFeedPreferCallback S3(final String method, final int curSeq, final IGProDoFeedPreferCallback result) {
        if (result != null) {
            return new IGProDoFeedPreferCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback
                public final void onResult(int i3, String str, boolean z16, GProDoFeedPreferRsp gProDoFeedPreferRsp) {
                    FeedNewBaseService.T3(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProDoFeedPreferRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S4(final FeedNewBaseService this$0, final String method, final int i3, final IGProMoveFeedCallback it, final int i16, final String str, final GProMoveFeedRsp gProMoveFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ba
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.T4(FeedNewBaseService.this, method, i16, str, i3, it, gProMoveFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T3(final FeedNewBaseService this$0, final String method, final int i3, final IGProDoFeedPreferCallback it, final int i16, final String str, final boolean z16, final GProDoFeedPreferRsp gProDoFeedPreferRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.U3(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProDoFeedPreferRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProMoveFeedCallback it, GProMoveFeedRsp gProMoveFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProMoveFeedRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProDoFeedPreferCallback it, boolean z16, GProDoFeedPreferRsp gProDoFeedPreferRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProDoFeedPreferRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProPreloadGuildFeedsCallback U4(final String method, final int curSeq, final IGProPreloadGuildFeedsCallback result) {
        if (result != null) {
            return new IGProPreloadGuildFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ai
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreloadGuildFeedsCallback
                public final void onResult(int i3, String str, GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp) {
                    FeedNewBaseService.V4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProPreloadGuildFeedsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProDoLikeCallback V3(final String method, final int curSeq, final IGProDoLikeCallback result) {
        if (result != null) {
            return new IGProDoLikeCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.o
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoLikeRsp gProStDoLikeRsp) {
                    FeedNewBaseService.W3(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStDoLikeRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V4(final FeedNewBaseService this$0, final String method, final int i3, final IGProPreloadGuildFeedsCallback it, final int i16, final String str, final GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bd
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.W4(FeedNewBaseService.this, method, i16, str, i3, it, gProPreloadGuildFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W3(final FeedNewBaseService this$0, final String method, final int i3, final IGProDoLikeCallback it, final int i16, final String str, final boolean z16, final GProStDoLikeRsp gProStDoLikeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bp
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.X3(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStDoLikeRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProPreloadGuildFeedsCallback it, GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProPreloadGuildFeedsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X3(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProDoLikeCallback it, boolean z16, GProStDoLikeRsp gProStDoLikeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStDoLikeRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProTopChannelFeedCallback X4(final String method, final int curSeq, final IGProTopChannelFeedCallback result) {
        if (result != null) {
            return new IGProTopChannelFeedCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.z
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback
                public final void onResult(int i3, String str, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
                    FeedNewBaseService.Y4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProTopChannelFeedRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProDoReplyCallback Y3(final String method, final int curSeq, final IGProDoReplyCallback result) {
        if (result != null) {
            return new IGProDoReplyCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ag
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoReplyRsp gProStDoReplyRsp) {
                    FeedNewBaseService.Z3(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStDoReplyRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y4(final FeedNewBaseService this$0, final String method, final int i3, final IGProTopChannelFeedCallback it, final int i16, final String str, final GProTopChannelFeedRsp gProTopChannelFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.Z4(FeedNewBaseService.this, method, i16, str, i3, it, gProTopChannelFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z3(final FeedNewBaseService this$0, final String method, final int i3, final IGProDoReplyCallback it, final int i16, final String str, final boolean z16, final GProStDoReplyRsp gProStDoReplyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.am
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.a4(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStDoReplyRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProTopChannelFeedCallback it, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProTopChannelFeedRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProDoReplyCallback it, boolean z16, GProStDoReplyRsp gProStDoReplyRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStDoReplyRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProTopFeedActionCallback a5(final String method, final int curSeq, final IGProTopFeedActionCallback result) {
        if (result != null) {
            return new IGProTopFeedActionCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.af
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopFeedActionCallback
                public final void onResult(int i3, String str, GProTopFeedActionRsp gProTopFeedActionRsp) {
                    FeedNewBaseService.b5(FeedNewBaseService.this, method, curSeq, result, i3, str, gProTopFeedActionRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetAllFeedNoticesCallback b4(final String method, final int curSeq, final IGProGetAllFeedNoticesCallback result) {
        if (result != null) {
            return new IGProGetAllFeedNoticesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.m
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetAllFeedNoticesCallback
                public final void onResult(int i3, String str, boolean z16, int i16, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
                    FeedNewBaseService.f4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, i16, gProGetFeedNoticesRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b5(final FeedNewBaseService this$0, final String method, final int i3, final IGProTopFeedActionCallback it, final int i16, final String str, final GProTopFeedActionRsp gProTopFeedActionRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.as
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.c5(FeedNewBaseService.this, method, i16, str, i3, it, gProTopFeedActionRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetFeedNoticesCallback c4(final String method, final int curSeq, final IGProGetFeedNoticesCallback result) {
        if (result != null) {
            return new IGProGetFeedNoticesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.t
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedNoticesCallback
                public final void onResult(int i3, String str, boolean z16, int i16, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
                    FeedNewBaseService.d4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, i16, gProGetFeedNoticesRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProTopFeedActionCallback it, GProTopFeedActionRsp gProTopFeedActionRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProTopFeedActionRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetFeedNoticesCallback it, final int i16, final String str, final boolean z16, final int i17, final GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ax
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.e4(FeedNewBaseService.this, method, i16, str, z16, i3, it, i17, gProGetFeedNoticesRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProgetFeedsCallback d5(final String method, final int curSeq, final IGProgetFeedsCallback result) {
        if (result != null) {
            return new IGProgetFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ar
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetFeedsCallback
                public final void onResult(int i3, String str, boolean z16, GProGetFeedsRsp gProGetFeedsRsp) {
                    FeedNewBaseService.e5(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProGetFeedsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e4(FeedNewBaseService this$0, String method, int i3, String str, boolean z16, int i16, IGProGetFeedNoticesCallback it, int i17, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str), TuplesKt.to("cache", Boolean.valueOf(z16))}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, i17, gProGetFeedNoticesRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e5(final FeedNewBaseService this$0, final String method, final int i3, final IGProgetFeedsCallback it, final int i16, final String str, final boolean z16, final GProGetFeedsRsp gProGetFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bb
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.f5(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProGetFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetAllFeedNoticesCallback it, final int i16, final String str, final boolean z16, final int i17, final GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ac
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.g4(FeedNewBaseService.this, method, i16, str, z16, i17, i3, it, gProGetFeedNoticesRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProgetFeedsCallback it, boolean z16, GProGetFeedsRsp gProGetFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProGetFeedsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g4(FeedNewBaseService this$0, String method, int i3, String str, boolean z16, int i16, int i17, IGProGetAllFeedNoticesCallback it, GProGetFeedNoticesRsp gProGetFeedNoticesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str), TuplesKt.to("cache", Boolean.valueOf(z16)), TuplesKt.to("unreadCount", Integer.valueOf(i16))}, Integer.valueOf(i17));
        it.onResult(i3, str, z16, i16, gProGetFeedNoticesRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProgetNextPageRepliesCallback g5(final String method, final int curSeq, final IGProgetNextPageRepliesCallback result) {
        if (result != null) {
            return new IGProgetNextPageRepliesCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bg
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetNextPageRepliesCallback
                public final void onResult(int i3, String str, boolean z16, GProGetNextPageRepliesRsp gProGetNextPageRepliesRsp) {
                    FeedNewBaseService.h5(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProGetNextPageRepliesRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetChannelTimelineFeedsCallback h4(final String method, final int curSeq, final IGProGetChannelTimelineFeedsCallback result) {
        if (result != null) {
            return new IGProGetChannelTimelineFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ae
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTimelineFeedsCallback
                public final void onResult(int i3, String str, boolean z16, GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
                    FeedNewBaseService.i4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStGetChannelFeedsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h5(final FeedNewBaseService this$0, final String method, final int i3, final IGProgetNextPageRepliesCallback it, final int i16, final String str, final boolean z16, final GProGetNextPageRepliesRsp gProGetNextPageRepliesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.i5(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProGetNextPageRepliesRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetChannelTimelineFeedsCallback it, final int i16, final String str, final boolean z16, final GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ap
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.j4(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStGetChannelFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProgetNextPageRepliesCallback it, boolean z16, GProGetNextPageRepliesRsp gProGetNextPageRepliesRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProGetNextPageRepliesRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetChannelTimelineFeedsCallback it, boolean z16, GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStGetChannelFeedsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPropublishFeedCallback j5(final String method, final int curSeq, final IGPropublishFeedCallback result) {
        if (result != null) {
            return new IGPropublishFeedCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bi
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGPropublishFeedCallback
                public final void onResult(int i3, String str, boolean z16, GProStPublishFeedRsp gProStPublishFeedRsp) {
                    FeedNewBaseService.k5(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStPublishFeedRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetExternalCommentsCallback k4(final String method, final int curSeq, final IGProGetExternalCommentsCallback result) {
        if (result != null) {
            return new IGProGetExternalCommentsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ad
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetExternalCommentsCallback
                public final void onResult(int i3, String str, GProGetExternalCommentsRsp gProGetExternalCommentsRsp) {
                    FeedNewBaseService.l4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetExternalCommentsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k5(final FeedNewBaseService this$0, final String method, final int i3, final IGPropublishFeedCallback it, final int i16, final String str, final boolean z16, final GProStPublishFeedRsp gProStPublishFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bl
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.l5(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStPublishFeedRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetExternalCommentsCallback it, final int i16, final String str, final GProGetExternalCommentsRsp gProGetExternalCommentsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.al
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.m4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetExternalCommentsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGPropublishFeedCallback it, boolean z16, GProStPublishFeedRsp gProStPublishFeedRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStPublishFeedRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetExternalCommentsCallback it, GProGetExternalCommentsRsp gProGetExternalCommentsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetExternalCommentsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGproFeedOperateCallback m5(final String method, final int curSeq, final IGproFeedOperateCallback result) {
        if (result != null) {
            return new IGproFeedOperateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bq
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGproFeedOperateCallback
                public final void onResult(int i3, String str) {
                    FeedNewBaseService.n5(FeedNewBaseService.this, method, curSeq, result, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetFeedCommentsCallback n4(final String method, final int curSeq, final IGProGetFeedCommentsCallback result) {
        if (result != null) {
            return new IGProGetFeedCommentsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.av
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCommentsCallback
                public final void onResult(int i3, String str, boolean z16, GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
                    FeedNewBaseService.o4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStGetFeedCommentsRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n5(final FeedNewBaseService this$0, final String method, final int i3, final IGproFeedOperateCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.o5(FeedNewBaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetFeedCommentsCallback it, final int i16, final String str, final boolean z16, final GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.p4(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStGetFeedCommentsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGproFeedOperateCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetFeedCommentsCallback it, boolean z16, GProStGetFeedCommentsRsp gProStGetFeedCommentsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStGetFeedCommentsRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProDeleteFeedInteractNoticeCallback p5(final String method, final int curSeq, final IGProDeleteFeedInteractNoticeCallback result) {
        if (result != null) {
            return new IGProDeleteFeedInteractNoticeCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bf
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDeleteFeedInteractNoticeCallback
                public final void onResult(int i3, String str) {
                    FeedNewBaseService.q5(FeedNewBaseService.this, method, curSeq, result, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetFeedCountCallback q4(final String method, final int curSeq, final IGProGetFeedCountCallback result) {
        if (result != null) {
            return new IGProGetFeedCountCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.f
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCountCallback
                public final void onResult(int i3, String str, GProGetFeedCountRsp gProGetFeedCountRsp) {
                    FeedNewBaseService.r4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetFeedCountRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q5(final FeedNewBaseService this$0, final String method, final int i3, final IGProDeleteFeedInteractNoticeCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bk
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.r5(FeedNewBaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetFeedCountCallback it, final int i16, final String str, final GProGetFeedCountRsp gProGetFeedCountRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.s4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetFeedCountRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProDeleteFeedInteractNoticeCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetFeedCountCallback it, GProGetFeedCountRsp gProGetFeedCountRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetFeedCountRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProUpdateFeedInteractBlockedStatusCallback s5(final String method, final int curSeq, final IGProUpdateFeedInteractBlockedStatusCallback result) {
        if (result != null) {
            return new IGProUpdateFeedInteractBlockedStatusCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.be
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProUpdateFeedInteractBlockedStatusCallback
                public final void onResult(int i3, String str) {
                    FeedNewBaseService.t5(FeedNewBaseService.this, method, curSeq, result, i3, str);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetFeedDetailCallback t4(final String method, final int curSeq, final IGProGetFeedDetailCallback result) {
        if (result != null) {
            return new IGProGetFeedDetailCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.ak
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
                public final void onResult(int i3, String str, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
                    FeedNewBaseService.u4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProStGetFeedDetailRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t5(final FeedNewBaseService this$0, final String method, final int i3, final IGProUpdateFeedInteractBlockedStatusCallback it, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bj
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.u5(FeedNewBaseService.this, method, i16, str, i3, it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetFeedDetailCallback it, final int i16, final String str, final boolean z16, final GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.n
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.v4(FeedNewBaseService.this, method, i16, str, i3, it, z16, gProStGetFeedDetailRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u5(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProUpdateFeedInteractBlockedStatusCallback it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetFeedDetailCallback it, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, z16, gProStGetFeedDetailRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetFeedsByIndexCallback w4(final String method, final int curSeq, final IGProGetFeedsByIndexCallback result) {
        if (result != null) {
            return new IGProGetFeedsByIndexCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.v
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedsByIndexCallback
                public final void onResult(int i3, String str, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
                    FeedNewBaseService.x4(FeedNewBaseService.this, method, curSeq, result, i3, str, gProGetFeedsByIndexRsp);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x4(final FeedNewBaseService this$0, final String method, final int i3, final IGProGetFeedsByIndexCallback it, final int i16, final String str, final GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.at
            @Override // java.lang.Runnable
            public final void run() {
                FeedNewBaseService.y4(FeedNewBaseService.this, method, i16, str, i3, it, gProGetFeedsByIndexRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y4(FeedNewBaseService this$0, String method, int i3, String str, int i16, IGProGetFeedsByIndexCallback it, GProGetFeedsByIndexRsp gProGetFeedsByIndexRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(it, "$it");
        KLog.f268416a.d(this$0.getSubTag(), new Object[]{TuplesKt.to("method", method), TuplesKt.to("result", Integer.valueOf(i3)), TuplesKt.to("errMsg", str)}, Integer.valueOf(i16));
        it.onResult(i3, str, gProGetFeedsByIndexRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGetGuildFeedsCallback z4(final String method, final int curSeq, final IGProGetGuildFeedsCallback result) {
        if (result != null) {
            return new IGProGetGuildFeedsCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.u
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildFeedsCallback
                public final void onResult(int i3, String str, boolean z16, GProGetGuildFeedsRsp gProGetGuildFeedsRsp, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
                    FeedNewBaseService.A4(FeedNewBaseService.this, method, curSeq, result, i3, str, z16, gProGetGuildFeedsRsp, guildInteractiveNotificationItem);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T T2(@NotNull final String method, @Nullable final IGProAlterFeedCallback cb5, @NotNull final Function1<? super IGProAlterFeedCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().f(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$11
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
                IGProAlterFeedCallback D3;
                Function1<IGProAlterFeedCallback, T> function1 = work;
                D3 = this.D3(method, i3, cb5);
                return function1.invoke(D3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T U2(@NotNull final String method, @Nullable final IGProBatchGetFeedDetailCallback cb5, @NotNull final Function1<? super IGProBatchGetFeedDetailCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().g(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$18
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
                IGProBatchGetFeedDetailCallback G3;
                Function1<IGProBatchGetFeedDetailCallback, T> function1 = work;
                G3 = this.G3(method, i3, cb5);
                return function1.invoke(G3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T V2(@NotNull final String method, @Nullable final IGProBatchManageOperateCallback cb5, @NotNull final Function1<? super IGProBatchManageOperateCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().h(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$5
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
                IGProBatchManageOperateCallback J3;
                Function1<IGProBatchManageOperateCallback, T> function1 = work;
                J3 = this.J3(method, i3, cb5);
                return function1.invoke(J3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T W2(@NotNull final String method, @Nullable final IGProDelFeedCallback cb5, @NotNull final Function1<? super IGProDelFeedCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().i(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$3
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
                IGProDelFeedCallback M3;
                Function1<IGProDelFeedCallback, T> function1 = work;
                M3 = this.M3(method, i3, cb5);
                return function1.invoke(M3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T X2(@NotNull final String method, @Nullable final IGProDeleteFeedInteractNoticeCallback cb5, @NotNull final Function1<? super IGProDeleteFeedInteractNoticeCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().j(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$42
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
                IGProDeleteFeedInteractNoticeCallback p56;
                Function1<IGProDeleteFeedInteractNoticeCallback, T> function1 = work;
                p56 = this.p5(method, i3, cb5);
                return function1.invoke(p56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T Y2(@NotNull final String method, @Nullable final IGProDoCommentCallback cb5, @NotNull final Function1<? super IGProDoCommentCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().k(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$13
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
                IGProDoCommentCallback P3;
                Function1<IGProDoCommentCallback, T> function1 = work;
                P3 = this.P3(method, i3, cb5);
                return function1.invoke(P3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T Z2(@NotNull final String method, @Nullable final IGProDoFeedPreferCallback cb5, @NotNull final Function1<? super IGProDoFeedPreferCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().l(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$17
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
                IGProDoFeedPreferCallback S3;
                Function1<IGProDoFeedPreferCallback, T> function1 = work;
                S3 = this.S3(method, i3, cb5);
                return function1.invoke(S3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T a3(@NotNull final String method, @Nullable final IGProDoLikeCallback cb5, @NotNull final Function1<? super IGProDoLikeCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().m(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$12
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
                IGProDoLikeCallback V3;
                Function1<IGProDoLikeCallback, T> function1 = work;
                V3 = this.V3(method, i3, cb5);
                return function1.invoke(V3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T b3(@NotNull final String method, @Nullable final IGProDoReplyCallback cb5, @NotNull final Function1<? super IGProDoReplyCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().n(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$14
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
                IGProDoReplyCallback Y3;
                Function1<IGProDoReplyCallback, T> function1 = work;
                Y3 = this.Y3(method, i3, cb5);
                return function1.invoke(Y3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T c3(@NotNull final String method, @Nullable final IGProGetAllFeedNoticesCallback cb5, @NotNull final Function1<? super IGProGetAllFeedNoticesCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().o(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$36
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
                IGProGetAllFeedNoticesCallback b46;
                Function1<IGProGetAllFeedNoticesCallback, T> function1 = work;
                b46 = this.b4(method, i3, cb5);
                return function1.invoke(b46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T d3(@NotNull final String method, @Nullable final IGProGetExternalCommentsCallback cb5, @NotNull final Function1<? super IGProGetExternalCommentsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().p(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$41
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
                IGProGetExternalCommentsCallback k46;
                Function1<IGProGetExternalCommentsCallback, T> function1 = work;
                k46 = this.k4(method, i3, cb5);
                return function1.invoke(k46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T e3(@NotNull final String method, @Nullable final IGProGetFeedCommentsCallback cb5, @NotNull final Function1<? super IGProGetFeedCommentsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().q(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$9
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
                IGProGetFeedCommentsCallback n46;
                Function1<IGProGetFeedCommentsCallback, T> function1 = work;
                n46 = this.n4(method, i3, cb5);
                return function1.invoke(n46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T f3(@NotNull final String method, @Nullable final IGProGetFeedCountCallback cb5, @NotNull final Function1<? super IGProGetFeedCountCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().r(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$1
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
                IGProGetFeedCountCallback q46;
                Function1<IGProGetFeedCountCallback, T> function1 = work;
                q46 = this.q4(method, i3, cb5);
                return function1.invoke(q46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T g3(@NotNull final String method, @Nullable final IGProGetFeedDetailCallback cb5, @NotNull final Function1<? super IGProGetFeedDetailCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().s(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$8
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
                IGProGetFeedDetailCallback t46;
                Function1<IGProGetFeedDetailCallback, T> function1 = work;
                t46 = this.t4(method, i3, cb5);
                return function1.invoke(t46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T h3(@NotNull final String method, @Nullable final IGProGetFeedLikeUserListCallback cb5, @NotNull final Function1<? super IGProGetFeedLikeUserListCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().t(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$44
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
                IGProGetFeedLikeUserListCallback A3;
                Function1<IGProGetFeedLikeUserListCallback, T> function1 = work;
                A3 = this.A3(method, i3, cb5);
                return function1.invoke(A3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T i3(@NotNull final String method, @Nullable final IGProGetFeedNoticesCallback cb5, @NotNull final Function1<? super IGProGetFeedNoticesCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().u(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$34
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
                IGProGetFeedNoticesCallback c46;
                Function1<IGProGetFeedNoticesCallback, T> function1 = work;
                c46 = this.c4(method, i3, cb5);
                return function1.invoke(c46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T j3(@NotNull final String method, @Nullable final IGProGetFeedsByIndexCallback cb5, @NotNull final Function1<? super IGProGetFeedsByIndexCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().v(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$30
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
                IGProGetFeedsByIndexCallback w46;
                Function1<IGProGetFeedsByIndexCallback, T> function1 = work;
                w46 = this.w4(method, i3, cb5);
                return function1.invoke(w46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T k3(@NotNull final String method, @Nullable final IGProGetImmersiveFeedsCallback cb5, @NotNull final Function1<? super IGProGetImmersiveFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().w(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$32
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
                IGProGetImmersiveFeedsCallback L4;
                Function1<IGProGetImmersiveFeedsCallback, T> function1 = work;
                L4 = this.L4(method, i3, cb5);
                return function1.invoke(L4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T l3(@NotNull final String method, @Nullable final IGProGetTopFeedConfigCallback cb5, @NotNull final Function1<? super IGProGetTopFeedConfigCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().x(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$24
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
                IGProGetTopFeedConfigCallback C4;
                Function1<IGProGetTopFeedConfigCallback, T> function1 = work;
                C4 = this.C4(method, i3, cb5);
                return function1.invoke(C4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T m3(@NotNull final String method, @Nullable final IGProGetTopFeedsCallback cb5, @NotNull final Function1<? super IGProGetTopFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().y(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$26
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
                IGProGetTopFeedsCallback F4;
                Function1<IGProGetTopFeedsCallback, T> function1 = work;
                F4 = this.F4(method, i3, cb5);
                return function1.invoke(F4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T n3(@NotNull final String method, @Nullable final IGProGetTopicFeedsCallback cb5, @NotNull final Function1<? super IGProGetTopicFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().z(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$28
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
                IGProGetTopicFeedsCallback I4;
                Function1<IGProGetTopicFeedsCallback, T> function1 = work;
                I4 = this.I4(method, i3, cb5);
                return function1.invoke(I4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T o3(@NotNull final String method, @Nullable final IGProImpeachCallback cb5, @NotNull final Function1<? super IGProImpeachCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().B(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$15
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
                IGProImpeachCallback O4;
                Function1<IGProImpeachCallback, T> function1 = work;
                O4 = this.O4(method, i3, cb5);
                return function1.invoke(O4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T p3(@NotNull final String method, @Nullable final IGProMoveFeedCallback cb5, @NotNull final Function1<? super IGProMoveFeedCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().C(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$4
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
                IGProMoveFeedCallback R4;
                Function1<IGProMoveFeedCallback, T> function1 = work;
                R4 = this.R4(method, i3, cb5);
                return function1.invoke(R4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T q3(@NotNull final String method, @Nullable final IGProPreloadGuildFeedsCallback cb5, @NotNull final Function1<? super IGProPreloadGuildFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().D(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$40
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
                IGProPreloadGuildFeedsCallback U4;
                Function1<IGProPreloadGuildFeedsCallback, T> function1 = work;
                U4 = this.U4(method, i3, cb5);
                return function1.invoke(U4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T r3(@NotNull final String method, @Nullable final IGProTopChannelFeedCallback cb5, @NotNull final Function1<? super IGProTopChannelFeedCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().E(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$25
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
                IGProTopChannelFeedCallback X4;
                Function1<IGProTopChannelFeedCallback, T> function1 = work;
                X4 = this.X4(method, i3, cb5);
                return function1.invoke(X4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T s3(@NotNull final String method, @Nullable final IGProTopFeedActionCallback cb5, @NotNull final Function1<? super IGProTopFeedActionCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().F(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$2
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
                IGProTopFeedActionCallback a56;
                Function1<IGProTopFeedActionCallback, T> function1 = work;
                a56 = this.a5(method, i3, cb5);
                return function1.invoke(a56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T t3(@NotNull final String method, @Nullable final IGProUpdateFeedInteractBlockedStatusCallback cb5, @NotNull final Function1<? super IGProUpdateFeedInteractBlockedStatusCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().G(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$43
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
                IGProUpdateFeedInteractBlockedStatusCallback s56;
                Function1<IGProUpdateFeedInteractBlockedStatusCallback, T> function1 = work;
                s56 = this.s5(method, i3, cb5);
                return function1.invoke(s56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T u3(@NotNull final String method, @Nullable final IGProgetFeedsCallback cb5, @NotNull final Function1<? super IGProgetFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().H(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$20
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
                IGProgetFeedsCallback d56;
                Function1<IGProgetFeedsCallback, T> function1 = work;
                d56 = this.d5(method, i3, cb5);
                return function1.invoke(d56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T v3(@NotNull final String method, @Nullable final IGProgetNextPageRepliesCallback cb5, @NotNull final Function1<? super IGProgetNextPageRepliesCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().I(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$19
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
                IGProgetNextPageRepliesCallback g56;
                Function1<IGProgetNextPageRepliesCallback, T> function1 = work;
                g56 = this.g5(method, i3, cb5);
                return function1.invoke(g56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T w3(@NotNull final String method, @Nullable final IGPropublishFeedCallback cb5, @NotNull final Function1<? super IGPropublishFeedCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().J(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$7
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
                IGPropublishFeedCallback j56;
                Function1<IGPropublishFeedCallback, T> function1 = work;
                j56 = this.j5(method, i3, cb5);
                return function1.invoke(j56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T x3(@NotNull final String method, @Nullable final IGproFeedOperateCallback cb5, @NotNull final Function1<? super IGproFeedOperateCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().K(getSubTag(), new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$22
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
                IGproFeedOperateCallback m56;
                Function1<IGproFeedOperateCallback, T> function1 = work;
                m56 = this.m5(method, i3, cb5);
                return function1.invoke(m56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T y3(@NotNull final String method, boolean enableCache, @Nullable final IGProGetChannelTimelineFeedsCallback cb5, @NotNull final Function1<? super IGProGetChannelTimelineFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().b(getSubTag(), enableCache, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$6
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
                IGProGetChannelTimelineFeedsCallback h46;
                Function1<IGProGetChannelTimelineFeedsCallback, T> function1 = work;
                h46 = this.h4(method, i3, cb5);
                return function1.invoke(h46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T z3(@NotNull final String method, boolean enableCache, @Nullable final IGProGetGuildFeedsCallback cb5, @NotNull final Function1<? super IGProGetGuildFeedsCallback, ? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) getContent().getMCallMonitor().c(getSubTag(), enableCache, new Object[]{TuplesKt.to("method", method)}, cb5, new Function1<Integer, T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.FeedNewBaseService$check$23
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
                IGProGetGuildFeedsCallback z46;
                Function1<IGProGetGuildFeedsCallback, T> function1 = work;
                z46 = this.z4(method, i3, cb5);
                return function1.invoke(z46);
            }
        });
    }
}
