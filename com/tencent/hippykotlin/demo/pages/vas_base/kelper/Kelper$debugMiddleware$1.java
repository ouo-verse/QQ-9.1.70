package com.tencent.hippykotlin.demo.pages.vas_base.kelper;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper$debugMiddleware$1", f = "Kelper.kt", i = {1}, l = {113, 121}, m = "invokeSuspend", n = {"id"}, s = {"I$0"})
/* loaded from: classes33.dex */
public final class Kelper$debugMiddleware$1 extends SuspendLambda implements Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> {
    public int I$0;
    public /* synthetic */ RequestConfig L$0;
    public /* synthetic */ Function2 L$1;
    public int label;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RequestConfig requestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        Kelper$debugMiddleware$1 kelper$debugMiddleware$1 = new Kelper$debugMiddleware$1(continuation);
        kelper$debugMiddleware$1.L$0 = requestConfig;
        kelper$debugMiddleware$1.L$1 = function2;
        return kelper$debugMiddleware$1.invokeSuspend(Unit.INSTANCE);
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
            Kelper kelper = Kelper.INSTANCE;
            this.L$0 = null;
            this.label = 1;
            obj = function2.invoke(requestConfig, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i16 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                    Response response = (Response) obj;
                    Kelper kelper2 = Kelper.INSTANCE;
                    BuildersKt.e(e.f117232d, null, null, new Kelper$reportResponse$1(i16, response, null), 3, null);
                    return response;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    public Kelper$debugMiddleware$1(Continuation<? super Kelper$debugMiddleware$1> continuation) {
        super(3, continuation);
    }
}
