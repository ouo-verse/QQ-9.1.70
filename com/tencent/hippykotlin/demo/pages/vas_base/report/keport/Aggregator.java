package com.tencent.hippykotlin.demo.pages.vas_base.report.keport;

import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Aggregator<T> {
    public final List<T> queue = new ArrayList();
    public final Function1<List<T>, Unit> trigger;
    public boolean waiting;

    public Aggregator(Function1 function1) {
        this.trigger = function1;
    }

    public final void add(T t16) {
        this.queue.add(t16);
        if (this.waiting) {
            return;
        }
        this.waiting = true;
        TimerKt.d(300, new Function0<Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Aggregator$add$1
            public final /* synthetic */ Aggregator<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<T>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<T>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<T>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                List<List> windowed;
                List mutableList;
                Aggregator<T> aggregator = this.this$0;
                if (aggregator.queue.isEmpty()) {
                    aggregator.waiting = false;
                } else {
                    if (aggregator.queue.size() > 10) {
                        windowed = CollectionsKt___CollectionsKt.windowed(aggregator.queue, 10, 10, true);
                        for (List list : windowed) {
                            Function1<List<T>, Unit> function1 = aggregator.trigger;
                            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                            function1.invoke(mutableList);
                        }
                    } else {
                        aggregator.trigger.invoke(aggregator.queue);
                    }
                    aggregator.waiting = false;
                    aggregator.queue.clear();
                }
                return Unit.INSTANCE;
            }
        });
    }
}
