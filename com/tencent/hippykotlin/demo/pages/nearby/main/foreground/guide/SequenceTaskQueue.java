package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SequenceTaskQueue {
    public boolean started;
    public final List<ISequenceTask> tasks = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask>, java.util.ArrayList] */
    public final void execute() {
        if (this.tasks.isEmpty()) {
            return;
        }
        ISequenceTask iSequenceTask = (ISequenceTask) this.tasks.remove(0);
        if (iSequenceTask.canStart()) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("task=");
            m3.append(Reflection.getOrCreateKotlinClass(iSequenceTask.getClass()));
            m3.append(" start");
            kLog.i("SequenceTaskQueue", m3.toString());
            iSequenceTask.onStart(new SequenceTaskQueue$execute$1(iSequenceTask, this));
            return;
        }
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("task=");
        m16.append(Reflection.getOrCreateKotlinClass(iSequenceTask.getClass()));
        m16.append(" cannot start");
        kLog2.i("SequenceTaskQueue", m16.toString());
        execute();
    }
}
