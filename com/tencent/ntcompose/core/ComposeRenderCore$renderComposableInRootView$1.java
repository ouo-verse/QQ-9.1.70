package com.tencent.ntcompose.core;

import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.ntcompose.core.ComposeRenderCore$renderComposableInRootView$1", f = "ComposeRenderCore.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ComposeRenderCore$renderComposableInRootView$1 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $reComposer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeRenderCore$renderComposableInRootView$1(Recomposer recomposer, Continuation<? super ComposeRenderCore$renderComposableInRootView$1> continuation) {
        super(2, continuation);
        this.$reComposer = recomposer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposeRenderCore$renderComposableInRootView$1(this.$reComposer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
        return ((ComposeRenderCore$renderComposableInRootView$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Recomposer recomposer = this.$reComposer;
            this.label = 1;
            if (recomposer.runRecomposeAndApplyChanges(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
