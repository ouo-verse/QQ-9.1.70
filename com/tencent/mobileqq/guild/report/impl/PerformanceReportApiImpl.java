package com.tencent.mobileqq.guild.report.impl;

import com.tencent.mobileqq.guild.report.IPerformanceReportApi;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.ReportOption;
import com.tencent.mobileqq.guild.report.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportApiImpl;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportApi;", "", "name", "Lcom/tencent/mobileqq/guild/report/j;", "option", "Lcom/tencent/mobileqq/guild/report/h;", "newReportClient", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "newForceReportTask", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PerformanceReportApiImpl implements IPerformanceReportApi {
    private static final String BUILD_TYPE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String LOG_TAG = "PerformanceReportApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportApiImpl$a;", "", "", "b", "BUILD_TYPE", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "LOG_TAG", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.report.impl.PerformanceReportApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            return "public";
        }

        public final String c() {
            return PerformanceReportApiImpl.BUILD_TYPE;
        }

        Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        BUILD_TYPE = companion.b();
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportApi
    public IPerformanceReportTask newForceReportTask(String name, ReportOption option) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(option, "option");
        PerformanceReportTask performanceReportTask = new PerformanceReportTask(option.getAppKey(), name);
        PerformanceReportTask.init$default(performanceReportTask, null, 1, null);
        performanceReportTask.setForceReport(true);
        return performanceReportTask;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportApi
    public h newReportClient(String name, ReportOption option) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(option, "option");
        return c.f232031a.a(name, new PerformanceReportClient(name, option, option.getForceReport()));
    }
}
