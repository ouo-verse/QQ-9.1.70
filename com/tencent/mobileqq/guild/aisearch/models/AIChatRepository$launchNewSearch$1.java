package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.SearchResponse;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$launchNewSearch$1", f = "AIChatRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class AIChatRepository$launchNewSearch$1 extends SuspendLambda implements Function2<Pair<? extends q, ? extends SearchResponse>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableStateFlow<ChatAnswerData> $aiSearchStateFlow;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatRepository$launchNewSearch$1(MutableStateFlow<ChatAnswerData> mutableStateFlow, Continuation<? super AIChatRepository$launchNewSearch$1> continuation) {
        super(2, continuation);
        this.$aiSearchStateFlow = mutableStateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatRepository$launchNewSearch$1 aIChatRepository$launchNewSearch$1 = new AIChatRepository$launchNewSearch$1(this.$aiSearchStateFlow, continuation);
        aIChatRepository$launchNewSearch$1.L$0 = obj;
        return aIChatRepository$launchNewSearch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends q, ? extends SearchResponse> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<? extends q, SearchResponse>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            q qVar = (q) pair.component1();
            SearchResponse searchResponse = (SearchResponse) pair.component2();
            if (qVar == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("fetchResponseResult: event is null");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), null);
                }
                return Unit.INSTANCE;
            }
            ChatAnswerData a16 = f.a(this.$aiSearchStateFlow.getValue(), qVar, searchResponse);
            this.$aiSearchStateFlow.setValue(a16);
            Logger.f235387a.d().i("AIChatRepository", 1, "fetchResponseResult: " + a16);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<? extends q, SearchResponse> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatRepository$launchNewSearch$1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
