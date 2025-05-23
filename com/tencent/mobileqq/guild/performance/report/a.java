package com.tencent.mobileqq.guild.performance.report;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J:\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J0\u0010\r\u001a\u00020\u00042&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016J8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/a;", "Lcom/tencent/mobileqq/guild/performance/report/z;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "task", "", "f", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraInfo", tl.h.F, "c", "params", "a", "event", "e", "endTask", "g", "d", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "", "J", "startTime", "lastReportTime", "Ljava/util/HashMap;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a implements z {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastReportTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> params;

    public a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.startTime = uptimeMillis;
        this.lastReportTime = uptimeMillis;
        this.params = new HashMap<>();
    }

    private final void f(IPerformanceReportTask task) {
        if (task != null) {
            task.setTimeCost(SystemClock.uptimeMillis() - this.lastReportTime);
        }
        if (task != null) {
            task.report();
        }
        this.lastReportTime = SystemClock.uptimeMillis();
    }

    private final void h(IPerformanceReportTask task, HashMap<String, String> extraInfo) {
        boolean isBlank;
        if (extraInfo != null) {
            for (Map.Entry<String, String> entry : extraInfo.entrySet()) {
                isBlank = StringsKt__StringsJVMKt.isBlank(entry.getKey());
                if ((!isBlank) && task != null) {
                    task.setExtra(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void a(@Nullable HashMap<String, String> params) {
        if (params != null) {
            this.params.putAll(params);
        }
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.startTime = uptimeMillis;
        this.lastReportTime = uptimeMillis;
        String d16 = d();
        IPerformanceReportTask stageCode = Reporters.f231995a.b().a(d16).setStageCode("start");
        this.reportTask = stageCode;
        f(stageCode);
        Logger logger = Logger.f235387a;
        String b16 = b();
        if (QLog.isColorLevel()) {
            logger.d().d(b16, 2, "startTask, taskName=" + d16);
        }
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void e(@NotNull String event, @Nullable HashMap<String, String> extraInfo) {
        IPerformanceReportTask iPerformanceReportTask;
        IPerformanceReportTask duplicate;
        Intrinsics.checkNotNullParameter(event, "event");
        IPerformanceReportTask iPerformanceReportTask2 = this.reportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode(event);
        } else {
            iPerformanceReportTask = null;
        }
        h(iPerformanceReportTask, this.params);
        h(iPerformanceReportTask, extraInfo);
        f(iPerformanceReportTask);
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    public void endTask() {
        IPerformanceReportTask iPerformanceReportTask;
        IPerformanceReportTask duplicate;
        IPerformanceReportTask iPerformanceReportTask2 = this.reportTask;
        if (iPerformanceReportTask2 != null && (duplicate = iPerformanceReportTask2.duplicate(new String[0])) != null) {
            iPerformanceReportTask = duplicate.setStageCode("end");
        } else {
            iPerformanceReportTask = null;
        }
        this.params.put("timestamp_from_start_on", g());
        h(iPerformanceReportTask, this.params);
        f(iPerformanceReportTask);
    }

    @NotNull
    protected final String g() {
        return String.valueOf(SystemClock.uptimeMillis() - this.startTime);
    }
}
