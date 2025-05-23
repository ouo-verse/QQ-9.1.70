package com.tencent.mobileqq.mini.entry.expDesktop.part;

import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$initSubPageView$5", f = "MiniAppExpDesktopSubLayoutPart.kt", i = {}, l = {com.tencent.luggage.wxa.ig.k.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopSubLayoutPart$initSubPageView$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppExpDesktopSubLayoutPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppExpDesktopSubLayoutPart$initSubPageView$5(MiniAppExpDesktopSubLayoutPart miniAppExpDesktopSubLayoutPart, Continuation<? super MiniAppExpDesktopSubLayoutPart$initSubPageView$5> continuation) {
        super(2, continuation);
        this.this$0 = miniAppExpDesktopSubLayoutPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppExpDesktopSubLayoutPart$initSubPageView$5(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<MiniAppExpDesktopEffect> effect = this.this$0.getMMiniAppDesktopViewModel().getEffect();
            MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 = new MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1(this.this$0);
            this.label = 1;
            if (effect.collect(miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppExpDesktopSubLayoutPart$initSubPageView$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
