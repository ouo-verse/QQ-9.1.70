package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterConfirmViewModel$registerBySessionId$1", f = "ECRegisterConfirmViewModel.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECRegisterConfirmViewModel$registerBySessionId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $smsCode;
    int label;
    final /* synthetic */ ECRegisterConfirmViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRegisterConfirmViewModel$registerBySessionId$1(ECRegisterConfirmViewModel eCRegisterConfirmViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCRegisterConfirmViewModel;
        this.$smsCode = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECRegisterConfirmViewModel$registerBySessionId$1(this.this$0, this.$smsCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECRegisterConfirmViewModel$registerBySessionId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECommerceRegisterRepo eCommerceRegisterRepo = ECommerceRegisterRepo.f104099a;
            String registerRespSessionId = this.this$0.getRegisterRespSessionId();
            String str = this.$smsCode;
            this.label = 1;
            obj = eCommerceRegisterRepo.f(registerRespSessionId, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        if (eCNetworkResponse.getCode() != 0) {
            mutableLiveData = this.this$0._registerBySessionStatus;
            mutableLiveData.setValue(Boxing.boxInt(-1));
            cg0.a.a("ECRegisterConfirmViewModel", "registerBySessionId", "[registerBySessionId] error = " + eCNetworkResponse.getMessage());
        } else {
            JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
            if (jSONObject != null) {
                mutableLiveData2 = this.this$0._registerBySessionStatus;
                mutableLiveData2.setValue(Boxing.boxInt(jSONObject.optInt("status", -1)));
                mutableLiveData3 = this.this$0._registerBySessionRespMediaId;
                mutableLiveData3.setValue(jSONObject.optString("media_id", ""));
            }
        }
        return Unit.INSTANCE;
    }
}
