package com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel;

import bo1.a;
import com.tencent.common.app.AppInterface;
import com.tencent.luggage.wxa.rf.h;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.eg;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ea;
import yl1.n;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1", f = "FeedBatchManageSearchViewModel.kt", i = {}, l = {h.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $tinyID;
    int label;
    final /* synthetic */ FeedBatchManageSearchViewModel this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements FlowCollector<Pair<? extends String, ? extends FeedBatchManageSearchArgs>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedBatchManageSearchViewModel f218286d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f218287e;

        public a(FeedBatchManageSearchViewModel feedBatchManageSearchViewModel, long j3) {
            this.f218286d = feedBatchManageSearchViewModel;
            this.f218287e = j3;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends String, ? extends FeedBatchManageSearchArgs> pair, @NotNull Continuation<? super Unit> continuation) {
            MutableStateFlow mutableStateFlow;
            AppInterface appInterface;
            eg T1;
            AtomicIntegerArray atomicIntegerArray;
            ea d26;
            MutableStateFlow mutableStateFlow2;
            Pair<? extends String, ? extends FeedBatchManageSearchArgs> pair2 = pair;
            String component1 = pair2.component1();
            FeedBatchManageSearchArgs component2 = pair2.component2();
            mutableStateFlow = this.f218286d._stateFlow;
            a.c cVar = a.c.f28718a;
            Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
            mutableStateFlow.setValue(cVar);
            IRuntimeService iRuntimeService = null;
            if (n.d(true, 0, 2, null)) {
                mutableStateFlow2 = this.f218286d._stateFlow;
                a.d dVar = a.d.f28719a;
                Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
                mutableStateFlow2.setValue(dVar);
            } else {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface != null) {
                    iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    T1 = this.f218286d.T1(this.f218287e, component2, component1);
                    this.f218286d.currentSearchRequest = T1;
                    FeedBatchManageSearchViewModel feedBatchManageSearchViewModel = this.f218286d;
                    atomicIntegerArray = feedBatchManageSearchViewModel.maxRunScheduledGeneration;
                    d26 = feedBatchManageSearchViewModel.d2(component1, component2, atomicIntegerArray.incrementAndGet(0));
                    iGPSService.searchGuildFeeds(T1, d26);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1(FeedBatchManageSearchViewModel feedBatchManageSearchViewModel, long j3, Continuation<? super FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1> continuation) {
        super(2, continuation);
        this.this$0 = feedBatchManageSearchViewModel;
        this.$tinyID = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1(this.this$0, this.$tinyID, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Channel channel;
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
            channel = this.this$0.searchRequestChannel;
            Flow receiveAsFlow = FlowKt.receiveAsFlow(channel);
            a aVar = new a(this.this$0, this.$tinyID);
            this.label = 1;
            if (receiveAsFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBatchManageSearchViewModel$startProducerJobInViewModelScope$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
