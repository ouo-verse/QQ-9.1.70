package com.tencent.hippykotlin.demo.pages.vas_base.kelper;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Method;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper$reportResponse$1", f = "Kelper.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Kelper$reportResponse$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $id;
    public final /* synthetic */ Response $response;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kelper$reportResponse$1(int i3, Response response, Continuation<? super Kelper$reportResponse$1> continuation) {
        super(2, continuation);
        this.$id = i3;
        this.$response = response;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Kelper$reportResponse$1(this.$id, this.$response, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((Kelper$reportResponse$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            KRequest kRequest = (KRequest) Kelper.requester$delegate.getValue();
            final int i16 = this.$id;
            final Response response = this.$response;
            RequestConfig requestConfig = new RequestConfig("/network/response", null, null, null, new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper$reportResponse$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    eVar2.z("id", Integer.valueOf(i16));
                    eVar2.B("header", response.headers);
                    eVar2.z("status", Integer.valueOf(response.status));
                    eVar2.z("data", response.data.toString());
                    return Unit.INSTANCE;
                }
            }), 0, null, 990);
            this.label = 1;
            kRequest.getClass();
            requestConfig.method = Method.POST;
            if (kRequest.request(requestConfig, this) == coroutine_suspended) {
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
