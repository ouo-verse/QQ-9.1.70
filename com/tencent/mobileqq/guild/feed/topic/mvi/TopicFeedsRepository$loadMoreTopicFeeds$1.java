package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository", f = "TopicFeedsRepository.kt", i = {0}, l = {76}, m = "loadMoreTopicFeeds", n = {"this"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class TopicFeedsRepository$loadMoreTopicFeeds$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopicFeedsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedsRepository$loadMoreTopicFeeds$1(TopicFeedsRepository topicFeedsRepository, Continuation<? super TopicFeedsRepository$loadMoreTopicFeeds$1> continuation) {
        super(continuation);
        this.this$0 = topicFeedsRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
