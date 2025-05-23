package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DevInfo implements IKernelModel {
    public int clientType;
    public String devUid;
    public int instanceId;

    public DevInfo() {
        this.devUid = "";
    }

    public int getClientType() {
        return this.clientType;
    }

    public String getDevUid() {
        return this.devUid;
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public void setClientType(int i3) {
        this.clientType = i3;
    }

    public void setDevUid(String str) {
        this.devUid = str;
    }

    public void setInstanceId(int i3) {
        this.instanceId = i3;
    }

    public String toString() {
        return "DevInfo{instanceId=" + this.instanceId + ",clientType=" + this.clientType + ",devUid=" + this.devUid + ",}";
    }

    public DevInfo(int i3, int i16, String str) {
        this.instanceId = i3;
        this.clientType = i16;
        this.devUid = str;
    }
}
