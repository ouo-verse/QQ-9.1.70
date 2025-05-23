package com.tencent.qqnt.aio.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.DiscussionChatHelper", f = "DiscussionChatHelper.kt", i = {0, 0}, l = {194}, m = "insertDiscussionUnavailableGrayTipIfNeed", n = {"this", "appRuntime"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiscussionChatHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1(DiscussionChatHelper discussionChatHelper, Continuation<? super DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1> continuation) {
        super(continuation);
        this.this$0 = discussionChatHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object r16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r16 = this.this$0.r(this);
        return r16;
    }
}
