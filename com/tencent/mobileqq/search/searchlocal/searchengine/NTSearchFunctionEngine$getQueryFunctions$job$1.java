package com.tencent.mobileqq.search.searchlocal.searchengine;

import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lo2.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.searchlocal.searchengine.NTSearchFunctionEngine$getQueryFunctions$job$1", f = "NTSearchFunctionEngine.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class NTSearchFunctionEngine$getQueryFunctions$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<SearchFunctionResult> $flow;
    final /* synthetic */ String $keyword;
    final /* synthetic */ ArrayList<c> $searchResults;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NTSearchFunctionEngine this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements FlowCollector<SearchFunctionResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f284860d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f284861e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f284862f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ NTSearchFunctionEngine f284863h;

        public a(String str, ArrayList arrayList, CoroutineScope coroutineScope, NTSearchFunctionEngine nTSearchFunctionEngine) {
            this.f284860d = str;
            this.f284861e = arrayList;
            this.f284862f = coroutineScope;
            this.f284863h = nTSearchFunctionEngine;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(SearchFunctionResult searchFunctionResult, @NotNull Continuation<? super Unit> continuation) {
            int collectionSizeOrDefault;
            int i3;
            SearchFunctionResult searchFunctionResult2 = searchFunctionResult;
            QLog.d(NTSearchFunctionEngine.F, 1, "search " + this.f284860d + " with result: " + searchFunctionResult2);
            ArrayList<SearchFunctionItem> arrayList = searchFunctionResult2.resultItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "result.resultItems");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (SearchFunctionItem searchFunctionItem : arrayList) {
                String str = this.f284860d;
                String valueOf = String.valueOf(searchFunctionItem.fid);
                String str2 = searchFunctionItem.name;
                String str3 = searchFunctionItem.headUrl;
                String str4 = searchFunctionItem.androidJumpUrl;
                i3 = this.f284863h.mFromType;
                c cVar = new c(str, valueOf, str2, str3, str4, "", VasBusiness.QWALLET, null, i3);
                cVar.S(7);
                arrayList2.add(cVar);
            }
            this.f284861e.addAll(arrayList2);
            CoroutineScopeKt.cancel$default(this.f284862f, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTSearchFunctionEngine$getQueryFunctions$job$1(Flow<SearchFunctionResult> flow, String str, ArrayList<c> arrayList, NTSearchFunctionEngine nTSearchFunctionEngine, Continuation<? super NTSearchFunctionEngine$getQueryFunctions$job$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.$keyword = str;
        this.$searchResults = arrayList;
        this.this$0 = nTSearchFunctionEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NTSearchFunctionEngine$getQueryFunctions$job$1 nTSearchFunctionEngine$getQueryFunctions$job$1 = new NTSearchFunctionEngine$getQueryFunctions$job$1(this.$flow, this.$keyword, this.$searchResults, this.this$0, continuation);
        nTSearchFunctionEngine$getQueryFunctions$job$1.L$0 = obj;
        return nTSearchFunctionEngine$getQueryFunctions$job$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow flowOn = FlowKt.flowOn(this.$flow, Dispatchers.getDefault());
            a aVar = new a(this.$keyword, this.$searchResults, coroutineScope, this.this$0);
            this.label = 1;
            if (flowOn.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NTSearchFunctionEngine$getQueryFunctions$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
