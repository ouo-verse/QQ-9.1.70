package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PhysicalInfo {
    public int height;
    public int time;
    public int width;

    /* renamed from: id, reason: collision with root package name */
    public String f359199id = "";
    public String url = "";
    public ServerFileStatus status = ServerFileStatus.values()[0];
    public String processing = "";
    public String localPath = "";

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f359199id;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getProcessing() {
        return this.processing;
    }

    public ServerFileStatus getStatus() {
        return this.status;
    }

    public int getTime() {
        return this.time;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }
}
