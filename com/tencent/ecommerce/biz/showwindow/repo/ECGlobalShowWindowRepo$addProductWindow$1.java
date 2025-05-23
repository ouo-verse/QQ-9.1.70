package com.tencent.ecommerce.biz.showwindow.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0086@"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/a;", "addProductWindowRequest", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lqi0/a;", "continuation", "", "addProductWindow"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.repo.ECGlobalShowWindowRepo", f = "ECGlobalShowWindowRepo.kt", i = {}, l = {46}, m = "addProductWindow", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECGlobalShowWindowRepo$addProductWindow$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECGlobalShowWindowRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECGlobalShowWindowRepo$addProductWindow$1(ECGlobalShowWindowRepo eCGlobalShowWindowRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCGlobalShowWindowRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
