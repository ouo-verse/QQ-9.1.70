package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProQqMsgListSetting implements Serializable {
    public int isInList;
    long serialVersionUID = 1;
    public long subscribeTimestamp;
    public long topTimestamp;

    public int getIsInList() {
        return this.isInList;
    }

    public long getSubscribeTimestamp() {
        return this.subscribeTimestamp;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String toString() {
        return "GProQqMsgListSetting{isInList=" + this.isInList + ",topTimestamp=" + this.topTimestamp + ",subscribeTimestamp=" + this.subscribeTimestamp + ",}";
    }
}
