package com.tencent.ecommerce.biz.register.officialAccountFollowedChecker;

import androidx.lifecycle.MutableLiveData;
import cg0.a;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.officialAccountFollowedChecker.ECAccountFollowedCheckerViewModel$followAccount$1", f = "ECAccountFollowedCheckerViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAccountFollowedCheckerViewModel$followAccount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $accountFollowScene;
    final /* synthetic */ int $accountType;
    int label;
    final /* synthetic */ ECAccountFollowedCheckerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAccountFollowedCheckerViewModel$followAccount$1(ECAccountFollowedCheckerViewModel eCAccountFollowedCheckerViewModel, int i3, int i16, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAccountFollowedCheckerViewModel;
        this.$accountType = i3;
        this.$accountFollowScene = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAccountFollowedCheckerViewModel$followAccount$1(this.this$0, this.$accountType, this.$accountFollowScene, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAccountFollowedCheckerViewModel$followAccount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECAccountFollowedRepository repo = this.this$0.getRepo();
            int i16 = this.$accountType;
            int i17 = this.$accountFollowScene;
            this.label = 1;
            obj = repo.a(i16, i17, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        if (eCNetworkResponse.getCode() == 0) {
            JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
            if (jSONObject != null) {
                mutableLiveData = this.this$0._followAccountRespStatus;
                mutableLiveData.setValue(Boxing.boxInt(jSONObject.optInt("status", -1)));
                mutableLiveData2 = this.this$0._followAccountRespStatus;
                Integer num = (Integer) mutableLiveData2.getValue();
                if (num != null && num.intValue() == 0) {
                    mutableLiveData4 = this.this$0._shouldShowGuideView;
                    mutableLiveData4.setValue(Boxing.boxBoolean(false));
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("followAccount success with resp status = ");
                mutableLiveData3 = this.this$0._followAccountRespStatus;
                sb5.append((Integer) mutableLiveData3.getValue());
                a.b("ECAccountFollowedCheckerViewModel", sb5.toString());
            } else {
                a.a("ECAccountFollowedCheckerViewModel", VasLiveIPCModule.ACTION_FOLLOW_ACCOUNT, "[followAccount] success with respData = null");
                return Unit.INSTANCE;
            }
        } else {
            a.a("ECAccountFollowedCheckerViewModel", VasLiveIPCModule.ACTION_FOLLOW_ACCOUNT, "[followAccount] error with " + eCNetworkResponse.getMessage());
        }
        return Unit.INSTANCE;
    }
}
