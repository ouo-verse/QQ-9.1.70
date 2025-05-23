package com.tencent.ecommerce.base.list;

import com.tencent.ecommerce.base.list.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/base/list/b;", "BEAN", "", "Lkotlin/Function1;", "", "predicate", "", "c", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bean", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/base/list/e;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_operatorEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "b", "Lkotlinx/coroutines/flow/SharedFlow;", "()Lkotlinx/coroutines/flow/SharedFlow;", "operatorEvent", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b<BEAN> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableSharedFlow<e<BEAN>> _operatorEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SharedFlow<e<BEAN>> operatorEvent;

    public b() {
        MutableSharedFlow<e<BEAN>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._operatorEvent = MutableSharedFlow$default;
        this.operatorEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    public final Object a(BEAN bean, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object emit = this._operatorEvent.emit(new e.a(bean), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return emit == coroutine_suspended ? emit : Unit.INSTANCE;
    }

    public final SharedFlow<e<BEAN>> b() {
        return this.operatorEvent;
    }

    public final Object c(Function1<? super BEAN, Boolean> function1, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object emit = this._operatorEvent.emit(new e.b(function1), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return emit == coroutine_suspended ? emit : Unit.INSTANCE;
    }

    public final Object d(BEAN bean, Function1<? super BEAN, Boolean> function1, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object emit = this._operatorEvent.emit(new e.c(bean, function1), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return emit == coroutine_suspended ? emit : Unit.INSTANCE;
    }
}
