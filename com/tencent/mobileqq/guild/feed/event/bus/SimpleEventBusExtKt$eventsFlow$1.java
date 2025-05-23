package com.tencent.mobileqq.guild.feed.event.bus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import java.util.ArrayList;
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
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.event.bus.SimpleEventBusExtKt$eventsFlow$1", f = "SimpleEventBusExt.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class SimpleEventBusExtKt$eventsFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super SimpleBaseEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<Class<? extends SimpleBaseEvent>> $events;
    final /* synthetic */ SimpleEventBus $this_eventsFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007`\bH\u0016R6\u0010\u000e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/event/bus/SimpleEventBusExtKt$eventsFlow$1$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Ljava/util/ArrayList;", "getEventClz$annotations", "()V", "eventClz", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements SimpleEventReceiver<SimpleBaseEvent> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Class<SimpleBaseEvent>> eventClz;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ProducerScope<SimpleBaseEvent> f218573e;

        /* JADX WARN: Multi-variable type inference failed */
        a(ArrayList<Class<? extends SimpleBaseEvent>> arrayList, ProducerScope<? super SimpleBaseEvent> producerScope) {
            this.f218573e = producerScope;
            Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
            this.eventClz = arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            return this.eventClz;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event != null) {
                ChannelResult.m2008boximpl(this.f218573e.mo2003trySendJP2dKIU(event));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleEventBusExtKt$eventsFlow$1(SimpleEventBus simpleEventBus, ArrayList<Class<? extends SimpleBaseEvent>> arrayList, Continuation<? super SimpleEventBusExtKt$eventsFlow$1> continuation) {
        super(2, continuation);
        this.$this_eventsFlow = simpleEventBus;
        this.$events = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SimpleEventBusExtKt$eventsFlow$1 simpleEventBusExtKt$eventsFlow$1 = new SimpleEventBusExtKt$eventsFlow$1(this.$this_eventsFlow, this.$events, continuation);
        simpleEventBusExtKt$eventsFlow$1.L$0 = obj;
        return simpleEventBusExtKt$eventsFlow$1;
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
            final a aVar = new a(this.$events, producerScope);
            this.$this_eventsFlow.registerReceiver(aVar);
            final SimpleEventBus simpleEventBus = this.$this_eventsFlow;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.event.bus.SimpleEventBusExtKt$eventsFlow$1.1
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
    public final Object invoke(@NotNull ProducerScope<? super SimpleBaseEvent> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SimpleEventBusExtKt$eventsFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
