package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.util.Logger;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$publishEvents$1$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$publishEvents$1$2 extends SuspendLambda implements Function2<kn1.a, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedPublishServiceV2Impl$publishEvents$1$2(Continuation<? super FeedPublishServiceV2Impl$publishEvents$1$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedPublishServiceV2Impl$publishEvents$1$2 feedPublishServiceV2Impl$publishEvents$1$2 = new FeedPublishServiceV2Impl$publishEvents$1$2(continuation);
        feedPublishServiceV2Impl$publishEvents$1$2.L$0 = obj;
        return feedPublishServiceV2Impl$publishEvents$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            kn1.a aVar = (kn1.a) this.L$0;
            if ((aVar instanceof a.FeedPublishBegin) || (aVar instanceof a.FeedPublishFinish)) {
                Logger.f235387a.d().i("FeedPublishServiceV2Impl", 1, "flowCenter: " + aVar);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull kn1.a aVar, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedPublishServiceV2Impl$publishEvents$1$2) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
