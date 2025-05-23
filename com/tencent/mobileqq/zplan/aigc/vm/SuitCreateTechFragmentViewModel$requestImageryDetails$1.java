package com.tencent.mobileqq.zplan.aigc.vm;

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
import u45.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$requestImageryDetails$1", f = "SuitCreateTechFragmentViewModel.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel$requestImageryDetails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needRefreshUI;
    final /* synthetic */ int $requestIndex;
    int label;
    final /* synthetic */ SuitCreateTechFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateTechFragmentViewModel$requestImageryDetails$1(SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, int i3, boolean z16, Continuation<? super SuitCreateTechFragmentViewModel$requestImageryDetails$1> continuation) {
        super(2, continuation);
        this.this$0 = suitCreateTechFragmentViewModel;
        this.$requestIndex = i3;
        this.$needRefreshUI = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateTechFragmentViewModel$requestImageryDetails$1(this.this$0, this.$requestIndex, this.$needRefreshUI, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String N2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                N2 = this.this$0.N2("GetImageryDetails");
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                this.label = 1;
                obj = zPlanAIGCRequest.k(0, 100, N2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z16 = this.$needRefreshUI;
            SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.this$0;
            int i16 = this.$requestIndex;
            l lVar = (l) obj;
            if (z16) {
                suitCreateTechFragmentViewModel.W2(lVar);
            }
            suitCreateTechFragmentViewModel.k2().set(i16, Boxing.boxBoolean(true));
        } catch (Throwable th5) {
            this.this$0.k2().set(this.$requestIndex, Boxing.boxBoolean(false));
            QLog.e("SuitCreateTechFragmentViewModel", 1, "requestImageryDetails: " + th5.getMessage());
        }
        this.this$0.j2().set(this.$requestIndex, Boxing.boxBoolean(true));
        if (this.$needRefreshUI) {
            this.this$0.c2();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateTechFragmentViewModel$requestImageryDetails$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
