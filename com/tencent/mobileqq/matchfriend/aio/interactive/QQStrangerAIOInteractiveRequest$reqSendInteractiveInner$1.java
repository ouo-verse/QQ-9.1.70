package com.tencent.mobileqq.matchfriend.aio.interactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.interactive.QQStrangerAIOInteractiveRequest", f = "QQStrangerAIOInteractiveRequest.kt", i = {}, l = {57}, m = "reqSendInteractiveInner", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQStrangerAIOInteractiveRequest this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1(QQStrangerAIOInteractiveRequest qQStrangerAIOInteractiveRequest, Continuation<? super QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1> continuation) {
        super(continuation);
        this.this$0 = qQStrangerAIOInteractiveRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d16 = this.this$0.d(0, null, 0, null, null, this);
        return d16;
    }
}
