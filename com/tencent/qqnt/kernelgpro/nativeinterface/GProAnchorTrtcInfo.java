package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAnchorTrtcInfo {
    public String businessInfo;
    public String sig;
    public GProStreamIDInfo streamInfo;
    public Long timeout;
    public String trtcStr;

    public String getBusinessInfo() {
        return this.businessInfo;
    }

    public String getSig() {
        return this.sig;
    }

    public GProStreamIDInfo getStreamInfo() {
        return this.streamInfo;
    }

    public Long getTimeout() {
        return this.timeout;
    }

    public String getTrtcStr() {
        return this.trtcStr;
    }

    public String toString() {
        return "GProAnchorTrtcInfo{sig=" + this.sig + ",timeout=" + this.timeout + ",streamInfo=" + this.streamInfo + ",businessInfo=" + this.businessInfo + ",trtcStr=" + this.trtcStr + ",}";
    }
}
