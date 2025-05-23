package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\u008a@"}, d2 = {"Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopBaseViewModel$setEffect$1", f = "MiniAppDesktopBaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopBaseViewModel$setEffect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MiniAppDesktopEffect $newEffect;
    int label;
    final /* synthetic */ MiniAppDesktopBaseViewModel<S, I> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopBaseViewModel$setEffect$1(MiniAppDesktopBaseViewModel<S, I> miniAppDesktopBaseViewModel, MiniAppDesktopEffect miniAppDesktopEffect, Continuation<? super MiniAppDesktopBaseViewModel$setEffect$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopBaseViewModel;
        this.$newEffect = miniAppDesktopEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopBaseViewModel$setEffect$1(this.this$0, this.$newEffect, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableSharedFlow = ((MiniAppDesktopBaseViewModel) this.this$0)._effect;
            mutableSharedFlow.tryEmit(this.$newEffect);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppDesktopBaseViewModel$setEffect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
