package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.util.cv;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/y;", "", "", "from", "", "e", "", "endType", "d", "c", "type", "f", "b", "Ljava/lang/String;", "taskKey", "", "J", "startTime", "I", "cookie", "traceName", "spanName", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "g", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class y {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int cookie;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IPerformanceReportTask reportTask;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f231068a = new y();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String taskKey = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String traceName = "Guild.Report.TabInit.ClickTab.";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String spanName = "";

    y() {
    }

    @JvmStatic
    public static final void c() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(taskKey);
        if (!isBlank) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildTabInitReportTask", 2, "cancel report taskKey=" + taskKey + ", spanName:" + spanName);
            }
            taskKey = "";
        }
    }

    @JvmStatic
    public static final void d(@NotNull String endType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(endType, "endType");
        if (taskKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildTabInitReportTask", 2, "endTask but taskKey is empty, spanName:" + spanName + ", endType:" + endType);
                return;
            }
            return;
        }
        IPerformanceReportTask iPerformanceReportTask = reportTask;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        TraceUtils.j(traceName + taskKey, cookie);
        taskKey = "";
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildTabInitReportTask", 2, "endTask, taskKey= " + taskKey + ", spanName:" + spanName + ", endType:" + endType + ", timeCost:" + currentTimeMillis);
        }
    }

    private final void e(int from) {
        if (from != 0) {
            if (from == 1) {
                spanName = "gpro_quality#time_cost#gpro_tab_with_qq";
                traceName = "Guild.Report.TabInit.ColdStartup.";
                return;
            }
            return;
        }
        spanName = "gpro_quality#time_cost#gpro_tab";
        traceName = "Guild.Report.TabInit.ClickTab.";
    }

    public final void f(int type) {
        String str;
        boolean z16;
        if (startTime != 0) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildTabInitReportTask", 2, "repeated report");
                return;
            }
            return;
        }
        IPerformanceReportTask eventCode = Reporters.f231995a.b().newReportTask().setEventCode("guild_tab_init_time_cost");
        reportTask = eventCode;
        boolean z17 = false;
        if (eventCode != null) {
            if (type == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            eventCode.setParam("is_cold", String.valueOf(z16));
        }
        IPerformanceReportTask iPerformanceReportTask = reportTask;
        if (iPerformanceReportTask != null) {
            if (type == 1) {
                z17 = true;
            }
            iPerformanceReportTask.setExtra("is_cold", Boolean.valueOf(z17));
        }
        e(type);
        startTime = System.currentTimeMillis();
        IPerformanceReportTask iPerformanceReportTask2 = reportTask;
        if (iPerformanceReportTask2 == null || (str = kw1.a.f413327a.c(iPerformanceReportTask2)) == null) {
            str = "";
        }
        taskKey = str;
        cookie = TraceUtils.g(traceName + str);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildTabInitReportTask", 2, "startTask, taskKey= " + taskKey + ", spanName:" + spanName);
        }
        cv.c("GuildTabInitReportTask click guild tab");
        uh1.a aVar = uh1.a.f438959a;
        aVar.d("click guild tab");
        aVar.b();
    }
}
