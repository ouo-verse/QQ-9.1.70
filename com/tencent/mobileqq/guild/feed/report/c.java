package com.tencent.mobileqq.guild.feed.report;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.LoadDataArgs;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNextPageRepliesRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedCommentsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001eB\t\b\u0002\u00a2\u0006\u0004\bc\u0010dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0002J*\u0010\u001a\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011J(\u0010\"\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017J8\u0010$\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u001e\u0010(\u001a\u00020\u00192\u0006\u0010&\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0017J\u0016\u0010,\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\nJ \u0010.\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002JH\u00101\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u000e\u00104\u001a\u00020\u00112\u0006\u00103\u001a\u000202J(\u00108\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\n2\u0006\u00107\u001a\u000206J\u000e\u0010;\u001a\u00020\u00112\u0006\u0010:\u001a\u000209J(\u0010=\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\n2\u0006\u00107\u001a\u00020<J\u000e\u0010@\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>J\u001e\u0010D\u001a\u00020\u00112\u0006\u0010?\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\nJ\u0016\u0010F\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010I\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nJ\u001a\u0010N\u001a\u00020\u00192\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010M\u001a\u0004\u0018\u00010LJ\u000e\u0010O\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)J \u0010T\u001a\u00020\u00112\b\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010S\u001a\u00020R2\u0006\u0010B\u001a\u00020\u0017J\u0018\u0010U\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\nJ4\u0010X\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\n2\u0006\u00105\u001a\u00020V2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u00107\u001a\u0004\u0018\u00010WJ>\u0010[\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\n2\u0006\u00105\u001a\u00020V2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010?\u001a\u0004\u0018\u00010Y2\b\u00107\u001a\u0004\u0018\u00010ZJ$\u0010_\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00112\f\u0010?\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u00107\u001a\u00020^J*\u0010`\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\n2\u0006\u00105\u001a\u00020V2\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ*\u0010b\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010a\u001a\u00020\u0017\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/report/c;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "l", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProFeedEntry;", "Lkotlin/collections/ArrayList;", "entryList", "", "d", "type", "eventCode", "Lcom/tencent/mobileqq/guild/feed/report/c$a;", "feedReportData", "enterFrom", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "c", "task", "Landroid/view/View;", "view", "Lkotlin/Function0;", "", "canReport", "", "B", "reportTask", "y", "G", "v", "errMsg", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "w", "state", "u", "Landroid/content/Intent;", "intent", "isTroop", "r", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "stageCode", "g", "cacheType", ReportConstant.COSTREPORT_PREFIX, "isSuccess", "removeTask", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "loadDataArgs", "f", "result", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetFeedCommentsRsp;", "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesReq;", "replyReq", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetNextPageRepliesRsp;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDoFeedPreferReq;", "req", "i", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoLikeReq;", "isReply", "likeId", "e", "setTop", "k", "guildId", "channelId", "j", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "Landroid/os/Bundle;", "arguments", "t", h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "mainFeedData", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$r;", "msg", DomainData.DOMAIN_NAME, "p", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "o", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsReq;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/b;", HippyTKDListViewAdapter.X, "b", "isSingleEnd", "D", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a */
    @NotNull
    public static final c f223280a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/report/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "feedId", "c", "guildId", "channelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.report.c$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedReportData {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        public FeedReportData(@NotNull String feedId, @NotNull String guildId, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.feedId = feedId;
            this.guildId = guildId;
            this.channelId = channelId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedReportData)) {
                return false;
            }
            FeedReportData feedReportData = (FeedReportData) other;
            if (Intrinsics.areEqual(this.feedId, feedReportData.feedId) && Intrinsics.areEqual(this.guildId, feedReportData.guildId) && Intrinsics.areEqual(this.channelId, feedReportData.channelId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.feedId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "FeedReportData(feedId=" + this.feedId + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ")";
        }
    }

    c() {
    }

    private final void B(final IPerformanceReportTask task, View view, final Function0<Boolean> canReport) {
        String stackTraceToString;
        if (task != null) {
            try {
                if (!(task instanceof DummyPerformanceReportTask) && view != null) {
                    final long uptimeMillis = SystemClock.uptimeMillis();
                    OneShotPreDrawListener.add(view, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.report.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.C(Function0.this, task, uptimeMillis);
                        }
                    });
                }
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportOnFirstFrame] exception: " + stackTraceToString);
            }
        }
    }

    public static final void C(Function0 canReport, IPerformanceReportTask iPerformanceReportTask, long j3) {
        Intrinsics.checkNotNullParameter(canReport, "$canReport");
        if (((Boolean) canReport.invoke()).booleanValue()) {
            iPerformanceReportTask.setTimeCost(SystemClock.uptimeMillis() - j3);
            iPerformanceReportTask.report();
        }
    }

    public static /* synthetic */ void E(c cVar, IPerformanceReportTask iPerformanceReportTask, int i3, String str, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        cVar.D(iPerformanceReportTask, i3, str, z16);
    }

    private final IPerformanceReportTask c(int type, String eventCode, FeedReportData feedReportData, String enterFrom) {
        String stackTraceToString;
        Map<String, ? extends Object> mapOf;
        try {
            StringBuilder sb5 = new StringBuilder(eventCode);
            if (GuildInfoManager.q().P(feedReportData.getChannelId())) {
                sb5.append("_group");
            }
            com.tencent.mobileqq.guild.report.h b16 = Reporters.f231995a.b();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "eventCodeSB.toString()");
            IPerformanceReportTask a16 = b16.a(sb6);
            a16.setRealTime(false);
            a16.setParam("guild_id", feedReportData.getGuildId());
            a16.setParam("guild_channel_id", feedReportData.getChannelId());
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("feed_id", feedReportData.getFeedId()), TuplesKt.to("type", Integer.valueOf(type)));
            a16.setExtras(mapOf);
            a16.setEnterFrom(enterFrom);
            return a16;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[geLikeCancelReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    private final String d(ArrayList<GProFeedEntry> entryList) {
        if (entryList != null) {
            Iterator<GProFeedEntry> it = entryList.iterator();
            while (it.hasNext()) {
                GProFeedEntry next = it.next();
                if (Intrinsics.areEqual(next.key, "page_id") || Intrinsics.areEqual(next.key, "re_page_id")) {
                    String str = next.value;
                    Intrinsics.checkNotNullExpressionValue(str, "entry.value");
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    private final int l(FeedDetailMainData data) {
        if (data == null) {
            return 0;
        }
        if (data.getItemType() == 12) {
            return 2;
        }
        return 1;
    }

    public final void A(@Nullable IPerformanceReportTask iPerformanceReportTask, int i3, @NotNull String errMsg, @NotNull GProGetNextPageRepliesRsp rsp) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (iPerformanceReportTask != null) {
            try {
                iPerformanceReportTask.setExtra("rspList", Integer.valueOf(rsp.replies.size()));
                E(f223280a, iPerformanceReportTask, i3, errMsg, false, 8, null);
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportGetReplyList] exception: " + stackTraceToString);
            }
        }
    }

    public final void D(@NotNull IPerformanceReportTask reportTask, int result, @Nullable String errMsg, boolean isSingleEnd) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        try {
            reportTask.setResultCode(result);
            if (errMsg != null) {
                reportTask.setResultMsg(errMsg);
            }
            if (isSingleEnd) {
                qw1.b.n(reportTask);
            } else {
                reportTask.report();
            }
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportOnRsp] exception: " + stackTraceToString);
        }
    }

    public final void F(@Nullable IPerformanceReportTask iPerformanceReportTask, @NotNull String stageCode, long j3, @Nullable String str, @Nullable GProStDoReplyReq gProStDoReplyReq, @Nullable GProStDoReplyRsp gProStDoReplyRsp) {
        String stackTraceToString;
        String str2;
        GProStReply gProStReply;
        GProStComment gProStComment;
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        if (iPerformanceReportTask == null) {
            return;
        }
        try {
            IPerformanceReportTask duplicate = iPerformanceReportTask.duplicate("guild_id", "guild_channel_id", "feed_id");
            duplicate.setRealTime(false);
            duplicate.setStageCode(stageCode);
            duplicate.setResultCode(j3);
            if (str != null) {
                duplicate.setResultMsg(str);
            }
            String str3 = null;
            if (gProStDoReplyReq != null && (gProStComment = gProStDoReplyReq.comment) != null) {
                str2 = gProStComment.idd;
            } else {
                str2 = null;
            }
            String str4 = "";
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "req?.comment?.idd ?: \"\"");
            }
            duplicate.setExtra("comment_id", str2);
            if (gProStDoReplyRsp != null && (gProStReply = gProStDoReplyRsp.reply) != null) {
                str3 = gProStReply.idd;
            }
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "rsp?.reply?.idd ?: \"\"");
                str4 = str3;
            }
            duplicate.setExtra("reply_id", str4);
            duplicate.report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[duplicateAndReportOnRsp] exception: " + stackTraceToString);
        }
    }

    @NotNull
    public final IPerformanceReportTask G() {
        String stackTraceToString;
        try {
            IPerformanceReportTask a16 = Reporters.f231995a.b().a("feed_section");
            a16.setRealTime(false);
            a16.setStageCode("stage_init");
            return a16.report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportSecondaryListInit] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    public final void b(@Nullable IPerformanceReportTask reportTask, @NotNull String stageCode, long result, @Nullable String errMsg) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        if (reportTask == null) {
            return;
        }
        try {
            IPerformanceReportTask duplicate = reportTask.duplicate("guild_id", "guild_channel_id", "feed_id");
            duplicate.setRealTime(false);
            duplicate.setStageCode(stageCode);
            duplicate.setResultCode(result);
            if (errMsg != null) {
                duplicate.setResultMsg(errMsg);
            }
            duplicate.report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[duplicateAndReportOnRsp] exception: " + stackTraceToString);
        }
    }

    @NotNull
    public final IPerformanceReportTask e(@NotNull GProStDoLikeReq req, boolean isReply, @NotNull String likeId) {
        String str;
        ArrayList<GProFeedEntry> arrayList;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(likeId, "likeId");
        int i3 = req.likeType;
        if (isReply) {
            str = "feed_reply_like";
        } else {
            str = "feed_comment_like";
        }
        String str2 = req.feed.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "req.feed.idd");
        FeedReportData feedReportData = new FeedReportData(str2, String.valueOf(req.feed.channelInfo.sign.guildId), String.valueOf(req.feed.channelInfo.sign.channelId));
        GProStCommonExt gProStCommonExt = req.extInfo;
        if (gProStCommonExt != null) {
            arrayList = gProStCommonExt.mapInfoList;
        } else {
            arrayList = null;
        }
        IPerformanceReportTask c16 = c(i3, str, feedReportData, d(arrayList));
        c16.setExtra("like_id", likeId);
        return c16;
    }

    @NotNull
    public final IPerformanceReportTask f(@NotNull LoadDataArgs loadDataArgs) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        try {
            StringBuilder sb5 = new StringBuilder("feed_comment_list");
            if (GuildInfoManager.q().P(loadDataArgs.getChannelId())) {
                sb5.append("_group");
            }
            com.tencent.mobileqq.guild.report.h b16 = Reporters.f231995a.b();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "eventCode.toString()");
            IPerformanceReportTask a16 = b16.a(sb6);
            a16.setRealTime(false);
            a16.setParam("guild_id", loadDataArgs.getGuildId());
            a16.setParam("guild_channel_id", loadDataArgs.getChannelId());
            a16.setExtra("feed_id", loadDataArgs.getFeedId());
            return a16;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[getFeedCommentsReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    @NotNull
    public final IPerformanceReportTask g(@NotNull IPartHost partHost, @NotNull String stageCode) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        try {
            IPerformanceReportTask duplicate = qw1.b.f(GuildSplitViewUtils.f235370a.h(partHost), "feed_perf_report_task_param").duplicate("guild_id", "guild_channel_id", "feed_id");
            duplicate.setRealTime(false);
            duplicate.setStageCode(stageCode);
            return duplicate;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[getFeedDetailReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final IPerformanceReportTask h(@NotNull IPartHost partHost) {
        String stackTraceToString;
        IPerformanceReportTask iPerformanceReportTask;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        try {
            if (partHost instanceof Fragment) {
                iPerformanceReportTask = qw1.b.f(((Fragment) partHost).getArguments(), "_feed_immersive_param_report_task").duplicate("guild_id", "guild_channel_id", "feed_id");
                iPerformanceReportTask.setRealTime(false);
            } else {
                iPerformanceReportTask = DummyPerformanceReportTask.INSTANCE;
            }
            return iPerformanceReportTask;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[getFeedGalleryReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    @NotNull
    public final IPerformanceReportTask i(@NotNull GProDoFeedPreferReq req) {
        ArrayList<GProFeedEntry> arrayList;
        Intrinsics.checkNotNullParameter(req, "req");
        int i3 = req.action;
        String str = req.feedId;
        Intrinsics.checkNotNullExpressionValue(str, "req.feedId");
        FeedReportData feedReportData = new FeedReportData(str, String.valueOf(req.channelId), String.valueOf(req.guildId));
        GProStCommonExt gProStCommonExt = req.extInfo;
        if (gProStCommonExt != null) {
            arrayList = gProStCommonExt.mapInfoList;
        } else {
            arrayList = null;
        }
        return c(i3, "feed_like", feedReportData, d(arrayList));
    }

    @NotNull
    public final IPerformanceReportTask j(@NotNull String guildId, @NotNull String channelId) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        try {
            StringBuilder sb5 = new StringBuilder("feed_top_list");
            if (GuildInfoManager.q().P(channelId)) {
                sb5.append("_group");
            }
            com.tencent.mobileqq.guild.report.h b16 = Reporters.f231995a.b();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "eventCode.toString()");
            IPerformanceReportTask a16 = b16.a(sb6);
            a16.setRealTime(false);
            a16.setParam("guild_id", guildId);
            a16.setParam("guild_channel_id", channelId);
            return a16;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[getFeedTopListReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    @NotNull
    public final IPerformanceReportTask k(boolean setTop, @NotNull FeedReportData feedReportData) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(feedReportData, "feedReportData");
        try {
            StringBuilder sb5 = new StringBuilder("feed_top");
            if (GuildInfoManager.q().P(feedReportData.getChannelId())) {
                sb5.append("_group");
            }
            com.tencent.mobileqq.guild.report.h b16 = Reporters.f231995a.b();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "eventCode.toString()");
            IPerformanceReportTask a16 = b16.a(sb6);
            int i3 = 0;
            a16.setRealTime(false);
            a16.setParam("guild_id", feedReportData.getGuildId());
            a16.setParam("guild_channel_id", feedReportData.getChannelId());
            a16.setExtra("feed_id", feedReportData.getFeedId());
            if (setTop) {
                i3 = 1;
            }
            a16.setExtra(QCircleDaTongConstant.ElementParamValue.SET_TOP, Integer.valueOf(i3));
            return a16;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[getFeedTopReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    @NotNull
    public final IPerformanceReportTask m(@NotNull GProGetNextPageRepliesReq replyReq) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(replyReq, "replyReq");
        try {
            StringBuilder sb5 = new StringBuilder("feed_reply_list");
            if (GuildInfoManager.q().P(String.valueOf(replyReq.channelSign.channelId))) {
                sb5.append("_group");
            }
            com.tencent.mobileqq.guild.report.h b16 = Reporters.f231995a.b();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "eventCode.toString()");
            IPerformanceReportTask a16 = b16.a(sb6);
            a16.setRealTime(false);
            a16.setParam("guild_id", String.valueOf(replyReq.channelSign.guildId));
            a16.setParam("guild_channel_id", String.valueOf(replyReq.channelSign.channelId));
            a16.setExtra("feed_id", replyReq.feedId);
            a16.setExtra("comment_id", replyReq.commentId);
            return a16;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[getReplyListReportTask] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    @NotNull
    public final IPerformanceReportTask n(@Nullable a.CommentMainFeedData commentMainFeedData, @NotNull a.TryToSendInputContentMessage msg2, boolean z16) {
        String stackTraceToString;
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        try {
            if (z16) {
                sb5 = new StringBuilder("feed_reply");
            } else {
                sb5 = new StringBuilder("feed_comment");
            }
            if (commentMainFeedData != null && GuildInfoManager.q().P(commentMainFeedData.getChannelId())) {
                sb5.append("_group");
            }
            com.tencent.mobileqq.guild.report.h b16 = Reporters.f231995a.b();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "eventCode.toString()");
            IPerformanceReportTask a16 = b16.a(sb6);
            int i3 = 0;
            a16.setRealTime(false);
            a16.setStageCode("stage_start_send");
            ArrayList<LocalMediaInfo> d16 = msg2.d();
            if (d16 != null) {
                i3 = d16.size();
            }
            a16.setExtra("media_count", Integer.valueOf(i3));
            if (commentMainFeedData != null) {
                a16.setParam("guild_id", commentMainFeedData.getGuildId());
                a16.setParam("guild_channel_id", commentMainFeedData.getChannelId());
                a16.setExtra("feed_id", commentMainFeedData.getFeedId());
            }
            a16.report();
            return a16;
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportCommentInit] exception: " + stackTraceToString);
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    public final void o(@Nullable IPerformanceReportTask reportTask, @NotNull String stageCode, long result, @Nullable String errMsg, @Nullable GProStDoCommentRsp rsp) {
        String stackTraceToString;
        String str;
        GProStComment gProStComment;
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        if (reportTask == null) {
            return;
        }
        try {
            IPerformanceReportTask duplicate = reportTask.duplicate("guild_id", "guild_channel_id", "feed_id");
            duplicate.setRealTime(false);
            duplicate.setStageCode(stageCode);
            duplicate.setResultCode(result);
            if (errMsg != null) {
                duplicate.setResultMsg(errMsg);
            }
            if (rsp != null && (gProStComment = rsp.comment) != null) {
                str = gProStComment.idd;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "rsp?.comment?.idd ?: \"\"");
            }
            duplicate.setExtra("comment_id", str);
            duplicate.report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[duplicateAndReportOnRsp] exception: " + stackTraceToString);
        }
    }

    public final void p(@Nullable IPerformanceReportTask reportTask, @NotNull String stageCode) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        if (reportTask == null) {
            return;
        }
        try {
            IPerformanceReportTask duplicate = reportTask.duplicate("guild_id", "guild_channel_id", "feed_id");
            duplicate.setRealTime(false);
            duplicate.setStageCode(stageCode);
            duplicate.report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportCommentStage] exception: " + stackTraceToString);
        }
    }

    public final void q(@NotNull IPartHost partHost, @NotNull String stageCode, boolean z16, @Nullable FeedDetailMainData feedDetailMainData, boolean z17, @Nullable View view, @NotNull Function0<Boolean> canReport) {
        String stackTraceToString;
        int i3;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        Intrinsics.checkNotNullParameter(canReport, "canReport");
        try {
            IPerformanceReportTask g16 = g(partHost, stageCode);
            Pair[] pairArr = new Pair[2];
            if (z16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            pairArr[0] = TuplesKt.to(VRReportDefine$ReportParam.IS_SUCCESS, Integer.valueOf(i3));
            pairArr[1] = TuplesKt.to(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, Integer.valueOf(l(feedDetailMainData)));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            B(g16.setExtras(mapOf), view, canReport);
            if (z17) {
                GuildSplitViewUtils.f235370a.y(partHost, "feed_perf_report_task_param");
            }
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedDetailFirstFrame] exception: " + stackTraceToString);
        }
    }

    public final void r(@NotNull Intent intent, @NotNull FeedReportData feedReportData, boolean isTroop) {
        String str;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(feedReportData, "feedReportData");
        if (!isTroop) {
            str = "feed_detail";
        } else {
            str = "feed_detail_group";
        }
        try {
            IPerformanceReportTask a16 = Reporters.f231995a.b().a(str);
            a16.setRealTime(false);
            a16.setParam("guild_id", feedReportData.getGuildId());
            a16.setParam("guild_channel_id", feedReportData.getChannelId());
            a16.setExtra("feed_id", feedReportData.getFeedId());
            a16.setStageCode("stage_init");
            intent.putExtra("feed_perf_report_task_param", a16.report());
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedDetailInit] exception: " + stackTraceToString);
        }
    }

    public final void s(@NotNull IPartHost partHost, @NotNull String cacheType, @Nullable FeedDetailMainData feedDetailMainData) {
        String stackTraceToString;
        int i3;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        try {
            IPerformanceReportTask g16 = g(partHost, "stage_load_cache_end");
            if (feedDetailMainData != null && !com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.a.a(feedDetailMainData)) {
                i3 = 1;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("has_cache", Integer.valueOf(i3)), TuplesKt.to("cache_type", cacheType), TuplesKt.to(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, Integer.valueOf(l(feedDetailMainData))));
                g16.setExtras(mapOf).report();
            }
            i3 = 0;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("has_cache", Integer.valueOf(i3)), TuplesKt.to("cache_type", cacheType), TuplesKt.to(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, Integer.valueOf(l(feedDetailMainData))));
            g16.setExtras(mapOf).report();
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedDetailLoadCache] exception: " + stackTraceToString);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d A[Catch: Exception -> 0x000d, TRY_LEAVE, TryCatch #0 {Exception -> 0x000d, blocks: (B:22:0x0004, B:6:0x0019, B:8:0x002e, B:9:0x0058, B:11:0x005d), top: B:21:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e A[Catch: Exception -> 0x000d, TryCatch #0 {Exception -> 0x000d, blocks: (B:22:0x0004, B:6:0x0019, B:8:0x002e, B:9:0x0058, B:11:0x005d), top: B:21:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(@Nullable GuildFeedGalleryInitBean initBean, @Nullable Bundle arguments) {
        boolean z16;
        String stackTraceToString;
        String str;
        if (initBean != null) {
            try {
                if (initBean.getBusinessType() == 7) {
                    z16 = true;
                    if (!z16) {
                        str = "feed_immersive_group";
                    } else {
                        str = "feed_immersive";
                    }
                    IPerformanceReportTask a16 = Reporters.f231995a.b().a(str);
                    a16.setRealTime(false);
                    a16.setStageCode("stage_init");
                    if (initBean != null) {
                        String guildId = initBean.getGuildId();
                        Intrinsics.checkNotNullExpressionValue(guildId, "it.guildId");
                        a16.setParam("guild_id", guildId);
                        String channelId = initBean.getChannelId();
                        Intrinsics.checkNotNullExpressionValue(channelId, "it.channelId");
                        a16.setParam("guild_channel_id", channelId);
                        a16.setExtra("feed_id", initBean.getFeedId());
                    }
                    a16.report();
                    if (arguments == null) {
                        qw1.b.t(arguments, a16, "_feed_immersive_param_report_task");
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedGalleryInit] exception: " + stackTraceToString);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
        IPerformanceReportTask a162 = Reporters.f231995a.b().a(str);
        a162.setRealTime(false);
        a162.setStageCode("stage_init");
        if (initBean != null) {
        }
        a162.report();
        if (arguments == null) {
        }
    }

    public final void u(@Nullable IPerformanceReportTask reportTask, boolean r36, int state, @Nullable View view, @NotNull Function0<Boolean> canReport) {
        String stackTraceToString;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(canReport, "canReport");
        if (reportTask != null) {
            try {
                IPerformanceReportTask duplicate = reportTask.duplicate("guild_id");
                if (duplicate != null) {
                    if (r36) {
                        duplicate.setStageCode("stage_cache_first_frame_finish");
                    } else {
                        duplicate.setStageCode("stage_finish");
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("state", Integer.valueOf(state)));
                        duplicate.setExtras(mapOf);
                    }
                    duplicate.setRealTime(false);
                    f223280a.B(duplicate, view, canReport);
                }
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedListFirstScreen] exception: " + stackTraceToString);
            }
        }
    }

    public final void v(@Nullable IPerformanceReportTask reportTask) {
        IPerformanceReportTask stageCode;
        IPerformanceReportTask realTime;
        String stackTraceToString;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode2;
        IPerformanceReportTask realTime2;
        if (reportTask != null) {
            try {
                IPerformanceReportTask duplicate2 = reportTask.duplicate("guild_id");
                if (duplicate2 != null && (stageCode = duplicate2.setStageCode("stage_load_cache")) != null && (realTime = stageCode.setRealTime(false)) != null) {
                    realTime.report();
                }
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedListLoadData] exception: " + stackTraceToString);
                return;
            }
        }
        if (reportTask != null && (duplicate = reportTask.duplicate("guild_id")) != null && (stageCode2 = duplicate.setStageCode("stage_request_net_start")) != null && (realTime2 = stageCode2.setRealTime(false)) != null) {
            realTime2.report();
        }
    }

    public final void w(@Nullable IPerformanceReportTask reportTask, @NotNull String errMsg, int r46, boolean r56) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (reportTask != null) {
            try {
                IPerformanceReportTask duplicate = reportTask.duplicate("guild_id");
                if (duplicate != null) {
                    if (r56) {
                        duplicate.setStageCode("stage_load_cache_end");
                    } else {
                        duplicate.setStageCode("stage_request_net_end");
                    }
                    duplicate.setResultCode(r46);
                    duplicate.setResultMsg(errMsg);
                    duplicate.setRealTime(false);
                    duplicate.report();
                }
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedListLoadFinish] exception: " + stackTraceToString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[Catch: Exception -> 0x00e1, TryCatch #0 {Exception -> 0x00e1, blocks: (B:3:0x0013, B:5:0x0019, B:9:0x0029, B:11:0x0031, B:16:0x003d, B:21:0x0071, B:23:0x008b, B:26:0x00cb, B:30:0x0064), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(@NotNull IPerformanceReportTask reportTask, @NotNull GuildFeedListDataRepo.b<GProGetGuildFeedsReq> req, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.b rsp) {
        String stackTraceToString;
        boolean z16;
        boolean z17;
        Object first;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        try {
            if (req.getCom.tencent.mobileqq.activity.miniaio.MiniChatConstants.MINI_APP_TOP_TYPE java.lang.String() > 0) {
                int i3 = 0;
                if (req.getTopBusinessId().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    ArrayList<GProStFeed> arrayList = rsp.getGProGetGuildFeedsRsp().vecFeedList;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z17 = false;
                        if (z17) {
                            ArrayList<GProStFeed> arrayList2 = rsp.getGProGetGuildFeedsRsp().vecFeedList;
                            Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.gProGetGuildFeedsRsp.vecFeedList");
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                            String str = ((GProStFeed) first).idd;
                            StringBuilder sb5 = new StringBuilder();
                            int i16 = 5;
                            if (rsp.getGProGetGuildFeedsRsp().vecFeedList.size() <= 5) {
                                i16 = rsp.getGProGetGuildFeedsRsp().vecFeedList.size();
                            }
                            for (int i17 = 0; i17 < i16; i17++) {
                                sb5.append(rsp.getGProGetGuildFeedsRsp().vecFeedList.get(i17).idd);
                                sb5.append(",");
                            }
                            reportTask.setRealTime(false);
                            Pair[] pairArr = new Pair[4];
                            pairArr[0] = TuplesKt.to("top_type", Integer.valueOf(req.getCom.tencent.mobileqq.activity.miniaio.MiniChatConstants.MINI_APP_TOP_TYPE java.lang.String()));
                            pairArr[1] = TuplesKt.to("top_business_id", req.getTopBusinessId());
                            pairArr[2] = TuplesKt.to("feed_ids", sb5.toString());
                            if (Intrinsics.areEqual(req.getTopBusinessId(), str)) {
                                i3 = 1;
                            }
                            pairArr[3] = TuplesKt.to("is_matched", Integer.valueOf(i3));
                            mapOf = MapsKt__MapsKt.mapOf(pairArr);
                            reportTask.setExtras(mapOf);
                            qw1.b.n(reportTask);
                            return;
                        }
                        return;
                    }
                    z17 = true;
                    if (z17) {
                    }
                }
            }
        } catch (Exception e16) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedListTopBusiness] exception: " + stackTraceToString);
        }
    }

    @NotNull
    public final IPerformanceReportTask y(@Nullable IPerformanceReportTask reportTask) {
        String stackTraceToString;
        if (reportTask != null) {
            try {
                IPerformanceReportTask duplicate = reportTask.duplicate("guild_id");
                if (duplicate != null) {
                    duplicate.setRealTime(false);
                    duplicate.setStageCode("stage_init").report();
                    return duplicate;
                }
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportFeedTabInit] exception: " + stackTraceToString);
            }
        }
        return DummyPerformanceReportTask.INSTANCE;
    }

    public final void z(@Nullable IPerformanceReportTask iPerformanceReportTask, int i3, @NotNull String errMsg, @NotNull GProStGetFeedCommentsRsp rsp) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (iPerformanceReportTask != null) {
            try {
                iPerformanceReportTask.setExtra("rspList", Integer.valueOf(rsp.vecCommentList.size()));
                E(f223280a, iPerformanceReportTask, i3, errMsg, false, 8, null);
            } catch (Exception e16) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                QLog.e("GuildFeedPerformanceReportUtils", 1, "[reportGetFeedComments] exception: " + stackTraceToString);
            }
        }
    }
}
