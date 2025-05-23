package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GetFilesTransferProgressReq {
    public int seq;
    public long sinceTimestamp;
    public String fileSetId = "";
    public ArrayList<String> svrFileIds = new ArrayList<>();
    public FlashTransferSceneType sceneType = FlashTransferSceneType.values()[0];

    public String getFileSetId() {
        return this.fileSetId;
    }

    public FlashTransferSceneType getSceneType() {
        return this.sceneType;
    }

    public int getSeq() {
        return this.seq;
    }

    public long getSinceTimestamp() {
        return this.sinceTimestamp;
    }

    public ArrayList<String> getSvrFileIds() {
        return this.svrFileIds;
    }
}
