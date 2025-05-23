package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.SearchResponse;
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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006*\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$launchNewSearch$2", f = "AIChatRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIChatRepository$launchNewSearch$2 extends SuspendLambda implements Function3<FlowCollector<? super Pair<? extends q, ? extends SearchResponse>>, Throwable, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIChatRepository$launchNewSearch$2(Continuation<? super AIChatRepository$launchNewSearch$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Pair<? extends q, ? extends SearchResponse>> flowCollector, Throwable th5, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Pair<? extends q, SearchResponse>>) flowCollector, th5, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logger.f235387a.d().i("AIChatRepository", 1, "fetchResponseResult: onCompletion");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<? super Pair<? extends q, SearchResponse>> flowCollector, @Nullable Throwable th5, @Nullable Continuation<? super Unit> continuation) {
        return new AIChatRepository$launchNewSearch$2(continuation).invokeSuspend(Unit.INSTANCE);
    }
}
