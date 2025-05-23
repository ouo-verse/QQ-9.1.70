package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import h25.r;
import h25.s;
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
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestTtsList$1", f = "AdelieOIDBServer.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieOIDBServer$requestTtsList$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Integer, String, s, Unit> $callback;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieOIDBServer$requestTtsList$1(Function3<? super Integer, ? super String, ? super s, Unit> function3, Continuation<? super AdelieOIDBServer$requestTtsList$1> continuation) {
        super(2, continuation);
        this.$callback = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieOIDBServer$requestTtsList$1(this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieOIDBServer$requestTtsList$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AdelieOIDBServer$requestTtsList$1$rsp$1 adelieOIDBServer$requestTtsList$1$rsp$1 = new Function0<r>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestTtsList$1$rsp$1
                @Override // kotlin.jvm.functions.Function0
                public final r invoke() {
                    return new r(1, 0, 62);
                }
            };
            AdelieOIDBServer$requestTtsList$1$rsp$2 adelieOIDBServer$requestTtsList$1$rsp$2 = new Function1<byte[], s>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestTtsList$1$rsp$2
                @Override // kotlin.jvm.functions.Function1
                public final s invoke(byte[] bArr) {
                    return (s) i.b(new s(null, null, 0, null, null, null, 0, null, 255, null), bArr);
                }
            };
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37339, adelieOIDBServer$requestTtsList$1$rsp$1, adelieOIDBServer$requestTtsList$1$rsp$2, this);
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
