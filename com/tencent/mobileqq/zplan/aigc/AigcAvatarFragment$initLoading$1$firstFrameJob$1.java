package com.tencent.mobileqq.zplan.aigc;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$initLoading$1$firstFrameJob$1", f = "AigcAvatarFragment.kt", i = {}, l = {1006}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class AigcAvatarFragment$initLoading$1$firstFrameJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AigcAvatarFragment$initLoading$listener$1 $listener;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcAvatarFragment$initLoading$1$firstFrameJob$1(AigcAvatarFragment$initLoading$listener$1 aigcAvatarFragment$initLoading$listener$1, Continuation<? super AigcAvatarFragment$initLoading$1$firstFrameJob$1> continuation) {
        super(2, continuation);
        this.$listener = aigcAvatarFragment$initLoading$listener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AigcAvatarFragment$initLoading$1$firstFrameJob$1(this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AigcAvatarFragment$initLoading$listener$1 aigcAvatarFragment$initLoading$listener$1 = this.$listener;
            this.L$0 = aigcAvatarFragment$initLoading$listener$1;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            synchronized (aigcAvatarFragment$initLoading$listener$1) {
                if (!aigcAvatarFragment$initLoading$listener$1.getDone()) {
                    aigcAvatarFragment$initLoading$listener$1.b(cancellableContinuationImpl);
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
                Unit unit = Unit.INSTANCE;
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
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
        return ((AigcAvatarFragment$initLoading$1$firstFrameJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
