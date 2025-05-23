package com.tencent.mobileqq.guild.feed.topic.mvi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.mvi.BaseViewModel;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedsReloadEvent;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedsRspEvent;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f*\u0001\u000b\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000f\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010 R\u0014\u0010)\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010 R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel;", "Lcom/tencent/mobileqq/guild/feed/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/d;", "Lcom/tencent/mobileqq/guild/feed/mvi/c;", "", "guildId", "", "o2", "numStr", "defaultStr", "i2", "com/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel$b", "r2", "()Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel$b;", "i", "replayState", ICustomDataEditor.NUMBER_PARAM_2, "p2", "onCleared", "Lcom/tencent/mobileqq/guild/feed/topic/e;", "D", "Lcom/tencent/mobileqq/guild/feed/topic/e;", "topicSession", "Landroidx/lifecycle/MutableLiveData;", "", "E", "Landroidx/lifecycle/MutableLiveData;", "isGuildMemberData", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel$b;", "mObserver", "m2", "()Ljava/lang/String;", "topicName", "", "l2", "()J", "topicId", "k2", "topicGuildId", "j2", "channelSign", "q2", "()Landroidx/lifecycle/MutableLiveData;", "isGuildMember", "<init>", "(Lcom/tencent/mobileqq/guild/feed/topic/e;)V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicViewModel extends BaseViewModel<MainState, com.tencent.mobileqq.guild.feed.mvi.c> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.topic.e topicSession;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isGuildMemberData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicFeedsRspEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$2", f = "TopicViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<TopicFeedsRspEvent, Continuation<? super Unit>, Object> {
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
        public final Object invoke(@NotNull TopicFeedsRspEvent topicFeedsRspEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(topicFeedsRspEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean isBlank;
            com.tencent.mobileqq.guild.feed.topic.f fVar;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final com.tencent.mobileqq.guild.feed.topic.g rsp = ((TopicFeedsRspEvent) this.L$0).getRsp();
                final String newTopicName = rsp.getRawRsp().topicName;
                TopicViewModel topicViewModel = TopicViewModel.this;
                isBlank = StringsKt__StringsJVMKt.isBlank(newTopicName);
                if (isBlank) {
                    newTopicName = topicViewModel.topicSession.getTopicNameRef();
                }
                final int i3 = rsp.getRspStatus().f431477a;
                com.tencent.mobileqq.guild.feed.topic.e eVar = TopicViewModel.this.topicSession;
                if (eVar instanceof com.tencent.mobileqq.guild.feed.topic.f) {
                    fVar = (com.tencent.mobileqq.guild.feed.topic.f) eVar;
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    Intrinsics.checkNotNullExpressionValue(newTopicName, "newTopicName");
                    fVar.b(newTopicName);
                }
                final TopicViewModel topicViewModel2 = TopicViewModel.this;
                topicViewModel2.a2(new Function1<MainState, MainState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final MainState invoke(@NotNull MainState old) {
                        Intrinsics.checkNotNullParameter(old, "old");
                        int i16 = i3;
                        if (i16 == 20028) {
                            return MainState.b(old, 10001, null, null, null, null, null, false, 126, null);
                        }
                        if (i16 == 0) {
                            String newTopicName2 = newTopicName;
                            Intrinsics.checkNotNullExpressionValue(newTopicName2, "newTopicName");
                            String str = rsp.getRawRsp().channelSign.joinGuildSig;
                            Intrinsics.checkNotNullExpressionValue(str, "rsp.rawRsp.channelSign.joinGuildSig");
                            TopicViewModel topicViewModel3 = topicViewModel2;
                            String str2 = rsp.getRawRsp().pageView;
                            Intrinsics.checkNotNullExpressionValue(str2, "rsp.rawRsp.pageView");
                            String i26 = topicViewModel3.i2(str2, old.getPageView());
                            TopicViewModel topicViewModel4 = topicViewModel2;
                            String str3 = rsp.getRawRsp().totalFeedNum;
                            Intrinsics.checkNotNullExpressionValue(str3, "rsp.rawRsp.totalFeedNum");
                            return MainState.b(old, 0, newTopicName2, null, str, i26, topicViewModel4.i2(str3, old.getTotalFeedNum()), false, 68, null);
                        }
                        if (old.getStatusCode() != 0) {
                            return MainState.b(old, i3 == 1002 ? 3 : 4, null, null, null, null, null, false, 126, null);
                        }
                        return old;
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\bH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/mvi/TopicViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "onAddGuildNotInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "sourceType", "onAddGuildWithInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAddGuildNotInfo(@Nullable String guildId) {
            if (Intrinsics.areEqual(TopicViewModel.this.k2(), guildId)) {
                TopicViewModel.this.isGuildMemberData.setValue(Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            String k26 = TopicViewModel.this.k2();
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(k26, str)) {
                TopicViewModel.this.isGuildMemberData.setValue(Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            if (Intrinsics.areEqual(TopicViewModel.this.k2(), guildId)) {
                TopicViewModel.this.isGuildMemberData.setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            if (Intrinsics.areEqual(TopicViewModel.this.k2(), guildId)) {
                TopicViewModel.this.isGuildMemberData.setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            if (Intrinsics.areEqual(TopicViewModel.this.k2(), guildId)) {
                TopicViewModel.this.isGuildMemberData.setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            if (Intrinsics.areEqual(TopicViewModel.this.k2(), guildId)) {
                TopicViewModel.this.isGuildMemberData.setValue(Boolean.FALSE);
            }
        }
    }

    public TopicViewModel(@NotNull com.tencent.mobileqq.guild.feed.topic.e topicSession) {
        Intrinsics.checkNotNullParameter(topicSession, "topicSession");
        this.topicSession = topicSession;
        this.isGuildMemberData = new MutableLiveData<>();
        b r26 = r2();
        this.mObserver = r26;
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(r26);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        final Flow callbackFlow = FlowKt.callbackFlow(new TopicViewModel$special$$inlined$eventFlow$1(simpleEventBus, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<TopicFeedsRspEvent>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$special$$inlined$filter$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$special$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<TopicFeedsRspEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223632d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicViewModel f223633e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$special$$inlined$filter$1$2", f = "TopicViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$special$$inlined$filter$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, TopicViewModel topicViewModel) {
                    this.f223632d = flowCollector;
                    this.f223633e = topicViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(TopicFeedsRspEvent topicFeedsRspEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    long l26;
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
                                FlowCollector flowCollector = this.f223632d;
                                long topicId = topicFeedsRspEvent.getTopicId();
                                l26 = this.f223633e.l2();
                                if (topicId == l26) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(topicFeedsRspEvent, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(@NotNull FlowCollector<? super TopicFeedsRspEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new AnonymousClass2(null)), ViewModelKt.getViewModelScope(this));
        o2(k2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String i2(String numStr, String defaultStr) {
        String str;
        Long longOrNull;
        String str2;
        try {
            Result.Companion companion = Result.INSTANCE;
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(numStr);
            if (longOrNull == null) {
                str2 = defaultStr;
            } else if (longOrNull.longValue() < 10000) {
                str2 = longOrNull.toString();
            } else {
                long j3 = 10000;
                long longValue = longOrNull.longValue() / j3;
                long longValue2 = longOrNull.longValue() % j3;
                if (longValue2 == 0) {
                    str2 = longValue + "\u4e07";
                } else {
                    int i3 = (int) ((longValue2 * 10) / j3);
                    if (i3 == 0) {
                        str2 = longValue + "\u4e07";
                    } else {
                        str2 = longValue + "." + i3 + "\u4e07";
                    }
                }
            }
            str = Result.m476constructorimpl(str2);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            str = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(str) == null) {
            defaultStr = str;
        }
        return defaultStr;
    }

    private final String j2() {
        return this.topicSession.getChannelSign();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k2() {
        return this.topicSession.getGuildId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long l2() {
        return this.topicSession.getTopicId();
    }

    private final String m2() {
        return this.topicSession.getTopicNameRef();
    }

    private final void o2(String guildId) {
        boolean z16;
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo != null && !guildInfo.isMember() && !guildInfo.getIsBanned() && guildInfo.isVisibleForVisitor()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isGuildMemberData.setValue(Boolean.valueOf(!z16));
    }

    private final b r2() {
        return new b();
    }

    @Override // com.tencent.mobileqq.guild.feed.mvi.BaseViewModel
    /* renamed from: n2, reason: merged with bridge method [inline-methods] */
    public void U1(@NotNull final com.tencent.mobileqq.guild.feed.mvi.c i3, @NotNull MainState replayState) {
        Intrinsics.checkNotNullParameter(i3, "i");
        Intrinsics.checkNotNullParameter(replayState, "replayState");
        if (i3 instanceof p) {
            a2(new Function1<MainState, MainState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$handleIntent$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final MainState invoke(@NotNull MainState old) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    return MainState.b(old, 2, null, null, null, null, null, false, 126, null);
                }
            });
            SimpleEventBus.getInstance().dispatchEvent(new TopicFeedsReloadEvent(l2()));
        } else if (i3 instanceof o) {
            a2(new Function1<MainState, MainState>() { // from class: com.tencent.mobileqq.guild.feed.topic.mvi.TopicViewModel$handleIntent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final MainState invoke(@NotNull MainState old) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    return MainState.b(old, 0, null, null, null, null, null, ((o) com.tencent.mobileqq.guild.feed.mvi.c.this).getShow(), 63, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.mObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.mvi.BaseViewModel
    @NotNull
    /* renamed from: p2, reason: merged with bridge method [inline-methods] */
    public MainState W1() {
        return new MainState(2, m2(), k2(), j2(), "0", "0", true);
    }

    @NotNull
    public final MutableLiveData<Boolean> q2() {
        return this.isGuildMemberData;
    }
}
