package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.FeatureGroup$runSync$2", f = "FeatureGroup.kt", i = {0}, l = {49}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class FeatureGroup$runSync$2 extends SuspendLambda implements Function2<a, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskContext $taskContext;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeatureGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureGroup$runSync$2(FeatureGroup featureGroup, TaskContext taskContext, Continuation<? super FeatureGroup$runSync$2> continuation) {
        super(2, continuation);
        this.this$0 = featureGroup;
        this.$taskContext = taskContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FeatureGroup$runSync$2 featureGroup$runSync$2 = new FeatureGroup$runSync$2(this.this$0, this.$taskContext, continuation);
        featureGroup$runSync$2.L$0 = obj;
        return featureGroup$runSync$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(a aVar, Continuation<? super Unit> continuation) {
        return ((FeatureGroup$runSync$2) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            a aVar2 = (a) this.L$0;
            QLog.i(this.this$0.e(), 1, "[runSync] begin feat=" + aVar2.getClass().getSimpleName() + ", task id=" + this.$taskContext.getId());
            TaskContext taskContext = this.$taskContext;
            this.L$0 = aVar2;
            this.label = 1;
            if (aVar2.a(taskContext, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar = aVar2;
        } else if (i3 == 1) {
            aVar = (a) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        QLog.i(this.this$0.e(), 1, "[runSync] end feat=" + aVar.getClass().getSimpleName() + ", task id=" + this.$taskContext.getId());
        return Unit.INSTANCE;
    }
}
