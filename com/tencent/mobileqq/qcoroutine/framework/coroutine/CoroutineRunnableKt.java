package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aD\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002\u00a2\u0006\u0002\b\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001aL\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002\u00a2\u0006\u0002\b\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/a;", "runnable", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "_block", "b", "(Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/a;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "a", "QCoroutine_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class CoroutineRunnableKt {
    @Nullable
    public static final <T> Object a(@NotNull a aVar, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new CoroutineRunnableKt$asyncBlock$2(aVar, function2, null), continuation);
    }

    @Nullable
    public static final Object b(@NotNull a aVar, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new CoroutineRunnableKt$launchBlock$2(aVar, function2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
