package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import bo1.a;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u000b\u001a\u00020\n20\u0010\t\u001a,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0000j\u0002`\bH\u008a@"}, d2 = {"Lbo1/a;", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResult;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchExtraArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResultState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultListPart$startObserveViewModel$1", f = "FeedBatchManageSearchResultListPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultListPart$startObserveViewModel$1 extends SuspendLambda implements Function2<bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedBatchManageSearchResultListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBatchManageSearchResultListPart$startObserveViewModel$1(FeedBatchManageSearchResultListPart feedBatchManageSearchResultListPart, Continuation<? super FeedBatchManageSearchResultListPart$startObserveViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = feedBatchManageSearchResultListPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedBatchManageSearchResultListPart$startObserveViewModel$1 feedBatchManageSearchResultListPart$startObserveViewModel$1 = new FeedBatchManageSearchResultListPart$startObserveViewModel$1(this.this$0, continuation);
        feedBatchManageSearchResultListPart$startObserveViewModel$1.L$0 = obj;
        return feedBatchManageSearchResultListPart$startObserveViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs> aVar, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBatchManageSearchResultListPart$startObserveViewModel$1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        zi1.a D9;
        zi1.a D92;
        zi1.a D93;
        zi1.a D94;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            bo1.a aVar = (bo1.a) this.L$0;
            if (aVar instanceof a.SuccessState) {
                this.this$0.C9((a.SuccessState) aVar);
            } else if (aVar instanceof a.ErrorState) {
                D94 = this.this$0.D9();
                D94.g(4);
            } else {
                a.b bVar = a.b.f28717a;
                Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
                if (Intrinsics.areEqual(aVar, bVar)) {
                    D93 = this.this$0.D9();
                    D93.g(-1);
                } else {
                    a.d dVar = a.d.f28719a;
                    Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
                    if (Intrinsics.areEqual(aVar, dVar)) {
                        D92 = this.this$0.D9();
                        D92.g(3);
                    } else {
                        a.c cVar = a.c.f28718a;
                        Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.util.framework.candidate.session.api.IKeywordSearchSessionProxy.ResultState<com.tencent.mobileqq.guild.feed.util.state.CollectionViewState<kotlin.collections.MutableList<com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedItemData>, kotlin.Int>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResult }, com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchExtraArgs }>{ com.tencent.mobileqq.guild.feed.batchmanage.FeedBatchManageKtKt.FeedBatchManageSearchResultState }");
                        if (Intrinsics.areEqual(aVar, cVar)) {
                            D9 = this.this$0.D9();
                            D9.g(2);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
