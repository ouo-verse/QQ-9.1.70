package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$1", f = "QUIDragBackView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class QUIDragBackViewKt$QUIDragBackView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QUIDragBackViewKt$QUIDragBackView$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new QUIDragBackViewKt$QUIDragBackView$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        TimerKt.c(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIDragBackViewKt$QUIDragBackView$1.1
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                QQKuiklyPlatformApi.Companion.setEdgePopWidth(0.0f);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QUIDragBackViewKt$QUIDragBackView$1(Continuation<? super QUIDragBackViewKt$QUIDragBackView$1> continuation) {
        super(2, continuation);
    }
}
