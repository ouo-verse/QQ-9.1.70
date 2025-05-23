package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.TopFeedCommentApi", f = "TopFeedCommentApi.kt", i = {0, 0}, l = {63}, m = "setTopComment", n = {"callback", "req"}, s = {"L$0", "L$1"})
/* loaded from: classes13.dex */
public final class TopFeedCommentApi$setTopComment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopFeedCommentApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFeedCommentApi$setTopComment$1(TopFeedCommentApi topFeedCommentApi, Continuation<? super TopFeedCommentApi$setTopComment$1> continuation) {
        super(continuation);
        this.this$0 = topFeedCommentApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, false, null, this);
    }
}
