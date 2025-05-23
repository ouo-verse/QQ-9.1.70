package com.tencent.mobileqq.troop.file.main.part;

import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.troop.file.data.TroopFileShowAdapter;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.file.main.vm.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart$initData$1", f = "TroopFileMainContentPart.kt", i = {}, l = {com.tencent.luggage.wxa.j2.b.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class TroopFileMainContentPart$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TroopFileMainContentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileMainContentPart$initData$1(TroopFileMainContentPart troopFileMainContentPart, Continuation<? super TroopFileMainContentPart$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = troopFileMainContentPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopFileMainContentPart$initData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            TroopFileMainVM viewModel = this.this$0.getViewModel();
            TroopFileShowAdapter troopFileShowAdapter = this.this$0.fileShowAdapter;
            if (troopFileShowAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileShowAdapter");
                troopFileShowAdapter = null;
            }
            Lifecycle lifecycle = this.this$0.getPartHost().getLifecycleOwner().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "partHost.hostLifecycleOwner.lifecycle");
            b.g gVar = new b.g(troopFileShowAdapter, lifecycle);
            this.label = 1;
            if (viewModel.sendUserIntent(gVar, this) == coroutine_suspended) {
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
        return ((TroopFileMainContentPart$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
