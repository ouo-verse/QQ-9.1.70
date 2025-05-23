package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BdhUploadReq {
    public long commandId;
    public byte[] extInfo;
    public Integer priority;
    public byte[] upKey;
    public Long uploadTimeout;
    public String uuid;
    public String filePath = "";
    public byte[] bizInfo = new byte[0];

    public byte[] getBizInfo() {
        return this.bizInfo;
    }

    public long getCommandId() {
        return this.commandId;
    }

    public byte[] getExtInfo() {
        return this.extInfo;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public byte[] getUpKey() {
        return this.upKey;
    }

    public Long getUploadTimeout() {
        return this.uploadTimeout;
    }

    public String getUuid() {
        return this.uuid;
    }
}
