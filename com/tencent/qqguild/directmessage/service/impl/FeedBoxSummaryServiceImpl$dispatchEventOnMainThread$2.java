package com.tencent.qqguild.directmessage.service.impl;

import com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService;
import com.tencent.qqnt.msg.data.FeedsBoxEvent;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2", f = "FeedBoxSummaryServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
public final class FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedsBoxEvent $summary;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedBoxSummaryServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2(FeedBoxSummaryServiceImpl feedBoxSummaryServiceImpl, FeedsBoxEvent feedsBoxEvent, Continuation<? super FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2> continuation) {
        super(2, continuation);
        this.this$0 = feedBoxSummaryServiceImpl;
        this.$summary = feedsBoxEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2 feedBoxSummaryServiceImpl$dispatchEventOnMainThread$2 = new FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2(this.this$0, this.$summary, continuation);
        feedBoxSummaryServiceImpl$dispatchEventOnMainThread$2.L$0 = obj;
        return feedBoxSummaryServiceImpl$dispatchEventOnMainThread$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CopyOnWriteArrayList<IFeedBoxSummaryService.a> copyOnWriteArrayList;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            copyOnWriteArrayList = this.this$0.listeners;
            FeedsBoxEvent feedsBoxEvent = this.$summary;
            for (IFeedBoxSummaryService.a aVar : copyOnWriteArrayList) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    aVar.a(feedsBoxEvent);
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBoxSummaryServiceImpl$dispatchEventOnMainThread$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
