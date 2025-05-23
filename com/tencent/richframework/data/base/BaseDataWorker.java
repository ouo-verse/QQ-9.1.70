package com.tencent.richframework.data.base;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class BaseDataWorker {
    private BaseDataCenter mDataCenter;

    public BaseDataCenter getWorkDataCenter() {
        return this.mDataCenter;
    }

    public void registerWorkDataCenter(BaseDataCenter baseDataCenter) {
        this.mDataCenter = baseDataCenter;
    }
}
