package com.tencent.ecommerce.biz.applysample;

import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel$uploadImages$1", f = "ECAbortFulfillOrderViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAbortFulfillOrderViewModel$uploadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $mediaInfos;
    int label;
    final /* synthetic */ ECAbortFulfillOrderViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAbortFulfillOrderViewModel$uploadImages$1(ECAbortFulfillOrderViewModel eCAbortFulfillOrderViewModel, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCAbortFulfillOrderViewModel;
        this.$mediaInfos = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAbortFulfillOrderViewModel$uploadImages$1(this.this$0, this.$mediaInfos, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAbortFulfillOrderViewModel$uploadImages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        BatchUploader batchUploader;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            batchUploader = this.this$0.batchUploader;
            List<ECMediaInfo> list = this.$mediaInfos;
            this.label = 1;
            if (batchUploader.k(list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
