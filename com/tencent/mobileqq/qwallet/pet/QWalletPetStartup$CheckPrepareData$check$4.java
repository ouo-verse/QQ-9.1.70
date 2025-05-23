package com.tencent.mobileqq.qwallet.pet;

import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageRsp;
import com.tencent.mobileqq.qwallet.pet.QWalletPetStartup;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$CheckPrepareData$check$4", f = "QWalletPetStartup.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class QWalletPetStartup$CheckPrepareData$check$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PetUserState$HomepageRsp $userStateRsp;
    int label;
    final /* synthetic */ QWalletPetStartup.CheckPrepareData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletPetStartup$CheckPrepareData$check$4(QWalletPetStartup.CheckPrepareData checkPrepareData, PetUserState$HomepageRsp petUserState$HomepageRsp, Continuation<? super QWalletPetStartup$CheckPrepareData$check$4> continuation) {
        super(2, continuation);
        this.this$0 = checkPrepareData;
        this.$userStateRsp = petUserState$HomepageRsp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletPetStartup$CheckPrepareData$check$4(this.this$0, this.$userStateRsp, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        QWalletPetStartup.FailResultData failResultData;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getPreloadStrategy().i(this.$userStateRsp);
            boolean D = PetStateManager.f278740a.D(this.$userStateRsp);
            Function3<QWalletPetStartup.EnumTask, Boolean, QWalletPetStartup.FailResultData, Unit> a16 = this.this$0.a();
            QWalletPetStartup.EnumTask checkerStep = this.this$0.getCheckerStep();
            Boolean boxBoolean = Boxing.boxBoolean(D);
            if (!D) {
                failResultData = QWalletPetStartup.FailResultData.INSTANCE.a(this.this$0.getCheckerStep());
            } else {
                failResultData = null;
            }
            a16.invoke(checkerStep, boxBoolean, failResultData);
            QLog.i("QWallet.Pet.Startup", 1, this.this$0.getCheckerStep() + ": true");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QWalletPetStartup$CheckPrepareData$check$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
