package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.ExpireConfig;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx4.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0007B\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0011J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ \u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/record/provider/LocalCacheProvider;", "Lcom/tencent/zplan/record/provider/a;", "", "key", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "a", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchKey", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "Lkotlinx/coroutines/flow/Flow;", "c", "Lcom/tencent/zplan/record/provider/a;", "d", "()Lcom/tencent/zplan/record/provider/a;", "b", "(Lcom/tencent/zplan/record/provider/a;)V", "nextProvider", "<init>", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class LocalCacheProvider implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a nextProvider;

    public LocalCacheProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.zplan.record.provider.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull String str, @NotNull SingleRecordRequestParams singleRecordRequestParams, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        LocalCacheProvider$recordSingle$1 localCacheProvider$recordSingle$1;
        Object coroutine_suspended;
        int i3;
        LocalCacheProvider localCacheProvider;
        ZPlanRecordResource zPlanRecordResource;
        if (continuation instanceof LocalCacheProvider$recordSingle$1) {
            localCacheProvider$recordSingle$1 = (LocalCacheProvider$recordSingle$1) continuation;
            int i16 = localCacheProvider$recordSingle$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                localCacheProvider$recordSingle$1.label = i16 - Integer.MIN_VALUE;
                Object obj = localCacheProvider$recordSingle$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = localCacheProvider$recordSingle$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return (ZPlanRecordResource) obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    singleRecordRequestParams = (SingleRecordRequestParams) localCacheProvider$recordSingle$1.L$2;
                    str = (String) localCacheProvider$recordSingle$1.L$1;
                    localCacheProvider = (LocalCacheProvider) localCacheProvider$recordSingle$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
                    ExpireConfig expireConfig = singleRecordRequestParams.getExpireConfig();
                    c.ForceDeleteResourceConfig b16 = ZPlanRecordResource.INSTANCE.b();
                    boolean downloadFromNetIfLocalAbsent = singleRecordRequestParams.getDownloadFromNetIfLocalAbsent();
                    localCacheProvider$recordSingle$1.L$0 = this;
                    localCacheProvider$recordSingle$1.L$1 = str;
                    localCacheProvider$recordSingle$1.L$2 = singleRecordRequestParams;
                    localCacheProvider$recordSingle$1.label = 1;
                    obj = zPlanResourceManager.g(str, expireConfig, b16, downloadFromNetIfLocalAbsent, localCacheProvider$recordSingle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    localCacheProvider = this;
                }
                zPlanRecordResource = (ZPlanRecordResource) obj;
                if (zPlanRecordResource == null) {
                    ZPlanRecordResourceStatistic b17 = ZPlanRecordResourceStatistic.INSTANCE.b(Source.LOCAL_CACHE, singleRecordRequestParams.getResourceId(), singleRecordRequestParams);
                    b17.u(true);
                    b17.o(true);
                    Unit unit = Unit.INSTANCE;
                    zPlanRecordResource.s(b17);
                    return zPlanRecordResource;
                }
                a nextProvider = localCacheProvider.getNextProvider();
                if (nextProvider == null) {
                    return null;
                }
                localCacheProvider$recordSingle$1.L$0 = null;
                localCacheProvider$recordSingle$1.L$1 = null;
                localCacheProvider$recordSingle$1.L$2 = null;
                localCacheProvider$recordSingle$1.label = 2;
                obj = nextProvider.a(str, singleRecordRequestParams, localCacheProvider$recordSingle$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (ZPlanRecordResource) obj;
            }
        }
        localCacheProvider$recordSingle$1 = new LocalCacheProvider$recordSingle$1(this, continuation);
        Object obj2 = localCacheProvider$recordSingle$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = localCacheProvider$recordSingle$1.label;
        if (i3 == 0) {
        }
        zPlanRecordResource = (ZPlanRecordResource) obj2;
        if (zPlanRecordResource == null) {
        }
    }

    @Override // com.tencent.zplan.record.provider.a
    public void b(@Nullable a aVar) {
        this.nextProvider = aVar;
    }

    @Override // com.tencent.zplan.record.provider.a
    @NotNull
    public Flow<ZPlanRecordResource> c(@NotNull String batchKey, @NotNull BatchRecordRequestParams params) {
        Intrinsics.checkNotNullParameter(batchKey, "batchKey");
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.callbackFlow(new LocalCacheProvider$recordBatch$1(this, params, null));
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public a getNextProvider() {
        return this.nextProvider;
    }

    public LocalCacheProvider(@Nullable a aVar) {
        this.nextProvider = aVar;
    }

    public /* synthetic */ LocalCacheProvider(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
    }
}
