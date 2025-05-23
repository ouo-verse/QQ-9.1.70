package com.tencent.mobileqq.zplan.aigc.vm;

import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.aigc.data.AIGCTemplateInfo;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$requestWhiteModelList$1", f = "SuitCreateTechFragmentViewModel.kt", i = {0}, l = {446}, m = "invokeSuspend", n = {"gender"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel$requestWhiteModelList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needRefreshUI;
    final /* synthetic */ int $requestIndex;
    Object L$0;
    int label;
    final /* synthetic */ SuitCreateTechFragmentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateTechFragmentViewModel$requestWhiteModelList$1(int i3, SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, boolean z16, Continuation<? super SuitCreateTechFragmentViewModel$requestWhiteModelList$1> continuation) {
        super(2, continuation);
        this.$requestIndex = i3;
        this.this$0 = suitCreateTechFragmentViewModel;
        this.$needRefreshUI = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateTechFragmentViewModel$requestWhiteModelList$1(this.$requestIndex, this.this$0, this.$needRefreshUI, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String N2;
        Ref.IntRef intRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.IntRef intRef2 = new Ref.IntRef();
                if (this.$requestIndex == 0) {
                    intRef2.element = UEAvatarGender.FEMALE.getIndex();
                } else {
                    intRef2.element = UEAvatarGender.MALE.getIndex();
                }
                N2 = this.this$0.N2("GetUGCTemplateInfo" + intRef2.element);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                int i16 = intRef2.element;
                this.L$0 = intRef2;
                this.label = 1;
                Object q16 = zPlanAIGCRequest.q(i16, true, N2, this);
                if (q16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                intRef = intRef2;
                obj = q16;
            } else if (i3 == 1) {
                intRef = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z16 = this.$needRefreshUI;
            SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.this$0;
            int i17 = this.$requestIndex;
            AIGCTemplateInfo aIGCTemplateInfo = (AIGCTemplateInfo) obj;
            if (z16) {
                suitCreateTechFragmentViewModel.Y2(aIGCTemplateInfo, intRef.element);
            }
            suitCreateTechFragmentViewModel.k2().set(i17, Boxing.boxBoolean(true));
        } catch (Throwable th5) {
            QLog.e("SuitCreateTechFragmentViewModel", 1, "requestWhiteModelList: " + th5.getMessage());
            this.this$0.k2().set(this.$requestIndex, Boxing.boxBoolean(false));
        }
        this.this$0.j2().set(this.$requestIndex, Boxing.boxBoolean(true));
        if (this.$needRefreshUI) {
            this.this$0.c2();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateTechFragmentViewModel$requestWhiteModelList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
