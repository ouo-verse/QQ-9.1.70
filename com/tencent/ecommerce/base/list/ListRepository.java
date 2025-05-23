package com.tencent.ecommerce.base.list;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.e;
import com.tencent.ecommerce.base.list.f;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0019\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b#\u0010$J#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0016J'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\rJ/\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R'\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00130\u00128VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/base/list/ListRepository;", "Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lcom/tencent/ecommerce/base/list/IListRepository;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "e", "(Lcom/tencent/ecommerce/base/list/f;)Lcom/tencent/ecommerce/base/list/IListRepository$a;", "", "clearMemoryCache", "d", "(Lcom/tencent/ecommerce/base/list/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "extra", "f", "(Lcom/tencent/ecommerce/base/list/f;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/tencent/ecommerce/base/list/e;", "a", "Lkotlin/Lazy;", "getOperatorEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "operatorEvent", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "b", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "dataSource", "Lcom/tencent/ecommerce/base/list/b;", "Lcom/tencent/ecommerce/base/list/b;", JsonRuleKey.OPERATOR, "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lcom/tencent/ecommerce/base/list/BaseListDataSource;Lcom/tencent/ecommerce/base/list/b;Lkotlinx/coroutines/CoroutineDispatcher;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ListRepository<REQUEST extends f, BEAN, EXTRA> implements IListRepository<REQUEST, BEAN, EXTRA> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy operatorEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final BaseListDataSource<REQUEST, BEAN, EXTRA> dataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final b<BEAN> operator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/list/f;", "REQUEST", "BEAN", "EXTRA", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.base.list.ListRepository$1", f = "ListRepository.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.base.list.ListRepository$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.base.list.ListRepository$1$a */
        /* loaded from: classes32.dex */
        public static final class a implements FlowCollector<e<BEAN>> {
            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                e eVar = (e) obj;
                if (eVar instanceof e.b) {
                    ListRepository.this.dataSource.j(((e.b) eVar).a());
                } else if (eVar instanceof e.c) {
                    e.c cVar = (e.c) eVar;
                    ListRepository.this.dataSource.k(cVar.bean, cVar.a());
                } else if (eVar instanceof e.a) {
                    ListRepository.this.dataSource.a(((e.a) eVar).bean);
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
                SharedFlow<e<BEAN>> operatorEvent = ListRepository.this.getOperatorEvent();
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

    public ListRepository(BaseListDataSource<REQUEST, BEAN, EXTRA> baseListDataSource, b<BEAN> bVar, CoroutineDispatcher coroutineDispatcher) {
        Lazy lazy;
        this.dataSource = baseListDataSource;
        this.operator = bVar;
        this.coroutineDispatcher = coroutineDispatcher;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SharedFlow<? extends e<BEAN>>>() { // from class: com.tencent.ecommerce.base.list.ListRepository$operatorEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SharedFlow<e<BEAN>> invoke() {
                b bVar2;
                bVar2 = ListRepository.this.operator;
                return bVar2.b();
            }
        });
        this.operatorEvent = lazy;
    }

    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$4(ClassGen.java:360)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:361)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:327)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static final /* synthetic */ BaseListDataSource a(ListRepository listRepository) {
        return listRepository.dataSource;
    }

    @Override // com.tencent.ecommerce.base.list.IListRepository
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Object loadFirstPageFromServer(REQUEST request, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ListRepository$loadFirstPageFromServer$2(this, request, null), continuation);
    }

    @Override // com.tencent.ecommerce.base.list.IListRepository
    public void clearMemoryCache() {
        this.dataSource.b();
    }

    @Override // com.tencent.ecommerce.base.list.IListRepository
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object loadFromDatabase(REQUEST request, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ListRepository$loadFromDatabase$2(this, request, null), continuation);
    }

    @Override // com.tencent.ecommerce.base.list.IListRepository
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public IListRepository.Result<BEAN, EXTRA> loadFromMemory(REQUEST request) {
        return this.dataSource.g(request);
    }

    @Override // com.tencent.ecommerce.base.list.IListRepository
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object loadNextPageFromServer(REQUEST request, EXTRA extra, Continuation<? super IListRepository.Result<BEAN, EXTRA>> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ListRepository$loadNextPageFromServer$2(this, request, extra, null), continuation);
    }

    @Override // com.tencent.ecommerce.base.list.IListRepository
    public SharedFlow<e<BEAN>> getOperatorEvent() {
        return (SharedFlow) this.operatorEvent.getValue();
    }

    public /* synthetic */ ListRepository(BaseListDataSource baseListDataSource, b bVar, CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseListDataSource, (i3 & 2) != 0 ? new b() : bVar, (i3 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
