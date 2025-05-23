package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import h25.c;
import h25.x;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$onKeySelectTts$1", f = "AdelieOIDBServer.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieOIDBServer$onKeySelectTts$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Integer, String, c, Unit> $callback;
    public final /* synthetic */ x $myBotInfo;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieOIDBServer$onKeySelectTts$1(Function3<? super Integer, ? super String, ? super c, Unit> function3, x xVar, Continuation<? super AdelieOIDBServer$onKeySelectTts$1> continuation) {
        super(2, continuation);
        this.$callback = function3;
        this.$myBotInfo = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieOIDBServer$onKeySelectTts$1(this.$callback, this.$myBotInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieOIDBServer$onKeySelectTts$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final x xVar = this.$myBotInfo;
            Function0<h25.b> function0 = new Function0<h25.b>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$onKeySelectTts$1$rsp$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final h25.b invoke() {
                    return new h25.b(7, x.this, 11);
                }
            };
            AdelieOIDBServer$onKeySelectTts$1$rsp$2 adelieOIDBServer$onKeySelectTts$1$rsp$2 = new Function1<byte[], c>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$onKeySelectTts$1$rsp$2
                @Override // kotlin.jvm.functions.Function1
                public final c invoke(byte[] bArr) {
                    return (c) i.b(new c(null, null, 3, null), bArr);
                }
            };
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37237, function0, adelieOIDBServer$onKeySelectTts$1$rsp$2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AdelieOIDBServer.access$handleResponse((OIDBResponse) obj, this.$callback);
        return Unit.INSTANCE;
    }
}
