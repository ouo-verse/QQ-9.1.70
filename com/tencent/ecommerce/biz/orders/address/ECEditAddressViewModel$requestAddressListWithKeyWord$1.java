package com.tencent.ecommerce.biz.orders.address;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/lbssearch/object/result/SuggestionResultObject;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECEditAddressViewModel$requestAddressListWithKeyWord$1", f = "ECEditAddressViewModel.kt", i = {0}, l = {37, 49}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes31.dex */
final class ECEditAddressViewModel$requestAddressListWithKeyWord$1 extends SuspendLambda implements Function2<FlowCollector<? super SuggestionResultObject>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $region;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECEditAddressViewModel$requestAddressListWithKeyWord$1(Context context, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$keyword = str;
        this.$region = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECEditAddressViewModel$requestAddressListWithKeyWord$1 eCEditAddressViewModel$requestAddressListWithKeyWord$1 = new ECEditAddressViewModel$requestAddressListWithKeyWord$1(this.$context, this.$keyword, this.$region, continuation);
        eCEditAddressViewModel$requestAddressListWithKeyWord$1.L$0 = obj;
        return eCEditAddressViewModel$requestAddressListWithKeyWord$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SuggestionResultObject> flowCollector, Continuation<? super Unit> continuation) {
        return ((ECEditAddressViewModel$requestAddressListWithKeyWord$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            this.L$0 = flowCollector;
            this.L$1 = this;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            IECLocationServiceProxy.b.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLocationService(), this.$context, this.$keyword, this.$region, 0, 0, new Function3<Integer, String, SuggestionResultObject, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressViewModel$requestAddressListWithKeyWord$1$result$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, SuggestionResultObject suggestionResultObject) {
                    invoke(num.intValue(), str, suggestionResultObject);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16, String str, SuggestionResultObject suggestionResultObject) {
                    if (i16 != 0 || suggestionResultObject == null) {
                        cg0.a.a("ECEditAddressViewModel", "requestAddressListWithKeyWord", "errCode:" + i16 + ", errMsg:" + str);
                    }
                    Continuation.this.resumeWith(Result.m476constructorimpl(suggestionResultObject));
                }
            }, 24, null);
            obj = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (flowCollector.emit((SuggestionResultObject) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
