package com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Scheduler$add$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Scheduler<Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Scheduler$add$1(Scheduler<Object> scheduler) {
        super(0);
        this.this$0 = scheduler;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        Scheduler<Object> scheduler = this.this$0;
        Iterator<T> it = scheduler.tasks.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(scheduler.container);
        }
        scheduler.container.clear();
        this.this$0.timer = null;
        return Unit.INSTANCE;
    }
}
