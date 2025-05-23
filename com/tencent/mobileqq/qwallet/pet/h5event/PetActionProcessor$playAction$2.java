package com.tencent.mobileqq.qwallet.pet.h5event;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor$playAction$2", f = "PetActionProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class PetActionProcessor$playAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PetActionProcessor.ActionCallback $actionCallback;
    final /* synthetic */ String $actionType;
    final /* synthetic */ long $timeoutMS;
    int label;
    final /* synthetic */ PetActionProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PetActionProcessor$playAction$2(String str, long j3, PetActionProcessor.ActionCallback actionCallback, PetActionProcessor petActionProcessor, Continuation<? super PetActionProcessor$playAction$2> continuation) {
        super(2, continuation);
        this.$actionType = str;
        this.$timeoutMS = j3;
        this.$actionCallback = actionCallback;
        this.this$0 = petActionProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PetActionProcessor.ActionCallback actionCallback, PetActionProcessor petActionProcessor) {
        QWalletPetH5Controller qWalletPetH5Controller;
        actionCallback.f(true);
        if (!actionCallback.getIsPlaying()) {
            qWalletPetH5Controller = petActionProcessor.h5Controller;
            qWalletPetH5Controller.b(actionCallback.getCallback(), -1, "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            PetStateManager.f278740a.o();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PetActionProcessor$playAction$2(this.$actionType, this.$timeoutMS, this.$actionCallback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!PetStateManager.f278740a.g(this.$actionType)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final PetActionProcessor.ActionCallback actionCallback = this.$actionCallback;
                final PetActionProcessor petActionProcessor = this.this$0;
                uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pet.h5event.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        PetActionProcessor$playAction$2.b(PetActionProcessor.ActionCallback.this, petActionProcessor);
                    }
                }, this.$timeoutMS);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PetActionProcessor$playAction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
