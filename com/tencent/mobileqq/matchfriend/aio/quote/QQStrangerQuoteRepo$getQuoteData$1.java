package com.tencent.mobileqq.matchfriend.aio.quote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteRepo", f = "QQStrangerQuoteRepo.kt", i = {}, l = {41}, m = "getQuoteData", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteRepo$getQuoteData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQStrangerQuoteRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerQuoteRepo$getQuoteData$1(QQStrangerQuoteRepo qQStrangerQuoteRepo, Continuation<? super QQStrangerQuoteRepo$getQuoteData$1> continuation) {
        super(continuation);
        this.this$0 = qQStrangerQuoteRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0L, null, this);
    }
}
