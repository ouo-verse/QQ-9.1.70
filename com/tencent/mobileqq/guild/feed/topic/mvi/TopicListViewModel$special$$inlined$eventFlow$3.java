package com.tencent.mobileqq.guild.feed.topic.mvi;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {"Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.event.bus.SimpleEventBusExtKt$eventFlow$1", f = "SimpleEventBusExt.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class TopicListViewModel$special$$inlined$eventFlow$3 extends SuspendLambda implements Function2<ProducerScope<? super GuildFeedDeleteEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleEventBus $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007`\bH\u0016R0\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/mvi/TopicListViewModel$special$$inlined$eventFlow$3$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Ljava/util/ArrayList;", "eventClz", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements SimpleEventReceiver<GuildFeedDeleteEvent> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Class<GuildFeedDeleteEvent>> eventClz;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ProducerScope<GuildFeedDeleteEvent> f223615e;

        public a(ProducerScope producerScope) {
            ArrayList<Class<GuildFeedDeleteEvent>> arrayListOf;
            this.f223615e = producerScope;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedDeleteEvent.class);
            this.eventClz = arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<GuildFeedDeleteEvent>> getEventClass() {
            return this.eventClz;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (!(event instanceof GuildFeedDeleteEvent)) {
                event = null;
            }
            GuildFeedDeleteEvent guildFeedDeleteEvent = (GuildFeedDeleteEvent) event;
            if (guildFeedDeleteEvent != null) {
                this.f223615e.mo2003trySendJP2dKIU(guildFeedDeleteEvent);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicListViewModel$special$$inlined$eventFlow$3(SimpleEventBus simpleEventBus, Continuation continuation) {
        super(2, continuation);
        this.$this_eventFlow = simpleEventBus;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TopicListViewModel$special$$inlined$eventFlow$3 topicListViewModel$special$$inlined$eventFlow$3 = new TopicListViewModel$special$$inlined$eventFlow$3(this.$this_eventFlow, continuation);
        topicListViewModel$special$$inlined$eventFlow$3.L$0 = obj;
        return topicListViewModel$special$$inlined$eventFlow$3;
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
            this.$this_eventFlow.registerReceiver(aVar);
            final SimpleEventBus simpleEventBus = this.$this_eventFlow;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$eventFlow$3.2
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
                    SimpleEventBus.this.unRegisterReceiver(aVar);
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
    public final Object invoke(@NotNull ProducerScope<? super GuildFeedDeleteEvent> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TopicListViewModel$special$$inlined$eventFlow$3) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
