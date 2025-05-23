package com.tencent.mobileqq.zplan.easteregg.repository;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository$queryPortrait$1", f = "RecordRepository.kt", i = {}, l = {169, 504}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class RecordRepository$queryPortrait$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BatchRecordRequestParams $batchRecordRequestParams;
    final /* synthetic */ List<Source> $sources;
    int label;
    final /* synthetic */ RecordRepository this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FlowCollector<ZPlanRecordResource> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecordRepository f333046d;

        public a(RecordRepository recordRepository) {
            this.f333046d = recordRepository;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(ZPlanRecordResource zPlanRecordResource, Continuation<? super Unit> continuation) {
            String str;
            ZPlanRecordResource zPlanRecordResource2 = zPlanRecordResource;
            boolean o16 = zPlanRecordResource2 != null ? zPlanRecordResource2.o() : false;
            ZPlanRecordResourceStatistic statistic = zPlanRecordResource2 != null ? zPlanRecordResource2.getStatistic() : null;
            QLog.i("RecordRepository", 1, "ZPlanRecordResource: " + zPlanRecordResource2 + ", " + (zPlanRecordResource2 != null ? zPlanRecordResource2.getLocalPath() : null) + ", " + (statistic != null ? statistic.getSource() : null));
            int resId = statistic != null ? statistic.getResId() : -1;
            if (zPlanRecordResource2 == null || (str = zPlanRecordResource2.getLocalPath()) == null) {
                str = "";
            }
            if (o16) {
                this.f333046d.l(Boxing.boxInt(resId), str);
            } else {
                this.f333046d.m(Boxing.boxInt(resId), str);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecordRepository$queryPortrait$1(BatchRecordRequestParams batchRecordRequestParams, List<? extends Source> list, RecordRepository recordRepository, Continuation<? super RecordRepository$queryPortrait$1> continuation) {
        super(2, continuation);
        this.$batchRecordRequestParams = batchRecordRequestParams;
        this.$sources = list;
        this.this$0 = recordRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RecordRepository$queryPortrait$1(this.$batchRecordRequestParams, this.$sources, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            BatchRecordRequestParams batchRecordRequestParams = this.$batchRecordRequestParams;
            List<Source> list = this.$sources;
            this.label = 1;
            obj = zPlanRecordResourceCenter.e(batchRecordRequestParams, list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        a aVar = new a(this.this$0);
        this.label = 2;
        if (((Flow) obj).collect(aVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RecordRepository$queryPortrait$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
