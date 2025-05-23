package com.tencent.mobileqq.guild.media.thirdapp.container.report;

import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\u001d\u0018\u0000 $2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0001`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0014\u0010!\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/b;", "", "", "f", "", "serviceDisconnected", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "g", "", "a", "J", "backgroundStartTime", "b", "Z", "isForeground", "c", "mWebAlreadyAttach", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "mReportTask", "e", "mLastReportTime", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mParams", "com/tencent/mobileqq/guild/media/thirdapp/container/report/b$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/b$b;", "applicationLifeCallback", h.F, "startTime", "<init>", "()V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long backgroundStartTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mWebAlreadyAttach;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask mReportTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isForeground = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLastReportTime = System.currentTimeMillis();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mParams = new HashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7839b applicationLifeCallback = new C7839b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long startTime = System.currentTimeMillis();

    public static /* synthetic */ void e(b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        bVar.d(z16);
    }

    public final void d(boolean serviceDisconnected) {
        int i3;
        HashMap hashMapOf;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask iPerformanceReportTask = null;
        if (this.mReportTask == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("endTask ignored. taskKey is empty. return");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebLifeReportTask", 1, (String) it.next(), null);
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.startTime;
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        if (serviceDisconnected) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        long j3 = 0;
        if (this.backgroundStartTime > 0) {
            j3 = System.currentTimeMillis() - this.backgroundStartTime;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("time_cost", String.valueOf(currentTimeMillis)), TuplesKt.to("web_process_status", String.valueOf(isProcessRunning)), TuplesKt.to("preLoad", String.valueOf(this.mWebAlreadyAttach)), TuplesKt.to("is_backup", String.valueOf(!this.isForeground)), TuplesKt.to("ret", String.valueOf(i3)), TuplesKt.to("on_hide", String.valueOf(j3)));
        this.mParams.putAll(hashMapOf);
        IPerformanceReportTask iPerformanceReportTask2 = this.mReportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode("end");
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(i3);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setExtras(this.mParams);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebLifeReportTask", 1, "endTask, serviceDisconnected " + serviceDisconnected + " toolExits " + isProcessRunning + ", isForeground " + this.isForeground + ", backGroundTimeCost " + j3);
        GuardManagerCallbackDispatcher.unregisterCallBack(this.applicationLifeCallback);
    }

    public final void f() {
        this.mWebAlreadyAttach = true;
    }

    public final void g(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        if (this.mReportTask != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("addTaskEvent ignored. taskKey is not empty. return");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebLifeReportTask", 1, (String) it.next(), null);
            }
            return;
        }
        GuardManagerCallbackDispatcher.registerCallBack(this.applicationLifeCallback);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("guild_id", startParams.getGuildId()), TuplesKt.to("channel_id", startParams.getChannelId()), TuplesKt.to("url", startParams.getUrl()), TuplesKt.to("web_process_status", String.valueOf(QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool"))), TuplesKt.to("start_time", String.valueOf(System.currentTimeMillis())));
        this.mParams.putAll(hashMapOf);
        IPerformanceReportTask stageCode = Reporters.f231995a.b().a("gpro_quality#event#av_channel_web_life").setStageCode("start");
        this.mReportTask = stageCode;
        if (stageCode != null) {
            stageCode.setExtras(this.mParams);
        }
        IPerformanceReportTask iPerformanceReportTask = this.mReportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        this.mLastReportTime = System.currentTimeMillis();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebLifeReportTask", 1, "startTask");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/report/b$b", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.report.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7839b implements IGuardInterface {
        C7839b() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebLifeReportTask", 1, "onApplicationBackground");
            b.this.isForeground = false;
            b.this.backgroundStartTime = System.currentTimeMillis();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebLifeReportTask", 1, "onApplicationForeground");
            b.this.isForeground = true;
            b.this.backgroundStartTime = 0L;
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
            long j3;
            b.this.isForeground = isEnabled;
            b bVar = b.this;
            if (!isEnabled) {
                j3 = System.currentTimeMillis();
            } else {
                j3 = 0;
            }
            bVar.backgroundStartTime = j3;
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }
    }
}
