package com.tencent.mobileqq.guild.feed.performance.report;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u001d\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104JJ\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\\\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003JJ\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0015\u001a\u00020\u0011J\\\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J.\u0010\u0017\u001a\u00020\t2$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u001a\u0010!\u001a\u00020\u00038\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#R\"\u0010(\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010'R\"\u0010+\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010'R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010,R7\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b`\u00048DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/GuildFeedBaseReportData;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "eventAttributeParams", "k", "event", "taskAttributeParams", "", "p", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "taskName", "u", "extraInfo", "", "errCode", "errMsg", "c", "i", "l", ReportConstant.COSTREPORT_PREFIX, "", tl.h.F, "o", "f", DomainData.DOMAIN_NAME, "d", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "TAG", "taskKey", "J", "startTimestamp", "getGuildId", "t", "(Ljava/lang/String;)V", "guildId", "getChannelId", "r", "channelId", "Ljava/util/List;", "singleEvent", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "g", "()Ljava/util/HashMap;", "hitSingleEvent", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedBaseReportData {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy hitSingleEvent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "GuildFeedReport_" + n();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String taskKey = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> singleEvent = h();

    public GuildFeedBaseReportData() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, Boolean>>() { // from class: com.tencent.mobileqq.guild.feed.performance.report.GuildFeedBaseReportData$hitSingleEvent$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, Boolean> invoke() {
                return new HashMap<>();
            }
        });
        this.hitSingleEvent = lazy;
    }

    public static /* synthetic */ void d(GuildFeedBaseReportData guildFeedBaseReportData, String str, HashMap hashMap, long j3, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                hashMap = new HashMap();
            }
            HashMap hashMap2 = hashMap;
            if ((i3 & 4) != 0) {
                j3 = 0;
            }
            long j16 = j3;
            if ((i3 & 8) != 0) {
                str2 = "";
            }
            guildFeedBaseReportData.c(str, hashMap2, j16, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addTaskEvent");
    }

    private final boolean e(String event) {
        if (m(event)) {
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "addTaskEvent " + event + " return, taskKey already report! ");
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HashMap<String, String> k(HashMap<String, String> eventAttributeParams) {
        if (eventAttributeParams.isEmpty()) {
            return new HashMap<>();
        }
        List<String> o16 = o();
        HashMap<String, String> hashMap = new HashMap<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : eventAttributeParams.entrySet()) {
            if (o16.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            hashMap.put(entry2.getKey(), entry2.getValue());
        }
        return hashMap;
    }

    private final synchronized boolean m(String event) {
        if (this.singleEvent.contains(event)) {
            if (g().containsKey(event)) {
                return true;
            }
            synchronized (this) {
                if (!g().containsKey(event)) {
                    g().put(event, Boolean.TRUE);
                    Logger logger = Logger.f235387a;
                    String str = this.TAG;
                    if (QLog.isColorLevel()) {
                        logger.d().d(str, 2, "updateHitSingleEvent  taskKey=" + this.taskKey + ", event: " + event);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return true;
        }
        return false;
    }

    private final void p(final String event, final HashMap<String, String> eventAttributeParams, final HashMap<String, String> taskAttributeParams) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.performance.report.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedBaseReportData.q(GuildFeedBaseReportData.this, taskAttributeParams, event, eventAttributeParams);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildFeedBaseReportData this$0, HashMap taskAttributeParams, String event, HashMap eventAttributeParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(taskAttributeParams, "$taskAttributeParams");
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(eventAttributeParams, "$eventAttributeParams");
        if (TextUtils.isEmpty(this$0.taskKey)) {
            Logger logger = Logger.f235387a;
            String str = this$0.TAG;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "realAddTaskEvent event: " + event + " return because taskKey is empty!");
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        String str2 = this$0.TAG;
        if (QLog.isColorLevel()) {
            logger2.d().d(str2, 2, "doAddTaskEvent event: " + event);
        }
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) api;
        if (!taskAttributeParams.isEmpty()) {
            iQQOpenTelemetryReportApi.setOpenTelemetryTaskAttributes(this$0.taskKey, taskAttributeParams);
        }
        iQQOpenTelemetryReportApi.reportOpenTelemetryTask(this$0.taskKey, event, eventAttributeParams);
        if (Intrinsics.areEqual(event, "end")) {
            iQQOpenTelemetryReportApi.endOpenTelemetryTask(this$0.taskKey);
            this$0.taskKey = "";
        }
    }

    public final void c(@NotNull String event, @NotNull HashMap<String, String> extraInfo, long errCode, @Nullable String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (TextUtils.isEmpty(this.taskKey)) {
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "addTaskEvent return, taskKey isEmpty ");
                return;
            }
            return;
        }
        if (!e(event)) {
            return;
        }
        if (errMsg == null) {
            errMsg = "";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(errCode)), TuplesKt.to("msg", errMsg));
        if (!extraInfo.isEmpty()) {
            hashMapOf.putAll(extraInfo);
        }
        s(hashMapOf);
        HashMap<String, String> k3 = k(hashMapOf);
        if (errCode != 0) {
            k3.put("stage", event);
        }
        l(event, hashMapOf, k3);
        p(event, hashMapOf, k3);
    }

    public void f() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, "endTask, taskKey=" + this.taskKey);
        }
        d(this, "end", null, 0L, null, 14, null);
    }

    @NotNull
    protected final HashMap<String, Boolean> g() {
        return (HashMap) this.hitSingleEvent.getValue();
    }

    @NotNull
    public List<String> h() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* renamed from: i, reason: from getter */
    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    public void l(@NotNull String event, @NotNull HashMap<String, String> eventAttributeParams, @NotNull HashMap<String, String> taskAttributeParams) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventAttributeParams, "eventAttributeParams");
        Intrinsics.checkNotNullParameter(taskAttributeParams, "taskAttributeParams");
    }

    @NotNull
    public String n() {
        throw null;
    }

    @NotNull
    public List<String> o() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"cost_time", "start_time", "ret", "msg", "stage"});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public void s(@NotNull HashMap<String, String> eventAttributeParams) {
        Intrinsics.checkNotNullParameter(eventAttributeParams, "eventAttributeParams");
        if (!eventAttributeParams.containsKey("timestamp_from_start_on")) {
            eventAttributeParams.put("timestamp_from_start_on", String.valueOf(System.currentTimeMillis() - this.startTimestamp));
        }
        if (!eventAttributeParams.containsKey("guild_id") && !TextUtils.isEmpty(this.guildId)) {
            eventAttributeParams.put("guild_id", this.guildId);
        }
        if (!eventAttributeParams.containsKey("channel_id") && !TextUtils.isEmpty(this.channelId)) {
            eventAttributeParams.put("channel_id", this.channelId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void u(@NotNull String taskName) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        if (!TextUtils.isEmpty(this.taskKey)) {
            return;
        }
        if (1 != MobileQQ.sProcessId) {
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            Logger.b bVar = new Logger.b();
            bVar.a().add("can not start task from other process 1");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str, 1, (String) it.next(), null);
            }
            return;
        }
        this.startTimestamp = System.currentTimeMillis();
        QRouteApi api = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQOpenTelemetryReportApi::class.java)");
        String startOpenTelemetryTask = ((IQQOpenTelemetryReportApi) api).startOpenTelemetryTask(taskName);
        Intrinsics.checkNotNullExpressionValue(startOpenTelemetryTask, "api.startOpenTelemetryTask(taskName)");
        this.taskKey = startOpenTelemetryTask;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", "0"), TuplesKt.to("msg", ""), TuplesKt.to("stage", ""), TuplesKt.to("guild_id", this.guildId), TuplesKt.to("channel_id", this.channelId));
        d(this, "start", hashMapOf, 0L, null, 12, null);
        Logger logger2 = Logger.f235387a;
        String str2 = this.TAG;
        if (QLog.isColorLevel()) {
            logger2.d().d(str2, 2, "GuildFeedListReportTask startTask, taskKey=" + this.taskKey + " ");
        }
    }
}
