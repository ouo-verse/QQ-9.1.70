package com.tencent.mobileqq.search.business.viewmodel;

import com.tencent.mobileqq.search.model.x;
import com.tencent.qqnt.kernel.nativeinterface.UfsTabItemGroup;
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
@DebugMetadata(c = "com.tencent.mobileqq.search.business.viewmodel.SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1", f = "SearchDataFetchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $cookie;
    final /* synthetic */ boolean $isEnd;
    final /* synthetic */ boolean $isFirstReq;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $reqTime;
    final /* synthetic */ List<x> $result;
    final /* synthetic */ boolean $showModelForEntrance;
    final /* synthetic */ wp2.b $sortInfoConfig;
    final /* synthetic */ int $subId;
    final /* synthetic */ List<UfsTabItemGroup> $tabList;
    int label;
    final /* synthetic */ SearchDataFetchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1(SearchDataFetchViewModel searchDataFetchViewModel, String str, boolean z16, String str2, byte[] bArr, boolean z17, List<UfsTabItemGroup> list, List<? extends x> list2, int i3, boolean z18, wp2.b bVar, Continuation<? super SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = searchDataFetchViewModel;
        this.$keyword = str;
        this.$isFirstReq = z16;
        this.$reqTime = str2;
        this.$cookie = bArr;
        this.$isEnd = z17;
        this.$tabList = list;
        this.$result = list2;
        this.$subId = i3;
        this.$showModelForEntrance = z18;
        this.$sortInfoConfig = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1(this.this$0, this.$keyword, this.$isFirstReq, this.$reqTime, this.$cookie, this.$isEnd, this.$tabList, this.$result, this.$subId, this.$showModelForEntrance, this.$sortInfoConfig, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.uniteSearchResultSuccessObservers;
            String str = this.$keyword;
            boolean z16 = this.$isFirstReq;
            String str2 = this.$reqTime;
            byte[] bArr = this.$cookie;
            boolean z17 = this.$isEnd;
            List<UfsTabItemGroup> list2 = this.$tabList;
            List<x> list3 = this.$result;
            int i3 = this.$subId;
            boolean z18 = this.$showModelForEntrance;
            wp2.b bVar = this.$sortInfoConfig;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                wp2.b bVar2 = bVar;
                boolean z19 = z18;
                int i16 = i3;
                ((b) it.next()).a(str, z16, str2, bArr, z17, list2, list3, i16, z19, bVar2);
                bVar = bVar2;
                z18 = z19;
                i3 = i16;
                list2 = list2;
                z17 = z17;
                bArr = bArr;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchDataFetchViewModel$handlerUniteSearchResultSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
