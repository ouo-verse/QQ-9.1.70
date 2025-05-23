package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Map;
import kn1.FeedPublishStateV2;
import kn1.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkn1/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super FeedPublishStateV2>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, FeedEditorEvent.OnStartPublishFeedEvent> $extMap;
    final /* synthetic */ FeedPublishServiceV2Impl $this_run;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1(FeedPublishServiceV2Impl feedPublishServiceV2Impl, Map<String, FeedEditorEvent.OnStartPublishFeedEvent> map, Continuation<? super FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1> continuation) {
        super(2, continuation);
        this.$this_run = feedPublishServiceV2Impl;
        this.$extMap = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1 feedPublishServiceV2Impl$publishEvents$1$beginFlow$1 = new FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1(this.$this_run, this.$extMap, continuation);
        feedPublishServiceV2Impl$publishEvents$1$beginFlow$1.L$0 = obj;
        return feedPublishServiceV2Impl$publishEvents$1$beginFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final FeedPublishServiceV2Impl feedPublishServiceV2Impl = this.$this_run;
            final Map<String, FeedEditorEvent.OnStartPublishFeedEvent> map = this.$extMap;
            feedPublishServiceV2Impl._publishBeginEvent = new Function2<Boolean, GuildTaskProgressState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GuildTaskProgressState guildTaskProgressState) {
                    invoke(bool.booleanValue(), guildTaskProgressState);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull GuildTaskProgressState state) {
                    FeedPublishStateV2 stateV2FromProgressState;
                    Intrinsics.checkNotNullParameter(state, "state");
                    stateV2FromProgressState = FeedPublishServiceV2Impl.this.stateV2FromProgressState(z16, state);
                    if (stateV2FromProgressState != null) {
                        Map<String, FeedEditorEvent.OnStartPublishFeedEvent> map2 = map;
                        GProStFeed stFeed = stateV2FromProgressState.getStFeed();
                        String guildId = state.getGuildId();
                        Intrinsics.checkNotNullExpressionValue(guildId, "state.guildId");
                        String channelId = state.getChannelId();
                        Intrinsics.checkNotNullExpressionValue(channelId, "state.channelId");
                        String f16 = ch.f();
                        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
                        com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.g(stFeed, guildId, channelId, f16);
                        FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent = map2.get(stateV2FromProgressState.getTaskId());
                        c.e(stateV2FromProgressState, onStartPublishFeedEvent != null ? onStartPublishFeedEvent.getTopicIds() : null);
                        FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent2 = map2.get(stateV2FromProgressState.getTaskId());
                        c.d(stateV2FromProgressState, onStartPublishFeedEvent2 != null ? Integer.valueOf(onStartPublishFeedEvent2.getRequestId()) : null);
                        producerScope.mo2003trySendJP2dKIU(stateV2FromProgressState);
                    }
                }
            };
            final FeedPublishServiceV2Impl feedPublishServiceV2Impl2 = this.$this_run;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FeedPublishServiceV2Impl.this._publishBeginEvent = null;
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super FeedPublishStateV2> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedPublishServiceV2Impl$publishEvents$1$beginFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
