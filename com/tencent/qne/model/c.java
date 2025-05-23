package com.tencent.qne.model;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", AdMetricTag.FALLBACK, "a", "qne_debug"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull String fallback) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        String model = DeviceInfoMonitor.getModel();
        d dVar = d.f344351c;
        if (dVar.b().contains(model)) {
            return dVar.a();
        }
        e eVar = e.f344352c;
        String a16 = eVar.a();
        Intrinsics.checkNotNullExpressionValue(model, "");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) a16, (CharSequence) model, false, 2, (Object) null);
        if (contains$default) {
            return eVar.a();
        }
        return fallback;
    }
}
