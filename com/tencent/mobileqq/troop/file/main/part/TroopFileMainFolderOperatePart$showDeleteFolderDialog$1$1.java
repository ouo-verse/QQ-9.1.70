package com.tencent.mobileqq.troop.file.main.part;

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
@DebugMetadata(c = "com.tencent.mobileqq.troop.file.main.part.TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1", f = "TroopFileMainFolderOperatePart.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.troop.data.n $fileInfo;
    int label;
    final /* synthetic */ TroopFileMainFolderOperatePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1(TroopFileMainFolderOperatePart troopFileMainFolderOperatePart, com.tencent.mobileqq.troop.data.n nVar, Continuation<? super TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1> continuation) {
        super(2, continuation);
        this.this$0 = troopFileMainFolderOperatePart;
        this.$fileInfo = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1(this.this$0, this.$fileInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            TroopFileMainVM viewModel = this.this$0.getViewModel();
            b.C8685b c8685b = new b.C8685b(this.$fileInfo);
            this.label = 1;
            if (viewModel.sendUserIntent(c8685b, this) == coroutine_suspended) {
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
        return ((TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
