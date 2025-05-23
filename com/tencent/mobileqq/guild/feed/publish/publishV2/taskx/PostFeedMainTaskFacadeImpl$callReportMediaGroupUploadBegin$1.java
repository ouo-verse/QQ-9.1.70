package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl", f = "PostFeedMainTaskFacadeImpl.kt", i = {0}, l = {135}, m = "callReportMediaGroupUploadBegin", n = {"this"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PostFeedMainTaskFacadeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1(PostFeedMainTaskFacadeImpl postFeedMainTaskFacadeImpl, Continuation<? super PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1> continuation) {
        super(continuation);
        this.this$0 = postFeedMainTaskFacadeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(this);
        return g16;
    }
}
