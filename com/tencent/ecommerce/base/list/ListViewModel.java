package com.tencent.ecommerce.base.list;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.a;
import com.tencent.ecommerce.base.list.c;
import com.tencent.ecommerce.base.list.e;
import com.tencent.ecommerce.base.list.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\u00020\u0005:\u0001,B!\u0012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001d\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0002J\u0016\u0010\r\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0002J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0010R&\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00140!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/base/list/ListViewModel;", "Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/base/list/e$c;", "event", "", "W1", "Lcom/tencent/ecommerce/base/list/e$a;", "T1", "Lcom/tencent/ecommerce/base/list/e$b;", "U1", Const.BUNDLE_KEY_REQUEST, ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Lcom/tencent/ecommerce/base/list/f;)V", "X1", "Z1", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/ecommerce/base/list/h;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_uiState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/base/list/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_uiEvent", "Lcom/tencent/ecommerce/base/list/IListRepository;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/list/IListRepository;", "repository", "Lkotlinx/coroutines/flow/StateFlow;", "S1", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lkotlinx/coroutines/flow/SharedFlow;", "R1", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiEvent", "<init>", "(Lcom/tencent/ecommerce/base/list/IListRepository;)V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ListViewModel<REQUEST extends f, BEAN, EXTRA> extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final IListRepository<REQUEST, BEAN, EXTRA> repository;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<h<BEAN, EXTRA>> _uiState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableSharedFlow<g> _uiEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.base.list.ListViewModel$1", f = "ListViewModel.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.base.list.ListViewModel$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.base.list.ListViewModel$1$a */
        /* loaded from: classes32.dex */
        public static final class a implements FlowCollector<e<BEAN>> {
            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                e eVar = (e) obj;
                if (eVar instanceof e.b) {
                    ListViewModel.this.U1((e.b) eVar);
                } else if (eVar instanceof e.a) {
                    ListViewModel.this.T1((e.a) eVar);
                } else if (eVar instanceof e.c) {
                    ListViewModel.this.W1((e.c) eVar);
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<e<BEAN>> operatorEvent = ListViewModel.this.repository.getOperatorEvent();
                a aVar = new a();
                this.label = 1;
                if (operatorEvent.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public ListViewModel(IListRepository<REQUEST, BEAN, EXTRA> iListRepository) {
        List emptyList;
        this.repository = iListRepository;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this._uiState = StateFlowKt.MutableStateFlow(new h(emptyList, a.c.f100774a, false, c.f.f100782a, null, 16, null));
        this._uiEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(e.a<BEAN> event) {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this._uiState.getValue().a());
        mutableList.add(event.bean);
        c cVar = this._uiState.getValue().listUiState;
        if (Intrinsics.areEqual(cVar, c.e.f100781a) || Intrinsics.areEqual(cVar, c.d.f100780a)) {
            cVar = c.g.f100783a;
        }
        c cVar2 = cVar;
        MutableStateFlow<h<BEAN, EXTRA>> mutableStateFlow = this._uiState;
        h<BEAN, EXTRA> value = mutableStateFlow.getValue();
        mutableStateFlow.setValue(new h<>(mutableList, value.dataCacheLevel, value.hasMore, cVar2, value.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(final e.b<BEAN> event) {
        List mutableList;
        c cVar;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this._uiState.getValue().a());
        CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<BEAN, Boolean>() { // from class: com.tencent.ecommerce.base.list.ListViewModel$handleRemoveEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke2((ListViewModel$handleRemoveEvent$1<BEAN>) obj));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(BEAN bean) {
                return e.b.this.a().invoke(bean).booleanValue();
            }
        });
        c cVar2 = this._uiState.getValue().listUiState;
        if (!mutableList.isEmpty()) {
            MutableStateFlow<h<BEAN, EXTRA>> mutableStateFlow = this._uiState;
            h<BEAN, EXTRA> value = mutableStateFlow.getValue();
            mutableStateFlow.setValue(new h<>(mutableList, value.dataCacheLevel, value.hasMore, value.listUiState, value.b()));
            return;
        }
        if (Intrinsics.areEqual(cVar2, c.g.f100783a) || Intrinsics.areEqual(cVar2, c.j.f100786a) || Intrinsics.areEqual(cVar2, c.C1031c.f100779a)) {
            cVar2 = c.d.f100780a;
        } else {
            c.e eVar = c.e.f100781a;
            if (Intrinsics.areEqual(cVar2, eVar) || Intrinsics.areEqual(cVar2, c.h.f100784a) || Intrinsics.areEqual(cVar2, c.a.f100777a)) {
                cVar = eVar;
                MutableStateFlow<h<BEAN, EXTRA>> mutableStateFlow2 = this._uiState;
                h<BEAN, EXTRA> value2 = mutableStateFlow2.getValue();
                mutableStateFlow2.setValue(new h<>(mutableList, value2.dataCacheLevel, value2.hasMore, cVar, value2.b()));
            }
        }
        cVar = cVar2;
        MutableStateFlow<h<BEAN, EXTRA>> mutableStateFlow22 = this._uiState;
        h<BEAN, EXTRA> value22 = mutableStateFlow22.getValue();
        mutableStateFlow22.setValue(new h<>(mutableList, value22.dataCacheLevel, value22.hasMore, cVar, value22.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(e.c<BEAN> event) {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this._uiState.getValue().a());
        int i3 = 0;
        for (Object obj : mutableList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) event.a().invoke(obj)).booleanValue()) {
                mutableList.set(i3, event.bean);
            }
            i3 = i16;
        }
        MutableStateFlow<h<BEAN, EXTRA>> mutableStateFlow = this._uiState;
        h<BEAN, EXTRA> value = mutableStateFlow.getValue();
        mutableStateFlow.setValue(new h<>(mutableList, value.dataCacheLevel, value.hasMore, value.listUiState, value.b()));
    }

    public final SharedFlow<g> R1() {
        return this._uiEvent;
    }

    public final StateFlow<h<BEAN, EXTRA>> S1() {
        return this._uiState;
    }

    public final void X1(REQUEST request) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ListViewModel$loadFirstPage$1(this, request, null), 3, null);
    }

    public final void Z1(REQUEST request) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ListViewModel$loadNextPage$1(this, request, null), 3, null);
    }

    public final void a2(REQUEST request) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ListViewModel$refreshPage$1(this, request, null), 3, null);
    }
}
