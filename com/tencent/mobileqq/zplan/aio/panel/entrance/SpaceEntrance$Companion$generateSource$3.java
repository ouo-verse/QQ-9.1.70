package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import le3.ApiPanelEventHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$3", f = "SpaceEntrance.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SpaceEntrance$Companion$generateSource$3 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ ApiPanelEventHandler $handler;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceEntrance$Companion$generateSource$3(ApiPanelEventHandler apiPanelEventHandler, Continuation<? super SpaceEntrance$Companion$generateSource$3> continuation) {
        super(3, continuation);
        this.$handler = apiPanelEventHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$handler.c().invoke();
            Unit unit = Unit.INSTANCE;
            TuplesKt.to(CompletableDeferredKt.CompletableDeferred(unit), null);
            return unit;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, View view, Continuation<? super Unit> continuation) {
        return new SpaceEntrance$Companion$generateSource$3(this.$handler, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
