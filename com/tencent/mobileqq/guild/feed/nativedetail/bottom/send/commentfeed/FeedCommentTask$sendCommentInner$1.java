package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.FeedCommentTask", f = "FeedCommentTask.kt", i = {0, 0, 0, 0, 0}, l = {169}, m = "sendCommentInner", n = {"this", "commentRequestArgs", "richText", Const.BUNDLE_KEY_REQUEST, "originalPic"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"})
/* loaded from: classes13.dex */
public final class FeedCommentTask$sendCommentInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedCommentTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentTask$sendCommentInner$1(FeedCommentTask feedCommentTask, Continuation<? super FeedCommentTask$sendCommentInner$1> continuation) {
        super(continuation);
        this.this$0 = feedCommentTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object H;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        H = this.this$0.H(null, null, false, null, this);
        return H;
    }
}
