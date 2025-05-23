package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchUploadSession {
    public boolean enableCache;
    public int failedCount;
    public int status;
    public int successCount;
    public BatchUploadTimeInfo timeInfo = new BatchUploadTimeInfo();
    public String sessionId = "";
    public ArrayList<BatchUploadTask> tasks = new ArrayList<>();
    public byte[] bizInfo = new byte[0];

    public byte[] getBizInfo() {
        return this.bizInfo;
    }

    public boolean getEnableCache() {
        return this.enableCache;
    }

    public int getFailedCount() {
        return this.failedCount;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getStatus() {
        return this.status;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public ArrayList<BatchUploadTask> getTasks() {
        return this.tasks;
    }

    public BatchUploadTimeInfo getTimeInfo() {
        return this.timeInfo;
    }
}
