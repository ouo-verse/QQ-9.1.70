package com.tencent.qmethod.monitor.debug.question;

import com.tencent.qmethod.pandoraex.api.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qmethod/pandoraex/api/u;", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull u getKey) {
        Intrinsics.checkParameterIsNotNull(getKey, "$this$getKey");
        return getKey.f343964a + '/' + getKey.f343965b;
    }
}
