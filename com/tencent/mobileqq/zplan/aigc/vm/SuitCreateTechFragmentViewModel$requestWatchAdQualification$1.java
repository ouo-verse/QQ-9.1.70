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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$requestWatchAdQualification$1", f = "SuitCreateTechFragmentViewModel.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel$requestWatchAdQualification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Integer> $callback;
    final /* synthetic */ int $sceneId;
    int label;
    final /* synthetic */ SuitCreateTechFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateTechFragmentViewModel$requestWatchAdQualification$1(int i3, com.tencent.mobileqq.zootopia.api.e<Integer> eVar, SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, Continuation<? super SuitCreateTechFragmentViewModel$requestWatchAdQualification$1> continuation) {
        super(2, continuation);
        this.$sceneId = i3;
        this.$callback = eVar;
        this.this$0 = suitCreateTechFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateTechFragmentViewModel$requestWatchAdQualification$1(this.$sceneId, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                int i16 = this.$sceneId;
                this.label = 1;
                obj = zPlanAIGCRequest.e(i16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.this$0;
            com.tencent.mobileqq.zootopia.api.e<Integer> eVar = this.$callback;
            int intValue = ((Number) obj).intValue();
            QLog.i("SuitCreateTechFragmentViewModel", 1, "requestWatchAdQualification done, playQualification: " + intValue);
            mutableLiveData = suitCreateTechFragmentViewModel._playAdQualificationLiveData;
            mutableLiveData.postValue(Boxing.boxInt(intValue));
            eVar.onResultSuccess(Boxing.boxInt(intValue));
        } catch (Throwable th5) {
            QLog.e("SuitCreateTechFragmentViewModel", 1, "requestWatchAdQualification failed.", th5);
            e.a.a(this.$callback, -1, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateTechFragmentViewModel$requestWatchAdQualification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
