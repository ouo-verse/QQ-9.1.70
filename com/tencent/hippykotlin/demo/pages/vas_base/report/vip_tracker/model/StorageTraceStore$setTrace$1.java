package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$setTrace$1", f = "StorageTraceStore.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class StorageTraceStore$setTrace$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ TraceInfo $trace;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageTraceStore$setTrace$1(TraceInfo traceInfo, Continuation<? super StorageTraceStore$setTrace$1> continuation) {
        super(2, continuation);
        this.$trace = traceInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StorageTraceStore$setTrace$1(this.$trace, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((StorageTraceStore$setTrace$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String eVar;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final TraceInfo traceInfo = this.$trace;
            this.label = 1;
            e eVar2 = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$setTraceInternal$traceStr$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar3) {
                    long a16;
                    e eVar4 = eVar3;
                    a16 = com.tencent.kuikly.core.module.b.c((com.tencent.kuikly.core.module.b) c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null).a();
                    eVar4.z("time", Long.valueOf(a16));
                    final TraceInfo traceInfo2 = TraceInfo.this;
                    traceInfo2.getClass();
                    eVar4.z("trace", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceInfo$serializeForStore$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar5) {
                            e eVar6 = eVar5;
                            eVar6.z("traceId", TraceInfo.this.f114312id);
                            eVar6.z("traceDetail", TraceInfo.this.detail);
                            eVar6.z("traceIndex", TraceInfo.this.index);
                            eVar6.z("traceNum", Integer.valueOf(TraceInfo.this.num));
                            return Unit.INSTANCE;
                        }
                    }));
                    return Unit.INSTANCE;
                }
            });
            if (k.a(c.f117352a)) {
                eVar = UriKt.encodeURIComponent(eVar2.toString());
            } else {
                eVar = eVar2.toString();
            }
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            VasModule.Companion.getInstance().writeH5Data("/vip/tracker/sdk", "vt_lastest_trace_detail", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.StorageTraceStore$setTraceInternal$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar3) {
                    e eVar4 = eVar3;
                    if (!(eVar4 != null && eVar4.j("ret") == 0)) {
                        Continuation<Boolean> continuation = safeContinuation;
                        Result.Companion companion = Result.INSTANCE;
                        continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
                    } else {
                        Continuation<Boolean> continuation2 = safeContinuation;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                    }
                    return Unit.INSTANCE;
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
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
