package com.tencent.upload.task;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface TaskStateListener {
    void onTaskFinished(BaseTask baseTask, int i3, String str);

    void onTaskInfoChanged(BaseTask baseTask);
}
