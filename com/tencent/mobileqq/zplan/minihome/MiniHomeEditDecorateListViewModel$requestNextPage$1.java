package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.MiniHomeEditDecorateListViewModel", f = "EditMiniHomeFragment.kt", i = {0, 0, 0}, l = {1887}, m = "requestNextPage", n = {"this", "expression", "nextIndex"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes34.dex */
public final class MiniHomeEditDecorateListViewModel$requestNextPage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniHomeEditDecorateListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeEditDecorateListViewModel$requestNextPage$1(MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel, Continuation<? super MiniHomeEditDecorateListViewModel$requestNextPage$1> continuation) {
        super(continuation);
        this.this$0 = miniHomeEditDecorateListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.P1(this);
    }
}
