package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileSetRsp {
    public String errMs = "";
    public FileSet fileSet = new FileSet();
    public boolean isCache;
    public int result;
    public int seq;

    public String getErrMs() {
        return this.errMs;
    }

    public FileSet getFileSet() {
        return this.fileSet;
    }

    public boolean getIsCache() {
        return this.isCache;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }
}
