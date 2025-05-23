package com.tencent.ecommerce.biz.applysample;

import com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import com.tencent.ecommerce.biz.comment.UploadFailedException;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.sampleorder.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1", f = "ECAbortFulfillOrderViewModel.kt", i = {0, 0, 2}, l = {64, 66, 74, 76}, m = "invokeSuspend", n = {"$this$flow", "currentState", "$this$flow"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes31.dex */
public final class ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desc;
    final /* synthetic */ String $orderId;
    final /* synthetic */ OptionValue $reason;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECAbortFulfillOrderViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1(ECAbortFulfillOrderViewModel eCAbortFulfillOrderViewModel, String str, OptionValue optionValue, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAbortFulfillOrderViewModel;
        this.$orderId = str;
        this.$reason = optionValue;
        this.$desc = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1 eCAbortFulfillOrderViewModel$requestAbortFulfillOrder$1 = new ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1(this.this$0, this.$orderId, this.$reason, this.$desc, continuation);
        eCAbortFulfillOrderViewModel$requestAbortFulfillOrder$1.L$0 = obj;
        return eCAbortFulfillOrderViewModel$requestAbortFulfillOrder$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return ((ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(1:(1:(1:(1:(3:7|8|9)(2:11|12))(5:13|14|(1:16)|8|9))(3:17|18|19))(4:20|21|22|23))(2:36|(2:38|39)(3:40|41|(1:43)(1:44)))|24|25|26|(1:28)|14|(0)|8|9|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c4, code lost:
    
        return r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        BatchUploader batchUploader;
        Object h16;
        FlowCollector flowCollector2;
        ECAbortFulfillOrderViewModel.a aVar;
        Boolean boxBoolean;
        Object e16;
        Boolean boxBoolean2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            ECAbortFulfillOrderViewModel.a value = this.this$0.O1().getValue();
            if (value instanceof ECAbortFulfillOrderViewModel.a.c) {
                try {
                    batchUploader = this.this$0.batchUploader;
                    this.L$0 = flowCollector3;
                    this.L$1 = value;
                    this.label = 1;
                    h16 = batchUploader.h(this);
                    if (h16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector3;
                    aVar = value;
                } catch (UploadFailedException unused) {
                    flowCollector = flowCollector3;
                    boxBoolean = Boxing.boxBoolean(false);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    if (flowCollector.emit(boxBoolean, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                return Unit.INSTANCE;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i3 != 3) {
                    if (i3 == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FlowCollector flowCollector4 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector4;
                e16 = obj;
                boxBoolean2 = Boxing.boxBoolean(((Boolean) e16).booleanValue());
                this.L$0 = null;
                this.label = 4;
                if (flowCollector2.emit(boxBoolean2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            aVar = (ECAbortFulfillOrderViewModel.a) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector;
                h16 = obj;
            } catch (UploadFailedException unused2) {
                boxBoolean = Boxing.boxBoolean(false);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (flowCollector.emit(boxBoolean, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        List<String> list = (List) h16;
        d d16 = ServiceLocator.f104891i.d();
        String str = ((ECAbortFulfillOrderViewModel.a.c) aVar).data.token;
        String str2 = this.$orderId;
        OptionValue optionValue = this.$reason;
        String str3 = this.$desc;
        this.L$0 = flowCollector2;
        this.L$1 = null;
        this.label = 3;
        e16 = d16.e(str, str2, optionValue, str3, list, this);
        if (e16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        boxBoolean2 = Boxing.boxBoolean(((Boolean) e16).booleanValue());
        this.L$0 = null;
        this.label = 4;
        if (flowCollector2.emit(boxBoolean2, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
