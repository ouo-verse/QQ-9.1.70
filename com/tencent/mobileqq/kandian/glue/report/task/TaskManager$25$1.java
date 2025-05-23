package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes33.dex */
class TaskManager$25$1 extends TimerTask {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSContext f239904d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f239905e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ TaskManager.q f239906f;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        StringBuffer stringBuffer = new StringBuffer();
        JSContext jSContext = this.f239904d;
        if (jSContext != null) {
            jSContext.a(this.f239905e, stringBuffer);
            TaskManager.q qVar = this.f239906f;
            TaskManager.this.S(stringBuffer, qVar.f239929a, this.f239905e);
        }
    }
}
