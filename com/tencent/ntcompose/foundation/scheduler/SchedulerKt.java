package com.tencent.ntcompose.foundation.scheduler;

import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/manager/Task;", "task", "b", "a", "c", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SchedulerKt {
    public static final void a(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        c.f117352a.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.scheduler.SchedulerKt$nextTick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                task.invoke();
            }
        });
    }

    public static final void b(final Function0<Unit> task) {
        FlexNode flexNode;
        Intrinsics.checkNotNullParameter(task, "task");
        c cVar = c.f117352a;
        b g16 = cVar.g();
        Pager pager = g16 instanceof Pager ? (Pager) g16 : null;
        if (pager != null && (flexNode = pager.getFlexNode()) != null) {
            flexNode.a0();
        }
        cVar.g().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.scheduler.SchedulerKt$nextTickUtilLayoutCompleted$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b g17 = c.f117352a.g();
                final Function0<Unit> function0 = task;
                g17.addNextTickTask(new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.scheduler.SchedulerKt$nextTickUtilLayoutCompleted$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function0.invoke();
                    }
                });
            }
        });
    }

    public static final void c(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        BridgeManager.f117344a.f(task);
    }
}
