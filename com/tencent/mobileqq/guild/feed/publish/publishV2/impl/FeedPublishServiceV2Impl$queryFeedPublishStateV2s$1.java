package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl", f = "FeedPublishServiceV2Impl.kt", i = {0, 0, 1, 1}, l = {169, 169}, m = "queryFeedPublishStateV2s", n = {"guild", WadlProxyConsts.CHANNEL, "guild", WadlProxyConsts.CHANNEL}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes13.dex */
public final class FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedPublishServiceV2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1(FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super FeedPublishServiceV2Impl$queryFeedPublishStateV2s$1> continuation) {
        super(continuation);
        this.this$0 = feedPublishServiceV2Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object queryFeedPublishStateV2s;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        queryFeedPublishStateV2s = this.this$0.queryFeedPublishStateV2s(null, null, false, this);
        return queryFeedPublishStateV2s;
    }
}
