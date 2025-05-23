package com.tencent.mobileqq.guild.feed.performance.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0007J4\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\rH\u0002J4\u0010\u0011\u001a\u00020\u00052\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J4\u0010\u0015\u001a\u00020\u00052\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0007J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e`\u001fH\u0016R\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/f;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedReportEvent;", "Lcom/tencent/mobileqq/guild/feed/performance/report/d;", "initData", "", "i", "", AdMetricTag.EVENT_NAME, "", "extraInfo", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", tl.h.F, "taskAttributeKey", "c", "taskAttributeValue", "b", "taskAttributesKey", "g", "", "costTime", "f", "e", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/lang/String;", "mTaskKey", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements SimpleEventReceiver<GuildFeedReportEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final f f222723d = new f();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mTaskKey = "";

    f() {
    }

    private final void b(String taskAttributeKey, String taskAttributeValue) {
        boolean isBlank;
        HashMap hashMapOf;
        isBlank = StringsKt__StringsJVMKt.isBlank(mTaskKey);
        if (!isBlank) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(taskAttributeKey, taskAttributeValue));
            QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
            ((IQQOpenTelemetryReportApi) api).setOpenTelemetryTaskAttributes(mTaskKey, hashMapOf);
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedDetailTimeCostReportTask", 2, "addTaskAttributes (" + taskAttributeKey + ") but already end task. return");
        }
    }

    private final void c(HashMap<String, String> params, String taskAttributeKey) {
        if (params.containsKey(taskAttributeKey)) {
            String str = params.get(taskAttributeKey);
            if (str == null) {
                str = "";
            }
            b(taskAttributeKey, str);
        }
    }

    @JvmStatic
    public static final void d(@NotNull String eventName, @NotNull Map<String, String> extraInfo) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (!GuildFeedReportHelper.i().g()) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedDetailTimeCostReportTask", 2, "addTaskEvent event: " + eventName + ", extraInfo: " + extraInfo);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(mTaskKey);
        if (isBlank) {
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedDetailTimeCostReportTask", 2, "addTaskEvent ignored. taskKey is empty. return");
                return;
            }
            return;
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!extraInfo.isEmpty()) {
            hashMap.putAll(extraInfo);
        }
        f222723d.h(eventName, hashMap);
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(mTaskKey, eventName, hashMap);
    }

    @JvmStatic
    public static final void e() {
        boolean isBlank;
        if (!GuildFeedReportHelper.i().g()) {
            return;
        }
        bl.c().e(f222723d);
        isBlank = StringsKt__StringsJVMKt.isBlank(mTaskKey);
        if (isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedDetailTimeCostReportTask", 2, "endTask but taskKey is empty. return");
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
            logger2.d().d("GuildFeedDetailTimeCostReportTask", 2, "endTask, taskKey=" + mTaskKey);
        }
        mTaskKey = "";
    }

    private final void f(long costTime, String taskAttributesKey) {
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        HashMap hashMap = new HashMap();
        hashMap.put(taskAttributesKey, String.valueOf(costTime));
        ((IQQOpenTelemetryReportApi) api).setOpenTelemetryTaskAttributes(mTaskKey, hashMap);
    }

    private final void g(HashMap<String, String> params, String taskAttributesKey) {
        long d16 = az.d(params.get("cost_time"), -1L);
        if (d16 > -1) {
            f(d16, taskAttributesKey);
        }
    }

    private final void h(String eventName, HashMap<String, String> params) {
        switch (eventName.hashCode()) {
            case -986566877:
                if (eventName.equals("resource_request_total")) {
                    g(params, "cost_time_resource_request");
                    return;
                }
                return;
            case -721233473:
                if (eventName.equals("data_request_total")) {
                    g(params, "cost_time_data_request");
                    return;
                }
                return;
            case -60163210:
                if (eventName.equals("webview_load_request_finish")) {
                    g(params, "cost_time_load_request");
                    return;
                }
                return;
            case -13445124:
                if (eventName.equals("get_detail_json_data")) {
                    c(params, "is_hit_detail_cache_data");
                    return;
                }
                return;
            case 1248323439:
                if (eventName.equals("html_render_total")) {
                    g(params, "cost_time_total");
                    g(params, "cost_time_html_render");
                    c(params, "is_hit_index_offline");
                    if (params.containsKey("is_hit_detail_cache_data")) {
                        c(params, "is_hit_detail_cache_data");
                        return;
                    }
                    return;
                }
                return;
            case 1470414122:
                if (eventName.equals("webview_on_init")) {
                    c(params, "web_process_status");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @JvmStatic
    public static final void i(@NotNull GuildFeedDetailInitData initData) {
        Intrinsics.checkNotNullParameter(initData, "initData");
        if (!GuildFeedReportHelper.i().g()) {
            return;
        }
        bl.c().d(f222723d);
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        String startOpenTelemetryTask = iQQOpenTelemetryReportApi.startOpenTelemetryTask("gpro_quality#time_cost#channel_topic_detail");
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTa\u2026LD_FEED_DETAIL_TIME_COST)");
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
        Long mStartTime = initData.getMStartTime();
        if (mStartTime != null) {
            hashMap.put("start_time", String.valueOf(mStartTime.longValue()));
        }
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(mTaskKey, "start", hashMap);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedDetailTimeCostReportTask", 2, "startTask, taskKey=" + mTaskKey + ", initData: " + initData);
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
        QLog.i("GuildFeedDetailTimeCostReportTask", 1, "onReceiveEvent: " + event);
        if (event != null && (event instanceof GuildFeedReportEvent)) {
            GuildFeedReportEvent guildFeedReportEvent = (GuildFeedReportEvent) event;
            if (guildFeedReportEvent.getGuildFeedReportBean() == null) {
                return;
            }
            boolean z16 = false;
            if (!com.tencent.mobileqq.utils.bl.b(guildFeedReportEvent.getGuildFeedReportBean().getReportList())) {
                for (GuildFeedReportBean.ReportBean reportBean : guildFeedReportEvent.getGuildFeedReportBean().getReportList()) {
                    if (Intrinsics.areEqual(reportBean.getTaskName(), "gpro_quality#time_cost#channel_topic_detail")) {
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
                e();
            }
        }
    }
}
