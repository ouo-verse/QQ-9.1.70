package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsRepository", f = "TopicFeedsRepository.kt", i = {0, 0, 0, 1, 1, 1}, l = {135, 97}, m = "innerGetFeeds", n = {"this", "req", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "this", "req", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0"})
/* loaded from: classes13.dex */
public final class TopicFeedsRepository$innerGetFeeds$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopicFeedsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicFeedsRepository$innerGetFeeds$1(TopicFeedsRepository topicFeedsRepository, Continuation<? super TopicFeedsRepository$innerGetFeeds$1> continuation) {
        super(continuation);
        this.this$0 = topicFeedsRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object k3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        k3 = this.this$0.k(null, this);
        return k3;
    }
}
