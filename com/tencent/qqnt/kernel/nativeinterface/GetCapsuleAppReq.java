package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetCapsuleAppReq {
    public ClientInfo client = new ClientInfo();
    public long groupId;
    public int groupType;
    public int miniappProtect;
    public int mode;

    public ClientInfo getClient() {
        return this.client;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public int getMiniappProtect() {
        return this.miniappProtect;
    }

    public int getMode() {
        return this.mode;
    }

    public String toString() {
        return "GetCapsuleAppReq{client=" + this.client + ",groupId=" + this.groupId + ",groupType=" + this.groupType + ",miniappProtect=" + this.miniappProtect + ",mode=" + this.mode + ",}";
    }
}
