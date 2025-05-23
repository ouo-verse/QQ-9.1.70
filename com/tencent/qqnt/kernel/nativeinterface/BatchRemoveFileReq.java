package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchRemoveFileReq {
    public int seq;
    public String fileSetId = "";
    public ArrayList<File> fileList = new ArrayList<>();
    public RemoveReason removeReason = RemoveReason.values()[0];

    public ArrayList<File> getFileList() {
        return this.fileList;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public RemoveReason getRemoveReason() {
        return this.removeReason;
    }

    public int getSeq() {
        return this.seq;
    }
}
