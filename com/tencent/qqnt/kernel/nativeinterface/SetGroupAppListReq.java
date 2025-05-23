package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SetGroupAppListReq {
    public int addType;
    public long appendAppid;
    public int appendSource;
    public long groupId;
    public int miniappProtect;
    public int openShortcut;
    public ClientInfo clientInfo = new ClientInfo();
    public ArrayList<AppId> appids = new ArrayList<>();

    public int getAddType() {
        return this.addType;
    }

    public long getAppendAppid() {
        return this.appendAppid;
    }

    public int getAppendSource() {
        return this.appendSource;
    }

    public ArrayList<AppId> getAppids() {
        return this.appids;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getMiniappProtect() {
        return this.miniappProtect;
    }

    public int getOpenShortcut() {
        return this.openShortcut;
    }

    public String toString() {
        return "SetGroupAppListReq{groupId=" + this.groupId + ",clientInfo=" + this.clientInfo + ",addType=" + this.addType + ",appids=" + this.appids + ",appendAppid=" + this.appendAppid + ",appendSource=" + this.appendSource + ",miniappProtect=" + this.miniappProtect + ",openShortcut=" + this.openShortcut + ",}";
    }
}
