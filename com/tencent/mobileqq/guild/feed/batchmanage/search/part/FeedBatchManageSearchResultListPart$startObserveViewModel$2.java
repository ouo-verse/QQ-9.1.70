package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\r\u001a\u00020\f*2\u0012.\u0012,\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0001j\u0002`\t0\u00002\u0006\u0010\u000b\u001a\u00020\nH\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lbo1/a;", "Ldo1/a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResult;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchExtraArgs;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/FeedBatchManageSearchResultState;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultListPart$startObserveViewModel$2", f = "FeedBatchManageSearchResultListPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedBatchManageSearchResultListPart$startObserveViewModel$2 extends SuspendLambda implements Function3<FlowCollector<? super bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs>>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedBatchManageSearchResultListPart$startObserveViewModel$2(Continuation<? super FeedBatchManageSearchResultListPart$startObserveViewModel$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.e("FeedBatchManagement.Search.List", 1, "observe stateFlow error: " + ((Throwable) this.L$0));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super bo1.a<do1.a<List<com.tencent.mobileqq.guild.feed.feedsquare.data.h>, Integer>, FeedBatchManageSearchArgs>> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
        FeedBatchManageSearchResultListPart$startObserveViewModel$2 feedBatchManageSearchResultListPart$startObserveViewModel$2 = new FeedBatchManageSearchResultListPart$startObserveViewModel$2(continuation);
        feedBatchManageSearchResultListPart$startObserveViewModel$2.L$0 = th5;
        return feedBatchManageSearchResultListPart$startObserveViewModel$2.invokeSuspend(Unit.INSTANCE);
    }
}
