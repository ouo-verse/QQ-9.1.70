package com.tencent.mobileqq.guild.feed.batchmanage.search.fragment;

import androidx.lifecycle.MutableLiveData;
import bo1.a;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.data.h;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u000b\u001a\u00020\n20\u0010\t\u001a,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0000j\u0002`\bH\u008a@"}, d2 = {"Lbo1/a;", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResult;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchExtraArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResultState;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.search.fragment.FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1", f = "FeedBatchManageSearchResultFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1 extends SuspendLambda implements Function2<a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableLiveData<do1.a<? extends Collection<?>, Integer>> $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1(FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1 feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1, MutableLiveData<do1.a<? extends Collection<?>, Integer>> mutableLiveData, Continuation<? super FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1;
        this.$this_apply = mutableLiveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1 feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1 = new FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1(this.this$0, this.$this_apply, continuation);
        feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1.L$0 = obj;
        return feedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a<do1.a<List<h>, Integer>, FeedBatchManageSearchArgs> aVar, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1$feedCollectionViewState$2$1$1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            a aVar = (a) this.L$0;
            if (aVar instanceof a.SuccessState) {
                Function1<Integer, Unit> c16 = this.this$0.c();
                if (c16 != null) {
                    c16.invoke(Boxing.boxInt(((do1.a) ((a.SuccessState) aVar).d()).getTotal()));
                }
                this.$this_apply.setValue(((a.SuccessState) aVar).d());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
