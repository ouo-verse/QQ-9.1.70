package com.tencent.hippykotlin.demo.pages.vas_base.report.keport;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Method;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport$reportLog$1", f = "Keport.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Keport$reportLog$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<LogParam> $params;
    public int label;
    public final /* synthetic */ Keport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Keport$reportLog$1(Keport keport, List<LogParam> list, Continuation<? super Keport$reportLog$1> continuation) {
        super(2, continuation);
        this.this$0 = keport;
        this.$params = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Keport$reportLog$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((Keport$reportLog$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Map mutableMapOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            KRequest kRequest = this.this$0.krequest;
            final List<LogParam> list = this.$params;
            e eVar = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport$reportLog$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    eVar2.A("logs", list);
                    return Unit.INSTANCE;
                }
            });
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("Content-Type", "application/json;charset=utf-8"));
            RequestConfig requestConfig = new RequestConfig("/log-report", null, mutableMapOf, null, eVar, 0, null, 982);
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
