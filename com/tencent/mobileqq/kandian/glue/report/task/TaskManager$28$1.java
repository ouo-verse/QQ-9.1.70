package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes33.dex */
class TaskManager$28$1 extends TimerTask {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSContext f239907d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f239908e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ TaskManager.t f239909f;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        StringBuffer stringBuffer = new StringBuffer();
        JSContext jSContext = this.f239907d;
        if (jSContext != null) {
            jSContext.a(this.f239908e, stringBuffer);
            TaskManager.t tVar = this.f239909f;
            TaskManager.this.S(stringBuffer, tVar.f239934a, this.f239908e);
        }
    }
}
