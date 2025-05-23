package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class FileTransferProgress {
    public long srvLastModifyTimestamp;
    public float transferProgressPercent;
    public String srvFileId = "";
    public ServerFileStatus srvStatus = ServerFileStatus.values()[0];
    public String physicalId = "";
    public String thumbnailUrl = "";
    public FileSafeStatus safeStatus = FileSafeStatus.values()[0];
    public String name = "";
    public ClientPollControl pollControl = new ClientPollControl();

    public String getName() {
        return this.name;
    }

    public String getPhysicalId() {
        return this.physicalId;
    }

    public ClientPollControl getPollControl() {
        return this.pollControl;
    }

    public FileSafeStatus getSafeStatus() {
        return this.safeStatus;
    }

    public String getSrvFileId() {
        return this.srvFileId;
    }

    public long getSrvLastModifyTimestamp() {
        return this.srvLastModifyTimestamp;
    }

    public ServerFileStatus getSrvStatus() {
        return this.srvStatus;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public float getTransferProgressPercent() {
        return this.transferProgressPercent;
    }
}
