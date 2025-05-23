package com.tencent.ecommerce.base.list;

import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.a;
import com.tencent.ecommerce.base.list.c;
import com.tencent.ecommerce.base.list.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.ListViewModel$loadNextPage$1", f = "ListViewModel.kt", i = {}, l = {297, 320}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class ListViewModel$loadNextPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $request;
    int label;
    final /* synthetic */ ListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewModel$loadNextPage$1(ListViewModel listViewModel, f fVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listViewModel;
        this.$request = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListViewModel$loadNextPage$1(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ListViewModel$loadNextPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        IListRepository.Result result;
        MutableStateFlow mutableStateFlow7;
        MutableStateFlow mutableStateFlow8;
        MutableSharedFlow mutableSharedFlow;
        MutableStateFlow mutableStateFlow9;
        MutableStateFlow mutableStateFlow10;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._uiState;
            Object b16 = ((h) mutableStateFlow.getValue()).b();
            if (b16 != null) {
                mutableStateFlow4 = this.this$0._uiState;
                c cVar = ((h) mutableStateFlow4.getValue()).listUiState;
                c.b bVar = c.b.f100778a;
                if (!Intrinsics.areEqual(cVar, bVar)) {
                    mutableStateFlow5 = this.this$0._uiState;
                    mutableStateFlow6 = this.this$0._uiState;
                    h hVar = (h) mutableStateFlow6.getValue();
                    mutableStateFlow5.setValue(new h(hVar.a(), a.b.f100773a, hVar.hasMore, bVar, hVar.b()));
                    IListRepository iListRepository = this.this$0.repository;
                    f fVar = this.$request;
                    this.label = 1;
                    obj = iListRepository.loadNextPageFromServer(fVar, b16, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    result = (IListRepository.Result) obj;
                    if (result.isSucceeded) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                cg0.a.a("ListViewModel", "loadNextPage", "loadNextPage must apply _cookie");
                mutableStateFlow2 = this.this$0._uiState;
                mutableStateFlow3 = this.this$0._uiState;
                h hVar2 = (h) mutableStateFlow3.getValue();
                mutableStateFlow2.setValue(new h(hVar2.a(), a.b.f100773a, hVar2.hasMore, c.a.f100777a, hVar2.b()));
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            result = (IListRepository.Result) obj;
            if (result.isSucceeded) {
                mutableStateFlow7 = this.this$0._uiState;
                mutableStateFlow8 = this.this$0._uiState;
                h hVar3 = (h) mutableStateFlow8.getValue();
                mutableStateFlow7.setValue(new h(hVar3.a(), a.b.f100773a, hVar3.hasMore, c.a.f100777a, hVar3.b()));
                mutableSharedFlow = this.this$0._uiEvent;
                g.b bVar2 = g.b.f100795a;
                this.label = 2;
                if (mutableSharedFlow.emit(bVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                mutableStateFlow9 = this.this$0._uiState;
                arrayList.addAll(((h) mutableStateFlow9.getValue()).a());
                arrayList.addAll(result.d());
                mutableStateFlow10 = this.this$0._uiState;
                mutableStateFlow10.setValue(new h(arrayList, a.c.f100774a, result.hasMore, c.C1031c.f100779a, result.c()));
            }
        } else if (i3 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
