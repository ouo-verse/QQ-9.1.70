package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver", f = "MiniHomeInfoObserver.kt", i = {0, 0}, l = {78}, m = "fetchMiniHomeInfoFromNet", n = {"this", "uin"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniHomeInfoObserver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1(MiniHomeInfoObserver miniHomeInfoObserver, Continuation<? super MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1> continuation) {
        super(continuation);
        this.this$0 = miniHomeInfoObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
