package com.tencent.mobileqq.guild.report;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u000b\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/report/Reporters;", "", "Lcom/tencent/mobileqq/guild/report/h;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/report/h;", "guild", "Lcom/tencent/mobileqq/guild/report/j;", "c", "a", "()Lcom/tencent/mobileqq/guild/report/j;", "forceReportOption", "d", "search", "e", "getTroop", "troop", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class Reporters {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Reporters f231995a = new Reporters();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy guild = ReportersKt.b(new Function1<ReportOption, Unit>() { // from class: com.tencent.mobileqq.guild.report.Reporters$guild$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportOption reportOption) {
            invoke2(reportOption);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ReportOption reportOption) {
            Intrinsics.checkNotNullParameter(reportOption, "$this$reportOption");
            reportOption.j("guild");
            reportOption.h("0AND062LE8518LS5");
            reportOption.i("guild_performance_report_sample_config");
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy forceReportOption = ReportersKt.a(new Function1<ReportOption, Unit>() { // from class: com.tencent.mobileqq.guild.report.Reporters$forceReportOption$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportOption reportOption) {
            invoke2(reportOption);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ReportOption forceReportOption2) {
            Intrinsics.checkNotNullParameter(forceReportOption2, "$this$forceReportOption");
            forceReportOption2.j("forceReport");
            forceReportOption2.h("0AND062LE8518LS5");
        }
    });

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy search = ReportersKt.b(new Function1<ReportOption, Unit>() { // from class: com.tencent.mobileqq.guild.report.Reporters$search$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportOption reportOption) {
            invoke2(reportOption);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ReportOption reportOption) {
            Intrinsics.checkNotNullParameter(reportOption, "$this$reportOption");
            reportOption.j("search");
            reportOption.h("0AND065T223AXNVN");
            reportOption.i("guild_performance_report_sample_config");
        }
    });

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy troop = ReportersKt.b(new Function1<ReportOption, Unit>() { // from class: com.tencent.mobileqq.guild.report.Reporters$troop$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportOption reportOption) {
            invoke2(reportOption);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ReportOption reportOption) {
            Intrinsics.checkNotNullParameter(reportOption, "$this$reportOption");
            reportOption.h("xxxx");
        }
    });

    Reporters() {
    }

    @NotNull
    public final ReportOption a() {
        return (ReportOption) forceReportOption.getValue();
    }

    @NotNull
    public final h b() {
        return (h) guild.getValue();
    }

    @NotNull
    public final h c() {
        return (h) search.getValue();
    }
}
