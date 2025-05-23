package com.tencent.rdelivery.reshub.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a \u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a \u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Ljz3/e;", "resConfig", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "", "c", "localConfig", "", "b", "a", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class k {
    public static final boolean a(@NotNull jz3.e resConfig, @Nullable jz3.e eVar, @NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        Intrinsics.checkParameterIsNotNull(req, "req");
        if (!com.tencent.rdelivery.reshub.core.g.j(req) && eVar != null && jz3.c.b(eVar.G, resConfig.f411265f, resConfig.f411264e)) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull jz3.e resConfig, @Nullable jz3.e eVar, @NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        Intrinsics.checkParameterIsNotNull(req, "req");
        if (com.tencent.rdelivery.reshub.core.g.j(req) && eVar != null && jz3.b.e(resConfig.f411271l, resConfig.f411270k, eVar.G, false, 8, null) && Intrinsics.areEqual(resConfig.f411264e, eVar.f411264e)) {
            return true;
        }
        return false;
    }

    public static final int c(@NotNull jz3.e resConfig, @NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        Intrinsics.checkParameterIsNotNull(req, "req");
        String str = resConfig.f411260a;
        Intrinsics.checkExpressionValueIsNotNull(str, "resConfig.id");
        return com.tencent.rdelivery.reshub.core.g.g(str, req.getAppInfo());
    }
}
