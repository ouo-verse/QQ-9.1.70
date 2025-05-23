package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsItemRequestUserData {
    public long rptBusiMask;
    public byte[] userData = new byte[0];

    public long getRptBusiMask() {
        return this.rptBusiMask;
    }

    public byte[] getUserData() {
        return this.userData;
    }

    public String toString() {
        return "UfsItemRequestUserData{rptBusiMask=" + this.rptBusiMask + ",userData=" + this.userData + ",}";
    }
}
