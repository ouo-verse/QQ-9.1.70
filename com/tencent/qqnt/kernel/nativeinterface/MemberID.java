package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MemberID {
    public long memberUin;
    public String memberUid = "";
    public String memberQid = "";

    public String getMemberQid() {
        return this.memberQid;
    }

    public String getMemberUid() {
        return this.memberUid;
    }

    public long getMemberUin() {
        return this.memberUin;
    }

    public String toString() {
        return "MemberID{memberUin=" + this.memberUin + ",memberUid=" + this.memberUid + ",memberQid=" + this.memberQid + ",}";
    }
}
