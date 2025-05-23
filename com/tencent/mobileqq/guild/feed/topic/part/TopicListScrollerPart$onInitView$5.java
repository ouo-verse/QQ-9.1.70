package com.tencent.mobileqq.guild.feed.topic.part;

import com.tencent.mobileqq.guild.feed.topic.mvi.TopicFeedsLordMoreIntent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.part.TopicListScrollerPart$onInitView$5", f = "TopicListScrollerPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class TopicListScrollerPart$onInitView$5 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TopicListScrollerPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicListScrollerPart$onInitView$5(TopicListScrollerPart topicListScrollerPart, Continuation<? super TopicListScrollerPart$onInitView$5> continuation) {
        super(2, continuation);
        this.this$0 = topicListScrollerPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicListScrollerPart$onInitView$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Integer, ? extends Integer> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<Integer, Integer>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.E9().Z1(new TopicFeedsLordMoreIntent("scrolled"));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<Integer, Integer> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((TopicListScrollerPart$onInitView$5) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
