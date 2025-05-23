package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPMarkerUIScheduler$frameByFrameToPerformLazyTasks$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ NBPMarkerUIScheduler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPMarkerUIScheduler$frameByFrameToPerformLazyTasks$1(NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        super(0);
        this.this$0 = nBPMarkerUIScheduler;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        List<Function0> list;
        if (!this.this$0.endScrollLazyTasks.isEmpty()) {
            ArrayList<Function0<Unit>> arrayList = this.this$0.endScrollLazyTasks;
            list = CollectionsKt___CollectionsKt.toList(arrayList.subList(0, Math.min(1, arrayList.size())));
            NBPMarkerUIScheduler nBPMarkerUIScheduler = this.this$0;
            for (Function0 function0 : list) {
                nBPMarkerUIScheduler.endScrollLazyTasks.remove(function0);
                function0.invoke();
            }
            if (!this.this$0.endScrollLazyTasks.isEmpty()) {
                NBPMarkerUIScheduler nBPMarkerUIScheduler2 = this.this$0;
                nBPMarkerUIScheduler2.getClass();
                TimerKt.d(2, new NBPMarkerUIScheduler$frameByFrameToPerformLazyTasks$1(nBPMarkerUIScheduler2));
            } else {
                this.this$0.frameByFrameToPerformLazyTasking = false;
            }
        } else {
            this.this$0.frameByFrameToPerformLazyTasking = false;
        }
        return Unit.INSTANCE;
    }
}
