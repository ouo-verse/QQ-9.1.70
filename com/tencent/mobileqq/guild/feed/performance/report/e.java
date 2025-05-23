package com.tencent.mobileqq.guild.feed.performance.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J$\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00140\u0013H\u0016R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/e;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedReportEvent;", "Lcom/tencent/mobileqq/guild/feed/performance/report/d;", "initData", "", "e", "b", "", AdMetricTag.EVENT_NAME, "", "params", "d", "ret", "msg", "c", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Ljava/lang/String;", "mTaskKey", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements SimpleEventReceiver<GuildFeedReportEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final e f222721d = new e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mTaskKey = "";

    e() {
    }

    @JvmStatic
    public static final void b() {
        boolean isBlank;
        if (!GuildFeedReportHelper.i().g()) {
            return;
        }
        bl.c().e(f222721d);
        isBlank = StringsKt__StringsJVMKt.isBlank(mTaskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedDetailInitReportTask", 2, "endTask but taskKey is empty. return");
                return;
            }
            return;
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(mTaskKey, "end", new HashMap());
        iQQOpenTelemetryReportApi.endOpenTelemetryTask(mTaskKey);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildFeedDetailInitReportTask", 2, "endTask, taskKey=" + mTaskKey);
        }
        mTaskKey = "";
    }

    private final void c(String ret, String msg2) {
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        HashMap hashMap = new HashMap();
        if (ret == null) {
            ret = "0";
        }
        hashMap.put("ret", ret);
        if (msg2 == null) {
            msg2 = "";
        }
        hashMap.put("msg", msg2);
        iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(mTaskKey, hashMap);
    }

    private final void d(String eventName, Map<String, String> params) {
        if (Intrinsics.areEqual(eventName, LibraTraceConst.Node.IMAGE_LOAD_SUCCESS)) {
            c("0", "");
        } else if (Intrinsics.areEqual(eventName, "load_failed")) {
            c(params.get("ret"), params.get("msg"));
        }
    }

    @JvmStatic
    public static final void e(@NotNull GuildFeedDetailInitData initData) {
        Intrinsics.checkNotNullParameter(initData, "initData");
        if (!GuildFeedReportHelper.i().g()) {
            return;
        }
        bl.c().d(f222721d);
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#success#channel_topic_detail");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026GUILD_FEED_DETAIL_REPORT)");
        mTaskKey = startOpenTelemetryTask;
        HashMap hashMap = new HashMap();
        String mGuildId = initData.getMGuildId();
        if (mGuildId != null) {
            hashMap.put("guild_id", mGuildId);
        }
        String mChannelId = initData.getMChannelId();
        if (mChannelId != null) {
            hashMap.put("channel_id", mChannelId);
        }
        String mPosterTinyId = initData.getMPosterTinyId();
        if (mPosterTinyId != null) {
            hashMap.put("poster_tiny_id", mPosterTinyId);
        }
        String mFrom = initData.getMFrom();
        if (mFrom != null) {
            hashMap.put("from", mFrom);
        }
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(mTaskKey, "start", hashMap);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedDetailInitReportTask", 2, "startTask, taskKey=" + mTaskKey + ", initData: " + initData);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildFeedReportEvent>> getEventClass() {
        ArrayList<Class<GuildFeedReportEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedReportEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!GuildFeedReportHelper.i().g()) {
            return;
        }
        QLog.i("GuildFeedDetailInitReportTask", 1, "onReceiveEvent: " + event);
        if (event != null && (event instanceof GuildFeedReportEvent)) {
            GuildFeedReportEvent guildFeedReportEvent = (GuildFeedReportEvent) event;
            if (guildFeedReportEvent.getGuildFeedReportBean() == null) {
                return;
            }
            boolean z16 = false;
            if (!com.tencent.mobileqq.utils.bl.b(guildFeedReportEvent.getGuildFeedReportBean().getReportList())) {
                for (GuildFeedReportBean.ReportBean reportBean : guildFeedReportEvent.getGuildFeedReportBean().getReportList()) {
                    if (Intrinsics.areEqual(reportBean.getTaskName(), "gpro_quality#success#channel_topic_detail")) {
                        String event2 = reportBean.getEvent();
                        Intrinsics.checkNotNullExpressionValue(event2, "report.event");
                        Map<String, String> params = reportBean.getParams();
                        Intrinsics.checkNotNullExpressionValue(params, "report.params");
                        d(event2, params);
                        z16 = true;
                    }
                }
            }
            if (z16 && guildFeedReportEvent.isFinish()) {
                b();
            }
        }
    }
}
