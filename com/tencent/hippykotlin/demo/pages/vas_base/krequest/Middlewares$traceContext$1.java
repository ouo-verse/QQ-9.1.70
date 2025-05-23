package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.vas_base.SessionIdGenerator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares$traceContext$1", f = "Middlewares.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class Middlewares$traceContext$1 extends SuspendLambda implements Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> {
    public /* synthetic */ RequestConfig L$0;
    public /* synthetic */ Function2 L$1;
    public int label;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RequestConfig requestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        Middlewares$traceContext$1 middlewares$traceContext$1 = new Middlewares$traceContext$1(continuation);
        middlewares$traceContext$1.L$0 = requestConfig;
        middlewares$traceContext$1.L$1 = function2;
        return middlewares$traceContext$1.invokeSuspend(Unit.INSTANCE);
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
            Map<String, String> map = requestConfig.headers;
            SessionIdGenerator sessionIdGenerator = SessionIdGenerator.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("00-");
            m3.append(sessionIdGenerator.getSessionId());
            m3.append('-');
            m3.append(sessionIdGenerator.generateRandomString(16));
            m3.append("-00");
            map.put("Trace-Parent", m3.toString());
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

    public Middlewares$traceContext$1(Continuation<? super Middlewares$traceContext$1> continuation) {
        super(3, continuation);
    }
}
