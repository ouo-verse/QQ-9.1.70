package com.tencent.ecommerce.base.list;

import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.a;
import com.tencent.ecommerce.base.list.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Add missing generic type declarations: [EXTRA, BEAN] */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.ListViewModel$loadFirstPage$1$loadFromDatabaseJob$1", f = "ListViewModel.kt", i = {}, l = {236}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
final class ListViewModel$loadFirstPage$1$loadFromDatabaseJob$1<BEAN, EXTRA> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IListRepository.Result<BEAN, EXTRA>>, Object> {
    int label;
    final /* synthetic */ ListViewModel$loadFirstPage$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewModel$loadFirstPage$1$loadFromDatabaseJob$1(ListViewModel$loadFirstPage$1 listViewModel$loadFirstPage$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listViewModel$loadFirstPage$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListViewModel$loadFirstPage$1$loadFromDatabaseJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((ListViewModel$loadFirstPage$1$loadFromDatabaseJob$1) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IListRepository iListRepository = this.this$0.this$0.repository;
            f fVar = this.this$0.$request;
            this.label = 1;
            obj = iListRepository.loadFromDatabase(fVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IListRepository.Result result = (IListRepository.Result) obj;
        if (!result.d().isEmpty()) {
            mutableStateFlow = this.this$0.this$0._uiState;
            mutableStateFlow.setValue(new h(result.d(), a.C1030a.f100772a, result.hasMore, c.g.f100783a, result.c()));
        }
        return result;
    }
}
