package com.tencent.aio.base.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0000*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/aio/base/log/e;", "a", "b", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    @NotNull
    public static final e a(@NotNull e wrapDebug) {
        Intrinsics.checkNotNullParameter(wrapDebug, "$this$wrapDebug");
        if (com.tencent.aio.base.a.f69150c.a()) {
            return wrapDebug;
        }
        return d.f69188a;
    }

    @NotNull
    public static final e b(@NotNull e wrapDevelop) {
        Intrinsics.checkNotNullParameter(wrapDevelop, "$this$wrapDevelop");
        if (com.tencent.aio.base.a.f69150c.b()) {
            return wrapDevelop;
        }
        return d.f69188a;
    }
}
