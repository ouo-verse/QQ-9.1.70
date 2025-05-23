package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$1$1", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$publishEvents$1$1 extends SuspendLambda implements Function2<kn1.a, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedPublishServiceV2Impl $this_run;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$publishEvents$1$1(FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super FeedPublishServiceV2Impl$publishEvents$1$1> continuation) {
        super(2, continuation);
        this.$this_run = feedPublishServiceV2Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedPublishServiceV2Impl$publishEvents$1$1 feedPublishServiceV2Impl$publishEvents$1$1 = new FeedPublishServiceV2Impl$publishEvents$1$1(this.$this_run, continuation);
        feedPublishServiceV2Impl$publishEvents$1$1.L$0 = obj;
        return feedPublishServiceV2Impl$publishEvents$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            kn1.a aVar = (kn1.a) this.L$0;
            FeedPublishServiceV2Impl feedPublishServiceV2Impl = this.$this_run;
            String guildId = aVar.getState().getTaskState().getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "it.state.taskState.guildId");
            String channelId = aVar.getState().getTaskState().getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "it.state.taskState.channelId");
            feedPublishServiceV2Impl.invalidateCache(guildId, channelId);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull kn1.a aVar, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedPublishServiceV2Impl$publishEvents$1$1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
