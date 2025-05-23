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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.ListViewModel$refreshPage$1", f = "ListViewModel.kt", i = {}, l = {154, 176}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class ListViewModel$refreshPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $request;
    int label;
    final /* synthetic */ ListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewModel$refreshPage$1(ListViewModel listViewModel, f fVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listViewModel;
        this.$request = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListViewModel$refreshPage$1(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ListViewModel$refreshPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        MutableSharedFlow mutableSharedFlow;
        MutableStateFlow mutableStateFlow5;
        c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._uiState;
            mutableStateFlow2 = this.this$0._uiState;
            h hVar = (h) mutableStateFlow2.getValue();
            mutableStateFlow.setValue(new h(hVar.a(), a.b.f100773a, hVar.hasMore, c.i.f100785a, hVar.b()));
            IListRepository iListRepository = this.this$0.repository;
            f fVar = this.$request;
            this.label = 1;
            obj = iListRepository.loadFirstPageFromServer(fVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        IListRepository.Result result = (IListRepository.Result) obj;
        if (!result.isSucceeded) {
            mutableStateFlow3 = this.this$0._uiState;
            mutableStateFlow4 = this.this$0._uiState;
            h hVar2 = (h) mutableStateFlow4.getValue();
            mutableStateFlow3.setValue(new h(hVar2.a(), a.b.f100773a, hVar2.hasMore, c.h.f100784a, hVar2.b()));
            mutableSharedFlow = this.this$0._uiEvent;
            g.c cVar2 = g.c.f100796a;
            this.label = 2;
            if (mutableSharedFlow.emit(cVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(result.d());
            mutableStateFlow5 = this.this$0._uiState;
            a.c cVar3 = a.c.f100774a;
            boolean z16 = result.hasMore;
            if (arrayList.isEmpty()) {
                cVar = c.d.f100780a;
            } else {
                cVar = c.j.f100786a;
            }
            mutableStateFlow5.setValue(new h(arrayList, cVar3, z16, cVar, result.c()));
        }
        return Unit.INSTANCE;
    }
}
