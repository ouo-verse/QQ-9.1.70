package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetTeamUpListReq {
    public byte[] cookies = new byte[0];
    public long groupId;
    public int status;
    public int type;

    public byte[] getCookies() {
        return this.cookies;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GetTeamUpListReq{groupId=" + this.groupId + ",type=" + this.type + ",status=" + this.status + ",cookies=" + this.cookies + ",}";
    }
}
