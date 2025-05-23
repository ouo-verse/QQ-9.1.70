package com.tencent.mobileqq.guild.feed.topic.mvi;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.detail.event.CommentStatusEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.mvi.BaseViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.guild.feed.topic.TopicContextKt;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedPublishEvent;
import com.tencent.mobileqq.guild.feed.topic.mvi.i;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn1.TopicDataExt;
import xn1.InsertFeedArgs;
import xn1.ModifyFeedArgs;
import xn1.ModifyFeedArgsV2;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0015H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0014R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicListViewModel;", "Lcom/tencent/mobileqq/guild/feed/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/n;", "", "v2", "Lkn1/b;", "state", "", ICustomDataEditor.NUMBER_PARAM_2, "Lkn1/a$a;", "event", "p2", "(Lkn1/a$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkn1/a$b;", "q2", "(Lkn1/a$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDeleteEvent;", "u2", "Lcom/tencent/mobileqq/guild/feed/detail/event/CommentStatusEvent;", "t2", "Lcom/tencent/mobileqq/guild/feed/event/GuildDetailViewDestroyEvent;", "w2", "i", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/h;", "change", "r2", "replayState", "o2", ICustomDataEditor.STRING_PARAM_2, "", "D", "Ljava/lang/String;", "topicGuildId", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/c;", "E", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/c;", "repo", "", UserInfo.SEX_FEMALE, "J", "topicID", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "G", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", ISchemeApi.KEY_PAGE_DATA, "H", "topicName", "Lcom/tencent/mobileqq/guild/feed/topic/d;", SessionDbHelper.SESSION_ID, "<init>", "(Lcom/tencent/mobileqq/guild/feed/topic/d;)V", "I", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicListViewModel extends BaseViewModel<FeedListState, n> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String topicGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c repo;

    /* renamed from: F, reason: from kotlin metadata */
    private final long topicID;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final PageData pageData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String topicName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildDetailViewDestroyEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$2", f = "TopicListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<GuildDetailViewDestroyEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull GuildDetailViewDestroyEvent guildDetailViewDestroyEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(guildDetailViewDestroyEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TopicListViewModel.this.w2((GuildDetailViewDestroyEvent) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/event/CommentStatusEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$4", f = "TopicListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$4, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CommentStatusEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CommentStatusEvent commentStatusEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(commentStatusEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TopicListViewModel.this.t2((CommentStatusEvent) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDeleteEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$6", f = "TopicListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$6, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<GuildFeedDeleteEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull GuildFeedDeleteEvent guildFeedDeleteEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(guildFeedDeleteEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TopicListViewModel.this.u2((GuildFeedDeleteEvent) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TopicListViewModel(@NotNull com.tencent.mobileqq.guild.feed.topic.d session) {
        Intrinsics.checkNotNullParameter(session, "session");
        String guildId = session.getGuildId();
        this.topicGuildId = guildId;
        this.repo = TopicContextKt.e(session);
        this.topicID = session.getTopicId();
        this.pageData = session.getF223518b();
        this.topicName = session.getTopicNameRef();
        Z1(m.f223665a);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        final Flow callbackFlow = FlowKt.callbackFlow(new TopicListViewModel$special$$inlined$eventFlow$1(simpleEventBus, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<GuildDetailViewDestroyEvent>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildDetailViewDestroyEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223618d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicListViewModel f223619e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$1$2", f = "TopicListViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, TopicListViewModel topicListViewModel) {
                    this.f223618d = flowCollector;
                    this.f223619e = topicListViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildDetailViewDestroyEvent guildDetailViewDestroyEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
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
                                FlowCollector flowCollector = this.f223618d;
                                GuildDetailViewDestroyEvent guildDetailViewDestroyEvent2 = guildDetailViewDestroyEvent;
                                List<vn1.b> b16 = this.f223619e.R1().c().b();
                                boolean z16 = false;
                                if (!(b16 instanceof Collection) || !b16.isEmpty()) {
                                    Iterator<T> it = b16.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        if (Intrinsics.areEqual(((vn1.b) it.next()).d().getFeedId(), guildDetailViewDestroyEvent2.getFeedId())) {
                                            z16 = true;
                                            break;
                                        }
                                    }
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(guildDetailViewDestroyEvent, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super GuildDetailViewDestroyEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new AnonymousClass2(null)), ViewModelKt.getViewModelScope(this));
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        final Flow callbackFlow2 = FlowKt.callbackFlow(new TopicListViewModel$special$$inlined$eventFlow$2(simpleEventBus2, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<CommentStatusEvent>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<CommentStatusEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223622d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicListViewModel f223623e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$2$2", f = "TopicListViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, TopicListViewModel topicListViewModel) {
                    this.f223622d = flowCollector;
                    this.f223623e = topicListViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(CommentStatusEvent commentStatusEvent, @NotNull Continuation continuation) {
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
                                FlowCollector flowCollector = this.f223622d;
                                CommentStatusEvent commentStatusEvent2 = commentStatusEvent;
                                boolean z17 = false;
                                if (commentStatusEvent2.getStatus() == 2) {
                                    List<vn1.b> b16 = this.f223623e.R1().c().b();
                                    if (!(b16 instanceof Collection) || !b16.isEmpty()) {
                                        Iterator<T> it = b16.iterator();
                                        while (it.hasNext()) {
                                            if (Intrinsics.areEqual(((vn1.b) it.next()).d().getFeedId(), commentStatusEvent2.getFeedId())) {
                                                z16 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z16 = false;
                                    if (z16) {
                                        z17 = true;
                                    }
                                }
                                if (z17) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(commentStatusEvent, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super CommentStatusEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new AnonymousClass4(null)), ViewModelKt.getViewModelScope(this));
        SimpleEventBus simpleEventBus3 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus3, "getInstance()");
        final Flow callbackFlow3 = FlowKt.callbackFlow(new TopicListViewModel$special$$inlined$eventFlow$3(simpleEventBus3, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<GuildFeedDeleteEvent>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$3

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$3$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildFeedDeleteEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223626d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicListViewModel f223627e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$3$2", f = "TopicListViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$special$$inlined$filter$3$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, TopicListViewModel topicListViewModel) {
                    this.f223626d = flowCollector;
                    this.f223627e = topicListViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildFeedDeleteEvent guildFeedDeleteEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
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
                                FlowCollector flowCollector = this.f223626d;
                                GuildFeedDeleteEvent guildFeedDeleteEvent2 = guildFeedDeleteEvent;
                                List<vn1.b> b16 = this.f223627e.R1().c().b();
                                boolean z16 = false;
                                if (!(b16 instanceof Collection) || !b16.isEmpty()) {
                                    Iterator<T> it = b16.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        if (Intrinsics.areEqual(((vn1.b) it.next()).d().getFeedId(), guildFeedDeleteEvent2.getFeedId())) {
                                            z16 = true;
                                            break;
                                        }
                                    }
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(guildFeedDeleteEvent, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super GuildFeedDeleteEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new AnonymousClass6(null)), ViewModelKt.getViewModelScope(this));
        v2();
        if (!ch.j0(guildId)) {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).getSimpleProfile(guildId, ch.f(), 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n2(FeedPublishStateV2 state) {
        if (!Intrinsics.areEqual(String.valueOf(state.getStFeed().channelInfo.sign.guildId), this.topicGuildId)) {
            return false;
        }
        xn1.e eVar = xn1.e.f448187a;
        ArrayList<GProStRichTextContent> arrayList = state.getStFeed().contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "state.stFeed.contents.contents");
        if (eVar.d(arrayList, this.topicName) || !state.getIsNewFeed()) {
            return true;
        }
        Logger.f235387a.d().i("GTopic_LIST_VM", 1, "filterPublishFeed isNotRelated topicID:" + this.topicID + " topicName:" + this.topicName);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p2(final a.FeedPublishBegin feedPublishBegin, Continuation<? super Unit> continuation) {
        Logger.f235387a.d().i("GTopic_LIST_VM", 1, "handlePublishBegin event: stFeed idd:" + feedPublishBegin.getState().getStFeed().idd + " isNewFeed:" + feedPublishBegin.getState().getIsNewFeed() + " isEdit:" + feedPublishBegin.getState().getTaskState().isEdit() + " taskState:" + feedPublishBegin.getState().getTaskState());
        if (!feedPublishBegin.getState().getIsNewFeed()) {
            a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishBegin$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final FeedListState invoke(@NotNull FeedListState oldState) {
                    Intrinsics.checkNotNullParameter(oldState, "oldState");
                    xn1.e eVar = xn1.e.f448187a;
                    ArrayList<GProStRichTextContent> arrayList = a.FeedPublishBegin.this.getState().getStFeed().contents.contents;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "event.state.stFeed.contents.contents");
                    if (!eVar.d(arrayList, this.topicName)) {
                        Logger logger = Logger.f235387a;
                        TopicListViewModel topicListViewModel = this;
                        logger.d().i("GTopic_LIST_VM", 1, "filterPublishFeed isNotRelated topicID:" + topicListViewModel.topicID + " topicName:" + topicListViewModel.topicName + " remove");
                        List<vn1.b> b16 = oldState.c().b();
                        a.FeedPublishBegin feedPublishBegin2 = a.FeedPublishBegin.this;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : b16) {
                            if (!Intrinsics.areEqual(((vn1.b) obj).d().getFeedId(), feedPublishBegin2.getState().getStFeed().idd)) {
                                arrayList2.add(obj);
                            }
                        }
                        return FeedListState.b(oldState, null, false, new com.tencent.mobileqq.guild.feed.topic.h(arrayList2), false, 0, false, 59, null);
                    }
                    final a.FeedPublishBegin feedPublishBegin3 = a.FeedPublishBegin.this;
                    Function1<vn1.b, Boolean> function1 = new Function1<vn1.b, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishBegin$3.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(Intrinsics.areEqual(it.d().getFeedId(), a.FeedPublishBegin.this.getState().getStFeed().idd));
                        }
                    };
                    final a.FeedPublishBegin feedPublishBegin4 = a.FeedPublishBegin.this;
                    return xn1.a.c(oldState, new ModifyFeedArgsV2(function1, new Function1<vn1.b, vn1.b>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishBegin$3.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final vn1.b invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            vn1.b s16 = xn1.e.f448187a.s(it, a.FeedPublishBegin.this.getState().getTaskState());
                            a.FeedPublishBegin feedPublishBegin5 = a.FeedPublishBegin.this;
                            Object a16 = s16.d().a();
                            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
                            com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.m((GProStFeed) a16, feedPublishBegin5.getState().getStFeed());
                            return s16;
                        }
                    }));
                }
            });
        } else {
            a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishBegin$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final FeedListState invoke(@NotNull FeedListState oldState) {
                    PageData pageData;
                    List listOf;
                    Intrinsics.checkNotNullParameter(oldState, "oldState");
                    xn1.e eVar = xn1.e.f448187a;
                    GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(a.FeedPublishBegin.this.getState().getStFeed(), null, 2, 0 == true ? 1 : 0);
                    pageData = this.pageData;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(xn1.e.p(eVar, gProStFeedDetailRspWrapper, new TopicDataExt(pageData, this.topicID, ""), 0L, a.FeedPublishBegin.this.getState().getTaskState(), 4, null));
                    final a.FeedPublishBegin feedPublishBegin2 = a.FeedPublishBegin.this;
                    return xn1.a.a(oldState, listOf, new InsertFeedArgs(0, true, 0, new Function1<vn1.b, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishBegin$4.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(Intrinsics.areEqual(it.d().getFeedId(), a.FeedPublishBegin.this.getState().getStFeed().idd));
                        }
                    }, 4, null));
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q2(final a.FeedPublishFinish feedPublishFinish, Continuation<? super Unit> continuation) {
        final boolean isEdit = feedPublishFinish.getState().getTaskState().isEdit();
        Logger.f235387a.d().i("GTopic_LIST_VM", 1, "handlePublishEnd event: stFeed idd:" + feedPublishFinish.getState().getStFeed().idd + " isEdit:" + isEdit + " taskState:" + feedPublishFinish.getState().getTaskState());
        if (kn1.c.c(feedPublishFinish.getState().getTaskState())) {
            a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishEnd$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final FeedListState invoke(@NotNull FeedListState oldState) {
                    PageData pageData;
                    Intrinsics.checkNotNullParameter(oldState, "oldState");
                    xn1.e eVar = xn1.e.f448187a;
                    GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(a.FeedPublishFinish.this.getState().getStFeed(), null, 2, 0 == true ? 1 : 0);
                    pageData = this.pageData;
                    vn1.b p16 = xn1.e.p(eVar, gProStFeedDetailRspWrapper, new TopicDataExt(pageData, this.topicID, ""), 0L, a.FeedPublishFinish.this.getState().getTaskState(), 4, null);
                    final a.FeedPublishFinish feedPublishFinish2 = a.FeedPublishFinish.this;
                    Function1<vn1.b, Boolean> function1 = new Function1<vn1.b, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishEnd$3.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            GuildTaskProgressState taskProgressState = it.getTaskProgressState();
                            return Boolean.valueOf(Intrinsics.areEqual(taskProgressState != null ? taskProgressState.mTaskId : null, a.FeedPublishFinish.this.getState().getTaskState().mTaskId));
                        }
                    };
                    final a.FeedPublishFinish feedPublishFinish3 = a.FeedPublishFinish.this;
                    return xn1.a.b(oldState, p16, new ModifyFeedArgs(function1, new Function1<vn1.b, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishEnd$3.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(Intrinsics.areEqual(it.d().getFeedId(), a.FeedPublishFinish.this.getState().getStFeed().idd));
                        }
                    }, !isEdit));
                }
            });
            SimpleEventBus.getInstance().dispatchEvent(new TopicFeedPublishEvent(this.topicID));
        } else {
            a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishEnd$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final FeedListState invoke(@NotNull FeedListState oldState) {
                    Intrinsics.checkNotNullParameter(oldState, "oldState");
                    final a.FeedPublishFinish feedPublishFinish2 = a.FeedPublishFinish.this;
                    Function1<vn1.b, Boolean> function1 = new Function1<vn1.b, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishEnd$4.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            GuildTaskProgressState taskProgressState = it.getTaskProgressState();
                            return Boolean.valueOf(Intrinsics.areEqual(taskProgressState != null ? taskProgressState.mTaskId : null, a.FeedPublishFinish.this.getState().getTaskState().mTaskId));
                        }
                    };
                    final a.FeedPublishFinish feedPublishFinish3 = a.FeedPublishFinish.this;
                    return xn1.a.c(oldState, new ModifyFeedArgsV2(function1, new Function1<vn1.b, vn1.b>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handlePublishEnd$4.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final vn1.b invoke(@NotNull vn1.b it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return xn1.e.f448187a.s(it, a.FeedPublishFinish.this.getState().getTaskState());
                        }
                    }));
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final void r2(n i3, h change) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TopicListViewModel$handleRepoReq$1(change, this, i3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2(final CommentStatusEvent event) {
        a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onCommentEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FeedListState invoke(@NotNull FeedListState oldState) {
                Intrinsics.checkNotNullParameter(oldState, "oldState");
                List<vn1.b> b16 = oldState.c().b();
                CommentStatusEvent commentStatusEvent = CommentStatusEvent.this;
                ArrayList arrayList = new ArrayList();
                for (vn1.b bVar : b16) {
                    if (Intrinsics.areEqual(commentStatusEvent.getFeedId(), bVar.d().getFeedId())) {
                        bVar = xn1.e.f448187a.r(bVar);
                    }
                    if (bVar != null) {
                        arrayList.add(bVar);
                    }
                }
                return FeedListState.b(oldState, null, false, new com.tencent.mobileqq.guild.feed.topic.h(arrayList), false, 0, false, 59, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(final GuildFeedDeleteEvent event) {
        a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedDeleteEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FeedListState invoke(@NotNull FeedListState oldState) {
                Intrinsics.checkNotNullParameter(oldState, "oldState");
                List<vn1.b> b16 = oldState.c().b();
                GuildFeedDeleteEvent guildFeedDeleteEvent = GuildFeedDeleteEvent.this;
                ArrayList arrayList = new ArrayList();
                for (vn1.b bVar : b16) {
                    if (!(!Intrinsics.areEqual(bVar.d().getFeedId(), guildFeedDeleteEvent.getFeedId()))) {
                        bVar = null;
                    }
                    if (bVar != null) {
                        arrayList.add(bVar);
                    }
                }
                return FeedListState.b(oldState, null, false, new com.tencent.mobileqq.guild.feed.topic.h(arrayList), false, 0, false, 59, null);
            }
        });
        SimpleEventBus.getInstance().dispatchEvent(new TopicFeedDeleteEvent(this.topicID));
    }

    private final void v2() {
        final Flow<a.FeedPublishBegin> publishBeginFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishBeginFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishBegin>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishBegin> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223604d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicListViewModel f223605e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$1$2", f = "TopicListViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, TopicListViewModel topicListViewModel) {
                    this.f223604d = flowCollector;
                    this.f223605e = topicListViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishBegin feedPublishBegin, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean n26;
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
                                FlowCollector flowCollector = this.f223604d;
                                n26 = this.f223605e.n2(feedPublishBegin.getState());
                                if (n26) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishBegin, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishBegin> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new TopicListViewModel$onFeedPublishObserve$2(this, null)), ViewModelKt.getViewModelScope(this));
        final Flow<a.FeedPublishFinish> publishEndFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishEndFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishFinish> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223608d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicListViewModel f223609e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$2$2", f = "TopicListViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedPublishObserve$$inlined$filter$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, TopicListViewModel topicListViewModel) {
                    this.f223608d = flowCollector;
                    this.f223609e = topicListViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishFinish feedPublishFinish, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean n26;
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
                                FlowCollector flowCollector = this.f223608d;
                                n26 = this.f223609e.n2(feedPublishFinish.getState());
                                if (n26) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new TopicListViewModel$onFeedPublishObserve$4(this, null)), ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2(final GuildDetailViewDestroyEvent event) {
        a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$onFeedUpdateEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FeedListState invoke(@NotNull FeedListState oldState) {
                Intrinsics.checkNotNullParameter(oldState, "oldState");
                List<vn1.b> b16 = oldState.c().b();
                GuildDetailViewDestroyEvent guildDetailViewDestroyEvent = GuildDetailViewDestroyEvent.this;
                ArrayList arrayList = new ArrayList();
                for (vn1.b bVar : b16) {
                    if (Intrinsics.areEqual(guildDetailViewDestroyEvent.getFeedId(), bVar.d().getFeedId())) {
                        Object a16 = bVar.d().a();
                        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
                        GProStFeed gProStFeed = (GProStFeed) a16;
                        gProStFeed.totalPrefer.preferCount = guildDetailViewDestroyEvent.getPreferCount();
                        gProStFeed.totalPrefer.preferStatus = guildDetailViewDestroyEvent.getPreferStatus();
                        gProStFeed.totalPrefer.preferCountWithoutLike = guildDetailViewDestroyEvent.getPreferCount();
                        gProStFeed.share.sharedCount = guildDetailViewDestroyEvent.getShareCount();
                        gProStFeed.commentCount = guildDetailViewDestroyEvent.getCommentCount();
                        bVar = xn1.e.f448187a.r(bVar);
                    }
                    if (bVar != null) {
                        arrayList.add(bVar);
                    }
                }
                return FeedListState.b(oldState, null, false, new com.tencent.mobileqq.guild.feed.topic.h(arrayList), false, 0, false, 59, null);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.mvi.BaseViewModel
    /* renamed from: o2, reason: merged with bridge method [inline-methods] */
    public void U1(@NotNull final n i3, @NotNull FeedListState replayState) {
        final h hVar;
        Intrinsics.checkNotNullParameter(i3, "i");
        Intrinsics.checkNotNullParameter(replayState, "replayState");
        if (i3 instanceof TopicFeedsRefreshIntent) {
            TopicFeedsRefreshIntent topicFeedsRefreshIntent = (TopicFeedsRefreshIntent) i3;
            hVar = new i.Refresh(topicFeedsRefreshIntent.getFirstFeedId(), topicFeedsRefreshIntent.getSource());
        } else if (i3 instanceof TopicFeedsLordMoreIntent) {
            hVar = e.INSTANCE.a((TopicFeedsLordMoreIntent) i3, replayState);
        } else if (i3 instanceof m) {
            hVar = l.f223664a;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        r2(i3, hVar);
        a2(new Function1<FeedListState, FeedListState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicListViewModel$handleIntent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FeedListState invoke(@NotNull FeedListState old) {
                Intrinsics.checkNotNullParameter(old, "old");
                FeedListState a16 = h.this.a(old);
                QLog.i("GTopic_LIST_VM", 1, "handleIntent\n " + i3 + "\n-> " + old + "\n-> " + h.this + "\n-> " + a16);
                return a16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.mvi.BaseViewModel
    @NotNull
    /* renamed from: s2, reason: merged with bridge method [inline-methods] */
    public FeedListState W1() {
        ri1.a a16 = ri1.a.a(-1);
        Intrinsics.checkNotNullExpressionValue(a16, "error(GProStateCode.TYPE_DEFAULT_VALUE)");
        return new FeedListState(a16, false, new com.tencent.mobileqq.guild.feed.topic.h(null, 1, null), false, 0, false, 56, null);
    }
}
