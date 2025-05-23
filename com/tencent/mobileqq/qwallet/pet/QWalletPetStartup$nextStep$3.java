package com.tencent.mobileqq.qwallet.pet;

import com.tencent.mobileqq.qwallet.pet.QWalletPetStartup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$nextStep$3", f = "QWalletPetStartup.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class QWalletPetStartup$nextStep$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QWalletPetStartup.EnumTask $currentStep;
    int label;
    final /* synthetic */ QWalletPetStartup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletPetStartup$nextStep$3(QWalletPetStartup qWalletPetStartup, QWalletPetStartup.EnumTask enumTask, Continuation<? super QWalletPetStartup$nextStep$3> continuation) {
        super(2, continuation);
        this.this$0 = qWalletPetStartup;
        this.$currentStep = enumTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletPetStartup$nextStep$3(this.this$0, this.$currentStep, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        QWalletPetStartup.d dVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            dVar = this.this$0.callback;
            if (dVar != null) {
                QWalletPetStartup.EnumTask enumTask = this.$currentStep;
                this.label = 1;
                if (dVar.a(enumTask, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return null;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QWalletPetStartup$nextStep$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
