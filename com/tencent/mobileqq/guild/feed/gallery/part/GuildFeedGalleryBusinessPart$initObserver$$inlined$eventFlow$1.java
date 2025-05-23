package com.tencent.mobileqq.guild.feed.gallery.part;

import com.tencent.mobileqq.guild.feed.gallery.msgintent.FeedPublishFinishMsgResult;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {"Lcom/tencent/mvi/base/route/MsgIntent;", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.IVMessengerKtKt$eventFlow$1", f = "IVMessengerKt.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super FeedPublishFinishMsgResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mvi.base.route.j $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProducerScope<FeedPublishFinishMsgResult> f219657d;

        public a(ProducerScope producerScope) {
            this.f219657d = producerScope;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof FeedPublishFinishMsgResult) {
                this.f219657d.mo2003trySendJP2dKIU(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1(com.tencent.mvi.base.route.j jVar, Continuation continuation) {
        super(2, continuation);
        this.$this_eventFlow = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1 guildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1 = new GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1(this.$this_eventFlow, continuation);
        guildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1.L$0 = obj;
        return guildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1;
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
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final a aVar = new a(producerScope);
            com.tencent.mvi.base.route.j jVar = this.$this_eventFlow;
            String b16 = com.tencent.mvi.base.route.c.b(FeedPublishFinishMsgResult.class);
            Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
            jVar.d(b16, aVar);
            final com.tencent.mvi.base.route.j jVar2 = this.$this_eventFlow;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.mvi.base.route.j jVar3 = com.tencent.mvi.base.route.j.this;
                    String b17 = com.tencent.mvi.base.route.c.b(FeedPublishFinishMsgResult.class);
                    Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
                    jVar3.b(b17, aVar);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super FeedPublishFinishMsgResult> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedGalleryBusinessPart$initObserver$$inlined$eventFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
