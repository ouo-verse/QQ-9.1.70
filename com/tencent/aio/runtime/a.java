package com.tencent.aio.runtime;

import com.tencent.mvi.base.route.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a1\u0010\n\u001a\u00020\b*\u0004\u0018\u00010\u00012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/runtime/AIOContextImpl;", "a", "Lkotlin/Function1;", "Lcom/tencent/mvi/base/route/j;", "Lkotlin/ParameterName;", "name", "messenger", "", "invoke", "b", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    @NotNull
    public static final AIOContextImpl a(@NotNull com.tencent.aio.api.runtime.a coreGet) {
        Intrinsics.checkNotNullParameter(coreGet, "$this$coreGet");
        return (AIOContextImpl) coreGet;
    }

    public static final void b(@Nullable AIOContextImpl aIOContextImpl, @NotNull Function1<? super j, Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        if (aIOContextImpl == null || !aIOContextImpl.s()) {
            return;
        }
        invoke.invoke(aIOContextImpl.e());
    }
}
