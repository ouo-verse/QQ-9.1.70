package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileSetReq {
    public boolean isNoReqSvr;
    public boolean isUseCache;
    public int seq;
    public String fileSetId = "";
    public FlashTransferSceneType sceneType = FlashTransferSceneType.values()[0];

    public String getFileSetId() {
        return this.fileSetId;
    }

    public boolean getIsNoReqSvr() {
        return this.isNoReqSvr;
    }

    public boolean getIsUseCache() {
        return this.isUseCache;
    }

    public FlashTransferSceneType getSceneType() {
        return this.sceneType;
    }

    public int getSeq() {
        return this.seq;
    }
}
