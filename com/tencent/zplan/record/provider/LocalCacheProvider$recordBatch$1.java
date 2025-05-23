package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.ExpireConfig;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
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
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx4.c;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.LocalCacheProvider$recordBatch$1", f = "LocalCacheProvider.kt", i = {0, 0, 0, 0, 0, 1}, l = {58, 116, 103}, m = "invokeSuspend", n = {"$this$callbackFlow", "action", "batchKey", "cachedIdList", "id", "$this$callbackFlow"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0"})
/* loaded from: classes27.dex */
final class LocalCacheProvider$recordBatch$1 extends SuspendLambda implements Function2<ProducerScope<? super ZPlanRecordResource>, Continuation<? super Unit>, Object> {
    final /* synthetic */ BatchRecordRequestParams $params;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ LocalCacheProvider this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements FlowCollector<ZPlanRecordResource> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProducerScope f386110d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f386111e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f386112f;

        public a(ProducerScope producerScope, List list, AtomicInteger atomicInteger) {
            this.f386110d = producerScope;
            this.f386111e = list;
            this.f386112f = atomicInteger;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(ZPlanRecordResource zPlanRecordResource, @NotNull Continuation<? super Unit> continuation) {
            this.f386110d.mo2003trySendJP2dKIU(zPlanRecordResource);
            if (this.f386112f.addAndGet(1) == this.f386111e.size()) {
                SendChannel.DefaultImpls.close$default(this.f386110d, null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalCacheProvider$recordBatch$1(LocalCacheProvider localCacheProvider, BatchRecordRequestParams batchRecordRequestParams, Continuation continuation) {
        super(2, continuation);
        this.this$0 = localCacheProvider;
        this.$params = batchRecordRequestParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        LocalCacheProvider$recordBatch$1 localCacheProvider$recordBatch$1 = new LocalCacheProvider$recordBatch$1(this.this$0, this.$params, completion);
        localCacheProvider$recordBatch$1.L$0 = obj;
        return localCacheProvider$recordBatch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ZPlanRecordResource> producerScope, Continuation<? super Unit> continuation) {
        return ((LocalCacheProvider$recordBatch$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x02a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bb -> B:17:0x00c0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ProducerScope producerScope;
        LocalCacheProvider$recordBatch$1 localCacheProvider$recordBatch$1;
        MemeZPlanBatchAction memeZPlanBatchAction;
        Iterator<Integer> it;
        String str;
        Set set;
        List minus;
        BatchRecordRequestParams n3;
        int collectionSizeOrDefault;
        Flow<ZPlanRecordResource> asFlow;
        d a16;
        AnonymousClass3 anonymousClass3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                producerScope = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                localCacheProvider$recordBatch$1 = this;
                anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.zplan.record.provider.LocalCacheProvider$recordBatch$1.3
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        d a17 = LogUtil.f385285b.a();
                        if (a17 != null) {
                            d.a.c(a17, "[ZPlanRRC]LocalCacheProvider", 1, "recordBatch channel is closed", null, 8, null);
                        }
                    }
                };
                localCacheProvider$recordBatch$1.L$0 = null;
                localCacheProvider$recordBatch$1.label = 3;
                if (ProduceKt.awaitClose(producerScope, anonymousClass3, localCacheProvider$recordBatch$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            int i16 = this.I$0;
            it = (Iterator) this.L$4;
            set = (Set) this.L$3;
            str = (String) this.L$2;
            memeZPlanBatchAction = (MemeZPlanBatchAction) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Object g16 = obj;
            localCacheProvider$recordBatch$1 = this;
            ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) g16;
            if (zPlanRecordResource != null) {
                ZPlanRecordResourceStatistic b16 = ZPlanRecordResourceStatistic.INSTANCE.b(Source.LOCAL_CACHE, i16, localCacheProvider$recordBatch$1.$params);
                b16.u(true);
                b16.o(true);
                Unit unit = Unit.INSTANCE;
                zPlanRecordResource.s(b16);
                Object mo2003trySendJP2dKIU = producerScope2.mo2003trySendJP2dKIU(zPlanRecordResource);
                if (ChannelResult.m2018isSuccessimpl(mo2003trySendJP2dKIU)) {
                    set.add(Boxing.boxInt(i16));
                } else if (ChannelResult.m2016isClosedimpl(mo2003trySendJP2dKIU)) {
                    d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        d.a.b(a17, "[ZPlanRRC]LocalCacheProvider", 1, "chanel is closed for id: " + i16 + ", cause: " + ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU), null, 8, null);
                    }
                } else if (ChannelResult.m2017isFailureimpl(mo2003trySendJP2dKIU) && (a16 = LogUtil.f385285b.a()) != null) {
                    d.a.b(a16, "[ZPlanRRC]LocalCacheProvider", 1, "fail to send resource for id: " + i16 + ", cause: " + ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU), null, 8, null);
                }
            }
            producerScope = producerScope2;
            if (it.hasNext()) {
                int intValue = it.next().intValue();
                ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
                String singleActionKey = memeZPlanBatchAction.getSingleActionKey(intValue);
                ExpireConfig expireConfig = localCacheProvider$recordBatch$1.$params.getExpireConfig();
                c.ForceDeleteResourceConfig b17 = ZPlanRecordResource.INSTANCE.b();
                boolean downloadFromNetIfLocalAbsent = localCacheProvider$recordBatch$1.$params.getDownloadFromNetIfLocalAbsent();
                localCacheProvider$recordBatch$1.L$0 = producerScope;
                localCacheProvider$recordBatch$1.L$1 = memeZPlanBatchAction;
                localCacheProvider$recordBatch$1.L$2 = str;
                localCacheProvider$recordBatch$1.L$3 = set;
                localCacheProvider$recordBatch$1.L$4 = it;
                localCacheProvider$recordBatch$1.I$0 = intValue;
                localCacheProvider$recordBatch$1.label = 1;
                LocalCacheProvider$recordBatch$1 localCacheProvider$recordBatch$12 = localCacheProvider$recordBatch$1;
                g16 = zPlanResourceManager.g(singleActionKey, expireConfig, b17, downloadFromNetIfLocalAbsent, localCacheProvider$recordBatch$12);
                if (g16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                localCacheProvider$recordBatch$1 = localCacheProvider$recordBatch$12;
                producerScope2 = producerScope;
                i16 = intValue;
                ZPlanRecordResource zPlanRecordResource2 = (ZPlanRecordResource) g16;
                if (zPlanRecordResource2 != null) {
                }
                producerScope = producerScope2;
                if (it.hasNext()) {
                    if (set.size() != localCacheProvider$recordBatch$1.$params.x().size()) {
                        minus = CollectionsKt___CollectionsKt.minus((Iterable) localCacheProvider$recordBatch$1.$params.x(), (Iterable) set);
                        if (minus.isEmpty()) {
                            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                            return Unit.INSTANCE;
                        }
                        d a18 = LogUtil.f385285b.a();
                        if (a18 != null) {
                            d.a.c(a18, "[ZPlanRRC]LocalCacheProvider", 1, "recordBatch " + set + " -> " + localCacheProvider$recordBatch$1.$params.getMode() + " -> " + localCacheProvider$recordBatch$1.$params.getTheme() + " success, left " + minus + " by nextProvider:" + localCacheProvider$recordBatch$1.this$0.getNextProvider() + ", batchKey:" + str, null, 8, null);
                        }
                        AtomicInteger atomicInteger = new AtomicInteger(0);
                        n3 = r7.n((r36 & 1) != 0 ? r7.resourcesIds : minus, (r36 & 2) != 0 ? r7.configs : null, (r36 & 4) != 0 ? r7.getTheme() : null, (r36 & 8) != 0 ? r7.getSender() : null, (r36 & 16) != 0 ? r7.getReceiver() : null, (r36 & 32) != 0 ? r7.getWidth() : 0, (r36 & 64) != 0 ? r7.getHeight() : 0, (r36 & 128) != 0 ? r7.getMode() : null, (r36 & 256) != 0 ? r7.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String() : null, (r36 & 512) != 0 ? r7.getScene() : 0, (r36 & 1024) != 0 ? r7.getPriority() : null, (r36 & 2048) != 0 ? r7.getUploadConfig() : null, (r36 & 4096) != 0 ? r7.getExpireConfig() : null, (r36 & 8192) != 0 ? r7.getReqFrom() : 0, (r36 & 16384) != 0 ? r7.getDownloadFromNetIfLocalAbsent() : false, (r36 & 32768) != 0 ? r7.getCom.tencent.mobileqq.activity.QQBrowserActivity.APP_PARAM java.lang.String() : null, (r36 & 65536) != 0 ? localCacheProvider$recordBatch$1.$params.getReportConfig() : null);
                        n3.z(localCacheProvider$recordBatch$1.$params.getSenderAvatarCharacterInfo());
                        n3.y(localCacheProvider$recordBatch$1.$params.getReceiverAvatarCharacterInfo());
                        com.tencent.zplan.record.provider.a nextProvider = localCacheProvider$recordBatch$1.this$0.getNextProvider();
                        if (nextProvider == null || (asFlow = nextProvider.c(str, n3)) == null) {
                            List list = minus;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                ((Number) it5.next()).intValue();
                                arrayList.add(null);
                            }
                            asFlow = FlowKt.asFlow(arrayList);
                        }
                        Flow take = FlowKt.take(asFlow, minus.size());
                        a aVar = new a(producerScope, minus, atomicInteger);
                        localCacheProvider$recordBatch$1.L$0 = producerScope;
                        localCacheProvider$recordBatch$1.L$1 = null;
                        localCacheProvider$recordBatch$1.L$2 = null;
                        localCacheProvider$recordBatch$1.L$3 = null;
                        localCacheProvider$recordBatch$1.L$4 = null;
                        localCacheProvider$recordBatch$1.label = 2;
                        if (take.collect(aVar, localCacheProvider$recordBatch$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.zplan.record.provider.LocalCacheProvider$recordBatch$1.3
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                d a172 = LogUtil.f385285b.a();
                                if (a172 != null) {
                                    d.a.c(a172, "[ZPlanRRC]LocalCacheProvider", 1, "recordBatch channel is closed", null, 8, null);
                                }
                            }
                        };
                        localCacheProvider$recordBatch$1.L$0 = null;
                        localCacheProvider$recordBatch$1.label = 3;
                        if (ProduceKt.awaitClose(producerScope, anonymousClass3, localCacheProvider$recordBatch$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                    SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            MemeZPlanBatchAction a19 = this.$params.a();
            String key = a19.getKey();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            localCacheProvider$recordBatch$1 = this;
            memeZPlanBatchAction = a19;
            it = this.$params.x().iterator();
            str = key;
            set = linkedHashSet;
            if (it.hasNext()) {
            }
        }
    }
}
