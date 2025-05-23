package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q;
import com.tencent.mobileqq.guild.util.Logger;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchViewModel$launchNewSearch$1", f = "DSSearchViewModel.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSSearchViewModel$launchNewSearch$1 extends SuspendLambda implements Function2<Pair<? extends q, ? extends SearchResponse>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DSSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSSearchViewModel$launchNewSearch$1(DSSearchViewModel dSSearchViewModel, Continuation<? super DSSearchViewModel$launchNewSearch$1> continuation) {
        super(2, continuation);
        this.this$0 = dSSearchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSSearchViewModel$launchNewSearch$1 dSSearchViewModel$launchNewSearch$1 = new DSSearchViewModel$launchNewSearch$1(this.this$0, continuation);
        dSSearchViewModel$launchNewSearch$1.L$0 = obj;
        return dSSearchViewModel$launchNewSearch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends q, ? extends SearchResponse> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<? extends q, SearchResponse>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        boolean z16;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        int i3;
        MutableStateFlow mutableStateFlow5;
        int i16;
        MutableStateFlow mutableStateFlow6;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            q qVar = (q) pair.component1();
            SearchResponse searchResponse = (SearchResponse) pair.component2();
            Logger logger = Logger.f235387a;
            DSSearchViewModel dSSearchViewModel = this.this$0;
            logger.d().i("QQGuildInSearchTag.DSSearchViewModel", 1, "receive (delayTime=" + dSSearchViewModel.getDelayTime() + ") receive " + qVar);
            mutableStateFlow = this.this$0._aiSearchStateFlow;
            DSSearchData dSSearchData = (DSSearchData) mutableStateFlow.getValue();
            if (qVar == null) {
                return Unit.INSTANCE;
            }
            boolean z17 = qVar instanceof q.ReceiveContent;
            if (z17) {
                z16 = true;
            } else {
                z16 = qVar instanceof q.ReceiveReasonContent;
            }
            if (z16) {
                if (z17) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                int i18 = i16;
                mutableStateFlow6 = this.this$0._aiSearchStateFlow;
                mutableStateFlow6.setValue(DSSearchData.c(dSSearchData, i18, searchResponse.getContent(), searchResponse.getReasonContent(), 0L, 0L, 24, null));
            } else if (qVar instanceof q.Failed) {
                String reason = ((q.Failed) qVar).getReason();
                if (Intrinsics.areEqual(reason, "sensitive")) {
                    i3 = 7;
                } else if (Intrinsics.areEqual(reason, "timeout")) {
                    i3 = 8;
                } else {
                    i3 = 6;
                }
                int i19 = i3;
                mutableStateFlow5 = this.this$0._aiSearchStateFlow;
                mutableStateFlow5.setValue(DSSearchData.c(dSSearchData, i19, null, null, 0L, 0L, 30, null));
            } else if (qVar instanceof q.e) {
                mutableStateFlow4 = this.this$0._aiSearchStateFlow;
                mutableStateFlow4.setValue(DSSearchData.c(dSSearchData, 2, null, null, SystemClock.uptimeMillis(), 0L, 22, null));
            } else if (qVar instanceof q.a) {
                mutableStateFlow3 = this.this$0._aiSearchStateFlow;
                mutableStateFlow3.setValue(DSSearchData.c(dSSearchData, 5, null, null, 0L, 0L, 30, null));
            } else if (qVar instanceof q.c) {
                mutableStateFlow2 = this.this$0._aiSearchStateFlow;
                mutableStateFlow2.setValue(DSSearchData.c(dSSearchData, 3, null, null, 0L, SystemClock.uptimeMillis(), 14, null));
            }
            long delayTime = this.this$0.getDelayTime();
            this.label = 1;
            if (DelayKt.delay(delayTime, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<? extends q, SearchResponse> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((DSSearchViewModel$launchNewSearch$1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
