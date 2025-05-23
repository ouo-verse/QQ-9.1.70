package com.tencent.ecommerce.biz.detail.repo.saas;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.view.FilterEnum;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2", f = "ECDetailCustomRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECDetailCustomRepo$requestCustomLiveData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $method;
    final /* synthetic */ JSONObject $requestParams;
    final /* synthetic */ String $service;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECDetailCustomRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2$1", f = "ECDetailCustomRepo.kt", i = {1, 1}, l = {218, 446}, m = "invokeSuspend", n = {"response", "$this$withLock$iv"}, s = {"L$0", "L$1"})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2$1, reason: invalid class name */
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

        /* JADX WARN: Removed duplicated region for block: B:15:0x00ad A[Catch: all -> 0x00bc, TryCatch #0 {all -> 0x00bc, blocks: (B:7:0x007e, B:9:0x0094, B:10:0x00b4, B:15:0x00ad), top: B:6:0x007e }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0094 A[Catch: all -> 0x00bc, TryCatch #0 {all -> 0x00bc, blocks: (B:7:0x007e, B:9:0x0094, B:10:0x00b4, B:15:0x00ad), top: B:6:0x007e }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ECNetworkResponse eCNetworkResponse;
            Mutex mutex;
            Mutex mutex2;
            List list;
            List list2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.mediaProductId);
                jSONObject.put("seller_id", ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.mediaId);
                jSONObject.put("goods_type", ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.goodsType);
                com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                this.label = 1;
                obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.shop_url_distribute_svr.ShopUrlDistribute", "/trpc.ecom.shop_url_distribute_svr.ShopUrlDistribute/GetShopJumpInfo", bVar, jSONObject, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        mutex2 = (Mutex) this.L$1;
                        eCNetworkResponse = (ECNetworkResponse) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            list = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
                            if (!((Collection) list.get(0)).isEmpty()) {
                                ECDetailCustomRepo$requestCustomLiveData$2.this.this$0._realTimeResponse = eCNetworkResponse;
                            } else {
                                ECDetailCustomRepo eCDetailCustomRepo = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0;
                                list2 = eCDetailCustomRepo.dataSourcePts;
                                eCDetailCustomRepo.q((List) list2.get(0), eCNetworkResponse);
                                ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.r();
                            }
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            mutex2.unlock(null);
                            throw th5;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            eCNetworkResponse = (ECNetworkResponse) obj;
            mutex = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.mutex;
            this.L$0 = eCNetworkResponse;
            this.L$1 = mutex;
            this.label = 2;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            list = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
            if (!((Collection) list.get(0)).isEmpty()) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2$2", f = "ECDetailCustomRepo.kt", i = {1, 1}, l = {243, 446}, m = "invokeSuspend", n = {"detailData", "$this$withLock$iv"}, s = {"L$0", "L$1"})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2$2, reason: invalid class name */
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

        /* JADX WARN: Removed duplicated region for block: B:9:0x0088 A[Catch: all -> 0x00af, TryCatch #0 {all -> 0x00af, blocks: (B:7:0x0074, B:9:0x0088, B:10:0x009a), top: B:6:0x0074 }] */
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
            List list2;
            k kVar2;
            List list3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ECDetailCustomRepo$requestCustomLiveData$2 eCDetailCustomRepo$requestCustomLiveData$2 = ECDetailCustomRepo$requestCustomLiveData$2.this;
                ECDetailCustomRepo eCDetailCustomRepo = eCDetailCustomRepo$requestCustomLiveData$2.this$0;
                String str = eCDetailCustomRepo$requestCustomLiveData$2.$service;
                String str2 = eCDetailCustomRepo$requestCustomLiveData$2.$method;
                JSONObject jSONObject = eCDetailCustomRepo$requestCustomLiveData$2.$requestParams;
                this.label = 1;
                obj = eCDetailCustomRepo.t(str, str2, jSONObject, this);
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
                            list2 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
                            if (((List) list2.get(0)).isEmpty()) {
                                list3 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
                                list3.set(0, list);
                                ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.r();
                            }
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            d dVar = d.f102466a;
                            kVar2 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.showPageCostTime;
                            dVar.r(kVar2, false, 2);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            mutex2.unlock(null);
                            throw th5;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list4 = (List) obj;
            if (list4 == null) {
                list4 = CollectionsKt__CollectionsKt.emptyList();
            }
            list = list4;
            if (!list.isEmpty()) {
                mutex = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.mutex;
                this.L$0 = list;
                this.L$1 = mutex;
                this.label = 2;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                list2 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
                if (((List) list2.get(0)).isEmpty()) {
                }
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                d dVar2 = d.f102466a;
                kVar2 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.showPageCostTime;
                dVar2.r(kVar2, false, 2);
                return Unit.INSTANCE;
            }
            d dVar3 = d.f102466a;
            kVar = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.showPageCostTime;
            dVar3.r(kVar, false, 3);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2$3", f = "ECDetailCustomRepo.kt", i = {1, 1}, l = {FilterEnum.MIC_PTU_ZIRAN, 446}, m = "invokeSuspend", n = {"relateData", "$this$withLock$iv"}, s = {"L$0", "L$1"})
    /* renamed from: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$requestCustomLiveData$2$3, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x00b3 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:7:0x0092, B:9:0x00b3, B:10:0x00ba), top: B:6:0x0092 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ECDetailCustomRelatedRepo k3;
            ECDetailCustomRelatedRepo k16;
            List<ECBasePtsViewData> a16;
            Mutex mutex;
            Mutex mutex2;
            List list;
            List list2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("media_id", ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.mediaId);
                jSONObject.put("cookie", "");
                jSONObject.put("source", 2);
                k3 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.k();
                this.label = 1;
                obj = k3.c("trpc.ecom.show_window_svr.ShowWindowSvr", "/trpc.ecom.show_window_svr.ShowWindowSvr/ViewProducts", jSONObject, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        mutex2 = (Mutex) this.L$1;
                        a16 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            list = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
                            list.set(1, a16);
                            list2 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
                            if (!((Collection) list2.get(0)).isEmpty()) {
                                ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.r();
                            }
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            mutex2.unlock(null);
                            throw th5;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            k16 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.k();
            a16 = k16.a(jSONObject2, ECDetailCustomRepo$requestCustomLiveData$2.this.$requestParams);
            mutex = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.mutex;
            this.L$0 = a16;
            this.L$1 = mutex;
            this.label = 2;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            list = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
            list.set(1, a16);
            list2 = ECDetailCustomRepo$requestCustomLiveData$2.this.this$0.dataSourcePts;
            if (!((Collection) list2.get(0)).isEmpty()) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDetailCustomRepo$requestCustomLiveData$2(ECDetailCustomRepo eCDetailCustomRepo, String str, String str2, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCDetailCustomRepo;
        this.$service = str;
        this.$method = str2;
        this.$requestParams = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECDetailCustomRepo$requestCustomLiveData$2 eCDetailCustomRepo$requestCustomLiveData$2 = new ECDetailCustomRepo$requestCustomLiveData$2(this.this$0, this.$service, this.$method, this.$requestParams, continuation);
        eCDetailCustomRepo$requestCustomLiveData$2.L$0 = obj;
        return eCDetailCustomRepo$requestCustomLiveData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECDetailCustomRepo$requestCustomLiveData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        ECDetailCustomRelatedRepo k3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.this$0.getNeedDetail()) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass1(null), 2, null);
            }
            list = this.this$0.dataSourcePts;
            if (!(!((Collection) list.get(0)).isEmpty())) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass2(null), 2, null);
            }
            ECLocalConfig eCLocalConfig = ECLocalConfig.f100650f;
            k3 = this.this$0.k();
            String string = eCLocalConfig.getString(k3.b(this.this$0.mediaId), "", Boxing.boxBoolean(true));
            if (this.this$0.getNeedDetail() && TextUtils.isEmpty(string)) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass3(null), 2, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
