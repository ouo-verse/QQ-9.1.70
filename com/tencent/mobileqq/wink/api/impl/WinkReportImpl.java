package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.wink.api.IWinkReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkReportImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkReport;", "()V", "reportBugly", "", "errMsg", "", "extra", "reportDengTa", "action", "map", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkReportImpl implements IWinkReport {
    @Override // com.tencent.mobileqq.wink.api.IWinkReport
    public void reportBugly(@NotNull String errMsg, @Nullable String extra) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (extra != null) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(new RuntimeException(errMsg), extra);
        } else {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(new RuntimeException(errMsg));
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkReport
    public void reportDengTa(@NotNull String action, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(map, "map");
        com.tencent.mobileqq.wink.report.e.o(com.tencent.mobileqq.wink.report.e.f326265a, action, map, false, 4, null);
    }
}
