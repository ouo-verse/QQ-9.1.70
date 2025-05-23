package com.tencent.kuikly.core.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u0005\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/h;", "Lcom/tencent/kuikly/core/coroutines/a;", "", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class h extends a<Unit> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(CoroutineContext parentContext, boolean z16) {
        super(parentContext, true, z16);
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
    }
}
