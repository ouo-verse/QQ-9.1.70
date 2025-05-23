package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileSetListRsp {
    public boolean isCache;
    public boolean isEnd;
    public int result;
    public int seq;
    public int totalFileSetCount;
    public String errMs = "";
    public ArrayList<FileSet> fileSetList = new ArrayList<>();
    public byte[] paginationInfo = new byte[0];

    public String getErrMs() {
        return this.errMs;
    }

    public ArrayList<FileSet> getFileSetList() {
        return this.fileSetList;
    }

    public boolean getIsCache() {
        return this.isCache;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getTotalFileSetCount() {
        return this.totalFileSetCount;
    }
}
