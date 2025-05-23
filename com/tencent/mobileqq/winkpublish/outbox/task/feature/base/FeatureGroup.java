package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.base.config.data.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0001\u0015B\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\tJ\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001b\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/a;", k.FEATURES_KEY, "", "i", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", h.F, "", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "f", "d", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "<init>", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;)V", "RunMode", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class FeatureGroup extends b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/FeatureGroup$RunMode;", "", "(Ljava/lang/String;I)V", "SYNC_RUN_MODE", "ASYNC_RUN_MODE", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum RunMode {
        SYNC_RUN_MODE,
        ASYNC_RUN_MODE
    }

    public FeatureGroup(b bVar) {
        super(bVar);
    }

    static /* synthetic */ Object g(FeatureGroup featureGroup, TaskContext taskContext, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        List<a> d16 = featureGroup.d(taskContext);
        RunMode f16 = featureGroup.f();
        QLog.i(featureGroup.e(), 1, "[run] runMode=" + f16 + ", feature size=" + d16.size() + ", task id=" + taskContext.getId());
        if (f16 == RunMode.SYNC_RUN_MODE) {
            Object i3 = featureGroup.i(taskContext, d16, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return i3 == coroutine_suspended2 ? i3 : Unit.INSTANCE;
        }
        Object h16 = featureGroup.h(taskContext, d16, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return h16 == coroutine_suspended ? h16 : Unit.INSTANCE;
    }

    private final Object h(TaskContext taskContext, List<? extends a> list, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FeatureGroup$runAsync$2(list, this, taskContext, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    private final Object i(TaskContext taskContext, List<? extends a> list, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object collect = FlowKt.collect(FlowKt.onEach(FlowKt.asFlow(list), new FeatureGroup$runSync$2(this, taskContext, null)), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return collect == coroutine_suspended ? collect : Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        return g(this, taskContext, continuation);
    }

    public abstract List<a> d(TaskContext taskContext);

    public abstract String e();

    public abstract RunMode f();
}
