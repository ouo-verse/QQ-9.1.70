package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.provider.CloudCacheProvider$recordBatch$1;
import com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2}, xi = 48)
/* loaded from: classes27.dex */
public final class CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<CloudRecordResult> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ CloudCacheProvider$recordBatch$1.AnonymousClass2 f386100d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f386101e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f386102f;

    public CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1(CloudCacheProvider$recordBatch$1.AnonymousClass2 anonymousClass2, CoroutineScope coroutineScope, long j3) {
        this.f386100d = anonymousClass2;
        this.f386101e = coroutineScope;
        this.f386102f = j3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(CloudRecordResult cloudRecordResult, @NotNull Continuation<? super Unit> continuation) {
        CloudRecordResult cloudRecordResult2 = cloudRecordResult;
        long currentTimeMillis = System.currentTimeMillis() - this.f386102f;
        int resourceId = cloudRecordResult2.getResourceId();
        String singleActionKey = this.f386100d.$action.getSingleActionKey(resourceId);
        CloudRecordResult a16 = Z1CloudCacheHelper.f386141d.a(cloudRecordResult2, resourceId, this.f386100d.$action, currentTimeMillis);
        d a17 = LogUtil.f385285b.a();
        if (a17 != null) {
            d.a.c(a17, "[ZPlanRRC]CloudCacheProvider", 1, "recordBatch batchKey:" + CloudCacheProvider$recordBatch$1.this.$batchKey + ", collect one result from cloud cache, resId:" + resourceId + ", result:" + cloudRecordResult2, null, 8, null);
        }
        ZPlanRecordResourceStatistic zPlanRecordResourceStatistic = (ZPlanRecordResourceStatistic) this.f386100d.$statisticMap.get(Boxing.boxInt(resourceId));
        if (zPlanRecordResourceStatistic != null) {
            CloudCacheProvider.INSTANCE.e(zPlanRecordResourceStatistic, a16);
        }
        this.f386100d.$cacheResultList.add(a16);
        if (a16.g()) {
            BuildersKt__Builders_commonKt.launch$default(this.f386101e, null, null, new CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1$lambda$1(singleActionKey, a16, resourceId, null, this), 3, null);
        }
        return Unit.INSTANCE;
    }
}
