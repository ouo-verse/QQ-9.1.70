package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$fetchResponseResult$2", f = "DSSearchDepositary.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSSearchDepositary$fetchResponseResult$2 extends SuspendLambda implements Function2<Pair<? extends q, ? extends SearchResponse>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DSSearchDepositary$fetchResponseResult$2(Continuation<? super DSSearchDepositary$fetchResponseResult$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSSearchDepositary$fetchResponseResult$2 dSSearchDepositary$fetchResponseResult$2 = new DSSearchDepositary$fetchResponseResult$2(continuation);
        dSSearchDepositary$fetchResponseResult$2.L$0 = obj;
        return dSSearchDepositary$fetchResponseResult$2;
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
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QQGuildInSearchTag.DSSearchDepositary", "fetchResponseResult " + pair);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<? extends q, SearchResponse> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((DSSearchDepositary$fetchResponseResult$2) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
