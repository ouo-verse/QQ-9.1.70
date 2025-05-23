package com.tencent.qqnt.aio.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.DiscussionChatHelper", f = "DiscussionChatHelper.kt", i = {}, l = {302}, m = "deleteDiscuss", n = {}, s = {})
/* loaded from: classes34.dex */
public final class DiscussionChatHelper$deleteDiscuss$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiscussionChatHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscussionChatHelper$deleteDiscuss$1(DiscussionChatHelper discussionChatHelper, Continuation<? super DiscussionChatHelper$deleteDiscuss$1> continuation) {
        super(continuation);
        this.this$0 = discussionChatHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object o16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        o16 = this.this$0.o(null, this);
        return o16;
    }
}
