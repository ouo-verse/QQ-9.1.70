package com.tencent.ecommerce.biz.commission.forecast;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@"}, d2 = {"", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Lkotlin/coroutines/Continuation;", "", "continuation", "", "loadMoreInternal"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListViewModel", f = "ECCommissionForecastDetailListViewModel.kt", i = {0, 0}, l = {63}, m = "loadMoreInternal", n = {"this", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE}, s = {"L$0", "Z$0"})
/* loaded from: classes31.dex */
public final class ECCommissionForecastDetailListViewModel$loadMoreInternal$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECCommissionForecastDetailListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCommissionForecastDetailListViewModel$loadMoreInternal$1(ECCommissionForecastDetailListViewModel eCCommissionForecastDetailListViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCCommissionForecastDetailListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.S1(false, this);
    }
}
