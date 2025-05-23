package com.tencent.mobileqq.qwallet.pet.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.data.PetStateManager$playAction$1", f = "PetStateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class PetStateManager$playAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $action;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PetStateManager$playAction$1(d dVar, Continuation<? super PetStateManager$playAction$1> continuation) {
        super(2, continuation);
        this.$action = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PetStateManager$playAction$1 petStateManager$playAction$1 = new PetStateManager$playAction$1(this.$action, continuation);
        petStateManager$playAction$1.L$0 = obj;
        return petStateManager$playAction$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.mobileqq.qwallet.pet.filament.a aVar;
        MutableLiveData mutableLiveData;
        d dVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            aVar = PetStateManager.playerInstance;
            Unit unit = null;
            if (aVar != null) {
                d dVar2 = this.$action;
                mutableLiveData = PetStateManager._isShowLoading;
                mutableLiveData.setValue(Boxing.boxBoolean(false));
                PetStateManager.currentAction = dVar2;
                PetStateManager.pendingAction = null;
                dVar = PetStateManager.currentAction;
                if (dVar != null) {
                    aVar.a(dVar);
                    unit = Unit.INSTANCE;
                }
            }
            if (unit == null) {
                QLog.w("QWallet.Pet.PetState", 1, "playerInstance is null, ignored playAction " + this.$action.getInfoBase().getActionType());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PetStateManager$playAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
