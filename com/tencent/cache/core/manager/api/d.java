package com.tencent.cache.core.manager.api;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/cache/core/manager/api/d;", "", "", "tag", "msg", "", "e", "", ReportConstant.COSTREPORT_TRANS, "i", "d", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface d {
    void d(@NotNull String tag, @NotNull String msg2);

    void e(@NotNull String tag, @NotNull String msg2);

    void e(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5);

    void i(@NotNull String tag, @NotNull String msg2);
}
