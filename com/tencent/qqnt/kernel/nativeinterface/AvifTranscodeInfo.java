package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AvifTranscodeInfo {
    public String aioPath;
    public String avifPath;
    public String dstJpgPath;
    public long picHeight;
    public long picWidth;

    public AvifTranscodeInfo() {
        this.avifPath = "";
        this.dstJpgPath = "";
    }

    public String getAioPath() {
        return this.aioPath;
    }

    public String getAvifPath() {
        return this.avifPath;
    }

    public String getDstJpgPath() {
        return this.dstJpgPath;
    }

    public long getPicHeight() {
        return this.picHeight;
    }

    public long getPicWidth() {
        return this.picWidth;
    }

    public String toString() {
        return "AvifTranscodeInfo{avifPath=" + this.avifPath + ",dstJpgPath=" + this.dstJpgPath + ",aioPath=" + this.aioPath + ",picWidth=" + this.picWidth + ",picHeight=" + this.picHeight + ",}";
    }

    public AvifTranscodeInfo(String str, String str2, String str3, long j3, long j16) {
        this.avifPath = str;
        this.dstJpgPath = str2;
        this.aioPath = str3;
        this.picWidth = j3;
        this.picHeight = j16;
    }
}
