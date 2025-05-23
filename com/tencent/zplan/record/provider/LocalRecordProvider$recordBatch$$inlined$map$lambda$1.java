package com.tencent.zplan.record.provider;

import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
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
import kotlinx.coroutines.flow.FlowCollector;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/zplan/record/provider/LocalRecordProvider$recordBatch$1$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.LocalRecordProvider$recordBatch$1$1", f = "LocalRecordProvider.kt", i = {0}, l = {52, 54}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes27.dex */
final class LocalRecordProvider$recordBatch$$inlined$map$lambda$1 extends SuspendLambda implements Function2<FlowCollector<? super ZPlanRecordResource>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $batchInfo$inlined;
    final /* synthetic */ int $it;
    final /* synthetic */ BatchRecordRequestParams $params$inlined;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalRecordProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalRecordProvider$recordBatch$$inlined$map$lambda$1(int i3, Continuation continuation, LocalRecordProvider localRecordProvider, BatchRecordRequestParams batchRecordRequestParams, String str) {
        super(2, continuation);
        this.$it = i3;
        this.this$0 = localRecordProvider;
        this.$params$inlined = batchRecordRequestParams;
        this.$batchInfo$inlined = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        LocalRecordProvider$recordBatch$$inlined$map$lambda$1 localRecordProvider$recordBatch$$inlined$map$lambda$1 = new LocalRecordProvider$recordBatch$$inlined$map$lambda$1(this.$it, completion, this.this$0, this.$params$inlined, this.$batchInfo$inlined);
        localRecordProvider$recordBatch$$inlined$map$lambda$1.L$0 = obj;
        return localRecordProvider$recordBatch$$inlined$map$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ZPlanRecordResource> flowCollector, Continuation<? super Unit> continuation) {
        return ((LocalRecordProvider$recordBatch$$inlined$map$lambda$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        SingleRecordRequestParams c16;
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
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            BusinessConfig businessConfig = this.$params$inlined.q().get(Boxing.boxInt(this.$it));
            if (businessConfig == null) {
                businessConfig = this.$params$inlined.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            }
            c16 = LocalRecordProvider.INSTANCE.c(this.$params$inlined, this.$it, businessConfig);
            c16.x(this.$params$inlined.getSenderAvatarCharacterInfo());
            c16.w(this.$params$inlined.getReceiverAvatarCharacterInfo());
            String key = c16.a().getKey();
            LocalRecordProvider localRecordProvider = this.this$0;
            com.tencent.zplan.record.provider.helper.a uploader = localRecordProvider.getUploader();
            this.L$0 = flowCollector;
            this.label = 1;
            obj = localRecordProvider.e(key, c16, uploader, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ZPlanRecordResource zPlanRecordResource = (ZPlanRecordResource) obj;
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[ZPlanRRC]LocalRecordProvider", 1, "recordBatch get one result, " + zPlanRecordResource + " -> " + this.$batchInfo$inlined, null, 8, null);
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(zPlanRecordResource, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
