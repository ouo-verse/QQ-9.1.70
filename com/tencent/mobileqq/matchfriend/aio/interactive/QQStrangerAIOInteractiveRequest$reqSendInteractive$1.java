package com.tencent.mobileqq.matchfriend.aio.interactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.interactive.QQStrangerAIOInteractiveRequest", f = "QQStrangerAIOInteractiveRequest.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {28, 30, 35, 41}, m = "reqSendInteractive", n = {"this", "param", "option", "chatType", "tinyId", "interactiveType", "this", "param", "option", "chatType", "tinyId", "interactiveType", "appId", "this", "param", "option", "result", "interactiveType", "appId"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "I$1", "L$0", "L$1", "L$2", "I$0", "J$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
/* loaded from: classes33.dex */
public final class QQStrangerAIOInteractiveRequest$reqSendInteractive$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQStrangerAIOInteractiveRequest this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerAIOInteractiveRequest$reqSendInteractive$1(QQStrangerAIOInteractiveRequest qQStrangerAIOInteractiveRequest, Continuation<? super QQStrangerAIOInteractiveRequest$reqSendInteractive$1> continuation) {
        super(continuation);
        this.this$0 = qQStrangerAIOInteractiveRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(0, 0L, 0, null, null, this);
    }
}
