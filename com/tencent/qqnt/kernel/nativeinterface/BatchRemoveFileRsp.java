package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchRemoveFileRsp {
    public String errMs = "";
    public ArrayList<File> removedFileList = new ArrayList<>();
    public int result;
    public int seq;

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<File> getRemovedFileList() {
        return this.removedFileList;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }
}
