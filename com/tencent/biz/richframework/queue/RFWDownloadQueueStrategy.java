package com.tencent.biz.richframework.queue;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWDownloadQueueStrategy extends RFWDownloadStrategy implements RFWTaskClearStrategy {
    public int getRunMaxCount() {
        return 10;
    }

    public abstract RFWDownloadTaskLocalStorageDelegate getTaskLocalStorageDelegate();

    public abstract boolean supportSaveToSystemAlbum();
}
