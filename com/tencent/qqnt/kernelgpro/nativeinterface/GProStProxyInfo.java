package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStProxyInfo {
    public int cmdId;
    public int subCmdId;
    public String appProtocol = "";
    public byte[] reqBody = new byte[0];

    public String getAppProtocol() {
        return this.appProtocol;
    }

    public int getCmdId() {
        return this.cmdId;
    }

    public byte[] getReqBody() {
        return this.reqBody;
    }

    public int getSubCmdId() {
        return this.subCmdId;
    }

    public String toString() {
        return "GProStProxyInfo{cmdId=" + this.cmdId + ",subCmdId=" + this.subCmdId + ",appProtocol=" + this.appProtocol + ",reqBody=" + this.reqBody + ",}";
    }
}
