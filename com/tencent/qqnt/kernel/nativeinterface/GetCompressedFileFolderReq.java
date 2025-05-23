package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetCompressedFileFolderReq {
    public boolean isUseCache;
    public int seq;
    public String fileSetId = "";
    public String cliFileId = "";
    public String srvFileId = "";
    public ArrayList<CompressedFileFolderReqInfo> reqInfos = new ArrayList<>();
    public FlashTransferSceneType sceneType = FlashTransferSceneType.values()[0];

    public String getCliFileId() {
        return this.cliFileId;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public boolean getIsUseCache() {
        return this.isUseCache;
    }

    public ArrayList<CompressedFileFolderReqInfo> getReqInfos() {
        return this.reqInfos;
    }

    public FlashTransferSceneType getSceneType() {
        return this.sceneType;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getSrvFileId() {
        return this.srvFileId;
    }
}
