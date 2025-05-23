package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import h25.ai;
import h25.aj;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$queryTask$pollTaskState$1", f = "AdelieOIDBServer.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieOIDBServer$queryTask$pollTaskState$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Integer, String, aj, Unit> $callback;
    public final /* synthetic */ Ref.IntRef $currentPolling;
    public final /* synthetic */ String $taskId;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieOIDBServer$queryTask$pollTaskState$1(Function3<? super Integer, ? super String, ? super aj, Unit> function3, Ref.IntRef intRef, String str, Continuation<? super AdelieOIDBServer$queryTask$pollTaskState$1> continuation) {
        super(2, continuation);
        this.$callback = function3;
        this.$currentPolling = intRef;
        this.$taskId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieOIDBServer$queryTask$pollTaskState$1(this.$callback, this.$currentPolling, this.$taskId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieOIDBServer$queryTask$pollTaskState$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int coerceAtLeast;
        int coerceAtLeast2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = this.$taskId;
            Function0<ai> function0 = new Function0<ai>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$queryTask$pollTaskState$1$rsp$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ai invoke() {
                    return new ai(str);
                }
            };
            AdelieOIDBServer$queryTask$pollTaskState$1$rsp$2 adelieOIDBServer$queryTask$pollTaskState$1$rsp$2 = new Function1<byte[], aj>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$queryTask$pollTaskState$1$rsp$2
                @Override // kotlin.jvm.functions.Function1
                public final aj invoke(byte[] bArr) {
                    return (aj) i.b(new aj(0, 0, null, null, null, null, 0, 0, 255, null), bArr);
                }
            };
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37239, function0, adelieOIDBServer$queryTask$pollTaskState$1$rsp$2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        Rsp rsp = oIDBResponse.rsp;
        if (rsp != 0 && oIDBResponse.success) {
            aj ajVar = (aj) rsp;
            KLog.INSTANCE.i("AdelieOIDBServer", "rspData value = " + ajVar);
            int i16 = ajVar.f404150d;
            if (i16 == 0) {
                this.$callback.invoke(Boxing.boxInt(i16), "", ajVar);
            } else if (i16 == 1) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(ajVar.D, 5);
                if (this.$currentPolling.element < coerceAtLeast) {
                    coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(ajVar.C, 200);
                    final String str2 = this.$taskId;
                    final Ref.IntRef intRef = this.$currentPolling;
                    final Function3<Integer, String, aj, Unit> function3 = this.$callback;
                    TimerKt.c(coerceAtLeast2, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieOIDBServer$queryTask$pollTaskState$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            AdelieOIDBServer.queryTask$pollTaskState(intRef, function3, str2);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    this.$callback.invoke(Boxing.boxInt(ajVar.f404150d), ajVar.f404152f, ajVar);
                }
            } else if (i16 != 2) {
                this.$callback.invoke(Boxing.boxInt(i16), ajVar.f404152f, ajVar);
            } else {
                this.$callback.invoke(Boxing.boxInt(i16), ajVar.f404152f, ajVar);
            }
            return Unit.INSTANCE;
        }
        this.$callback.invoke(Boxing.boxInt(-1), oIDBResponse.f114186msg, null);
        return Unit.INSTANCE;
    }
}
