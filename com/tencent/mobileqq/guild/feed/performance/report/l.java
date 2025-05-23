package com.tencent.mobileqq.guild.feed.performance.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftNativeAutoRestoreEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedEditPublishEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedPublishQualityEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001-\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007JZ\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0002J8\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u000b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010!\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u001cH\u0014J$\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#`%H\u0014R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R2\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0\nj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/l;", "Lcom/tencent/mobileqq/guild/feed/performance/report/a;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishInitBean;", "initBean", "", "r", "o", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraInfo", "", "errCode", "errMsg", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "", "map", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedReportBean$ReportBean;", "bean", "j", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "i", "l", "k", tl.h.F, "b", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/mobileqq/guild/feed/performance/report/n;", "e", "Lcom/tencent/mobileqq/guild/feed/performance/report/n;", "curWebReportBeanGuild", "Ljava/util/HashMap;", "publishWebReportMapGuild", "com/tencent/mobileqq/guild/feed/performance/report/l$a", "Lcom/tencent/mobileqq/guild/feed/performance/report/l$a;", "editPublishReceiver", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends com.tencent.mobileqq.guild.feed.performance.report.a {

    /* renamed from: e, reason: from kotlin metadata */
    @Nullable
    private static n curWebReportBeanGuild;

    /* renamed from: d */
    @NotNull
    public static final l f222740d = new l();

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private static HashMap<String, n> publishWebReportMapGuild = new HashMap<>();

    /* renamed from: h */
    @NotNull
    private static final a editPublishReceiver = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004`\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/performance/report/l$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/publish/event/GuildFeedEditPublishEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements SimpleEventReceiver<GuildFeedEditPublishEvent> {
        a() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<GuildFeedEditPublishEvent>> getEventClass() {
            ArrayList<Class<GuildFeedEditPublishEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedEditPublishEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            GuildFeedEditPublishEvent guildFeedEditPublishEvent;
            GuildFeedPublishInitBean initBean;
            if (event instanceof GuildFeedEditPublishEvent) {
                guildFeedEditPublishEvent = (GuildFeedEditPublishEvent) event;
            } else {
                guildFeedEditPublishEvent = null;
            }
            if (guildFeedEditPublishEvent == null || (initBean = guildFeedEditPublishEvent.getInitBean()) == null) {
                return;
            }
            l.r(initBean);
        }
    }

    l() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void f(@Nullable String r65, @NotNull String event, @Nullable HashMap<String, String> extraInfo, long errCode, @Nullable String errMsg) {
        n nVar;
        Intrinsics.checkNotNullParameter(event, "event");
        if (extraInfo == null) {
            extraInfo = new HashMap<>();
        }
        HashMap<String, String> hashMap = extraInfo;
        if (TextUtils.isEmpty(r65)) {
            nVar = curWebReportBeanGuild;
        } else {
            nVar = publishWebReportMapGuild.get(r65);
        }
        n nVar2 = nVar;
        if (nVar2 != null) {
            nVar2.c(event, hashMap, errCode, errMsg);
        }
    }

    public static /* synthetic */ void g(String str, String str2, HashMap hashMap, long j3, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = new HashMap();
        }
        HashMap hashMap2 = hashMap;
        if ((i3 & 8) != 0) {
            j3 = 0;
        }
        long j16 = j3;
        if ((i3 & 16) != 0) {
            str3 = "";
        }
        f(str, str2, hashMap2, j16, str3);
    }

    private final void h(SimpleBaseEvent simpleBaseEvent) {
        GuildDraftNativeAutoRestoreEvent guildDraftNativeAutoRestoreEvent;
        n nVar;
        if (simpleBaseEvent instanceof GuildDraftNativeAutoRestoreEvent) {
            guildDraftNativeAutoRestoreEvent = (GuildDraftNativeAutoRestoreEvent) simpleBaseEvent;
        } else {
            guildDraftNativeAutoRestoreEvent = null;
        }
        if (guildDraftNativeAutoRestoreEvent != null && (nVar = curWebReportBeanGuild) != null) {
            String mainTaskId = guildDraftNativeAutoRestoreEvent.getMainTaskId();
            Intrinsics.checkNotNullExpressionValue(mainTaskId, "autoRestoreEvent.mainTaskId");
            nVar.E(mainTaskId);
            HashMap<String, n> hashMap = publishWebReportMapGuild;
            String mainTaskId2 = guildDraftNativeAutoRestoreEvent.getMainTaskId();
            Intrinsics.checkNotNullExpressionValue(mainTaskId2, "autoRestoreEvent.mainTaskId");
            hashMap.put(mainTaskId2, nVar);
        }
    }

    private final void i(SimpleBaseEvent event) {
        GuildFeedReportEvent guildFeedReportEvent;
        GuildFeedReportBean guildFeedReportBean;
        if (event instanceof GuildFeedReportEvent) {
            guildFeedReportEvent = (GuildFeedReportEvent) event;
        } else {
            guildFeedReportEvent = null;
        }
        if (guildFeedReportEvent == null || (guildFeedReportBean = guildFeedReportEvent.getGuildFeedReportBean()) == null) {
            return;
        }
        List<String> m3 = m();
        List<GuildFeedReportBean.ReportBean> reportList = guildFeedReportBean.getReportList();
        if (reportList != null) {
            ArrayList<GuildFeedReportBean.ReportBean> arrayList = new ArrayList();
            for (Object obj : reportList) {
                if (!m3.contains(((GuildFeedReportBean.ReportBean) obj).getEvent())) {
                    arrayList.add(obj);
                }
            }
            for (GuildFeedReportBean.ReportBean it : arrayList) {
                l lVar = f222740d;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                lVar.j(it);
            }
        }
    }

    private final void j(GuildFeedReportBean.ReportBean bean) {
        String str;
        Map<String, String> params = bean.getParams();
        if (params == null || (str = params.get("feed_publish_task_id")) == null) {
            str = "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            u(str2);
        }
        String event = bean.getEvent();
        Intrinsics.checkNotNullExpressionValue(event, "bean.event");
        Map<String, String> params2 = bean.getParams();
        Intrinsics.checkNotNullExpressionValue(params2, "bean.params");
        f(str2, event, t(params2), 0L, "");
    }

    private final void k(SimpleBaseEvent event) {
        GuildPublishViewDestroyEvent guildPublishViewDestroyEvent;
        if (event instanceof GuildPublishViewDestroyEvent) {
            guildPublishViewDestroyEvent = (GuildPublishViewDestroyEvent) event;
        } else {
            guildPublishViewDestroyEvent = null;
        }
        if (guildPublishViewDestroyEvent == null) {
            return;
        }
        String taskId = guildPublishViewDestroyEvent.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        g(taskId, "feed_publish_exit_webview_fragment", null, 0L, null, 28, null);
        n();
    }

    private final void l(SimpleBaseEvent event) {
        GuildFeedPublishQualityEvent guildFeedPublishQualityEvent;
        QCirclePublishQualityDataBuilder builder;
        HashMap hashMapOf;
        if (event instanceof GuildFeedPublishQualityEvent) {
            guildFeedPublishQualityEvent = (GuildFeedPublishQualityEvent) event;
        } else {
            guildFeedPublishQualityEvent = null;
        }
        if (guildFeedPublishQualityEvent == null || (builder = guildFeedPublishQualityEvent.getBuilder()) == null) {
            return;
        }
        String taskId = builder.getTraceId();
        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
        u(taskId);
        String eventId = builder.getKeyEventId();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feed_publish_task_id", builder.getTraceId()), TuplesKt.to("feed_publish_quality_report_content", builder.toString()));
        Intrinsics.checkNotNullExpressionValue(eventId, "eventId");
        f(taskId, eventId, hashMapOf, 0L, "");
    }

    private final List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"html_render", "resource_request"});
        return listOf;
    }

    private final void n() {
        bl.c().e(this);
        curWebReportBeanGuild = null;
    }

    @JvmStatic
    public static final void o() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.performance.report.j
            @Override // java.lang.Runnable
            public final void run() {
                l.p();
            }
        }, 16, null, false);
    }

    public static final void p() {
        if (1 == MobileQQ.sProcessId) {
            bl.c().d(editPublishReceiver);
        }
    }

    @JvmStatic
    public static final void q(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        publishWebReportMapGuild.remove(taskId);
    }

    @JvmStatic
    public static final void r(@NotNull final GuildFeedPublishInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.performance.report.k
            @Override // java.lang.Runnable
            public final void run() {
                l.s(GuildFeedPublishInitBean.this);
            }
        });
    }

    public static final void s(GuildFeedPublishInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        if (1 != MobileQQ.sProcessId) {
            bl.c().b(new GuildFeedEditPublishEvent(initBean), true);
            return;
        }
        bl.c().d(f222740d);
        n nVar = new n(initBean);
        curWebReportBeanGuild = nVar;
        nVar.u("gpro_quality#event#feed_channel_publish");
    }

    private final HashMap<String, String> t(Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (map.isEmpty()) {
            return hashMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    private final void u(String r46) {
        String str;
        n nVar = curWebReportBeanGuild;
        if (nVar == null || (str = nVar.getTaskId()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && !Intrinsics.areEqual(r46, str)) {
            QLog.e("GuildFeedPublishReportTask", 1, "current taskId " + str + " != receive taskID " + r46);
        }
        n nVar2 = curWebReportBeanGuild;
        if (nVar2 != null) {
            nVar2.E(r46);
            publishWebReportMapGuild.put(r46, nVar2);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.a
    @NotNull
    protected ArrayList<Class<Object>> a() {
        ArrayList<Class<Object>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedReportEvent.class, GuildFeedPublishQualityEvent.class, GuildPublishViewDestroyEvent.class, GuildDraftNativeAutoRestoreEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.performance.report.a
    protected void b(@Nullable SimpleBaseEvent event) {
        String str;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            n nVar = curWebReportBeanGuild;
            if (nVar != null) {
                str = nVar.getTaskId();
            } else {
                str = null;
            }
            d16.d("GuildFeedPublishReportTask", 2, "[onReceiveEventBusEvent] , curTaskId " + str + ",  onReceiveEvent " + event);
        }
        if (event instanceof GuildFeedReportEvent) {
            i(event);
            return;
        }
        if (event instanceof GuildFeedPublishQualityEvent) {
            l(event);
        } else if (event instanceof GuildPublishViewDestroyEvent) {
            k(event);
        } else if (event instanceof GuildDraftNativeAutoRestoreEvent) {
            h(event);
        }
    }
}
