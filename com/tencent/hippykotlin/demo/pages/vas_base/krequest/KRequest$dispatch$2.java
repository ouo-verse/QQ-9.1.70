package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest$dispatch$2", f = "KRequest.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class KRequest$dispatch$2 extends SuspendLambda implements Function2<RequestConfig, Continuation<? super Response>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ KRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRequest$dispatch$2(KRequest kRequest, Continuation<? super KRequest$dispatch$2> continuation) {
        super(2, continuation);
        this.this$0 = kRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KRequest$dispatch$2 kRequest$dispatch$2 = new KRequest$dispatch$2(this.this$0, continuation);
        kRequest$dispatch$2.L$0 = obj;
        return kRequest$dispatch$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(RequestConfig requestConfig, Continuation<? super Response> continuation) {
        return ((KRequest$dispatch$2) create(requestConfig, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            RequestConfig requestConfig = (RequestConfig) this.L$0;
            KRequest kRequest = this.this$0;
            this.label = 1;
            obj = kRequest.doRequest(requestConfig, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
