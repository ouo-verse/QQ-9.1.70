package com.tencent.ecommerce.biz.showwindow.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0082@"}, d2 = {"", "groupId", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "Lorg/json/JSONObject;", "continuation", "", "changeShowWindowScheme"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.viewmodel.ECQGroupWindowViewModel", f = "ECQGroupWindowViewModel.kt", i = {}, l = {66}, m = "changeShowWindowScheme", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECQGroupWindowViewModel$changeShowWindowScheme$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECQGroupWindowViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQGroupWindowViewModel$changeShowWindowScheme$1(ECQGroupWindowViewModel eCQGroupWindowViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCQGroupWindowViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.N1(null, null, this);
    }
}
