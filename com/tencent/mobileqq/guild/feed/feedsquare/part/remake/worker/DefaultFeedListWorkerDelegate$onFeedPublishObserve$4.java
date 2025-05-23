package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate$onFeedPublishObserve$4", f = "DefaultFeedListWorkerDelegate.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class DefaultFeedListWorkerDelegate$onFeedPublishObserve$4 extends SuspendLambda implements Function2<a.FeedPublishFinish, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultFeedListWorkerDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFeedListWorkerDelegate$onFeedPublishObserve$4(DefaultFeedListWorkerDelegate defaultFeedListWorkerDelegate, Continuation<? super DefaultFeedListWorkerDelegate$onFeedPublishObserve$4> continuation) {
        super(2, continuation);
        this.this$0 = defaultFeedListWorkerDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DefaultFeedListWorkerDelegate$onFeedPublishObserve$4 defaultFeedListWorkerDelegate$onFeedPublishObserve$4 = new DefaultFeedListWorkerDelegate$onFeedPublishObserve$4(this.this$0, continuation);
        defaultFeedListWorkerDelegate$onFeedPublishObserve$4.L$0 = obj;
        return defaultFeedListWorkerDelegate$onFeedPublishObserve$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object o16;
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
            a.FeedPublishFinish feedPublishFinish = (a.FeedPublishFinish) this.L$0;
            DefaultFeedListWorkerDelegate defaultFeedListWorkerDelegate = this.this$0;
            this.label = 1;
            o16 = defaultFeedListWorkerDelegate.o(feedPublishFinish, this);
            if (o16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a.FeedPublishFinish feedPublishFinish, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultFeedListWorkerDelegate$onFeedPublishObserve$4) create(feedPublishFinish, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
