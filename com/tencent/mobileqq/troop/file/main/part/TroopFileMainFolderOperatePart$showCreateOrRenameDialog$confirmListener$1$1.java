package com.tencent.mobileqq.troop.file.main.part;

import com.tencent.mobileqq.R;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.file.main.part.TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1", f = "TroopFileMainFolderOperatePart.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $folderId;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ TroopFileMainFolderOperatePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1(int i3, TroopFileMainFolderOperatePart troopFileMainFolderOperatePart, String str, Continuation<? super TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1> continuation) {
        super(2, continuation);
        this.$type = i3;
        this.this$0 = troopFileMainFolderOperatePart;
        this.$folderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1(this.$type, this.this$0, this.$folderId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.troop.file.main.vm.b aVar;
        String str;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int i16 = this.$type;
            if (i16 == 0) {
                str = this.this$0.tempInputFolderName;
                aVar = new b.a(str);
            } else {
                if (i16 != 1) {
                    return Unit.INSTANCE;
                }
                String str3 = this.$folderId;
                if (str3 != null) {
                    str2 = this.this$0.tempInputFolderName;
                    aVar = new b.h(str3, str2);
                } else {
                    aVar = null;
                }
            }
            if (aVar != null) {
                TroopFileMainVM viewModel = this.this$0.getViewModel();
                this.label = 1;
                if (viewModel.sendUserIntent(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.ca(R.string.etq);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
