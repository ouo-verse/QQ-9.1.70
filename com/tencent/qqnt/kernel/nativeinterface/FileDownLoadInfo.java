package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileDownLoadInfo {
    public long curDownLoadedBytes;
    public int errorCode;
    public UserActionFileDownLoadStatus status = UserActionFileDownLoadStatus.values()[0];
    public long totalFileBytes;

    public long getCurDownLoadedBytes() {
        return this.curDownLoadedBytes;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public UserActionFileDownLoadStatus getStatus() {
        return this.status;
    }

    public long getTotalFileBytes() {
        return this.totalFileBytes;
    }
}
