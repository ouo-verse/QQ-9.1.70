package com.tencent.mobileqq.guild.feed.detail.guidebar;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.detail.guidebar.FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1", f = "FeedDetailWebPageGuideBarDependencyImpl.kt", i = {0}, l = {141, 142}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
/* loaded from: classes13.dex */
final class FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1 extends SuspendLambda implements Function2<ProducerScope<? super GuideBarGuildInfo>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedDetailWebPageGuideBarDependencyImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1(FeedDetailWebPageGuideBarDependencyImpl feedDetailWebPageGuideBarDependencyImpl, Continuation<? super FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1> continuation) {
        super(2, continuation);
        this.this$0 = feedDetailWebPageGuideBarDependencyImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1 feedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1 = new FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1(this.this$0, continuation);
        feedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1.L$0 = obj;
        return feedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ProducerScope producerScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            FeedDetailWebPageGuideBarDependencyImpl feedDetailWebPageGuideBarDependencyImpl = this.this$0;
            this.L$0 = producerScope;
            this.label = 1;
            obj = feedDetailWebPageGuideBarDependencyImpl.o(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuideBarGuildInfo guideBarGuildInfo = (GuideBarGuildInfo) obj;
        if (guideBarGuildInfo != null) {
            ChannelResult.m2008boximpl(producerScope.mo2003trySendJP2dKIU(guideBarGuildInfo));
        }
        AnonymousClass2 anonymousClass2 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.detail.guidebar.FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.L$0 = null;
        this.label = 2;
        if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super GuideBarGuildInfo> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
