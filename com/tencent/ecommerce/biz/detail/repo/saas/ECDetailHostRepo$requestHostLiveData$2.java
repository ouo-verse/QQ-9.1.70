package com.tencent.ecommerce.biz.detail.repo.saas;

import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.detail.utils.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo$requestHostLiveData$2", f = "ECDetailHostRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECDetailHostRepo$requestHostLiveData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ String $method;
    final /* synthetic */ JSONObject $requestParams;
    final /* synthetic */ String $service;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECDetailHostRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo$requestHostLiveData$2$1", f = "ECDetailHostRepo.kt", i = {1, 1}, l = {138, 345}, m = "invokeSuspend", n = {"it", "$this$withLock$iv"}, s = {"L$0", "L$1"})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo$requestHostLiveData$2$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

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

        /* JADX WARN: Removed duplicated region for block: B:16:0x009f A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:7:0x0083, B:9:0x0091, B:10:0x00ac, B:16:0x009f), top: B:6:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0091 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:7:0x0083, B:9:0x0091, B:10:0x00ac, B:16:0x009f), top: B:6:0x0083 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            List list;
            Mutex mutex;
            Mutex mutex2;
            k kVar;
            k kVar2;
            List list2;
            List list3;
            List list4;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ECDetailHostRepo$requestHostLiveData$2 eCDetailHostRepo$requestHostLiveData$2 = ECDetailHostRepo$requestHostLiveData$2.this;
                ECDetailHostRepo eCDetailHostRepo = eCDetailHostRepo$requestHostLiveData$2.this$0;
                String str = eCDetailHostRepo$requestHostLiveData$2.$service;
                String str2 = eCDetailHostRepo$requestHostLiveData$2.$method;
                JSONObject jSONObject = eCDetailHostRepo$requestHostLiveData$2.$requestParams;
                this.label = 1;
                obj = eCDetailHostRepo.q(str, str2, jSONObject, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        mutex2 = (Mutex) this.L$1;
                        list = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            list2 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                            if (!list2.isEmpty()) {
                                list4 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                                list4.addAll(list);
                            } else {
                                list3 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                                list3.addAll(0, list);
                            }
                            ECDetailHostRepo$requestHostLiveData$2.this.this$0.p();
                            Unit unit = Unit.INSTANCE;
                            d dVar = d.f102466a;
                            kVar2 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.showPageCostTime;
                            dVar.r(kVar2, true, 2);
                            return Unit.INSTANCE;
                        } finally {
                            mutex2.unlock(null);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list5 = (List) obj;
            List list6 = list5;
            if (list6 == null || list6.isEmpty()) {
                ECDetailHostRepo$requestHostLiveData$2 eCDetailHostRepo$requestHostLiveData$22 = ECDetailHostRepo$requestHostLiveData$2.this;
                list5 = eCDetailHostRepo$requestHostLiveData$22.this$0.m(eCDetailHostRepo$requestHostLiveData$22.$requestParams);
                d dVar2 = d.f102466a;
                kVar = ECDetailHostRepo$requestHostLiveData$2.this.this$0.showPageCostTime;
                dVar2.r(kVar, true, 3);
            }
            list = list5;
            if (list != null) {
                mutex = ECDetailHostRepo$requestHostLiveData$2.this.this$0.mutex;
                this.L$0 = list;
                this.L$1 = mutex;
                this.label = 2;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                list2 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                if (!list2.isEmpty()) {
                }
                ECDetailHostRepo$requestHostLiveData$2.this.this$0.p();
                Unit unit2 = Unit.INSTANCE;
            }
            d dVar3 = d.f102466a;
            kVar2 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.showPageCostTime;
            dVar3.r(kVar2, true, 2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo$requestHostLiveData$2$2", f = "ECDetailHostRepo.kt", i = {1, 1}, l = {181, 345}, m = "invokeSuspend", n = {"it", "$this$withLock$iv"}, s = {"L$0", "L$1"})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo$requestHostLiveData$2$2, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0095 A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:7:0x0075, B:10:0x0086, B:12:0x0095, B:13:0x009c), top: B:6:0x0075 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0085  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ECDetailHostRelatedRepo j3;
            List list;
            Mutex mutex;
            Mutex mutex2;
            List list2;
            boolean z16;
            List list3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                e eVar = e.f102467a;
                ECDetailHostRepo eCDetailHostRepo = ECDetailHostRepo$requestHostLiveData$2.this.this$0;
                JSONObject a16 = eVar.a(eCDetailHostRepo.goodsType, eCDetailHostRepo.categoryName, eCDetailHostRepo.com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment.KEY_THEME java.lang.String, false);
                j3 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.j();
                String str = ECDetailHostRepo$requestHostLiveData$2.this.this$0.categoryId;
                this.label = 1;
                obj = j3.c("trpc.ecom.select_product_list_svr.SelectProductListSvr", "/trpc.ecom.select_product_list_svr.SelectProductListSvr/SelectProductList", str, a16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        mutex2 = (Mutex) this.L$1;
                        list = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            list2 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                            z16 = list2.isEmpty() ? false : true;
                            list3 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                            list3.addAll(list);
                            if (z16) {
                                ECDetailHostRepo$requestHostLiveData$2.this.this$0.p();
                            }
                            Unit unit = Unit.INSTANCE;
                            return Unit.INSTANCE;
                        } finally {
                            mutex2.unlock(null);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            list = (List) obj;
            if (list != null) {
                mutex = ECDetailHostRepo$requestHostLiveData$2.this.this$0.mutex;
                this.L$0 = list;
                this.L$1 = mutex;
                this.label = 2;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                list2 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                if (list2.isEmpty()) {
                }
                list3 = ECDetailHostRepo$requestHostLiveData$2.this.this$0.detailDataList;
                list3.addAll(list);
                if (z16) {
                }
                Unit unit2 = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDetailHostRepo$requestHostLiveData$2(ECDetailHostRepo eCDetailHostRepo, String str, String str2, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCDetailHostRepo;
        this.$service = str;
        this.$method = str2;
        this.$requestParams = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECDetailHostRepo$requestHostLiveData$2 eCDetailHostRepo$requestHostLiveData$2 = new ECDetailHostRepo$requestHostLiveData$2(this.this$0, this.$service, this.$method, this.$requestParams, continuation);
        eCDetailHostRepo$requestHostLiveData$2.L$0 = obj;
        return eCDetailHostRepo$requestHostLiveData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((ECDetailHostRepo$requestHostLiveData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass1(null), 2, null);
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass2(null), 2, null);
            return launch$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
