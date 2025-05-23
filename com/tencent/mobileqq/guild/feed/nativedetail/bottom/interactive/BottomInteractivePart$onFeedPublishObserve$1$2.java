package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive;

import kn1.a;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$b;", "publishState", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$onFeedPublishObserve$1$2", f = "BottomInteractivePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class BottomInteractivePart$onFeedPublishObserve$1$2 extends SuspendLambda implements Function2<a.FeedPublishFinish, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BottomInteractivePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomInteractivePart$onFeedPublishObserve$1$2(BottomInteractivePart bottomInteractivePart, Continuation<? super BottomInteractivePart$onFeedPublishObserve$1$2> continuation) {
        super(2, continuation);
        this.this$0 = bottomInteractivePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BottomInteractivePart$onFeedPublishObserve$1$2 bottomInteractivePart$onFeedPublishObserve$1$2 = new BottomInteractivePart$onFeedPublishObserve$1$2(this.this$0, continuation);
        bottomInteractivePart$onFeedPublishObserve$1$2.L$0 = obj;
        return bottomInteractivePart$onFeedPublishObserve$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.F9().u1(kn1.c.c(((a.FeedPublishFinish) this.L$0).getState().getTaskState()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a.FeedPublishFinish feedPublishFinish, @Nullable Continuation<? super Unit> continuation) {
        return ((BottomInteractivePart$onFeedPublishObserve$1$2) create(feedPublishFinish, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
