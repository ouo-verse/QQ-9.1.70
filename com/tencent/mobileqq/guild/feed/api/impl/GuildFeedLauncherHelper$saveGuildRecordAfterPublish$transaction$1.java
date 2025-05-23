package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.api.IGuildTransaction;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.util.ae;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1", "Lcom/tencent/mobileqq/guild/api/IGuildTransaction;", "", "onRemoved", TencentLocation.RUN_MODE, "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "e", "I", "getId", "()I", "id", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 implements IGuildTransaction {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(ae.a().e()));

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f218034f;
    final /* synthetic */ GuildFeedLauncherHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1(int i3, String str, GuildFeedLauncherHelper guildFeedLauncherHelper) {
        this.f218034f = str;
        this.this$0 = guildFeedLauncherHelper;
        this.id = i3;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTransaction
    public int getId() {
        return this.id;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTransaction
    public void onRemoved() {
        CoroutineScopeKt.cancel$default(this.coroutineScope, "onRemoved", null, 2, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        final Flow callbackFlow = FlowKt.callbackFlow(new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$eventFlow$1(simpleEventBus, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<FeedEditorEvent.OnStartPublishFeedEvent>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<FeedEditorEvent.OnStartPublishFeedEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f218024d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 f218025e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$1$2", f = "GuildShareToFeedApiImpl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1) {
                    this.f218024d = flowCollector;
                    this.f218025e = guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean z16;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f218024d;
                                if (onStartPublishFeedEvent.getRequestId() == this.f218025e.getId()) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(onStartPublishFeedEvent, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super FeedEditorEvent.OnStartPublishFeedEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2(this.f218034f, this.this$0, null)), this.coroutineScope);
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        final Flow callbackFlow2 = FlowKt.callbackFlow(new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$eventFlow$2(simpleEventBus2, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<FeedEditorEvent.OnFeedEditorClosedEvent>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<FeedEditorEvent.OnFeedEditorClosedEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f218028d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 f218029e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$2$2", f = "GuildShareToFeedApiImpl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$$inlined$filter$2$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1) {
                    this.f218028d = flowCollector;
                    this.f218029e = guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(FeedEditorEvent.OnFeedEditorClosedEvent onFeedEditorClosedEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean z16;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f218028d;
                                if (onFeedEditorClosedEvent.getRequestId() == this.f218029e.getId()) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(onFeedEditorClosedEvent, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super FeedEditorEvent.OnFeedEditorClosedEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4(this, this.this$0, null)), this.coroutineScope);
    }
}
