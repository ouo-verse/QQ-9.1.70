package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsItemRequestBusiMask {
    public long groupMask;
    public byte[] sessionInfo = new byte[0];

    public long getGroupMask() {
        return this.groupMask;
    }

    public byte[] getSessionInfo() {
        return this.sessionInfo;
    }

    public String toString() {
        return "UfsItemRequestBusiMask{groupMask=" + this.groupMask + ",sessionInfo=" + this.sessionInfo + ",}";
    }
}
