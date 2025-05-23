package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPExtInfo implements Serializable {
    public boolean isAllRead;
    long serialVersionUID;
    public String traceId;

    public GProMVPExtInfo() {
        this.serialVersionUID = 1L;
        this.traceId = "";
    }

    public boolean getIsAllRead() {
        return this.isAllRead;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProMVPExtInfo{traceId=" + this.traceId + ",isAllRead=" + this.isAllRead + ",}";
    }

    public GProMVPExtInfo(String str) {
        this.serialVersionUID = 1L;
        this.traceId = str;
    }
}
