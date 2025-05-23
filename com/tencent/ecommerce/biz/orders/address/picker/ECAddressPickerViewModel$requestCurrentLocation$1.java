package com.tencent.ecommerce.biz.orders.address.picker;

import ag0.ECLocationInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
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
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lag0/a;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerViewModel$requestCurrentLocation$1", f = "ECAddressPickerViewModel.kt", i = {0}, l = {148, 158}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes31.dex */
final class ECAddressPickerViewModel$requestCurrentLocation$1 extends SuspendLambda implements Function2<FlowCollector<? super ECLocationInfo>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECAddressPickerViewModel$requestCurrentLocation$1 eCAddressPickerViewModel$requestCurrentLocation$1 = new ECAddressPickerViewModel$requestCurrentLocation$1(continuation);
        eCAddressPickerViewModel$requestCurrentLocation$1.L$0 = obj;
        return eCAddressPickerViewModel$requestCurrentLocation$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ECLocationInfo> flowCollector, Continuation<? super Unit> continuation) {
        return ((ECAddressPickerViewModel$requestCurrentLocation$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLocationService().requestCurrentLocation(3, new Function2<Integer, ECLocationInfo, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerViewModel$requestCurrentLocation$1$currentCity$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, ECLocationInfo eCLocationInfo) {
                    invoke(num.intValue(), eCLocationInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16, ECLocationInfo eCLocationInfo) {
                    if (i16 == 0 && eCLocationInfo != null) {
                        Continuation.this.resumeWith(Result.m476constructorimpl(eCLocationInfo));
                    } else {
                        Continuation.this.resumeWith(Result.m476constructorimpl(null));
                    }
                }
            });
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
        if (flowCollector.emit((ECLocationInfo) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECAddressPickerViewModel$requestCurrentLocation$1(Continuation continuation) {
        super(2, continuation);
    }
}
