package com.tencent.mobileqq.guild.util.report;

import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/util/report/b;", "", "", "eventCode", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "a", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "b", "key", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f235619a = new b();

    b() {
    }

    @JvmStatic
    @NotNull
    public static final IPerformanceReportTask a(@NotNull String eventCode) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        return Reporters.f231995a.b().newReportTask().setEventCode(eventCode).setAppChannel(com.tencent.mobileqq.guild.report.b.c());
    }

    @JvmStatic
    @NotNull
    public static final IPerformanceReportTask b(@NotNull QBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return c(fragment, "_extra_param_report_task");
    }

    @JvmStatic
    @NotNull
    public static final IPerformanceReportTask c(@NotNull QBaseFragment fragment, @NotNull String key) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(key, "key");
        return qw1.b.c(GuildSplitViewUtils.f235370a.g(fragment), key);
    }
}
