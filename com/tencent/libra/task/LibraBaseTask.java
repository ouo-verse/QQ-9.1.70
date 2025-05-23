package com.tencent.libra.task;

import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.LoadContext;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class LibraBaseTask implements ILibraTask {
    public Option mOption;
    public LibraPicLoader mPicLoader;
    protected volatile LoadState mStatus;
    public long mTaskStartTime;

    public LibraBaseTask(LoadContext loadContext) {
        this.mOption = loadContext.getOption();
        this.mPicLoader = loadContext.getPicLoader();
    }

    @Override // com.tencent.libra.task.ILibraTask
    public void cancel() {
        if (this.mStatus != LoadState.STATE_SUCCESS) {
            this.mStatus = LoadState.STATE_CANCEL;
        }
    }

    @Override // com.tencent.libra.task.ILibraTask
    public Option getOption() {
        return this.mOption;
    }

    public abstract void onCancel();
}
