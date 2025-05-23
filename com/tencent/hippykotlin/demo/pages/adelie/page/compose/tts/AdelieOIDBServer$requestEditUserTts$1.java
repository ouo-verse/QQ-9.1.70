package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import f25.j;
import h25.p;
import h25.q;
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
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestEditUserTts$1", f = "AdelieOIDBServer.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieOIDBServer$requestEditUserTts$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Integer, String, q, Unit> $callback;
    public final /* synthetic */ j $ttsInfo;
    public final /* synthetic */ int $type;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieOIDBServer$requestEditUserTts$1(Function3<? super Integer, ? super String, ? super q, Unit> function3, int i3, j jVar, Continuation<? super AdelieOIDBServer$requestEditUserTts$1> continuation) {
        super(2, continuation);
        this.$callback = function3;
        this.$type = i3;
        this.$ttsInfo = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieOIDBServer$requestEditUserTts$1(this.$callback, this.$type, this.$ttsInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieOIDBServer$requestEditUserTts$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final int i16 = this.$type;
            final j jVar = this.$ttsInfo;
            Function0<p> function0 = new Function0<p>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestEditUserTts$1$rsp$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final p invoke() {
                    return new p(i16, null, jVar, 2);
                }
            };
            AdelieOIDBServer$requestEditUserTts$1$rsp$2 adelieOIDBServer$requestEditUserTts$1$rsp$2 = new Function1<byte[], q>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$requestEditUserTts$1$rsp$2
                @Override // kotlin.jvm.functions.Function1
                public final q invoke(byte[] bArr) {
                    return (q) i.b(new q(null, 1, null), bArr);
                }
            };
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37529, function0, adelieOIDBServer$requestEditUserTts$1$rsp$2, this);
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
