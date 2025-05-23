package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDeleteEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$onCreate$1", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$onCreate$1 extends SuspendLambda implements Function2<GuildFeedDeleteEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedPublishServiceV2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$onCreate$1(FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super FeedPublishServiceV2Impl$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = feedPublishServiceV2Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedPublishServiceV2Impl$onCreate$1 feedPublishServiceV2Impl$onCreate$1 = new FeedPublishServiceV2Impl$onCreate$1(this.this$0, continuation);
        feedPublishServiceV2Impl$onCreate$1.L$0 = obj;
        return feedPublishServiceV2Impl$onCreate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GuildFeedDeleteEvent guildFeedDeleteEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedPublishServiceV2Impl$onCreate$1) create(guildFeedDeleteEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuildFeedDeleteEvent guildFeedDeleteEvent = (GuildFeedDeleteEvent) this.L$0;
            FeedPublishServiceV2Impl.Holder.f223068a.b();
            FeedPublishServiceV2Impl feedPublishServiceV2Impl = this.this$0;
            String guildId = guildFeedDeleteEvent.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "event.guildId");
            String channelId = guildFeedDeleteEvent.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "event.channelId");
            feedPublishServiceV2Impl.invalidateCache(guildId, channelId);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
