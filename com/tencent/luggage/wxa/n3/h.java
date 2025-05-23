package com.tencent.luggage.wxa.n3;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h extends e {

    /* renamed from: b, reason: collision with root package name */
    public s8 f135180b;

    /* renamed from: c, reason: collision with root package name */
    public Class f135181c;

    /* renamed from: d, reason: collision with root package name */
    public String f135182d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f135183a;

        public a(CancellableContinuation cancellableContinuation) {
            this.f135183a = cancellableContinuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(t8 t8Var) {
            this.f135183a.resumeWith(Result.m476constructorimpl(t8Var));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f135184a;

        public b(CancellableContinuation cancellableContinuation) {
            this.f135184a = cancellableContinuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object it) {
            String str;
            if (it instanceof com.tencent.luggage.wxa.bj.a) {
                CancellableContinuation cancellableContinuation = this.f135184a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure((Throwable) it)));
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.f135184a;
            Result.Companion companion2 = Result.INSTANCE;
            a.EnumC6074a enumC6074a = a.EnumC6074a.UNKNOWN;
            if (it != null) {
                str = it.toString();
            } else {
                str = null;
            }
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new com.tencent.luggage.wxa.bj.a(enumC6074a, 0, str))));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vo.c f135185a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.vo.c cVar) {
            super(1);
            this.f135185a = cVar;
        }

        public final void a(Throwable th5) {
            this.f135185a.g();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    public Object a(Continuation continuation) {
        return a(this, continuation);
    }

    public final String b() {
        return this.f135182d;
    }

    public final s8 c() {
        s8 s8Var = this.f135180b;
        if (s8Var != null) {
            return s8Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Const.BUNDLE_KEY_REQUEST);
        return null;
    }

    public Class d() {
        Class cls = this.f135181c;
        if (cls != null) {
            return cls;
        }
        Intrinsics.throwUninitializedPropertyAccessException("responseClazz");
        return null;
    }

    public final void a(s8 s8Var) {
        Intrinsics.checkNotNullParameter(s8Var, "<set-?>");
        this.f135180b = s8Var;
    }

    public void a(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.f135181c = cls;
    }

    public final void a(String str) {
        this.f135182d = str;
    }

    public static /* synthetic */ Object a(h hVar, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.luggage.wxa.vo.c cVar = new com.tencent.luggage.wxa.vo.c();
        hVar.a(hVar.b(), hVar.c(), hVar.d()).a(cVar).a(new a(cancellableContinuationImpl)).a(new b(cancellableContinuationImpl));
        cancellableContinuationImpl.invokeOnCancellation(new c(cVar));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
