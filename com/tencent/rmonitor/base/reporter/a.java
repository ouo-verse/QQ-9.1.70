package com.tencent.rmonitor.base.reporter;

import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.rmonitor.base.db.DBDataStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rmonitor/base/reporter/a;", "", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "", "a", "b", "", "dbId", "Lcom/tencent/rmonitor/base/db/DBDataStatus;", "status", "c", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface a {
    void a(@NotNull ReportData reportData);

    void b();

    void c(int dbId, @NotNull DBDataStatus status);
}
