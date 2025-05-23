package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.data.GProStFeedMemoryKeepSerializer;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProRecommendFeedWrapper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSimpleProfileAsyncRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.ca;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kn1.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;
import wh2.db;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 S2\u00020\u0001:\u0001TB\u000f\u0012\u0006\u0010G\u001a\u00020D\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0002JE\u0010*\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00162\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0002\u00a2\u0006\u0004\b*\u0010+JA\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020 H\u0002\u00a2\u0006\u0004\b,\u0010-J*\u0010.\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u00101\u001a\u000200H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0016H\u0002J\u0018\u0010:\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001092\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0012\u0010;\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010<\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010>\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u00101\u001a\u00020\u00162\u0006\u0010=\u001a\u00020&H\u0002J(\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\n\u0010C\u001a\u0004\u0018\u00010\u001aH\u0002R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010ER\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/DetailMainViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/AbsDetailViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "loadDataArgs", "", "y1", "e1", "", "E", "", "action", "", "args", "a0", "c", "t0", "getLogTag", "H2", "Lkn1/a;", "it", "p2", Constants.MMCCID, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "preloadData", "u2", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "cacheType", "E2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedDetailReq;", "m2", "", "startTime", "lastModifiedTime", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProGetFeedDetailCallback;", "f2", "feed", "", "result", "errMsg", "isDbCache", "y2", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;ILjava/lang/String;ZJLjava/lang/Long;)V", "B2", "(ILjava/lang/String;ZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Ljava/lang/Long;J)V", "x2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "stFeed", "o2", "Ltl1/g;", "w2", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "v2", SemanticAttributes.DbSystemValues.H2, "e2", "", "r2", "F2", "C2", "status", ICustomDataEditor.STRING_PARAM_2, "feedId", "I2", "l2", "k2", "q2", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "J", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "K", "useCacheEndTime", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "L", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "requestNetReportTask", "getIdentifier", "()I", IECDtReport.ACTION_IDENTIFIER, "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;)V", "M", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DetailMainViewModel extends AbsDetailViewModel {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final IPartHost partHost;

    /* renamed from: K, reason: from kotlin metadata */
    private long useCacheEndTime;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask requestNetReportTask;

    public DetailMainViewModel(@NotNull IPartHost partHost) {
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        this.partHost = partHost;
        this.useCacheEndTime = -1L;
        G2();
        H2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(int i3, GProStFeed gProStFeed, DetailMainViewModel this$0, String errMsg, boolean z16, Long l3, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        if (i3 == 0 && gProStFeed != null && !com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.a.b(gProStFeed)) {
            this$0.B2(i3, errMsg, z16, gProStFeed, l3, j3);
        } else {
            this$0.x2(i3, errMsg, gProStFeed, z16);
        }
    }

    private final void B2(int result, String errMsg, boolean isDbCache, GProStFeed feed, Long startTime, long lastModifiedTime) {
        long j3 = feed.meta.lastModifiedTime;
        if (lastModifiedTime > j3) {
            QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "handGetFeedDetailRsp cache invalid feedId=" + feed.idd + " oldTime=" + lastModifiedTime + " newTime" + j3);
            return;
        }
        FeedDetailMainData n26 = n2(feed);
        n26.A(Random.INSTANCE.nextLong());
        k2(n26);
        P1(1, r2(isDbCache));
        Q1("message_on_load_main_completed", new g.OnLoadMainCompletedMessage(true, result, isDbCache, i()));
        if (!isDbCache) {
            e2(feed);
        }
        if (startTime != null) {
            long longValue = startTime.longValue();
            String str = feed.idd;
            Intrinsics.checkNotNullExpressionValue(str, "feed.idd");
            I2(str, result, errMsg, longValue);
        }
    }

    private final void C2(Object args) {
        FeedDetailMainData m3;
        Integer num;
        qj1.h feedDetail;
        Object obj;
        boolean z16;
        qj1.h feedDetail2;
        if (!(args instanceof a.ModifyBottomInteractiveDataMessage)) {
            return;
        }
        FeedDetailMainData q26 = q2();
        FeedDetailMainData feedDetailMainData = null;
        GProStFeed gProStFeed = null;
        feedDetailMainData = null;
        if (q26 != null && (m3 = q26.m()) != null) {
            a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = (a.ModifyBottomInteractiveDataMessage) args;
            Integer commentCount = modifyBottomInteractiveDataMessage.getCommentCount();
            if (commentCount != null) {
                m3.x(Integer.valueOf(commentCount.intValue()));
            }
            Integer shareCount = modifyBottomInteractiveDataMessage.getShareCount();
            if (shareCount != null) {
                m3.B(Integer.valueOf(shareCount.intValue()));
            }
            Integer preferStatus = modifyBottomInteractiveDataMessage.getPreferStatus();
            if (preferStatus != null) {
                m3.z(Integer.valueOf(preferStatus.intValue()));
            }
            Integer preferCount = modifyBottomInteractiveDataMessage.getPreferCount();
            if (preferCount != null) {
                m3.y(Integer.valueOf(preferCount.intValue()));
            }
            FeedDetailMainData q27 = q2();
            if (q27 == null || (num = q27.getPreferStatus()) == null) {
                FeedDetailMainData q28 = q2();
                if (q28 != null && (feedDetail = q28.getFeedDetail()) != null) {
                    num = Integer.valueOf(feedDetail.getPreferStatus());
                } else {
                    num = null;
                }
            }
            if (num != null && modifyBottomInteractiveDataMessage.getPreferStatus() != null && !Intrinsics.areEqual(modifyBottomInteractiveDataMessage.getPreferStatus(), num)) {
                FeedDetailMainData q29 = q2();
                if (q29 != null && (feedDetail2 = q29.getFeedDetail()) != null) {
                    obj = feedDetail2.a();
                } else {
                    obj = null;
                }
                if (obj instanceof GProStFeed) {
                    gProStFeed = (GProStFeed) obj;
                }
                if (gProStFeed != null) {
                    Integer preferStatus2 = modifyBottomInteractiveDataMessage.getPreferStatus();
                    Intrinsics.checkNotNull(preferStatus2);
                    if (preferStatus2.intValue() == 1) {
                        String guildUserDisplayNameInternal = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayNameInternal(String.valueOf(gProStFeed.channelInfo.sign.guildId), ax.u());
                        Intrinsics.checkNotNullExpressionValue(guildUserDisplayNameInternal, "api(IQQGuildUtilApi::cla\u2026Utils.getCurrentTinyId())");
                        if (guildUserDisplayNameInternal.length() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "[preferUpdateScreen] nick is null.");
                            s2(args, gProStFeed, num.intValue());
                        }
                    }
                    int intValue = num.intValue();
                    Integer preferStatus3 = modifyBottomInteractiveDataMessage.getPreferStatus();
                    Intrinsics.checkNotNull(preferStatus3);
                    bc.l(gProStFeed, intValue, preferStatus3.intValue());
                }
            }
            feedDetailMainData = m3;
        }
        if (feedDetailMainData == null) {
            QLog.w("FeedNativeDetail.ContentDetailMainViewModel", 1, "handleModifyBottomInteractData|but main is null");
        } else {
            k2(feedDetailMainData);
            P1(16, Boolean.valueOf(((a.ModifyBottomInteractiveDataMessage) args).getNeedNotifyUpdateList()));
        }
    }

    private final void D2(LoadDataArgs loadDataArgs) {
        QLog.i("FeedNativeDetail.ContentDetailMainViewModel", 1, "onPreload useOriginData'");
        if (loadDataArgs.getOriginStFeedData() instanceof GProStFeedMemoryKeepSerializer) {
            E2(n2(((GProStFeedMemoryKeepSerializer) loadDataArgs.getOriginStFeedData()).getStFeed()), "feedlist");
            return;
        }
        if (loadDataArgs.getOriginRecommendFeedData() != null) {
            Serializable originRecommendFeedData = loadDataArgs.getOriginRecommendFeedData();
            Intrinsics.checkNotNull(originRecommendFeedData, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed");
            E2(o2((IGProContentRecommendFeed) originRecommendFeedData), "recommend");
        } else {
            E2(null, "");
            QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "No origin data to handle");
        }
    }

    private final void E2(FeedDetailMainData data, String cacheType) {
        com.tencent.mobileqq.guild.feed.report.c.f223280a.s(this.partHost, cacheType, data);
        boolean z16 = false;
        if (data != null && !com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.a.a(data)) {
            if (i().isEmpty()) {
                k2(data);
                O1(1);
                z16 = true;
            }
            S1("message_on_preload_main_completed", new g.OnPreloadMainCompletedMessage(true, z16));
            this.useCacheEndTime = System.currentTimeMillis();
            return;
        }
        QLog.i("FeedNativeDetail.ContentDetailMainViewModel", 1, "handleLoadFromCacheRsp failed");
        S1("message_on_preload_main_completed", new g.OnPreloadMainCompletedMessage(false, false));
    }

    private final void F2(Object args) {
        Object obj;
        qj1.h feedDetail;
        if (!(args instanceof g.UpdateFeedChannelTopStateMessage)) {
            return;
        }
        FeedDetailMainData q26 = q2();
        GProStFeed gProStFeed = null;
        if (q26 != null && (feedDetail = q26.getFeedDetail()) != null) {
            obj = feedDetail.a();
        } else {
            obj = null;
        }
        if (obj instanceof GProStFeed) {
            gProStFeed = (GProStFeed) obj;
        }
        if (gProStFeed != null) {
            gProStFeed.channelTopInfo.isTop = ((g.UpdateFeedChannelTopStateMessage) args).getTopState();
        }
    }

    private final void G2() {
        final Flow<a.FeedPublishBegin> publishBeginFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishBeginFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishBegin>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishBeginFlow$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishBeginFlow$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishBegin> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f221163d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ DetailMainViewModel f221164e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishBeginFlow$$inlined$filter$1$2", f = "DetailMainViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishBeginFlow$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DetailMainViewModel detailMainViewModel) {
                    this.f221163d = flowCollector;
                    this.f221164e = detailMainViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishBegin feedPublishBegin, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean p26;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f221163d;
                                p26 = this.f221164e.p2(feedPublishBegin);
                                if (p26) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishBegin, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishBegin> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new DetailMainViewModel$observePublishBeginFlow$2(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void H2() {
        final Flow<a.FeedPublishFinish> publishEndFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishEndFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishEndFlow$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishEndFlow$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishFinish> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f221167d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ DetailMainViewModel f221168e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishEndFlow$$inlined$filter$1$2", f = "DetailMainViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishEndFlow$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DetailMainViewModel detailMainViewModel) {
                    this.f221167d = flowCollector;
                    this.f221168e = detailMainViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishFinish feedPublishFinish, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean p26;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f221167d;
                                p26 = this.f221168e.p2(feedPublishFinish);
                                if (p26) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new DetailMainViewModel$observePublishEndFlow$2(this, null)), ViewModelKt.getViewModelScope(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void I2(String feedId, int result, String errMsg, long startTime) {
        int i3;
        boolean isBlank;
        HashMap hashMap = new HashMap();
        hashMap.put("uin", ax.v());
        hashMap.put("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c());
        hashMap.put("sgrp_feed_id", feedId);
        hashMap.put("start_time", Long.valueOf(startTime));
        hashMap.put("end_time", Long.valueOf(System.currentTimeMillis()));
        int i16 = 0;
        if (result == 0) {
            isBlank = StringsKt__StringsJVMKt.isBlank(feedId);
            if (!isBlank) {
                i3 = 1;
                hashMap.put("sgrp_is_success", Integer.valueOf(i3));
                hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, result + errMsg);
                if (this.useCacheEndTime != -1) {
                    i16 = 1;
                }
                hashMap.put("sgrp_cache", Integer.valueOf(i16));
                hashMap.put("cache_start_time", Long.valueOf(startTime));
                hashMap.put("cache_end_time", Long.valueOf(this.useCacheEndTime));
                VideoReport.reportEvent("ev_sgrp_push_content_load_assess", hashMap);
            }
        }
        i3 = 0;
        hashMap.put("sgrp_is_success", Integer.valueOf(i3));
        hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, result + errMsg);
        if (this.useCacheEndTime != -1) {
        }
        hashMap.put("sgrp_cache", Integer.valueOf(i16));
        hashMap.put("cache_start_time", Long.valueOf(startTime));
        hashMap.put("cache_end_time", Long.valueOf(this.useCacheEndTime));
        VideoReport.reportEvent("ev_sgrp_push_content_load_assess", hashMap);
    }

    private final void e2(GProStFeed feed) {
        GuildFeedDetailDataCacheManager.y().e(feed);
    }

    private final IGProGetFeedDetailCallback f2(final long startTime, final long lastModifiedTime) {
        return new IGProGetFeedDetailCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.r
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
            public final void onResult(int i3, String str, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
                DetailMainViewModel.g2(DetailMainViewModel.this, lastModifiedTime, startTime, i3, str, z16, gProStGetFeedDetailRsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(DetailMainViewModel this$0, long j3, long j16, int i3, String errMsg, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
        GProStFeed gProStFeed;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.requestNetReportTask != null) {
            com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
            cVar.D(cVar.g(this$0.partHost, "stage_request_net_end"), i3, errMsg, false);
            this$0.requestNetReportTask = null;
        }
        this$0.requestNetReportTask = null;
        if (gProStGetFeedDetailRsp != null) {
            gProStFeed = gProStGetFeedDetailRsp.feed;
        } else {
            gProStFeed = null;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.y2(gProStFeed, i3, errMsg, z16, j3, Long.valueOf(j16));
    }

    private final IGProGetFeedDetailCallback h2() {
        return new IGProGetFeedDetailCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.p
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
            public final void onResult(int i3, String str, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
                DetailMainViewModel.i2(DetailMainViewModel.this, i3, str, z16, gProStGetFeedDetailRsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(final DetailMainViewModel this$0, final int i3, final String str, final boolean z16, final GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.t
            @Override // java.lang.Runnable
            public final void run() {
                DetailMainViewModel.j2(i3, gProStGetFeedDetailRsp, str, z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(int i3, GProStGetFeedDetailRsp gProStGetFeedDetailRsp, String errMsg, boolean z16, DetailMainViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && gProStGetFeedDetailRsp != null) {
            GProStFeed gProStFeed = gProStGetFeedDetailRsp.feed;
            Intrinsics.checkNotNullExpressionValue(gProStFeed, "rsp.feed");
            this$0.k2(this$0.n2(gProStFeed));
            this$0.P1(9, this$0.r2(z16));
            this$0.T1("message_on_main_reload_complete", new g.OnLoadMainCompletedMessage(true, i3, z16, this$0.i()));
            if (!z16) {
                GProStFeed gProStFeed2 = gProStGetFeedDetailRsp.feed;
                Intrinsics.checkNotNullExpressionValue(gProStFeed2, "rsp.feed");
                this$0.e2(gProStFeed2);
                return;
            }
            return;
        }
        QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "handleReloadMain|result=" + i3 + ", errMsg=" + errMsg);
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            this$0.l2(i3, errMsg);
            this$0.P1(1, this$0.r2(z16));
        }
        this$0.Q1("message_on_main_reload_complete", new g.OnLoadMainCompletedMessage(false, i3, z16, null));
    }

    private final boolean k2(final FeedDetailMainData data) {
        final int i3;
        List chunked;
        Object firstOrNull;
        Object lastOrNull;
        List listOf;
        List plus;
        List plus2;
        Object orNull;
        boolean z16;
        List listOf2;
        if (data.getItemType() == 12) {
            i();
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(data);
            M1().clear();
            M1().addAll(listOf2);
            return true;
        }
        List<qj1.l> c16 = data.getFeedDetail().c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            if (((qj1.l) obj).getType() != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size != 1) {
            if (size != 2 && size != 4) {
                i3 = 3;
            } else {
                i3 = 2;
            }
        } else {
            i3 = 1;
        }
        chunked = CollectionsKt___CollectionsKt.chunked(arrayList, i3, new Function1<List<? extends qj1.l>, com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$commitAfterFlatPic$picDataList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c invoke(@NotNull List<? extends qj1.l> it) {
                List list;
                Intrinsics.checkNotNullParameter(it, "it");
                int i16 = i3;
                list = CollectionsKt___CollectionsKt.toList(it);
                return new com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c(i16, list, data);
            }
        });
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) chunked);
        com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c cVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c) firstOrNull;
        if (cVar != null) {
            cVar.n(true);
            cVar.p(true);
            cVar.q(true);
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) chunked);
        com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c cVar2 = (com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c) lastOrNull;
        if (cVar2 != null) {
            if (cVar2.h().size() < i3) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(chunked, chunked.size() - 2);
                com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c cVar3 = (com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c) orNull;
                if (cVar3 != null) {
                    cVar3.m(true);
                }
            }
            cVar2.o(true);
            cVar2.l(true);
            cVar2.m(true);
        }
        i();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(data);
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) chunked);
        com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.a aVar = new com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.a(data.getFeedDetail());
        aVar.A(data.getSeq());
        plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.a>) ((Collection<? extends Object>) plus), aVar);
        M1().clear();
        M1().addAll(plus2);
        return true;
    }

    private final boolean l2(int result, String errMsg) {
        List listOf;
        i();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.b(result, errMsg));
        M1().clear();
        M1().addAll(listOf);
        return true;
    }

    private final GProStGetFeedDetailReq m2(LoadDataArgs loadDataArgs) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        GProStChannelSign gProStChannelSign = new GProStChannelSign();
        gProStChannelSign.guildId = Long.parseLong(loadDataArgs.getGuildId());
        gProStChannelSign.channelId = Long.parseLong(loadDataArgs.getChannelId());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        GProStGetFeedDetailReq gProStGetFeedDetailReq = new GProStGetFeedDetailReq();
        gProStGetFeedDetailReq.userId = str;
        gProStGetFeedDetailReq.feedId = loadDataArgs.getFeedId();
        gProStGetFeedDetailReq.channelSign = gProStChannelSign;
        gProStGetFeedDetailReq.contentType = 2;
        return gProStGetFeedDetailReq;
    }

    private final FeedDetailMainData n2(GProStFeed feed) {
        return new FeedDetailMainData(new GProStFeedDetailRspWrapper(feed, null, 2, null));
    }

    private final FeedDetailMainData o2(IGProContentRecommendFeed stFeed) {
        return new FeedDetailMainData(new GProRecommendFeedWrapper(stFeed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p2(kn1.a it) {
        String str;
        Bundle h16 = GuildSplitViewUtils.f235370a.h(this.partHost);
        GuildFeedPublishInfo q16 = yl1.n.q(h16);
        if (q16 != null) {
            str = q16.getMainTaskId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(it.getState().getTaskId(), str) && !Intrinsics.areEqual(it.getState().getStFeed().idd, h16.getString("feed_id", ""))) {
            return false;
        }
        return true;
    }

    private final FeedDetailMainData q2() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) i());
        if (firstOrNull instanceof FeedDetailMainData) {
            return (FeedDetailMainData) firstOrNull;
        }
        return null;
    }

    private final List<String> r2(boolean isDbCache) {
        List<String> listOf;
        if (isDbCache) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf("main_changed_payload_db_response");
            return listOf;
        }
        return null;
    }

    private final void s2(final Object args, final GProStFeed stFeed, final int status) {
        ca caVar = new ca();
        caVar.d(stFeed.channelInfo.sign.guildId);
        String u16 = ax.u();
        Intrinsics.checkNotNullExpressionValue(u16, "getCurrentTinyId()");
        caVar.f(MiscKt.l(u16));
        caVar.e(111);
        ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getSimpleProfileAsync(caVar, new db() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.s
            @Override // wh2.db
            public final void a(int i3, String str, IGProGetSimpleProfileAsyncRsp iGProGetSimpleProfileAsyncRsp) {
                DetailMainViewModel.t2(args, this, stFeed, status, i3, str, iGProGetSimpleProfileAsyncRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(Object obj, DetailMainViewModel this$0, GProStFeed stFeed, int i3, int i16, String str, IGProGetSimpleProfileAsyncRsp iGProGetSimpleProfileAsyncRsp) {
        a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stFeed, "$stFeed");
        if (i16 != 0) {
            QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "[handleModifyBottomInteractData] getUserNick is error" + i16 + "." + str);
            return;
        }
        if (obj instanceof a.ModifyBottomInteractiveDataMessage) {
            modifyBottomInteractiveDataMessage = (a.ModifyBottomInteractiveDataMessage) obj;
        } else {
            modifyBottomInteractiveDataMessage = null;
        }
        if (modifyBottomInteractiveDataMessage != null) {
            Integer preferStatus = modifyBottomInteractiveDataMessage.getPreferStatus();
            Intrinsics.checkNotNull(preferStatus);
            bc.l(stFeed, i3, preferStatus.intValue());
        }
        this$0.C2(obj);
    }

    private final void u2(LoadDataArgs loadDataArgs, GProStFeed preloadData) {
        FeedDetailMainData feedDetailMainData;
        qj1.h feedDetail;
        if (loadDataArgs.getOriginStFeedData() instanceof GProStFeedMemoryKeepSerializer) {
            feedDetailMainData = n2(((GProStFeedMemoryKeepSerializer) loadDataArgs.getOriginStFeedData()).getStFeed());
        } else if (loadDataArgs.getOriginRecommendFeedData() != null) {
            Serializable originRecommendFeedData = loadDataArgs.getOriginRecommendFeedData();
            Intrinsics.checkNotNull(originRecommendFeedData, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed");
            feedDetailMainData = o2((IGProContentRecommendFeed) originRecommendFeedData);
        } else {
            feedDetailMainData = null;
        }
        if (feedDetailMainData != null && (feedDetail = feedDetailMainData.getFeedDetail()) != null) {
            if (!TextUtils.isEmpty(feedDetail.q())) {
                preloadData.channelInfo.name = feedDetail.q();
            }
            preloadData.channelInfo.isSquare = feedDetail.B();
            if (feedDetail.j() == 3) {
                preloadData.auditStatus = feedDetail.j();
            }
        }
        E2(n2(preloadData), "preload");
    }

    private final a.OnCommentMainFeedDataResult v2() {
        return yl1.n.x(new a.OnCommentMainFeedDataResult(null, 1, null), q2(), this.partHost);
    }

    private final tl1.g w2() {
        return new g.OnGetFeedDetailMainDataMessage(q2());
    }

    private final void x2(int result, String errMsg, GProStFeed feed, boolean isDbCache) {
        String str;
        if (feed != null) {
            str = feed.idd;
        } else {
            str = null;
        }
        QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "handGetFeedDetailRsp error! result = " + result + " errMsg = " + errMsg + " feedId = " + str + "isDbCache = " + isDbCache);
        if (!isDbCache) {
            l2(result, errMsg);
            P1(1, r2(isDbCache));
        }
        Q1("message_on_load_main_completed", new g.OnLoadMainCompletedMessage(false, result, isDbCache, null));
    }

    private final void y2(final GProStFeed feed, final int result, final String errMsg, final boolean isDbCache, final long lastModifiedTime, final Long startTime) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.model.q
            @Override // java.lang.Runnable
            public final void run() {
                DetailMainViewModel.A2(result, feed, this, errMsg, isDbCache, startTime, lastModifiedTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z2(DetailMainViewModel detailMainViewModel, GProStFeed gProStFeed, int i3, String str, boolean z16, long j3, Long l3, int i16, Object obj) {
        Long l16;
        if ((i16 & 32) != 0) {
            l16 = null;
        } else {
            l16 = l3;
        }
        detailMainViewModel.y2(gProStFeed, i3, str, z16, j3, l16);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean E() {
        return i().isEmpty();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    @Nullable
    public Object a0(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -2016848844) {
                if (hashCode != 68441322) {
                    if (hashCode == 1034302502 && action.equals("action_get_detail_channel_extension_info")) {
                        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
                        int i3 = guildSplitViewUtils.h(this.partHost).getInt("business_type", 0);
                        String string = guildSplitViewUtils.h(this.partHost).getString("sgrp_channel_extension_info");
                        String str = "";
                        if (string == null) {
                            string = "";
                        }
                        String string2 = guildSplitViewUtils.h(this.partHost).getString("param_key_search_extension_info");
                        if (string2 != null) {
                            str = string2;
                        }
                        return new g.FeedDetailChannelExtensionInfoMessage(i3, string, str);
                    }
                } else if (action.equals("message_get_comment_feed_data")) {
                    return v2();
                }
            } else if (action.equals("action_get_detail_main_data")) {
                return w2();
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean c(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_modify_bottom_interact_data")) {
            C2(args);
            return true;
        }
        if (Intrinsics.areEqual(action, "message_update_feed_channel_top_state")) {
            F2(args);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void e1(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        if (com.tencent.mobileqq.guild.feed.feedsquare.data.g.c(yl1.n.q(GuildSplitViewUtils.f235370a.h(this.partHost)))) {
            QLog.i("FeedNativeDetail.ContentDetailMainViewModel", 1, "feed is editing, cancel load");
            return;
        }
        this.requestNetReportTask = com.tencent.mobileqq.guild.feed.report.c.f223280a.g(this.partHost, "stage_request_net_start").report();
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.getFeedDetail(m2(loadDataArgs), loadDataArgs.getEnableCache(), f2(loadDataArgs.getStartTime(), loadDataArgs.getLastModifiedTime()));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public int getIdentifier() {
        return 1;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FeedNativeDetail.ContentDetailMainViewModel";
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel, com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void t0(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        GProStGetFeedDetailReq m26 = m2(loadDataArgs);
        if (m26 == null) {
            QLog.e("FeedNativeDetail.ContentDetailMainViewModel", 1, "handleReloadMain, but request is null");
            return;
        }
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.getFeedDetail(m26, true, h2());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void y1(@NotNull LoadDataArgs loadDataArgs) {
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        com.tencent.mobileqq.guild.feed.report.c.f223280a.g(this.partHost, "stage_load_cache").report();
        boolean z16 = false;
        GProStFeed r16 = GuildFeedDetailDataCacheManager.y().r(loadDataArgs.getFeedId(), loadDataArgs.getLastModifiedTime(), false);
        if (r16 != null) {
            String str = r16.idd;
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                QLog.i("FeedNativeDetail.ContentDetailMainViewModel", 1, "onPreload use cache: " + loadDataArgs.getFeedId() + ", lastModifyTime: " + loadDataArgs.getLastModifiedTime());
                u2(loadDataArgs, r16);
                return;
            }
        }
        D2(loadDataArgs);
    }
}
