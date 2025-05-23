package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetCardAppListReq {
    public ClientInfo clientInfo = new ClientInfo();
    public long groupId;
    public int lastGameDynamicTs;
    public int miniAppDisable;
    public int mode;

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getLastGameDynamicTs() {
        return this.lastGameDynamicTs;
    }

    public int getMiniAppDisable() {
        return this.miniAppDisable;
    }

    public int getMode() {
        return this.mode;
    }

    public String toString() {
        return "GetCardAppListReq{groupId=" + this.groupId + ",clientInfo=" + this.clientInfo + ",lastGameDynamicTs=" + this.lastGameDynamicTs + ",miniAppDisable=" + this.miniAppDisable + ",mode=" + this.mode + ",}";
    }
}
