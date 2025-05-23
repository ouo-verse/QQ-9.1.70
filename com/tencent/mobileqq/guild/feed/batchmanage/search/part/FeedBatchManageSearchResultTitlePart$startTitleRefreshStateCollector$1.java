package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import bo1.a;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchViewModel;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1", f = "FeedBatchManageSearchResultTitlePart.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedBatchManageSearchResultTitlePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements FlowCollector<bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedBatchManageSearchResultTitlePart f218262d;

        public a(FeedBatchManageSearchResultTitlePart feedBatchManageSearchResultTitlePart) {
            this.f218262d = feedBatchManageSearchResultTitlePart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs> aVar, @NotNull Continuation<? super Unit> continuation) {
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon;
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2;
            bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs> aVar2 = aVar;
            if (aVar2 instanceof a.SuccessState) {
                this.f218262d.L9((a.SuccessState) aVar2);
            } else {
                GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon3 = null;
                if (aVar2 instanceof a.ErrorState) {
                    FeedBatchManageSearchResultTitlePart.K9(this.f218262d, null, "\u51fa\u9519\u4e86", 1, null);
                    guildDefaultThemeNavBarCommon2 = this.f218262d.navBar;
                    if (guildDefaultThemeNavBarCommon2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navBar");
                    } else {
                        guildDefaultThemeNavBarCommon3 = guildDefaultThemeNavBarCommon2;
                    }
                    guildDefaultThemeNavBarCommon3.setRightViewTextVisible(4);
                } else {
                    a.c cVar = a.c.f28718a;
                    Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
                    if (Intrinsics.areEqual(aVar2, cVar)) {
                        FeedBatchManageSearchResultTitlePart.K9(this.f218262d, null, "\u52a0\u8f7d\u4e2d...", 1, null);
                    } else {
                        a.d dVar = a.d.f28719a;
                        Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
                        if (Intrinsics.areEqual(aVar2, dVar)) {
                            FeedBatchManageSearchResultTitlePart.K9(this.f218262d, null, "\u7f51\u7edc\u5df2\u65ad\u5f00\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1, null);
                            guildDefaultThemeNavBarCommon = this.f218262d.navBar;
                            if (guildDefaultThemeNavBarCommon == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("navBar");
                            } else {
                                guildDefaultThemeNavBarCommon3 = guildDefaultThemeNavBarCommon;
                            }
                            guildDefaultThemeNavBarCommon3.setRightViewTextVisible(4);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1(FeedBatchManageSearchResultTitlePart feedBatchManageSearchResultTitlePart, Continuation<? super FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1> continuation) {
        super(2, continuation);
        this.this$0 = feedBatchManageSearchResultTitlePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        StateFlow<bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs>> X1;
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
            FeedBatchManageSearchViewModel feedBatchManageSearchViewModel = (FeedBatchManageSearchViewModel) this.this$0.getViewModel(FeedBatchManageSearchViewModel.class);
            if (feedBatchManageSearchViewModel != null && (X1 = feedBatchManageSearchViewModel.X1()) != null) {
                a aVar = new a(this.this$0);
                this.label = 1;
                if (X1.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBatchManageSearchResultTitlePart$startTitleRefreshStateCollector$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
