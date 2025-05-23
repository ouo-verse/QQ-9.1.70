package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.r;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "acc", "event", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$fetchResponseResult$1", f = "DSSearchDepositary.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSSearchDepositary$fetchResponseResult$1 extends SuspendLambda implements Function3<Pair<? extends q, ? extends SearchResponse>, q, Continuation<? super Pair<? extends q, ? extends SearchResponse>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DSSearchDepositary$fetchResponseResult$1(Continuation<? super DSSearchDepositary$fetchResponseResult$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends q, ? extends SearchResponse> pair, q qVar, Continuation<? super Pair<? extends q, ? extends SearchResponse>> continuation) {
        return invoke2((Pair<? extends q, SearchResponse>) pair, qVar, (Continuation<? super Pair<? extends q, SearchResponse>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        r error;
        r rVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            q qVar = (q) this.L$1;
            SearchResponse searchResponse = (SearchResponse) pair.component2();
            if (qVar instanceof q.e) {
                return TuplesKt.to(qVar, SearchResponse.b(searchResponse, null, null, null, SystemClock.uptimeMillis(), null, 23, null));
            }
            if (qVar instanceof q.ReceiveContent) {
                return TuplesKt.to(qVar, SearchResponse.b(searchResponse, null, searchResponse.getContent() + ((q.ReceiveContent) qVar).getContent(), null, 0L, null, 29, null));
            }
            if (qVar instanceof q.ReceiveReasonContent) {
                return TuplesKt.to(qVar, SearchResponse.b(searchResponse, null, null, searchResponse.getReasonContent() + ((q.ReceiveReasonContent) qVar).getReasonContent(), 0L, null, 27, null));
            }
            if (qVar instanceof q.Failed) {
                q.Failed failed = (q.Failed) qVar;
                String reason = failed.getReason();
                if (Intrinsics.areEqual(reason, "sensitive")) {
                    rVar = r.b.f231719a;
                } else if (Intrinsics.areEqual(reason, "timeout")) {
                    rVar = r.d.f231721a;
                } else {
                    error = new r.Error(failed.getReason());
                    return TuplesKt.to(qVar, SearchResponse.b(searchResponse, null, null, null, 0L, error, 15, null));
                }
                error = rVar;
                return TuplesKt.to(qVar, SearchResponse.b(searchResponse, null, null, null, 0L, error, 15, null));
            }
            if (qVar instanceof q.a) {
                return TuplesKt.to(qVar, SearchResponse.b(searchResponse, null, null, null, 0L, r.c.f231720a, 15, null));
            }
            if (qVar instanceof q.c) {
                return TuplesKt.to(qVar, searchResponse);
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<? extends q, SearchResponse> pair, @NotNull q qVar, @Nullable Continuation<? super Pair<? extends q, SearchResponse>> continuation) {
        DSSearchDepositary$fetchResponseResult$1 dSSearchDepositary$fetchResponseResult$1 = new DSSearchDepositary$fetchResponseResult$1(continuation);
        dSSearchDepositary$fetchResponseResult$1.L$0 = pair;
        dSSearchDepositary$fetchResponseResult$1.L$1 = qVar;
        return dSSearchDepositary$fetchResponseResult$1.invokeSuspend(Unit.INSTANCE);
    }
}
