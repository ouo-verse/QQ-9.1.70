package com.tencent.mobileqq.qqlive.sail.report;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/report/QQLiveDaTongParams;", "params", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    @NotNull
    public static final QQLiveDaTongParams a(@NotNull QQLiveDaTongParams qQLiveDaTongParams, @NotNull QQLiveDaTongParams params) {
        Map plus;
        Intrinsics.checkNotNullParameter(qQLiveDaTongParams, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        plus = MapsKt__MapsKt.plus(qQLiveDaTongParams.a(), params.a());
        return new QQLiveDaTongParams(plus);
    }
}
