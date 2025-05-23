package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class NBPMarkerUIScheduler {
    public ArrayList<Function0<Unit>> endScrollLazyTasks = new ArrayList<>();
    public boolean frameByFrameToPerformLazyTasking;
    public boolean mapScrolling;

    public final void addUITask(Function0<Unit> function0) {
        if (!this.mapScrolling) {
            function0.invoke();
            return;
        }
        this.endScrollLazyTasks.add(function0);
        if (this.frameByFrameToPerformLazyTasking) {
            return;
        }
        this.frameByFrameToPerformLazyTasking = true;
        TimerKt.d(2, new NBPMarkerUIScheduler$frameByFrameToPerformLazyTasks$1(this));
    }
}
