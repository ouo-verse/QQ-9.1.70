package com.tencent.luggage.wxa.bj;

import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f122915a;

        public a(Continuation continuation) {
            this.f122915a = continuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(t8 t8Var) {
            this.f122915a.resumeWith(Result.m476constructorimpl(t8Var));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bj.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6075b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f122916a;

        public C6075b(Continuation continuation) {
            this.f122916a = continuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            if (obj instanceof Throwable) {
                Continuation continuation = this.f122916a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure((Throwable) obj)));
            } else {
                Continuation continuation2 = this.f122916a;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException("Unknown error " + obj))));
            }
        }
    }

    public static final Object a(c cVar, String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls, Continuation continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        cVar.b(str, str2, bVar, cls).a(new a(safeContinuation)).a(new C6075b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
