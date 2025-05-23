package com.tencent.mobileqq.vas.comm.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.raft.standard.task.IRTask;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements IRTask {
    @Override // com.tencent.raft.standard.task.IRTask
    public void startTask(@NotNull IRTask.TaskType taskType, @NotNull IRTask.Task task) {
        ThreadManagerV2.excute(task, 192, null, true);
    }
}
