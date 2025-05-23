package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1", f = "FeedSquareListWorkerDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1 extends SuspendLambda implements Function2<GProNewPostAndSystemPromptNotifyFeedEventData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedSquareListWorkerDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1(FeedSquareListWorkerDelegate feedSquareListWorkerDelegate, Continuation<? super FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1> continuation) {
        super(2, continuation);
        this.this$0 = feedSquareListWorkerDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1 feedSquareListWorkerDelegate$initNewFeedPostDelegate$1 = new FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1(this.this$0, continuation);
        feedSquareListWorkerDelegate$initNewFeedPostDelegate$1.L$0 = obj;
        return feedSquareListWorkerDelegate$initNewFeedPostDelegate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData gProNewPostAndSystemPromptNotifyFeedEventData, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1) create(gProNewPostAndSystemPromptNotifyFeedEventData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.E((GProNewPostAndSystemPromptNotifyFeedEventData) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
