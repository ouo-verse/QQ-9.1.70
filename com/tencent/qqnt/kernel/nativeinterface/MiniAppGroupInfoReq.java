package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiniAppGroupInfoReq {
    public long groupCode;
    public byte[] groupOpenID = new byte[0];
    public long groupUin;

    public long getGroupCode() {
        return this.groupCode;
    }

    public byte[] getGroupOpenID() {
        return this.groupOpenID;
    }

    public long getGroupUin() {
        return this.groupUin;
    }

    public String toString() {
        return "MiniAppGroupInfoReq{groupCode=" + this.groupCode + ",groupUin=" + this.groupUin + ",groupOpenID=" + this.groupOpenID + ",}";
    }
}
