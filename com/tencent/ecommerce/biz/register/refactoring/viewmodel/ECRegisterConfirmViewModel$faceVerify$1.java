package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.register.ECInnerFaceVerification;
import com.tencent.ecommerce.biz.register.network.ECVerifyFaceResp;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterConfirmViewModel$faceVerify$1", f = "ECRegisterConfirmViewModel.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECRegisterConfirmViewModel$faceVerify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ECRegisterConfirmViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRegisterConfirmViewModel$faceVerify$1(ECRegisterConfirmViewModel eCRegisterConfirmViewModel, Context context, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCRegisterConfirmViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECRegisterConfirmViewModel$faceVerify$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECRegisterConfirmViewModel$faceVerify$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECInnerFaceVerification eCInnerFaceVerification = ECInnerFaceVerification.f103955a;
            Context context = this.$context;
            String userName = this.this$0.getUserName();
            String userID = this.this$0.getUserID();
            String psKey = this.this$0.getPsKey();
            String realNameVerifySessionId = this.this$0.getRealNameVerifySessionId();
            this.label = 1;
            obj = eCInnerFaceVerification.a(context, psKey, userName, userID, realNameVerifySessionId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECVerifyFaceResp eCVerifyFaceResp = (ECVerifyFaceResp) obj;
        com.tencent.ecommerce.biz.register.a.f103962b.b(eCVerifyFaceResp.verifyRspCode);
        this.this$0.w2(eCVerifyFaceResp.sessionId);
        mutableLiveData = this.this$0._faceVerifyStatus;
        mutableLiveData.setValue(Boxing.boxInt(eCVerifyFaceResp.verifyRspCode));
        return Unit.INSTANCE;
    }
}
