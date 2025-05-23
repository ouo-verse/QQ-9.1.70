package com.tencent.kuikly.core.coroutines;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR>\u0010\u000e\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\n0\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\n`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u0017\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u00008\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/d;", "T", "Lcom/tencent/kuikly/core/coroutines/a;", "Lcom/tencent/kuikly/core/coroutines/c;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "suspendCoroutineResumeTasks", "", "f", "Z", "didSetResultValue", "value", tl.h.F, "Ljava/lang/Object;", "b", "resumeResultValue", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class d<T> extends a<T> implements c<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Function1<T, Unit>> suspendCoroutineResumeTasks;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean didSetResultValue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private T resumeResultValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CoroutineContext parentContext, boolean z16) {
        super(parentContext, true, z16);
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        this.suspendCoroutineResumeTasks = new ArrayList<>();
    }

    private final void b(T t16) {
        this.resumeResultValue = t16;
        this.didSetResultValue = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        if (Result.m483isSuccessimpl(result)) {
            if (Result.m482isFailureimpl(result)) {
                result = null;
            }
            b(result);
            Iterator<T> it = this.suspendCoroutineResumeTasks.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(this.resumeResultValue);
            }
            this.suspendCoroutineResumeTasks.clear();
            return;
        }
        throw new RuntimeException("result failure:" + Result.m479exceptionOrNullimpl(result));
    }
}
