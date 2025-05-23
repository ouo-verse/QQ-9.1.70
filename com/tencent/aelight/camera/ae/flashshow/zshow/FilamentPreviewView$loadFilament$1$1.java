package com.tencent.aelight.camera.ae.flashshow.zshow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView$loadFilament$1$1", f = "FilamentPreviewView.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class FilamentPreviewView$loadFilament$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $downloadSucc;
    Object L$0;
    int label;
    final /* synthetic */ FilamentPreviewView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentPreviewView$loadFilament$1$1(Ref.BooleanRef booleanRef, FilamentPreviewView filamentPreviewView, Continuation<? super FilamentPreviewView$loadFilament$1$1> continuation) {
        super(2, continuation);
        this.$downloadSucc = booleanRef;
        this.this$0 = filamentPreviewView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilamentPreviewView$loadFilament$1$1(this.$downloadSucc, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object x16;
        Ref.BooleanRef booleanRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$downloadSucc;
            FilamentPreviewView filamentPreviewView = this.this$0;
            this.L$0 = booleanRef2;
            this.label = 1;
            x16 = filamentPreviewView.x(this);
            if (x16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = x16;
        } else if (i3 == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        booleanRef.element = ((Boolean) obj).booleanValue();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentPreviewView$loadFilament$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
