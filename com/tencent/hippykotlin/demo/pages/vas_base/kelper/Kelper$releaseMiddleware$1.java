package com.tencent.hippykotlin.demo.pages.vas_base.kelper;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper$releaseMiddleware$1", f = "Kelper.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Kelper$releaseMiddleware$1 extends SuspendLambda implements Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> {
    public /* synthetic */ RequestConfig L$0;
    public /* synthetic */ Function2 L$1;
    public int label;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RequestConfig requestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        Kelper$releaseMiddleware$1 kelper$releaseMiddleware$1 = new Kelper$releaseMiddleware$1(continuation);
        kelper$releaseMiddleware$1.L$0 = requestConfig;
        kelper$releaseMiddleware$1.L$1 = function2;
        return kelper$releaseMiddleware$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            RequestConfig requestConfig = this.L$0;
            Function2 function2 = this.L$1;
            this.L$0 = null;
            this.label = 1;
            obj = function2.invoke(requestConfig, this);
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

    public Kelper$releaseMiddleware$1(Continuation<? super Kelper$releaseMiddleware$1> continuation) {
        super(3, continuation);
    }
}
