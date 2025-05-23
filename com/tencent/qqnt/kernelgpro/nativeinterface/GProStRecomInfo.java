package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRecomInfo implements Serializable {
    public int recomReasonType;
    long serialVersionUID = 1;
    public String recomReason = "";
    public byte[] recomAttachInfo = new byte[0];
    public String recomTrace = "";
    public byte[] clientSealData = new byte[0];
    public String iconUrl = "";

    public byte[] getClientSealData() {
        return this.clientSealData;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public byte[] getRecomAttachInfo() {
        return this.recomAttachInfo;
    }

    public String getRecomReason() {
        return this.recomReason;
    }

    public int getRecomReasonType() {
        return this.recomReasonType;
    }

    public String getRecomTrace() {
        return this.recomTrace;
    }

    public String toString() {
        return "GProStRecomInfo{recomReason=" + this.recomReason + ",recomAttachInfo=" + this.recomAttachInfo + ",recomTrace=" + this.recomTrace + ",clientSealData=" + this.clientSealData + ",iconUrl=" + this.iconUrl + ",recomReasonType=" + this.recomReasonType + ",}";
    }
}
