package com.tencent.mobileqq.zplan.meme.api.impl;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper$recordBatchActionByResourceCenter$1", f = "MemeHelperImpl.kt", i = {}, l = {168, 205}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MemeHelper$recordBatchActionByResourceCenter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.zplan.meme.a $listener;
    final /* synthetic */ BatchRecordRequestParams $params;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FlowCollector<ZPlanRecordResource> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.meme.a f333970d;

        public a(com.tencent.zplan.meme.a aVar) {
            this.f333970d = aVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(ZPlanRecordResource zPlanRecordResource, Continuation<? super Unit> continuation) {
            MODE mode;
            String str;
            ZPlanRecordResource zPlanRecordResource2 = zPlanRecordResource;
            ZPlanRecordResourceStatistic statistic = zPlanRecordResource2 != null ? zPlanRecordResource2.getStatistic() : null;
            boolean o16 = zPlanRecordResource2 != null ? zPlanRecordResource2.o() : false;
            QLog.i(MemeHelper.TAG, 1, "recordBatchActionByResourceCenter end:" + zPlanRecordResource2 + ", success:" + o16 + ", result:" + statistic);
            int resId = statistic != null ? statistic.getResId() : -1;
            int width = statistic != null ? statistic.getWidth() : -1;
            int height = statistic != null ? statistic.getHeight() : -1;
            if (statistic == null || (mode = statistic.getMode()) == null) {
                mode = MODE.FRAME;
            }
            MODE mode2 = mode;
            if (statistic == null || (str = statistic.getUserId()) == null) {
                str = "-1";
            }
            MemeZPlanAction memeZPlanAction = new MemeZPlanAction(resId, -1, width, height, mode2, str);
            com.tencent.zplan.meme.a aVar = this.f333970d;
            if (aVar != null) {
                aVar.l9(o16, new MemeResult(memeZPlanAction, memeZPlanAction.getKey(), zPlanRecordResource2 != null ? zPlanRecordResource2.getLocalPath() : null));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeHelper$recordBatchActionByResourceCenter$1(BatchRecordRequestParams batchRecordRequestParams, com.tencent.zplan.meme.a aVar, Continuation<? super MemeHelper$recordBatchActionByResourceCenter$1> continuation) {
        super(2, continuation);
        this.$params = batchRecordRequestParams;
        this.$listener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemeHelper$recordBatchActionByResourceCenter$1(this.$params, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
            BatchRecordRequestParams batchRecordRequestParams = this.$params;
            this.label = 1;
            obj = ZPlanRecordResourceCenter.f(zPlanRecordResourceCenter, batchRecordRequestParams, null, this, 2, null);
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
        a aVar = new a(this.$listener);
        this.label = 2;
        if (((Flow) obj).collect(aVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MemeHelper$recordBatchActionByResourceCenter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
