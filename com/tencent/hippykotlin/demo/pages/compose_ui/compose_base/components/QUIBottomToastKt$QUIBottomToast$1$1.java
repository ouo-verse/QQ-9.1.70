package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$1$1", f = "QUIBottomToast.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class QUIBottomToastKt$QUIBottomToast$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<Boolean> $didEntered;
    public final /* synthetic */ boolean $showToast;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIBottomToastKt$QUIBottomToast$1$1(MutableState<Boolean> mutableState, boolean z16, Continuation<? super QUIBottomToastKt$QUIBottomToast$1$1> continuation) {
        super(2, continuation);
        this.$didEntered = mutableState;
        this.$showToast = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QUIBottomToastKt$QUIBottomToast$1$1(this.$didEntered, this.$showToast, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QUIBottomToastKt$QUIBottomToast$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.$didEntered.setValue(Boxing.boxBoolean(this.$showToast));
        return Unit.INSTANCE;
    }
}
