package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.WnsNetworkConst;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$requestSingleFeed$1", f = "SuitCreateTechFragmentViewModel.kt", i = {}, l = {WnsNetworkConst.NETWORK_DISABLE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel$requestSingleFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuitCreateTechFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateTechFragmentViewModel$requestSingleFeed$1(SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, Continuation<? super SuitCreateTechFragmentViewModel$requestSingleFeed$1> continuation) {
        super(2, continuation);
        this.this$0 = suitCreateTechFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateTechFragmentViewModel$requestSingleFeed$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        AIGCFeedItemInfo2 V2;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                long whiteModelUgcId = this.this$0.getWhiteModelUgcId();
                this.label = 1;
                obj = zPlanAIGCRequest.o(whiteModelUgcId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.this$0;
            iu4.b bVar = (iu4.b) obj;
            V2 = suitCreateTechFragmentViewModel.V2(bVar);
            QLog.i("SuitCreateTechFragmentViewModel", 1, "refreshSingleFeed true");
            suitCreateTechFragmentViewModel.o3(bVar.f408764c);
            mutableLiveData2 = suitCreateTechFragmentViewModel._fetchFeedSuccessEvent;
            mutableLiveData2.postValue(V2);
        } catch (Throwable th5) {
            mutableLiveData = this.this$0._fetchFeedSuccessEvent;
            mutableLiveData.postValue(null);
            QLog.e("SuitCreateTechFragmentViewModel", 1, "refreshSingleFeed failed.", th5);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateTechFragmentViewModel$requestSingleFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
