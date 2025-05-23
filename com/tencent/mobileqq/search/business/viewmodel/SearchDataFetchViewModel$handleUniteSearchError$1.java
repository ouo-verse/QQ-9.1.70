package com.tencent.mobileqq.search.business.viewmodel;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.viewmodel.SearchDataFetchViewModel$handleUniteSearchError$1", f = "SearchDataFetchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class SearchDataFetchViewModel$handleUniteSearchError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ boolean $isFirstReq;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $reqTime;
    final /* synthetic */ int $resultCode;
    int label;
    final /* synthetic */ SearchDataFetchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchDataFetchViewModel$handleUniteSearchError$1(SearchDataFetchViewModel searchDataFetchViewModel, String str, boolean z16, String str2, int i3, String str3, Continuation<? super SearchDataFetchViewModel$handleUniteSearchError$1> continuation) {
        super(2, continuation);
        this.this$0 = searchDataFetchViewModel;
        this.$keyword = str;
        this.$isFirstReq = z16;
        this.$reqTime = str2;
        this.$resultCode = i3;
        this.$errorMsg = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchDataFetchViewModel$handleUniteSearchError$1(this.this$0, this.$keyword, this.$isFirstReq, this.$reqTime, this.$resultCode, this.$errorMsg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.uniteSearchResultErrorObservers;
            String str = this.$keyword;
            boolean z16 = this.$isFirstReq;
            String str2 = this.$reqTime;
            int i3 = this.$resultCode;
            String str3 = this.$errorMsg;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(str, z16, str2, i3, str3);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchDataFetchViewModel$handleUniteSearchError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
