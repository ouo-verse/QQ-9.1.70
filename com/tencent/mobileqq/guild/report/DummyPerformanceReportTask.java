package com.tencent.mobileqq.guild.report;

import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0000H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/report/DummyPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "()V", "readResolve", "", "report", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class DummyPerformanceReportTask implements IPerformanceReportTask {

    @NotNull
    public static final DummyPerformanceReportTask INSTANCE = new DummyPerformanceReportTask();

    DummyPerformanceReportTask() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask duplicate(@NotNull String... strArr) {
        return IPerformanceReportTask.a.a(this, strArr);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public String getTraceId() {
        return IPerformanceReportTask.a.b(this);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public boolean hasReported() {
        return IPerformanceReportTask.a.c(this);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public DummyPerformanceReportTask report() {
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setAppChannel(@NotNull String str) {
        return IPerformanceReportTask.a.d(this, str);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setEnterFrom(@NotNull String str) {
        return IPerformanceReportTask.a.e(this, str);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setEventCode(@NotNull String str) {
        return IPerformanceReportTask.a.f(this, str);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setExtra(@NotNull String str, @Nullable Object obj) {
        return IPerformanceReportTask.a.g(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setExtras(@NotNull Map<String, ? extends Object> map) {
        return IPerformanceReportTask.a.h(this, map);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setParam(@NotNull String str, @NotNull String str2) {
        return IPerformanceReportTask.a.i(this, str, str2);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setRealTime(boolean z16) {
        return IPerformanceReportTask.a.j(this, z16);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setResultCode(long j3) {
        return IPerformanceReportTask.a.k(this, j3);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setResultMsg(@NotNull String str) {
        return IPerformanceReportTask.a.l(this, str);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setStageCode(@NotNull String str) {
        return IPerformanceReportTask.a.m(this, str);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    @NotNull
    public IPerformanceReportTask setTimeCost(long j3) {
        return IPerformanceReportTask.a.n(this, j3);
    }
}
