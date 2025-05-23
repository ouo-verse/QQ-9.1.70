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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterConfirmViewModel$register$1", f = "ECRegisterConfirmViewModel.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECRegisterConfirmViewModel$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECRegisterConfirmViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRegisterConfirmViewModel$register$1(ECRegisterConfirmViewModel eCRegisterConfirmViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCRegisterConfirmViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECRegisterConfirmViewModel$register$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECRegisterConfirmViewModel$register$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            String userName = this.this$0.getUserName();
            String userID = this.this$0.getUserID();
            String userPhone = this.this$0.getUserPhone();
            String verifyFaceRespSessionId = this.this$0.getVerifyFaceRespSessionId();
            boolean areEqual = Intrinsics.areEqual(this.this$0.getIsFollowAccount(), "1");
            this.label = 1;
            obj = eCommerceRegisterRepo.e(userName, userID, userPhone, verifyFaceRespSessionId, areEqual, this);
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
            mutableLiveData = this.this$0._registerStatus;
            mutableLiveData.setValue(Boxing.boxInt(-1));
            cg0.a.a("ECRegisterConfirmViewModel", "register", "[register] error = " + eCNetworkResponse.getMessage());
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
                mutableLiveData2 = this.this$0._registerStatus;
                mutableLiveData2.setValue(Boxing.boxInt(jSONObject.optInt("status", -1)));
                this.this$0.v2(jSONObject.optString(ServiceConst.PARA_SESSION_ID, ""));
                this.this$0.s2(jSONObject.optString("origin_phone_number", ""));
                String optString = jSONObject.optString("media_id", "");
                ECommerceRegisterRepo.f104099a.g(optString != null ? optString : "");
                hg0.a.c(hg0.a.f404850b, "ECRegisterSuccessAlertPage", null, 2, null);
            }
        }
        return Unit.INSTANCE;
    }
}
