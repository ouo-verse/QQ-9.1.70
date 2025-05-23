package com.tencent.gamecenter.wadl.sdk.common.e;

import com.tencent.raft.standard.task.IRTask;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static IRTask f107239a = com.tencent.gamecenter.wadl.sdk.common.a.f106992o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends IRTask.WeakReferenceTask<Runnable> {
        a(Runnable runnable, String str, IRTask.Priority priority) {
            super(runnable, str, priority);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getRef() != null) {
                getRef().run();
            }
        }
    }

    public static void a(Runnable runnable) {
        a(runnable, IRTask.Priority.NORMAL_PRIORITY);
    }

    public static void a(Runnable runnable, IRTask.Priority priority) {
        IRTask iRTask = f107239a;
        if (iRTask != null) {
            iRTask.startTask(IRTask.TaskType.SIMPLE_TASK, new a(runnable, Thread.currentThread().getName(), priority));
        }
    }
}
