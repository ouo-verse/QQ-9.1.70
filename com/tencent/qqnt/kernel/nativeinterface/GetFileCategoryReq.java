package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileCategoryReq {
    public String fileSetId = "";
    public String parentId = "";
    public FlashTransferSceneType sceneType = FlashTransferSceneType.values()[0];
    public int seq;

    public String getFileSetId() {
        return this.fileSetId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public FlashTransferSceneType getSceneType() {
        return this.sceneType;
    }

    public int getSeq() {
        return this.seq;
    }
}
