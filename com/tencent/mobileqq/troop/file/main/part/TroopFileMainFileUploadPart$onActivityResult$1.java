package com.tencent.mobileqq.troop.file.main.part;

import android.content.Intent;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.file.main.part.TroopFileMainFileUploadPart$onActivityResult$1", f = "TroopFileMainFileUploadPart.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class TroopFileMainFileUploadPart$onActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $data;
    int label;
    final /* synthetic */ TroopFileMainFileUploadPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileMainFileUploadPart$onActivityResult$1(TroopFileMainFileUploadPart troopFileMainFileUploadPart, Intent intent, Continuation<? super TroopFileMainFileUploadPart$onActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = troopFileMainFileUploadPart;
        this.$data = intent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopFileMainFileUploadPart$onActivityResult$1(this.this$0, this.$data, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            TroopFileMainVM viewModel = this.this$0.getViewModel();
            b.c cVar = new b.c(this.$data);
            this.label = 1;
            if (viewModel.sendUserIntent(cVar, this) == coroutine_suspended) {
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
        return ((TroopFileMainFileUploadPart$onActivityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
