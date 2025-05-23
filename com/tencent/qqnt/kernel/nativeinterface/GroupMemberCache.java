package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMemberCache {
    public int titleId;
    public String specialTitle = "";
    public byte[] honorInfo = new byte[0];

    public byte[] getHonorInfo() {
        return this.honorInfo;
    }

    public String getSpecialTitle() {
        return this.specialTitle;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public String toString() {
        return "GroupMemberCache{specialTitle=" + this.specialTitle + ",titleId=" + this.titleId + ",honorInfo=" + this.honorInfo + ",}";
    }
}
