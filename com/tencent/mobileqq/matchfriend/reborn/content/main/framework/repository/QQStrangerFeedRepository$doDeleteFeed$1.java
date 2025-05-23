package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository", f = "QQStrangerFeedRepository.kt", i = {}, l = {333}, m = "doDeleteFeed", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerFeedRepository$doDeleteFeed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQStrangerFeedRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedRepository$doDeleteFeed$1(QQStrangerFeedRepository qQStrangerFeedRepository, Continuation<? super QQStrangerFeedRepository$doDeleteFeed$1> continuation) {
        super(continuation);
        this.this$0 = qQStrangerFeedRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
