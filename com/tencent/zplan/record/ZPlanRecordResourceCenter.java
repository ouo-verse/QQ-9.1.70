package com.tencent.zplan.record;

import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.Constant;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.GeneralRecordParams;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0006J3\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0003\u001a\u00020\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0007J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/record/ZPlanRecordResourceCenter;", "", "Lcom/tencent/zplan/record/model/GeneralRecordParams;", "params", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "g", "(Lcom/tencent/zplan/record/model/GeneralRecordParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "", "Lcom/tencent/zplan/record/model/Source;", "sources", h.F, "(Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "d", "Lcom/tencent/zplan/record/model/BatchRecordRequestParams;", "e", "(Lcom/tencent/zplan/record/model/BatchRecordRequestParams;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "b", "(Lcom/tencent/zplan/record/model/SingleRecordRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanRecordResourceCenter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ZPlanRecordResourceCenter f386003a = new ZPlanRecordResourceCenter();

    ZPlanRecordResourceCenter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object f(ZPlanRecordResourceCenter zPlanRecordResourceCenter, BatchRecordRequestParams batchRecordRequestParams, List list, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE, Source.LOCAL_RECORD});
        }
        return zPlanRecordResourceCenter.e(batchRecordRequestParams, list, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object i(ZPlanRecordResourceCenter zPlanRecordResourceCenter, SingleRecordRequestParams singleRecordRequestParams, List list, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE, Source.LOCAL_RECORD});
        }
        return zPlanRecordResourceCenter.h(singleRecordRequestParams, list, continuation);
    }

    public final synchronized void a() {
        ZPlanResourceManager.f386013d.c();
        c.f385288a.e(Constant.f385743c.a());
    }

    @Nullable
    public final Object b(@NotNull SingleRecordRequestParams singleRecordRequestParams, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        return ZPlanResourceManager.f386013d.g(singleRecordRequestParams.a().getKey(), singleRecordRequestParams.getExpireConfig(), ZPlanRecordResource.INSTANCE.b(), singleRecordRequestParams.getDownloadFromNetIfLocalAbsent(), continuation);
    }

    @Nullable
    public final ZPlanRecordResource c(@NotNull SingleRecordRequestParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return ZPlanResourceManager.f386013d.i(params.a().getKey());
    }

    @Nullable
    public final Object d(@NotNull GeneralRecordParams generalRecordParams, @NotNull Continuation<? super Flow<ZPlanRecordResource>> continuation) {
        return e(generalRecordParams.a(), generalRecordParams.f(), continuation);
    }

    @Nullable
    public final Object e(@NotNull BatchRecordRequestParams batchRecordRequestParams, @NotNull List<? extends Source> list, @NotNull Continuation<? super Flow<ZPlanRecordResource>> continuation) {
        Flow<ZPlanRecordResource> c16;
        com.tencent.zplan.record.provider.a a16 = Source.INSTANCE.a(list);
        if (a16 == null || (c16 = a16.c(batchRecordRequestParams.a().getKey(), batchRecordRequestParams)) == null) {
            return FlowKt.emptyFlow();
        }
        return c16;
    }

    @Nullable
    public final Object g(@NotNull GeneralRecordParams generalRecordParams, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        return h(generalRecordParams.b(), generalRecordParams.f(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull SingleRecordRequestParams singleRecordRequestParams, @NotNull List<? extends Source> list, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        ZPlanRecordResourceCenter$requestSingleResourceImmediate$1 zPlanRecordResourceCenter$requestSingleResourceImmediate$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ZPlanRecordResourceCenter$requestSingleResourceImmediate$1) {
            zPlanRecordResourceCenter$requestSingleResourceImmediate$1 = (ZPlanRecordResourceCenter$requestSingleResourceImmediate$1) continuation;
            int i16 = zPlanRecordResourceCenter$requestSingleResourceImmediate$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanRecordResourceCenter$requestSingleResourceImmediate$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanRecordResourceCenter$requestSingleResourceImmediate$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanRecordResourceCenter$requestSingleResourceImmediate$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.zplan.record.provider.a a16 = Source.INSTANCE.a(list);
                    if (a16 != null) {
                        String key = singleRecordRequestParams.a().getKey();
                        zPlanRecordResourceCenter$requestSingleResourceImmediate$1.label = 1;
                        obj = a16.a(key, singleRecordRequestParams, zPlanRecordResourceCenter$requestSingleResourceImmediate$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return null;
                    }
                }
                return (ZPlanRecordResource) obj;
            }
        }
        zPlanRecordResourceCenter$requestSingleResourceImmediate$1 = new ZPlanRecordResourceCenter$requestSingleResourceImmediate$1(this, continuation);
        Object obj2 = zPlanRecordResourceCenter$requestSingleResourceImmediate$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanRecordResourceCenter$requestSingleResourceImmediate$1.label;
        if (i3 == 0) {
        }
        return (ZPlanRecordResource) obj2;
    }
}
