package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProReportShareAttaReq {
    public byte[] attaData = new byte[0];
    public String attaContentId = "";

    public String getAttaContentId() {
        return this.attaContentId;
    }

    public byte[] getAttaData() {
        return this.attaData;
    }

    public String toString() {
        return "GProReportShareAttaReq{attaData=" + this.attaData + ",attaContentId=" + this.attaContentId + ",}";
    }
}
