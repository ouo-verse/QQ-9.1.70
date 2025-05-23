package com.tencent.mobileqq.guild.media.thirdapp.container.report;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001cj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u001cj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebTimeReportTask;", "", "", "g", "", AdMetricTag.EVENT_NAME, "d", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "c", "f", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", h.F, "", "a", "J", "mWebStartTime", "b", "mWebLoadEndTime", "", "Z", "mWebAlreadyAttach", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "mReportTask", "mLastReportTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mParams", "reportEventMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaWebTimeReportTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long mWebStartTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mWebLoadEndTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mWebAlreadyAttach;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask mReportTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLastReportTime = System.currentTimeMillis();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mParams = new HashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<RemoteWebTimeCost, String> reportEventMap;

    public GuildMediaWebTimeReportTask() {
        HashMap<RemoteWebTimeCost, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(RemoteWebTimeCost.REMOTE_ACTIVITY_ON_CREATE, "media_web_activity_on_create"), TuplesKt.to(RemoteWebTimeCost.SHOW_PRESENTATION, "media_web_show_presentation"), TuplesKt.to(RemoteWebTimeCost.BEFORE_CREATE_WEB_VIEW, "media_web_before_create_web_view"), TuplesKt.to(RemoteWebTimeCost.CREATE_WEB_VIEW, "media_web_create_web_view"), TuplesKt.to(RemoteWebTimeCost.BEFORE_LOAD_URL, "media_web_before_load_url"), TuplesKt.to(RemoteWebTimeCost.REBUILD_WEB_VIEW, "media_web_remote_rebuild"));
        this.reportEventMap = hashMapOf;
    }

    private final void g() {
        if (this.mWebLoadEndTime == 0) {
            this.mWebLoadEndTime = System.currentTimeMillis();
        }
    }

    public final void c(@NotNull RemoteWebTimeCost type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String str = this.reportEventMap.get(type);
        if (str == null) {
            return;
        }
        if (type == RemoteWebTimeCost.BEFORE_LOAD_URL) {
            g();
        }
        d(str);
    }

    public final void d(@NotNull String eventName) {
        HashMap hashMapOf;
        IPerformanceReportTask iPerformanceReportTask;
        IPerformanceReportTask duplicate;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebTimeReportTask", 1, "addTaskEvent event: " + eventName);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("start_time", String.valueOf(System.currentTimeMillis())), TuplesKt.to("cost_time", String.valueOf(System.currentTimeMillis() - this.mWebStartTime)));
        IPerformanceReportTask iPerformanceReportTask2 = this.mReportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode(eventName);
        } else {
            iPerformanceReportTask = null;
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setTimeCost(System.currentTimeMillis() - this.mLastReportTime);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(this.mParams);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(hashMapOf);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        this.mLastReportTime = System.currentTimeMillis();
    }

    public final void e() {
        HashMap hashMapOf;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask iPerformanceReportTask = null;
        if (this.mWebAlreadyAttach) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "endTask ignored. taskKey is empty. return mWebAlreadyAttach " + this.mWebAlreadyAttach;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebTimeReportTask", 1, (String) it.next(), null);
            }
            return;
        }
        g();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("time_cost", String.valueOf(this.mWebLoadEndTime - this.mWebStartTime)));
        this.mParams.putAll(hashMapOf);
        IPerformanceReportTask iPerformanceReportTask2 = this.mReportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode("end");
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setTimeCost(System.currentTimeMillis() - this.mLastReportTime);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(this.mParams);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebTimeReportTask", 1, "endTask, params " + hashMapOf);
    }

    public final void f() {
        this.mWebAlreadyAttach = true;
    }

    public final void h(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        long currentTimeMillis = System.currentTimeMillis();
        this.mWebStartTime = currentTimeMillis;
        this.mLastReportTime = currentTimeMillis;
        this.mReportTask = Reporters.f231995a.b().a("gpro_quality#event#av_channel_web");
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("guild_id", startParams.getGuildId()), TuplesKt.to("channel_id", startParams.getChannelId()), TuplesKt.to("url", startParams.getUrl()), TuplesKt.to("web_process_status", String.valueOf(isProcessRunning)), TuplesKt.to("start_time", String.valueOf(System.currentTimeMillis())));
        this.mParams.putAll(hashMapOf);
        IPerformanceReportTask iPerformanceReportTask = this.mReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setStageCode("start");
        }
        IPerformanceReportTask iPerformanceReportTask2 = this.mReportTask;
        if (iPerformanceReportTask2 != null) {
            iPerformanceReportTask2.setExtras(this.mParams);
        }
        IPerformanceReportTask iPerformanceReportTask3 = this.mReportTask;
        if (iPerformanceReportTask3 != null) {
            iPerformanceReportTask3.report();
        }
        j.a().d0().x1(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebTimeReportTask$startTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String openId) {
                HashMap hashMapOf2;
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(openId, "openId");
                if (openId.length() == 0) {
                    return;
                }
                Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebTimeReportTask", 1, "[startTask] getOpenId " + openId);
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("open_id", openId));
                hashMap = GuildMediaWebTimeReportTask.this.mParams;
                hashMap.putAll(hashMapOf2);
            }
        });
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebTimeReportTask", 1, "startTask, toolExits " + isProcessRunning);
    }
}
