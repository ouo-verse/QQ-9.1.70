package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UploadFileWithoutMsgParams {
    public RMBizTypeEnum bizType;
    public String filePath;
    public String peerUid;
    public int transferId;
    public boolean useNTV2;

    public UploadFileWithoutMsgParams() {
        this.bizType = RMBizTypeEnum.values()[0];
        this.filePath = "";
        this.peerUid = "";
    }

    public RMBizTypeEnum getBizType() {
        return this.bizType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getTransferId() {
        return this.transferId;
    }

    public boolean getUseNTV2() {
        return this.useNTV2;
    }

    public UploadFileWithoutMsgParams(int i3, RMBizTypeEnum rMBizTypeEnum, String str, String str2, boolean z16) {
        RMBizTypeEnum rMBizTypeEnum2 = RMBizTypeEnum.values()[0];
        this.transferId = i3;
        this.bizType = rMBizTypeEnum;
        this.filePath = str;
        this.peerUid = str2;
        this.useNTV2 = z16;
    }
}
