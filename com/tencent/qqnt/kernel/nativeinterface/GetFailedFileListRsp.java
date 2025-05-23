package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFailedFileListRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String fileSetId = "";
    public ArrayList<File> fileList = new ArrayList<>();

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<File> getFileList() {
        return this.fileList;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }
}
