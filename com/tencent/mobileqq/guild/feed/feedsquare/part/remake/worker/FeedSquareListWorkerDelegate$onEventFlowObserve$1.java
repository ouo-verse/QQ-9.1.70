package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareChannelDeleteEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/event/GuildFeedSquareChannelDeleteEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onEventFlowObserve$1", f = "FeedSquareListWorkerDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedSquareListWorkerDelegate$onEventFlowObserve$1 extends SuspendLambda implements Function2<GuildFeedSquareChannelDeleteEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedSquareListWorkerDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSquareListWorkerDelegate$onEventFlowObserve$1(FeedSquareListWorkerDelegate feedSquareListWorkerDelegate, Continuation<? super FeedSquareListWorkerDelegate$onEventFlowObserve$1> continuation) {
        super(2, continuation);
        this.this$0 = feedSquareListWorkerDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedSquareListWorkerDelegate$onEventFlowObserve$1 feedSquareListWorkerDelegate$onEventFlowObserve$1 = new FeedSquareListWorkerDelegate$onEventFlowObserve$1(this.this$0, continuation);
        feedSquareListWorkerDelegate$onEventFlowObserve$1.L$0 = obj;
        return feedSquareListWorkerDelegate$onEventFlowObserve$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GuildFeedSquareChannelDeleteEvent guildFeedSquareChannelDeleteEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSquareListWorkerDelegate$onEventFlowObserve$1) create(guildFeedSquareChannelDeleteEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.F((GuildFeedSquareChannelDeleteEvent) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
