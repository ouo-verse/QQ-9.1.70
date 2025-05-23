package com.tencent.zplan.record.provider;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/zplan/record/provider/CloudCacheProvider$recordBatch$1$2$1$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.CloudCacheProvider$recordBatch$1$2$1$1", f = "CloudCacheProvider.kt", i = {}, l = {126, 129}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes27.dex */
final class CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentKey;
    final /* synthetic */ int $resourceId;
    final /* synthetic */ CloudRecordResult $result;
    int label;
    final /* synthetic */ CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1$lambda$1(String str, CloudRecordResult cloudRecordResult, int i3, Continuation continuation, CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1 cloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1) {
        super(2, continuation);
        this.$currentKey = str;
        this.$result = cloudRecordResult;
        this.$resourceId = i3;
        this.this$0 = cloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1$lambda$1(this.$currentKey, this.$result, this.$resourceId, completion, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudCacheProvider$recordBatch$1$2$invokeSuspend$$inlined$collect$1$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ZPlanRecordResource zPlanRecordResource;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    zPlanRecordResource = (ZPlanRecordResource) obj;
                    if (zPlanRecordResource == null) {
                        zPlanRecordResource.s((ZPlanRecordResourceStatistic) this.this$0.f386100d.$statisticMap.get(Boxing.boxInt(this.$resourceId)));
                    } else {
                        zPlanRecordResource = null;
                    }
                    if (zPlanRecordResource == null) {
                        this.this$0.f386100d.$this_callbackFlow.mo2003trySendJP2dKIU(zPlanRecordResource);
                    } else {
                        this.this$0.f386100d.$this_callbackFlow.mo2003trySendJP2dKIU(new ZPlanRecordResource(this.$currentKey, null, null, 0L, 0, 0, null, 126, null));
                        d a16 = LogUtil.f385285b.a();
                        if (a16 != null) {
                            d.a.b(a16, "[ZPlanRRC]CloudCacheProvider", 1, "recordBatch batchKey:" + CloudCacheProvider$recordBatch$1.this.$batchKey + " currentKey:" + this.$currentKey + ", cloud cache download fail, return empty result", null, 8, null);
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
            String str = this.$currentKey;
            ZPlanRecordResource resource = this.$result.getResource();
            Intrinsics.checkNotNull(resource);
            boolean downloadFromNetIfLocalAbsent = CloudCacheProvider$recordBatch$1.this.$params.getDownloadFromNetIfLocalAbsent();
            this.label = 1;
            if (zPlanResourceManager.b(str, resource, downloadFromNetIfLocalAbsent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ZPlanResourceManager zPlanResourceManager2 = ZPlanResourceManager.f386013d;
        String str2 = this.$currentKey;
        boolean downloadFromNetIfLocalAbsent2 = CloudCacheProvider$recordBatch$1.this.$params.getDownloadFromNetIfLocalAbsent();
        this.label = 2;
        obj = ZPlanResourceManager.h(zPlanResourceManager2, str2, null, null, downloadFromNetIfLocalAbsent2, this, 6, null);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        zPlanRecordResource = (ZPlanRecordResource) obj;
        if (zPlanRecordResource == null) {
        }
        if (zPlanRecordResource == null) {
        }
        return Unit.INSTANCE;
    }
}
