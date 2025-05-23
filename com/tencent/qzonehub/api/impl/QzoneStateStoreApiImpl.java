package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneStateStoreApi;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes34.dex */
public class QzoneStateStoreApiImpl implements IQzoneStateStoreApi {
    private volatile boolean mHasPublishRunningTask;

    @Override // com.tencent.qzonehub.api.IQzoneStateStoreApi
    public boolean hasPublishRunningTask() {
        QLog.i("QzoneStateStoreApiImpl", 1, "hasPublishRunningTask:" + this.mHasPublishRunningTask);
        return this.mHasPublishRunningTask;
    }

    @Override // com.tencent.qzonehub.api.IQzoneStateStoreApi
    public void syncRunningTaskState(boolean z16) {
        QLog.i("QzoneStateStoreApiImpl", 2, "syncRunningTaskState:" + z16);
        this.mHasPublishRunningTask = z16;
    }
}
