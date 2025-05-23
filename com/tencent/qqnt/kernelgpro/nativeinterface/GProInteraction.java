package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProInteraction implements Serializable {
    public long timestamp;
    public int type;
    long serialVersionUID = 1;
    public String interactiveUid = "";

    public String getInteractiveUid() {
        return this.interactiveUid;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProInteraction{interactiveUid=" + this.interactiveUid + ",type=" + this.type + ",timestamp=" + this.timestamp + ",}";
    }
}
