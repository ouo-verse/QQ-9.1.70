package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRetryTaskOperationEvent;
import com.tencent.view.FilterEnum;
import kn1.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkn1/a$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {FilterEnum.MIC_PTU_TRANS_ROUHE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a.FeedPublishFinish>, Object> {
    final /* synthetic */ GuildTaskProgressState $progressState;
    int label;
    final /* synthetic */ FeedPublishServiceV2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<a.FeedPublishFinish, Continuation<? super Boolean>, Object> {
        final /* synthetic */ GuildTaskProgressState $progressState;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(GuildTaskProgressState guildTaskProgressState, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progressState = guildTaskProgressState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$progressState, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(Intrinsics.areEqual(((a.FeedPublishFinish) this.L$0).getState().getTaskState().getMainTaskId(), this.$progressState.getMainTaskId()));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull a.FeedPublishFinish feedPublishFinish, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(feedPublishFinish, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1(GuildTaskProgressState guildTaskProgressState, FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1> continuation) {
        super(2, continuation);
        this.$progressState = guildTaskProgressState;
        this.this$0 = feedPublishServiceV2Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1(this.$progressState, this.this$0, continuation);
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
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            GuildRetryTaskOperationEvent guildRetryTaskOperationEvent = new GuildRetryTaskOperationEvent(2, this.$progressState.getMainTaskId());
            guildRetryTaskOperationEvent.showFailToast = false;
            guildRetryTaskOperationEvent.showSuccessToast = false;
            guildRetryTaskOperationEvent.setAutoRetryReportValue(true);
            simpleEventBus.dispatchEvent(guildRetryTaskOperationEvent);
            Flow<a.FeedPublishFinish> publishEndFlow = this.this$0.publishEndFlow();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$progressState, null);
            this.label = 1;
            obj = FlowKt.firstOrNull(publishEndFlow, anonymousClass2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super a.FeedPublishFinish> continuation) {
        return ((FeedPublishServiceV2Impl$activePublishingFeed$5$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
