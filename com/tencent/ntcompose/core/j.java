package com.tencent.ntcompose.core;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ntcompose/core/j;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "interceptContinuation", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* renamed from: d, reason: collision with root package name */
    public static final j f339216d = new j();

    j() {
        super(ContinuationInterceptor.INSTANCE);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.DefaultImpls.get(this, key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.ContinuationInterceptor
    public <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continuation;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        ContinuationInterceptor.DefaultImpls.releaseInterceptedContinuation(this, continuation);
    }
}
