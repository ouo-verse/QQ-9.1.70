package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class CancelFilesTransferProgressReq {
    public int seq;
    public String fileSetId = "";
    public ArrayList<String> svrFileIds = new ArrayList<>();

    public String getFileSetId() {
        return this.fileSetId;
    }

    public int getSeq() {
        return this.seq;
    }

    public ArrayList<String> getSvrFileIds() {
        return this.svrFileIds;
    }
}
