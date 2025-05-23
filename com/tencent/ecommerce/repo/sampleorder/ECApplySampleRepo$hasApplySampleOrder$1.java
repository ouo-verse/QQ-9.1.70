package com.tencent.ecommerce.repo.sampleorder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "hasApplySampleOrder"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.sampleorder.ECApplySampleRepo", f = "ECApplySampleRepo.kt", i = {}, l = {49}, m = "hasApplySampleOrder", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleRepo$hasApplySampleOrder$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECApplySampleRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleRepo$hasApplySampleOrder$1(ECApplySampleRepo eCApplySampleRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCApplySampleRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
