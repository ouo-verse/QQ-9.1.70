package com.tencent.kuikly.core.coroutines;

import com.tencent.kuikly.core.coroutines.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001e\u0010\u001fJQ\u0010\u000e\u001a\u00020\r\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00012'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00a2\u0006\u0002\b\u000bH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/coroutines/a;", "T", "Lcom/tencent/kuikly/core/coroutines/f;", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/kuikly/core/coroutines/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/kuikly/core/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "block", "", "a", "(Lcom/tencent/kuikly/core/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "d", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "parentContext", "", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class a<T> implements f, Continuation<T>, b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineContext context;

    public a(CoroutineContext parentContext, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        this.context = parentContext.plus(this);
    }

    public <R> void a(CoroutineStart start, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        start.invoke(block, receiver, this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r16, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) f.a.a(this, r16, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) f.a.b(this, key);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return f.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return f.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return f.a.d(this, coroutineContext);
    }
}
