package com.tencent.mobileqq.guild.feed.topic.part;

import com.tencent.mobileqq.guild.feed.topic.TopicFeedsReloadEvent;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicFeedsReloadEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart$onInitView$2", f = "TopicListReservePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class TopicListReservePart$onInitView$2 extends SuspendLambda implements Function2<TopicFeedsReloadEvent, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TopicListReservePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicListReservePart$onInitView$2(TopicListReservePart topicListReservePart, Continuation<? super TopicListReservePart$onInitView$2> continuation) {
        super(2, continuation);
        this.this$0 = topicListReservePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicListReservePart$onInitView$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull TopicFeedsReloadEvent topicFeedsReloadEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((TopicListReservePart$onInitView$2) create(topicFeedsReloadEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.E9().Z1(com.tencent.mobileqq.guild.feed.topic.mvi.m.f223665a);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
