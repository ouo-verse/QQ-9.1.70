package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.n2;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final String f135281a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135282b;

    /* renamed from: c, reason: collision with root package name */
    public final int f135283c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m6.k f135284d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f135285a;

        public a(Continuation continuation) {
            this.f135285a = continuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(n2 n2Var) {
            Continuation continuation = this.f135285a;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNull(n2Var);
            continuation.resumeWith(Result.m476constructorimpl(n2Var));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f135286a;

        public b(Continuation continuation) {
            this.f135286a = continuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                Continuation continuation = this.f135286a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure((Throwable) obj)));
            } else {
                Continuation continuation2 = this.f135286a;
                Result.Companion companion2 = Result.INSTANCE;
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = null;
                }
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalArgumentException(str))));
            }
        }
    }

    public z(String codeData, int i3, int i16) {
        Intrinsics.checkNotNullParameter(codeData, "codeData");
        this.f135281a = codeData;
        this.f135282b = i3;
        this.f135283c = i16;
        com.tencent.luggage.wxa.m6.k kVar = new com.tencent.luggage.wxa.m6.k();
        kVar.f();
        kVar.f128121m = 4;
        kVar.f128129u = i3;
        kVar.f128130v = i16;
        kVar.f128118j = new e9().a(codeData);
        kVar.f128113e = 2;
        this.f135284d = kVar;
    }

    public final Object a(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.luggage.wxa.m6.l lVar = new com.tencent.luggage.wxa.m6.l();
        String f16 = this.f135284d.f128118j.f();
        Intrinsics.checkNotNullExpressionValue(f16, "a8keyRequest.ReqUrl.string");
        lVar.a(f16, 0).a(this.f135284d, n2.class).a(new a(safeContinuation)).a(new b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
