package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetCompressedFileFolderRsp {
    public String errMs = "";
    public ArrayList<FileList> fileLists = new ArrayList<>();
    public String remainingMsg = "";
    public long remainingTime;
    public int result;
    public int seq;
    public long totalFileCount;
    public long totalFileSize;

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<FileList> getFileLists() {
        return this.fileLists;
    }

    public String getRemainingMsg() {
        return this.remainingMsg;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public long getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }
}
