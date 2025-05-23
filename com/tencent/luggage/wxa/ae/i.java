package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f121086a;

    public i(CancellableContinuation cancellableContinuation) {
        this.f121086a = cancellableContinuation;
    }

    @Override // com.tencent.luggage.wxa.xo.e.a
    public final void a(Object it) {
        if (this.f121086a.isActive()) {
            if (it instanceof com.tencent.luggage.wxa.bj.a) {
                CancellableContinuation cancellableContinuation = this.f121086a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure((Throwable) it)));
                return;
            }
            if (it == null) {
                CancellableContinuation cancellableContinuation2 = this.f121086a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.UNKNOWN, -1, null))));
            } else {
                CancellableContinuation cancellableContinuation3 = this.f121086a;
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.UNKNOWN, -1, it.toString()))));
            }
        }
    }
}
