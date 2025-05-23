package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SequenceTaskQueue$execute$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ ISequenceTask $task;
    public final /* synthetic */ SequenceTaskQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequenceTaskQueue$execute$1(ISequenceTask iSequenceTask, SequenceTaskQueue sequenceTaskQueue) {
        super(1);
        this.$task = iSequenceTask;
        this.this$0 = sequenceTaskQueue;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("task=");
        m3.append(Reflection.getOrCreateKotlinClass(this.$task.getClass()));
        m3.append(" finish, abort=");
        m3.append(booleanValue);
        kLog.i("SequenceTaskQueue", m3.toString());
        if (!booleanValue) {
            this.this$0.execute();
        }
        return Unit.INSTANCE;
    }
}
