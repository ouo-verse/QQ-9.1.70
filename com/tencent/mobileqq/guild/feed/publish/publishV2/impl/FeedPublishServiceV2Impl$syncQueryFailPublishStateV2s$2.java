package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import java.util.List;
import kn1.FeedPublishStateV2;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lkn1/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends FeedPublishStateV2>>, Object> {
    final /* synthetic */ String $channel;
    final /* synthetic */ String $guild;
    int label;
    final /* synthetic */ FeedPublishServiceV2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2(FeedPublishServiceV2Impl feedPublishServiceV2Impl, String str, String str2, Continuation<? super FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2> continuation) {
        super(2, continuation);
        this.this$0 = feedPublishServiceV2Impl;
        this.$guild = str;
        this.$channel = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2(this.this$0, this.$guild, this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends FeedPublishStateV2>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<FeedPublishStateV2>>) continuation);
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
            FeedPublishServiceV2Impl feedPublishServiceV2Impl = this.this$0;
            String str = this.$guild;
            String str2 = this.$channel;
            this.label = 1;
            obj = feedPublishServiceV2Impl.queryFeedPublishStateV2s(str, str2, false, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<FeedPublishStateV2>> continuation) {
        return ((FeedPublishServiceV2Impl$syncQueryFailPublishStateV2s$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
