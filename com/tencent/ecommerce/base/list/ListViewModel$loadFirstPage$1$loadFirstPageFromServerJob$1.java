package com.tencent.ecommerce.base.list;

import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.a;
import com.tencent.ecommerce.base.list.c;
import com.tencent.ecommerce.base.list.g;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Add missing generic type declarations: [EXTRA, BEAN] */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.ListViewModel$loadFirstPage$1$loadFirstPageFromServerJob$1", f = "ListViewModel.kt", i = {1}, l = {250, 261}, m = "invokeSuspend", n = {"serverResult"}, s = {"L$0"})
/* loaded from: classes32.dex */
final class ListViewModel$loadFirstPage$1$loadFirstPageFromServerJob$1<BEAN, EXTRA> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IListRepository.Result<BEAN, EXTRA>>, Object> {
    final /* synthetic */ Deferred $loadFromDatabaseJob;
    Object L$0;
    int label;
    final /* synthetic */ ListViewModel$loadFirstPage$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewModel$loadFirstPage$1$loadFirstPageFromServerJob$1(ListViewModel$loadFirstPage$1 listViewModel$loadFirstPage$1, Deferred deferred, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listViewModel$loadFirstPage$1;
        this.$loadFromDatabaseJob = deferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListViewModel$loadFirstPage$1$loadFirstPageFromServerJob$1(this.this$0, this.$loadFromDatabaseJob, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((ListViewModel$loadFirstPage$1$loadFirstPageFromServerJob$1) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        IListRepository.Result result;
        MutableStateFlow mutableStateFlow;
        c cVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IListRepository iListRepository = this.this$0.this$0.repository;
            f fVar = this.this$0.$request;
            this.label = 1;
            obj = iListRepository.loadFirstPageFromServer(fVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    result = (IListRepository.Result) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return result;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        IListRepository.Result result2 = (IListRepository.Result) obj;
        if (!result2.isSucceeded) {
            mutableSharedFlow = this.this$0.this$0._uiEvent;
            g.a aVar = g.a.f100794a;
            this.L$0 = result2;
            this.label = 2;
            if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            result = result2;
            return result;
        }
        Job.DefaultImpls.cancel$default((Job) this.$loadFromDatabaseJob, (CancellationException) null, 1, (Object) null);
        mutableStateFlow = this.this$0.this$0._uiState;
        List<BEAN> d16 = result2.d();
        a.c cVar2 = a.c.f100774a;
        boolean z16 = result2.hasMore;
        if (result2.d().isEmpty()) {
            cVar = c.d.f100780a;
        } else {
            cVar = c.g.f100783a;
        }
        mutableStateFlow.setValue(new h(d16, cVar2, z16, cVar, result2.c()));
        return result2;
    }
}
