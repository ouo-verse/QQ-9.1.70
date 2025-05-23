package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GetFilesTransferProgressRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String fileSetId = "";
    public ArrayList<FileTransferProgress> fileProgresses = new ArrayList<>();
    public ClientPollControl pollControl = new ClientPollControl();

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<FileTransferProgress> getFileProgresses() {
        return this.fileProgresses;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public ClientPollControl getPollControl() {
        return this.pollControl;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }
}
