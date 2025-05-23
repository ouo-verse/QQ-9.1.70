package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class AsyncTask extends BaseTask {
    public AsyncTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, 2, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void execute() {
        if (!isMainThread()) {
            executeAsync();
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.task.AsyncTask.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncTask.this.executeAsync();
                }
            });
        }
    }

    public abstract void executeAsync();

    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            return true;
        }
        return false;
    }
}
