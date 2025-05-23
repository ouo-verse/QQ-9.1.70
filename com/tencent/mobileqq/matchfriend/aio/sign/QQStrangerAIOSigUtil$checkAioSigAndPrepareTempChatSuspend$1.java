package com.tencent.mobileqq.matchfriend.aio.sign;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil", f = "QQStrangerAIOSigUtil.kt", i = {0, 0, 0, 1, 1, 1}, l = {160, 164, 169}, m = "checkAioSigAndPrepareTempChatSuspend", n = {"this", "chatType", "tinyId", "this", "chatType", "tinyId"}, s = {"L$0", "I$0", "J$0", "L$0", "I$0", "J$0"})
/* loaded from: classes33.dex */
public final class QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQStrangerAIOSigUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1(QQStrangerAIOSigUtil qQStrangerAIOSigUtil, Continuation<? super QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1> continuation) {
        super(continuation);
        this.this$0 = qQStrangerAIOSigUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(0, 0L, this);
    }
}
