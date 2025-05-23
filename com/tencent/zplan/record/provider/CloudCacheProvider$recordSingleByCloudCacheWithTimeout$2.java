package com.tencent.zplan.record.provider;

import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/zplan/record/model/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2", f = "CloudCacheProvider.kt", i = {0, 0, 1, 1}, l = {89, 253}, m = "invokeSuspend", n = {"result", "start$iv", "result", "start$iv"}, s = {"L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes27.dex */
public final class CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CloudRecordResult>, Object> {
    final /* synthetic */ MemeZPlanBaseAction $action;
    final /* synthetic */ SingleRecordRequestParams $params;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ CloudCacheProvider this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/zplan/record/provider/CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements FlowCollector<CloudRecordResult> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f386107e;

        public a(Ref.ObjectRef objectRef) {
            this.f386107e = objectRef;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.zplan.record.model.a, T] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(CloudRecordResult cloudRecordResult, @NotNull Continuation<? super Unit> continuation) {
            this.f386107e.element = cloudRecordResult;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2(CloudCacheProvider cloudCacheProvider, SingleRecordRequestParams singleRecordRequestParams, MemeZPlanBaseAction memeZPlanBaseAction, Continuation continuation) {
        super(2, continuation);
        this.this$0 = cloudCacheProvider;
        this.$params = singleRecordRequestParams;
        this.$action = memeZPlanBaseAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2(this.this$0, this.$params, this.$action, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CloudRecordResult> continuation) {
        return ((CloudCacheProvider$recordSingleByCloudCacheWithTimeout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        long j16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    j16 = this.J$0;
                    objectRef2 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Z1CloudCacheHelper.f386141d.a((CloudRecordResult) objectRef2.element, this.$action.getActionId(), this.$action, System.currentTimeMillis() - j16);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.J$0;
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = null;
            long currentTimeMillis = System.currentTimeMillis();
            CloudCacheProvider cloudCacheProvider = this.this$0;
            SingleRecordRequestParams singleRecordRequestParams = this.$params;
            this.L$0 = objectRef3;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            Object l3 = cloudCacheProvider.l(singleRecordRequestParams, this);
            if (l3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
            objectRef = objectRef3;
            obj = l3;
        }
        Flow take = FlowKt.take((Flow) obj, this.$action.batchCount());
        a aVar = new a(objectRef);
        this.L$0 = objectRef;
        this.J$0 = j3;
        this.label = 2;
        if (take.collect(aVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef2 = objectRef;
        j16 = j3;
        return Z1CloudCacheHelper.f386141d.a((CloudRecordResult) objectRef2.element, this.$action.getActionId(), this.$action, System.currentTimeMillis() - j16);
    }
}
