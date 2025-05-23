package com.tencent.ecommerce.base.cache.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, d2 = {"DataType", "KeyType", "", "newList", "", "pageName", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "generateNewList"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.cache.service.PtsComposerCache", f = "PtsComposerCache.kt", i = {0, 0}, l = {163}, m = "generateNewList", n = {"this", "pageName"}, s = {"L$0", "L$1"})
/* loaded from: classes32.dex */
public final class PtsComposerCache$generateNewList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PtsComposerCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PtsComposerCache$generateNewList$1(PtsComposerCache ptsComposerCache, Continuation continuation) {
        super(continuation);
        this.this$0 = ptsComposerCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
