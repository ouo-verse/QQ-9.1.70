package com.tencent.mobileqq.guild.report;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a2\u0006\u0002\b\u0003H\u0000\u001a'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a2\u0006\u0002\b\u0003H\u0000\u00a8\u0006\t"}, d2 = {"Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/report/j;", "", "Lkotlin/ExtensionFunctionType;", "optionScope", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/guild/report/h;", "b", "a", "base_proj_ext_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ReportersKt {
    @NotNull
    public static final Lazy<ReportOption> a(@NotNull final Function1<? super ReportOption, Unit> optionScope) {
        Lazy<ReportOption> lazy;
        Intrinsics.checkNotNullParameter(optionScope, "optionScope");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ReportOption>() { // from class: com.tencent.mobileqq.guild.report.ReportersKt$forceReportOption$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReportOption invoke() {
                ReportOption reportOption = new ReportOption(null, null, null, false, 0.0f, 0.0f, 63, null);
                optionScope.invoke(reportOption);
                return reportOption;
            }
        });
        return lazy;
    }

    @NotNull
    public static final Lazy<h> b(@NotNull final Function1<? super ReportOption, Unit> optionScope) {
        Lazy<h> lazy;
        Intrinsics.checkNotNullParameter(optionScope, "optionScope");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.mobileqq.guild.report.ReportersKt$reportOption$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                ReportOption reportOption = new ReportOption(null, null, null, false, 0.0f, 0.0f, 63, null);
                optionScope.invoke(reportOption);
                return reportOption.b();
            }
        });
        return lazy;
    }
}
