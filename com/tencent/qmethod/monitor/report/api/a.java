package com.tencent.qmethod.monitor.report.api;

import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u00a8\u0006\u0004"}, d2 = {"", "str", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {
    public static final void a(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "str");
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.e("APIInvokeAnalyse", str);
        }
    }
}
