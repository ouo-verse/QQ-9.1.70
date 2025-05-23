package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECRegisterAgreementRepo;
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
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterAgreementViewModel$getAgreementInfo$1", f = "ECRegisterAgreementViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECRegisterAgreementViewModel$getAgreementInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ECRegisterAgreementViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRegisterAgreementViewModel$getAgreementInfo$1(ECRegisterAgreementViewModel eCRegisterAgreementViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCRegisterAgreementViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECRegisterAgreementViewModel$getAgreementInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECRegisterAgreementViewModel$getAgreementInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._agreementInfo;
            ECRegisterAgreementRepo eCRegisterAgreementRepo = ECRegisterAgreementRepo.f104098a;
            this.L$0 = mutableLiveData;
            this.label = 1;
            Object b16 = eCRegisterAgreementRepo.b(this);
            if (b16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData2 = mutableLiveData;
            obj = b16;
        } else if (i3 == 1) {
            mutableLiveData2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData2.setValue(obj);
        return Unit.INSTANCE;
    }
}
