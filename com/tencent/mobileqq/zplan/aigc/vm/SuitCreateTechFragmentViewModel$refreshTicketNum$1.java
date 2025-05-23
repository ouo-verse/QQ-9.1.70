package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$refreshTicketNum$1", f = "SuitCreateTechFragmentViewModel.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel$refreshTicketNum$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<String> $callback;
    int label;
    final /* synthetic */ SuitCreateTechFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateTechFragmentViewModel$refreshTicketNum$1(com.tencent.mobileqq.zootopia.api.e<String> eVar, SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, Continuation<? super SuitCreateTechFragmentViewModel$refreshTicketNum$1> continuation) {
        super(2, continuation);
        this.$callback = eVar;
        this.this$0 = suitCreateTechFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateTechFragmentViewModel$refreshTicketNum$1(this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                this.label = 1;
                obj = zPlanAIGCRequest.n(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.this$0;
            com.tencent.mobileqq.zootopia.api.e<String> eVar = this.$callback;
            long longValue = ((Number) obj).longValue();
            QLog.i("SuitCreateTechFragmentViewModel", 1, "refreshTicketNum done, couponCount: " + longValue);
            mutableLiveData = suitCreateTechFragmentViewModel._ticketNumLiveData;
            mutableLiveData.postValue(Boxing.boxLong(longValue));
            mutableLiveData2 = suitCreateTechFragmentViewModel._ticketVisibleLiveData;
            mutableLiveData2.postValue(Boxing.boxBoolean(true));
            if (eVar != null) {
                eVar.onResultSuccess("");
            }
        } catch (Throwable th5) {
            QLog.e("SuitCreateTechFragmentViewModel", 1, "refreshTicketNum failed.", th5);
            com.tencent.mobileqq.zootopia.api.e<String> eVar2 = this.$callback;
            if (eVar2 != null) {
                e.a.a(eVar2, -1, null, 2, null);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateTechFragmentViewModel$refreshTicketNum$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
