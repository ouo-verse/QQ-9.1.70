package com.tencent.mobileqq.guild.report.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.ReportOption;
import com.tencent.mobileqq.guild.report.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u0018\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportClient;", "Lcom/tencent/mobileqq/guild/report/h;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "newReportTask", "", "eventCode", "a", AdMetricTag.EVENT_NAME, "", "f", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lcom/tencent/mobileqq/guild/report/j;", "b", "Lcom/tencent/mobileqq/guild/report/j;", "option", "c", "Z", "forceReport", "d", "canCreateReportTask", "Lcom/tencent/mobileqq/guild/report/impl/ReportSampleRate;", "e", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/report/impl/ReportSampleRate;", "sampleRate", "()Z", "isSample", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/report/j;Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PerformanceReportClient implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReportOption option;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean forceReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean canCreateReportTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy sampleRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy isSample;

    public PerformanceReportClient(String name, ReportOption option, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(option, "option");
        this.name = name;
        this.option = option;
        this.forceReport = z16;
        this.canCreateReportTask = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ReportSampleRate>() { // from class: com.tencent.mobileqq.guild.report.impl.PerformanceReportClient$sampleRate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReportSampleRate invoke() {
                ReportOption reportOption;
                ReportOption reportOption2;
                ReportOption reportOption3;
                reportOption = PerformanceReportClient.this.option;
                float defaultGraySampleRate = reportOption.getDefaultGraySampleRate();
                reportOption2 = PerformanceReportClient.this.option;
                float defaultPublicSampleRate = reportOption2.getDefaultPublicSampleRate();
                reportOption3 = PerformanceReportClient.this.option;
                return new ReportSampleRate(defaultGraySampleRate, defaultPublicSampleRate, reportOption3.getFreesiaName());
            }
        });
        this.sampleRate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.report.impl.PerformanceReportClient$isSample$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                ReportSampleRate d16;
                d16 = PerformanceReportClient.this.d();
                return Boolean.valueOf(d16.i());
            }
        });
        this.isSample = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReportSampleRate d() {
        return (ReportSampleRate) this.sampleRate.getValue();
    }

    private final boolean e() {
        return ((Boolean) this.isSample.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.guild.report.h
    public IPerformanceReportTask a(String eventCode) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        if (!this.forceReport && !this.canCreateReportTask && !f(eventCode)) {
            return DummyPerformanceReportTask.INSTANCE;
        }
        PerformanceReportTask performanceReportTask = new PerformanceReportTask(this.option.getAppKey(), this.name);
        PerformanceReportTask.init$default(performanceReportTask, null, 1, null);
        performanceReportTask.setEventCode(eventCode);
        return performanceReportTask;
    }

    public final boolean f(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.canCreateReportTask = e();
        return this.forceReport || d().g(eventName) || (e() && d().j(eventName));
    }

    @Override // com.tencent.mobileqq.guild.report.h
    public IPerformanceReportTask newReportTask() {
        PerformanceReportTask performanceReportTask = new PerformanceReportTask(this.option.getAppKey(), this.name);
        PerformanceReportTask.init$default(performanceReportTask, null, 1, null);
        return performanceReportTask;
    }

    public /* synthetic */ PerformanceReportClient(String str, ReportOption reportOption, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, reportOption, (i3 & 4) != 0 ? false : z16);
    }
}
