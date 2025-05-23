package com.tencent.qqmini.sdk.task;

import android.content.Context;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class MainThreadTask extends BaseTask {
    public MainThreadTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, 3, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void execute() {
        executeStartTime();
        this.mainHander.post(new Runnable() { // from class: com.tencent.qqmini.sdk.task.MainThreadTask.1
            @Override // java.lang.Runnable
            public void run() {
                MainThreadTask.this.executeInMainThread();
            }
        });
    }

    public abstract void executeInMainThread();

    public void executeStartTime() {
    }
}
