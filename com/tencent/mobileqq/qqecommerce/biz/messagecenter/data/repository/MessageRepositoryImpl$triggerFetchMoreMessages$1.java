package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl", f = "MessageRepositoryImpl.kt", i = {0, 1}, l = {133, 138}, m = "triggerFetchMoreMessages", n = {"this", "curList"}, s = {"L$0", "L$0"})
/* loaded from: classes35.dex */
public final class MessageRepositoryImpl$triggerFetchMoreMessages$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$triggerFetchMoreMessages$1(MessageRepositoryImpl messageRepositoryImpl, Continuation<? super MessageRepositoryImpl$triggerFetchMoreMessages$1> continuation) {
        super(continuation);
        this.this$0 = messageRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j3 = this.this$0.j(null, this);
        return j3;
    }
}
