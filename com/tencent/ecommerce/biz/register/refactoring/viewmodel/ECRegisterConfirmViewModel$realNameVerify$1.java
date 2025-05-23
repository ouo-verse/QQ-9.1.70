package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo;
import com.tencent.ecommerce.repo.register.ECMsgBox;
import cooperation.qzone.remote.ServiceConst;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterConfirmViewModel$realNameVerify$1", f = "ECRegisterConfirmViewModel.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECRegisterConfirmViewModel$realNameVerify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECRegisterConfirmViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRegisterConfirmViewModel$realNameVerify$1(ECRegisterConfirmViewModel eCRegisterConfirmViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCRegisterConfirmViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECRegisterConfirmViewModel$realNameVerify$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECRegisterConfirmViewModel$realNameVerify$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            String psKey = this.this$0.getPsKey();
            String userName = this.this$0.getUserName();
            String userID = this.this$0.getUserID();
            String userPhone = this.this$0.getUserPhone();
            String smsCode = this.this$0.getSmsCode();
            this.label = 1;
            obj = eCommerceRegisterRepo.d(psKey, userName, userID, userPhone, smsCode, this);
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
            mutableLiveData = this.this$0._realNameVerifyStatus;
            mutableLiveData.setValue(Boxing.boxInt(-1));
            cg0.a.a("ECRegisterConfirmViewModel", "realNameVerify", "[realNameVerify] error = " + eCNetworkResponse.getMessage());
        } else {
            JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("msg_box");
                if (optJSONObject != null) {
                    ECMsgBox a16 = ECMsgBox.INSTANCE.a(optJSONObject);
                    if (a16.disPlay) {
                        mutableLiveData3 = this.this$0._registerRespMsgBox;
                        mutableLiveData3.setValue(a16);
                        return Unit.INSTANCE;
                    }
                }
                this.this$0.u2(jSONObject.optString(ServiceConst.PARA_SESSION_ID, ""));
                mutableLiveData2 = this.this$0._realNameVerifyStatus;
                mutableLiveData2.setValue(Boxing.boxInt(jSONObject.optInt("status", -1)));
            }
        }
        return Unit.INSTANCE;
    }
}
