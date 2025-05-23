package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileListRsp {
    public String errMs = "";
    public ArrayList<FileList> fileLists = new ArrayList<>();
    public int result;
    public int seq;

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<FileList> getFileLists() {
        return this.fileLists;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }
}
