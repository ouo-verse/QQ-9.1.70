package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import com.tencent.zplan.record.provider.CloudCacheProvider;
import com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.CloudCacheProvider$recordBatch$1", f = "CloudCacheProvider.kt", i = {0, 0, 0, 0, 1}, l = {111, 271, 185}, m = "invokeSuspend", n = {"$this$callbackFlow", "count", "statisticMap", "cacheResultList", "$this$callbackFlow"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes27.dex */
public final class CloudCacheProvider$recordBatch$1 extends SuspendLambda implements Function2<ProducerScope<? super ZPlanRecordResource>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $batchKey;
    final /* synthetic */ BatchRecordRequestParams $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CloudCacheProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.tencent.zplan.record.provider.CloudCacheProvider$recordBatch$1$2", f = "CloudCacheProvider.kt", i = {0, 0}, l = {113, 248}, m = "invokeSuspend", n = {"$this$withTimeout", "timeStart"}, s = {"L$0", "J$0"})
    /* renamed from: com.tencent.zplan.record.provider.CloudCacheProvider$recordBatch$1$2, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MemeZPlanBatchAction $action;
        final /* synthetic */ List $cacheResultList;
        final /* synthetic */ Ref.IntRef $count;
        final /* synthetic */ Map $statisticMap;
        final /* synthetic */ ProducerScope $this_callbackFlow;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ProducerScope producerScope, Ref.IntRef intRef, MemeZPlanBatchAction memeZPlanBatchAction, Map map, List list, Continuation continuation) {
            super(2, continuation);
            this.$this_callbackFlow = producerScope;
            this.$count = intRef;
            this.$action = memeZPlanBatchAction;
            this.$statisticMap = map;
            this.$cacheResultList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_callbackFlow, this.$count, this.$action, this.$statisticMap, this.$cacheResultList, completion);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            long j3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = this.J$0;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                long currentTimeMillis = System.currentTimeMillis();
                CloudCacheProvider$recordBatch$1 cloudCacheProvider$recordBatch$1 = CloudCacheProvider$recordBatch$1.this;
                CloudCacheProvider cloudCacheProvider = cloudCacheProvider$recordBatch$1.this$0;
                BatchRecordRequestParams batchRecordRequestParams = cloudCacheProvider$recordBatch$1.$params;
                this.L$0 = coroutineScope;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = cloudCacheProvider.l(batchRecordRequestParams, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis;
            }
            Flow take = FlowKt.take((Flow) obj, this.$count.element);
            CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1 cloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1 = new CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1(this, coroutineScope, j3);
            this.L$0 = null;
            this.label = 2;
            if (take.collect(cloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements FlowCollector<ZPlanRecordResource> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProducerScope f386103d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f386104e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f386105f;

        public a(ProducerScope producerScope, List list, AtomicInteger atomicInteger) {
            this.f386103d = producerScope;
            this.f386104e = list;
            this.f386105f = atomicInteger;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(ZPlanRecordResource zPlanRecordResource, @NotNull Continuation<? super Unit> continuation) {
            this.f386103d.mo2003trySendJP2dKIU(zPlanRecordResource);
            if (this.f386105f.addAndGet(1) == this.f386104e.size()) {
                SendChannel.DefaultImpls.close$default(this.f386103d, null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudCacheProvider$recordBatch$1(CloudCacheProvider cloudCacheProvider, BatchRecordRequestParams batchRecordRequestParams, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = cloudCacheProvider;
        this.$params = batchRecordRequestParams;
        this.$batchKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        CloudCacheProvider$recordBatch$1 cloudCacheProvider$recordBatch$1 = new CloudCacheProvider$recordBatch$1(this.this$0, this.$params, this.$batchKey, completion);
        cloudCacheProvider$recordBatch$1.L$0 = obj;
        return cloudCacheProvider$recordBatch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ZPlanRecordResource> producerScope, Continuation<? super Unit> continuation) {
        return ((CloudCacheProvider$recordBatch$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x038c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01a0 A[LOOP:0: B:21:0x019a->B:23:0x01a0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0137 A[LOOP:4: B:82:0x0131->B:84:0x0137, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0164  */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        LinkedHashMap linkedHashMap;
        Object obj2;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        List list;
        ProducerScope producerScope;
        long b16;
        int collectionSizeOrDefault;
        Iterator it;
        List minus;
        int collectionSizeOrDefault2;
        Iterator it5;
        Iterator it6;
        ArrayList arrayList;
        int collectionSizeOrDefault3;
        Set set;
        List minus2;
        BatchRecordRequestParams n3;
        int collectionSizeOrDefault4;
        Function0 function0;
        Flow<ZPlanRecordResource> asFlow;
        ProducerScope producerScope2;
        com.tencent.zplan.record.provider.helper.a i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                producerScope2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = coroutine_suspended;
                function0 = null;
                this.L$0 = function0;
                this.label = 3;
                if (ProduceKt.awaitClose$default(producerScope2, function0, this, 1, function0) == obj2) {
                    return obj2;
                }
                return Unit.INSTANCE;
            }
            list = (List) this.L$3;
            ?? r16 = (Map) this.L$2;
            intRef2 = (Ref.IntRef) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                linkedHashMap = r16;
                obj2 = coroutine_suspended;
            } catch (TimeoutCancellationException unused) {
                linkedHashMap = r16;
                obj2 = coroutine_suspended;
                List<Integer> x16 = this.$params.x();
                List list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                it = list2.iterator();
                while (it.hasNext()) {
                }
                minus = CollectionsKt___CollectionsKt.minus((Iterable) x16, (Iterable) arrayList2);
                List list3 = minus;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                it5 = list3.iterator();
                while (it5.hasNext()) {
                }
                list.addAll(arrayList3);
                it6 = linkedHashMap.values().iterator();
                while (it6.hasNext()) {
                }
                arrayList = new ArrayList();
                while (r4.hasNext()) {
                }
                if (arrayList.size() == intRef2.element) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope3 = (ProducerScope) this.L$0;
            MemeZPlanBatchAction a16 = this.$params.a();
            Ref.IntRef intRef3 = new Ref.IntRef();
            intRef3.element = a16.batchCount();
            d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.c(a17, "[ZPlanRRC]CloudCacheProvider", 1, "recordBatch start, batchKey:" + this.$batchKey + ", count:" + intRef3.element + ", params:" + this.$params, null, 8, null);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it7 = this.$params.x().iterator();
            while (it7.hasNext()) {
                int intValue = ((Number) it7.next()).intValue();
                linkedHashMap2.put(Boxing.boxInt(intValue), ZPlanRecordResourceStatistic.INSTANCE.b(Source.CLOUD_CACHE, intValue, this.$params));
            }
            ArrayList arrayList4 = new ArrayList();
            try {
                b16 = CloudCacheProvider.INSTANCE.b();
                linkedHashMap = linkedHashMap2;
                intRef = intRef3;
            } catch (TimeoutCancellationException unused2) {
                linkedHashMap = linkedHashMap2;
                obj2 = coroutine_suspended;
                intRef = intRef3;
            }
            try {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(producerScope3, intRef3, a16, linkedHashMap2, arrayList4, null);
                this.L$0 = producerScope3;
                this.L$1 = intRef;
                this.L$2 = linkedHashMap;
                this.L$3 = arrayList4;
                this.label = 1;
                obj2 = coroutine_suspended;
                if (TimeoutKt.withTimeout(b16, anonymousClass2, this) == obj2) {
                    return obj2;
                }
                intRef2 = intRef;
                list = arrayList4;
                producerScope = producerScope3;
            } catch (TimeoutCancellationException unused3) {
                obj2 = coroutine_suspended;
                intRef2 = intRef;
                list = arrayList4;
                producerScope = producerScope3;
                List<Integer> x162 = this.$params.x();
                List list22 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list22, 10);
                ArrayList arrayList22 = new ArrayList(collectionSizeOrDefault);
                it = list22.iterator();
                while (it.hasNext()) {
                    arrayList22.add(Boxing.boxInt(((CloudRecordResult) it.next()).getResourceId()));
                }
                minus = CollectionsKt___CollectionsKt.minus((Iterable) x162, (Iterable) arrayList22);
                List list32 = minus;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list32, 10);
                ArrayList arrayList32 = new ArrayList(collectionSizeOrDefault2);
                it5 = list32.iterator();
                while (it5.hasNext()) {
                    int intValue2 = ((Number) it5.next()).intValue();
                    Z1CloudCacheHelper z1CloudCacheHelper = Z1CloudCacheHelper.f386141d;
                    CloudCacheProvider.Companion companion = CloudCacheProvider.INSTANCE;
                    CloudRecordResult g16 = z1CloudCacheHelper.g(intValue2, companion.b());
                    ZPlanRecordResourceStatistic zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) linkedHashMap.get(Boxing.boxInt(intValue2));
                    if (zPlanRecordResourceStatistic != null) {
                        companion.e(zPlanRecordResourceStatistic, g16);
                    }
                    arrayList32.add(g16);
                }
                list.addAll(arrayList32);
                it6 = linkedHashMap.values().iterator();
                while (it6.hasNext()) {
                }
                arrayList = new ArrayList();
                while (r4.hasNext()) {
                }
                if (arrayList.size() == intRef2.element) {
                }
            }
        }
        it6 = linkedHashMap.values().iterator();
        while (it6.hasNext()) {
            ((ZPlanRecordResourceStatistic) it6.next()).k();
        }
        arrayList = new ArrayList();
        for (Object obj3 : list) {
            if (Boxing.boxBoolean(((CloudRecordResult) obj3).g()).booleanValue()) {
                arrayList.add(obj3);
            }
        }
        if (arrayList.size() == intRef2.element) {
            d a18 = LogUtil.f385285b.a();
            if (a18 != null) {
                d.a.c(a18, "[ZPlanRRC]CloudCacheProvider", 1, "recordBatch end, all succeed by cloud cache, batchKey:" + this.$batchKey, null, 8, null);
            }
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            return Unit.INSTANCE;
        }
        List<Integer> x17 = this.$params.x();
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault3);
        Iterator it8 = arrayList.iterator();
        while (it8.hasNext()) {
            arrayList5.add(Boxing.boxInt(((CloudRecordResult) it8.next()).getResourceId()));
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList5);
        minus2 = CollectionsKt___CollectionsKt.minus((Iterable) x17, (Iterable) set);
        if (minus2.isEmpty()) {
            d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                d.a.c(a19, "[ZPlanRRC]CloudCacheProvider", 1, "recordBatch end, leftResourceIdList empty, batchKey:" + this.$batchKey, null, 8, null);
            }
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            return Unit.INSTANCE;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        n3 = r6.n((r36 & 1) != 0 ? r6.resourcesIds : minus2, (r36 & 2) != 0 ? r6.configs : null, (r36 & 4) != 0 ? r6.getTheme() : null, (r36 & 8) != 0 ? r6.getSender() : null, (r36 & 16) != 0 ? r6.getReceiver() : null, (r36 & 32) != 0 ? r6.getWidth() : 0, (r36 & 64) != 0 ? r6.getHeight() : 0, (r36 & 128) != 0 ? r6.getMode() : null, (r36 & 256) != 0 ? r6.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String() : null, (r36 & 512) != 0 ? r6.getScene() : 0, (r36 & 1024) != 0 ? r6.getPriority() : null, (r36 & 2048) != 0 ? r6.getUploadConfig() : null, (r36 & 4096) != 0 ? r6.getExpireConfig() : null, (r36 & 8192) != 0 ? r6.getReqFrom() : 0, (r36 & 16384) != 0 ? r6.getDownloadFromNetIfLocalAbsent() : false, (r36 & 32768) != 0 ? r6.getCom.tencent.mobileqq.activity.QQBrowserActivity.APP_PARAM java.lang.String() : null, (r36 & 65536) != 0 ? this.$params.getReportConfig() : null);
        d a26 = LogUtil.f385285b.a();
        if (a26 != null) {
            d.a.c(a26, "[ZPlanRRC]CloudCacheProvider", 1, "recordBatch end, batchKey:" + this.$batchKey + ", " + arrayList.size() + " succeed from cloud cache, left " + minus2 + " by nextProvider:" + this.this$0.getNextProvider(), null, 8, null);
        }
        n3.z(this.$params.getSenderAvatarCharacterInfo());
        n3.y(this.$params.getReceiverAvatarCharacterInfo());
        com.tencent.zplan.record.provider.a nextProvider = this.this$0.getNextProvider();
        if (!(nextProvider instanceof LocalRecordProvider)) {
            nextProvider = null;
        }
        LocalRecordProvider localRecordProvider = (LocalRecordProvider) nextProvider;
        if (localRecordProvider != null) {
            i3 = this.this$0.i(list, n3);
            localRecordProvider.i(i3);
        }
        com.tencent.zplan.record.provider.a nextProvider2 = this.this$0.getNextProvider();
        if (nextProvider2 != null && (asFlow = nextProvider2.c(this.$batchKey, n3)) != null) {
            function0 = null;
        } else {
            List list4 = minus2;
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault4);
            Iterator it9 = list4.iterator();
            while (it9.hasNext()) {
                ((Number) it9.next()).intValue();
                arrayList6.add(null);
            }
            function0 = null;
            asFlow = FlowKt.asFlow(arrayList6);
        }
        Flow take = FlowKt.take(asFlow, minus2.size());
        a aVar = new a(producerScope, minus2, atomicInteger);
        this.L$0 = producerScope;
        this.L$1 = function0;
        this.L$2 = function0;
        this.L$3 = function0;
        this.label = 2;
        if (take.collect(aVar, this) == obj2) {
            return obj2;
        }
        producerScope2 = producerScope;
        this.L$0 = function0;
        this.label = 3;
        if (ProduceKt.awaitClose$default(producerScope2, function0, this, 1, function0) == obj2) {
        }
        return Unit.INSTANCE;
    }
}
