package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetIdentityListReq {
    public long groupCode;
    public long memberUin;

    public long getGroupCode() {
        return this.groupCode;
    }

    public long getMemberUin() {
        return this.memberUin;
    }

    public String toString() {
        return "GetIdentityListReq{groupCode=" + this.groupCode + ",memberUin=" + this.memberUin + ",}";
    }
}
