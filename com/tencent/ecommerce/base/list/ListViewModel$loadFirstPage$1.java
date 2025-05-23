package com.tencent.ecommerce.base.list;

import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.a;
import com.tencent.ecommerce.base.list.c;
import com.tencent.ecommerce.base.list.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.ListViewModel$loadFirstPage$1", f = "ListViewModel.kt", i = {2, 3}, l = {196, 211, 265, 266}, m = "invokeSuspend", n = {"loadFirstPageFromServerJob", "databaseResult"}, s = {"L$0", "L$0"})
/* loaded from: classes32.dex */
public final class ListViewModel$loadFirstPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewModel$loadFirstPage$1(ListViewModel listViewModel, f fVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = listViewModel;
        this.$request = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ListViewModel$loadFirstPage$1 listViewModel$loadFirstPage$1 = new ListViewModel$loadFirstPage$1(this.this$0, this.$request, continuation);
        listViewModel$loadFirstPage$1.L$0 = obj;
        return listViewModel$loadFirstPage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ListViewModel$loadFirstPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        List emptyList;
        Deferred async$default;
        Deferred async$default2;
        MutableStateFlow mutableStateFlow2;
        IListRepository.Result result;
        MutableSharedFlow mutableSharedFlow;
        c cVar;
        MutableStateFlow mutableStateFlow3;
        Object await;
        IListRepository.Result result2;
        MutableStateFlow mutableStateFlow4;
        List emptyList2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                result = (IListRepository.Result) obj;
                if (result.isSucceeded) {
                    mutableSharedFlow = this.this$0._uiEvent;
                    g.a aVar = g.a.f100794a;
                    this.label = 2;
                    if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (result.d().isEmpty()) {
                        cVar = c.d.f100780a;
                    } else {
                        cVar = c.g.f100783a;
                    }
                    c cVar2 = cVar;
                    mutableStateFlow3 = this.this$0._uiState;
                    mutableStateFlow3.setValue(new h(result.d(), a.c.f100774a, result.hasMore, cVar2, result.c()));
                }
                return Unit.INSTANCE;
            }
            if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    result2 = (IListRepository.Result) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((IListRepository.Result) obj).isSucceeded && result2.d().isEmpty()) {
                        mutableStateFlow4 = this.this$0._uiState;
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        mutableStateFlow4.setValue(new h(emptyList2, a.c.f100774a, false, c.e.f100781a, null));
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            async$default2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
            IListRepository.Result result3 = (IListRepository.Result) obj;
            this.L$0 = result3;
            this.label = 4;
            await = async$default2.await(this);
            if (await != coroutine_suspended) {
                return coroutine_suspended;
            }
            result2 = result3;
            obj = await;
            if (!((IListRepository.Result) obj).isSucceeded) {
                mutableStateFlow4 = this.this$0._uiState;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                mutableStateFlow4.setValue(new h(emptyList2, a.c.f100774a, false, c.e.f100781a, null));
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IListRepository.Result loadFromMemory = this.this$0.repository.loadFromMemory(this.$request);
        if (!loadFromMemory.d().isEmpty()) {
            mutableStateFlow2 = this.this$0._uiState;
            mutableStateFlow2.setValue(new h(loadFromMemory.d(), a.b.f100773a, loadFromMemory.hasMore, c.g.f100783a, loadFromMemory.c()));
            IListRepository iListRepository = this.this$0.repository;
            f fVar = this.$request;
            this.label = 1;
            obj = iListRepository.loadFirstPageFromServer(fVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            result = (IListRepository.Result) obj;
            if (result.isSucceeded) {
            }
            return Unit.INSTANCE;
        }
        mutableStateFlow = this.this$0._uiState;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableStateFlow.setValue(new h(emptyList, a.c.f100774a, false, c.f.f100782a, null, 16, null));
        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ListViewModel$loadFirstPage$1$loadFromDatabaseJob$1(this, null), 3, null);
        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ListViewModel$loadFirstPage$1$loadFirstPageFromServerJob$1(this, async$default, null), 3, null);
        this.L$0 = async$default2;
        this.label = 3;
        obj = async$default.await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        IListRepository.Result result32 = (IListRepository.Result) obj;
        this.L$0 = result32;
        this.label = 4;
        await = async$default2.await(this);
        if (await != coroutine_suspended) {
        }
    }
}
