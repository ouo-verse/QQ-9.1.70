package com.tencent.mobileqq.matchfriend.reborn.couple.api.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.couple.api.impl.QQStrangerInteractiveMarkServiceImpl", f = "QQStrangerInteractiveMarkServiceImpl.kt", i = {0, 0}, l = {49}, m = "batchGetInteractiveMarkInner", n = {"this", "chatType"}, s = {"L$0", "I$0"})
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQStrangerInteractiveMarkServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1(QQStrangerInteractiveMarkServiceImpl qQStrangerInteractiveMarkServiceImpl, Continuation<? super QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1> continuation) {
        super(continuation);
        this.this$0 = qQStrangerInteractiveMarkServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object batchGetInteractiveMarkInner;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        batchGetInteractiveMarkInner = this.this$0.batchGetInteractiveMarkInner(0, null, this);
        return batchGetInteractiveMarkInner;
    }
}
